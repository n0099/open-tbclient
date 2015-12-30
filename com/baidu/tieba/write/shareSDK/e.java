package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.n;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0085a {
    final /* synthetic */ WriteShareActivity dUL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.dUL = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0085a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.dUL.mPrefixData = postPrefixData;
            postPrefixData2 = this.dUL.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.dUL.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.dUL.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.dUL.getPageContext().getString(n.j.write_no_prefix));
                    oVar2 = this.dUL.dUv;
                    if (oVar2 != null) {
                        oVar3 = this.dUL.dUv;
                        postPrefixData5 = this.dUL.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dUL.mPrefixData = null;
        oVar = this.dUL.dUv;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0085a
    public void aKx() {
        o oVar;
        this.dUL.mPrefixData = null;
        oVar = this.dUL.dUv;
        oVar.a((PostPrefixData) null);
    }
}
