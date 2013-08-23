package com.baidu.tieba.view;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class w {

    /* renamed from: a  reason: collision with root package name */
    private View f1881a;
    private GoodGridView b;
    private Activity c;

    public w(Activity activity) {
        this.f1881a = null;
        this.b = null;
        this.c = null;
        this.c = activity;
        this.f1881a = LayoutInflater.from(activity).inflate(R.layout.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.f1881a.findViewById(R.id.good_gridview);
    }

    public void a(com.baidu.tieba.frs.ai aiVar) {
        this.b.setAdapter((ListAdapter) aiVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.f1881a;
    }

    public void a(int i) {
        int a2 = UtilHelper.a((Context) this.c, 10.0f);
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
