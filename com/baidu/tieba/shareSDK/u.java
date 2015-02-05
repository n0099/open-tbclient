package com.baidu.tieba.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.write.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ci {
    final /* synthetic */ q bPW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.bPW = qVar;
    }

    @Override // com.baidu.tieba.write.ci
    public void hB(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        ch chVar;
        ch chVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.bPW.bPU;
        writeShareActivity.hA(i);
        textView = this.bPW.bPL;
        postPrefixData = this.bPW.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        chVar = this.bPW.bPM;
        chVar.setCurrentIndex(i);
        this.bPW.adf();
        chVar2 = this.bPW.bPM;
        writeShareActivity2 = this.bPW.bPU;
        com.baidu.adp.lib.g.k.a(chVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
