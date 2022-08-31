package com.baidu.tieba;

import android.animation.ValueAnimator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.data.TiebaPlusConfigData;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.switchs.NickNameActivitySwitch;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.ky7;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.sz5;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbContent;
import tbclient.PluginUser;
/* loaded from: classes4.dex */
public class ky7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px7 A;
    public h B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public ti5 H;
    public int I;
    public int J;
    public String K;
    public final View.OnClickListener L;
    public PbFragment a;
    public mu7 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public u16 e;
    public RelativeLayout f;
    public ImageView g;
    public zv7 h;
    public ColumnLayout i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public ImageView n;
    public HeadPendantView o;
    public TBLottieAnimationView p;
    public UserIconBox q;
    public UserIconBox r;
    public FrameLayout s;
    public HeadCustomImageView t;
    public VirtualImageStatusTip u;
    public LinearLayout v;
    public LinearLayout w;
    public ClickableHeaderImageView x;
    public PbFirstFloorUserLikeButton y;
    public PbFirstFloorMessageButton z;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public a(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.a == null || this.a.a.getContext() == null) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a.getContext(), null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ ky7 b;

        public b(ky7 ky7Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.b.w.getMeasuredWidth();
                int measuredWidth2 = this.b.C.getMeasuredWidth();
                int measuredWidth3 = this.b.F.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i2 = this.a;
                if (i < i2) {
                    this.b.E.setVisibility(8);
                    this.b.D.setVisibility(8);
                } else if (i - i2 < dimenPixelSize) {
                    this.b.D.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ky7 b;

        public c(ky7 ky7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.w(this.a);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ kt7 b;
        public final /* synthetic */ ky7 c;

        public d(ky7 ky7Var, MetaData metaData, kt7 kt7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, metaData, kt7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = ky7Var;
            this.a = metaData;
            this.b = kt7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.c.w(this.a);
                ux7.a(ux7.a, this.b.Q(), ux7.b, this.c.J, this.c.K);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ky7 b;

        public e(ky7 ky7Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ky7Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.n(this.b.H);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(pg.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.u(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public f(ky7 ky7Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, valueAnimator) == null) {
                this.a.setAlpha(valueAnimator.getAnimatedFraction());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ky7 a;

        public g(ky7 ky7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ky7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.p.playAnimation();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ ky7 d;

        public h(@NonNull ky7 ky7Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ky7Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ky7Var;
            this.a = textView;
            this.b = tBSpecificationBtn;
            c();
        }

        public void a(@NonNull String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.c = str;
            }
        }

        @NonNull
        public final TiebaPlusConfigData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                return tiebaPlusConfigData == null ? TiebaPlusConfigData.DEFAULT : tiebaPlusConfigData;
            }
            return (TiebaPlusConfigData) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                qv4 qv4Var = new qv4();
                qv4Var.r(R.color.CAM_X0302);
                this.b.setConfig(qv4Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.dy7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            ky7.h.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!pi.A()) {
                ri.M(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0c40);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.b.l(i);
                } else {
                    SkinManager.setViewTextColor(this.a, (int) R.color.CAM_X0109);
                }
            }
        }

        public void f(@Nullable CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, charSequence) == null) {
                if (b().isSwitchOpen()) {
                    this.b.setText(charSequence.toString());
                } else {
                    this.a.setText(charSequence);
                }
            }
        }

        public void g(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                if (b().isSwitchOpen()) {
                    this.b.setVisibility(i);
                    this.a.setVisibility(8);
                    return;
                }
                this.b.setVisibility(8);
                this.a.setVisibility(i);
            }
        }
    }

    public ky7(PbFragment pbFragment, mu7 mu7Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, mu7Var, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.f = null;
        this.i = null;
        this.k = null;
        this.l = null;
        this.s = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.I = 0;
        this.J = 0;
        this.K = null;
        this.L = new a(this);
        this.a = pbFragment;
        this.b = mu7Var;
        this.c = onClickListener;
        v();
    }

    public void A(kt7 kt7Var, PostData postData, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{kt7Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) || kt7Var == null || postData == null) {
            return;
        }
        String Q = kt7Var != null ? kt7Var.Q() : "";
        int k = qx7.k(kt7Var);
        if (z && postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
        }
        if (this.A == null) {
            ThreadData O = kt7Var.O();
            int i = 1;
            if (O != null) {
                if (O.isBJHArticleThreadType()) {
                    i = 4;
                } else if (O.isBJHVideoThreadType()) {
                    i = 6;
                } else if (O.isBJHVideoDynamicThreadType()) {
                    i = 7;
                } else if (O.isBJHNormalThreadType()) {
                    i = 5;
                } else if (O.isVideoWorksInfo()) {
                    i = 8;
                }
            }
            px7 px7Var = new px7(this.a.getPageContext(), this.y, i);
            this.A = px7Var;
            px7Var.l(this.a.getUniqueId());
            this.A.v(O);
        }
        if (postData != null && postData.s() != null) {
            postData.s().setIsLike(postData.s().hadConcerned());
            this.A.n(postData.s());
            this.A.x(Q);
        }
        px7 px7Var2 = this.A;
        px7Var2.p = z2;
        px7Var2.w(k);
    }

    public void B(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.removeHeaderView(this.f);
    }

    public final void C(kt7 kt7Var, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, kt7Var, postData) == null) {
            MetaData s = postData.s();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView == null || this.u == null) {
                return;
            }
            headCustomImageView.setVisibility(0);
            if (postData.i0() != null) {
                FrameLayout frameLayout = this.s;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
                this.t.d(s);
                VirtualImageCustomFigure i0 = postData.i0();
                this.t.setHeadImageViewResource(i0.getFigureUrl());
                this.t.setHeadImageBackgroundColorResource(i0.getBackgroundValue());
                if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(i0.getBackGroundType())) {
                    str = i0.getBackgroundValue();
                } else {
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(i0.getBackGroundType())) {
                        this.t.setHeadImageBackgroundResource(i0.getBackgroundValue());
                    }
                    str = "#7F66FE";
                }
                PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
                if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                    marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                    this.y.setLayoutParams(marginLayoutParams);
                }
                if (postData.j0() != null && !TextUtils.isEmpty(postData.j0().b())) {
                    a25 j0 = postData.j0();
                    this.u.setData(j0.b(), j0.a(), str);
                    this.u.setVisibility(0);
                    LinearLayout linearLayout = this.v;
                    if (linearLayout != null && linearLayout.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                        marginLayoutParams2.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams2.topMargin, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams2.bottomMargin);
                        this.v.setLayoutParams(marginLayoutParams2);
                    }
                    LinearLayout linearLayout2 = this.w;
                    if (linearLayout2 != null && linearLayout2.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                        marginLayoutParams3.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.bottomMargin);
                        this.w.setLayoutParams(marginLayoutParams3);
                    }
                    this.u.setNotNeedAnimate();
                    this.J = ux7.d;
                    this.K = this.u.getData();
                } else {
                    this.J = ux7.e;
                    this.u.setVisibility(8);
                    LinearLayout linearLayout3 = this.v;
                    if (linearLayout3 != null && linearLayout3.getVisibility() == 0 && (this.v.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                        marginLayoutParams4.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams4.bottomMargin);
                        this.v.setLayoutParams(marginLayoutParams4);
                    }
                    LinearLayout linearLayout4 = this.w;
                    if (linearLayout4 != null && linearLayout4.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                        marginLayoutParams5.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams5.bottomMargin);
                        this.w.setLayoutParams(marginLayoutParams5);
                    }
                }
                this.t.setBigWidthAndHeight(ri.f(TbadkApplication.getInst(), R.dimen.tbds110), ri.f(TbadkApplication.getInst(), R.dimen.tbds144));
            }
            this.u.setOnClickListener(new c(this, s));
            this.t.setOnClickListener(new d(this, s, kt7Var));
            ux7.a(2, kt7Var.Q(), ux7.b, this.J, this.K);
        }
    }

    public void D(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void E(PostData postData, kt7 kt7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, postData, kt7Var) == null) || postData == null || kt7Var == null) {
            return;
        }
        if (postData.X() != null) {
            this.j.setData(this.a.getPageContext(), kt7Var.F().get(0).X(), ml8.a("PB", "c0132", kt7Var.l().getId(), kt7Var.l().getName(), kt7Var.O().getId(), this.a.l6() ? "FRS" : null));
            ColumnLayout columnLayout = this.i;
            columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
            return;
        }
        this.j.setData(null, null, null);
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.h.g(z);
        }
    }

    public void G(kt7 kt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, kt7Var) == null) {
            if (kt7Var != null && kt7Var.u0()) {
                int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c5);
                int paddingBottom = this.i.getPaddingBottom();
                if (kt7Var.i0()) {
                    f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), f2, this.i.getPaddingRight(), paddingBottom);
                return;
            }
            int f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.i.getPaddingBottom();
            if (kt7Var != null && !kt7Var.O().isVideoThreadType() && kt7Var.i0() && (!StringUtils.isNull(kt7Var.O().getTitle()) || kt7Var.O().getSpan_str() != null)) {
                f3 = ri.f(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.i;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), f3, this.i.getPaddingRight(), paddingBottom2);
        }
    }

    public void H(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void I(int i, kt7 kt7Var, PostData postData, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), kt7Var, postData, onClickListener}) == null) {
            if (postData != null && postData.s() != null) {
                MetaData s = postData.s();
                String string = s.getName_show() == null ? StringUtils.string(s.getUserName()) : StringUtils.string(s.getName_show());
                int byteLength = !StringUtils.isNull(postData.s().getSealPrefix()) ? qi.byteLength(s.getSealPrefix()) + 2 : 0;
                if (kt7Var == null || kt7Var.O() == null || !kt7Var.O().isQuestionThread()) {
                    if (byteLength > 0) {
                        if (qi.byteLength(string) > 12) {
                            string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                        }
                    } else if (qi.byteLength(string) > 14) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                    }
                } else if (qi.byteLength(string) > 20) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 20, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> tShowInfoNew = s.getTShowInfoNew();
                if (this.q != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.q.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.P() != null) {
                        this.q.setOnClickListener(this.a.P().d.e);
                    }
                    int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.q.h(tShowInfoNew, 3, f2, f2, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.k.setText(t(s.getSealPrefix(), string));
                this.k.setTag(R.id.obfuscated_res_0x7f09203f, s.getUserId());
                this.k.setTag(R.id.obfuscated_res_0x7f092047, s.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !s.isBigV()) {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0301, 1);
                }
                if (kt7Var.i0()) {
                    this.l.setVisibility(8);
                } else if (s.getIs_bawu() == 1 && postData.o0()) {
                    ns4 d2 = ns4.d(this.l);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.l.setVisibility(0);
                    this.l.setText(R.string.obfuscated_res_0x7f0f0342);
                } else if (s.getIs_bawu() == 1 && "manager".equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02fb);
                    this.l.setVisibility(0);
                    ns4 d3 = ns4.d(this.l);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (s.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(s.getBawu_type())) {
                    this.l.setText(R.string.obfuscated_res_0x7f0f02fc);
                    this.l.setVisibility(0);
                    ns4 d4 = ns4.d(this.l);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.l.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.e0()), "yyyy"))) {
                    this.C.setText(StringHelper.getFormatTimeShort(postData.e0()));
                } else {
                    this.C.setText(StringHelper.getFormatTime(postData.e0()));
                }
                if (kt7Var.i0()) {
                    this.D.setVisibility(8);
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = 0;
                    }
                    this.i.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo);
                    } else {
                        this.F.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(s);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.F.setVisibility(0);
                        this.F.setText(authInfo2);
                    } else {
                        this.F.setVisibility(8);
                    }
                    if (this.w.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.w.getLayoutParams())).rightMargin = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.i.setSpacingRight(ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    n15 R = postData.R();
                    String r = r(postData);
                    if (!TextUtils.isEmpty(r)) {
                        this.D.setVisibility(0);
                        this.D.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f14ea) + r);
                    } else if (R != null && !TextUtils.isEmpty(R.b()) && !TextUtils.isEmpty(R.b().trim())) {
                        this.D.setVisibility(0);
                        this.D.setText(R.b());
                    } else {
                        this.D.setVisibility(8);
                    }
                    if (R != null && !TextUtils.isEmpty(R.a()) && TextUtils.isEmpty(r)) {
                        this.E.setText(R.a());
                        this.E.setVisibility(0);
                        this.w.post(new b(this, (int) this.E.getPaint().measureText(R.a(), 0, R.a().length())));
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (postData.i0() != null) {
                        C(kt7Var, postData);
                    }
                }
                if (kt7Var.O().getAuthor() == null || kt7Var.O().getAuthor().getAlaInfo() == null || kt7Var.O().getAuthor().getAlaInfo().live_status != 1) {
                    z = false;
                } else {
                    J(kt7Var);
                    z = true;
                }
                this.o.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.o.j(s, 4);
                    this.o.setIsclearmode(false);
                } else {
                    this.o.setIsclearmode(true);
                }
                this.o.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.x;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.k.setOnClickListener(onClickListener);
                this.o.getHeadView().setUserId(s.getUserId());
                this.o.getHeadView().setUserName(s.getUserName());
                this.o.getHeadView().setTid(postData.K());
                this.o.getHeadView().setFid(kt7Var != null ? kt7Var.m() : "");
                this.o.getHeadView().setFName(kt7Var.n());
                this.o.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.o.l(s.getAvater());
                } else {
                    this.o.n(s);
                    this.o.setIsNeedAlpAnima(true);
                }
                String name_show = s.getName_show();
                String userName = s.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.k.setText(ls7.b(this.a.getPageContext().getPageActivity(), this.k.getText().toString()));
                    this.k.setGravity(16);
                    this.k.setTag(R.id.obfuscated_res_0x7f092014, ls7.a());
                    SkinManager.setViewTextColor(this.k, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && s.getUserGrowthData() != null) {
                    int a2 = s.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.m.K(String.valueOf(ww.b(a2)), 24, false);
                        this.m.setVisibility(0);
                        this.m.setOnClickListener(this.L);
                    } else {
                        this.m.setVisibility(8);
                    }
                }
            }
            if (kt7Var != null) {
                this.h.f(kt7Var.O());
            }
        }
    }

    public final void J(kt7 kt7Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, kt7Var) == null) || (tBLottieAnimationView = this.p) == null) {
            return;
        }
        if (tBLottieAnimationView.getVisibility() != 0 && kt7Var != null && kt7Var.O() != null && kt7Var.O().getAuthor() != null) {
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", kt7Var.m());
            statisticItem.param("fname", kt7Var.n());
            statisticItem.param("obj_param1", kt7Var.O().getAuthor().getUserId());
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", kt7Var.Q());
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
            if (kt7Var.O().getAuthor().getAlaInfo() != null) {
                AlaInfoData alaInfo = kt7Var.O().getAuthor().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
        this.p.setVisibility(0);
        this.p.setSpeed(0.8f);
        this.p.loop(true);
        this.p.post(new g(this));
    }

    public void K(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048586, this, postData, z) == null) {
            if (this.a.u0()) {
                this.I = 0;
                if (postData != null && postData.s() != null) {
                    this.I = postData.s().getLevel_id();
                }
                if (this.I > 0 && !z) {
                    this.n.setVisibility(0);
                    x(this.n);
                    if (postData != null && postData.s() != null) {
                        N(postData);
                    }
                    SkinManager.setImageResource(this.n, BitmapHelper.getGradeResourceIdInEnterForum(this.I));
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (postData == null || postData.s() == null) {
                return;
            }
            N(postData);
        }
    }

    public void L(kt7 kt7Var, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(1048587, this, kt7Var, postData, z) == null) || kt7Var == null || postData == null) {
            return;
        }
        if (3 != kt7Var.g()) {
            this.y.setVisibility(0);
            x(this.y);
        }
        if (z) {
            this.y.setVisibility(8);
            if (kt7Var != null && kt7Var.O() != null && kt7Var.O().getBaijiahaoData() != null && kt7Var.O().getBaijiahaoData().oriUgcType == 3) {
                this.B.g(8);
            } else if (kt7Var.O() != null && kt7Var.O().isQuestionThread()) {
                this.B.g(8);
            } else {
                this.B.g(0);
            }
            this.B.a(kt7Var.Q());
            this.B.f(String.format(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0e70), StringHelper.numberUniformFormatExtra(kt7Var.P())));
        } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.s().hadConcerned() && (kt7Var.O() == null || !kt7Var.O().isQuestionThread())) {
            this.B.g(8);
        } else {
            this.y.setVisibility(8);
            this.B.g(8);
        }
        if (kt7Var.i || 3 == kt7Var.g()) {
            this.y.setVisibility(8);
        }
    }

    public void M(kt7 kt7Var, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, kt7Var, postData) == null) || postData == null || this.a == null || postData.g0 == null || kt7Var.O() == null || kt7Var.O().getAuthor() == null) {
            return;
        }
        MetaData author = kt7Var.O().getAuthor();
        this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
        PbContent o = TiePlusHelper.o(postData.g0);
        if (o == null || o.tiebaplus_info == null) {
            return;
        }
        ti5 c2 = ti5.c(o.type.intValue(), o.tiebaplus_info, kt7Var.O());
        this.H = c2;
        c2.p(TiePlusStat.RichTextType.MESSAGE);
        this.H.q(TiePlusStat.StatType.EXPOSE);
        this.G.n(this.H);
        this.z.setVisibility(0);
        this.z.setOnClickListener(new e(this, author));
    }

    public final void N(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        MetaData s = postData.s();
        ArrayList<IconData> iconInfo = s.getIconInfo();
        UserIconBox userIconBox = this.r;
        if (userIconBox != null) {
            userIconBox.setTag(R.id.obfuscated_res_0x7f09203f, s.getUserId());
            if (this.a.P() != null) {
                this.r.setOnClickListener(this.a.P().d.c);
            }
            int f2 = ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds40);
            this.r.g(iconInfo, 4, f2, f2, ri.f(TbadkCoreApplication.getInst(), R.dimen.tbds10));
            this.r.setAutoChangedStyle(true);
            x(this.r);
        }
    }

    public void m(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, bdTypeListView) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.addHeaderView(this.f);
    }

    public void n(BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, bdTypeListView, i) == null) || bdTypeListView == null) {
            return;
        }
        bdTypeListView.x(this.f, i);
    }

    public void o(kt7 kt7Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{kt7Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (kt7Var != null && kt7Var.j) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f0f);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z && z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f51);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f4f);
                this.g.setVisibility(0);
                x(this.g);
            } else if (z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080f50);
                this.g.setVisibility(0);
                x(this.g);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void p() {
        u16 u16Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048593, this) == null) || (u16Var = this.e) == null) {
            return;
        }
        u16Var.N();
    }

    public TextView q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h.e() : (TextView) invokeV.objValue;
    }

    public final String r(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return null;
            }
            return postData.s().getIpAddress();
        }
        return (String) invokeL.objValue;
    }

    public View s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    public final SpannableStringBuilder t(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048597, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null || str == null) {
                return spannableStringBuilder;
            }
            arrayList.add(new sz5.a(str));
            return sz5.h(this.a.getActivity(), str2, arrayList, true);
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public SparseArray<Object> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.i.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.i.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d062d, (ViewGroup) null);
            this.f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091850);
            this.g = imageView;
            imageView.getLayoutParams().height = qx7.i();
            zv7 zv7Var = new zv7(this.a.getBaseFragmentActivity(), this.f);
            this.h = zv7Var;
            zv7Var.a();
            zv7 zv7Var2 = this.h;
            zv7Var2.d(zv7Var2.e(), this.c);
            this.i = (ColumnLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0917f2);
            this.j = (ThreadSkinView) this.f.findViewById(R.id.obfuscated_res_0x7f09184d);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0917f1);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0909f4);
            this.n = (ImageView) this.i.findViewById(R.id.obfuscated_res_0x7f090e0d);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0917ee);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.f.findViewById(R.id.obfuscated_res_0x7f09073d);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.f.findViewById(R.id.obfuscated_res_0x7f0925a9);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f09182c);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f0917ef);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091e74);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f091e75);
            this.v = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f0917f0);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f0917ca);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f091802);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091809);
            this.B = new h(this, (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091871), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091872));
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0917f8);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0917f6);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0917f4);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f0917f5);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f0917cb);
        }
    }

    public final void w(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, metaData) == null) {
            String str2 = null;
            if (metaData != null) {
                str2 = metaData.getUserId();
                str = metaData.getUserName();
            } else {
                str = null;
            }
            if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), str2, str)));
        }
    }

    public final void x(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new f(this, view2));
            ofInt.start();
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            ImageView imageView = this.n;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.I));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.r(i);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.z;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.r(i);
            }
            TextView textView = this.D;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            h hVar = this.B;
            if (hVar != null) {
                hVar.e(i);
            }
            TextView textView3 = this.F;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
            TextView textView4 = this.E;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.p;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            UserIconBox userIconBox = this.r;
            if (userIconBox != null) {
                userIconBox.i(i);
            }
        }
    }

    public void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            u16 u16Var = this.e;
            if (u16Var != null) {
                u16Var.N();
            }
            ColumnLayout columnLayout = this.i;
            if (columnLayout != null && this.x != null) {
                columnLayout.removeView(this.s);
                this.x = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.p;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }
}
