package com.baidu.tieba;

import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
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
public class qs5 implements cr5 {
    public static /* synthetic */ Interceptable $ic;
    public static final int s;
    public static final float t;
    public static final int u;
    public static final int v;
    public static final float[] w;
    public static final float[] x;
    public static final float[] y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public TbPageContext<?> c;
    public View d;
    public TbImageView e;
    public EMTextView f;
    public TextView g;
    public EMTextView h;
    public LinearLayout i;
    public TbImageView j;
    public TbImageView k;
    public oq5 l;
    public SdkLiveInfoData m;
    public String n;
    public int o;
    public int p;
    public int q;
    public View.OnClickListener r;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs5 a;

        public a(qs5 qs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                qs5 qs5Var = this.a;
                this.a.j.setLayoutParams(new RelativeLayout.LayoutParams(qs5Var.i(qs5Var.j.getLoadedHeight(), this.a.j.getLoadedWidth()), qs5.s));
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs5 a;

        public b(qs5 qs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs5Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                qs5 qs5Var = this.a;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(qs5Var.i(qs5Var.k.getLoadedHeight(), this.a.k.getLoadedWidth()), qs5.s);
                layoutParams.addRule(11);
                layoutParams.rightMargin = this.a.c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
                this.a.k.setLayoutParams(layoutParams);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qs5 a;

        public c(qs5 qs5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qs5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qs5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                boolean d = dr5.d(this.a.m);
                String str4 = TiebaStatic.YYValues.YY_LIVE;
                if (d) {
                    if (!(this.a.c.getPageActivity() instanceof nq5) || !((nq5) this.a.c.getPageActivity()).n0()) {
                        if (this.a.l.b) {
                            str3 = YYLiveUtil.SOURCE_FRS_LIVE_CARD_ + this.a.p;
                        } else {
                            str3 = YYLiveUtil.SOURCE_HOME_LIVE_TAB_CARD_ + this.a.p;
                        }
                    } else {
                        us5.b(this.a.l, ((nq5) this.a.c.getPageActivity()).getFrom());
                        str3 = YYLiveUtil.SOURCE_FORUM_USER_LIVE_PAGE;
                    }
                    dr5.i(this.a.c, this.a.m, str3);
                    if (!dr5.d(this.a.m) || this.a.l == null) {
                        return;
                    }
                    if (this.a.l.b) {
                        this.a.k();
                        return;
                    }
                    StatisticItem statisticItem = new StatisticItem("c13557");
                    statisticItem.param("obj_locate", this.a.l.e);
                    statisticItem.param("obj_param1", this.a.m.liveId);
                    if (this.a.m.liveInfo != null) {
                        int a = dr5.a(this.a.m.liveInfo);
                        if (this.a.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem, dr5.j(this.a.m.liveInfo.yyExt, this.a.m.roomId));
                        } else {
                            str4 = "";
                        }
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, a);
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem.param("nid", this.a.m.nid);
                    statisticItem.param(TiebaStatic.Params.LOGID, this.a.m.logid);
                    TiebaStatic.log(statisticItem);
                } else if (dr5.c(this.a.m)) {
                    if (103 == this.a.p) {
                        StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_CLICK);
                        statisticItem2.param("obj_locate", 3);
                        statisticItem2.param("obj_param1", this.a.m.liveId);
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                        TiebaStatic.log(statisticItem2);
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_FRIEND;
                    } else {
                        str2 = AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN;
                    }
                    dr5.e(this.a.c, this.a.m, str2);
                } else {
                    dr5.g(this.a.c.getPageActivity(), this.a.m);
                    if (this.a.l == null || this.a.m == null) {
                        return;
                    }
                    if (this.a.l.b) {
                        StatisticItem statisticItem3 = new StatisticItem("c13611");
                        statisticItem3.param("obj_param1", this.a.m.liveId);
                        statisticItem3.param("fid", this.a.l.c);
                        statisticItem3.param("fname", this.a.l.d);
                        statisticItem3.param("obj_locate", this.a.l.e);
                        if (this.a.m != null && this.a.m.uiTransParam != null) {
                            statisticItem3.param("ab_tag", this.a.m.uiTransParam.abTag);
                            statisticItem3.param(TiebaStatic.Params.STAR_ID, this.a.m.uiTransParam.starId);
                            statisticItem3.param("extra", this.a.m.uiTransParam.extra);
                            statisticItem3.param("source_from", this.a.m.uiTransParam.sourceFrom);
                        }
                        TiebaStatic.log(statisticItem3);
                        this.a.k();
                        return;
                    }
                    StatisticItem statisticItem4 = new StatisticItem("c13557");
                    if (101 == this.a.p) {
                        str = "推荐";
                    } else if (102 == this.a.p) {
                        str = "颜值";
                    } else {
                        str = 103 == this.a.p ? "交友" : "";
                    }
                    if (this.a.m.liveInfo != null) {
                        int a2 = dr5.a(this.a.m.liveInfo);
                        if (this.a.m.liveInfo.yyExt != null) {
                            TiebaStaticHelper.addYYParam(statisticItem4, dr5.j(this.a.m.liveInfo.yyExt, this.a.m.roomId));
                        } else {
                            str4 = "";
                        }
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM2, a2);
                        statisticItem4.param(TiebaStatic.Params.OBJ_PARAM3, str4);
                    }
                    statisticItem4.param("obj_param1", this.a.m.liveId);
                    statisticItem4.param(TiebaStatic.Params.ENTRY_NAME, str);
                    statisticItem4.param("nid", this.a.m.nid);
                    statisticItem4.param(TiebaStatic.Params.LOGID, this.a.m.logid);
                    TiebaStatic.log(statisticItem4);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948102422, "Lcom/baidu/tieba/qs5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948102422, "Lcom/baidu/tieba/qs5;");
                return;
            }
        }
        s = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        t = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
        u = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds12);
        v = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds44);
        float f = t;
        w = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, f, f};
        x = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, f};
        y = new float[]{0.0f, 0.0f, 0.0f, 0.0f, f, f, 0.0f, 0.0f};
    }

    public qs5(TbPageContext<?> tbPageContext, int i) {
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
        this.a = 3;
        this.b = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
        this.o = 0;
        this.r = new c(this);
        this.c = tbPageContext;
        this.p = i;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d082a, (ViewGroup) null, false);
        this.d = inflate;
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.obfuscated_res_0x7f090ea4);
        this.e = tbImageView;
        tbImageView.setBorderSurroundContent(true);
        this.e.setDrawBorder(true);
        this.e.setPlaceHolder(2);
        this.e.setBorderWidth(ri.f(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0922fb);
        this.g = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f092308);
        this.i = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f0922fa);
        this.j = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091369);
        this.k = (TbImageView) this.d.findViewById(R.id.obfuscated_res_0x7f091395);
        this.h = (EMTextView) this.d.findViewById(R.id.obfuscated_res_0x7f0922fd);
        this.d.setOnClickListener(this.r);
        this.q = ((ri.k(TbadkCoreApplication.getInst()) - u) - (v * 2)) / 2;
    }

    @Override // com.baidu.tieba.cr5
    public void a(oq5 oq5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, oq5Var) == null) {
            l(oq5Var, -1);
        }
    }

    @Override // com.baidu.tieba.cr5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public final int i(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i, i2)) == null) ? (int) (s * (i2 / i)) : invokeII.intValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.M_H_X002);
            this.h.setGravity(16);
            this.h.setLayoutParams(layoutParams);
        }
    }

    public final void k() {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_CLICK);
            SdkLiveInfoData sdkLiveInfoData = this.m;
            if (sdkLiveInfoData != null) {
                statisticItem.param("tid", sdkLiveInfoData.tid);
                statisticItem.param("fid", this.l.c);
                statisticItem.param("fname", this.l.d);
            }
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_locate", 6);
            SdkLiveInfoData sdkLiveInfoData2 = this.m;
            if (sdkLiveInfoData2 != null && (alaLiveInfo = sdkLiveInfoData2.liveInfo) != null) {
                int a2 = dr5.a(alaLiveInfo);
                SdkLiveInfoData sdkLiveInfoData3 = this.m;
                SdkLiveInfoData.YYExt yYExt = sdkLiveInfoData3.liveInfo.yyExt;
                if (yYExt != null) {
                    TiebaStaticHelper.addYYParam(statisticItem, dr5.j(yYExt, sdkLiveInfoData3.roomId));
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

    public void l(oq5 oq5Var, int i) {
        String str;
        SdkLiveInfoData.UiTransParam uiTransParam;
        String str2;
        SdkLiveInfoData.YYExt yYExt;
        String str3;
        SdkLiveInfoData.YYExt yYExt2;
        String str4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, oq5Var, i) == null) {
            int k = ri.k(this.d.getContext());
            if (k != this.o) {
                ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
                if (layoutParams == null) {
                    int i2 = this.q;
                    layoutParams = new ViewGroup.LayoutParams(i2, i2);
                } else {
                    int i3 = this.q;
                    layoutParams.width = i3;
                    layoutParams.height = i3;
                }
                this.d.setLayoutParams(layoutParams);
                this.o = k;
            }
            if (oq5Var != null && oq5Var.a != null) {
                getView().setVisibility(0);
                this.l = oq5Var;
                this.m = oq5Var.a;
                GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.b);
                String str5 = this.m.liveInfo.cover;
                this.n = str5;
                this.e.setTag(str5);
                int i4 = 5;
                if (oq5Var.f) {
                    this.e.setConrers(5);
                    gradientDrawable.setCornerRadii(x);
                    this.e.setPlaceHolder(2);
                } else if (oq5Var.g) {
                    this.e.setConrers(10);
                    gradientDrawable.setCornerRadii(y);
                    this.e.setPlaceHolder(2);
                } else if (oq5Var.h) {
                    this.e.setConrers(15);
                    gradientDrawable.setCornerRadii(w);
                    this.e.setPlaceHolder(2);
                }
                this.e.setRadius((int) t);
                TbImageView tbImageView = this.e;
                String str6 = this.m.liveInfo.cover;
                int i5 = this.q;
                tbImageView.J(str6, 10, i5, i5, false, false);
                this.i.setBackgroundDrawable(gradientDrawable);
                long j = this.m.liveInfo.audienceCount;
                if (j <= 0) {
                    this.f.setVisibility(8);
                    if (this.h.getVisibility() == 0) {
                        m();
                    }
                } else {
                    String numberUniformFormatExtraWithRound = StringHelper.numberUniformFormatExtraWithRound(j);
                    this.f.setVisibility(0);
                    this.f.setText(numberUniformFormatExtraWithRound);
                    j();
                }
                if (103 == this.p) {
                    if (!StringUtils.isNull(this.m.title)) {
                        this.g.setText(this.m.title);
                    }
                } else if (!StringUtils.isNull(this.m.liveAuthor.nameShow)) {
                    this.g.setText(this.m.liveAuthor.nameShow);
                }
                if (!StringUtils.isNull(this.m.labelUrl)) {
                    this.j.setVisibility(0);
                    this.j.K(this.m.labelUrl, 10, false);
                    this.j.setEvent(new a(this));
                } else {
                    this.j.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.modeUrl)) {
                    this.k.setVisibility(0);
                    this.k.K(this.m.modeUrl, 10, false);
                    this.k.setEvent(new b(this));
                } else {
                    this.k.setVisibility(8);
                }
                if (!StringUtils.isNull(this.m.location)) {
                    this.h.setVisibility(0);
                    if (this.m.location.length() <= 5) {
                        str4 = this.m.location;
                    } else {
                        str4 = this.m.location.substring(0, 5) + StringHelper.STRING_MORE;
                    }
                    this.h.setText(str4);
                } else {
                    this.h.setVisibility(8);
                }
                SdkLiveInfoData sdkLiveInfoData = this.m;
                String str7 = TiebaStatic.YYValues.YY_LIVE;
                if (sdkLiveInfoData != null) {
                    if (i == 2) {
                        StatisticItem param = new StatisticItem("c12899").param("tid", this.m.tid);
                        oq5 oq5Var2 = this.l;
                        if (oq5Var2 != null) {
                            param.param("fid", oq5Var2.c);
                            param.param("fname", this.l.d);
                        }
                        SdkLiveInfoData sdkLiveInfoData2 = this.m;
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData2.liveInfo;
                        if (alaLiveInfo == null || (yYExt2 = alaLiveInfo.yyExt) == null) {
                            str3 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param, yYExt2.toYyExtData(sdkLiveInfoData2.roomId));
                            SdkLiveInfoData sdkLiveInfoData3 = this.m;
                            i4 = sdkLiveInfoData3.liveInfo.yyExt.toYyExtData(sdkLiveInfoData3.roomId).isYyGame ? 3 : 2;
                            str3 = TiebaStatic.YYValues.YY_LIVE;
                        }
                        param.param("obj_param1", i4);
                        param.param(TiebaStatic.Params.OBJ_PARAM2, str3);
                        TiebaStatic.log(param);
                    } else if (i == 1) {
                        StatisticItem param2 = new StatisticItem("c12903").param("tid", this.m.tid);
                        oq5 oq5Var3 = this.l;
                        if (oq5Var3 != null) {
                            param2.param("fid", oq5Var3.c);
                            param2.param("fname", this.l.d);
                        }
                        SdkLiveInfoData sdkLiveInfoData4 = this.m;
                        SdkLiveInfoData.AlaLiveInfo alaLiveInfo2 = sdkLiveInfoData4.liveInfo;
                        if (alaLiveInfo2 == null || (yYExt = alaLiveInfo2.yyExt) == null) {
                            str2 = "";
                        } else {
                            TiebaStaticHelper.addYYParam(param2, yYExt.toYyExtData(sdkLiveInfoData4.roomId));
                            SdkLiveInfoData sdkLiveInfoData5 = this.m;
                            i4 = sdkLiveInfoData5.liveInfo.yyExt.toYyExtData(sdkLiveInfoData5.roomId).isYyGame ? 3 : 2;
                            str2 = TiebaStatic.YYValues.YY_LIVE;
                        }
                        param2.param("obj_param1", i4);
                        param2.param(TiebaStatic.Params.OBJ_PARAM2, str2);
                        TiebaStatic.log(param2);
                    }
                }
                onChangeSkinType(this.c, TbadkCoreApplication.getInst().getSkinType());
                if (oq5Var.b) {
                    StatisticItem statisticItem = new StatisticItem("c13610");
                    SdkLiveInfoData sdkLiveInfoData6 = this.m;
                    statisticItem.param("obj_param1", sdkLiveInfoData6 != null ? sdkLiveInfoData6.liveId : "");
                    statisticItem.param("fid", oq5Var.c);
                    statisticItem.param("fname", oq5Var.d);
                    statisticItem.param("obj_locate", oq5Var.e);
                    SdkLiveInfoData sdkLiveInfoData7 = this.m;
                    if (sdkLiveInfoData7 != null && (uiTransParam = sdkLiveInfoData7.uiTransParam) != null) {
                        statisticItem.param("ab_tag", uiTransParam.abTag);
                        statisticItem.param(TiebaStatic.Params.STAR_ID, this.m.uiTransParam.starId);
                        statisticItem.param("extra", this.m.uiTransParam.extra);
                        statisticItem.param("source_from", this.m.uiTransParam.sourceFrom);
                    }
                    TiebaStatic.log(statisticItem);
                    StatisticItem statisticItem2 = new StatisticItem(CommonStatisticKey.KEY_FORUM_INSIDE_LIVE_SHOW);
                    SdkLiveInfoData sdkLiveInfoData8 = this.m;
                    if (sdkLiveInfoData8 != null) {
                        statisticItem2.param("tid", sdkLiveInfoData8.tid);
                        statisticItem2.param("fid", oq5Var.c);
                        statisticItem2.param("fname", oq5Var.d);
                    }
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_locate", 6);
                    SdkLiveInfoData.AlaLiveInfo alaLiveInfo3 = this.m.liveInfo;
                    if (alaLiveInfo3 != null) {
                        int a2 = dr5.a(alaLiveInfo3);
                        SdkLiveInfoData sdkLiveInfoData9 = this.m;
                        SdkLiveInfoData.YYExt yYExt3 = sdkLiveInfoData9.liveInfo.yyExt;
                        if (yYExt3 != null) {
                            TiebaStaticHelper.addYYParam(statisticItem2, dr5.j(yYExt3, sdkLiveInfoData9.roomId));
                        } else {
                            str7 = "";
                        }
                        statisticItem2.param("obj_param1", a2);
                        statisticItem2.param(TiebaStatic.Params.OBJ_PARAM2, str7);
                    }
                    TiebaStatic.log(statisticItem2);
                } else {
                    StatisticItem statisticItem3 = new StatisticItem("c13544");
                    int i6 = this.p;
                    if (101 == i6) {
                        str = "推荐";
                    } else if (102 == i6) {
                        str = "颜值";
                    } else if (103 == i6) {
                        if (dr5.c(this.m)) {
                            StatisticItem statisticItem4 = new StatisticItem(CommonStatisticKey.ALA_FRIEND_ROOM_CARD_SHOW);
                            statisticItem4.param("obj_locate", 3);
                            statisticItem4.param("obj_param1", this.m.liveId);
                            statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccountId());
                            TiebaStatic.log(statisticItem4);
                        }
                        str = "交友";
                    } else {
                        str = "";
                    }
                    SdkLiveInfoData.AlaLiveInfo alaLiveInfo4 = this.m.liveInfo;
                    if (alaLiveInfo4 != null) {
                        int a3 = dr5.a(alaLiveInfo4);
                        SdkLiveInfoData sdkLiveInfoData10 = this.m;
                        SdkLiveInfoData.YYExt yYExt4 = sdkLiveInfoData10.liveInfo.yyExt;
                        if (yYExt4 != null) {
                            TiebaStaticHelper.addYYParam(statisticItem3, dr5.j(yYExt4, sdkLiveInfoData10.roomId));
                        } else {
                            str7 = "";
                        }
                        statisticItem3.param(TiebaStatic.Params.OBJ_PARAM2, a3);
                        statisticItem3.param(TiebaStatic.Params.OBJ_PARAM3, str7);
                    }
                    SdkLiveInfoData sdkLiveInfoData11 = this.m;
                    statisticItem3.param("obj_param1", sdkLiveInfoData11 != null ? sdkLiveInfoData11.liveId : "");
                    statisticItem3.param(TiebaStatic.Params.ENTRY_NAME, str);
                    statisticItem3.param("nid", this.m.nid);
                    statisticItem3.param(TiebaStatic.Params.LOGID, this.m.logid);
                    TiebaStatic.log(statisticItem3);
                }
                if ((this.c.getPageActivity() instanceof nq5) && ((nq5) this.c.getPageActivity()).n0()) {
                    us5.c(oq5Var, ((nq5) this.c.getPageActivity()).getFrom());
                    return;
                }
                return;
            }
            getView().setVisibility(4);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.c.getResources().getDimensionPixelOffset(R.dimen.M_W_X004);
            layoutParams.bottomMargin = 0;
            this.h.setGravity(16);
            this.h.setLayoutParams(layoutParams);
        }
    }

    @Override // com.baidu.tieba.cr5
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) || this.a == i) {
            return;
        }
        SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.g, (int) R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0101);
        this.a = i;
    }
}
