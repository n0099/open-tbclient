package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.a.j;
import d.a.d.e.p.l;
import d.a.p0.s.q.d1;
import d.a.q0.h2.k.e.i0;
/* loaded from: classes4.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f19523a;

    /* renamed from: b  reason: collision with root package name */
    public View f19524b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19525c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19526d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19527e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19528f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19529g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19530h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19531i;
    public TextView j;
    public LinearLayout k;
    public ImageView l;
    public TextView m;
    public View n;
    public d1 o;
    public d1 p;
    public d1 q;
    public TbPageContext r;
    public int s;
    public i0 t;
    public b u;
    public View.OnClickListener v;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbPageNewsInfoHolder f19532e;

        public a(PbPageNewsInfoHolder pbPageNewsInfoHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbPageNewsInfoHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19532e = pbPageNewsInfoHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f19532e.r.getPageActivity()) && l.D()) {
                if (this.f19532e.u != null) {
                    this.f19532e.u.a(this.f19532e.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.f19532e;
                if (view == pbPageNewsInfoHolder.f19525c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(this.f19532e.o.f53282a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19532e.r.getPageActivity()), new String[]{this.f19532e.o.f53282a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.f19532e.o.f53282a));
                } else if (view == pbPageNewsInfoHolder.f19530h) {
                    BdLog.e("link: " + this.f19532e.p.f53282a);
                    if (this.f19532e.p == null || TextUtils.isEmpty(this.f19532e.p.f53282a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19532e.r.getPageActivity()), new String[]{this.f19532e.p.f53282a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.f19532e.p.f53282a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(this.f19532e.q.f53282a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19532e.r.getPageActivity()), new String[]{this.f19532e.q.f53282a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.f19532e.q.f53282a));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(i0 i0Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view, b bVar) {
        super(view);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((View) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.s = 3;
        this.v = new a(this);
        this.r = tbPageContext;
        this.u = bVar;
        this.f19523a = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.f19524b = view.findViewById(R.id.pb_list_item_top_line);
        this.f19525c = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.f19526d = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f19527e = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.f19528f = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f19529g = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.f19530h = (LinearLayout) view.findViewById(R.id.news_info);
        this.f19531i = (ImageView) view.findViewById(R.id.news_info_img);
        this.j = (TextView) view.findViewById(R.id.news_info_text);
        this.k = (LinearLayout) view.findViewById(R.id.game_info);
        this.l = (ImageView) view.findViewById(R.id.game_info_img);
        this.m = (TextView) view.findViewById(R.id.game_info_text);
        this.n = view.findViewById(R.id.pb_news_info_divider);
        j(this.v);
    }

    public void h(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, i0Var) == null) || i0Var == null) {
            return;
        }
        this.t = i0Var;
        d1 d1Var = i0Var.C0;
        this.o = d1Var;
        this.p = i0Var.D0;
        this.q = i0Var.E0;
        if (d1Var != null) {
            this.f19526d.M(d1Var.f53285d, 10, false);
            this.f19528f.setText(this.o.f53283b);
            this.f19529g.setText(this.o.f53286e);
            this.f19527e.setText(this.o.f53287f);
            SkinManager.setBackgroundResource(this.f19527e, R.drawable.selector_star_btn_like);
            SkinManager.setViewTextColor(this.f19527e, R.drawable.news_text_color_selector);
        } else {
            this.f19525c.setVisibility(8);
        }
        d1 d1Var2 = this.p;
        if (d1Var2 != null) {
            this.j.setText(d1Var2.f53283b);
            SkinManager.setBackgroundResource(this.f19531i, R.drawable.icon_frs_news);
        } else {
            this.f19530h.setVisibility(8);
            this.j.setVisibility(8);
            this.f19531i.setVisibility(8);
        }
        d1 d1Var3 = this.q;
        if (d1Var3 != null) {
            this.m.setText(d1Var3.f53283b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.f19523a.setTag(i0Var);
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) || this.s == i2) {
            return;
        }
        this.r.getLayoutMode().k(i2 == 1);
        this.r.getLayoutMode().j(a());
        this.s = i2;
    }

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f19525c.setOnClickListener(onClickListener);
            this.f19530h.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        }
    }
}
