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
import com.baidu.tieba.fx7;
import com.baidu.tieba.i9;
import com.baidu.tieba.lq4;
import com.baidu.tieba.ri;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public View b;
    public RelativeLayout c;
    public TbImageView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public LinearLayout h;
    public ImageView i;
    public TextView j;
    public LinearLayout k;
    public ImageView l;
    public TextView m;
    public View n;
    public lq4 o;
    public lq4 p;
    public lq4 q;
    public TbPageContext r;
    public int s;
    public fx7 t;
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
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.r.getPageActivity()) && ri.D()) {
                if (this.a.u != null) {
                    this.a.u.a(this.a.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.a;
                if (view2 == pbPageNewsInfoHolder.c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(this.a.o.a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) i9.a(this.a.r.getPageActivity()), new String[]{this.a.o.a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.a.o.a));
                } else if (view2 == pbPageNewsInfoHolder.h) {
                    BdLog.e("link: " + this.a.p.a);
                    if (this.a.p == null || TextUtils.isEmpty(this.a.p.a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) i9.a(this.a.r.getPageActivity()), new String[]{this.a.p.a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.a.p.a));
                } else if (view2 != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(this.a.q.a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) i9.a(this.a.r.getPageActivity()), new String[]{this.a.q.a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.a.q.a));
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface b {
        void a(fx7 fx7Var);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbPageNewsInfoHolder(TbPageContext tbPageContext, View view2, b bVar) {
        super(view2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, view2, bVar};
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
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091826);
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f091806);
        this.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091852);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f092241);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223f);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223d);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09223c);
        this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091678);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091679);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09167a);
        this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c51);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c52);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c53);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f091825);
        i(this.v);
    }

    public void g(fx7 fx7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, fx7Var) == null) || fx7Var == null) {
            return;
        }
        this.t = fx7Var;
        lq4 lq4Var = fx7Var.T0;
        this.o = lq4Var;
        this.p = fx7Var.U0;
        this.q = fx7Var.V0;
        if (lq4Var != null) {
            this.d.K(lq4Var.d, 10, false);
            this.f.setText(this.o.b);
            this.g.setText(this.o.e);
            this.e.setText(this.o.f);
            SkinManager.setBackgroundResource(this.e, R.drawable.obfuscated_res_0x7f0810a4);
            SkinManager.setViewTextColor(this.e, (int) R.drawable.obfuscated_res_0x7f080e31);
        } else {
            this.c.setVisibility(8);
        }
        lq4 lq4Var2 = this.p;
        if (lq4Var2 != null) {
            this.j.setText(lq4Var2.b);
            SkinManager.setBackgroundResource(this.i, R.drawable.icon_frs_news);
        } else {
            this.h.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        lq4 lq4Var3 = this.q;
        if (lq4Var3 != null) {
            this.m.setText(lq4Var3.b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.a.setTag(fx7Var);
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) || this.s == i) {
            return;
        }
        this.r.getLayoutMode().l(i == 1);
        this.r.getLayoutMode().k(getView());
        this.s = i;
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.c.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        }
    }
}
