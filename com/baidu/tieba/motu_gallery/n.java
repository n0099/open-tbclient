package com.baidu.tieba.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
final class n implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.a = jigsawAlbumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
