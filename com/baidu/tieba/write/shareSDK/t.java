package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cd.a {
    final /* synthetic */ o dmr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.dmr = oVar;
    }

    @Override // com.baidu.tieba.write.write.cd.a
    public void lQ(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cd cdVar;
        cd cdVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.dmr.dmo;
        writeShareActivity.lP(i);
        textView = this.dmr.dmf;
        postPrefixData = this.dmr.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cdVar = this.dmr.dmg;
        cdVar.lJ(i);
        this.dmr.aBZ();
        cdVar2 = this.dmr.dmg;
        writeShareActivity2 = this.dmr.dmo;
        com.baidu.adp.lib.g.j.a(cdVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
