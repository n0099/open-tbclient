package com.baidu.tieba.motu_gallery;

import android.view.View;
/* loaded from: classes.dex */
class m implements View.OnClickListener {
    final /* synthetic */ JigsawAlbumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(JigsawAlbumListActivity jigsawAlbumListActivity) {
        this.a = jigsawAlbumListActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.a.finish();
    }
}
