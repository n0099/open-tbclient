package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements c {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.bJq.mPrefixData = postPrefixData;
            postPrefixData2 = this.bJq.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.bJq.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.bJq.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.bJq.getString(y.write_no_prefix));
                    oVar2 = this.bJq.bJe;
                    if (oVar2 != null) {
                        oVar3 = this.bJq.bJe;
                        postPrefixData5 = this.bJq.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bJq.mPrefixData = null;
        oVar = this.bJq.bJe;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void abT() {
        o oVar;
        this.bJq.mPrefixData = null;
        oVar = this.bJq.bJe;
        oVar.a((PostPrefixData) null);
    }
}
