package com.baidu.tieba.themeCenter.background;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinProgressView;
/* loaded from: classes.dex */
class j implements View.OnClickListener {
    final /* synthetic */ BackgroundItemView dfx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BackgroundItemView backgroundItemView) {
        this.dfx = backgroundItemView;
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
            dressItemData = this.dfx.dfw;
            if (dressItemData != null) {
                iVar = this.dfx.dfa;
                if (iVar != null) {
                    skinProgressView = this.dfx.dfv;
                    if (view != skinProgressView) {
                        tbImageView = this.dfx.dfu;
                        if (view == tbImageView) {
                            aq aqVar = new aq("c10279");
                            dressItemData2 = this.dfx.dfw;
                            TiebaStatic.log(aqVar.r("obj_id", dressItemData2.getPropsId()));
                            iVar2 = this.dfx.dfa;
                            dressItemData3 = this.dfx.dfw;
                            iVar2.a(dressItemData3);
                            return;
                        }
                        return;
                    }
                    aq aqVar2 = new aq("c10280");
                    dressItemData4 = this.dfx.dfw;
                    TiebaStatic.log(aqVar2.r("obj_id", dressItemData4.getPropsId()));
                    iVar3 = this.dfx.dfa;
                    dressItemData5 = this.dfx.dfw;
                    iVar3.a(dressItemData5, false);
                }
            }
        }
    }
}
