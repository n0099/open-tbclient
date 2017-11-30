package com.baidu.tieba.write;

import android.content.DialogInterface;
import android.content.Intent;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.d.a;
import com.baidu.tieba.likedForum.a;
import com.baidu.tieba.write.transmit.model.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.RecommendForumListForBottle.ForumInfo;
import tbclient.SimpleForum;
/* loaded from: classes2.dex */
public class a implements com.baidu.tieba.d.a {
    private com.baidu.tieba.write.transmit.model.a haU;
    private com.baidu.tieba.likedForum.a haV;
    private com.baidu.tbadk.core.view.a haW;
    private List<SimpleForum> hba;
    private List<ForumInfo> hbb;
    private a.InterfaceC0080a hbc;
    private boolean hbd;
    private WriteData mData;
    private TbPageContext mPageContext;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean haX = false;
    private boolean haY = false;
    private boolean haZ = false;
    private boolean mUseCache = true;
    private a.InterfaceC0142a hbe = new a.InterfaceC0142a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0142a
        public void bER() {
            a.this.bEQ();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0142a
        public void C(List<SimpleForum> list) {
            a.this.haX = true;
            a.this.hba = list;
            a.this.bEP();
        }
    };
    private a.InterfaceC0106a bzh = new a.InterfaceC0106a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0106a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            if (!z) {
                a.this.bEQ();
                return;
            }
            a.this.haY = true;
            a.this.hbb = list;
            a.this.bEP();
        }
    };
    private DialogInterface.OnCancelListener hbf = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.haU != null) {
                a.this.haU.amU();
            }
            if (a.this.haV != null) {
                a.this.haV.amU();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.haW = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        BdUniqueId gen = BdUniqueId.gen();
        this.haU = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.haU.a(this.hbe);
        if (this.mData != null) {
            this.haU.setForumId(this.mData.getForumId());
        }
        this.haU.setRequestId(gen);
        this.haV = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.haV.a(this.bzh);
        this.haV.setRequestId(gen);
        this.haW = new com.baidu.tbadk.core.view.a(this.mPageContext);
        this.haW.c(this.hbf);
        bEO();
    }

    private void bEO() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aaW = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEP() {
        if (this.haX && this.haY) {
            this.haW.aE(false);
            ArrayList arrayList = new ArrayList();
            if (v.v(this.hba) > 0) {
                for (SimpleForum simpleForum : this.hba) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !dc(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.v(this.hbb) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.hbb) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !dc(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (this.hbc != null) {
                this.hbc.e(this.mDataList, true);
            }
            if (!this.mUseCache) {
                this.haX = false;
                this.haY = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEQ() {
        if (!this.hbd) {
            if (this.hbc != null) {
                this.haW.aE(false);
                this.hbc.e(null, false);
            }
            this.hbd = true;
        }
    }

    private boolean dc(long j) {
        if (this.mDataList == null) {
            return false;
        }
        for (TransmitForumData transmitForumData : this.mDataList) {
            if (transmitForumData != null && transmitForumData.forumId == j) {
                return true;
            }
        }
        return false;
    }

    @Override // com.baidu.tieba.d.a
    public void aJ(String str, String str2) {
        if (this.haX && this.haY) {
            if (this.hbc != null) {
                this.hbc.e(this.mDataList, true);
            }
        } else if (!l.hy()) {
            if (this.hbc != null) {
                this.hbc.e(this.mDataList, true);
            }
        } else {
            this.hbd = false;
            if (!this.haX) {
                this.haU.setThreadTitle(str);
                this.haU.setThreadContent(str2);
                this.haU.Om();
            }
            if (!this.haY) {
                this.haV.Fy();
            }
            this.haW.aE(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0080a interfaceC0080a) {
        this.hbc = interfaceC0080a;
    }
}
