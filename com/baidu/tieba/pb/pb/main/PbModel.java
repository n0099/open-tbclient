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
import b.a.e.e.p.j;
import b.a.e.e.p.k;
import b.a.q0.a.g;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.d2;
import b.a.r0.k2.l;
import b.a.r0.k2.r.q;
import b.a.r0.k2.r.v;
import b.a.r0.k2.u.f.b0;
import b.a.r0.k2.u.f.c0;
import b.a.r0.k2.u.f.k0;
import b.a.r0.l3.j0.p;
import b.a.r0.z2.y;
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
/* loaded from: classes9.dex */
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
    public b.a.r0.k2.r.f J;
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
    public b.a.r0.l3.l0.b a0;
    public int a1;
    public BaseFragmentActivity b0;
    public String b1;
    public boolean c0;
    public int c1;
    public boolean d1;

    /* renamed from: e  reason: collision with root package name */
    public int f52414e;
    public boolean e1;

    /* renamed from: f  reason: collision with root package name */
    public String f52415f;
    public String f1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f52416g;
    public String g1;

    /* renamed from: h  reason: collision with root package name */
    public String f52417h;
    public String h1;

    /* renamed from: i  reason: collision with root package name */
    public String f52418i;
    public boolean i0;
    public boolean i1;
    public boolean isLoading;
    public String j;
    public long j0;
    public boolean j1;
    public String k;
    public boolean k0;
    public boolean k1;
    public boolean l;
    public boolean l0;
    public g.b l1;
    public boolean m;
    public String m0;
    public CustomMessageListener m1;
    public String mStType;
    public String mTopicId;
    public String mTopicSubjectName;
    public boolean n;
    public String n0;
    public b.a.e.c.g.a n1;
    public boolean o;
    public long o0;
    public CustomMessageListener o1;
    public int p;
    public boolean p0;
    public CustomMessageListener p1;
    public int q;
    public int q0;
    public PraiseData q1;
    public boolean r;
    public boolean r0;
    public int s;
    public boolean s0;
    public int t;
    public int t0;
    public long u;
    public b.a.r0.k2.r.d u0;
    public int v;
    public final b0 v0;
    public int w;
    public final b.a.r0.k2.u.f.p w0;
    public int x;
    public final c0 x0;
    public int y;
    public String y0;
    public boolean z;
    public final CheckRealNameModel z0;

    /* loaded from: classes9.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f52419a;

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
            this.f52419a = pbModel;
        }

        @Override // b.a.q0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(b.a.q0.a.g.s) instanceof String) {
                this.f52419a.f52415f = (String) hashMap.get(b.a.q0.a.g.s);
            }
            if (hashMap.get(b.a.q0.a.g.t) instanceof String) {
                this.f52419a.Q0 = (String) hashMap.get(b.a.q0.a.g.t);
            }
            if (hashMap.get(b.a.q0.a.g.u) instanceof String) {
                this.f52419a.R0 = (String) hashMap.get(b.a.q0.a.g.u);
            }
            if (hashMap.get(b.a.q0.a.g.v) instanceof String) {
                this.f52419a.S0 = b.a.e.e.m.b.e((String) hashMap.get(b.a.q0.a.g.v), 0);
            }
            if (hashMap.get(b.a.q0.a.g.w) instanceof String) {
                this.f52419a.T0 = (String) hashMap.get(b.a.q0.a.g.w);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f52420a;

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
            this.f52420a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.f52420a.P0() == null || this.f52420a.P0().l() == null || this.f52420a.P0().l().getSignData() == null || !signData.forumId.equals(this.f52420a.P0().m())) {
                return;
            }
            this.f52420a.P0().l().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes9.dex */
    public class c extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f52421a;

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
            this.f52421a = pbModel;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.f52421a.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && j.z()) {
                        this.f52421a.b0.showToast(responsedMessage.getErrorString());
                    }
                    if (z2) {
                        this.f52421a.O1((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.f52421a.N1((pbPageHttpResponseMessage) responsedMessage);
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
                        b.a.q0.s.a0.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (this.f52421a.c0 && this.f52421a.i0) {
                        return;
                    }
                    if (!this.f52421a.c0) {
                        this.f52421a.c0 = true;
                    } else {
                        this.f52421a.i0 = true;
                    }
                    if (this.f52421a.S != null) {
                        this.f52421a.S.a(this.f52421a.R0(), z, responsedMessage, this.f52421a.k0, System.currentTimeMillis() - this.f52421a.j0);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f52422a;

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
            this.f52422a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                b.a.r0.k2.r.f fVar = this.f52422a.J;
                if (fVar == null || fVar.h() == null || this.f52422a.J.h().getForumId() == null || !this.f52422a.J.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.f52422a.J.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f52423a;

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
            this.f52423a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                b.a.r0.k2.r.f fVar = this.f52423a.J;
                if (fVar == null || fVar.h() == null || this.f52423a.J.h().getForumId() == null || !this.f52423a.J.h().getForumId().equals(valueOf)) {
                    return;
                }
                this.f52423a.J.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.r0.k2.r.f f52424e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbModel f52425f;

        public f(PbModel pbModel, b.a.r0.k2.r.f fVar) {
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
            this.f52425f = pbModel;
            this.f52424e = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f52425f.Q1(this.f52424e, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.f52425f.isLoading = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(b.a.r0.k2.r.f fVar);

        void c(boolean z, int i2, int i3, int i4, b.a.r0.k2.r.f fVar, String str, int i5);
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
        int a2 = b.a.q0.u.d.a() / 30;
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
                super((b.a.e.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f52414e = 4;
        this.mStType = null;
        this.f52415f = null;
        this.f52416g = false;
        this.f52417h = null;
        this.f52418i = null;
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
        this.mTopicId = "";
        this.mTopicSubjectName = "";
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
        this.m1 = new b(this, 2001222);
        this.n1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.o1 = new d(this, 2001336);
        this.p1 = new e(this, 2001335);
        this.q1 = null;
        registerListener(this.n1);
        registerListener(this.m1);
        registerListener(this.p1);
        registerListener(this.o1);
        b.a.r0.k2.r.f fVar = new b.a.r0.k2.r.f();
        this.J = fVar;
        fVar.y0(0);
        this.R = baseFragmentActivity.getPageContext().getPageActivity();
        this.b0 = baseFragmentActivity;
        this.v0 = new b0(this, baseFragmentActivity);
        this.w0 = new b.a.r0.k2.u.f.p(this, this.b0);
        this.x0 = new c0(this, this.b0);
        this.z0 = new CheckRealNameModel(this.b0.getPageContext());
        this.B0 = new SuggestEmotionModel();
        this.A0 = new AddExperiencedModel(this.b0.getPageContext());
        this.l1 = new a(this);
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

    public void A1(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, forumData, cVar) == null) {
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
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f1 : (String) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null) {
                return false;
            }
            return fVar.r();
        }
        return invokeV.booleanValue;
    }

    public boolean B1(boolean z) {
        InterceptResult invokeZ;
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048581, this, z)) == null) {
            if (this.f52415f == null || (fVar = this.J) == null) {
                return false;
            }
            if (z || fVar.y().b() != 0) {
                return Z1(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
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

    public void C1(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f52415f = fVar.Q();
        if (fVar.O() != null && fVar.O().L() != null) {
            BaijiahaoData L = fVar.O().L();
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
        this.f52417h = null;
        this.m = false;
        this.o = true;
        loadData();
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData D(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null || fVar.O() == null || this.J.l() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.J.O().l2()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.J.l().getId());
                writeData.setForumName(this.J.l().getName());
            }
            writeData.setFromForumId(this.j);
            writeData.sourceFrom = String.valueOf(this.E0);
            writeData.setThreadId(this.f52415f);
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

    public void D1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f52415f = str;
        this.f52417h = null;
        this.m = false;
        this.o = true;
        loadData();
    }

    public int E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.t : invokeV.intValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.f52415f == null || this.f52417h == null) {
                return false;
            }
            cancelMessage();
            if (this.D) {
                return Z1(4);
            }
            return Z1(6);
        }
        return invokeV.booleanValue;
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
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null) {
                return false;
            }
            return fVar.q0();
        }
        return invokeV.booleanValue;
    }

    public boolean F1(boolean z) {
        InterceptResult invokeZ;
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048592, this, z)) == null) {
            if (this.f52415f == null || (fVar = this.J) == null || ((!z && fVar.y().c() == 0) || this.J.F() == null || this.J.F().size() < 1)) {
                return false;
            }
            return Z1(2);
        }
        return invokeZ.booleanValue;
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
                if (postData != null && !StringUtils.isNull(postData.G())) {
                    return postData.G();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void G1(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048595, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.C0 == null) {
            this.C0 = new GetSugMatchWordsModel(this.b0.getPageContext());
        }
        this.C0.y(bVar);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? H1() : invokeV.booleanValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.J0 : invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String str = this.f52417h;
            if (str != null && !str.equals("0") && this.f52417h.length() != 0) {
                return E1();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public int I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.I0 : invokeV.intValue;
    }

    public final void I1() {
        b.a.r0.l3.l0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (bVar = this.a0) == null) {
            return;
        }
        bVar.a();
        this.a0 = null;
    }

    public MarkData J0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f52415f);
            markData.setPostId(postData.G());
            markData.setTime(date.getTime());
            markData.setHostMode(this.m);
            markData.setSequence(Boolean.valueOf(v1()));
            markData.setId(this.f52415f);
            markData.setFloor(postData.A());
            markData.setForumId(this.f52418i);
            boolean z = true;
            if (postData instanceof b.a.r0.k2.r.c) {
                markData.setApp(true);
            } else if (postData instanceof p) {
                p pVar = (p) postData;
                markData.setApp((pVar.getAdvertAppInfo() == null || !pVar.getAdvertAppInfo().R4()) ? false : false);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void J1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048602, this) == null) || !"personalize_page".equals(this.mStType) || this.J == null || this.o0 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        TiebaStatic.log(new StatisticItem("c10754").param("fid", this.J.m()).param("tid", this.f52415f).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.o0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
        this.o0 = 0L;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null || !fVar.r()) {
                return null;
            }
            return this.J.u();
        }
        return (String) invokeV.objValue;
    }

    public void K1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && "personalize_page".equals(this.mStType)) {
            this.o0 = System.currentTimeMillis() / 1000;
        }
    }

    public c0 L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.x0 : (c0) invokeV.objValue;
    }

    public void L1(b.a.r0.k2.r.f fVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048606, this, fVar, i2, str) == null) {
            this.l0 = true;
            if (fVar == null || fVar.f18764h != null) {
                return;
            }
            z2(fVar);
            Z(fVar);
            if (fVar.O() != null) {
                fVar.O().z3(0);
            }
            g gVar = this.S;
            if (gVar == null || fVar == null) {
                return;
            }
            gVar.c(true, 0, i2, 0, fVar, str, 0);
        }
    }

    public final String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
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

    public void M1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            R1(i2);
            ArrayList<PostData> F = this.J.F();
            boolean z = false;
            this.k0 = false;
            if (i2 != 1) {
                if (i2 == 2) {
                    while (F.size() + 30 > b.a.q0.u.d.a()) {
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
            while (F.size() + 30 > b.a.q0.u.d.a()) {
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

    public b1 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null) {
                return null;
            }
            return fVar.y();
        }
        return (b1) invokeV.objValue;
    }

    public void N1(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.u0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            P1(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public int O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.E0 : invokeV.intValue;
    }

    public void O1(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.u0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            P1(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public b.a.r0.k2.r.f P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.J : (b.a.r0.k2.r.f) invokeV.objValue;
    }

    public void P1(b.a.r0.k2.r.f fVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j, long j2) {
        b.a.r0.k2.r.f fVar2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i5 = i3;
                fVar2 = null;
            } else {
                fVar2 = fVar;
                i5 = i3;
            }
            this.t0 = i5;
            this.isLoading = false;
            if (fVar2 != null) {
                Z(fVar2);
            }
            V(fVar2);
            p pVar = this.O0;
            if (pVar != null && pVar.M0()) {
                TiebaStatic.log(b.a.r0.k3.a.h("a005", "common_fill", true, 1));
            }
            Q1(fVar2, i2, z, i3, str, z2, i4, j, j2, false);
        }
    }

    public b.a.r0.k2.r.f Q0() {
        InterceptResult invokeV;
        p pVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null) {
                return fVar;
            }
            if (!n1() && (pVar = this.O0) != null) {
                this.J.G0(pVar);
            }
            return this.J;
        }
        return (b.a.r0.k2.r.f) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void Q1(b.a.r0.k2.r.f fVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j, long j2, boolean z3) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{fVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.r0 = z3;
            b.a.r0.l3.l0.b bVar = this.a0;
            if (bVar != null && !z3) {
                bVar.b(z2, z4, i3, str, i4, j, j2);
                this.a0 = null;
            }
            b.a.r0.k2.r.f fVar2 = this.J;
            if (fVar2 != null) {
                fVar2.a0 = z3;
                fVar2.b0 = i2;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(q0()) && y.o().b() != null) {
                y.o().b().g(q0(), V1(Z0()), true);
            }
            if (fVar != null && (this.v != 1 || i2 != 5 || fVar.F() == null || fVar.F().size() >= 1)) {
                this.n = this.o;
                if (i2 != 8) {
                    this.q = this.p;
                    this.p = fVar.f18763g;
                }
                List<PbSortType> list = fVar.f18762f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.b0.getResources().getString(l.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    fVar.f18762f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.b0.getResources().getString(l.view_reverse);
                    builder2.sort_type = 1;
                    fVar.f18762f.add(builder2.build(false));
                    int i7 = this.q;
                    this.p = i7;
                    fVar.f18763g = i7;
                }
                this.H = false;
                if (fVar.y() != null && (this.p != 2 || i2 != 8)) {
                    U(fVar.y());
                }
                int i8 = this.y;
                if (i8 < 1) {
                    i8 = 1;
                }
                this.y = i8;
                ArrayList<PostData> F = this.J.F();
                switch (i2) {
                    case 1:
                        this.J.F0(fVar.y(), 1);
                        y2(fVar, F);
                        w2(fVar);
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
                        w2(fVar);
                        this.J.F0(fVar.y(), 2);
                        break;
                    case 3:
                        if (this.p == 1 && fVar.y() != null) {
                            fVar.y().k(fVar.y().h());
                        }
                        z2(fVar);
                        i5 = 0;
                        break;
                    case 4:
                        z2(fVar);
                        i5 = 0;
                        break;
                    case 5:
                        z2(fVar);
                        i5 = 0;
                        break;
                    case 6:
                        z2(fVar);
                        i5 = 0;
                        break;
                    case 7:
                        z2(fVar);
                        i5 = 0;
                        break;
                    case 8:
                        if (fVar == null || ListUtils.isEmpty(fVar.F()) || this.J == null || (this.m && !U1(fVar).equals(fVar.F().get(0).t().getUserId()))) {
                            i6 = 0;
                        } else {
                            if (this.J.y().b() == 0) {
                                this.J.y().l(1);
                            }
                            X1();
                            this.G0 = fVar.F().get(0);
                            if (!v1() && !this.J.g0()) {
                                if (this.I0 - this.J0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.H0 = postData3;
                                    postData3.F = false;
                                    postData3.w0(53);
                                    this.J.F().add(0, this.H0);
                                }
                                this.J.F().add(0, this.G0);
                                i6 = 0;
                            } else {
                                if (this.J.F().size() - this.I0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.H0 = postData4;
                                    postData4.F = true;
                                    postData4.w0(53);
                                    this.J.F().add(this.H0);
                                }
                                this.J.F().add(this.G0);
                                i6 = this.J.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(b.a.q0.s.e0.b.j().l("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.G0.V = this.J.J();
                                b.a.q0.s.e0.b.j().w("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        w2(fVar);
                        i5 = i6;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
                b.a.r0.k2.r.f fVar3 = this.J;
                if (fVar3 != null && fVar3.O() != null) {
                    PraiseData L0 = this.J.O().L0();
                    if (this.q1 != null && !L0.isPriaseDataValid()) {
                        this.J.O().m4(this.q1);
                    } else {
                        PraiseData L02 = this.J.O().L0();
                        this.q1 = L02;
                        L02.setPostId(this.J.O().W());
                    }
                    if (fVar.y() != null && fVar.y().a() == 1 && fVar.O() != null && fVar.O().q() != null && fVar.O().q().size() > 0) {
                        this.J.O().q3(fVar.O().q());
                    }
                    this.J.O().n4(fVar.O().U0());
                    this.J.O().v3(fVar.O().F());
                    this.J.O().z3(fVar.O().O());
                    if (this.L == 33) {
                        this.J.O().J().setHadConcerned(fVar.O().J().hadConcerned());
                    }
                    if (fVar != null && fVar.O() != null) {
                        this.J.O().N4(fVar.O().n0());
                    }
                }
                b.a.r0.k2.r.f fVar4 = this.J;
                if (fVar4 != null && fVar4.U() != null && fVar.U() != null) {
                    this.J.U().setBimg_end_time(fVar.U().getBimg_end_time());
                    this.J.U().setBimg_url(fVar.U().getBimg_url());
                }
                if (fVar.y() != null && fVar.y().a() == 1 && fVar.W() != null) {
                    this.J.M0(fVar.W());
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
                    b.a.r0.k2.r.f fVar5 = this.J;
                    fVar5.f18761e = -1;
                    fVar5.f18760d = -1;
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
            b.a.r0.k2.r.f fVar6 = this.J;
            if (fVar6 == null || fVar6.O() == null || this.J.l() == null || this.J.g0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.b0.getPageContext();
            historyMessage.threadId = P0().O().f0();
            if (this.K0 && P0().O().y1 != null) {
                historyMessage.threadName = P0().O().y1.f45036b;
            } else {
                historyMessage.threadName = P0().O().getTitle();
            }
            if (this.K0 && !y1()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = P0().l().getName();
            }
            historyMessage.isHostOnly = t0();
            historyMessage.isSquence = d1();
            historyMessage.threadType = P0().O().o1();
            historyMessage.isShareThread = this.K0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public final void R1(int i2) {
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048618, this, i2) == null) || i2 == 8) {
            return;
        }
        this.F0 = "";
        if (this.G0 != null) {
            if (i2 == 1 && (fVar = this.J) != null && fVar.g0()) {
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

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) ? this.y0 : (String) invokeV.objValue;
    }

    public void S1(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, fVar) == null) || fVar == null) {
            return;
        }
        String U1 = U1(fVar);
        for (int i2 = 0; i2 < fVar.F().size(); i2++) {
            PostData postData = fVar.F().get(i2);
            for (int i3 = 0; i3 < postData.O().size(); i3++) {
                postData.O().get(i3).F0(this.b0.getPageContext(), U1.equals(postData.O().get(i3).t().getUserId()));
            }
        }
        v T = fVar.T();
        if (T == null || ListUtils.isEmpty(T.f18820a)) {
            return;
        }
        for (PostData postData2 : T.f18820a) {
            for (int i4 = 0; i4 < postData2.O().size(); i4++) {
                postData2.O().get(i4).F0(this.b0.getPageContext(), U1.equals(postData2.O().get(i4).t().getUserId()));
            }
        }
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.N0 : (String) invokeV.objValue;
    }

    public void T1(b.a.r0.k2.r.f fVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048622, this, fVar, i2) == null) || fVar == null) {
            return;
        }
        String U1 = U1(fVar);
        v T = fVar.T();
        if (T == null || ListUtils.isEmpty(T.f18820a)) {
            return;
        }
        List<PostData> list = T.f18820a;
        for (PostData postData : list.subList(i2, list.size())) {
            for (int i3 = 0; i3 < postData.O().size(); i3++) {
                postData.O().get(i3).F0(this.b0.getPageContext(), U1.equals(postData.O().get(i3).t().getUserId()));
            }
        }
    }

    public void U(b1 b1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, b1Var) == null) {
            if (b1Var == null) {
                W1(1);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.W0 : (String) invokeV.objValue;
    }

    public String U1(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048625, this, fVar)) == null) {
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

    public final void V(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, fVar) == null) || fVar == null || fVar.z() == null || fVar.z().getAdvertAppInfo() == null || !fVar.z().M0() || fVar.z().getAdvertAppInfo().Z3 == 1001) {
            return;
        }
        this.O0 = fVar.z();
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.X0 : (String) invokeV.objValue;
    }

    public final int V1(int i2) {
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

    public void W() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.O0 = null;
        }
    }

    public String W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public void W1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i2) == null) {
            this.v = i2;
            this.w = i2;
            this.x = i2;
        }
    }

    public void X() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            this.k = null;
        }
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.U0 : (String) invokeV.objValue;
    }

    public void X1() {
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || (fVar = this.J) == null || ListUtils.isEmpty(fVar.F())) {
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

    public void Y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048635, this, str) == null) {
            if ((!this.m || z1(TbadkCoreApplication.getCurrentAccount())) && this.J.F() != null) {
                this.J.y().l(1);
                if (this.J.y().b() == 0) {
                    this.J.y().l(1);
                }
                this.F0 = str;
                Z1(8);
            }
        }
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar != null) {
                return fVar.L();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void Y1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, bundle) == null) {
            bundle.putString("thread_id", this.f52415f);
            bundle.putString("post_id", this.f52417h);
            bundle.putString("forum_id", this.f52418i);
            bundle.putString("from_forum_id", this.j);
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

    public void Z(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048638, this, fVar) == null) || fVar == null) {
            return;
        }
        if (this.O || this.M || this.N) {
            fVar = q2(fVar);
        }
        S1(fVar);
    }

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.K : invokeV.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0335, code lost:
        if ((r11.x - 1) <= 0) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0293 A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a7 A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0366 A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0382 A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03ad A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x043b A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x044b A[Catch: Exception -> 0x04a6, TryCatch #0 {Exception -> 0x04a6, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0162, B:50:0x0172, B:51:0x0175, B:53:0x0182, B:54:0x0185, B:56:0x0189, B:57:0x018e, B:59:0x0192, B:60:0x0197, B:62:0x019b, B:63:0x01aa, B:65:0x01ae, B:66:0x01b1, B:68:0x01b5, B:69:0x01cd, B:73:0x01e3, B:75:0x01f0, B:76:0x0202, B:77:0x0212, B:79:0x0219, B:81:0x021d, B:83:0x0221, B:87:0x0235, B:89:0x023c, B:91:0x0243, B:90:0x0240, B:84:0x0225, B:86:0x0232, B:92:0x0248, B:93:0x025c, B:94:0x0276, B:96:0x027a, B:99:0x027f, B:101:0x0286, B:103:0x028f, B:107:0x02a3, B:109:0x02a7, B:110:0x02aa, B:104:0x0293, B:106:0x029a, B:100:0x0283, B:112:0x02b1, B:114:0x02b7, B:116:0x02bd, B:117:0x02c9, B:119:0x02d3, B:121:0x02d9, B:123:0x02de, B:124:0x02e9, B:126:0x02ef, B:127:0x02f9, B:129:0x02fd, B:131:0x0305, B:133:0x0312, B:134:0x0315, B:135:0x031a, B:137:0x0324, B:139:0x0328, B:146:0x034b, B:149:0x0351, B:176:0x03b0, B:152:0x0357, B:154:0x035d, B:155:0x0362, B:157:0x0366, B:159:0x036e, B:160:0x0371, B:163:0x037e, B:165:0x0382, B:166:0x038c, B:168:0x0390, B:170:0x0398, B:172:0x03a5, B:173:0x03a9, B:175:0x03ad, B:142:0x0339, B:177:0x03b3, B:181:0x03e1, B:183:0x03ec, B:185:0x03f9, B:187:0x0403, B:189:0x040a, B:191:0x040e, B:193:0x0413, B:196:0x0418, B:198:0x041f, B:200:0x043b, B:201:0x0444, B:203:0x044b, B:205:0x0455, B:208:0x0462, B:209:0x0467, B:212:0x0473, B:213:0x0477, B:197:0x041c, B:188:0x0407, B:184:0x03f4, B:214:0x04a3), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x037e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean Z1(int i2) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048640, this, i2)) == null) {
            this.K = i2;
            int i5 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            M1(i2);
            b.a.r0.k2.r.f f2 = k0.b().f();
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
                b.a.e.e.m.e.a().post(new f(this, f2));
                return false;
            }
            if (i2 == 4 && !this.l0) {
                a2(o0(), true, this.f52417h, 3);
            }
            if (i2 == 3 && !this.l0) {
                if (this.D) {
                    a2(o0(), true, this.f52417h, 3);
                } else {
                    a2(o0(), false, this.f52417h, 3);
                }
            }
            this.l0 = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i2);
            pbPageRequestMessage.setIsReqAd(this.O0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(b.a.q0.v.a.o);
            if (this.m || this.D) {
                this.Z = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f52415f != null && this.f52415f.length() != 0) {
                pbPageRequestMessage.set_kz(b.a.e.e.m.b.g(this.f52415f, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.f52414e);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(b.a.e.e.p.l.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(b.a.e.e.p.l.i(TbadkCoreApplication.getInst().getApp())));
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
                    pbPageRequestMessage.setOpStat(b.a.e.e.m.b.e(this.V, 0));
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
                                                String G = postData.G();
                                                this.f52417h = G;
                                                if (StringUtils.isNull(G)) {
                                                }
                                            }
                                            i3++;
                                        }
                                    }
                                    if (this.p == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.w + 1));
                                    }
                                }
                                if (this.f52417h == null && this.f52417h.length() > 0) {
                                    pbPageRequestMessage.set_pid(b.a.e.e.m.b.g(this.f52417h, 0L));
                                    if (this.p == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.p == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            h2(pbPageRequestMessage);
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
                        if (this.f52417h == null) {
                        }
                        if (this.p == 1) {
                        }
                        h2(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.f52417h = F.get(0).G();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.D) {
                            if (v1()) {
                                if (this.x - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.x - 1));
                                }
                            } else if (this.w < this.y) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.w + 1));
                            }
                        }
                        if (this.f52417h != null && this.f52417h.length() > 0) {
                            pbPageRequestMessage.set_pid(b.a.e.e.m.b.g(this.f52417h, 0L));
                            if (this.p == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        h2(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.D && !this.m) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!v1()) {
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
                            l2(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!v1()) {
                        }
                        if (this.D) {
                        }
                        l2(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(b.a.e.e.m.b.g(this.f52417h, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        h2(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.v));
                        pbPageRequestMessage.set_banner(0);
                        h2(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.p == 1 && this.D0 && !this.m) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(b.a.e.e.m.b.g(this.f52417h, 0L));
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
                        h2(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.q0);
                        h2(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(b.a.e.e.m.b.g(this.F0, 0L));
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
                    pbPageRequestMessage.setForumId(this.f52418i);
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
                    pbPageRequestMessage.setReqFoldComment(this.k1);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f52415f);
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
                pbPageRequestMessage.setReqFoldComment(this.k1);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f52415f);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            return (fVar == null || fVar.l() == null || this.J.O() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public b.a.r0.k2.r.f a0(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, d2Var)) == null) {
            b.a.r0.k2.r.f fVar = new b.a.r0.k2.r.f();
            fVar.y0(3);
            if (d2Var == null) {
                return null;
            }
            fVar.K0(d2Var);
            if (d2Var.Y() != null) {
                fVar.z0(d2Var.Y());
                ForumData l = fVar.l();
                l.setId(d2Var.Y().getForumId());
                l.setName(d2Var.Y().getForumName());
                l.setUser_level(d2Var.Y().c());
                l.setImage_url(d2Var.Y().b());
                l.setPost_num(d2Var.Y().f13512h);
                l.setMember_num(d2Var.Y().f13513i);
            } else {
                ForumData l2 = fVar.l();
                l2.setId(String.valueOf(d2Var.T()));
                l2.setName(d2Var.Z());
            }
            PostData postData = new PostData();
            postData.m0(1);
            postData.B0(d2Var.P());
            postData.k0(d2Var.J());
            MetaData J = d2Var.J();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(J.getUserId(), J);
            postData.D0(hashMap);
            postData.y0(TbRichTextView.parser(this.R, d2Var.V(), f1(), false));
            fVar.A0(postData);
            fVar.F().add(postData);
            fVar.H0(new q(d2Var, null));
            fVar.m = true;
            fVar.D0(1);
            return fVar;
        }
        return (b.a.r0.k2.r.f) invokeL.objValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) ? v1() : invokeV.booleanValue;
    }

    public final void a2(String str, boolean z, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048644, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i2)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setContext(this.R);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i2);
            sendMessage(pbPageReadLocalRequestMessage);
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

    public void b2(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048647, this, i2, i3) == null) {
            this.I0 = i2;
            this.J0 = i3;
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

    public void c2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048650, this, str) == null) {
            this.n0 = str;
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

    public String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.f52415f);
            if (!this.F) {
                sb.append(this.f52417h);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? v1() : invokeV.booleanValue;
    }

    public void d2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048654, this, i2) == null) {
            this.c1 = i2;
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
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
            b.a.r0.z2.l0.b.f().a("PB");
            I1();
        }
    }

    public AddExperiencedModel e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.A0 : (AddExperiencedModel) invokeV.objValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.M0 : invokeV.intValue;
    }

    public void e2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048658, this, i2) == null) {
            this.a1 = i2;
        }
    }

    public final int f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.f52415f : (String) invokeV.objValue;
    }

    public void f2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i2) == null) {
            this.s = i2;
        }
    }

    public b.a.r0.k2.r.d g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.u0 : (b.a.r0.k2.r.d) invokeV.objValue;
    }

    public String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (!StringUtils.isNull(this.f52415f) && !"0".equals(this.f52415f)) {
                return this.f52415f;
            }
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public void g2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048664, this, i2) == null) {
            this.t = i2;
        }
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.t0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? this.f52418i : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.mTopicId : (String) invokeV.objValue;
    }

    public MarkData h0(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048669, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            b.a.r0.k2.r.f fVar = this.J;
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
            return J0(F.get(i2));
        }
        return (MarkData) invokeI.objValue;
    }

    public PostData h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) ? this.G0 : (PostData) invokeV.objValue;
    }

    public final void h2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048671, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(q0()) || y.o().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(y.o().b().e(q0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(y.o().b().d(q0(), true));
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

    public void i2(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, gVar) == null) {
            this.S = gVar;
        }
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, bundle) == null) {
            this.E0 = bundle.getInt("key_start_from", 0);
            this.f52415f = bundle.getString("thread_id");
            this.f52417h = bundle.getString("post_id");
            this.f52418i = bundle.getString("forum_id");
            this.j = bundle.getString("from_forum_id");
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
        this.f52415f = intent.getStringExtra("thread_id");
        this.f52416g = intent.getBooleanExtra("key_is_privacy", false);
        this.Q0 = intent.getStringExtra("key_ori_ugc_nid");
        this.R0 = intent.getStringExtra("key_ori_ugc_tid");
        this.S0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.T0 = intent.getStringExtra("key_ori_ugc_vid");
        this.Z0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.b1 = intent.getStringExtra("key_official_bar_message_id");
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.Y0 = uri != null ? uri.toString() : null;
        this.d1 = false;
        if (b.a.q0.a.g.c(uri)) {
            this.d1 = true;
            b.a.q0.a.g.b().f(uri, this.l1);
        } else if (StringUtils.isNull(this.f52415f)) {
            this.d1 = true;
            this.v0.b(intent, this.l1);
            if (uri != null) {
                if (StringUtils.isNull(this.f52415f)) {
                    this.f52415f = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.Q0)) {
                    this.Q0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.R0)) {
                    this.R0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.S0 == 0) {
                    this.S0 = b.a.e.e.m.b.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.T0)) {
                    this.T0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (k.isEmpty(this.f52415f)) {
            this.f52415f = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.E0 = intExtra;
        if (intExtra == 0) {
            this.E0 = this.v0.f19072a;
        }
        this.f52417h = intent.getStringExtra("post_id");
        this.f52418i = intent.getStringExtra("forum_id");
        this.j = intent.getStringExtra("from_forum_id");
        intent.getStringExtra("god_reply_id");
        this.l = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.m = intent.getBooleanExtra("host_only", false);
        this.o = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.p = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = b.a.q0.s.e0.b.j().k("key_pb_current_sort_type", 2);
        }
        this.p = intExtra2;
        this.f52417h = intExtra2 != 2 ? this.f52417h : "0";
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
        if (this.E0 == 17) {
            this.mTopicId = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_ID);
            this.mTopicSubjectName = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_SUBJECT_NAME);
        }
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.f52416g : invokeV.booleanValue;
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
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null || fVar.O() == null) {
                return null;
            }
            return this.J.O().L();
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public String j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mTopicSubjectName : (String) invokeV.objValue;
    }

    public void j2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048681, this, i2) == null) {
            this.E0 = i2;
        }
    }

    public p k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.O0 : (p) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null || fVar.O() == null) {
                return null;
            }
            return this.J.O().M2;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    public void k2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048684, this, str) == null) {
            this.N0 = str;
        }
    }

    public CheckRealNameModel l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? this.z0 : (CheckRealNameModel) invokeV.objValue;
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.f52417h : (String) invokeV.objValue;
    }

    public final void l2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048687, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(q0()) || y.o().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(y.o().b().d(q0(), true) + 1);
        pbPageRequestMessage.setLoadCount(y.o().b().e(q0(), true));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            if (this.f52415f == null) {
                return false;
            }
            cancelLoadData();
            if (this.a0 == null) {
                b.a.r0.l3.l0.b bVar = new b.a.r0.l3.l0.b("pbStat");
                this.a0 = bVar;
                bVar.f();
            }
            boolean Z1 = Z1(3);
            if (this.T != null) {
                this.T = null;
                this.V = null;
                this.U = null;
            }
            return Z1;
        }
        return invokeV.booleanValue;
    }

    public b.a.r0.k2.u.f.p m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.w0 : (b.a.r0.k2.u.f.p) invokeV.objValue;
    }

    public boolean m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            return (fVar == null || ListUtils.isEmpty(fVar.F())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void m2(int i2) {
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048691, this, i2) == null) || (fVar = this.J) == null) {
            return;
        }
        fVar.J0(i2);
    }

    public MarkData n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f52415f);
            markData.setPostId(this.J.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.m);
            markData.setSequence(Boolean.valueOf(v1()));
            markData.setId(this.f52415f);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public final boolean n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048693, this)) == null) ? (this.J.z() == null || this.J.z().getAdvertAppInfo() == null || this.J.z().getAdvertAppInfo().Z3 == 1001) ? false : true : invokeV.booleanValue;
    }

    public void n2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048694, this, z) == null) {
            this.k1 = z;
        }
    }

    public final String o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            String str = this.f52415f;
            String M0 = (str == null || str.equals("0")) ? M0() : this.f52415f;
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

    public void o1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048696, this) == null) {
            b.a.r0.k2.u.f.j.b().d(o0(), this.D);
        }
    }

    public void o2(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048697, this, i2) == null) {
            this.f52414e = i2;
        }
    }

    public String p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) ? this.n0 : (String) invokeV.objValue;
    }

    public boolean p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) ? this.j1 : invokeV.booleanValue;
    }

    public boolean p2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048700, this, i2)) == null) {
            this.v = i2;
            if (i2 > this.J.y().h()) {
                this.v = this.J.y().h();
            }
            if (this.v < 1) {
                this.v = 1;
            }
            if (this.f52415f == null) {
                return false;
            }
            return Z1(5);
        }
        return invokeI.booleanValue;
    }

    public String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.I : (String) invokeV.objValue;
    }

    public boolean q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.r0 : invokeV.booleanValue;
    }

    public b.a.r0.k2.r.f q2(b.a.r0.k2.r.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048703, this, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            d2 O = fVar.O();
            O.X3(this.s);
            O.Y3(this.t);
            long j = this.u;
            if (j > 0) {
                O.c4(j);
            }
            b0(O);
            return fVar;
        }
        return (b.a.r0.k2.r.f) invokeL.objValue;
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.k : (String) invokeV.objValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.s0 : invokeV.booleanValue;
    }

    public void r2(boolean z) {
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048706, this, z) == null) || (fVar = this.J) == null) {
            return;
        }
        fVar.C0(z);
    }

    public MetaData s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            b.a.r0.k2.r.f fVar = this.J;
            if (fVar == null || fVar.O() == null || this.J.O().J() == null) {
                return null;
            }
            return this.J.O().J();
        }
        return (MetaData) invokeV.objValue;
    }

    public boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.Z0 : invokeV.booleanValue;
    }

    public boolean s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            if (v1() && this.J.y().b() == 0) {
                B1(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public boolean t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) ? this.Z : invokeV.booleanValue;
    }

    public boolean t2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048712, this, str)) == null) {
            this.m = !this.m;
            this.f52417h = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (Z1(6)) {
                return true;
            }
            this.m = !this.m;
            return false;
        }
        return invokeL.booleanValue;
    }

    public int u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.a1 : invokeV.intValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.P0 && b.a.r0.x0.l.b() != null && b.a.r0.x0.l.b().equals(this.f52415f) && b.a.r0.x0.l.a() != null : invokeV.booleanValue;
    }

    public boolean u2(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048715, this, z, str)) == null) {
            if (this.m == z) {
                return false;
            }
            this.m = z;
            this.f52417h = str;
            if (this.p == 2) {
                this.f52417h = "";
            }
            if (z) {
                TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
            }
            if (Z1(6)) {
                return true;
            }
            this.m = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public final boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            int i2 = this.p;
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public boolean v2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048718, this, i2)) == null) {
            if (i2 == this.p) {
                return false;
            }
            if (i2 != 1) {
                b.a.q0.s.e0.b.j().v("key_pb_current_sort_type", i2);
            }
            boolean z = this.o;
            this.n = z;
            this.q = this.p;
            this.p = i2;
            this.o = !z;
            if (i2 == 2 && this.D) {
                this.f52417h = "0";
            }
            if (this.isLoading || !loadData()) {
                this.o = !this.o;
                this.p = this.q;
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.P : invokeV.booleanValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? P0() != null && P0().s0() : invokeV.booleanValue;
    }

    public final void w2(@NonNull b.a.r0.k2.r.f fVar) {
        b.a.r0.k2.r.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048721, this, fVar) == null) || (fVar2 = this.J) == null) {
            return;
        }
        fVar2.e().clear();
        this.J.e().addAll(fVar.e());
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? "hot_topic".equals(this.mStType) : invokeV.booleanValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            int i2 = this.E0;
            return i2 == 13 || i2 == 12 || i2 == 7 || i2 == 23 || i2 == 24;
        }
        return invokeV.booleanValue;
    }

    public void x2(UserPendantData userPendantData) {
        b.a.r0.k2.r.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048724, this, userPendantData) == null) || userPendantData == null || (fVar = this.J) == null || fVar.F() == null || this.J.F().size() <= 0) {
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

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) ? O0() == 3 || P0() == null || P0().O() == null || !P0().O().l2() : invokeV.booleanValue;
    }

    public void y2(b.a.r0.k2.r.f fVar, ArrayList<PostData> arrayList) {
        String G0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048728, this, fVar, arrayList) == null) || arrayList == null || fVar.F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(fVar.F(), 0);
        if (postData != null && (G0 = G0(arrayList)) != null && G0.equals(postData.G())) {
            fVar.F().remove(postData);
        }
        this.J.Z = arrayList.size();
        arrayList.addAll(fVar.F());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.f52415f : (String) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) ? this.D : invokeV.booleanValue;
    }

    public boolean z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048731, this, str)) == null) {
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

    public void z2(b.a.r0.k2.r.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048732, this, fVar) == null) || fVar == null) {
            return;
        }
        fVar.N0(this.J.X());
        b.a.r0.k2.r.f fVar2 = this.J;
        if (!fVar2.X && fVar.X && fVar2.i() != null) {
            fVar.B0(this.J.i());
        }
        this.J = fVar;
        W1(fVar.y().a());
    }
}
