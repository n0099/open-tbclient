package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.b.b.a.j;
import d.b.b.e.p.l;
import d.b.h0.r.q.c1;
import d.b.i0.c2.k.e.g0;
/* loaded from: classes4.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f19742a;

    /* renamed from: b  reason: collision with root package name */
    public View f19743b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19744c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19745d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19746e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19747f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19748g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19749h;
    public ImageView i;
    public TextView j;
    public LinearLayout k;
    public ImageView l;
    public TextView m;
    public View n;
    public c1 o;
    public c1 p;
    public c1 q;
    public TbPageContext r;
    public int s;
    public g0 t;
    public b u;
    public View.OnClickListener v;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(PbPageNewsInfoHolder.this.r.getPageActivity()) && l.C()) {
                if (PbPageNewsInfoHolder.this.u != null) {
                    PbPageNewsInfoHolder.this.u.a(PbPageNewsInfoHolder.this.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = PbPageNewsInfoHolder.this;
                if (view == pbPageNewsInfoHolder.f19744c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.o.f50735a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.o.f50735a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", PbPageNewsInfoHolder.this.o.f50735a));
                } else if (view == pbPageNewsInfoHolder.f19749h) {
                    BdLog.e("link: " + PbPageNewsInfoHolder.this.p.f50735a);
                    if (PbPageNewsInfoHolder.this.p == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.p.f50735a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.p.f50735a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", PbPageNewsInfoHolder.this.p.f50735a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.q.f50735a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.q.f50735a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", PbPageNewsInfoHolder.this.q.f50735a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(g0 g0Var);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        this.s = 3;
        this.v = new a();
        this.r = tbPageContext;
        this.u = bVar;
        this.f19742a = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.f19743b = view.findViewById(R.id.pb_list_item_top_line);
        this.f19744c = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.f19745d = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f19746e = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.f19747f = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f19748g = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.f19749h = (LinearLayout) view.findViewById(R.id.news_info);
        this.i = (ImageView) view.findViewById(R.id.news_info_img);
        this.j = (TextView) view.findViewById(R.id.news_info_text);
        this.k = (LinearLayout) view.findViewById(R.id.game_info);
        this.l = (ImageView) view.findViewById(R.id.game_info_img);
        this.m = (TextView) view.findViewById(R.id.game_info_text);
        this.n = view.findViewById(R.id.pb_news_info_divider);
        j(this.v);
    }

    public void h(g0 g0Var) {
        if (g0Var == null) {
            return;
        }
        this.t = g0Var;
        c1 c1Var = g0Var.w0;
        this.o = c1Var;
        this.p = g0Var.x0;
        this.q = g0Var.y0;
        if (c1Var != null) {
            this.f19745d.W(c1Var.f50738d, 10, false);
            this.f19747f.setText(this.o.f50736b);
            this.f19748g.setText(this.o.f50739e);
            this.f19746e.setText(this.o.f50740f);
            SkinManager.setBackgroundResource(this.f19746e, R.drawable.selector_star_btn_like);
            SkinManager.setViewTextColor(this.f19746e, R.drawable.news_text_color_selector);
        } else {
            this.f19744c.setVisibility(8);
        }
        c1 c1Var2 = this.p;
        if (c1Var2 != null) {
            this.j.setText(c1Var2.f50736b);
            SkinManager.setBackgroundResource(this.i, R.drawable.icon_frs_news);
        } else {
            this.f19749h.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        c1 c1Var3 = this.q;
        if (c1Var3 != null) {
            this.m.setText(c1Var3.f50736b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.f19742a.setTag(g0Var);
    }

    public void i(int i) {
        if (this.s != i) {
            this.r.getLayoutMode().k(i == 1);
            this.r.getLayoutMode().j(a());
            this.s = i;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.f19744c.setOnClickListener(onClickListener);
        this.f19749h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }
}
