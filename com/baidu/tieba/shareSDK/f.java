package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
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
            this.bNV.mPrefixData = postPrefixData;
            postPrefixData2 = this.bNV.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.bNV.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.bNV.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.bNV.getPageContext().getString(z.write_no_prefix));
                    qVar2 = this.bNV.bNH;
                    if (qVar2 != null) {
                        qVar3 = this.bNV.bNH;
                        postPrefixData5 = this.bNV.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bNV.mPrefixData = null;
        qVar = this.bNV.bNH;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void acr() {
        q qVar;
        this.bNV.mPrefixData = null;
        qVar = this.bNV.bNH;
        qVar.a((PostPrefixData) null);
    }
}
