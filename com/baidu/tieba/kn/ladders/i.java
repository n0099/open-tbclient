package com.baidu.tieba.kn.ladders;

import android.widget.ImageView;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ int f1748a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ KnLaddersBannerAdapter c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(KnLaddersBannerAdapter knLaddersBannerAdapter, int i, ImageView imageView) {
        this.c = knLaddersBannerAdapter;
        this.f1748a = i;
        this.b = imageView;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        KnLaddersModel.Pic[] picArr;
        picArr = this.c.f1736a;
        if (str.equals(picArr[this.f1748a].pic_url)) {
            this.b.setImageBitmap(eVar.f());
            this.b.invalidate();
        }
    }
}
