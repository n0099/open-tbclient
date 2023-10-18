package com.baidu.tieba.pb.pb.main;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.k4;
import com.baidu.tieba.oj9;
import com.baidu.tieba.px4;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class PbPageNewsInfoHolder extends TypeAdapter.ViewHolder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout a;
    public RelativeLayout b;
    public TbImageView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public LinearLayout g;
    public ImageView h;
    public TextView i;
    public LinearLayout j;
    public ImageView k;
    public TextView l;
    public px4 m;
    public px4 n;
    public px4 o;
    public TbPageContext p;
    public int q;
    public oj9 r;
    public b s;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public interface b {
        void a(oj9 oj9Var);
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !ViewHelper.checkUpIsLogin(this.a.p.getPageActivity()) || !BdUtilHelper.isNetOk()) {
                return;
            }
            if (this.a.s != null) {
                this.a.s.a(this.a.r);
            }
            PbPageNewsInfoHolder pbPageNewsInfoHolder = this.a;
            if (view2 == pbPageNewsInfoHolder.b) {
                if (pbPageNewsInfoHolder.m != null && !TextUtils.isEmpty(this.a.m.a)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) k4.a(this.a.p.getPageActivity()), new String[]{this.a.m.a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.a.m.a));
                }
            } else if (view2 == pbPageNewsInfoHolder.g) {
                BdLog.e("link: " + this.a.n.a);
                if (this.a.n != null && !TextUtils.isEmpty(this.a.n.a)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) k4.a(this.a.p.getPageActivity()), new String[]{this.a.n.a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.a.n.a));
                }
            } else if (view2 == pbPageNewsInfoHolder.j && pbPageNewsInfoHolder.o != null && !TextUtils.isEmpty(this.a.o.a)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) k4.a(this.a.p.getPageActivity()), new String[]{this.a.o.a});
                TiebaStatic.log(new StatisticItem("c11408").param("obj_source", this.a.o.a));
            }
        }
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
        this.q = 3;
        this.t = new a(this);
        this.p = tbPageContext;
        this.s = bVar;
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b55);
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b82);
        this.c = (TbImageView) view2.findViewById(R.id.top_code_img);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092631);
        this.e = (TextView) view2.findViewById(R.id.top_code_detail_summary_text);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09262e);
        this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091984);
        this.h = (ImageView) view2.findViewById(R.id.news_info_img);
        this.i = (TextView) view2.findViewById(R.id.news_info_text);
        this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090e05);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090e06);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e07);
        i(this.t);
    }

    public void h(int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) && this.q != i) {
            BDLayoutMode layoutMode = this.p.getLayoutMode();
            if (i == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.p.getLayoutMode().onModeChanged(getView());
            this.q = i;
        }
    }

    public void i(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void g(oj9 oj9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, oj9Var) != null) || oj9Var == null) {
            return;
        }
        this.r = oj9Var;
        px4 px4Var = oj9Var.g1;
        this.m = px4Var;
        this.n = oj9Var.h1;
        this.o = oj9Var.i1;
        if (px4Var != null) {
            this.c.startLoad(px4Var.d, 10, false);
            this.e.setText(this.m.b);
            this.f.setText(this.m.e);
            this.d.setText(this.m.f);
            SkinManager.setBackgroundResource(this.d, R.drawable.obfuscated_res_0x7f0813a4);
            SkinManager.setViewTextColor(this.d, (int) R.drawable.obfuscated_res_0x7f0810f9);
        } else {
            this.b.setVisibility(8);
        }
        px4 px4Var2 = this.n;
        if (px4Var2 != null) {
            this.i.setText(px4Var2.b);
            SkinManager.setBackgroundResource(this.h, R.drawable.icon_frs_news);
        } else {
            this.g.setVisibility(8);
            this.i.setVisibility(8);
            this.h.setVisibility(8);
        }
        px4 px4Var3 = this.o;
        if (px4Var3 != null) {
            this.l.setText(px4Var3.b);
            SkinManager.setBackgroundResource(this.k, R.drawable.icon_frs_game);
        } else {
            this.j.setVisibility(8);
            this.l.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.a.setTag(oj9Var);
    }
}
