package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.i;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0077a {
    final /* synthetic */ WriteShareActivity daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.daW = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0077a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.daW.mPrefixData = postPrefixData;
            postPrefixData2 = this.daW.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.daW.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.daW.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.daW.getPageContext().getString(i.h.write_no_prefix));
                    oVar2 = this.daW.daG;
                    if (oVar2 != null) {
                        oVar3 = this.daW.daG;
                        postPrefixData5 = this.daW.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.daW.mPrefixData = null;
        oVar = this.daW.daG;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0077a
    public void ayC() {
        o oVar;
        this.daW.mPrefixData = null;
        oVar = this.daW.daG;
        oVar.a((PostPrefixData) null);
    }
}
