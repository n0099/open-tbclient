package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ColumnLayout;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadCustomImageView;
import com.baidu.tbadk.core.view.HeadPendantView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.data.VirtualImageCustomFigure;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.level.TbLevelView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tbadk.widget.tiejia.TiePlusStat;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.view.PbFirstFloorMessageButton;
import com.baidu.tieba.pb.view.PbFirstFloorUserLikeButton;
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
/* loaded from: classes8.dex */
public class s2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public m1a A;
    public h4a B;
    public TextView C;
    public TextView D;
    public TextView E;
    public TextView F;
    public TiePlusEventController G;
    public bz5 H;
    public int I;
    public int J;
    public String K;
    public final View.OnClickListener L;
    public int M;
    public View.OnLayoutChangeListener N;
    public PbFragment a;
    public ux9 b;
    public View.OnClickListener c;
    public View.OnLongClickListener d;
    public RelativeLayout e;
    public ImageView f;
    public TbImageView g;
    public uz9 h;
    public ColumnLayout i;
    public ThreadSkinView j;
    public TextView k;
    public TextView l;
    public TbImageView m;
    public TbLevelView n;
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

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s2a a;

        public a(s2a s2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s2aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.a != null && this.a.a.getContext() != null) {
                CommonStatisticUtils.staticNameplateOfUserLevel(2, 3, ((Integer) view2.getTag()).intValue());
                BrowserHelper.startWebActivity(this.a.a.getContext(), (String) null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aw9 a;
        public final /* synthetic */ nwa b;
        public final /* synthetic */ s2a c;

        public b(s2a s2aVar, aw9 aw9Var, nwa nwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar, aw9Var, nwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s2aVar;
            this.a = aw9Var;
            this.b = nwaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                av5.d(this.a.o(), this.b.u().getPortrait(), "2", this.c.a.getContext());
                bv5.c("c15281", this.a.o(), "2");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ s2a b;

        public c(s2a s2aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s2aVar;
            this.a = metaData;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) != null) || i3 - i <= 0) {
                return;
            }
            this.b.s(this.a);
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ CharSequence b;

        public d(s2a s2aVar, TextView textView, CharSequence charSequence) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar, textView, charSequence};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = textView;
            this.b = charSequence;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.setText(this.b);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements View.OnAttachStateChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ s2a a;

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }

        public e(s2a s2aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = s2aVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) {
                if (this.a.N != null) {
                    this.a.v.removeOnLayoutChangeListener(this.a.N);
                }
                this.a.v.removeOnAttachStateChangeListener(this);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ s2a b;

        public f(s2a s2aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s2aVar;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            MetaData metaData;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && (metaData = this.a) != null) {
                e4a.c(metaData, this.b.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ aw9 b;
        public final /* synthetic */ s2a c;

        public g(s2a s2aVar, MetaData metaData, aw9 aw9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar, metaData, aw9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = s2aVar;
            this.a = metaData;
            this.b = aw9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a != null) {
                q1a.a(q1a.a, this.b.T(), q1a.b, this.c.J, this.c.K, this.a.getUserId());
                if ((view2 instanceof HeadCustomImageView) && ((HeadCustomImageView) view2).b()) {
                    return;
                }
                e4a.c(this.a, this.c.a);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ s2a b;

        public h(s2a s2aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {s2aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = s2aVar;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.H.q(TiePlusStat.StatType.CLICK);
                this.b.G.u(this.b.H);
                PluginUser.Builder builder = new PluginUser.Builder();
                builder.user_id = Long.valueOf(JavaTypesHelper.toLong(this.a.getUserId(), 0L));
                builder.user_name_show = this.a.getName_show();
                builder.user_photo = this.a.getPortrait();
                builder.user_type = Integer.valueOf(this.a.getType());
                TiePlusHelper.L(this.b.a.getActivity(), builder.build(true));
            }
        }
    }

    public s2a(PbFragment pbFragment, ux9 ux9Var, View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, ux9Var, onClickListener};
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
        this.e = null;
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
        this.M = 0;
        this.N = null;
        this.a = pbFragment;
        this.b = ux9Var;
        this.c = onClickListener;
        p();
    }

    public void A(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i.setVisibility(i);
        }
    }

    public void i(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.addHeaderView(this.e);
        }
    }

    public void k(@NonNull MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, metaData) == null) && this.v != null && this.N == null) {
            c cVar = new c(this, metaData);
            this.N = cVar;
            this.v.addOnLayoutChangeListener(cVar);
            j();
        }
    }

    public void u(BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, bdTypeListView) == null) && bdTypeListView != null) {
            bdTypeListView.removeHeaderView(this.e);
        }
    }

    public void w(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onLongClickListener) == null) {
            this.d = onLongClickListener;
            this.i.setOnLongClickListener(onLongClickListener);
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048597, this, z) == null) {
            this.h.f(z);
        }
    }

    public void z(aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, aw9Var) == null) {
            e4a.f(aw9Var, this.i);
        }
    }

    public void B(aw9 aw9Var, nwa nwaVar, View.OnClickListener onClickListener) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aw9Var, nwaVar, onClickListener) != null) || this.k == null) {
            return;
        }
        if (nwaVar != null && nwaVar.u() != null) {
            MetaData u = nwaVar.u();
            if (u.getName_show() == null) {
                StringUtils.string(u.getUserName());
            } else {
                StringUtils.string(u.getName_show());
            }
            e4a.m(this.q, u, this.a, this.k);
            e4a.g(aw9Var, this.l, u, nwaVar);
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(nwaVar.r0()), "yyyy"))) {
                this.C.setText(StringHelper.getFormatTimeShort(nwaVar.r0()));
            } else {
                this.C.setText(StringHelper.getFormatTime(nwaVar.r0()));
            }
            e4a.h(aw9Var, this.D, this.E, u, nwaVar, this.w, this.i, this.F, this.C);
            if (!aw9Var.a() && nwaVar.w0() != null) {
                v(aw9Var, nwaVar);
            }
            if (aw9Var.R().getAuthor() != null && aw9Var.R().getAuthor().getAlaInfo() != null && aw9Var.R().getAuthor().getAlaInfo().live_status == 1) {
                TBLottieAnimationView tBLottieAnimationView = this.p;
                if (tBLottieAnimationView != null) {
                    e4a.j(aw9Var, tBLottieAnimationView);
                }
                z = true;
            } else {
                z = false;
            }
            if (this.p.getVisibility() == 0) {
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), UtilHelper.getDimenPixelSize(R.dimen.tbds25));
            } else {
                ColumnLayout columnLayout2 = this.i;
                columnLayout2.setPadding(columnLayout2.getPaddingLeft(), this.i.getPaddingTop(), this.i.getPaddingRight(), this.i.getPaddingBottom());
            }
            e4a.l(this.o, u, z, aw9Var, nwaVar, this.x, this.k, onClickListener, this.a, this.m, this.L);
            k(u);
        }
        if (aw9Var != null) {
            this.h.e(aw9Var.R());
        }
        this.n.setOnClickListener(new b(this, aw9Var, nwaVar));
    }

    public void C(nwa nwaVar, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, nwaVar, z) == null) {
            if (this.a.e1()) {
                this.I = 0;
                if (nwaVar != null && nwaVar.u() != null) {
                    this.I = nwaVar.u().getLevel_id();
                    str = nwaVar.u().getLevelName();
                } else {
                    str = "";
                }
                if (this.I > 0 && !z) {
                    this.n.setVisibility(0);
                    e4a.d(this.n);
                    if (nwaVar != null && nwaVar.u() != null) {
                        e4a.o(nwaVar, this.r, this.a);
                    }
                    this.n.setLevel(this.I, str);
                    return;
                }
                this.n.setVisibility(8);
                return;
            }
            this.n.setVisibility(8);
            if (nwaVar != null && nwaVar.u() != null) {
                e4a.o(nwaVar, this.r, this.a);
            }
        }
    }

    public void E(aw9 aw9Var, nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048580, this, aw9Var, nwaVar) == null) && nwaVar != null && this.a != null && nwaVar.t0 != null && aw9Var.R() != null && aw9Var.R().getAuthor() != null) {
            MetaData author = aw9Var.R().getAuthor();
            this.G = new TiePlusEventController(this.a.getActivity(), TiePlusStat.Locate.PB);
            PbContent B = TiePlusHelper.B(nwaVar.t0);
            if (B != null && B.tiebaplus_info != null) {
                bz5 c2 = bz5.c(B.type.intValue(), B.tiebaplus_info, aw9Var.R());
                this.H = c2;
                c2.p(TiePlusStat.RichTextType.MESSAGE);
                this.H.q(TiePlusStat.StatType.EXPOSE);
                this.G.u(this.H);
                this.z.setVisibility(0);
                this.z.setOnClickListener(new h(this, author));
            }
        }
    }

    public void x(nwa nwaVar, aw9 aw9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, nwaVar, aw9Var) == null) && nwaVar != null && aw9Var != null) {
            String str = null;
            if (nwaVar.i0() != null) {
                if (this.a.C7()) {
                    str = "FRS";
                }
                this.j.setData(this.a.getPageContext(), aw9Var.I().get(0).i0(), twa.a("PB", "c0132", aw9Var.n().getId(), aw9Var.n().getName(), aw9Var.R().getId(), str));
                ColumnLayout columnLayout = this.i;
                columnLayout.setPadding(columnLayout.getPaddingLeft(), (int) TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.obfuscated_res_0x7f0701d5), this.i.getPaddingRight(), this.i.getPaddingBottom());
                return;
            }
            this.j.setData(null, null, null);
        }
    }

    public void D(aw9 aw9Var, nwa nwaVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048579, this, aw9Var, nwaVar, z) == null) {
            e4a.n(aw9Var, nwaVar, z, this.y, this.B);
        }
    }

    public void m(aw9 aw9Var, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{aw9Var, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            e4a.a(aw9Var, z, z2, this.f);
        }
    }

    public final void j() {
        LinearLayout linearLayout;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048582, this) != null) || (linearLayout = this.v) == null) {
            return;
        }
        linearLayout.addOnAttachStateChangeListener(new e(this));
    }

    public final void n() {
        TextView textView;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || (textView = this.k) == null || textView.getWidth() != 0) {
            return;
        }
        textView.post(new d(this, textView, textView.getText()));
    }

    public TextView o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h.d();
        }
        return (TextView) invokeV.objValue;
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
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

    public void l(nwa nwaVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nwaVar) == null) && nwaVar != null && this.g != null) {
            String g0 = nwaVar.g0();
            if (!StringUtils.isNull(g0)) {
                this.g.startLoad(g0, 10, false);
                this.g.setVisibility(0);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d073c, (ViewGroup) null);
            this.e = relativeLayout;
            ImageView imageView = (ImageView) relativeLayout.findViewById(R.id.obfuscated_res_0x7f091c3e);
            this.f = imageView;
            imageView.getLayoutParams().height = n1a.o();
            this.g = (TbImageView) this.e.findViewById(R.id.obfuscated_res_0x7f091c3a);
            uz9 uz9Var = new uz9(this.a.getBaseFragmentActivity(), this.e);
            this.h = uz9Var;
            uz9Var.a();
            uz9 uz9Var2 = this.h;
            uz9Var2.c(uz9Var2.d(), this.c);
            this.i = (ColumnLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091bda);
            this.j = (ThreadSkinView) this.e.findViewById(R.id.obfuscated_res_0x7f091c3b);
            this.k = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091bd9);
            this.l = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f090bc9);
            this.n = (TbLevelView) this.i.findViewById(R.id.forum_level_view);
            this.s = (FrameLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091bd6);
            HeadCustomImageView headCustomImageView = (HeadCustomImageView) this.e.findViewById(R.id.obfuscated_res_0x7f090887);
            this.t = headCustomImageView;
            headCustomImageView.setBigWidthAndHeight(UtilHelper.getDimenPixelSize(R.dimen.tbds94), UtilHelper.getDimenPixelSize(R.dimen.tbds120));
            this.u = (VirtualImageStatusTip) this.e.findViewById(R.id.virtual_image_status_tip);
            HeadPendantView headPendantView = (HeadPendantView) this.i.findViewById(R.id.obfuscated_res_0x7f091c19);
            this.o = headPendantView;
            headPendantView.setHasPendantStyle();
            this.p = (TBLottieAnimationView) this.i.findViewById(R.id.obfuscated_res_0x7f091bd7);
            this.i.setOnLongClickListener(this.d);
            this.i.setOnTouchListener(this.b);
            this.i.setVisibility(8);
            if (this.o.getHeadView() != null) {
                this.o.getHeadView().setIsRound(true);
                this.o.getHeadView().setDrawBorder(true);
                this.o.getHeadView().setPlaceHolder(1);
            }
            this.q = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f0922de);
            this.r = (UserIconBox) this.i.findViewById(R.id.obfuscated_res_0x7f0922df);
            this.v = (LinearLayout) this.e.findViewById(R.id.obfuscated_res_0x7f091bd8);
            this.w = (LinearLayout) this.i.findViewById(R.id.obfuscated_res_0x7f091bad);
            this.y = (PbFirstFloorUserLikeButton) this.i.findViewById(R.id.obfuscated_res_0x7f091beb);
            this.z = (PbFirstFloorMessageButton) this.i.findViewById(R.id.obfuscated_res_0x7f091bf2);
            this.B = new h4a((TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091c54), (TBSpecificationBtn) this.i.findViewById(R.id.obfuscated_res_0x7f091c55), this.a);
            this.C = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091be2);
            this.D = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091be1);
            this.E = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091bdf);
            this.F = (TextView) this.i.findViewById(R.id.obfuscated_res_0x7f091be0);
            this.m = (TbImageView) this.i.findViewById(R.id.obfuscated_res_0x7f091bb0);
        }
    }

    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0205);
            TbLevelView tbLevelView = this.n;
            if (tbLevelView != null) {
                tbLevelView.a();
            }
            PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
            if (pbFirstFloorUserLikeButton != null) {
                pbFirstFloorUserLikeButton.onChangeSkinType(i);
            }
            PbFirstFloorMessageButton pbFirstFloorMessageButton = this.z;
            if (pbFirstFloorMessageButton != null) {
                pbFirstFloorMessageButton.onChangeSkinType(i);
            }
            TextView textView = this.D;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0109);
            }
            TextView textView2 = this.C;
            if (textView2 != null) {
                SkinManager.setViewTextColor(textView2, (int) R.color.CAM_X0109);
            }
            h4a h4aVar = this.B;
            if (h4aVar != null) {
                h4aVar.e(i);
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

    public final void s(@NonNull MetaData metaData) {
        int measuredWidth;
        String string;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, metaData) != null) || this.M == (measuredWidth = this.v.getMeasuredWidth())) {
            return;
        }
        this.M = measuredWidth;
        if (rd.isEmpty(metaData.getName_show())) {
            string = StringUtils.string(metaData.getUserName());
        } else {
            string = StringUtils.string(metaData.getName_show());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.q);
        arrayList.add(this.l);
        arrayList.add(this.m);
        arrayList.add(this.n);
        zu5.c(measuredWidth, string, this.k, this.n, arrayList, this.r);
        n();
        bv5.a(this.k, this.q, this.m, this.n, this.r, 1);
    }

    public void t(aw9 aw9Var, nwa nwaVar, boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{aw9Var, nwaVar, Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            String T2 = aw9Var.T();
            int q = n1a.q(aw9Var);
            if (z && nwaVar != null && nwaVar.u() != null) {
                nwaVar.u().setIsLike(nwaVar.u().hadConcerned());
            }
            if (this.A == null) {
                ThreadData R = aw9Var.R();
                int i = 1;
                if (R != null) {
                    if (R.isBJHArticleThreadType()) {
                        i = 4;
                    } else if (R.isBJHVideoThreadType()) {
                        i = 6;
                    } else if (R.isBJHVideoDynamicThreadType()) {
                        i = 7;
                    } else if (R.isBJHNormalThreadType()) {
                        i = 5;
                    } else if (R.isVideoWorksInfo()) {
                        i = 8;
                    }
                }
                m1a m1aVar = new m1a(this.a.getPageContext(), this.y, i);
                this.A = m1aVar;
                m1aVar.j(this.a.getUniqueId());
                this.A.u(R);
            }
            if (nwaVar != null && nwaVar.u() != null) {
                nwaVar.u().setIsLike(nwaVar.u().hadConcerned());
                this.A.l(nwaVar.u());
                this.A.y(T2);
            }
            m1a m1aVar2 = this.A;
            m1aVar2.p = z2;
            m1aVar2.x(q);
        }
    }

    public final void v(aw9 aw9Var, nwa nwaVar) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, aw9Var, nwaVar) == null) {
            MetaData u = nwaVar.u();
            HeadCustomImageView headCustomImageView = this.t;
            if (headCustomImageView != null && this.u != null) {
                headCustomImageView.setVisibility(0);
                if (nwaVar.w0() != null) {
                    FrameLayout frameLayout = this.s;
                    if (frameLayout != null) {
                        frameLayout.setVisibility(8);
                    }
                    this.t.f(u);
                    VirtualImageCustomFigure w0 = nwaVar.w0();
                    this.t.setHeadImageViewResource(w0.getFigureUrl());
                    this.t.setHeadImageBackgroundColorResource(w0.getBackgroundValue());
                    if (VirtualImageCustomFigure.BACK_GROUND_TYPE_TONE.equals(w0.getBackGroundType())) {
                        str = w0.getBackgroundValue();
                    } else {
                        if (VirtualImageCustomFigure.BACK_GROUND_TYPE_URL.equals(w0.getBackGroundType())) {
                            this.t.setHeadImageBackgroundResource(w0.getBackgroundValue());
                        }
                        str = "#7F66FE";
                    }
                    PbFirstFloorUserLikeButton pbFirstFloorUserLikeButton = this.y;
                    if (pbFirstFloorUserLikeButton != null && (pbFirstFloorUserLikeButton.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.y.getLayoutParams();
                        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, UtilHelper.getDimenPixelSize(R.dimen.tbds40), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                        this.y.setLayoutParams(marginLayoutParams);
                    }
                    if (nwaVar.x0() != null && !TextUtils.isEmpty(nwaVar.x0().getIcon())) {
                        this.u.setData(nwaVar.x0(), true, str);
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
                        this.J = q1a.d;
                        this.K = this.u.getData();
                    } else {
                        this.J = q1a.e;
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
                    this.t.setBigWidthAndHeight(BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds110), BdUtilHelper.getDimens(TbadkApplication.getInst(), R.dimen.tbds144));
                }
                this.u.setOnClickListener(new f(this, u));
                this.t.setFrom(3);
                this.t.setOnClickListener(new g(this, u, aw9Var));
                if (u != null) {
                    q1a.a(2, aw9Var.T(), q1a.b, this.J, this.K, u.getUserId());
                }
            }
        }
    }
}
