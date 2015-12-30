package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cf.a {
    final /* synthetic */ o dVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.dVe = oVar;
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void ok(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cf cfVar;
        cf cfVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.dVe.dVb;
        writeShareActivity.oj(i);
        textView = this.dVe.dUS;
        postPrefixData = this.dVe.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cfVar = this.dVe.dUT;
        cfVar.od(i);
        this.dVe.aKN();
        cfVar2 = this.dVe.dUT;
        writeShareActivity2 = this.dVe.dVb;
        com.baidu.adp.lib.h.j.a(cfVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
