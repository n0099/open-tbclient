package com.baidu.tieba.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.ch;
import com.baidu.tieba.write.ci;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements ci {
    final /* synthetic */ o bJI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar) {
        this.bJI = oVar;
    }

    @Override // com.baidu.tieba.write.ci
    public void hj(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        ch chVar;
        ch chVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.bJI.bJG;
        writeShareActivity.hi(i);
        textView = this.bJI.bJx;
        postPrefixData = this.bJI.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        chVar = this.bJI.bJy;
        chVar.dP(i);
        this.bJI.aci();
        chVar2 = this.bJI.bJy;
        writeShareActivity2 = this.bJI.bJG;
        com.baidu.adp.lib.g.j.a(chVar2, writeShareActivity2);
    }
}
