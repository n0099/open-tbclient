package com.baidu.tieba.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.write.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements ci {
    final /* synthetic */ q bOn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(q qVar) {
        this.bOn = qVar;
    }

    @Override // com.baidu.tieba.write.ci
    public void hs(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        ch chVar;
        ch chVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.bOn.bOl;
        writeShareActivity.hr(i);
        textView = this.bOn.bOc;
        postPrefixData = this.bOn.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        chVar = this.bOn.bOd;
        chVar.setCurrentIndex(i);
        this.bOn.acG();
        chVar2 = this.bOn.bOd;
        writeShareActivity2 = this.bOn.bOl;
        com.baidu.adp.lib.g.k.a(chVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
