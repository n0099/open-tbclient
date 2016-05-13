package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements b.a {
    final /* synthetic */ o fav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.fav = oVar;
    }

    @Override // com.baidu.tieba.write.b.a
    public void qH(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        com.baidu.tieba.write.b bVar;
        com.baidu.tieba.write.b bVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.fav.fas;
        writeShareActivity.qS(i);
        textView = this.fav.faj;
        postPrefixData = this.fav.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        bVar = this.fav.fak;
        bVar.qG(i);
        this.fav.bcq();
        bVar2 = this.fav.fak;
        writeShareActivity2 = this.fav.fas;
        com.baidu.adp.lib.h.j.a(bVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
