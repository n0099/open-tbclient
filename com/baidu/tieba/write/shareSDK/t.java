package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cf.a {
    final /* synthetic */ o dNF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.dNF = oVar;
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void ns(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cf cfVar;
        cf cfVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.dNF.dNC;
        writeShareActivity.nr(i);
        textView = this.dNF.dNt;
        postPrefixData = this.dNF.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cfVar = this.dNF.dNu;
        cfVar.nl(i);
        this.dNF.aIs();
        cfVar2 = this.dNF.dNu;
        writeShareActivity2 = this.dNF.dNC;
        com.baidu.adp.lib.h.j.a(cfVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
