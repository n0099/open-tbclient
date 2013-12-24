package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements View.OnClickListener {
    final /* synthetic */ w a;
    final /* synthetic */ JigsawAlbumActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(JigsawAlbumActivity jigsawAlbumActivity, w wVar) {
        this.b = jigsawAlbumActivity;
        this.a = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        u uVar;
        LinearLayout linearLayout;
        u uVar2;
        uVar = this.b.k;
        uVar.b(this.b, this.a.getUri());
        linearLayout = this.b.v;
        linearLayout.removeView(view);
        TextView textView = this.b.a;
        uVar2 = this.b.k;
        textView.setText(uVar2.e(this.b));
    }
}
