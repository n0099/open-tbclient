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
import com.repackage.dq4;
import com.repackage.f9;
import com.repackage.mi;
import com.repackage.tv7;
/* loaded from: classes3.dex */
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
    public dq4 o;
    public dq4 p;
    public dq4 q;
    public TbPageContext r;
    public int s;
    public tv7 t;
    public b u;
    public View.OnClickListener v;

    /* loaded from: classes3.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && ViewHelper.checkUpIsLogin(this.a.r.getPageActivity()) && mi.C()) {
                if (this.a.u != null) {
                    this.a.u.a(this.a.t);
                }
                PbPageNewsInfoHolder pbPageNewsInfoHolder = this.a;
                if (view2 == pbPageNewsInfoHolder.c) {
                    if (pbPageNewsInfoHolder.o == null || TextUtils.isEmpty(this.a.o.a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.r.getPageActivity()), new String[]{this.a.o.a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.a.o.a));
                } else if (view2 == pbPageNewsInfoHolder.h) {
                    BdLog.e("link: " + this.a.p.a);
                    if (this.a.p == null || TextUtils.isEmpty(this.a.p.a)) {
                        return;
                    }
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.r.getPageActivity()), new String[]{this.a.p.a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.a.p.a));
                } else if (view2 != pbPageNewsInfoHolder.k || pbPageNewsInfoHolder.q == null || TextUtils.isEmpty(this.a.q.a)) {
                } else {
                    UrlManager.getInstance().dealOneLink((TbPageContext) f9.a(this.a.r.getPageActivity()), new String[]{this.a.q.a});
                    TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.a.q.a));
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(tv7 tv7Var);
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
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f09172a);
        this.b = view2.findViewById(R.id.obfuscated_res_0x7f09170a);
        this.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091756);
        this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0920ed);
        this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920eb);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920e9);
        this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0920e8);
        this.h = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091584);
        this.i = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091585);
        this.j = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091586);
        this.k = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090c39);
        this.l = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090c3a);
        this.m = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090c3b);
        this.n = view2.findViewById(R.id.obfuscated_res_0x7f091729);
        k(this.v);
    }

    public void i(tv7 tv7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tv7Var) == null) || tv7Var == null) {
            return;
        }
        this.t = tv7Var;
        dq4 dq4Var = tv7Var.F0;
        this.o = dq4Var;
        this.p = tv7Var.G0;
        this.q = tv7Var.H0;
        if (dq4Var != null) {
            this.d.K(dq4Var.d, 10, false);
            this.f.setText(this.o.b);
            this.g.setText(this.o.e);
            this.e.setText(this.o.f);
            SkinManager.setBackgroundResource(this.e, R.drawable.obfuscated_res_0x7f0810b5);
            SkinManager.setViewTextColor(this.e, (int) R.drawable.obfuscated_res_0x7f080e50);
        } else {
            this.c.setVisibility(8);
        }
        dq4 dq4Var2 = this.p;
        if (dq4Var2 != null) {
            this.j.setText(dq4Var2.b);
            SkinManager.setBackgroundResource(this.i, R.drawable.icon_frs_news);
        } else {
            this.h.setVisibility(8);
            this.j.setVisibility(8);
            this.i.setVisibility(8);
        }
        dq4 dq4Var3 = this.q;
        if (dq4Var3 != null) {
            this.m.setText(dq4Var3.b);
            SkinManager.setBackgroundResource(this.l, R.drawable.icon_frs_game);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
            this.m.setVisibility(8);
        }
        this.a.setTag(tv7Var);
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
            this.c.setOnClickListener(onClickListener);
            this.h.setOnClickListener(onClickListener);
            this.k.setOnClickListener(onClickListener);
        }
    }
}
