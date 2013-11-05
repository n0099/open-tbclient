package com.baidu.tieba.kn.ladders;

import android.widget.ImageView;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1749a;
    final /* synthetic */ int b;
    final /* synthetic */ KnLaddersBannerAdapter c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(KnLaddersBannerAdapter knLaddersBannerAdapter, int i, int i2) {
        this.c = knLaddersBannerAdapter;
        this.f1749a = i;
        this.b = i2;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        KnLaddersModel.Pic[] picArr;
        ImageView[] imageViewArr;
        ImageView[] imageViewArr2;
        picArr = this.c.f1736a;
        if (str.equals(picArr[this.f1749a].pic_url)) {
            imageViewArr = this.c.c;
            imageViewArr[this.b].setImageBitmap(eVar.f());
            imageViewArr2 = this.c.c;
            imageViewArr2[this.b].invalidate();
        }
    }
}
