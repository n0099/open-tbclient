package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.n;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0089a {
    final /* synthetic */ WriteShareActivity dNm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.dNm = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0089a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.dNm.mPrefixData = postPrefixData;
            postPrefixData2 = this.dNm.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.dNm.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.dNm.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.dNm.getPageContext().getString(n.i.write_no_prefix));
                    oVar2 = this.dNm.dMW;
                    if (oVar2 != null) {
                        oVar3 = this.dNm.dMW;
                        postPrefixData5 = this.dNm.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dNm.mPrefixData = null;
        oVar = this.dNm.dMW;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0089a
    public void aIc() {
        o oVar;
        this.dNm.mPrefixData = null;
        oVar = this.dNm.dMW;
        oVar.a((PostPrefixData) null);
    }
}
