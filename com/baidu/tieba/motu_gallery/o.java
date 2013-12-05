package com.baidu.tieba.motu_gallery;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ w f2124a;
    final /* synthetic */ JigsawAlbumListActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(JigsawAlbumListActivity jigsawAlbumListActivity, w wVar) {
        this.b = jigsawAlbumListActivity;
        this.f2124a = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.b.a(this.f2124a.getUri());
    }
}
