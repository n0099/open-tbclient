package com.baidu.tieba.pb.pb.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.BdNetTypeUtil;
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
import com.baidu.tbadk.core.message.HistoryMessage;
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
import com.baidu.tbadk.switchs.PBCacheBlockSwitch;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.a57;
import com.baidu.tieba.a9;
import com.baidu.tieba.ak9;
import com.baidu.tieba.am9;
import com.baidu.tieba.db9;
import com.baidu.tieba.f45;
import com.baidu.tieba.gc5;
import com.baidu.tieba.gg;
import com.baidu.tieba.gt8;
import com.baidu.tieba.hi;
import com.baidu.tieba.hm9;
import com.baidu.tieba.ht8;
import com.baidu.tieba.ii;
import com.baidu.tieba.j70;
import com.baidu.tieba.jg;
import com.baidu.tieba.mb5;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.mw8;
import com.baidu.tieba.my4;
import com.baidu.tieba.ng;
import com.baidu.tieba.nw8;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.q45;
import com.baidu.tieba.qc9;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.uv8;
import com.baidu.tieba.vt8;
import com.baidu.tieba.ww8;
import com.baidu.tieba.yv8;
import com.baidu.tieba.za;
import com.baidu.tieba.zl9;
import com.baidu.tieba.zt8;
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
    public static final int UPDATE_TYPE_REDIRECT_FLOOR = 7;
    public static final int UPDATE_TYPE_REDIRECT_PAGE = 5;
    public static final int UPDATE_TYPE_SINGLE_FLOOR = 8;
    public static final int UPDATE_TYPE_SPEC_FLOOR = 6;
    public static final int UPDATE_TYPE_UPDATE = 3;
    public static int UPGRADE_TO_PHOTO_LIVE = 1;
    public static final String WISE = "wise";
    public static String u1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean A0;
    public boolean B;
    public int B0;
    public boolean C;
    public String C0;
    public long D;
    public am9 D0;
    public boolean E;
    public am9 E0;
    public String F;
    public int F0;
    public ht8 G;
    public int G0;
    public int H;
    public boolean H0;
    public boolean I;
    public String I0;
    public boolean J;
    public zl9 J0;
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
    public int T;
    public String T0;
    public boolean U;
    public String U0;
    public hm9 V;
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
    public BdUniDispatchSchemeController.b o1;
    public int p;
    public CustomMessageListener p1;
    public int q;
    public za q1;
    public long r;
    public gt8 r0;
    public CustomMessageListener r1;
    public int s;
    public final mw8 s0;
    public CustomMessageListener s1;
    public String showReplyPanel;
    public int t;
    public final yv8 t0;
    public PraiseData t1;
    public int u;
    public final nw8 u0;
    public int v;
    public String v0;
    public boolean w;
    public final CheckRealNameModel w0;
    public boolean x;
    public final AddExperiencedModel x0;
    public boolean y;
    public SuggestEmotionModel y0;
    public boolean z;
    public GetSugMatchWordsModel z0;

    /* loaded from: classes5.dex */
    public interface h {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(ht8 ht8Var);

        void c(boolean z, int i, int i2, int i3, ht8 ht8Var, String str, int i4);
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

    public int w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class g implements j70.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ int a;
        public final /* synthetic */ PbModel b;

        /* loaded from: classes5.dex */
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
                ht8 pbData;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ResponsedMessage responsedMessage = this.a;
                    boolean z = true;
                    if ((responsedMessage instanceof pbPageHttpResponseMessage) && (pbData = ((pbPageHttpResponseMessage) responsedMessage).getPbData()) != null) {
                        String O = pbData.O();
                        if (!TextUtils.isEmpty(this.b.b.b) && this.b.b.b.equals(O)) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.b.b();
                    } else if (this.b.b.q1 != null) {
                        this.b.b.q1.onMessage(this.a);
                    }
                }
            }
        }

        /* loaded from: classes5.dex */
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

        @Override // com.baidu.tieba.j70.b
        public void a(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                ng.e(new a(this, responsedMessage));
            }
        }

        @Override // com.baidu.tieba.j70.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                ng.e(new b(this));
            }
        }
    }

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
                this.a.N0 = gg.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SignData)) {
                SignData signData = (SignData) customResponsedMessage.getData();
                if (this.a.u1() != null && this.a.u1().k() != null && this.a.u1().k().getSignData() != null && signData.forumId.equals(this.a.u1().l())) {
                    this.a.u1().k().getSignData().is_signed = signData.is_signed;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends za {
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

        @Override // com.baidu.tieba.za
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if (!z2 && !(responsedMessage instanceof pbPageHttpResponseMessage)) {
                    return;
                }
                if (responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId() && responsedMessage.getOrginalMessage().getTag() != j70.d) {
                    return;
                }
                if (responsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.W.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    this.a.C2((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    this.a.B2((pbPageHttpResponseMessage) responsedMessage);
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
                    f45.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                }
                if (!this.a.X || !this.a.Y) {
                    if (!this.a.X) {
                        this.a.X = true;
                    } else {
                        this.a.Y = true;
                    }
                    if (this.a.N != null) {
                        this.a.N.a(this.a.w1(), z, responsedMessage, this.a.a0, System.currentTimeMillis() - this.a.Z);
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
                ht8 ht8Var = this.a.G;
                if (ht8Var != null && ht8Var.g() != null && this.a.G.g().b() != null && this.a.G.g().b().equals(valueOf)) {
                    this.a.G.g().k(false);
                }
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
                ht8 ht8Var = this.a.G;
                if (ht8Var != null && ht8Var.g() != null && this.a.G.g().b() != null && this.a.G.g().b().equals(valueOf)) {
                    this.a.G.g().k(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ht8 a;
        public final /* synthetic */ PbModel b;

        public f(PbModel pbModel, ht8 ht8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, ht8Var};
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
            this.a = ht8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.E2(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
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
                super((a9) newInitContext.callArgs[0]);
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
        this.T = -1;
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
        this.p1 = new b(this, 2001222);
        this.q1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.r1 = new d(this, 2001336);
        this.s1 = new e(this, 2001335);
        this.t1 = null;
        ht8 ht8Var = new ht8();
        this.G = ht8Var;
        ht8Var.C0(0);
        this.W = baseFragmentActivity;
        this.s0 = new mw8();
        this.t0 = new yv8(this, this.W);
        this.u0 = new nw8(this, this.W);
        this.w0 = new CheckRealNameModel(this.W.getPageContext());
        this.y0 = new SuggestEmotionModel();
        this.x0 = new AddExperiencedModel(this.W.getPageContext());
        this.o1 = new a(this);
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
            bundle.putInt("extra_pb_is_attention_key", this.T);
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
        X1(intent);
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
        W1(bundle);
        Y2(hVar);
        J2();
    }

    public void R2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048629, this, i, i2) == null) {
            this.F0 = i;
            this.G0 = i2;
        }
    }

    public final void v0(PbPageRequestMessage pbPageRequestMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048735, this, pbPageRequestMessage, j) == null) && pbPageRequestMessage != null && !UbsABTestHelper.isPbReplyOptimize()) {
            pbPageRequestMessage.setLastPid(j);
        }
    }

    public void E0(ht8 ht8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048588, this, ht8Var) != null) || ht8Var == null) {
            return;
        }
        if (this.K || this.I || this.J) {
            ht8Var = h3(ht8Var);
        }
        G2(ht8Var);
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
        if (interceptable == null || interceptable.invokeL(1048633, this, str) == null) {
            this.d0 = str;
        }
    }

    public void T2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i) == null) {
            this.Z0 = i;
        }
    }

    public void U2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.X0 = i;
        }
    }

    public void V2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048645, this, i) == null) {
            this.p = i;
        }
    }

    public void W2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048649, this, i) == null) {
            this.q = i;
        }
    }

    public void Y2(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048656, this, hVar) == null) {
            this.N = hVar;
        }
    }

    public void Z2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048660, this, i) == null) {
            this.B0 = i;
        }
    }

    public void a3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, str) == null) {
            this.I0 = str;
        }
    }

    public void c3(int i) {
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048671, this, i) == null) && (ht8Var = this.G) != null) {
            ht8Var.N0(i);
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
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048696, this, z) == null) && (ht8Var = this.G) != null) {
            ht8Var.G0(z);
        }
    }

    public final void n3(@NonNull ht8 ht8Var) {
        ht8 ht8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048714, this, ht8Var) == null) && (ht8Var2 = this.G) != null) {
            ht8Var2.d().clear();
            this.G.d().addAll(ht8Var.d());
        }
    }

    public boolean q2(boolean z) {
        InterceptResult invokeZ;
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048722, this, z)) == null) {
            if (this.b == null || (ht8Var = this.G) == null) {
                return false;
            }
            if (!z && ht8Var.y().b() == 0) {
                return false;
            }
            return P2(1);
        }
        return invokeZ.booleanValue;
    }

    public final void t0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048729, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (UtilHelper.isUgcThreadType(this.N0)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.e);
        }
    }

    public void t2(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048731, this, bVar) != null) || bVar == null) {
            return;
        }
        if (this.z0 == null) {
            this.z0 = new GetSugMatchWordsModel(this.W.getPageContext());
        }
        this.z0.S(bVar);
    }

    public final void u0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048732, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (this.B0 == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
    }

    public final void y0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048744, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = this.B0;
        if (i != 7 && i != 5 && !this.a1) {
            pbPageRequestMessage.setSourceType(2);
        } else {
            pbPageRequestMessage.setSourceType(1);
        }
    }

    public void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.J0 = null;
        }
    }

    public String A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.h = "";
        }
    }

    public String B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.S0;
        }
        return (String) invokeV.objValue;
    }

    public void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.g = null;
        }
    }

    public String C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.R0;
        }
        return (String) invokeV.objValue;
    }

    public int D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var != null) {
                return ht8Var.J();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return k2();
        }
        return invokeV.booleanValue;
    }

    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    public String H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.Q0;
        }
        return (String) invokeV.objValue;
    }

    public AddExperiencedModel I0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.x0;
        }
        return (AddExperiencedModel) invokeV.objValue;
    }

    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.m1;
        }
        return (String) invokeV.objValue;
    }

    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.l1;
        }
        return invokeV.intValue;
    }

    public final void J2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048605, this) == null) {
            registerListener(this.q1);
            registerListener(this.p1);
            registerListener(this.s1);
            registerListener(this.r1);
        }
    }

    public gt8 K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.r0;
        }
        return (gt8) invokeV.objValue;
    }

    public int K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public BaijiahaoData M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var != null && ht8Var.M() != null) {
                return this.G.M().getBaijiahaoData();
            }
            return null;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return k2();
        }
        return invokeV.booleanValue;
    }

    public zl9 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.J0;
        }
        return (zl9) invokeV.objValue;
    }

    public String N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public CheckRealNameModel O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.w0;
        }
        return (CheckRealNameModel) invokeV.objValue;
    }

    public String O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.L0;
        }
        return (String) invokeV.objValue;
    }

    public yv8 P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.t0;
        }
        return (yv8) invokeV.objValue;
    }

    public am9 P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.D0;
        }
        return (am9) invokeV.objValue;
    }

    public am9 Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.E0;
        }
        return (am9) invokeV.objValue;
    }

    public String R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.mTopicSubjectName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.c0;
        }
        return (String) invokeV.objValue;
    }

    public String S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.d0;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var != null && ht8Var.M() != null) {
                return this.G.M().worksInfoData;
            }
            return null;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    public String T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.e1;
        }
        return (String) invokeV.objValue;
    }

    public String U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var != null && !ListUtils.isEmpty(ht8Var.F())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.c1;
        }
        return (String) invokeV.objValue;
    }

    public String V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.d1;
        }
        return (String) invokeV.objValue;
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public int Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.X0;
        }
        return invokeV.intValue;
    }

    public void Y1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            uv8.b().d(R0(), this.A);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.b1;
        }
        return invokeV.booleanValue;
    }

    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.f1;
        }
        return invokeV.booleanValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.L;
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.g1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return u2();
        }
        return invokeV.booleanValue;
    }

    public boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return "hot_topic".equals(this.mStType);
        }
        return invokeV.booleanValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (12 != this.W.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) && 12 != this.B0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.n1;
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
            ht8 ht8Var = this.G;
            if (ht8Var != null && ht8Var.k() != null && this.G.M() != null) {
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
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            return this.j1;
        }
        return invokeV.booleanValue;
    }

    public boolean f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048681, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var == null) {
                return false;
            }
            return ht8Var.q();
        }
        return invokeV.booleanValue;
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.i1;
        }
        return invokeV.booleanValue;
    }

    public boolean g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            if (!TextUtils.isEmpty(this.g) && !"0".equals(this.g)) {
                return true;
            }
            return false;
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
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.W0;
        }
        return invokeV.booleanValue;
    }

    public int i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.U;
        }
        return invokeV.booleanValue;
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

    public boolean j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var == null) {
                return false;
            }
            return ht8Var.u0();
        }
        return invokeV.booleanValue;
    }

    public boolean j3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            if (k2() && this.G.y().b() == 0) {
                q2(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return u1;
        }
        return (String) invokeV.objValue;
    }

    public final boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            int i = this.m;
            if (i != 0 && i != 2) {
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
            return this.k1;
        }
        return invokeV.booleanValue;
    }

    public int m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.G0;
        }
        return invokeV.intValue;
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            return this.F0;
        }
        return invokeV.intValue;
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            u1 = null;
        }
    }

    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var != null && ht8Var.q()) {
                return this.G.u();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public nw8 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            return this.u0;
        }
        return (nw8) invokeV.objValue;
    }

    public boolean r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
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

    public my4 s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var == null) {
                return null;
            }
            return ht8Var.y();
        }
        return (my4) invokeV.objValue;
    }

    public int t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.B0;
        }
        return invokeV.intValue;
    }

    public ht8 u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            return this.G;
        }
        return (ht8) invokeV.objValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048734, this)) == null) {
            String str = this.d;
            if (str != null && !str.equals("0") && this.d.length() != 0) {
                return r2();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public ht8 v1() {
        InterceptResult invokeV;
        zl9 zl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var == null) {
                return ht8Var;
            }
            if (!V1() && (zl9Var = this.J0) != null) {
                this.G.K0(zl9Var);
            }
            return this.G;
        }
        return (ht8) invokeV.objValue;
    }

    public final void v2() {
        hm9 hm9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048737, this) == null) && (hm9Var = this.V) != null) {
            hm9Var.a();
            this.V = null;
        }
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.v0;
        }
        return (String) invokeV.objValue;
    }

    public void x2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048743, this) == null) && "personalize_page".equals(this.mStType)) {
            this.e0 = System.currentTimeMillis() / 1000;
        }
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return this.I0;
        }
        return (String) invokeV.objValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return !TextUtils.isEmpty(this.h);
        }
        return invokeV.booleanValue;
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.T0;
        }
        return (String) invokeV.objValue;
    }

    public void A2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            F2(i);
            ArrayList<am9> F = this.G.F();
            boolean z = false;
            this.a0 = false;
            if (i == 1) {
                boolean z2 = false;
                while (F.size() + 30 > mb5.a()) {
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
                while (F.size() + 30 > mb5.a()) {
                    F.remove(F.size() - 1);
                    z = true;
                }
                if (z) {
                    this.G.y().l(1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData X(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, str)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var != null && ht8Var.M() != null && this.G.k() != null) {
                WriteData writeData = new WriteData();
                if (this.G.M().isMutiForumThread()) {
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
                return writeData;
            }
            return null;
        }
        return (WriteData) invokeL.objValue;
    }

    public MarkData o1(am9 am9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048715, this, am9Var)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(am9Var.O());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(k2()));
            markData.setId(this.b);
            markData.setFloor(am9Var.E());
            markData.setForumId(this.e);
            if (am9Var instanceof zl9) {
                zl9 zl9Var = (zl9) am9Var;
                if (zl9Var.getAdvertAppInfo() != null && zl9Var.getAdvertAppInfo().e()) {
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

    public void B2(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.r0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            D2(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void C2(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.r0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            D2(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public void G0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = Z();
            threadData.tiebaPlusOrderId = V();
            threadData.tiebaPlusToken = W();
            threadData.tiebaPlusExtraParam = W();
            threadData.tiebaplusCantDelete = a0();
            threadData.setDispatchedForumIdWithString(Q());
        }
    }

    public String I2(ht8 ht8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, ht8Var)) == null) {
            String str = null;
            if (ht8Var == null) {
                return null;
            }
            if (ht8Var.M() != null && ht8Var.M().getAuthor() != null) {
                str = ht8Var.M().getAuthor().getUserId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public MarkData L0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048609, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            ht8 ht8Var = this.G;
            if (ht8Var == null) {
                return null;
            }
            ArrayList<am9> F = ht8Var.F();
            if (ListUtils.isEmpty(F)) {
                return null;
            }
            if (F.size() > 0 && i >= F.size()) {
                i = F.size() - 1;
            }
            return o1(F.get(i));
        }
        return (MarkData) invokeI.objValue;
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

    public ht8 h3(ht8 ht8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048693, this, ht8Var)) == null) {
            if (ht8Var == null) {
                return null;
            }
            ThreadData M = ht8Var.M();
            M.setIs_good(this.p);
            M.setIs_top(this.q);
            long j = this.r;
            if (j > 0) {
                M.setLast_time_int(j);
            }
            G0(M);
            return ht8Var;
        }
        return (ht8) invokeL.objValue;
    }

    public boolean k3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, str)) == null) {
            this.j = !this.j;
            this.d = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (P2(6)) {
                return true;
            }
            this.j = !this.j;
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String l1(ArrayList<am9> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048705, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                am9 am9Var = (am9) ListUtils.getItem(arrayList, i);
                if (am9Var != null && !StringUtils.isNull(am9Var.O())) {
                    return am9Var.O();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public void q3(ht8 ht8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048723, this, ht8Var) != null) || ht8Var == null) {
            return;
        }
        ht8Var.R0(this.G.X());
        ht8 ht8Var2 = this.G;
        if (!ht8Var2.W && ht8Var.W && ht8Var2.h() != null) {
            ht8Var.F0(this.G.h());
        }
        this.G = ht8Var;
        M2(ht8Var.y().a());
    }

    public boolean s2(boolean z) {
        InterceptResult invokeZ;
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048728, this, z)) == null) {
            if (this.b == null || (ht8Var = this.G) == null || ((!z && ht8Var.y().c() == 0) || this.G.F() == null || this.G.F().size() < 1)) {
                return false;
            }
            return P2(2);
        }
        return invokeZ.booleanValue;
    }

    public void x0(my4 my4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, my4Var) == null) {
            if (my4Var == null) {
                M2(1);
                return;
            }
            if (this.t < my4Var.a()) {
                this.t = my4Var.a();
            }
            if (this.u > my4Var.a()) {
                this.u = my4Var.a();
            }
            this.v = my4Var.h();
        }
    }

    public final void z0(ht8 ht8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048747, this, ht8Var) == null) && ht8Var != null && ht8Var.z() != null && ht8Var.z().getAdvertAppInfo() != null && ht8Var.z().u1() && ht8Var.z().getAdvertAppInfo().c != 1001) {
            this.J0 = ht8Var.z();
        }
    }

    public void D0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if ((!this.j || n2(TbadkCoreApplication.getCurrentAccount())) && this.G.F() != null) {
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
        if ((interceptable != null && interceptable.invokeL(1048653, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(T0()) || db9.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(db9.l().b().e(T0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(db9.l().b().d(T0(), true));
    }

    public final boolean Z1(ht8 ht8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, ht8Var)) == null) {
            if (ht8Var == null || ListUtils.isEmpty(ht8Var.F()) || this.G.M() == null || TextUtils.isEmpty(this.G.M().getFirstPostId())) {
                return false;
            }
            return TextUtils.equals(this.G.M().getFirstPostId(), ht8Var.F().get(0).O());
        }
        return invokeL.booleanValue;
    }

    public final void b3(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048668, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(T0()) || db9.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(db9.l().b().d(T0(), true) + 1);
        pbPageRequestMessage.setLoadCount(db9.l().b().e(T0(), true));
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

    public boolean m3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048711, this, i)) == null) {
            if (i == this.m) {
                return false;
            }
            if (i != 1) {
                q45.m().z("key_pb_current_sort_type", i);
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

    public boolean n2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, str)) == null) {
            if (u1() == null || u1().M() == null || u1().M().getAuthor() == null || StringUtils.isNull(str)) {
                return false;
            }
            String userId = u1().M().getAuthor().getUserId();
            if (StringUtils.isNull(userId)) {
                return false;
            }
            return userId.equals(str);
        }
        return invokeL.booleanValue;
    }

    public final void s0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048726, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = -1;
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() != this.v) {
                    i = J0();
                }
            } else if (pbPageRequestMessage.getPn().intValue() != 1) {
                i = J0();
            }
        } else {
            i = 0;
        }
        pbPageRequestMessage.setAfterAdThreadCount(i);
    }

    public void D2(ht8 ht8Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        ht8 ht8Var2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{ht8Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i4 = i2;
                ht8Var2 = null;
            } else {
                ht8Var2 = ht8Var;
                i4 = i2;
            }
            this.j0 = i4;
            this.isLoading = false;
            if (ht8Var2 != null) {
                E0(ht8Var2);
            }
            z0(ht8Var2);
            zl9 zl9Var = this.J0;
            if (zl9Var != null && zl9Var.u1()) {
                TiebaStatic.log(ak9.e("a005", "common_fill", true, 1));
            }
            E2(ht8Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void E2(ht8 ht8Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{ht8Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z5 = true;
            boolean z6 = !z;
            this.h0 = z3;
            hm9 hm9Var = this.V;
            if (hm9Var != null && !z3) {
                hm9Var.b(z2, z6, i2, str, i3, j, j2);
                this.V = null;
            }
            ht8 ht8Var2 = this.G;
            if (ht8Var2 != null) {
                ht8Var2.Z = z3;
                ht8Var2.a0 = i;
            }
            if (z6 && !z3 && !TextUtils.isEmpty(T0()) && db9.l().b() != null) {
                db9.l().b().g(T0(), L2(E1()), true);
            }
            if (ht8Var != null && (this.s != 1 || i != 5 || ht8Var.F() == null || ht8Var.F().size() >= 1)) {
                this.k = this.l;
                if (i != 8) {
                    this.n = this.m;
                    this.m = ht8Var.g;
                }
                List<PbSortType> list = ht8Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.W.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    ht8Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.W.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    ht8Var.f.add(builder2.build(false));
                    int i6 = this.n;
                    this.m = i6;
                    ht8Var.g = i6;
                }
                this.E = false;
                if (ht8Var.y() != null && (this.m != 2 || i != 8)) {
                    x0(ht8Var.y());
                }
                int i7 = this.v;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.v = i7;
                ArrayList<am9> F = this.G.F();
                switch (i) {
                    case 1:
                        this.G.J0(ht8Var.y(), 1);
                        p3(ht8Var, F);
                        n3(ht8Var);
                        i4 = 0;
                        break;
                    case 2:
                        if (ht8Var.F() != null) {
                            i4 = ht8Var.F().size() + 1;
                            am9 am9Var = (am9) ListUtils.getItem(F, 0);
                            am9 am9Var2 = (am9) ListUtils.getItem(ht8Var.F(), ListUtils.getCount(ht8Var.F()) - 1);
                            if (am9Var != null && am9Var2 != null && am9Var.O().equals(am9Var2.O())) {
                                ht8Var.F().remove(am9Var2);
                                i4--;
                            }
                            if (b2()) {
                                u1 = F.get(1).O();
                            }
                            F.addAll(0, ht8Var.F());
                        } else {
                            i4 = 0;
                        }
                        n3(ht8Var);
                        this.G.J0(ht8Var.y(), 2);
                        break;
                    case 3:
                        if (this.m == 1 && ht8Var.y() != null) {
                            ht8Var.y().k(ht8Var.y().h());
                        }
                        q3(ht8Var);
                        i4 = 0;
                        break;
                    case 4:
                        q3(ht8Var);
                        i4 = 0;
                        break;
                    case 5:
                        q3(ht8Var);
                        i4 = 0;
                        break;
                    case 6:
                        q3(ht8Var);
                        i4 = 0;
                        break;
                    case 7:
                        q3(ht8Var);
                        i4 = 0;
                        break;
                    case 8:
                        if (Z1(ht8Var)) {
                            return;
                        }
                        if (ht8Var != null && !ListUtils.isEmpty(ht8Var.F()) && this.G != null && (!this.j || I2(ht8Var).equals(ht8Var.F().get(0).q().getUserId()))) {
                            if (this.G.y().b() == 0) {
                                this.G.y().l(1);
                            }
                            N2();
                            this.D0 = ht8Var.F().get(0);
                            if (!k2() && !this.G.h0()) {
                                if (this.F0 - this.G0 >= 3) {
                                    am9 am9Var3 = new am9();
                                    this.E0 = am9Var3;
                                    am9Var3.D = false;
                                    am9Var3.a1(53);
                                    this.G.F().add(0, this.E0);
                                }
                                this.G.F().add(0, this.D0);
                                i5 = 0;
                            } else {
                                if (this.G.F().size() - this.F0 >= 3) {
                                    am9 am9Var4 = new am9();
                                    this.E0 = am9Var4;
                                    am9Var4.D = true;
                                    am9Var4.a1(53);
                                    this.G.F().add(this.E0);
                                }
                                this.G.F().add(this.D0);
                                i5 = this.G.F().size() - 1;
                            }
                            if (!StringHelper.isTaday(q45.m().o("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.D0.T = this.G.I();
                                q45.m().A("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        } else {
                            i5 = 0;
                        }
                        n3(ht8Var);
                        i4 = i5;
                        break;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                ht8 ht8Var3 = this.G;
                if (ht8Var3 != null && ht8Var3.M() != null) {
                    PraiseData praise = this.G.M().getPraise();
                    if (this.t1 != null && !praise.isPriaseDataValid()) {
                        this.G.M().setPraise(this.t1);
                    } else {
                        PraiseData praise2 = this.G.M().getPraise();
                        this.t1 = praise2;
                        praise2.setPostId(this.G.M().getFirstPostId());
                    }
                    if (ht8Var.y() != null && ht8Var.y().a() == 1 && ht8Var.M() != null && ht8Var.M().getActDatas() != null && ht8Var.M().getActDatas().size() > 0) {
                        this.G.M().setActDatas(ht8Var.M().getActDatas());
                    }
                    this.G.M().setReply_num(ht8Var.M().getReply_num());
                    this.G.M().setAnchorLevel(ht8Var.M().getAnchorLevel());
                    this.G.M().setCopyThreadRemindType(ht8Var.M().getCopyThreadRemindType());
                    if (ht8Var != null && ht8Var.M() != null) {
                        this.G.M().updateIsNotitle(ht8Var.M().getIsNoTitle());
                    }
                }
                ht8 ht8Var4 = this.G;
                if (ht8Var4 != null && ht8Var4.T() != null && ht8Var.T() != null) {
                    this.G.T().setBimg_end_time(ht8Var.T().getBimg_end_time());
                    this.G.T().setBimg_url(ht8Var.T().getBimg_url());
                    this.G.T().setDynamicUrl(ht8Var.T().getDynamicUrl());
                }
                if (ht8Var.y() != null && ht8Var.y().a() == 1 && ht8Var.W() != null) {
                    this.G.Q0(ht8Var.W());
                }
                if (this.h0) {
                    if (this.G.M() != null && this.G.M().getAuthor() != null && this.G.F() != null && ListUtils.getItem(this.G.F(), 0) != null) {
                        am9 am9Var5 = (am9) ListUtils.getItem(this.G.F(), 0);
                        MetaData author = this.G.M().getAuthor();
                        if (am9Var5.q() != null && am9Var5.q().getGodUserData() != null) {
                            int i8 = this.S;
                            if (i8 != -1) {
                                author.setFansNum(i8);
                                am9Var5.q().setFansNum(this.S);
                            }
                            if (this.T != -1) {
                                GodUserData godUserData = author.getGodUserData();
                                if (this.T == 1) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                godUserData.setIsLike(z4);
                                GodUserData godUserData2 = am9Var5.q().getGodUserData();
                                if (this.T != 1) {
                                    z5 = false;
                                }
                                godUserData2.setIsLike(z5);
                                author.getGodUserData().setIsFromNetWork(false);
                                am9Var5.q().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    ht8 ht8Var5 = this.G;
                    ht8Var5.e = -1;
                    ht8Var5.d = -1;
                }
                h hVar = this.N;
                if (hVar != null) {
                    hVar.c(true, getErrorCode(), i, i4, this.G, this.mErrorString, 1);
                }
            } else if (this.N != null) {
                this.l = this.k;
                if (i2 != 350006) {
                    this.m = this.n;
                }
                this.N.c(false, i2, i, 0, null, str, 1);
            }
            ht8 ht8Var6 = this.G;
            if (ht8Var6 != null && ht8Var6.M() != null && this.G.k() != null && !this.G.h0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = this.W.getPageContext();
                historyMessage.threadId = u1().M().getId();
                if (this.H0 && u1().M().originalThreadData != null) {
                    historyMessage.threadName = u1().M().originalThreadData.b;
                } else {
                    historyMessage.threadName = u1().M().getTitle();
                }
                if (this.H0 && !m2()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = u1().k().getName();
                }
                historyMessage.isHostOnly = X0();
                historyMessage.isSquence = M1();
                historyMessage.threadType = u1().M().getThreadType();
                historyMessage.isShareThread = this.H0;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public ht8 F0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, threadData)) == null) {
            ht8 ht8Var = new ht8();
            ht8Var.C0(3);
            if (threadData == null) {
                return null;
            }
            ht8Var.O0(threadData);
            if (threadData.getForumData() != null) {
                ht8Var.D0(threadData.getForumData());
                ForumData k = ht8Var.k();
                k.setId(threadData.getForumData().b());
                k.setName(threadData.getForumData().d());
                k.setUser_level(threadData.getForumData().c());
                k.setImage_url(threadData.getForumData().a());
                k.setPost_num(threadData.getForumData().g);
                k.setMember_num(threadData.getForumData().h);
            } else {
                ForumData k2 = ht8Var.k();
                k2.setId(String.valueOf(threadData.getFid()));
                k2.setName(threadData.getForum_name());
            }
            am9 am9Var = new am9();
            am9Var.K0(1);
            am9Var.g1(threadData.getCreateTime());
            am9Var.H0(threadData.getAuthor());
            MetaData author = threadData.getAuthor();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(author.getUserId(), author);
            am9Var.j1(hashMap);
            am9Var.c1(TbRichTextView.a0(threadData.getFirstFloorList(), N1(), false));
            ht8Var.E0(am9Var);
            ht8Var.F().add(am9Var);
            ht8Var.L0(new vt8(threadData, null));
            ht8Var.m = true;
            ht8Var.H0(1);
            return ht8Var;
        }
        return (ht8) invokeL.objValue;
    }

    public void o3(UserPendantData userPendantData) {
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048717, this, userPendantData) == null) && userPendantData != null && (ht8Var = this.G) != null && ht8Var.F() != null && this.G.F().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            int size = this.G.F().size();
            for (int i = 0; i < size; i++) {
                if (this.G.F().get(i) != null && this.G.F().get(i).q() != null && currentAccount.equals(this.G.F().get(i).q().getUserId()) && this.G.F().get(i).q().getPendantData() != null) {
                    this.G.F().get(i).q().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    this.G.F().get(i).q().getPendantData().setPropsId(userPendantData.getPropsId());
                }
            }
        }
    }

    public final void F2(int i) {
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048593, this, i) == null) && i != 8) {
            this.C0 = "";
            if (this.D0 != null) {
                if (i == 1 && (ht8Var = this.G) != null && ht8Var.h0()) {
                    if (this.E0 != null) {
                        u1().F().remove(this.E0);
                    }
                } else if (i == 1 && !this.l && !ListUtils.isEmpty(u1().F())) {
                    u1().F().remove(this.D0);
                    if (this.E0 != null) {
                        u1().F().remove(this.E0);
                    }
                    u1().F().add(0, this.D0);
                } else {
                    u1().F().remove(this.D0);
                    if (this.E0 != null) {
                        u1().F().remove(this.E0);
                    }
                }
            }
            this.E0 = null;
        }
    }

    public void G2(ht8 ht8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, ht8Var) != null) || ht8Var == null) {
            return;
        }
        String I2 = I2(ht8Var);
        for (int i = 0; i < ht8Var.F().size(); i++) {
            am9 am9Var = ht8Var.F().get(i);
            for (int i2 = 0; i2 < am9Var.e0().size(); i2++) {
                am9Var.e0().get(i2).n1(this.W.getPageContext(), I2.equals(am9Var.e0().get(i2).q().getUserId()));
            }
        }
        zt8 R = ht8Var.R();
        if (R != null && !ListUtils.isEmpty(R.a)) {
            for (am9 am9Var2 : R.a) {
                for (int i3 = 0; i3 < am9Var2.e0().size(); i3++) {
                    am9Var2.e0().get(i3).n1(this.W.getPageContext(), I2.equals(am9Var2.e0().get(i3).q().getUserId()));
                }
            }
        }
    }

    public boolean P2(int i) {
        InterceptResult invokeI;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048623, this, i)) == null) {
            this.H = i;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            A2(i);
            ht8 f2 = ww8.b().f();
            if (f2 != null && f2.M() != null) {
                f2.M().setCopyThreadRemindType(0);
                this.l = ww8.b().i();
                this.j = ww8.b().a();
                this.o = ww8.b().c();
                this.D0 = ww8.b().g();
                this.E0 = ww8.b().h();
                this.F0 = ww8.b().d();
                boolean z2 = this.j;
                this.A0 = z2;
                if (z2 || this.A) {
                    this.U = false;
                }
                jg.a().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.b0) {
                Q2(R0(), true, this.d, 3);
            }
            if (i == 3 && !this.b0) {
                String R0 = R0();
                if (this.A) {
                    z = true;
                } else {
                    z = false;
                }
                Q2(R0, z, this.d, 3);
            }
            this.b0 = false;
            j70.d(CmdConfigHttp.PB_PAGE_HTTP_CMD, new g(this, i));
            return true;
        }
        return invokeI.booleanValue;
    }

    public String H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
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

    public void H2(ht8 ht8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048599, this, ht8Var, i) != null) || ht8Var == null) {
            return;
        }
        String I2 = I2(ht8Var);
        zt8 R = ht8Var.R();
        if (R != null && !ListUtils.isEmpty(R.a)) {
            List<am9> list = R.a;
            for (am9 am9Var : list.subList(i, list.size())) {
                for (int i2 = 0; i2 < am9Var.e0().size(); i2++) {
                    am9Var.e0().get(i2).n1(this.W.getPageContext(), I2.equals(am9Var.e0().get(i2).q().getUserId()));
                }
            }
        }
    }

    public final int J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            int i = 0;
            if (u1().F() == null) {
                return 0;
            }
            ArrayList<am9> F = u1().F();
            for (int size = F.size() - 1; size >= 0; size--) {
                am9 am9Var = F.get(size);
                if (am9Var instanceof zl9) {
                    if (am9Var.getType() != AdvertAppInfo.x) {
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

    public MarkData Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(this.G.u());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(k2()));
            markData.setId(this.b);
            return markData;
        }
        return (MarkData) invokeV.objValue;
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
            pbPageRequestMessage.setLastids(gc5.l);
            if (this.j || this.A) {
                this.U = false;
            }
            try {
                if (this.b != null && this.b.length() != 0) {
                    pbPageRequestMessage.set_kz(gg.g(this.b, 0L));
                    pbPageRequestMessage.setFloorSortType(1);
                    pbPageRequestMessage.setFloor_rn(this.a);
                    pbPageRequestMessage.set_rn(15);
                    pbPageRequestMessage.set_with_floor(1);
                    pbPageRequestMessage.set_scr_w(Integer.valueOf(ii.l(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_h(Integer.valueOf(ii.j(TbadkCoreApplication.getInst().getApp())));
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
                        pbPageRequestMessage.setOpStat(gg.e(this.Q, 0));
                        pbPageRequestMessage.setOpMessageID(this.D);
                    }
                    w0(pbPageRequestMessage, i);
                    this.A0 = this.j;
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.A));
                    pbPageRequestMessage.setCacheKey(R0());
                    pbPageRequestMessage.setObjParam1(String.valueOf(this.B0));
                    pbPageRequestMessage.setIsSubPostDataReverse(this.f0);
                    if (this.i0) {
                        i4 = 1;
                    }
                    pbPageRequestMessage.setFromSmartFrs(i4);
                    t0(pbPageRequestMessage);
                    pbPageRequestMessage.setNeedRepostRecommendForum(this.i);
                    u0(pbPageRequestMessage);
                    y0(pbPageRequestMessage);
                    pbPageRequestMessage.setOriUgcNid(this.L0);
                    pbPageRequestMessage.setOriUgcTid(this.M0);
                    pbPageRequestMessage.setOriUgcType(this.N0);
                    pbPageRequestMessage.setOriUgcVid(this.O0);
                    if (!StringUtils.isNull(this.Y0)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.Y0));
                    }
                    s0(pbPageRequestMessage);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.Z0);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.setReqFoldComment(this.h1);
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

    public final void W1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048648, this, bundle) == null) {
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
            this.T = bundle.getInt("extra_pb_is_attention_key", -1);
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
        ht8 ht8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048617, this) == null) && (ht8Var = this.G) != null && !ListUtils.isEmpty(ht8Var.F())) {
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

    public final boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (this.G.z() == null || this.G.z().getAdvertAppInfo() == null || this.G.z().getAdvertAppInfo().c == 1001) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public MetaData W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            ht8 ht8Var = this.G;
            if (ht8Var == null || ht8Var.M() == null || this.G.M().getAuthor() == null) {
                return null;
            }
            return this.G.M().getAuthor();
        }
        return (MetaData) invokeV.objValue;
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
            qc9.f().a("PB");
            v2();
        }
    }

    public boolean j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            if (PBCacheBlockSwitch.getIsOn() || !this.K0 || a57.b() == null || !a57.b().equals(this.b) || a57.a() == null) {
                return false;
            }
            return true;
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
                hm9 hm9Var = new hm9("pbStat");
                this.V = hm9Var;
                hm9Var.f();
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

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            if (t1() == 3 || u1() == null || u1().M() == null || !u1().M().isMutiForumThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void Q2(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    public final String R0() {
        InterceptResult invokeV;
        String r1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            String str = this.b;
            if (str != null && !str.equals("0")) {
                r1 = this.b;
            } else {
                r1 = r1();
            }
            if (this.j) {
                r1 = r1 + "_host";
            }
            int i = this.m;
            if (i == 1) {
                r1 = r1 + "_rev";
            } else if (i == 2) {
                r1 = r1 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return r1 + TbadkCoreApplication.getCurrentAccount();
            }
            return r1;
        }
        return (String) invokeV.objValue;
    }

    public final String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
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

    public void w2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048740, this) == null) && "personalize_page".equals(this.mStType) && this.G != null && this.e0 != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new StatisticItem("c10754").param("fid", this.G.l()).param("tid", this.b).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.e0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.e0 = 0L;
        }
    }

    public final void X1(Intent intent) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048652, this, intent) != null) || intent == null) {
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
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.o1);
        } else if (StringUtils.isNull(this.b)) {
            this.a1 = true;
            this.s0.b(intent, this.o1);
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
                    this.N0 = gg.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.O0)) {
                    this.O0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        String str2 = "0";
        if (hi.isEmpty(this.b)) {
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
            intExtra2 = q45.m().n("key_pb_current_sort_type", 2);
        }
        this.m = intExtra2;
        if (g2()) {
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
        this.T = intent.getIntExtra("extra_pb_is_attention_key", -1);
        this.S = intent.getIntExtra("extra_pb_funs_count_key", -1);
        this.y = intent.getBooleanExtra("from_frs", false);
        this.z = intent.getBooleanExtra("from_maintab", false);
        this.i0 = intent.getBooleanExtra("from_smart_frs", false);
        this.L = intent.getBooleanExtra("from_hottopic", false);
        this.v0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.H0 = intent.getBooleanExtra("key_is_share_thread", false);
        boolean booleanExtra = intent.getBooleanExtra("key_need_preload", false);
        this.K0 = booleanExtra;
        if (!booleanExtra && !a57.c()) {
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
            if (P2(6)) {
                return true;
            }
            this.j = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public void p2(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048719, this, forumData, cVar) == null) {
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
            this.y0.T(str3, str, cVar);
        }
    }

    public void p3(ht8 ht8Var, ArrayList<am9> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048720, this, ht8Var, arrayList) == null) && arrayList != null && ht8Var.F() != null) {
            am9 am9Var = (am9) ListUtils.getItem(ht8Var.F(), 0);
            if (am9Var != null) {
                String l1 = l1(arrayList);
                String O = am9Var.O();
                if (StringUtils.isNull(O) || "0".equals(O) || (l1 != null && l1.equals(O))) {
                    ht8Var.F().remove(am9Var);
                }
            }
            this.G.Y = arrayList.size();
            arrayList.addAll(ht8Var.F());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0223, code lost:
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0210, code lost:
        if ((r11.u - 1) <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0221, code lost:
        if (r11.t >= r11.v) goto L103;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void w0(PbPageRequestMessage pbPageRequestMessage, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048738, this, pbPageRequestMessage, i) != null) || pbPageRequestMessage == null) {
            return;
        }
        ArrayList<am9> F = this.G.F();
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
                                am9 am9Var = F.get(i4);
                                if (am9Var != null) {
                                    String O = am9Var.O();
                                    this.d = O;
                                    if (StringUtils.isNull(O)) {
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
                        pbPageRequestMessage.set_pid(gg.g(this.d, 0L));
                        if (this.m == 2) {
                            pbPageRequestMessage.set_pid(0L);
                        }
                    } else if (this.m == 1) {
                        pbPageRequestMessage.set_last(1);
                    }
                }
                X2(pbPageRequestMessage);
                String l1 = l1(F);
                if (StringUtils.isNotNull(l1)) {
                    v0(pbPageRequestMessage, gg.g(l1, 0L));
                    return;
                }
                return;
            case 2:
                if (F != null && F.size() > 0 && F.get(0) != null) {
                    this.d = F.get(0).O();
                }
                pbPageRequestMessage.set_back(1);
                pbPageRequestMessage.set_banner(0);
                if (this.A) {
                    if (k2()) {
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
                    pbPageRequestMessage.set_pid(gg.g(this.d, 0L));
                    if (this.m == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                    v0(pbPageRequestMessage, gg.g(this.d, 0L));
                }
                X2(pbPageRequestMessage);
                return;
            case 3:
                if (!this.A && !this.j) {
                    pbPageRequestMessage.set_banner(1);
                } else {
                    pbPageRequestMessage.set_banner(0);
                }
                if (g2() && this.m == 0) {
                    pbPageRequestMessage.set_pid(gg.g(this.g, 0L));
                }
                if (b2()) {
                    this.B0 = 12;
                    if (this.m == 1 && !UbsABTestHelper.isPbReplyOptimize() && (i2 = this.v) > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(i2));
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (!b2()) {
                    if (k2()) {
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
                v0(pbPageRequestMessage, -1L);
                return;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(gg.g(this.d, 0L));
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
                if (g2()) {
                    pbPageRequestMessage.setObjLocate("reply_jump_first");
                }
                pbPageRequestMessage.set_mark(1);
                if (this.m == 1 && this.A0 && !this.j) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(gg.g(this.d, 0L));
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
                v0(pbPageRequestMessage, -1L);
                return;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.g0);
                X2(pbPageRequestMessage);
                return;
            case 8:
                pbPageRequestMessage.set_pid(gg.g(this.C0, 0L));
                if (this.m == 1) {
                    pbPageRequestMessage.set_arround(1);
                    pbPageRequestMessage.set_back(1);
                    pbPageRequestMessage.set_pn(0);
                    pbPageRequestMessage.set_rn(2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void z2(ht8 ht8Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048749, this, ht8Var, i, str) == null) {
            this.b0 = true;
            if (ht8Var != null && ht8Var.h == null) {
                q3(ht8Var);
                E0(ht8Var);
                if (ht8Var.M() != null) {
                    ht8Var.M().setCopyThreadRemindType(0);
                }
                h hVar = this.N;
                if (hVar != null && ht8Var != null) {
                    hVar.c(true, 0, i, 0, ht8Var, str, 0);
                }
            }
        }
    }
}
