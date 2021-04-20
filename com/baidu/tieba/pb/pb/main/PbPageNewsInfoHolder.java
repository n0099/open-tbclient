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
import d.b.c.a.j;
import d.b.c.e.p.l;
import d.b.h0.r.q.c1;
import d.b.i0.d2.k.e.i0;
/* loaded from: classes3.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f19427a;

    /* renamed from: b  reason: collision with root package name */
    public View f19428b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19429c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19430d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19431e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19432f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19433g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19434h;
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
    public i0 t;
    public b u;
    public View.OnClickListener v;

    /* loaded from: classes3.dex */
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
                if (view == pbPageNewsInfoHolder.f19429c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.o.f51142a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.o.f51142a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", PbPageNewsInfoHolder.this.o.f51142a));
                } else if (view == pbPageNewsInfoHolder.f19434h) {
                    BdLog.e("link: " + PbPageNewsInfoHolder.this.p.f51142a);
                    if (PbPageNewsInfoHolder.this.p == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.p.f51142a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.p.f51142a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", PbPageNewsInfoHolder.this.p.f51142a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.q.f51142a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.q.f51142a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", PbPageNewsInfoHolder.this.q.f51142a));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(i0 i0Var);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        this.s = 3;
        this.v = new a();
        this.r = tbPageContext;
        this.u = bVar;
        this.f19427a = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.f19428b = view.findViewById(R.id.pb_list_item_top_line);
        this.f19429c = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.f19430d = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f19431e = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.f19432f = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f19433g = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.f19434h = (LinearLayout) view.findViewById(R.id.news_info);
        this.i = (ImageView) view.findViewById(R.id.news_info_img);
        this.j = (TextView) view.findViewById(R.id.news_info_text);
        this.k = (LinearLayout) view.findViewById(R.id.game_info);
        this.l = (ImageView) view.findViewById(R.id.game_info_img);
        this.m = (TextView) view.findViewById(R.id.game_info_text);
        this.n = view.findViewById(R.id.pb_news_info_divider);
        j(this.v);
    }

    public void h(i0 i0Var) {
        if (i0Var == null) {
            return;
        }
        this.t = i0Var;
        c1 c1Var = i0Var.x0;
        this.o = c1Var;
        this.p = i0Var.y0;
        this.q = i0Var.z0;
        if (c1Var != null) {
            this.f19430d.W(c1Var.f51145d, 10, false);
            this.f19432f.setText(this.o.f51143b);
            this.f19433g.setText(this.o.f51146e);
            this.f19431e.setText(this.o.f51147f);
            SkinManager.setBackgroundResource(this.f19431e, R.drawable.selector_star_btn_like);
            SkinManager.setViewTextColor(this.f19431e, R.drawable.news_text_color_selector);
        } else {
            this.f19429c.setVisibility(8);
        }
        c1 c1Var2 = this.p;
        if (c1Var2 != null) {
            this.j.setText(c1Var2.f51143b);
            SkinManager.setBackgroundResource(this.i, R.drawable.icon_frs_news);
        } else {
            this.f19434h.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        c1 c1Var3 = this.q;
        if (c1Var3 != null) {
            this.m.setText(c1Var3.f51143b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.f19427a.setTag(i0Var);
    }

    public void i(int i) {
        if (this.s != i) {
            this.r.getLayoutMode().k(i == 1);
            this.r.getLayoutMode().j(a());
            this.s = i;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.f19429c.setOnClickListener(onClickListener);
        this.f19434h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }
}
