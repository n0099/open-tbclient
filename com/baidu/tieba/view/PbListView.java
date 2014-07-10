package com.baidu.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bk;
/* loaded from: classes.dex */
public class PbListView extends com.baidu.adp.widget.ListView.e {
    private Context a;
    private TextView b;
    private ProgressBar c;
    private View.OnClickListener d;
    private View e;
    private String f;
    private LinearLayout g;
    private ImageView h;
    private int i;

    /* loaded from: classes.dex */
    public enum IconType {
        ICON_DOWN_WARD,
        ICON_UP_WARD;

        /* JADX DEBUG: Replace access to removed values field (a) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static IconType[] valuesCustom() {
            IconType[] valuesCustom = values();
            int length = valuesCustom.length;
            IconType[] iconTypeArr = new IconType[length];
            System.arraycopy(valuesCustom, 0, iconTypeArr, 0, length);
            return iconTypeArr;
        }
    }

    public PbListView(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.a = context;
    }

    public PbListView(Context context, IconType iconType) {
        this(context);
    }

    @Override // com.baidu.adp.widget.ListView.e
    public View a() {
        this.e = LayoutInflater.from(this.a).inflate(com.baidu.tieba.w.new_pb_list_more, (ViewGroup) null);
        this.g = (LinearLayout) this.e.findViewById(com.baidu.tieba.v.pb_more_view);
        this.b = (TextView) this.e.findViewById(com.baidu.tieba.v.pb_more_text);
        this.c = (ProgressBar) this.e.findViewById(com.baidu.tieba.v.progress);
        this.h = (ImageView) this.e.findViewById(com.baidu.tieba.v.pb_more_view_top_line);
        return this.e;
    }

    public void c() {
        this.h.setVisibility(0);
    }

    public void d() {
        this.c.setVisibility(0);
        this.b.setText(this.a.getText(com.baidu.tieba.y.loading));
        d(TbadkApplication.m252getInst().getSkinType());
    }

    public void e() {
        this.c.setVisibility(8);
        if (this.f != null) {
            this.b.setText(this.f);
        } else {
            this.b.setText(this.a.getText(com.baidu.tieba.y.pb_load_more));
        }
        d(TbadkApplication.m252getInst().getSkinType());
    }

    public void a(int i) {
        this.g.setBackgroundResource(i);
    }

    public void a(String str) {
        this.f = str;
        this.b.setText(str);
        d(TbadkApplication.m252getInst().getSkinType());
    }

    public void b(int i) {
        this.b.setTextColor(this.a.getResources().getColor(i));
    }

    public void a(View.OnClickListener onClickListener) {
        this.d = onClickListener;
    }

    @Override // com.baidu.adp.widget.ListView.e
    public void onClick() {
        if (this.d != null) {
            this.d.onClick(this.e);
        }
    }

    public void c(int i) {
        this.i = i;
    }

    @SuppressLint({"ResourceAsColor"})
    public void d(int i) {
        String charSequence = this.b.getText().toString();
        if (this.e != null && charSequence != null) {
            if (i == 1) {
                if (charSequence.equals(this.a.getText(com.baidu.tieba.y.pb_load_more))) {
                    b(com.baidu.tieba.s.pb_more_txt_1);
                } else if (charSequence.equals(this.a.getText(com.baidu.tieba.y.loading))) {
                    b(com.baidu.tieba.s.pb_more_txt_1);
                } else if (charSequence.equals(this.a.getText(com.baidu.tieba.y.no_more_to_load))) {
                    b(com.baidu.tieba.s.pb_list_morebutton_nomore_text_1);
                }
                this.h.setImageResource(com.baidu.tieba.s.cp_bg_line_b_1);
            } else {
                if (charSequence.equals(this.a.getText(com.baidu.tieba.y.pb_load_more))) {
                    b(com.baidu.tieba.s.pb_more_txt);
                } else if (charSequence.equals(this.a.getText(com.baidu.tieba.y.loading))) {
                    b(com.baidu.tieba.s.pb_more_txt);
                } else if (charSequence.equals(this.a.getText(com.baidu.tieba.y.no_more_to_load))) {
                    b(com.baidu.tieba.s.pb_list_morebutton_nomore_text);
                }
                this.h.setImageResource(com.baidu.tieba.s.cp_bg_line_b);
            }
        }
        if (this.i == 0) {
            bk.f(this.g, com.baidu.tieba.s.cp_bg_line_d);
        } else if (this.i > 0) {
            bk.f(this.g, this.i);
        }
    }
}
