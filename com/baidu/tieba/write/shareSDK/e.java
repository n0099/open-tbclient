package com.baidu.tieba.write.shareSDK;

import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.t;
import com.baidu.tieba.write.shareSDK.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0088a {
    final /* synthetic */ WriteShareActivity eJm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.eJm = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0088a
    public void a(boolean z, PostPrefixData postPrefixData) {
        o oVar;
        PostPrefixData postPrefixData2;
        PostPrefixData postPrefixData3;
        PostPrefixData postPrefixData4;
        o oVar2;
        o oVar3;
        PostPrefixData postPrefixData5;
        if (z) {
            this.eJm.mPrefixData = postPrefixData;
            postPrefixData2 = this.eJm.mPrefixData;
            if (postPrefixData2 != null) {
                postPrefixData3 = this.eJm.mPrefixData;
                if (postPrefixData3.getPrefixs().size() > 0) {
                    postPrefixData4 = this.eJm.mPrefixData;
                    postPrefixData4.getPrefixs().add(this.eJm.getPageContext().getString(t.j.write_no_prefix));
                    oVar2 = this.eJm.eIW;
                    if (oVar2 != null) {
                        oVar3 = this.eJm.eIW;
                        postPrefixData5 = this.eJm.mPrefixData;
                        oVar3.a(postPrefixData5);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.eJm.mPrefixData = null;
        oVar = this.eJm.eIW;
        oVar.a((PostPrefixData) null);
    }

    @Override // com.baidu.tieba.write.shareSDK.a.InterfaceC0088a
    public void aZH() {
        o oVar;
        this.eJm.mPrefixData = null;
        oVar = this.eJm.eIW;
        oVar.a((PostPrefixData) null);
    }
}
