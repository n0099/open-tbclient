package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa dhK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dhK = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        i iVar;
        i iVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dhK.dhc;
            if (dressItemData != null) {
                iVar = this.dhK.dgG;
                if (iVar != null) {
                    TiebaStatic.log(new aq("c10284"));
                    iVar2 = this.dhK.dgG;
                    dressItemData2 = this.dhK.dhc;
                    iVar2.a(dressItemData2, true);
                }
            }
        }
    }
}
