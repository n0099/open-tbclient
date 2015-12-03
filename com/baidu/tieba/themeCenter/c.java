package com.baidu.tieba.themeCenter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ SkinItemView dDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SkinItemView skinItemView) {
        this.dDS = skinItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b bVar;
        SkinItemView.a aVar;
        SkinProgressView skinProgressView;
        TbImageView tbImageView;
        ImageView imageView;
        SkinItemView.a aVar2;
        b bVar2;
        SkinItemView.a aVar3;
        b bVar3;
        SkinItemView.a aVar4;
        SkinProgressView skinProgressView2;
        b bVar4;
        if (view != null) {
            bVar = this.dDS.mSkinData;
            if (bVar != null) {
                aVar = this.dDS.dDR;
                if (aVar != null) {
                    skinProgressView = this.dDS.dDQ;
                    if (view != skinProgressView) {
                        tbImageView = this.dDS.dDL;
                        if (view != tbImageView) {
                            imageView = this.dDS.dDO;
                            if (view == imageView) {
                                aVar2 = this.dDS.dDR;
                                bVar2 = this.dDS.mSkinData;
                                aVar2.a(view, bVar2);
                                return;
                            }
                            return;
                        }
                        aVar3 = this.dDS.dDR;
                        SkinItemView skinItemView = this.dDS;
                        bVar3 = this.dDS.mSkinData;
                        aVar3.a(skinItemView, bVar3);
                        return;
                    }
                    aVar4 = this.dDS.dDR;
                    skinProgressView2 = this.dDS.dDQ;
                    bVar4 = this.dDS.mSkinData;
                    aVar4.a(skinProgressView2, bVar4);
                }
            }
        }
    }
}
