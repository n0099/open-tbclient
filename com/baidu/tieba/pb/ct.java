package com.baidu.tieba.pb;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class ct implements AdapterView.OnItemClickListener {
    final /* synthetic */ cr a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cr crVar) {
        this.a = crVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = (String) view.getTag(R.id.tag_photo_username);
        if (str != null) {
            this.a.b(str);
        }
    }
}
