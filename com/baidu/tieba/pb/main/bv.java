package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements com.baidu.tbadk.imageManager.d {
    final /* synthetic */ bj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        BdListView bdListView;
        BdListView bdListView2;
        if (aVar != null) {
            bdListView = this.a.o;
            View findViewWithTag = bdListView.findViewWithTag(str);
            while (findViewWithTag != null) {
                if (findViewWithTag instanceof ImageView) {
                    ImageView imageView = (ImageView) findViewWithTag;
                    imageView.setTag(null);
                    imageView.setImageBitmap(aVar.h());
                }
                bdListView2 = this.a.o;
                findViewWithTag = bdListView2.findViewWithTag(str);
            }
        }
    }
}
