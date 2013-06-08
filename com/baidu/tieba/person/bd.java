package com.baidu.tieba.person;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class bd implements com.baidu.tbadk.a.d {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        PersonLbsActivity personLbsActivity;
        ListView listView;
        if (bVar != null) {
            personLbsActivity = this.a.a;
            listView = personLbsActivity.c;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
