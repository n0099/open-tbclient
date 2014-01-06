package com.baidu.tieba.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.c {
    private Context a;
    private TextView b;
    private ProgressBar c;
    private View.OnClickListener d;
    private View e;
    private String f;
    private LinearLayout g;
    private int h;
    private IconType i;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD
    }

    public PbListView(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = IconType.ICON_DOWN_WARD;
        this.a = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
        this.i = iconType;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public View a() {
        this.e = LayoutInflater.from(this.a).inflate(R.layout.new_pb_list_more, (ViewGroup) null);
        this.g = (LinearLayout) this.e.findViewById(R.id.pb_more_view);
        this.b = (TextView) this.e.findViewById(R.id.pb_more_text);
        this.c = (ProgressBar) this.e.findViewById(R.id.progress);
        return this.e;
    }

    public void c() {
        this.c.setVisibility(0);
        this.b.setText(this.a.getText(R.string.loading));
        d(TiebaApplication.g().an());
    }

    public void d() {
        this.c.setVisibility(8);
        if (this.f != null) {
            this.b.setText(this.f);
        } else {
            this.b.setText(this.a.getText(R.string.pb_load_more));
        }
        d(TiebaApplication.g().an());
    }

    public void a(int i) {
        this.g.setBackgroundResource(i);
    }

    public void b(int i) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.g.getLayoutParams());
        layoutParams.height = i;
        this.g.setLayoutParams(layoutParams);
    }

    public void a(String str) {
        this.f = str;
        this.b.setText(str);
        d(TiebaApplication.g().an());
    }

    public void c(int i) {
        this.b.setTextColor(this.a.getResources().getColor(i));
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.c
    public void onClick() {
        if (this.d != null) {
            this.d.onClick(this.e);
        }
    }

    public void d(int i) {
        String charSequence = this.b.getText().toString();
        if (this.e != null && charSequence != null) {
            if (i == 1) {
                if (charSequence.equals(this.a.getText(R.string.pb_load_more))) {
                    c(R.color.pb_more_txt_1);
                } else if (charSequence.equals(this.a.getText(R.string.loading))) {
                    c(R.color.pb_more_txt_1);
                } else if (charSequence.equals(this.a.getText(R.string.no_more_to_load))) {
                    c(R.color.pb_list_morebutton_nomore_text_1);
                }
            } else if (charSequence.equals(this.a.getText(R.string.pb_load_more))) {
                c(R.color.pb_more_txt);
            } else if (charSequence.equals(this.a.getText(R.string.loading))) {
                c(R.color.pb_more_txt);
            } else if (charSequence.equals(this.a.getText(R.string.no_more_to_load))) {
                c(R.color.pb_list_morebutton_nomore_text);
            }
        }
    }
}
