package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bk f1250a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(bk bkVar) {
        this.f1250a = bkVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        cr crVar;
        cr crVar2;
        if (bVar != null) {
            bdListView = this.f1250a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
            if (this.f1250a.t()) {
                crVar = this.f1250a.z;
                if (crVar != null) {
                    crVar2 = this.f1250a.z;
                    ImageView imageView2 = (ImageView) crVar2.d().findViewWithTag(str);
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                }
            }
        }
    }
}
