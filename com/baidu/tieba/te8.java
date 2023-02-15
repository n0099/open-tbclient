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
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
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
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.te8;
import com.baidu.tieba.view.VirtualImageStatusTip;
import com.baidu.tieba.xc6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import tbclient.PbContent;
import tbclient.PluginUser;
/* loaded from: classes6.dex */
public class te8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public PbFirstFloorMessageButton A;
    public wd8 B;
    public j C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TextView G;
    public TiePlusEventController H;
    public ft5 I;
    public TBLottieAnimationView J;
    public TbImageView K;
    public HeadWorldCupFlagLayout L;
    public int M;
    public int N;
    public String O;
    public final View.OnClickListener P;
    public Runnable Q;
    public PbFragment a;
    public xa8 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public bf6 e;
    public RelativeLayout f;
    public ImageView g;
    public TbImageView h;
    public fc8 i;
    public ColumnLayout j;
    public ThreadSkinView k;
    public TextView l;
    public TextView m;
    public TbImageView n;
    public ImageView o;
    public HeadPendantView p;
    public TBLottieAnimationView q;
    public UserIconBox r;
    public UserIconBox s;
    public FrameLayout t;
    public HeadCustomImageView u;
    public VirtualImageStatusTip v;
    public LinearLayout w;
    public LinearLayout x;
    public ClickableHeaderImageView y;
    public PbFirstFloorUserLikeButton z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te8 a;

        public a(te8 te8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getContext() != null) {
                CommonStatisticUtils.staticNameplateOfUserLevel(2, 3, ((Integer) view2.getTag()).intValue());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.a.getContext(), null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te8 a;

        public b(te8 te8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.J != null) {
                this.a.J.setVisibility(8);
                this.a.J.pauseAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ te8 b;

        public c(te8 te8Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = te8Var;
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int measuredWidth = this.b.x.getMeasuredWidth();
                int measuredWidth2 = this.b.D.getMeasuredWidth();
                int measuredWidth3 = this.b.G.getMeasuredWidth();
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int i = (measuredWidth - measuredWidth2) - measuredWidth3;
                int i2 = this.a;
                if (i < i2) {
                    this.b.F.setVisibility(8);
                    this.b.E.setVisibility(8);
                } else if (i - i2 < dimenPixelSize) {
                    this.b.E.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ PostData b;
        public final /* synthetic */ te8 c;

        public d(te8 te8Var, MetaData metaData, PostData postData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, metaData, postData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = te8Var;
            this.a = metaData;
            this.b = postData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getPortrait() != null) {
                String portrait = this.a.getPortrait();
                String str2 = null;
                if (this.b.o0() != null) {
                    str2 = this.b.o0().getFigureUrl();
                    str = this.b.o0().getBackgroundValue();
                } else {
                    str = null;
                }
                if (!TextUtils.isEmpty(portrait)) {
                    iu5.a(this.c.a.getPageContext(), portrait, str2, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ te8 b;

        public e(te8 te8Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = te8Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.A(this.a);
        }
    }

    /* loaded from: classes6.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ v98 b;
        public final /* synthetic */ te8 c;

        public f(te8 te8Var, MetaData metaData, v98 v98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, metaData, v98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = te8Var;
            this.a = metaData;
            this.b = v98Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null) {
                be8.a(be8.a, this.b.S(), be8.b, this.c.N, this.c.O, this.a.getUserId());
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                this.c.A(this.a);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ te8 b;

        public g(te8 te8Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = te8Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.I.q(TiePlusStat.StatType.CLICK);
                this.b.H.g(this.b.I);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(dh.g(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.x(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements ValueAnimator.AnimatorUpdateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;

        public h(te8 te8Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, view2};
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

    /* loaded from: classes6.dex */
    public class i implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ te8 a;

        public i(te8 te8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = te8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.q.playAnimation();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final TextView a;
        public final TBSpecificationBtn b;
        public String c;
        public final /* synthetic */ te8 d;

        public j(@NonNull te8 te8Var, @NonNull TextView textView, TBSpecificationBtn tBSpecificationBtn) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {te8Var, textView, tBSpecificationBtn};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = te8Var;
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

        @NonNull
        public final TiebaPlusConfigData b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                TiebaPlusConfigData tiebaPlusConfigData = TbSingleton.getInstance().getTiebaPlusConfigData();
                if (tiebaPlusConfigData == null) {
                    return TiebaPlusConfigData.DEFAULT;
                }
                return tiebaPlusConfigData;
            }
            return (TiebaPlusConfigData) invokeV.objValue;
        }

        public final void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                n45 n45Var = new n45();
                n45Var.t(R.color.CAM_X0302);
                this.b.setConfig(n45Var);
                this.b.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.le8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                            te8.j.this.d(view2);
                        }
                    }
                });
            }
        }

        public /* synthetic */ void d(View view2) {
            if (!BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                ej.P(this.d.a.getContext(), R.string.obfuscated_res_0x7f0f0d08);
                return;
            }
            UrlManager.getInstance().dealOneLink(this.d.a.getPageContext(), new String[]{b().getJumpUrlWithTid(this.c)});
            TiebaPlusConfigData.addClickStatsForFireLink(4);
        }
    }

    public te8(PbFragment pbFragment, xa8 xa8Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, xa8Var, onClickListener};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = null;
        this.d = null;
        this.f = null;
        this.j = null;
        this.l = null;
        this.m = null;
        this.t = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.M = 0;
        this.N = 0;
        this.O = null;
        this.P = new a(this);
        this.Q = new b(this);
        this.a = pbFragment;
        this.b = xa8Var;
        this.c = onClickListener;
        z();
    }

    public void q(v98 v98Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{v98Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (v98Var != null && v98Var.j) {
                this.g.setImageResource(R.drawable.pic_frs_headlines_n);
                this.g.setVisibility(0);
                B(this.g);
            } else if (z && z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080fff);
                this.g.setVisibility(0);
                B(this.g);
            } else if (z) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080ffd);
                this.g.setVisibility(0);
                B(this.g);
            } else if (z2) {
                this.g.setImageResource(R.drawable.obfuscated_res_0x7f080ffe);
                this.g.setVisibility(0);
                B(this.g);
            } else {
                this.g.setVisibility(8);
            }
        }
    }

    public void F(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.f);
        }
    }

    public void H(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.j.setOnLongClickListener(onLongClickListener);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.i.g(z);
        }
    }

    public void L(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.j.setVisibility(i2);
        }
    }

    public void n(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048594, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.f);
        }
    }

    public final String t(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, postData)) == null) {
            if (postData != null && postData.r() != null) {
                return postData.r().getIpAddress();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void o(BdTypeListView bdTypeListView, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048595, this, bdTypeListView, i2) == null) && bdTypeListView != null) {
            bdTypeListView.x(this.f, i2);
        }
    }

    public final void A(MetaData metaData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, metaData) == null) {
            String str2 = null;
            if (metaData != null) {
                str2 = metaData.getUserId();
                str = metaData.getUserName();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getContext(), str2, str)));
            }
        }
    }

    public final void B(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
            view2.setAlpha(0.0f);
            ValueAnimator ofInt = ValueAnimator.ofInt(0, 1);
            ofInt.setDuration(50L);
            ofInt.addUpdateListener(new h(this, view2));
            ofInt.start();
        }
    }

    public void p(PostData postData) {
        TbImageView tbImageView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, postData) == null) && postData != null) {
            String a0 = postData.a0();
            if (!StringUtils.isNull(a0) && (tbImageView = this.h) != null) {
                tbImageView.K(a0, 10, false);
                this.h.setVisibility(0);
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public void C(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            SkinManager.setBackgroundColor(this.f, R.color.CAM_X0205);
            ImageView imageView = this.o;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, BitmapHelper.getGradeResourceIdInEnterForum(this.M));
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.z;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.onChangeSkinType(i2);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.A;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.onChangeSkinType(i2);
            }
            TextView textView = this.E;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.D;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            j jVar = this.C;
            if (jVar != null) {
                jVar.e(i2);
            }
            TextView textView3 = this.G;
            if (textView3 != null) {
                SkinManager.setViewTextColor(textView3, (int) R.color.CAM_X0109);
            }
            TextView textView4 = this.F;
            if (textView4 != null) {
                SkinManager.setViewTextColor(textView4, (int) R.color.CAM_X0109);
            }
            TBLottieAnimationView tBLottieAnimationView = this.q;
            if (tBLottieAnimationView != null) {
                SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            }
            UserIconBox userIconBox = this.s;
            if (userIconBox != null) {
                userIconBox.i(i2);
            }
        }
    }

    public final void R(PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, postData) == null) && postData != null && postData.r() != null) {
            MetaData r = postData.r();
            ArrayList<IconData> iconInfo = r.getIconInfo();
            UserIconBox userIconBox = this.s;
            if (userIconBox != null) {
                userIconBox.setTag(R.id.tag_user_id, r.getUserId());
                if (this.a.N() != null) {
                    this.s.setOnClickListener(this.a.N().d.c);
                }
                int g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                this.s.g(iconInfo, 4, g2, g2, ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
                this.s.setAutoChangedStyle(true);
                B(this.s);
            }
        }
    }

    public void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            bf6 bf6Var = this.e;
            if (bf6Var != null) {
                bf6Var.h();
            }
            ColumnLayout columnLayout = this.j;
            if (columnLayout != null && this.y != null) {
                columnLayout.removeView(this.t);
                this.y = null;
            }
            TBLottieAnimationView tBLottieAnimationView = this.q;
            if (tBLottieAnimationView != null) {
                tBLottieAnimationView.cancelAnimation();
            }
        }
    }

    public void r() {
        bf6 bf6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && (bf6Var = this.e) != null) {
            bf6Var.h();
        }
    }

    public TextView s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.i.e();
        }
        return (TextView) invokeV.objValue;
    }

    public View u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    public SparseArray<Object> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            SparseArray<Object> sparseArray = (SparseArray) this.j.getTag();
            if (sparseArray == null) {
                SparseArray<Object> sparseArray2 = new SparseArray<>();
                this.j.setTag(sparseArray2);
                return sparseArray2;
            }
            return sparseArray;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void E(v98 v98Var, PostData postData, boolean z, boolean z2) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{v98Var, postData, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) && v98Var != null && postData != null) {
            if (v98Var != null) {
                str = v98Var.S();
            } else {
                str = "";
            }
            int v = xd8.v(v98Var);
            if (z && postData != null && postData.r() != null) {
                postData.r().setIsLike(postData.r().hadConcerned());
            }
            if (this.B == null) {
                ThreadData Q = v98Var.Q();
                int i2 = 1;
                if (Q != null) {
                    if (Q.isBJHArticleThreadType()) {
                        i2 = 4;
                    } else if (Q.isBJHVideoThreadType()) {
                        i2 = 6;
                    } else if (Q.isBJHVideoDynamicThreadType()) {
                        i2 = 7;
                    } else if (Q.isBJHNormalThreadType()) {
                        i2 = 5;
                    } else if (Q.isVideoWorksInfo()) {
                        i2 = 8;
                    }
                }
                wd8 wd8Var = new wd8(this.a.getPageContext(), this.z, i2);
                this.B = wd8Var;
                wd8Var.l(this.a.getUniqueId());
                this.B.v(Q);
            }
            if (postData != null && postData.r() != null) {
                postData.r().setIsLike(postData.r().hadConcerned());
                this.B.n(postData.r());
                this.B.x(str);
            }
            wd8 wd8Var2 = this.B;
            wd8Var2.p = z2;
            wd8Var2.w(v);
        }
    }

    public final void G(v98 v98Var, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, v98Var, postData) == null) {
            MetaData r = postData.r();
            HeadCustomImageView headCustomImageView = this.u;
            if (headCustomImageView != null && this.v != null) {
                headCustomImageView.setVisibility(0);
                if (postData.o0() != null) {
                    FrameLayout frameLayout = this.t;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.u.e(r);
                    VirtualImageCustomFigure o0 = postData.o0();
                    this.u.setHeadImageViewResource(o0.getFigureUrl());
                    this.u.setHeadImageBackgroundColorResource(o0.getBackgroundValue());
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(o0.getBackGroundType())) {
                        str = o0.getBackgroundValue();
                    } else {
                        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(o0.getBackGroundType())) {
                            this.u.setHeadImageBackgroundResource(o0.getBackgroundValue());
                        }
                        str = "#7F66FE";
                    }
                    PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.z;
                    if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.z.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        this.z.setLayoutParams(marginLayoutParams);
                    }
                    TbImageView tbImageView = this.K;
                    if (tbImageView != null && (tbImageView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.K.getLayoutParams();
                        marginLayoutParams2.setMargins(marginLayoutParams2.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams2.rightMargin, marginLayoutParams2.bottomMargin);
                        this.K.setLayoutParams(marginLayoutParams2);
                    }
                    if (postData.p0() != null && !TextUtils.isEmpty(postData.p0().getIcon())) {
                        this.v.setData(postData.p0(), true, str);
                        this.v.setVisibility(0);
                        LinearLayout linearLayout = this.w;
                        if (linearLayout != null && linearLayout.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                            marginLayoutParams3.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.topMargin, UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams3.bottomMargin);
                            this.w.setLayoutParams(marginLayoutParams3);
                        }
                        LinearLayout linearLayout2 = this.x;
                        if (linearLayout2 != null && linearLayout2.getVisibility() == 0 && (this.x.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
                            marginLayoutParams4.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams4.bottomMargin);
                            this.x.setLayoutParams(marginLayoutParams4);
                        }
                        this.v.setNotNeedAnimate();
                        this.N = be8.d;
                        this.O = this.v.getData();
                    } else {
                        this.N = be8.e;
                        this.v.setVisibility(8);
                        LinearLayout linearLayout3 = this.w;
                        if (linearLayout3 != null && linearLayout3.getVisibility() == 0 && (this.w.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) this.w.getLayoutParams();
                            marginLayoutParams5.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.M_H_X004), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams5.bottomMargin);
                            this.w.setLayoutParams(marginLayoutParams5);
                        }
                        LinearLayout linearLayout4 = this.x;
                        if (linearLayout4 != null && linearLayout4.getVisibility() == 0 && (this.x.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) this.x.getLayoutParams();
                            marginLayoutParams6.setMargins(UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), UtilHelper.getDimenPixelSize(R.dimen.tbds12), UtilHelper.getDimenPixelSize(R.dimen.M_W_X004), marginLayoutParams6.bottomMargin);
                            this.x.setLayoutParams(marginLayoutParams6);
                        }
                    }
                    HeadWorldCupFlagLayout headWorldCupFlagLayout = this.L;
                    if (headWorldCupFlagLayout != null) {
                        headWorldCupFlagLayout.setPadding(0, ej.g(TbadkApplication.getInst(), R.dimen.tbds24), 0, 0);
                    }
                    this.u.setBigWidthAndHeight(ej.g(TbadkApplication.getInst(), R.dimen.tbds110), ej.g(TbadkApplication.getInst(), R.dimen.tbds144));
                }
                this.v.setOnClickListener(new e(this, r));
                this.u.setFrom(3);
                this.u.setOnClickListener(new f(this, r, v98Var));
                y();
                String q = p35.q("key_reaction_guide_show_number_pb");
                PbFragment pbFragment = this.a;
                if (pbFragment != null && pbFragment.N() != null && this.a.N().getIntent() != null && this.a.N().getIntent().getBooleanExtra(PbActivityConfig.KEY_IS_CUSTOM_FIGURE_THREAD, false) && p35.m().n(q, 0) == 1) {
                    this.J.setVisibility(0);
                    this.J.playAnimation();
                    gh.a().postDelayed(this.Q, 4000L);
                }
                if (r != null) {
                    be8.a(2, v98Var.S(), be8.b, this.N, this.O, r.getUserId());
                }
            }
        }
    }

    public void I(PostData postData, v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, v98Var) == null) && postData != null && v98Var != null) {
            String str = null;
            if (postData.c0() != null) {
                if (this.a.c6()) {
                    str = "FRS";
                }
                this.k.setData(this.a.getPageContext(), v98Var.H().get(0).c0(), p29.a("PB", "c0132", v98Var.l().getId(), v98Var.l().getName(), v98Var.Q().getId(), str));
                ColumnLayout columnLayout = this.j;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.j.getPaddingRight(), this.j.getPaddingBottom());
                return;
            }
            this.k.setData(null, null, null);
        }
    }

    public void O(PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, postData, z) == null) {
            if (this.a.v0()) {
                this.M = 0;
                if (postData != null && postData.r() != null) {
                    this.M = postData.r().getLevel_id();
                }
                if (this.M > 0 && !z) {
                    this.o.setVisibility(0);
                    B(this.o);
                    if (postData != null && postData.r() != null) {
                        R(postData);
                    }
                    SkinManager.setImageResource(this.o, BitmapHelper.getGradeResourceIdInEnterForum(this.M));
                    return;
                }
                this.o.setVisibility(8);
                return;
            }
            this.o.setVisibility(8);
            if (postData != null && postData.r() != null) {
                R(postData);
            }
        }
    }

    public void Q(v98 v98Var, PostData postData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, v98Var, postData) == null) && postData != null && this.a != null && postData.i0 != null && v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
            MetaData author = v98Var.Q().getAuthor();
            this.H = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
            PbContent r = TiePlusHelper.r(postData.i0);
            if (r != null && r.tiebaplus_info != null) {
                ft5 c2 = ft5.c(r.type.intValue(), r.tiebaplus_info, v98Var.Q());
                this.I = c2;
                c2.p(TiePlusStat.RichTextType.MESSAGE);
                this.I.q(TiePlusStat.StatType.EXPOSE);
                this.H.g(this.I);
                this.A.setVisibility(0);
                this.A.setOnClickListener(new g(this, author));
            }
        }
    }

    public void K(v98 v98Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, v98Var) == null) {
            if (v98Var != null && v98Var.y0()) {
                int g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0702c6);
                int paddingBottom = this.j.getPaddingBottom();
                if (v98Var.l0()) {
                    g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds38);
                    paddingBottom = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds8);
                }
                ColumnLayout columnLayout = this.j;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), g2, this.j.getPaddingRight(), paddingBottom);
                return;
            }
            int g3 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
            int paddingBottom2 = this.j.getPaddingBottom();
            if (v98Var != null && !v98Var.Q().isVideoThreadType() && v98Var.l0() && (!StringUtils.isNull(v98Var.Q().getTitle()) || v98Var.Q().getSpan_str() != null)) {
                g3 = ej.g(TbadkCoreApplication.getInst(), R.dimen.obfuscated_res_0x7f0701d5);
            }
            ColumnLayout columnLayout2 = this.j;
            columnLayout2.setPadding(columnLayout2.getPaddingLeft(), g3, this.j.getPaddingRight(), paddingBottom2);
        }
    }

    public final void N(v98 v98Var) {
        TBLottieAnimationView tBLottieAnimationView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, v98Var) == null) && (tBLottieAnimationView = this.q) != null) {
            if (tBLottieAnimationView.getVisibility() != 0 && v98Var != null && v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
                StatisticItem statisticItem = new StatisticItem("c13714");
                statisticItem.param("fid", v98Var.m());
                statisticItem.param("fname", v98Var.n());
                statisticItem.param("obj_param1", v98Var.Q().getAuthor().getUserId());
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", v98Var.S());
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, 1);
                if (v98Var.Q().getAuthor().getAlaInfo() != null) {
                    AlaInfoData alaInfo = v98Var.Q().getAuthor().getAlaInfo();
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                    if (alaInfo.mYyExtData != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                        TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                    }
                }
                TiebaStatic.log(statisticItem);
            }
            this.q.setVisibility(0);
            this.q.setSpeed(0.8f);
            this.q.loop(true);
            this.q.post(new i(this));
        }
    }

    public void M(int i2, v98 v98Var, PostData postData, View.OnClickListener onClickListener) {
        String string;
        int i3;
        boolean z;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i2), v98Var, postData, onClickListener}) == null) {
            if (postData != null && postData.r() != null) {
                MetaData r = postData.r();
                if (r.getName_show() == null) {
                    string = StringUtils.string(r.getUserName());
                } else {
                    string = StringUtils.string(r.getName_show());
                }
                if (!StringUtils.isNull(postData.r().getSealPrefix())) {
                    i3 = dj.byteLength(r.getSealPrefix()) + 2;
                } else {
                    i3 = 0;
                }
                if (v98Var != null && v98Var.Q() != null && v98Var.Q().isQuestionThread()) {
                    if (dj.byteLength(string) > 20) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 20, StringHelper.STRING_MORE);
                    }
                } else if (i3 > 0) {
                    if (dj.byteLength(string) > 12) {
                        string = StringHelper.cutChineseAndEnglishWithSuffix(string, 12, StringHelper.STRING_MORE);
                    }
                } else if (dj.byteLength(string) > 14) {
                    string = StringHelper.cutChineseAndEnglishWithSuffix(string, 14, StringHelper.STRING_MORE);
                }
                ArrayList<IconData> tShowInfoNew = r.getTShowInfoNew();
                if (this.r != null) {
                    if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
                        this.r.setTag(tShowInfoNew.get(0).getUrl());
                    }
                    if (this.a.N() != null) {
                        this.r.setOnClickListener(this.a.N().d.e);
                    }
                    int g2 = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds48);
                    this.r.h(tShowInfoNew, 3, g2, g2, ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds8), true);
                }
                this.l.setText(v(r.getSealPrefix(), string));
                this.l.setTag(R.id.tag_user_id, r.getUserId());
                this.l.setTag(R.id.tag_user_name, r.getName_show());
                if (ListUtils.isEmpty(tShowInfoNew) && !r.isBigV()) {
                    SkinManager.setViewTextColor(this.l, R.color.CAM_X0105, 1);
                } else {
                    SkinManager.setViewTextColor(this.l, R.color.CAM_X0301, 1);
                }
                if (v98Var.l0()) {
                    this.m.setVisibility(8);
                } else if (r.getIs_bawu() == 1 && postData.u0()) {
                    p15 d2 = p15.d(this.m);
                    d2.v(R.color.CAM_X0101);
                    d2.n(R.string.J_X04);
                    d2.f(R.color.CAM_X0302);
                    this.m.setVisibility(0);
                    this.m.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    this.m.setText(R.string.bawu_member_bazhu_tip);
                    this.m.setVisibility(0);
                    p15 d3 = p15.d(this.m);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    this.m.setText(R.string.bawu_member_xbazhu_tip);
                    this.m.setVisibility(0);
                    p15 d4 = p15.d(this.m);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                } else {
                    this.m.setVisibility(8);
                }
                if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.k0()), "yyyy"))) {
                    this.D.setText(StringHelper.getFormatTimeShort(postData.k0()));
                } else {
                    this.D.setText(StringHelper.getFormatTime(postData.k0()));
                }
                if (v98Var.l0()) {
                    this.E.setVisibility(8);
                    if (this.x.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.x.getLayoutParams())).rightMargin = 0;
                    }
                    this.j.setSpacingRight(0);
                    String authInfo = UtilHelper.getAuthInfo(r);
                    if (!TextUtils.isEmpty(authInfo)) {
                        this.G.setVisibility(0);
                        this.G.setText(authInfo);
                    } else {
                        this.G.setVisibility(8);
                    }
                } else {
                    String authInfo2 = UtilHelper.getAuthInfo(r);
                    if (!TextUtils.isEmpty(authInfo2)) {
                        this.G.setVisibility(0);
                        this.G.setText(authInfo2);
                    } else {
                        this.G.setVisibility(8);
                    }
                    if (this.x.getLayoutParams() instanceof ColumnLayout.LayoutParams) {
                        ((FrameLayout.LayoutParams) ((ColumnLayout.LayoutParams) this.x.getLayoutParams())).rightMargin = ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds40);
                    }
                    this.j.setSpacingRight(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds20));
                    oa5 V = postData.V();
                    String t = t(postData);
                    if (!TextUtils.isEmpty(t)) {
                        this.E.setVisibility(0);
                        this.E.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + t);
                    } else if (V != null && !TextUtils.isEmpty(V.b()) && !TextUtils.isEmpty(V.b().trim())) {
                        this.E.setVisibility(0);
                        this.E.setText(V.b());
                    } else {
                        this.E.setVisibility(8);
                    }
                    if (V != null && !TextUtils.isEmpty(V.a()) && TextUtils.isEmpty(t)) {
                        this.F.setText(V.a());
                        this.F.setVisibility(0);
                        this.x.post(new c(this, (int) this.F.getPaint().measureText(V.a(), 0, V.a().length())));
                    } else {
                        this.F.setVisibility(8);
                    }
                    if (postData.o0() != null) {
                        G(v98Var, postData);
                    }
                }
                if (v98Var.Q().getAuthor() != null && v98Var.Q().getAuthor().getAlaInfo() != null && v98Var.Q().getAuthor().getAlaInfo().live_status == 1) {
                    N(v98Var);
                    z = true;
                } else {
                    z = false;
                }
                this.p.setBigVDimenSize(R.dimen.tbds36);
                if (!z) {
                    this.p.j(r, 4);
                    this.p.setIsclearmode(false);
                } else {
                    this.p.setIsclearmode(true);
                }
                this.p.setVisibility(0);
                ClickableHeaderImageView clickableHeaderImageView = this.y;
                if (clickableHeaderImageView != null) {
                    clickableHeaderImageView.setVisibility(8);
                }
                this.l.setOnClickListener(onClickListener);
                this.p.getHeadView().setUserId(r.getUserId());
                this.p.getHeadView().setUserName(r.getUserName());
                this.p.getHeadView().setTid(postData.O());
                if (v98Var != null) {
                    str = v98Var.m();
                } else {
                    str = "";
                }
                this.p.getHeadView().setFid(str);
                this.p.getHeadView().setFName(v98Var.n());
                this.p.getHeadView().setOnClickListener(onClickListener);
                if (z) {
                    this.p.m(r.getAvater());
                } else {
                    this.p.o(r);
                    this.p.setIsNeedAlpAnima(true);
                }
                String name_show = r.getName_show();
                String userName = r.getUserName();
                if (NickNameActivitySwitch.isOn() && name_show != null && !name_show.equals(userName)) {
                    this.l.setText(v88.b(this.a.getPageContext().getPageActivity(), this.l.getText().toString()));
                    this.l.setGravity(16);
                    this.l.setTag(R.id.tag_nick_name_activity, v88.a());
                    SkinManager.setViewTextColor(this.l, R.color.CAM_X0312, 1);
                }
                if (TbSingleton.getInstance().isUserGrowthOpen() && r.getUserGrowthData() != null) {
                    int a2 = r.getUserGrowthData().a();
                    if (a2 >= 0 && a2 <= 10) {
                        this.n.setImageResource(lx.b(a2));
                        this.n.setVisibility(0);
                        this.n.setTag(Integer.valueOf(a2));
                        this.n.setOnClickListener(this.P);
                        CommonStatisticUtils.staticNameplateOfUserLevel(1, 3, a2);
                    } else {
                        this.n.setVisibility(8);
                    }
                }
                if (WorldCupEnableSwitch.isOn()) {
                    TbImageView tbImageView = this.K;
                    if (tbImageView != null) {
                        tbImageView.setVisibility(0);
                        this.K.setImageResource(R.drawable.icon_mask_raise_flag_button);
                        this.K.setOnClickListener(new d(this, r, postData));
                        String a3 = iq5.a("https://tieba.baidu.com/mo/q/hybrid-main-activity/worldcupPortrait?support_cache=1&thrown_flag_portrait=");
                        if (a3 != null) {
                            iq5.d(TbadkCoreApplication.getInst(), a3, null);
                        }
                    }
                    HeadWorldCupFlagLayout headWorldCupFlagLayout = this.L;
                    if (headWorldCupFlagLayout != null) {
                        headWorldCupFlagLayout.b(r);
                    }
                }
            }
            if (v98Var != null) {
                this.i.f(v98Var.Q());
            }
        }
    }

    public void P(v98 v98Var, PostData postData, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLZ(1048591, this, v98Var, postData, z) == null) && v98Var != null && postData != null) {
            if (3 != v98Var.g()) {
                this.z.setVisibility(0);
                B(this.z);
            }
            if (z) {
                this.z.setVisibility(8);
                if (v98Var != null && v98Var.Q() != null && v98Var.Q().getBaijiahaoData() != null && v98Var.Q().getBaijiahaoData().oriUgcType == 3) {
                    this.C.g(8);
                } else if (v98Var.Q() != null && v98Var.Q().isQuestionThread()) {
                    this.C.g(8);
                } else {
                    this.C.g(0);
                }
                this.C.a(v98Var.S());
                this.C.f(String.format(TbadkCoreApplication.getInst().getString(R.string.person_view_num), StringHelper.numberUniformFormatExtra(v98Var.R())));
            } else if (PbNormalLikeButtonSwitch.getIsOn() && !postData.r().hadConcerned() && (v98Var.Q() == null || !v98Var.Q().isQuestionThread())) {
                this.C.g(8);
            } else {
                this.z.setVisibility(8);
                this.C.g(8);
            }
            if (v98Var.i || 3 == v98Var.g()) {
                this.z.setVisibility(8);
            }
        }
    }

    public final SpannableStringBuilder v(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048602, this, str, str2)) == null) {
            ArrayList arrayList = new ArrayList();
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            if (str2 == null) {
                return spannableStringBuilder;
            }
            if (str != null) {
                arrayList.add(new xc6.a(str));
                return xc6.h(this.a.getActivity(), str2, arrayList, true);
            }
            return spannableStringBuilder;
        }
        return (SpannableStringBuilder) invokeLL.objValue;
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            this.J = new TBLottieAnimationView(this.f.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ej.g(this.f.getContext(), R.dimen.tbds650), ej.g(this.f.getContext(), R.dimen.tbds100));
            layoutParams.setMargins(ej.g(this.f.getContext(), R.dimen.tbds110), 0, 0, ej.g(this.f.getContext(), R.dimen.tbds10));
            layoutParams.addRule(8, this.j.getId());
            this.f.addView(this.J, layoutParams);
            y();
            this.J.setVisibility(8);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.J != null) {
            if (TbadkCoreApplication.getInst().getSkinType() != 1 && TbadkCoreApplication.getInst().getSkinType() != 4) {
                this.J.setImageAssetsFolder("lottie_reactions_guide_left_img");
            } else {
                this.J.setImageAssetsFolder("lottie_reactions_guide_left_img_dark");
            }
            SkinManager.setLottieAnimation(this.J, R.raw.lottie_reactions_guide_left);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048606, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0674, (ViewGroup) null);
            this.f = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091997);
            this.g = imageView;
            imageView.getLayoutParams().height = xd8.t();
            this.h = (TbImageView) this.f.findViewById(R.id.obfuscated_res_0x7f091993);
            fc8 fc8Var = new fc8(this.a.getBaseFragmentActivity(), this.f);
            this.i = fc8Var;
            fc8Var.a();
            fc8 fc8Var2 = this.i;
            fc8Var2.d(fc8Var2.e(), this.c);
            this.j = (ColumnLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091938);
            this.k = (ThreadSkinView) this.f.findViewById(R.id.obfuscated_res_0x7f091994);
            this.l = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f091937);
            this.m = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f090aa2);
            this.o = (ImageView) this.j.findViewById(R.id.obfuscated_res_0x7f090efd);
            this.t = (FrameLayout) this.j.findViewById(R.id.obfuscated_res_0x7f091934);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.f.findViewById(R.id.obfuscated_res_0x7f0907a4);
            this.u = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.v = (VirtualImageStatusTip) this.f.findViewById(R.id.virtual_image_status_tip);
            HeadPendantView headPendantView = (HeadPendantView) this.j.findViewById(R.id.obfuscated_res_0x7f091972);
            this.p = headPendantView;
            headPendantView.setHasPendantStyle();
            this.q = (TBLottieAnimationView) this.j.findViewById(R.id.obfuscated_res_0x7f091935);
            this.j.setOnLongClickListener(this.d);
            this.j.setOnTouchListener(this.b);
            this.j.setVisibility(8);
            if (this.p.getHeadView() != null) {
                this.p.getHeadView().setIsRound(true);
                this.p.getHeadView().setDrawBorder(true);
                this.p.getHeadView().setPlaceHolder(1);
            }
            this.r = (UserIconBox) this.j.findViewById(R.id.obfuscated_res_0x7f092003);
            this.s = (UserIconBox) this.j.findViewById(R.id.obfuscated_res_0x7f092004);
            this.w = (LinearLayout) this.f.findViewById(R.id.obfuscated_res_0x7f091936);
            this.x = (LinearLayout) this.j.findViewById(R.id.obfuscated_res_0x7f09190d);
            this.z = (PbFirstFloorUserLikeButton) this.j.findViewById(R.id.obfuscated_res_0x7f091948);
            this.A = (PbFirstFloorMessageButton) this.j.findViewById(R.id.obfuscated_res_0x7f09194f);
            this.C = new j(this, (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f0919b8), (TBSpecificationBtn) this.j.findViewById(R.id.obfuscated_res_0x7f0919b9));
            this.D = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f09193f);
            this.E = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f09193e);
            this.F = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f09193c);
            this.G = (TextView) this.j.findViewById(R.id.obfuscated_res_0x7f09193d);
            this.n = (TbImageView) this.j.findViewById(R.id.obfuscated_res_0x7f091910);
            this.K = (TbImageView) this.j.findViewById(R.id.obfuscated_res_0x7f091911);
            this.L = (HeadWorldCupFlagLayout) this.j.findViewById(R.id.world_cup_flag);
            x();
        }
    }
}
