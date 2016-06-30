package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements b.a {
    final /* synthetic */ o fFy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.fFy = oVar;
    }

    @Override // com.baidu.tieba.write.b.a
    public void rY(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        com.baidu.tieba.write.b bVar;
        com.baidu.tieba.write.b bVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.fFy.fFw;
        writeShareActivity.sj(i);
        textView = this.fFy.fFn;
        postPrefixData = this.fFy.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        bVar = this.fFy.fFo;
        bVar.rX(i);
        this.fFy.bkL();
        bVar2 = this.fFy.fFo;
        writeShareActivity2 = this.fFy.fFw;
        com.baidu.adp.lib.h.j.a(bVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
