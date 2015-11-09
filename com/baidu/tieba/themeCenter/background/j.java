package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ BackgroundItemView dhd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BackgroundItemView backgroundItemView) {
        this.dhd = backgroundItemView;
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
            dressItemData = this.dhd.dhc;
            if (dressItemData != null) {
                iVar = this.dhd.dgG;
                if (iVar != null) {
                    skinProgressView = this.dhd.dhb;
                    if (view != skinProgressView) {
                        tbImageView = this.dhd.dha;
                        if (view == tbImageView) {
                            aq aqVar = new aq("c10279");
                            dressItemData2 = this.dhd.dhc;
                            TiebaStatic.log(aqVar.r("obj_id", dressItemData2.getPropsId()));
                            iVar2 = this.dhd.dgG;
                            dressItemData3 = this.dhd.dhc;
                            iVar2.a(dressItemData3);
                            return;
                        }
                        return;
                    }
                    aq aqVar2 = new aq("c10280");
                    dressItemData4 = this.dhd.dhc;
                    TiebaStatic.log(aqVar2.r("obj_id", dressItemData4.getPropsId()));
                    iVar3 = this.dhd.dgG;
                    dressItemData5 = this.dhd.dhc;
                    iVar3.a(dressItemData5, false);
                }
            }
        }
    }
}
