package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ br f1588a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(br brVar) {
        this.f1588a = brVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.c cVar, String str, boolean z) {
        BdListView bdListView;
        db dbVar;
        db dbVar2;
        if (cVar != null) {
            bdListView = this.f1588a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
            if (this.f1588a.E()) {
                dbVar = this.f1588a.E;
                if (dbVar != null) {
                    dbVar2 = this.f1588a.E;
                    ImageView imageView2 = (ImageView) dbVar2.g().findViewWithTag(str);
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                }
            }
        }
    }
}
