package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ BackgroundItemView deX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BackgroundItemView backgroundItemView) {
        this.deX = backgroundItemView;
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
            dressItemData = this.deX.deW;
            if (dressItemData != null) {
                iVar = this.deX.deA;
                if (iVar != null) {
                    skinProgressView = this.deX.deV;
                    if (view != skinProgressView) {
                        tbImageView = this.deX.deU;
                        if (view == tbImageView) {
                            ap apVar = new ap("c10279");
                            dressItemData2 = this.deX.deW;
                            TiebaStatic.log(apVar.r("obj_id", dressItemData2.getPropsId()));
                            iVar2 = this.deX.deA;
                            dressItemData3 = this.deX.deW;
                            iVar2.a(dressItemData3);
                            return;
                        }
                        return;
                    }
                    ap apVar2 = new ap("c10280");
                    dressItemData4 = this.deX.deW;
                    TiebaStatic.log(apVar2.r("obj_id", dressItemData4.getPropsId()));
                    iVar3 = this.deX.deA;
                    dressItemData5 = this.deX.deW;
                    iVar3.a(dressItemData5, false);
                }
            }
        }
    }
}
