package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements com.baidu.tbadk.imageManager.c {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bt f2101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(bt btVar) {
        this.f2101a = btVar;
    }

    @Override // com.baidu.tbadk.imageManager.c
    public void a(com.baidu.adp.widget.ImageView.e eVar, String str, boolean z) {
        BdListView bdListView;
        dd ddVar;
        dd ddVar2;
        if (eVar != null) {
            bdListView = this.f2101a.g;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
            if (this.f2101a.E()) {
                ddVar = this.f2101a.E;
                if (ddVar != null) {
                    ddVar2 = this.f2101a.E;
                    ImageView imageView2 = (ImageView) ddVar2.g().findViewWithTag(str);
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                }
            }
        }
    }
}
