package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.c
    public void a(boolean z, PostPrefixData postPrefixData) {
        q qVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        q qVar2;
        q qVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.cAt.mPrefixData = postPrefixData;
            postPrefixData2 = this.cAt.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.cAt.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.cAt.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.cAt.getPageContext().getString(com.baidu.tieba.t.write_no_prefix));
                    qVar2 = this.cAt.cAe;
                    if (qVar2 != null) {
                        qVar3 = this.cAt.cAe;
                        postPrefixData5 = this.cAt.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cAt.mPrefixData = null;
        qVar = this.cAt.cAe;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.c
    public void ass() {
        q qVar;
        this.cAt.mPrefixData = null;
        qVar = this.cAt.cAe;
        qVar.a((PostPrefixData) null);
    }
}
