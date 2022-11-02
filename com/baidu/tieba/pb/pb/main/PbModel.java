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
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.an8;
import com.baidu.tieba.ax7;
import com.baidu.tieba.bx7;
import com.baidu.tieba.c55;
import com.baidu.tieba.c80;
import com.baidu.tieba.dh;
import com.baidu.tieba.dx7;
import com.baidu.tieba.gp8;
import com.baidu.tieba.hh8;
import com.baidu.tieba.ky4;
import com.baidu.tieba.m08;
import com.baidu.tieba.model.CheckRealNameModel;
import com.baidu.tieba.n08;
import com.baidu.tieba.pb;
import com.baidu.tieba.pb.PbPageRequestMessage;
import com.baidu.tieba.pb.pb.main.emotion.model.GetSugMatchWordsModel;
import com.baidu.tieba.pb.pb.main.emotion.model.SuggestEmotionModel;
import com.baidu.tieba.qz7;
import com.baidu.tieba.r9;
import com.baidu.tieba.rx7;
import com.baidu.tieba.share.AddExperiencedModel;
import com.baidu.tieba.st4;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.tbadkCore.data.WorksInfoData;
import com.baidu.tieba.u55;
import com.baidu.tieba.vf8;
import com.baidu.tieba.vi6;
import com.baidu.tieba.w08;
import com.baidu.tieba.wg;
import com.baidu.tieba.wi;
import com.baidu.tieba.wx7;
import com.baidu.tieba.wz7;
import com.baidu.tieba.xi;
import com.baidu.tieba.zg;
import com.baidu.tieba.zo8;
import com.baidu.tieba.zx4;
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
    public static String x1;
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
    public dx7 G;
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
    public zo8 M0;
    public String N;
    public boolean N0;
    public Context O;
    public String O0;
    public h P;
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
    public gp8 X;
    public String X0;
    public BaseFragmentActivity Y;
    public String Y0;
    public boolean Z;
    public boolean Z0;
    public int a;
    public boolean a0;
    public int a1;
    public String b;
    public long b0;
    public String b1;
    public boolean c;
    public boolean c0;
    public int c1;
    public String d;
    public boolean d0;
    public boolean d1;
    public String e;
    public String e0;
    public boolean e1;
    public String f;
    public String f0;
    public String f1;
    public String g;
    public long g0;
    public String g1;
    public String h;
    public boolean h0;
    public String h1;
    public boolean i;
    public int i0;
    public boolean i1;
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
    public int o1;
    public int p;
    public String p1;
    public int q;
    public boolean q0;
    public boolean q1;
    public long r;
    public int r0;
    public BdUniDispatchSchemeController.b r1;
    public int s;
    public bx7 s0;
    public CustomMessageListener s1;
    public String showReplyPanel;
    public int t;
    public final m08 t0;
    public pb t1;
    public int u;
    public final wz7 u0;
    public CustomMessageListener u1;
    public int v;
    public final n08 v0;
    public CustomMessageListener v1;
    public boolean w;
    public String w0;
    public PraiseData w1;
    public boolean x;
    public final CheckRealNameModel x0;
    public boolean y;
    public final AddExperiencedModel y0;
    public boolean z;
    public SuggestEmotionModel z0;

    /* loaded from: classes5.dex */
    public interface h {
        void a(int i, boolean z, ResponsedMessage<?> responsedMessage, boolean z2, long j);

        void b(dx7 dx7Var);

        void c(boolean z, int i, int i2, int i3, dx7 dx7Var, String str, int i4);
    }

    public int U1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return 1001;
        }
        return invokeV.intValue;
    }

    public final int k3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048701, this, i)) == null) {
            if (i != 1) {
                return i != 3 ? -1 : 1;
            }
            return 2;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes5.dex */
    public class g implements c80.b {
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
                dx7 pbData;
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
                    } else if (this.b.b.t1 != null) {
                        this.b.b.t1.onMessage(this.a);
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

            /* JADX WARN: Code restructure failed: missing block: B:122:0x0428, code lost:
                if ((r12.a.b.u - 1) <= 0) goto L119;
             */
            /* JADX WARN: Removed duplicated region for block: B:139:0x0477 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:147:0x04a6 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:157:0x04f5 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:182:0x05f1 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:185:0x0607 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:205:0x049c A[SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:80:0x02d6 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:83:0x0301 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            /* JADX WARN: Removed duplicated region for block: B:91:0x0335 A[Catch: Exception -> 0x0697, TryCatch #0 {Exception -> 0x0697, blocks: (B:13:0x004a, B:15:0x0052, B:18:0x0060, B:22:0x00d3, B:24:0x00ef, B:25:0x00f2, B:27:0x010b, B:28:0x010e, B:30:0x0116, B:31:0x011f, B:33:0x0129, B:34:0x0134, B:36:0x013e, B:37:0x0153, B:39:0x015d, B:40:0x0160, B:42:0x016a, B:43:0x019a, B:47:0x01be, B:49:0x01d7, B:50:0x01e9, B:51:0x0203, B:53:0x020d, B:54:0x0210, B:56:0x021d, B:58:0x0227, B:60:0x0231, B:64:0x0251, B:66:0x025e, B:68:0x0265, B:67:0x0262, B:61:0x0235, B:63:0x024e, B:69:0x026e, B:70:0x028c, B:71:0x02b0, B:73:0x02ba, B:76:0x02c5, B:78:0x02cc, B:80:0x02d6, B:81:0x02f4, B:83:0x0301, B:85:0x030b, B:86:0x030f, B:88:0x031c, B:89:0x032b, B:91:0x0335, B:92:0x0338, B:77:0x02c9, B:94:0x0343, B:96:0x0349, B:98:0x034f, B:99:0x0360, B:101:0x0370, B:103:0x037a, B:105:0x0385, B:106:0x0396, B:108:0x03a8, B:109:0x03b8, B:111:0x03c2, B:113:0x03d0, B:115:0x03e9, B:116:0x03ec, B:117:0x03f5, B:119:0x0405, B:121:0x040f, B:128:0x0450, B:131:0x045c, B:158:0x04f8, B:134:0x0468, B:136:0x046e, B:137:0x0473, B:139:0x0477, B:141:0x047f, B:142:0x0482, B:145:0x049c, B:147:0x04a6, B:148:0x04b6, B:150:0x04c0, B:152:0x04ce, B:154:0x04e7, B:155:0x04eb, B:157:0x04f5, B:124:0x042c, B:159:0x04ff, B:163:0x054f, B:165:0x0560, B:167:0x0573, B:169:0x0589, B:171:0x0590, B:173:0x059a, B:175:0x05a5, B:178:0x05b0, B:180:0x05b7, B:182:0x05f1, B:183:0x0600, B:185:0x0607, B:187:0x0611, B:190:0x0624, B:191:0x062d, B:194:0x0639, B:195:0x0641, B:179:0x05b4, B:170:0x058d, B:166:0x0568, B:196:0x0690), top: B:204:0x004a }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                int i;
                int i2;
                int i3;
                boolean z;
                int size;
                int i4;
                int i5;
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    PbPageRequestMessage pbPageRequestMessage = new PbPageRequestMessage();
                    pbPageRequestMessage.setUpdateType(this.a.a);
                    int i6 = 0;
                    if (this.a.b.M0 == null) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    pbPageRequestMessage.setIsReqAd(i);
                    pbPageRequestMessage.setLastids(u55.l);
                    if (this.a.b.j || this.a.b.A) {
                        this.a.b.W = false;
                    }
                    try {
                        if (this.a.b.b != null && this.a.b.b.length() != 0) {
                            pbPageRequestMessage.set_kz(wg.g(this.a.b.b, 0L));
                            pbPageRequestMessage.setFloorSortType(1);
                            pbPageRequestMessage.setFloor_rn(this.a.b.a);
                            pbPageRequestMessage.set_rn(15);
                            pbPageRequestMessage.set_with_floor(1);
                            pbPageRequestMessage.set_scr_w(Integer.valueOf(xi.l(TbadkCoreApplication.getInst().getApp())));
                            pbPageRequestMessage.set_scr_h(Integer.valueOf(xi.j(TbadkCoreApplication.getInst().getApp())));
                            pbPageRequestMessage.set_scr_dip(TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density);
                            if (TbImageHelper.getInstance().isShowBigImage()) {
                                i2 = 2;
                            } else {
                                i2 = 1;
                            }
                            pbPageRequestMessage.set_q_type(Integer.valueOf(i2));
                            pbPageRequestMessage.setSchemeUrl(this.a.b.Y0);
                            if (!this.a.b.l) {
                                pbPageRequestMessage.set_r(1);
                            }
                            pbPageRequestMessage.set_r(Integer.valueOf(this.a.b.m));
                            if (this.a.b.j) {
                                pbPageRequestMessage.set_lz(1);
                            }
                            if (this.a.b.mStType != null) {
                                pbPageRequestMessage.set_st_type(this.a.b.mStType);
                            }
                            if (this.a.b.N != null) {
                                pbPageRequestMessage.setLocate(this.a.b.N);
                            }
                            if (this.a.b.E) {
                                pbPageRequestMessage.set_message_id(Integer.valueOf((int) this.a.b.D));
                                pbPageRequestMessage.set_message_click("1");
                            }
                            if (this.a.b.W) {
                                pbPageRequestMessage.set_banner(1);
                            }
                            if (this.a.b.Q != null) {
                                pbPageRequestMessage.setOpType(this.a.b.Q);
                                pbPageRequestMessage.setOpUrl(this.a.b.R);
                                pbPageRequestMessage.setOpStat(wg.e(this.a.b.S, 0));
                                pbPageRequestMessage.setOpMessageID(this.a.b.D);
                            }
                            pbPageRequestMessage.set_thread_type(Integer.valueOf(this.a.b.I));
                            ArrayList<PostData> H = this.a.b.G.H();
                            switch (this.a.a) {
                                case 1:
                                    pbPageRequestMessage.set_back(0);
                                    pbPageRequestMessage.set_banner(0);
                                    if (!this.a.b.A) {
                                        if (this.a.b.m == 1) {
                                            pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.u - 1));
                                            break;
                                        } else {
                                            pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.t + 1));
                                            if (this.a.b.t >= this.a.b.v) {
                                                z = true;
                                            }
                                        }
                                        if (!this.a.b.A || z || this.a.b.B) {
                                            if (H != null && H.size() > 0) {
                                                size = H.size();
                                                i4 = 1;
                                                while (true) {
                                                    i5 = size - i4;
                                                    if (i5 >= 0) {
                                                        PostData postData = H.get(i5);
                                                        if (postData != null) {
                                                            this.a.b.d = postData.M();
                                                            if (StringUtils.isNull(this.a.b.d)) {
                                                            }
                                                        }
                                                        i4++;
                                                    }
                                                }
                                                if (this.a.b.m == 2) {
                                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.t + 1));
                                                }
                                            }
                                            if (this.a.b.d == null && this.a.b.d.length() > 0) {
                                                pbPageRequestMessage.set_pid(wg.g(this.a.b.d, 0L));
                                                if (this.a.b.m == 2) {
                                                    pbPageRequestMessage.set_pid(0L);
                                                }
                                            } else if (this.a.b.m == 1) {
                                                pbPageRequestMessage.set_last(1);
                                            }
                                        }
                                        this.a.b.w3(pbPageRequestMessage);
                                        break;
                                    }
                                    z = false;
                                    if (!this.a.b.A) {
                                    }
                                    if (H != null) {
                                        size = H.size();
                                        i4 = 1;
                                        while (true) {
                                            i5 = size - i4;
                                            if (i5 >= 0) {
                                            }
                                            i4++;
                                        }
                                        if (this.a.b.m == 2) {
                                        }
                                    }
                                    if (this.a.b.d == null) {
                                    }
                                    if (this.a.b.m == 1) {
                                    }
                                    this.a.b.w3(pbPageRequestMessage);
                                case 2:
                                    if (H != null && H.size() > 0 && H.get(0) != null) {
                                        this.a.b.d = H.get(0).M();
                                    }
                                    pbPageRequestMessage.set_back(1);
                                    pbPageRequestMessage.set_banner(0);
                                    if (this.a.b.A) {
                                        if (this.a.b.G2()) {
                                            if (this.a.b.u - 1 > 0) {
                                                pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.u - 1));
                                            }
                                        } else if (this.a.b.t < this.a.b.v) {
                                            pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.t + 1));
                                        }
                                    }
                                    if (this.a.b.d != null && this.a.b.d.length() > 0) {
                                        pbPageRequestMessage.set_pid(wg.g(this.a.b.d, 0L));
                                        if (this.a.b.m == 2) {
                                            pbPageRequestMessage.set_pid(0L);
                                        }
                                    }
                                    this.a.b.w3(pbPageRequestMessage);
                                    break;
                                case 3:
                                    if (!this.a.b.A && !this.a.b.j) {
                                        pbPageRequestMessage.set_banner(1);
                                        if (this.a.b.y2()) {
                                            this.a.b.C0 = 12;
                                            pbPageRequestMessage.set_pid(wg.g(this.a.b.g, 0L));
                                            pbPageRequestMessage.setObjLocate("reply_jump_first");
                                            pbPageRequestMessage.set_r(0);
                                        }
                                        pbPageRequestMessage.set_back(0);
                                        if (!this.a.b.y2()) {
                                            if (this.a.b.G2()) {
                                                pbPageRequestMessage.set_pn(1);
                                            } else {
                                                pbPageRequestMessage.set_last(1);
                                                if (this.a.b.v > 0) {
                                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.v));
                                                }
                                            }
                                        }
                                        if (this.a.b.A) {
                                            pbPageRequestMessage.set_st_type("store_thread");
                                        }
                                        this.a.b.A3(pbPageRequestMessage);
                                        break;
                                    }
                                    pbPageRequestMessage.set_banner(0);
                                    if (this.a.b.y2()) {
                                    }
                                    pbPageRequestMessage.set_back(0);
                                    if (!this.a.b.y2()) {
                                    }
                                    if (this.a.b.A) {
                                    }
                                    this.a.b.A3(pbPageRequestMessage);
                                    break;
                                case 4:
                                    pbPageRequestMessage.set_st_type("store_thread");
                                    pbPageRequestMessage.set_mark(1);
                                    pbPageRequestMessage.set_pid(wg.g(this.a.b.d, 0L));
                                    pbPageRequestMessage.set_back(0);
                                    pbPageRequestMessage.set_banner(0);
                                    this.a.b.w3(pbPageRequestMessage);
                                    break;
                                case 5:
                                    pbPageRequestMessage.set_back(0);
                                    pbPageRequestMessage.set_pn(Integer.valueOf(this.a.b.s));
                                    pbPageRequestMessage.set_banner(0);
                                    this.a.b.w3(pbPageRequestMessage);
                                    break;
                                case 6:
                                    if (this.a.b.y2()) {
                                        pbPageRequestMessage.setObjLocate("reply_jump_first");
                                    }
                                    pbPageRequestMessage.set_mark(1);
                                    if (this.a.b.m == 1 && this.a.b.B0 && !this.a.b.j) {
                                        pbPageRequestMessage.set_pid(0L);
                                    } else {
                                        pbPageRequestMessage.set_pid(wg.g(this.a.b.d, 0L));
                                        if (this.a.b.m == 2) {
                                            pbPageRequestMessage.set_pid(0L);
                                        }
                                    }
                                    pbPageRequestMessage.set_back(0);
                                    if (this.a.b.j) {
                                        pbPageRequestMessage.set_banner(0);
                                    } else {
                                        pbPageRequestMessage.set_banner(1);
                                    }
                                    this.a.b.w3(pbPageRequestMessage);
                                    break;
                                case 7:
                                    pbPageRequestMessage.set_back(0);
                                    pbPageRequestMessage.setIsJumpFloor(true);
                                    pbPageRequestMessage.setJumpFloorNum(this.a.b.i0);
                                    this.a.b.w3(pbPageRequestMessage);
                                    break;
                                case 8:
                                    pbPageRequestMessage.set_pid(wg.g(this.a.b.D0, 0L));
                                    if (this.a.b.m == 1) {
                                        pbPageRequestMessage.set_arround(1);
                                        pbPageRequestMessage.set_back(1);
                                        pbPageRequestMessage.set_pn(0);
                                        pbPageRequestMessage.set_rn(2);
                                        break;
                                    }
                                    break;
                            }
                            this.a.b.B0 = this.a.b.j;
                            pbPageRequestMessage.setIsFromMark(Boolean.valueOf(this.a.b.A));
                            pbPageRequestMessage.setCacheKey(this.a.b.p1());
                            pbPageRequestMessage.setObjParam1(String.valueOf(this.a.b.C0));
                            pbPageRequestMessage.setIsSubPostDataReverse(this.a.b.h0);
                            if (this.a.b.q0) {
                                i3 = 1;
                            } else {
                                i3 = 0;
                            }
                            pbPageRequestMessage.setFromSmartFrs(i3);
                            if (UtilHelper.isUgcThreadType(this.a.b.Q0)) {
                                pbPageRequestMessage.setForumId(String.valueOf(0));
                            } else {
                                pbPageRequestMessage.setForumId(this.a.b.e);
                            }
                            pbPageRequestMessage.setNeedRepostRecommendForum(this.a.b.i);
                            if (this.a.b.C0 == 7) {
                                pbPageRequestMessage.setFrom_push(1);
                            } else {
                                pbPageRequestMessage.setFrom_push(0);
                            }
                            if (this.a.b.C0 != 7 && this.a.b.C0 != 5 && !this.a.b.d1) {
                                pbPageRequestMessage.setSourceType(2);
                                pbPageRequestMessage.setOriUgcNid(this.a.b.O0);
                                pbPageRequestMessage.setOriUgcTid(this.a.b.P0);
                                pbPageRequestMessage.setOriUgcType(this.a.b.Q0);
                                pbPageRequestMessage.setOriUgcVid(this.a.b.R0);
                                if (!StringUtils.isNull(this.a.b.b1)) {
                                    pbPageRequestMessage.setOfficialBarMsgId(Long.parseLong(this.a.b.b1));
                                }
                                if (pbPageRequestMessage.getPn() != null) {
                                    if (pbPageRequestMessage.getR().intValue() != 1) {
                                        if (pbPageRequestMessage.getPn().intValue() != 1) {
                                            i6 = this.a.b.g1();
                                        }
                                    } else {
                                        i6 = pbPageRequestMessage.getPn().intValue() == this.a.b.v ? -1 : this.a.b.g1();
                                    }
                                }
                                pbPageRequestMessage.setAfterAdThreadCount(i6);
                                pbPageRequestMessage.setImmersionVideoCommentSource(this.a.b.c1);
                                pbPageRequestMessage.setTag(this.a.b.unique_id);
                                pbPageRequestMessage.setReqFoldComment(this.a.b.k1);
                                pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a.b.b);
                                pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                                int i7 = PbPageRequestMessage.requestTimes;
                                PbPageRequestMessage.requestTimes = i7 + 1;
                                pbPageRequestMessage.setRequestTimes(i7);
                                this.a.b.sendMessage(pbPageRequestMessage);
                                return;
                            }
                            pbPageRequestMessage.setSourceType(1);
                            pbPageRequestMessage.setOriUgcNid(this.a.b.O0);
                            pbPageRequestMessage.setOriUgcTid(this.a.b.P0);
                            pbPageRequestMessage.setOriUgcType(this.a.b.Q0);
                            pbPageRequestMessage.setOriUgcVid(this.a.b.R0);
                            if (!StringUtils.isNull(this.a.b.b1)) {
                            }
                            if (pbPageRequestMessage.getPn() != null) {
                            }
                            pbPageRequestMessage.setAfterAdThreadCount(i6);
                            pbPageRequestMessage.setImmersionVideoCommentSource(this.a.b.c1);
                            pbPageRequestMessage.setTag(this.a.b.unique_id);
                            pbPageRequestMessage.setReqFoldComment(this.a.b.k1);
                            pbPageRequestMessage.getHttpMessage().addHeader("thread_id", this.a.b.b);
                            pbPageRequestMessage.getHttpMessage().addHeader("client_type", "2");
                            int i72 = PbPageRequestMessage.requestTimes;
                            PbPageRequestMessage.requestTimes = i72 + 1;
                            pbPageRequestMessage.setRequestTimes(i72);
                            this.a.b.sendMessage(pbPageRequestMessage);
                            return;
                        }
                        this.a.b.isLoading = false;
                    } catch (Exception e) {
                        BdLog.e(e.getMessage());
                    }
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

        @Override // com.baidu.tieba.c80.b
        public void a(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                dh.b(new a(this, responsedMessage));
            }
        }

        @Override // com.baidu.tieba.c80.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                dh.b(new b(this));
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
                this.a.O0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_NID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID) instanceof String) {
                this.a.P0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE) instanceof String) {
                this.a.Q0 = wg.e((String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_TYPE), 0);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID) instanceof String) {
                this.a.R0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_ORI_UGC_VID);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_SHOW_REPLY_PANEL) instanceof String) {
                this.a.showReplyPanel = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_SHOW_REPLY_PANEL);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_PUSH_TYPE) instanceof String) {
                this.a.S0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_PUSH_TYPE);
            }
            if (hashMap.get(BdUniDispatchSchemeController.PARAM_SOURCE) instanceof String) {
                this.a.T0 = (String) hashMap.get(BdUniDispatchSchemeController.PARAM_SOURCE);
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
                if (this.a.S1() != null && this.a.S1().l() != null && this.a.S1().l().getSignData() != null && signData.forumId.equals(this.a.S1().m())) {
                    this.a.S1().l().getSignData().is_signed = signData.is_signed;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends pb {
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

        @Override // com.baidu.tieba.pb
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
                if (responsedMessage.getOrginalMessage().getTag() != this.a.getUniqueId() && responsedMessage.getOrginalMessage().getTag() != c80.d) {
                    return;
                }
                if (responsedMessage.hasError() && BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.Y.showToast(responsedMessage.getErrorString());
                }
                if (z2) {
                    this.a.c3((pbPageSocketResponseMessage) responsedMessage);
                }
                if (responsedMessage instanceof pbPageHttpResponseMessage) {
                    this.a.b3((pbPageHttpResponseMessage) responsedMessage);
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
                    zx4.a("pb", clientLogID, cmd, "resp", error, errorString, objArr);
                }
                if (!this.a.Z || !this.a.a0) {
                    if (!this.a.Z) {
                        this.a.Z = true;
                    } else {
                        this.a.a0 = true;
                    }
                    if (this.a.P != null) {
                        this.a.P.a(this.a.U1(), z, responsedMessage, this.a.c0, System.currentTimeMillis() - this.a.b0);
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
                dx7 dx7Var = this.a.G;
                if (dx7Var != null && dx7Var.h() != null && this.a.G.h().b() != null && this.a.G.h().b().equals(valueOf)) {
                    this.a.G.h().k(false);
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
                dx7 dx7Var = this.a.G;
                if (dx7Var != null && dx7Var.h() != null && this.a.G.h().b() != null && this.a.G.h().b().equals(valueOf)) {
                    this.a.G.h().k(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dx7 a;
        public final /* synthetic */ PbModel b;

        public f(PbModel pbModel, dx7 dx7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pbModel, dx7Var};
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
            this.a = dx7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.b.e3(this.a, 3, false, 0, "", false, 0, 0L, 0L, true);
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
        int a2 = c55.a() / 30;
        x1 = null;
        UPGRADE_TO_PHOTO_LIVE = 1;
    }

    public boolean A1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return invokeV.booleanValue;
    }

    public boolean A2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.q0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e0;
        }
        return (String) invokeV.objValue;
    }

    public boolean B1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.A;
        }
        return invokeV.booleanValue;
    }

    public boolean B2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.m1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public int C1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.p;
        }
        return invokeV.intValue;
    }

    public boolean C2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.l1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.h1;
        }
        return (String) invokeV.objValue;
    }

    public boolean D1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var == null) {
                return false;
            }
            return dx7Var.r();
        }
        return invokeV.booleanValue;
    }

    public boolean D2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.Z0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.f1;
        }
        return (String) invokeV.objValue;
    }

    public boolean E1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.o;
        }
        return invokeV.booleanValue;
    }

    public boolean E2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.W;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.g1;
        }
        return (String) invokeV.objValue;
    }

    public boolean F1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.x;
        }
        return invokeV.booleanValue;
    }

    public boolean F2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (this.N0 && vi6.b() != null && vi6.b().equals(this.b) && vi6.a() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int G1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.q;
        }
        return invokeV.intValue;
    }

    public final boolean G2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            int i = this.m;
            if (i != 0 && i != 2) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean H1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var == null) {
                return false;
            }
            return dx7Var.x0();
        }
        return invokeV.booleanValue;
    }

    public boolean H2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.n1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.e1;
        }
        return invokeV.booleanValue;
    }

    public String I1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return x1;
        }
        return (String) invokeV.objValue;
    }

    public boolean I2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            if (S1() != null && S1().z0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean I3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (G2() && this.G.z().b() == 0) {
                N2(true);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.i1;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public boolean K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return T2();
        }
        return invokeV.booleanValue;
    }

    public int K1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.H0;
        }
        return invokeV.intValue;
    }

    public int L1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.G0;
        }
        return invokeV.intValue;
    }

    public void L2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            x1 = null;
        }
    }

    public String N1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null && dx7Var.r()) {
                return this.G.v();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public n08 O1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.v0;
        }
        return (n08) invokeV.objValue;
    }

    public st4 Q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var == null) {
                return null;
            }
            return dx7Var.z();
        }
        return (st4) invokeV.objValue;
    }

    public boolean Q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            if (this.b != null && this.d != null) {
                cancelMessage();
                if (this.A) {
                    return o3(4);
                }
                return o3(6);
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int R1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.C0;
        }
        return invokeV.intValue;
    }

    public dx7 S1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.G;
        }
        return (dx7) invokeV.objValue;
    }

    public dx7 T1() {
        InterceptResult invokeV;
        zo8 zo8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var == null) {
                return dx7Var;
            }
            if (!u2() && (zo8Var = this.M0) != null) {
                this.G.N0(zo8Var);
            }
            return this.G;
        }
        return (dx7) invokeV.objValue;
    }

    public boolean T2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            String str = this.d;
            if (str != null && !str.equals("0") && this.d.length() != 0) {
                return Q2();
            }
            return loadData();
        }
        return invokeV.booleanValue;
    }

    public final void U2() {
        gp8 gp8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048642, this) == null) && (gp8Var = this.X) != null) {
            gp8Var.a();
            this.X = null;
        }
    }

    public String V1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.w0;
        }
        return (String) invokeV.objValue;
    }

    public String W1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.L0;
        }
        return (String) invokeV.objValue;
    }

    public void W2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048648, this) == null) && "personalize_page".equals(this.mStType)) {
            this.g0 = System.currentTimeMillis() / 1000;
        }
    }

    public void X0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048649, this) == null) {
            this.M0 = null;
        }
    }

    public String X1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.W0;
        }
        return (String) invokeV.objValue;
    }

    public boolean X2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return !TextUtils.isEmpty(this.h);
        }
        return invokeV.booleanValue;
    }

    public void Y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048652, this) == null) {
            this.h = "";
        }
    }

    public String Y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.X0;
        }
        return (String) invokeV.objValue;
    }

    public boolean Y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return !TextUtils.isEmpty(this.g);
        }
        return invokeV.booleanValue;
    }

    public void Z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048655, this) == null) {
            this.g = null;
        }
    }

    public String Z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.V0;
        }
        return (String) invokeV.objValue;
    }

    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null && dx7Var.l() != null && this.G.Q() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String a2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.U0;
        }
        return (String) invokeV.objValue;
    }

    public int b2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null) {
                return dx7Var.N();
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public int c2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.H;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            cancelMessage();
            this.isLoading = false;
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean d2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return G2();
        }
        return invokeV.booleanValue;
    }

    public String e2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.S0;
        }
        return (String) invokeV.objValue;
    }

    public AddExperiencedModel f1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            return this.y0;
        }
        return (AddExperiencedModel) invokeV.objValue;
    }

    public String f2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048677, this)) == null) {
            return this.T0;
        }
        return (String) invokeV.objValue;
    }

    public String g2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048680, this)) == null) {
            return this.p1;
        }
        return (String) invokeV.objValue;
    }

    public int getErrorNo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048682, this)) == null) {
            return this.r0;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048683, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public String getFromForumId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048684, this)) == null) {
            return this.f;
        }
        return (String) invokeV.objValue;
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048685, this)) == null) {
            return this.mTopicId;
        }
        return (String) invokeV.objValue;
    }

    public bx7 h1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048686, this)) == null) {
            return this.s0;
        }
        return (bx7) invokeV.objValue;
    }

    public int h2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048687, this)) == null) {
            return this.o1;
        }
        return invokeV.intValue;
    }

    public int i2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048690, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public boolean isPrivacy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048694, this)) == null) {
            return this.c;
        }
        return invokeV.booleanValue;
    }

    public boolean isShareThread() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048695, this)) == null) {
            return this.I0;
        }
        return invokeV.booleanValue;
    }

    public Rect j1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048696, this)) == null) {
            Rect rect = this.J0;
            this.J0 = null;
            return rect;
        }
        return (Rect) invokeV.objValue;
    }

    public int j2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048697, this)) == null) {
            return this.m;
        }
        return invokeV.intValue;
    }

    public final void j3() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048698, this) == null) {
            registerListener(this.t1);
            registerListener(this.s1);
            registerListener(this.v1);
            registerListener(this.u1);
        }
    }

    public BaijiahaoData k1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048699, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null && dx7Var.Q() != null) {
                return this.G.Q().getBaijiahaoData();
            }
            return null;
        }
        return (BaijiahaoData) invokeV.objValue;
    }

    public boolean k2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048700, this)) == null) {
            return G2();
        }
        return invokeV.booleanValue;
    }

    public zo8 l1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048702, this)) == null) {
            return this.M0;
        }
        return (zo8) invokeV.objValue;
    }

    public int l2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048703, this)) == null) {
            return this.K0;
        }
        return invokeV.intValue;
    }

    public CheckRealNameModel m1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048706, this)) == null) {
            return this.x0;
        }
        return (CheckRealNameModel) invokeV.objValue;
    }

    public String m2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048707, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public wz7 n1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048709, this)) == null) {
            return this.u0;
        }
        return (wz7) invokeV.objValue;
    }

    public String n2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048710, this)) == null) {
            if (!StringUtils.isNull(this.b) && !"0".equals(this.b)) {
                return this.b;
            }
            return this.O0;
        }
        return (String) invokeV.objValue;
    }

    public PostData o2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048713, this)) == null) {
            return this.E0;
        }
        return (PostData) invokeV.objValue;
    }

    public PostData p2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048716, this)) == null) {
            return this.F0;
        }
        return (PostData) invokeV.objValue;
    }

    public String q1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048718, this)) == null) {
            return this.f0;
        }
        return (String) invokeV.objValue;
    }

    public String q2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048719, this)) == null) {
            return this.mTopicSubjectName;
        }
        return (String) invokeV.objValue;
    }

    public String r1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048721, this)) == null) {
            return this.F;
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public WorksInfoData r2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048722, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null && dx7Var.Q() != null) {
                return this.G.Q().worksInfoData;
            }
            return null;
        }
        return (WorksInfoData) invokeV.objValue;
    }

    public String s1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048724, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String s2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048725, this)) == null) {
            return this.d;
        }
        return (String) invokeV.objValue;
    }

    public String t1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048727, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public boolean t2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048728, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null && !ListUtils.isEmpty(dx7Var.H())) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean v1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048733, this)) == null) {
            return this.j;
        }
        return invokeV.booleanValue;
    }

    public void v2() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048734, this) == null) {
            qz7.b().d(p1(), this.A);
        }
    }

    public int w1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048736, this)) == null) {
            return this.a1;
        }
        return invokeV.intValue;
    }

    public boolean w2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048737, this)) == null) {
            return this.j1;
        }
        return invokeV.booleanValue;
    }

    public boolean x1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048739, this)) == null) {
            return this.y;
        }
        return invokeV.booleanValue;
    }

    public boolean x2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048740, this)) == null) {
            return this.j0;
        }
        return invokeV.booleanValue;
    }

    public boolean y1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048742, this)) == null) {
            return this.M;
        }
        return invokeV.booleanValue;
    }

    public boolean y2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048743, this)) == null) {
            if (12 != this.Y.getIntent().getIntExtra(PbCommentFloatActivityConfig.KEY_FROM_VIDEO_PAGE_TYPE, 0) && 12 != this.C0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean z1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048745, this)) == null) {
            return "hot_topic".equals(this.mStType);
        }
        return invokeV.booleanValue;
    }

    public boolean z2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048746, this)) == null) {
            return this.q1;
        }
        return invokeV.booleanValue;
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
                super((r9) newInitContext.callArgs[0]);
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
        this.q0 = false;
        this.B0 = false;
        this.C0 = 0;
        this.K0 = 0;
        this.N0 = false;
        this.a1 = 3;
        this.c1 = 0;
        this.l1 = false;
        this.m1 = false;
        this.n1 = false;
        this.o1 = -1;
        this.p1 = null;
        this.q1 = false;
        this.s1 = new b(this, 2001222);
        this.t1 = new c(this, CmdConfigHttp.PB_PAGE_HTTP_CMD, 302001);
        this.u1 = new d(this, 2001336);
        this.v1 = new e(this, 2001335);
        this.w1 = null;
        dx7 dx7Var = new dx7();
        this.G = dx7Var;
        dx7Var.F0(0);
        this.O = baseFragmentActivity.getPageContext().getPageActivity();
        this.Y = baseFragmentActivity;
        this.t0 = new m08();
        this.u0 = new wz7(this, this.Y);
        this.v0 = new n08(this, this.Y);
        this.x0 = new CheckRealNameModel(this.Y.getPageContext());
        this.z0 = new SuggestEmotionModel();
        this.y0 = new AddExperiencedModel(this.Y.getPageContext());
        this.r1 = new a(this);
    }

    public void n3(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048711, this, bundle) == null) {
            bundle.putString("thread_id", this.b);
            bundle.putString("post_id", this.d);
            bundle.putString("forum_id", this.e);
            bundle.putString("from_forum_id", this.f);
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
            bundle.putBoolean("is_jump_from_video_tab", this.l1);
            bundle.putBoolean("is_jump_from_video_middle", this.m1);
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
        initWithIntent(intent);
        x3(hVar);
        j3();
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
        initWithBundle(bundle);
        x3(hVar);
        j3();
    }

    public void q3(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048720, this, i, i2) == null) {
            this.G0 = i;
            this.H0 = i2;
        }
    }

    public void B3(int i) {
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (dx7Var = this.G) != null) {
            dx7Var.Q0(i);
        }
    }

    public void C3(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k1 = z;
        }
    }

    public void E3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.a = i;
        }
    }

    public void H3(boolean z) {
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048605, this, z) == null) && (dx7Var = this.G) != null) {
            dx7Var.J0(z);
        }
    }

    public final void M3(@NonNull dx7 dx7Var) {
        dx7 dx7Var2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048623, this, dx7Var) == null) && (dx7Var2 = this.G) != null) {
            dx7Var2.e().clear();
            this.G.e().addAll(dx7Var.e());
        }
    }

    public boolean N2(boolean z) {
        InterceptResult invokeZ;
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
            if (this.b == null || (dx7Var = this.G) == null) {
                return false;
            }
            if (!z && dx7Var.z().b() == 0) {
                return false;
            }
            return o3(1);
        }
        return invokeZ.booleanValue;
    }

    public void P2(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048631, this, str) != null) || StringUtils.isNull(str)) {
            return;
        }
        this.b = str;
        this.d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public void S2(GetSugMatchWordsModel.b bVar) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048638, this, bVar) != null) || bVar == null) {
            return;
        }
        if (this.A0 == null) {
            this.A0 = new GetSugMatchWordsModel(this.Y.getPageContext());
        }
        this.A0.B(bVar);
    }

    public void b1(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048662, this, dx7Var) != null) || dx7Var == null) {
            return;
        }
        if (this.L || this.J || this.K) {
            dx7Var = G3(dx7Var);
        }
        g3(dx7Var);
    }

    public void l3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048704, this, i) == null) {
            this.s = i;
            this.t = i;
            this.u = i;
        }
    }

    public void r3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048723, this, str) == null) {
            this.f0 = str;
        }
    }

    public void s3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048726, this, i) == null) {
            this.c1 = i;
        }
    }

    public void t3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048729, this, i) == null) {
            this.a1 = i;
        }
    }

    public void u3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048732, this, i) == null) {
            this.p = i;
        }
    }

    public void v3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048735, this, i) == null) {
            this.q = i;
        }
    }

    public void x3(h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048741, this, hVar) == null) {
            this.P = hVar;
        }
    }

    public void y3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048744, this, i) == null) {
            this.C0 = i;
        }
    }

    public void z3(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048747, this, str) == null) {
            this.L0 = str;
        }
    }

    public final void A3(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(r1()) || vf8.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setRefreshCount(vf8.l().b().d(r1(), true) + 1);
        pbPageRequestMessage.setLoadCount(vf8.l().b().e(r1(), true));
    }

    public void D3(Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, uri) == null) {
            boolean z = false;
            if (uri == null) {
                this.n1 = false;
                return;
            }
            String queryParameter = uri.getQueryParameter("obj_source");
            String uri2 = uri.toString();
            if (!TextUtils.isEmpty(uri2) && uri2.contains(UNIDISPATCH_PB) && ("shoubai".equals(queryParameter) || WISE.equals(queryParameter))) {
                z = true;
            }
            this.n1 = z;
            if ("shoubai".equals(queryParameter)) {
                this.o1 = 5;
            } else if (WISE.equals(queryParameter)) {
                this.o1 = 4;
            } else {
                this.o1 = -1;
            }
            this.p1 = uri.getQueryParameter(TiebaStatic.Params.EQID);
        }
    }

    public boolean K2(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
            if (S1() != null && S1().Q() != null && S1().Q().getAuthor() != null && !StringUtils.isNull(str)) {
                String userId = S1().Q().getAuthor().getUserId();
                if (!StringUtils.isNull(userId) && userId.equals(str)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean L3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048620, this, i)) == null) {
            if (i == this.m) {
                return false;
            }
            if (i != 1) {
                ky4.k().w("key_pb_current_sort_type", i);
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

    public void O2(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048628, this, dx7Var) != null) || dx7Var == null) {
            return;
        }
        this.b = dx7Var.S();
        if (dx7Var.Q() != null && dx7Var.Q().getBaijiahaoData() != null) {
            BaijiahaoData baijiahaoData = dx7Var.Q().getBaijiahaoData();
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
        this.d = null;
        this.j = false;
        this.l = true;
        loadData();
    }

    public void a1(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048659, this, str) == null) {
            if ((!this.j || K2(TbadkCoreApplication.getCurrentAccount())) && this.G.H() != null) {
                this.G.z().l(1);
                if (this.G.z().b() == 0) {
                    this.G.z().l(1);
                }
                this.D0 = str;
                o3(8);
            }
        }
    }

    public final void w3(PbPageRequestMessage pbPageRequestMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048738, this, pbPageRequestMessage) != null) || TextUtils.isEmpty(r1()) || vf8.l().b() == null) {
            return;
        }
        pbPageRequestMessage.setLoadCount(vf8.l().b().e(r1(), true) + 1);
        pbPageRequestMessage.setRefreshCount(vf8.l().b().d(r1(), true));
    }

    public boolean F3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
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
            return o3(5);
        }
        return invokeI.booleanValue;
    }

    public dx7 G3(dx7 dx7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, dx7Var)) == null) {
            if (dx7Var == null) {
                return null;
            }
            ThreadData Q = dx7Var.Q();
            Q.setIs_good(this.p);
            Q.setIs_top(this.q);
            long j = this.r;
            if (j > 0) {
                Q.setLast_time_int(j);
            }
            d1(Q);
            return dx7Var;
        }
        return (dx7) invokeL.objValue;
    }

    public final String J1(ArrayList<PostData> arrayList) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, arrayList)) == null) {
            int count = ListUtils.getCount(arrayList);
            if (count <= 0) {
                return null;
            }
            for (int i = count - 1; i >= 0; i--) {
                PostData postData = (PostData) ListUtils.getItem(arrayList, i);
                if (postData != null && !StringUtils.isNull(postData.M())) {
                    return postData.M();
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public boolean J3(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
            this.j = !this.j;
            this.d = str;
            TiebaStatic.log(new StatisticItem("pb_onlyowner_click").param("obj_source", 0));
            if (o3(6)) {
                return true;
            }
            this.j = !this.j;
            return false;
        }
        return invokeL.booleanValue;
    }

    public void P3(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048632, this, dx7Var) != null) || dx7Var == null) {
            return;
        }
        dx7Var.U0(this.G.b0());
        dx7 dx7Var2 = this.G;
        if (!dx7Var2.Z && dx7Var.Z && dx7Var2.i() != null) {
            dx7Var.I0(this.G.i());
        }
        this.G = dx7Var;
        l3(dx7Var.z().a());
    }

    public boolean R2(boolean z) {
        InterceptResult invokeZ;
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048636, this, z)) == null) {
            if (this.b == null || (dx7Var = this.G) == null || ((!z && dx7Var.z().c() == 0) || this.G.H() == null || this.G.H().size() < 1)) {
                return false;
            }
            return o3(2);
        }
        return invokeZ.booleanValue;
    }

    public void V0(st4 st4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048643, this, st4Var) == null) {
            if (st4Var == null) {
                l3(1);
                return;
            }
            if (this.t < st4Var.a()) {
                this.t = st4Var.a();
            }
            if (this.u > st4Var.a()) {
                this.u = st4Var.a();
            }
            this.v = st4Var.h();
        }
    }

    public final void W0(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048646, this, dx7Var) == null) && dx7Var != null && dx7Var.A() != null && dx7Var.A().getAdvertAppInfo() != null && dx7Var.A().p1() && dx7Var.A().getAdvertAppInfo().c != 1001) {
            this.M0 = dx7Var.A();
        }
    }

    public void b3(pbPageHttpResponseMessage pbpagehttpresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, pbpagehttpresponsemessage) == null) {
            int downSize = pbpagehttpresponsemessage.getDownSize();
            long costTime = pbpagehttpresponsemessage.getCostTime();
            if (pbpagehttpresponsemessage.getError() == 4) {
                this.s0 = pbpagehttpresponsemessage.getAppealInfo();
            }
            d3(pbpagehttpresponsemessage.getPbData(), pbpagehttpresponsemessage.getUpdateType(), pbpagehttpresponsemessage.hasError(), pbpagehttpresponsemessage.getError(), pbpagehttpresponsemessage.getErrorString(), true, downSize, costTime, 0L);
        }
    }

    public void c3(pbPageSocketResponseMessage pbpagesocketresponsemessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, pbpagesocketresponsemessage) == null) {
            int downSize = pbpagesocketresponsemessage.getDownSize();
            long costTime = pbpagesocketresponsemessage.getCostTime();
            if (pbpagesocketresponsemessage.getError() == 4) {
                this.s0 = pbpagesocketresponsemessage.getAppealInfo();
            }
            d3(pbpagesocketresponsemessage.getPbData(), pbpagesocketresponsemessage.getUpdateType(), pbpagesocketresponsemessage.hasError(), pbpagesocketresponsemessage.getError(), pbpagesocketresponsemessage.getErrorString(), false, downSize, 0L, costTime);
        }
    }

    public void d1(@NonNull ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, threadData) == null) {
            threadData.isTiebaPlusAdThread = I();
            threadData.tiebaPlusOrderId = E();
            threadData.tiebaPlusToken = F();
            threadData.tiebaPlusExtraParam = F();
            threadData.tiebaplusCantDelete = J();
            threadData.setDispatchedForumIdWithString(z());
        }
    }

    public MarkData i1(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048689, this, i)) == null) {
            if (i < 0) {
                i = 0;
            }
            dx7 dx7Var = this.G;
            if (dx7Var == null) {
                return null;
            }
            ArrayList<PostData> H = dx7Var.H();
            if (ListUtils.isEmpty(H)) {
                return null;
            }
            if (H.size() > 0 && i >= H.size()) {
                i = H.size() - 1;
            }
            return M1(H.get(i));
        }
        return (MarkData) invokeI.objValue;
    }

    public String i3(dx7 dx7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048691, this, dx7Var)) == null) {
            String str = null;
            if (dx7Var == null) {
                return null;
            }
            if (dx7Var.Q() != null && dx7Var.Q().getAuthor() != null) {
                str = dx7Var.Q().getAuthor().getUserId();
            }
            if (str == null) {
                return "";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // com.baidu.tbadk.editortools.pb.DataModel
    public WriteData G(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, str)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var != null && dx7Var.Q() != null && this.G.l() != null) {
                WriteData writeData = new WriteData();
                if (this.G.Q().isMutiForumThread()) {
                    writeData.setForumId("0");
                    writeData.setForumName("");
                } else {
                    writeData.setForumId(this.G.l().getId());
                    writeData.setForumName(this.G.l().getName());
                }
                writeData.setFromForumId(this.f);
                writeData.sourceFrom = String.valueOf(this.C0);
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

    public MarkData M1(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, postData)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(postData.M());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(G2()));
            markData.setId(this.b);
            markData.setFloor(postData.D());
            markData.setForumId(this.e);
            boolean z = true;
            if (postData instanceof ax7) {
                markData.setApp(true);
            } else if (postData instanceof zo8) {
                zo8 zo8Var = (zo8) postData;
                markData.setApp((zo8Var.getAdvertAppInfo() == null || !zo8Var.getAdvertAppInfo().h()) ? false : false);
            }
            return markData;
        }
        return (MarkData) invokeL.objValue;
    }

    public void a3(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048661, this, i) == null) {
            f3(i);
            ArrayList<PostData> H = this.G.H();
            boolean z = false;
            this.c0 = false;
            if (i == 1) {
                boolean z2 = false;
                while (H.size() + 30 > c55.a()) {
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
                while (H.size() + 30 > c55.a()) {
                    H.remove(H.size() - 1);
                    z = true;
                }
                if (z) {
                    this.G.z().l(1);
                }
            }
        }
    }

    public boolean J2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            if (R1() == 3 || S1() == null || S1().Q() == null || !S1().Q().isMutiForumThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void destory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048672, this) == null) {
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
            hh8.f().a("PB");
            U2();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048705, this)) == null) {
            if (this.b == null) {
                return false;
            }
            cancelLoadData();
            if (this.X == null) {
                gp8 gp8Var = new gp8("pbStat");
                this.X = gp8Var;
                gp8Var.f();
            }
            boolean o3 = o3(3);
            if (this.Q != null) {
                this.Q = null;
                this.S = null;
                this.R = null;
            }
            return o3;
        }
        return invokeV.booleanValue;
    }

    public void m3() {
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048708, this) == null) && (dx7Var = this.G) != null && !ListUtils.isEmpty(dx7Var.H())) {
            if (this.F0 != null) {
                this.G.H().remove(this.F0);
                this.F0 = null;
            }
            if (this.E0 != null) {
                this.G.H().remove(this.E0);
                this.E0 = null;
            }
        }
    }

    public MetaData u1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048730, this)) == null) {
            dx7 dx7Var = this.G;
            if (dx7Var == null || dx7Var.Q() == null || this.G.Q().getAuthor() == null) {
                return null;
            }
            return this.G.Q().getAuthor();
        }
        return (MetaData) invokeV.objValue;
    }

    public final boolean u2() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048731, this)) == null) {
            if (this.G.A() == null || this.G.A().getAdvertAppInfo() == null || this.G.A().getAdvertAppInfo().c == 1001) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean K3(boolean z, String str) {
        InterceptResult invokeZL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZL = interceptable.invokeZL(1048617, this, z, str)) == null) {
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
            if (o3(6)) {
                return true;
            }
            this.j = !z;
            return false;
        }
        return invokeZL.booleanValue;
    }

    public void M2(ForumData forumData, SuggestEmotionModel.c cVar) {
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048622, this, forumData, cVar) == null) {
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
            this.z0.C(str3, str, cVar);
        }
    }

    public void N3(UserPendantData userPendantData) {
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048626, this, userPendantData) == null) && userPendantData != null && (dx7Var = this.G) != null && dx7Var.H() != null && this.G.H().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            int size = this.G.H().size();
            for (int i = 0; i < size; i++) {
                if (this.G.H().get(i) != null && this.G.H().get(i).s() != null && currentAccount.equals(this.G.H().get(i).s().getUserId()) && this.G.H().get(i).s().getPendantData() != null) {
                    this.G.H().get(i).s().getPendantData().setImgUrl(userPendantData.getImgUrl());
                    this.G.H().get(i).s().getPendantData().setPropsId(userPendantData.getPropsId());
                }
            }
        }
    }

    public dx7 c1(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, threadData)) == null) {
            dx7 dx7Var = new dx7();
            dx7Var.F0(3);
            if (threadData == null) {
                return null;
            }
            dx7Var.R0(threadData);
            if (threadData.getForumData() != null) {
                dx7Var.G0(threadData.getForumData());
                ForumData l = dx7Var.l();
                l.setId(threadData.getForumData().b());
                l.setName(threadData.getForumData().d());
                l.setUser_level(threadData.getForumData().c());
                l.setImage_url(threadData.getForumData().a());
                l.setPost_num(threadData.getForumData().g);
                l.setMember_num(threadData.getForumData().h);
            } else {
                ForumData l2 = dx7Var.l();
                l2.setId(String.valueOf(threadData.getFid()));
                l2.setName(threadData.getForum_name());
            }
            PostData postData = new PostData();
            postData.F0(1);
            postData.b1(threadData.getCreateTime());
            postData.D0(threadData.getAuthor());
            MetaData author = threadData.getAuthor();
            HashMap<String, MetaData> hashMap = new HashMap<>();
            hashMap.put(author.getUserId(), author);
            postData.e1(hashMap);
            postData.X0(TbRichTextView.V(threadData.getFirstFloorList(), m2(), false));
            dx7Var.H0(postData);
            dx7Var.H().add(postData);
            dx7Var.O0(new rx7(threadData, null));
            dx7Var.m = true;
            dx7Var.K0(1);
            return dx7Var;
        }
        return (dx7) invokeL.objValue;
    }

    public boolean o3(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048714, this, i)) == null) {
            this.H = i;
            if (this.isLoading) {
                return false;
            }
            this.isLoading = true;
            a3(i);
            dx7 f2 = w08.b().f();
            if (f2 != null && f2.Q() != null) {
                f2.Q().setCopyThreadRemindType(0);
                this.l = w08.b().i();
                this.j = w08.b().a();
                this.o = w08.b().c();
                this.E0 = w08.b().g();
                this.F0 = w08.b().h();
                this.G0 = w08.b().d();
                this.J0 = w08.b().k();
                this.K0 = w08.b().j();
                boolean z = this.j;
                this.B0 = z;
                if (z || this.A) {
                    this.W = false;
                }
                zg.a().post(new f(this, f2));
                return false;
            }
            if (i == 4 && !this.d0) {
                p3(p1(), true, this.d, 3);
            }
            if (i == 3 && !this.d0) {
                if (this.A) {
                    p3(p1(), true, this.d, 3);
                } else {
                    p3(p1(), false, this.d, 3);
                }
            }
            this.d0 = false;
            c80.d(CmdConfigHttp.PB_PAGE_HTTP_CMD, new g(this, i));
            return true;
        }
        return invokeI.booleanValue;
    }

    public void O3(dx7 dx7Var, ArrayList<PostData> arrayList) {
        String J1;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048629, this, dx7Var, arrayList) == null) && arrayList != null && dx7Var.H() != null) {
            PostData postData = (PostData) ListUtils.getItem(dx7Var.H(), 0);
            if (postData != null && (J1 = J1(arrayList)) != null && J1.equals(postData.M())) {
                dx7Var.H().remove(postData);
            }
            this.G.b0 = arrayList.size();
            arrayList.addAll(dx7Var.H());
        }
    }

    public final String P1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
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

    public void V2() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048645, this) == null) && "personalize_page".equals(this.mStType) && this.G != null && this.g0 != 0) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            TiebaStatic.log(new StatisticItem("c10754").param("fid", this.G.m()).param("tid", this.b).param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(currentTimeMillis - this.g0)).param(TiebaStatic.Params.OBJ_PARAM3, String.valueOf(currentTimeMillis)));
            this.g0 = 0L;
        }
    }

    public final String p1() {
        InterceptResult invokeV;
        String P1;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048715, this)) == null) {
            String str = this.b;
            if (str != null && !str.equals("0")) {
                P1 = this.b;
            } else {
                P1 = P1();
            }
            if (this.j) {
                P1 = P1 + "_host";
            }
            int i = this.m;
            if (i == 1) {
                P1 = P1 + "_rev";
            } else if (i == 2) {
                P1 = P1 + "_hot";
            }
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                return P1 + TbadkCoreApplication.getCurrentAccount();
            }
            return P1;
        }
        return (String) invokeV.objValue;
    }

    public void Z2(dx7 dx7Var, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048657, this, dx7Var, i, str) == null) {
            this.d0 = true;
            if (dx7Var != null && dx7Var.h == null) {
                P3(dx7Var);
                b1(dx7Var);
                if (dx7Var.Q() != null) {
                    dx7Var.Q().setCopyThreadRemindType(0);
                }
                h hVar = this.P;
                if (hVar != null && dx7Var != null) {
                    hVar.c(true, 0, i, 0, dx7Var, str, 0);
                }
            }
        }
    }

    public void d3(dx7 dx7Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2) {
        dx7 dx7Var2;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048671, this, new Object[]{dx7Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            if (z) {
                i4 = i2;
                dx7Var2 = null;
            } else {
                dx7Var2 = dx7Var;
                i4 = i2;
            }
            this.r0 = i4;
            this.isLoading = false;
            if (dx7Var2 != null) {
                b1(dx7Var2);
            }
            W0(dx7Var2);
            zo8 zo8Var = this.M0;
            if (zo8Var != null && zo8Var.p1()) {
                TiebaStatic.log(an8.e("a005", "common_fill", true, 1));
            }
            e3(dx7Var2, i, z, i2, str, z2, i3, j, j2, false);
        }
    }

    public String e1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
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

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void e3(dx7 dx7Var, int i, boolean z, int i2, String str, boolean z2, int i3, long j, long j2, boolean z3) {
        int i4;
        boolean z4;
        int i5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048675, this, new Object[]{dx7Var, Integer.valueOf(i), Boolean.valueOf(z), Integer.valueOf(i2), str, Boolean.valueOf(z2), Integer.valueOf(i3), Long.valueOf(j), Long.valueOf(j2), Boolean.valueOf(z3)}) == null) {
            boolean z5 = true;
            boolean z6 = !z;
            this.j0 = z3;
            gp8 gp8Var = this.X;
            if (gp8Var != null && !z3) {
                gp8Var.b(z2, z6, i2, str, i3, j, j2);
                this.X = null;
            }
            dx7 dx7Var2 = this.G;
            if (dx7Var2 != null) {
                dx7Var2.c0 = z3;
                dx7Var2.d0 = i;
            }
            if (z6 && !z3 && !TextUtils.isEmpty(r1()) && vf8.l().b() != null) {
                vf8.l().b().g(r1(), k3(c2()), true);
            }
            if (dx7Var != null && (this.s != 1 || i != 5 || dx7Var.H() == null || dx7Var.H().size() >= 1)) {
                this.k = this.l;
                if (i != 8) {
                    this.n = this.m;
                    this.m = dx7Var.g;
                }
                List<PbSortType> list = dx7Var.f;
                if (list != null && list.isEmpty()) {
                    PbSortType.Builder builder = new PbSortType.Builder();
                    builder.sort_name = this.Y.getResources().getString(R.string.obfuscated_res_0x7f0f04aa);
                    builder.sort_type = 0;
                    ArrayList arrayList = new ArrayList();
                    dx7Var.f = arrayList;
                    arrayList.add(builder.build(false));
                    PbSortType.Builder builder2 = new PbSortType.Builder();
                    builder2.sort_name = this.Y.getResources().getString(R.string.obfuscated_res_0x7f0f15a5);
                    builder2.sort_type = 1;
                    dx7Var.f.add(builder2.build(false));
                    int i6 = this.n;
                    this.m = i6;
                    dx7Var.g = i6;
                }
                this.E = false;
                if (dx7Var.z() != null && (this.m != 2 || i != 8)) {
                    V0(dx7Var.z());
                }
                int i7 = this.v;
                if (i7 < 1) {
                    i7 = 1;
                }
                this.v = i7;
                ArrayList<PostData> H = this.G.H();
                switch (i) {
                    case 1:
                        this.G.M0(dx7Var.z(), 1);
                        O3(dx7Var, H);
                        M3(dx7Var);
                        i4 = 0;
                        break;
                    case 2:
                        if (dx7Var.H() != null) {
                            i4 = dx7Var.H().size() + 1;
                            PostData postData = (PostData) ListUtils.getItem(H, 0);
                            PostData postData2 = (PostData) ListUtils.getItem(dx7Var.H(), ListUtils.getCount(dx7Var.H()) - 1);
                            if (postData != null && postData2 != null && postData.M().equals(postData2.M())) {
                                dx7Var.H().remove(postData2);
                                i4--;
                            }
                            if (y2()) {
                                x1 = H.get(1).M();
                            }
                            H.addAll(0, dx7Var.H());
                        } else {
                            i4 = 0;
                        }
                        M3(dx7Var);
                        this.G.M0(dx7Var.z(), 2);
                        break;
                    case 3:
                        if (this.m == 1 && dx7Var.z() != null) {
                            dx7Var.z().k(dx7Var.z().h());
                        }
                        P3(dx7Var);
                        i4 = 0;
                        break;
                    case 4:
                        P3(dx7Var);
                        i4 = 0;
                        break;
                    case 5:
                        P3(dx7Var);
                        i4 = 0;
                        break;
                    case 6:
                        P3(dx7Var);
                        i4 = 0;
                        break;
                    case 7:
                        P3(dx7Var);
                        i4 = 0;
                        break;
                    case 8:
                        if (dx7Var != null && !ListUtils.isEmpty(dx7Var.H()) && this.G != null && (!this.j || i3(dx7Var).equals(dx7Var.H().get(0).s().getUserId()))) {
                            if (this.G.z().b() == 0) {
                                this.G.z().l(1);
                            }
                            m3();
                            this.E0 = dx7Var.H().get(0);
                            if (!G2() && !this.G.l0()) {
                                if (this.G0 - this.H0 >= 3) {
                                    PostData postData3 = new PostData();
                                    this.F0 = postData3;
                                    postData3.C = false;
                                    postData3.V0(53);
                                    this.G.H().add(0, this.F0);
                                }
                                this.G.H().add(0, this.E0);
                                i5 = 0;
                            } else {
                                if (this.G.H().size() - this.G0 >= 3) {
                                    PostData postData4 = new PostData();
                                    this.F0 = postData4;
                                    postData4.C = true;
                                    postData4.V0(53);
                                    this.G.H().add(this.F0);
                                }
                                this.G.H().add(this.E0);
                                i5 = this.G.H().size() - 1;
                            }
                            if (!StringHelper.isTaday(ky4.k().m("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), 0L))) {
                                this.E0.S = this.G.L();
                                ky4.k().x("pb_post_recommend_live_date_" + TbadkCoreApplication.getCurrentAccount(), System.currentTimeMillis());
                            }
                        } else {
                            i5 = 0;
                        }
                        M3(dx7Var);
                        i4 = i5;
                        break;
                    default:
                        i4 = 0;
                        break;
                }
                dx7 dx7Var3 = this.G;
                if (dx7Var3 != null && dx7Var3.Q() != null) {
                    PraiseData praise = this.G.Q().getPraise();
                    if (this.w1 != null && !praise.isPriaseDataValid()) {
                        this.G.Q().setPraise(this.w1);
                    } else {
                        PraiseData praise2 = this.G.Q().getPraise();
                        this.w1 = praise2;
                        praise2.setPostId(this.G.Q().getFirstPostId());
                    }
                    if (dx7Var.z() != null && dx7Var.z().a() == 1 && dx7Var.Q() != null && dx7Var.Q().getActDatas() != null && dx7Var.Q().getActDatas().size() > 0) {
                        this.G.Q().setActDatas(dx7Var.Q().getActDatas());
                    }
                    this.G.Q().setReply_num(dx7Var.Q().getReply_num());
                    this.G.Q().setAnchorLevel(dx7Var.Q().getAnchorLevel());
                    this.G.Q().setCopyThreadRemindType(dx7Var.Q().getCopyThreadRemindType());
                    if (this.I == 33) {
                        this.G.Q().getAuthor().setHadConcerned(dx7Var.Q().getAuthor().hadConcerned());
                    }
                    if (dx7Var != null && dx7Var.Q() != null) {
                        this.G.Q().updateIsNotitle(dx7Var.Q().getIsNoTitle());
                    }
                }
                dx7 dx7Var4 = this.G;
                if (dx7Var4 != null && dx7Var4.X() != null && dx7Var.X() != null) {
                    this.G.X().setBimg_end_time(dx7Var.X().getBimg_end_time());
                    this.G.X().setBimg_url(dx7Var.X().getBimg_url());
                    this.G.X().setDynamicUrl(dx7Var.X().getDynamicUrl());
                }
                if (dx7Var.z() != null && dx7Var.z().a() == 1 && dx7Var.a0() != null) {
                    this.G.T0(dx7Var.a0());
                }
                if (this.j0) {
                    if (this.G.Q() != null && this.G.Q().getAuthor() != null && this.G.H() != null && ListUtils.getItem(this.G.H(), 0) != null) {
                        PostData postData5 = (PostData) ListUtils.getItem(this.G.H(), 0);
                        MetaData author = this.G.Q().getAuthor();
                        if (postData5.s() != null && postData5.s().getGodUserData() != null) {
                            int i8 = this.U;
                            if (i8 != -1) {
                                author.setFansNum(i8);
                                postData5.s().setFansNum(this.U);
                            }
                            if (this.V != -1) {
                                GodUserData godUserData = author.getGodUserData();
                                if (this.V == 1) {
                                    z4 = true;
                                } else {
                                    z4 = false;
                                }
                                godUserData.setIsLike(z4);
                                GodUserData godUserData2 = postData5.s().getGodUserData();
                                if (this.V != 1) {
                                    z5 = false;
                                }
                                godUserData2.setIsLike(z5);
                                author.getGodUserData().setIsFromNetWork(false);
                                postData5.s().getGodUserData().setIsFromNetWork(false);
                            }
                        }
                    }
                    dx7 dx7Var5 = this.G;
                    dx7Var5.e = -1;
                    dx7Var5.d = -1;
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
            dx7 dx7Var6 = this.G;
            if (dx7Var6 != null && dx7Var6.Q() != null && this.G.l() != null && !this.G.l0()) {
                HistoryMessage historyMessage = new HistoryMessage();
                historyMessage.Activity = this.Y.getPageContext();
                historyMessage.threadId = S1().Q().getId();
                if (this.I0 && S1().Q().originalThreadData != null) {
                    historyMessage.threadName = S1().Q().originalThreadData.b;
                } else {
                    historyMessage.threadName = S1().Q().getTitle();
                }
                if (this.I0 && !J2()) {
                    historyMessage.forumName = "";
                } else {
                    historyMessage.forumName = S1().l().getName();
                }
                historyMessage.isHostOnly = v1();
                historyMessage.isSquence = k2();
                historyMessage.threadType = S1().Q().getThreadType();
                historyMessage.isShareThread = this.I0;
                MessageManager.getInstance().dispatchResponsedMessage(historyMessage);
            }
        }
    }

    public final void f3(int i) {
        dx7 dx7Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048678, this, i) == null) && i != 8) {
            this.D0 = "";
            if (this.E0 != null) {
                if (i == 1 && (dx7Var = this.G) != null && dx7Var.l0()) {
                    if (this.F0 != null) {
                        S1().H().remove(this.F0);
                    }
                } else if (i == 1 && !this.l && !ListUtils.isEmpty(S1().H())) {
                    S1().H().remove(this.E0);
                    if (this.F0 != null) {
                        S1().H().remove(this.F0);
                    }
                    S1().H().add(0, this.E0);
                } else {
                    S1().H().remove(this.E0);
                    if (this.F0 != null) {
                        S1().H().remove(this.F0);
                    }
                }
            }
            this.F0 = null;
        }
    }

    public void g3(dx7 dx7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048681, this, dx7Var) != null) || dx7Var == null) {
            return;
        }
        String i3 = i3(dx7Var);
        for (int i = 0; i < dx7Var.H().size(); i++) {
            PostData postData = dx7Var.H().get(i);
            for (int i2 = 0; i2 < postData.a0().size(); i2++) {
                postData.a0().get(i2).i1(this.Y.getPageContext(), i3.equals(postData.a0().get(i2).s().getUserId()));
            }
        }
        wx7 V = dx7Var.V();
        if (V != null && !ListUtils.isEmpty(V.a)) {
            for (PostData postData2 : V.a) {
                for (int i4 = 0; i4 < postData2.a0().size(); i4++) {
                    postData2.a0().get(i4).i1(this.Y.getPageContext(), i3.equals(postData2.a0().get(i4).s().getUserId()));
                }
            }
        }
    }

    public final int g1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048679, this)) == null) {
            int i = 0;
            if (S1().H() == null) {
                return 0;
            }
            ArrayList<PostData> H = S1().H();
            for (int size = H.size() - 1; size >= 0; size--) {
                PostData postData = H.get(size);
                if (postData instanceof zo8) {
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

    public MarkData o1() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048712, this)) == null) {
            MarkData markData = new MarkData();
            Date date = new Date();
            markData.setAccount(TbadkCoreApplication.getCurrentAccount());
            markData.setThreadId(this.b);
            markData.setPostId(this.G.v());
            markData.setTime(date.getTime());
            markData.setHostMode(this.j);
            markData.setSequence(Boolean.valueOf(G2()));
            markData.setId(this.b);
            return markData;
        }
        return (MarkData) invokeV.objValue;
    }

    public void h3(dx7 dx7Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048688, this, dx7Var, i) != null) || dx7Var == null) {
            return;
        }
        String i3 = i3(dx7Var);
        wx7 V = dx7Var.V();
        if (V != null && !ListUtils.isEmpty(V.a)) {
            List<PostData> list = V.a;
            for (PostData postData : list.subList(i, list.size())) {
                for (int i2 = 0; i2 < postData.a0().size(); i2++) {
                    postData.a0().get(i2).i1(this.Y.getPageContext(), i3.equals(postData.a0().get(i2).s().getUserId()));
                }
            }
        }
    }

    public final void initWithBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048692, this, bundle) == null) {
            boolean z = false;
            this.C0 = bundle.getInt("key_start_from", 0);
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
            this.q1 = bundle.getBoolean(PbActivityConfig.KEY_SCHEME_START, false);
            this.l1 = bundle.getBoolean("is_jump_from_video_tab", false);
            this.m1 = bundle.getBoolean("is_jump_from_video_middle", false);
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
            this.Z0 = bundle.getBoolean("key_jump_to_comment_area", false);
            this.R0 = bundle.getString("key_ori_ugc_vid");
            if (bundle.getInt("request_code", -1) == 18003) {
                z = true;
            }
            this.W = z;
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
            Parcelable parcelable = bundle.getParcelable(IntentConfig.KEY_URI);
            if (parcelable instanceof Uri) {
                D3((Uri) parcelable);
            }
        }
    }

    public final void initWithIntent(Intent intent) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048693, this, intent) != null) || intent == null) {
            return;
        }
        this.b = intent.getStringExtra("thread_id");
        this.c = intent.getBooleanExtra("key_is_privacy", false);
        this.O0 = intent.getStringExtra("key_ori_ugc_nid");
        this.P0 = intent.getStringExtra("key_ori_ugc_tid");
        this.Q0 = intent.getIntExtra("key_ori_ugc_type", 0);
        this.R0 = intent.getStringExtra("key_ori_ugc_vid");
        this.Z0 = intent.getBooleanExtra("key_jump_to_comment_area", false);
        this.l1 = intent.getBooleanExtra("is_jump_from_video_tab", false);
        this.m1 = intent.getBooleanExtra("is_jump_from_video_middle", false);
        this.b1 = intent.getStringExtra("key_official_bar_message_id");
        this.q1 = intent.getBooleanExtra(PbActivityConfig.KEY_SCHEME_START, false);
        Uri uri = (Uri) intent.getParcelableExtra(IntentConfig.KEY_URI);
        D3(uri);
        if (uri != null) {
            str = uri.toString();
        } else {
            str = null;
        }
        this.Y0 = str;
        this.d1 = false;
        boolean z = true;
        if (BdUniDispatchSchemeController.isUniScheme(uri)) {
            this.d1 = true;
            BdUniDispatchSchemeController.getInstance().parsePbScheme(uri, this.r1);
        } else if (StringUtils.isNull(this.b)) {
            this.d1 = true;
            this.t0.b(intent, this.r1);
            if (uri != null) {
                if (StringUtils.isNull(this.b)) {
                    this.b = uri.getQueryParameter("thread_id");
                }
                if (StringUtils.isNull(this.O0)) {
                    this.O0 = uri.getQueryParameter("key_ori_ugc_nid");
                }
                if (StringUtils.isNull(this.P0)) {
                    this.P0 = uri.getQueryParameter("key_ori_ugc_tid");
                }
                if (this.Q0 == 0) {
                    this.Q0 = wg.e(uri.getQueryParameter("key_ori_ugc_type"), 0);
                }
                if (StringUtils.isNull(this.R0)) {
                    this.R0 = uri.getQueryParameter("key_ori_ugc_vid");
                }
            }
        }
        String str2 = "0";
        if (wi.isEmpty(this.b)) {
            this.b = "0";
        }
        int intExtra = intent.getIntExtra("key_start_from", 0);
        this.C0 = intExtra;
        if (intExtra == 0) {
            this.C0 = this.t0.a;
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
            intExtra2 = ky4.k().l("key_pb_current_sort_type", 2);
        }
        this.m = intExtra2;
        if (intExtra2 != 2) {
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
        this.q0 = intent.getBooleanExtra("from_smart_frs", false);
        this.M = intent.getBooleanExtra("from_hottopic", false);
        this.w0 = intent.getStringExtra("KEY_POST_THREAD_TIP");
        this.I0 = intent.getBooleanExtra("key_is_share_thread", false);
        this.g = intent.getStringExtra("high_light_post_id");
        this.h = intent.getStringExtra(PbCommentFloatActivityConfig.KEY_HIGH_LIGHT_3S_POST_ID);
        this.N0 = intent.getBooleanExtra("key_need_preload", false);
        if (intent.getIntExtra("request_code", -1) != 18003) {
            z = false;
        }
        this.W = z;
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
        if (this.C0 == 17) {
            this.mTopicId = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_ID);
            this.mTopicSubjectName = intent.getStringExtra(PbActivityConfig.KEY_HOTTOPIC_DETAIL_SUBJECT_NAME);
        }
    }

    public final void p3(String str, boolean z, String str2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048717, this, new Object[]{str, Boolean.valueOf(z), str2, Integer.valueOf(i)}) == null) {
            PbPageReadLocalRequestMessage pbPageReadLocalRequestMessage = new PbPageReadLocalRequestMessage();
            pbPageReadLocalRequestMessage.setCacheKey(str);
            pbPageReadLocalRequestMessage.setMarkCache(z);
            pbPageReadLocalRequestMessage.setPostId(str2);
            pbPageReadLocalRequestMessage.setUpdateType(i);
            sendMessage(pbPageReadLocalRequestMessage);
        }
    }
}
