package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class i implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity a;
    private final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(JigsawAlbumActivity jigsawAlbumActivity, w wVar) {
        this.a = jigsawAlbumActivity;
        this.b = wVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.a.k;
        uVar.b(this.a, this.b.getUri());
        linearLayout = this.a.v;
        linearLayout.removeView(view);
        TextView textView = this.a.a;
        uVar2 = this.a.k;
        textView.setText(uVar2.c(this.a));
    }
}
