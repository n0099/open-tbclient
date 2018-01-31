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
    private com.baidu.tieba.write.transmit.model.a hBM;
    private com.baidu.tieba.likedForum.a hBN;
    private com.baidu.tbadk.core.view.b hBO;
    private List<SimpleForum> hBS;
    private List<ForumInfo> hBT;
    private a.InterfaceC0106a hBU;
    private boolean hBV;
    private WriteData mData;
    private TbPageContext mPageContext;
    private int mPrivateThread;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean hBP = false;
    private boolean hBQ = false;
    private boolean hBR = false;
    private boolean mUseCache = true;
    private a.InterfaceC0171a hBW = new a.InterfaceC0171a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void onError() {
            a.this.bEN();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void u(List<SimpleForum> list, int i) {
            a.this.hBP = true;
            a.this.hBS = list;
            a.this.mPrivateThread = i;
            a.this.bEM();
        }
    };
    private a.InterfaceC0132a cnI = new a.InterfaceC0132a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0132a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            if (!z) {
                a.this.bEN();
                return;
            }
            a.this.hBQ = true;
            a.this.hBT = list;
            a.this.bEM();
        }
    };
    private DialogInterface.OnCancelListener hBX = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.hBM != null) {
                a.this.hBM.avS();
            }
            if (a.this.hBN != null) {
                a.this.hBN.avS();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.hBO = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        BdUniqueId gen = BdUniqueId.gen();
        this.hBM = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.hBM.a(this.hBW);
        if (this.mData != null) {
            this.hBM.setForumId(this.mData.getForumId());
        }
        this.hBM.setRequestId(gen);
        this.hBN = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.hBN.a(this.cnI);
        this.hBN.setRequestId(gen);
        this.hBO = new com.baidu.tbadk.core.view.b(this.mPageContext);
        this.hBO.c(this.hBX);
        bEL();
    }

    private void bEL() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aPr = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEM() {
        if (this.hBP && this.hBQ) {
            this.hBO.bn(false);
            ArrayList arrayList = new ArrayList();
            if (v.D(this.hBS) > 0) {
                for (SimpleForum simpleForum : this.hBS) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !cY(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.D(this.hBT) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.hBT) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !cY(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (this.hBU != null) {
                this.hBU.b(this.mDataList, true, this.mPrivateThread);
            }
            if (!this.mUseCache) {
                this.hBP = false;
                this.hBQ = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bEN() {
        if (!this.hBV) {
            if (this.hBU != null) {
                this.hBO.bn(false);
                this.hBU.b(null, false, 0);
            }
            this.hBV = true;
        }
    }

    private boolean cY(long j) {
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
    public void aI(String str, String str2) {
        if (this.hBP && this.hBQ) {
            if (this.hBU != null) {
                this.hBU.b(this.mDataList, true, this.mPrivateThread);
            }
        } else if (!l.pa()) {
            if (this.hBU != null) {
                this.hBU.b(this.mDataList, true, this.mPrivateThread);
            }
        } else {
            this.hBV = false;
            if (!this.hBP) {
                this.hBM.setThreadTitle(str);
                this.hBM.setThreadContent(str2);
                this.hBM.VB();
            }
            if (!this.hBQ) {
                this.hBN.MQ();
            }
            this.hBO.bn(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0106a interfaceC0106a) {
        this.hBU = interfaceC0106a;
    }
}
