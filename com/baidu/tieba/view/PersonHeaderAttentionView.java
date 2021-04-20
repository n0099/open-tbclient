package com.baidu.tieba.view;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.wallet.home.datamodel.HomeCfgResponse;
import d.b.c.e.p.l;
import d.b.i0.u3.f;
/* loaded from: classes5.dex */
public class PersonHeaderAttentionView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21843e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21844f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21845g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21846h;
    public ImageView i;
    public TextView j;
    public TextView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public int o;
    public f p;
    public UserData q;
    public View r;
    public View s;
    public View t;
    public View.OnClickListener u;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {

        /* renamed from: e  reason: collision with root package name */
        public d.b.i0.j0.a f21847e = new d.b.i0.j0.a();

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonHeaderAttentionView.this.q == null || view == null || !ViewHelper.checkUpIsLogin(PersonHeaderAttentionView.this.f21843e)) {
                return;
            }
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.q.getUserId());
            boolean z = PersonHeaderAttentionView.this.q.getIsFriend() == 1;
            int id = view.getId();
            if (id != PersonHeaderAttentionView.this.f21844f.getId() && id != PersonHeaderAttentionView.this.f21845g.getId()) {
                if (id != PersonHeaderAttentionView.this.f21846h.getId() && id != PersonHeaderAttentionView.this.j.getId()) {
                    if (id == PersonHeaderAttentionView.this.k.getId() || id == PersonHeaderAttentionView.this.l.getId()) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
                        if (PersonHeaderAttentionView.this.q.getPersonPrivate() != null) {
                            if (PersonHeaderAttentionView.this.q.getPersonPrivate().s() != 1 && !equals && (!z || PersonHeaderAttentionView.this.q.getPersonPrivate().s() != 2)) {
                                PersonHeaderAttentionView personHeaderAttentionView = PersonHeaderAttentionView.this;
                                personHeaderAttentionView.n(personHeaderAttentionView.q.getSex());
                                return;
                            }
                            this.f21847e.f57315a = 7;
                        } else {
                            PersonHeaderAttentionView personHeaderAttentionView2 = PersonHeaderAttentionView.this;
                            personHeaderAttentionView2.n(personHeaderAttentionView2.q.getSex());
                            return;
                        }
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
                    this.f21847e.f57315a = 5;
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
                this.f21847e.f57315a = 4;
            }
            if (PersonHeaderAttentionView.this.p == null) {
                return;
            }
            this.f21847e.f57316b = new Bundle();
            this.f21847e.f57316b.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.q);
            PersonHeaderAttentionView.this.p.a(view, this.f21847e);
        }
    }

    public PersonHeaderAttentionView(Context context) {
        super(context);
        this.o = -1;
        this.u = new a();
        l(context);
        k();
        m(0);
    }

    public final void k() {
        this.f21846h.setOnClickListener(this.u);
        this.j.setOnClickListener(this.u);
        this.f21844f.setOnClickListener(this.u);
        this.f21845g.setOnClickListener(this.u);
        this.k.setOnClickListener(this.u);
        this.l.setOnClickListener(this.u);
        this.m.setOnClickListener(this.u);
        this.n.setOnClickListener(this.u);
    }

    public final void l(Context context) {
        this.f21843e = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.f21846h = (TextView) findViewById(R.id.person_header_fans_num);
        this.j = (TextView) findViewById(R.id.person_header_fans_des);
        this.i = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.f21844f = (TextView) findViewById(R.id.person_header_attention_num);
        this.f21845g = (TextView) findViewById(R.id.person_header_attention_des);
        this.k = (TextView) findViewById(R.id.person_header_bar_num);
        this.l = (TextView) findViewById(R.id.person_header_bar_des);
        TextView textView = (TextView) findViewById(R.id.person_header_thread_num);
        this.m = textView;
        textView.setVisibility(8);
        TextView textView2 = (TextView) findViewById(R.id.person_header_thread_des);
        this.n = textView2;
        textView2.setVisibility(8);
        this.r = findViewById(R.id.divider_for_fans_and_attention);
        this.s = findViewById(R.id.divider_for_attention_and_bar);
        View findViewById = findViewById(R.id.divider_for_bar_and_thread);
        this.t = findViewById;
        findViewById.setVisibility(8);
    }

    public void m(int i) {
        if (this.o == i) {
            return;
        }
        this.o = i;
        SkinManager.setViewTextColor(this.f21844f, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f21845g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f21846h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(this.i, R.drawable.icon_news_down_bar_one);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
    }

    public final void n(int i) {
        Context context = this.f21843e;
        BdToast.i(context, String.format(context.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public final void o(String str, String str2, String str3, String str4) {
        this.f21844f.setText(str);
        this.f21846h.setText(str2);
        this.k.setText(str4);
        this.m.setText(str3);
    }

    public void setData(UserData userData) {
        this.q = userData;
        if (userData.getConcernNum() >= 9999000) {
            this.f21844f.setTextSize(0, l.g(this.f21843e, R.dimen.ds32));
        }
        if (this.q.getFansNum() >= 9999000) {
            this.f21846h.setTextSize(0, l.g(this.f21843e, R.dimen.ds32));
        }
        if (this.q.getLike_bars() >= 9999000) {
            this.k.setTextSize(0, l.g(this.f21843e, R.dimen.ds32));
        }
        if (this.q.getPosts_num() >= 9999000) {
            this.m.setTextSize(0, l.g(this.f21843e, R.dimen.ds32));
        }
        o(StringHelper.numFormatOverWanNa(this.q.getConcernNum()), StringHelper.numFormatOverWanNa(this.q.getFansNum()), StringHelper.numFormatOverWanNa(this.q.getPosts_num()), StringHelper.numFormatOverWanNa(this.q.getLike_bars()));
    }

    public void setOnViewResponseListener(f fVar) {
        this.p = fVar;
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = -1;
        this.u = new a();
        l(context);
        k();
        m(0);
    }

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.o = -1;
        this.u = new a();
        l(context);
        k();
        m(0);
    }
}
