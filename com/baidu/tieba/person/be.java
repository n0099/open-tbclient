package com.baidu.tieba.person;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class be implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bd f1338a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.f1338a = bdVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        PersonLbsActivity personLbsActivity;
        ListView listView;
        if (bVar != null) {
            personLbsActivity = this.f1338a.f1337a;
            listView = personLbsActivity.f1305a;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
