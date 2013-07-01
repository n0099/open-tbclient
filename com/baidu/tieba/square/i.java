package com.baidu.tieba.square;

import android.view.View;
import android.widget.ImageView;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1434a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, View view) {
        this.f1434a = gVar;
        this.b = view;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        while (true) {
            View findViewWithTag = this.b.findViewWithTag(str);
            if (findViewWithTag != null) {
                findViewWithTag.setTag(null);
                if (findViewWithTag instanceof ImageView) {
                    bVar.b((ImageView) findViewWithTag);
                }
            } else {
                return;
            }
        }
    }
}
