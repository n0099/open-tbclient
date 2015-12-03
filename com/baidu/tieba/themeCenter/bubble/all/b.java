package com.baidu.tieba.themeCenter.bubble.all;

import android.view.View;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.themeCenter.background.DressItemData;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ BubbleItemView dFu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BubbleItemView bubbleItemView) {
        this.dFu = bubbleItemView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DressItemData dressItemData;
        a aVar;
        TbImageView tbImageView;
        a aVar2;
        DressItemData dressItemData2;
        if (view != null) {
            dressItemData = this.dFu.dEF;
            if (dressItemData != null) {
                aVar = this.dFu.dFt;
                if (aVar != null) {
                    tbImageView = this.dFu.cnM;
                    if (view == tbImageView) {
                        aVar2 = this.dFu.dFt;
                        dressItemData2 = this.dFu.dEF;
                        aVar2.f(dressItemData2);
                    }
                }
            }
        }
    }
}
