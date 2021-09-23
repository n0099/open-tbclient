package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.p.j;
import c.a.e.e.p.k;
import c.a.e.e.p.l;
import c.a.q0.a.g;
import c.a.q0.s.q.b1;
import c.a.q0.s.q.d2;
import c.a.r0.j2.h.u;
import c.a.r0.j2.k.e.b0;
import c.a.r0.j2.k.e.c0;
import c.a.r0.j2.k.e.k0;
import c.a.r0.j3.i0.p;
import c.a.r0.y2.y;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes7.dex */
public class PbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_HOT = "_hot";
    public static final String DB_KEY_REVER = "_rev";
    public static final int MIN_NUM_SHOW_GO_BACK_ITEM = 3;
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    public static int UPGRADE_TO_PHOTO_LIVE;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public final AddExperiencedModel A0;
    public boolean B;
    public SuggestEmotionModel B0;
    public boolean C;
    public GetSugMatchWordsModel C0;
    public boolean D;
    public boolean D0;
    public boolean E;
    public int E0;
    public boolean F;
    public String F0;
    public long G;
    public PostData G0;
    public boolean H;
    public PostData H0;
    public String I;
    public int I0;
    public c.a.r0.j2.h.e J;
    public int J0;
    public int K;
    public boolean K0;
    public int L;
    public Rect L0;
    public boolean M;
    public int M0;
    public boolean N;
    public String N0;
    public boolean O;
    public p O0;
    public boolean P;
    public boolean P0;
    public String Q;
    public String Q0;
    public Context R;
    public String R0;
    public g S;
    public int S0;
    public String T;
    public String T0;
    public String U;
    public String U0;
    public String V;
    public String V0;
    public String W;
    public String W0;
    public int X;
    public String X0;
    public int Y;
    public String Y0;
    public boolean Z;
    public boolean Z0;
    public c.a.r0.j3.k0.b a0;
    public int a1;
    public BaseFragmentActivity b0;
    public String b1;
    public boolean c0;
    public int c1;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public int f55293e;
    public boolean e1;

    /* renamed from: f  reason: collision with root package name */
    public String f55294f;
    public String f1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55295g;
    public String g1;

    /* renamed from: h  reason: collision with root package name */
    public String f55296h;
    public String h1;

    /* renamed from: i  reason: collision with root package name */
    public String f55297i;
    public boolean i0;
    public boolean i1;
    public boolean isLoading;

    /* renamed from: j  reason: collision with root package name */
    public String f55298j;
    public long j0;
    public boolean j1;
    public String k;
    public boolean k0;
    public g.b k1;
    public boolean l;
    public boolean l0;
    public CustomMessageListener l1;
    public boolean m;
    public String m0;
    public c.a.e.c.g.a m1;
    public String mStType;
    public boolean n;
    public String n0;
    public CustomMessageListener n1;
    public boolean o;
    public long o0;
    public CustomMessageListener o1;
    public int p;
    public boolean p0;
    public PraiseData p1;
    public int q;
    public int q0;
    public boolean r;
    public boolean r0;
    public int s;
    public boolean s0;
    public int t;
    public int t0;
    public long u;
    public c.a.r0.j2.h.c u0;
    public int v;
    public final b0 v0;
    public int w;
    public final c.a.r0.j2.k.e.p w0;
    public int x;
    public final c0 x0;
    public int y;
    public String y0;
    public boolean z;
    public final CheckRealNameModel z0;

    /* loaded from: classes7.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f55299a;

        public a(PbModel pbModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55299a = pbModel;
        }

        @Override // c.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(c.a.q0.a.g.p) instanceof String) {
                this.f55299a.f55294f = (String) hashMap.get(c.a.q0.a.g.p);
            }
            if (hashMap.get(c.a.q0.a.g.q) instanceof String) {
                this.f55299a.Q0 = (String) hashMap.get(c.a.q0.a.g.q);
            }
            if (hashMap.get(c.a.q0.a.g.r) instanceof String) {
                this.f55299a.R0 = (String) hashMap.get(c.a.q0.a.g.r);
            }
            if (hashMap.get(c.a.q0.a.g.s) instanceof String) {
                this.f55299a.S0 = c.a.e.e.m.b.e((String) hashMap.get(c.a.q0.a.g.s), 0);
            }
            if (hashMap.get(c.a.q0.a.g.t) instanceof String) {
                this.f55299a.T0 = (String) hashMap.get(c.a.q0.a.g.t);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f55300a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbModel pbModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i2)};
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
            this.f55300a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.f55300a.P0() == null || this.f55300a.P0().m() == null || this.f55300a.P0().m().getSignData() == null || !signData.forumId.equals(this.f55300a.P0().n())) {
                return;
            }
            this.f55300a.P0().m().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes7.dex */
    public class c extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f55301a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbModel pbModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f55301a = pbModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.f55301a.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && j.z()) {
                        this.f55301a.b0.showToast(responsedMessage.getErrorString());
                    }
                    if (z2) {
                        this.f55301a.M1((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.f55301a.L1((pbPageHttpResponseMessage) responsedMessage);
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
                        c.a.q0.s.z.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (this.f55301a.c0 && this.f55301a.i0) {
                        return;
                    }
                    if (!this.f55301a.c0) {
                        this.f55301a.c0 = true;
                    } else {
                        this.f55301a.i0 = true;
                    }
                    if (this.f55301a.S != null) {
                        this.f55301a.S.a(this.f55301a.R0(), z, responsedMessage, this.f55301a.k0, System.currentTimeMillis() - this.f55301a.j0);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f55302a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbModel pbModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i2)};
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
            this.f55302a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                c.a.r0.j2.h.e eVar = this.f55302a.J;
                if (eVar == null || eVar.h() == null || this.f55302a.J.h().getForumId() == null || !this.f55302a.J.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.f55302a.J.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f55303a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbModel pbModel, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i2)};
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
            this.f55303a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                c.a.r0.j2.h.e eVar = this.f55303a.J;
                if (eVar == null || eVar.h() == null || this.f55303a.J.h().getForumId() == null || !this.f55303a.J.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.f55303a.J.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.r0.j2.h.e f55304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbModel f55305f;

        public f(PbModel pbModel, c.a.r0.j2.h.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f55305f = pbModel;
            this.f55304e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f55305f.O1(this.f55304e, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.f55305f.isLoading = false;
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface g {
        void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2);

        void b(c.a.r0.j2.h.e eVar);

        void c(boolean z, int i2, int i3, int i4, c.a.r0.j2.h.e eVar, String str, int i5);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(323112716, "Lcom/baidu/tieba/pb/pb/main/PbModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(323112716, "Lcom/baidu/tieba/pb/pb/main/PbModel;");
                return;
            }
        }
        int a2 = c.a.q0.u.c.a() / 30;
        UPGRADE_TO_PHOTO_LIVE = 1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PbModel(BaseFragmentActivity baseFragmentActivity) {
        super(baseFragmentActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((c.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f55293e = 4;
        this.mStType = null;
        this.f55294f = null;
        this.f55295g = false;
        this.f55296h = null;
        this.f55297i = null;
        this.k = null;
        this.l = false;
        this.m = false;
        this.n = true;
        this.o = true;
        this.p = 0;
        this.q = 0;
        this.r = false;
        this.s = 0;
        this.t = 0;
        this.u = 0L;
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.y = 1;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = 0L;
        this.H = false;
        this.I = null;
        this.J = null;
        this.isLoading = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = -1;
        this.Y = -1;
        this.a0 = null;
        this.c0 = false;
        this.i0 = false;
        this.m0 = null;
        this.n0 = null;
        this.o0 = 0L;
        this.p0 = false;
        this.q0 = -1;
        this.s0 = false;
        this.D0 = false;
        this.E0 = 0;
        this.M0 = 0;
        this.P0 = false;
        this.a1 = 3;
        this.c1 = 0;
        this.l1 = new b(this, 2001222);
        this.m1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.n1 = new d(this, 2001336);
        this.o1 = new e(this, 2001335);
        this.p1 = null;
        registerListener(this.m1);
        registerListener(this.l1);
        registerListener(this.o1);
        registerListener(this.n1);
        c.a.r0.j2.h.e eVar = new c.a.r0.j2.h.e();
        this.J = eVar;
        eVar.v0(0);
        this.R = baseFragmentActivity.getPageContext().getPageActivity();
        this.b0 = baseFragmentActivity;
        this.v0 = new b0(this, baseFragmentActivity);
        this.w0 = new c.a.r0.j2.k.e.p(this, this.b0);
        this.x0 = new c0(this, this.b0);
        this.z0 = new CheckRealNameModel(this.b0.getPageContext());
        this.B0 = new SuggestEmotionModel();
        this.A0 = new AddExperiencedModel(this.b0.getPageContext());
        this.k1 = new a(this);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.h1 : (String) invokeV.objValue;
    }

    public int A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.s : invokeV.intValue;
    }

    public void A1(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f55294f = eVar.Q();
        if (eVar.O() != null && eVar.O().L() != null) {
            BaijiahaoData L = eVar.O().L();
            this.Q0 = L.oriUgcNid;
            this.R0 = L.oriUgcTid;
            this.S0 = L.oriUgcType;
            this.T0 = L.oriUgcVid;
        } else {
            this.Q0 = null;
            this.R0 = null;
            this.S0 = 0;
            this.T0 = null;
        }
        this.f55296h = null;
        this.m = false;
        this.o = true;
        LoadData();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1 : (String) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null) {
                return false;
            }
            return eVar.s();
        }
        return invokeV.booleanValue;
    }

    public void B1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f55294f = str;
        this.f55296h = null;
        this.m = false;
        this.o = true;
        LoadData();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g1 : (String) invokeV.objValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.r : invokeV.booleanValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (this.f55294f == null || this.f55296h == null) {
                return false;
            }
            cancelMessage();
            if (this.D) {
                return X1(4);
            }
            return X1(6);
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null || eVar.O() == null || this.J.m() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.J.O().l2()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.J.m().getId());
                writeData.setForumName(this.J.m().getName());
            }
            writeData.setFromForumId(this.f55298j);
            writeData.sourceFrom = String.valueOf(this.E0);
            writeData.setThreadId(this.f55294f);
            writeData.setIsAd(this.z);
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

    public boolean D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean D1(boolean z) {
        InterceptResult invokeZ;
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (this.f55294f == null || (eVar = this.J) == null || ((!z && eVar.y().c() == 0) || this.J.F() == null || this.J.F().size() < 1)) {
                return false;
            }
            return X1(2);
        }
        return invokeZ.booleanValue;
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.t : invokeV.intValue;
    }

    public void E1(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.C0 == null) {
            this.C0 = new GetSugMatchWordsModel(this.b0.getPageContext());
        }
        this.C0.y(bVar);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.e1 : invokeV.booleanValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null) {
                return false;
            }
            return eVar.o0();
        }
        return invokeV.booleanValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            String str = this.f55296h;
            if (str != null && !str.equals("0") && this.f55296h.length() != 0) {
                return C1();
            }
            return LoadData();
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.i1 : invokeV.booleanValue;
    }

    public final String G0(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i2 = count - 1; i2 >= 0; i2--) {
                PostData postData = (PostData) ListUtils.getItem(arrayList, i2);
                if (postData != null && !StringUtils.isNull(postData.E())) {
                    return postData.E();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public final void G1() {
        c.a.r0.j3.k0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (bVar = this.a0) == null) {
            return;
        }
        bVar.a();
        this.a0 = null;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? F1() : invokeV.booleanValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.J0 : invokeV.intValue;
    }

    public void H1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || !"personalize_page".equals(this.mStType) || this.J == null || this.o0 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        TiebaStatic.log(new StatisticItem("c10754").param("fid", this.J.n()).param("tid", this.f55294f).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.o0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
        this.o0 = 0L;
    }

    public int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.I0 : invokeV.intValue;
    }

    public void I1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048600, this) == null) && "personalize_page".equals(this.mStType)) {
            this.o0 = System.currentTimeMillis() / 1000;
        }
    }

    public MarkData J0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f55294f);
            markData.setPostId(postData.E());
            markData.setTime(date.getTime());
            markData.setHostMode(this.m);
            markData.setSequence(Boolean.valueOf(t1()));
            markData.setId(this.f55294f);
            markData.setFloor(postData.A());
            markData.setForumId(this.f55297i);
            if (postData instanceof p) {
                p pVar = (p) postData;
                markData.setApp(pVar.getAdvertAppInfo() != null && pVar.getAdvertAppInfo().P4());
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void J1(c.a.r0.j2.h.e eVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048602, this, eVar, i2, str) == null) {
            this.l0 = true;
            if (eVar == null || eVar.f19633h != null) {
                return;
            }
            w2(eVar);
            Z(eVar);
            if (eVar.O() != null) {
                eVar.O().z3(0);
            }
            g gVar = this.S;
            if (gVar == null || eVar == null) {
                return;
            }
            gVar.c(true, 0, i2, 0, eVar, str, 0);
        }
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null || !eVar.s()) {
                return null;
            }
            return this.J.u();
        }
        return (String) invokeV.objValue;
    }

    public void K1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            P1(i2);
            ArrayList<PostData> F = this.J.F();
            boolean z = false;
            this.k0 = false;
            if (i2 != 1) {
                if (i2 == 2) {
                    while (F.size() + 30 > c.a.q0.u.c.a()) {
                        F.remove(F.size() - 1);
                        z = true;
                    }
                    if (z) {
                        this.J.y().l(1);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z2 = false;
            while (F.size() + 30 > c.a.q0.u.c.a()) {
                F.remove(0);
                z2 = true;
            }
            if (z2) {
                this.J.y().m(1);
                g gVar = this.S;
                if (gVar != null) {
                    gVar.b(this.J);
                }
            }
            this.j0 = System.currentTimeMillis();
            this.k0 = true;
        }
    }

    public c0 L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.x0 : (c0) invokeV.objValue;
    }

    public void L1(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.u0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            N1(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (this.f55294f == null) {
                return false;
            }
            cancelLoadData();
            if (this.a0 == null) {
                c.a.r0.j3.k0.b bVar = new c.a.r0.j3.k0.b("pbStat");
                this.a0 = bVar;
                bVar.f();
            }
            boolean X1 = X1(3);
            if (this.T != null) {
                this.T = null;
                this.V = null;
                this.U = null;
            }
            return X1;
        }
        return invokeV.booleanValue;
    }

    public final String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            String str = "";
            if (this.Q0 != null) {
                str = "" + this.Q0;
            }
            if (this.R0 != null) {
                str = str + this.R0;
            }
            String str2 = str + this.S0;
            if (this.T0 != null) {
                return str2 + this.T0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void M1(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.u0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            N1(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public b1 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null) {
                return null;
            }
            return eVar.y();
        }
        return (b1) invokeV.objValue;
    }

    public void N1(c.a.r0.j2.h.e eVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j2, long j3) {
        c.a.r0.j2.h.e eVar2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048611, this, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (z) {
                i5 = i3;
                eVar2 = null;
            } else {
                eVar2 = eVar;
                i5 = i3;
            }
            this.t0 = i5;
            this.isLoading = false;
            if (eVar2 != null) {
                Z(eVar2);
            }
            V(eVar2);
            p pVar = this.O0;
            if (pVar != null && pVar.I0()) {
                TiebaStatic.log(c.a.r0.i3.a.h("a005", "common_fill", true, 1));
            }
            O1(eVar2, i2, z, i3, str, z2, i4, j2, j3, false);
        }
    }

    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.E0 : invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void O1(c.a.r0.j2.h.e eVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j2, long j3, boolean z3) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.r0 = z3;
            c.a.r0.j3.k0.b bVar = this.a0;
            if (bVar != null && !z3) {
                bVar.b(z2, z4, i3, str, i4, j2, j3);
                this.a0 = null;
            }
            c.a.r0.j2.h.e eVar2 = this.J;
            if (eVar2 != null) {
                eVar2.a0 = z3;
                eVar2.b0 = i2;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(q0()) && y.o().b() != null) {
                y.o().b().g(q0(), T1(Z0()), true);
            }
            if (eVar != null && (this.v != 1 || i2 != 5 || eVar.F() == null || eVar.F().size() >= 1)) {
                this.n = this.o;
                if (i2 != 8) {
                    this.q = this.p;
                    this.p = eVar.f19632g;
                }
                List<PbSortType> list = eVar.f19631f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.b0.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    eVar.f19631f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.b0.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    eVar.f19631f.add(builder2.build(false));
                    int i7 = this.q;
                    this.p = i7;
                    eVar.f19632g = i7;
                }
                this.H = false;
                if (eVar.y() != null && (this.p != 2 || i2 != 8)) {
                    U(eVar.y());
                }
                int i8 = this.y;
                if (i8 < 1) {
                    i8 = 1;
                }
                this.y = i8;
                ArrayList<PostData> F = this.J.F();
                switch (i2) {
                    case 1:
                        this.J.C0(eVar.y(), 1);
                        v2(eVar, F);
                        t2(eVar);
                        i5 = 0;
                        break;
                    case 2:
                        if (eVar.F() != null) {
                            i5 = eVar.F().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(F, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(eVar.F(), ListUtils.getCount(eVar.F()) - 1);
                            if (postData != null && postData2 != null && postData.E().equals(postData2.E())) {
                                eVar.F().remove(postData2);
                                i5--;
                            }
                            F.addAll(0, eVar.F());
                        } else {
                            i5 = 0;
                        }
                        t2(eVar);
                        this.J.C0(eVar.y(), 2);
                        break;
                    case 3:
                        if (this.p == 1 && eVar.y() != null) {
                            eVar.y().k(eVar.y().h());
                        }
                        w2(eVar);
                        i5 = 0;
                        break;
                    case 4:
                        w2(eVar);
                        i5 = 0;
                        break;
                    case 5:
                        w2(eVar);
                        i5 = 0;
                        break;
                    case 6:
                        w2(eVar);
                        i5 = 0;
                        break;
                    case 7:
                        w2(eVar);
                        i5 = 0;
                        break;
                    case 8:
                        if (eVar == null || ListUtils.isEmpty(eVar.F()) || this.J == null || (this.m && !S1(eVar).equals(eVar.F().get(0).t().getUserId()))) {
                            i6 = 0;
                        } else {
                            if (this.J.y().b() == 0) {
                                this.J.y().l(1);
                            }
                            V1();
                            this.G0 = eVar.F().get(0);
                            if (!t1() && !this.J.f0()) {
                                if (this.I0 - this.J0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.H0 = postData3;
                                    postData3.D = false;
                                    postData3.t0(53);
                                    this.J.F().add(0, this.H0);
                                }
                                this.J.F().add(0, this.G0);
                                i6 = 0;
                            } else {
                                if (this.J.F().size() - this.I0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.H0 = postData4;
                                    postData4.D = true;
                                    postData4.t0(53);
                                    this.J.F().add(this.H0);
                                }
                                this.J.F().add(this.G0);
                                i6 = this.J.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(c.a.q0.s.d0.b.j().l("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.G0.T = this.J.J();
                                c.a.q0.s.d0.b.j().w("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        t2(eVar);
                        i5 = i6;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
                c.a.r0.j2.h.e eVar3 = this.J;
                if (eVar3 != null && eVar3.O() != null) {
                    PraiseData L0 = this.J.O().L0();
                    if (this.p1 != null && !L0.isPriaseDataValid()) {
                        this.J.O().l4(this.p1);
                    } else {
                        PraiseData L02 = this.J.O().L0();
                        this.p1 = L02;
                        L02.setPostId(this.J.O().W());
                    }
                    if (eVar.y() != null && eVar.y().a() == 1 && eVar.O() != null && eVar.O().q() != null && eVar.O().q().size() > 0) {
                        this.J.O().q3(eVar.O().q());
                    }
                    this.J.O().m4(eVar.O().U0());
                    this.J.O().v3(eVar.O().F());
                    this.J.O().z3(eVar.O().O());
                    if (this.L == 33) {
                        this.J.O().J().setHadConcerned(eVar.O().J().hadConcerned());
                    }
                    if (eVar != null && eVar.O() != null) {
                        this.J.O().L4(eVar.O().n0());
                    }
                }
                c.a.r0.j2.h.e eVar4 = this.J;
                if (eVar4 != null && eVar4.U() != null && eVar.U() != null) {
                    this.J.U().setBimg_end_time(eVar.U().getBimg_end_time());
                    this.J.U().setBimg_url(eVar.U().getBimg_url());
                }
                if (eVar.y() != null && eVar.y().a() == 1 && eVar.W() != null) {
                    this.J.J0(eVar.W());
                }
                if (this.r0) {
                    if (this.J.O() != null && this.J.O().J() != null && this.J.F() != null && ListUtils.getItem(this.J.F(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.J.F(), 0);
                        MetaData J = this.J.O().J();
                        if (postData5.t() != null && postData5.t().getGodUserData() != null) {
                            int i9 = this.X;
                            if (i9 != -1) {
                                J.setFansNum(i9);
                                postData5.t().setFansNum(this.X);
                            }
                            if (this.Y != -1) {
                                J.getGodUserData().setIsLike(this.Y == 1);
                                postData5.t().getGodUserData().setIsLike(this.Y == 1);
                                J.getGodUserData().setIsFromNetWork(false);
                                postData5.t().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    c.a.r0.j2.h.e eVar5 = this.J;
                    eVar5.f19630e = -1;
                    eVar5.f19629d = -1;
                }
                g gVar = this.S;
                if (gVar != null) {
                    gVar.c(true, getErrorCode(), i2, i5, this.J, this.mErrorString, 1);
                }
            } else if (this.S != null) {
                this.o = this.n;
                if (i3 != 350006) {
                    this.p = this.q;
                }
                this.S.c(false, i3, i2, 0, null, str, 1);
            }
            c.a.r0.j2.h.e eVar6 = this.J;
            if (eVar6 == null || eVar6.O() == null || this.J.m() == null || this.J.f0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.b0.getPageContext();
            historyMessage.threadId = P0().O().f0();
            if (this.K0 && P0().O().y1 != null) {
                historyMessage.threadName = P0().O().y1.f47520b;
            } else {
                historyMessage.threadName = P0().O().getTitle();
            }
            if (this.K0 && !w1()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = P0().m().getName();
            }
            historyMessage.isHostOnly = t0();
            historyMessage.isSquence = d1();
            historyMessage.threadType = P0().O().o1();
            historyMessage.isShareThread = this.K0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public c.a.r0.j2.h.e P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.J : (c.a.r0.j2.h.e) invokeV.objValue;
    }

    public final void P1(int i2) {
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048615, this, i2) == null) || i2 == 8) {
            return;
        }
        this.F0 = "";
        if (this.G0 != null) {
            if (i2 == 1 && (eVar = this.J) != null && eVar.f0()) {
                if (this.H0 != null) {
                    P0().F().remove(this.H0);
                }
            } else if (i2 == 1 && !this.o && !ListUtils.isEmpty(P0().F())) {
                P0().F().remove(this.G0);
                if (this.H0 != null) {
                    P0().F().remove(this.H0);
                }
                P0().F().add(0, this.G0);
            } else {
                P0().F().remove(this.G0);
                if (this.H0 != null) {
                    P0().F().remove(this.H0);
                }
            }
        }
        this.H0 = null;
    }

    public c.a.r0.j2.h.e Q0() {
        InterceptResult invokeV;
        p pVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null) {
                return eVar;
            }
            if (!l1() && (pVar = this.O0) != null) {
                this.J.D0(pVar);
            }
            return this.J;
        }
        return (c.a.r0.j2.h.e) invokeV.objValue;
    }

    public void Q1(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048617, this, eVar) == null) || eVar == null) {
            return;
        }
        String S1 = S1(eVar);
        for (int i2 = 0; i2 < eVar.F().size(); i2++) {
            PostData postData = eVar.F().get(i2);
            for (int i3 = 0; i3 < postData.M().size(); i3++) {
                postData.M().get(i3).B0(this.b0.getPageContext(), S1.equals(postData.M().get(i3).t().getUserId()));
            }
        }
        u T = eVar.T();
        if (T == null || ListUtils.isEmpty(T.f19694a)) {
            return;
        }
        for (PostData postData2 : T.f19694a) {
            for (int i4 = 0; i4 < postData2.M().size(); i4++) {
                postData2.M().get(i4).B0(this.b0.getPageContext(), S1.equals(postData2.M().get(i4).t().getUserId()));
            }
        }
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public void R1(c.a.r0.j2.h.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048619, this, eVar, i2) == null) || eVar == null) {
            return;
        }
        String S1 = S1(eVar);
        u T = eVar.T();
        if (T == null || ListUtils.isEmpty(T.f19694a)) {
            return;
        }
        List<PostData> list = T.f19694a;
        for (PostData postData : list.subList(i2, list.size())) {
            for (int i3 = 0; i3 < postData.M().size(); i3++) {
                postData.M().get(i3).B0(this.b0.getPageContext(), S1.equals(postData.M().get(i3).t().getUserId()));
            }
        }
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.y0 : (String) invokeV.objValue;
    }

    public String S1(c.a.r0.j2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, eVar)) == null) {
            String str = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.O() != null && eVar.O().J() != null) {
                str = eVar.O().J().getUserId();
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? this.N0 : (String) invokeV.objValue;
    }

    public final int T1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i2)) == null) {
            if (i2 != 1) {
                return i2 != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public void U(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, b1Var) == null) {
            if (b1Var == null) {
                U1(1);
                return;
            }
            if (this.w < b1Var.a()) {
                this.w = b1Var.a();
            }
            if (this.x > b1Var.a()) {
                this.x = b1Var.a();
            }
            this.y = b1Var.h();
        }
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.W0 : (String) invokeV.objValue;
    }

    public void U1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            this.v = i2;
            this.w = i2;
            this.x = i2;
        }
    }

    public final void V(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048627, this, eVar) == null) || eVar == null || eVar.z() == null || eVar.z().getAdvertAppInfo() == null || !eVar.z().I0() || eVar.z().getAdvertAppInfo().Z3 == 1001) {
            return;
        }
        this.O0 = eVar.z();
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) ? this.X0 : (String) invokeV.objValue;
    }

    public void V1() {
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048629, this) == null) || (eVar = this.J) == null || ListUtils.isEmpty(eVar.F())) {
            return;
        }
        if (this.H0 != null) {
            this.J.F().remove(this.H0);
            this.H0 = null;
        }
        if (this.G0 != null) {
            this.J.F().remove(this.G0);
            this.G0 = null;
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            this.O0 = null;
        }
    }

    public String W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public void W1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            bundle.putString("thread_id", this.f55294f);
            bundle.putString("post_id", this.f55296h);
            bundle.putString("forum_id", this.f55297i);
            bundle.putString("from_forum_id", this.f55298j);
            bundle.putInt("key_start_from", this.E0);
            bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.l);
            bundle.putBoolean("host_only", this.m);
            bundle.putBoolean("squence", this.o);
            bundle.putInt("sort_type", this.p);
            bundle.putString("st_type", this.mStType);
            bundle.putString("locate", this.Q);
            bundle.putInt("is_good", this.s);
            bundle.putInt("is_top", this.t);
            bundle.putLong("thread_time", this.u);
            bundle.putBoolean("from_mark", this.D);
            bundle.putBoolean("is_pb_key_need_post_id", this.F);
            bundle.putBoolean("is_sub_pb", this.A);
            bundle.putBoolean("is_ad", this.z);
            bundle.putBoolean("is_pv", this.H);
            bundle.putLong("msg_id", this.G);
            bundle.putString("extra_pb_cache_key", this.W);
            bundle.putInt("thread_type", this.L);
            bundle.putBoolean("is_from_thread_config", this.M);
            bundle.putBoolean("is_from_interview_live_config", this.N);
            bundle.putBoolean("is_from_my_god_config", this.O);
            bundle.putInt("extra_pb_is_attention_key", this.Y);
            bundle.putInt("extra_pb_funs_count_key", this.X);
            bundle.putBoolean("from_frs", this.B);
            bundle.putBoolean("from_maintab", this.C);
            bundle.putBoolean("from_smart_frs", this.s0);
            bundle.putBoolean("from_hottopic", this.P);
            bundle.putBoolean("key_is_share_thread", this.K0);
            bundle.putString("key_ori_ugc_nid", this.Q0);
            bundle.putString("key_ori_ugc_tid", this.R0);
            bundle.putInt("key_ori_ugc_type", this.S0);
            bundle.putString("key_ori_ugc_vid", this.T0);
            bundle.putString("key_rec_weight", this.U0);
            bundle.putString("key_rec_source", this.V0);
            bundle.putString("key_rec_ab_tag", this.W0);
            bundle.putString("key_rec_extra", this.X0);
            bundle.putBoolean("key_is_tieba_plus", this.e1);
            bundle.putString("key_tieba_plus_order_id", this.f1);
            bundle.putString("key_tieba_plus_token", this.g1);
            bundle.putString("key_tieba_extra_param", this.h1);
            bundle.putBoolean("key_tieba_plus_cant_delete", this.i1);
            bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.j1);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            this.k = null;
        }
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) ? this.U0 : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0335, code lost:
        if ((r11.x - 1) <= 0) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0293 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a7 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0366 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0382 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03ad A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x043b A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x044b A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x037e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean X1(int i2) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048635, this, i2)) == null) {
            this.K = i2;
            int i5 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            K1(i2);
            c.a.r0.j2.h.e f2 = k0.b().f();
            if (f2 != null && f2.O() != null) {
                f2.O().z3(0);
                this.o = k0.b().i();
                this.m = k0.b().a();
                this.r = k0.b().c();
                this.G0 = k0.b().g();
                this.H0 = k0.b().h();
                this.I0 = k0.b().d();
                this.L0 = k0.b().k();
                this.M0 = k0.b().j();
                boolean z2 = this.m;
                this.D0 = z2;
                if (z2 || this.D) {
                    this.Z = false;
                }
                c.a.e.e.m.e.a().post(new f(this, f2));
                return false;
            }
            if (i2 == 4 && !this.l0) {
                Y1(o0(), true, this.f55296h, 3);
            }
            if (i2 == 3 && !this.l0) {
                if (this.D) {
                    Y1(o0(), true, this.f55296h, 3);
                } else {
                    Y1(o0(), false, this.f55296h, 3);
                }
            }
            this.l0 = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i2);
            pbPageRequestMessage.setIsReqAd(this.O0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(c.a.q0.v.a.o);
            if (this.m || this.D) {
                this.Z = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f55294f != null && this.f55294f.length() != 0) {
                pbPageRequestMessage.set_kz(c.a.e.e.m.b.g(this.f55294f, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.f55293e);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                pbPageRequestMessage.setSchemeUrl(this.Y0);
                if (!this.o) {
                    pbPageRequestMessage.set_r(1);
                }
                pbPageRequestMessage.set_r(Integer.valueOf(this.p));
                if (this.m) {
                    pbPageRequestMessage.set_lz(1);
                }
                if (this.mStType != null) {
                    pbPageRequestMessage.set_st_type(this.mStType);
                }
                if (this.Q != null) {
                    pbPageRequestMessage.setLocate(this.Q);
                }
                if (this.H) {
                    pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.G));
                    pbPageRequestMessage.set_message_click("1");
                }
                if (this.Z) {
                    pbPageRequestMessage.set_banner(1);
                }
                if (this.T != null) {
                    pbPageRequestMessage.setOpType(this.T);
                    pbPageRequestMessage.setOpUrl(this.U);
                    pbPageRequestMessage.setOpStat(c.a.e.e.m.b.e(this.V, 0));
                    pbPageRequestMessage.setOpMessageID(this.G);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.L));
                ArrayList<PostData> F = this.J.F();
                switch (i2) {
                    case 1:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        if (!this.D) {
                            if (this.p == 1) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.x - 1));
                                break;
                            } else {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.w + 1));
                                z = this.w >= this.y;
                            }
                            if (!this.D || z || this.E) {
                                if (F != null && F.size() > 0) {
                                    size = F.size();
                                    i3 = 1;
                                    while (true) {
                                        i4 = size - i3;
                                        if (i4 >= 0) {
                                            PostData postData = F.get(i4);
                                            if (postData != null) {
                                                String E = postData.E();
                                                this.f55296h = E;
                                                if (StringUtils.isNull(E)) {
                                                }
                                            }
                                            i3++;
                                        }
                                    }
                                    if (this.p == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.w + 1));
                                    }
                                }
                                if (this.f55296h == null && this.f55296h.length() > 0) {
                                    pbPageRequestMessage.set_pid(c.a.e.e.m.b.g(this.f55296h, 0L));
                                    if (this.p == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.p == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            f2(pbPageRequestMessage);
                            break;
                        }
                        if (!this.D) {
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
                            if (this.p == 2) {
                            }
                        }
                        if (this.f55296h == null) {
                        }
                        if (this.p == 1) {
                        }
                        f2(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.f55296h = F.get(0).E();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.D) {
                            if (t1()) {
                                if (this.x - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.x - 1));
                                }
                            } else if (this.w < this.y) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.w + 1));
                            }
                        }
                        if (this.f55296h != null && this.f55296h.length() > 0) {
                            pbPageRequestMessage.set_pid(c.a.e.e.m.b.g(this.f55296h, 0L));
                            if (this.p == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        f2(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.D && !this.m) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!t1()) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                if (this.y > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.y));
                                }
                            }
                            if (this.D) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            j2(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!t1()) {
                        }
                        if (this.D) {
                        }
                        j2(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(c.a.e.e.m.b.g(this.f55296h, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        f2(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.v));
                        pbPageRequestMessage.set_banner(0);
                        f2(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.p == 1 && this.D0 && !this.m) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(c.a.e.e.m.b.g(this.f55296h, 0L));
                            if (this.p == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        pbPageRequestMessage.set_back(0);
                        if (this.m) {
                            pbPageRequestMessage.set_banner(0);
                        } else {
                            pbPageRequestMessage.set_banner(1);
                        }
                        f2(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.q0);
                        f2(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(c.a.e.e.m.b.g(this.F0, 0L));
                        if (this.p == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.D0 = this.m;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.D));
                pbPageRequestMessage.setCacheKey(o0());
                pbPageRequestMessage.setContext(this.R);
                pbPageRequestMessage.setObjParam1(String.valueOf(this.E0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.p0);
                pbPageRequestMessage.setFromSmartFrs(this.s0 ? 1 : 0);
                if (UtilHelper.isUgcThreadType(this.S0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.f55297i);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.l);
                if (this.E0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.E0 != 7 && this.E0 != 5 && !this.d1) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.Q0);
                    pbPageRequestMessage.setOriUgcTid(this.R0);
                    pbPageRequestMessage.setOriUgcType(this.S0);
                    pbPageRequestMessage.setOriUgcVid(this.T0);
                    if (!StringUtils.isNull(this.b1)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.b1));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            i5 = pbPageRequestMessage.getPn().intValue() == this.y ? -1 : f0();
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i5 = f0();
                            }
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i5);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.c1);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f55294f);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.Q0);
                pbPageRequestMessage.setOriUgcTid(this.R0);
                pbPageRequestMessage.setOriUgcType(this.S0);
                pbPageRequestMessage.setOriUgcVid(this.T0);
                if (!StringUtils.isNull(this.b1)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i5);
                pbPageRequestMessage.setImmersionVideoCommentSource(this.c1);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f55294f);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            if ((!this.m || x1(TbadkCoreApplication.getCurrentAccount())) && this.J.F() != null) {
                this.J.y().l(1);
                if (this.J.y().b() == 0) {
                    this.J.y().l(1);
                }
                this.F0 = str;
                X1(8);
            }
        }
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar != null) {
                return eVar.L();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public final void Y1(String str, boolean z, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048638, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i2)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setContext(this.R);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i2);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    public void Z(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048639, this, eVar) == null) || eVar == null) {
            return;
        }
        if (this.O || this.M || this.N) {
            eVar = n2(eVar);
        }
        Q1(eVar);
    }

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? this.K : invokeV.intValue;
    }

    public void Z1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048641, this, i2, i3) == null) {
            this.I0 = i2;
            this.J0 = i3;
        }
    }

    public c.a.r0.j2.h.e a0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, d2Var)) == null) {
            c.a.r0.j2.h.e eVar = new c.a.r0.j2.h.e();
            eVar.v0(3);
            if (d2Var == null) {
                return null;
            }
            eVar.H0(d2Var);
            if (d2Var.Y() != null) {
                eVar.w0(d2Var.Y());
                ForumData m = eVar.m();
                m.setId(d2Var.Y().getForumId());
                m.setName(d2Var.Y().getForumName());
                m.setUser_level(d2Var.Y().c());
                m.setImage_url(d2Var.Y().b());
                m.setPost_num(d2Var.Y().f14380h);
                m.setMember_num(d2Var.Y().f14381i);
            } else {
                ForumData m2 = eVar.m();
                m2.setId(String.valueOf(d2Var.T()));
                m2.setName(d2Var.Z());
            }
            PostData postData = new PostData();
            postData.k0(1);
            postData.y0(d2Var.P());
            postData.i0(d2Var.J());
            MetaData J = d2Var.J();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(J.getUserId(), J);
            postData.A0(hashMap);
            postData.v0(TbRichTextView.parser(this.R, d2Var.V(), f1(), false));
            eVar.x0(postData);
            eVar.F().add(postData);
            eVar.E0(new c.a.r0.j2.h.p(d2Var, null));
            eVar.m = true;
            eVar.A0(1);
            return eVar;
        }
        return (c.a.r0.j2.h.e) invokeL.objValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? t1() : invokeV.booleanValue;
    }

    public void a2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            this.n0 = str;
        }
    }

    public void b0(@NonNull d2 d2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048645, this, d2Var) == null) {
            d2Var.R2 = F();
            d2Var.S2 = B();
            d2Var.T2 = C();
            d2Var.U2 = C();
            d2Var.V2 = G();
            d2Var.C3(w());
        }
    }

    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.p : invokeV.intValue;
    }

    public void b2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i2) == null) {
            this.c1 = i2;
        }
    }

    public int c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            int i2 = this.E0;
            return (i2 == 7 || i2 == 5 || this.d1) ? 1 : 2;
        }
        return invokeV.intValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.p : invokeV.intValue;
    }

    public void c2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i2) == null) {
            this.a1 = i2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            return (eVar == null || eVar.m() == null || this.J.O() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.f55294f);
            if (!this.F) {
                sb.append(this.f55296h);
            }
            sb.append(this.m);
            sb.append(this.o);
            sb.append(this.p);
            sb.append(this.mStType);
            sb.append(this.s);
            sb.append(this.t);
            sb.append(this.u);
            sb.append(this.B);
            sb.append(this.C);
            sb.append(this.D);
            sb.append(this.z);
            sb.append(this.A);
            sb.append(this.H);
            sb.append(this.G);
            sb.append(this.I);
            sb.append(this.L);
            sb.append(this.M);
            sb.append(this.N);
            sb.append(this.O);
            sb.append(this.Q0);
            sb.append(this.R0);
            sb.append(this.T0);
            sb.append(this.S0);
            String str = this.W;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) ? t1() : invokeV.booleanValue;
    }

    public void d2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i2) == null) {
            this.s = i2;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048656, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.unique_id);
            SuggestEmotionModel suggestEmotionModel = this.B0;
            if (suggestEmotionModel != null) {
                suggestEmotionModel.cancelLoadData();
            }
            GetSugMatchWordsModel getSugMatchWordsModel = this.C0;
            if (getSugMatchWordsModel != null) {
                getSugMatchWordsModel.cancelLoadData();
            }
            c.a.r0.y2.l0.b.f().a("PB");
            G1();
        }
    }

    public AddExperiencedModel e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.A0 : (AddExperiencedModel) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) ? this.M0 : invokeV.intValue;
    }

    public void e2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i2) == null) {
            this.t = i2;
        }
    }

    public final int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            int i2 = 0;
            if (P0().F() == null) {
                return 0;
            }
            ArrayList<PostData> F = P0().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                PostData postData = F.get(size);
                if (!(postData instanceof p)) {
                    i2++;
                } else if (postData.getType() != AdvertAppInfo.s4) {
                    return i2;
                }
            }
            return F.size();
        }
        return invokeV.intValue;
    }

    public String f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.f55294f : (String) invokeV.objValue;
    }

    public final void f2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048662, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(q0()) || y.o().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(y.o().b().e(q0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(y.o().b().d(q0(), true));
    }

    public c.a.r0.j2.h.c g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.u0 : (c.a.r0.j2.h.c) invokeV.objValue;
    }

    public String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (!StringUtils.isNull(this.f55294f) && !"0".equals(this.f55294f)) {
                return this.f55294f;
            }
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public void g2(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, gVar) == null) {
            this.S = gVar;
        }
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.t0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.f55297i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.f55298j : (String) invokeV.objValue;
    }

    public MarkData h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null) {
                return null;
            }
            ArrayList<PostData> F = eVar.F();
            if (ListUtils.isEmpty(F)) {
                return null;
            }
            if (F.size() > 0 && i2 >= F.size()) {
                i2 = F.size() - 1;
            }
            return J0(F.get(i2));
        }
        return (MarkData) invokeI.objValue;
    }

    public PostData h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.G0 : (PostData) invokeV.objValue;
    }

    public void h2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048671, this, i2) == null) {
            this.E0 = i2;
        }
    }

    public Rect i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            Rect rect = this.L0;
            this.L0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public PostData i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.H0 : (PostData) invokeV.objValue;
    }

    public void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, str) == null) {
            this.N0 = str;
        }
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            this.E0 = bundle.getInt("key_start_from", 0);
            this.f55294f = bundle.getString("thread_id");
            this.f55296h = bundle.getString("post_id");
            this.f55297i = bundle.getString("forum_id");
            this.f55298j = bundle.getString("from_forum_id");
            bundle.getString("god_reply_id");
            this.l = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.m = bundle.getBoolean("host_only", false);
            this.o = bundle.getBoolean("squence", true);
            this.p = bundle.getInt("sort_type", 0);
            this.mStType = bundle.getString("st_type");
            this.Q = bundle.getString("locate");
            this.s = bundle.getInt("is_good", 0);
            this.t = bundle.getInt("is_top", 0);
            this.u = bundle.getLong("thread_time");
            this.D = bundle.getBoolean("from_mark", false);
            this.F = bundle.getBoolean("is_pb_key_need_post_id", false);
            this.z = bundle.getBoolean("is_ad", false);
            this.A = bundle.getBoolean("is_sub_pb", false);
            this.H = bundle.getBoolean("is_pv", false);
            this.G = bundle.getLong("msg_id", 0L);
            this.I = bundle.getString("from_forum_name");
            this.W = bundle.getString("extra_pb_cache_key");
            this.M = bundle.getBoolean("is_from_thread_config", false);
            this.N = bundle.getBoolean("is_from_interview_live_config", false);
            this.O = bundle.getBoolean("is_from_my_god_config", false);
            this.Y = bundle.getInt("extra_pb_is_attention_key", -1);
            this.X = bundle.getInt("extra_pb_funs_count_key", -1);
            this.B = bundle.getBoolean("from_frs", false);
            this.C = bundle.getBoolean("from_maintab", false);
            this.s0 = bundle.getBoolean("from_smart_frs", false);
            this.P = bundle.getBoolean("from_hottopic", false);
            this.K0 = bundle.getBoolean("key_is_share_thread", false);
            this.Q0 = bundle.getString("key_ori_ugc_nid");
            this.R0 = bundle.getString("key_ori_ugc_tid");
            this.S0 = bundle.getInt("key_ori_ugc_type", 0);
            this.Z0 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.T0 = bundle.getString("key_ori_ugc_vid");
            this.Z = bundle.getInt("request_code", -1) == 18003;
            this.U0 = bundle.getString("key_rec_weight");
            this.V0 = bundle.getString("key_rec_source");
            this.W0 = bundle.getString("key_rec_ab_tag");
            this.X0 = bundle.getString("key_rec_extra");
            this.e1 = bundle.getBoolean("key_is_tieba_plus");
            this.f1 = bundle.getString("key_tieba_plus_order_id");
            this.g1 = bundle.getString("key_tieba_plus_token");
            this.h1 = bundle.getString("key_tieba_extra_param");
            this.i1 = bundle.getBoolean("key_tieba_plus_cant_delete");
            this.j1 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
        }
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048676, this, intent) == null) || intent == null) {
            return;
        }
        this.f55294f = intent.getStringExtra("thread_id");
        this.f55295g = intent.getBooleanExtra("key_is_privacy", false);
        this.Q0 = intent.getStringExtra("key_ori_ugc_nid");
        this.R0 = intent.getStringExtra("key_ori_ugc_tid");
        this.S0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.T0 = intent.getStringExtra("key_ori_ugc_vid");
        this.Z0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.b1 = intent.getStringExtra("key_official_bar_message_id");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.Y0 = uri != null ? uri.toString() : null;
        this.d1 = false;
        if (c.a.q0.a.g.c(uri)) {
            this.d1 = true;
            c.a.q0.a.g.b().f(uri, this.k1);
        } else if (StringUtils.isNull(this.f55294f)) {
            this.d1 = true;
            this.v0.b(intent, this.k1);
            if (uri != null) {
                if (StringUtils.isNull(this.f55294f)) {
                    this.f55294f = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.Q0)) {
                    this.Q0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.R0)) {
                    this.R0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.S0 == 0) {
                    this.S0 = c.a.e.e.m.b.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.T0)) {
                    this.T0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (k.isEmpty(this.f55294f)) {
            this.f55294f = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.E0 = intExtra;
        if (intExtra == 0) {
            this.E0 = this.v0.f19887a;
        }
        this.f55296h = intent.getStringExtra("post_id");
        this.f55297i = intent.getStringExtra("forum_id");
        this.f55298j = intent.getStringExtra("from_forum_id");
        intent.getStringExtra("god_reply_id");
        this.l = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.m = intent.getBooleanExtra("host_only", false);
        this.o = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.p = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = c.a.q0.s.d0.b.j().k("key_pb_current_sort_type", 2);
        }
        this.p = intExtra2;
        this.f55296h = intExtra2 != 2 ? this.f55296h : "0";
        this.mStType = intent.getStringExtra("st_type");
        this.Q = intent.getStringExtra("locate");
        this.s = intent.getIntExtra("is_good", 0);
        this.t = intent.getIntExtra("is_top", 0);
        this.u = intent.getLongExtra("thread_time", 0L);
        this.D = intent.getBooleanExtra("from_mark", false);
        this.E = intent.getBooleanExtra("KEY_SHOULD_ADD_POST_ID", false);
        this.F = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.z = intent.getBooleanExtra("is_ad", false);
        this.A = intent.getBooleanExtra("is_sub_pb", false);
        this.H = intent.getBooleanExtra("is_pv", false);
        this.G = intent.getLongExtra("msg_id", 0L);
        this.I = intent.getStringExtra("from_forum_name");
        this.W = intent.getStringExtra("extra_pb_cache_key");
        this.T = intent.getStringExtra("op_type");
        this.U = intent.getStringExtra("op_url");
        this.V = intent.getStringExtra("op_stat");
        this.M = intent.getBooleanExtra("is_from_thread_config", false);
        this.N = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.O = intent.getBooleanExtra("is_from_my_god_config", false);
        this.Y = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.X = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.B = intent.getBooleanExtra("from_frs", false);
        this.C = intent.getBooleanExtra("from_maintab", false);
        this.s0 = intent.getBooleanExtra("from_smart_frs", false);
        this.P = intent.getBooleanExtra("from_hottopic", false);
        this.y0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.K0 = intent.getBooleanExtra("key_is_share_thread", false);
        this.k = intent.getStringExtra("high_light_post_id");
        this.P0 = intent.getBooleanExtra("key_need_preload", false);
        this.Z = intent.getIntExtra("request_code", -1) == 18003;
        this.U0 = intent.getStringExtra("key_rec_weight");
        this.V0 = intent.getStringExtra("key_rec_source");
        this.W0 = intent.getStringExtra("key_rec_ab_tag");
        this.X0 = intent.getStringExtra("key_rec_extra");
        this.e1 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.f1 = intent.getStringExtra("key_tieba_plus_order_id");
        this.g1 = intent.getStringExtra("key_tieba_plus_token");
        this.h1 = intent.getStringExtra("key_tieba_extra_param");
        this.i1 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.j1 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.f55295g : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.K0 : invokeV.booleanValue;
    }

    public BaijiahaoData j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null || eVar.O() == null) {
                return null;
            }
            return this.J.O().L();
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null || eVar.O() == null) {
                return null;
            }
            return this.J.O().M2;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    public final void j2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048681, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(q0()) || y.o().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(y.o().b().d(q0(), true) + 1);
        pbPageRequestMessage.setLoadCount(y.o().b().e(q0(), true));
    }

    public p k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.O0 : (p) invokeV.objValue;
    }

    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.f55296h : (String) invokeV.objValue;
    }

    public void k2(int i2) {
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048684, this, i2) == null) || (eVar = this.J) == null) {
            return;
        }
        eVar.G0(i2);
    }

    public CheckRealNameModel l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.z0 : (CheckRealNameModel) invokeV.objValue;
    }

    public final boolean l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? (this.J.z() == null || this.J.z().getAdvertAppInfo() == null || this.J.z().getAdvertAppInfo().Z3 == 1001) ? false : true : invokeV.booleanValue;
    }

    public void l2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            this.f55293e = i2;
        }
    }

    public c.a.r0.j2.k.e.p m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.w0 : (c.a.r0.j2.k.e.p) invokeV.objValue;
    }

    public void m1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048689, this) == null) {
            c.a.r0.j2.k.e.j.b().d(o0(), this.D);
        }
    }

    public boolean m2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048690, this, i2)) == null) {
            this.v = i2;
            if (i2 > this.J.y().h()) {
                this.v = this.J.y().h();
            }
            if (this.v < 1) {
                this.v = 1;
            }
            if (this.f55294f == null) {
                return false;
            }
            return X1(5);
        }
        return invokeI.booleanValue;
    }

    public MarkData n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f55294f);
            markData.setPostId(this.J.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.m);
            markData.setSequence(Boolean.valueOf(t1()));
            markData.setId(this.f55294f);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.j1 : invokeV.booleanValue;
    }

    public c.a.r0.j2.h.e n2(c.a.r0.j2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            d2 O = eVar.O();
            O.W3(this.s);
            O.X3(this.t);
            long j2 = this.u;
            if (j2 > 0) {
                O.b4(j2);
            }
            b0(O);
            return eVar;
        }
        return (c.a.r0.j2.h.e) invokeL.objValue;
    }

    public final String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            String str = this.f55294f;
            String M0 = (str == null || str.equals("0")) ? M0() : this.f55294f;
            if (this.m) {
                M0 = M0 + DB_KEY_HOST;
            }
            int i2 = this.p;
            if (i2 == 1) {
                M0 = M0 + DB_KEY_REVER;
            } else if (i2 == 2) {
                M0 = M0 + DB_KEY_HOT;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return M0 + TbadkCoreApplication.getCurrentAccount();
            }
            return M0;
        }
        return (String) invokeV.objValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.r0 : invokeV.booleanValue;
    }

    public void o2(boolean z) {
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048696, this, z) == null) || (eVar = this.J) == null) {
            return;
        }
        eVar.z0(z);
    }

    public String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) ? this.n0 : (String) invokeV.objValue;
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.s0 : invokeV.booleanValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            if (t1() && this.J.y().b() == 0) {
                z1(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public boolean q2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048702, this, str)) == null) {
            this.m = !this.m;
            this.f55296h = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (X1(6)) {
                return true;
            }
            this.m = !this.m;
            return false;
        }
        return invokeL.booleanValue;
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public boolean r2(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048705, this, z, str)) == null) {
            if (this.m == z) {
                return false;
            }
            this.m = z;
            this.f55296h = str;
            if (this.p == 2) {
                this.f55296h = "";
            }
            if (z) {
                TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
            }
            if (X1(6)) {
                return true;
            }
            this.m = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public MetaData s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            c.a.r0.j2.h.e eVar = this.J;
            if (eVar == null || eVar.O() == null || this.J.O().J() == null) {
                return null;
            }
            return this.J.O().J();
        }
        return (MetaData) invokeV.objValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.P0 && c.a.r0.w0.l.b() != null && c.a.r0.w0.l.b().equals(this.f55294f) && c.a.r0.w0.l.a() != null : invokeV.booleanValue;
    }

    public boolean s2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048708, this, i2)) == null) {
            if (i2 == this.p) {
                return false;
            }
            if (i2 != 1) {
                c.a.q0.s.d0.b.j().v("key_pb_current_sort_type", i2);
            }
            boolean z = this.o;
            this.n = z;
            this.q = this.p;
            this.p = i2;
            this.o = !z;
            if (i2 == 2 && this.D) {
                this.f55296h = "0";
            }
            if (this.isLoading || !LoadData()) {
                this.o = !this.o;
                this.p = this.q;
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public final boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            int i2 = this.p;
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public final void t2(@NonNull c.a.r0.j2.h.e eVar) {
        c.a.r0.j2.h.e eVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048711, this, eVar) == null) || (eVar2 = this.J) == null) {
            return;
        }
        eVar2.e().clear();
        this.J.e().addAll(eVar.e());
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) ? this.a1 : invokeV.intValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? P0() != null && P0().q0() : invokeV.booleanValue;
    }

    public void u2(UserPendantData userPendantData) {
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048714, this, userPendantData) == null) || userPendantData == null || (eVar = this.J) == null || eVar.F() == null || this.J.F().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.J.F().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.J.F().get(i2) != null && this.J.F().get(i2).t() != null && currentAccount.equals(this.J.F().get(i2).t().getUserId()) && this.J.F().get(i2).t().getPendantData() != null) {
                this.J.F().get(i2).t().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.J.F().get(i2).t().getPendantData().setPropsId(userPendantData.getPropsId());
            }
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            int i2 = this.E0;
            return i2 == 13 || i2 == 12 || i2 == 7 || i2 == 23 || i2 == 24;
        }
        return invokeV.booleanValue;
    }

    public void v2(c.a.r0.j2.h.e eVar, ArrayList<PostData> arrayList) {
        String G0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048717, this, eVar, arrayList) == null) || arrayList == null || eVar.F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(eVar.F(), 0);
        if (postData != null && (G0 = G0(arrayList)) != null && G0.equals(postData.E())) {
            eVar.F().remove(postData);
        }
        this.J.Z = arrayList.size();
        arrayList.addAll(eVar.F());
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? O0() == 3 || P0() == null || P0().O() == null || !P0().O().l2() : invokeV.booleanValue;
    }

    public void w2(c.a.r0.j2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048720, this, eVar) == null) || eVar == null) {
            return;
        }
        eVar.K0(this.J.X());
        c.a.r0.j2.h.e eVar2 = this.J;
        if (!eVar2.X && eVar.X && eVar2.i() != null) {
            eVar.y0(this.J.i());
        }
        this.J = eVar;
        U1(eVar.y().a());
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) ? "hot_topic".equals(this.mStType) : invokeV.booleanValue;
    }

    public boolean x1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048722, this, str)) == null) {
            if (P0() != null && P0().O() != null && P0().O().J() != null && !StringUtils.isNull(str)) {
                String userId = P0().O().J().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public void y1(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048725, this, forumData, cVar) == null) {
            str = "";
            if (forumData != null) {
                String id = !TextUtils.isEmpty(forumData.getId()) ? forumData.getId() : "";
                str2 = TextUtils.isEmpty(forumData.getName()) ? "" : forumData.getName();
                str = id;
            } else {
                str2 = "";
            }
            this.B0.z(str, str2, cVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.f55294f : (String) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean z1(boolean z) {
        InterceptResult invokeZ;
        c.a.r0.j2.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048728, this, z)) == null) {
            if (this.f55294f == null || (eVar = this.J) == null) {
                return false;
            }
            if (z || eVar.y().b() != 0) {
                return X1(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }
}
