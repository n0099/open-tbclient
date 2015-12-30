package com.baidu.tieba.themeCenter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ SkinItemView dLw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SkinItemView skinItemView) {
        this.dLw = skinItemView;
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
            bVar = this.dLw.mSkinData;
            if (bVar != null) {
                aVar = this.dLw.dLv;
                if (aVar != null) {
                    skinProgressView = this.dLw.dLu;
                    if (view != skinProgressView) {
                        tbImageView = this.dLw.dLp;
                        if (view != tbImageView) {
                            imageView = this.dLw.dLs;
                            if (view == imageView) {
                                aVar2 = this.dLw.dLv;
                                bVar2 = this.dLw.mSkinData;
                                aVar2.a(view, bVar2);
                                return;
                            }
                            return;
                        }
                        aVar3 = this.dLw.dLv;
                        SkinItemView skinItemView = this.dLw;
                        bVar3 = this.dLw.mSkinData;
                        aVar3.a(skinItemView, bVar3);
                        return;
                    }
                    aVar4 = this.dLw.dLv;
                    skinProgressView2 = this.dLw.dLu;
                    bVar4 = this.dLw.mSkinData;
                    aVar4.a(skinProgressView2, bVar4);
                }
            }
        }
    }
}
