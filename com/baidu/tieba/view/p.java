package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private View f1843a;
    private GoodGridView b;
    private Activity c;

    public p(Activity activity) {
        this.f1843a = null;
        this.b = null;
        this.c = null;
        this.c = activity;
        this.f1843a = LayoutInflater.from(activity).inflate(R.layout.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.f1843a.findViewById(R.id.good_gridview);
    }

    public void a(com.baidu.tieba.frs.ag agVar) {
        this.b.setAdapter((ListAdapter) agVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.f1843a;
    }

    public void a(int i) {
        int a2 = com.baidu.tieba.util.am.a((Context) this.c, 10.0f);
        if (i == 1) {
            this.b.setBackgroundResource(R.drawable.bg_topbar_1);
            this.b.setPadding(0, a2, 0, a2);
            return;
        }
        this.b.setBackgroundDrawable(null);
        this.b.setBackgroundColor(-1);
        this.b.setPadding(0, a2, 0, a2);
    }

    public void b() {
    }
}
