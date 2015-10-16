package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cd.a {
    final /* synthetic */ o dmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.dmR = oVar;
    }

    @Override // com.baidu.tieba.write.write.cd.a
    public void lS(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cd cdVar;
        cd cdVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.dmR.dmO;
        writeShareActivity.lR(i);
        textView = this.dmR.dmF;
        postPrefixData = this.dmR.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cdVar = this.dmR.dmG;
        cdVar.lL(i);
        this.dmR.aCj();
        cdVar2 = this.dmR.dmG;
        writeShareActivity2 = this.dmR.dmO;
        com.baidu.adp.lib.g.j.a(cdVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
