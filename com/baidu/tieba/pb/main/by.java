package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class by implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bm bmVar) {
        this.a = bmVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public final void a(com.baidu.adp.widget.ImageView.b bVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (bVar != null) {
            bdListView = this.a.o;
            View findViewWithTag = bdListView.findViewWithTag(str);
            while (findViewWithTag != null) {
                if (findViewWithTag instanceof ImageView) {
                    ImageView imageView = (ImageView) findViewWithTag;
                    imageView.setTag(null);
                    imageView.setImageBitmap(bVar.h());
                }
                bdListView2 = this.a.o;
                findViewWithTag = bdListView2.findViewWithTag(str);
            }
        }
    }
}
