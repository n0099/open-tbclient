package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ BackgroundItemView dEG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BackgroundItemView backgroundItemView) {
        this.dEG = backgroundItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        i iVar;
        SkinProgressView skinProgressView;
        TbImageView tbImageView;
        DressItemData dressItemData2;
        i iVar2;
        DressItemData dressItemData3;
        DressItemData dressItemData4;
        i iVar3;
        DressItemData dressItemData5;
        if (view != null) {
            dressItemData = this.dEG.dEF;
            if (dressItemData != null) {
                iVar = this.dEG.dEn;
                if (iVar != null) {
                    skinProgressView = this.dEG.dEE;
                    if (view != skinProgressView) {
                        tbImageView = this.dEG.cnM;
                        if (view == tbImageView) {
                            av avVar = new av("c10279");
                            dressItemData2 = this.dEG.dEF;
                            TiebaStatic.log(avVar.r("obj_id", dressItemData2.getPropsId()));
                            iVar2 = this.dEG.dEn;
                            dressItemData3 = this.dEG.dEF;
                            iVar2.b(dressItemData3);
                            return;
                        }
                        return;
                    }
                    av avVar2 = new av("c10280");
                    dressItemData4 = this.dEG.dEF;
                    TiebaStatic.log(avVar2.r("obj_id", dressItemData4.getPropsId()));
                    iVar3 = this.dEG.dEn;
                    dressItemData5 = this.dEG.dEF;
                    iVar3.a(dressItemData5, false);
                }
            }
        }
    }
}
