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
import com.baidu.tieba.c35;
import com.baidu.tieba.l9;
import com.baidu.tieba.tl9;
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
    public c35 m;
    public c35 n;
    public c35 o;
    public TbPageContext p;
    public int q;
    public tl9 r;
    public b s;
    public View.OnClickListener t;

    /* loaded from: classes7.dex */
    public interface b {
        void a(tl9 tl9Var);
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
                    UrlManager.getInstance().dealOneLink((TbPageContext) l9.a(this.a.p.getPageActivity()), new String[]{this.a.m.a});
                    TiebaStatic.log(new StatisticItem("c11410").param("obj_source", this.a.m.a));
                }
            } else if (view2 == pbPageNewsInfoHolder.g) {
                BdLog.e("link: " + this.a.n.a);
                if (this.a.n != null && !TextUtils.isEmpty(this.a.n.a)) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) l9.a(this.a.p.getPageActivity()), new String[]{this.a.n.a});
                    TiebaStatic.log(new StatisticItem("c11409").param("obj_source", this.a.n.a));
                }
            } else if (view2 == pbPageNewsInfoHolder.j && pbPageNewsInfoHolder.o != null && !TextUtils.isEmpty(this.a.o.a)) {
                UrlManager.getInstance().dealOneLink((TbPageContext) l9.a(this.a.p.getPageActivity()), new String[]{this.a.o.a});
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
        this.a = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b27);
        this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091b54);
        this.c = (TbImageView) view2.findViewById(R.id.top_code_img);
        this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092619);
        this.e = (TextView) view2.findViewById(R.id.top_code_detail_summary_text);
        this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092616);
        this.g = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f091955);
        this.h = (ImageView) view2.findViewById(R.id.news_info_img);
        this.i = (TextView) view2.findViewById(R.id.news_info_text);
        this.j = (LinearLayout) view2.findViewById(R.id.obfuscated_res_0x7f090df2);
        this.k = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f090df3);
        this.l = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090df4);
        j(this.t);
    }

    public void i(int i) {
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

    public void j(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.b.setOnClickListener(onClickListener);
            this.g.setOnClickListener(onClickListener);
            this.j.setOnClickListener(onClickListener);
        }
    }

    public void h(tl9 tl9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tl9Var) != null) || tl9Var == null) {
            return;
        }
        this.r = tl9Var;
        c35 c35Var = tl9Var.f1;
        this.m = c35Var;
        this.n = tl9Var.g1;
        this.o = tl9Var.h1;
        if (c35Var != null) {
            this.c.startLoad(c35Var.d, 10, false);
            this.e.setText(this.m.b);
            this.f.setText(this.m.e);
            this.d.setText(this.m.f);
            SkinManager.setBackgroundResource(this.d, R.drawable.obfuscated_res_0x7f081388);
            SkinManager.setViewTextColor(this.d, (int) R.drawable.obfuscated_res_0x7f0810de);
        } else {
            this.b.setVisibility(8);
        }
        c35 c35Var2 = this.n;
        if (c35Var2 != null) {
            this.i.setText(c35Var2.b);
            SkinManager.setBackgroundResource(this.h, R.drawable.icon_frs_news);
        } else {
            this.g.setVisibility(8);
            this.i.setVisibility(8);
            this.h.setVisibility(8);
        }
        c35 c35Var3 = this.o;
        if (c35Var3 != null) {
            this.l.setText(c35Var3.b);
            SkinManager.setBackgroundResource(this.k, R.drawable.icon_frs_game);
        } else {
            this.j.setVisibility(8);
            this.l.setVisibility(8);
            this.l.setVisibility(8);
        }
        this.a.setTag(tl9Var);
    }
}
