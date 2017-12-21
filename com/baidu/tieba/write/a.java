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
    private com.baidu.tieba.write.transmit.model.a hdP;
    private com.baidu.tieba.likedForum.a hdQ;
    private com.baidu.tbadk.core.view.b hdR;
    private List<SimpleForum> hdV;
    private List<ForumInfo> hdW;
    private a.InterfaceC0093a hdX;
    private boolean hdY;
    private WriteData mData;
    private TbPageContext mPageContext;
    private int mPrivateThread;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean hdS = false;
    private boolean hdT = false;
    private boolean hdU = false;
    private boolean mUseCache = true;
    private a.InterfaceC0158a hdZ = new a.InterfaceC0158a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0158a
        public void bFD() {
            a.this.bFC();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0158a
        public void r(List<SimpleForum> list, int i) {
            a.this.hdS = true;
            a.this.hdV = list;
            a.this.mPrivateThread = i;
            a.this.bFB();
        }
    };
    private a.InterfaceC0120a bzn = new a.InterfaceC0120a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0120a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            if (!z) {
                a.this.bFC();
                return;
            }
            a.this.hdT = true;
            a.this.hdW = list;
            a.this.bFB();
        }
    };
    private DialogInterface.OnCancelListener hea = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.hdP != null) {
                a.this.hdP.and();
            }
            if (a.this.hdQ != null) {
                a.this.hdQ.and();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.hdR = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        BdUniqueId gen = BdUniqueId.gen();
        this.hdP = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.hdP.a(this.hdZ);
        if (this.mData != null) {
            this.hdP.setForumId(this.mData.getForumId());
        }
        this.hdP.setRequestId(gen);
        this.hdQ = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.hdQ.a(this.bzn);
        this.hdQ.setRequestId(gen);
        this.hdR = new com.baidu.tbadk.core.view.b(this.mPageContext);
        this.hdR.c(this.hea);
        bFA();
    }

    private void bFA() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aaT = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFB() {
        if (this.hdS && this.hdT) {
            this.hdR.aE(false);
            ArrayList arrayList = new ArrayList();
            if (v.v(this.hdV) > 0) {
                for (SimpleForum simpleForum : this.hdV) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !dd(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.v(this.hdW) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.hdW) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !dd(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (this.hdX != null) {
                this.hdX.b(this.mDataList, true, this.mPrivateThread);
            }
            if (!this.mUseCache) {
                this.hdS = false;
                this.hdT = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFC() {
        if (!this.hdY) {
            if (this.hdX != null) {
                this.hdR.aE(false);
                this.hdX.b(null, false, 0);
            }
            this.hdY = true;
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
        if (this.hdS && this.hdT) {
            if (this.hdX != null) {
                this.hdX.b(this.mDataList, true, this.mPrivateThread);
            }
        } else if (!l.hy()) {
            if (this.hdX != null) {
                this.hdX.b(this.mDataList, true, this.mPrivateThread);
            }
        } else {
            this.hdY = false;
            if (!this.hdS) {
                this.hdP.setThreadTitle(str);
                this.hdP.setThreadContent(str2);
                this.hdP.Om();
            }
            if (!this.hdT) {
                this.hdQ.Fz();
            }
            this.hdR.aE(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0093a interfaceC0093a) {
        this.hdX = interfaceC0093a;
    }
}
