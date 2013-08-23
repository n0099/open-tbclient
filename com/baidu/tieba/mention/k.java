package com.baidu.tieba.mention;

import android.widget.ImageView;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
class k implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f1334a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f1334a = jVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        i iVar;
        BdListView bdListView;
        i iVar2;
        BdListView bdListView2;
        iVar = this.f1334a.f1333a;
        bdListView = iVar.d;
        ImageView imageView = (ImageView) bdListView.findViewWithTag(str);
        while (imageView != null) {
            imageView.setTag(null);
            if (imageView != null && bVar != null) {
                bVar.a(imageView);
            }
            iVar2 = this.f1334a.f1333a;
            bdListView2 = iVar2.d;
            imageView = (ImageView) bdListView2.findViewWithTag(str);
        }
    }
}
