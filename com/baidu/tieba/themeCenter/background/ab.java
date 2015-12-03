package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa dFq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dFq = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        i iVar;
        i iVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dFq.dEF;
            if (dressItemData != null) {
                iVar = this.dFq.dEn;
                if (iVar != null) {
                    TiebaStatic.log(new av("c10284"));
                    iVar2 = this.dFq.dEn;
                    dressItemData2 = this.dFq.dEF;
                    iVar2.a(dressItemData2, true);
                }
            }
        }
    }
}
