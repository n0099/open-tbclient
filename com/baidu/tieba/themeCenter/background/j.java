package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ BackgroundItemView dMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BackgroundItemView backgroundItemView) {
        this.dMj = backgroundItemView;
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
            dressItemData = this.dMj.dMi;
            if (dressItemData != null) {
                iVar = this.dMj.dLR;
                if (iVar != null) {
                    skinProgressView = this.dMj.dMh;
                    if (view != skinProgressView) {
                        tbImageView = this.dMj.crP;
                        if (view == tbImageView) {
                            av avVar = new av("c10279");
                            dressItemData2 = this.dMj.dMi;
                            TiebaStatic.log(avVar.r("obj_id", dressItemData2.getPropsId()));
                            iVar2 = this.dMj.dLR;
                            dressItemData3 = this.dMj.dMi;
                            iVar2.b(dressItemData3);
                            return;
                        }
                        return;
                    }
                    av avVar2 = new av("c10280");
                    dressItemData4 = this.dMj.dMi;
                    TiebaStatic.log(avVar2.r("obj_id", dressItemData4.getPropsId()));
                    iVar3 = this.dMj.dLR;
                    dressItemData5 = this.dMj.dMi;
                    iVar3.a(dressItemData5, false);
                }
            }
        }
    }
}
