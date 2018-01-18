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
    private a.InterfaceC0105a hBA;
    private boolean hBB;
    private com.baidu.tieba.write.transmit.model.a hBs;
    private com.baidu.tieba.likedForum.a hBt;
    private com.baidu.tbadk.core.view.b hBu;
    private List<SimpleForum> hBy;
    private List<ForumInfo> hBz;
    private WriteData mData;
    private TbPageContext mPageContext;
    private int mPrivateThread;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean hBv = false;
    private boolean hBw = false;
    private boolean hBx = false;
    private boolean mUseCache = true;
    private a.InterfaceC0170a hBC = new a.InterfaceC0170a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0170a
        public void onError() {
            a.this.bEL();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0170a
        public void u(List<SimpleForum> list, int i) {
            a.this.hBv = true;
            a.this.hBy = list;
            a.this.mPrivateThread = i;
            a.this.bEK();
        }
    };
    private a.InterfaceC0131a cnA = new a.InterfaceC0131a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0131a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            if (!z) {
                a.this.bEL();
                return;
            }
            a.this.hBw = true;
            a.this.hBz = list;
            a.this.bEK();
        }
    };
    private DialogInterface.OnCancelListener hBD = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.hBs != null) {
                a.this.hBs.avN();
            }
            if (a.this.hBt != null) {
                a.this.hBt.avN();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.hBu = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        BdUniqueId gen = BdUniqueId.gen();
        this.hBs = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.hBs.a(this.hBC);
        if (this.mData != null) {
            this.hBs.setForumId(this.mData.getForumId());
        }
        this.hBs.setRequestId(gen);
        this.hBt = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.hBt.a(this.cnA);
        this.hBt.setRequestId(gen);
        this.hBu = new com.baidu.tbadk.core.view.b(this.mPageContext);
        this.hBu.c(this.hBD);
        bEJ();
    }

    private void bEJ() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aPo = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEK() {
        if (this.hBv && this.hBw) {
            this.hBu.bm(false);
            ArrayList arrayList = new ArrayList();
            if (v.D(this.hBy) > 0) {
                for (SimpleForum simpleForum : this.hBy) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cW(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.D(this.hBz) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.hBz) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cW(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (this.hBA != null) {
                this.hBA.b(this.mDataList, true, this.mPrivateThread);
            }
            if (!this.mUseCache) {
                this.hBv = false;
                this.hBw = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEL() {
        if (!this.hBB) {
            if (this.hBA != null) {
                this.hBu.bm(false);
                this.hBA.b(null, false, 0);
            }
            this.hBB = true;
        }
    }

    private boolean cW(long j) {
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
        if (this.hBv && this.hBw) {
            if (this.hBA != null) {
                this.hBA.b(this.mDataList, true, this.mPrivateThread);
            }
        } else if (!l.oZ()) {
            if (this.hBA != null) {
                this.hBA.b(this.mDataList, true, this.mPrivateThread);
            }
        } else {
            this.hBB = false;
            if (!this.hBv) {
                this.hBs.setThreadTitle(str);
                this.hBs.setThreadContent(str2);
                this.hBs.Vz();
            }
            if (!this.hBw) {
                this.hBt.MO();
            }
            this.hBu.bm(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0105a interfaceC0105a) {
        this.hBA = interfaceC0105a;
    }
}
