package com.baidu.tieba.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ JigsawAlbumListActivity f2122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.f2122a = jigsawAlbumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f2122a.finish();
    }
}
