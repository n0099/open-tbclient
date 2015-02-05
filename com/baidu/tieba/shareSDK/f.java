package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity bPE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.bPE = writeShareActivity;
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void a(boolean z, PostPrefixData postPrefixData) {
        q qVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        q qVar2;
        q qVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.bPE.mPrefixData = postPrefixData;
            postPrefixData2 = this.bPE.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.bPE.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.bPE.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.bPE.getPageContext().getString(z.write_no_prefix));
                    qVar2 = this.bPE.bPq;
                    if (qVar2 != null) {
                        qVar3 = this.bPE.bPq;
                        postPrefixData5 = this.bPE.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bPE.mPrefixData = null;
        qVar = this.bPE.bPq;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void acQ() {
        q qVar;
        this.bPE.mPrefixData = null;
        qVar = this.bPE.bPq;
        qVar.a((PostPrefixData) null);
    }
}
