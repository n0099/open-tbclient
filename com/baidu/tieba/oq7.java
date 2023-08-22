package com.baidu.tieba;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.abtest.helper.FrsTabTestHelper;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.PbListView;
import com.baidu.tbadk.core.view.UserPhotoLayout;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.mc.FrsNewAreaFragment;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBnt;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import tbclient.FrsTabInfo;
/* loaded from: classes7.dex */
public class oq7 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern s;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsNewAreaFragment a;
    public RelativeLayout b;
    public BdTypeRecyclerView c;
    public FrameLayout d;
    public PbListView e;
    public nq7 f;
    public BannerView g;
    public g25 h;
    public boolean i;
    public RelativeLayout j;
    public am7 k;
    public boolean l;
    public uwa m;
    public nn n;
    public BannerView.b o;
    public CustomMessageListener p;
    public CustomMessageListener q;
    public CustomMessageListener r;

    /* loaded from: classes7.dex */
    public class f extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ f a;

            public a(f fVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {fVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = fVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.s();
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(oq7 oq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var, Integer.valueOf(i)};
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
            this.a = oq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ThreadData threadData;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                List<bn> j = this.a.f.j();
                if (ListUtils.isEmpty(j)) {
                    return;
                }
                if (!ListUtils.isEmpty(j)) {
                    for (bn bnVar : j) {
                        if (bnVar instanceof c45) {
                            c45 c45Var = (c45) bnVar;
                            if (c45Var.u != 0 && (threadData = c45Var.t) != null) {
                                int[] imageWidthAndHeight = threadData.getImageWidthAndHeight();
                                c45Var.u = imageWidthAndHeight[0];
                                c45Var.v = imageWidthAndHeight[1];
                            }
                        }
                    }
                }
                SafeHandler.getInst().postDelayed(new a(this), 500L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements RecyclerView.RecyclerListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        public a(oq7 oq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq7Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            View view2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, viewHolder) == null) && (view2 = viewHolder.itemView) != null) {
                PlayVoiceBnt playVoiceBnt = (PlayVoiceBnt) view2.findViewById(R.id.abstract_voice);
                if (playVoiceBnt != null) {
                    playVoiceBnt.h();
                }
                FrsCommonImageLayout frsCommonImageLayout = (FrsCommonImageLayout) view2.findViewById(R.id.abstract_img_layout);
                if (frsCommonImageLayout != null) {
                    frsCommonImageLayout.p();
                }
                if (view2 instanceof UserPhotoLayout) {
                    ((UserPhotoLayout) view2).reset();
                }
                if (this.a.m != null) {
                    this.a.m.e(view2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }

        public b(oq7 oq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq7Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, str, z) != null) || !z || !this.a.g.i() || this.a.i || this.a.c == null) {
                return;
            }
            this.a.i = true;
            this.a.c.addHeaderView(this.a.g, 1);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        public c(oq7 oq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq7Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.y();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) {
                return;
            }
            this.a.j();
        }
    }

    /* loaded from: classes7.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        public d(oq7 oq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.removeHeaderView(this.a.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        public e(oq7 oq7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oq7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.c.removeHeaderView(this.a.j);
                this.a.c.addHeaderView(this.a.j, 0);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(oq7 oq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var, Integer.valueOf(i)};
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
            this.a = oq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.A(str);
                this.a.z(str);
                this.a.f.o();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class h extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oq7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(oq7 oq7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oq7Var, Integer.valueOf(i)};
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
            this.a = oq7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) {
                return;
            }
            this.a.l();
        }
    }

    /* loaded from: classes7.dex */
    public static /* synthetic */ class i {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-538378065, "Lcom/baidu/tieba/oq7$i;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-538378065, "Lcom/baidu/tieba/oq7$i;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948040980, "Lcom/baidu/tieba/oq7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948040980, "Lcom/baidu/tieba/oq7;");
                return;
            }
        }
        s = Pattern.compile("(/p/){1}(\\d+)");
    }

    public boolean B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.l) {
                return false;
            }
            this.e.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bea));
            this.e.g();
            return true;
        }
        return invokeV.booleanValue;
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ih7 ih7Var = new ih7();
            ih7Var.a = 503;
            ih7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ih7Var));
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.c.setVisibility(0);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.c.setNextPage(this.e);
            this.e.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.e.U();
        }
    }

    public void O() {
        uwa uwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048590, this) == null) && (uwaVar = this.m) != null) {
            uwaVar.i(2000);
        }
    }

    public void P() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            ih7 ih7Var = new ih7();
            ih7Var.a = 503;
            ih7Var.b = true;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ih7Var));
        }
    }

    public nq7 m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.f;
        }
        return (nq7) invokeV.objValue;
    }

    public BdTypeRecyclerView n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.c;
        }
        return (BdTypeRecyclerView) invokeV.objValue;
    }

    public RelativeLayout o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.b;
        }
        return (RelativeLayout) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.c.setNextPage(null);
        }
    }

    public void s() {
        nq7 nq7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048601, this) == null) && (nq7Var = this.f) != null) {
            nq7Var.l();
        }
    }

    public void t() {
        uwa uwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048602, this) == null) && (uwaVar = this.m) != null) {
            uwaVar.d();
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.f.n();
            this.c.setOnSrollToBottomListener(null);
        }
    }

    public void y() {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (bannerView = this.g) != null) {
            this.i = false;
            this.c.removeHeaderView(bannerView);
        }
    }

    public oq7(FrsNewAreaFragment frsNewAreaFragment, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsNewAreaFragment, view2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.g = null;
        this.i = false;
        this.l = true;
        this.o = new c(this);
        this.p = new f(this, 2921414);
        this.q = new g(this, 2016331);
        this.r = new h(this, 2921746);
        this.a = frsNewAreaFragment;
        r(view2);
    }

    public void D(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048579, this, z) == null) && !z) {
            ih7 ih7Var = new ih7();
            ih7Var.a = 503;
            ih7Var.b = false;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921449, ih7Var));
        }
    }

    public void E(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            FrameLayout frameLayout = this.d;
            if (z) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            frameLayout.setVisibility(i2);
        }
    }

    public void F(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.c.setSelection(i2);
        }
    }

    public void H(ln lnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, lnVar) == null) {
            this.f.t(lnVar);
        }
    }

    public void I(RecyclerView.OnScrollListener onScrollListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, onScrollListener) == null) {
            this.c.setOnScrollListener(onScrollListener);
        }
    }

    public void J(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            ph7 ph7Var = new ph7();
            ph7Var.a = 503;
            ph7Var.c = z;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(9205410, ph7Var));
        }
    }

    public void z(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048608, this, str) == null) && this.a.D2() != null) {
            this.a.D2().a0(str);
        }
    }

    public void u(int i2, int i3) {
        uwa uwaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeII(1048603, this, i2, i3) == null) && (uwaVar = this.m) != null) {
            uwaVar.i(100);
        }
    }

    public void A(String str) {
        ThreadData threadData;
        xfa xfaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && !StringUtils.isNull(str) && !ListUtils.isEmpty(this.f.j())) {
            Iterator<bn> it = this.f.j().iterator();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (it.hasNext()) {
                i2++;
                bn next = it.next();
                if ((i3 + 1 == i2 || i4 + 1 == i2) && (next instanceof z56)) {
                    it.remove();
                }
                if (next instanceof e36) {
                    e36 e36Var = (e36) next;
                    if ((e36Var.a() instanceof AdvertAppInfo) && str.equals(((AdvertAppInfo) e36Var.a()).a)) {
                        it.remove();
                        i3 = i2;
                    }
                } else if ((next instanceof c45) && (threadData = ((c45) next).t) != null && (xfaVar = threadData.funAdData) != null && xfaVar.i()) {
                    it.remove();
                    i4 = i2;
                }
            }
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.l = z;
            if (z) {
                this.e.H(TbadkCoreApplication.getInst().getContext().getResources().getString(R.string.load_more));
                BdTypeRecyclerView bdTypeRecyclerView = this.c;
                if (bdTypeRecyclerView.getChildAt(bdTypeRecyclerView.getChildCount() - 1) == this.e.c()) {
                    this.e.U();
                    this.a.c();
                    return;
                }
                this.e.g();
                return;
            }
            this.e.H(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0bea));
            this.e.g();
        }
    }

    public final List<FrsTabInfo> k(FrsViewData frsViewData) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, frsViewData)) == null) {
            Iterator<FrsTabInfo> it = frsViewData.getEntelechyTabInfo().a.iterator();
            while (true) {
                if (it.hasNext()) {
                    FrsTabInfo next = it.next();
                    if (next.tab_id.intValue() == 503) {
                        i2 = next.tab_type.intValue();
                        break;
                    }
                } else {
                    i2 = -1;
                    break;
                }
            }
            if (i2 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (FrsTabInfo frsTabInfo : frsViewData.getEntelechyTabInfo().b) {
                if (frsTabInfo.tab_type.intValue() == i2) {
                    arrayList.add(frsTabInfo);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public void K(ArrayList<bn> arrayList, int i2, FrsViewData frsViewData, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{arrayList, Integer.valueOf(i2), frsViewData, Integer.valueOf(i3)}) == null) {
            ArrayList<bn> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            if (switchThreadDataToThreadCardInfo == null || switchThreadDataToThreadCardInfo.size() <= 0) {
                gh7 gh7Var = new gh7();
                ArrayList<bn> arrayList2 = new ArrayList<>();
                arrayList2.add(gh7Var);
                switchThreadDataToThreadCardInfo = arrayList2;
            }
            if (frsViewData != null && frsViewData.getEntelechyTabInfo() != null) {
                List<FrsTabInfo> k = k(frsViewData);
                if (ListUtils.isEmpty(k)) {
                    if (this.j != null) {
                        this.n.e(new d(this));
                    }
                } else if (this.j != null) {
                    this.n.e(new e(this));
                }
                if (frsViewData != null && frsViewData.getIsBrandForum()) {
                    FrsTabInfo frsTabInfo = (FrsTabInfo) ListUtils.getItem(k, 0);
                    if (frsViewData != null && this.a.E2() != null && frsTabInfo != null) {
                        this.a.E2().d0(frsTabInfo.tab_id.intValue());
                    }
                } else if (this.k != null && frsViewData.getForum() != null) {
                    this.k.i(k);
                    this.k.j(frsViewData.getForum().getId());
                    if (UbsABTestHelper.isFrsNewAreaTabSortTestA() && FrsTabTestHelper.HAVE_NOT_RECORD_SORT != FrsTabTestHelper.getFrsNewAreaTabSort()) {
                        this.k.g(iv7.d(FrsTabTestHelper.getFrsNewAreaTabSort()));
                    }
                }
            }
            this.f.p(switchThreadDataToThreadCardInfo, frsViewData);
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.c.setNextPage(this.e);
            this.e.P(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
            this.e.g();
            this.e.H(this.a.getResources().getString(R.string.list_has_no_more));
        }
    }

    public final void j() {
        g25 g25Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || (g25Var = this.h) == null) {
            return;
        }
        String d2 = g25Var.d();
        if (this.h.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2902014, new FacePackageDetailActivityConfig(this.a.getPageContext().getPageActivity(), d2, false, "frs_banner")));
        } else if (this.h.a() == 2) {
            if (d2.contains("tieba.baidu.com")) {
                Matcher matcher = s.matcher(d2);
                if (matcher.find()) {
                    try {
                        String group = matcher.group(2);
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(group, null, "frs_banner");
                        createNormalCfg.setForumId(group);
                        createNormalCfg.setStartFrom(3);
                        this.a.sendMessage(new CustomMessage(2004001, createNormalCfg));
                    } catch (Exception e2) {
                        BdLog.e(e2.toString());
                    }
                }
            }
        } else if (this.h.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = i.a[nativePageType.ordinal()];
                if (i2 != 1) {
                    if (i2 == 2) {
                        PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                        createNormalCfg2.setForumId(isNativeAddress.id);
                        createNormalCfg2.setStartFrom(3);
                        this.a.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                        return;
                    }
                    return;
                }
                this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                return;
            }
            UrlManager.getInstance().dealOneLink(this.a.getPageContext(), new String[]{d2});
            if (!StringUtils.isNull(d2) && d2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
            }
        } else if (this.h.a() == 4) {
            this.a.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.a.getPageContext().getPageActivity()).createNormalCfg(d2, "frs_banner")));
        }
    }

    public final void l() {
        ThreadData threadData;
        xfa xfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            nq7 nq7Var = this.f;
            if (nq7Var != null && !ListUtils.isEmpty(nq7Var.j())) {
                Iterator<bn> it = this.f.j().iterator();
                while (it.hasNext()) {
                    bn next = it.next();
                    if (!(next instanceof e36) && !(next instanceof z56)) {
                        if ((next instanceof c45) && (threadData = ((c45) next).t) != null && (xfaVar = threadData.funAdData) != null) {
                            xfaVar.p(true);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }
            }
            z(null);
            this.f.o();
        }
    }

    public final void q(g25 g25Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048599, this, g25Var) != null) || this.g != null) {
            return;
        }
        this.g = new BannerView(this.a.getPageContext().getPageActivity());
        this.g.setLayoutParams(new AbsListView.LayoutParams(-1, this.a.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f07019a)));
        this.g.setVisibility(8);
        this.g.setBannerViewClickListener(this.o);
        this.g.setBannerData(g25Var);
        this.g.setBannerViewEvent(new b(this));
    }

    public void v(int i2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            nq7 nq7Var = this.f;
            if (nq7Var != null) {
                nq7Var.v();
                this.f.l();
                this.f.m(i2);
            }
            BDLayoutMode layoutMode = this.a.getBaseFragmentActivity().getLayoutMode();
            if (i2 == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.a.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.b);
            BannerView bannerView = this.g;
            if (bannerView != null) {
                bannerView.j();
            }
            PbListView pbListView = this.e;
            if (pbListView != null) {
                pbListView.J(SkinManager.getColor(R.color.CAM_X0107));
                this.e.e(i2);
            }
            this.k.h();
        }
    }

    public final void r(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, view2) == null) {
            this.b = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f090cbb);
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) view2.findViewById(R.id.obfuscated_res_0x7f090cbd);
            this.c = bdTypeRecyclerView;
            bdTypeRecyclerView.setLayoutManager(new LinearLayoutManager(bdTypeRecyclerView.getContext()));
            this.c.setFadingEdgeLength(0);
            this.c.setOverScrollMode(2);
            this.c.setRecyclerListener(new a(this));
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            BdTypeRecyclerView bdTypeRecyclerView2 = this.c;
            bdTypeRecyclerView2.setPadding(dimenPixelSize, bdTypeRecyclerView2.getPaddingTop(), dimenPixelSize, this.c.getPaddingBottom());
            this.n = new nn(this.c);
            PbListView pbListView = new PbListView(this.a.getPageContext().getPageActivity());
            this.e = pbListView;
            pbListView.a();
            this.e.s(R.color.transparent);
            this.e.w(BdUtilHelper.getDimens(this.a.getActivity(), R.dimen.tbds182));
            this.e.B();
            this.e.L(R.dimen.tbfontsize33);
            this.e.J(SkinManager.getColor(R.color.CAM_X0107));
            this.e.F(R.color.CAM_X0110);
            this.c.setOnSrollToBottomListener(this.a);
            this.d = (FrameLayout) view2.findViewById(R.id.obfuscated_res_0x7f090d1e);
            this.f = new nq7(this.a, this.c);
            D(false);
            this.j = new RelativeLayout(this.a.getContext());
            this.j.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.k = new am7(this.a, this.j);
            this.a.registerListener(this.p);
            this.a.registerListener(this.q);
            this.a.registerListener(this.r);
            if (this.m == null) {
                this.m = new uwa(this.a.getPageContext(), this.c);
            }
        }
    }

    public void x(ForumData forumData, UserData userData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048606, this, forumData, userData) != null) || this.i || forumData == null || forumData.getFrsBannerData() == null || !forumData.getFrsBannerData().e()) {
            return;
        }
        g25 frsBannerData = forumData.getFrsBannerData();
        this.h = frsBannerData;
        q(frsBannerData);
        this.g.k();
        this.c.removeHeaderView(this.g);
        if (this.h.getType() == 1 && !TextUtils.isEmpty(this.h.b())) {
            this.g.setData(this.a.getPageContext(), this.h.b());
            if (this.h.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                TiebaStatic.eventStat(this.a.getPageContext().getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
            }
        }
    }
}
