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
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.s0.a.g;
import c.a.s0.s.q.b1;
import c.a.s0.s.q.e2;
import c.a.t0.j3.y;
import c.a.t0.s2.r.r;
import c.a.t0.s2.r.w;
import c.a.t0.s2.u.f.c0;
import c.a.t0.s2.u.f.d0;
import c.a.t0.s2.u.f.j;
import c.a.t0.s2.u.f.l0;
import c.a.t0.w3.j0.p;
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
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PbCommentFloatActivityConfig;
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
/* loaded from: classes12.dex */
public class PbModel extends DataModel {
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
    public static int UPGRADE_TO_PHOTO_LIVE;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public String A0;
    public boolean B;
    public final CheckRealNameModel B0;
    public boolean C;
    public final AddExperiencedModel C0;
    public boolean D;
    public SuggestEmotionModel D0;
    public boolean E;
    public GetSugMatchWordsModel E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public int G0;
    public long H;
    public String H0;
    public boolean I;
    public PostData I0;
    public String J;
    public PostData J0;
    public c.a.t0.s2.r.f K;
    public int K0;
    public int L;
    public int L0;
    public int M;
    public boolean M0;
    public boolean N;
    public Rect N0;
    public boolean O;
    public int O0;
    public boolean P;
    public String P0;
    public boolean Q;
    public p Q0;
    public String R;
    public boolean R0;
    public Context S;
    public String S0;
    public g T;
    public String T0;
    public String U;
    public int U0;
    public String V;
    public String V0;
    public String W;
    public String W0;
    public String X;
    public String X0;
    public int Y;
    public String Y0;
    public int Z;
    public String Z0;
    public boolean a0;
    public String a1;
    public c.a.t0.w3.l0.b b0;
    public boolean b1;
    public BaseFragmentActivity c0;
    public int c1;
    public boolean d0;
    public String d1;

    /* renamed from: e  reason: collision with root package name */
    public int f46594e;
    public boolean e0;
    public int e1;

    /* renamed from: f  reason: collision with root package name */
    public String f46595f;
    public long f0;
    public boolean f1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f46596g;
    public boolean g0;
    public boolean g1;

    /* renamed from: h  reason: collision with root package name */
    public String f46597h;
    public boolean h0;
    public String h1;

    /* renamed from: i  reason: collision with root package name */
    public String f46598i;
    public String i0;
    public String i1;
    public boolean isLoading;

    /* renamed from: j  reason: collision with root package name */
    public String f46599j;
    public String j1;
    public String k;
    public String k0;
    public boolean k1;
    public String l;
    public boolean l1;
    public boolean m;
    public boolean m1;
    public String mStType;
    public String mTopicId;
    public String mTopicSubjectName;
    public boolean n;
    public boolean n1;
    public boolean o;
    public boolean o1;
    public boolean p;
    public g.b p1;
    public int q;
    public long q0;
    public CustomMessageListener q1;
    public int r;
    public boolean r0;
    public c.a.d.c.g.a r1;
    public boolean s;
    public int s0;
    public CustomMessageListener s1;
    public int t;
    public boolean t0;
    public CustomMessageListener t1;
    public int u;
    public boolean u0;
    public PraiseData u1;
    public long v;
    public int v0;
    public int w;
    public c.a.t0.s2.r.d w0;
    public int x;
    public final c0 x0;
    public int y;
    public final c.a.t0.s2.u.f.p y0;
    public int z;
    public final d0 z0;

    /* loaded from: classes12.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

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
            this.a = pbModel;
        }

        @Override // c.a.s0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(c.a.s0.a.g.u) instanceof String) {
                this.a.f46595f = (String) hashMap.get(c.a.s0.a.g.u);
            }
            if (hashMap.get(c.a.s0.a.g.v) instanceof String) {
                this.a.S0 = (String) hashMap.get(c.a.s0.a.g.v);
            }
            if (hashMap.get(c.a.s0.a.g.w) instanceof String) {
                this.a.T0 = (String) hashMap.get(c.a.s0.a.g.w);
            }
            if (hashMap.get(c.a.s0.a.g.x) instanceof String) {
                this.a.U0 = c.a.d.f.m.b.e((String) hashMap.get(c.a.s0.a.g.x), 0);
            }
            if (hashMap.get(c.a.s0.a.g.y) instanceof String) {
                this.a.V0 = (String) hashMap.get(c.a.s0.a.g.y);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

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
            this.a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.a.R0() == null || this.a.R0().l() == null || this.a.R0().l().getSignData() == null || !signData.forumId.equals(this.a.R0().m())) {
                return;
            }
            this.a.R0().l().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes12.dex */
    public class c extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

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
            this.a = pbModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && l.z()) {
                        this.a.c0.showToast(responsedMessage.getErrorString());
                    }
                    if (z2) {
                        this.a.U1((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.a.T1((pbPageHttpResponseMessage) responsedMessage);
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
                        c.a.s0.s.b0.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (this.a.d0 && this.a.e0) {
                        return;
                    }
                    if (!this.a.d0) {
                        this.a.d0 = true;
                    } else {
                        this.a.e0 = true;
                    }
                    if (this.a.T != null) {
                        this.a.T.a(this.a.T0(), z, responsedMessage, this.a.g0, System.currentTimeMillis() - this.a.f0);
                    }
                }
            }
        }
    }

    /* loaded from: classes12.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

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
            this.a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                c.a.t0.s2.r.f fVar = this.a.K;
                if (fVar == null || fVar.h() == null || this.a.K.h().getForumId() == null || !this.a.K.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.a.K.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

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
            this.a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                c.a.t0.s2.r.f fVar = this.a.K;
                if (fVar == null || fVar.h() == null || this.a.K.h().getForumId() == null || !this.a.K.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.a.K.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes12.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c.a.t0.s2.r.f f46600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbModel f46601f;

        public f(PbModel pbModel, c.a.t0.s2.r.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46601f = pbModel;
            this.f46600e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f46601f.W1(this.f46600e, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.f46601f.isLoading = false;
            }
        }
    }

    /* loaded from: classes12.dex */
    public interface g {
        void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j2);

        void b(c.a.t0.s2.r.f fVar);

        void c(boolean z, int i2, int i3, int i4, c.a.t0.s2.r.f fVar, String str, int i5);
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
        int a2 = c.a.s0.u.d.a() / 30;
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
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f46594e = 4;
        this.mStType = null;
        this.f46595f = null;
        this.f46596g = false;
        this.f46597h = null;
        this.f46598i = null;
        this.k = null;
        this.l = "";
        this.m = false;
        this.n = false;
        this.o = true;
        this.p = true;
        this.q = 0;
        this.r = 0;
        this.s = false;
        this.t = 0;
        this.u = 0;
        this.v = 0L;
        this.w = 1;
        this.x = 1;
        this.y = 1;
        this.z = 1;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = false;
        this.G = false;
        this.H = 0L;
        this.I = false;
        this.J = null;
        this.K = null;
        this.isLoading = false;
        this.mTopicId = "";
        this.mTopicSubjectName = "";
        this.N = false;
        this.O = false;
        this.P = false;
        this.Q = false;
        this.R = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = null;
        this.X = null;
        this.Y = -1;
        this.Z = -1;
        this.b0 = null;
        this.d0 = false;
        this.e0 = false;
        this.i0 = null;
        this.k0 = null;
        this.q0 = 0L;
        this.r0 = false;
        this.s0 = -1;
        this.u0 = false;
        this.F0 = false;
        this.G0 = 0;
        this.O0 = 0;
        this.R0 = false;
        this.c1 = 3;
        this.e1 = 0;
        this.n1 = false;
        this.o1 = false;
        this.q1 = new b(this, 2001222);
        this.r1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.s1 = new d(this, 2001336);
        this.t1 = new e(this, 2001335);
        this.u1 = null;
        registerListener(this.r1);
        registerListener(this.q1);
        registerListener(this.t1);
        registerListener(this.s1);
        c.a.t0.s2.r.f fVar = new c.a.t0.s2.r.f();
        this.K = fVar;
        fVar.y0(0);
        this.S = baseFragmentActivity.getPageContext().getPageActivity();
        this.c0 = baseFragmentActivity;
        this.x0 = new c0();
        this.y0 = new c.a.t0.s2.u.f.p(this, this.c0);
        this.z0 = new d0(this, this.c0);
        this.B0 = new CheckRealNameModel(this.c0.getPageContext());
        this.D0 = new SuggestEmotionModel();
        this.C0 = new AddExperiencedModel(this.c0.getPageContext());
        this.p1 = new a(this);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.j1 : (String) invokeV.objValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? R0() != null && R0().s0() : invokeV.booleanValue;
    }

    public boolean A2(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048579, this, z, str)) == null) {
            if (this.n == z) {
                return false;
            }
            this.n = z;
            this.f46597h = str;
            if (this.q == 2) {
                this.f46597h = "";
            }
            if (z) {
                TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
            }
            if (f2(6)) {
                return true;
            }
            this.n = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h1 : (String) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            int i2 = this.G0;
            return i2 == 13 || i2 == 12 || i2 == 7 || i2 == 23 || i2 == 24;
        }
        return invokeV.booleanValue;
    }

    public boolean B2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == this.q) {
                return false;
            }
            if (i2 != 1) {
                c.a.s0.s.h0.b.k().w("key_pb_current_sort_type", i2);
            }
            boolean z = this.p;
            this.o = z;
            this.r = this.q;
            this.q = i2;
            this.p = !z;
            if (i2 == 2 && this.E) {
                this.f46597h = "0";
            }
            if (this.isLoading || !loadData()) {
                this.p = !this.p;
                this.q = this.r;
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i1 : (String) invokeV.objValue;
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.t : invokeV.intValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? Q0() == 3 || R0() == null || R0().O() == null || !R0().O().o2() : invokeV.booleanValue;
    }

    public final void C2(@NonNull c.a.t0.s2.r.f fVar) {
        c.a.t0.s2.r.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, fVar) == null) || (fVar2 = this.K) == null) {
            return;
        }
        fVar2.e().clear();
        this.K.e().addAll(fVar.e());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null || fVar.O() == null || this.K.l() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.K.O().o2()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.K.l().getId());
                writeData.setForumName(this.K.l().getName());
            }
            writeData.setFromForumId(this.f46599j);
            writeData.sourceFrom = String.valueOf(this.G0);
            writeData.setThreadId(this.f46595f);
            writeData.setIsAd(this.A);
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null) {
                return false;
            }
            return fVar.r();
        }
        return invokeV.booleanValue;
    }

    public boolean D1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, str)) == null) {
            if (R0() != null && R0().O() != null && R0().O().J() != null && !StringUtils.isNull(str)) {
                String userId = R0().O().J().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void D2(UserPendantData userPendantData) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, userPendantData) == null) || userPendantData == null || (fVar = this.K) == null || fVar.F() == null || this.K.F().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.K.F().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.K.F().get(i2) != null && this.K.F().get(i2).t() != null && currentAccount.equals(this.K.F().get(i2).t().getUserId()) && this.K.F().get(i2).t().getPendantData() != null) {
                this.K.F().get(i2).t().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.K.F().get(i2).t().getPendantData().setPropsId(userPendantData.getPropsId());
            }
        }
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.s : invokeV.booleanValue;
    }

    public void E1(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048593, this, forumData, cVar) == null) {
            str = "";
            if (forumData != null) {
                String id = !TextUtils.isEmpty(forumData.getId()) ? forumData.getId() : "";
                str2 = TextUtils.isEmpty(forumData.getName()) ? "" : forumData.getName();
                str = id;
            } else {
                str2 = "";
            }
            this.D0.z(str, str2, cVar);
        }
    }

    public void E2(c.a.t0.s2.r.f fVar, ArrayList<PostData> arrayList) {
        String I0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048594, this, fVar, arrayList) == null) || arrayList == null || fVar.F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(fVar.F(), 0);
        if (postData != null && (I0 = I0(arrayList)) != null && I0.equals(postData.G())) {
            fVar.F().remove(postData);
        }
        this.K.Z = arrayList.size();
        arrayList.addAll(fVar.F());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.g1 : invokeV.booleanValue;
    }

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public boolean F1(boolean z) {
        InterceptResult invokeZ;
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048597, this, z)) == null) {
            if (this.f46595f == null || (fVar = this.K) == null) {
                return false;
            }
            if (z || fVar.y().b() != 0) {
                return f2(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void F2(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, fVar) == null) || fVar == null) {
            return;
        }
        fVar.N0(this.K.X());
        c.a.t0.s2.r.f fVar2 = this.K;
        if (!fVar2.X && fVar.X && fVar2.i() != null) {
            fVar.B0(this.K.i());
        }
        this.K = fVar;
        c2(fVar.y().a());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.k1 : invokeV.booleanValue;
    }

    public int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.u : invokeV.intValue;
    }

    public void G1(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f46595f = fVar.Q();
        if (fVar.O() != null && fVar.O().L() != null) {
            BaijiahaoData L = fVar.O().L();
            this.S0 = L.oriUgcNid;
            this.T0 = L.oriUgcTid;
            this.U0 = L.oriUgcType;
            this.V0 = L.oriUgcVid;
        } else {
            this.S0 = null;
            this.T0 = null;
            this.U0 = 0;
            this.V0 = null;
        }
        this.f46597h = null;
        this.n = false;
        this.p = true;
        loadData();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? L1() : invokeV.booleanValue;
    }

    public boolean H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null) {
                return false;
            }
            return fVar.q0();
        }
        return invokeV.booleanValue;
    }

    public void H1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048604, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f46595f = str;
        this.f46597h = null;
        this.n = false;
        this.p = true;
        loadData();
    }

    public final String I0(ArrayList<PostData> arrayList) {
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

    public boolean I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.f46595f == null || this.f46597h == null) {
                return false;
            }
            cancelMessage();
            if (this.E) {
                return f2(4);
            }
            return f2(6);
        }
        return invokeV.booleanValue;
    }

    public int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.L0 : invokeV.intValue;
    }

    public boolean J1(boolean z) {
        InterceptResult invokeZ;
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048608, this, z)) == null) {
            if (this.f46595f == null || (fVar = this.K) == null || ((!z && fVar.y().c() == 0) || this.K.F() == null || this.K.F().size() < 1)) {
                return false;
            }
            return f2(2);
        }
        return invokeZ.booleanValue;
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.K0 : invokeV.intValue;
    }

    public void K1(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.E0 == null) {
            this.E0 = new GetSugMatchWordsModel(this.c0.getPageContext());
        }
        this.E0.y(bVar);
    }

    public MarkData L0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f46595f);
            markData.setPostId(postData.G());
            markData.setTime(date.getTime());
            markData.setHostMode(this.n);
            markData.setSequence(Boolean.valueOf(z1()));
            markData.setId(this.f46595f);
            markData.setFloor(postData.A());
            markData.setForumId(this.f46598i);
            boolean z = true;
            if (postData instanceof c.a.t0.s2.r.c) {
                markData.setApp(true);
            } else if (postData instanceof p) {
                p pVar = (p) postData;
                markData.setApp((pVar.getAdvertAppInfo() == null || !pVar.getAdvertAppInfo().V4()) ? false : false);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            String str = this.f46597h;
            if (str != null && !str.equals("0") && this.f46597h.length() != 0) {
                return I1();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null || !fVar.r()) {
                return null;
            }
            return this.K.u();
        }
        return (String) invokeV.objValue;
    }

    public final void M1() {
        c.a.t0.w3.l0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (bVar = this.b0) == null) {
            return;
        }
        bVar.a();
        this.b0 = null;
    }

    public d0 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.z0 : (d0) invokeV.objValue;
    }

    public void N1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048616, this) == null) || !"personalize_page".equals(this.mStType) || this.K == null || this.q0 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        TiebaStatic.log(new StatisticItem("c10754").param("fid", this.K.m()).param("tid", this.f46595f).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.q0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
        this.q0 = 0L;
    }

    public final String O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            String str = "";
            if (this.S0 != null) {
                str = "" + this.S0;
            }
            if (this.T0 != null) {
                str = str + this.T0;
            }
            String str2 = str + this.U0;
            if (this.V0 != null) {
                return str2 + this.V0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void O1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048618, this) == null) && "personalize_page".equals(this.mStType)) {
            this.q0 = System.currentTimeMillis() / 1000;
        }
    }

    public b1 P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null) {
                return null;
            }
            return fVar.y();
        }
        return (b1) invokeV.objValue;
    }

    public boolean P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? !TextUtils.isEmpty(this.l) : invokeV.booleanValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.G0 : invokeV.intValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) ? !TextUtils.isEmpty(this.k) : invokeV.booleanValue;
    }

    public c.a.t0.s2.r.f R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.K : (c.a.t0.s2.r.f) invokeV.objValue;
    }

    public void R1(c.a.t0.s2.r.f fVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048624, this, fVar, i2, str) == null) {
            this.h0 = true;
            if (fVar == null || fVar.f22407h != null) {
                return;
            }
            F2(fVar);
            a0(fVar);
            if (fVar.O() != null) {
                fVar.O().D3(0);
            }
            g gVar = this.T;
            if (gVar == null || fVar == null) {
                return;
            }
            gVar.c(true, 0, i2, 0, fVar, str, 0);
        }
    }

    public c.a.t0.s2.r.f S0() {
        InterceptResult invokeV;
        p pVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null) {
                return fVar;
            }
            if (!p1() && (pVar = this.Q0) != null) {
                this.K.G0(pVar);
            }
            return this.K;
        }
        return (c.a.t0.s2.r.f) invokeV.objValue;
    }

    public void S1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048626, this, i2) == null) {
            X1(i2);
            ArrayList<PostData> F = this.K.F();
            boolean z = false;
            this.g0 = false;
            if (i2 != 1) {
                if (i2 == 2) {
                    while (F.size() + 30 > c.a.s0.u.d.a()) {
                        F.remove(F.size() - 1);
                        z = true;
                    }
                    if (z) {
                        this.K.y().l(1);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z2 = false;
            while (F.size() + 30 > c.a.s0.u.d.a()) {
                F.remove(0);
                z2 = true;
            }
            if (z2) {
                this.K.y().m(1);
                g gVar = this.T;
                if (gVar != null) {
                    gVar.b(this.K);
                }
            }
            this.f0 = System.currentTimeMillis();
            this.g0 = true;
        }
    }

    public int T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public void T1(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048628, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.w0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            V1(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void U(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048629, this, b1Var) == null) {
            if (b1Var == null) {
                c2(1);
                return;
            }
            if (this.x < b1Var.a()) {
                this.x = b1Var.a();
            }
            if (this.y > b1Var.a()) {
                this.y = b1Var.a();
            }
            this.z = b1Var.h();
        }
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.A0 : (String) invokeV.objValue;
    }

    public void U1(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.w0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            V1(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public final void V(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048632, this, fVar) == null) || fVar == null || fVar.z() == null || fVar.z().getAdvertAppInfo() == null || !fVar.z().N0() || fVar.z().getAdvertAppInfo().h4 == 1001) {
            return;
        }
        this.Q0 = fVar.z();
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.P0 : (String) invokeV.objValue;
    }

    public void V1(c.a.t0.s2.r.f fVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j2, long j3) {
        c.a.t0.s2.r.f fVar2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048634, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3)}) == null) {
            if (z) {
                i5 = i3;
                fVar2 = null;
            } else {
                fVar2 = fVar;
                i5 = i3;
            }
            this.v0 = i5;
            this.isLoading = false;
            if (fVar2 != null) {
                a0(fVar2);
            }
            V(fVar2);
            p pVar = this.Q0;
            if (pVar != null && pVar.N0()) {
                TiebaStatic.log(c.a.t0.v3.a.h("a005", "common_fill", true, 1));
            }
            W1(fVar2, i2, z, i3, str, z2, i4, j2, j3, false);
        }
    }

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048635, this) == null) {
            this.Q0 = null;
        }
    }

    public String W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.Y0 : (String) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void W1(c.a.t0.s2.r.f fVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j2, long j3, boolean z3) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048637, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j2), Long.valueOf(j3), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.t0 = z3;
            c.a.t0.w3.l0.b bVar = this.b0;
            if (bVar != null && !z3) {
                bVar.b(z2, z4, i3, str, i4, j2, j3);
                this.b0 = null;
            }
            c.a.t0.s2.r.f fVar2 = this.K;
            if (fVar2 != null) {
                fVar2.a0 = z3;
                fVar2.b0 = i2;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(r0()) && y.q().b() != null) {
                y.q().b().g(r0(), b2(b1()), true);
            }
            if (fVar != null && (this.w != 1 || i2 != 5 || fVar.F() == null || fVar.F().size() >= 1)) {
                this.o = this.p;
                if (i2 != 8) {
                    this.r = this.q;
                    this.q = fVar.f22406g;
                }
                List<PbSortType> list = fVar.f22405f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.c0.getResources().getString(c.a.t0.s2.l.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    fVar.f22405f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.c0.getResources().getString(c.a.t0.s2.l.view_reverse);
                    builder2.sort_type = 1;
                    fVar.f22405f.add(builder2.build(false));
                    int i7 = this.r;
                    this.q = i7;
                    fVar.f22406g = i7;
                }
                this.I = false;
                if (fVar.y() != null && (this.q != 2 || i2 != 8)) {
                    U(fVar.y());
                }
                int i8 = this.z;
                if (i8 < 1) {
                    i8 = 1;
                }
                this.z = i8;
                ArrayList<PostData> F = this.K.F();
                switch (i2) {
                    case 1:
                        this.K.F0(fVar.y(), 1);
                        E2(fVar, F);
                        C2(fVar);
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
                        C2(fVar);
                        this.K.F0(fVar.y(), 2);
                        break;
                    case 3:
                        if (this.q == 1 && fVar.y() != null) {
                            fVar.y().k(fVar.y().h());
                        }
                        F2(fVar);
                        i5 = 0;
                        break;
                    case 4:
                        F2(fVar);
                        i5 = 0;
                        break;
                    case 5:
                        F2(fVar);
                        i5 = 0;
                        break;
                    case 6:
                        F2(fVar);
                        i5 = 0;
                        break;
                    case 7:
                        F2(fVar);
                        i5 = 0;
                        break;
                    case 8:
                        if (fVar == null || ListUtils.isEmpty(fVar.F()) || this.K == null || (this.n && !a2(fVar).equals(fVar.F().get(0).t().getUserId()))) {
                            i6 = 0;
                        } else {
                            if (this.K.y().b() == 0) {
                                this.K.y().l(1);
                            }
                            d2();
                            this.I0 = fVar.F().get(0);
                            if (!z1() && !this.K.g0()) {
                                if (this.K0 - this.L0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.J0 = postData3;
                                    postData3.F = false;
                                    postData3.x0(53);
                                    this.K.F().add(0, this.J0);
                                }
                                this.K.F().add(0, this.I0);
                                i6 = 0;
                            } else {
                                if (this.K.F().size() - this.K0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.J0 = postData4;
                                    postData4.F = true;
                                    postData4.x0(53);
                                    this.K.F().add(this.J0);
                                }
                                this.K.F().add(this.I0);
                                i6 = this.K.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(c.a.s0.s.h0.b.k().m("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.I0.V = this.K.J();
                                c.a.s0.s.h0.b.k().x("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        C2(fVar);
                        i5 = i6;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
                c.a.t0.s2.r.f fVar3 = this.K;
                if (fVar3 != null && fVar3.O() != null) {
                    PraiseData M0 = this.K.O().M0();
                    if (this.u1 != null && !M0.isPriaseDataValid()) {
                        this.K.O().q4(this.u1);
                    } else {
                        PraiseData M02 = this.K.O().M0();
                        this.u1 = M02;
                        M02.setPostId(this.K.O().X());
                    }
                    if (fVar.y() != null && fVar.y().a() == 1 && fVar.O() != null && fVar.O().q() != null && fVar.O().q().size() > 0) {
                        this.K.O().u3(fVar.O().q());
                    }
                    this.K.O().r4(fVar.O().V0());
                    this.K.O().z3(fVar.O().F());
                    this.K.O().D3(fVar.O().O());
                    if (this.M == 33) {
                        this.K.O().J().setHadConcerned(fVar.O().J().hadConcerned());
                    }
                    if (fVar != null && fVar.O() != null) {
                        this.K.O().R4(fVar.O().o0());
                    }
                }
                c.a.t0.s2.r.f fVar4 = this.K;
                if (fVar4 != null && fVar4.U() != null && fVar.U() != null) {
                    this.K.U().setBimg_end_time(fVar.U().getBimg_end_time());
                    this.K.U().setBimg_url(fVar.U().getBimg_url());
                }
                if (fVar.y() != null && fVar.y().a() == 1 && fVar.W() != null) {
                    this.K.M0(fVar.W());
                }
                if (this.t0) {
                    if (this.K.O() != null && this.K.O().J() != null && this.K.F() != null && ListUtils.getItem(this.K.F(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.K.F(), 0);
                        MetaData J = this.K.O().J();
                        if (postData5.t() != null && postData5.t().getGodUserData() != null) {
                            int i9 = this.Y;
                            if (i9 != -1) {
                                J.setFansNum(i9);
                                postData5.t().setFansNum(this.Y);
                            }
                            if (this.Z != -1) {
                                J.getGodUserData().setIsLike(this.Z == 1);
                                postData5.t().getGodUserData().setIsLike(this.Z == 1);
                                J.getGodUserData().setIsFromNetWork(false);
                                postData5.t().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    c.a.t0.s2.r.f fVar5 = this.K;
                    fVar5.f22404e = -1;
                    fVar5.f22403d = -1;
                }
                g gVar = this.T;
                if (gVar != null) {
                    gVar.c(true, getErrorCode(), i2, i5, this.K, this.mErrorString, 1);
                }
            } else if (this.T != null) {
                this.p = this.o;
                if (i3 != 350006) {
                    this.q = this.r;
                }
                this.T.c(false, i3, i2, 0, null, str, 1);
            }
            c.a.t0.s2.r.f fVar6 = this.K;
            if (fVar6 == null || fVar6.O() == null || this.K.l() == null || this.K.g0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.c0.getPageContext();
            historyMessage.threadId = R0().O().g0();
            if (this.M0 && R0().O().z1 != null) {
                historyMessage.threadName = R0().O().z1.f40128b;
            } else {
                historyMessage.threadName = R0().O().getTitle();
            }
            if (this.M0 && !C1()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = R0().l().getName();
            }
            historyMessage.isHostOnly = v0();
            historyMessage.isSquence = f1();
            historyMessage.threadType = R0().O().r1();
            historyMessage.isShareThread = this.M0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048638, this) == null) {
            this.l = "";
        }
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.Z0 : (String) invokeV.objValue;
    }

    public final void X1(int i2) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048640, this, i2) == null) || i2 == 8) {
            return;
        }
        this.H0 = "";
        if (this.I0 != null) {
            if (i2 == 1 && (fVar = this.K) != null && fVar.g0()) {
                if (this.J0 != null) {
                    R0().F().remove(this.J0);
                }
            } else if (i2 == 1 && !this.p && !ListUtils.isEmpty(R0().F())) {
                R0().F().remove(this.I0);
                if (this.J0 != null) {
                    R0().F().remove(this.J0);
                }
                R0().F().add(0, this.I0);
            } else {
                R0().F().remove(this.I0);
                if (this.J0 != null) {
                    R0().F().remove(this.J0);
                }
            }
        }
        this.J0 = null;
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048641, this) == null) {
            this.k = null;
        }
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.X0 : (String) invokeV.objValue;
    }

    public void Y1(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048643, this, fVar) == null) || fVar == null) {
            return;
        }
        String a2 = a2(fVar);
        for (int i2 = 0; i2 < fVar.F().size(); i2++) {
            PostData postData = fVar.F().get(i2);
            for (int i3 = 0; i3 < postData.P().size(); i3++) {
                postData.P().get(i3).G0(this.c0.getPageContext(), a2.equals(postData.P().get(i3).t().getUserId()));
            }
        }
        w T = fVar.T();
        if (T == null || ListUtils.isEmpty(T.a)) {
            return;
        }
        for (PostData postData2 : T.a) {
            for (int i4 = 0; i4 < postData2.P().size(); i4++) {
                postData2.P().get(i4).G0(this.c0.getPageContext(), a2.equals(postData2.P().get(i4).t().getUserId()));
            }
        }
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, str) == null) {
            if ((!this.n || D1(TbadkCoreApplication.getCurrentAccount())) && this.K.F() != null) {
                this.K.y().l(1);
                if (this.K.y().b() == 0) {
                    this.K.y().l(1);
                }
                this.H0 = str;
                f2(8);
            }
        }
    }

    public String Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.W0 : (String) invokeV.objValue;
    }

    public void Z1(c.a.t0.s2.r.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048646, this, fVar, i2) == null) || fVar == null) {
            return;
        }
        String a2 = a2(fVar);
        w T = fVar.T();
        if (T == null || ListUtils.isEmpty(T.a)) {
            return;
        }
        List<PostData> list = T.a;
        for (PostData postData : list.subList(i2, list.size())) {
            for (int i3 = 0; i3 < postData.P().size(); i3++) {
                postData.P().get(i3).G0(this.c0.getPageContext(), a2.equals(postData.P().get(i3).t().getUserId()));
            }
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            return (fVar == null || fVar.l() == null || this.K.O() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a0(c.a.t0.s2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048648, this, fVar) == null) || fVar == null) {
            return;
        }
        if (this.P || this.N || this.O) {
            fVar = w2(fVar);
        }
        Y1(fVar);
    }

    public int a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar != null) {
                return fVar.L();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public String a2(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, fVar)) == null) {
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

    public c.a.t0.s2.r.f b0(e2 e2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048651, this, e2Var)) == null) {
            c.a.t0.s2.r.f fVar = new c.a.t0.s2.r.f();
            fVar.y0(3);
            if (e2Var == null) {
                return null;
            }
            fVar.K0(e2Var);
            if (e2Var.Z() != null) {
                fVar.z0(e2Var.Z());
                ForumData l = fVar.l();
                l.setId(e2Var.Z().getForumId());
                l.setName(e2Var.Z().getForumName());
                l.setUser_level(e2Var.Z().c());
                l.setImage_url(e2Var.Z().b());
                l.setPost_num(e2Var.Z().f13279h);
                l.setMember_num(e2Var.Z().f13280i);
            } else {
                ForumData l2 = fVar.l();
                l2.setId(String.valueOf(e2Var.U()));
                l2.setName(e2Var.a0());
            }
            PostData postData = new PostData();
            postData.n0(1);
            postData.C0(e2Var.P());
            postData.l0(e2Var.J());
            MetaData J = e2Var.J();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(J.getUserId(), J);
            postData.E0(hashMap);
            postData.z0(TbRichTextView.parser(e2Var.W(), h1(), false));
            fVar.A0(postData);
            fVar.F().add(postData);
            fVar.H0(new r(e2Var, null));
            fVar.m = true;
            fVar.D0(1);
            return fVar;
        }
        return (c.a.t0.s2.r.f) invokeL.objValue;
    }

    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.L : invokeV.intValue;
    }

    public final int b2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048653, this, i2)) == null) {
            if (i2 != 1) {
                return i2 != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public void c0(@NonNull e2 e2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048654, this, e2Var) == null) {
            e2Var.U2 = F();
            e2Var.V2 = B();
            e2Var.W2 = C();
            e2Var.X2 = C();
            e2Var.Y2 = G();
            e2Var.G3(w());
        }
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? z1() : invokeV.booleanValue;
    }

    public void c2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048656, this, i2) == null) {
            this.w = i2;
            this.x = i2;
            this.y = i2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            int i2 = this.G0;
            return (i2 == 7 || i2 == 5 || this.f1) ? 1 : 2;
        }
        return invokeV.intValue;
    }

    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.q : invokeV.intValue;
    }

    public void d2() {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048660, this) == null) || (fVar = this.K) == null || ListUtils.isEmpty(fVar.F())) {
            return;
        }
        if (this.J0 != null) {
            this.K.F().remove(this.J0);
            this.J0 = null;
        }
        if (this.I0 != null) {
            this.K.F().remove(this.I0);
            this.I0 = null;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048661, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.unique_id);
            SuggestEmotionModel suggestEmotionModel = this.D0;
            if (suggestEmotionModel != null) {
                suggestEmotionModel.cancelLoadData();
            }
            GetSugMatchWordsModel getSugMatchWordsModel = this.E0;
            if (getSugMatchWordsModel != null) {
                getSugMatchWordsModel.cancelLoadData();
            }
            c.a.t0.j3.l0.b.f().a("PB");
            M1();
        }
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.f46595f);
            if (!this.G) {
                sb.append(this.f46597h);
            }
            sb.append(this.n);
            sb.append(this.p);
            sb.append(this.q);
            sb.append(this.mStType);
            sb.append(this.t);
            sb.append(this.u);
            sb.append(this.v);
            sb.append(this.C);
            sb.append(this.D);
            sb.append(this.E);
            sb.append(this.A);
            sb.append(this.B);
            sb.append(this.I);
            sb.append(this.H);
            sb.append(this.J);
            sb.append(this.M);
            sb.append(this.N);
            sb.append(this.O);
            sb.append(this.P);
            sb.append(this.S0);
            sb.append(this.T0);
            sb.append(this.V0);
            sb.append(this.U0);
            String str = this.X;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.q : invokeV.intValue;
    }

    public void e2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, bundle) == null) {
            bundle.putString("thread_id", this.f46595f);
            bundle.putString("post_id", this.f46597h);
            bundle.putString("forum_id", this.f46598i);
            bundle.putString("from_forum_id", this.f46599j);
            bundle.putInt("key_start_from", this.G0);
            bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.m);
            bundle.putBoolean("host_only", this.n);
            bundle.putBoolean("squence", this.p);
            bundle.putInt("sort_type", this.q);
            bundle.putString("st_type", this.mStType);
            bundle.putString("locate", this.R);
            bundle.putInt("is_good", this.t);
            bundle.putInt("is_top", this.u);
            bundle.putLong("thread_time", this.v);
            bundle.putBoolean("from_mark", this.E);
            bundle.putBoolean("is_pb_key_need_post_id", this.G);
            bundle.putBoolean("is_sub_pb", this.B);
            bundle.putBoolean("is_ad", this.A);
            bundle.putBoolean("is_pv", this.I);
            bundle.putLong("msg_id", this.H);
            bundle.putString("extra_pb_cache_key", this.X);
            bundle.putInt("thread_type", this.M);
            bundle.putBoolean("is_from_thread_config", this.N);
            bundle.putBoolean("is_from_interview_live_config", this.O);
            bundle.putBoolean("is_from_my_god_config", this.P);
            bundle.putInt("extra_pb_is_attention_key", this.Z);
            bundle.putInt("extra_pb_funs_count_key", this.Y);
            bundle.putBoolean("from_frs", this.C);
            bundle.putBoolean("from_maintab", this.D);
            bundle.putBoolean("from_smart_frs", this.u0);
            bundle.putBoolean("from_hottopic", this.Q);
            bundle.putBoolean("key_is_share_thread", this.M0);
            bundle.putString("key_ori_ugc_nid", this.S0);
            bundle.putString("key_ori_ugc_tid", this.T0);
            bundle.putInt("key_ori_ugc_type", this.U0);
            bundle.putString("key_ori_ugc_vid", this.V0);
            bundle.putString("key_rec_weight", this.W0);
            bundle.putString("key_rec_source", this.X0);
            bundle.putString("key_rec_ab_tag", this.Y0);
            bundle.putString("key_rec_extra", this.Z0);
            bundle.putBoolean("key_is_tieba_plus", this.g1);
            bundle.putString("key_tieba_plus_order_id", this.h1);
            bundle.putString("key_tieba_plus_token", this.i1);
            bundle.putString("key_tieba_extra_param", this.j1);
            bundle.putBoolean("key_tieba_plus_cant_delete", this.k1);
            bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.l1);
            bundle.putBoolean("is_jump_from_video_tab", this.n1);
            bundle.putBoolean("is_jump_from_video_middle", this.o1);
        }
    }

    public AddExperiencedModel f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.C0 : (AddExperiencedModel) invokeV.objValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? z1() : invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0335, code lost:
        if ((r11.y - 1) <= 0) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0293 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a7 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0366 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0382 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03ad A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0436 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0446 A[Catch: Exception -> 0x04a1, TryCatch #0 {Exception -> 0x04a1, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03dc, B:183:0x03e7, B:185:0x03f4, B:187:0x03fe, B:189:0x0405, B:191:0x0409, B:193:0x040e, B:196:0x0413, B:198:0x041a, B:200:0x0436, B:201:0x043f, B:203:0x0446, B:205:0x0450, B:208:0x045d, B:209:0x0462, B:212:0x046e, B:213:0x0472, B:197:0x0417, B:188:0x0402, B:184:0x03ef, B:214:0x049e), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x037e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean f2(int i2) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048667, this, i2)) == null) {
            this.L = i2;
            int i5 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            S1(i2);
            c.a.t0.s2.r.f f2 = l0.b().f();
            if (f2 != null && f2.O() != null) {
                f2.O().D3(0);
                this.p = l0.b().i();
                this.n = l0.b().a();
                this.s = l0.b().c();
                this.I0 = l0.b().g();
                this.J0 = l0.b().h();
                this.K0 = l0.b().d();
                this.N0 = l0.b().k();
                this.O0 = l0.b().j();
                boolean z2 = this.n;
                this.F0 = z2;
                if (z2 || this.E) {
                    this.a0 = false;
                }
                c.a.d.f.m.e.a().post(new f(this, f2));
                return false;
            }
            if (i2 == 4 && !this.h0) {
                g2(p0(), true, this.f46597h, 3);
            }
            if (i2 == 3 && !this.h0) {
                if (this.E) {
                    g2(p0(), true, this.f46597h, 3);
                } else {
                    g2(p0(), false, this.f46597h, 3);
                }
            }
            this.h0 = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i2);
            pbPageRequestMessage.setIsReqAd(this.Q0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(c.a.s0.v.a.o);
            if (this.n || this.E) {
                this.a0 = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f46595f != null && this.f46595f.length() != 0) {
                pbPageRequestMessage.set_kz(c.a.d.f.m.b.g(this.f46595f, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.f46594e);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(n.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(n.i(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                pbPageRequestMessage.setSchemeUrl(this.a1);
                if (!this.p) {
                    pbPageRequestMessage.set_r(1);
                }
                pbPageRequestMessage.set_r(Integer.valueOf(this.q));
                if (this.n) {
                    pbPageRequestMessage.set_lz(1);
                }
                if (this.mStType != null) {
                    pbPageRequestMessage.set_st_type(this.mStType);
                }
                if (this.R != null) {
                    pbPageRequestMessage.setLocate(this.R);
                }
                if (this.I) {
                    pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.H));
                    pbPageRequestMessage.set_message_click("1");
                }
                if (this.a0) {
                    pbPageRequestMessage.set_banner(1);
                }
                if (this.U != null) {
                    pbPageRequestMessage.setOpType(this.U);
                    pbPageRequestMessage.setOpUrl(this.V);
                    pbPageRequestMessage.setOpStat(c.a.d.f.m.b.e(this.W, 0));
                    pbPageRequestMessage.setOpMessageID(this.H);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.M));
                ArrayList<PostData> F = this.K.F();
                switch (i2) {
                    case 1:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        if (!this.E) {
                            if (this.q == 1) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.y - 1));
                                break;
                            } else {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.x + 1));
                                z = this.x >= this.z;
                            }
                            if (!this.E || z || this.F) {
                                if (F != null && F.size() > 0) {
                                    size = F.size();
                                    i3 = 1;
                                    while (true) {
                                        i4 = size - i3;
                                        if (i4 >= 0) {
                                            PostData postData = F.get(i4);
                                            if (postData != null) {
                                                String G = postData.G();
                                                this.f46597h = G;
                                                if (StringUtils.isNull(G)) {
                                                }
                                            }
                                            i3++;
                                        }
                                    }
                                    if (this.q == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.x + 1));
                                    }
                                }
                                if (this.f46597h == null && this.f46597h.length() > 0) {
                                    pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f46597h, 0L));
                                    if (this.q == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.q == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            n2(pbPageRequestMessage);
                            break;
                        }
                        if (!this.E) {
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
                            if (this.q == 2) {
                            }
                        }
                        if (this.f46597h == null) {
                        }
                        if (this.q == 1) {
                        }
                        n2(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.f46597h = F.get(0).G();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.E) {
                            if (z1()) {
                                if (this.y - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.y - 1));
                                }
                            } else if (this.x < this.z) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.x + 1));
                            }
                        }
                        if (this.f46597h != null && this.f46597h.length() > 0) {
                            pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f46597h, 0L));
                            if (this.q == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        n2(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.E && !this.n) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!z1()) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                if (this.z > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.z));
                                }
                            }
                            if (this.E) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            r2(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!z1()) {
                        }
                        if (this.E) {
                        }
                        r2(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f46597h, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        n2(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.w));
                        pbPageRequestMessage.set_banner(0);
                        n2(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.q == 1 && this.F0 && !this.n) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f46597h, 0L));
                            if (this.q == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        pbPageRequestMessage.set_back(0);
                        if (this.n) {
                            pbPageRequestMessage.set_banner(0);
                        } else {
                            pbPageRequestMessage.set_banner(1);
                        }
                        n2(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.s0);
                        n2(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.H0, 0L));
                        if (this.q == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.F0 = this.n;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.E));
                pbPageRequestMessage.setCacheKey(p0());
                pbPageRequestMessage.setObjParam1(String.valueOf(this.G0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.r0);
                pbPageRequestMessage.setFromSmartFrs(this.u0 ? 1 : 0);
                if (UtilHelper.isUgcThreadType(this.U0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.f46598i);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.m);
                if (this.G0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.G0 != 7 && this.G0 != 5 && !this.f1) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.S0);
                    pbPageRequestMessage.setOriUgcTid(this.T0);
                    pbPageRequestMessage.setOriUgcType(this.U0);
                    pbPageRequestMessage.setOriUgcVid(this.V0);
                    if (!StringUtils.isNull(this.d1)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.d1));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            i5 = pbPageRequestMessage.getPn().intValue() == this.z ? -1 : g0();
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i5 = g0();
                            }
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i5);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.e1);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.setReqFoldComment(this.m1);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f46595f);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.S0);
                pbPageRequestMessage.setOriUgcTid(this.T0);
                pbPageRequestMessage.setOriUgcType(this.U0);
                pbPageRequestMessage.setOriUgcVid(this.V0);
                if (!StringUtils.isNull(this.d1)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i5);
                pbPageRequestMessage.setImmersionVideoCommentSource(this.e1);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.setReqFoldComment(this.m1);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f46595f);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final int g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            int i2 = 0;
            if (R0().F() == null) {
                return 0;
            }
            ArrayList<PostData> F = R0().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                PostData postData = F.get(size);
                if (!(postData instanceof p)) {
                    i2++;
                } else if (postData.getType() != AdvertAppInfo.B4) {
                    return i2;
                }
            }
            return F.size();
        }
        return invokeV.intValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.O0 : invokeV.intValue;
    }

    public final void g2(String str, boolean z, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048670, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i2)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i2);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) ? this.v0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.f46598i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? this.f46599j : (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.mTopicId : (String) invokeV.objValue;
    }

    public c.a.t0.s2.r.d h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.w0 : (c.a.t0.s2.r.d) invokeV.objValue;
    }

    public String h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.f46595f : (String) invokeV.objValue;
    }

    public void h2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048677, this, i2, i3) == null) {
            this.K0 = i2;
            this.L0 = i3;
        }
    }

    public MarkData i0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048678, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null) {
                return null;
            }
            ArrayList<PostData> F = fVar.F();
            if (ListUtils.isEmpty(F)) {
                return null;
            }
            if (F.size() > 0 && i2 >= F.size()) {
                i2 = F.size() - 1;
            }
            return L0(F.get(i2));
        }
        return (MarkData) invokeI.objValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (!StringUtils.isNull(this.f46595f) && !"0".equals(this.f46595f)) {
                return this.f46595f;
            }
            return this.S0;
        }
        return (String) invokeV.objValue;
    }

    public void i2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, str) == null) {
            this.k0 = str;
        }
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048681, this, bundle) == null) {
            this.G0 = bundle.getInt("key_start_from", 0);
            this.f46595f = bundle.getString("thread_id");
            this.f46597h = bundle.getString("post_id");
            this.f46598i = bundle.getString("forum_id");
            this.f46599j = bundle.getString("from_forum_id");
            bundle.getString("god_reply_id");
            this.m = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.n = bundle.getBoolean("host_only", false);
            this.p = bundle.getBoolean("squence", true);
            this.q = bundle.getInt("sort_type", 0);
            this.mStType = bundle.getString("st_type");
            this.R = bundle.getString("locate");
            this.t = bundle.getInt("is_good", 0);
            this.u = bundle.getInt("is_top", 0);
            this.v = bundle.getLong("thread_time");
            this.E = bundle.getBoolean("from_mark", false);
            this.G = bundle.getBoolean("is_pb_key_need_post_id", false);
            this.A = bundle.getBoolean("is_ad", false);
            this.B = bundle.getBoolean("is_sub_pb", false);
            this.I = bundle.getBoolean("is_pv", false);
            this.n1 = bundle.getBoolean("is_jump_from_video_tab", false);
            this.o1 = bundle.getBoolean("is_jump_from_video_middle", false);
            this.H = bundle.getLong("msg_id", 0L);
            this.J = bundle.getString("from_forum_name");
            this.X = bundle.getString("extra_pb_cache_key");
            this.N = bundle.getBoolean("is_from_thread_config", false);
            this.O = bundle.getBoolean("is_from_interview_live_config", false);
            this.P = bundle.getBoolean("is_from_my_god_config", false);
            this.Z = bundle.getInt("extra_pb_is_attention_key", -1);
            this.Y = bundle.getInt("extra_pb_funs_count_key", -1);
            this.C = bundle.getBoolean("from_frs", false);
            this.D = bundle.getBoolean("from_maintab", false);
            this.u0 = bundle.getBoolean("from_smart_frs", false);
            this.Q = bundle.getBoolean("from_hottopic", false);
            this.M0 = bundle.getBoolean("key_is_share_thread", false);
            this.S0 = bundle.getString("key_ori_ugc_nid");
            this.T0 = bundle.getString("key_ori_ugc_tid");
            this.U0 = bundle.getInt("key_ori_ugc_type", 0);
            this.b1 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.V0 = bundle.getString("key_ori_ugc_vid");
            this.a0 = bundle.getInt("request_code", -1) == 18003;
            this.W0 = bundle.getString("key_rec_weight");
            this.X0 = bundle.getString("key_rec_source");
            this.Y0 = bundle.getString("key_rec_ab_tag");
            this.Z0 = bundle.getString("key_rec_extra");
            this.g1 = bundle.getBoolean("key_is_tieba_plus");
            this.h1 = bundle.getString("key_tieba_plus_order_id");
            this.i1 = bundle.getString("key_tieba_plus_token");
            this.j1 = bundle.getString("key_tieba_extra_param");
            this.k1 = bundle.getBoolean("key_tieba_plus_cant_delete");
            this.l1 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
        }
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048682, this, intent) == null) || intent == null) {
            return;
        }
        this.f46595f = intent.getStringExtra("thread_id");
        this.f46596g = intent.getBooleanExtra("key_is_privacy", false);
        this.S0 = intent.getStringExtra("key_ori_ugc_nid");
        this.T0 = intent.getStringExtra("key_ori_ugc_tid");
        this.U0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.V0 = intent.getStringExtra("key_ori_ugc_vid");
        this.b1 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.n1 = intent.getBooleanExtra("is_jump_from_video_tab", false);
        this.o1 = intent.getBooleanExtra("is_jump_from_video_middle", false);
        this.d1 = intent.getStringExtra("key_official_bar_message_id");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.a1 = uri != null ? uri.toString() : null;
        this.f1 = false;
        if (c.a.s0.a.g.c(uri)) {
            this.f1 = true;
            c.a.s0.a.g.b().f(uri, this.p1);
        } else if (StringUtils.isNull(this.f46595f)) {
            this.f1 = true;
            this.x0.b(intent, this.p1);
            if (uri != null) {
                if (StringUtils.isNull(this.f46595f)) {
                    this.f46595f = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.S0)) {
                    this.S0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.T0)) {
                    this.T0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.U0 == 0) {
                    this.U0 = c.a.d.f.m.b.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.V0)) {
                    this.V0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (m.isEmpty(this.f46595f)) {
            this.f46595f = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.G0 = intExtra;
        if (intExtra == 0) {
            this.G0 = this.x0.a;
        }
        this.f46597h = intent.getStringExtra("post_id");
        this.f46598i = intent.getStringExtra("forum_id");
        this.f46599j = intent.getStringExtra("from_forum_id");
        intent.getStringExtra("god_reply_id");
        this.m = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.n = intent.getBooleanExtra("host_only", false);
        this.p = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.q = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = c.a.s0.s.h0.b.k().l("key_pb_current_sort_type", 2);
        }
        this.q = intExtra2;
        this.f46597h = intExtra2 != 2 ? this.f46597h : "0";
        this.mStType = intent.getStringExtra("st_type");
        this.R = intent.getStringExtra("locate");
        this.t = intent.getIntExtra("is_good", 0);
        this.u = intent.getIntExtra("is_top", 0);
        this.v = intent.getLongExtra("thread_time", 0L);
        this.E = intent.getBooleanExtra("from_mark", false);
        this.F = intent.getBooleanExtra("KEY_SHOULD_ADD_POST_ID", false);
        this.G = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.A = intent.getBooleanExtra("is_ad", false);
        this.B = intent.getBooleanExtra("is_sub_pb", false);
        this.I = intent.getBooleanExtra("is_pv", false);
        this.H = intent.getLongExtra("msg_id", 0L);
        this.J = intent.getStringExtra("from_forum_name");
        this.X = intent.getStringExtra("extra_pb_cache_key");
        this.U = intent.getStringExtra("op_type");
        this.V = intent.getStringExtra("op_url");
        this.W = intent.getStringExtra("op_stat");
        this.N = intent.getBooleanExtra("is_from_thread_config", false);
        this.O = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.P = intent.getBooleanExtra("is_from_my_god_config", false);
        this.Z = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.Y = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.C = intent.getBooleanExtra("from_frs", false);
        this.D = intent.getBooleanExtra("from_maintab", false);
        this.u0 = intent.getBooleanExtra("from_smart_frs", false);
        this.Q = intent.getBooleanExtra("from_hottopic", false);
        this.A0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.M0 = intent.getBooleanExtra("key_is_share_thread", false);
        this.k = intent.getStringExtra("high_light_post_id");
        this.l = intent.getStringExtra(PbCommentFloatActivityConfig.KEY_HIGH_LIGHT_3S_POST_ID);
        this.R0 = intent.getBooleanExtra("key_need_preload", false);
        this.a0 = intent.getIntExtra("request_code", -1) == 18003;
        this.W0 = intent.getStringExtra("key_rec_weight");
        this.X0 = intent.getStringExtra("key_rec_source");
        this.Y0 = intent.getStringExtra("key_rec_ab_tag");
        this.Z0 = intent.getStringExtra("key_rec_extra");
        this.g1 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.h1 = intent.getStringExtra("key_tieba_plus_order_id");
        this.i1 = intent.getStringExtra("key_tieba_plus_token");
        this.j1 = intent.getStringExtra("key_tieba_extra_param");
        this.k1 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.l1 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
        if (this.G0 == 17) {
            this.mTopicId = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_ID);
            this.mTopicSubjectName = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_SUBJECT_NAME);
        }
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) ? this.f46596g : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.M0 : invokeV.booleanValue;
    }

    public Rect j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            Rect rect = this.N0;
            this.N0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public PostData j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.I0 : (PostData) invokeV.objValue;
    }

    public void j2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048687, this, i2) == null) {
            this.e1 = i2;
        }
    }

    public BaijiahaoData k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null || fVar.O() == null) {
                return null;
            }
            return this.K.O().L();
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public PostData k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.J0 : (PostData) invokeV.objValue;
    }

    public void k2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048690, this, i2) == null) {
            this.c1 = i2;
        }
    }

    public p l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) ? this.Q0 : (p) invokeV.objValue;
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.mTopicSubjectName : (String) invokeV.objValue;
    }

    public void l2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048693, this, i2) == null) {
            this.t = i2;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            if (this.f46595f == null) {
                return false;
            }
            cancelLoadData();
            if (this.b0 == null) {
                c.a.t0.w3.l0.b bVar = new c.a.t0.w3.l0.b("pbStat");
                this.b0 = bVar;
                bVar.f();
            }
            boolean f2 = f2(3);
            if (this.U != null) {
                this.U = null;
                this.W = null;
                this.V = null;
            }
            return f2;
        }
        return invokeV.booleanValue;
    }

    public CheckRealNameModel m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.B0 : (CheckRealNameModel) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null || fVar.O() == null) {
                return null;
            }
            return this.K.O().O2;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    public void m2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i2) == null) {
            this.u = i2;
        }
    }

    public c.a.t0.s2.u.f.p n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.y0 : (c.a.t0.s2.u.f.p) invokeV.objValue;
    }

    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.f46597h : (String) invokeV.objValue;
    }

    public final void n2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048700, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(r0()) || y.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(y.q().b().e(r0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(y.q().b().d(r0(), true));
    }

    public MarkData o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f46595f);
            markData.setPostId(this.K.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.n);
            markData.setSequence(Boolean.valueOf(z1()));
            markData.setId(this.f46595f);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            return (fVar == null || ListUtils.isEmpty(fVar.F())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void o2(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048703, this, gVar) == null) {
            this.T = gVar;
        }
    }

    public final String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) {
            String str = this.f46595f;
            String O0 = (str == null || str.equals("0")) ? O0() : this.f46595f;
            if (this.n) {
                O0 = O0 + "_host";
            }
            int i2 = this.q;
            if (i2 == 1) {
                O0 = O0 + "_rev";
            } else if (i2 == 2) {
                O0 = O0 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return O0 + TbadkCoreApplication.getCurrentAccount();
            }
            return O0;
        }
        return (String) invokeV.objValue;
    }

    public final boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? (this.K.z() == null || this.K.z().getAdvertAppInfo() == null || this.K.z().getAdvertAppInfo().h4 == 1001) ? false : true : invokeV.booleanValue;
    }

    public void p2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            this.G0 = i2;
        }
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public void q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048708, this) == null) {
            j.b().d(p0(), this.E);
        }
    }

    public void q2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, str) == null) {
            this.P0 = str;
        }
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.J : (String) invokeV.objValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.l1 : invokeV.booleanValue;
    }

    public final void r2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048712, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(r0()) || y.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(y.q().b().d(r0(), true) + 1);
        pbPageRequestMessage.setLoadCount(y.q().b().e(r0(), true));
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.l : (String) invokeV.objValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public void s2(int i2) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048715, this, i2) == null) || (fVar = this.K) == null) {
            return;
        }
        fVar.J0(i2);
    }

    public String t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) ? this.u0 : invokeV.booleanValue;
    }

    public void t2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048718, this, z) == null) {
            this.m1 = z;
        }
    }

    public MetaData u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            c.a.t0.s2.r.f fVar = this.K;
            if (fVar == null || fVar.O() == null || this.K.O().J() == null) {
                return null;
            }
            return this.K.O().J();
        }
        return (MetaData) invokeV.objValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? this.o1 : invokeV.booleanValue;
    }

    public void u2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048721, this, i2) == null) {
            this.f46594e = i2;
        }
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) ? this.n1 : invokeV.booleanValue;
    }

    public boolean v2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048724, this, i2)) == null) {
            this.w = i2;
            if (i2 > this.K.y().h()) {
                this.w = this.K.y().h();
            }
            if (this.w < 1) {
                this.w = 1;
            }
            if (this.f46595f == null) {
                return false;
            }
            return f2(5);
        }
        return invokeI.booleanValue;
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.c1 : invokeV.intValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.b1 : invokeV.booleanValue;
    }

    public c.a.t0.s2.r.f w2(c.a.t0.s2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048727, this, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            e2 O = fVar.O();
            O.b4(this.t);
            O.c4(this.u);
            long j2 = this.v;
            if (j2 > 0) {
                O.g4(j2);
            }
            c0(O);
            return fVar;
        }
        return (c.a.t0.s2.r.f) invokeL.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.a0 : invokeV.booleanValue;
    }

    public void x2(boolean z) {
        c.a.t0.s2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048730, this, z) == null) || (fVar = this.K) == null) {
            return;
        }
        fVar.C0(z);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.i0 : (String) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.Q : invokeV.booleanValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) ? this.R0 && c.a.t0.d1.l.b() != null && c.a.t0.d1.l.b().equals(this.f46595f) && c.a.t0.d1.l.a() != null : invokeV.booleanValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            if (z1() && this.K.y().b() == 0) {
                F1(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.f46595f : (String) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) ? "hot_topic".equals(this.mStType) : invokeV.booleanValue;
    }

    public final boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            int i2 = this.q;
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean z2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048738, this, str)) == null) {
            this.n = !this.n;
            this.f46597h = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (f2(6)) {
                return true;
            }
            this.n = !this.n;
            return false;
        }
        return invokeL.booleanValue;
    }
}
