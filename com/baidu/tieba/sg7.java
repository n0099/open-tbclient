package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.GreyUtil;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatRoomRecycleAdapter;
import com.baidu.tieba.imMessageCenter.chatgroup.data.ChatRoomInfo;
import com.baidu.tieba.pg7;
import com.baidu.tieba.view.TbImageAutoSwitch;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class sg7 {
    public static /* synthetic */ Interceptable $ic;
    public static final int W;
    public static final int X;
    public static final int Y;
    public static final int Z;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public int B;
    public int C;
    public TextView D;
    public gh7 E;
    public fh7 F;
    public RecyclerView G;
    public String H;
    public List<String> I;
    public boolean J;
    public TbImageAutoSwitch.b K;
    public NoDataView L;
    public RelativeLayout M;
    public RelativeLayout N;
    public la5 O;
    @Nullable
    public pg7 P;
    public ka5 Q;
    public View.OnClickListener R;
    @NonNull
    public pg7.b S;
    public RecyclerView.OnScrollListener T;
    public CustomMessageListener U;
    public Runnable V;
    public final Context a;
    public final TbPageContext b;
    public RelativeLayout c;
    public TbImageAutoSwitch d;
    public HeadImageView e;
    public BottomSheetDialog f;
    public FrameLayout g;
    public RelativeLayout h;
    public RelativeLayout i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public ImageView m;
    public RecyclerView n;
    public LinearLayoutManager o;
    public tg7 p;
    public ChatRoomRecycleAdapter q;
    public ug7 r;
    public View s;
    public View t;
    public View u;
    public long v;
    public String w;
    public long x;
    public boolean y;
    public List<Long> z;

    /* loaded from: classes6.dex */
    public class a implements TbImageAutoSwitch.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            }
        }

        public a(sg7 sg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public void a(View view2, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLI(1048576, this, view2, i) == null) && (view2 instanceof HeadImageView)) {
                ((HeadImageView) view2).K(this.a.I.get(i), 10, false);
            }
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public View c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                HeadImageView headImageView = new HeadImageView(this.a.a);
                headImageView.setLayoutParams(new ViewGroup.LayoutParams(sg7.W, sg7.W));
                headImageView.setBorderWidth(sg7.X);
                headImageView.setBorderColor(SkinManager.getColor(R.color.CAM_X0101));
                headImageView.setIsRound(true);
                headImageView.setDrawBorder(true);
                headImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                headImageView.setPlaceHolder(1);
                return headImageView;
            }
            return (View) invokeV.objValue;
        }

        @Override // com.baidu.tieba.view.TbImageAutoSwitch.b
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.a.I.size();
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        public b(sg7 sg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && BdNetTypeUtil.isNetworkAvailableForImmediately()) {
                if (this.a.O != null) {
                    this.a.O.dettachView(this.a.N);
                    this.a.O = null;
                }
                if (this.a.P != null) {
                    this.a.W();
                    this.a.P.r(this.a.z, TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.a.v));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements pg7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        public c(sg7 sg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // com.baidu.tieba.pg7.b
        public void a(List list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, list, i) == null) {
                if (i != 0) {
                    this.a.X();
                    this.a.j.setVisibility(8);
                    return;
                }
                this.a.K();
                this.a.J();
                this.a.j.setVisibility(0);
                if (!ListUtils.isEmpty(list)) {
                    if (this.a.n != null) {
                        this.a.n.setVisibility(0);
                    }
                    if (list.get(0) instanceof ih7) {
                        ih7 ih7Var = (ih7) list.remove(0);
                        if (ih7Var != null && ih7Var.a() != null) {
                            this.a.I = ih7Var.a();
                            if (this.a.I.size() == 1) {
                                this.a.e.setVisibility(0);
                                this.a.d.setVisibility(8);
                                sg7 sg7Var = this.a;
                                sg7Var.e.K(sg7Var.I.get(0), 10, false);
                            } else {
                                this.a.d.setVisibility(0);
                                this.a.e.setVisibility(8);
                                this.a.d.p();
                            }
                        } else {
                            this.a.d.setVisibility(8);
                            this.a.e.setVisibility(8);
                            this.a.Z();
                        }
                        if (ih7Var != null && ih7Var.b() != null) {
                            this.a.l.setText(ih7Var.b());
                        }
                    }
                    if (this.a.p != null) {
                        this.a.p.j(list, this.a.y);
                        this.a.U();
                        return;
                    }
                    return;
                }
                this.a.Y();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        public d(sg7 sg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLII(1048576, this, recyclerView, i, i2) != null) || !this.a.J) {
                return;
            }
            this.a.J = false;
            if (this.a.o.findViewByPosition(this.a.B) != null) {
                sg7 sg7Var = this.a;
                sg7Var.C = sg7Var.o.findViewByPosition(this.a.B).getTop();
            }
            this.a.n.scrollBy(0, (this.a.I() - this.a.G()) + this.a.C);
            this.a.C = 0;
            this.a.L();
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(sg7 sg7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2001266 && (customResponsedMessage.getData() instanceof lr8)) {
                sg7 sg7Var = this.a;
                boolean z = true;
                if (((lr8) customResponsedMessage.getData()).m() != 1) {
                    z = false;
                }
                sg7Var.y = z;
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f extends BottomSheetDialog {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(sg7 sg7Var, Context context, int i) {
            super(context, i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var, context, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onAttachedToWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onAttachedToWindow();
                this.a.S();
            }
        }

        @Override // android.app.Dialog, android.view.Window.Callback
        public void onDetachedFromWindow() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                super.onDetachedFromWindow();
                this.a.P();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class g implements ch7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        public g(sg7 sg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // com.baidu.tieba.ch7
        public void a(long j, int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)}) == null) && this.a.P != null) {
                this.a.P.k(j, i);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class h implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ sg7 a;

        public h(sg7 sg7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sg7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = sg7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.G != null && this.a.E != null && this.a.E.b() != null) {
                this.a.E.b().setLocationScrolled(false);
                this.a.G.getAdapter().notifyItemChanged(this.a.A);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948150534, "Lcom/baidu/tieba/sg7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948150534, "Lcom/baidu/tieba/sg7;");
                return;
            }
        }
        W = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds56);
        X = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2);
        Y = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds20);
        Z = yi.g(TbadkApplication.getInst(), R.dimen.tbds600);
    }

    public final int I() {
        InterceptResult invokeV;
        RecyclerView recyclerView;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.p.a() <= 0 || this.A <= 0 || (recyclerView = this.n) == null || (viewGroup = (ViewGroup) recyclerView.getChildAt(0)) == null || viewGroup.findViewById(R.id.obfuscated_res_0x7f090d6c) == null || (viewGroup2 = (ViewGroup) viewGroup.findViewById(R.id.obfuscated_res_0x7f090d6c)) == null || viewGroup2.getChildAt(0) == null) {
                return 0;
            }
            return viewGroup2.getChildAt(0).getHeight() * (this.A + 1);
        }
        return invokeV.intValue;
    }

    public final void L() {
        ViewGroup viewGroup;
        gh7 gh7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (viewGroup = (ViewGroup) this.o.findViewByPosition(this.B)) != null) {
            RecyclerView recyclerView = (RecyclerView) viewGroup.findViewById(R.id.obfuscated_res_0x7f090d6c);
            this.G = recyclerView;
            if (recyclerView != null && recyclerView.getChildAt(this.A) != null && (gh7Var = this.E) != null && gh7Var.b() != null) {
                this.E.b().setLocationScrolled(true);
                this.G.getAdapter().notifyItemChanged(this.A);
                this.G.postDelayed(this.V, 3000L);
            }
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            pg7 pg7Var = this.P;
            if (pg7Var != null) {
                pg7Var.j();
            }
            tg7 tg7Var = this.p;
            if (tg7Var != null) {
                tg7Var.n();
            }
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                if (recyclerView.getRecycledViewPool() != null) {
                    this.n.getRecycledViewPool().clear();
                }
                this.n.removeAllViews();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003023, "show_ok"));
            E();
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            J();
            if (this.O == null) {
                this.O = new la5(this.a, this.R);
            }
            this.O.k(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds300));
            this.O.attachView(this.N, true);
            this.O.p();
            this.O.onChangeSkinType();
            this.O.f(R.color.transparent);
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.L == null) {
                this.L = NoDataViewFactory.b(this.a, this.M, NoDataViewFactory.d.b(NoDataViewFactory.ImgType.WEBVIEW, 400), NoDataViewFactory.e.d(null, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0849)), null, true);
            }
            this.L.f(this.b, TbadkApplication.getInst().getSkinType());
            this.L.setVisibility(0);
        }
    }

    public sg7(TbPageContext tbPageContext, long j, String str, long j2, List<Long> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Long.valueOf(j), str, Long.valueOf(j2), list, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.z = new ArrayList();
        this.A = 0;
        this.B = 0;
        this.C = 0;
        this.G = null;
        this.H = "1";
        this.J = false;
        this.K = new a(this);
        this.R = new b(this);
        this.S = new c(this);
        this.T = new d(this);
        this.U = new e(this, 2001266);
        this.V = new h(this);
        this.a = tbPageContext.getContext();
        this.b = tbPageContext;
        this.v = j;
        this.w = str;
        this.x = j2;
        if (list != null) {
            this.z.addAll(list);
        }
        this.y = z;
        MessageManager.getInstance().registerListener(this.U);
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.x = -1L;
        }
    }

    public final String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.H;
        }
        return (String) invokeV.objValue;
    }

    public final int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            RelativeLayout relativeLayout = this.M;
            if (relativeLayout != null && this.n != null) {
                return (relativeLayout.getHeight() / 2) - this.n.getTop();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public void J() {
        ka5 ka5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && (ka5Var = this.Q) != null) {
            ka5Var.dettachView(this.N);
        }
    }

    public void K() {
        la5 la5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (la5Var = this.O) != null) {
            la5Var.dettachView(this.N);
            this.O = null;
        }
    }

    public void O() {
        RecyclerView recyclerView;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            pg7 pg7Var = this.P;
            if (pg7Var != null) {
                pg7Var.h();
            }
            Runnable runnable = this.V;
            if (runnable != null && (recyclerView = this.G) != null) {
                recyclerView.removeCallbacks(runnable);
            }
            MessageManager.getInstance().unRegisterListener(this.U);
        }
    }

    public void Q() {
        pg7 pg7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && (pg7Var = this.P) != null) {
            pg7Var.d();
        }
    }

    public void R() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            pg7 pg7Var = this.P;
            if (pg7Var != null) {
                pg7Var.i();
            }
            tg7 tg7Var = this.p;
            if (tg7Var != null) {
                tg7Var.k();
            }
        }
    }

    public final void S() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.P != null) {
                W();
                this.P.r(this.z, TbadkCoreApplication.getCurrentAccount(), String.valueOf(this.v));
            } else {
                Y();
            }
            D();
        }
    }

    public void V() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            if (this.f == null) {
                M();
            }
            this.f.show();
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            RecyclerView recyclerView = this.n;
            if (recyclerView != null) {
                recyclerView.setVisibility(8);
            }
            if (this.Q == null) {
                ka5 ka5Var = new ka5(this.a);
                this.Q = ka5Var;
                ka5Var.onChangeSkinType();
            }
            this.Q.attachView(this.N);
        }
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", this.v);
            statisticItem.param("fname", this.w);
            statisticItem.param("obj_source", F());
            TiebaStatic.log(statisticItem);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(3, R.id.obfuscated_res_0x7f090d64);
            layoutParams.leftMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X008);
            layoutParams.topMargin = yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
            this.j.setLayoutParams(layoutParams);
        }
    }

    public final int H() {
        InterceptResult invokeV;
        tg7 tg7Var;
        gh7 gh7Var;
        ChatRoomInfo b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.x > 0 && (tg7Var = this.p) != null && !ListUtils.isEmpty(tg7Var.d())) {
                List<wg7> d2 = this.p.d();
                for (wg7 wg7Var : d2) {
                    if (wg7Var != null && (wg7Var instanceof fh7)) {
                        fh7 fh7Var = (fh7) wg7Var;
                        List<wg7> e2 = fh7Var.e();
                        if (ListUtils.isEmpty(e2)) {
                            continue;
                        } else {
                            for (wg7 wg7Var2 : e2) {
                                if (wg7Var2 != null && (wg7Var2 instanceof gh7) && (b2 = (gh7Var = (gh7) wg7Var2).b()) != null && this.x == b2.getRoomId()) {
                                    this.A = e2.indexOf(wg7Var2);
                                    this.B = d2.indexOf(wg7Var);
                                    this.E = gh7Var;
                                    this.F = fh7Var;
                                    fh7Var.j(false);
                                    return d2.indexOf(wg7Var);
                                }
                            }
                            continue;
                        }
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || !(this.a instanceof TbPageContextSupport)) {
            return;
        }
        this.f = new f(this, this.a, R.style.obfuscated_res_0x7f1000fa);
        this.g = (FrameLayout) LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d038e, (ViewGroup) null);
        GreyUtil.grey(this.f);
        if (UtilHelper.isFoldScreen()) {
            this.f.getBehavior().setSkipCollapsed(true);
            this.f.getBehavior().setState(3);
        }
        this.h = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090d6f);
        this.i = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090d5a);
        this.D = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090d5c);
        this.M = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091769);
        this.N = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f091773);
        this.s = this.g.findViewById(R.id.obfuscated_res_0x7f090d70);
        this.m = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f090d6d);
        this.t = this.g.findViewById(R.id.obfuscated_res_0x7f09101d);
        this.u = this.g.findViewById(R.id.obfuscated_res_0x7f0913be);
        this.n = (RecyclerView) this.g.findViewById(R.id.obfuscated_res_0x7f090d59);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a);
        this.o = linearLayoutManager;
        this.n.setLayoutManager(linearLayoutManager);
        tg7 tg7Var = new tg7(this.b, this.v, this.y);
        this.p = tg7Var;
        tg7Var.o(new g(this));
        ug7 ug7Var = new ug7(null);
        this.r = ug7Var;
        ChatRoomRecycleAdapter chatRoomRecycleAdapter = new ChatRoomRecycleAdapter(ug7Var, this.p, this.b);
        this.q = chatRoomRecycleAdapter;
        this.n.setAdapter(chatRoomRecycleAdapter);
        this.n.removeOnScrollListener(this.T);
        this.n.addOnScrollListener(this.T);
        TextView textView = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f090d62);
        this.k = textView;
        this.k.setText(bh7.a(this.w, "...吧", bh7.c(Z), textView.getPaint(), "吧"));
        this.j = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f090d50);
        this.l = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091a09);
        this.c = (RelativeLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0906d1);
        this.d = (TbImageAutoSwitch) this.g.findViewById(R.id.obfuscated_res_0x7f0906d2);
        HeadImageView headImageView = (HeadImageView) this.g.findViewById(R.id.obfuscated_res_0x7f0906d6);
        this.e = headImageView;
        headImageView.setPlaceHolder(1);
        this.e.setIsRound(true);
        this.e.setBorderWidth(SelectorHelper.getResources().getDimensionPixelSize(R.dimen.L_X02));
        this.e.setBorderColor(R.color.CAM_X0101);
        this.e.setDrawBorder(true);
        this.e.setScaleType(ImageView.ScaleType.FIT_XY);
        TbImageAutoSwitch tbImageAutoSwitch = this.d;
        int i = W;
        tbImageAutoSwitch.l(4, i, i, Y);
        this.d.setAnimationDuration(500);
        this.d.setCarouselDelayPeriod(2000);
        this.d.setCarouselPeriod(2000);
        this.d.setAdapter(this.K);
        this.f.setContentView(this.g);
        if (this.f.getWindow() != null && this.f.getWindow().getAttributes() != null) {
            int i2 = this.f.getWindow().getAttributes().windowAnimations;
        }
        N(TbadkCoreApplication.getInst().getSkinType());
        int height = (((WindowManager) this.a.getSystemService("window")).getDefaultDisplay().getHeight() * 9) / 10;
        this.f.getBehavior().setPeekHeight(height);
        int dimenPixelSize = height - UtilHelper.getDimenPixelSize(R.dimen.tbds318);
        this.i.getLayoutParams().height = dimenPixelSize;
        this.t.getLayoutParams().height = dimenPixelSize;
        this.u.getLayoutParams().height = dimenPixelSize;
        this.N.getLayoutParams().height = dimenPixelSize;
        this.M.getLayoutParams().height = dimenPixelSize;
        this.P = new pg7(this.a, this.S);
    }

    public void N(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || this.f == null) {
            return;
        }
        rw4.d(this.g).n(R.string.obfuscated_res_0x7f0f0032);
        rw4 d2 = rw4.d(this.s);
        d2.m(0);
        d2.n(R.string.J_X03);
        d2.f(R.color.CAM_X0618);
        rw4 d3 = rw4.d(this.k);
        d3.v(R.color.CAM_X0101);
        d3.z(R.dimen.T_X04);
        d3.A(R.string.F_X02);
        rw4 d4 = rw4.d(this.l);
        d4.v(R.color.CAM_X0102);
        d4.z(R.dimen.T_X12);
        d4.A(R.string.F_X01);
        rw4.d(this.h).n(R.string.obfuscated_res_0x7f0f0032);
        rw4 d5 = rw4.d(this.t);
        d5.n(R.string.obfuscated_res_0x7f0f0032);
        d5.f(R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.m, R.drawable.obfuscated_res_0x7f0805e5);
        rw4.d(this.i).n(R.string.obfuscated_res_0x7f0f0032);
        rw4 d6 = rw4.d(this.D);
        d6.z(R.dimen.T_X07);
        d6.A(R.string.F_X02);
        d6.v(R.color.CAM_X0105);
    }

    public void T(long j, String str, long j2, List<Long> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Long.valueOf(j), str, Long.valueOf(j2), list, Boolean.valueOf(z)}) == null) {
            this.x = j2;
            this.v = j;
            this.w = str;
            this.y = z;
            if (!ListUtils.isEmpty(list)) {
                this.z.clear();
                this.z.addAll(list);
            }
        }
    }

    public void U() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int H = H();
            if (H >= 0 && this.n != null) {
                int findFirstVisibleItemPosition = this.o.findFirstVisibleItemPosition();
                int findLastVisibleItemPosition = this.o.findLastVisibleItemPosition();
                if (H >= findFirstVisibleItemPosition && H <= findLastVisibleItemPosition) {
                    this.J = false;
                    if (this.o.findViewByPosition(H) != null) {
                        i = this.o.findViewByPosition(H).getTop();
                    } else {
                        i = 0;
                    }
                    this.n.scrollBy(0, (i - G()) + I());
                    L();
                    return;
                }
                this.J = true;
                this.o.scrollToPosition(H);
                return;
            }
            LinearLayoutManager linearLayoutManager = this.o;
            if (linearLayoutManager != null && this.n != null) {
                linearLayoutManager.scrollToPosition(0);
            }
        }
    }
}
