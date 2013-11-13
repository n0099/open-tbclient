package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ AllPostActivity f2205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllPostActivity allPostActivity) {
        this.f2205a = allPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.f2205a.e.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                if (this.f2205a.f.g()) {
                    this.f2205a.a(1);
                    return;
                } else {
                    this.f2205a.showToast(this.f2205a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
