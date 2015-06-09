package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
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
            this.cAu.mPrefixData = postPrefixData;
            postPrefixData2 = this.cAu.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.cAu.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.cAu.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.cAu.getPageContext().getString(com.baidu.tieba.t.write_no_prefix));
                    qVar2 = this.cAu.cAf;
                    if (qVar2 != null) {
                        qVar3 = this.cAu.cAf;
                        postPrefixData5 = this.cAu.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cAu.mPrefixData = null;
        qVar = this.cAu.cAf;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.c
    public void ast() {
        q qVar;
        this.cAu.mPrefixData = null;
        qVar = this.cAu.cAf;
        qVar.a((PostPrefixData) null);
    }
}
