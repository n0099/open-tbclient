package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements View.OnClickListener {
    final /* synthetic */ aa dMS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(aa aaVar) {
        this.dMS = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        i iVar;
        i iVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dMS.dMi;
            if (dressItemData != null) {
                iVar = this.dMS.dLR;
                if (iVar != null) {
                    TiebaStatic.log(new av("c10284"));
                    iVar2 = this.dMS.dLR;
                    dressItemData2 = this.dMS.dMi;
                    iVar2.a(dressItemData2, true);
                }
            }
        }
    }
}
