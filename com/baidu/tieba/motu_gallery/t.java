package com.baidu.tieba.motu_gallery;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes.dex */
final class t implements View.OnClickListener {
    final /* synthetic */ s a;
    private final /* synthetic */ w b;
    private final /* synthetic */ a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, w wVar, a aVar) {
        this.a = sVar;
        this.b = wVar;
        this.c = aVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JigsawAlbumListActivity jigsawAlbumListActivity;
        JigsawAlbumListActivity jigsawAlbumListActivity2;
        JigsawAlbumListActivity jigsawAlbumListActivity3;
        LinearLayout linearLayout;
        JigsawAlbumListActivity jigsawAlbumListActivity4;
        TextView textView;
        JigsawAlbumListActivity jigsawAlbumListActivity5;
        JigsawAlbumListActivity jigsawAlbumListActivity6;
        jigsawAlbumListActivity = this.a.a.a;
        u uVar = jigsawAlbumListActivity.a;
        jigsawAlbumListActivity2 = this.a.a.a;
        uVar.b(jigsawAlbumListActivity2, this.b.getUri());
        this.c.setIsSelected(false);
        jigsawAlbumListActivity3 = this.a.a.a;
        linearLayout = jigsawAlbumListActivity3.m;
        linearLayout.removeView(view);
        jigsawAlbumListActivity4 = this.a.a.a;
        textView = jigsawAlbumListActivity4.o;
        jigsawAlbumListActivity5 = this.a.a.a;
        u uVar2 = jigsawAlbumListActivity5.a;
        jigsawAlbumListActivity6 = this.a.a.a;
        textView.setText(uVar2.c(jigsawAlbumListActivity6));
    }
}
