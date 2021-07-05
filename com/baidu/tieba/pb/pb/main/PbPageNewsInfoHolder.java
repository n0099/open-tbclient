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
import d.a.c.a.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.d1;
import d.a.s0.h2.k.e.i0;
/* loaded from: classes5.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public LinearLayout f19393a;

    /* renamed from: b  reason: collision with root package name */
    public View f19394b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f19395c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f19396d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f19397e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19398f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f19399g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f19400h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f19401i;
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

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PbPageNewsInfoHolder f19402e;

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
            this.f19402e = pbPageNewsInfoHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.f19402e.r.getPageActivity()) && l.D()) {
                if (this.f19402e.u != null) {
                    this.f19402e.u.a(this.f19402e.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.f19402e;
                if (view == pbPageNewsInfoHolder.f19395c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(this.f19402e.o.f55903a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19402e.r.getPageActivity()), new String[]{this.f19402e.o.f55903a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.f19402e.o.f55903a));
                } else if (view == pbPageNewsInfoHolder.f19400h) {
                    BdLog.e("link: " + this.f19402e.p.f55903a);
                    if (this.f19402e.p == null || TextUtils.isEmpty(this.f19402e.p.f55903a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19402e.r.getPageActivity()), new String[]{this.f19402e.p.f55903a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.f19402e.p.f55903a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(this.f19402e.q.f55903a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.f19402e.r.getPageActivity()), new String[]{this.f19402e.q.f55903a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.f19402e.q.f55903a));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
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
        this.f19393a = (LinearLayout) view.findViewById(R.id.pb_news_info_layout);
        this.f19394b = view.findViewById(R.id.pb_list_item_top_line);
        this.f19395c = (RelativeLayout) view.findViewById(R.id.pb_top_code);
        this.f19396d = (TbImageView) view.findViewById(R.id.top_code_img);
        this.f19397e = (TextView) view.findViewById(R.id.top_code_get_btn);
        this.f19398f = (TextView) view.findViewById(R.id.top_code_detail_summary_text);
        this.f19399g = (TextView) view.findViewById(R.id.top_code_detail_subtitle_text);
        this.f19400h = (LinearLayout) view.findViewById(R.id.news_info);
        this.f19401i = (ImageView) view.findViewById(R.id.news_info_img);
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
            this.f19396d.M(d1Var.f55906d, 10, false);
            this.f19398f.setText(this.o.f55904b);
            this.f19399g.setText(this.o.f55907e);
            this.f19397e.setText(this.o.f55908f);
            SkinManager.setBackgroundResource(this.f19397e, R.drawable.selector_star_btn_like);
            SkinManager.setViewTextColor(this.f19397e, R.drawable.news_text_color_selector);
        } else {
            this.f19395c.setVisibility(8);
        }
        d1 d1Var2 = this.p;
        if (d1Var2 != null) {
            this.j.setText(d1Var2.f55904b);
            SkinManager.setBackgroundResource(this.f19401i, R.drawable.icon_frs_news);
        } else {
            this.f19400h.setVisibility(8);
            this.j.setVisibility(8);
            this.f19401i.setVisibility(8);
        }
        d1 d1Var3 = this.q;
        if (d1Var3 != null) {
            this.m.setText(d1Var3.f55904b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.f19393a.setTag(i0Var);
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
            this.f19395c.setOnClickListener(onClickListener);
            this.f19400h.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        }
    }
}
