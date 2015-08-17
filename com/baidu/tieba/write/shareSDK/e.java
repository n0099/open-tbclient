package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.i;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0075a {
    final /* synthetic */ WriteShareActivity cSj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.cSj = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0075a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.cSj.mPrefixData = postPrefixData;
            postPrefixData2 = this.cSj.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.cSj.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.cSj.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.cSj.getPageContext().getString(i.C0057i.write_no_prefix));
                    oVar2 = this.cSj.cRT;
                    if (oVar2 != null) {
                        oVar3 = this.cSj.cRT;
                        postPrefixData5 = this.cSj.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.cSj.mPrefixData = null;
        oVar = this.cSj.cRT;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0075a
    public void auj() {
        o oVar;
        this.cSj.mPrefixData = null;
        oVar = this.cSj.cRT;
        oVar.a((PostPrefixData) null);
    }
}
