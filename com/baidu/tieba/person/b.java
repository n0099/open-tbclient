package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements AdapterView.OnItemClickListener {
    final /* synthetic */ AllPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AllPostActivity allPostActivity) {
        this.a = allPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        switch (this.a.e.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                if (this.a.f.g()) {
                    this.a.a(1);
                    return;
                } else {
                    this.a.showToast(this.a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
