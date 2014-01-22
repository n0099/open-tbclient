package com.baidu.tieba.person.post;

import android.support.v4.view.ViewPager;
import android.support.v4.view.bq;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.bs;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class PersonPostView implements bq {
    public FrameLayout a;
    public ViewPager b;
    public TextView c;
    public TextView d;
    public int e = 1;
    private NavigationBar f;
    private i g;

    public PersonPostView(PersonPostActivity personPostActivity) {
        personPostActivity.setContentView(R.layout.person_post_activity);
        this.a = (FrameLayout) personPostActivity.findViewById(16908290);
        this.f = (NavigationBar) personPostActivity.findViewById(R.id.view_navigation_bar);
        this.f.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        View a = this.f.a(R.layout.nb_item_person_post, (View.OnClickListener) null);
        this.c = (TextView) a.findViewById(R.id.thread);
        this.c.setOnClickListener(personPostActivity);
        this.d = (TextView) a.findViewById(R.id.reply);
        this.d.setOnClickListener(personPostActivity);
        this.b = (ViewPager) personPostActivity.findViewById(R.id.pager);
        this.b.setOnPageChangeListener(this);
    }

    public void c(int i) {
        bs.b(this.a, i);
        this.f.c(i);
        d(this.e);
    }

    public void d(int i) {
        boolean z = TiebaApplication.h().al() == 1;
        switch (i) {
            case 1:
                if (z) {
                    this.c.setTextColor(this.c.getContext().getResources().getColor(R.color.navi_multiview_text_s_1));
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.navi_multiview_text_n_1));
                } else {
                    this.c.setTextColor(this.c.getContext().getResources().getColor(R.color.navi_multiview_text_s));
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.navi_multiview_text_n));
                }
                bs.e((View) this.c, z ? R.drawable.btn_jin_ba_s_1 : R.drawable.btn_jin_ba_s);
                bs.e((View) this.d, z ? R.drawable.btn_jin_qun_n_1 : R.drawable.btn_jin_qun_n);
                return;
            case 2:
                if (z) {
                    this.c.setTextColor(this.c.getContext().getResources().getColor(R.color.navi_multiview_text_n_1));
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.navi_multiview_text_s_1));
                } else {
                    this.c.setTextColor(this.c.getContext().getResources().getColor(R.color.navi_multiview_text_n));
                    this.d.setTextColor(this.d.getContext().getResources().getColor(R.color.navi_multiview_text_s));
                }
                bs.e((View) this.c, z ? R.drawable.btn_jin_ba_n_1 : R.drawable.btn_jin_ba_n);
                bs.e((View) this.d, z ? R.drawable.btn_jin_qun_s_1 : R.drawable.btn_jin_qun_s);
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
        this.e = i + 1;
        if (this.e == 1) {
            d(1);
        } else if (this.e == 2) {
            d(2);
        }
    }

    @Override // android.support.v4.view.bq
    public void b(int i) {
        if (i == 0 && this.g != null) {
            this.g.a(this.e - 1);
        }
    }

    public void a(i iVar) {
        this.g = iVar;
    }
}
