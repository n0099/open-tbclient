package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.bx;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements bx.a {
    final /* synthetic */ o cSC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.cSC = oVar;
    }

    @Override // com.baidu.tieba.write.write.bx.a
    public void kq(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        bx bxVar;
        bx bxVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.cSC.cSz;
        writeShareActivity.kp(i);
        textView = this.cSC.cSq;
        postPrefixData = this.cSC.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        bxVar = this.cSC.cSr;
        bxVar.kj(i);
        this.cSC.auw();
        bxVar2 = this.cSC.cSr;
        writeShareActivity2 = this.cSC.cSz;
        com.baidu.adp.lib.g.j.a(bxVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
