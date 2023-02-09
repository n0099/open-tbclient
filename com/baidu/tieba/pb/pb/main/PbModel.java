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
import com.baidu.tieba.bb5;
import com.baidu.tieba.bs6;
import com.baidu.tieba.cu8;
import com.baidu.tieba.dh;
import com.baidu.tieba.dj;
import com.baidu.tieba.e35;
import com.baidu.tieba.ed8;
import com.baidu.tieba.ej;
import com.baidu.tieba.fd8;
import com.baidu.tieba.gh;
import com.baidu.tieba.ia5;
import com.baidu.tieba.ic8;
import com.baidu.tieba.j29;
import com.baidu.tieba.ja8;
import com.baidu.tieba.k09;
import com.baidu.tieba.kh;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n80;
import com.baidu.tieba.oa8;
import com.baidu.tieba.oc8;
import com.baidu.tieba.od8;
import com.baidu.tieba.p35;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.q29;
import com.baidu.tieba.qs8;
import com.baidu.tieba.s98;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.t98;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.ty4;
import com.baidu.tieba.v98;
import com.baidu.tieba.wb;
import com.baidu.tieba.x9;
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
    public v98 G;
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
    public j29 N0;
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
    public q29 X;
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
    public t98 t0;
    public CustomMessageListener t1;
    public int u;
    public final ed8 u0;
    public wb u1;
    public int v;
    public final oc8 v0;
    public CustomMessageListener v1;
    public boolean w;
    public final fd8 w0;
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

        void b(v98 v98Var);

        void c(boolean z, int i, int i2, int i3, v98 v98Var, String str, int i4);
    }

    public final int H2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i)) == null) {
            if (i != 1) {
                return i != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    public int n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes5.dex */
    public class g implements n80.b {
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
                v98 pbData;
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
                    gVar.b.G2(gVar.a);
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

        @Override // com.baidu.tieba.n80.b
        public void a(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                kh.e(new a(this, responsedMessage));
            }
        }

        @Override // com.baidu.tieba.n80.b
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
                if (this.a.l1() != null && this.a.l1().l() != null && this.a.l1().l().getSignData() != null && signData.forumId.equals(this.a.l1().m())) {
                    this.a.l1().l().getSignData().is_signed = signData.is_signed;
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
                if (responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId() && responsedMessage.getOrginalMessage().getTag() != n80.d) {
                    return;
                }
                if (responsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.Y.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    this.a.y2((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    this.a.x2((pbPageHttpResponseMessage) responsedMessage);
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
                    objArr[4] = "seq_id";
                    objArr[5] = Long.valueOf(j);
                    e35.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                }
                if (!this.a.Z || !this.a.a0) {
                    if (!this.a.Z) {
                        this.a.Z = true;
                    } else {
                        this.a.a0 = true;
                    }
                    if (this.a.P != null) {
                        this.a.P.a(this.a.n1(), z, responsedMessage, this.a.c0, System.currentTimeMillis() - this.a.b0);
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
                v98 v98Var = this.a.G;
                if (v98Var != null && v98Var.h() != null && this.a.G.h().b() != null && this.a.G.h().b().equals(valueOf)) {
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
                v98 v98Var = this.a.G;
                if (v98Var != null && v98Var.h() != null && this.a.G.h().b() != null && this.a.G.h().b().equals(valueOf)) {
                    this.a.G.h().j(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ v98 a;
        public final /* synthetic */ PbModel b;

        public f(PbModel pbModel, v98 v98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, v98Var};
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
            this.a = v98Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.A2(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
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
        int a2 = ia5.a() / 30;
        y1 = null;
        UPGRADE_TO_PHOTO_LIVE = 1;
    }

    public t98 A0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.t0;
        }
        return (t98) invokeV.objValue;
    }

    public int A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.p1;
        }
        return invokeV.intValue;
    }

    public int B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public Rect C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Rect rect = this.K0;
            this.K0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public BaijiahaoData D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null && v98Var.Q() != null) {
                return this.G.Q().getBaijiahaoData();
            }
            return null;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return c2();
        }
        return invokeV.booleanValue;
    }

    public j29 E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.N0;
        }
        return (j29) invokeV.objValue;
    }

    public int E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.L0;
        }
        return invokeV.intValue;
    }

    public CheckRealNameModel F0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.y0;
        }
        return (CheckRealNameModel) invokeV.objValue;
    }

    public String F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public final void F2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            registerListener(this.u1);
            registerListener(this.t1);
            registerListener(this.w1);
            registerListener(this.v1);
        }
    }

    public oc8 G0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.v0;
        }
        return (oc8) invokeV.objValue;
    }

    public String G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.P0;
        }
        return (String) invokeV.objValue;
    }

    public PostData H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.F0;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.e0;
        }
        return (String) invokeV.objValue;
    }

    public PostData I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.G0;
        }
        return (PostData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public String J0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.f0;
        }
        return (String) invokeV.objValue;
    }

    public String J1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.mTopicSubjectName;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.i1;
        }
        return (String) invokeV.objValue;
    }

    public String K0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null && v98Var.Q() != null) {
                return this.G.Q().worksInfoData;
            }
            return null;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.g1;
        }
        return (String) invokeV.objValue;
    }

    public String L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.h1;
        }
        return (String) invokeV.objValue;
    }

    public String M0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean M1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null && !ListUtils.isEmpty(v98Var.H())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean O0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.f1;
        }
        return invokeV.booleanValue;
    }

    public int P0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.b1;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.j1;
        }
        return invokeV.booleanValue;
    }

    public boolean Q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public void Q1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048633, this) == null) {
            ic8.b().d(I0(), this.A);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return p2();
        }
        return invokeV.booleanValue;
    }

    public boolean R0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public boolean S0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return "hot_topic".equals(this.mStType);
        }
        return invokeV.booleanValue;
    }

    public boolean S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.k1;
        }
        return invokeV.booleanValue;
    }

    public boolean T0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean T1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.j0;
        }
        return invokeV.booleanValue;
    }

    public boolean U0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (12 != this.Y.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) && 12 != this.D0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public int V0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public boolean V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.r1;
        }
        return invokeV.booleanValue;
    }

    public boolean W0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var == null) {
                return false;
            }
            return v98Var.r();
        }
        return invokeV.booleanValue;
    }

    public boolean W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public boolean X0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.n1;
        }
        return invokeV.booleanValue;
    }

    public boolean Y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public boolean Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.m1;
        }
        return invokeV.booleanValue;
    }

    public int Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public boolean Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.a1;
        }
        return invokeV.booleanValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null && v98Var.l() != null && this.G.Q() != null) {
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
            v98 v98Var = this.G;
            if (v98Var == null) {
                return false;
            }
            return v98Var.x0();
        }
        return invokeV.booleanValue;
    }

    public boolean a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.W;
        }
        return invokeV.booleanValue;
    }

    public String b1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return y1;
        }
        return (String) invokeV.objValue;
    }

    public final boolean c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            int i = this.m;
            if (i != 0 && i != 2) {
                return false;
            }
            return true;
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

    public int d1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.I0;
        }
        return invokeV.intValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.o1;
        }
        return invokeV.booleanValue;
    }

    public int e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048678, this)) == null) {
            return this.H0;
        }
        return invokeV.intValue;
    }

    public boolean e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            if (l1() != null && l1().z0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean f3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            if (c2() && this.G.z().b() == 0) {
                j2(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null && v98Var.r()) {
                return this.G.v();
            }
            return null;
        }
        return (String) invokeV.objValue;
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

    public fd8 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048691, this)) == null) {
            return this.w0;
        }
        return (fd8) invokeV.objValue;
    }

    public void h2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048692, this) == null) {
            y1 = null;
        }
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048698, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            return this.J0;
        }
        return invokeV.booleanValue;
    }

    public ty4 j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048701, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var == null) {
                return null;
            }
            return v98Var.z();
        }
        return (ty4) invokeV.objValue;
    }

    public int k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            return this.D0;
        }
        return invokeV.intValue;
    }

    public v98 l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.G;
        }
        return (v98) invokeV.objValue;
    }

    public v98 m1() {
        InterceptResult invokeV;
        j29 j29Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048714, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var == null) {
                return v98Var;
            }
            if (!N1() && (j29Var = this.N0) != null) {
                this.G.N0(j29Var);
            }
            return this.G;
        }
        return (v98) invokeV.objValue;
    }

    public boolean m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            if (this.b != null && this.d != null) {
                cancelMessage();
                if (this.A) {
                    return L2(4);
                }
                return L2(6);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            return this.x0;
        }
        return (String) invokeV.objValue;
    }

    public String p1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.M0;
        }
        return (String) invokeV.objValue;
    }

    public boolean p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            String str = this.d;
            if (str != null && !str.equals("0") && this.d.length() != 0) {
                return m2();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048726, this) == null) {
            this.N0 = null;
        }
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.X0;
        }
        return (String) invokeV.objValue;
    }

    public final void q2() {
        q29 q29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048728, this) == null) && (q29Var = this.X) != null) {
            q29Var.a();
            this.X = null;
        }
    }

    public void r0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048729, this) == null) {
            this.h = "";
        }
    }

    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            return this.Y0;
        }
        return (String) invokeV.objValue;
    }

    public void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048732, this) == null) {
            this.g = null;
        }
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            return this.W0;
        }
        return (String) invokeV.objValue;
    }

    public void s2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048734, this) == null) && "personalize_page".equals(this.mStType)) {
            this.g0 = System.currentTimeMillis() / 1000;
        }
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.V0;
        }
        return (String) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return !TextUtils.isEmpty(this.h);
        }
        return invokeV.booleanValue;
    }

    public int u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null) {
                return v98Var.N();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return !TextUtils.isEmpty(this.g);
        }
        return invokeV.booleanValue;
    }

    public int v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    public boolean w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return c2();
        }
        return invokeV.booleanValue;
    }

    public String x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048748, this)) == null) {
            return this.T0;
        }
        return (String) invokeV.objValue;
    }

    public AddExperiencedModel y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048750, this)) == null) {
            return this.z0;
        }
        return (AddExperiencedModel) invokeV.objValue;
    }

    public String y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048751, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public String z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048754, this)) == null) {
            return this.q1;
        }
        return (String) invokeV.objValue;
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
        v98 v98Var = new v98();
        this.G = v98Var;
        v98Var.F0(0);
        this.O = baseFragmentActivity.getPageContext().getPageActivity();
        this.Y = baseFragmentActivity;
        this.u0 = new ed8();
        this.v0 = new oc8(this, this.Y);
        this.w0 = new fd8(this, this.Y);
        this.y0 = new CheckRealNameModel(this.Y.getPageContext());
        this.A0 = new SuggestEmotionModel();
        this.z0 = new AddExperiencedModel(this.Y.getPageContext());
        this.s1 = new a(this);
    }

    public void K2(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, bundle) == null) {
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
        P1(intent);
        U2(hVar);
        F2();
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
        O1(bundle);
        U2(hVar);
        F2();
    }

    public void N2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048623, this, i, i2) == null) {
            this.H0 = i;
            this.I0 = i2;
        }
    }

    public final void l0(PbPageRequestMessage pbPageRequestMessage, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLJ(1048708, this, pbPageRequestMessage, j) == null) && pbPageRequestMessage != null && !UbsABTestHelper.isPbReplyOptimize()) {
            pbPageRequestMessage.setLastPid(j);
        }
    }

    public void I2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.s = i;
            this.t = i;
            this.u = i;
        }
    }

    public void O2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, str) == null) {
            this.f0 = str;
        }
    }

    public void P2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048630, this, i) == null) {
            this.d1 = i;
        }
    }

    public void Q2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048634, this, i) == null) {
            this.b1 = i;
        }
    }

    public void R2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i) == null) {
            this.p = i;
        }
    }

    public void S2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048641, this, i) == null) {
            this.q = i;
        }
    }

    public void U2(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048647, this, hVar) == null) {
            this.P = hVar;
        }
    }

    public void V2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048650, this, i) == null) {
            this.D0 = i;
        }
    }

    public void W2(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048653, this, str) == null) {
            this.M0 = str;
        }
    }

    public void Y2(int i) {
        v98 v98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048659, this, i) == null) && (v98Var = this.G) != null) {
            v98Var.Q0(i);
        }
    }

    public void Z2(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048662, this, z) == null) {
            this.l1 = z;
        }
    }

    public void b3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048669, this, i) == null) {
            this.a = i;
        }
    }

    public void e3(boolean z) {
        v98 v98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048680, this, z) == null) && (v98Var = this.G) != null) {
            v98Var.J0(z);
        }
    }

    public final void j0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048700, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (UtilHelper.isUgcThreadType(this.R0)) {
            pbPageRequestMessage.setForumId(String.valueOf(0));
        } else {
            pbPageRequestMessage.setForumId(this.e);
        }
    }

    public boolean j2(boolean z) {
        InterceptResult invokeZ;
        v98 v98Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048702, this, z)) == null) {
            if (this.b == null || (v98Var = this.G) == null) {
                return false;
            }
            if (!z && v98Var.z().b() == 0) {
                return false;
            }
            return L2(1);
        }
        return invokeZ.booleanValue;
    }

    public final void j3(@NonNull v98 v98Var) {
        v98 v98Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048703, this, v98Var) == null) && (v98Var2 = this.G) != null) {
            v98Var2.e().clear();
            this.G.e().addAll(v98Var.e());
        }
    }

    public final void k0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048704, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        if (this.D0 == 7) {
            pbPageRequestMessage.setFrom_push(1);
        } else {
            pbPageRequestMessage.setFrom_push(0);
        }
    }

    public void l2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048710, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.b = str;
        this.d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public final void o0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048720, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = this.D0;
        if (i != 7 && i != 5 && !this.e1) {
            pbPageRequestMessage.setSourceType(2);
        } else {
            pbPageRequestMessage.setSourceType(1);
        }
    }

    public void o2(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048722, this, bVar) != null) || bVar == null) {
            return;
        }
        if (this.B0 == null) {
            this.B0 = new GetSugMatchWordsModel(this.Y.getPageContext());
        }
        this.B0.I(bVar);
    }

    public void u0(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048738, this, v98Var) != null) || v98Var == null) {
            return;
        }
        if (this.L || this.J || this.K) {
            v98Var = d3(v98Var);
        }
        C2(v98Var);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void A2(v98 v98Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{v98Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z5 = true;
            boolean z6 = !z;
            this.j0 = z3;
            q29 q29Var = this.X;
            if (q29Var != null && !z3) {
                q29Var.b(z2, z6, i2, str, i3, j, j2);
                this.X = null;
            }
            v98 v98Var2 = this.G;
            if (v98Var2 != null) {
                v98Var2.c0 = z3;
                v98Var2.d0 = i;
            }
            if (z6 && !z3 && !TextUtils.isEmpty(K0()) && qs8.l().b() != null) {
                qs8.l().b().g(K0(), H2(v1()), true);
            }
            if (v98Var != null && (this.s != 1 || i != 5 || v98Var.H() == null || v98Var.H().size() >= 1)) {
                this.k = this.l;
                if (i != 8) {
                    this.n = this.m;
                    this.m = v98Var.g;
                }
                List<PbSortType> list = v98Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.Y.getResources().getString(R.string.default_sort);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    v98Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.Y.getResources().getString(R.string.view_reverse);
                    builder2.sort_type = 1;
                    v98Var.f.add(builder2.build(false));
                    int i6 = this.n;
                    this.m = i6;
                    v98Var.g = i6;
                }
                this.E = false;
                if (v98Var.z() != null && (this.m != 2 || i != 8)) {
                    n0(v98Var.z());
                }
                int i7 = this.v;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.v = i7;
                ArrayList<PostData> H = this.G.H();
                switch (i) {
                    case 1:
                        this.G.M0(v98Var.z(), 1);
                        l3(v98Var, H);
                        j3(v98Var);
                        i4 = 0;
                        break;
                    case 2:
                        if (v98Var.H() != null) {
                            i4 = v98Var.H().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(H, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(v98Var.H(), ListUtils.getCount(v98Var.H()) - 1);
                            if (postData != null && postData2 != null && postData.O().equals(postData2.O())) {
                                v98Var.H().remove(postData2);
                                i4--;
                            }
                            if (U1()) {
                                y1 = H.get(1).O();
                            }
                            H.addAll(0, v98Var.H());
                        } else {
                            i4 = 0;
                        }
                        j3(v98Var);
                        this.G.M0(v98Var.z(), 2);
                        break;
                    case 3:
                        if (this.m == 1 && v98Var.z() != null) {
                            v98Var.z().k(v98Var.z().h());
                        }
                        m3(v98Var);
                        i4 = 0;
                        break;
                    case 4:
                        m3(v98Var);
                        i4 = 0;
                        break;
                    case 5:
                        m3(v98Var);
                        i4 = 0;
                        break;
                    case 6:
                        m3(v98Var);
                        i4 = 0;
                        break;
                    case 7:
                        m3(v98Var);
                        i4 = 0;
                        break;
                    case 8:
                        if (R1(v98Var)) {
                            return;
                        }
                        if (v98Var != null && !ListUtils.isEmpty(v98Var.H()) && this.G != null && (!this.j || E2(v98Var).equals(v98Var.H().get(0).r().getUserId()))) {
                            if (this.G.z().b() == 0) {
                                this.G.z().l(1);
                            }
                            J2();
                            this.F0 = v98Var.H().get(0);
                            if (!c2() && !this.G.l0()) {
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
                            if (!StringHelper.isTaday(p35.m().o("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.F0.T = this.G.L();
                                p35.m().A("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        } else {
                            i5 = 0;
                        }
                        j3(v98Var);
                        i4 = i5;
                        break;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                v98 v98Var3 = this.G;
                if (v98Var3 != null && v98Var3.Q() != null) {
                    PraiseData praise = this.G.Q().getPraise();
                    if (this.x1 != null && !praise.isPriaseDataValid()) {
                        this.G.Q().setPraise(this.x1);
                    } else {
                        PraiseData praise2 = this.G.Q().getPraise();
                        this.x1 = praise2;
                        praise2.setPostId(this.G.Q().getFirstPostId());
                    }
                    if (v98Var.z() != null && v98Var.z().a() == 1 && v98Var.Q() != null && v98Var.Q().getActDatas() != null && v98Var.Q().getActDatas().size() > 0) {
                        this.G.Q().setActDatas(v98Var.Q().getActDatas());
                    }
                    this.G.Q().setReply_num(v98Var.Q().getReply_num());
                    this.G.Q().setAnchorLevel(v98Var.Q().getAnchorLevel());
                    this.G.Q().setCopyThreadRemindType(v98Var.Q().getCopyThreadRemindType());
                    if (this.I == 33) {
                        this.G.Q().getAuthor().setHadConcerned(v98Var.Q().getAuthor().hadConcerned());
                    }
                    if (v98Var != null && v98Var.Q() != null) {
                        this.G.Q().updateIsNotitle(v98Var.Q().getIsNoTitle());
                    }
                }
                v98 v98Var4 = this.G;
                if (v98Var4 != null && v98Var4.X() != null && v98Var.X() != null) {
                    this.G.X().setBimg_end_time(v98Var.X().getBimg_end_time());
                    this.G.X().setBimg_url(v98Var.X().getBimg_url());
                    this.G.X().setDynamicUrl(v98Var.X().getDynamicUrl());
                }
                if (v98Var.z() != null && v98Var.z().a() == 1 && v98Var.a0() != null) {
                    this.G.T0(v98Var.a0());
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
                    v98 v98Var5 = this.G;
                    v98Var5.e = -1;
                    v98Var5.d = -1;
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
            v98 v98Var6 = this.G;
            if (v98Var6 != null && v98Var6.Q() != null && this.G.l() != null && !this.G.l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = this.Y.getPageContext();
                historyMessage.threadId = l1().Q().getId();
                if (this.J0 && l1().Q().originalThreadData != null) {
                    historyMessage.threadName = l1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = l1().Q().getTitle();
                }
                if (this.J0 && !f2()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = l1().l().getName();
                }
                historyMessage.isHostOnly = O0();
                historyMessage.isSquence = D1();
                historyMessage.threadType = l1().Q().getThreadType();
                historyMessage.isShareThread = this.J0;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public MarkData B0(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            v98 v98Var = this.G;
            if (v98Var == null) {
                return null;
            }
            ArrayList<PostData> H = v98Var.H();
            if (ListUtils.isEmpty(H)) {
                return null;
            }
            if (H.size() > 0 && i >= H.size()) {
                i = H.size() - 1;
            }
            return f1(H.get(i));
        }
        return (MarkData) invokeI.objValue;
    }

    public String E2(v98 v98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, v98Var)) == null) {
            String str = null;
            if (v98Var == null) {
                return null;
            }
            if (v98Var.Q() != null && v98Var.Q().getAuthor() != null) {
                str = v98Var.Q().getAuthor().getUserId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final String c1(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, arrayList)) == null) {
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

    public boolean c3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048672, this, i)) == null) {
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
            return L2(5);
        }
        return invokeI.booleanValue;
    }

    public v98 d3(v98 v98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048676, this, v98Var)) == null) {
            if (v98Var == null) {
                return null;
            }
            ThreadData Q = v98Var.Q();
            Q.setIs_good(this.p);
            Q.setIs_top(this.q);
            long j = this.r;
            if (j > 0) {
                Q.setLast_time_int(j);
            }
            w0(Q);
            return v98Var;
        }
        return (v98) invokeL.objValue;
    }

    public boolean g3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048686, this, str)) == null) {
            this.j = !this.j;
            this.d = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (L2(6)) {
                return true;
            }
            this.j = !this.j;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m3(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048716, this, v98Var) != null) || v98Var == null) {
            return;
        }
        v98Var.U0(this.G.b0());
        v98 v98Var2 = this.G;
        if (!v98Var2.Z && v98Var.Z && v98Var2.i() != null) {
            v98Var.I0(this.G.i());
        }
        this.G = v98Var;
        I2(v98Var.z().a());
    }

    public void n0(ty4 ty4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048717, this, ty4Var) == null) {
            if (ty4Var == null) {
                I2(1);
                return;
            }
            if (this.t < ty4Var.a()) {
                this.t = ty4Var.a();
            }
            if (this.u > ty4Var.a()) {
                this.u = ty4Var.a();
            }
            this.v = ty4Var.h();
        }
    }

    public boolean n2(boolean z) {
        InterceptResult invokeZ;
        v98 v98Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048719, this, z)) == null) {
            if (this.b == null || (v98Var = this.G) == null || ((!z && v98Var.z().c() == 0) || this.G.H() == null || this.G.H().size() < 1)) {
                return false;
            }
            return L2(2);
        }
        return invokeZ.booleanValue;
    }

    public final void p0(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048723, this, v98Var) == null) && v98Var != null && v98Var.A() != null && v98Var.A().getAdvertAppInfo() != null && v98Var.A().t1() && v98Var.A().getAdvertAppInfo().c != 1001) {
            this.N0 = v98Var.A();
        }
    }

    public void w0(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048744, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = P();
            threadData.tiebaPlusOrderId = L();
            threadData.tiebaPlusToken = M();
            threadData.tiebaPlusExtraParam = M();
            threadData.tiebaplusCantDelete = Q();
            threadData.setDispatchedForumIdWithString(G());
        }
    }

    public void x2(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048749, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.t0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            z2(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void y2(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048752, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.t0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            z2(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public final void B2(int i) {
        v98 v98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048581, this, i) == null) && i != 8) {
            this.E0 = "";
            if (this.F0 != null) {
                if (i == 1 && (v98Var = this.G) != null && v98Var.l0()) {
                    if (this.G0 != null) {
                        l1().H().remove(this.G0);
                    }
                } else if (i == 1 && !this.l && !ListUtils.isEmpty(l1().H())) {
                    l1().H().remove(this.F0);
                    if (this.G0 != null) {
                        l1().H().remove(this.G0);
                    }
                    l1().H().add(0, this.F0);
                } else {
                    l1().H().remove(this.F0);
                    if (this.G0 != null) {
                        l1().H().remove(this.G0);
                    }
                }
            }
            this.G0 = null;
        }
    }

    public void C2(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v98Var) != null) || v98Var == null) {
            return;
        }
        String E2 = E2(v98Var);
        for (int i = 0; i < v98Var.H().size(); i++) {
            PostData postData = v98Var.H().get(i);
            for (int i2 = 0; i2 < postData.d0().size(); i2++) {
                postData.d0().get(i2).m1(this.Y.getPageContext(), E2.equals(postData.d0().get(i2).r().getUserId()));
            }
        }
        oa8 V = v98Var.V();
        if (V != null && !ListUtils.isEmpty(V.a)) {
            for (PostData postData2 : V.a) {
                for (int i3 = 0; i3 < postData2.d0().size(); i3++) {
                    postData2.d0().get(i3).m1(this.Y.getPageContext(), E2.equals(postData2.d0().get(i3).r().getUserId()));
                }
            }
        }
    }

    public void D2(v98 v98Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048587, this, v98Var, i) != null) || v98Var == null) {
            return;
        }
        String E2 = E2(v98Var);
        oa8 V = v98Var.V();
        if (V != null && !ListUtils.isEmpty(V.a)) {
            List<PostData> list = V.a;
            for (PostData postData : list.subList(i, list.size())) {
                for (int i2 = 0; i2 < postData.d0().size(); i2++) {
                    postData.d0().get(i2).m1(this.Y.getPageContext(), E2.equals(postData.d0().get(i2).r().getUserId()));
                }
            }
        }
    }

    public final void G2(int i) {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
            pbPageRequestMessage.setUpdateType(i);
            int i4 = 0;
            if (this.N0 == null) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            pbPageRequestMessage.setIsReqAd(i2);
            pbPageRequestMessage.setLastids(bb5.l);
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
                    m0(pbPageRequestMessage, i);
                    this.C0 = this.j;
                    pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.A));
                    pbPageRequestMessage.setCacheKey(I0());
                    pbPageRequestMessage.setObjParam1(String.valueOf(this.D0));
                    pbPageRequestMessage.setIsSubPostDataReverse(this.h0);
                    if (this.r0) {
                        i4 = 1;
                    }
                    pbPageRequestMessage.setFromSmartFrs(i4);
                    j0(pbPageRequestMessage);
                    pbPageRequestMessage.setNeedRepostRecommendForum(this.i);
                    k0(pbPageRequestMessage);
                    o0(pbPageRequestMessage);
                    pbPageRequestMessage.setOriUgcNid(this.P0);
                    pbPageRequestMessage.setOriUgcTid(this.Q0);
                    pbPageRequestMessage.setOriUgcType(this.R0);
                    pbPageRequestMessage.setOriUgcVid(this.S0);
                    if (!StringUtils.isNull(this.c1)) {
                        pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.c1));
                    }
                    i0(pbPageRequestMessage);
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

    public final void O1(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048625, this, bundle) == null) {
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
                a3((Uri) parcelable);
            }
        }
    }

    public MarkData H0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(this.G.v());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(c2()));
            markData.setId(this.b);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public final int z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048753, this)) == null) {
            int i = 0;
            if (l1().H() == null) {
                return 0;
            }
            ArrayList<PostData> H = l1().H();
            for (int size = H.size() - 1; size >= 0; size--) {
                PostData postData = H.get(size);
                if (postData instanceof j29) {
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

    public final String I0() {
        InterceptResult invokeV;
        String i1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            String str = this.b;
            if (str != null && !str.equals("0")) {
                i1 = this.b;
            } else {
                i1 = i1();
            }
            if (this.j) {
                i1 = i1 + "_host";
            }
            int i = this.m;
            if (i == 1) {
                i1 = i1 + "_rev";
            } else if (i == 2) {
                i1 = i1 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return i1 + TbadkCoreApplication.getCurrentAccount();
            }
            return i1;
        }
        return (String) invokeV.objValue;
    }

    public final String i1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
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

    public void r2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048731, this) == null) && "personalize_page".equals(this.mStType) && this.G != null && this.g0 != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new StatisticItem("c10754").param("fid", this.G.m()).param("tid", this.b).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.g0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.g0 = 0L;
        }
    }

    public void J2() {
        v98 v98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && (v98Var = this.G) != null && !ListUtils.isEmpty(v98Var.H())) {
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

    public MetaData N0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            v98 v98Var = this.G;
            if (v98Var == null || v98Var.Q() == null || this.G.Q().getAuthor() == null) {
                return null;
            }
            return this.G.Q().getAuthor();
        }
        return (MetaData) invokeV.objValue;
    }

    public final boolean N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.G.A() == null || this.G.A().getAdvertAppInfo() == null || this.G.A().getAdvertAppInfo().c == 1001) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (PBCacheBlockSwitch.getIsOn() || !this.O0 || bs6.b() == null || !bs6.b().equals(this.b) || bs6.a() == null) {
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
            cu8.f().a("PB");
            q2();
        }
    }

    public boolean f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            if (k1() == 3 || l1() == null || l1().Q() == null || !l1().Q().isMutiForumThread()) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            if (this.b == null) {
                return false;
            }
            cancelLoadData();
            if (this.X == null) {
                q29 q29Var = new q29("pbStat");
                this.X = q29Var;
                q29Var.f();
            }
            boolean L2 = L2(3);
            if (this.Q != null) {
                this.Q = null;
                this.S = null;
                this.R = null;
            }
            return L2;
        }
        return invokeV.booleanValue;
    }

    public boolean L2(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048615, this, i)) == null) {
            this.H = i;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            w2(i);
            v98 f2 = od8.b().f();
            if (f2 != null && f2.Q() != null) {
                f2.Q().setCopyThreadRemindType(0);
                this.l = od8.b().i();
                this.j = od8.b().a();
                this.o = od8.b().c();
                this.F0 = od8.b().g();
                this.G0 = od8.b().h();
                this.H0 = od8.b().d();
                this.K0 = od8.b().k();
                this.L0 = od8.b().j();
                boolean z = this.j;
                this.C0 = z;
                if (z || this.A) {
                    this.W = false;
                }
                gh.a().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.d0) {
                M2(I0(), true, this.d, 3);
            }
            if (i == 3 && !this.d0) {
                if (this.A) {
                    M2(I0(), true, this.d, 3);
                } else {
                    M2(I0(), false, this.d, 3);
                }
            }
            this.d0 = false;
            n80.d(CmdConfigHttp.PB_PAGE_HTTP_CMD, new g(this, i));
            return true;
        }
        return invokeI.booleanValue;
    }

    public void k3(UserPendantData userPendantData) {
        v98 v98Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048707, this, userPendantData) == null) && userPendantData != null && (v98Var = this.G) != null && v98Var.H() != null && this.G.H().size() > 0) {
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

    public v98 v0(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048741, this, threadData)) == null) {
            v98 v98Var = new v98();
            v98Var.F0(3);
            if (threadData == null) {
                return null;
            }
            v98Var.R0(threadData);
            if (threadData.getForumData() != null) {
                v98Var.G0(threadData.getForumData());
                ForumData l = v98Var.l();
                l.setId(threadData.getForumData().b());
                l.setName(threadData.getForumData().d());
                l.setUser_level(threadData.getForumData().c());
                l.setImage_url(threadData.getForumData().a());
                l.setPost_num(threadData.getForumData().g);
                l.setMember_num(threadData.getForumData().h);
            } else {
                ForumData l2 = v98Var.l();
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
            postData.b1(TbRichTextView.a0(threadData.getFirstFloorList(), F1(), false));
            v98Var.H0(postData);
            v98Var.H().add(postData);
            v98Var.O0(new ja8(threadData, null));
            v98Var.m = true;
            v98Var.K0(1);
            return v98Var;
        }
        return (v98) invokeL.objValue;
    }

    public final void M2(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData N(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, str)) == null) {
            v98 v98Var = this.G;
            if (v98Var != null && v98Var.Q() != null && this.G.l() != null) {
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

    public MarkData f1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048681, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(postData.O());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(c2()));
            markData.setId(this.b);
            markData.setFloor(postData.F());
            markData.setForumId(this.e);
            boolean z = true;
            if (postData instanceof s98) {
                markData.setApp(true);
            } else if (postData instanceof j29) {
                j29 j29Var = (j29) postData;
                markData.setApp((j29Var.getAdvertAppInfo() == null || !j29Var.getAdvertAppInfo().h()) ? false : false);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void w2(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048746, this, i) == null) {
            B2(i);
            ArrayList<PostData> H = this.G.H();
            boolean z = false;
            this.c0 = false;
            if (i == 1) {
                boolean z2 = false;
                while (H.size() + 30 > ia5.a()) {
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
                while (H.size() + 30 > ia5.a()) {
                    H.remove(H.size() - 1);
                    z = true;
                }
                if (z) {
                    this.G.z().l(1);
                }
            }
        }
    }

    public final void P1(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048629, this, intent) != null) || intent == null) {
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
        a3(uri);
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
            intExtra2 = p35.m().n("key_pb_current_sort_type", 2);
        }
        this.m = intExtra2;
        if (U1()) {
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

    public final boolean R1(v98 v98Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048637, this, v98Var)) == null) {
            if (v98Var == null || ListUtils.isEmpty(v98Var.H()) || this.G.Q() == null || TextUtils.isEmpty(this.G.Q().getFirstPostId())) {
                return false;
            }
            return TextUtils.equals(this.G.Q().getFirstPostId(), v98Var.H().get(0).O());
        }
        return invokeL.booleanValue;
    }

    public final void T2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048644, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(K0()) || qs8.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(qs8.l().b().e(K0(), true) + 1);
        pbPageRequestMessage.setRefreshCount(qs8.l().b().d(K0(), true));
    }

    public final void X2(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048656, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(K0()) || qs8.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(qs8.l().b().d(K0(), true) + 1);
        pbPageRequestMessage.setLoadCount(qs8.l().b().e(K0(), true));
    }

    public void a3(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, uri) == null) {
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

    public boolean g2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048685, this, str)) == null) {
            if (l1() != null && l1().Q() != null && l1().Q().getAuthor() != null && !StringUtils.isNull(str)) {
                String userId = l1().Q().getAuthor().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i0(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048694, this, pbPageRequestMessage) != null) || pbPageRequestMessage == null) {
            return;
        }
        int i = -1;
        if (pbPageRequestMessage.getPn() != null) {
            if (pbPageRequestMessage.getR().intValue() == 1) {
                if (pbPageRequestMessage.getPn().intValue() != this.v) {
                    i = z0();
                }
            } else if (pbPageRequestMessage.getPn().intValue() != 1) {
                i = z0();
            }
        } else {
            i = 0;
        }
        pbPageRequestMessage.setAfterAdThreadCount(i);
    }

    public boolean i3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048697, this, i)) == null) {
            if (i == this.m) {
                return false;
            }
            if (i != 1) {
                p35.m().z("key_pb_current_sort_type", i);
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

    public void k2(v98 v98Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048706, this, v98Var) != null) || v98Var == null) {
            return;
        }
        this.b = v98Var.S();
        if (v98Var.Q() != null && v98Var.Q().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = v98Var.Q().getBaijiahaoData();
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

    public void t0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048735, this, str) == null) {
            if ((!this.j || g2(TbadkCoreApplication.getCurrentAccount())) && this.G.H() != null) {
                this.G.z().l(1);
                if (this.G.z().b() == 0) {
                    this.G.z().l(1);
                }
                this.E0 = str;
                L2(8);
            }
        }
    }

    public boolean h3(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048693, this, z, str)) == null) {
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
            if (L2(6)) {
                return true;
            }
            this.j = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public void i2(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048696, this, forumData, cVar) == null) {
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
            this.A0.J(str3, str, cVar);
        }
    }

    public void l3(v98 v98Var, ArrayList<PostData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048711, this, v98Var, arrayList) == null) && arrayList != null && v98Var.H() != null) {
            PostData postData = (PostData) ListUtils.getItem(v98Var.H(), 0);
            if (postData != null) {
                String c1 = c1(arrayList);
                String O = postData.O();
                if (StringUtils.isNull(O) || "0".equals(O) || (c1 != null && c1.equals(O))) {
                    v98Var.H().remove(postData);
                }
            }
            this.G.b0 = arrayList.size();
            arrayList.addAll(v98Var.H());
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
    public final void m0(PbPageRequestMessage pbPageRequestMessage, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048713, this, pbPageRequestMessage, i) != null) || pbPageRequestMessage == null) {
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
                T2(pbPageRequestMessage);
                String c1 = c1(H);
                if (StringUtils.isNotNull(c1)) {
                    l0(pbPageRequestMessage, dh.g(c1, 0L));
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
                    if (c2()) {
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
                    l0(pbPageRequestMessage, dh.g(this.d, 0L));
                }
                T2(pbPageRequestMessage);
                return;
            case 3:
                if (!this.A && !this.j) {
                    pbPageRequestMessage.set_banner(1);
                } else {
                    pbPageRequestMessage.set_banner(0);
                }
                if (U1()) {
                    this.D0 = 12;
                    int i7 = this.m;
                    if (i7 == 0) {
                        pbPageRequestMessage.set_pid(dh.g(this.g, 0L));
                    } else if (i7 == 1 && !UbsABTestHelper.isPbReplyOptimize() && (i2 = this.v) > 0) {
                        pbPageRequestMessage.set_pn(Integer.valueOf(i2));
                    }
                }
                pbPageRequestMessage.set_back(0);
                if (!U1()) {
                    if (c2()) {
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
                X2(pbPageRequestMessage);
                l0(pbPageRequestMessage, -1L);
                return;
            case 4:
                pbPageRequestMessage.set_st_type("store_thread");
                pbPageRequestMessage.set_mark(1);
                pbPageRequestMessage.set_pid(dh.g(this.d, 0L));
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_banner(0);
                T2(pbPageRequestMessage);
                return;
            case 5:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.set_pn(Integer.valueOf(this.s));
                pbPageRequestMessage.set_banner(0);
                T2(pbPageRequestMessage);
                return;
            case 6:
                if (U1()) {
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
                T2(pbPageRequestMessage);
                l0(pbPageRequestMessage, -1L);
                return;
            case 7:
                pbPageRequestMessage.set_back(0);
                pbPageRequestMessage.setIsJumpFloor(true);
                pbPageRequestMessage.setJumpFloorNum(this.i0);
                T2(pbPageRequestMessage);
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

    public void v2(v98 v98Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048743, this, v98Var, i, str) == null) {
            this.d0 = true;
            if (v98Var != null && v98Var.h == null) {
                m3(v98Var);
                u0(v98Var);
                if (v98Var.Q() != null) {
                    v98Var.Q().setCopyThreadRemindType(0);
                }
                h hVar = this.P;
                if (hVar != null && v98Var != null) {
                    hVar.c(true, 0, i, 0, v98Var, str, 0);
                }
            }
        }
    }

    public String x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048747, this)) == null) {
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

    public void z2(v98 v98Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        v98 v98Var2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048755, this, new Object[]{v98Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i4 = i2;
                v98Var2 = null;
            } else {
                v98Var2 = v98Var;
                i4 = i2;
            }
            this.s0 = i4;
            this.isLoading = false;
            if (v98Var2 != null) {
                u0(v98Var2);
            }
            p0(v98Var2);
            j29 j29Var = this.N0;
            if (j29Var != null && j29Var.t1()) {
                TiebaStatic.log(k09.e("a005", "common_fill", true, 1));
            }
            A2(v98Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }
}
