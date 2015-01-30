package com.baidu.tieba.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.write.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ci {
    final /* synthetic */ q bPX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.bPX = qVar;
    }

    @Override // com.baidu.tieba.write.ci
    public void hB(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        ch chVar;
        ch chVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.bPX.bPV;
        writeShareActivity.hA(i);
        textView = this.bPX.bPM;
        postPrefixData = this.bPX.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        chVar = this.bPX.bPN;
        chVar.setCurrentIndex(i);
        this.bPX.adk();
        chVar2 = this.bPX.bPN;
        writeShareActivity2 = this.bPX.bPV;
        com.baidu.adp.lib.g.k.a(chVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
