package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f2298a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllPostActivity allPostActivity) {
        this.f2298a = allPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.f2298a.e.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                if (this.f2298a.f.g()) {
                    this.f2298a.a(1);
                    return;
                } else {
                    this.f2298a.showToast(this.f2298a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
