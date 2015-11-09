package com.baidu.tieba.themeCenter;

import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.SkinItemView;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ SkinItemView dgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(SkinItemView skinItemView) {
        this.dgl = skinItemView;
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
            bVar = this.dgl.mSkinData;
            if (bVar != null) {
                aVar = this.dgl.dgk;
                if (aVar != null) {
                    skinProgressView = this.dgl.dgj;
                    if (view != skinProgressView) {
                        tbImageView = this.dgl.dgc;
                        if (view != tbImageView) {
                            imageView = this.dgl.dgg;
                            if (view == imageView) {
                                aVar2 = this.dgl.dgk;
                                bVar2 = this.dgl.mSkinData;
                                aVar2.a(view, bVar2);
                                return;
                            }
                            return;
                        }
                        aVar3 = this.dgl.dgk;
                        SkinItemView skinItemView = this.dgl;
                        bVar3 = this.dgl.mSkinData;
                        aVar3.a(skinItemView, bVar3);
                        return;
                    }
                    aVar4 = this.dgl.dgk;
                    skinProgressView2 = this.dgl.dgj;
                    bVar4 = this.dgl.mSkinData;
                    aVar4.a(skinProgressView2, bVar4);
                }
            }
        }
    }
}
