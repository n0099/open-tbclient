package com.baidu.tieba.themeCenter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ SkinItemView deF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SkinItemView skinItemView) {
        this.deF = skinItemView;
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
            bVar = this.deF.mSkinData;
            if (bVar != null) {
                aVar = this.deF.deE;
                if (aVar != null) {
                    skinProgressView = this.deF.deD;
                    if (view != skinProgressView) {
                        tbImageView = this.deF.dew;
                        if (view != tbImageView) {
                            imageView = this.deF.deA;
                            if (view == imageView) {
                                aVar2 = this.deF.deE;
                                bVar2 = this.deF.mSkinData;
                                aVar2.a(view, bVar2);
                                return;
                            }
                            return;
                        }
                        aVar3 = this.deF.deE;
                        SkinItemView skinItemView = this.deF;
                        bVar3 = this.deF.mSkinData;
                        aVar3.a(skinItemView, bVar3);
                        return;
                    }
                    aVar4 = this.deF.deE;
                    skinProgressView2 = this.deF.deD;
                    bVar4 = this.deF.mSkinData;
                    aVar4.a(skinProgressView2, bVar4);
                }
            }
        }
    }
}
