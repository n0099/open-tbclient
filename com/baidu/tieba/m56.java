package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class m56 implements x36 {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> a;
    public int b;
    public View c;
    public TbImageView d;
    public View e;
    public TextView f;
    public EMTextView g;
    public EMTextView h;
    public EMTextView i;
    public TbImageView j;
    public int k;
    public t36 l;
    public SdkLiveInfoData m;
    public int n;
    public int o;
    public int p;
    public int q;
    public final View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m56 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public a(m56 m56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m56Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                m56 m56Var = this.a;
                this.a.j.setLayoutParams(new RelativeLayout.LayoutParams(m56Var.i(m56Var.j.getLoadedHeight(), this.a.j.getLoadedWidth()), m56.s));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m56 a;

        public b(m56 m56Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m56Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m56Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (y36.d(this.a.m)) {
                    if ((this.a.a.getPageActivity() instanceof s36) && ((s36) this.a.a.getPageActivity()).Y0()) {
                        s56.b(this.a.l, ((s36) this.a.a.getPageActivity()).getFrom());
                        str2 = YYLiveUtil.SOURCE_FORUM_USER_LIVE_PAGE;
                    } else if (this.a.l.b) {
                        str2 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.a.b;
                    } else {
                        str2 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.a.b;
                    }
                    y36.i(this.a.a, this.a.m, str2);
                }
                if (this.a.l != null && this.a.l.b) {
                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
                    if (this.a.m != null) {
                        statisticItem.param("tid", this.a.m.tid);
                        statisticItem.param("fid", this.a.l.c);
                        statisticItem.param("fname", this.a.l.d);
                    }
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_locate", this.a.p);
                    if (this.a.m != null && this.a.m.liveInfo != null) {
                        int a = y36.a(this.a.m.liveInfo);
                        if (this.a.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, y36.j(this.a.m.liveInfo.yyExt, this.a.m.roomId));
                            str = TiebaStatic.YYValues.YY_LIVE;
                        } else {
                            str = "";
                        }
                        statisticItem.param("obj_param1", a);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                    }
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947923707, "Lcom/baidu/tieba/m56;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947923707, "Lcom/baidu/tieba/m56;");
                return;
            }
        }
        s = ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds55);
    }

    @Override // com.baidu.tieba.x36
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return (View) invokeV.objValue;
    }

    public m56(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = 3;
        this.n = 0;
        this.o = 2;
        this.p = 6;
        this.q = 9;
        this.r = new b(this);
        this.a = tbPageContext;
        this.b = i;
        j(tbPageContext);
    }

    @Override // com.baidu.tieba.x36
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) && this.k != i) {
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0109);
            r25 d = r25.d(this.c);
            d.n(0);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0201);
            this.k = i;
        }
    }

    @Override // com.baidu.tieba.x36
    public void a(t36 t36Var) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, t36Var) == null) {
            if (t36Var != null && t36Var.a != null) {
                getView().setVisibility(0);
                this.l = t36Var;
                this.m = t36Var.a;
                int l = ii.l(this.c.getContext());
                if (l != this.n) {
                    ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
                    int l2 = ii.l(this.c.getContext()) - this.c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds20);
                    int dimensionPixelSize = this.c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds34);
                    int i = this.o;
                    int i2 = l2 - (dimensionPixelSize * i);
                    if (layoutParams == null) {
                        layoutParams = new ViewGroup.LayoutParams(i2 / this.o, -2);
                    } else {
                        layoutParams.width = i2 / i;
                        layoutParams.height = -2;
                    }
                    this.c.setLayoutParams(layoutParams);
                    ViewGroup.LayoutParams layoutParams2 = this.d.getLayoutParams();
                    if (layoutParams2 == null) {
                        layoutParams2 = new RelativeLayout.LayoutParams(i2 / this.o, (i2 / 32) * this.q);
                    } else {
                        layoutParams2.width = i2 / this.o;
                        layoutParams2.height = (i2 / 32) * this.q;
                    }
                    this.d.setLayoutParams(layoutParams2);
                    ViewGroup.LayoutParams layoutParams3 = this.e.getLayoutParams();
                    if (layoutParams3 == null) {
                        layoutParams3 = new RelativeLayout.LayoutParams(i2 / this.o, this.c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72));
                    } else {
                        layoutParams3.width = i2 / this.o;
                        layoutParams3.height = this.c.getContext().getResources().getDimensionPixelSize(R.dimen.tbds72);
                    }
                    this.e.setLayoutParams(layoutParams3);
                    this.n = l;
                }
                SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = this.m.liveInfo;
                if (alaLiveInfo2 != null) {
                    if (!TextUtils.isEmpty(alaLiveInfo2.coverWide)) {
                        this.d.N(this.m.liveInfo.coverWide, 10, false);
                    }
                    if (!TextUtils.isEmpty(this.m.liveAuthor.nameShow)) {
                        this.f.setText(this.m.liveAuthor.nameShow);
                    }
                    this.g.setText(StringHelper.numberUniformFormatExtraWithRound(this.m.liveInfo.audienceCount));
                    if (!TextUtils.isEmpty(this.m.title)) {
                        this.h.setText(this.m.title);
                    }
                    if (!TextUtils.isEmpty(this.m.liveInfo.showLabel)) {
                        this.i.setText(this.m.liveInfo.showLabel);
                    }
                    if (!StringUtils.isNull(this.m.labelUrl)) {
                        this.j.setVisibility(0);
                        this.j.N(this.m.labelUrl, 10, false);
                        this.j.setEvent(new a(this));
                    } else {
                        this.j.setVisibility(8);
                    }
                    if (t36Var.b) {
                        StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                        SdkLiveInfoData sdkLiveInfoData = this.m;
                        if (sdkLiveInfoData != null) {
                            statisticItem.param("tid", sdkLiveInfoData.tid);
                            statisticItem.param("fid", t36Var.c);
                            statisticItem.param("fname", t36Var.d);
                        }
                        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        statisticItem.param("obj_locate", this.p);
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                            int a2 = y36.a(alaLiveInfo);
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData3.liveInfo.yyExt;
                            if (yYExt != null) {
                                TiebaStaticHelper.addYYParam(statisticItem, y36.j(yYExt, sdkLiveInfoData3.roomId));
                                str = TiebaStatic.YYValues.YY_LIVE;
                            } else {
                                str = "";
                            }
                            statisticItem.param("obj_param1", a2);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
                        }
                        TiebaStatic.log(statisticItem);
                    }
                }
                if ((this.a.getPageActivity() instanceof s36) && ((s36) this.a.getPageActivity()).Y0()) {
                    s56.c(t36Var, ((s36) this.a.getPageActivity()).getFrom());
                }
                onChangeSkinType(this.a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            getView().setVisibility(4);
        }
    }

    public final int i(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) {
            return (int) (s * (i2 / i));
        }
        return invokeII.intValue;
    }

    public final void j(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, tbPageContext) == null) {
            View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d09b0, (ViewGroup) null, false);
            this.c = inflate;
            TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f09103e);
            this.d = tbImageView;
            tbImageView.setDrawCorner(true);
            this.d.setConrers(3);
            this.d.setRadiusById(R.string.J_X13);
            this.d.setPlaceHolder(2);
            this.e = this.c.findViewById(R.id.obfuscated_res_0x7f091052);
            this.f = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f092317);
            this.g = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f0922f9);
            EMTextView eMTextView = (EMTextView) this.c.findViewById(R.id.text_title);
            this.h = eMTextView;
            r25.d(eMTextView).C(R.string.F_X02);
            this.i = (EMTextView) this.c.findViewById(R.id.obfuscated_res_0x7f092311);
            this.c.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            TbImageView tbImageView2 = (TbImageView) this.c.findViewById(R.id.obfuscated_res_0x7f0920e7);
            this.j = tbImageView2;
            tbImageView2.setDrawCorner(true);
            this.j.setConrers(1);
            this.j.setRadius((int) tbPageContext.getResources().getDimension(R.dimen.tbds21));
            r25 d = r25.d(this.c);
            d.n(0);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0201);
            this.c.setOnClickListener(this.r);
        }
    }
}
