package com.baidu.tieba;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.wf;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes5.dex */
public class s15 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public TBLottieAnimationView B;
    public int C;
    public int D;
    public int E;
    public h F;
    public YyExtData G;
    public String H;
    public vf a;
    public final Activity b;
    public final TbPageContext c;
    public ViewGroup d;
    public uf e;
    public final Handler f;
    public Runnable g;
    public int h;
    public String i;
    public String j;
    public TextView k;
    public TextView l;
    public HeadImageView m;
    public View n;
    public TBSpecificationBtn o;
    public String p;
    public String q;
    public String r;
    public View s;
    public View t;
    public ViewGroup u;
    public boolean v;
    public float w;
    public float x;
    public Long y;
    public String z;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public a(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a == null) {
                return;
            }
            this.a.a.e(this.a.d);
        }
    }

    /* loaded from: classes5.dex */
    public class b implements wf.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public b(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // com.baidu.tieba.wf.a
        public void onDismiss() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.a = null;
                this.a.f.removeCallbacks(this.a.g);
            }
        }

        @Override // com.baidu.tieba.wf.a
        public void onShown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements uf {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public c(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // com.baidu.tieba.uf
        public int a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 3;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return 32;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public View c(LayoutInflater layoutInflater) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutInflater)) == null) ? this.a.s == null ? this.a.s(layoutInflater) : this.a.s : (View) invokeL.objValue;
        }

        @Override // com.baidu.tieba.uf
        public int getXOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // com.baidu.tieba.uf
        public int getYOffset() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public d(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!dj.isEmpty(this.a.p)) {
                    UrlManager.getInstance().dealOneLink(this.a.c, new String[]{this.a.p});
                } else if (this.a.G != null) {
                    YYLiveUtil.jumpToYYLiveRoom(this.a.c, this.a.G, "rec_fuceng");
                }
                this.a.q();
                this.a.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public e(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (!dj.isEmpty(this.a.p)) {
                    UrlManager.getInstance().dealOneLink(this.a.c, new String[]{this.a.p});
                } else if (this.a.G != null) {
                    YYLiveUtil.jumpToYYLiveRoom(this.a.c, this.a.G, "rec_fuceng");
                }
                this.a.q();
                this.a.t();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public f(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view2, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view2, motionEvent)) == null) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.a.w = motionEvent.getY();
                    this.a.v = false;
                } else if (action != 1) {
                    if (action == 2) {
                        if (this.a.w == 0.0f) {
                            this.a.w = motionEvent.getY();
                        }
                        this.a.x = motionEvent.getY() - this.a.w;
                        if (this.a.x < 0.0f) {
                            this.a.v = true;
                        } else {
                            this.a.v = false;
                        }
                    }
                } else if (this.a.v) {
                    this.a.w();
                    this.a.t();
                    return true;
                }
                return false;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s15 a;

        public g(s15 s15Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s15Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s15Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.B.playAnimation();
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface h {
        void dismiss();
    }

    public s15(TbPageContext<?> tbPageContext, Map<String, Object> map) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, map};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new Handler();
        this.v = false;
        this.x = 0.0f;
        this.C = UtilHelper.getDimenPixelSize(R.dimen.M_H_X013);
        this.D = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        this.E = UtilHelper.getDimenPixelSize(R.dimen.M_W_X003);
        UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
        this.G = null;
        this.c = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        if (map != null) {
            this.i = (String) map.get("view_top_params_key_title");
            this.j = (String) map.get("view_top_params_key_desc");
            this.h = ((Integer) map.get("view_top_params_key_type")).intValue();
            this.p = (String) map.get("view_top_params_key_schema");
            this.q = (String) map.get("view_top_params_key_image_url");
            this.G = (YyExtData) map.get("view_top_params_key_yyext");
            this.r = (String) map.get("view_top_params_user_name");
            this.y = (Long) map.get("view_top_params_room_id");
            this.z = (String) map.get("view_top_params_btn_text");
            this.A = ((Boolean) map.get("view_top_params_is_breathe")).booleanValue();
            this.H = (String) map.get("view_top_params_key_nid");
        }
        this.d = u(this.b);
    }

    public void A() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (viewGroup = this.d) == null) {
            return;
        }
        viewGroup.setVisibility(0);
        vf vfVar = this.a;
        if (vfVar != null) {
            vfVar.e(this.d);
        }
        this.g = new a(this);
        wf wfVar = new wf();
        wfVar.d(true);
        wfVar.h(new b(this));
        if (this.e == null) {
            this.e = r();
        }
        wfVar.a(this.e);
        wfVar.e(R.anim.obfuscated_res_0x7f010102);
        wfVar.f(R.anim.obfuscated_res_0x7f010103);
        vf b2 = wfVar.b();
        this.a = b2;
        b2.q(this.b, this.d, false);
    }

    public Activity getActivity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (Activity) invokeV.objValue;
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.G == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_REMIND_FLOAT_VIEW_CLICK);
        statisticItem.param("obj_type", this.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_param1", this.G.mYyUid);
        statisticItem.param("obj_name", this.r);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.G.isYyGame ? "3" : "2");
        statisticItem.param("liveid", this.y.longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, this.G.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, this.G.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, this.G.mYyUid);
        statisticItem.param("template_id", this.G.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.H);
        TiebaStatic.log(statisticItem);
    }

    public final uf r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new c(this) : (uf) invokeV.objValue;
    }

    @NonNull
    public final View s(LayoutInflater layoutInflater) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, layoutInflater)) == null) {
            View inflate = layoutInflater.inflate(R.layout.obfuscated_res_0x7f0d0894, (ViewGroup) null);
            this.t = inflate;
            this.n = inflate.findViewById(R.id.obfuscated_res_0x7f090b42);
            this.k = (TextView) this.t.findViewById(R.id.obfuscated_res_0x7f090b49);
            this.l = (TextView) this.t.findViewById(R.id.obfuscated_res_0x7f090b4b);
            this.m = (HeadImageView) this.t.findViewById(R.id.obfuscated_res_0x7f090b41);
            this.B = (TBLottieAnimationView) this.t.findViewById(R.id.obfuscated_res_0x7f0924b2);
            this.o = (TBSpecificationBtn) this.t.findViewById(R.id.obfuscated_res_0x7f090b44);
            this.l.setText(this.i);
            this.k.setText(this.j);
            if (dj.isEmpty(this.z)) {
                this.o.setVisibility(8);
            } else {
                this.o.setText(this.z);
            }
            this.o.setOnClickListener(new d(this));
            this.n.setOnClickListener(new e(this));
            this.n.setOnTouchListener(new f(this));
            this.m.K(this.q, 10, false);
            this.m.setDefaultResource(17170445);
            this.m.setPlaceHolder(1);
            this.m.setIsRound(true);
            this.m.setBorderWidth(R.dimen.L_X02);
            this.m.setBorderColor(R.color.CAM_X0622);
            this.m.setDrawBorder(true);
            if (this.A) {
                SkinManager.setLottieAnimation(this.B, R.raw.card_live_header_bg);
            }
            this.B.setVisibility(0);
            if (!this.B.isAnimating()) {
                this.B.setSpeed(0.8f);
                this.B.setRepeatCount(-1);
                this.B.post(new g(this));
            }
            z();
            v();
            return this.t;
        }
        return (View) invokeL.objValue;
    }

    public void t() {
        ViewGroup viewGroup;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            vf vfVar = this.a;
            if (vfVar != null && (viewGroup = this.d) != null) {
                vfVar.e(viewGroup);
                this.d.setVisibility(8);
            }
            h hVar = this.F;
            if (hVar != null) {
                hVar.dismiss();
            }
        }
    }

    public final ViewGroup u(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) {
            if (activity == null) {
                return null;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            layoutParams.topMargin = this.C;
            layoutParams.leftMargin = this.D;
            layoutParams.rightMargin = this.E;
            FrameLayout frameLayout = new FrameLayout(activity);
            this.u = frameLayout;
            ((FrameLayout) activity.findViewById(16908290)).addView(frameLayout, layoutParams);
            return this.u;
        }
        return (ViewGroup) invokeL.objValue;
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.l, (int) R.color.CAM_X0105);
            TBSelector.makeShadowDrawable().setBgColor(R.color.CAM_X0207).setShapeRadius(ej.f(this.b, R.dimen.tbds31)).setShadowColor(R.color.CAM_X0803).setShadowSide(ShadowDrawable.ALL).setShadowRadius(ej.f(this.b, R.dimen.tbds16)).setOffsetX(0).setOffsetY(0).into(this.n);
            zx4 zx4Var = new zx4();
            zx4Var.p(R.color.CAM_X0302);
            this.o.setConfig(zx4Var);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.G == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_REMIND_FLOAT_VIEW_HIDE);
        statisticItem.param("obj_type", this.h);
        statisticItem.param("liveid", this.y.longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, this.G.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, this.G.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, this.G.mYyUid);
        statisticItem.param("template_id", this.G.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.H);
        TiebaStatic.log(statisticItem);
    }

    public void x(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, hVar) == null) {
            this.F = hVar;
        }
    }

    public void y(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, view2) == null) {
            this.s = view2;
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || this.G == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_LIVE_REMIND_FLOAT_VIEW_SHOW);
        statisticItem.param("obj_type", this.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("obj_param1", this.G.mYyUid);
        statisticItem.param("obj_name", this.r);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, this.G.isYyGame ? "3" : "2");
        statisticItem.param("liveid", this.y.longValue());
        statisticItem.param("hdid", TbadkCoreApplication.getInst().getHdid());
        statisticItem.param(TiebaStatic.YYParams.YYSID, this.G.mSid);
        statisticItem.param(TiebaStatic.YYParams.YYSSID, this.G.mSsid);
        statisticItem.param(TiebaStatic.YYParams.YYUID, this.G.mYyUid);
        statisticItem.param("template_id", this.G.mTemplateId);
        statisticItem.param(TiebaStatic.YYParams.YYLIVEID, 1);
        statisticItem.param(TiebaStatic.Params.VID, this.H);
        TiebaStatic.log(statisticItem);
    }
}
