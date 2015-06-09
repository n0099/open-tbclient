package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cn;
import com.baidu.tieba.write.write.co;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements co {
    final /* synthetic */ q cAM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.cAM = qVar;
    }

    @Override // com.baidu.tieba.write.write.co
    public void jv(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cn cnVar;
        cn cnVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.cAM.cAK;
        writeShareActivity.ju(i);
        textView = this.cAM.cAB;
        postPrefixData = this.cAM.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cnVar = this.cAM.cAC;
        cnVar.setCurrentIndex(i);
        this.cAM.asG();
        cnVar2 = this.cAM.cAC;
        writeShareActivity2 = this.cAM.cAK;
        com.baidu.adp.lib.g.k.a(cnVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
