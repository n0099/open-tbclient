package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa dge;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dge = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        i iVar;
        i iVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dge.dfw;
            if (dressItemData != null) {
                iVar = this.dge.dfa;
                if (iVar != null) {
                    TiebaStatic.log(new aq("c10284"));
                    iVar2 = this.dge.dfa;
                    dressItemData2 = this.dge.dfw;
                    iVar2.a(dressItemData2, true);
                }
            }
        }
    }
}
