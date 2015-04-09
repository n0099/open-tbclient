package com.baidu.tieba.write.shareSDK;

import android.widget.TextView;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tieba.write.write.cm;
import com.baidu.tieba.write.write.cn;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements cn {
    final /* synthetic */ q cwv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(q qVar) {
        this.cwv = qVar;
    }

    @Override // com.baidu.tieba.write.write.cn
    public void iZ(int i) {
        WriteShareActivity writeShareActivity;
        TextView textView;
        PostPrefixData postPrefixData;
        cm cmVar;
        cm cmVar2;
        WriteShareActivity writeShareActivity2;
        writeShareActivity = this.cwv.cwt;
        writeShareActivity.iY(i);
        textView = this.cwv.cwk;
        postPrefixData = this.cwv.mPrefixData;
        textView.setText(postPrefixData.getPrefixs().get(i));
        cmVar = this.cwv.cwl;
        cmVar.setCurrentIndex(i);
        this.cwv.aqP();
        cmVar2 = this.cwv.cwl;
        writeShareActivity2 = this.cwv.cwt;
        com.baidu.adp.lib.g.k.a(cmVar2, writeShareActivity2.getPageContext().getPageActivity());
    }
}
