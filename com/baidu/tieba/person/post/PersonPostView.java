package com.baidu.tieba.person.post;

import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bb;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonPostView implements bq {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f2226a;
    public ViewPager b;
    public LinearLayout c;
    public TextView d;
    public TextView e;
    public ImageView f;
    public int g = 1;
    private i h;

    public PersonPostView(PersonPostActivity personPostActivity) {
        personPostActivity.setContentView(R.layout.person_post_activity);
        this.f2226a = (FrameLayout) personPostActivity.findViewById(16908290);
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

    public void a(int i) {
        bb.d(this.c, i);
        bb.a(this.f, i);
        bb.b(this.f2226a, i);
        boolean z = TiebaApplication.g().as() == 1;
        switch (this.g) {
            case 1:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.white));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.gray_night_4));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                this.d.setBackgroundResource(z ? R.drawable.btn_jin_ba_s_1 : R.drawable.btn_jin_ba_s);
                this.e.setBackgroundResource(z ? R.drawable.btn_baidu_n_1 : R.drawable.btn_baidu_n);
                return;
            case 2:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.gray_night_4));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.white));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                this.d.setBackgroundResource(z ? R.drawable.btn_jin_ba_n_1 : R.drawable.btn_jin_ba_n);
                this.e.setBackgroundResource(z ? R.drawable.btn_baidu_s_1 : R.drawable.btn_baidu_s);
                return;
            default:
                return;
        }
    }

    public void b(int i) {
        boolean z = TiebaApplication.g().as() == 1;
        switch (i) {
            case 1:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.white));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.gray_night_4));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                this.d.setBackgroundResource(z ? R.drawable.btn_jin_ba_s_1 : R.drawable.btn_jin_ba_s);
                this.e.setBackgroundResource(z ? R.drawable.btn_baidu_n_1 : R.drawable.btn_baidu_n);
                return;
            case 2:
                if (z) {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.gray_night_4));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.white));
                } else {
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.top_msg_num_day));
                    this.e.setTextColor(this.e.getContext().getResources().getColor(R.color.top_msg_num_day));
                }
                this.e.setBackgroundResource(z ? R.drawable.btn_baidu_s_1 : R.drawable.btn_baidu_s);
                this.d.setBackgroundResource(z ? R.drawable.btn_jin_ba_n_1 : R.drawable.btn_jin_ba_n);
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.bq
    public void onPageSelected(int i) {
        this.g = i + 1;
        if (this.g == 1) {
            b(1);
        } else if (this.g == 2) {
            b(2);
        }
    }

    @Override // android.support.v4.view.bq
    public void onPageScrollStateChanged(int i) {
        if (i == 0 && this.h != null) {
            this.h.a(this.g - 1);
        }
    }

    public void a(i iVar) {
        this.h = iVar;
    }
}
