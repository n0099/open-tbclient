package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
import com.baidu.tbadk.core.log.Logger;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.GodUserData;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.az9;
import com.baidu.tieba.bh5;
import com.baidu.tieba.bi;
import com.baidu.tieba.h80;
import com.baidu.tieba.hg5;
import com.baidu.tieba.if7;
import com.baidu.tieba.je9;
import com.baidu.tieba.jh9;
import com.baidu.tieba.kh9;
import com.baidu.tieba.lg;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mx9;
import com.baidu.tieba.ne9;
import com.baidu.tieba.ng9;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.qba;
import com.baidu.tieba.rba;
import com.baidu.tieba.rg9;
import com.baidu.tieba.s9a;
import com.baidu.tieba.sd9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.sr6;
import com.baidu.tieba.t25;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.td5;
import com.baidu.tieba.td9;
import com.baidu.tieba.th9;
import com.baidu.tieba.wb9;
import com.baidu.tieba.yba;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
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
    public static final String SHOUBAI = "shoubai";
    public static final int SORT_TYPE_ASC = 0;
    public static final int SORT_TYPE_DESC = 1;
    public static final int SORT_TYPE_HOT = 2;
    public static final String UNIDISPATCH_PB = "unidispatch/pb";
    public static final int UPDATE_TYPE_MARK = 4;
    public static final int UPDATE_TYPE_MORE = 1;
    public static final int UPDATE_TYPE_PREVIOUS = 2;
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_REDIRECT_PAGE = 5;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_SWITCH_HOST_MODE = 9;
    public static final int UPDATE_TYPE_UPDATE = 3;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;
    public static final String WISE = "wise";
    public static String x1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean A0;
    public boolean B;
    public int B0;
    public boolean C;
    public String C0;
    public long D;
    public rba D0;
    public boolean E;
    public rba E0;
    public String F;
    public int F0;
    public td9 G;
    public int G0;
    public int H;
    public boolean H0;
    public boolean I;
    public String I0;
    public boolean J;
    public qba J0;
    public boolean K;
    public boolean K0;
    public boolean L;
    public String L0;
    public String M;
    public String M0;
    public h N;
    public int N0;
    public String O;
    public String O0;
    public String P;
    public String P0;
    public String Q;
    public String Q0;
    public String R;
    public String R0;
    public int S;
    public String S0;

    /* renamed from: T  reason: collision with root package name */
    public int f1146T;
    public String T0;
    public boolean U;
    public String U0;
    public yba V;
    public String V0;
    public BaseFragmentActivity W;
    public boolean W0;
    public boolean X;
    public int X0;
    public boolean Y;
    public String Y0;
    public long Z;
    public int Z0;
    public int a;
    public boolean a0;
    public boolean a1;
    public String b;
    public boolean b0;
    public boolean b1;
    public boolean c;
    public String c0;
    public String c1;
    public String d;
    public String d0;
    public String d1;
    public String e;
    public long e0;
    public String e1;
    public String f;
    public boolean f0;
    public boolean f1;
    public String g;
    public int g0;
    public boolean g1;
    public String h;
    public boolean h0;
    public boolean h1;
    public boolean i;
    public boolean i0;
    public boolean i1;
    public boolean isLoading;
    public boolean isReplyResultNotificationH5;
    public boolean j;
    public int j0;
    public boolean j1;
    public boolean k;
    public boolean k1;
    public boolean l;
    public int l1;
    public int m;
    public String m1;
    public String mStType;
    public String mTopicId;
    public String mTopicSubjectName;
    public int n;
    public boolean n1;
    public boolean o;
    public int o1;
    public int p;
    public String p1;
    public int q;
    public String q1;
    public long r;
    public sd9 r0;
    public BdUniDispatchSchemeController.OnSchemeParsedCallback r1;
    public int s;
    public final jh9 s0;
    public CustomMessageListener s1;
    public String showReplyPanel;
    public int t;
    public final rg9 t0;
    public NetMessageListener t1;
    public int u;
    public final kh9 u0;
    public CustomMessageListener u1;
    public int v;
    public String v0;
    public CustomMessageListener v1;
    public boolean w;
    public final CheckRealNameModel w0;
    public PraiseData w1;
    public boolean x;
    public final AddExperiencedModel x0;
    public boolean y;
    public SuggestEmotionModel y0;
    public boolean z;
    public GetSugMatchWordsModel z0;

    /* loaded from: classes7.dex */
    public interface h {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(td9 td9Var);

        void c(boolean z, int i, int i2, int i3, td9 td9Var, String str, int i4);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(323112716, "Lcom/baidu/tieba/pb/pb/main/PbModel;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(323112716, "Lcom/baidu/tieba/pb/pb/main/PbModel;");
        }
    }

    public final int L2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048611, this, i)) == null) {
            if (i != 1) {
                return i != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public int u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes7.dex */
    public class g implements h80.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbModel b;

        /* loaded from: classes7.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ ResponsedMessage a;
            public final /* synthetic */ g b;

            public a(g gVar, ResponsedMessage responsedMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar, responsedMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.b = gVar;
                this.a = responsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                td9 pbData;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ResponsedMessage responsedMessage = this.a;
                    boolean z = true;
                    if ((responsedMessage instanceof pbPageHttpResponseMessage) && (pbData = ((pbPageHttpResponseMessage) responsedMessage).getPbData()) != null) {
                        String Q = pbData.Q();
                        if (!TextUtils.isEmpty(this.b.b.b) && this.b.b.b.equals(Q)) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.b.b();
                    } else if (this.b.b.t1 != null) {
                        this.b.b.t1.onMessage(this.a);
                    }
                }
            }
        }

        /* loaded from: classes7.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ g a;

            public b(g gVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {gVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    g gVar = this.a;
                    gVar.b.K2(gVar.a);
                }
            }
        }

        public g(PbModel pbModel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbModel;
            this.a = i;
        }

        @Override // com.baidu.tieba.h80.b
        public void a(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                lg.g(new a(this, responsedMessage));
            }
        }

        @Override // com.baidu.tieba.h80.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                lg.g(new b(this));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class a implements BdUniDispatchSchemeController.OnSchemeParsedCallback {
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
                this.a.L0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.M0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.N0 = JavaTypesHelper.toInt((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.O0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_SHOW_REPLY_PANEL) instanceof String) {
                this.a.showReplyPanel = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_SHOW_REPLY_PANEL);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_PUSH_TYPE) instanceof String) {
                this.a.P0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_PUSH_TYPE);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_SOURCE) instanceof String) {
                this.a.Q0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_SOURCE);
            }
        }
    }

    /* loaded from: classes7.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                SignData signData = (SignData) customResponsedMessage.getData();
                if (this.a.s1() != null && this.a.s1().k() != null && this.a.s1().k().getSignData() != null && signData.forumId.equals(this.a.s1().l())) {
                    this.a.s1().k().getSignData().is_signed = signData.is_signed;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if (!z2 && !(responsedMessage instanceof pbPageHttpResponseMessage)) {
                    return;
                }
                if (responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId() && responsedMessage.getOrginalMessage().getTag() != h80.d) {
                    return;
                }
                if (responsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.W.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    this.a.B2((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    this.a.A2((pbPageHttpResponseMessage) responsedMessage);
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
                if (!this.a.X || !this.a.Y) {
                    if (!this.a.X) {
                        this.a.X = true;
                    } else {
                        this.a.Y = true;
                    }
                    if (this.a.N != null) {
                        this.a.N.a(this.a.u1(), z, responsedMessage, this.a.a0, System.currentTimeMillis() - this.a.Z);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                td9 td9Var = this.a.G;
                if (td9Var != null && td9Var.g() != null && this.a.G.g().b() != null && this.a.G.g().b().equals(valueOf)) {
                    this.a.G.g().n(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
                td9 td9Var = this.a.G;
                if (td9Var != null && td9Var.g() != null && this.a.G.g().b() != null && this.a.G.g().b().equals(valueOf)) {
                    this.a.G.g().n(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ td9 a;
        public final /* synthetic */ PbModel b;

        public f(PbModel pbModel, td9 td9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, td9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pbModel;
            this.a = td9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.D2(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.b.isLoading = false;
            }
        }
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
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 4;
        this.mStType = null;
        this.b = null;
        this.c = false;
        this.d = null;
        this.e = null;
        this.g = null;
        this.h = "";
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
        this.I = false;
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
        this.f1146T = -1;
        this.V = null;
        this.X = false;
        this.Y = false;
        this.c0 = null;
        this.d0 = null;
        this.e0 = 0L;
        this.f0 = false;
        this.g0 = -1;
        this.i0 = false;
        this.A0 = false;
        this.B0 = 0;
        this.K0 = false;
        this.X0 = 3;
        this.Z0 = 0;
        this.i1 = false;
        this.j1 = false;
        this.k1 = false;
        this.l1 = -1;
        this.m1 = null;
        this.n1 = false;
        this.isReplyResultNotificationH5 = false;
        this.o1 = 0;
        this.s1 = new b(this, 2001222);
        this.t1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.u1 = new d(this, 2001336);
        this.v1 = new e(this, 2001335);
        this.w1 = null;
        td9 td9Var = new td9();
        this.G = td9Var;
        td9Var.E0(0);
        this.W = baseFragmentActivity;
        this.s0 = new jh9();
        this.t0 = new rg9(this, this.W);
        this.u0 = new kh9(this, this.W);
        this.w0 = new CheckRealNameModel(this.W.getPageContext());
        this.y0 = new SuggestEmotionModel();
        this.x0 = new AddExperiencedModel(this.W.getPageContext());
        this.r1 = new a(this);
    }

    public void O2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048620, this, bundle) == null) {
            bundle.putString("thread_id", this.b);
            bundle.putString("post_id", this.d);
            bundle.putString("forum_id", this.e);
            bundle.putString("from_forum_id", this.f);
            bundle.putInt("key_start_from", this.B0);
            bundle.putBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", this.i);
            bundle.putBoolean("host_only", this.j);
            bundle.putBoolean("squence", this.l);
            bundle.putInt("sort_type", this.m);
            bundle.putString("st_type", this.mStType);
            bundle.putString("locate", this.M);
            bundle.putInt("is_good", this.p);
            bundle.putInt("is_top", this.q);
            bundle.putLong("thread_time", this.r);
            bundle.putBoolean("from_mark", this.A);
            bundle.putBoolean("is_pb_key_need_post_id", this.C);
            bundle.putBoolean("is_sub_pb", this.x);
            bundle.putBoolean("is_ad", this.w);
            bundle.putBoolean("is_pv", this.E);
            bundle.putLong("msg_id", this.D);
            bundle.putString("extra_pb_cache_key", this.R);
            bundle.putBoolean("is_from_thread_config", this.I);
            bundle.putBoolean("is_from_interview_live_config", this.J);
            bundle.putBoolean("is_from_my_god_config", this.K);
            bundle.putInt("extra_pb_is_attention_key", this.f1146T);
            bundle.putInt("extra_pb_funs_count_key", this.S);
            bundle.putBoolean("from_frs", this.y);
            bundle.putBoolean("from_maintab", this.z);
            bundle.putBoolean("from_smart_frs", this.i0);
            bundle.putBoolean("from_hottopic", this.L);
            bundle.putBoolean("key_is_share_thread", this.H0);
            bundle.putString("key_ori_ugc_nid", this.L0);
            bundle.putString("key_ori_ugc_tid", this.M0);
            bundle.putInt("key_ori_ugc_type", this.N0);
            bundle.putString("key_ori_ugc_vid", this.O0);
            bundle.putString("key_rec_weight", this.R0);
            bundle.putString("key_rec_source", this.S0);
            bundle.putString("key_rec_ab_tag", this.T0);
            bundle.putString("key_rec_extra", this.U0);
            bundle.putBoolean("key_is_tieba_plus", this.b1);
            bundle.putString("key_tieba_plus_order_id", this.c1);
            bundle.putString("key_tieba_plus_token", this.d1);
            bundle.putString("key_tieba_extra_param", this.e1);
            bundle.putBoolean("key_tieba_plus_cant_delete", this.f1);
            bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.g1);
            bundle.putBoolean("is_jump_from_video_tab", this.i1);
            bundle.putBoolean("is_jump_from_video_middle", this.j1);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbModel(BaseFragmentActivity baseFragmentActivity, Intent intent, h hVar) {
        this(baseFragmentActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, intent, hVar};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((BaseFragmentActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        W1(intent);
        Y2(hVar);
        J2();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PbModel(BaseFragmentActivity baseFragmentActivity, Bundle bundle, h hVar) {
        this(baseFragmentActivity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragmentActivity, bundle, hVar};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((BaseFragmentActivity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        V1(bundle);
        Y2(hVar);
        J2();
    }

    public void R2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048632, this, i, i2) == null) {
            this.F0 = i;
            this.G0 = i2;
        }
    }

    public final void s0(PbPageRequestMessage pbPageRequestMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048730, this, pbPageRequestMessage, j) == null) && pbPageRequestMessage != null && !UbsABTestHelper.isPbReplyOptimize()) {
            pbPageRequestMessage.setLastPid(j);
        }
    }

    public void B0(td9 td9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, td9Var) != null) || td9Var == null) {
            return;
        }
        if (this.K || this.I || this.J) {
            td9Var = h3(td9Var);
        }
        G2(td9Var);
    }

    public void M2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i) == null) {
            this.s = i;
            this.t = i;
            this.u = i;
        }
    }

    public void S2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
            this.d0 = str;
        }
    }

    public void T2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i) == null) {
            this.Z0 = i;
        }
    }

    public void U2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i) == null) {
            this.X0 = i;
        }
    }

    public void V2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048647, this, i) == null) {
            this.p = i;
        }
    }

    public void W2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.q = i;
        }
    }

    public void Y2(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, hVar) == null) {
            this.N = hVar;
        }
    }

    public void Z2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i) == null) {
            this.B0 = i;
            F2();
        }
    }

    public void a3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048665, this, str) == null) {
            this.I0 = str;
        }
    }

    public void c3(int i) {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048671, this, i) == null) && (td9Var = this.G) != null) {
            td9Var.P0(i);
        }
    }

    public void d3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048676, this, z) == null) {
            this.h1 = z;
        }
    }

    public void f3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048683, this, i) == null) {
            this.a = i;
        }
    }

    public void i3(boolean z) {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048696, this, z) == null) && (td9Var = this.G) != null) {
            td9Var.I0(z);
        }
    }

    public final void n3(@NonNull td9 td9Var) {
        td9 td9Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048714, this, td9Var) == null) && (td9Var2 = this.G) != null) {
            td9Var2.d().clear();
            this.G.d().addAll(td9Var.d());
        }
    }

    public boolean p2(boolean z) {
        InterceptResult invokeZ;
        td9 td9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048720, this, z)) == null) {
            if (this.b == null || (td9Var = this.G) == null) {
                return false;
            }
            if (!z && td9Var.y().b() == 0) {
                return false;
            }
            return P2(1);
        }
        return invokeZ.booleanValue;
    }

    public final void q0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048722, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (UtilHelper.isUgcThreadType(this.N0)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.e);
        }
    }

    public final void r0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048726, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (this.B0 == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
    }

    public void s2(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048732, this, bVar) != null) || bVar == null) {
            return;
        }
        if (this.z0 == null) {
            this.z0 = new GetSugMatchWordsModel(this.W.getPageContext());
        }
        this.z0.P(bVar);
    }

    public final void v0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048739, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = this.B0;
        if (i != 7 && i != 5 && !this.a1) {
            pbPageRequestMessage.setSourceType(2);
        } else {
            pbPageRequestMessage.setSourceType(1);
        }
    }

    public void A0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if ((!this.j || m2(TbadkCoreApplication.getCurrentAccount())) && this.G.F() != null) {
                this.G.y().l(1);
                if (this.G.y().b() == 0) {
                    this.G.y().l(1);
                }
                this.C0 = str;
                P2(8);
            }
        }
    }

    public final void X2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048655, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(R0()) || mx9.m().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(mx9.m().b().e(R0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(mx9.m().b().d(R0(), true));
    }

    public final boolean Y1(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, td9Var)) == null) {
            if (td9Var == null || ListUtils.isEmpty(td9Var.F()) || this.G.O() == null || TextUtils.isEmpty(this.G.O().getFirstPostId())) {
                return false;
            }
            return TextUtils.equals(this.G.O().getFirstPostId(), td9Var.F().get(0).S());
        }
        return invokeL.booleanValue;
    }

    public final void b3(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(R0()) || mx9.m().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(mx9.m().b().d(R0(), true) + 1);
        pbPageRequestMessage.setLoadCount(mx9.m().b().e(R0(), true));
    }

    public void e3(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048680, this, uri) == null) {
            boolean z = false;
            if (uri == null) {
                this.k1 = false;
                return;
            }
            String queryParameter = uri.getQueryParameter("obj_source");
            String uri2 = uri.toString();
            if (!TextUtils.isEmpty(uri2) && uri2.contains(UNIDISPATCH_PB) && ("shoubai".equals(queryParameter) || WISE.equals(queryParameter))) {
                z = true;
            }
            this.k1 = z;
            if ("shoubai".equals(queryParameter)) {
                this.l1 = 5;
            } else if (WISE.equals(queryParameter)) {
                this.l1 = 4;
            } else {
                this.l1 = -1;
            }
            this.m1 = uri.getQueryParameter(TiebaStatic.Params.EQID);
        }
    }

    public boolean m2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048710, this, str)) == null) {
            if (s1() == null || s1().O() == null || s1().O().getAuthor() == null || StringUtils.isNull(str)) {
                return false;
            }
            String userId = s1().O().getAuthor().getUserId();
            if (StringUtils.isNull(userId)) {
                return false;
            }
            return userId.equals(str);
        }
        return invokeL.booleanValue;
    }

    public boolean m3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i)) == null) {
            if (i == this.m) {
                return false;
            }
            if (i != 1) {
                SharedPrefHelper.getInstance().putInt("key_pb_current_sort_type", i);
            }
            boolean z = this.l;
            this.k = z;
            this.n = this.m;
            this.m = i;
            this.l = !z;
            if (i == 2 && this.A) {
                this.d = "0";
            }
            if (!this.isLoading && loadData()) {
                return true;
            }
            this.l = !this.l;
            this.m = this.n;
            return false;
        }
        return invokeI.booleanValue;
    }

    public final void p0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048718, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = -1;
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() != this.v) {
                    i = G0();
                }
            } else if (pbPageRequestMessage.getPn().intValue() != 1) {
                i = G0();
            }
        } else {
            i = 0;
        }
        pbPageRequestMessage.setAfterAdThreadCount(i);
    }

    public String A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.S0;
        }
        return (String) invokeV.objValue;
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.R0;
        }
        return (String) invokeV.objValue;
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null) {
                return td9Var.J();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return j2();
        }
        return invokeV.booleanValue;
    }

    public AddExperiencedModel F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.x0;
        }
        return (AddExperiencedModel) invokeV.objValue;
    }

    public String F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            int i = this.B0;
            if (i == 10) {
                this.q1 = PbActivityConfig.MY_COLLECTION_STORY;
            } else if (i == 11) {
                this.q1 = PbActivityConfig.MY_HISTORY_STORY;
            }
            if (TextUtils.isEmpty(this.q1)) {
                this.q1 = "story_tieba_default";
            }
        }
    }

    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public sd9 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.r0;
        }
        return (sd9) invokeV.objValue;
    }

    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.m1;
        }
        return (String) invokeV.objValue;
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.l1;
        }
        return invokeV.intValue;
    }

    public BaijiahaoData J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null && td9Var.O() != null) {
                return this.G.O().getBaijiahaoData();
            }
            return null;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            registerListener(this.t1);
            registerListener(this.s1);
            registerListener(this.v1);
            registerListener(this.u1);
        }
    }

    public qba K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.J0;
        }
        return (qba) invokeV.objValue;
    }

    public int K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.q1;
        }
        return (String) invokeV.objValue;
    }

    public boolean L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return j2();
        }
        return invokeV.booleanValue;
    }

    public CheckRealNameModel M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.w0;
        }
        return (CheckRealNameModel) invokeV.objValue;
    }

    public String M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public rg9 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.t0;
        }
        return (rg9) invokeV.objValue;
    }

    public String N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.L0;
        }
        return (String) invokeV.objValue;
    }

    public rba O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.D0;
        }
        return (rba) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.c0;
        }
        return (String) invokeV.objValue;
    }

    public rba P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.E0;
        }
        return (rba) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.d0;
        }
        return (String) invokeV.objValue;
    }

    public String Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.mTopicSubjectName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.e1;
        }
        return (String) invokeV.objValue;
    }

    public String R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null && td9Var.O() != null) {
                return this.G.O().worksInfoData;
            }
            return null;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.c1;
        }
        return (String) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.d1;
        }
        return (String) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null && !ListUtils.isEmpty(td9Var.F())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.b1;
        }
        return invokeV.booleanValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.X0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.f1;
        }
        return invokeV.booleanValue;
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public void X1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048654, this) == null) {
            ng9.b().d(P0(), this.A);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return t2();
        }
        return invokeV.booleanValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.L;
        }
        return invokeV.booleanValue;
    }

    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return "hot_topic".equals(this.mStType);
        }
        return invokeV.booleanValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.g1;
        }
        return invokeV.booleanValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            if (12 != this.W.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) && 12 != this.B0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.n1;
        }
        return invokeV.booleanValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null && td9Var.k() != null && this.G.O() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var == null) {
                return false;
            }
            return td9Var.q();
        }
        return invokeV.booleanValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.j1;
        }
        return invokeV.booleanValue;
    }

    public boolean e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.i1;
        }
        return invokeV.booleanValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (!TextUtils.isEmpty(this.g) && !"0".equals(this.g)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.j0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048688, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048689, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.mTopicId;
        }
        return (String) invokeV.objValue;
    }

    public boolean h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var == null) {
                return false;
            }
            return td9Var.w0();
        }
        return invokeV.booleanValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.U;
        }
        return invokeV.booleanValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return x1;
        }
        return (String) invokeV.objValue;
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.H0;
        }
        return invokeV.booleanValue;
    }

    public final boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            int i = this.m;
            if (i != 0 && i != 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            if (j2() && this.G.y().b() == 0) {
                p2(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.G0;
        }
        return invokeV.intValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.k1;
        }
        return invokeV.booleanValue;
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.F0;
        }
        return invokeV.intValue;
    }

    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null && td9Var.q()) {
                return this.G.u();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public void n2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048713, this) == null) {
            x1 = null;
        }
    }

    public kh9 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.u0;
        }
        return (kh9) invokeV.objValue;
    }

    public t25 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var == null) {
                return null;
            }
            return td9Var.y();
        }
        return (t25) invokeV.objValue;
    }

    public boolean q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            if (this.b != null && this.d != null) {
                cancelMessage();
                if (this.A) {
                    return P2(4);
                }
                return P2(6);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.B0;
        }
        return invokeV.intValue;
    }

    public td9 s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.G;
        }
        return (td9) invokeV.objValue;
    }

    public td9 t1() {
        InterceptResult invokeV;
        qba qbaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var == null) {
                return td9Var;
            }
            if (!U1() && (qbaVar = this.J0) != null) {
                this.G.M0(qbaVar);
            }
            return this.G;
        }
        return (td9) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            String str = this.d;
            if (str != null && !str.equals("0") && this.d.length() != 0) {
                return q2();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public final void u2() {
        yba ybaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048738, this) == null) && (ybaVar = this.V) != null) {
            ybaVar.a();
            this.V = null;
        }
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return this.v0;
        }
        return (String) invokeV.objValue;
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            return this.I0;
        }
        return (String) invokeV.objValue;
    }

    public void w2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048744, this) == null) && "personalize_page".equals(this.mStType)) {
            this.e0 = System.currentTimeMillis() / 1000;
        }
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048745, this) == null) {
            this.J0 = null;
        }
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.p1;
        }
        return (String) invokeV.objValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
            return !TextUtils.isEmpty(this.h);
        }
        return invokeV.booleanValue;
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048748, this) == null) {
            this.h = "";
        }
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048749, this)) == null) {
            return this.T0;
        }
        return (String) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048751, this) == null) {
            this.g = null;
        }
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048752, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public void A2(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.r0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            C2(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void B2(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.r0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            C2(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public void D0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = W();
            threadData.tiebaPlusOrderId = S();
            threadData.tiebaPlusToken = T();
            threadData.tiebaPlusExtraParam = T();
            threadData.tiebaplusCantDelete = X();
            threadData.setDispatchedForumIdWithString(N());
        }
    }

    public MarkData I0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            td9 td9Var = this.G;
            if (td9Var == null) {
                return null;
            }
            ArrayList<rba> F = td9Var.F();
            if (ListUtils.isEmpty(F)) {
                return null;
            }
            if (F.size() > 0 && i >= F.size()) {
                i = F.size() - 1;
            }
            return m1(F.get(i));
        }
        return (MarkData) invokeI.objValue;
    }

    public String I2(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, td9Var)) == null) {
            String str = null;
            if (td9Var == null) {
                return null;
            }
            if (td9Var.O() != null && td9Var.O().getAuthor() != null) {
                str = td9Var.O().getAuthor().getUserId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public boolean g3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048686, this, i)) == null) {
            this.s = i;
            if (i > this.G.y().h()) {
                this.s = this.G.y().h();
            }
            if (this.s < 1) {
                this.s = 1;
            }
            if (this.b == null) {
                return false;
            }
            return P2(5);
        }
        return invokeI.booleanValue;
    }

    public td9 h3(td9 td9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, td9Var)) == null) {
            if (td9Var == null) {
                return null;
            }
            ThreadData O = td9Var.O();
            O.setIs_good(this.p);
            O.setIs_top(this.q);
            long j = this.r;
            if (j > 0) {
                O.setLast_time_int(j);
            }
            D0(O);
            return td9Var;
        }
        return (td9) invokeL.objValue;
    }

    public final String j1(ArrayList<rba> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                rba rbaVar = (rba) ListUtils.getItem(arrayList, i);
                if (rbaVar != null && !StringUtils.isNull(rbaVar.S())) {
                    return rbaVar.S();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean k3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, str)) == null) {
            this.j = !this.j;
            this.d = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (P2(9)) {
                return true;
            }
            this.j = !this.j;
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean r2(boolean z) {
        InterceptResult invokeZ;
        td9 td9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048728, this, z)) == null) {
            if (this.b == null || (td9Var = this.G) == null || ((!z && td9Var.y().c() == 0) || this.G.F() == null || this.G.F().size() < 1)) {
                return false;
            }
            return P2(2);
        }
        return invokeZ.booleanValue;
    }

    public void r3(td9 td9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048729, this, td9Var) != null) || td9Var == null) {
            return;
        }
        td9Var.U0(this.G.Z());
        td9 td9Var2 = this.G;
        if (!td9Var2.W && td9Var.W && td9Var2.h() != null) {
            td9Var.H0(this.G.h());
        }
        this.G = td9Var;
        M2(td9Var.y().a());
    }

    public void u0(t25 t25Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048736, this, t25Var) == null) {
            if (t25Var == null) {
                M2(1);
                return;
            }
            if (this.t < t25Var.a()) {
                this.t = t25Var.a();
            }
            if (this.u > t25Var.a()) {
                this.u = t25Var.a();
            }
            this.v = t25Var.h();
        }
    }

    public final void w0(td9 td9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048742, this, td9Var) == null) && td9Var != null && td9Var.z() != null && td9Var.z().getAdvertAppInfo() != null && td9Var.z().D1() && td9Var.z().getAdvertAppInfo().c != 1001) {
            this.J0 = td9Var.z();
        }
    }

    public td9 C0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, threadData)) == null) {
            td9 td9Var = new td9();
            td9Var.E0(3);
            if (threadData == null) {
                return null;
            }
            td9Var.R0(threadData);
            if (threadData.getForumData() != null) {
                td9Var.F0(threadData.getForumData());
                ForumData k = td9Var.k();
                k.setId(threadData.getForumData().b());
                k.setName(threadData.getForumData().d());
                k.setUser_level(threadData.getForumData().c());
                k.setImage_url(threadData.getForumData().a());
                k.setPost_num(threadData.getForumData().j);
                k.setMember_num(threadData.getForumData().k);
            } else {
                ForumData k2 = td9Var.k();
                k2.setId(String.valueOf(threadData.getFid()));
                k2.setName(threadData.getForum_name());
            }
            td9Var.Q0(threadData.getRobotEntrance());
            rba rbaVar = new rba();
            rbaVar.S0(1);
            rbaVar.o1(threadData.getCreateTime());
            rbaVar.N0(threadData.getAuthor());
            MetaData author = threadData.getAuthor();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(author.getUserId(), author);
            rbaVar.r1(hashMap);
            rbaVar.k1(TbRichTextView.a0(threadData.getFirstFloorList(), M1(), false));
            td9Var.G0(rbaVar);
            td9Var.F().add(rbaVar);
            td9Var.N0(new je9(threadData, null));
            td9Var.m = true;
            td9Var.J0(1);
            return td9Var;
        }
        return (td9) invokeL.objValue;
    }

    public void p3(UserPendantData userPendantData) {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048721, this, userPendantData) == null) && userPendantData != null && (td9Var = this.G) != null && td9Var.F() != null && this.G.F().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            int size = this.G.F().size();
            for (int i = 0; i < size; i++) {
                if (this.G.F().get(i) != null && this.G.F().get(i).r() != null && currentAccount.equals(this.G.F().get(i).r().getUserId()) && this.G.F().get(i).r().getPendantData() != null) {
                    this.G.F().get(i).r().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    this.G.F().get(i).r().getPendantData().setPropsId(userPendantData.getPropsId());
                }
            }
        }
    }

    public void C2(td9 td9Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        td9 td9Var2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{td9Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i4 = i2;
                td9Var2 = null;
            } else {
                td9Var2 = td9Var;
                i4 = i2;
            }
            this.j0 = i4;
            this.isLoading = false;
            if (td9Var2 != null) {
                B0(td9Var2);
            }
            w0(td9Var2);
            qba qbaVar = this.J0;
            if (qbaVar != null && qbaVar.D1()) {
                TiebaStatic.log(s9a.e("a005", "common_fill", true, 1));
            }
            D2(td9Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [boolean] */
    public void D2(td9 td9Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        ?? r3;
        int i4;
        int i5;
        boolean z4;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{td9Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z5 = !z;
            this.h0 = z3;
            yba ybaVar = this.V;
            if (ybaVar != null && !z3) {
                r3 = 1;
                ybaVar.b(z2, z5, i2, str, i3, j, j2);
                this.V = null;
            } else {
                r3 = 1;
            }
            td9 td9Var2 = this.G;
            if (td9Var2 != null) {
                td9Var2.Z = z3;
                td9Var2.a0 = i;
            }
            if (z5 && !z3 && !TextUtils.isEmpty(R0()) && mx9.m().b() != null) {
                mx9.m().b().g(R0(), L2(D1()), r3);
            }
            if (td9Var != null && (this.s != r3 || i != 5 || td9Var.F() == null || td9Var.F().size() >= r3)) {
                this.k = this.l;
                if (i != 8) {
                    this.n = this.m;
                    this.m = td9Var.g;
                }
                List<PbSortType> list = td9Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.W.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    td9Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.W.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = Integer.valueOf(r3 == true ? 1 : 0);
                    td9Var.f.add(builder2.build(false));
                    int i7 = this.n;
                    this.m = i7;
                    td9Var.g = i7;
                }
                this.E = false;
                if (td9Var.y() != null && (this.m != 2 || i != 8)) {
                    u0(td9Var.y());
                }
                int i8 = this.v;
                if (i8 < r3) {
                    i8 = 1;
                }
                this.v = i8;
                ArrayList<rba> F = this.G.F();
                switch (i) {
                    case 1:
                        this.G.L0(td9Var.y(), r3 == true ? 1 : 0);
                        q3(td9Var, F);
                        n3(td9Var);
                        o3();
                        i5 = 0;
                        break;
                    case 2:
                        if (td9Var.F() != null) {
                            i5 = td9Var.F().size() + (r3 == true ? 1 : 0);
                            rba rbaVar = (rba) ListUtils.getItem(F, 0);
                            rba rbaVar2 = (rba) ListUtils.getItem(td9Var.F(), ListUtils.getCount(td9Var.F()) - (r3 == true ? 1 : 0));
                            if (rbaVar != null && rbaVar2 != null && rbaVar.S().equals(rbaVar2.S())) {
                                td9Var.F().remove(rbaVar2);
                                i5--;
                            }
                            if (a2()) {
                                x1 = F.get(r3 == true ? 1 : 0).S();
                            }
                            F.addAll(0, td9Var.F());
                        } else {
                            i5 = 0;
                        }
                        n3(td9Var);
                        this.G.L0(td9Var.y(), 2);
                        o3();
                        break;
                    case 3:
                        if (this.m == r3 && td9Var.y() != null) {
                            td9Var.y().k(td9Var.y().h());
                        }
                        r3(td9Var);
                        i5 = 0;
                        break;
                    case 4:
                        r3(td9Var);
                        i5 = 0;
                        break;
                    case 5:
                        r3(td9Var);
                        i5 = 0;
                        break;
                    case 6:
                        r3(td9Var);
                        i5 = 0;
                        break;
                    case 7:
                        r3(td9Var);
                        i5 = 0;
                        break;
                    case 8:
                        if (Y1(td9Var)) {
                            return;
                        }
                        if (td9Var != null && !ListUtils.isEmpty(td9Var.F()) && this.G != null && (!this.j || I2(td9Var).equals(td9Var.F().get(0).r().getUserId()))) {
                            if (this.G.y().b() == 0) {
                                this.G.y().l(r3 == true ? 1 : 0);
                            }
                            N2();
                            this.D0 = td9Var.F().get(0);
                            if (!j2() && !this.G.j0()) {
                                if (this.F0 - this.G0 >= 3) {
                                    rba rbaVar3 = new rba();
                                    this.E0 = rbaVar3;
                                    rbaVar3.D = false;
                                    rbaVar3.i1(53);
                                    this.G.F().add(0, this.E0);
                                }
                                this.G.F().add(0, this.D0);
                                i6 = 0;
                            } else {
                                if (this.G.F().size() - this.F0 >= 3) {
                                    rba rbaVar4 = new rba();
                                    this.E0 = rbaVar4;
                                    rbaVar4.D = r3;
                                    rbaVar4.i1(53);
                                    this.G.F().add(this.E0);
                                }
                                this.G.F().add(this.D0);
                                i6 = this.G.F().size() - (r3 == true ? 1 : 0);
                            }
                            if (!StringHelper.isTaday(SharedPrefHelper.getInstance().getLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.D0.U = this.G.I();
                                SharedPrefHelper.getInstance().putLong("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        } else {
                            i6 = 0;
                        }
                        n3(td9Var);
                        i5 = i6;
                        break;
                        break;
                    case 9:
                        r3(td9Var);
                        i5 = 0;
                        break;
                    default:
                        i5 = 0;
                        break;
                }
                td9 td9Var3 = this.G;
                if (td9Var3 != null && td9Var3.O() != null) {
                    PraiseData praise = this.G.O().getPraise();
                    if (this.w1 != null && !praise.isPriaseDataValid()) {
                        this.G.O().setPraise(this.w1);
                    } else {
                        PraiseData praise2 = this.G.O().getPraise();
                        this.w1 = praise2;
                        praise2.setPostId(this.G.O().getFirstPostId());
                    }
                    if (td9Var.y() != null && td9Var.y().a() == r3 && td9Var.O() != null && td9Var.O().getActDatas() != null && td9Var.O().getActDatas().size() > 0) {
                        this.G.O().setActDatas(td9Var.O().getActDatas());
                    }
                    this.G.O().setReply_num(td9Var.O().getReply_num());
                    this.G.O().setAnchorLevel(td9Var.O().getAnchorLevel());
                    this.G.O().setCopyThreadRemindType(td9Var.O().getCopyThreadRemindType());
                    if (td9Var != null && td9Var.O() != null) {
                        this.G.O().updateIsNotitle(td9Var.O().getIsNoTitle());
                    }
                }
                td9 td9Var4 = this.G;
                if (td9Var4 != null && td9Var4.V() != null && td9Var.V() != null) {
                    this.G.V().setBimg_end_time(td9Var.V().getBimg_end_time());
                    this.G.V().setBimg_url(td9Var.V().getBimg_url());
                    this.G.V().setDynamicUrl(td9Var.V().getDynamicUrl());
                }
                if (td9Var.y() != null && td9Var.y().a() == r3 && td9Var.Y() != null) {
                    this.G.T0(td9Var.Y());
                }
                if (this.h0) {
                    if (this.G.O() != null && this.G.O().getAuthor() != null && this.G.F() != null && ListUtils.getItem(this.G.F(), 0) != null) {
                        rba rbaVar5 = (rba) ListUtils.getItem(this.G.F(), 0);
                        MetaData author = this.G.O().getAuthor();
                        if (rbaVar5.r() != null && rbaVar5.r().getGodUserData() != null) {
                            int i9 = this.S;
                            if (i9 != -1) {
                                author.setFansNum(i9);
                                rbaVar5.r().setFansNum(this.S);
                            }
                            if (this.f1146T != -1) {
                                GodUserData godUserData = author.getGodUserData();
                                if (this.f1146T == r3) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                godUserData.setIsLike(z4);
                                GodUserData godUserData2 = rbaVar5.r().getGodUserData();
                                boolean z6 = r3;
                                if (this.f1146T != r3) {
                                    z6 = false;
                                }
                                godUserData2.setIsLike(z6);
                                author.getGodUserData().setIsFromNetWork(false);
                                rbaVar5.r().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    td9 td9Var5 = this.G;
                    td9Var5.e = -1;
                    td9Var5.d = -1;
                }
                h hVar = this.N;
                if (hVar != null) {
                    hVar.c(true, getErrorCode(), i, i5, this.G, this.mErrorString, 1);
                }
            } else {
                if (this.N != null) {
                    this.l = this.k;
                    if (i2 != 350006) {
                        this.m = this.n;
                    }
                    i4 = i2;
                    this.N.c(false, i2, i, 0, null, str, 1);
                } else {
                    i4 = i2;
                }
                if (i4 == 4 || i4 == 350008) {
                    sr6.b().b(new td5(M1()));
                }
            }
            td9 td9Var6 = this.G;
            if (td9Var6 != null && td9Var6.O() != null && this.G.k() != null && !this.G.j0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = this.W.getPageContext();
                historyMessage.threadId = s1().O().getId();
                if (this.H0 && s1().O().originalThreadData != null) {
                    historyMessage.threadName = s1().O().originalThreadData.b;
                } else {
                    historyMessage.threadName = s1().O().getTitle();
                }
                if (this.H0 && !l2()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = s1().k().getName();
                }
                historyMessage.isHostOnly = V0();
                historyMessage.isSquence = L1();
                historyMessage.threadType = s1().O().getThreadType();
                historyMessage.isShareThread = this.H0;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StringBuilder sb = new StringBuilder(20);
            sb.append(this.b);
            if (!this.C) {
                sb.append(this.d);
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
            sb.append(this.L0);
            sb.append(this.M0);
            sb.append(this.O0);
            sb.append(this.N0);
            String str = this.R;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void E2(int i) {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048590, this, i) == null) && i != 8) {
            this.C0 = "";
            if (this.D0 != null) {
                if (i == 1 && (td9Var = this.G) != null && td9Var.j0()) {
                    if (this.E0 != null) {
                        s1().F().remove(this.E0);
                    }
                } else if (i == 1 && !this.l && !ListUtils.isEmpty(s1().F())) {
                    s1().F().remove(this.D0);
                    if (this.E0 != null) {
                        s1().F().remove(this.E0);
                    }
                    s1().F().add(0, this.D0);
                } else {
                    s1().F().remove(this.D0);
                    if (this.E0 != null) {
                        s1().F().remove(this.E0);
                    }
                }
            }
            this.E0 = null;
        }
    }

    public void G2(td9 td9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, td9Var) != null) || td9Var == null) {
            return;
        }
        String I2 = I2(td9Var);
        for (int i = 0; i < td9Var.F().size(); i++) {
            rba rbaVar = td9Var.F().get(i);
            for (int i2 = 0; i2 < rbaVar.i0().size(); i2++) {
                rbaVar.i0().get(i2).w1(this.W.getPageContext(), I2.equals(rbaVar.i0().get(i2).r().getUserId()));
            }
        }
        ne9 T2 = td9Var.T();
        if (T2 != null && !ListUtils.isEmpty(T2.a)) {
            for (rba rbaVar2 : T2.a) {
                for (int i3 = 0; i3 < rbaVar2.i0().size(); i3++) {
                    rbaVar2.i0().get(i3).w1(this.W.getPageContext(), I2.equals(rbaVar2.i0().get(i3).r().getUserId()));
                }
            }
        }
    }

    public boolean P2(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048624, this, i)) == null) {
            this.H = i;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            z2(i);
            td9 f2 = th9.b().f();
            if (f2 != null && f2.O() != null) {
                f2.O().setCopyThreadRemindType(0);
                this.l = th9.b().i();
                this.j = th9.b().a();
                this.o = th9.b().c();
                this.D0 = th9.b().g();
                this.E0 = th9.b().h();
                this.F0 = th9.b().d();
                boolean z2 = this.j;
                this.A0 = z2;
                if (z2 || this.A) {
                    this.U = false;
                }
                SafeHandler.getInst().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.b0) {
                Q2(P0(), true, this.d, 3);
            }
            if (i == 3 && !this.b0) {
                String P0 = P0();
                if (this.A) {
                    z = true;
                } else {
                    z = false;
                }
                Q2(P0, z, this.d, 3);
            }
            this.b0 = false;
            h80.d(CmdConfigHttp.PB_PAGE_HTTP_CMD, new g(this, i));
            return true;
        }
        return invokeI.booleanValue;
    }

    public final int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = 0;
            if (s1().F() == null) {
                return 0;
            }
            ArrayList<rba> F = s1().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                rba rbaVar = F.get(size);
                if (rbaVar instanceof qba) {
                    if (rbaVar.getType() != AdvertAppInfo.y) {
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

    public MarkData O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(this.G.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(j2()));
            markData.setId(this.b);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public void H2(td9 td9Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048599, this, td9Var, i) != null) || td9Var == null) {
            return;
        }
        String I2 = I2(td9Var);
        ne9 T2 = td9Var.T();
        if (T2 != null && !ListUtils.isEmpty(T2.a)) {
            List<rba> list = T2.a;
            for (rba rbaVar : list.subList(i, list.size())) {
                for (int i2 = 0; i2 < rbaVar.i0().size(); i2++) {
                    rbaVar.i0().get(i2).w1(this.W.getPageContext(), I2.equals(rbaVar.i0().get(i2).r().getUserId()));
                }
            }
        }
    }

    public final void K2(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            int i4 = 0;
            if (this.J0 == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            pbPageRequestMessage.setIsReqAd(i2);
            pbPageRequestMessage.setLastids(bh5.l);
            if (this.j || this.A) {
                this.U = false;
            }
            try {
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
                    pbPageRequestMessage.setSchemeUrl(this.V0);
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
                        pbPageRequestMessage.setOpStat(JavaTypesHelper.toInt(this.Q, 0));
                        pbPageRequestMessage.setOpMessageID(this.D);
                    }
                    t0(pbPageRequestMessage, i);
                    this.A0 = this.j;
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.A));
                    pbPageRequestMessage.setCacheKey(P0());
                    pbPageRequestMessage.setObjParam1(String.valueOf(this.B0));
                    pbPageRequestMessage.setIsSubPostDataReverse(this.f0);
                    if (this.i0) {
                        i4 = 1;
                    }
                    pbPageRequestMessage.setFromSmartFrs(i4);
                    q0(pbPageRequestMessage);
                    pbPageRequestMessage.setNeedRepostRecommendForum(this.i);
                    r0(pbPageRequestMessage);
                    v0(pbPageRequestMessage);
                    pbPageRequestMessage.setOriUgcNid(this.L0);
                    pbPageRequestMessage.setOriUgcTid(this.M0);
                    pbPageRequestMessage.setOriUgcType(this.N0);
                    pbPageRequestMessage.setOriUgcVid(this.O0);
                    if (!StringUtils.isNull(this.Y0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.Y0));
                    }
                    p0(pbPageRequestMessage);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.Z0);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.setReqFoldComment(this.h1);
                    pbPageRequestMessage.setSimilarFrom(this.o1);
                    pbPageRequestMessage.setQuery(this.p1);
                    pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.b);
                    pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                    int i5 = PbPageRequestMessage.requestTimes;
                    PbPageRequestMessage.requestTimes = i5 + 1;
                    pbPageRequestMessage.setRequestTimes(i5);
                    sendMessage(pbPageRequestMessage);
                    return;
                }
                this.isLoading = false;
            } catch (Exception e2) {
                BdLog.e(e2.getMessage());
            }
        }
    }

    public final void V1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048646, this, bundle) == null) {
            boolean z = false;
            this.B0 = bundle.getInt("key_start_from", 0);
            this.b = bundle.getString("thread_id");
            this.d = bundle.getString("post_id");
            this.e = bundle.getString("forum_id");
            this.f = bundle.getString("from_forum_id");
            this.i = bundle.getBoolean("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
            this.j = bundle.getBoolean("host_only", false);
            this.l = bundle.getBoolean("squence", true);
            this.m = bundle.getInt("sort_type", 0);
            this.mStType = bundle.getString("st_type");
            this.M = bundle.getString("locate");
            this.p = bundle.getInt("is_good", 0);
            this.q = bundle.getInt("is_top", 0);
            this.r = bundle.getLong("thread_time");
            this.A = bundle.getBoolean("from_mark", false);
            this.C = bundle.getBoolean("is_pb_key_need_post_id", false);
            this.w = bundle.getBoolean("is_ad", false);
            this.x = bundle.getBoolean("is_sub_pb", false);
            this.E = bundle.getBoolean("is_pv", false);
            this.n1 = bundle.getBoolean(PbActivityConfig.KEY_SCHEME_START, false);
            this.i1 = bundle.getBoolean("is_jump_from_video_tab", false);
            this.j1 = bundle.getBoolean("is_jump_from_video_middle", false);
            this.D = bundle.getLong("msg_id", 0L);
            this.F = bundle.getString("from_forum_name");
            this.R = bundle.getString("extra_pb_cache_key");
            this.I = bundle.getBoolean("is_from_thread_config", false);
            this.J = bundle.getBoolean("is_from_interview_live_config", false);
            this.K = bundle.getBoolean("is_from_my_god_config", false);
            this.f1146T = bundle.getInt("extra_pb_is_attention_key", -1);
            this.S = bundle.getInt("extra_pb_funs_count_key", -1);
            this.y = bundle.getBoolean("from_frs", false);
            this.z = bundle.getBoolean("from_maintab", false);
            this.i0 = bundle.getBoolean("from_smart_frs", false);
            this.L = bundle.getBoolean("from_hottopic", false);
            this.H0 = bundle.getBoolean("key_is_share_thread", false);
            this.L0 = bundle.getString("key_ori_ugc_nid");
            this.M0 = bundle.getString("key_ori_ugc_tid");
            this.N0 = bundle.getInt("key_ori_ugc_type", 0);
            this.W0 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.O0 = bundle.getString("key_ori_ugc_vid");
            if (bundle.getInt("request_code", -1) == 18003) {
                z = true;
            }
            this.U = z;
            this.R0 = bundle.getString("key_rec_weight");
            this.S0 = bundle.getString("key_rec_source");
            this.T0 = bundle.getString("key_rec_ab_tag");
            this.U0 = bundle.getString("key_rec_extra");
            this.b1 = bundle.getBoolean("key_is_tieba_plus");
            this.c1 = bundle.getString("key_tieba_plus_order_id");
            this.d1 = bundle.getString("key_tieba_plus_token");
            this.e1 = bundle.getString("key_tieba_extra_param");
            this.f1 = bundle.getBoolean("key_tieba_plus_cant_delete");
            this.g1 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
            Parcelable parcelable = bundle.getParcelable(IntentConfig.KEY_URI);
            if (parcelable instanceof Uri) {
                e3((Uri) parcelable);
            }
        }
    }

    public void N2() {
        td9 td9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (td9Var = this.G) != null && !ListUtils.isEmpty(td9Var.F())) {
            if (this.E0 != null) {
                this.G.F().remove(this.E0);
                this.E0 = null;
            }
            if (this.D0 != null) {
                this.G.F().remove(this.D0);
                this.D0 = null;
            }
        }
    }

    public MetaData U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            td9 td9Var = this.G;
            if (td9Var == null || td9Var.O() == null || this.G.O().getAuthor() == null) {
                return null;
            }
            return this.G.O().getAuthor();
        }
        return (MetaData) invokeV.objValue;
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.G.z() == null || this.G.z().getAdvertAppInfo() == null || this.G.z().getAdvertAppInfo().c == 1001) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048677, this) == null) {
            cancelLoadData();
            MessageManager.getInstance().unRegisterListener(this.unique_id);
            SuggestEmotionModel suggestEmotionModel = this.y0;
            if (suggestEmotionModel != null) {
                suggestEmotionModel.cancelLoadData();
            }
            GetSugMatchWordsModel getSugMatchWordsModel = this.z0;
            if (getSugMatchWordsModel != null) {
                getSugMatchWordsModel.cancelLoadData();
            }
            az9.f().a("PB");
            u2();
        }
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            if (UbsABTestHelper.isNoCachePb() || !this.K0 || if7.c() == null || !if7.c().equals(this.b) || if7.b() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            if (r1() == 3 || s1() == null || s1().O() == null || !s1().O().isMutiForumThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048708, this)) == null) {
            if (this.b == null) {
                return false;
            }
            cancelLoadData();
            if (this.V == null) {
                yba ybaVar = new yba("pbStat");
                this.V = ybaVar;
                ybaVar.f();
            }
            boolean P2 = P2(3);
            if (this.O != null) {
                this.O = null;
                this.Q = null;
                this.P = null;
            }
            return P2;
        }
        return invokeV.booleanValue;
    }

    public void o3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048717, this) == null) {
            wb9.a(Q());
            td9 td9Var = this.G;
            if (td9Var != null && td9Var.S() != null && this.G.S().c() != null) {
                this.G.S().c().setForceRefreshCallRobotEntrance(true);
            }
        }
    }

    public final String P0() {
        InterceptResult invokeV;
        String p1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            String str = this.b;
            if (str != null && !str.equals("0")) {
                p1 = this.b;
            } else {
                p1 = p1();
            }
            if (this.j) {
                p1 = p1 + "_host";
            }
            int i = this.m;
            if (i == 1) {
                p1 = p1 + "_rev";
            } else if (i == 2) {
                p1 = p1 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return p1 + TbadkCoreApplication.getCurrentAccount();
            }
            return p1;
        }
        return (String) invokeV.objValue;
    }

    public final String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            String str = "";
            if (this.L0 != null) {
                str = "" + this.L0;
            }
            if (this.M0 != null) {
                str = str + this.M0;
            }
            String str2 = str + this.N0;
            if (this.O0 != null) {
                return str2 + this.O0;
            }
            return str2;
        }
        return (String) invokeV.objValue;
    }

    public void v2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048741, this) == null) && "personalize_page".equals(this.mStType) && this.G != null && this.e0 != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new StatisticItem("c10754").param("fid", this.G.l()).param("tid", this.b).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.e0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.e0 = 0L;
        }
    }

    public final void Q2(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048628, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
            td9 td9Var = this.G;
            if (td9Var != null && td9Var.O() != null && this.G.k() != null) {
                WriteData writeData = new WriteData();
                if (this.G.O().isMutiForumThread()) {
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setForumId(this.G.k().getId());
                    writeData.setForumName(this.G.k().getName());
                }
                writeData.setFromForumId(this.f);
                writeData.sourceFrom = String.valueOf(this.B0);
                writeData.setThreadId(this.b);
                writeData.setIsAd(this.w);
                if (str == null) {
                    writeData.setType(1);
                } else {
                    writeData.setType(2);
                    writeData.setFloor(str);
                    writeData.setFloorNum(0);
                }
                writeData.setReplyResultNotificationH5(this.isReplyResultNotificationH5);
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public MarkData m1(rba rbaVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048709, this, rbaVar)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(rbaVar.S());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(j2()));
            markData.setId(this.b);
            markData.setFloor(rbaVar.I());
            markData.setForumId(this.e);
            if (rbaVar instanceof qba) {
                qba qbaVar = (qba) rbaVar;
                if (qbaVar.getAdvertAppInfo() != null && qbaVar.getAdvertAppInfo().e()) {
                    z = true;
                } else {
                    z = false;
                }
                markData.setApp(z);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void z2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048753, this, i) == null) {
            E2(i);
            ArrayList<rba> F = this.G.F();
            boolean z = false;
            this.a0 = false;
            if (i == 1) {
                boolean z2 = false;
                while (F.size() + 30 > hg5.a()) {
                    F.remove(0);
                    z2 = true;
                }
                if (z2) {
                    this.G.y().m(1);
                    h hVar = this.N;
                    if (hVar != null) {
                        hVar.b(this.G);
                    }
                }
                this.Z = System.currentTimeMillis();
                this.a0 = true;
            } else if (i == 2) {
                while (F.size() + 30 > hg5.a()) {
                    F.remove(F.size() - 1);
                    z = true;
                }
                if (z) {
                    this.G.y().l(1);
                }
            }
        }
    }

    public final void W1(Intent intent) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048650, this, intent) != null) || intent == null) {
            return;
        }
        this.b = intent.getStringExtra("thread_id");
        this.c = intent.getBooleanExtra("key_is_privacy", false);
        this.L0 = intent.getStringExtra("key_ori_ugc_nid");
        this.M0 = intent.getStringExtra("key_ori_ugc_tid");
        this.N0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.O0 = intent.getStringExtra("key_ori_ugc_vid");
        this.W0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.i1 = intent.getBooleanExtra("is_jump_from_video_tab", false);
        this.j1 = intent.getBooleanExtra("is_jump_from_video_middle", false);
        this.Y0 = intent.getStringExtra("key_official_bar_message_id");
        this.o1 = intent.getIntExtra(PbActivityConfig.KEY_SIMILAR_FROM_TYPE, 0);
        this.n1 = intent.getBooleanExtra(PbActivityConfig.KEY_SCHEME_START, false);
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        e3(uri);
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        this.V0 = str;
        this.a1 = false;
        boolean z2 = true;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.a1 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.r1);
        } else if (StringUtils.isNull(this.b)) {
            this.a1 = true;
            this.s0.b(intent, this.r1);
            if (uri != null) {
                if (StringUtils.isNull(this.b)) {
                    this.b = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.L0)) {
                    this.L0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.M0)) {
                    this.M0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.N0 == 0) {
                    this.N0 = JavaTypesHelper.toInt(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.O0)) {
                    this.O0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        String str2 = "0";
        if (bi.isEmpty(this.b)) {
            this.b = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.B0 = intExtra;
        if (intExtra == 0) {
            this.B0 = this.s0.a;
        }
        this.d = intent.getStringExtra("post_id");
        this.e = intent.getStringExtra("forum_id");
        this.f = intent.getStringExtra("from_forum_id");
        this.i = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.j = intent.getBooleanExtra("host_only", false);
        this.l = intent.getBooleanExtra("squence", true);
        this.g = intent.getStringExtra("high_light_post_id");
        this.h = intent.getStringExtra(PbCommentFloatActivityConfig.KEY_HIGH_LIGHT_3S_POST_ID);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.m = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = SharedPrefHelper.getInstance().getInt("key_pb_current_sort_type", 2);
        }
        this.m = intExtra2;
        if (f2()) {
            this.m = 0;
        }
        if (this.m != 2) {
            str2 = this.d;
        }
        this.d = str2;
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
        this.I = intent.getBooleanExtra("is_from_thread_config", false);
        this.J = intent.getBooleanExtra("is_from_interview_live_config", false);
        this.K = intent.getBooleanExtra("is_from_my_god_config", false);
        this.f1146T = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.S = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.y = intent.getBooleanExtra("from_frs", false);
        this.z = intent.getBooleanExtra("from_maintab", false);
        this.i0 = intent.getBooleanExtra("from_smart_frs", false);
        this.L = intent.getBooleanExtra("from_hottopic", false);
        this.v0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.H0 = intent.getBooleanExtra("key_is_share_thread", false);
        boolean booleanExtra = intent.getBooleanExtra("key_need_preload", false);
        this.K0 = booleanExtra;
        if (!booleanExtra && !if7.d()) {
            z = false;
        } else {
            z = true;
        }
        this.K0 = z;
        if (intent.getIntExtra("request_code", -1) != 18003) {
            z2 = false;
        }
        this.U = z2;
        this.R0 = intent.getStringExtra("key_rec_weight");
        this.S0 = intent.getStringExtra("key_rec_source");
        this.T0 = intent.getStringExtra("key_rec_ab_tag");
        this.U0 = intent.getStringExtra("key_rec_extra");
        this.b1 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.c1 = intent.getStringExtra("key_tieba_plus_order_id");
        this.d1 = intent.getStringExtra("key_tieba_plus_token");
        this.e1 = intent.getStringExtra("key_tieba_extra_param");
        this.f1 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.g1 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
        if (this.B0 == 17) {
            this.mTopicId = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_ID);
            this.mTopicSubjectName = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_SUBJECT_NAME);
        }
        this.p1 = intent.getStringExtra(PbActivityConfig.KEY_QUERY_KEYWORD);
        String stringExtra = intent.getStringExtra(PbActivityConfig.KEY_CHANNEL_ID);
        if (!TextUtils.isEmpty(stringExtra)) {
            this.q1 = stringExtra;
        }
        F2();
    }

    public boolean l3(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048707, this, z, str)) == null) {
            if (this.j == z) {
                return false;
            }
            this.j = z;
            this.d = str;
            if (this.m == 2) {
                this.d = "";
            }
            if (z) {
                TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 1));
            }
            if (P2(9)) {
                return true;
            }
            this.j = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public void o2(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048716, this, forumData, cVar) == null) {
            String str3 = "";
            if (forumData == null) {
                str = "";
            } else {
                if (TextUtils.isEmpty(forumData.getId())) {
                    str2 = "";
                } else {
                    str2 = forumData.getId();
                }
                if (!TextUtils.isEmpty(forumData.getName())) {
                    str3 = forumData.getName();
                }
                str = str3;
                str3 = str2;
            }
            this.y0.Q(str3, str, cVar);
        }
    }

    public void q3(td9 td9Var, ArrayList<rba> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048725, this, td9Var, arrayList) == null) && arrayList != null && td9Var.F() != null) {
            rba rbaVar = (rba) ListUtils.getItem(td9Var.F(), 0);
            if (rbaVar != null) {
                String j1 = j1(arrayList);
                String S = rbaVar.S();
                if (StringUtils.isNull(S) || "0".equals(S) || (j1 != null && j1.equals(S))) {
                    td9Var.F().remove(rbaVar);
                }
            }
            this.G.Y = arrayList.size();
            arrayList.addAll(td9Var.F());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x023b, code lost:
        if ((r9.u - 1) <= 0) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x024c, code lost:
        if (r9.t >= r9.v) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x024e, code lost:
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t0(PbPageRequestMessage pbPageRequestMessage, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048733, this, pbPageRequestMessage, i) != null) || pbPageRequestMessage == null) {
            return;
        }
        ArrayList<rba> F = this.G.F();
        boolean z = false;
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
                        break;
                    }
                }
                if (this.A || z || this.B) {
                    if (F != null && F.size() > 0) {
                        int size = F.size();
                        int i3 = 1;
                        while (true) {
                            int i4 = size - i3;
                            if (i4 >= 0) {
                                rba rbaVar = F.get(i4);
                                if (rbaVar != null) {
                                    String S = rbaVar.S();
                                    this.d = S;
                                    if (StringUtils.isNull(S)) {
                                    }
                                }
                                i3++;
                            }
                        }
                        if (this.m == 2) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(this.t + 1));
                        }
                    }
                    String str = this.d;
                    if (str != null && str.length() > 0) {
                        pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.d, 0L));
                        if (this.m == 2) {
                            pbPageRequestMessage.set_pid(0L);
                        }
                    } else if (this.m == 1) {
                        pbPageRequestMessage.set_last(1);
                    }
                }
                X2(pbPageRequestMessage);
                String j1 = j1(F);
                if (StringUtils.isNotNull(j1)) {
                    s0(pbPageRequestMessage, JavaTypesHelper.toLong(j1, 0L));
                    return;
                }
                return;
            case 2:
                if (F != null && F.size() > 0 && F.get(0) != null) {
                    this.d = F.get(0).S();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.A) {
                    if (j2()) {
                        int i5 = this.u;
                        if (i5 - 1 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(i5 - 1));
                        }
                    } else {
                        int i6 = this.t;
                        if (i6 < this.v) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(i6 + 1));
                        }
                    }
                }
                String str2 = this.d;
                if (str2 != null && str2.length() > 0) {
                    pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.d, 0L));
                    if (this.m == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                    s0(pbPageRequestMessage, JavaTypesHelper.toLong(this.d, 0L));
                }
                X2(pbPageRequestMessage);
                return;
            case 3:
                if (!this.A && !this.j) {
                    pbPageRequestMessage.set_banner(1);
                } else {
                    pbPageRequestMessage.set_banner(0);
                }
                if (f2() && this.m == 0) {
                    pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.g, 0L));
                }
                if (a2()) {
                    this.B0 = 12;
                    if (this.m == 1 && !UbsABTestHelper.isPbReplyOptimize() && (i2 = this.v) > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(i2));
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (!a2()) {
                    if (j2()) {
                        pbPageRequestMessage.set_pn(1);
                    } else {
                        pbPageRequestMessage.set_last(1);
                        int i7 = this.v;
                        if (i7 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(i7));
                        }
                    }
                }
                if (this.A) {
                    pbPageRequestMessage.set_st_type("store_thread");
                }
                b3(pbPageRequestMessage);
                s0(pbPageRequestMessage, -1L);
                return;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.d, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                X2(pbPageRequestMessage);
                return;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.s));
                pbPageRequestMessage.set_banner(0);
                X2(pbPageRequestMessage);
                return;
            case 6:
                if (f2()) {
                    pbPageRequestMessage.setObjLocate("reply_jump_first");
                }
                pbPageRequestMessage.set_mark(1);
                if (this.m == 1 && this.A0 && !this.j) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.d, 0L));
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
                X2(pbPageRequestMessage);
                s0(pbPageRequestMessage, -1L);
                return;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.g0);
                X2(pbPageRequestMessage);
                return;
            case 8:
                pbPageRequestMessage.set_pid(JavaTypesHelper.toLong(this.C0, 0L));
                if (this.m == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    return;
                }
                return;
            case 9:
                pbPageRequestMessage.set_pn(Integer.valueOf(this.t));
                pbPageRequestMessage.set_back(0);
                if (this.j) {
                    pbPageRequestMessage.set_banner(0);
                } else {
                    pbPageRequestMessage.set_banner(1);
                }
                X2(pbPageRequestMessage);
                s0(pbPageRequestMessage, -1L);
                return;
            default:
                return;
        }
    }

    public void y2(td9 td9Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048750, this, td9Var, i, str) == null) {
            this.b0 = true;
            if (td9Var != null && td9Var.h == null) {
                r3(td9Var);
                B0(td9Var);
                if (td9Var.O() != null) {
                    td9Var.O().setCopyThreadRemindType(0);
                }
                h hVar = this.N;
                if (hVar != null && td9Var != null) {
                    hVar.c(true, 0, i, 0, td9Var, str, 0);
                }
            }
        }
    }
}
