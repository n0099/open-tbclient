package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ba extends com.baidu.adp.widget.ListView.c {

    /* renamed from: a  reason: collision with root package name */
    private Context f1827a;
    private TextView b = null;
    private ProgressBar c = null;
    private ImageView d = null;
    private View.OnClickListener e = null;
    private View f = null;
    private String g = null;

    public ba(Context context) {
        this.f1827a = null;
        this.f1827a = context;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.f = LayoutInflater.from(this.f1827a).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.b = (TextView) this.f.findViewById(R.id.pb_more_text);
        this.d = (ImageView) this.f.findViewById(R.id.image);
        if (TiebaApplication.f().au() == 1) {
            this.d.setBackgroundResource(R.drawable.ico_downward_1);
        } else {
            this.d.setBackgroundResource(R.drawable.ico_downward);
        }
        this.c = (ProgressBar) this.f.findViewById(R.id.progress);
        return this.f;
    }

    public void c() {
        this.c.setVisibility(0);
        this.d.setVisibility(8);
        this.b.setText(this.f1827a.getText(R.string.loading));
    }

    public void d() {
        this.c.setVisibility(8);
        this.d.setVisibility(0);
        if (this.g != null) {
            this.b.setText(this.g);
        } else {
            this.b.setText(this.f1827a.getText(R.string.load_more));
        }
    }

    public void a(String str) {
        this.g = str;
        this.b.setText(str);
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
