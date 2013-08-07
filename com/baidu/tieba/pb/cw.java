package com.baidu.tieba.pb;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class cw implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cu f1514a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cw(cu cuVar) {
        this.f1514a = cuVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null && (str = (String) sparseArray.get(R.id.tag_photo_username)) != null) {
            this.f1514a.b(str);
        }
    }
}
