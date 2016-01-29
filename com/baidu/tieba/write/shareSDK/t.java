package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cc;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cc.a {
    final /* synthetic */ o epJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.epJ = oVar;
    }

    @Override // com.baidu.tieba.write.write.cc.a
    public void pF(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cc ccVar;
        cc ccVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.epJ.epG;
        writeShareActivity.pE(i);
        textView = this.epJ.epx;
        postPrefixData = this.epJ.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        ccVar = this.epJ.epy;
        ccVar.py(i);
        this.epJ.aTx();
        ccVar2 = this.epJ.epy;
        writeShareActivity2 = this.epJ.epG;
        com.baidu.adp.lib.h.j.a(ccVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
