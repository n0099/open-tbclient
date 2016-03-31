package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cg;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cg.a {
    final /* synthetic */ o eJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.eJF = oVar;
    }

    @Override // com.baidu.tieba.write.write.cg.a
    public void qy(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cg cgVar;
        cg cgVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.eJF.eJC;
        writeShareActivity.qx(i);
        textView = this.eJF.eJt;
        postPrefixData = this.eJF.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cgVar = this.eJF.eJu;
        cgVar.qr(i);
        this.eJF.aZX();
        cgVar2 = this.eJF.eJu;
        writeShareActivity2 = this.eJF.eJC;
        com.baidu.adp.lib.h.j.a(cgVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
