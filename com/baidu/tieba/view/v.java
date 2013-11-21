package com.baidu.tieba.view;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    private View f2582a;
    private GoodGridView b;
    private ImageView c;
    private Activity d;

    public v(Activity activity) {
        this.f2582a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.d = activity;
        this.f2582a = LayoutInflater.from(activity).inflate(R.layout.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.f2582a.findViewById(R.id.good_gridview);
        this.c = (ImageView) this.f2582a.findViewById(R.id.divider_line);
    }

    public void a(com.baidu.tieba.frs.ap apVar) {
        this.b.setAdapter((ListAdapter) apVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.f2582a;
    }

    public void a(int i) {
        if (i == 1) {
            this.b.setBackgroundResource(R.color.frs_goodheader_bg_1);
            this.c.setBackgroundResource(R.color.frs_goodheader_line_end_1);
            return;
        }
        this.b.setBackgroundDrawable(null);
        this.b.setBackgroundColor(-1);
        this.c.setBackgroundResource(R.color.frs_goodheader_line_end);
    }
}
