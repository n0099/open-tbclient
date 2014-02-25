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
public class an {
    private View a;
    private GoodGridView b;
    private ImageView c;
    private Activity d;

    public an(Activity activity) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.d = activity;
        this.a = LayoutInflater.from(activity).inflate(R.layout.dialog_good, (ViewGroup) null);
        this.b = (GoodGridView) this.a.findViewById(R.id.good_gridview);
        this.c = (ImageView) this.a.findViewById(R.id.divider_line);
    }

    public void a(com.baidu.tieba.frs.at atVar) {
        this.b.setAdapter((ListAdapter) atVar);
    }

    public void a(AdapterView.OnItemClickListener onItemClickListener) {
        this.b.setOnItemClickListener(onItemClickListener);
    }

    public View a() {
        return this.a;
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
