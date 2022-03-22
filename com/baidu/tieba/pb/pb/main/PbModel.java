package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import c.a.d.f.p.m;
import c.a.d.f.p.n;
import c.a.o0.r.r.z0;
import c.a.p0.a4.k0.o;
import c.a.p0.l3.z;
import c.a.p0.w2.i.s;
import c.a.p0.w2.i.x;
import c.a.p0.w2.m.f.i0;
import c.a.p0.w2.m.f.k0;
import c.a.p0.w2.m.f.s0;
import c.a.p0.w2.m.f.t;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BdToken.BdUniDispatchSchemeController;
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
import com.baidu.tbadk.core.data.ThreadData;
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
import com.baidu.tieba.pb.PbPageRequestMessage;
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
/* loaded from: classes5.dex */
public class PbModel extends DataModel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DB_KEY_HOST = "_host";
    public static final String DB_KEY_HOT = "_hot";
    public static final String DB_KEY_REVER = "_rev";
    public static final int MIN_NUM_SHOW_GO_BACK_ITEM = 3;
    public static final String SHOUBAI = "shoubai";
    public static final int SORT_TYPE_ASC = 0;
    public static final int SORT_TYPE_DESC = 1;
    public static final int SORT_TYPE_HOT = 2;
    public static final String UNIDISPATCH_PB = "unidispatch/pb";
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECTPAGE = 5;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    public static int UPGRADE_TO_PHOTO_LIVE = 0;
    public static final String WISE = "wise";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public GetSugMatchWordsModel A0;
    public boolean B;
    public boolean B0;
    public boolean C;
    public int C0;
    public long D;
    public String D0;
    public boolean E;
    public PostData E0;
    public String F;
    public PostData F0;
    public c.a.p0.w2.i.f G;
    public int G0;
    public int H;
    public int H0;
    public int I;
    public boolean I0;
    public boolean J;
    public Rect J0;
    public boolean K;
    public int K0;
    public boolean L;
    public String L0;
    public boolean M;
    public o M0;
    public String N;
    public boolean N0;
    public Context O;
    public String O0;
    public g P;
    public String P0;
    public String Q;
    public int Q0;
    public String R;
    public String R0;
    public String S;
    public String S0;
    public String T;
    public String T0;
    public int U;
    public String U0;
    public int V;
    public String V0;
    public boolean W;
    public String W0;
    public c.a.p0.a4.m0.b X;
    public boolean X0;
    public BaseFragmentActivity Y;
    public int Y0;
    public boolean Z;
    public String Z0;
    public int a;
    public int a1;

    /* renamed from: b  reason: collision with root package name */
    public String f34970b;
    public boolean b1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34971c;
    public boolean c1;

    /* renamed from: d  reason: collision with root package name */
    public String f34972d;
    public String d1;

    /* renamed from: e  reason: collision with root package name */
    public String f34973e;
    public String e1;

    /* renamed from: f  reason: collision with root package name */
    public String f34974f;
    public String f1;

    /* renamed from: g  reason: collision with root package name */
    public String f34975g;
    public boolean g0;
    public boolean g1;

    /* renamed from: h  reason: collision with root package name */
    public String f34976h;
    public long h0;
    public boolean h1;
    public boolean i;
    public boolean i0;
    public boolean i1;
    public boolean isLoading;
    public boolean j;
    public boolean j0;
    public boolean j1;
    public boolean k;
    public String k0;
    public boolean k1;
    public boolean l;
    public String l0;
    public boolean l1;
    public int m;
    public long m0;
    public int m1;
    public String mStType;
    public String mTopicId;
    public String mTopicSubjectName;
    public int n;
    public boolean n0;
    public String n1;
    public boolean o;
    public int o0;
    public boolean o1;
    public int p;
    public boolean p0;
    public BdUniDispatchSchemeController.b p1;
    public int q;
    public boolean q0;
    public CustomMessageListener q1;
    public long r;
    public int r0;
    public c.a.d.c.g.a r1;
    public int s;
    public c.a.p0.w2.i.d s0;
    public CustomMessageListener s1;
    public int t;
    public final i0 t0;
    public CustomMessageListener t1;
    public int u;
    public final t u0;
    public PraiseData u1;
    public int v;
    public final k0 v0;
    public boolean w;
    public String w0;
    public boolean x;
    public final CheckRealNameModel x0;
    public boolean y;
    public final AddExperiencedModel y0;
    public boolean z;
    public SuggestEmotionModel z0;

    /* loaded from: classes5.dex */
    public class a implements BdUniDispatchSchemeController.b {
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pbModel;
        }

        @Override // com.baidu.tbadk.BdToken.BdUniDispatchSchemeController.b
        public void a(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_TID) instanceof String) {
                this.a.f34970b = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID) instanceof String) {
                this.a.O0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.P0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.Q0 = c.a.d.f.m.b.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.R0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(PbModel pbModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i)};
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
            if (this.a.S0() == null || this.a.S0().l() == null || this.a.S0().l().getSignData() == null || !signData.forumId.equals(this.a.S0().m())) {
                return;
            }
            this.a.S0().l().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes5.dex */
    public class c extends c.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PbModel pbModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = pbModel;
        }

        @Override // c.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            long j;
            boolean z;
            boolean z2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z3 = responsedMessage instanceof pbPageSocketResponseMessage;
                if (z3 || (responsedMessage instanceof pbPageHttpResponseMessage)) {
                    if (responsedMessage.getOrginalMessage().getSelf() instanceof PbPageRequestMessage) {
                        PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getSelf();
                        z = pbPageRequestMessage.isFromPbOptimize();
                        j = pbPageRequestMessage.get_kz();
                    } else {
                        j = 0;
                        z = false;
                    }
                    if (responsedMessage.getOrginalMessage().getTag() == this.a.getUniqueId() || (c.a.p0.w2.l.a.a().d() && z && c.a.d.f.m.b.g(this.a.f34970b, 0L) == j)) {
                        if (responsedMessage.hasError() && responsedMessage.getError() != 4 && l.z()) {
                            this.a.Y.showToast(responsedMessage.getErrorString());
                        }
                        if (z3) {
                            this.a.Z1((pbPageSocketResponseMessage) responsedMessage);
                        }
                        if (responsedMessage instanceof pbPageHttpResponseMessage) {
                            this.a.Y1((pbPageHttpResponseMessage) responsedMessage);
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (responsedMessage.getError() != 0) {
                            long j2 = z2 ? 0L : ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                            PbPageRequestMessage pbPageRequestMessage2 = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                            long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                            int cmd = responsedMessage.getOrginalMessage().getCmd();
                            int error = responsedMessage.getError();
                            String errorString = responsedMessage.getErrorString();
                            Object[] objArr = new Object[6];
                            objArr[0] = "updateType";
                            objArr[1] = pbPageRequestMessage2 != null ? String.valueOf(pbPageRequestMessage2.getUpdateType()) : null;
                            objArr[2] = "ThreadId";
                            objArr[3] = pbPageRequestMessage2 != null ? String.valueOf(pbPageRequestMessage2.get_kz()) : null;
                            objArr[4] = "seq_id";
                            objArr[5] = Long.valueOf(j2);
                            c.a.o0.r.d0.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                        }
                        if (this.a.Z && this.a.g0) {
                            return;
                        }
                        if (!this.a.Z) {
                            this.a.Z = true;
                        } else {
                            this.a.g0 = true;
                        }
                        if (this.a.P != null) {
                            this.a.P.a(this.a.U0(), z2, responsedMessage, this.a.i0, System.currentTimeMillis() - this.a.h0);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PbModel pbModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i)};
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
            this.a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                c.a.p0.w2.i.f fVar = this.a.G;
                if (fVar == null || fVar.h() == null || this.a.G.h().c() == null || !this.a.G.h().c().equals(valueOf)) {
                    return;
                }
                this.a.G.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PbModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(PbModel pbModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i)};
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
            this.a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                c.a.p0.w2.i.f fVar = this.a.G;
                if (fVar == null || fVar.h() == null || this.a.G.h().c() == null || !this.a.G.h().c().equals(valueOf)) {
                    return;
                }
                this.a.G.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.p0.w2.i.f a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PbModel f34977b;

        public f(PbModel pbModel, c.a.p0.w2.i.f fVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, fVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34977b = pbModel;
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34977b.b2(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.f34977b.isLoading = false;
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface g {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(c.a.p0.w2.i.f fVar);

        void c(boolean z, int i, int i2, int i3, c.a.p0.w2.i.f fVar, String str, int i4);
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
        int a2 = c.a.o0.t.d.a() / 30;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((c.a.d.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 4;
        this.mStType = null;
        this.f34970b = null;
        this.f34971c = false;
        this.f34972d = null;
        this.f34973e = null;
        this.f34975g = null;
        this.f34976h = "";
        this.i = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = 0;
        this.n = 0;
        this.o = false;
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
        this.mTopicId = "";
        this.mTopicSubjectName = "";
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = false;
        this.N = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = -1;
        this.V = -1;
        this.X = null;
        this.Z = false;
        this.g0 = false;
        this.k0 = null;
        this.l0 = null;
        this.m0 = 0L;
        this.n0 = false;
        this.o0 = -1;
        this.q0 = false;
        this.B0 = false;
        this.C0 = 0;
        this.K0 = 0;
        this.N0 = false;
        this.Y0 = 3;
        this.a1 = 0;
        this.j1 = false;
        this.k1 = false;
        this.l1 = false;
        this.m1 = -1;
        this.n1 = null;
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
        c.a.p0.w2.i.f fVar = new c.a.p0.w2.i.f();
        this.G = fVar;
        fVar.y0(0);
        this.O = baseFragmentActivity.getPageContext().getPageActivity();
        this.Y = baseFragmentActivity;
        this.t0 = new i0();
        this.u0 = new t(this, this.Y);
        this.v0 = new k0(this, this.Y);
        this.x0 = new CheckRealNameModel(this.Y.getPageContext());
        this.z0 = new SuggestEmotionModel();
        this.y0 = new AddExperiencedModel(this.Y.getPageContext());
        this.p1 = new a(this);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k0 : (String) invokeV.objValue;
    }

    public boolean A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "hot_topic".equals(this.mStType) : invokeV.booleanValue;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.X0 : invokeV.booleanValue;
    }

    public void A2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.a = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34970b : (String) invokeV.objValue;
    }

    public boolean B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.W : invokeV.booleanValue;
    }

    public boolean B2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            this.s = i;
            if (i > this.G.y().h()) {
                this.s = this.G.y().h();
            }
            if (this.s < 1) {
                this.s = 1;
            }
            if (this.f34970b == null) {
                return false;
            }
            return k2(5);
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f1 : (String) invokeV.objValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.N0 && c.a.p0.f1.l.b() != null && c.a.p0.f1.l.b().equals(this.f34970b) && c.a.p0.f1.l.a() != null : invokeV.booleanValue;
    }

    public c.a.p0.w2.i.f C2(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, fVar)) == null) {
            if (fVar == null) {
                return null;
            }
            ThreadData O = fVar.O();
            O.setIs_good(this.p);
            O.setIs_top(this.q);
            long j = this.r;
            if (j > 0) {
                O.setLast_time_int(j);
            }
            e0(O);
            return fVar;
        }
        return (c.a.p0.w2.i.f) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.d1 : (String) invokeV.objValue;
    }

    public int D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.p : invokeV.intValue;
    }

    public final boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            int i = this.m;
            return i == 0 || i == 2;
        }
        return invokeV.booleanValue;
    }

    public void D2(boolean z) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048591, this, z) == null) || (fVar = this.G) == null) {
            return;
        }
        fVar.C0(z);
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e1 : (String) invokeV.objValue;
    }

    public boolean E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null) {
                return false;
            }
            return fVar.r();
        }
        return invokeV.booleanValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.l1 : invokeV.booleanValue;
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (D1() && this.G.y().b() == 0) {
                K1(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData F(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, str)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null || fVar.O() == null || this.G.l() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.G.O().isMutiForumThread()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.G.l().getId());
                writeData.setForumName(this.G.l().getName());
            }
            writeData.setFromForumId(this.f34974f);
            writeData.sourceFrom = String.valueOf(this.C0);
            writeData.setThreadId(this.f34970b);
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

    public boolean F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.o : invokeV.booleanValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? S0() != null && S0().s0() : invokeV.booleanValue;
    }

    public boolean F2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            this.j = !this.j;
            this.f34972d = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (k2(6)) {
                return true;
            }
            this.j = !this.j;
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.x : invokeV.booleanValue;
    }

    public boolean G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int i = this.C0;
            return i == 13 || i == 12 || i == 7 || i == 23 || i == 24;
        }
        return invokeV.booleanValue;
    }

    public boolean G2(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048602, this, z, str)) == null) {
            if (this.j == z) {
                return false;
            }
            this.j = z;
            this.f34972d = str;
            if (this.m == 2) {
                this.f34972d = "";
            }
            if (z) {
                TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
            }
            if (k2(6)) {
                return true;
            }
            this.j = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.c1 : invokeV.booleanValue;
    }

    public int H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.q : invokeV.intValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? R0() == 3 || S0() == null || S0().O() == null || !S0().O().isMutiForumThread() : invokeV.booleanValue;
    }

    public boolean H2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            if (i == this.m) {
                return false;
            }
            if (i != 1) {
                c.a.o0.r.j0.b.k().w("key_pb_current_sort_type", i);
            }
            boolean z = this.l;
            this.k = z;
            this.n = this.m;
            this.m = i;
            this.l = !z;
            if (i == 2 && this.A) {
                this.f34972d = "0";
            }
            if (this.isLoading || !loadData()) {
                this.l = !this.l;
                this.m = this.n;
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) ? this.g1 : invokeV.booleanValue;
    }

    public boolean I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null) {
                return false;
            }
            return fVar.q0();
        }
        return invokeV.booleanValue;
    }

    public boolean I1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
            if (S0() != null && S0().O() != null && S0().O().getAuthor() != null && !StringUtils.isNull(str)) {
                String userId = S0().O().getAuthor().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void I2(@NonNull c.a.p0.w2.i.f fVar) {
        c.a.p0.w2.i.f fVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048610, this, fVar) == null) || (fVar2 = this.G) == null) {
            return;
        }
        fVar2.e().clear();
        this.G.e().addAll(fVar.e());
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? Q1() : invokeV.booleanValue;
    }

    public final String J0(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                PostData postData = (PostData) ListUtils.getItem(arrayList, i);
                if (postData != null && !StringUtils.isNull(postData.G())) {
                    return postData.G();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void J1(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, forumData, cVar) == null) {
            str = "";
            if (forumData != null) {
                String id = !TextUtils.isEmpty(forumData.getId()) ? forumData.getId() : "";
                str2 = TextUtils.isEmpty(forumData.getName()) ? "" : forumData.getName();
                str = id;
            } else {
                str2 = "";
            }
            this.z0.B(str, str2, cVar);
        }
    }

    public void J2(UserPendantData userPendantData) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048614, this, userPendantData) == null) || userPendantData == null || (fVar = this.G) == null || fVar.F() == null || this.G.F().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.G.F().size();
        for (int i = 0; i < size; i++) {
            if (this.G.F().get(i) != null && this.G.F().get(i).s() != null && currentAccount.equals(this.G.F().get(i).s().getUserId()) && this.G.F().get(i).s().getPendantData() != null) {
                this.G.F().get(i).s().getPendantData().setImgUrl(userPendantData.getImgUrl());
                this.G.F().get(i).s().getPendantData().setPropsId(userPendantData.getPropsId());
            }
        }
    }

    public int K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.H0 : invokeV.intValue;
    }

    public boolean K1(boolean z) {
        InterceptResult invokeZ;
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048616, this, z)) == null) {
            if (this.f34970b == null || (fVar = this.G) == null) {
                return false;
            }
            if (z || fVar.y().b() != 0) {
                return k2(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void K2(c.a.p0.w2.i.f fVar, ArrayList<PostData> arrayList) {
        String J0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048617, this, fVar, arrayList) == null) || arrayList == null || fVar.F() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(fVar.F(), 0);
        if (postData != null && (J0 = J0(arrayList)) != null && J0.equals(postData.G())) {
            fVar.F().remove(postData);
        }
        this.G.Z = arrayList.size();
        arrayList.addAll(fVar.F());
    }

    public int L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.G0 : invokeV.intValue;
    }

    public void L1(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048619, this, fVar) == null) || fVar == null) {
            return;
        }
        this.f34970b = fVar.Q();
        if (fVar.O() != null && fVar.O().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = fVar.O().getBaijiahaoData();
            this.O0 = baijiahaoData.oriUgcNid;
            this.P0 = baijiahaoData.oriUgcTid;
            this.Q0 = baijiahaoData.oriUgcType;
            this.R0 = baijiahaoData.oriUgcVid;
        } else {
            this.O0 = null;
            this.P0 = null;
            this.Q0 = 0;
            this.R0 = null;
        }
        this.f34972d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public void L2(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, fVar) == null) || fVar == null) {
            return;
        }
        fVar.N0(this.G.X());
        c.a.p0.w2.i.f fVar2 = this.G;
        if (!fVar2.X && fVar.X && fVar2.i() != null) {
            fVar.B0(this.G.i());
        }
        this.G = fVar;
        h2(fVar.y().a());
    }

    public MarkData M0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f34970b);
            markData.setPostId(postData.G());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(D1()));
            markData.setId(this.f34970b);
            markData.setFloor(postData.A());
            markData.setForumId(this.f34973e);
            boolean z = true;
            if (postData instanceof c.a.p0.w2.i.c) {
                markData.setApp(true);
            } else if (postData instanceof o) {
                o oVar = (o) postData;
                markData.setApp((oVar.getAdvertAppInfo() == null || !oVar.getAdvertAppInfo().i()) ? false : false);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void M1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048622, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f34970b = str;
        this.f34972d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public String N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null || !fVar.r()) {
                return null;
            }
            return this.G.u();
        }
        return (String) invokeV.objValue;
    }

    public boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.f34970b == null || this.f34972d == null) {
                return false;
            }
            cancelMessage();
            if (this.A) {
                return k2(4);
            }
            return k2(6);
        }
        return invokeV.booleanValue;
    }

    public k0 O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.v0 : (k0) invokeV.objValue;
    }

    public boolean O1(boolean z) {
        InterceptResult invokeZ;
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048626, this, z)) == null) {
            if (this.f34970b == null || (fVar = this.G) == null || ((!z && fVar.y().c() == 0) || this.G.F() == null || this.G.F().size() < 1)) {
                return false;
            }
            return k2(2);
        }
        return invokeZ.booleanValue;
    }

    public final String P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            String str = "";
            if (this.O0 != null) {
                str = "" + this.O0;
            }
            if (this.P0 != null) {
                str = str + this.P0;
            }
            String str2 = str + this.Q0;
            if (this.R0 != null) {
                return str2 + this.R0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void P1(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.A0 == null) {
            this.A0 = new GetSugMatchWordsModel(this.Y.getPageContext());
        }
        this.A0.A(bVar);
    }

    public z0 Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null) {
                return null;
            }
            return fVar.y();
        }
        return (z0) invokeV.objValue;
    }

    public boolean Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            String str = this.f34972d;
            if (str != null && !str.equals("0") && this.f34972d.length() != 0) {
                return N1();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public int R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.C0 : invokeV.intValue;
    }

    public final void R1() {
        c.a.p0.a4.m0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048632, this) == null) || (bVar = this.X) == null) {
            return;
        }
        bVar.a();
        this.X = null;
    }

    public c.a.p0.w2.i.f S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.G : (c.a.p0.w2.i.f) invokeV.objValue;
    }

    public void S1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048634, this) == null) || !"personalize_page".equals(this.mStType) || this.G == null || this.m0 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        TiebaStatic.log(new StatisticItem("c10754").param("fid", this.G.m()).param("tid", this.f34970b).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.m0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
        this.m0 = 0L;
    }

    public c.a.p0.w2.i.f T0() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null) {
                return fVar;
            }
            if (!s1() && (oVar = this.M0) != null) {
                this.G.G0(oVar);
            }
            return this.G;
        }
        return (c.a.p0.w2.i.f) invokeV.objValue;
    }

    public void T1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048636, this) == null) && "personalize_page".equals(this.mStType)) {
            this.m0 = System.currentTimeMillis() / 1000;
        }
    }

    public int U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? !TextUtils.isEmpty(this.f34976h) : invokeV.booleanValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.w0 : (String) invokeV.objValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) ? !TextUtils.isEmpty(this.f34975g) : invokeV.booleanValue;
    }

    public void W(z0 z0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, z0Var) == null) {
            if (z0Var == null) {
                h2(1);
                return;
            }
            if (this.t < z0Var.a()) {
                this.t = z0Var.a();
            }
            if (this.u > z0Var.a()) {
                this.u = z0Var.a();
            }
            this.v = z0Var.h();
        }
    }

    public String W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? this.L0 : (String) invokeV.objValue;
    }

    public void W1(c.a.p0.w2.i.f fVar, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048643, this, fVar, i, str) == null) {
            this.j0 = true;
            if (fVar == null || fVar.f19821h != null) {
                return;
            }
            L2(fVar);
            c0(fVar);
            if (fVar.O() != null) {
                fVar.O().setCopyThreadRemindType(0);
            }
            g gVar = this.P;
            if (gVar == null || fVar == null) {
                return;
            }
            gVar.c(true, 0, i, 0, fVar, str, 0);
        }
    }

    public final void X(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048644, this, fVar) == null) || fVar == null || fVar.z() == null || fVar.z().getAdvertAppInfo() == null || !fVar.z().N0() || fVar.z().getAdvertAppInfo().f29816c == 1001) {
            return;
        }
        this.M0 = fVar.z();
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.U0 : (String) invokeV.objValue;
    }

    public void X1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i) == null) {
            c2(i);
            ArrayList<PostData> F = this.G.F();
            boolean z = false;
            this.i0 = false;
            if (i != 1) {
                if (i == 2) {
                    while (F.size() + 30 > c.a.o0.t.d.a()) {
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
            while (F.size() + 30 > c.a.o0.t.d.a()) {
                F.remove(0);
                z2 = true;
            }
            if (z2) {
                this.G.y().m(1);
                g gVar = this.P;
                if (gVar != null) {
                    gVar.b(this.G);
                }
            }
            this.h0 = System.currentTimeMillis();
            this.i0 = true;
        }
    }

    public void Y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048647, this) == null) {
            this.M0 = null;
        }
    }

    public String Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public void Y1(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048649, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.s0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            a2(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void Z() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048650, this) == null) {
            this.f34976h = "";
        }
    }

    public String Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.T0 : (String) invokeV.objValue;
    }

    public void Z1(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048652, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.s0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            a2(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            return (fVar == null || fVar.l() == null || this.G.O() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void a0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            this.f34975g = null;
        }
    }

    public String a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.S0 : (String) invokeV.objValue;
    }

    public void a2(c.a.p0.w2.i.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        c.a.p0.w2.i.f fVar2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048656, this, new Object[]{fVar, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i4 = i2;
                fVar2 = null;
            } else {
                fVar2 = fVar;
                i4 = i2;
            }
            this.r0 = i4;
            this.isLoading = false;
            if (fVar2 != null) {
                c0(fVar2);
            }
            X(fVar2);
            o oVar = this.M0;
            if (oVar != null && oVar.N0()) {
                TiebaStatic.log(c.a.p0.z3.a.h("a005", "common_fill", true, 1));
            }
            b2(fVar2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    public void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048657, this, str) == null) {
            if ((!this.j || I1(TbadkCoreApplication.getCurrentAccount())) && this.G.F() != null) {
                this.G.y().l(1);
                if (this.G.y().b() == 0) {
                    this.G.y().l(1);
                }
                this.D0 = str;
                k2(8);
            }
        }
    }

    public int b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar != null) {
                return fVar.L();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void b2(c.a.p0.w2.i.f fVar, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048659, this, new Object[]{fVar, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.p0 = z3;
            c.a.p0.a4.m0.b bVar = this.X;
            if (bVar != null && !z3) {
                bVar.b(z2, z4, i2, str, i3, j, j2);
                this.X = null;
            }
            c.a.p0.w2.i.f fVar2 = this.G;
            if (fVar2 != null) {
                fVar2.a0 = z3;
                fVar2.b0 = i;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(s0()) && z.q().b() != null) {
                z.q().b().g(s0(), g2(c1()), true);
            }
            if (fVar != null && (this.s != 1 || i != 5 || fVar.F() == null || fVar.F().size() >= 1)) {
                this.k = this.l;
                if (i != 8) {
                    this.n = this.m;
                    this.m = fVar.f19820g;
                }
                List<PbSortType> list = fVar.f19819f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.Y.getResources().getString(R.string.obfuscated_res_0x7f0f047e);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    fVar.f19819f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.Y.getResources().getString(R.string.obfuscated_res_0x7f0f1506);
                    builder2.sort_type = 1;
                    fVar.f19819f.add(builder2.build(false));
                    int i6 = this.n;
                    this.m = i6;
                    fVar.f19820g = i6;
                }
                this.E = false;
                if (fVar.y() != null && (this.m != 2 || i != 8)) {
                    W(fVar.y());
                }
                int i7 = this.v;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.v = i7;
                ArrayList<PostData> F = this.G.F();
                switch (i) {
                    case 1:
                        this.G.F0(fVar.y(), 1);
                        K2(fVar, F);
                        I2(fVar);
                        i4 = 0;
                        break;
                    case 2:
                        if (fVar.F() != null) {
                            i4 = fVar.F().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(F, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(fVar.F(), ListUtils.getCount(fVar.F()) - 1);
                            if (postData != null && postData2 != null && postData.G().equals(postData2.G())) {
                                fVar.F().remove(postData2);
                                i4--;
                            }
                            F.addAll(0, fVar.F());
                        } else {
                            i4 = 0;
                        }
                        I2(fVar);
                        this.G.F0(fVar.y(), 2);
                        break;
                    case 3:
                        if (this.m == 1 && fVar.y() != null) {
                            fVar.y().k(fVar.y().h());
                        }
                        L2(fVar);
                        i4 = 0;
                        break;
                    case 4:
                        L2(fVar);
                        i4 = 0;
                        break;
                    case 5:
                        L2(fVar);
                        i4 = 0;
                        break;
                    case 6:
                        L2(fVar);
                        i4 = 0;
                        break;
                    case 7:
                        L2(fVar);
                        i4 = 0;
                        break;
                    case 8:
                        if (fVar == null || ListUtils.isEmpty(fVar.F()) || this.G == null || (this.j && !f2(fVar).equals(fVar.F().get(0).s().getUserId()))) {
                            i5 = 0;
                        } else {
                            if (this.G.y().b() == 0) {
                                this.G.y().l(1);
                            }
                            i2();
                            this.E0 = fVar.F().get(0);
                            if (!D1() && !this.G.g0()) {
                                if (this.G0 - this.H0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.F0 = postData3;
                                    postData3.B = false;
                                    postData3.x0(53);
                                    this.G.F().add(0, this.F0);
                                }
                                this.G.F().add(0, this.E0);
                                i5 = 0;
                            } else {
                                if (this.G.F().size() - this.G0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.F0 = postData4;
                                    postData4.B = true;
                                    postData4.x0(53);
                                    this.G.F().add(this.F0);
                                }
                                this.G.F().add(this.E0);
                                i5 = this.G.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(c.a.o0.r.j0.b.k().m("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.E0.R = this.G.J();
                                c.a.o0.r.j0.b.k().x("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        I2(fVar);
                        i4 = i5;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                c.a.p0.w2.i.f fVar3 = this.G;
                if (fVar3 != null && fVar3.O() != null) {
                    PraiseData praise = this.G.O().getPraise();
                    if (this.u1 != null && !praise.isPriaseDataValid()) {
                        this.G.O().setPraise(this.u1);
                    } else {
                        PraiseData praise2 = this.G.O().getPraise();
                        this.u1 = praise2;
                        praise2.setPostId(this.G.O().getFirstPostId());
                    }
                    if (fVar.y() != null && fVar.y().a() == 1 && fVar.O() != null && fVar.O().getActDatas() != null && fVar.O().getActDatas().size() > 0) {
                        this.G.O().setActDatas(fVar.O().getActDatas());
                    }
                    this.G.O().setReply_num(fVar.O().getReply_num());
                    this.G.O().setAnchorLevel(fVar.O().getAnchorLevel());
                    this.G.O().setCopyThreadRemindType(fVar.O().getCopyThreadRemindType());
                    if (this.I == 33) {
                        this.G.O().getAuthor().setHadConcerned(fVar.O().getAuthor().hadConcerned());
                    }
                    if (fVar != null && fVar.O() != null) {
                        this.G.O().updateIsNotitle(fVar.O().getIsNoTitle());
                    }
                }
                c.a.p0.w2.i.f fVar4 = this.G;
                if (fVar4 != null && fVar4.U() != null && fVar.U() != null) {
                    this.G.U().setBimg_end_time(fVar.U().getBimg_end_time());
                    this.G.U().setBimg_url(fVar.U().getBimg_url());
                }
                if (fVar.y() != null && fVar.y().a() == 1 && fVar.W() != null) {
                    this.G.M0(fVar.W());
                }
                if (this.p0) {
                    if (this.G.O() != null && this.G.O().getAuthor() != null && this.G.F() != null && ListUtils.getItem(this.G.F(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.G.F(), 0);
                        MetaData author = this.G.O().getAuthor();
                        if (postData5.s() != null && postData5.s().getGodUserData() != null) {
                            int i8 = this.U;
                            if (i8 != -1) {
                                author.setFansNum(i8);
                                postData5.s().setFansNum(this.U);
                            }
                            if (this.V != -1) {
                                author.getGodUserData().setIsLike(this.V == 1);
                                postData5.s().getGodUserData().setIsLike(this.V == 1);
                                author.getGodUserData().setIsFromNetWork(false);
                                postData5.s().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    c.a.p0.w2.i.f fVar5 = this.G;
                    fVar5.f19818e = -1;
                    fVar5.f19817d = -1;
                }
                g gVar = this.P;
                if (gVar != null) {
                    gVar.c(true, getErrorCode(), i, i4, this.G, this.mErrorString, 1);
                }
            } else if (this.P != null) {
                this.l = this.k;
                if (i2 != 350006) {
                    this.m = this.n;
                }
                this.P.c(false, i2, i, 0, null, str, 1);
            }
            c.a.p0.w2.i.f fVar6 = this.G;
            if (fVar6 == null || fVar6.O() == null || this.G.l() == null || this.G.g0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.Y.getPageContext();
            historyMessage.threadId = S0().O().getId();
            if (this.I0 && S0().O().originalThreadData != null) {
                historyMessage.threadName = S0().O().originalThreadData.f29822b;
            } else {
                historyMessage.threadName = S0().O().getTitle();
            }
            if (this.I0 && !H1()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = S0().l().getName();
            }
            historyMessage.isHostOnly = w0();
            historyMessage.isSquence = i1();
            historyMessage.threadType = S0().O().getThreadType();
            historyMessage.isShareThread = this.I0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public void c0(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048660, this, fVar) == null) || fVar == null) {
            return;
        }
        if (this.L || this.J || this.K) {
            fVar = C2(fVar);
        }
        d2(fVar);
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.H : invokeV.intValue;
    }

    public final void c2(int i) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048662, this, i) == null) || i == 8) {
            return;
        }
        this.D0 = "";
        if (this.E0 != null) {
            if (i == 1 && (fVar = this.G) != null && fVar.g0()) {
                if (this.F0 != null) {
                    S0().F().remove(this.F0);
                }
            } else if (i == 1 && !this.l && !ListUtils.isEmpty(S0().F())) {
                S0().F().remove(this.E0);
                if (this.F0 != null) {
                    S0().F().remove(this.F0);
                }
                S0().F().add(0, this.E0);
            } else {
                S0().F().remove(this.E0);
                if (this.F0 != null) {
                    S0().F().remove(this.F0);
                }
            }
        }
        this.F0 = null;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public c.a.p0.w2.i.f d0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048664, this, threadData)) == null) {
            c.a.p0.w2.i.f fVar = new c.a.p0.w2.i.f();
            fVar.y0(3);
            if (threadData == null) {
                return null;
            }
            fVar.K0(threadData);
            if (threadData.getForumData() != null) {
                fVar.z0(threadData.getForumData());
                ForumData l = fVar.l();
                l.setId(threadData.getForumData().c());
                l.setName(threadData.getForumData().a());
                l.setUser_level(threadData.getForumData().e());
                l.setImage_url(threadData.getForumData().b());
                l.setPost_num(threadData.getForumData().f10997h);
                l.setMember_num(threadData.getForumData().i);
            } else {
                ForumData l2 = fVar.l();
                l2.setId(String.valueOf(threadData.getFid()));
                l2.setName(threadData.getForum_name());
            }
            PostData postData = new PostData();
            postData.n0(1);
            postData.C0(threadData.getCreateTime());
            postData.l0(threadData.getAuthor());
            MetaData author = threadData.getAuthor();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(author.getUserId(), author);
            postData.E0(hashMap);
            postData.z0(TbRichTextView.V(threadData.getFirstFloorList(), k1(), false));
            fVar.A0(postData);
            fVar.F().add(postData);
            fVar.H0(new s(threadData, null));
            fVar.m = true;
            fVar.D0(1);
            return fVar;
        }
        return (c.a.p0.w2.i.f) invokeL.objValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? D1() : invokeV.booleanValue;
    }

    public void d2(c.a.p0.w2.i.f fVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048666, this, fVar) == null) || fVar == null) {
            return;
        }
        String f2 = f2(fVar);
        for (int i = 0; i < fVar.F().size(); i++) {
            PostData postData = fVar.F().get(i);
            for (int i2 = 0; i2 < postData.P().size(); i2++) {
                postData.P().get(i2).G0(this.Y.getPageContext(), f2.equals(postData.P().get(i2).s().getUserId()));
            }
        }
        x T = fVar.T();
        if (T == null || ListUtils.isEmpty(T.a)) {
            return;
        }
        for (PostData postData2 : T.a) {
            for (int i3 = 0; i3 < postData2.P().size(); i3++) {
                postData2.P().get(i3).G0(this.Y.getPageContext(), f2.equals(postData2.P().get(i3).s().getUserId()));
            }
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048667, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.unique_id);
            SuggestEmotionModel suggestEmotionModel = this.z0;
            if (suggestEmotionModel != null) {
                suggestEmotionModel.cancelLoadData();
            }
            GetSugMatchWordsModel getSugMatchWordsModel = this.A0;
            if (getSugMatchWordsModel != null) {
                getSugMatchWordsModel.cancelLoadData();
            }
            c.a.p0.l3.m0.b.f().a("PB");
            R1();
        }
    }

    public void e0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = H();
            threadData.tiebaPlusOrderId = D();
            threadData.tiebaPlusToken = E();
            threadData.tiebaPlusExtraParam = E();
            threadData.tiebaplusCantDelete = I();
            threadData.setDispatchedForumIdWithString(y());
        }
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.n1 : (String) invokeV.objValue;
    }

    public void e2(c.a.p0.w2.i.f fVar, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048670, this, fVar, i) == null) || fVar == null) {
            return;
        }
        String f2 = f2(fVar);
        x T = fVar.T();
        if (T == null || ListUtils.isEmpty(T.a)) {
            return;
        }
        List<PostData> list = T.a;
        for (PostData postData : list.subList(i, list.size())) {
            for (int i2 = 0; i2 < postData.P().size(); i2++) {
                postData.P().get(i2).G0(this.Y.getPageContext(), f2.equals(postData.P().get(i2).s().getUserId()));
            }
        }
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.f34970b);
            if (!this.C) {
                sb.append(this.f34972d);
            }
            sb.append(this.j);
            sb.append(this.l);
            sb.append(this.m);
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
            sb.append(this.O0);
            sb.append(this.P0);
            sb.append(this.R0);
            sb.append(this.Q0);
            String str = this.T;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.m1 : invokeV.intValue;
    }

    public String f2(c.a.p0.w2.i.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048673, this, fVar)) == null) {
            String str = null;
            if (fVar == null) {
                return null;
            }
            if (fVar.O() != null && fVar.O().getAuthor() != null) {
                str = fVar.O().getAuthor().getUserId();
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public AddExperiencedModel g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) ? this.y0 : (AddExperiencedModel) invokeV.objValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) ? this.m : invokeV.intValue;
    }

    public final int g2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048676, this, i)) == null) {
            if (i != 1) {
                return i != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.r0 : invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.f34973e : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) ? this.f34974f : (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.mTopicId : (String) invokeV.objValue;
    }

    public final int h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            int i = 0;
            if (S0().F() == null) {
                return 0;
            }
            ArrayList<PostData> F = S0().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                PostData postData = F.get(size);
                if (!(postData instanceof o)) {
                    i++;
                } else if (postData.getType() != AdvertAppInfo.x) {
                    return i;
                }
            }
            return F.size();
        }
        return invokeV.intValue;
    }

    public int h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? this.m : invokeV.intValue;
    }

    public void h2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i) == null) {
            this.s = i;
            this.t = i;
            this.u = i;
        }
    }

    public c.a.p0.w2.i.d i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.s0 : (c.a.p0.w2.i.d) invokeV.objValue;
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) ? D1() : invokeV.booleanValue;
    }

    public void i2() {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048686, this) == null) || (fVar = this.G) == null || ListUtils.isEmpty(fVar.F())) {
            return;
        }
        if (this.F0 != null) {
            this.G.F().remove(this.F0);
            this.F0 = null;
        }
        if (this.E0 != null) {
            this.G.F().remove(this.E0);
            this.E0 = null;
        }
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048687, this, bundle) == null) {
            this.C0 = bundle.getInt("key_start_from", 0);
            this.f34970b = bundle.getString("thread_id");
            this.f34972d = bundle.getString("post_id");
            this.f34973e = bundle.getString("forum_id");
            this.f34974f = bundle.getString("from_forum_id");
            bundle.getString("god_reply_id");
            this.i = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.j = bundle.getBoolean("host_only", false);
            this.l = bundle.getBoolean("squence", true);
            this.m = bundle.getInt("sort_type", 0);
            this.mStType = bundle.getString("st_type");
            this.N = bundle.getString("locate");
            this.p = bundle.getInt("is_good", 0);
            this.q = bundle.getInt("is_top", 0);
            this.r = bundle.getLong("thread_time");
            this.A = bundle.getBoolean("from_mark", false);
            this.C = bundle.getBoolean("is_pb_key_need_post_id", false);
            this.w = bundle.getBoolean("is_ad", false);
            this.x = bundle.getBoolean("is_sub_pb", false);
            this.E = bundle.getBoolean("is_pv", false);
            this.o1 = bundle.getBoolean(PbActivityConfig.KEY_SCHEME_START, false);
            this.j1 = bundle.getBoolean("is_jump_from_video_tab", false);
            this.k1 = bundle.getBoolean("is_jump_from_video_middle", false);
            this.D = bundle.getLong("msg_id", 0L);
            this.F = bundle.getString("from_forum_name");
            this.T = bundle.getString("extra_pb_cache_key");
            this.J = bundle.getBoolean("is_from_thread_config", false);
            this.K = bundle.getBoolean("is_from_interview_live_config", false);
            this.L = bundle.getBoolean("is_from_my_god_config", false);
            this.V = bundle.getInt("extra_pb_is_attention_key", -1);
            this.U = bundle.getInt("extra_pb_funs_count_key", -1);
            this.y = bundle.getBoolean("from_frs", false);
            this.z = bundle.getBoolean("from_maintab", false);
            this.q0 = bundle.getBoolean("from_smart_frs", false);
            this.M = bundle.getBoolean("from_hottopic", false);
            this.I0 = bundle.getBoolean("key_is_share_thread", false);
            this.O0 = bundle.getString("key_ori_ugc_nid");
            this.P0 = bundle.getString("key_ori_ugc_tid");
            this.Q0 = bundle.getInt("key_ori_ugc_type", 0);
            this.X0 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.R0 = bundle.getString("key_ori_ugc_vid");
            this.W = bundle.getInt("request_code", -1) == 18003;
            this.S0 = bundle.getString("key_rec_weight");
            this.T0 = bundle.getString("key_rec_source");
            this.U0 = bundle.getString("key_rec_ab_tag");
            this.V0 = bundle.getString("key_rec_extra");
            this.c1 = bundle.getBoolean("key_is_tieba_plus");
            this.d1 = bundle.getString("key_tieba_plus_order_id");
            this.e1 = bundle.getString("key_tieba_plus_token");
            this.f1 = bundle.getString("key_tieba_extra_param");
            this.g1 = bundle.getBoolean("key_tieba_plus_cant_delete");
            this.h1 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
            Parcelable parcelable = bundle.getParcelable(IntentConfig.KEY_URI);
            if (parcelable instanceof Uri) {
                z2((Uri) parcelable);
            }
        }
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048688, this, intent) == null) || intent == null) {
            return;
        }
        this.f34970b = intent.getStringExtra("thread_id");
        this.f34971c = intent.getBooleanExtra("key_is_privacy", false);
        this.O0 = intent.getStringExtra("key_ori_ugc_nid");
        this.P0 = intent.getStringExtra("key_ori_ugc_tid");
        this.Q0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.R0 = intent.getStringExtra("key_ori_ugc_vid");
        this.X0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.j1 = intent.getBooleanExtra("is_jump_from_video_tab", false);
        this.k1 = intent.getBooleanExtra("is_jump_from_video_middle", false);
        this.Z0 = intent.getStringExtra("key_official_bar_message_id");
        this.o1 = intent.getBooleanExtra(PbActivityConfig.KEY_SCHEME_START, false);
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        z2(uri);
        this.W0 = uri != null ? uri.toString() : null;
        this.b1 = false;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.b1 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.p1);
        } else if (StringUtils.isNull(this.f34970b)) {
            this.b1 = true;
            this.t0.b(intent, this.p1);
            if (uri != null) {
                if (StringUtils.isNull(this.f34970b)) {
                    this.f34970b = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.O0)) {
                    this.O0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.P0)) {
                    this.P0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.Q0 == 0) {
                    this.Q0 = c.a.d.f.m.b.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.R0)) {
                    this.R0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (m.isEmpty(this.f34970b)) {
            this.f34970b = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.C0 = intExtra;
        if (intExtra == 0) {
            this.C0 = this.t0.a;
        }
        this.f34972d = intent.getStringExtra("post_id");
        this.f34973e = intent.getStringExtra("forum_id");
        this.f34974f = intent.getStringExtra("from_forum_id");
        intent.getStringExtra("god_reply_id");
        this.i = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.j = intent.getBooleanExtra("host_only", false);
        this.l = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.m = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = c.a.o0.r.j0.b.k().l("key_pb_current_sort_type", 2);
        }
        this.m = intExtra2;
        this.f34972d = intExtra2 != 2 ? this.f34972d : "0";
        this.mStType = intent.getStringExtra("st_type");
        this.N = intent.getStringExtra("locate");
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
        this.T = intent.getStringExtra("extra_pb_cache_key");
        this.Q = intent.getStringExtra("op_type");
        this.R = intent.getStringExtra("op_url");
        this.S = intent.getStringExtra("op_stat");
        this.J = intent.getBooleanExtra("is_from_thread_config", false);
        this.K = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.L = intent.getBooleanExtra("is_from_my_god_config", false);
        this.V = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.U = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.y = intent.getBooleanExtra("from_frs", false);
        this.z = intent.getBooleanExtra("from_maintab", false);
        this.q0 = intent.getBooleanExtra("from_smart_frs", false);
        this.M = intent.getBooleanExtra("from_hottopic", false);
        this.w0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.I0 = intent.getBooleanExtra("key_is_share_thread", false);
        this.f34975g = intent.getStringExtra("high_light_post_id");
        this.f34976h = intent.getStringExtra(PbCommentFloatActivityConfig.KEY_HIGH_LIGHT_3S_POST_ID);
        this.N0 = intent.getBooleanExtra("key_need_preload", false);
        this.W = intent.getIntExtra("request_code", -1) == 18003;
        this.S0 = intent.getStringExtra("key_rec_weight");
        this.T0 = intent.getStringExtra("key_rec_source");
        this.U0 = intent.getStringExtra("key_rec_ab_tag");
        this.V0 = intent.getStringExtra("key_rec_extra");
        this.c1 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.d1 = intent.getStringExtra("key_tieba_plus_order_id");
        this.e1 = intent.getStringExtra("key_tieba_plus_token");
        this.f1 = intent.getStringExtra("key_tieba_extra_param");
        this.g1 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.h1 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
        if (this.C0 == 17) {
            this.mTopicId = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_ID);
            this.mTopicSubjectName = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_SUBJECT_NAME);
        }
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) ? this.f34971c : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) ? this.I0 : invokeV.booleanValue;
    }

    public MarkData j0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048691, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null) {
                return null;
            }
            ArrayList<PostData> F = fVar.F();
            if (ListUtils.isEmpty(F)) {
                return null;
            }
            if (F.size() > 0 && i >= F.size()) {
                i = F.size() - 1;
            }
            return M0(F.get(i));
        }
        return (MarkData) invokeI.objValue;
    }

    public int j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.K0 : invokeV.intValue;
    }

    public void j2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, bundle) == null) {
            bundle.putString("thread_id", this.f34970b);
            bundle.putString("post_id", this.f34972d);
            bundle.putString("forum_id", this.f34973e);
            bundle.putString("from_forum_id", this.f34974f);
            bundle.putInt("key_start_from", this.C0);
            bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.i);
            bundle.putBoolean("host_only", this.j);
            bundle.putBoolean("squence", this.l);
            bundle.putInt("sort_type", this.m);
            bundle.putString("st_type", this.mStType);
            bundle.putString("locate", this.N);
            bundle.putInt("is_good", this.p);
            bundle.putInt("is_top", this.q);
            bundle.putLong("thread_time", this.r);
            bundle.putBoolean("from_mark", this.A);
            bundle.putBoolean("is_pb_key_need_post_id", this.C);
            bundle.putBoolean("is_sub_pb", this.x);
            bundle.putBoolean("is_ad", this.w);
            bundle.putBoolean("is_pv", this.E);
            bundle.putLong("msg_id", this.D);
            bundle.putString("extra_pb_cache_key", this.T);
            bundle.putInt("thread_type", this.I);
            bundle.putBoolean("is_from_thread_config", this.J);
            bundle.putBoolean("is_from_interview_live_config", this.K);
            bundle.putBoolean("is_from_my_god_config", this.L);
            bundle.putInt("extra_pb_is_attention_key", this.V);
            bundle.putInt("extra_pb_funs_count_key", this.U);
            bundle.putBoolean("from_frs", this.y);
            bundle.putBoolean("from_maintab", this.z);
            bundle.putBoolean("from_smart_frs", this.q0);
            bundle.putBoolean("from_hottopic", this.M);
            bundle.putBoolean("key_is_share_thread", this.I0);
            bundle.putString("key_ori_ugc_nid", this.O0);
            bundle.putString("key_ori_ugc_tid", this.P0);
            bundle.putInt("key_ori_ugc_type", this.Q0);
            bundle.putString("key_ori_ugc_vid", this.R0);
            bundle.putString("key_rec_weight", this.S0);
            bundle.putString("key_rec_source", this.T0);
            bundle.putString("key_rec_ab_tag", this.U0);
            bundle.putString("key_rec_extra", this.V0);
            bundle.putBoolean("key_is_tieba_plus", this.c1);
            bundle.putString("key_tieba_plus_order_id", this.d1);
            bundle.putString("key_tieba_plus_token", this.e1);
            bundle.putString("key_tieba_extra_param", this.f1);
            bundle.putBoolean("key_tieba_plus_cant_delete", this.g1);
            bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.h1);
            bundle.putBoolean("is_jump_from_video_tab", this.j1);
            bundle.putBoolean("is_jump_from_video_middle", this.k1);
        }
    }

    public Rect k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            Rect rect = this.J0;
            this.J0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) ? this.f34970b : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:146:0x0351, code lost:
        if ((r11.u - 1) <= 0) goto L144;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ab A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02af A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02c3 A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0382 A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x039e A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03c9 A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0452 A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0462 A[Catch: Exception -> 0x04bd, TryCatch #0 {Exception -> 0x04bd, blocks: (B:45:0x0107, B:47:0x010b, B:50:0x0115, B:54:0x017e, B:56:0x018e, B:57:0x0191, B:59:0x019e, B:60:0x01a1, B:62:0x01a5, B:63:0x01aa, B:65:0x01ae, B:66:0x01b3, B:68:0x01b7, B:69:0x01c6, B:71:0x01ca, B:72:0x01cd, B:74:0x01d1, B:75:0x01e9, B:79:0x01ff, B:81:0x020c, B:82:0x021e, B:83:0x022e, B:85:0x0235, B:87:0x0239, B:89:0x023d, B:93:0x0251, B:95:0x0258, B:97:0x025f, B:96:0x025c, B:90:0x0241, B:92:0x024e, B:98:0x0264, B:99:0x0278, B:100:0x0292, B:102:0x0296, B:105:0x029b, B:107:0x02a2, B:109:0x02ab, B:113:0x02bf, B:115:0x02c3, B:116:0x02c6, B:110:0x02af, B:112:0x02b6, B:106:0x029f, B:118:0x02cd, B:120:0x02d3, B:122:0x02d9, B:123:0x02e5, B:125:0x02ef, B:127:0x02f5, B:129:0x02fa, B:130:0x0305, B:132:0x030b, B:133:0x0315, B:135:0x0319, B:137:0x0321, B:139:0x032e, B:140:0x0331, B:141:0x0336, B:143:0x0340, B:145:0x0344, B:152:0x0367, B:155:0x036d, B:182:0x03cc, B:158:0x0373, B:160:0x0379, B:161:0x037e, B:163:0x0382, B:165:0x038a, B:166:0x038d, B:169:0x039a, B:171:0x039e, B:172:0x03a8, B:174:0x03ac, B:176:0x03b4, B:178:0x03c1, B:179:0x03c5, B:181:0x03c9, B:148:0x0355, B:183:0x03cf, B:187:0x03f8, B:189:0x0403, B:191:0x0410, B:193:0x041a, B:195:0x0421, B:197:0x0425, B:199:0x042a, B:202:0x042f, B:204:0x0436, B:206:0x0452, B:207:0x045b, B:209:0x0462, B:211:0x046c, B:214:0x0479, B:215:0x047e, B:218:0x048a, B:219:0x048e, B:203:0x0433, B:194:0x041e, B:190:0x040b, B:220:0x04ba), top: B:229:0x0107 }] */
    /* JADX WARN: Removed duplicated region for block: B:230:0x039a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k2(int i) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048696, this, i)) == null) {
            this.H = i;
            int i4 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            X1(i);
            c.a.p0.w2.i.f f2 = s0.b().f();
            if (f2 != null && f2.O() != null) {
                f2.O().setCopyThreadRemindType(0);
                this.l = s0.b().i();
                this.j = s0.b().a();
                this.o = s0.b().c();
                this.E0 = s0.b().g();
                this.F0 = s0.b().h();
                this.G0 = s0.b().d();
                this.J0 = s0.b().k();
                this.K0 = s0.b().j();
                boolean z2 = this.j;
                this.B0 = z2;
                if (z2 || this.A) {
                    this.W = false;
                }
                c.a.d.f.m.e.a().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.j0) {
                l2(q0(), true, this.f34972d, 3);
            }
            if (i == 3 && !this.j0) {
                if (this.A) {
                    l2(q0(), true, this.f34972d, 3);
                } else {
                    l2(q0(), false, this.f34972d, 3);
                }
            }
            this.j0 = false;
            if (c.a.p0.w2.l.a.a().d() && c.a.p0.w2.l.a.a().b()) {
                c.a.p0.w2.l.a.a().e(false);
                return true;
            }
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            pbPageRequestMessage.setIsReqAd(this.M0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(c.a.o0.u.a.o);
            if (this.j || this.A) {
                this.W = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f34970b != null && this.f34970b.length() != 0) {
                pbPageRequestMessage.set_kz(c.a.d.f.m.b.g(this.f34970b, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(this.a);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(n.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(n.i(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                pbPageRequestMessage.setSchemeUrl(this.W0);
                if (!this.l) {
                    pbPageRequestMessage.set_r(1);
                }
                pbPageRequestMessage.set_r(Integer.valueOf(this.m));
                if (this.j) {
                    pbPageRequestMessage.set_lz(1);
                }
                if (this.mStType != null) {
                    pbPageRequestMessage.set_st_type(this.mStType);
                }
                if (this.N != null) {
                    pbPageRequestMessage.setLocate(this.N);
                }
                if (this.E) {
                    pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.D));
                    pbPageRequestMessage.set_message_click("1");
                }
                if (this.W) {
                    pbPageRequestMessage.set_banner(1);
                }
                if (this.Q != null) {
                    pbPageRequestMessage.setOpType(this.Q);
                    pbPageRequestMessage.setOpUrl(this.R);
                    pbPageRequestMessage.setOpStat(c.a.d.f.m.b.e(this.S, 0));
                    pbPageRequestMessage.setOpMessageID(this.D);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.I));
                ArrayList<PostData> F = this.G.F();
                switch (i) {
                    case 1:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        if (!this.A) {
                            if (this.m == 1) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.u - 1));
                                break;
                            } else {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                                z = this.t >= this.v;
                            }
                            if (!this.A || z || this.B) {
                                if (F != null && F.size() > 0) {
                                    size = F.size();
                                    i2 = 1;
                                    while (true) {
                                        i3 = size - i2;
                                        if (i3 >= 0) {
                                            PostData postData = F.get(i3);
                                            if (postData != null) {
                                                String G = postData.G();
                                                this.f34972d = G;
                                                if (StringUtils.isNull(G)) {
                                                }
                                            }
                                            i2++;
                                        }
                                    }
                                    if (this.m == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                                    }
                                }
                                if (this.f34972d == null && this.f34972d.length() > 0) {
                                    pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f34972d, 0L));
                                    if (this.m == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.m == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            s2(pbPageRequestMessage);
                            break;
                        }
                        if (!this.A) {
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
                            if (this.m == 2) {
                            }
                        }
                        if (this.f34972d == null) {
                        }
                        if (this.m == 1) {
                        }
                        s2(pbPageRequestMessage);
                    case 2:
                        if (F != null && F.size() > 0 && F.get(0) != null) {
                            this.f34972d = F.get(0).G();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.A) {
                            if (D1()) {
                                if (this.u - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.u - 1));
                                }
                            } else if (this.t < this.v) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                            }
                        }
                        if (this.f34972d != null && this.f34972d.length() > 0) {
                            pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f34972d, 0L));
                            if (this.m == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        s2(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.A && !this.j) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!D1()) {
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
                            w2(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!D1()) {
                        }
                        if (this.A) {
                        }
                        w2(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f34972d, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        s2(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.s));
                        pbPageRequestMessage.set_banner(0);
                        s2(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.m == 1 && this.B0 && !this.j) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.f34972d, 0L));
                            if (this.m == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        pbPageRequestMessage.set_back(0);
                        if (this.j) {
                            pbPageRequestMessage.set_banner(0);
                        } else {
                            pbPageRequestMessage.set_banner(1);
                        }
                        s2(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.o0);
                        s2(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(c.a.d.f.m.b.g(this.D0, 0L));
                        if (this.m == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.B0 = this.j;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.A));
                pbPageRequestMessage.setCacheKey(q0());
                pbPageRequestMessage.setObjParam1(String.valueOf(this.C0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.n0);
                pbPageRequestMessage.setFromSmartFrs(this.q0 ? 1 : 0);
                if (UtilHelper.isUgcThreadType(this.Q0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.f34973e);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.i);
                if (this.C0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.C0 != 7 && this.C0 != 5 && !this.b1) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.O0);
                    pbPageRequestMessage.setOriUgcTid(this.P0);
                    pbPageRequestMessage.setOriUgcType(this.Q0);
                    pbPageRequestMessage.setOriUgcVid(this.R0);
                    if (!StringUtils.isNull(this.Z0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.Z0));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            i4 = pbPageRequestMessage.getPn().intValue() == this.v ? -1 : h0();
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i4 = h0();
                            }
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i4);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.a1);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.setReqFoldComment(this.i1);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f34970b);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.O0);
                pbPageRequestMessage.setOriUgcTid(this.P0);
                pbPageRequestMessage.setOriUgcType(this.Q0);
                pbPageRequestMessage.setOriUgcVid(this.R0);
                if (!StringUtils.isNull(this.Z0)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i4);
                pbPageRequestMessage.setImmersionVideoCommentSource(this.a1);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.setReqFoldComment(this.i1);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f34970b);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public BaijiahaoData l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null || fVar.O() == null) {
                return null;
            }
            return this.G.O().getBaijiahaoData();
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public String l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            if (!StringUtils.isNull(this.f34970b) && !"0".equals(this.f34970b)) {
                return this.f34970b;
            }
            return this.O0;
        }
        return (String) invokeV.objValue;
    }

    public final void l2(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048699, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            if (this.f34970b == null) {
                return false;
            }
            cancelLoadData();
            if (this.X == null) {
                c.a.p0.a4.m0.b bVar = new c.a.p0.a4.m0.b("pbStat");
                this.X = bVar;
                bVar.f();
            }
            boolean k2 = k2(3);
            if (this.Q != null) {
                this.Q = null;
                this.S = null;
                this.R = null;
            }
            return k2;
        }
        return invokeV.booleanValue;
    }

    public o m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) ? this.M0 : (o) invokeV.objValue;
    }

    public PostData m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.E0 : (PostData) invokeV.objValue;
    }

    public void m2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048703, this, i, i2) == null) {
            this.G0 = i;
            this.H0 = i2;
        }
    }

    public CheckRealNameModel n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.x0 : (CheckRealNameModel) invokeV.objValue;
    }

    public PostData n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.F0 : (PostData) invokeV.objValue;
    }

    public void n2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048706, this, str) == null) {
            this.l0 = str;
        }
    }

    public t o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) ? this.u0 : (t) invokeV.objValue;
    }

    public String o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) ? this.mTopicSubjectName : (String) invokeV.objValue;
    }

    public void o2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048709, this, i) == null) {
            this.a1 = i;
        }
    }

    public MarkData p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f34970b);
            markData.setPostId(this.G.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(D1()));
            markData.setId(this.f34970b);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null || fVar.O() == null) {
                return null;
            }
            return this.G.O().worksInfoData;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    public void p2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048712, this, i) == null) {
            this.Y0 = i;
        }
    }

    public final String q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            String str = this.f34970b;
            String P0 = (str == null || str.equals("0")) ? P0() : this.f34970b;
            if (this.j) {
                P0 = P0 + "_host";
            }
            int i = this.m;
            if (i == 1) {
                P0 = P0 + "_rev";
            } else if (i == 2) {
                P0 = P0 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return P0 + TbadkCoreApplication.getCurrentAccount();
            }
            return P0;
        }
        return (String) invokeV.objValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) ? this.f34972d : (String) invokeV.objValue;
    }

    public void q2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048715, this, i) == null) {
            this.p = i;
        }
    }

    public String r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048717, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            return (fVar == null || ListUtils.isEmpty(fVar.F())) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public void r2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048718, this, i) == null) {
            this.q = i;
        }
    }

    public String s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) ? this.F : (String) invokeV.objValue;
    }

    public final boolean s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048720, this)) == null) ? (this.G.z() == null || this.G.z().getAdvertAppInfo() == null || this.G.z().getAdvertAppInfo().f29816c == 1001) ? false : true : invokeV.booleanValue;
    }

    public final void s2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048721, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(s0()) || z.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(z.q().b().e(s0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(z.q().b().d(s0(), true));
    }

    public String t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) ? this.f34976h : (String) invokeV.objValue;
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048723, this) == null) {
            c.a.p0.w2.m.f.n.b().d(q0(), this.A);
        }
    }

    public void t2(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048724, this, gVar) == null) {
            this.P = gVar;
        }
    }

    public String u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) ? this.f34975g : (String) invokeV.objValue;
    }

    public boolean u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048726, this)) == null) ? this.h1 : invokeV.booleanValue;
    }

    public void u2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048727, this, i) == null) {
            this.C0 = i;
        }
    }

    public MetaData v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            c.a.p0.w2.i.f fVar = this.G;
            if (fVar == null || fVar.O() == null || this.G.O().getAuthor() == null) {
                return null;
            }
            return this.G.O().getAuthor();
        }
        return (MetaData) invokeV.objValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048729, this)) == null) ? this.p0 : invokeV.booleanValue;
    }

    public void v2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048730, this, str) == null) {
            this.L0 = str;
        }
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) ? this.j : invokeV.booleanValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048732, this)) == null) ? this.o1 : invokeV.booleanValue;
    }

    public final void w2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048733, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(s0()) || z.q().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(z.q().b().d(s0(), true) + 1);
        pbPageRequestMessage.setLoadCount(z.q().b().e(s0(), true));
    }

    public int x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) ? this.Y0 : invokeV.intValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) ? this.q0 : invokeV.booleanValue;
    }

    public void x2(int i) {
        c.a.p0.w2.i.f fVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048736, this, i) == null) || (fVar = this.G) == null) {
            return;
        }
        fVar.J0(i);
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048738, this)) == null) ? this.k1 : invokeV.booleanValue;
    }

    public void y2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048739, this, z) == null) {
            this.i1 = z;
        }
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) ? this.M : invokeV.booleanValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048741, this)) == null) ? this.j1 : invokeV.booleanValue;
    }

    public void z2(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048742, this, uri) == null) {
            boolean z = false;
            if (uri == null) {
                this.l1 = false;
                return;
            }
            String queryParameter = uri.getQueryParameter("obj_source");
            String uri2 = uri.toString();
            if (!TextUtils.isEmpty(uri2) && uri2.contains(UNIDISPATCH_PB) && ("shoubai".equals(queryParameter) || "wise".equals(queryParameter))) {
                z = true;
            }
            this.l1 = z;
            if ("shoubai".equals(queryParameter)) {
                this.m1 = 5;
            } else if ("wise".equals(queryParameter)) {
                this.m1 = 4;
            } else {
                this.m1 = -1;
            }
            this.n1 = uri.getQueryParameter(TiebaStatic.Params.EQID);
        }
    }
}
