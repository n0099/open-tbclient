package com.baidu.tieba.pb.pb.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
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
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.a.g;
import d.a.o0.r.q.a1;
import d.a.o0.r.q.b2;
import d.a.o0.t.n;
import d.a.p0.h2.h.p;
import d.a.p0.h2.h.t;
import d.a.p0.h2.k.e.c0;
import d.a.p0.h2.k.e.e0;
import d.a.p0.h2.k.e.k;
import d.a.p0.h2.k.e.m0;
import d.a.p0.h2.k.e.q;
import d.a.p0.h3.h0.o;
import d.a.p0.w2.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import tbclient.PbPage.PbSortType;
/* loaded from: classes4.dex */
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
    public SuggestEmotionModel A0;
    public boolean B;
    public GetSugMatchWordsModel B0;
    public boolean C;
    public boolean C0;
    public boolean D;
    public int D0;
    public boolean E;
    public String E0;
    public long F;
    public PostData F0;
    public boolean G;
    public PostData G0;
    public String H;
    public int H0;
    public d.a.p0.h2.h.e I;
    public int I0;
    public int J;
    public boolean J0;
    public int K;
    public Rect K0;
    public boolean L;
    public int L0;
    public boolean M;
    public String M0;
    public boolean N;
    public o N0;
    public boolean O;
    public boolean O0;
    public String P;
    public String P0;
    public Context Q;
    public String Q0;
    public g R;
    public int R0;
    public String S;
    public String S0;
    public String T;
    public String T0;
    public String U;
    public String U0;
    public String V;
    public String V0;
    public int W;
    public String W0;
    public int X;
    public String X0;
    public boolean Y;
    public boolean Y0;
    public d.a.p0.h3.j0.b Z;
    public String Z0;
    public BaseFragmentActivity a0;
    public boolean a1;
    public boolean b0;
    public g.b b1;
    public boolean c0;
    public CustomMessageListener c1;
    public d.a.c.c.g.a d1;

    /* renamed from: e  reason: collision with root package name */
    public String f19421e;
    public CustomMessageListener e1;

    /* renamed from: f  reason: collision with root package name */
    public boolean f19422f;
    public CustomMessageListener f1;

    /* renamed from: g  reason: collision with root package name */
    public String f19423g;
    public PraiseData g1;

    /* renamed from: h  reason: collision with root package name */
    public String f19424h;

    /* renamed from: i  reason: collision with root package name */
    public String f19425i;
    public long i0;
    public boolean isLoading;
    public String j;
    public boolean j0;
    public boolean k;
    public boolean k0;
    public boolean l;
    public String l0;
    public boolean m;
    public String m0;
    public String mStType;
    public boolean n;
    public long n0;
    public int o;
    public boolean o0;
    public int p;
    public int p0;
    public boolean q;
    public boolean q0;
    public int r;
    public boolean r0;
    public int s;
    public int s0;
    public long t;
    public d.a.p0.h2.h.c t0;
    public int u;
    public final c0 u0;
    public int v;
    public final q v0;
    public int w;
    public final e0 w0;
    public int x;
    public String x0;
    public boolean y;
    public final CheckRealNameModel y0;
    public boolean z;
    public final AddExperiencedModel z0;

    /* loaded from: classes4.dex */
    public class a implements g.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f19426a;

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
            this.f19426a = pbModel;
        }

        @Override // d.a.o0.a.g.b
        public void onCallBack(HashMap<String, Object> hashMap) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, hashMap) == null) || hashMap == null) {
                return;
            }
            if (hashMap.get(d.a.o0.a.g.p) instanceof String) {
                this.f19426a.f19421e = (String) hashMap.get(d.a.o0.a.g.p);
            }
            if (hashMap.get(d.a.o0.a.g.q) instanceof String) {
                this.f19426a.P0 = (String) hashMap.get(d.a.o0.a.g.q);
            }
            if (hashMap.get(d.a.o0.a.g.r) instanceof String) {
                this.f19426a.Q0 = (String) hashMap.get(d.a.o0.a.g.r);
            }
            if (hashMap.get(d.a.o0.a.g.s) instanceof String) {
                this.f19426a.R0 = d.a.c.e.m.b.d((String) hashMap.get(d.a.o0.a.g.s), 0);
            }
            if (hashMap.get(d.a.o0.a.g.t) instanceof String) {
                this.f19426a.S0 = (String) hashMap.get(d.a.o0.a.g.t);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f19427a;

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
            this.f19427a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SignData)) {
                return;
            }
            SignData signData = (SignData) customResponsedMessage.getData();
            if (this.f19427a.D0() == null || this.f19427a.D0().m() == null || this.f19427a.D0().m().getSignData() == null || !signData.forumId.equals(this.f19427a.D0().n())) {
                return;
            }
            this.f19427a.D0().m().getSignData().is_signed = signData.is_signed;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f19428a;

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
            this.f19428a = pbModel;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if ((z2 || (responsedMessage instanceof pbPageHttpResponseMessage)) && responsedMessage.getOrginalMessage().getTag() == this.f19428a.getUniqueId()) {
                    if (responsedMessage.hasError() && responsedMessage.getError() != 4 && j.z()) {
                        this.f19428a.a0.showToast(responsedMessage.getErrorString());
                    }
                    if (z2) {
                        this.f19428a.y1((pbPageSocketResponseMessage) responsedMessage);
                    }
                    if (responsedMessage instanceof pbPageHttpResponseMessage) {
                        this.f19428a.x1((pbPageHttpResponseMessage) responsedMessage);
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
                        d.a.o0.r.z.a.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                    }
                    if (this.f19428a.b0 && this.f19428a.c0) {
                        return;
                    }
                    if (!this.f19428a.b0) {
                        this.f19428a.b0 = true;
                    } else {
                        this.f19428a.c0 = true;
                    }
                    if (this.f19428a.R != null) {
                        this.f19428a.R.a(this.f19428a.F0(), z, responsedMessage, this.f19428a.j0, System.currentTimeMillis() - this.f19428a.i0);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f19429a;

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
            this.f19429a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                d.a.p0.h2.h.e eVar = this.f19429a.I;
                if (eVar == null || eVar.h() == null || this.f19429a.I.h().h() == null || !this.f19429a.I.h().h().equals(valueOf)) {
                    return;
                }
                this.f19429a.I.h().setIsLike(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ PbModel f19430a;

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
            this.f19430a = pbModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                String valueOf = String.valueOf(customResponsedMessage.getData());
                d.a.p0.h2.h.e eVar = this.f19430a.I;
                if (eVar == null || eVar.h() == null || this.f19430a.I.h().h() == null || !this.f19430a.I.h().h().equals(valueOf)) {
                    return;
                }
                this.f19430a.I.h().setIsLike(true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.h2.h.e f19431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ PbModel f19432f;

        public f(PbModel pbModel, d.a.p0.h2.h.e eVar) {
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
            this.f19432f = pbModel;
            this.f19431e = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f19432f.A1(this.f19431e, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.f19432f.isLoading = false;
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a(int i2, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(d.a.p0.h2.h.e eVar);

        void c(boolean z, int i2, int i3, int i4, d.a.p0.h2.h.e eVar, String str, int i5);
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
        int a2 = d.a.o0.t.e.a() / 30;
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
                super((d.a.c.a.f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mStType = null;
        this.f19421e = null;
        this.f19422f = false;
        this.f19423g = null;
        this.f19424h = null;
        this.j = null;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = true;
        this.o = 0;
        this.p = 0;
        this.q = false;
        this.r = 0;
        this.s = 0;
        this.t = 0L;
        this.u = 1;
        this.v = 1;
        this.w = 1;
        this.x = 1;
        this.y = false;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.F = 0L;
        this.G = false;
        this.H = null;
        this.I = null;
        this.isLoading = false;
        this.L = false;
        this.M = false;
        this.N = false;
        this.O = false;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
        this.T = null;
        this.U = null;
        this.V = null;
        this.W = -1;
        this.X = -1;
        this.Z = null;
        this.b0 = false;
        this.c0 = false;
        this.l0 = null;
        this.m0 = null;
        this.n0 = 0L;
        this.o0 = false;
        this.p0 = -1;
        this.r0 = false;
        this.C0 = false;
        this.D0 = 0;
        this.L0 = 0;
        this.O0 = false;
        this.c1 = new b(this, 2001222);
        this.d1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.e1 = new d(this, 2001336);
        this.f1 = new e(this, 2001335);
        this.g1 = null;
        registerListener(this.d1);
        registerListener(this.c1);
        registerListener(this.f1);
        registerListener(this.e1);
        d.a.p0.h2.h.e eVar = new d.a.p0.h2.h.e();
        this.I = eVar;
        eVar.q0(0);
        this.Q = baseFragmentActivity.getPageContext().getPageActivity();
        this.a0 = baseFragmentActivity;
        this.u0 = new c0(this, baseFragmentActivity);
        this.v0 = new q(this, this.a0);
        this.w0 = new e0(this, this.a0);
        this.y0 = new CheckRealNameModel(this.a0.getPageContext());
        this.A0 = new SuggestEmotionModel();
        this.z0 = new AddExperiencedModel(this.a0.getPageContext());
        this.b1 = new a(this);
    }

    public final String A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            String str = "";
            if (this.P0 != null) {
                str = "" + this.P0;
            }
            if (this.Q0 != null) {
                str = str + this.Q0;
            }
            String str2 = str + this.R0;
            if (this.S0 != null) {
                return str2 + this.S0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void A1(d.a.p0.h2.h.e eVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j, long j2, boolean z3) {
        int i5;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z4 = !z;
            this.q0 = z3;
            d.a.p0.h3.j0.b bVar = this.Z;
            if (bVar != null && !z3) {
                bVar.b(z2, z4, i3, str, i4, j, j2);
                this.Z = null;
            }
            d.a.p0.h2.h.e eVar2 = this.I;
            if (eVar2 != null) {
                eVar2.Y = z3;
                eVar2.Z = i2;
            }
            if (z4 && !z3 && !TextUtils.isEmpty(f0()) && w.o().b() != null) {
                w.o().b().g(f0(), F1(N0()), true);
            }
            if (eVar != null && (this.u != 1 || i2 != 5 || eVar.E() == null || eVar.E().size() >= 1)) {
                this.m = this.n;
                if (i2 != 8) {
                    this.p = this.o;
                    this.o = eVar.f56899g;
                }
                List<PbSortType> list = eVar.f56898f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.a0.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    eVar.f56898f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.a0.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    eVar.f56898f.add(builder2.build(false));
                    int i7 = this.p;
                    this.o = i7;
                    eVar.f56899g = i7;
                }
                this.G = false;
                if (eVar.x() != null && (this.o != 2 || i2 != 8)) {
                    L(eVar.x());
                }
                int i8 = this.x;
                if (i8 < 1) {
                    i8 = 1;
                }
                this.x = i8;
                ArrayList<PostData> E = this.I.E();
                switch (i2) {
                    case 1:
                        this.I.x0(eVar.x(), 1);
                        e2(eVar, E);
                        c2(eVar);
                        i5 = 0;
                        break;
                    case 2:
                        if (eVar.E() != null) {
                            i5 = eVar.E().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(E, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(eVar.E(), ListUtils.getCount(eVar.E()) - 1);
                            if (postData != null && postData2 != null && postData.E().equals(postData2.E())) {
                                eVar.E().remove(postData2);
                                i5--;
                            }
                            E.addAll(0, eVar.E());
                        } else {
                            i5 = 0;
                        }
                        c2(eVar);
                        this.I.x0(eVar.x(), 2);
                        break;
                    case 3:
                        if (this.o == 1 && eVar.x() != null) {
                            eVar.x().k(eVar.x().h());
                        }
                        f2(eVar);
                        i5 = 0;
                        break;
                    case 4:
                        f2(eVar);
                        i5 = 0;
                        break;
                    case 5:
                        f2(eVar);
                        i5 = 0;
                        break;
                    case 6:
                        f2(eVar);
                        i5 = 0;
                        break;
                    case 7:
                        f2(eVar);
                        i5 = 0;
                        break;
                    case 8:
                        if (eVar == null || ListUtils.isEmpty(eVar.E()) || this.I == null || (this.l && !E1(eVar).equals(eVar.E().get(0).t().getUserId()))) {
                            i6 = 0;
                        } else {
                            if (this.I.x().b() == 0) {
                                this.I.x().l(1);
                            }
                            H1();
                            this.F0 = eVar.E().get(0);
                            if (!f1() && !this.I.e0()) {
                                if (this.H0 - this.I0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.G0 = postData3;
                                    postData3.D = false;
                                    postData3.r0(53);
                                    this.I.E().add(0, this.G0);
                                }
                                this.I.E().add(0, this.F0);
                                i6 = 0;
                            } else {
                                if (this.I.E().size() - this.H0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.G0 = postData4;
                                    postData4.D = true;
                                    postData4.r0(53);
                                    this.I.E().add(this.G0);
                                }
                                this.I.E().add(this.F0);
                                i6 = this.I.E().size() - 1;
                            }
                            if (!StringHelper.isTaday(d.a.o0.r.d0.b.j().l("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.F0.T = this.I.I();
                                d.a.o0.r.d0.b.j().w("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        }
                        c2(eVar);
                        i5 = i6;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
                d.a.p0.h2.h.e eVar3 = this.I;
                if (eVar3 != null && eVar3.N() != null) {
                    PraiseData G0 = this.I.N().G0();
                    if (this.g1 != null && !G0.isPriaseDataValid()) {
                        this.I.N().Q3(this.g1);
                    } else {
                        PraiseData G02 = this.I.N().G0();
                        this.g1 = G02;
                        G02.setPostId(this.I.N().T());
                    }
                    if (eVar.x() != null && eVar.x().a() == 1 && eVar.N() != null && eVar.N().o() != null && eVar.N().o().size() > 0) {
                        this.I.N().b3(eVar.N().o());
                    }
                    this.I.N().R3(eVar.N().P0());
                    this.I.N().f3(eVar.N().D());
                    this.I.N().j3(eVar.N().M());
                    if (this.K == 33) {
                        this.I.N().H().setHadConcerned(eVar.N().H().hadConcerned());
                    }
                    if (eVar != null && eVar.N() != null) {
                        this.I.N().p4(eVar.N().j0());
                    }
                }
                d.a.p0.h2.h.e eVar4 = this.I;
                if (eVar4 != null && eVar4.T() != null && eVar.T() != null) {
                    this.I.T().setBimg_end_time(eVar.T().getBimg_end_time());
                    this.I.T().setBimg_url(eVar.T().getBimg_url());
                }
                if (eVar.x() != null && eVar.x().a() == 1 && eVar.V() != null) {
                    this.I.E0(eVar.V());
                }
                if (this.q0) {
                    if (this.I.N() != null && this.I.N().H() != null && this.I.E() != null && ListUtils.getItem(this.I.E(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.I.E(), 0);
                        MetaData H = this.I.N().H();
                        if (postData5.t() != null && postData5.t().getGodUserData() != null) {
                            int i9 = this.W;
                            if (i9 != -1) {
                                H.setFansNum(i9);
                                postData5.t().setFansNum(this.W);
                            }
                            if (this.X != -1) {
                                H.getGodUserData().setIsLike(this.X == 1);
                                postData5.t().getGodUserData().setIsLike(this.X == 1);
                                H.getGodUserData().setIsFromNetWork(false);
                                postData5.t().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    d.a.p0.h2.h.e eVar5 = this.I;
                    eVar5.f56897e = -1;
                    eVar5.f56896d = -1;
                }
                g gVar = this.R;
                if (gVar != null) {
                    gVar.c(true, getErrorCode(), i2, i5, this.I, this.mErrorString, 1);
                }
            } else if (this.R != null) {
                this.n = this.m;
                if (i3 != 350006) {
                    this.o = this.p;
                }
                this.R.c(false, i3, i2, 0, null, str, 1);
            }
            d.a.p0.h2.h.e eVar6 = this.I;
            if (eVar6 == null || eVar6.N() == null || this.I.m() == null || this.I.e0()) {
                return;
            }
            HistoryMessage historyMessage = new HistoryMessage();
            historyMessage.Activity = this.a0.getPageContext();
            historyMessage.threadId = D0().N().c0();
            if (this.J0 && D0().N().u1 != null) {
                historyMessage.threadName = D0().N().u1.f12248b;
            } else {
                historyMessage.threadName = D0().N().getTitle();
            }
            if (this.J0 && !i1()) {
                historyMessage.forumName = "";
            } else {
                historyMessage.forumName = D0().m().getName();
            }
            historyMessage.isHostOnly = i0();
            historyMessage.isSquence = R0();
            historyMessage.threadType = D0().N().j1();
            historyMessage.isShareThread = this.J0;
            MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
        }
    }

    public a1 B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null) {
                return null;
            }
            return eVar.x();
        }
        return (a1) invokeV.objValue;
    }

    public final void B1(int i2) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 == 8) {
            return;
        }
        this.E0 = "";
        if (this.F0 != null) {
            if (i2 == 1 && (eVar = this.I) != null && eVar.e0()) {
                if (this.G0 != null) {
                    D0().E().remove(this.G0);
                }
            } else if (i2 == 1 && !this.n && !ListUtils.isEmpty(D0().E())) {
                D0().E().remove(this.F0);
                if (this.G0 != null) {
                    D0().E().remove(this.G0);
                }
                D0().E().add(0, this.F0);
            } else {
                D0().E().remove(this.F0);
                if (this.G0 != null) {
                    D0().E().remove(this.G0);
                }
            }
        }
        this.G0 = null;
    }

    public int C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.D0 : invokeV.intValue;
    }

    public void C1(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, eVar) == null) || eVar == null) {
            return;
        }
        String E1 = E1(eVar);
        for (int i2 = 0; i2 < eVar.E().size(); i2++) {
            PostData postData = eVar.E().get(i2);
            for (int i3 = 0; i3 < postData.M().size(); i3++) {
                postData.M().get(i3).z0(this.a0.getPageContext(), E1.equals(postData.M().get(i3).t().getUserId()));
            }
        }
        t S = eVar.S();
        if (S == null || ListUtils.isEmpty(S.f56951a)) {
            return;
        }
        for (PostData postData2 : S.f56951a) {
            for (int i4 = 0; i4 < postData2.M().size(); i4++) {
                postData2.M().get(i4).z0(this.a0.getPageContext(), E1.equals(postData2.M().get(i4).t().getUserId()));
            }
        }
    }

    public d.a.p0.h2.h.e D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.I : (d.a.p0.h2.h.e) invokeV.objValue;
    }

    public void D1(d.a.p0.h2.h.e eVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048583, this, eVar, i2) == null) || eVar == null) {
            return;
        }
        String E1 = E1(eVar);
        t S = eVar.S();
        if (S == null || ListUtils.isEmpty(S.f56951a)) {
            return;
        }
        List<PostData> list = S.f56951a;
        for (PostData postData : list.subList(i2, list.size())) {
            for (int i3 = 0; i3 < postData.M().size(); i3++) {
                postData.M().get(i3).z0(this.a0.getPageContext(), E1.equals(postData.M().get(i3).t().getUserId()));
            }
        }
    }

    public d.a.p0.h2.h.e E0() {
        InterceptResult invokeV;
        o oVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null) {
                return eVar;
            }
            if (!Y0() && (oVar = this.N0) != null) {
                this.I.y0(oVar);
            }
            return this.I;
        }
        return (d.a.p0.h2.h.e) invokeV.objValue;
    }

    public String E1(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, eVar)) == null) {
            String str = null;
            if (eVar == null) {
                return null;
            }
            if (eVar.N() != null && eVar.N().H() != null) {
                str = eVar.N().H().getUserId();
            }
            return str == null ? "" : str;
        }
        return (String) invokeL.objValue;
    }

    public int F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public final int F1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            if (i2 != 1) {
                return i2 != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public String G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.x0 : (String) invokeV.objValue;
    }

    public void G1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.u = i2;
            this.v = i2;
            this.w = i2;
        }
    }

    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.M0 : (String) invokeV.objValue;
    }

    public void H1() {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048591, this) == null) || (eVar = this.I) == null || ListUtils.isEmpty(eVar.E())) {
            return;
        }
        if (this.G0 != null) {
            this.I.E().remove(this.G0);
            this.G0 = null;
        }
        if (this.F0 != null) {
            this.I.E().remove(this.F0);
            this.F0 = null;
        }
    }

    public String I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.V0 : (String) invokeV.objValue;
    }

    public void I1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bundle) == null) {
            bundle.putString("thread_id", this.f19421e);
            bundle.putString("post_id", this.f19423g);
            bundle.putString("forum_id", this.f19424h);
            bundle.putString("from_forum_id", this.f19425i);
            bundle.putInt("key_start_from", this.D0);
            bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.k);
            bundle.putBoolean("host_only", this.l);
            bundle.putBoolean("squence", this.n);
            bundle.putInt("sort_type", this.o);
            bundle.putString("st_type", this.mStType);
            bundle.putString("locate", this.P);
            bundle.putInt("is_good", this.r);
            bundle.putInt("is_top", this.s);
            bundle.putLong("thread_time", this.t);
            bundle.putBoolean("from_mark", this.C);
            bundle.putBoolean("is_pb_key_need_post_id", this.E);
            bundle.putBoolean("is_sub_pb", this.z);
            bundle.putBoolean("is_ad", this.y);
            bundle.putBoolean("is_pv", this.G);
            bundle.putLong("msg_id", this.F);
            bundle.putString("extra_pb_cache_key", this.V);
            bundle.putInt("thread_type", this.K);
            bundle.putBoolean("is_from_thread_config", this.L);
            bundle.putBoolean("is_from_interview_live_config", this.M);
            bundle.putBoolean("is_from_my_god_config", this.N);
            bundle.putInt("extra_pb_is_attention_key", this.X);
            bundle.putInt("extra_pb_funs_count_key", this.W);
            bundle.putBoolean("from_frs", this.A);
            bundle.putBoolean("from_maintab", this.B);
            bundle.putBoolean("from_smart_frs", this.r0);
            bundle.putBoolean("from_hottopic", this.O);
            bundle.putBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, this.J0);
            bundle.putString("high_light_post_id", this.j);
            bundle.putString("key_ori_ugc_nid", this.P0);
            bundle.putString("key_ori_ugc_tid", this.Q0);
            bundle.putInt("key_ori_ugc_type", this.R0);
            bundle.putString("key_ori_ugc_vid", this.S0);
            bundle.putString(PbActivityConfig.KEY_REC_WEIGHT, this.T0);
            bundle.putString(PbActivityConfig.KEY_REC_SOURCE, this.U0);
            bundle.putString(PbActivityConfig.KEY_REC_AB_TAG, this.V0);
            bundle.putString(PbActivityConfig.KEY_REC_EXTRA, this.W0);
        }
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.W0 : (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x0333, code lost:
        if ((r11.w - 1) <= 0) goto L138;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x028d A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0291 A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02a5 A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0364 A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0380 A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:175:0x03ab A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0439 A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0449 A[Catch: Exception -> 0x049a, TryCatch #0 {Exception -> 0x049a, blocks: (B:39:0x00eb, B:41:0x00ef, B:44:0x00f9, B:48:0x0160, B:50:0x0170, B:51:0x0173, B:53:0x0180, B:54:0x0183, B:56:0x0187, B:57:0x018c, B:59:0x0190, B:60:0x0195, B:62:0x0199, B:63:0x01a8, B:65:0x01ac, B:66:0x01af, B:68:0x01b3, B:69:0x01cb, B:73:0x01e1, B:75:0x01ee, B:76:0x0200, B:77:0x0210, B:79:0x0217, B:81:0x021b, B:83:0x021f, B:87:0x0233, B:89:0x023a, B:91:0x0241, B:90:0x023e, B:84:0x0223, B:86:0x0230, B:92:0x0246, B:93:0x025a, B:94:0x0274, B:96:0x0278, B:99:0x027d, B:101:0x0284, B:103:0x028d, B:107:0x02a1, B:109:0x02a5, B:110:0x02a8, B:104:0x0291, B:106:0x0298, B:100:0x0281, B:112:0x02af, B:114:0x02b5, B:116:0x02bb, B:117:0x02c7, B:119:0x02d1, B:121:0x02d7, B:123:0x02dc, B:124:0x02e7, B:126:0x02ed, B:127:0x02f7, B:129:0x02fb, B:131:0x0303, B:133:0x0310, B:134:0x0313, B:135:0x0318, B:137:0x0322, B:139:0x0326, B:146:0x0349, B:149:0x034f, B:176:0x03ae, B:152:0x0355, B:154:0x035b, B:155:0x0360, B:157:0x0364, B:159:0x036c, B:160:0x036f, B:163:0x037c, B:165:0x0380, B:166:0x038a, B:168:0x038e, B:170:0x0396, B:172:0x03a3, B:173:0x03a7, B:175:0x03ab, B:142:0x0337, B:177:0x03b1, B:181:0x03df, B:183:0x03ea, B:185:0x03f7, B:187:0x0401, B:189:0x0408, B:191:0x040c, B:193:0x0411, B:196:0x0416, B:198:0x041d, B:200:0x0439, B:201:0x0442, B:203:0x0449, B:205:0x0453, B:208:0x0460, B:209:0x0465, B:212:0x0471, B:213:0x0475, B:197:0x041a, B:188:0x0405, B:184:0x03f2, B:214:0x0497), top: B:223:0x00eb }] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x037c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean J1(int i2) {
        InterceptResult invokeI;
        boolean z;
        int size;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            this.J = i2;
            int i5 = 0;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            w1(i2);
            d.a.p0.h2.h.e f2 = m0.b().f();
            if (f2 != null && f2.N() != null) {
                f2.N().j3(0);
                this.n = m0.b().i();
                this.l = m0.b().a();
                this.q = m0.b().c();
                this.F0 = m0.b().g();
                this.G0 = m0.b().h();
                this.H0 = m0.b().d();
                this.K0 = m0.b().k();
                this.L0 = m0.b().j();
                boolean z2 = this.l;
                this.C0 = z2;
                if (z2 || this.C) {
                    this.Y = false;
                }
                d.a.c.e.m.e.a().post(new f(this, f2));
                return false;
            }
            if (i2 == 4 && !this.k0) {
                K1(d0(), true, this.f19423g, 3);
            }
            if (i2 == 3 && !this.k0) {
                if (this.C) {
                    K1(d0(), true, this.f19423g, 3);
                } else {
                    K1(d0(), false, this.f19423g, 3);
                }
            }
            this.k0 = false;
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i2);
            pbPageRequestMessage.setIsReqAd(this.N0 == null ? 1 : 0);
            pbPageRequestMessage.setLastids(d.a.o0.u.a.o);
            if (this.l || this.C) {
                this.Y = false;
            }
            try {
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
            if (this.f19421e != null && this.f19421e.length() != 0) {
                pbPageRequestMessage.set_kz(d.a.c.e.m.b.f(this.f19421e, 0L));
                pbPageRequestMessage.setFloorSortType(1);
                pbPageRequestMessage.setFloor_rn(4);
                pbPageRequestMessage.set_rn(15);
                pbPageRequestMessage.set_with_floor(1);
                pbPageRequestMessage.set_scr_w(Integer.valueOf(l.k(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_h(Integer.valueOf(l.i(TbadkCoreApplication.getInst().getApp())));
                pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                pbPageRequestMessage.set_q_type(Integer.valueOf(TbImageHelper.getInstance().isShowBigImage() ? 2 : 1));
                pbPageRequestMessage.setSchemeUrl(this.X0);
                if (!this.n) {
                    pbPageRequestMessage.set_r(1);
                }
                pbPageRequestMessage.set_r(Integer.valueOf(this.o));
                if (this.l) {
                    pbPageRequestMessage.set_lz(1);
                }
                if (this.mStType != null) {
                    pbPageRequestMessage.set_st_type(this.mStType);
                }
                if (this.P != null) {
                    pbPageRequestMessage.setLocate(this.P);
                }
                if (this.G) {
                    pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.F));
                    pbPageRequestMessage.set_message_click("1");
                }
                if (this.Y) {
                    pbPageRequestMessage.set_banner(1);
                }
                if (this.S != null) {
                    pbPageRequestMessage.setOpType(this.S);
                    pbPageRequestMessage.setOpUrl(this.T);
                    pbPageRequestMessage.setOpStat(d.a.c.e.m.b.d(this.U, 0));
                    pbPageRequestMessage.setOpMessageID(this.F);
                }
                pbPageRequestMessage.set_thread_type(Integer.valueOf(this.K));
                ArrayList<PostData> E = this.I.E();
                switch (i2) {
                    case 1:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        if (!this.C) {
                            if (this.o == 1) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.w - 1));
                                break;
                            } else {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.v + 1));
                                z = this.v >= this.x;
                            }
                            if (!this.C || z || this.D) {
                                if (E != null && E.size() > 0) {
                                    size = E.size();
                                    i3 = 1;
                                    while (true) {
                                        i4 = size - i3;
                                        if (i4 >= 0) {
                                            PostData postData = E.get(i4);
                                            if (postData != null) {
                                                String E2 = postData.E();
                                                this.f19423g = E2;
                                                if (StringUtils.isNull(E2)) {
                                                }
                                            }
                                            i3++;
                                        }
                                    }
                                    if (this.o == 2) {
                                        pbPageRequestMessage.set_pn(Integer.valueOf(this.v + 1));
                                    }
                                }
                                if (this.f19423g == null && this.f19423g.length() > 0) {
                                    pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19423g, 0L));
                                    if (this.o == 2) {
                                        pbPageRequestMessage.set_pid(0L);
                                    }
                                } else if (this.o == 1) {
                                    pbPageRequestMessage.set_last(1);
                                }
                            }
                            P1(pbPageRequestMessage);
                            break;
                        }
                        if (!this.C) {
                        }
                        if (E != null) {
                            size = E.size();
                            i3 = 1;
                            while (true) {
                                i4 = size - i3;
                                if (i4 >= 0) {
                                }
                                i3++;
                            }
                            if (this.o == 2) {
                            }
                        }
                        if (this.f19423g == null) {
                        }
                        if (this.o == 1) {
                        }
                        P1(pbPageRequestMessage);
                    case 2:
                        if (E != null && E.size() > 0 && E.get(0) != null) {
                            this.f19423g = E.get(0).E();
                        }
                        pbPageRequestMessage.set_back(1);
                        pbPageRequestMessage.set_banner(0);
                        if (this.C) {
                            if (f1()) {
                                if (this.w - 1 > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.w - 1));
                                }
                            } else if (this.v < this.x) {
                                pbPageRequestMessage.set_pn(Integer.valueOf(this.v + 1));
                            }
                        }
                        if (this.f19423g != null && this.f19423g.length() > 0) {
                            pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19423g, 0L));
                            if (this.o == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        P1(pbPageRequestMessage);
                        break;
                    case 3:
                        if (!this.C && !this.l) {
                            pbPageRequestMessage.set_banner(1);
                            pbPageRequestMessage.set_back(0);
                            if (!f1()) {
                                pbPageRequestMessage.set_pn(1);
                            } else {
                                pbPageRequestMessage.set_last(1);
                                if (this.x > 0) {
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.x));
                                }
                            }
                            if (this.C) {
                                pbPageRequestMessage.set_st_type("store_thread");
                            }
                            T1(pbPageRequestMessage);
                            break;
                        }
                        pbPageRequestMessage.set_banner(0);
                        pbPageRequestMessage.set_back(0);
                        if (!f1()) {
                        }
                        if (this.C) {
                        }
                        T1(pbPageRequestMessage);
                        break;
                    case 4:
                        pbPageRequestMessage.set_st_type("store_thread");
                        pbPageRequestMessage.set_mark(1);
                        pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19423g, 0L));
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_banner(0);
                        P1(pbPageRequestMessage);
                        break;
                    case 5:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.set_pn(Integer.valueOf(this.u));
                        pbPageRequestMessage.set_banner(0);
                        P1(pbPageRequestMessage);
                        break;
                    case 6:
                        pbPageRequestMessage.set_mark(1);
                        if (this.o == 1 && this.C0 && !this.l) {
                            pbPageRequestMessage.set_pid(0L);
                        } else {
                            pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.f19423g, 0L));
                            if (this.o == 2) {
                                pbPageRequestMessage.set_pid(0L);
                            }
                        }
                        pbPageRequestMessage.set_back(0);
                        if (this.l) {
                            pbPageRequestMessage.set_banner(0);
                        } else {
                            pbPageRequestMessage.set_banner(1);
                        }
                        P1(pbPageRequestMessage);
                        break;
                    case 7:
                        pbPageRequestMessage.set_back(0);
                        pbPageRequestMessage.setIsJumpFloor(true);
                        pbPageRequestMessage.setJumpFloorNum(this.p0);
                        P1(pbPageRequestMessage);
                        break;
                    case 8:
                        pbPageRequestMessage.set_pid(d.a.c.e.m.b.f(this.E0, 0L));
                        if (this.o == 1) {
                            pbPageRequestMessage.set_arround(1);
                            pbPageRequestMessage.set_back(1);
                            pbPageRequestMessage.set_pn(0);
                            pbPageRequestMessage.set_rn(2);
                            break;
                        }
                        break;
                }
                this.C0 = this.l;
                pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.C));
                pbPageRequestMessage.setCacheKey(d0());
                pbPageRequestMessage.setContext(this.Q);
                pbPageRequestMessage.setObjParam1(String.valueOf(this.D0));
                pbPageRequestMessage.setIsSubPostDataReverse(this.o0);
                pbPageRequestMessage.setFromSmartFrs(this.r0 ? 1 : 0);
                if (UtilHelper.isUgcThreadType(this.R0)) {
                    pbPageRequestMessage.setForumId(String.valueOf(0));
                } else {
                    pbPageRequestMessage.setForumId(this.f19424h);
                }
                pbPageRequestMessage.setNeedRepostRecommendForum(this.k);
                if (this.D0 == 7) {
                    pbPageRequestMessage.setFrom_push(1);
                } else {
                    pbPageRequestMessage.setFrom_push(0);
                }
                if (this.D0 != 7 && this.D0 != 5 && !this.a1) {
                    pbPageRequestMessage.setSourceType(2);
                    pbPageRequestMessage.setOriUgcNid(this.P0);
                    pbPageRequestMessage.setOriUgcTid(this.Q0);
                    pbPageRequestMessage.setOriUgcType(this.R0);
                    pbPageRequestMessage.setOriUgcVid(this.S0);
                    if (!StringUtils.isNull(this.Z0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.Z0));
                    }
                    if (pbPageRequestMessage.getPn() != null) {
                        if (pbPageRequestMessage.getR().intValue() == 1) {
                            i5 = pbPageRequestMessage.getPn().intValue() == this.x ? -1 : U();
                        } else {
                            if (pbPageRequestMessage.getPn().intValue() != 1) {
                                i5 = U();
                            }
                        }
                    }
                    pbPageRequestMessage.setAfterAdThreadCount(i5);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f19421e);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    sendMessage(pbPageRequestMessage);
                    return true;
                }
                pbPageRequestMessage.setSourceType(1);
                pbPageRequestMessage.setOriUgcNid(this.P0);
                pbPageRequestMessage.setOriUgcTid(this.Q0);
                pbPageRequestMessage.setOriUgcType(this.R0);
                pbPageRequestMessage.setOriUgcVid(this.S0);
                if (!StringUtils.isNull(this.Z0)) {
                }
                if (pbPageRequestMessage.getPn() != null) {
                }
                pbPageRequestMessage.setAfterAdThreadCount(i5);
                pbPageRequestMessage.setTag(this.unique_id);
                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.f19421e);
                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                sendMessage(pbPageRequestMessage);
                return true;
            }
            this.isLoading = false;
            return false;
        }
        return invokeI.booleanValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.U0 : (String) invokeV.objValue;
    }

    public final void K1(String str, boolean z, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048597, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i2)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setContext(this.Q);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i2);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    public void L(a1 a1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, a1Var) == null) {
            if (a1Var == null) {
                G1(1);
                return;
            }
            if (this.v < a1Var.a()) {
                this.v = a1Var.a();
            }
            if (this.w > a1Var.a()) {
                this.w = a1Var.a();
            }
            this.x = a1Var.h();
        }
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.T0 : (String) invokeV.objValue;
    }

    public void L1(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048600, this, i2, i3) == null) {
            this.H0 = i2;
            this.I0 = i3;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.f19421e == null) {
                return false;
            }
            cancelLoadData();
            if (this.Z == null) {
                d.a.p0.h3.j0.b bVar = new d.a.p0.h3.j0.b("pbStat");
                this.Z = bVar;
                bVar.f();
            }
            boolean J1 = J1(3);
            if (this.S != null) {
                this.S = null;
                this.U = null;
                this.T = null;
            }
            return J1;
        }
        return invokeV.booleanValue;
    }

    public final void M(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048602, this, eVar) == null) || eVar == null || eVar.y() == null || eVar.y().getAdvertAppInfo() == null || !eVar.y().G0() || eVar.y().getAdvertAppInfo().N3 == 1001) {
            return;
        }
        this.N0 = eVar.y();
    }

    public int M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar != null) {
                return eVar.K();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void M1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.m0 = str;
        }
    }

    public void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            this.N0 = null;
        }
    }

    public int N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.J : invokeV.intValue;
    }

    public void N1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
            this.r = i2;
        }
    }

    public void O(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
            if ((!this.l || j1(TbadkCoreApplication.getCurrentAccount())) && this.I.E() != null) {
                this.I.x().l(1);
                if (this.I.x().b() == 0) {
                    this.I.x().l(1);
                }
                this.E0 = str;
                J1(8);
            }
        }
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? f1() : invokeV.booleanValue;
    }

    public void O1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.s = i2;
        }
    }

    public void P(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048611, this, eVar) == null) || eVar == null) {
            return;
        }
        if (this.N || this.L || this.M) {
            eVar = W1(eVar);
        }
        C1(eVar);
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.o : invokeV.intValue;
    }

    public final void P1(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048613, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(f0()) || w.o().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(w.o().b().e(f0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(w.o().b().d(f0(), true));
    }

    public d.a.p0.h2.h.e Q(b2 b2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, b2Var)) == null) {
            d.a.p0.h2.h.e eVar = new d.a.p0.h2.h.e();
            eVar.q0(3);
            if (b2Var == null) {
                return null;
            }
            eVar.C0(b2Var);
            if (b2Var.V() != null) {
                eVar.r0(b2Var.V());
                ForumData m = eVar.m();
                m.setId(b2Var.V().h());
                m.setName(b2Var.V().g());
                m.setUser_level(b2Var.V().b());
                m.setImage_url(b2Var.V().a());
                m.setPost_num(b2Var.V().f52821h);
                m.setMember_num(b2Var.V().f52822i);
            } else {
                ForumData m2 = eVar.m();
                m2.setId(String.valueOf(b2Var.Q()));
                m2.setName(b2Var.W());
            }
            PostData postData = new PostData();
            postData.i0(1);
            postData.w0(b2Var.N());
            postData.g0(b2Var.H());
            MetaData H = b2Var.H();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(H.getUserId(), H);
            postData.y0(hashMap);
            postData.t0(TbRichTextView.T(this.Q, b2Var.S(), T0(), false));
            eVar.s0(postData);
            eVar.E().add(postData);
            eVar.z0(new p(b2Var, null));
            eVar.m = true;
            eVar.v0(1);
            return eVar;
        }
        return (d.a.p0.h2.h.e) invokeL.objValue;
    }

    public int Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.o : invokeV.intValue;
    }

    public void Q1(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, gVar) == null) {
            this.R = gVar;
        }
    }

    public int R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            int i2 = this.D0;
            return (i2 == 7 || i2 == 5 || this.a1) ? 1 : 2;
        }
        return invokeV.intValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? f1() : invokeV.booleanValue;
    }

    public void R1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.D0 = i2;
        }
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.f19421e);
            if (!this.E) {
                sb.append(this.f19423g);
            }
            sb.append(this.l);
            sb.append(this.n);
            sb.append(this.o);
            sb.append(this.mStType);
            sb.append(this.r);
            sb.append(this.s);
            sb.append(this.t);
            sb.append(this.A);
            sb.append(this.B);
            sb.append(this.C);
            sb.append(this.y);
            sb.append(this.z);
            sb.append(this.G);
            sb.append(this.F);
            sb.append(this.H);
            sb.append(this.K);
            sb.append(this.L);
            sb.append(this.M);
            sb.append(this.N);
            sb.append(this.P0);
            sb.append(this.Q0);
            sb.append(this.S0);
            sb.append(this.R0);
            String str = this.V;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public int S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) ? this.L0 : invokeV.intValue;
    }

    public void S1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.M0 = str;
        }
    }

    public AddExperiencedModel T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) ? this.z0 : (AddExperiencedModel) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) ? this.f19421e : (String) invokeV.objValue;
    }

    public final void T1(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048625, this, pbPageRequestMessage) == null) || TextUtils.isEmpty(f0()) || w.o().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(w.o().b().d(f0(), true) + 1);
        pbPageRequestMessage.setLoadCount(w.o().b().e(f0(), true));
    }

    public final int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            int i2 = 0;
            if (D0().E() == null) {
                return 0;
            }
            ArrayList<PostData> E = D0().E();
            for (int size = E.size() - 1; size >= 0; size--) {
                PostData postData = E.get(size);
                if (!(postData instanceof o)) {
                    i2++;
                } else if (postData.getType() != AdvertAppInfo.g4) {
                    return i2;
                }
            }
            return E.size();
        }
        return invokeV.intValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            if (!StringUtils.isNull(this.f19421e) && !"0".equals(this.f19421e)) {
                return this.f19421e;
            }
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    public void U1(int i2) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048628, this, i2) == null) || (eVar = this.I) == null) {
            return;
        }
        eVar.B0(i2);
    }

    public d.a.p0.h2.h.c V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.t0 : (d.a.p0.h2.h.c) invokeV.objValue;
    }

    public PostData V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) ? this.F0 : (PostData) invokeV.objValue;
    }

    public boolean V1(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048631, this, i2)) == null) {
            this.u = i2;
            if (i2 > this.I.x().h()) {
                this.u = this.I.x().h();
            }
            if (this.u < 1) {
                this.u = 1;
            }
            if (this.f19421e == null) {
                return false;
            }
            return J1(5);
        }
        return invokeI.booleanValue;
    }

    public MarkData W(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048632, this, i2)) == null) {
            if (i2 < 0) {
                i2 = 0;
            }
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null) {
                return null;
            }
            ArrayList<PostData> E = eVar.E();
            if (ListUtils.isEmpty(E)) {
                return null;
            }
            if (E.size() > 0 && i2 >= E.size()) {
                i2 = E.size() - 1;
            }
            return x0(E.get(i2));
        }
        return (MarkData) invokeI.objValue;
    }

    public PostData W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.G0 : (PostData) invokeV.objValue;
    }

    public d.a.p0.h2.h.e W1(d.a.p0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, eVar)) == null) {
            if (eVar == null) {
                return null;
            }
            b2 N = eVar.N();
            N.C3(this.r);
            N.D3(this.s);
            long j = this.t;
            if (j > 0) {
                N.H3(j);
            }
            return eVar;
        }
        return (d.a.p0.h2.h.e) invokeL.objValue;
    }

    public Rect X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            Rect rect = this.K0;
            this.K0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public String X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? this.f19423g : (String) invokeV.objValue;
    }

    public void X1(boolean z) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048637, this, z) == null) || (eVar = this.I) == null) {
            return;
        }
        eVar.u0(z);
    }

    public BaijiahaoData Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null || eVar.N() == null) {
                return null;
            }
            return this.I.N().J();
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public final boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? (this.I.y() == null || this.I.y().getAdvertAppInfo() == null || this.I.y().getAdvertAppInfo().N3 == 1001) ? false : true : invokeV.booleanValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            if (f1() && this.I.x().b() == 0) {
                l1(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public o Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.N0 : (o) invokeV.objValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048642, this) == null) {
            k.b().d(d0(), this.C);
        }
    }

    public boolean Z1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, str)) == null) {
            this.l = !this.l;
            this.f19423g = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (J1(6)) {
                return true;
            }
            this.l = !this.l;
            return false;
        }
        return invokeL.booleanValue;
    }

    public CheckRealNameModel a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? this.y0 : (CheckRealNameModel) invokeV.objValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) ? this.q0 : invokeV.booleanValue;
    }

    public boolean a2(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048646, this, z, str)) == null) {
            if (this.l == z) {
                return false;
            }
            this.l = z;
            this.f19423g = str;
            if (this.o == 2) {
                this.f19423g = "";
            }
            if (z) {
                TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
            }
            if (J1(6)) {
                return true;
            }
            this.l = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public q b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.v0 : (q) invokeV.objValue;
    }

    public boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.r0 : invokeV.booleanValue;
    }

    public boolean b2(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048649, this, i2)) == null) {
            if (i2 == this.o) {
                return false;
            }
            if (i2 != 1) {
                d.a.o0.r.d0.b.j().v("key_pb_current_sort_type", i2);
            }
            boolean z = this.n;
            this.m = z;
            this.p = this.o;
            this.o = i2;
            this.n = !z;
            if (i2 == 2 && this.C) {
                this.f19423g = "0";
            }
            if (this.isLoading || !LoadData()) {
                this.n = !this.n;
                this.o = this.p;
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public MarkData c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f19421e);
            markData.setPostId(this.I.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.l);
            markData.setSequence(Boolean.valueOf(f1()));
            markData.setId(this.f19421e);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.Y0 : invokeV.booleanValue;
    }

    public final void c2(@NonNull d.a.p0.h2.h.e eVar) {
        d.a.p0.h2.h.e eVar2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048652, this, eVar) == null) || (eVar2 = this.I) == null) {
            return;
        }
        eVar2.e().clear();
        this.I.e().addAll(eVar.e());
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            return (eVar == null || eVar.m() == null || this.I.N() == null) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final String d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            String str = this.f19421e;
            String A0 = (str == null || str.equals("0")) ? A0() : this.f19421e;
            if (this.l) {
                A0 = A0 + DB_KEY_HOST;
            }
            int i2 = this.o;
            if (i2 == 1) {
                A0 = A0 + DB_KEY_REVER;
            } else if (i2 == 2) {
                A0 = A0 + DB_KEY_HOT;
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return A0 + TbadkCoreApplication.getCurrentAccount();
            }
            return A0;
        }
        return (String) invokeV.objValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) ? this.Y : invokeV.booleanValue;
    }

    public void d2(n nVar) {
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048657, this, nVar) == null) || nVar == null || (eVar = this.I) == null || eVar.E() == null || this.I.E().size() <= 0) {
            return;
        }
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount)) {
            return;
        }
        int size = this.I.E().size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.I.E().get(i2) != null && this.I.E().get(i2).t() != null && currentAccount.equals(this.I.E().get(i2).t().getUserId()) && this.I.E().get(i2).t().getPendantData() != null) {
                this.I.E().get(i2).t().getPendantData().d(nVar.a());
                this.I.E().get(i2).t().getPendantData().e(nVar.b());
            }
        }
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048658, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.unique_id);
            SuggestEmotionModel suggestEmotionModel = this.A0;
            if (suggestEmotionModel != null) {
                suggestEmotionModel.cancelLoadData();
            }
            GetSugMatchWordsModel getSugMatchWordsModel = this.B0;
            if (getSugMatchWordsModel != null) {
                getSugMatchWordsModel.cancelLoadData();
            }
            d.a.p0.w2.i0.b.f().a("PB");
            s1();
        }
    }

    public String e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) ? this.m0 : (String) invokeV.objValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? this.O0 && d.a.p0.u0.l.b() != null && d.a.p0.u0.l.b().equals(this.f19421e) && d.a.p0.u0.l.a() != null : invokeV.booleanValue;
    }

    public void e2(d.a.p0.h2.h.e eVar, ArrayList<PostData> arrayList) {
        String u0;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048661, this, eVar, arrayList) == null) || arrayList == null || eVar.E() == null) {
            return;
        }
        PostData postData = (PostData) ListUtils.getItem(eVar.E(), 0);
        if (postData != null && (u0 = u0(arrayList)) != null && u0.equals(postData.E())) {
            eVar.E().remove(postData);
        }
        this.I.X = arrayList.size();
        arrayList.addAll(eVar.E());
    }

    public String f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? this.H : (String) invokeV.objValue;
    }

    public final boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            int i2 = this.o;
            return i2 == 0 || i2 == 2;
        }
        return invokeV.booleanValue;
    }

    public final void f2(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048664, this, eVar) == null) || eVar == null) {
            return;
        }
        eVar.F0(this.I.W());
        d.a.p0.h2.h.e eVar2 = this.I;
        if (!eVar2.V && eVar.V && eVar2.i() != null) {
            eVar.t0(this.I.i());
        }
        this.I = eVar;
        G1(eVar.x().a());
    }

    public String g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.j : (String) invokeV.objValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) ? D0() != null && D0().m0() : invokeV.booleanValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.s0 : invokeV.intValue;
    }

    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) ? this.f19424h : (String) invokeV.objValue;
    }

    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.f19425i : (String) invokeV.objValue;
    }

    public MetaData h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null || eVar.N() == null || this.I.N().H() == null) {
                return null;
            }
            return this.I.N().H();
        }
        return (MetaData) invokeV.objValue;
    }

    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            int i2 = this.D0;
            return i2 == 13 || i2 == 12 || i2 == 7 || i2 == 23 || i2 == 24;
        }
        return invokeV.booleanValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) ? C0() == 3 || D0() == null || D0().N() == null || !D0().N().b2() : invokeV.booleanValue;
    }

    public void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, bundle) == null) {
            this.D0 = bundle.getInt("key_start_from", 0);
            this.f19421e = bundle.getString("thread_id");
            this.f19423g = bundle.getString("post_id");
            this.f19424h = bundle.getString("forum_id");
            this.f19425i = bundle.getString("from_forum_id");
            bundle.getString(PbActivityConfig.KEY_GOD_REPLY_ID);
            this.k = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.l = bundle.getBoolean("host_only", false);
            this.n = bundle.getBoolean("squence", true);
            this.o = bundle.getInt("sort_type", 0);
            this.mStType = bundle.getString("st_type");
            this.P = bundle.getString("locate");
            this.r = bundle.getInt("is_good", 0);
            this.s = bundle.getInt("is_top", 0);
            this.t = bundle.getLong("thread_time");
            this.C = bundle.getBoolean("from_mark", false);
            this.E = bundle.getBoolean("is_pb_key_need_post_id", false);
            this.y = bundle.getBoolean("is_ad", false);
            this.z = bundle.getBoolean("is_sub_pb", false);
            this.G = bundle.getBoolean("is_pv", false);
            this.F = bundle.getLong("msg_id", 0L);
            this.H = bundle.getString("from_forum_name");
            this.V = bundle.getString("extra_pb_cache_key");
            this.L = bundle.getBoolean("is_from_thread_config", false);
            this.M = bundle.getBoolean("is_from_interview_live_config", false);
            this.N = bundle.getBoolean("is_from_my_god_config", false);
            this.X = bundle.getInt("extra_pb_is_attention_key", -1);
            this.W = bundle.getInt("extra_pb_funs_count_key", -1);
            this.A = bundle.getBoolean("from_frs", false);
            this.B = bundle.getBoolean("from_maintab", false);
            this.r0 = bundle.getBoolean("from_smart_frs", false);
            this.O = bundle.getBoolean("from_hottopic", false);
            this.J0 = bundle.getBoolean(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
            this.j = bundle.getString("high_light_post_id");
            this.P0 = bundle.getString("key_ori_ugc_nid");
            this.Q0 = bundle.getString("key_ori_ugc_tid");
            this.R0 = bundle.getInt("key_ori_ugc_type", 0);
            this.Y0 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.S0 = bundle.getString("key_ori_ugc_vid");
            this.Y = bundle.getInt("request_code", -1) == 18003;
            this.T0 = bundle.getString(PbActivityConfig.KEY_REC_WEIGHT);
            this.U0 = bundle.getString(PbActivityConfig.KEY_REC_SOURCE);
            this.V0 = bundle.getString(PbActivityConfig.KEY_REC_AB_TAG);
            this.W0 = bundle.getString(PbActivityConfig.KEY_REC_EXTRA);
        }
    }

    public void initWithIntent(Intent intent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048675, this, intent) == null) || intent == null) {
            return;
        }
        this.f19421e = intent.getStringExtra("thread_id");
        this.f19422f = intent.getBooleanExtra(PbActivityConfig.KEY_IS_PRIVACY, false);
        this.P0 = intent.getStringExtra("key_ori_ugc_nid");
        this.Q0 = intent.getStringExtra("key_ori_ugc_tid");
        this.R0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.S0 = intent.getStringExtra("key_ori_ugc_vid");
        this.Y0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.Z0 = intent.getStringExtra(PbActivityConfig.KEY_OFFICIAL_BAR_MESSAGE_ID);
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        this.X0 = uri != null ? uri.toString() : null;
        this.a1 = false;
        if (d.a.o0.a.g.c(uri)) {
            this.a1 = true;
            d.a.o0.a.g.b().f(uri, this.b1);
        } else if (StringUtils.isNull(this.f19421e)) {
            this.a1 = true;
            this.u0.b(intent, this.b1);
            if (uri != null) {
                if (StringUtils.isNull(this.f19421e)) {
                    this.f19421e = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.P0)) {
                    this.P0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.Q0)) {
                    this.Q0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.R0 == 0) {
                    this.R0 = d.a.c.e.m.b.d(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.S0)) {
                    this.S0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        if (d.a.c.e.p.k.isEmpty(this.f19421e)) {
            this.f19421e = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.D0 = intExtra;
        if (intExtra == 0) {
            this.D0 = this.u0.f57167a;
        }
        this.f19423g = intent.getStringExtra("post_id");
        this.f19424h = intent.getStringExtra("forum_id");
        this.f19425i = intent.getStringExtra("from_forum_id");
        intent.getStringExtra(PbActivityConfig.KEY_GOD_REPLY_ID);
        this.k = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.l = intent.getBooleanExtra("host_only", false);
        this.n = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.o = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = d.a.o0.r.d0.b.j().k("key_pb_current_sort_type", 2);
        }
        this.o = intExtra2;
        this.f19423g = intExtra2 != 2 ? this.f19423g : "0";
        this.mStType = intent.getStringExtra("st_type");
        this.P = intent.getStringExtra("locate");
        this.r = intent.getIntExtra("is_good", 0);
        this.s = intent.getIntExtra("is_top", 0);
        this.t = intent.getLongExtra("thread_time", 0L);
        this.C = intent.getBooleanExtra("from_mark", false);
        this.D = intent.getBooleanExtra(PbActivityConfig.KEY_SHOULD_ADD_POST_ID, false);
        this.E = intent.getBooleanExtra("is_pb_key_need_post_id", false);
        this.y = intent.getBooleanExtra("is_ad", false);
        this.z = intent.getBooleanExtra("is_sub_pb", false);
        this.G = intent.getBooleanExtra("is_pv", false);
        this.F = intent.getLongExtra("msg_id", 0L);
        this.H = intent.getStringExtra("from_forum_name");
        this.V = intent.getStringExtra("extra_pb_cache_key");
        this.S = intent.getStringExtra("op_type");
        this.T = intent.getStringExtra("op_url");
        this.U = intent.getStringExtra("op_stat");
        this.L = intent.getBooleanExtra("is_from_thread_config", false);
        this.M = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.N = intent.getBooleanExtra("is_from_my_god_config", false);
        this.X = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.W = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.A = intent.getBooleanExtra("from_frs", false);
        this.B = intent.getBooleanExtra("from_maintab", false);
        this.r0 = intent.getBooleanExtra("from_smart_frs", false);
        this.O = intent.getBooleanExtra("from_hottopic", false);
        this.x0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.J0 = intent.getBooleanExtra(PbActivityConfig.KEY_IS_SHARE_THREAD, false);
        this.j = intent.getStringExtra("high_light_post_id");
        this.O0 = intent.getBooleanExtra(PbActivityConfig.KEY_NEED_PRELOAD, false);
        this.Y = intent.getIntExtra("request_code", -1) == 18003;
        this.T0 = intent.getStringExtra(PbActivityConfig.KEY_REC_WEIGHT);
        this.U0 = intent.getStringExtra(PbActivityConfig.KEY_REC_SOURCE);
        this.V0 = intent.getStringExtra(PbActivityConfig.KEY_REC_AB_TAG);
        this.W0 = intent.getStringExtra(PbActivityConfig.KEY_REC_EXTRA);
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) ? this.f19422f : invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) ? this.J0 : invokeV.booleanValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) ? this.A : invokeV.booleanValue;
    }

    public boolean j1(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048679, this, str)) == null) {
            if (D0() != null && D0().N() != null && D0().N().H() != null && !StringUtils.isNull(str)) {
                String userId = D0().N().H().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) ? this.O : invokeV.booleanValue;
    }

    public void k1(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048681, this, forumData, cVar) == null) {
            str = "";
            if (forumData != null) {
                String id = !TextUtils.isEmpty(forumData.getId()) ? forumData.getId() : "";
                str2 = TextUtils.isEmpty(forumData.getName()) ? "" : forumData.getName();
                str = id;
            } else {
                str2 = "";
            }
            this.A0.z(str, str2, cVar);
        }
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) ? "hot_topic".equals(this.mStType) : invokeV.booleanValue;
    }

    public boolean l1(boolean z) {
        InterceptResult invokeZ;
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048683, this, z)) == null) {
            if (this.f19421e == null || (eVar = this.I) == null) {
                return false;
            }
            if (z || eVar.x().b() != 0) {
                return J1(1);
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) ? this.B : invokeV.booleanValue;
    }

    public void m1(d.a.p0.h2.h.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048685, this, eVar) == null) || eVar == null) {
            return;
        }
        this.f19421e = eVar.P();
        if (eVar.N() != null && eVar.N().J() != null) {
            BaijiahaoData J = eVar.N().J();
            this.P0 = J.oriUgcNid;
            this.Q0 = J.oriUgcTid;
            this.R0 = J.oriUgcType;
            this.S0 = J.oriUgcVid;
        } else {
            this.P0 = null;
            this.Q0 = null;
            this.R0 = 0;
            this.S0 = null;
        }
        this.f19423g = null;
        this.l = false;
        this.n = true;
        LoadData();
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public void n1(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048687, this, str) == null) || StringUtils.isNull(str)) {
            return;
        }
        this.f19421e = str;
        this.f19423g = null;
        this.l = false;
        this.n = true;
        LoadData();
    }

    public int o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) ? this.r : invokeV.intValue;
    }

    public boolean o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            if (this.f19421e == null || this.f19423g == null) {
                return false;
            }
            cancelMessage();
            if (this.C) {
                return J1(4);
            }
            return J1(6);
        }
        return invokeV.booleanValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null) {
                return false;
            }
            return eVar.s();
        }
        return invokeV.booleanValue;
    }

    public boolean p1(boolean z) {
        InterceptResult invokeZ;
        d.a.p0.h2.h.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048691, this, z)) == null) {
            if (this.f19421e == null || (eVar = this.I) == null || ((!z && eVar.x().c() == 0) || this.I.E() == null || this.I.E().size() < 1)) {
                return false;
            }
            return J1(2);
        }
        return invokeZ.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public void q1(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048693, this, bVar) == null) || bVar == null) {
            return;
        }
        if (this.B0 == null) {
            this.B0 = new GetSugMatchWordsModel(this.a0.getPageContext());
        }
        this.B0.y(bVar);
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) ? this.z : invokeV.booleanValue;
    }

    public boolean r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            String str = this.f19423g;
            if (str != null && !str.equals("0") && this.f19423g.length() != 0) {
                return o1();
            }
            return LoadData();
        }
        return invokeV.booleanValue;
    }

    public int s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) ? this.s : invokeV.intValue;
    }

    public final void s1() {
        d.a.p0.h3.j0.b bVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048697, this) == null) || (bVar = this.Z) == null) {
            return;
        }
        bVar.a();
        this.Z = null;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null) {
                return false;
            }
            return eVar.k0();
        }
        return invokeV.booleanValue;
    }

    public void t1() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048699, this) == null) || !"personalize_page".equals(this.mStType) || this.I == null || this.n0 == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        TiebaStatic.log(new StatisticItem("c10754").param("fid", this.I.n()).param("tid", this.f19421e).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.n0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
        this.n0 = 0L;
    }

    public final String u0(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048700, this, arrayList)) == null) {
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

    public void u1() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048701, this) == null) && "personalize_page".equals(this.mStType)) {
            this.n0 = System.currentTimeMillis() / 1000;
        }
    }

    public int v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) ? this.I0 : invokeV.intValue;
    }

    public void v1(d.a.p0.h2.h.e eVar, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048703, this, eVar, i2, str) == null) {
            this.k0 = true;
            if (eVar == null || eVar.f56900h != null) {
                return;
            }
            f2(eVar);
            P(eVar);
            if (eVar.N() != null) {
                eVar.N().j3(0);
            }
            g gVar = this.R;
            if (gVar == null || eVar == null) {
                return;
            }
            gVar.c(true, 0, i2, 0, eVar, str, 0);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048704, this)) == null) ? this.l0 : (String) invokeV.objValue;
    }

    public int w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) ? this.H0 : invokeV.intValue;
    }

    public void w1(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048706, this, i2) == null) {
            B1(i2);
            ArrayList<PostData> E = this.I.E();
            boolean z = false;
            this.j0 = false;
            if (i2 != 1) {
                if (i2 == 2) {
                    while (E.size() + 30 > d.a.o0.t.e.a()) {
                        E.remove(E.size() - 1);
                        z = true;
                    }
                    if (z) {
                        this.I.x().l(1);
                        return;
                    }
                    return;
                }
                return;
            }
            boolean z2 = false;
            while (E.size() + 30 > d.a.o0.t.e.a()) {
                E.remove(0);
                z2 = true;
            }
            if (z2) {
                this.I.x().m(1);
                g gVar = this.R;
                if (gVar != null) {
                    gVar.b(this.I);
                }
            }
            this.i0 = System.currentTimeMillis();
            this.j0 = true;
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048707, this, str)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null || eVar.N() == null || this.I.m() == null) {
                return null;
            }
            WriteData writeData = new WriteData();
            if (this.I.N().b2()) {
                writeData.setForumId("0");
                writeData.setForumName("");
            } else {
                writeData.setForumId(this.I.m().getId());
                writeData.setForumName(this.I.m().getName());
            }
            writeData.setFromForumId(this.f19425i);
            writeData.sourceFrom = String.valueOf(this.D0);
            writeData.setThreadId(this.f19421e);
            writeData.setIsAd(this.y);
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

    public MarkData x0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048708, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.f19421e);
            markData.setPostId(postData.E());
            markData.setTime(date.getTime());
            markData.setHostMode(this.l);
            markData.setSequence(Boolean.valueOf(f1()));
            markData.setId(this.f19421e);
            markData.setFloor(postData.A());
            markData.setForumId(this.f19424h);
            if (postData instanceof o) {
                o oVar = (o) postData;
                markData.setApp(oVar.getAdvertAppInfo() != null && oVar.getAdvertAppInfo().t4());
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void x1(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048709, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.t0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            z1(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) ? r1() : invokeV.booleanValue;
    }

    public String y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            d.a.p0.h2.h.e eVar = this.I;
            if (eVar == null || !eVar.s()) {
                return null;
            }
            return this.I.u();
        }
        return (String) invokeV.objValue;
    }

    public void y1(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048712, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.t0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            z1(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public e0 z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) ? this.w0 : (e0) invokeV.objValue;
    }

    public void z1(d.a.p0.h2.h.e eVar, int i2, boolean z, int i3, String str, boolean z2, int i4, long j, long j2) {
        d.a.p0.h2.h.e eVar2;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048714, this, new Object[]{eVar, Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(i3), str, Boolean.valueOf(z2), Integer.valueOf(i4), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i5 = i3;
                eVar2 = null;
            } else {
                eVar2 = eVar;
                i5 = i3;
            }
            this.s0 = i5;
            this.isLoading = false;
            if (eVar2 != null) {
                P(eVar2);
            }
            M(eVar2);
            o oVar = this.N0;
            if (oVar != null && oVar.G0()) {
                TiebaStatic.log(d.a.p0.g3.a.h("a005", "common_fill", true, 1));
            }
            A1(eVar2, i2, z, i3, str, z2, i4, j, j2, false);
        }
    }
}
