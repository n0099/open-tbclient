package com.baidu.tieba.kn.ladders;

import android.widget.ImageView;
import com.baidu.tieba.kn.ladders.KnLaddersModel;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ KnLaddersBannerAdapter f1187a;
    private final /* synthetic */ int b;
    private final /* synthetic */ ImageView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(KnLaddersBannerAdapter knLaddersBannerAdapter, int i, ImageView imageView) {
        this.f1187a = knLaddersBannerAdapter;
        this.b = i;
        this.c = imageView;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        KnLaddersModel.Pic[] picArr;
        picArr = this.f1187a.f1175a;
        if (str.equals(picArr[this.b].pic_url)) {
            this.c.setImageBitmap(bVar.f());
            this.c.invalidate();
        }
    }
}
