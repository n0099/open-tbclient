package com.baidu.tieba.videoplay.danmu;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.q0.r.r.b1;
import c.a.q0.r.r.e2;
import c.a.r0.j3.z;
import c.a.r0.u2.k.f.d0;
import c.a.r0.u2.k.f.m0;
import c.a.r0.y3.k0.o;
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
import com.baidu.tieba.pb.pb.main.PbPageReadLocalRequestMessage;
import com.baidu.tieba.pb.pb.main.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.pbPageHttpResponseMessage;
import com.baidu.tieba.pb.pb.main.pbPageSocketResponseMessage;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes6.dex */
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
    public String A0;
    public boolean B;
    public String B0;
    public boolean C;
    public int C0;
    public long D;
    public boolean D0;
    public boolean E;
    public boolean E0;
    public String F;
    public String F0;
    public c.a.r0.u2.h.f G;
    public String G0;
    public int H;
    public String H0;
    public int I;
    public boolean I0;
    public boolean J;
    public BdUniDispatchSchemeController.b J0;
    public boolean K;
    public CustomMessageListener K0;
    public boolean L;
    public c.a.d.c.g.a L0;
    public String M;
    public CustomMessageListener M0;
    public g N;
    public CustomMessageListener N0;
    public String O;
    public PraiseData O0;
    public String P;
    public String Q;
    public String R;
    public int S;
    public int T;
    public boolean U;
    public c.a.r0.y3.m0.b V;
    public TbPageContext<BaseFragmentActivity> W;
    public boolean X;
    public boolean Y;
    public long Z;
    public boolean a0;
    public boolean b0;
    public String c0;
    public boolean d0;

    /* renamed from: e  reason: collision with root package name */
    public int f47461e;
    public int e0;

    /* renamed from: f  reason: collision with root package name */
    public String f47462f;
    public boolean f0;

    /* renamed from: g  reason: collision with root package name */
    public String f47463g;
    public boolean g0;

    /* renamed from: h  reason: collision with root package name */
    public String f47464h;
    public final d0 h0;

    /* renamed from: i  reason: collision with root package name */
    public String f47465i;
    public boolean i0;
    public boolean isLoading;

    /* renamed from: j  reason: collision with root package name */
    public boolean f47466j;
    public boolean k;
    public int k0;
    public boolean l;
    public boolean m;
    public String mStType;
    public int n;
    public int o;
    public int p;
    public int q;
    public String q0;
    public long r;
    public PostData r0;
    public int s;
    public PostData s0;
    public int t;
    public int t0;
    public int u;
    public boolean u0;
    public int v;
    public o v0;
    public boolean w;
    public String w0;
    public boolean x;
    public String x0;
    public boolean y;
    public int y0;
    public boolean z;
    public String z0;

    /* loaded from: classes6.dex */
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbDanmuModel;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                this.a.f47462f = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                this.a.w0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.x0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.y0 = c.a.d.f.m.b.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.z0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbDanmuModel pbDanmuModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
            if (this.a.h0() == null || this.a.h0().l() == null || this.a.h0().l().getSignData() == null || !signData.forumId.equals(this.a.h0().m())) {
                return;
            }
            this.a.h0().l().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes6.dex */
    public class c extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbDanmuModel pbDanmuModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbDanmuModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && l.z()) {
                        this.a.W.showToast(responsedMessage.getErrorString());
                    }
                    if (z2) {
                        this.a.s0((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.a.r0((pbPageHttpResponseMessage) responsedMessage);
                        z = true;
                    } else {
                        z = false;
                    }
                    if (responsedMessage.getError() != 0) {
                        long j2 = z ? 0L : ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
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
                        objArr[5] = Long.valueOf(j2);
                        c.a.q0.r.d0.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (this.a.X && this.a.Y) {
                        return;
                    }
                    if (!this.a.X) {
                        this.a.X = true;
                    } else {
                        this.a.Y = true;
                    }
                    if (this.a.N != null) {
                        this.a.N.a(this.a.i0(), z, responsedMessage, this.a.a0, System.currentTimeMillis() - this.a.Z);
                    }
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbDanmuModel pbDanmuModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a.r0.u2.h.f fVar = this.a.G;
                if (fVar == null || fVar.h() == null || this.a.G.h().getForumId() == null || !this.a.G.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.a.G.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbDanmuModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbDanmuModel pbDanmuModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
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
                c.a.r0.u2.h.f fVar = this.a.G;
                if (fVar == null || fVar.h() == null || this.a.G.h().getForumId() == null || !this.a.G.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.a.G.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.u2.h.f f47467e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbDanmuModel f47468f;

        public f(PbDanmuModel pbDanmuModel, c.a.r0.u2.h.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbDanmuModel, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47468f = pbDanmuModel;
            this.f47467e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f47468f.u0(this.f47467e, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.f47468f.isLoading = false;
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface g {
        void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2);

        void b(c.a.r0.u2.h.f fVar);

        void c(boolean z, int i2, int i3, int i4, c.a.r0.u2.h.f fVar, String str, int i5);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f47461e = 4;
        this.mStType = null;
        this.f47462f = null;
        this.f47463g = null;
        this.f47464h = null;
        this.f47466j = false;
        this.k = false;
        this.l = true;
        this.m = true;
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 0L;
        this.s = 1;
        this.t = 1;
        this.u = 1;
        this.v = 1;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = 0L;
        this.E = false;
        this.F = null;
        this.G = null;
        this.isLoading = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = -1;
        this.T = -1;
        this.V = null;
        this.X = false;
        this.Y = false;
        this.c0 = null;
        this.d0 = false;
        this.e0 = -1;
        this.g0 = false;
        this.i0 = false;
        this.k0 = 0;
        this.C0 = 0;
        this.K0 = new b(this, 2001222);
        this.L0 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.M0 = new d(this, 2001336);
        this.N0 = new e(this, 2001335);
        this.O0 = null;
        registerListener(this.L0);
        registerListener(this.K0);
        registerListener(this.N0);
        registerListener(this.M0);
        c.a.r0.u2.h.f fVar = new c.a.r0.u2.h.f();
        this.G = fVar;
        fVar.y0(0);
        this.W = tbPageContext;
        this.h0 = new d0();
        this.J0 = new a(this);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.H0 : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:142:0x0323, code lost:
        if ((r11.u - 1) <= 0) goto L140;
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
    public boolean A0(int i2) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
            this.H = i2;
            int i5 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            q0(i2);
            c.a.r0.u2.h.f f2 = m0.b().f();
            if (f2 != null && f2.O() != null && StringHelper.equals(f2.Q(), this.f47462f)) {
                f2.O().E3(0);
                this.m = m0.b().i();
                this.k = m0.b().a();
                this.r0 = m0.b().g();
                this.s0 = m0.b().h();
                this.t0 = m0.b().d();
                boolean z2 = this.k;
                this.i0 = z2;
                if (z2 || this.A) {
                    this.U = false;
                }
                c.a.d.f.m.e.a().post(new f(this, f2));
                return false;
            }
            if (i2 == 4 && !this.b0) {
                B0(a0(), true, this.f47463g, 3);
            }
            if (i2 == 3 && !this.b0) {
                if (this.A) {
                    B0(a0(), true, this.f47463g, 3);
                } else {
                    B0(a0(), false, this.f47463g, 3);
                }
            }
            this.b0 = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i2);
            pbPageRequestMessage.setIsReqAd(this.v0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(c.a.q0.u.a.o);
            if (this.k || this.A) {
                this.U = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f47462f != null && this.f47462f.length() != 0) {
                pbPageRequestMessage.set_kz(c.a.d.f.m.b.g(this.f47462f, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.f47461e);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(n.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(n.i(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                pbPageRequestMessage.setSchemeUrl(this.A0);
                if (!this.m) {
                    pbPageRequestMessage.set_r(1);
                }
                pbPageRequestMessage.set_r(Integer.valueOf(this.n));
                if (this.k) {
                    pbPageRequestMessage.set_lz(1);
                }
                if (this.mStType != null) {
                    pbPageRequestMessage.set_st_type(this.mStType);
                }
                if (this.M != null) {
                    pbPageRequestMessage.setLocate(this.M);
                }
                if (this.E) {
                    pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.D));
                    pbPageRequestMessage.set_message_click("1");
                }
                if (this.U) {
                    pbPageRequestMessage.set_banner(1);
                }
                if (this.O != null) {
                    pbPageRequestMessage.setOpType(this.O);
                    pbPageRequestMessage.setOpUrl(this.P);
                    pbPageRequestMessage.setOpStat(c.a.d.f.m.b.e(this.Q, 0));
                    pbPageRequestMessage.setOpMessageID(this.D);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.I));
                ArrayList<PostData> F = this.G.F();
                switch (i2) {
                    case 1:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        if (!this.A) {
                            if (this.n == 1) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.u - 1));
                                break;
                            } else {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                                z = this.t >= this.v;
                            }
                            if (!this.A || z || this.B) {
                                if (F != null && F.size() > 0) {
                                    size = F.size();
                                    i3 = 1;
                                    while (true) {
                                        i4 = size - i3;
                                        if (i4 >= 0) {
                                            PostData postData = F.get(i4);
                                            if (postData != null) {
                                                String G = postData.G();
                                                this.f47463g = G;
                                                if (StringUtils.isNull(G)) {
                                                }
                                            }
                                            i3++;
                                        }
                                    }
                                    if (this.n == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                                    }
                                }
                                if (this.f47463g == null && this.f47463g.length() > 0) {
                                    pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f47463g, 0L));
                                    if (this.n == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.n == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            D0(pbPageRequestMessage);
                            break;
                        }
                        if (!this.A) {
                        }
                        if (F != null) {
                            size = F.size();
                            i3 = 1;
                            while (true) {
                                i4 = size - i3;
                                if (i4 >= 0) {
                                }
                                i3++;
                            }
                            if (this.n == 2) {
                            }
                        }
                        if (this.f47463g == null) {
                        }
                        if (this.n == 1) {
                        }
                        D0(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.f47463g = F.get(0).G();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.A) {
                            if (l0()) {
                                if (this.u - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.u - 1));
                                }
                            } else if (this.t < this.v) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                            }
                        }
                        if (this.f47463g != null && this.f47463g.length() > 0) {
                            pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f47463g, 0L));
                            if (this.n == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        D0(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.A && !this.k) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!l0()) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                if (this.v > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.v));
                                }
                            }
                            if (this.A) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            F0(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!l0()) {
                        }
                        if (this.A) {
                        }
                        F0(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f47463g, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        D0(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.s));
                        pbPageRequestMessage.set_banner(0);
                        D0(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.n == 1 && this.i0 && !this.k) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f47463g, 0L));
                            if (this.n == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        pbPageRequestMessage.set_back(0);
                        if (this.k) {
                            pbPageRequestMessage.set_banner(0);
                        } else {
                            pbPageRequestMessage.set_banner(1);
                        }
                        D0(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.e0);
                        D0(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.q0, 0L));
                        if (this.n == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.i0 = this.k;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.A));
                pbPageRequestMessage.setCacheKey(a0());
                pbPageRequestMessage.setObjParam1(String.valueOf(this.k0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.d0);
                pbPageRequestMessage.setFromSmartFrs(this.g0 ? 1 : 0);
                if (UtilHelper.isUgcThreadType(this.y0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.f47464h);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.f47466j);
                if (this.k0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.k0 != 7 && this.k0 != 5 && !this.D0) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.w0);
                    pbPageRequestMessage.setOriUgcTid(this.x0);
                    pbPageRequestMessage.setOriUgcType(this.y0);
                    pbPageRequestMessage.setOriUgcVid(this.z0);
                    if (!StringUtils.isNull(this.B0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.B0));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            i5 = pbPageRequestMessage.getPn().intValue() == this.v ? -1 : Z();
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i5 = Z();
                            }
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i5);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.C0);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f47462f);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.w0);
                pbPageRequestMessage.setOriUgcTid(this.x0);
                pbPageRequestMessage.setOriUgcType(this.y0);
                pbPageRequestMessage.setOriUgcVid(this.z0);
                if (!StringUtils.isNull(this.B0)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i5);
                pbPageRequestMessage.setImmersionVideoCommentSource(this.C0);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f47462f);
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
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.F0 : (String) invokeV.objValue;
    }

    public final void B0(String str, boolean z, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i2)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i2);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.G0 : (String) invokeV.objValue;
    }

    public void C0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.C0 = i2;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            c.a.r0.u2.h.f fVar = this.G;
            if (fVar == null || fVar.O() == null || this.G.l() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.G.O().p2()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.G.l().getId());
                writeData.setForumName(this.G.l().getName());
            }
            writeData.setFromForumId(this.f47465i);
            writeData.sourceFrom = String.valueOf(this.k0);
            writeData.setThreadId(this.f47462f);
            writeData.setIsAd(this.w);
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

    public final void D0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(b0()) || z.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(z.q().b().e(b0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(z.q().b().d(b0(), true));
    }

    public void E0(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gVar) == null) {
            this.N = gVar;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.E0 : invokeV.booleanValue;
    }

    public final void F0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(b0()) || z.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(z.q().b().d(b0(), true) + 1);
        pbPageRequestMessage.setLoadCount(z.q().b().e(b0(), true));
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.I0 : invokeV.booleanValue;
    }

    public void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.f47461e = i2;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (!TextUtils.isEmpty(this.f47463g) && !"0".equals(this.f47463g)) {
                return o0();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public c.a.r0.u2.h.f H0(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            e2 O = fVar.O();
            O.c4(this.p);
            O.d4(this.q);
            long j2 = this.r;
            if (j2 > 0) {
                O.h4(j2);
            }
            X(O);
            return fVar;
        }
        return (c.a.r0.u2.h.f) invokeL.objValue;
    }

    public final void I0(@NonNull c.a.r0.u2.h.f fVar) {
        c.a.r0.u2.h.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, fVar) == null) || (fVar2 = this.G) == null) {
            return;
        }
        fVar2.e().clear();
        this.G.e().addAll(fVar.e());
    }

    public void J0(c.a.r0.u2.h.f fVar, ArrayList<PostData> arrayList) {
        String e0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, fVar, arrayList) == null) || arrayList == null || fVar.F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(fVar.F(), 0);
        if (postData != null && (e0 = e0(arrayList)) != null && e0.equals(postData.G())) {
            fVar.F().remove(postData);
        }
        this.G.Z = arrayList.size();
        arrayList.addAll(fVar.F());
    }

    public void K0(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) || fVar == null) {
            return;
        }
        fVar.N0(this.G.X());
        c.a.r0.u2.h.f fVar2 = this.G;
        if (!fVar2.X && fVar.X && fVar2.i() != null) {
            fVar.B0(this.G.i());
        }
        this.G = fVar;
        y0(fVar.y().a());
    }

    public void U(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, b1Var) == null) {
            if (b1Var == null) {
                y0(1);
                return;
            }
            if (this.t < b1Var.a()) {
                this.t = b1Var.a();
            }
            if (this.u > b1Var.a()) {
                this.u = b1Var.a();
            }
            this.v = b1Var.h();
        }
    }

    public final void V(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, fVar) == null) || fVar == null || fVar.z() == null || fVar.z().getAdvertAppInfo() == null || !fVar.z().N0() || fVar.z().getAdvertAppInfo().i4 == 1001) {
            return;
        }
        this.v0 = fVar.z();
    }

    public void W(c.a.r0.u2.h.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, fVar) == null) || fVar == null) {
            return;
        }
        if (this.L || this.J || this.K) {
            H0(fVar);
        }
    }

    public void X(@NonNull e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, e2Var) == null) {
            e2Var.U2 = F();
            e2Var.V2 = B();
            e2Var.W2 = C();
            e2Var.X2 = C();
            e2Var.Y2 = G();
            e2Var.H3(w());
        }
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.f47462f);
            if (!this.C) {
                sb.append(this.f47463g);
            }
            sb.append(this.k);
            sb.append(this.m);
            sb.append(this.n);
            sb.append(this.mStType);
            sb.append(this.p);
            sb.append(this.q);
            sb.append(this.r);
            sb.append(this.y);
            sb.append(this.z);
            sb.append(this.A);
            sb.append(this.w);
            sb.append(this.x);
            sb.append(this.E);
            sb.append(this.D);
            sb.append(this.F);
            sb.append(this.I);
            sb.append(this.J);
            sb.append(this.K);
            sb.append(this.L);
            sb.append(this.w0);
            sb.append(this.x0);
            sb.append(this.z0);
            sb.append(this.y0);
            String str = this.R;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            int i2 = 0;
            if (h0().F() == null) {
                return 0;
            }
            ArrayList<PostData> F = h0().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                PostData postData = F.get(size);
                if (!(postData instanceof o)) {
                    i2++;
                } else if (postData.getType() != AdvertAppInfo.C4) {
                    return i2;
                }
            }
            return F.size();
        }
        return invokeV.intValue;
    }

    public final String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            String f0 = !"0".equals(this.f47462f) ? this.f47462f : f0();
            if (this.k) {
                f0 = f0 + "_host";
            }
            int i2 = this.n;
            if (i2 == 1) {
                f0 = f0 + "_rev";
            } else if (i2 == 2) {
                f0 = f0 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return f0 + TbadkCoreApplication.getCurrentAccount();
            }
            return f0;
        }
        return (String) invokeV.objValue;
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.k : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public final String e0(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i2 = count - 1; i2 >= 0; i2--) {
                PostData postData = (PostData) ListUtils.getItem(arrayList, i2);
                if (postData != null && !StringUtils.isNull(postData.G())) {
                    return postData.G();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            String str = "";
            if (this.w0 != null) {
                str = "" + this.w0;
            }
            if (this.x0 != null) {
                str = str + this.x0;
            }
            String str2 = str + this.y0;
            if (this.z0 != null) {
                return str2 + this.z0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.k0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f47464h : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.f47465i : (String) invokeV.objValue;
    }

    public c.a.r0.u2.h.f h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.G : (c.a.r0.u2.h.f) invokeV.objValue;
    }

    public int i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, intent) == null) || intent == null) {
            return;
        }
        this.f47462f = intent.getStringExtra("thread_id");
        this.w0 = intent.getStringExtra("key_ori_ugc_nid");
        this.x0 = intent.getStringExtra("key_ori_ugc_tid");
        this.y0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.z0 = intent.getStringExtra("key_ori_ugc_vid");
        this.B0 = intent.getStringExtra("key_official_bar_message_id");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.A0 = uri != null ? uri.toString() : null;
        this.D0 = false;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.D0 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.J0);
        } else if (StringUtils.isNull(this.f47462f)) {
            this.D0 = true;
            this.h0.b(intent, this.J0);
            if (uri != null) {
                if (StringUtils.isNull(this.f47462f)) {
                    this.f47462f = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.w0)) {
                    this.w0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.x0)) {
                    this.x0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.y0 == 0) {
                    this.y0 = c.a.d.f.m.b.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.z0)) {
                    this.z0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (m.isEmpty(this.f47462f)) {
            this.f47462f = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.k0 = intExtra;
        if (intExtra == 0) {
            this.k0 = this.h0.a;
        }
        this.f47463g = intent.getStringExtra("post_id");
        this.f47464h = intent.getStringExtra("forum_id");
        this.f47465i = intent.getStringExtra("from_forum_id");
        this.f47466j = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.k = intent.getBooleanExtra("host_only", false);
        this.m = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.n = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = c.a.q0.r.j0.b.k().l("key_pb_current_sort_type", 2);
        }
        this.n = intExtra2;
        this.f47463g = intExtra2 != 2 ? this.f47463g : "0";
        this.mStType = intent.getStringExtra("st_type");
        this.M = intent.getStringExtra("locate");
        this.p = intent.getIntExtra("is_good", 0);
        this.q = intent.getIntExtra("is_top", 0);
        this.r = intent.getLongExtra("thread_time", 0L);
        this.A = intent.getBooleanExtra("from_mark", false);
        this.B = intent.getBooleanExtra("KEY_SHOULD_ADD_POST_ID", false);
        this.C = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.w = intent.getBooleanExtra("is_ad", false);
        this.x = intent.getBooleanExtra("is_sub_pb", false);
        this.E = intent.getBooleanExtra("is_pv", false);
        this.D = intent.getLongExtra("msg_id", 0L);
        this.F = intent.getStringExtra("from_forum_name");
        this.R = intent.getStringExtra("extra_pb_cache_key");
        this.O = intent.getStringExtra("op_type");
        this.P = intent.getStringExtra("op_url");
        this.Q = intent.getStringExtra("op_stat");
        this.J = intent.getBooleanExtra("is_from_thread_config", false);
        this.K = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.L = intent.getBooleanExtra("is_from_my_god_config", false);
        this.T = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.S = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.y = intent.getBooleanExtra("from_frs", false);
        this.z = intent.getBooleanExtra("from_maintab", false);
        this.g0 = intent.getBooleanExtra("from_smart_frs", false);
        this.u0 = intent.getBooleanExtra("key_is_share_thread", false);
        intent.getBooleanExtra("key_need_preload", false);
        this.U = intent.getIntExtra("request_code", -1) == 18003;
        this.E0 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.F0 = intent.getStringExtra("key_tieba_plus_order_id");
        this.G0 = intent.getStringExtra("key_tieba_plus_token");
        this.H0 = intent.getStringExtra("key_tieba_extra_param");
        this.I0 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
    }

    public int j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.H : invokeV.intValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? l0() : invokeV.booleanValue;
    }

    public final boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            int i2 = this.n;
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (this.f47462f == null) {
                return false;
            }
            cancelLoadData();
            if (this.V == null) {
                c.a.r0.y3.m0.b bVar = new c.a.r0.y3.m0.b("pbStat");
                this.V = bVar;
                bVar.f();
            }
            boolean A0 = A0(3);
            if (this.O != null) {
                this.O = null;
                this.Q = null;
                this.P = null;
            }
            return A0;
        }
        return invokeV.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? g0() == 3 || h0() == null || h0().O() == null || !h0().O().p2() : invokeV.booleanValue;
    }

    public boolean n0(boolean z) {
        InterceptResult invokeZ;
        c.a.r0.u2.h.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
            if (this.f47462f == null || (fVar = this.G) == null) {
                return false;
            }
            if (z || fVar.y().b() != 0) {
                return A0(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (this.f47462f == null || this.f47463g == null) {
                return false;
            }
            cancelMessage();
            if (this.A) {
                return A0(4);
            }
            return A0(6);
        }
        return invokeV.booleanValue;
    }

    public void p0(c.a.r0.u2.h.f fVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048620, this, fVar, i2, str) == null) {
            this.b0 = true;
            if (fVar == null || fVar.f23098h != null) {
                return;
            }
            K0(fVar);
            W(fVar);
            if (fVar.O() != null) {
                fVar.O().E3(0);
            }
            g gVar = this.N;
            if (gVar == null || fVar == null) {
                return;
            }
            gVar.c(true, 0, i2, 0, fVar, str, 0);
        }
    }

    public void q0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048621, this, i2) == null) {
            v0(i2);
            ArrayList<PostData> F = this.G.F();
            boolean z = false;
            this.a0 = false;
            if (i2 != 1) {
                if (i2 == 2) {
                    while (F.size() + 30 > c.a.q0.t.d.a()) {
                        F.remove(F.size() - 1);
                        z = true;
                    }
                    if (z) {
                        this.G.y().l(1);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z2 = false;
            while (F.size() + 30 > c.a.q0.t.d.a()) {
                F.remove(0);
                z2 = true;
            }
            if (z2) {
                this.G.y().m(1);
                g gVar = this.N;
                if (gVar != null) {
                    gVar.b(this.G);
                }
            }
            this.Z = System.currentTimeMillis();
            this.a0 = true;
        }
    }

    public void r0(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, pbpagehttpresponsemessage) == null) {
            t0(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, pbpagehttpresponsemessage.getDownSize(), pbpagehttpresponsemessage.getCostTime(), 0L);
        }
    }

    public void s0(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, pbpagesocketresponsemessage) == null) {
            t0(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, pbpagesocketresponsemessage.getDownSize(), 0L, pbpagesocketresponsemessage.getCostTime());
        }
    }

    public void t0(c.a.r0.u2.h.f fVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j2, long j3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            c.a.r0.u2.h.f fVar2 = z ? null : fVar;
            this.isLoading = false;
            if (fVar2 != null) {
                W(fVar2);
            }
            V(fVar2);
            o oVar = this.v0;
            if (oVar != null && oVar.N0()) {
                TiebaStatic.log(c.a.r0.x3.a.h("a005", "common_fill", true, 1));
            }
            u0(fVar2, i2, z, i3, str, z2, i4, j2, j3, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void u0(c.a.r0.u2.h.f fVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j2, long j3, boolean z3) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048625, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.f0 = z3;
            c.a.r0.y3.m0.b bVar = this.V;
            if (bVar != null && !z3) {
                bVar.b(z2, z4, i3, str, i4, j2, j3);
                this.V = null;
            }
            c.a.r0.u2.h.f fVar2 = this.G;
            if (fVar2 != null) {
                fVar2.a0 = z3;
                fVar2.b0 = i2;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(b0()) && z.q().b() != null) {
                z.q().b().g(b0(), x0(j0()), true);
            }
            if (fVar != null && (this.s != 1 || i2 != 5 || fVar.F() == null || fVar.F().size() >= 1)) {
                this.l = this.m;
                if (i2 != 8) {
                    this.o = this.n;
                    this.n = fVar.f23097g;
                }
                List<PbSortType> list = fVar.f23096f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.W.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    fVar.f23096f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.W.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    fVar.f23096f.add(builder2.build(false));
                    int i7 = this.o;
                    this.n = i7;
                    fVar.f23097g = i7;
                }
                this.E = false;
                if (fVar.y() != null && (this.n != 2 || i2 != 8)) {
                    U(fVar.y());
                }
                int i8 = this.v;
                if (i8 < 1) {
                    i8 = 1;
                }
                this.v = i8;
                ArrayList<PostData> F = this.G.F();
                switch (i2) {
                    case 1:
                        this.G.F0(fVar.y(), 1);
                        J0(fVar, F);
                        I0(fVar);
                        i5 = 0;
                        break;
                    case 2:
                        if (fVar.F() != null) {
                            i5 = fVar.F().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(F, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(fVar.F(), ListUtils.getCount(fVar.F()) - 1);
                            if (postData != null && postData2 != null && postData.G().equals(postData2.G())) {
                                fVar.F().remove(postData2);
                                i5--;
                            }
                            F.addAll(0, fVar.F());
                        } else {
                            i5 = 0;
                        }
                        I0(fVar);
                        this.G.F0(fVar.y(), 2);
                        break;
                    case 3:
                        if (this.n == 1 && fVar.y() != null) {
                            fVar.y().k(fVar.y().h());
                        }
                        K0(fVar);
                        i5 = 0;
                        break;
                    case 4:
                        K0(fVar);
                        i5 = 0;
                        break;
                    case 5:
                        K0(fVar);
                        i5 = 0;
                        break;
                    case 6:
                        K0(fVar);
                        i5 = 0;
                        break;
                    case 7:
                        K0(fVar);
                        i5 = 0;
                        break;
                    case 8:
                        if (fVar == null || ListUtils.isEmpty(fVar.F()) || this.G == null || (this.k && !w0(fVar).equals(fVar.F().get(0).t().getUserId()))) {
                            i6 = 0;
                        } else {
                            if (this.G.y().b() == 0) {
                                this.G.y().l(1);
                            }
                            z0();
                            this.r0 = fVar.F().get(0);
                            if (!l0() && !this.G.g0()) {
                                if (this.t0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.s0 = postData3;
                                    postData3.F = false;
                                    postData3.x0(53);
                                    this.G.F().add(0, this.s0);
                                }
                                this.G.F().add(0, this.r0);
                                i6 = 0;
                            } else {
                                if (this.G.F().size() - this.t0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.s0 = postData4;
                                    postData4.F = true;
                                    postData4.x0(53);
                                    this.G.F().add(this.s0);
                                }
                                this.G.F().add(this.r0);
                                i6 = this.G.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(c.a.q0.r.j0.b.k().m("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.r0.V = this.G.J();
                                c.a.q0.r.j0.b.k().x("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        I0(fVar);
                        i5 = i6;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
                c.a.r0.u2.h.f fVar3 = this.G;
                if (fVar3 != null && fVar3.O() != null) {
                    PraiseData N0 = this.G.O().N0();
                    if (this.O0 != null && !N0.isPriaseDataValid()) {
                        this.G.O().r4(this.O0);
                    } else {
                        PraiseData N02 = this.G.O().N0();
                        this.O0 = N02;
                        N02.setPostId(this.G.O().X());
                    }
                    if (fVar.y() != null && fVar.y().a() == 1 && fVar.O() != null && fVar.O().q() != null && fVar.O().q().size() > 0) {
                        this.G.O().v3(fVar.O().q());
                    }
                    this.G.O().s4(fVar.O().W0());
                    this.G.O().A3(fVar.O().F());
                    this.G.O().E3(fVar.O().O());
                    if (this.I == 33) {
                        this.G.O().J().setHadConcerned(fVar.O().J().hadConcerned());
                    }
                    if (fVar != null && fVar.O() != null) {
                        this.G.O().S4(fVar.O().p0());
                    }
                }
                c.a.r0.u2.h.f fVar4 = this.G;
                if (fVar4 != null && fVar4.U() != null && fVar.U() != null) {
                    this.G.U().setBimg_end_time(fVar.U().getBimg_end_time());
                    this.G.U().setBimg_url(fVar.U().getBimg_url());
                }
                if (fVar.y() != null && fVar.y().a() == 1 && fVar.W() != null) {
                    this.G.M0(fVar.W());
                }
                if (this.f0) {
                    if (this.G.O() != null && this.G.O().J() != null && this.G.F() != null && ListUtils.getItem(this.G.F(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.G.F(), 0);
                        MetaData J = this.G.O().J();
                        if (postData5.t() != null && postData5.t().getGodUserData() != null) {
                            int i9 = this.S;
                            if (i9 != -1) {
                                J.setFansNum(i9);
                                postData5.t().setFansNum(this.S);
                            }
                            if (this.T != -1) {
                                J.getGodUserData().setIsLike(this.T == 1);
                                postData5.t().getGodUserData().setIsLike(this.T == 1);
                                J.getGodUserData().setIsFromNetWork(false);
                                postData5.t().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    c.a.r0.u2.h.f fVar5 = this.G;
                    fVar5.f23095e = -1;
                    fVar5.f23094d = -1;
                }
                g gVar = this.N;
                if (gVar != null) {
                    gVar.c(true, getErrorCode(), i2, i5, this.G, this.mErrorString, 1);
                }
            } else if (this.N != null) {
                this.m = this.l;
                if (i3 != 350006) {
                    this.n = this.o;
                }
                this.N.c(false, i3, i2, 0, null, str, 1);
            }
            c.a.r0.u2.h.f fVar6 = this.G;
            if (fVar6 == null || fVar6.O() == null || this.G.l() == null || this.G.g0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.W;
            historyMessage.threadId = h0().O().h0();
            if (this.u0 && h0().O().z1 != null) {
                historyMessage.threadName = h0().O().z1.f38789b;
            } else {
                historyMessage.threadName = h0().O().getTitle();
            }
            if (this.u0 && !m0()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = h0().l().getName();
            }
            historyMessage.isHostOnly = c0();
            historyMessage.isSquence = k0();
            historyMessage.threadType = h0().O().s1();
            historyMessage.isShareThread = this.u0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public final void v0(int i2) {
        c.a.r0.u2.h.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048626, this, i2) == null) || i2 == 8) {
            return;
        }
        this.q0 = "";
        if (this.r0 != null) {
            if (i2 == 1 && (fVar = this.G) != null && fVar.g0()) {
                if (this.s0 != null) {
                    h0().F().remove(this.s0);
                }
            } else if (i2 == 1 && !this.m && !ListUtils.isEmpty(h0().F())) {
                h0().F().remove(this.r0);
                if (this.s0 != null) {
                    h0().F().remove(this.s0);
                }
                h0().F().add(0, this.r0);
            } else {
                h0().F().remove(this.r0);
                if (this.s0 != null) {
                    h0().F().remove(this.s0);
                }
            }
        }
        this.s0 = null;
    }

    public String w0(c.a.r0.u2.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, fVar)) == null) {
            String str = null;
            if (fVar == null) {
                return null;
            }
            if (fVar.O() != null && fVar.O().J() != null) {
                str = fVar.O().J().getUserId();
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public final int x0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            if (i2 != 1) {
                return i2 != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.c0 : (String) invokeV.objValue;
    }

    public void y0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i2) == null) {
            this.s = i2;
            this.t = i2;
            this.u = i2;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.f47462f : (String) invokeV.objValue;
    }

    public void z0() {
        c.a.r0.u2.h.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (fVar = this.G) == null || ListUtils.isEmpty(fVar.F())) {
            return;
        }
        if (this.s0 != null) {
            this.G.F().remove(this.s0);
            this.s0 = null;
        }
        if (this.r0 != null) {
            this.G.F().remove(this.r0);
            this.r0 = null;
        }
    }
}
