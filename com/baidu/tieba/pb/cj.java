package com.baidu.tieba.pb;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bo f1539a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(bo boVar) {
        this.f1539a = boVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        BdListView bdListView;
        cv cvVar;
        cv cvVar2;
        if (bVar != null) {
            bdListView = this.f1539a.f;
            ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
            if (this.f1539a.u()) {
                cvVar = this.f1539a.A;
                if (cvVar != null) {
                    cvVar2 = this.f1539a.A;
                    ImageView imageView2 = (ImageView) cvVar2.d().findViewWithTag(str);
                    if (imageView2 != null) {
                        imageView2.invalidate();
                    }
                }
            }
        }
    }
}
