package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cn;
import com.baidu.tieba.write.write.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements co {
    final /* synthetic */ q cAL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.cAL = qVar;
    }

    @Override // com.baidu.tieba.write.write.co
    public void jv(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cn cnVar;
        cn cnVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.cAL.cAJ;
        writeShareActivity.ju(i);
        textView = this.cAL.cAA;
        postPrefixData = this.cAL.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cnVar = this.cAL.cAB;
        cnVar.setCurrentIndex(i);
        this.cAL.asF();
        cnVar2 = this.cAL.cAB;
        writeShareActivity2 = this.cAL.cAJ;
        com.baidu.adp.lib.g.k.a(cnVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
