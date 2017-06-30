package com.baidu.tieba.write.write;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.w;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cm implements View.OnClickListener {
    final /* synthetic */ ck gmI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(ck ckVar) {
        this.gmI = ckVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        cq cqVar;
        Pattern pattern;
        cq cqVar2;
        com.baidu.tieba.write.model.a aVar;
        cq cqVar3;
        if (view != null && view.getId() == w.h.url_add) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12163"));
            cqVar = this.gmI.gmF;
            String bva = cqVar.bva();
            pattern = ck.gmE;
            if (pattern.matcher(bva).matches()) {
                this.gmI.buO();
                aVar = this.gmI.gmG;
                aVar.sk(bva);
                cqVar3 = this.gmI.gmF;
                cqVar3.a(null, true);
                return;
            }
            TiebaStatic.log(new com.baidu.tbadk.core.util.au("c12164"));
            cqVar2 = this.gmI.gmF;
            cqVar2.bvb();
        }
    }
}
