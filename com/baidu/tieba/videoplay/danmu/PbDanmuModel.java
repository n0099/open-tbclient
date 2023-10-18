package com.baidu.tieba.videoplay.danmu;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.ad;
import com.baidu.tieba.jj9;
import com.baidu.tieba.lc5;
import com.baidu.tieba.mx4;
import com.baidu.tieba.oca;
import com.baidu.tieba.oea;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalRequestMessage;
import com.baidu.tieba.pb.pb.main.pbPageHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.pbPageSocketResponseMessage;
import com.baidu.tieba.pea;
import com.baidu.tieba.rb5;
import com.baidu.tieba.tz9;
import com.baidu.tieba.uj9;
import com.baidu.tieba.wea;
import com.baidu.tieba.ye9;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes8.dex */
public class PbDanmuModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_HOT = "_hot";
    public static final String DB_KEY_REVER = "_rev";
    public static final int MIN_NUM_SHOW_GO_BACK_ITEM = 3;
    public static final int SORT_TYPE_ASC = 0;
    public static final int SORT_TYPE_DESC = 1;
    public static final int SORT_TYPE_HOT = 2;
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean A0;
    public String B;
    public boolean B0;
    public ye9 C;
    public String C0;
    public int D;
    public String D0;
    public int E;
    public String E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public BdUniDispatchSchemeController.OnSchemeParsedCallback G0;
    public boolean H;
    public CustomMessageListener H0;
    public String I;
    public NetMessageListener I0;
    public g J;
    public CustomMessageListener J0;
    public String K;
    public CustomMessageListener K0;
    public String L;
    public PraiseData L0;
    public String M;
    public String N;
    public int O;
    public int P;
    public boolean Q;
    public wea R;
    public TbPageContext<BaseFragmentActivity> S;

    /* renamed from: T  reason: collision with root package name */
    public boolean f1169T;
    public boolean U;
    public long V;
    public boolean W;
    public boolean X;
    public String Y;
    public boolean Z;
    public int a;
    public int a0;
    public String b;
    public boolean b0;
    public String c;
    public boolean c0;
    public String d;
    public final jj9 d0;
    public String e;
    public boolean e0;
    public boolean f;
    public int f0;
    public boolean g;
    public String g0;
    public boolean h;
    public pea h0;
    public boolean i;
    public pea i0;
    public boolean isLoading;
    public int j;
    public int j0;
    public int k;
    public int l;
    public int m;
    public String mStType;
    public long n;
    public int o;
    public int p;
    public int q;
    public int r;
    public boolean r0;
    public boolean s;
    public oea s0;
    public boolean t;
    public String t0;
    public boolean u;
    public String u0;
    public boolean v;
    public int v0;
    public boolean w;
    public String w0;
    public boolean x;
    public String x0;
    public boolean y;
    public String y0;
    public long z;
    public int z0;

    /* loaded from: classes8.dex */
    public interface g {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(ye9 ye9Var);

        void c(boolean z, int i, int i2, int i3, ye9 ye9Var, String str, int i4);
    }

    public final int P0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            if (i != 1) {
                return i != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes8.dex */
    public class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        public a(PbDanmuModel pbDanmuModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbDanmuModel;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.OnSchemeParsedCallback
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, hashMap) != null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                this.a.b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                this.a.t0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.u0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.v0 = JavaTypesHelper.toInt((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.w0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbDanmuModel pbDanmuModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i)};
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
            this.a = pbDanmuModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                SignData signData = (SignData) customResponsedMessage.getData();
                if (this.a.y0() != null && this.a.y0().k() != null && this.a.y0().k().getSignData() != null && signData.forumId.equals(this.a.y0().l())) {
                    this.a.y0().k().getSignData().is_signed = signData.is_signed;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbDanmuModel pbDanmuModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbDanmuModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((!z2 && !(responsedMessage instanceof pbPageHttpResponseMessage)) || responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId()) {
                    return;
                }
                if (responsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.S.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    this.a.K0((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    this.a.J0((pbPageHttpResponseMessage) responsedMessage);
                    z = true;
                } else {
                    z = false;
                }
                if (responsedMessage.getError() != 0) {
                    long j = 0;
                    if (!z) {
                        j = ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                    }
                    PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                    long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                    int cmd = responsedMessage.getOrginalMessage().getCmd();
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    Object[] objArr = new Object[6];
                    objArr[0] = "updateType";
                    String str2 = null;
                    if (pbPageRequestMessage != null) {
                        str = String.valueOf(pbPageRequestMessage.getUpdateType());
                    } else {
                        str = null;
                    }
                    objArr[1] = str;
                    objArr[2] = "ThreadId";
                    if (pbPageRequestMessage != null) {
                        str2 = String.valueOf(pbPageRequestMessage.get_kz());
                    }
                    objArr[3] = str2;
                    objArr[4] = PushConstants.SEQ_ID;
                    objArr[5] = Long.valueOf(j);
                    Logger.addLog("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                }
                if (!this.a.f1169T || !this.a.U) {
                    if (!this.a.f1169T) {
                        this.a.f1169T = true;
                    } else {
                        this.a.U = true;
                    }
                    if (this.a.J != null) {
                        this.a.J.a(this.a.z0(), z, responsedMessage, this.a.W, System.currentTimeMillis() - this.a.V);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbDanmuModel pbDanmuModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i)};
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
            this.a = pbDanmuModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                ye9 ye9Var = this.a.C;
                if (ye9Var != null && ye9Var.g() != null && this.a.C.g().b() != null && this.a.C.g().b().equals(valueOf)) {
                    this.a.C.g().o(false);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbDanmuModel pbDanmuModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i)};
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
            this.a = pbDanmuModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                ye9 ye9Var = this.a.C;
                if (ye9Var != null && ye9Var.g() != null && this.a.C.g().b() != null && this.a.C.g().b().equals(valueOf)) {
                    this.a.C.g().o(true);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ye9 a;
        public final /* synthetic */ PbDanmuModel b;

        public f(PbDanmuModel pbDanmuModel, ye9 ye9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, ye9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbDanmuModel;
            this.a = ye9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.M0(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.b.isLoading = false;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbDanmuModel(TbPageContext<BaseFragmentActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 4;
        this.mStType = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.f = false;
        this.g = false;
        this.h = true;
        this.i = true;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = 0L;
        this.o = 1;
        this.p = 1;
        this.q = 1;
        this.r = 1;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = 0L;
        this.A = false;
        this.B = null;
        this.C = null;
        this.isLoading = false;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = -1;
        this.P = -1;
        this.R = null;
        this.f1169T = false;
        this.U = false;
        this.Y = null;
        this.Z = false;
        this.a0 = -1;
        this.c0 = false;
        this.e0 = false;
        this.f0 = 0;
        this.z0 = 0;
        this.H0 = new b(this, 2001222);
        this.I0 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.J0 = new d(this, 2001336);
        this.K0 = new e(this, 2001335);
        this.L0 = null;
        registerListener(this.I0);
        registerListener(this.H0);
        registerListener(this.K0);
        registerListener(this.J0);
        ye9 ye9Var = new ye9();
        this.C = ye9Var;
        ye9Var.F0(0);
        this.S = tbPageContext;
        this.d0 = new jj9();
        this.G0 = new a(this);
    }

    public boolean F0(boolean z) {
        InterceptResult invokeZ;
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (this.b == null || (ye9Var = this.C) == null) {
                return false;
            }
            if (!z && ye9Var.y().b() == 0) {
                return false;
            }
            return S0(1);
        }
        return invokeZ.booleanValue;
    }

    public void Q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.o = i;
            this.p = i;
            this.q = i;
        }
    }

    public void U0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048602, this, i) == null) {
            this.z0 = i;
        }
    }

    public void W0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, gVar) == null) {
            this.J = gVar;
        }
    }

    public void Y0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.a = i;
        }
    }

    public final void a1(@NonNull ye9 ye9Var) {
        ye9 ye9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048611, this, ye9Var) == null) && (ye9Var2 = this.C) != null) {
            ye9Var2.d().clear();
            this.C.d().addAll(ye9Var.d());
        }
    }

    public void n0(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, ye9Var) != null) || ye9Var == null) {
            return;
        }
        if (this.H || this.F || this.G) {
            Z0(ye9Var);
        }
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.D;
        }
        return invokeV.intValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return D0();
        }
        return invokeV.booleanValue;
    }

    public final boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int i = this.j;
            if (i != 0 && i != 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.b != null && this.c != null) {
                cancelMessage();
                if (this.w) {
                    return S0(4);
                }
                return S0(6);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.Y;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.E0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.C0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.D0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.B0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.F0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (!TextUtils.isEmpty(this.c) && !"0".equals(this.c)) {
                return G0();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.B;
        }
        return (String) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.g;
        }
        return invokeV.booleanValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.w;
        }
        return invokeV.booleanValue;
    }

    public int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.f0;
        }
        return invokeV.intValue;
    }

    public ye9 y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.C;
        }
        return (ye9) invokeV.objValue;
    }

    public void C0(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, intent) != null) || intent == null) {
            return;
        }
        this.b = intent.getStringExtra("thread_id");
        this.t0 = intent.getStringExtra("key_ori_ugc_nid");
        this.u0 = intent.getStringExtra("key_ori_ugc_tid");
        this.v0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.w0 = intent.getStringExtra("key_ori_ugc_vid");
        this.y0 = intent.getStringExtra("key_official_bar_message_id");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        this.x0 = str;
        this.A0 = false;
        boolean z = true;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.A0 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.G0);
        } else if (StringUtils.isNull(this.b)) {
            this.A0 = true;
            this.d0.b(intent, this.G0);
            if (uri != null) {
                if (StringUtils.isNull(this.b)) {
                    this.b = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.t0)) {
                    this.t0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.u0)) {
                    this.u0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.v0 == 0) {
                    this.v0 = JavaTypesHelper.toInt(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.w0)) {
                    this.w0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        String str2 = "0";
        if (ad.isEmpty(this.b)) {
            this.b = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.f0 = intExtra;
        if (intExtra == 0) {
            this.f0 = this.d0.a;
        }
        this.c = intent.getStringExtra("post_id");
        this.d = intent.getStringExtra("forum_id");
        this.e = intent.getStringExtra("from_forum_id");
        this.f = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.g = intent.getBooleanExtra("host_only", false);
        this.i = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.j = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = SharedPrefHelper.getInstance().getInt("key_pb_current_sort_type", 2);
        }
        this.j = intExtra2;
        if (intExtra2 != 2) {
            str2 = this.c;
        }
        this.c = str2;
        this.mStType = intent.getStringExtra("st_type");
        this.I = intent.getStringExtra("locate");
        this.l = intent.getIntExtra("is_good", 0);
        this.m = intent.getIntExtra("is_top", 0);
        this.n = intent.getLongExtra("thread_time", 0L);
        this.w = intent.getBooleanExtra("from_mark", false);
        this.x = intent.getBooleanExtra("KEY_SHOULD_ADD_POST_ID", false);
        this.y = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.s = intent.getBooleanExtra("is_ad", false);
        this.t = intent.getBooleanExtra("is_sub_pb", false);
        this.A = intent.getBooleanExtra("is_pv", false);
        this.z = intent.getLongExtra("msg_id", 0L);
        this.B = intent.getStringExtra("from_forum_name");
        this.N = intent.getStringExtra("extra_pb_cache_key");
        this.K = intent.getStringExtra("op_type");
        this.L = intent.getStringExtra("op_url");
        this.M = intent.getStringExtra("op_stat");
        this.F = intent.getBooleanExtra("is_from_thread_config", false);
        this.G = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.H = intent.getBooleanExtra("is_from_my_god_config", false);
        this.P = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.O = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.u = intent.getBooleanExtra("from_frs", false);
        this.v = intent.getBooleanExtra("from_maintab", false);
        this.c0 = intent.getBooleanExtra("from_smart_frs", false);
        this.r0 = intent.getBooleanExtra("key_is_share_thread", false);
        intent.getBooleanExtra("key_need_preload", false);
        if (intent.getIntExtra("request_code", -1) != 18003) {
            z = false;
        }
        this.Q = z;
        this.B0 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.C0 = intent.getStringExtra("key_tieba_plus_order_id");
        this.D0 = intent.getStringExtra("key_tieba_plus_token");
        this.E0 = intent.getStringExtra("key_tieba_extra_param");
        this.F0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (x0() == 3 || y0() == null || y0().O() == null || !y0().O().isMutiForumThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void R0() {
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && (ye9Var = this.C) != null && !ListUtils.isEmpty(ye9Var.F())) {
            if (this.i0 != null) {
                this.C.F().remove(this.i0);
                this.i0 = null;
            }
            if (this.h0 != null) {
                this.C.F().remove(this.h0);
                this.h0 = null;
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            if (this.b == null) {
                return false;
            }
            cancelLoadData();
            if (this.R == null) {
                wea weaVar = new wea("pbStat");
                this.R = weaVar;
                weaVar.f();
            }
            boolean S0 = S0(3);
            if (this.K != null) {
                this.K = null;
                this.M = null;
                this.L = null;
            }
            return S0;
        }
        return invokeV.booleanValue;
    }

    public void H0(ye9 ye9Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048583, this, ye9Var, i, str) == null) {
            this.X = true;
            if (ye9Var != null && ye9Var.h == null) {
                c1(ye9Var);
                n0(ye9Var);
                if (ye9Var.O() != null) {
                    ye9Var.O().setCopyThreadRemindType(0);
                }
                g gVar = this.J;
                if (gVar != null && ye9Var != null) {
                    gVar.c(true, 0, i, 0, ye9Var, str, 0);
                }
            }
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            N0(i);
            ArrayList<pea> F = this.C.F();
            boolean z = false;
            this.W = false;
            if (i == 1) {
                boolean z2 = false;
                while (F.size() + 30 > rb5.a()) {
                    F.remove(0);
                    z2 = true;
                }
                if (z2) {
                    this.C.y().m(1);
                    g gVar = this.J;
                    if (gVar != null) {
                        gVar.b(this.C);
                    }
                }
                this.V = System.currentTimeMillis();
                this.W = true;
            } else if (i == 2) {
                while (F.size() + 30 > rb5.a()) {
                    F.remove(F.size() - 1);
                    z = true;
                }
                if (z) {
                    this.C.y().l(1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, str)) == null) {
            ye9 ye9Var = this.C;
            if (ye9Var != null && ye9Var.O() != null && this.C.k() != null) {
                WriteData writeData = new WriteData();
                if (this.C.O().isMutiForumThread()) {
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setForumId(this.C.k().getId());
                    writeData.setForumName(this.C.k().getName());
                }
                writeData.setFromForumId(this.e);
                writeData.sourceFrom = String.valueOf(this.f0);
                writeData.setThreadId(this.b);
                writeData.setIsAd(this.s);
                if (str == null) {
                    writeData.setType(1);
                } else {
                    writeData.setType(2);
                    writeData.setFloor(str);
                    writeData.setFloorNum(0);
                }
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public void J0(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, pbpagehttpresponsemessage) == null) {
            L0(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
        }
    }

    public void K0(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, pbpagesocketresponsemessage) == null) {
            L0(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
        }
    }

    public String O0(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, ye9Var)) == null) {
            String str = null;
            if (ye9Var == null) {
                return null;
            }
            if (ye9Var.O() != null && ye9Var.O().getAuthor() != null) {
                str = ye9Var.O().getAuthor().getUserId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public ye9 Z0(ye9 ye9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, ye9Var)) == null) {
            if (ye9Var == null) {
                return null;
            }
            ThreadData O = ye9Var.O();
            O.setIs_good(this.l);
            O.setIs_top(this.m);
            long j = this.n;
            if (j > 0) {
                O.setLast_time_int(j);
            }
            o0(O);
            return ye9Var;
        }
        return (ye9) invokeL.objValue;
    }

    public void c1(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048613, this, ye9Var) != null) || ye9Var == null) {
            return;
        }
        ye9Var.V0(this.C.Z());
        ye9 ye9Var2 = this.C;
        if (!ye9Var2.W && ye9Var.W && ye9Var2.h() != null) {
            ye9Var.I0(this.C.h());
        }
        this.C = ye9Var;
        Q0(ye9Var.y().a());
    }

    public void l0(mx4 mx4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, mx4Var) == null) {
            if (mx4Var == null) {
                Q0(1);
                return;
            }
            if (this.p < mx4Var.a()) {
                this.p = mx4Var.a();
            }
            if (this.q > mx4Var.a()) {
                this.q = mx4Var.a();
            }
            this.r = mx4Var.h();
        }
    }

    public final void m0(ye9 ye9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048619, this, ye9Var) == null) && ye9Var != null && ye9Var.z() != null && ye9Var.z().getAdvertAppInfo() != null && ye9Var.z().H1() && ye9Var.z().getAdvertAppInfo().c != 1001) {
            this.s0 = ye9Var.z();
        }
    }

    public void o0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = W();
            threadData.tiebaPlusOrderId = S();
            threadData.tiebaPlusToken = T();
            threadData.tiebaPlusExtraParam = T();
            threadData.tiebaplusCantDelete = X();
            threadData.setDispatchedForumIdWithString(N());
        }
    }

    public final String v0(ArrayList<pea> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048628, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                pea peaVar = (pea) ListUtils.getItem(arrayList, i);
                if (peaVar != null && !StringUtils.isNull(peaVar.U())) {
                    return peaVar.U();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void L0(ye9 ye9Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        ye9 ye9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{ye9Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                ye9Var2 = null;
            } else {
                ye9Var2 = ye9Var;
            }
            this.isLoading = false;
            if (ye9Var2 != null) {
                n0(ye9Var2);
            }
            m0(ye9Var2);
            oea oeaVar = this.s0;
            if (oeaVar != null && oeaVar.H1()) {
                TiebaStatic.log(oca.g("a005", "common_fill", true, 1));
            }
            M0(ye9Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void M0(ye9 ye9Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{ye9Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z5 = true;
            boolean z6 = !z;
            this.b0 = z3;
            wea weaVar = this.R;
            if (weaVar != null && !z3) {
                weaVar.b(z2, z6, i2, str, i3, j, j2);
                this.R = null;
            }
            ye9 ye9Var2 = this.C;
            if (ye9Var2 != null) {
                ye9Var2.Z = z3;
                ye9Var2.a0 = i;
            }
            if (z6 && !z3 && !TextUtils.isEmpty(s0()) && tz9.m().b() != null) {
                tz9.m().b().g(s0(), P0(A0()), true);
            }
            if (ye9Var != null && (this.o != 1 || i != 5 || ye9Var.F() == null || ye9Var.F().size() >= 1)) {
                this.h = this.i;
                if (i != 8) {
                    this.k = this.j;
                    this.j = ye9Var.g;
                }
                List<PbSortType> list = ye9Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.S.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    ye9Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.S.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    ye9Var.f.add(builder2.build(false));
                    int i6 = this.k;
                    this.j = i6;
                    ye9Var.g = i6;
                }
                this.A = false;
                if (ye9Var.y() != null && (this.j != 2 || i != 8)) {
                    l0(ye9Var.y());
                }
                int i7 = this.r;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.r = i7;
                ArrayList<pea> F = this.C.F();
                switch (i) {
                    case 1:
                        this.C.M0(ye9Var.y(), 1);
                        b1(ye9Var, F);
                        a1(ye9Var);
                        i4 = 0;
                        break;
                    case 2:
                        if (ye9Var.F() != null) {
                            i4 = ye9Var.F().size() + 1;
                            pea peaVar = (pea) ListUtils.getItem(F, 0);
                            pea peaVar2 = (pea) ListUtils.getItem(ye9Var.F(), ListUtils.getCount(ye9Var.F()) - 1);
                            if (peaVar != null && peaVar2 != null && peaVar.U().equals(peaVar2.U())) {
                                ye9Var.F().remove(peaVar2);
                                i4--;
                            }
                            F.addAll(0, ye9Var.F());
                        } else {
                            i4 = 0;
                        }
                        a1(ye9Var);
                        this.C.M0(ye9Var.y(), 2);
                        break;
                    case 3:
                        if (this.j == 1 && ye9Var.y() != null) {
                            ye9Var.y().k(ye9Var.y().h());
                        }
                        c1(ye9Var);
                        i4 = 0;
                        break;
                    case 4:
                        c1(ye9Var);
                        i4 = 0;
                        break;
                    case 5:
                        c1(ye9Var);
                        i4 = 0;
                        break;
                    case 6:
                        c1(ye9Var);
                        i4 = 0;
                        break;
                    case 7:
                        c1(ye9Var);
                        i4 = 0;
                        break;
                    case 8:
                        if (ye9Var != null && !ListUtils.isEmpty(ye9Var.F()) && this.C != null && (!this.g || O0(ye9Var).equals(ye9Var.F().get(0).t().getUserId()))) {
                            if (this.C.y().b() == 0) {
                                this.C.y().l(1);
                            }
                            R0();
                            this.h0 = ye9Var.F().get(0);
                            if (!D0() && !this.C.j0()) {
                                if (this.j0 >= 3) {
                                    pea peaVar3 = new pea();
                                    this.i0 = peaVar3;
                                    peaVar3.D = false;
                                    peaVar3.m1(53);
                                    this.C.F().add(0, this.i0);
                                }
                                this.C.F().add(0, this.h0);
                                i5 = 0;
                            } else {
                                if (this.C.F().size() - this.j0 >= 3) {
                                    pea peaVar4 = new pea();
                                    this.i0 = peaVar4;
                                    peaVar4.D = true;
                                    peaVar4.m1(53);
                                    this.C.F().add(this.i0);
                                }
                                this.C.F().add(this.h0);
                                i5 = this.C.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.h0.U = this.C.I();
                                SharedPrefHelper.getInstance().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        } else {
                            i5 = 0;
                        }
                        a1(ye9Var);
                        i4 = i5;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                ye9 ye9Var3 = this.C;
                if (ye9Var3 != null && ye9Var3.O() != null) {
                    PraiseData praise = this.C.O().getPraise();
                    if (this.L0 != null && !praise.isPriaseDataValid()) {
                        this.C.O().setPraise(this.L0);
                    } else {
                        PraiseData praise2 = this.C.O().getPraise();
                        this.L0 = praise2;
                        praise2.setPostId(this.C.O().getFirstPostId());
                    }
                    if (ye9Var.y() != null && ye9Var.y().a() == 1 && ye9Var.O() != null && ye9Var.O().getActDatas() != null && ye9Var.O().getActDatas().size() > 0) {
                        this.C.O().setActDatas(ye9Var.O().getActDatas());
                    }
                    this.C.O().setReply_num(ye9Var.O().getReply_num());
                    this.C.O().setAnchorLevel(ye9Var.O().getAnchorLevel());
                    this.C.O().setCopyThreadRemindType(ye9Var.O().getCopyThreadRemindType());
                    if (this.E == 33) {
                        this.C.O().getAuthor().setHadConcerned(ye9Var.O().getAuthor().hadConcerned());
                    }
                    if (ye9Var != null && ye9Var.O() != null) {
                        this.C.O().updateIsNotitle(ye9Var.O().getIsNoTitle());
                    }
                }
                ye9 ye9Var4 = this.C;
                if (ye9Var4 != null && ye9Var4.V() != null && ye9Var.V() != null) {
                    this.C.V().setBimg_end_time(ye9Var.V().getBimg_end_time());
                    this.C.V().setBimg_url(ye9Var.V().getBimg_url());
                    this.C.V().setDynamicUrl(ye9Var.V().getDynamicUrl());
                }
                if (ye9Var.y() != null && ye9Var.y().a() == 1 && ye9Var.Y() != null) {
                    this.C.U0(ye9Var.Y());
                }
                if (this.b0) {
                    if (this.C.O() != null && this.C.O().getAuthor() != null && this.C.F() != null && ListUtils.getItem(this.C.F(), 0) != null) {
                        pea peaVar5 = (pea) ListUtils.getItem(this.C.F(), 0);
                        MetaData author = this.C.O().getAuthor();
                        if (peaVar5.t() != null && peaVar5.t().getGodUserData() != null) {
                            int i8 = this.O;
                            if (i8 != -1) {
                                author.setFansNum(i8);
                                peaVar5.t().setFansNum(this.O);
                            }
                            if (this.P != -1) {
                                GodUserData godUserData = author.getGodUserData();
                                if (this.P == 1) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                godUserData.setIsLike(z4);
                                GodUserData godUserData2 = peaVar5.t().getGodUserData();
                                if (this.P != 1) {
                                    z5 = false;
                                }
                                godUserData2.setIsLike(z5);
                                author.getGodUserData().setIsFromNetWork(false);
                                peaVar5.t().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    ye9 ye9Var5 = this.C;
                    ye9Var5.e = -1;
                    ye9Var5.d = -1;
                }
                g gVar = this.J;
                if (gVar != null) {
                    gVar.c(true, getErrorCode(), i, i4, this.C, this.mErrorString, 1);
                }
            } else if (this.J != null) {
                this.i = this.h;
                if (i2 != 350006) {
                    this.j = this.k;
                }
                this.J.c(false, i2, i, 0, null, str, 1);
            }
            ye9 ye9Var6 = this.C;
            if (ye9Var6 != null && ye9Var6.O() != null && this.C.k() != null && !this.C.j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = this.S;
                historyMessage.threadId = y0().O().getId();
                if (this.r0 && y0().O().originalThreadData != null) {
                    historyMessage.threadName = y0().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = y0().O().getTitle();
                }
                if (this.r0 && !E0()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = y0().k().getName();
                }
                historyMessage.isHostOnly = t0();
                historyMessage.isSquence = B0();
                historyMessage.threadType = y0().O().getThreadType();
                historyMessage.isShareThread = this.r0;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public final void N0(int i) {
        ye9 ye9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048589, this, i) == null) && i != 8) {
            this.g0 = "";
            if (this.h0 != null) {
                if (i == 1 && (ye9Var = this.C) != null && ye9Var.j0()) {
                    if (this.i0 != null) {
                        y0().F().remove(this.i0);
                    }
                } else if (i == 1 && !this.i && !ListUtils.isEmpty(y0().F())) {
                    y0().F().remove(this.h0);
                    if (this.i0 != null) {
                        y0().F().remove(this.i0);
                    }
                    y0().F().add(0, this.h0);
                } else {
                    y0().F().remove(this.h0);
                    if (this.i0 != null) {
                        y0().F().remove(this.i0);
                    }
                }
            }
            this.i0 = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0323, code lost:
        if ((r11.q - 1) <= 0) goto L140;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027d A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0281 A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0295 A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0354 A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0370 A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x039b A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0424 A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0434 A[Catch: Exception -> 0x0493, TryCatch #0 {Exception -> 0x0493, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0490), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x036c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean S0(int i) {
        InterceptResult invokeI;
        int i2;
        int i3;
        int i4;
        boolean z;
        int size;
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            this.D = i;
            int i7 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            I0(i);
            ye9 f2 = uj9.b().f();
            if (f2 != null && f2.O() != null && StringHelper.equals(f2.Q(), this.b)) {
                f2.O().setCopyThreadRemindType(0);
                this.i = uj9.b().i();
                this.g = uj9.b().a();
                this.h0 = uj9.b().g();
                this.i0 = uj9.b().h();
                this.j0 = uj9.b().d();
                boolean z2 = this.g;
                this.e0 = z2;
                if (z2 || this.w) {
                    this.Q = false;
                }
                SafeHandler.getInst().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.X) {
                T0(r0(), true, this.c, 3);
            }
            if (i == 3 && !this.X) {
                if (this.w) {
                    T0(r0(), true, this.c, 3);
                } else {
                    T0(r0(), false, this.c, 3);
                }
            }
            this.X = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            if (this.s0 == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            pbPageRequestMessage.setIsReqAd(i2);
            pbPageRequestMessage.setLastids(lc5.l);
            if (this.g || this.w) {
                this.Q = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.b != null && this.b.length() != 0) {
                pbPageRequestMessage.set_kz(JavaTypesHelper.toLong(this.b, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.a);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(BdUtilHelper.getEquipmentWidth(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(BdUtilHelper.getEquipmentHeight(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                if (TbImageHelper.getInstance().isShowBigImage()) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
                pbPageRequestMessage.setSchemeUrl(this.x0);
                if (!this.i) {
                    pbPageRequestMessage.set_r(1);
                }
                pbPageRequestMessage.set_r(Integer.valueOf(this.j));
                if (this.g) {
                    pbPageRequestMessage.set_lz(1);
                }
                if (this.mStType != null) {
                    pbPageRequestMessage.set_st_type(this.mStType);
                }
                if (this.I != null) {
                    pbPageRequestMessage.setLocate(this.I);
                }
                if (this.A) {
                    pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.z));
                    pbPageRequestMessage.set_message_click("1");
                }
                if (this.Q) {
                    pbPageRequestMessage.set_banner(1);
                }
                if (this.K != null) {
                    pbPageRequestMessage.setOpType(this.K);
                    pbPageRequestMessage.setOpUrl(this.L);
                    pbPageRequestMessage.setOpStat(JavaTypesHelper.toInt(this.M, 0));
                    pbPageRequestMessage.setOpMessageID(this.z);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.E));
                ArrayList<pea> F = this.C.F();
                switch (i) {
                    case 1:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        if (!this.w) {
                            if (this.j == 1) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.q - 1));
                                break;
                            } else {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.p + 1));
                                if (this.p >= this.r) {
                                    z = true;
                                }
                            }
                            if (!this.w || z || this.x) {
                                if (F != null && F.size() > 0) {
                                    size = F.size();
                                    i5 = 1;
                                    while (true) {
                                        i6 = size - i5;
                                        if (i6 >= 0) {
                                            pea peaVar = F.get(i6);
                                            if (peaVar != null) {
                                                String U = peaVar.U();
                                                this.c = U;
                                                if (StringUtils.isNull(U)) {
                                                }
                                            }
                                            i5++;
                                        }
                                    }
                                    if (this.j == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.p + 1));
                                    }
                                }
                                if (this.c == null && this.c.length() > 0) {
                                    pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.c, 0L));
                                    if (this.j == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.j == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            V0(pbPageRequestMessage);
                            break;
                        }
                        z = false;
                        if (!this.w) {
                        }
                        if (F != null) {
                            size = F.size();
                            i5 = 1;
                            while (true) {
                                i6 = size - i5;
                                if (i6 >= 0) {
                                }
                                i5++;
                            }
                            if (this.j == 2) {
                            }
                        }
                        if (this.c == null) {
                        }
                        if (this.j == 1) {
                        }
                        V0(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.c = F.get(0).U();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.w) {
                            if (D0()) {
                                if (this.q - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.q - 1));
                                }
                            } else if (this.p < this.r) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.p + 1));
                            }
                        }
                        if (this.c != null && this.c.length() > 0) {
                            pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.c, 0L));
                            if (this.j == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        V0(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.w && !this.g) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!D0()) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                if (this.r > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.r));
                                }
                            }
                            if (this.w) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            X0(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!D0()) {
                        }
                        if (this.w) {
                        }
                        X0(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.c, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        V0(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.o));
                        pbPageRequestMessage.set_banner(0);
                        V0(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.j == 1 && this.e0 && !this.g) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.c, 0L));
                            if (this.j == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        pbPageRequestMessage.set_back(0);
                        if (this.g) {
                            pbPageRequestMessage.set_banner(0);
                        } else {
                            pbPageRequestMessage.set_banner(1);
                        }
                        V0(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.a0);
                        V0(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.g0, 0L));
                        if (this.j == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.e0 = this.g;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.w));
                pbPageRequestMessage.setCacheKey(r0());
                pbPageRequestMessage.setObjParam1(String.valueOf(this.f0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.Z);
                if (this.c0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                pbPageRequestMessage.setFromSmartFrs(i4);
                if (UtilHelper.isUgcThreadType(this.v0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.d);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.f);
                if (this.f0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.f0 != 7 && this.f0 != 5 && !this.A0) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.t0);
                    pbPageRequestMessage.setOriUgcTid(this.u0);
                    pbPageRequestMessage.setOriUgcType(this.v0);
                    pbPageRequestMessage.setOriUgcVid(this.w0);
                    if (!StringUtils.isNull(this.y0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.y0));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            if (pbPageRequestMessage.getPn().intValue() != this.r) {
                                i7 = q0();
                            } else {
                                i7 = -1;
                            }
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i7 = q0();
                            }
                            i7 = -1;
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i7);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.z0);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.b);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    int i8 = PbPageRequestMessage.requestTimes;
                    PbPageRequestMessage.requestTimes = i8 + 1;
                    pbPageRequestMessage.setRequestTimes(i8);
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.t0);
                pbPageRequestMessage.setOriUgcTid(this.u0);
                pbPageRequestMessage.setOriUgcType(this.v0);
                pbPageRequestMessage.setOriUgcVid(this.w0);
                if (!StringUtils.isNull(this.y0)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i7);
                pbPageRequestMessage.setImmersionVideoCommentSource(this.z0);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.b);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                int i82 = PbPageRequestMessage.requestTimes;
                PbPageRequestMessage.requestTimes = i82 + 1;
                pbPageRequestMessage.setRequestTimes(i82);
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void T0(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048600, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    public final void V0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048603, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(s0()) || tz9.m().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(tz9.m().b().e(s0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(tz9.m().b().d(s0(), true));
    }

    public final void X0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048607, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(s0()) || tz9.m().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(tz9.m().b().d(s0(), true) + 1);
        pbPageRequestMessage.setLoadCount(tz9.m().b().e(s0(), true));
    }

    public void b1(ye9 ye9Var, ArrayList<pea> arrayList) {
        String v0;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048612, this, ye9Var, arrayList) == null) && arrayList != null && ye9Var.F() != null) {
            pea peaVar = (pea) ListUtils.getItem(ye9Var.F(), 0);
            if (peaVar != null && (v0 = v0(arrayList)) != null && v0.equals(peaVar.U())) {
                ye9Var.F().remove(peaVar);
            }
            this.C.Y = arrayList.size();
            arrayList.addAll(ye9Var.F());
        }
    }

    public String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.b);
            if (!this.y) {
                sb.append(this.c);
            }
            sb.append(this.g);
            sb.append(this.i);
            sb.append(this.j);
            sb.append(this.mStType);
            sb.append(this.l);
            sb.append(this.m);
            sb.append(this.n);
            sb.append(this.u);
            sb.append(this.v);
            sb.append(this.w);
            sb.append(this.s);
            sb.append(this.t);
            sb.append(this.A);
            sb.append(this.z);
            sb.append(this.B);
            sb.append(this.E);
            sb.append(this.F);
            sb.append(this.G);
            sb.append(this.H);
            sb.append(this.t0);
            sb.append(this.u0);
            sb.append(this.w0);
            sb.append(this.v0);
            String str = this.N;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            int i = 0;
            if (y0().F() == null) {
                return 0;
            }
            ArrayList<pea> F = y0().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                pea peaVar = F.get(size);
                if (peaVar instanceof oea) {
                    if (peaVar.getType() != AdvertAppInfo.y) {
                        return i;
                    }
                } else {
                    i++;
                }
            }
            return F.size();
        }
        return invokeV.intValue;
    }

    public final String r0() {
        InterceptResult invokeV;
        String w0;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (!"0".equals(this.b)) {
                w0 = this.b;
            } else {
                w0 = w0();
            }
            if (this.g) {
                w0 = w0 + "_host";
            }
            int i = this.j;
            if (i == 1) {
                w0 = w0 + "_rev";
            } else if (i == 2) {
                w0 = w0 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return w0 + TbadkCoreApplication.getCurrentAccount();
            }
            return w0;
        }
        return (String) invokeV.objValue;
    }

    public final String w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            String str = "";
            if (this.t0 != null) {
                str = "" + this.t0;
            }
            if (this.u0 != null) {
                str = str + this.u0;
            }
            String str2 = str + this.v0;
            if (this.w0 != null) {
                return str2 + this.w0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }
}
