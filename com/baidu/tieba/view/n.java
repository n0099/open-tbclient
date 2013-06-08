package com.baidu.tieba.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class n {
    private View a;
    private GoodGridView b;
    private Activity c;

    public n(Activity activity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.c = activity;
        this.a = LayoutInflater.from(activity).inflate(R.layout.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.a.findViewById(R.id.good_gridview);
    }

    public void a(com.baidu.tieba.frs.ag agVar) {
        this.b.setAdapter((ListAdapter) agVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.a;
    }

    public void a(int i) {
        int a = com.baidu.tieba.d.ag.a(this.c, 10.0f);
        if (i == 1) {
            this.b.setBackgroundResource(R.drawable.bg_topbar_1);
            this.b.setPadding(0, a, 0, a);
            return;
        }
        this.b.setBackgroundDrawable(null);
        this.b.setBackgroundColor(-1);
        this.b.setPadding(0, a, 0, a);
    }

    public void b() {
    }
}
