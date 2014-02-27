package com.baidu.tieba.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
final class f implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(JigsawAlbumActivity jigsawAlbumActivity) {
        this.a = jigsawAlbumActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.finish();
    }
}
