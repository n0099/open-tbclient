package com.baidu.tieba.person.post;

import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.as;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonPostView implements bq {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f1706a;
    public ViewPager b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public int g = 1;
    private i h;

    public PersonPostView(PersonPostActivity personPostActivity) {
        personPostActivity.setContentView(R.layout.person_post_activity);
        this.f1706a = (FrameLayout) personPostActivity.findViewById(16908290);
        this.b = (ViewPager) personPostActivity.findViewById(R.id.pager);
        this.b.setOnPageChangeListener(this);
        this.c = (LinearLayout) personPostActivity.findViewById(R.id.title);
        this.d = (TextView) personPostActivity.findViewById(R.id.thread);
        this.d.setOnClickListener(personPostActivity);
        this.e = (TextView) personPostActivity.findViewById(R.id.reply);
        this.e.setOnClickListener(personPostActivity);
        this.f = (ImageView) personPostActivity.findViewById(R.id.back);
        this.f.setOnClickListener(personPostActivity);
    }

    public void c(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        as.d(this.c, i);
        as.a(this.f, i);
        as.b(this.f1706a, i);
        boolean z = TiebaApplication.g().ap() == 1;
        switch (this.g) {
            case 1:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.white));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.gray_night_4));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                TextView textView = this.d;
                if (z) {
                    i4 = R.drawable.btn_jin_ba_s_1;
                } else {
                    i4 = R.drawable.btn_jin_ba_s;
                }
                textView.setBackgroundResource(i4);
                TextView textView2 = this.e;
                if (z) {
                    i5 = R.drawable.btn_baidu_n_1;
                } else {
                    i5 = R.drawable.btn_baidu_n;
                }
                textView2.setBackgroundResource(i5);
                return;
            case 2:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.gray_night_4));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.white));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                TextView textView3 = this.d;
                if (z) {
                    i2 = R.drawable.btn_jin_ba_n_1;
                } else {
                    i2 = R.drawable.btn_jin_ba_n;
                }
                textView3.setBackgroundResource(i2);
                TextView textView4 = this.e;
                if (z) {
                    i3 = R.drawable.btn_baidu_s_1;
                } else {
                    i3 = R.drawable.btn_baidu_s;
                }
                textView4.setBackgroundResource(i3);
                return;
            default:
                return;
        }
    }

    public void d(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z = TiebaApplication.g().ap() == 1;
        switch (i) {
            case 1:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.white));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.gray_night_4));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                TextView textView = this.d;
                if (z) {
                    i4 = R.drawable.btn_jin_ba_s_1;
                } else {
                    i4 = R.drawable.btn_jin_ba_s;
                }
                textView.setBackgroundResource(i4);
                TextView textView2 = this.e;
                if (z) {
                    i5 = R.drawable.btn_baidu_n_1;
                } else {
                    i5 = R.drawable.btn_baidu_n;
                }
                textView2.setBackgroundResource(i5);
                return;
            case 2:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.gray_night_4));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.white));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                TextView textView3 = this.e;
                if (z) {
                    i2 = R.drawable.btn_baidu_s_1;
                } else {
                    i2 = R.drawable.btn_baidu_s;
                }
                textView3.setBackgroundResource(i2);
                TextView textView4 = this.d;
                if (z) {
                    i3 = R.drawable.btn_jin_ba_n_1;
                } else {
                    i3 = R.drawable.btn_jin_ba_n;
                }
                textView4.setBackgroundResource(i3);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.view.bq
    public void a(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void a_(int i) {
        this.g = i + 1;
        if (this.g == 1) {
            d(1);
        } else if (this.g == 2) {
            d(2);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        if (i == 0 && this.h != null) {
            this.h.a(this.g - 1);
        }
    }

    public void a(i iVar) {
        this.h = iVar;
    }
}
