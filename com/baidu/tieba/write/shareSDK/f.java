package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements c {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
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
            this.cwd.mPrefixData = postPrefixData;
            postPrefixData2 = this.cwd.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.cwd.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.cwd.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.cwd.getPageContext().getString(com.baidu.tieba.y.write_no_prefix));
                    qVar2 = this.cwd.cvO;
                    if (qVar2 != null) {
                        qVar3 = this.cwd.cvO;
                        postPrefixData5 = this.cwd.mPrefixData;
                        qVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cwd.mPrefixData = null;
        qVar = this.cwd.cvO;
        qVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.c
    public void aqC() {
        q qVar;
        this.cwd.mPrefixData = null;
        qVar = this.cwd.cvO;
        qVar.a((PostPrefixData) null);
    }
}
