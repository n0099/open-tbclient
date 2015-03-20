package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity cvN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.cvN = writeShareActivity;
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
            this.cvN.mPrefixData = postPrefixData;
            postPrefixData2 = this.cvN.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.cvN.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.cvN.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.cvN.getPageContext().getString(com.baidu.tieba.y.write_no_prefix));
                    qVar2 = this.cvN.cvy;
                    if (qVar2 != null) {
                        qVar3 = this.cvN.cvy;
                        postPrefixData5 = this.cvN.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cvN.mPrefixData = null;
        qVar = this.cvN.cvy;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.c
    public void aqn() {
        q qVar;
        this.cvN.mPrefixData = null;
        qVar = this.cvN.cvy;
        qVar.a((PostPrefixData) null);
    }
}
