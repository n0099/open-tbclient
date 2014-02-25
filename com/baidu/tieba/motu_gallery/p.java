package com.baidu.tieba.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity a;
    private final /* synthetic */ x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(JigsawAlbumListActivity jigsawAlbumListActivity, x xVar) {
        this.a = jigsawAlbumListActivity;
        this.b = xVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.a(this.b.getUri());
    }
}
