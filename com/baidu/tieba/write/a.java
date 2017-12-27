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
    private com.baidu.tieba.write.transmit.model.a hLL;
    private com.baidu.tieba.likedForum.a hLM;
    private com.baidu.tbadk.core.view.b hLN;
    private List<SimpleForum> hLR;
    private List<ForumInfo> hLS;
    private a.InterfaceC0106a hLT;
    private boolean hLU;
    private WriteData mData;
    private TbPageContext mPageContext;
    private int mPrivateThread;
    private List<TransmitForumData> mDataList = new ArrayList();
    private boolean hLO = false;
    private boolean hLP = false;
    private boolean hLQ = false;
    private boolean mUseCache = true;
    private a.InterfaceC0171a hLV = new a.InterfaceC0171a() { // from class: com.baidu.tieba.write.a.1
        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void onError() {
            a.this.bLl();
        }

        @Override // com.baidu.tieba.write.transmit.model.a.InterfaceC0171a
        public void u(List<SimpleForum> list, int i) {
            a.this.hLO = true;
            a.this.hLR = list;
            a.this.mPrivateThread = i;
            a.this.bLk();
        }
    };
    private a.InterfaceC0132a cnq = new a.InterfaceC0132a() { // from class: com.baidu.tieba.write.a.2
        @Override // com.baidu.tieba.likedForum.a.InterfaceC0132a
        public void a(boolean z, int i, String str, List<ForumInfo> list) {
            if (!z) {
                a.this.bLl();
                return;
            }
            a.this.hLP = true;
            a.this.hLS = list;
            a.this.bLk();
        }
    };
    private DialogInterface.OnCancelListener hLW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.write.a.3
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            if (a.this.hLL != null) {
                a.this.hLL.auK();
            }
            if (a.this.hLM != null) {
                a.this.hLM.auK();
            }
        }
    };

    public a(TbPageContext tbPageContext, WriteData writeData) {
        this.hLN = null;
        this.mPageContext = tbPageContext;
        this.mData = writeData;
        BdUniqueId gen = BdUniqueId.gen();
        this.hLL = new com.baidu.tieba.write.transmit.model.a(this.mPageContext.getUniqueId());
        this.hLL.a(this.hLV);
        if (this.mData != null) {
            this.hLL.setForumId(this.mData.getForumId());
        }
        this.hLL.setRequestId(gen);
        this.hLM = new com.baidu.tieba.likedForum.a(this.mPageContext.getUniqueId());
        this.hLM.a(this.cnq);
        this.hLM.setRequestId(gen);
        this.hLN = new com.baidu.tbadk.core.view.b(this.mPageContext);
        this.hLN.c(this.hLW);
        bLj();
    }

    private void bLj() {
        if (this.mData != null) {
            String str = null;
            Intent intent = this.mPageContext.getPageActivity().getIntent();
            if (intent != null) {
                str = intent.getStringExtra("forum_avatar");
            }
            long c = com.baidu.adp.lib.g.b.c(this.mData.getForumId(), 0L);
            if (c > 0 && !StringUtils.isNull(this.mData.getForumName())) {
                TransmitForumData transmitForumData = new TransmitForumData(c, this.mData.getForumName(), true, 0, str);
                transmitForumData.aPp = true;
                if (this.mDataList != null) {
                    this.mDataList.add(transmitForumData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLk() {
        if (this.hLO && this.hLP) {
            this.hLN.bm(false);
            ArrayList arrayList = new ArrayList();
            if (v.F(this.hLR) > 0) {
                for (SimpleForum simpleForum : this.hLR) {
                    if (simpleForum != null && simpleForum.id != null && simpleForum.id.longValue() > 0 && !de(simpleForum.id.longValue()) && !StringUtils.isNull(simpleForum.name)) {
                        arrayList.add(new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (v.F(this.hLS) > 0) {
                arrayList.clear();
                for (ForumInfo forumInfo : this.hLS) {
                    if (forumInfo != null && forumInfo.forum_id != null && forumInfo.forum_id.longValue() > 0 && !de(forumInfo.forum_id.longValue()) && !StringUtils.isNull(forumInfo.forum_name)) {
                        arrayList.add(new TransmitForumData(forumInfo.forum_id.longValue(), forumInfo.forum_name, false, 0, forumInfo.avatar));
                    }
                }
                this.mDataList.addAll(arrayList);
            }
            if (this.hLT != null) {
                this.hLT.b(this.mDataList, true, this.mPrivateThread);
            }
            if (!this.mUseCache) {
                this.hLO = false;
                this.hLP = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLl() {
        if (!this.hLU) {
            if (this.hLT != null) {
                this.hLN.bm(false);
                this.hLT.b(null, false, 0);
            }
            this.hLU = true;
        }
    }

    private boolean de(long j) {
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
        if (this.hLO && this.hLP) {
            if (this.hLT != null) {
                this.hLT.b(this.mDataList, true, this.mPrivateThread);
            }
        } else if (!l.oZ()) {
            if (this.hLT != null) {
                this.hLT.b(this.mDataList, true, this.mPrivateThread);
            }
        } else {
            this.hLU = false;
            if (!this.hLO) {
                this.hLL.setThreadTitle(str);
                this.hLL.setThreadContent(str2);
                this.hLL.VL();
            }
            if (!this.hLP) {
                this.hLM.Na();
            }
            this.hLN.bm(true);
        }
    }

    @Override // com.baidu.tieba.d.a
    public void setUseCache(boolean z) {
        this.mUseCache = z;
    }

    @Override // com.baidu.tieba.d.a
    public void a(a.InterfaceC0106a interfaceC0106a) {
        this.hLT = interfaceC0106a;
    }
}
