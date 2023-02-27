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
import com.baidu.tieba.a05;
import com.baidu.tieba.ae8;
import com.baidu.tieba.ag8;
import com.baidu.tieba.ah8;
import com.baidu.tieba.av6;
import com.baidu.tieba.b55;
import com.baidu.tieba.c69;
import com.baidu.tieba.cw8;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.ed8;
import com.baidu.tieba.ej;
import com.baidu.tieba.fd8;
import com.baidu.tieba.gh;
import com.baidu.tieba.hd8;
import com.baidu.tieba.kh;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.oc5;
import com.baidu.tieba.ox8;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.q45;
import com.baidu.tieba.qg8;
import com.baidu.tieba.r80;
import com.baidu.tieba.rg8;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.uf8;
import com.baidu.tieba.v59;
import com.baidu.tieba.vb5;
import com.baidu.tieba.vd8;
import com.baidu.tieba.w39;
import com.baidu.tieba.wb;
import com.baidu.tieba.x9;
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
    public static int UPGRADE_TO_PHOTO_LIVE = 0;
    public static final String WISE = "wise";
    public static String y1;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public SuggestEmotionModel A0;
    public boolean B;
    public GetSugMatchWordsModel B0;
    public boolean C;
    public boolean C0;
    public long D;
    public int D0;
    public boolean E;
    public String E0;
    public String F;
    public PostData F0;
    public hd8 G;
    public PostData G0;
    public int H;
    public int H0;
    public int I;
    public int I0;
    public boolean J;
    public boolean J0;
    public boolean K;
    public Rect K0;
    public boolean L;
    public int L0;
    public boolean M;
    public String M0;
    public String N;
    public v59 N0;
    public Context O;
    public boolean O0;
    public h P;
    public String P0;
    public String Q;
    public String Q0;
    public String R;
    public int R0;
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
    public c69 X;
    public String X0;
    public BaseFragmentActivity Y;
    public String Y0;
    public boolean Z;
    public String Z0;
    public int a;
    public boolean a0;
    public boolean a1;
    public String b;
    public long b0;
    public int b1;
    public boolean c;
    public boolean c0;
    public String c1;
    public String d;
    public boolean d0;
    public int d1;
    public String e;
    public String e0;
    public boolean e1;
    public String f;
    public String f0;
    public boolean f1;
    public String g;
    public long g0;
    public String g1;
    public String h;
    public boolean h0;
    public String h1;
    public boolean i;
    public int i0;
    public String i1;
    public boolean isLoading;
    public boolean j;
    public boolean j0;
    public boolean j1;
    public boolean k;
    public boolean k1;
    public boolean l;
    public boolean l1;
    public int m;
    public boolean m1;
    public String mStType;
    public String mTopicId;
    public String mTopicSubjectName;
    public int n;
    public boolean n1;
    public boolean o;
    public boolean o1;
    public int p;
    public int p1;
    public int q;
    public String q1;
    public long r;
    public boolean r0;
    public boolean r1;
    public int s;
    public int s0;
    public BdUniDispatchSchemeController.b s1;
    public String showReplyPanel;
    public int t;
    public fd8 t0;
    public CustomMessageListener t1;
    public int u;
    public final qg8 u0;
    public wb u1;
    public int v;
    public final ag8 v0;
    public CustomMessageListener v1;
    public boolean w;
    public final rg8 w0;
    public CustomMessageListener w1;
    public boolean x;
    public String x0;
    public PraiseData x1;
    public boolean y;
    public final CheckRealNameModel y0;
    public boolean z;
    public final AddExperiencedModel z0;

    /* loaded from: classes5.dex */
    public interface h {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(hd8 hd8Var);

        void c(boolean z, int i, int i2, int i3, hd8 hd8Var, String str, int i4);
    }

    public final int O2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class g implements r80.b {
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
                hd8 pbData;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    ResponsedMessage responsedMessage = this.a;
                    boolean z = true;
                    if ((responsedMessage instanceof pbPageHttpResponseMessage) && (pbData = ((pbPageHttpResponseMessage) responsedMessage).getPbData()) != null) {
                        String S = pbData.S();
                        if (!TextUtils.isEmpty(this.b.b.b) && this.b.b.b.equals(S)) {
                            z = false;
                        }
                    }
                    if (z) {
                        this.b.b();
                    } else if (this.b.b.u1 != null) {
                        this.b.b.u1.onMessage(this.a);
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
                    gVar.b.N2(gVar.a);
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

        @Override // com.baidu.tieba.r80.b
        public void a(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                kh.e(new a(this, responsedMessage));
            }
        }

        @Override // com.baidu.tieba.r80.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                kh.e(new b(this));
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
                this.a.P0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.Q0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.R0 = dh.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.S0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_SHOW_REPLY_PANEL) instanceof String) {
                this.a.showReplyPanel = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_SHOW_REPLY_PANEL);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_PUSH_TYPE) instanceof String) {
                this.a.T0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_PUSH_TYPE);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_SOURCE) instanceof String) {
                this.a.U0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_SOURCE);
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
                if (this.a.s1() != null && this.a.s1().l() != null && this.a.s1().l().getSignData() != null && signData.forumId.equals(this.a.s1().m())) {
                    this.a.s1().l().getSignData().is_signed = signData.is_signed;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends wb {
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

        @Override // com.baidu.tieba.wb
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            boolean z;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                boolean z2 = responsedMessage instanceof pbPageSocketResponseMessage;
                if (!z2 && !(responsedMessage instanceof pbPageHttpResponseMessage)) {
                    return;
                }
                if (responsedMessage.getOrginalMessage().getSelf() instanceof PbPageRequestMessage) {
                    PbPageRequestMessage pbPageRequestMessage = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getSelf();
                    pbPageRequestMessage.isFromPbOptimize();
                    pbPageRequestMessage.get_kz();
                }
                if (responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId() && responsedMessage.getOrginalMessage().getTag() != r80.d) {
                    return;
                }
                if (responsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.Y.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    this.a.F2((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    this.a.E2((pbPageHttpResponseMessage) responsedMessage);
                    z = true;
                } else {
                    z = false;
                }
                if (responsedMessage.getError() != 0) {
                    long j = 0;
                    if (!z) {
                        j = ((pbPageSocketResponseMessage) responsedMessage).sequenceID;
                    }
                    PbPageRequestMessage pbPageRequestMessage2 = (PbPageRequestMessage) responsedMessage.getOrginalMessage().getExtra();
                    long clientLogID = responsedMessage.getOrginalMessage().getClientLogID();
                    int cmd = responsedMessage.getOrginalMessage().getCmd();
                    int error = responsedMessage.getError();
                    String errorString = responsedMessage.getErrorString();
                    Object[] objArr = new Object[6];
                    objArr[0] = "updateType";
                    String str2 = null;
                    if (pbPageRequestMessage2 != null) {
                        str = String.valueOf(pbPageRequestMessage2.getUpdateType());
                    } else {
                        str = null;
                    }
                    objArr[1] = str;
                    objArr[2] = "ThreadId";
                    if (pbPageRequestMessage2 != null) {
                        str2 = String.valueOf(pbPageRequestMessage2.get_kz());
                    }
                    objArr[3] = str2;
                    objArr[4] = PushConstants.SEQ_ID;
                    objArr[5] = Long.valueOf(j);
                    q45.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                }
                if (!this.a.Z || !this.a.a0) {
                    if (!this.a.Z) {
                        this.a.Z = true;
                    } else {
                        this.a.a0 = true;
                    }
                    if (this.a.P != null) {
                        this.a.P.a(this.a.u1(), z, responsedMessage, this.a.c0, System.currentTimeMillis() - this.a.b0);
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
                hd8 hd8Var = this.a.G;
                if (hd8Var != null && hd8Var.h() != null && this.a.G.h().b() != null && this.a.G.h().b().equals(valueOf)) {
                    this.a.G.h().j(false);
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
                hd8 hd8Var = this.a.G;
                if (hd8Var != null && hd8Var.h() != null && this.a.G.h().b() != null && this.a.G.h().b().equals(valueOf)) {
                    this.a.G.h().j(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hd8 a;
        public final /* synthetic */ PbModel b;

        public f(PbModel pbModel, hd8 hd8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, hd8Var};
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
            this.a = hd8Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.H2(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
                this.b.isLoading = false;
            }
        }
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
        int a2 = vb5.a() / 30;
        y1 = null;
        UPGRADE_TO_PHOTO_LIVE = 1;
    }

    public String A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.V0;
        }
        return (String) invokeV.objValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return !TextUtils.isEmpty(this.h);
        }
        return invokeV.booleanValue;
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var != null) {
                return hd8Var.N();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return !TextUtils.isEmpty(this.g);
        }
        return invokeV.booleanValue;
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return j2();
        }
        return invokeV.booleanValue;
    }

    public String E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.T0;
        }
        return (String) invokeV.objValue;
    }

    public AddExperiencedModel F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.z0;
        }
        return (AddExperiencedModel) invokeV.objValue;
    }

    public String F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.q1;
        }
        return (String) invokeV.objValue;
    }

    public fd8 H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return this.t0;
        }
        return (fd8) invokeV.objValue;
    }

    public int H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.p1;
        }
        return invokeV.intValue;
    }

    public int I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public Rect J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            Rect rect = this.K0;
            this.K0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public int J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public BaijiahaoData K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var != null && hd8Var.Q() != null) {
                return this.G.Q().getBaijiahaoData();
            }
            return null;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public boolean K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return j2();
        }
        return invokeV.booleanValue;
    }

    public v59 L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.N0;
        }
        return (v59) invokeV.objValue;
    }

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.L0;
        }
        return invokeV.intValue;
    }

    public CheckRealNameModel M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.y0;
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

    public final void M2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            registerListener(this.u1);
            registerListener(this.t1);
            registerListener(this.w1);
            registerListener(this.v1);
        }
    }

    public ag8 N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.v0;
        }
        return (ag8) invokeV.objValue;
    }

    public String N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    public PostData O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.F0;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.e0;
        }
        return (String) invokeV.objValue;
    }

    public PostData P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.G0;
        }
        return (PostData) invokeV.objValue;
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
            return this.f0;
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
            return this.i1;
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
            hd8 hd8Var = this.G;
            if (hd8Var != null && hd8Var.Q() != null) {
                return this.G.Q().worksInfoData;
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
            return this.g1;
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
            return this.h1;
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
            hd8 hd8Var = this.G;
            if (hd8Var != null && !ListUtils.isEmpty(hd8Var.H())) {
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
            return this.f1;
        }
        return invokeV.booleanValue;
    }

    public int W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.b1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.j1;
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
            uf8.b().d(P0(), this.A);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return w2();
        }
        return invokeV.booleanValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.M;
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
            return this.k1;
        }
        return invokeV.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var != null && hd8Var.l() != null && this.G.Q() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean a1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.j0;
        }
        return invokeV.booleanValue;
    }

    public boolean b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (12 != this.Y.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) && 12 != this.D0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int c1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.r1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var == null) {
                return false;
            }
            return hd8Var.r();
        }
        return invokeV.booleanValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.r0;
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
            return this.n1;
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
            return this.m1;
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
            return this.a1;
        }
        return invokeV.booleanValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.s0;
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
            hd8 hd8Var = this.G;
            if (hd8Var == null) {
                return false;
            }
            return hd8Var.x0();
        }
        return invokeV.booleanValue;
    }

    public boolean h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048692, this)) == null) {
            return this.W;
        }
        return invokeV.booleanValue;
    }

    public String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return y1;
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
            return this.J0;
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

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.I0;
        }
        return invokeV.intValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.o1;
        }
        return invokeV.booleanValue;
    }

    public int l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.H0;
        }
        return invokeV.intValue;
    }

    public boolean l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            if (s1() != null && s1().z0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean m3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048711, this)) == null) {
            if (j2() && this.G.z().b() == 0) {
                q2(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var != null && hd8Var.r()) {
                return this.G.v();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public rg8 o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            return this.w0;
        }
        return (rg8) invokeV.objValue;
    }

    public void o2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048716, this) == null) {
            y1 = null;
        }
    }

    public a05 q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048723, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var == null) {
                return null;
            }
            return hd8Var.z();
        }
        return (a05) invokeV.objValue;
    }

    public int r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.D0;
        }
        return invokeV.intValue;
    }

    public hd8 s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            return this.G;
        }
        return (hd8) invokeV.objValue;
    }

    public hd8 t1() {
        InterceptResult invokeV;
        v59 v59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048735, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var == null) {
                return hd8Var;
            }
            if (!U1() && (v59Var = this.N0) != null) {
                this.G.N0(v59Var);
            }
            return this.G;
        }
        return (hd8) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            if (this.b != null && this.d != null) {
                cancelMessage();
                if (this.A) {
                    return S2(4);
                }
                return S2(6);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.x0;
        }
        return (String) invokeV.objValue;
    }

    public String w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return this.M0;
        }
        return (String) invokeV.objValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            String str = this.d;
            if (str != null && !str.equals("0") && this.d.length() != 0) {
                return t2();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048747, this) == null) {
            this.N0 = null;
        }
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.X0;
        }
        return (String) invokeV.objValue;
    }

    public final void x2() {
        c69 c69Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048749, this) == null) && (c69Var = this.X) != null) {
            c69Var.a();
            this.X = null;
        }
    }

    public void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048750, this) == null) {
            this.h = "";
        }
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.Y0;
        }
        return (String) invokeV.objValue;
    }

    public void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048753, this) == null) {
            this.g = null;
        }
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            return this.W0;
        }
        return (String) invokeV.objValue;
    }

    public void z2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048755, this) == null) && "personalize_page".equals(this.mStType)) {
            this.g0 = System.currentTimeMillis() / 1000;
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
                super((x9) newInitContext.callArgs[0]);
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
        this.a0 = false;
        this.e0 = null;
        this.f0 = null;
        this.g0 = 0L;
        this.h0 = false;
        this.i0 = -1;
        this.r0 = false;
        this.C0 = false;
        this.D0 = 0;
        this.L0 = 0;
        this.O0 = false;
        this.b1 = 3;
        this.d1 = 0;
        this.m1 = false;
        this.n1 = false;
        this.o1 = false;
        this.p1 = -1;
        this.q1 = null;
        this.r1 = false;
        this.t1 = new b(this, 2001222);
        this.u1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.v1 = new d(this, 2001336);
        this.w1 = new e(this, 2001335);
        this.x1 = null;
        hd8 hd8Var = new hd8();
        this.G = hd8Var;
        hd8Var.F0(0);
        this.O = baseFragmentActivity.getPageContext().getPageActivity();
        this.Y = baseFragmentActivity;
        this.u0 = new qg8();
        this.v0 = new ag8(this, this.Y);
        this.w0 = new rg8(this, this.Y);
        this.y0 = new CheckRealNameModel(this.Y.getPageContext());
        this.A0 = new SuggestEmotionModel();
        this.z0 = new AddExperiencedModel(this.Y.getPageContext());
        this.s1 = new a(this);
    }

    public void R2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048632, this, bundle) == null) {
            bundle.putString("thread_id", this.b);
            bundle.putString("post_id", this.d);
            bundle.putString("forum_id", this.e);
            bundle.putString("from_forum_id", this.f);
            bundle.putInt("key_start_from", this.D0);
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
            bundle.putBoolean("from_smart_frs", this.r0);
            bundle.putBoolean("from_hottopic", this.M);
            bundle.putBoolean("key_is_share_thread", this.J0);
            bundle.putString("key_ori_ugc_nid", this.P0);
            bundle.putString("key_ori_ugc_tid", this.Q0);
            bundle.putInt("key_ori_ugc_type", this.R0);
            bundle.putString("key_ori_ugc_vid", this.S0);
            bundle.putString("key_rec_weight", this.V0);
            bundle.putString("key_rec_source", this.W0);
            bundle.putString("key_rec_ab_tag", this.X0);
            bundle.putString("key_rec_extra", this.Y0);
            bundle.putBoolean("key_is_tieba_plus", this.f1);
            bundle.putString("key_tieba_plus_order_id", this.g1);
            bundle.putString("key_tieba_plus_token", this.h1);
            bundle.putString("key_tieba_extra_param", this.i1);
            bundle.putBoolean("key_tieba_plus_cant_delete", this.j1);
            bundle.putBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, this.k1);
            bundle.putBoolean("is_jump_from_video_tab", this.m1);
            bundle.putBoolean("is_jump_from_video_middle", this.n1);
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
        b3(hVar);
        M2();
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
        b3(hVar);
        M2();
    }

    public void U2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048644, this, i, i2) == null) {
            this.H0 = i;
            this.I0 = i2;
        }
    }

    public final void s0(PbPageRequestMessage pbPageRequestMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048730, this, pbPageRequestMessage, j) == null) && pbPageRequestMessage != null && !UbsABTestHelper.isPbReplyOptimize()) {
            pbPageRequestMessage.setLastPid(j);
        }
    }

    public void B0(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, hd8Var) != null) || hd8Var == null) {
            return;
        }
        if (this.L || this.J || this.K) {
            hd8Var = k3(hd8Var);
        }
        J2(hd8Var);
    }

    public void P2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048624, this, i) == null) {
            this.s = i;
            this.t = i;
            this.u = i;
        }
    }

    public void V2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, str) == null) {
            this.f0 = str;
        }
    }

    public void W2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048651, this, i) == null) {
            this.d1 = i;
        }
    }

    public void X2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048655, this, i) == null) {
            this.b1 = i;
        }
    }

    public void Y2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048659, this, i) == null) {
            this.p = i;
        }
    }

    public void Z2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048662, this, i) == null) {
            this.q = i;
        }
    }

    public void b3(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, hVar) == null) {
            this.P = hVar;
        }
    }

    public void c3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048672, this, i) == null) {
            this.D0 = i;
        }
    }

    public void d3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048676, this, str) == null) {
            this.M0 = str;
        }
    }

    public void f3(int i) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048683, this, i) == null) && (hd8Var = this.G) != null) {
            hd8Var.Q0(i);
        }
    }

    public void g3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048686, this, z) == null) {
            this.l1 = z;
        }
    }

    public void i3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048696, this, i) == null) {
            this.a = i;
        }
    }

    public void l3(boolean z) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048707, this, z) == null) && (hd8Var = this.G) != null) {
            hd8Var.J0(z);
        }
    }

    public final void q0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048722, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (UtilHelper.isUgcThreadType(this.R0)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.e);
        }
    }

    public boolean q2(boolean z) {
        InterceptResult invokeZ;
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048724, this, z)) == null) {
            if (this.b == null || (hd8Var = this.G) == null) {
                return false;
            }
            if (!z && hd8Var.z().b() == 0) {
                return false;
            }
            return S2(1);
        }
        return invokeZ.booleanValue;
    }

    public final void q3(@NonNull hd8 hd8Var) {
        hd8 hd8Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048725, this, hd8Var) == null) && (hd8Var2 = this.G) != null) {
            hd8Var2.e().clear();
            this.G.e().addAll(hd8Var.e());
        }
    }

    public final void r0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048726, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (this.D0 == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
    }

    public void s2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048732, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.b = str;
        this.d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public final void v0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048741, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = this.D0;
        if (i != 7 && i != 5 && !this.e1) {
            pbPageRequestMessage.setSourceType(2);
        } else {
            pbPageRequestMessage.setSourceType(1);
        }
    }

    public void v2(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048743, this, bVar) != null) || bVar == null) {
            return;
        }
        if (this.B0 == null) {
            this.B0 = new GetSugMatchWordsModel(this.Y.getPageContext());
        }
        this.B0.P(bVar);
    }

    public void A0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if ((!this.j || n2(TbadkCoreApplication.getCurrentAccount())) && this.G.H() != null) {
                this.G.z().l(1);
                if (this.G.z().b() == 0) {
                    this.G.z().l(1);
                }
                this.E0 = str;
                S2(8);
            }
        }
    }

    public final boolean Y1(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048658, this, hd8Var)) == null) {
            if (hd8Var == null || ListUtils.isEmpty(hd8Var.H()) || this.G.Q() == null || TextUtils.isEmpty(this.G.Q().getFirstPostId())) {
                return false;
            }
            return TextUtils.equals(this.G.Q().getFirstPostId(), hd8Var.H().get(0).O());
        }
        return invokeL.booleanValue;
    }

    public final void a3(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048666, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(R0()) || cw8.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(cw8.l().b().e(R0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(cw8.l().b().d(R0(), true));
    }

    public final void e3(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048680, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(R0()) || cw8.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(cw8.l().b().d(R0(), true) + 1);
        pbPageRequestMessage.setLoadCount(cw8.l().b().e(R0(), true));
    }

    public void h3(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048693, this, uri) == null) {
            boolean z = false;
            if (uri == null) {
                this.o1 = false;
                return;
            }
            String queryParameter = uri.getQueryParameter("obj_source");
            String uri2 = uri.toString();
            if (!TextUtils.isEmpty(uri2) && uri2.contains(UNIDISPATCH_PB) && ("shoubai".equals(queryParameter) || WISE.equals(queryParameter))) {
                z = true;
            }
            this.o1 = z;
            if ("shoubai".equals(queryParameter)) {
                this.p1 = 5;
            } else if (WISE.equals(queryParameter)) {
                this.p1 = 4;
            } else {
                this.p1 = -1;
            }
            this.q1 = uri.getQueryParameter(TiebaStatic.Params.EQID);
        }
    }

    public boolean n2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048713, this, str)) == null) {
            if (s1() != null && s1().Q() != null && s1().Q().getAuthor() != null && !StringUtils.isNull(str)) {
                String userId = s1().Q().getAuthor().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
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

    public boolean p3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048721, this, i)) == null) {
            if (i == this.m) {
                return false;
            }
            if (i != 1) {
                b55.m().z("key_pb_current_sort_type", i);
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

    public void r2(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048728, this, hd8Var) != null) || hd8Var == null) {
            return;
        }
        this.b = hd8Var.S();
        if (hd8Var.Q() != null && hd8Var.Q().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = hd8Var.Q().getBaijiahaoData();
            this.P0 = baijiahaoData.oriUgcNid;
            this.Q0 = baijiahaoData.oriUgcTid;
            this.R0 = baijiahaoData.oriUgcType;
            this.S0 = baijiahaoData.oriUgcVid;
        } else {
            this.P0 = null;
            this.Q0 = null;
            this.R0 = 0;
            this.S0 = null;
        }
        this.d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public hd8 C0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, threadData)) == null) {
            hd8 hd8Var = new hd8();
            hd8Var.F0(3);
            if (threadData == null) {
                return null;
            }
            hd8Var.R0(threadData);
            if (threadData.getForumData() != null) {
                hd8Var.G0(threadData.getForumData());
                ForumData l = hd8Var.l();
                l.setId(threadData.getForumData().b());
                l.setName(threadData.getForumData().d());
                l.setUser_level(threadData.getForumData().c());
                l.setImage_url(threadData.getForumData().a());
                l.setPost_num(threadData.getForumData().g);
                l.setMember_num(threadData.getForumData().h);
            } else {
                ForumData l2 = hd8Var.l();
                l2.setId(String.valueOf(threadData.getFid()));
                l2.setName(threadData.getForum_name());
            }
            PostData postData = new PostData();
            postData.J0(1);
            postData.f1(threadData.getCreateTime());
            postData.G0(threadData.getAuthor());
            MetaData author = threadData.getAuthor();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(author.getUserId(), author);
            postData.i1(hashMap);
            postData.b1(TbRichTextView.a0(threadData.getFirstFloorList(), M1(), false));
            hd8Var.H0(postData);
            hd8Var.H().add(postData);
            hd8Var.O0(new vd8(threadData, null));
            hd8Var.m = true;
            hd8Var.K0(1);
            return hd8Var;
        }
        return (hd8) invokeL.objValue;
    }

    public boolean S2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i)) == null) {
            this.H = i;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            D2(i);
            hd8 f2 = ah8.b().f();
            if (f2 != null && f2.Q() != null) {
                f2.Q().setCopyThreadRemindType(0);
                this.l = ah8.b().i();
                this.j = ah8.b().a();
                this.o = ah8.b().c();
                this.F0 = ah8.b().g();
                this.G0 = ah8.b().h();
                this.H0 = ah8.b().d();
                this.K0 = ah8.b().k();
                this.L0 = ah8.b().j();
                boolean z = this.j;
                this.C0 = z;
                if (z || this.A) {
                    this.W = false;
                }
                gh.a().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.d0) {
                T2(P0(), true, this.d, 3);
            }
            if (i == 3 && !this.d0) {
                if (this.A) {
                    T2(P0(), true, this.d, 3);
                } else {
                    T2(P0(), false, this.d, 3);
                }
            }
            this.d0 = false;
            r80.d(CmdConfigHttp.PB_PAGE_HTTP_CMD, new g(this, i));
            return true;
        }
        return invokeI.booleanValue;
    }

    public void r3(UserPendantData userPendantData) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048729, this, userPendantData) == null) && userPendantData != null && (hd8Var = this.G) != null && hd8Var.H() != null && this.G.H().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            int size = this.G.H().size();
            for (int i = 0; i < size; i++) {
                if (this.G.H().get(i) != null && this.G.H().get(i).r() != null && currentAccount.equals(this.G.H().get(i).r().getUserId()) && this.G.H().get(i).r().getPendantData() != null) {
                    this.G.H().get(i).r().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    this.G.H().get(i).r().getPendantData().setPropsId(userPendantData.getPropsId());
                }
            }
        }
    }

    public void C2(hd8 hd8Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, hd8Var, i, str) == null) {
            this.d0 = true;
            if (hd8Var != null && hd8Var.h == null) {
                t3(hd8Var);
                B0(hd8Var);
                if (hd8Var.Q() != null) {
                    hd8Var.Q().setCopyThreadRemindType(0);
                }
                h hVar = this.P;
                if (hVar != null && hd8Var != null) {
                    hVar.c(true, 0, i, 0, hd8Var, str, 0);
                }
            }
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

    public void E2(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.t0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            G2(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void F2(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.t0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            G2(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public MarkData I0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            hd8 hd8Var = this.G;
            if (hd8Var == null) {
                return null;
            }
            ArrayList<PostData> H = hd8Var.H();
            if (ListUtils.isEmpty(H)) {
                return null;
            }
            if (H.size() > 0 && i >= H.size()) {
                i = H.size() - 1;
            }
            return m1(H.get(i));
        }
        return (MarkData) invokeI.objValue;
    }

    public String L2(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, hd8Var)) == null) {
            String str = null;
            if (hd8Var == null) {
                return null;
            }
            if (hd8Var.Q() != null && hd8Var.Q().getAuthor() != null) {
                str = hd8Var.Q().getAuthor().getUserId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final String j1(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048699, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                PostData postData = (PostData) ListUtils.getItem(arrayList, i);
                if (postData != null && !StringUtils.isNull(postData.O())) {
                    return postData.O();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean j3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048701, this, i)) == null) {
            this.s = i;
            if (i > this.G.z().h()) {
                this.s = this.G.z().h();
            }
            if (this.s < 1) {
                this.s = 1;
            }
            if (this.b == null) {
                return false;
            }
            return S2(5);
        }
        return invokeI.booleanValue;
    }

    public hd8 k3(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048704, this, hd8Var)) == null) {
            if (hd8Var == null) {
                return null;
            }
            ThreadData Q = hd8Var.Q();
            Q.setIs_good(this.p);
            Q.setIs_top(this.q);
            long j = this.r;
            if (j > 0) {
                Q.setLast_time_int(j);
            }
            D0(Q);
            return hd8Var;
        }
        return (hd8) invokeL.objValue;
    }

    public boolean n3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048714, this, str)) == null) {
            this.j = !this.j;
            this.d = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (S2(6)) {
                return true;
            }
            this.j = !this.j;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void t3(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048737, this, hd8Var) != null) || hd8Var == null) {
            return;
        }
        hd8Var.U0(this.G.b0());
        hd8 hd8Var2 = this.G;
        if (!hd8Var2.Z && hd8Var.Z && hd8Var2.i() != null) {
            hd8Var.I0(this.G.i());
        }
        this.G = hd8Var;
        P2(hd8Var.z().a());
    }

    public void u0(a05 a05Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048738, this, a05Var) == null) {
            if (a05Var == null) {
                P2(1);
                return;
            }
            if (this.t < a05Var.a()) {
                this.t = a05Var.a();
            }
            if (this.u > a05Var.a()) {
                this.u = a05Var.a();
            }
            this.v = a05Var.h();
        }
    }

    public boolean u2(boolean z) {
        InterceptResult invokeZ;
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048740, this, z)) == null) {
            if (this.b == null || (hd8Var = this.G) == null || ((!z && hd8Var.z().c() == 0) || this.G.H() == null || this.G.H().size() < 1)) {
                return false;
            }
            return S2(2);
        }
        return invokeZ.booleanValue;
    }

    public final void w0(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048744, this, hd8Var) == null) && hd8Var != null && hd8Var.A() != null && hd8Var.A().getAdvertAppInfo() != null && hd8Var.A().t1() && hd8Var.A().getAdvertAppInfo().c != 1001) {
            this.N0 = hd8Var.A();
        }
    }

    public void D2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            I2(i);
            ArrayList<PostData> H = this.G.H();
            boolean z = false;
            this.c0 = false;
            if (i == 1) {
                boolean z2 = false;
                while (H.size() + 30 > vb5.a()) {
                    H.remove(0);
                    z2 = true;
                }
                if (z2) {
                    this.G.z().m(1);
                    h hVar = this.P;
                    if (hVar != null) {
                        hVar.b(this.G);
                    }
                }
                this.b0 = System.currentTimeMillis();
                this.c0 = true;
            } else if (i == 2) {
                while (H.size() + 30 > vb5.a()) {
                    H.remove(H.size() - 1);
                    z = true;
                }
                if (z) {
                    this.G.z().l(1);
                }
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData U(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, str)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var != null && hd8Var.Q() != null && this.G.l() != null) {
                WriteData writeData = new WriteData();
                if (this.G.Q().isMutiForumThread()) {
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setForumId(this.G.l().getId());
                    writeData.setForumName(this.G.l().getName());
                }
                writeData.setFromForumId(this.f);
                writeData.sourceFrom = String.valueOf(this.D0);
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

    public MarkData m1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048709, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(postData.O());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(j2()));
            markData.setId(this.b);
            markData.setFloor(postData.F());
            markData.setForumId(this.e);
            boolean z = true;
            if (postData instanceof ed8) {
                markData.setApp(true);
            } else if (postData instanceof v59) {
                v59 v59Var = (v59) postData;
                markData.setApp((v59Var.getAdvertAppInfo() == null || !v59Var.getAdvertAppInfo().g()) ? false : false);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
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
            sb.append(this.L);
            sb.append(this.P0);
            sb.append(this.Q0);
            sb.append(this.S0);
            sb.append(this.R0);
            String str = this.T;
            if (str != null) {
                sb.append(str);
            }
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public final int G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = 0;
            if (s1().H() == null) {
                return 0;
            }
            ArrayList<PostData> H = s1().H();
            for (int size = H.size() - 1; size >= 0; size--) {
                PostData postData = H.get(size);
                if (postData instanceof v59) {
                    if (postData.getType() != AdvertAppInfo.x) {
                        return i;
                    }
                } else {
                    i++;
                }
            }
            return H.size();
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
            markData.setPostId(this.G.v());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(j2()));
            markData.setId(this.b);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public void G2(hd8 hd8Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        hd8 hd8Var2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048596, this, new Object[]{hd8Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i4 = i2;
                hd8Var2 = null;
            } else {
                hd8Var2 = hd8Var;
                i4 = i2;
            }
            this.s0 = i4;
            this.isLoading = false;
            if (hd8Var2 != null) {
                B0(hd8Var2);
            }
            w0(hd8Var2);
            v59 v59Var = this.N0;
            if (v59Var != null && v59Var.t1()) {
                TiebaStatic.log(w39.e("a005", "common_fill", true, 1));
            }
            H2(hd8Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void H2(hd8 hd8Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{hd8Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z5 = true;
            boolean z6 = !z;
            this.j0 = z3;
            c69 c69Var = this.X;
            if (c69Var != null && !z3) {
                c69Var.b(z2, z6, i2, str, i3, j, j2);
                this.X = null;
            }
            hd8 hd8Var2 = this.G;
            if (hd8Var2 != null) {
                hd8Var2.c0 = z3;
                hd8Var2.d0 = i;
            }
            if (z6 && !z3 && !TextUtils.isEmpty(R0()) && cw8.l().b() != null) {
                cw8.l().b().g(R0(), O2(C1()), true);
            }
            if (hd8Var != null && (this.s != 1 || i != 5 || hd8Var.H() == null || hd8Var.H().size() >= 1)) {
                this.k = this.l;
                if (i != 8) {
                    this.n = this.m;
                    this.m = hd8Var.g;
                }
                List<PbSortType> list = hd8Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.Y.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    hd8Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.Y.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    hd8Var.f.add(builder2.build(false));
                    int i6 = this.n;
                    this.m = i6;
                    hd8Var.g = i6;
                }
                this.E = false;
                if (hd8Var.z() != null && (this.m != 2 || i != 8)) {
                    u0(hd8Var.z());
                }
                int i7 = this.v;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.v = i7;
                ArrayList<PostData> H = this.G.H();
                switch (i) {
                    case 1:
                        this.G.M0(hd8Var.z(), 1);
                        s3(hd8Var, H);
                        q3(hd8Var);
                        i4 = 0;
                        break;
                    case 2:
                        if (hd8Var.H() != null) {
                            i4 = hd8Var.H().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(H, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(hd8Var.H(), ListUtils.getCount(hd8Var.H()) - 1);
                            if (postData != null && postData2 != null && postData.O().equals(postData2.O())) {
                                hd8Var.H().remove(postData2);
                                i4--;
                            }
                            if (b2()) {
                                y1 = H.get(1).O();
                            }
                            H.addAll(0, hd8Var.H());
                        } else {
                            i4 = 0;
                        }
                        q3(hd8Var);
                        this.G.M0(hd8Var.z(), 2);
                        break;
                    case 3:
                        if (this.m == 1 && hd8Var.z() != null) {
                            hd8Var.z().k(hd8Var.z().h());
                        }
                        t3(hd8Var);
                        i4 = 0;
                        break;
                    case 4:
                        t3(hd8Var);
                        i4 = 0;
                        break;
                    case 5:
                        t3(hd8Var);
                        i4 = 0;
                        break;
                    case 6:
                        t3(hd8Var);
                        i4 = 0;
                        break;
                    case 7:
                        t3(hd8Var);
                        i4 = 0;
                        break;
                    case 8:
                        if (Y1(hd8Var)) {
                            return;
                        }
                        if (hd8Var != null && !ListUtils.isEmpty(hd8Var.H()) && this.G != null && (!this.j || L2(hd8Var).equals(hd8Var.H().get(0).r().getUserId()))) {
                            if (this.G.z().b() == 0) {
                                this.G.z().l(1);
                            }
                            Q2();
                            this.F0 = hd8Var.H().get(0);
                            if (!j2() && !this.G.l0()) {
                                if (this.H0 - this.I0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.G0 = postData3;
                                    postData3.D = false;
                                    postData3.Z0(53);
                                    this.G.H().add(0, this.G0);
                                }
                                this.G.H().add(0, this.F0);
                                i5 = 0;
                            } else {
                                if (this.G.H().size() - this.H0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.G0 = postData4;
                                    postData4.D = true;
                                    postData4.Z0(53);
                                    this.G.H().add(this.G0);
                                }
                                this.G.H().add(this.F0);
                                i5 = this.G.H().size() - 1;
                            }
                            if (!StringHelper.isTaday(b55.m().o("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.F0.T = this.G.L();
                                b55.m().A("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        } else {
                            i5 = 0;
                        }
                        q3(hd8Var);
                        i4 = i5;
                        break;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                hd8 hd8Var3 = this.G;
                if (hd8Var3 != null && hd8Var3.Q() != null) {
                    PraiseData praise = this.G.Q().getPraise();
                    if (this.x1 != null && !praise.isPriaseDataValid()) {
                        this.G.Q().setPraise(this.x1);
                    } else {
                        PraiseData praise2 = this.G.Q().getPraise();
                        this.x1 = praise2;
                        praise2.setPostId(this.G.Q().getFirstPostId());
                    }
                    if (hd8Var.z() != null && hd8Var.z().a() == 1 && hd8Var.Q() != null && hd8Var.Q().getActDatas() != null && hd8Var.Q().getActDatas().size() > 0) {
                        this.G.Q().setActDatas(hd8Var.Q().getActDatas());
                    }
                    this.G.Q().setReply_num(hd8Var.Q().getReply_num());
                    this.G.Q().setAnchorLevel(hd8Var.Q().getAnchorLevel());
                    this.G.Q().setCopyThreadRemindType(hd8Var.Q().getCopyThreadRemindType());
                    if (this.I == 33) {
                        this.G.Q().getAuthor().setHadConcerned(hd8Var.Q().getAuthor().hadConcerned());
                    }
                    if (hd8Var != null && hd8Var.Q() != null) {
                        this.G.Q().updateIsNotitle(hd8Var.Q().getIsNoTitle());
                    }
                }
                hd8 hd8Var4 = this.G;
                if (hd8Var4 != null && hd8Var4.X() != null && hd8Var.X() != null) {
                    this.G.X().setBimg_end_time(hd8Var.X().getBimg_end_time());
                    this.G.X().setBimg_url(hd8Var.X().getBimg_url());
                    this.G.X().setDynamicUrl(hd8Var.X().getDynamicUrl());
                }
                if (hd8Var.z() != null && hd8Var.z().a() == 1 && hd8Var.a0() != null) {
                    this.G.T0(hd8Var.a0());
                }
                if (this.j0) {
                    if (this.G.Q() != null && this.G.Q().getAuthor() != null && this.G.H() != null && ListUtils.getItem(this.G.H(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.G.H(), 0);
                        MetaData author = this.G.Q().getAuthor();
                        if (postData5.r() != null && postData5.r().getGodUserData() != null) {
                            int i8 = this.U;
                            if (i8 != -1) {
                                author.setFansNum(i8);
                                postData5.r().setFansNum(this.U);
                            }
                            if (this.V != -1) {
                                GodUserData godUserData = author.getGodUserData();
                                if (this.V == 1) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                godUserData.setIsLike(z4);
                                GodUserData godUserData2 = postData5.r().getGodUserData();
                                if (this.V != 1) {
                                    z5 = false;
                                }
                                godUserData2.setIsLike(z5);
                                author.getGodUserData().setIsFromNetWork(false);
                                postData5.r().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    hd8 hd8Var5 = this.G;
                    hd8Var5.e = -1;
                    hd8Var5.d = -1;
                }
                h hVar = this.P;
                if (hVar != null) {
                    hVar.c(true, getErrorCode(), i, i4, this.G, this.mErrorString, 1);
                }
            } else if (this.P != null) {
                this.l = this.k;
                if (i2 != 350006) {
                    this.m = this.n;
                }
                this.P.c(false, i2, i, 0, null, str, 1);
            }
            hd8 hd8Var6 = this.G;
            if (hd8Var6 != null && hd8Var6.Q() != null && this.G.l() != null && !this.G.l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = this.Y.getPageContext();
                historyMessage.threadId = s1().Q().getId();
                if (this.J0 && s1().Q().originalThreadData != null) {
                    historyMessage.threadName = s1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = s1().Q().getTitle();
                }
                if (this.J0 && !m2()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = s1().l().getName();
                }
                historyMessage.isHostOnly = V0();
                historyMessage.isSquence = K1();
                historyMessage.threadType = s1().Q().getThreadType();
                historyMessage.isShareThread = this.J0;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public final void I2(int i) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048602, this, i) == null) && i != 8) {
            this.E0 = "";
            if (this.F0 != null) {
                if (i == 1 && (hd8Var = this.G) != null && hd8Var.l0()) {
                    if (this.G0 != null) {
                        s1().H().remove(this.G0);
                    }
                } else if (i == 1 && !this.l && !ListUtils.isEmpty(s1().H())) {
                    s1().H().remove(this.F0);
                    if (this.G0 != null) {
                        s1().H().remove(this.G0);
                    }
                    s1().H().add(0, this.F0);
                } else {
                    s1().H().remove(this.F0);
                    if (this.G0 != null) {
                        s1().H().remove(this.G0);
                    }
                }
            }
            this.G0 = null;
        }
    }

    public void J2(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, hd8Var) != null) || hd8Var == null) {
            return;
        }
        String L2 = L2(hd8Var);
        for (int i = 0; i < hd8Var.H().size(); i++) {
            PostData postData = hd8Var.H().get(i);
            for (int i2 = 0; i2 < postData.d0().size(); i2++) {
                postData.d0().get(i2).m1(this.Y.getPageContext(), L2.equals(postData.d0().get(i2).r().getUserId()));
            }
        }
        ae8 V = hd8Var.V();
        if (V != null && !ListUtils.isEmpty(V.a)) {
            for (PostData postData2 : V.a) {
                for (int i3 = 0; i3 < postData2.d0().size(); i3++) {
                    postData2.d0().get(i3).m1(this.Y.getPageContext(), L2.equals(postData2.d0().get(i3).r().getUserId()));
                }
            }
        }
    }

    public void K2(hd8 hd8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048608, this, hd8Var, i) != null) || hd8Var == null) {
            return;
        }
        String L2 = L2(hd8Var);
        ae8 V = hd8Var.V();
        if (V != null && !ListUtils.isEmpty(V.a)) {
            List<PostData> list = V.a;
            for (PostData postData : list.subList(i, list.size())) {
                for (int i2 = 0; i2 < postData.d0().size(); i2++) {
                    postData.d0().get(i2).m1(this.Y.getPageContext(), L2.equals(postData.d0().get(i2).r().getUserId()));
                }
            }
        }
    }

    public final void N2(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            int i4 = 0;
            if (this.N0 == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            pbPageRequestMessage.setIsReqAd(i2);
            pbPageRequestMessage.setLastids(oc5.l);
            if (this.j || this.A) {
                this.W = false;
            }
            try {
                if (this.b != null && this.b.length() != 0) {
                    pbPageRequestMessage.set_kz(dh.g(this.b, 0L));
                    pbPageRequestMessage.setFloorSortType(1);
                    pbPageRequestMessage.setFloor_rn(this.a);
                    pbPageRequestMessage.set_rn(15);
                    pbPageRequestMessage.set_with_floor(1);
                    pbPageRequestMessage.set_scr_w(Integer.valueOf(ej.l(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_h(Integer.valueOf(ej.j(TbadkCoreApplication.getInst().getApp())));
                    pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                    if (TbImageHelper.getInstance().isShowBigImage()) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    pbPageRequestMessage.set_q_type(Integer.valueOf(i3));
                    pbPageRequestMessage.setSchemeUrl(this.Z0);
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
                        pbPageRequestMessage.setOpStat(dh.e(this.S, 0));
                        pbPageRequestMessage.setOpMessageID(this.D);
                    }
                    pbPageRequestMessage.set_thread_type(Integer.valueOf(this.I));
                    t0(pbPageRequestMessage, i);
                    this.C0 = this.j;
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.A));
                    pbPageRequestMessage.setCacheKey(P0());
                    pbPageRequestMessage.setObjParam1(String.valueOf(this.D0));
                    pbPageRequestMessage.setIsSubPostDataReverse(this.h0);
                    if (this.r0) {
                        i4 = 1;
                    }
                    pbPageRequestMessage.setFromSmartFrs(i4);
                    q0(pbPageRequestMessage);
                    pbPageRequestMessage.setNeedRepostRecommendForum(this.i);
                    r0(pbPageRequestMessage);
                    v0(pbPageRequestMessage);
                    pbPageRequestMessage.setOriUgcNid(this.P0);
                    pbPageRequestMessage.setOriUgcTid(this.Q0);
                    pbPageRequestMessage.setOriUgcType(this.R0);
                    pbPageRequestMessage.setOriUgcVid(this.S0);
                    if (!StringUtils.isNull(this.c1)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.c1));
                    }
                    p0(pbPageRequestMessage);
                    pbPageRequestMessage.setImmersionVideoCommentSource(this.d1);
                    pbPageRequestMessage.setTag(this.unique_id);
                    pbPageRequestMessage.setReqFoldComment(this.l1);
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
            this.D0 = bundle.getInt("key_start_from", 0);
            this.b = bundle.getString("thread_id");
            this.d = bundle.getString("post_id");
            this.e = bundle.getString("forum_id");
            this.f = bundle.getString("from_forum_id");
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
            this.r1 = bundle.getBoolean(PbActivityConfig.KEY_SCHEME_START, false);
            this.m1 = bundle.getBoolean("is_jump_from_video_tab", false);
            this.n1 = bundle.getBoolean("is_jump_from_video_middle", false);
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
            this.r0 = bundle.getBoolean("from_smart_frs", false);
            this.M = bundle.getBoolean("from_hottopic", false);
            this.J0 = bundle.getBoolean("key_is_share_thread", false);
            this.P0 = bundle.getString("key_ori_ugc_nid");
            this.Q0 = bundle.getString("key_ori_ugc_tid");
            this.R0 = bundle.getInt("key_ori_ugc_type", 0);
            this.a1 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.S0 = bundle.getString("key_ori_ugc_vid");
            if (bundle.getInt("request_code", -1) == 18003) {
                z = true;
            }
            this.W = z;
            this.V0 = bundle.getString("key_rec_weight");
            this.W0 = bundle.getString("key_rec_source");
            this.X0 = bundle.getString("key_rec_ab_tag");
            this.Y0 = bundle.getString("key_rec_extra");
            this.f1 = bundle.getBoolean("key_is_tieba_plus");
            this.g1 = bundle.getString("key_tieba_plus_order_id");
            this.h1 = bundle.getString("key_tieba_plus_token");
            this.i1 = bundle.getString("key_tieba_extra_param");
            this.j1 = bundle.getBoolean("key_tieba_plus_cant_delete");
            this.k1 = bundle.getBoolean(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT);
            Parcelable parcelable = bundle.getParcelable(IntentConfig.KEY_URI);
            if (parcelable instanceof Uri) {
                h3((Uri) parcelable);
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

    public void y2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048752, this) == null) && "personalize_page".equals(this.mStType) && this.G != null && this.g0 != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new StatisticItem("c10754").param("fid", this.G.m()).param("tid", this.b).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.g0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.g0 = 0L;
        }
    }

    public void Q2() {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048628, this) == null) && (hd8Var = this.G) != null && !ListUtils.isEmpty(hd8Var.H())) {
            if (this.G0 != null) {
                this.G.H().remove(this.G0);
                this.G0 = null;
            }
            if (this.F0 != null) {
                this.G.H().remove(this.F0);
                this.F0 = null;
            }
        }
    }

    public MetaData U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            hd8 hd8Var = this.G;
            if (hd8Var == null || hd8Var.Q() == null || this.G.Q().getAuthor() == null) {
                return null;
            }
            return this.G.Q().getAuthor();
        }
        return (MetaData) invokeV.objValue;
    }

    public final boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (this.G.A() == null || this.G.A().getAdvertAppInfo() == null || this.G.A().getAdvertAppInfo().c == 1001) {
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
            SuggestEmotionModel suggestEmotionModel = this.A0;
            if (suggestEmotionModel != null) {
                suggestEmotionModel.cancelLoadData();
            }
            GetSugMatchWordsModel getSugMatchWordsModel = this.B0;
            if (getSugMatchWordsModel != null) {
                getSugMatchWordsModel.cancelLoadData();
            }
            ox8.f().a("PB");
            x2();
        }
    }

    public boolean i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            if (PBCacheBlockSwitch.getIsOn() || !this.O0 || av6.b() == null || !av6.b().equals(this.b) || av6.a() == null) {
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
            if (this.X == null) {
                c69 c69Var = new c69("pbStat");
                this.X = c69Var;
                c69Var.f();
            }
            boolean S2 = S2(3);
            if (this.Q != null) {
                this.Q = null;
                this.S = null;
                this.R = null;
            }
            return S2;
        }
        return invokeV.booleanValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            if (r1() == 3 || s1() == null || s1().Q() == null || !s1().Q().isMutiForumThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void T2(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048640, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    public final void W1(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048650, this, intent) != null) || intent == null) {
            return;
        }
        this.b = intent.getStringExtra("thread_id");
        this.c = intent.getBooleanExtra("key_is_privacy", false);
        this.P0 = intent.getStringExtra("key_ori_ugc_nid");
        this.Q0 = intent.getStringExtra("key_ori_ugc_tid");
        this.R0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.S0 = intent.getStringExtra("key_ori_ugc_vid");
        this.a1 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.m1 = intent.getBooleanExtra("is_jump_from_video_tab", false);
        this.n1 = intent.getBooleanExtra("is_jump_from_video_middle", false);
        this.c1 = intent.getStringExtra("key_official_bar_message_id");
        this.r1 = intent.getBooleanExtra(PbActivityConfig.KEY_SCHEME_START, false);
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        h3(uri);
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        this.Z0 = str;
        this.e1 = false;
        boolean z = true;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.e1 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.s1);
        } else if (StringUtils.isNull(this.b)) {
            this.e1 = true;
            this.u0.b(intent, this.s1);
            if (uri != null) {
                if (StringUtils.isNull(this.b)) {
                    this.b = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.P0)) {
                    this.P0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.Q0)) {
                    this.Q0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.R0 == 0) {
                    this.R0 = dh.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.S0)) {
                    this.S0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        String str2 = "0";
        if (dj.isEmpty(this.b)) {
            this.b = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.D0 = intExtra;
        if (intExtra == 0) {
            this.D0 = this.u0.a;
        }
        this.d = intent.getStringExtra("post_id");
        this.e = intent.getStringExtra("forum_id");
        this.f = intent.getStringExtra("from_forum_id");
        intent.getStringExtra("god_reply_id");
        this.i = intent.getBooleanExtra("KEY_NEED_REPOST_RECOMMEND_FORUM", false);
        this.j = intent.getBooleanExtra("host_only", false);
        this.l = intent.getBooleanExtra("squence", true);
        int intExtra2 = intent.getIntExtra("sort_type", -1);
        this.m = intExtra2;
        if (intExtra2 < 0) {
            intExtra2 = b55.m().n("key_pb_current_sort_type", 2);
        }
        this.m = intExtra2;
        if (b2()) {
            this.m = 0;
        }
        if (this.m != 2) {
            str2 = this.d;
        }
        this.d = str2;
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
        this.r0 = intent.getBooleanExtra("from_smart_frs", false);
        this.M = intent.getBooleanExtra("from_hottopic", false);
        this.x0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.J0 = intent.getBooleanExtra("key_is_share_thread", false);
        this.g = intent.getStringExtra("high_light_post_id");
        this.h = intent.getStringExtra(PbCommentFloatActivityConfig.KEY_HIGH_LIGHT_3S_POST_ID);
        this.O0 = intent.getBooleanExtra("key_need_preload", false);
        if (intent.getIntExtra("request_code", -1) != 18003) {
            z = false;
        }
        this.W = z;
        this.V0 = intent.getStringExtra("key_rec_weight");
        this.W0 = intent.getStringExtra("key_rec_source");
        this.X0 = intent.getStringExtra("key_rec_ab_tag");
        this.Y0 = intent.getStringExtra("key_rec_extra");
        this.f1 = intent.getBooleanExtra("key_is_tieba_plus", false);
        this.g1 = intent.getStringExtra("key_tieba_plus_order_id");
        this.h1 = intent.getStringExtra("key_tieba_plus_token");
        this.i1 = intent.getStringExtra("key_tieba_extra_param");
        this.j1 = intent.getBooleanExtra("key_tieba_plus_cant_delete", false);
        this.k1 = intent.getBooleanExtra(IntentConfig.KEY_FORCE_INTERCEPT_STIME_STAT, false);
        if (this.D0 == 17) {
            this.mTopicId = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_ID);
            this.mTopicSubjectName = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_SUBJECT_NAME);
        }
    }

    public boolean o3(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048717, this, z, str)) == null) {
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
            if (S2(6)) {
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
        if (interceptable == null || interceptable.invokeLL(1048720, this, forumData, cVar) == null) {
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
            this.A0.Q(str3, str, cVar);
        }
    }

    public void s3(hd8 hd8Var, ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048733, this, hd8Var, arrayList) == null) && arrayList != null && hd8Var.H() != null) {
            PostData postData = (PostData) ListUtils.getItem(hd8Var.H(), 0);
            if (postData != null) {
                String j1 = j1(arrayList);
                String O = postData.O();
                if (StringUtils.isNull(O) || "0".equals(O) || (j1 != null && j1.equals(O))) {
                    hd8Var.H().remove(postData);
                }
            }
            this.G.b0 = arrayList.size();
            arrayList.addAll(hd8Var.H());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:93:0x0209, code lost:
        if ((r11.u - 1) <= 0) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x021a, code lost:
        if (r11.t >= r11.v) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x021c, code lost:
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t0(PbPageRequestMessage pbPageRequestMessage, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048734, this, pbPageRequestMessage, i) != null) || pbPageRequestMessage == null) {
            return;
        }
        ArrayList<PostData> H = this.G.H();
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
                    if (H != null && H.size() > 0) {
                        int size = H.size();
                        int i3 = 1;
                        while (true) {
                            int i4 = size - i3;
                            if (i4 >= 0) {
                                PostData postData = H.get(i4);
                                if (postData != null) {
                                    String O = postData.O();
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
                        pbPageRequestMessage.set_pid(dh.g(this.d, 0L));
                        if (this.m == 2) {
                            pbPageRequestMessage.set_pid(0L);
                        }
                    } else if (this.m == 1) {
                        pbPageRequestMessage.set_last(1);
                    }
                }
                a3(pbPageRequestMessage);
                String j1 = j1(H);
                if (StringUtils.isNotNull(j1)) {
                    s0(pbPageRequestMessage, dh.g(j1, 0L));
                    return;
                }
                return;
            case 2:
                if (H != null && H.size() > 0 && H.get(0) != null) {
                    this.d = H.get(0).O();
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
                    pbPageRequestMessage.set_pid(dh.g(this.d, 0L));
                    if (this.m == 2) {
                        pbPageRequestMessage.set_pid(0L);
                    }
                    s0(pbPageRequestMessage, dh.g(this.d, 0L));
                }
                a3(pbPageRequestMessage);
                return;
            case 3:
                if (!this.A && !this.j) {
                    pbPageRequestMessage.set_banner(1);
                } else {
                    pbPageRequestMessage.set_banner(0);
                }
                if (b2()) {
                    this.D0 = 12;
                    int i7 = this.m;
                    if (i7 == 0) {
                        pbPageRequestMessage.set_pid(dh.g(this.g, 0L));
                    } else if (i7 == 1 && !UbsABTestHelper.isPbReplyOptimize() && (i2 = this.v) > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(i2));
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (!b2()) {
                    if (j2()) {
                        pbPageRequestMessage.set_pn(1);
                    } else {
                        pbPageRequestMessage.set_last(1);
                        int i8 = this.v;
                        if (i8 > 0) {
                            pbPageRequestMessage.set_pn(Integer.valueOf(i8));
                        }
                    }
                }
                if (this.A) {
                    pbPageRequestMessage.set_st_type("store_thread");
                }
                e3(pbPageRequestMessage);
                s0(pbPageRequestMessage, -1L);
                return;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(dh.g(this.d, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                a3(pbPageRequestMessage);
                return;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.s));
                pbPageRequestMessage.set_banner(0);
                a3(pbPageRequestMessage);
                return;
            case 6:
                if (b2()) {
                    pbPageRequestMessage.setObjLocate("reply_jump_first");
                }
                pbPageRequestMessage.set_mark(1);
                if (this.m == 1 && this.C0 && !this.j) {
                    pbPageRequestMessage.set_pid(0L);
                } else {
                    pbPageRequestMessage.set_pid(dh.g(this.d, 0L));
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
                a3(pbPageRequestMessage);
                s0(pbPageRequestMessage, -1L);
                return;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.i0);
                a3(pbPageRequestMessage);
                return;
            case 8:
                pbPageRequestMessage.set_pid(dh.g(this.E0, 0L));
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
}
