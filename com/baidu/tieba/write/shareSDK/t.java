package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements cb.a {
    final /* synthetic */ o dbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.dbp = oVar;
    }

    @Override // com.baidu.tieba.write.write.cb.a
    public void lb(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cb cbVar;
        cb cbVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.dbp.dbm;
        writeShareActivity.la(i);
        textView = this.dbp.dbd;
        postPrefixData = this.dbp.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cbVar = this.dbp.dbe;
        cbVar.kU(i);
        this.dbp.ayQ();
        cbVar2 = this.dbp.dbe;
        writeShareActivity2 = this.dbp.dbm;
        com.baidu.adp.lib.g.j.a(cbVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
