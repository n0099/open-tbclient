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
import d.a.c.e.p.l;
import d.a.n0.v3.f;
/* loaded from: classes5.dex */
public class PersonHeaderAttentionView extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public Context f21684e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f21685f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f21686g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21687h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f21688i;
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
        public d.a.n0.k0.a f21689e = new d.a.n0.k0.a();

        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (PersonHeaderAttentionView.this.q == null || view == null || !ViewHelper.checkUpIsLogin(PersonHeaderAttentionView.this.f21684e)) {
                return;
            }
            boolean equals = TbadkCoreApplication.getCurrentAccount().equals(PersonHeaderAttentionView.this.q.getUserId());
            boolean z = PersonHeaderAttentionView.this.q.getIsFriend() == 1;
            int id = view.getId();
            if (id != PersonHeaderAttentionView.this.f21685f.getId() && id != PersonHeaderAttentionView.this.f21686g.getId()) {
                if (id != PersonHeaderAttentionView.this.f21687h.getId() && id != PersonHeaderAttentionView.this.j.getId()) {
                    if (id == PersonHeaderAttentionView.this.k.getId() || id == PersonHeaderAttentionView.this.l.getId()) {
                        TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "10"));
                        if (PersonHeaderAttentionView.this.q.getPersonPrivate() != null) {
                            if (PersonHeaderAttentionView.this.q.getPersonPrivate().s() != 1 && !equals && (!z || PersonHeaderAttentionView.this.q.getPersonPrivate().s() != 2)) {
                                PersonHeaderAttentionView personHeaderAttentionView = PersonHeaderAttentionView.this;
                                personHeaderAttentionView.n(personHeaderAttentionView.q.getSex());
                                return;
                            }
                            this.f21689e.f56586a = 7;
                        } else {
                            PersonHeaderAttentionView personHeaderAttentionView2 = PersonHeaderAttentionView.this;
                            personHeaderAttentionView2.n(personHeaderAttentionView2.q.getSex());
                            return;
                        }
                    }
                } else {
                    TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", "8"));
                    this.f21689e.f56586a = 5;
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12502").param("obj_locate", HomeCfgResponse.ConfigData.GROUP_LAYOUT_TYPE9));
                this.f21689e.f56586a = 4;
            }
            if (PersonHeaderAttentionView.this.p == null) {
                return;
            }
            this.f21689e.f56587b = new Bundle();
            this.f21689e.f56587b.putSerializable(UserData.TYPE_USER, PersonHeaderAttentionView.this.q);
            PersonHeaderAttentionView.this.p.a(view, this.f21689e);
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
        this.f21687h.setOnClickListener(this.u);
        this.j.setOnClickListener(this.u);
        this.f21685f.setOnClickListener(this.u);
        this.f21686g.setOnClickListener(this.u);
        this.k.setOnClickListener(this.u);
        this.l.setOnClickListener(this.u);
        this.m.setOnClickListener(this.u);
        this.n.setOnClickListener(this.u);
    }

    public final void l(Context context) {
        this.f21684e = context;
        setOrientation(0);
        setGravity(16);
        LayoutInflater.from(context).inflate(R.layout.item_person_header_attention_view, (ViewGroup) this, true);
        this.f21687h = (TextView) findViewById(R.id.person_header_fans_num);
        this.j = (TextView) findViewById(R.id.person_header_fans_des);
        this.f21688i = (ImageView) findViewById(R.id.person_header_fans_red_tip);
        this.f21685f = (TextView) findViewById(R.id.person_header_attention_num);
        this.f21686g = (TextView) findViewById(R.id.person_header_attention_des);
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

    public void m(int i2) {
        if (this.o == i2) {
            return;
        }
        this.o = i2;
        SkinManager.setViewTextColor(this.f21685f, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.f21686g, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.f21687h, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.j, R.color.CAM_X0107, 1);
        SkinManager.setImageResource(this.f21688i, R.drawable.icon_news_down_bar_one);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.l, R.color.CAM_X0107, 1);
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0107, 1);
        SkinManager.setBackgroundColor(this.r, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.s, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.t, R.color.CAM_X0204);
    }

    public final void n(int i2) {
        Context context = this.f21684e;
        BdToast.i(context, String.format(context.getString(R.string.person_privacy_toast), StringHelper.getUserDescByGender(i2)), R.drawable.icon_pure_toast_mistake40_svg, true).q();
    }

    public final void o(String str, String str2, String str3, String str4) {
        this.f21685f.setText(str);
        this.f21687h.setText(str2);
        this.k.setText(str4);
        this.m.setText(str3);
    }

    public void setData(UserData userData) {
        this.q = userData;
        if (userData.getConcernNum() >= 9999000) {
            this.f21685f.setTextSize(0, l.g(this.f21684e, R.dimen.ds32));
        }
        if (this.q.getFansNum() >= 9999000) {
            this.f21687h.setTextSize(0, l.g(this.f21684e, R.dimen.ds32));
        }
        if (this.q.getLike_bars() >= 9999000) {
            this.k.setTextSize(0, l.g(this.f21684e, R.dimen.ds32));
        }
        if (this.q.getPosts_num() >= 9999000) {
            this.m.setTextSize(0, l.g(this.f21684e, R.dimen.ds32));
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

    public PersonHeaderAttentionView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.o = -1;
        this.u = new a();
        l(context);
        k();
        m(0);
    }
}
