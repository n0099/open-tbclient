package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnClickListener {
    final /* synthetic */ cm gbK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cm cmVar) {
        this.gbK = cmVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cs csVar;
        Pattern pattern;
        cs csVar2;
        com.baidu.tieba.write.model.a aVar;
        cs csVar3;
        if (view != null && view.getId() == w.h.url_add) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12163"));
            csVar = this.gbK.gbH;
            String bqz = csVar.bqz();
            pattern = cm.gbG;
            if (pattern.matcher(bqz).matches()) {
                this.gbK.bqo();
                aVar = this.gbK.gbI;
                aVar.rl(bqz);
                csVar3 = this.gbK.gbH;
                csVar3.a(null, true);
                return;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.as("c12164"));
            csVar2 = this.gbK.gbH;
            csVar2.bqA();
        }
    }
}
