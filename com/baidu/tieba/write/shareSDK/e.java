package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.u;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0083a {
    final /* synthetic */ WriteShareActivity fFg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.fFg = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0083a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.fFg.mPrefixData = postPrefixData;
            postPrefixData2 = this.fFg.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.fFg.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.fFg.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.fFg.getPageContext().getString(u.j.write_no_prefix));
                    oVar2 = this.fFg.fEQ;
                    if (oVar2 != null) {
                        oVar3 = this.fFg.fEQ;
                        postPrefixData5 = this.fFg.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.fFg.mPrefixData = null;
        oVar = this.fFg.fEQ;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0083a
    public void bkw() {
        o oVar;
        this.fFg.mPrefixData = null;
        oVar = this.fFg.fEQ;
        oVar.a((PostPrefixData) null);
    }
}
