package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.i;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0080a {
    final /* synthetic */ WriteShareActivity dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.dmy = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0080a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.dmy.mPrefixData = postPrefixData;
            postPrefixData2 = this.dmy.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.dmy.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.dmy.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.dmy.getPageContext().getString(i.h.write_no_prefix));
                    oVar2 = this.dmy.dmi;
                    if (oVar2 != null) {
                        oVar3 = this.dmy.dmi;
                        postPrefixData5 = this.dmy.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dmy.mPrefixData = null;
        oVar = this.dmy.dmi;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0080a
    public void aBP() {
        o oVar;
        this.dmy.mPrefixData = null;
        oVar = this.dmy.dmi;
        oVar.a((PostPrefixData) null);
    }
}
