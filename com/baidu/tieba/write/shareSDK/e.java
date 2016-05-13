package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.t;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0081a {
    final /* synthetic */ WriteShareActivity fac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.fac = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0081a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.fac.mPrefixData = postPrefixData;
            postPrefixData2 = this.fac.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.fac.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.fac.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.fac.getPageContext().getString(t.j.write_no_prefix));
                    oVar2 = this.fac.eZM;
                    if (oVar2 != null) {
                        oVar3 = this.fac.eZM;
                        postPrefixData5 = this.fac.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.fac.mPrefixData = null;
        oVar = this.fac.eZM;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0081a
    public void bca() {
        o oVar;
        this.fac.mPrefixData = null;
        oVar = this.fac.eZM;
        oVar.a((PostPrefixData) null);
    }
}
