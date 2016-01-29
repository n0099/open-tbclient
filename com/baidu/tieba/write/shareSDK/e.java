package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.t;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0090a {
    final /* synthetic */ WriteShareActivity epq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.epq = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0090a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.epq.mPrefixData = postPrefixData;
            postPrefixData2 = this.epq.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.epq.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.epq.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.epq.getPageContext().getString(t.j.write_no_prefix));
                    oVar2 = this.epq.epa;
                    if (oVar2 != null) {
                        oVar3 = this.epq.epa;
                        postPrefixData5 = this.epq.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.epq.mPrefixData = null;
        oVar = this.epq.epa;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0090a
    public void aTh() {
        o oVar;
        this.epq.mPrefixData = null;
        oVar = this.epq.epa;
        oVar.a((PostPrefixData) null);
    }
}
