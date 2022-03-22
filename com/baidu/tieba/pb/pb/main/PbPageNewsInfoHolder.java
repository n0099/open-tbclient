package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import c.a.d.a.j;
import c.a.d.f.p.n;
import c.a.o0.r.r.c1;
import c.a.p0.w2.m.f.o0;
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
/* loaded from: classes5.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;

    /* renamed from: b  reason: collision with root package name */
    public View f34978b;

    /* renamed from: c  reason: collision with root package name */
    public RelativeLayout f34979c;

    /* renamed from: d  reason: collision with root package name */
    public TbImageView f34980d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f34981e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f34982f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f34983g;

    /* renamed from: h  reason: collision with root package name */
    public LinearLayout f34984h;
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
    public o0 t;
    public b u;
    public View.OnClickListener v;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbPageNewsInfoHolder a;

        public a(PbPageNewsInfoHolder pbPageNewsInfoHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbPageNewsInfoHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbPageNewsInfoHolder;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && ViewHelper.checkUpIsLogin(this.a.r.getPageActivity()) && n.C()) {
                if (this.a.u != null) {
                    this.a.u.a(this.a.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.a;
                if (view == pbPageNewsInfoHolder.f34979c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(this.a.o.a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.r.getPageActivity()), new String[]{this.a.o.a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.a.o.a));
                } else if (view == pbPageNewsInfoHolder.f34984h) {
                    BdLog.e("link: " + this.a.p.a);
                    if (this.a.p == null || TextUtils.isEmpty(this.a.p.a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.r.getPageActivity()), new String[]{this.a.p.a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.a.p.a));
                } else if (view != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(this.a.q.a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) j.a(this.a.r.getPageActivity()), new String[]{this.a.q.a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.a.q.a));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(o0 o0Var);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        this.a = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f091704);
        this.f34978b = view.findViewById(R.id.obfuscated_res_0x7f0916e5);
        this.f34979c = (RelativeLayout) view.findViewById(R.id.obfuscated_res_0x7f091730);
        this.f34980d = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f0920ac);
        this.f34981e = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920aa);
        this.f34982f = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920a8);
        this.f34983g = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0920a7);
        this.f34984h = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f09156b);
        this.i = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f09156c);
        this.j = (TextView) view.findViewById(R.id.obfuscated_res_0x7f09156d);
        this.k = (LinearLayout) view.findViewById(R.id.obfuscated_res_0x7f090c3f);
        this.l = (ImageView) view.findViewById(R.id.obfuscated_res_0x7f090c40);
        this.m = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090c41);
        this.n = view.findViewById(R.id.obfuscated_res_0x7f091703);
        k(this.v);
    }

    public void i(o0 o0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, o0Var) == null) || o0Var == null) {
            return;
        }
        this.t = o0Var;
        c1 c1Var = o0Var.E0;
        this.o = c1Var;
        this.p = o0Var.F0;
        this.q = o0Var.G0;
        if (c1Var != null) {
            this.f34980d.J(c1Var.f10826d, 10, false);
            this.f34982f.setText(this.o.f10824b);
            this.f34983g.setText(this.o.f10827e);
            this.f34981e.setText(this.o.f10828f);
            SkinManager.setBackgroundResource(this.f34981e, R.drawable.obfuscated_res_0x7f081094);
            SkinManager.setViewTextColor(this.f34981e, (int) R.drawable.obfuscated_res_0x7f080e28);
        } else {
            this.f34979c.setVisibility(8);
        }
        c1 c1Var2 = this.p;
        if (c1Var2 != null) {
            this.j.setText(c1Var2.f10824b);
            SkinManager.setBackgroundResource(this.i, R.drawable.icon_frs_news);
        } else {
            this.f34984h.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        c1 c1Var3 = this.q;
        if (c1Var3 != null) {
            this.m.setText(c1Var3.f10824b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.a.setTag(o0Var);
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.s == i) {
            return;
        }
        this.r.getLayoutMode().k(i == 1);
        this.r.getLayoutMode().j(b());
        this.s = i;
    }

    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.f34979c.setOnClickListener(onClickListener);
            this.f34984h.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        }
    }
}
