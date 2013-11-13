package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cp f2143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(cp cpVar) {
        this.f2143a = cpVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        eb ebVar;
        eb ebVar2;
        bdListView = this.f2143a.i;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        if (eVar == null) {
            if (imageView != null && (imageView instanceof com.baidu.tieba.view.ba)) {
                ((com.baidu.tieba.view.ba) imageView).a(false);
                return;
            }
            return;
        }
        if (imageView != null) {
            if (imageView instanceof com.baidu.tieba.view.ba) {
                ((com.baidu.tieba.view.ba) imageView).a(true);
            }
            imageView.invalidate();
        }
        if (this.f2143a.x()) {
            ebVar = this.f2143a.q;
            if (ebVar != null) {
                ebVar2 = this.f2143a.q;
                ImageView imageView2 = (ImageView) ebVar2.n().findViewWithTag(str);
                if (imageView2 != null) {
                    imageView2.invalidate();
                }
            }
        }
    }
}
