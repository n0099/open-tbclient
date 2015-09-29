package com.baidu.tieba.themeCenter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ SkinItemView def;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SkinItemView skinItemView) {
        this.def = skinItemView;
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
            bVar = this.def.mSkinData;
            if (bVar != null) {
                aVar = this.def.dee;
                if (aVar != null) {
                    skinProgressView = this.def.ded;
                    if (view != skinProgressView) {
                        tbImageView = this.def.ddW;
                        if (view != tbImageView) {
                            imageView = this.def.dea;
                            if (view == imageView) {
                                aVar2 = this.def.dee;
                                bVar2 = this.def.mSkinData;
                                aVar2.a(view, bVar2);
                                return;
                            }
                            return;
                        }
                        aVar3 = this.def.dee;
                        SkinItemView skinItemView = this.def;
                        bVar3 = this.def.mSkinData;
                        aVar3.a(skinItemView, bVar3);
                        return;
                    }
                    aVar4 = this.def.dee;
                    skinProgressView2 = this.def.ded;
                    bVar4 = this.def.mSkinData;
                    aVar4.a(skinProgressView2, bVar4);
                }
            }
        }
    }
}
