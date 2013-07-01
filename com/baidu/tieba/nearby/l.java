package com.baidu.tieba.nearby;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class l implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f1169a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f1169a = kVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        NearbyPbActivity nearbyPbActivity;
        ListView listView;
        if (bVar != null) {
            nearbyPbActivity = this.f1169a.f1168a;
            listView = nearbyPbActivity.b;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
