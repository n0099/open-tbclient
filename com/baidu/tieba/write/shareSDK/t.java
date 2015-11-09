package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cf.a {
    final /* synthetic */ o doz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.doz = oVar;
    }

    @Override // com.baidu.tieba.write.write.cf.a
    public void mg(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cf cfVar;
        cf cfVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.doz.dow;
        writeShareActivity.mf(i);
        textView = this.doz.don;
        postPrefixData = this.doz.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cfVar = this.doz.doo;
        cfVar.lZ(i);
        this.doz.aCV();
        cfVar2 = this.doz.doo;
        writeShareActivity2 = this.doz.dow;
        com.baidu.adp.lib.g.j.a(cfVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
