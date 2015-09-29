package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.i;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0080a {
    final /* synthetic */ WriteShareActivity dlY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.dlY = writeShareActivity;
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
            this.dlY.mPrefixData = postPrefixData;
            postPrefixData2 = this.dlY.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.dlY.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.dlY.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.dlY.getPageContext().getString(i.h.write_no_prefix));
                    oVar2 = this.dlY.dlI;
                    if (oVar2 != null) {
                        oVar3 = this.dlY.dlI;
                        postPrefixData5 = this.dlY.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.dlY.mPrefixData = null;
        oVar = this.dlY.dlI;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0080a
    public void aBJ() {
        o oVar;
        this.dlY.mPrefixData = null;
        oVar = this.dlY.dlI;
        oVar.a((PostPrefixData) null);
    }
}
