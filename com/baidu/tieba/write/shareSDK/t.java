package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements b.a {
    final /* synthetic */ o faw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.faw = oVar;
    }

    @Override // com.baidu.tieba.write.b.a
    public void qI(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        com.baidu.tieba.write.b bVar;
        com.baidu.tieba.write.b bVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.faw.fat;
        writeShareActivity.qT(i);
        textView = this.faw.fak;
        postPrefixData = this.faw.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        bVar = this.faw.fal;
        bVar.qH(i);
        this.faw.bcj();
        bVar2 = this.faw.fal;
        writeShareActivity2 = this.faw.fat;
        com.baidu.adp.lib.h.j.a(bVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
