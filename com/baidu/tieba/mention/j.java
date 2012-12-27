package com.baidu.tieba.mention;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class j implements com.baidu.tieba.c.d {
    final /* synthetic */ i a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.a = iVar;
    }

    @Override // com.baidu.tieba.c.d
    public void a(Bitmap bitmap, String str, boolean z) {
        h hVar;
        ListView listView;
        h hVar2;
        ListView listView2;
        hVar = this.a.a;
        listView = hVar.d;
        ImageView imageView = (ImageView) listView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bitmap != null) {
                imageView.setImageBitmap(bitmap);
            }
            hVar2 = this.a.a;
            listView2 = hVar2.d;
            imageView = (ImageView) listView2.findViewWithTag(str);
        }
    }
}
