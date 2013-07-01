package com.baidu.tieba.person;

import android.view.View;
import android.widget.AdapterView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ PersonLbsActivity f1341a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(PersonLbsActivity personLbsActivity) {
        this.f1341a = personLbsActivity;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        int i2;
        int i3;
        if (j == -1) {
            PersonLbsActivity personLbsActivity = this.f1341a;
            i3 = this.f1341a.r;
            personLbsActivity.b(1, i3 - 1);
        } else if (j == -2) {
            PersonLbsActivity personLbsActivity2 = this.f1341a;
            i2 = this.f1341a.s;
            personLbsActivity2.b(2, i2 + 1);
        }
    }
}
