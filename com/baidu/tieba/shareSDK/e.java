package com.baidu.tieba.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.y;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements c {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void a(boolean z, PostPrefixData postPrefixData) {
        p pVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        p pVar2;
        p pVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.bJF.mPrefixData = postPrefixData;
            postPrefixData2 = this.bJF.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.bJF.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.bJF.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.bJF.getString(y.write_no_prefix));
                    pVar2 = this.bJF.bJs;
                    if (pVar2 != null) {
                        pVar3 = this.bJF.bJs;
                        postPrefixData5 = this.bJF.mPrefixData;
                        pVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.bJF.mPrefixData = null;
        pVar = this.bJF.bJs;
        pVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.shareSDK.c
    public void abW() {
        p pVar;
        this.bJF.mPrefixData = null;
        pVar = this.bJF.bJs;
        pVar.a((PostPrefixData) null);
    }
}
