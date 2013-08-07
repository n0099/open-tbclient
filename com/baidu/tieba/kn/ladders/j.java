package com.baidu.tieba.kn.ladders;

import android.widget.ImageView;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnLaddersBannerAdapter f1188a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(KnLaddersBannerAdapter knLaddersBannerAdapter, int i, int i2) {
        this.f1188a = knLaddersBannerAdapter;
        this.b = i;
        this.c = i2;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        KnLaddersModel.Pic[] picArr;
        ImageView[] imageViewArr;
        ImageView[] imageViewArr2;
        picArr = this.f1188a.f1175a;
        if (str.equals(picArr[this.b].pic_url)) {
            imageViewArr = this.f1188a.c;
            imageViewArr[this.c].setImageBitmap(bVar.f());
            imageViewArr2 = this.f1188a.c;
            imageViewArr2[this.c].invalidate();
        }
    }
}
