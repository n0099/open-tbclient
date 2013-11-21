package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2010a;
    final /* synthetic */ JigsawAlbumActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity, w wVar) {
        this.b = jigsawAlbumActivity;
        this.f2010a = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.b.k;
        uVar.b(this.b, this.f2010a.getUri());
        linearLayout = this.b.v;
        linearLayout.removeView(view);
        TextView textView = this.b.f2002a;
        uVar2 = this.b.k;
        textView.setText(uVar2.e(this.b));
    }
}
