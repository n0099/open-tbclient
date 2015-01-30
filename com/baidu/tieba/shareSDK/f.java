package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
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
            this.bPF.mPrefixData = postPrefixData;
            postPrefixData2 = this.bPF.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.bPF.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.bPF.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.bPF.getPageContext().getString(z.write_no_prefix));
                    qVar2 = this.bPF.bPr;
                    if (qVar2 != null) {
                        qVar3 = this.bPF.bPr;
                        postPrefixData5 = this.bPF.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bPF.mPrefixData = null;
        qVar = this.bPF.bPr;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void acV() {
        q qVar;
        this.bPF.mPrefixData = null;
        qVar = this.bPF.bPr;
        qVar.a((PostPrefixData) null);
    }
}
