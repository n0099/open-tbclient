package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa dfE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dfE = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        i iVar;
        i iVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dfE.deW;
            if (dressItemData != null) {
                iVar = this.dfE.deA;
                if (iVar != null) {
                    TiebaStatic.log(new ap("c10284"));
                    iVar2 = this.dfE.deA;
                    dressItemData2 = this.dfE.deW;
                    iVar2.a(dressItemData2, true);
                }
            }
        }
    }
}
