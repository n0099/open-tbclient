package com.baidu.tieba.videoplay.danmu;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
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
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.PbPageReadLocalRequestMessage;
import com.baidu.tieba.pb.pb.main.pbPageHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.pbPageSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.b9;
import com.repackage.bl8;
import com.repackage.fa8;
import com.repackage.hv7;
import com.repackage.lt4;
import com.repackage.lz4;
import com.repackage.mg;
import com.repackage.mi;
import com.repackage.ni;
import com.repackage.oi;
import com.repackage.pg;
import com.repackage.qp4;
import com.repackage.rv7;
import com.repackage.ui8;
import com.repackage.vk8;
import com.repackage.wa;
import com.repackage.wt4;
import com.repackage.yr7;
import com.repackage.zz4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes4.dex */
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
    public String B0;
    public yr7 C;
    public String C0;
    public int D;
    public String D0;
    public int E;
    public boolean E0;
    public boolean F;
    public BdUniDispatchSchemeController.b F0;
    public boolean G;
    public CustomMessageListener G0;
    public boolean H;
    public wa H0;
    public String I;
    public CustomMessageListener I0;
    public g J;
    public CustomMessageListener J0;
    public String K;
    public PraiseData K0;
    public String L;
    public String M;
    public String N;
    public int O;
    public int P;
    public boolean Q;
    public bl8 R;
    public TbPageContext<BaseFragmentActivity> S;
    public boolean T;
    public boolean U;
    public long V;
    public boolean W;
    public boolean X;
    public String Y;
    public boolean Z;
    public int a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;
    public int g0;
    public boolean h;
    public boolean h0;
    public boolean i;
    public boolean i0;
    public boolean isLoading;
    public int j;
    public final hv7 j0;
    public int k;
    public boolean k0;
    public int l;
    public int l0;
    public int m;
    public String m0;
    public String mStType;
    public long n;
    public PostData n0;
    public int o;
    public PostData o0;
    public int p;
    public int p0;
    public int q;
    public boolean q0;
    public int r;
    public vk8 r0;
    public boolean s;
    public String s0;
    public boolean t;
    public String t0;
    public boolean u;
    public int u0;
    public boolean v;
    public String v0;
    public boolean w;
    public String w0;
    public boolean x;
    public String x0;
    public boolean y;
    public int y0;
    public long z;
    public boolean z0;

    /* loaded from: classes4.dex */
    public class a implements BdUniDispatchSchemeController.b {
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

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                this.a.b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                this.a.s0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.t0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.u0 = mg.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.v0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    /* loaded from: classes4.dex */
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
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.a.j0() == null || this.a.j0().l() == null || this.a.j0().l().getSignData() == null || !signData.forumId.equals(this.a.j0().m())) {
                return;
            }
            this.a.j0().l().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends wa {
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

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    if (responsedMessage.hasError() && mi.z()) {
                        this.a.S.showToast(responsedMessage.getErrorString());
                    }
                    if (z2) {
                        this.a.u0((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.a.t0((pbPageHttpResponseMessage) responsedMessage);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (responsedMessage.getError() != 0) {
                        long j = z ? 0L : ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                        PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                        long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                        int cmd = responsedMessage.getOrginalMessage().getCmd();
                        int error = responsedMessage.getError();
                        String errorString = responsedMessage.getErrorString();
                        Object[] objArr = new Object[6];
                        objArr[0] = "updateType";
                        objArr[1] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.getUpdateType()) : null;
                        objArr[2] = "ThreadId";
                        objArr[3] = pbPageRequestMessage != null ? String.valueOf(pbPageRequestMessage.get_kz()) : null;
                        objArr[4] = "seq_id";
                        objArr[5] = Long.valueOf(j);
                        lt4.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (this.a.T && this.a.U) {
                        return;
                    }
                    if (!this.a.T) {
                        this.a.T = true;
                    } else {
                        this.a.U = true;
                    }
                    if (this.a.J != null) {
                        this.a.J.a(this.a.k0(), z, responsedMessage, this.a.W, System.currentTimeMillis() - this.a.V);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
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
                yr7 yr7Var = this.a.C;
                if (yr7Var == null || yr7Var.h() == null || this.a.C.h().b() == null || !this.a.C.h().b().equals(valueOf)) {
                    return;
                }
                this.a.C.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes4.dex */
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
                yr7 yr7Var = this.a.C;
                if (yr7Var == null || yr7Var.h() == null || this.a.C.h().b() == null || !this.a.C.h().b().equals(valueOf)) {
                    return;
                }
                this.a.C.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ yr7 a;
        public final /* synthetic */ PbDanmuModel b;

        public f(PbDanmuModel pbDanmuModel, yr7 yr7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, yr7Var};
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
            this.a = yr7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.w0(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.b.isLoading = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(yr7 yr7Var);

        void c(boolean z, int i, int i2, int i3, yr7 yr7Var, String str, int i4);
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
                super((b9) newInitContext.callArgs[0]);
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
        this.T = false;
        this.U = false;
        this.Y = null;
        this.Z = false;
        this.g0 = -1;
        this.i0 = false;
        this.k0 = false;
        this.l0 = 0;
        this.y0 = 0;
        this.G0 = new b(this, 2001222);
        this.H0 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.I0 = new d(this, 2001336);
        this.J0 = new e(this, 2001335);
        this.K0 = null;
        registerListener(this.H0);
        registerListener(this.G0);
        registerListener(this.J0);
        registerListener(this.I0);
        yr7 yr7Var = new yr7();
        this.C = yr7Var;
        yr7Var.y0(0);
        this.S = tbPageContext;
        this.j0 = new hv7();
        this.F0 = new a(this);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.Y : (String) invokeV.objValue;
    }

    public void A0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.o = i;
            this.p = i;
            this.q = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public void B0() {
        yr7 yr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (yr7Var = this.C) == null || ListUtils.isEmpty(yr7Var.F())) {
            return;
        }
        if (this.o0 != null) {
            this.C.F().remove(this.o0);
            this.o0 = null;
        }
        if (this.n0 != null) {
            this.C.F().remove(this.n0);
            this.n0 = null;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.D0 : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0323, code lost:
        if ((r11.q - 1) <= 0) goto L140;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x027d A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0281 A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0295 A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0354 A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0370 A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x039b A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0424 A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0434 A[Catch: Exception -> 0x048a, TryCatch #0 {Exception -> 0x048a, blocks: (B:41:0x00d9, B:43:0x00dd, B:46:0x00e7, B:50:0x0150, B:52:0x0160, B:53:0x0163, B:55:0x0170, B:56:0x0173, B:58:0x0177, B:59:0x017c, B:61:0x0180, B:62:0x0185, B:64:0x0189, B:65:0x0198, B:67:0x019c, B:68:0x019f, B:70:0x01a3, B:71:0x01bb, B:75:0x01d1, B:77:0x01de, B:78:0x01f0, B:79:0x0200, B:81:0x0207, B:83:0x020b, B:85:0x020f, B:89:0x0223, B:91:0x022a, B:93:0x0231, B:92:0x022e, B:86:0x0213, B:88:0x0220, B:94:0x0236, B:95:0x024a, B:96:0x0264, B:98:0x0268, B:101:0x026d, B:103:0x0274, B:105:0x027d, B:109:0x0291, B:111:0x0295, B:112:0x0298, B:106:0x0281, B:108:0x0288, B:102:0x0271, B:114:0x029f, B:116:0x02a5, B:118:0x02ab, B:119:0x02b7, B:121:0x02c1, B:123:0x02c7, B:125:0x02cc, B:126:0x02d7, B:128:0x02dd, B:129:0x02e7, B:131:0x02eb, B:133:0x02f3, B:135:0x0300, B:136:0x0303, B:137:0x0308, B:139:0x0312, B:141:0x0316, B:148:0x0339, B:151:0x033f, B:178:0x039e, B:154:0x0345, B:156:0x034b, B:157:0x0350, B:159:0x0354, B:161:0x035c, B:162:0x035f, B:165:0x036c, B:167:0x0370, B:168:0x037a, B:170:0x037e, B:172:0x0386, B:174:0x0393, B:175:0x0397, B:177:0x039b, B:144:0x0327, B:179:0x03a1, B:183:0x03ca, B:185:0x03d5, B:187:0x03e2, B:189:0x03ec, B:191:0x03f3, B:193:0x03f7, B:195:0x03fc, B:198:0x0401, B:200:0x0408, B:202:0x0424, B:203:0x042d, B:205:0x0434, B:207:0x043e, B:210:0x044b, B:211:0x0450, B:214:0x045c, B:215:0x0460, B:199:0x0405, B:190:0x03f0, B:186:0x03dd, B:216:0x0487), top: B:225:0x00d9 }] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x036c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean C0(int i) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            this.D = i;
            int i4 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            s0(i);
            yr7 f2 = rv7.b().f();
            if (f2 != null && f2.O() != null && StringHelper.equals(f2.Q(), this.b)) {
                f2.O().setCopyThreadRemindType(0);
                this.i = rv7.b().i();
                this.g = rv7.b().a();
                this.n0 = rv7.b().g();
                this.o0 = rv7.b().h();
                this.p0 = rv7.b().d();
                boolean z2 = this.g;
                this.k0 = z2;
                if (z2 || this.w) {
                    this.Q = false;
                }
                pg.a().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.X) {
                D0(c0(), true, this.c, 3);
            }
            if (i == 3 && !this.X) {
                if (this.w) {
                    D0(c0(), true, this.c, 3);
                } else {
                    D0(c0(), false, this.c, 3);
                }
            }
            this.X = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setIsReqAd(this.r0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(zz4.o);
            if (this.g || this.w) {
                this.Q = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.b != null && this.b.length() != 0) {
                pbPageRequestMessage.set_kz(mg.g(this.b, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.a);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(oi.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(oi.i(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                pbPageRequestMessage.setSchemeUrl(this.w0);
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
                    pbPageRequestMessage.setOpStat(mg.e(this.M, 0));
                    pbPageRequestMessage.setOpMessageID(this.z);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.E));
                ArrayList<PostData> F = this.C.F();
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
                                z = this.p >= this.r;
                            }
                            if (!this.w || z || this.x) {
                                if (F != null && F.size() > 0) {
                                    size = F.size();
                                    i2 = 1;
                                    while (true) {
                                        i3 = size - i2;
                                        if (i3 >= 0) {
                                            PostData postData = F.get(i3);
                                            if (postData != null) {
                                                String I = postData.I();
                                                this.c = I;
                                                if (StringUtils.isNull(I)) {
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                    if (this.j == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.p + 1));
                                    }
                                }
                                if (this.c == null && this.c.length() > 0) {
                                    pbPageRequestMessage.set_pid(mg.g(this.c, 0L));
                                    if (this.j == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.j == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            F0(pbPageRequestMessage);
                            break;
                        }
                        if (!this.w) {
                        }
                        if (F != null) {
                            size = F.size();
                            i2 = 1;
                            while (true) {
                                i3 = size - i2;
                                if (i3 >= 0) {
                                }
                                i2++;
                            }
                            if (this.j == 2) {
                            }
                        }
                        if (this.c == null) {
                        }
                        if (this.j == 1) {
                        }
                        F0(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.c = F.get(0).I();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.w) {
                            if (n0()) {
                                if (this.q - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.q - 1));
                                }
                            } else if (this.p < this.r) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.p + 1));
                            }
                        }
                        if (this.c != null && this.c.length() > 0) {
                            pbPageRequestMessage.set_pid(mg.g(this.c, 0L));
                            if (this.j == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        F0(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.w && !this.g) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!n0()) {
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
                            H0(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!n0()) {
                        }
                        if (this.w) {
                        }
                        H0(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(mg.g(this.c, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        F0(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.o));
                        pbPageRequestMessage.set_banner(0);
                        F0(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.j == 1 && this.k0 && !this.g) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(mg.g(this.c, 0L));
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
                        F0(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.g0);
                        F0(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(mg.g(this.m0, 0L));
                        if (this.j == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.k0 = this.g;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.w));
                pbPageRequestMessage.setCacheKey(c0());
                pbPageRequestMessage.setObjParam1(String.valueOf(this.l0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.Z);
                pbPageRequestMessage.setFromSmartFrs(this.i0 ? 1 : 0);
                if (UtilHelper.isUgcThreadType(this.u0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.d);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.f);
                if (this.l0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.l0 != 7 && this.l0 != 5 && !this.z0) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.s0);
                    pbPageRequestMessage.setOriUgcTid(this.t0);
                    pbPageRequestMessage.setOriUgcType(this.u0);
                    pbPageRequestMessage.setOriUgcVid(this.v0);
                    if (!StringUtils.isNull(this.x0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.x0));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            i4 = pbPageRequestMessage.getPn().intValue() == this.r ? -1 : b0();
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i4 = b0();
                            }
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i4);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.y0);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.b);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.s0);
                pbPageRequestMessage.setOriUgcTid(this.t0);
                pbPageRequestMessage.setOriUgcType(this.u0);
                pbPageRequestMessage.setOriUgcVid(this.v0);
                if (!StringUtils.isNull(this.x0)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i4);
                pbPageRequestMessage.setImmersionVideoCommentSource(this.y0);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.b);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B0 : (String) invokeV.objValue;
    }

    public final void D0(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.C0 : (String) invokeV.objValue;
    }

    public void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.y0 = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, str)) == null) {
            yr7 yr7Var = this.C;
            if (yr7Var == null || yr7Var.O() == null || this.C.l() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.C.O().isMutiForumThread()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.C.l().getId());
                writeData.setForumName(this.C.l().getName());
            }
            writeData.setFromForumId(this.e);
            writeData.sourceFrom = String.valueOf(this.l0);
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
        return (WriteData) invokeL.objValue;
    }

    public final void F0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(d0()) || fa8.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(fa8.q().b().e(d0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(fa8.q().b().d(d0(), true));
    }

    public void G0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, gVar) == null) {
            this.J = gVar;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.A0 : invokeV.booleanValue;
    }

    public final void H0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(d0()) || fa8.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(fa8.q().b().d(d0(), true) + 1);
        pbPageRequestMessage.setLoadCount(fa8.q().b().e(d0(), true));
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E0 : invokeV.booleanValue;
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048592, this, i) == null) {
            this.a = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            if (!TextUtils.isEmpty(this.c) && !"0".equals(this.c)) {
                return q0();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public yr7 J0(yr7 yr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, yr7Var)) == null) {
            if (yr7Var == null) {
                return null;
            }
            ThreadData O = yr7Var.O();
            O.setIs_good(this.l);
            O.setIs_top(this.m);
            long j = this.n;
            if (j > 0) {
                O.setLast_time_int(j);
            }
            Z(O);
            return yr7Var;
        }
        return (yr7) invokeL.objValue;
    }

    public final void K0(@NonNull yr7 yr7Var) {
        yr7 yr7Var2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, yr7Var) == null) || (yr7Var2 = this.C) == null) {
            return;
        }
        yr7Var2.e().clear();
        this.C.e().addAll(yr7Var.e());
    }

    public void L0(yr7 yr7Var, ArrayList<PostData> arrayList) {
        String g0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, yr7Var, arrayList) == null) || arrayList == null || yr7Var.F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(yr7Var.F(), 0);
        if (postData != null && (g0 = g0(arrayList)) != null && g0.equals(postData.I())) {
            yr7Var.F().remove(postData);
        }
        this.C.Z = arrayList.size();
        arrayList.addAll(yr7Var.F());
    }

    public void M0(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048597, this, yr7Var) == null) || yr7Var == null) {
            return;
        }
        yr7Var.N0(this.C.X());
        yr7 yr7Var2 = this.C;
        if (!yr7Var2.X && yr7Var.X && yr7Var2.i() != null) {
            yr7Var.B0(this.C.i());
        }
        this.C = yr7Var;
        A0(yr7Var.y().a());
    }

    public void W(qp4 qp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, qp4Var) == null) {
            if (qp4Var == null) {
                A0(1);
                return;
            }
            if (this.p < qp4Var.a()) {
                this.p = qp4Var.a();
            }
            if (this.q > qp4Var.a()) {
                this.q = qp4Var.a();
            }
            this.r = qp4Var.h();
        }
    }

    public final void X(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, yr7Var) == null) || yr7Var == null || yr7Var.z() == null || yr7Var.z().getAdvertAppInfo() == null || !yr7Var.z().Q0() || yr7Var.z().getAdvertAppInfo().c == 1001) {
            return;
        }
        this.r0 = yr7Var.z();
    }

    public void Y(yr7 yr7Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, yr7Var) == null) || yr7Var == null) {
            return;
        }
        if (this.H || this.F || this.G) {
            J0(yr7Var);
        }
    }

    public void Z(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = H();
            threadData.tiebaPlusOrderId = D();
            threadData.tiebaPlusToken = E();
            threadData.tiebaPlusExtraParam = E();
            threadData.tiebaplusCantDelete = I();
            threadData.setDispatchedForumIdWithString(y());
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
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
            sb.append(this.s0);
            sb.append(this.t0);
            sb.append(this.v0);
            sb.append(this.u0);
            String str = this.N;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            int i = 0;
            if (j0().F() == null) {
                return 0;
            }
            ArrayList<PostData> F = j0().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                PostData postData = F.get(size);
                if (!(postData instanceof vk8)) {
                    i++;
                } else if (postData.getType() != AdvertAppInfo.x) {
                    return i;
                }
            }
            return F.size();
        }
        return invokeV.intValue;
    }

    public final String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            String h0 = !"0".equals(this.b) ? this.b : h0();
            if (this.g) {
                h0 = h0 + "_host";
            }
            int i = this.j;
            if (i == 1) {
                h0 = h0 + "_rev";
            } else if (i == 2) {
                h0 = h0 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return h0 + TbadkCoreApplication.getCurrentAccount();
            }
            return h0;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.B : (String) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.w : invokeV.booleanValue;
    }

    public final String g0(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                PostData postData = (PostData) ListUtils.getItem(arrayList, i);
                if (postData != null && !StringUtils.isNull(postData.I())) {
                    return postData.I();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.d : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final String h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            String str = "";
            if (this.s0 != null) {
                str = "" + this.s0;
            }
            if (this.t0 != null) {
                str = str + this.t0;
            }
            String str2 = str + this.u0;
            if (this.v0 != null) {
                return str2 + this.v0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.l0 : invokeV.intValue;
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, intent) == null) || intent == null) {
            return;
        }
        this.b = intent.getStringExtra("thread_id");
        this.s0 = intent.getStringExtra("key_ori_ugc_nid");
        this.t0 = intent.getStringExtra("key_ori_ugc_tid");
        this.u0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.v0 = intent.getStringExtra("key_ori_ugc_vid");
        this.x0 = intent.getStringExtra("key_official_bar_message_id");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.w0 = uri != null ? uri.toString() : null;
        this.z0 = false;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.z0 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.F0);
        } else if (StringUtils.isNull(this.b)) {
            this.z0 = true;
            this.j0.b(intent, this.F0);
            if (uri != null) {
                if (StringUtils.isNull(this.b)) {
                    this.b = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.s0)) {
                    this.s0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.t0)) {
                    this.t0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.u0 == 0) {
                    this.u0 = mg.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.v0)) {
                    this.v0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (ni.isEmpty(this.b)) {
            this.b = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.l0 = intExtra;
        if (intExtra == 0) {
            this.l0 = this.j0.a;
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
            intExtra2 = wt4.k().l("key_pb_current_sort_type", 2);
        }
        this.j = intExtra2;
        this.c = intExtra2 != 2 ? this.c : "0";
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
        this.i0 = intent.getBooleanExtra("from_smart_frs", false);
        this.q0 = intent.getBooleanExtra("key_is_share_thread", false);
        intent.getBooleanExtra("key_need_preload", false);
        this.Q = intent.getIntExtra("request_code", -1) == 18003;
        this.A0 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.B0 = intent.getStringExtra("key_tieba_plus_order_id");
        this.C0 = intent.getStringExtra("key_tieba_plus_token");
        this.D0 = intent.getStringExtra("key_tieba_extra_param");
        this.E0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
    }

    public yr7 j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.C : (yr7) invokeV.objValue;
    }

    public int k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public int l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.D : invokeV.intValue;
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
                bl8 bl8Var = new bl8("pbStat");
                this.R = bl8Var;
                bl8Var.f();
            }
            boolean C0 = C0(3);
            if (this.K != null) {
                this.K = null;
                this.M = null;
                this.L = null;
            }
            return C0;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? n0() : invokeV.booleanValue;
    }

    public final boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            int i = this.j;
            return i == 0 || i == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? i0() == 3 || j0() == null || j0().O() == null || !j0().O().isMutiForumThread() : invokeV.booleanValue;
    }

    public boolean p0(boolean z) {
        InterceptResult invokeZ;
        yr7 yr7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048622, this, z)) == null) {
            if (this.b == null || (yr7Var = this.C) == null) {
                return false;
            }
            if (z || yr7Var.y().b() != 0) {
                return C0(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            if (this.b == null || this.c == null) {
                return false;
            }
            cancelMessage();
            if (this.w) {
                return C0(4);
            }
            return C0(6);
        }
        return invokeV.booleanValue;
    }

    public void r0(yr7 yr7Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048624, this, yr7Var, i, str) == null) {
            this.X = true;
            if (yr7Var == null || yr7Var.h != null) {
                return;
            }
            M0(yr7Var);
            Y(yr7Var);
            if (yr7Var.O() != null) {
                yr7Var.O().setCopyThreadRemindType(0);
            }
            g gVar = this.J;
            if (gVar == null || yr7Var == null) {
                return;
            }
            gVar.c(true, 0, i, 0, yr7Var, str, 0);
        }
    }

    public void s0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048625, this, i) == null) {
            x0(i);
            ArrayList<PostData> F = this.C.F();
            boolean z = false;
            this.W = false;
            if (i != 1) {
                if (i == 2) {
                    while (F.size() + 30 > lz4.a()) {
                        F.remove(F.size() - 1);
                        z = true;
                    }
                    if (z) {
                        this.C.y().l(1);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z2 = false;
            while (F.size() + 30 > lz4.a()) {
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
        }
    }

    public void t0(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, pbpagehttpresponsemessage) == null) {
            v0(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
        }
    }

    public void u0(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048627, this, pbpagesocketresponsemessage) == null) {
            v0(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
        }
    }

    public void v0(yr7 yr7Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{yr7Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            yr7 yr7Var2 = z ? null : yr7Var;
            this.isLoading = false;
            if (yr7Var2 != null) {
                Y(yr7Var2);
            }
            X(yr7Var2);
            vk8 vk8Var = this.r0;
            if (vk8Var != null && vk8Var.Q0()) {
                TiebaStatic.log(ui8.f("a005", "common_fill", true, 1));
            }
            w0(yr7Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void w0(yr7 yr7Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048629, this, new Object[]{yr7Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.h0 = z3;
            bl8 bl8Var = this.R;
            if (bl8Var != null && !z3) {
                bl8Var.b(z2, z4, i2, str, i3, j, j2);
                this.R = null;
            }
            yr7 yr7Var2 = this.C;
            if (yr7Var2 != null) {
                yr7Var2.a0 = z3;
                yr7Var2.b0 = i;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(d0()) && fa8.q().b() != null) {
                fa8.q().b().g(d0(), z0(l0()), true);
            }
            if (yr7Var != null && (this.o != 1 || i != 5 || yr7Var.F() == null || yr7Var.F().size() >= 1)) {
                this.h = this.i;
                if (i != 8) {
                    this.k = this.j;
                    this.j = yr7Var.g;
                }
                List<PbSortType> list = yr7Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.S.getResources().getString(R.string.obfuscated_res_0x7f0f0485);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    yr7Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.S.getResources().getString(R.string.obfuscated_res_0x7f0f150d);
                    builder2.sort_type = 1;
                    yr7Var.f.add(builder2.build(false));
                    int i6 = this.k;
                    this.j = i6;
                    yr7Var.g = i6;
                }
                this.A = false;
                if (yr7Var.y() != null && (this.j != 2 || i != 8)) {
                    W(yr7Var.y());
                }
                int i7 = this.r;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.r = i7;
                ArrayList<PostData> F = this.C.F();
                switch (i) {
                    case 1:
                        this.C.F0(yr7Var.y(), 1);
                        L0(yr7Var, F);
                        K0(yr7Var);
                        i4 = 0;
                        break;
                    case 2:
                        if (yr7Var.F() != null) {
                            i4 = yr7Var.F().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(F, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(yr7Var.F(), ListUtils.getCount(yr7Var.F()) - 1);
                            if (postData != null && postData2 != null && postData.I().equals(postData2.I())) {
                                yr7Var.F().remove(postData2);
                                i4--;
                            }
                            F.addAll(0, yr7Var.F());
                        } else {
                            i4 = 0;
                        }
                        K0(yr7Var);
                        this.C.F0(yr7Var.y(), 2);
                        break;
                    case 3:
                        if (this.j == 1 && yr7Var.y() != null) {
                            yr7Var.y().k(yr7Var.y().h());
                        }
                        M0(yr7Var);
                        i4 = 0;
                        break;
                    case 4:
                        M0(yr7Var);
                        i4 = 0;
                        break;
                    case 5:
                        M0(yr7Var);
                        i4 = 0;
                        break;
                    case 6:
                        M0(yr7Var);
                        i4 = 0;
                        break;
                    case 7:
                        M0(yr7Var);
                        i4 = 0;
                        break;
                    case 8:
                        if (yr7Var == null || ListUtils.isEmpty(yr7Var.F()) || this.C == null || (this.g && !y0(yr7Var).equals(yr7Var.F().get(0).s().getUserId()))) {
                            i5 = 0;
                        } else {
                            if (this.C.y().b() == 0) {
                                this.C.y().l(1);
                            }
                            B0();
                            this.n0 = yr7Var.F().get(0);
                            if (!n0() && !this.C.g0()) {
                                if (this.p0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.o0 = postData3;
                                    postData3.B = false;
                                    postData3.A0(53);
                                    this.C.F().add(0, this.o0);
                                }
                                this.C.F().add(0, this.n0);
                                i5 = 0;
                            } else {
                                if (this.C.F().size() - this.p0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.o0 = postData4;
                                    postData4.B = true;
                                    postData4.A0(53);
                                    this.C.F().add(this.o0);
                                }
                                this.C.F().add(this.n0);
                                i5 = this.C.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(wt4.k().m("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.n0.R = this.C.J();
                                wt4.k().x("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        K0(yr7Var);
                        i4 = i5;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                yr7 yr7Var3 = this.C;
                if (yr7Var3 != null && yr7Var3.O() != null) {
                    PraiseData praise = this.C.O().getPraise();
                    if (this.K0 != null && !praise.isPriaseDataValid()) {
                        this.C.O().setPraise(this.K0);
                    } else {
                        PraiseData praise2 = this.C.O().getPraise();
                        this.K0 = praise2;
                        praise2.setPostId(this.C.O().getFirstPostId());
                    }
                    if (yr7Var.y() != null && yr7Var.y().a() == 1 && yr7Var.O() != null && yr7Var.O().getActDatas() != null && yr7Var.O().getActDatas().size() > 0) {
                        this.C.O().setActDatas(yr7Var.O().getActDatas());
                    }
                    this.C.O().setReply_num(yr7Var.O().getReply_num());
                    this.C.O().setAnchorLevel(yr7Var.O().getAnchorLevel());
                    this.C.O().setCopyThreadRemindType(yr7Var.O().getCopyThreadRemindType());
                    if (this.E == 33) {
                        this.C.O().getAuthor().setHadConcerned(yr7Var.O().getAuthor().hadConcerned());
                    }
                    if (yr7Var != null && yr7Var.O() != null) {
                        this.C.O().updateIsNotitle(yr7Var.O().getIsNoTitle());
                    }
                }
                yr7 yr7Var4 = this.C;
                if (yr7Var4 != null && yr7Var4.U() != null && yr7Var.U() != null) {
                    this.C.U().setBimg_end_time(yr7Var.U().getBimg_end_time());
                    this.C.U().setBimg_url(yr7Var.U().getBimg_url());
                }
                if (yr7Var.y() != null && yr7Var.y().a() == 1 && yr7Var.W() != null) {
                    this.C.M0(yr7Var.W());
                }
                if (this.h0) {
                    if (this.C.O() != null && this.C.O().getAuthor() != null && this.C.F() != null && ListUtils.getItem(this.C.F(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.C.F(), 0);
                        MetaData author = this.C.O().getAuthor();
                        if (postData5.s() != null && postData5.s().getGodUserData() != null) {
                            int i8 = this.O;
                            if (i8 != -1) {
                                author.setFansNum(i8);
                                postData5.s().setFansNum(this.O);
                            }
                            if (this.P != -1) {
                                author.getGodUserData().setIsLike(this.P == 1);
                                postData5.s().getGodUserData().setIsLike(this.P == 1);
                                author.getGodUserData().setIsFromNetWork(false);
                                postData5.s().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    yr7 yr7Var5 = this.C;
                    yr7Var5.e = -1;
                    yr7Var5.d = -1;
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
            yr7 yr7Var6 = this.C;
            if (yr7Var6 == null || yr7Var6.O() == null || this.C.l() == null || this.C.g0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.S;
            historyMessage.threadId = j0().O().getId();
            if (this.q0 && j0().O().originalThreadData != null) {
                historyMessage.threadName = j0().O().originalThreadData.b;
            } else {
                historyMessage.threadName = j0().O().getTitle();
            }
            if (this.q0 && !o0()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = j0().l().getName();
            }
            historyMessage.isHostOnly = e0();
            historyMessage.isSquence = m0();
            historyMessage.threadType = j0().O().getThreadType();
            historyMessage.isShareThread = this.q0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void x0(int i) {
        yr7 yr7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048630, this, i) == null) || i == 8) {
            return;
        }
        this.m0 = "";
        if (this.n0 != null) {
            if (i == 1 && (yr7Var = this.C) != null && yr7Var.g0()) {
                if (this.o0 != null) {
                    j0().F().remove(this.o0);
                }
            } else if (i == 1 && !this.i && !ListUtils.isEmpty(j0().F())) {
                j0().F().remove(this.n0);
                if (this.o0 != null) {
                    j0().F().remove(this.o0);
                }
                j0().F().add(0, this.n0);
            } else {
                j0().F().remove(this.n0);
                if (this.o0 != null) {
                    j0().F().remove(this.o0);
                }
            }
        }
        this.o0 = null;
    }

    public String y0(yr7 yr7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048631, this, yr7Var)) == null) {
            String str = null;
            if (yr7Var == null) {
                return null;
            }
            if (yr7Var.O() != null && yr7Var.O().getAuthor() != null) {
                str = yr7Var.O().getAuthor().getUserId();
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public final int z0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i)) == null) {
            if (i != 1) {
                return i != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }
}
