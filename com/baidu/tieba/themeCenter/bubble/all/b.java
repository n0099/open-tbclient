package com.baidu.tieba.themeCenter.bubble.all;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BubbleItemView dMW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleItemView bubbleItemView) {
        this.dMW = bubbleItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        a aVar;
        TbImageView tbImageView;
        a aVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dMW.dMi;
            if (dressItemData != null) {
                aVar = this.dMW.dMV;
                if (aVar != null) {
                    tbImageView = this.dMW.crP;
                    if (view == tbImageView) {
                        aVar2 = this.dMW.dMV;
                        dressItemData2 = this.dMW.dMi;
                        aVar2.f(dressItemData2);
                    }
                }
            }
        }
    }
}
