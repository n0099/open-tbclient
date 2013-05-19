package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.pb.bh;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.widget.ListView.c {
    private Context a;
    private TextView b = null;
    private ProgressBar c = null;
    private ImageView d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private int g = 0;

    public ao(Context context) {
        this.a = null;
        this.a = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.f = LayoutInflater.from(this.a).inflate(R.layout.new_sub_pb_list_more, (ViewGroup) null);
        this.b = (TextView) this.f.findViewById(R.id.sub_pb_more_text);
        this.d = (ImageView) this.f.findViewById(R.id.image);
        if (TiebaApplication.d().ai() == 1) {
            this.d.setBackgroundResource(R.drawable.icon_little_down_1);
        } else {
            this.d.setBackgroundResource(R.drawable.icon_little_down);
        }
        this.c = (ProgressBar) this.f.findViewById(R.id.progress);
        return this.f;
    }

    public void c() {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.b.setText(this.a.getText(R.string.loading));
    }

    public void a(int i) {
        this.g = i;
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (i > 0) {
            bh.a(this.b, i);
        } else {
            this.b.setText(this.a.getText(R.string.load_more));
        }
    }

    public void d() {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (this.g > 0) {
            bh.a(this.b, this.g);
        } else {
            this.b.setText(this.a.getText(R.string.load_more));
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.e = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.e != null) {
            this.e.onClick(this.f);
        }
    }
}
