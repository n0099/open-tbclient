package com.baidu.tieba.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity a;
    private final /* synthetic */ w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, w wVar) {
        this.a = jigsawAlbumListActivity;
        this.b = wVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        JigsawAlbumListActivity.a(this.a, this.b.getUri());
    }
}
