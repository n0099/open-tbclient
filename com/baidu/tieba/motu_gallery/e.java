package com.baidu.tieba.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class e implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumActivity f2024a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(JigsawAlbumActivity jigsawAlbumActivity) {
        this.f2024a = jigsawAlbumActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2024a.finish();
    }
}
