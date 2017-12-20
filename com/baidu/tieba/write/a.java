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
    private com.baidu.tieba.write.transmit.model.a hdK;
    private com.baidu.tieba.likedForum.a hdL;
    private com.baidu.tbadk.core.view.b hdM;
    private List<SimpleForum> hdQ;
    private List<ForumInfo> hdR;
    private a.InterfaceC0094a hdS;
    private boolean hdT;
    private WriteData mData;
    private TbPageContext mPageContext;
    private int mPrivateThread;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean hdN = false;
    private boolean hdO = false;
    private boolean hdP = false;
    private boolean mUseCache = true;
    private a.InterfaceC0159a hdU = new a.InterfaceC0159a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0159a
        public void bFC() {
            a.this.bFB();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0159a
        public void r(List<SimpleForum> list, int i) {
            a.this.hdN = true;
            a.this.hdQ = list;
            a.this.mPrivateThread = i;
            a.this.bFA();
        }
    };
    private a.InterfaceC0121a bzj = new a.InterfaceC0121a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0121a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            if (!z) {
                a.this.bFB();
                return;
            }
            a.this.hdO = true;
            a.this.hdR = list;
            a.this.bFA();
        }
    };
    private DialogInterface.OnCancelListener hdV = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.hdK != null) {
                a.this.hdK.anc();
            }
            if (a.this.hdL != null) {
                a.this.hdL.anc();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.hdM = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        BdUniqueId gen = BdUniqueId.gen();
        this.hdK = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.hdK.a(this.hdU);
        if (this.mData != null) {
            this.hdK.setForumId(this.mData.getForumId());
        }
        this.hdK.setRequestId(gen);
        this.hdL = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.hdL.a(this.bzj);
        this.hdL.setRequestId(gen);
        this.hdM = new com.baidu.tbadk.core.view.b(this.mPageContext);
        this.hdM.c(this.hdV);
        bFz();
    }

    private void bFz() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aaQ = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFA() {
        if (this.hdN && this.hdO) {
            this.hdM.aE(false);
            ArrayList arrayList = new ArrayList();
            if (v.v(this.hdQ) > 0) {
                for (SimpleForum simpleForum : this.hdQ) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !dd(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.v(this.hdR) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.hdR) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !dd(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (this.hdS != null) {
                this.hdS.b(this.mDataList, true, this.mPrivateThread);
            }
            if (!this.mUseCache) {
                this.hdN = false;
                this.hdO = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFB() {
        if (!this.hdT) {
            if (this.hdS != null) {
                this.hdM.aE(false);
                this.hdS.b(null, false, 0);
            }
            this.hdT = true;
        }
    }

    private boolean dd(long j) {
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
    public void aK(String str, String str2) {
        if (this.hdN && this.hdO) {
            if (this.hdS != null) {
                this.hdS.b(this.mDataList, true, this.mPrivateThread);
            }
        } else if (!l.hy()) {
            if (this.hdS != null) {
                this.hdS.b(this.mDataList, true, this.mPrivateThread);
            }
        } else {
            this.hdT = false;
            if (!this.hdN) {
                this.hdK.setThreadTitle(str);
                this.hdK.setThreadContent(str2);
                this.hdK.Om();
            }
            if (!this.hdO) {
                this.hdL.Fz();
            }
            this.hdM.aE(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0094a interfaceC0094a) {
        this.hdS = interfaceC0094a;
    }
}
