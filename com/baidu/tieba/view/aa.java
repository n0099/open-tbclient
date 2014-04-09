package com.baidu.tieba.view;

import com.baidu.tbadk.core.view.HeadImageView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aa implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ UserPhotoLayout a;
    private final /* synthetic */ HeadImageView b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(UserPhotoLayout userPhotoLayout, HeadImageView headImageView, String str) {
        this.a = userPhotoLayout;
        this.b = headImageView;
        this.c = str;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.setTag(null);
            bVar.a(this.b);
            return;
        }
        this.b.setTag(this.c);
        this.b.setImageBitmap(com.baidu.tbadk.core.util.g.a(com.baidu.tieba.a.g.photo));
    }
}
