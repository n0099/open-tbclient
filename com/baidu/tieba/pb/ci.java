package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ci implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bn f1501a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(bn bnVar) {
        this.f1501a = bnVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        cu cuVar;
        cu cuVar2;
        if (bVar != null) {
            bdListView = this.f1501a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
            if (this.f1501a.t()) {
                cuVar = this.f1501a.z;
                if (cuVar != null) {
                    cuVar2 = this.f1501a.z;
                    ImageView imageView2 = (ImageView) cuVar2.d().findViewWithTag(str);
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                }
            }
        }
    }
}
