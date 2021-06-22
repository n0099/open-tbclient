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
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.n0.r.q.c1;
import d.a.o0.e2.k.e.i0;
/* loaded from: classes5.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f19266a;

    /* renamed from: b  reason: collision with root package name */
    public View f19267b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19268c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19269d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19270e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19271f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19272g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19273h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19274i;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ViewHelper.checkUpIsLogin(PbPageNewsInfoHolder.this.r.getPageActivity()) && l.D()) {
                if (PbPageNewsInfoHolder.this.u != null) {
                    PbPageNewsInfoHolder.this.u.a(PbPageNewsInfoHolder.this.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = PbPageNewsInfoHolder.this;
                if (view == pbPageNewsInfoHolder.f19268c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.o.f53748a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.o.f53748a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", PbPageNewsInfoHolder.this.o.f53748a));
                } else if (view == pbPageNewsInfoHolder.f19273h) {
                    BdLog.e("link: " + PbPageNewsInfoHolder.this.p.f53748a);
                    if (PbPageNewsInfoHolder.this.p == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.p.f53748a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.p.f53748a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", PbPageNewsInfoHolder.this.p.f53748a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(PbPageNewsInfoHolder.this.q.f53748a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(PbPageNewsInfoHolder.this.r.getPageActivity()), new String[]{PbPageNewsInfoHolder.this.q.f53748a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", PbPageNewsInfoHolder.this.q.f53748a));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(i0 i0Var);
    }

    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        this.s = 3;
        this.v = new a();
        this.r = tbPageContext;
        this.u = bVar;
        this.f19266a = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.f19267b = view.findViewById(R.id.pb_list_item_top_line);
        this.f19268c = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.f19269d = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f19270e = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.f19271f = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f19272g = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.f19273h = (LinearLayout) view.findViewById(R.id.news_info);
        this.f19274i = (ImageView) view.findViewById(R.id.news_info_img);
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
        c1 c1Var = i0Var.C0;
        this.o = c1Var;
        this.p = i0Var.D0;
        this.q = i0Var.E0;
        if (c1Var != null) {
            this.f19269d.U(c1Var.f53751d, 10, false);
            this.f19271f.setText(this.o.f53749b);
            this.f19272g.setText(this.o.f53752e);
            this.f19270e.setText(this.o.f53753f);
            SkinManager.setBackgroundResource(this.f19270e, R.drawable.selector_star_btn_like);
            SkinManager.setViewTextColor(this.f19270e, R.drawable.news_text_color_selector);
        } else {
            this.f19268c.setVisibility(8);
        }
        c1 c1Var2 = this.p;
        if (c1Var2 != null) {
            this.j.setText(c1Var2.f53749b);
            SkinManager.setBackgroundResource(this.f19274i, R.drawable.icon_frs_news);
        } else {
            this.f19273h.setVisibility(8);
            this.j.setVisibility(8);
            this.f19274i.setVisibility(8);
        }
        c1 c1Var3 = this.q;
        if (c1Var3 != null) {
            this.m.setText(c1Var3.f53749b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.f19266a.setTag(i0Var);
    }

    public void i(int i2) {
        if (this.s != i2) {
            this.r.getLayoutMode().k(i2 == 1);
            this.r.getLayoutMode().j(a());
            this.s = i2;
        }
    }

    public void j(View.OnClickListener onClickListener) {
        this.f19268c.setOnClickListener(onClickListener);
        this.f19273h.setOnClickListener(onClickListener);
        this.k.setOnClickListener(onClickListener);
    }
}
