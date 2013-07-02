package com.baidu.tieba.person;

import android.widget.ImageView;
import android.widget.ListView;
/* loaded from: classes.dex */
class be implements com.baidu.tbadk.a.d {
    final /* synthetic */ bd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar) {
        this.a = bdVar;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        PersonLbsActivity personLbsActivity;
        ListView listView;
        if (bVar != null) {
            personLbsActivity = this.a.a;
            listView = personLbsActivity.a;
            ImageView imageView = (ImageView) listView.findViewWithTag(str);
            if (imageView != null) {
                imageView.invalidate();
            }
        }
    }
}
