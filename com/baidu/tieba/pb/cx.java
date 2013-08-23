package com.baidu.tieba.pb;

import android.util.SparseArray;
import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class cx implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cv f1552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cx(cv cvVar) {
        this.f1552a = cvVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str;
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray != null && (str = (String) sparseArray.get(R.id.tag_photo_username)) != null) {
            this.f1552a.b(str);
        }
    }
}
