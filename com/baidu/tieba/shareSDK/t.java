package com.baidu.tieba.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.write.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements ci {
    final /* synthetic */ p bJX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar) {
        this.bJX = pVar;
    }

    @Override // com.baidu.tieba.write.ci
    public void hj(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        ch chVar;
        ch chVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.bJX.bJV;
        writeShareActivity.hi(i);
        textView = this.bJX.bJM;
        postPrefixData = this.bJX.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        chVar = this.bJX.bJN;
        chVar.dP(i);
        this.bJX.acl();
        chVar2 = this.bJX.bJN;
        writeShareActivity2 = this.bJX.bJV;
        com.baidu.adp.lib.g.j.a(chVar2, writeShareActivity2);
    }
}
