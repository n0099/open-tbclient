package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f1584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AllPostActivity allPostActivity) {
        this.f1584a = allPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.f1584a.e.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                if (this.f1584a.f.f()) {
                    this.f1584a.b(1);
                    return;
                } else {
                    this.f1584a.a(this.f1584a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
