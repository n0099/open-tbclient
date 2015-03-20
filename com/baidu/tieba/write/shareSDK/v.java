package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cm;
import com.baidu.tieba.write.write.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements cn {
    final /* synthetic */ q cwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.cwf = qVar;
    }

    @Override // com.baidu.tieba.write.write.cn
    public void iW(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cm cmVar;
        cm cmVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.cwf.cwd;
        writeShareActivity.iV(i);
        textView = this.cwf.cvU;
        postPrefixData = this.cwf.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cmVar = this.cwf.cvV;
        cmVar.setCurrentIndex(i);
        this.cwf.aqA();
        cmVar2 = this.cwf.cvV;
        writeShareActivity2 = this.cwf.cwd;
        com.baidu.adp.lib.g.k.a(cmVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
