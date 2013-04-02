package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements AdapterView.OnItemClickListener {
    final /* synthetic */ PersonLbsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(PersonLbsActivity personLbsActivity) {
        this.a = personLbsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        int i3;
        if (j == -1) {
            PersonLbsActivity personLbsActivity = this.a;
            i3 = this.a.r;
            personLbsActivity.a(1, i3 - 1);
        } else if (j == -2) {
            PersonLbsActivity personLbsActivity2 = this.a;
            i2 = this.a.s;
            personLbsActivity2.a(2, i2 + 1);
        }
    }
}
