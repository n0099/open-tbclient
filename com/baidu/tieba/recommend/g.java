package com.baidu.tieba.recommend;

import com.baidu.tieba.view.ADImageViewDrawer;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f1664a;
    private final /* synthetic */ ADImageViewDrawer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, ADImageViewDrawer aDImageViewDrawer) {
        this.f1664a = cVar;
        this.b = aDImageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (this.b != null) {
            this.b.invalidate();
        }
    }
}
