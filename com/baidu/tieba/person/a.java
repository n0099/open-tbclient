package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements AdapterView.OnItemClickListener {
    final /* synthetic */ AllPostActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AllPostActivity allPostActivity) {
        this.a = allPostActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        switch (this.a.g.getItemViewType(i)) {
            case 0:
            case 1:
            default:
                return;
            case 2:
                if (this.a.h.d()) {
                    this.a.c(1);
                    return;
                } else {
                    this.a.a(this.a.getString(R.string.no_more_to_load));
                    return;
                }
        }
    }
}
