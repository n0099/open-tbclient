package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.TwzhiboAnti;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.BusinessAccountData;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.usermute.MuteUser;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AlaLiveInfo;
import tbclient.App;
import tbclient.Baijiahao;
import tbclient.ForumRuleStatus;
import tbclient.JumpLinkInfo;
import tbclient.ManagerElection;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.FloatingIcon;
import tbclient.PbPage.FloatingIconItem;
import tbclient.PbPage.PbSortType;
import tbclient.PbPage.SimilarContent;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class u89 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public r35 A;
    public oc9 B;
    public List<MuteUser> C;
    public s35 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<m4a> G;
    public m4a H;
    public TwzhiboAnti I;
    public List<n45> J;
    public o99 K;
    public n4a L;
    public b99 M;
    public long N;
    public JumpLinkInfo O;
    public k99 P;
    public String Q;
    public String R;
    public HashSet<String> S;

    /* renamed from: T  reason: collision with root package name */
    public List<c25> f1162T;
    public int U;
    public n4a V;
    public boolean W;
    public n4a X;
    public int Y;
    public boolean Z;
    public final UserData a;
    public int a0;
    public String b;
    public List<m4a> b0;
    public CardHListViewData c;
    public fc9 c0;
    public int d;
    public String d0;
    public int e;
    public String e0;
    public List<PbSortType> f;
    public List<ThreadInfo> f0;
    public int g;
    public ForumRuleStatus g0;
    public f99 h;
    public BusinessAccountData h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public boolean k0;
    public r89 l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public pc5 n0;
    public n45 o;
    public int o0;
    public ThreadData p;
    public List<xn> p0;
    public ArrayList<n4a> q;
    public SimilarContent q0;
    public n4a r;
    public boolean r0;
    public HashMap<String, MetaData> s;
    public o35 t;
    public AntiData u;
    public fh5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public u89() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.i = false;
        this.j = false;
        this.k = false;
        this.m = false;
        this.x = 0;
        this.G = new ArrayList<>();
        this.H = null;
        this.I = null;
        this.U = 0;
        this.W = true;
        this.Y = 0;
        this.a0 = 0;
        this.b0 = new ArrayList();
        this.j0 = 0;
        this.o0 = 0;
        this.r0 = false;
        this.n = new ForumData();
        this.o = new n45();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new o35();
        this.u = new AntiData();
        this.v = new fh5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new r35();
        this.D = new s35();
        this.B = new oc9();
        this.I = new TwzhiboAnti();
        this.K = new o99();
        this.c0 = new fc9();
        this.S = new HashSet<>();
        this.n0 = new pc5();
    }

    public b99 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.M;
        }
        return (b99) invokeV.objValue;
    }

    public fc9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            fc9 fc9Var = this.c0;
            if (fc9Var != null && fc9Var.isValid()) {
                return this.c0;
            }
            return null;
        }
        return (fc9) invokeV.objValue;
    }

    public oc9 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.B;
        }
        return (oc9) invokeV.objValue;
    }

    public s35 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.D;
        }
        return (s35) invokeV.objValue;
    }

    public ArrayList<n4a> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.j0;
        }
        return invokeV.intValue;
    }

    public List<ThreadInfo> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.f0;
        }
        return (List) invokeV.objValue;
    }

    public AlaLiveInfoCoreData I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.F;
        }
        return (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            AntiData antiData = this.u;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public String[] K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return L(true);
        }
        return (String[]) invokeV.objValue;
    }

    public SimilarContent M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.q0;
        }
        return (SimilarContent) invokeV.objValue;
    }

    public ThreadData N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    public long O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.N;
        }
        return invokeV.longValue;
    }

    public String P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<xn> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.p0;
        }
        return (List) invokeV.objValue;
    }

    public k99 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.P;
        }
        return (k99) invokeV.objValue;
    }

    public o99 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.K;
        }
        return (o99) invokeV.objValue;
    }

    public n4a T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.r;
        }
        return (n4a) invokeV.objValue;
    }

    public UserData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public int V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public n4a X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.L;
        }
        return (n4a) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public List<m4a> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.b0;
        }
        return (List) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            this.c0 = null;
        }
    }

    public pc5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.n0;
        }
        return (pc5) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            o35 o35Var = this.t;
            if (o35Var != null && o35Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public ArrayList<m4a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<c25> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.f1162T;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.U;
        }
        return invokeV.intValue;
    }

    public n45 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.o;
        }
        return (n45) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public n4a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.X;
        }
        return (n4a) invokeV.objValue;
    }

    public n4a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.V;
        }
        return (n4a) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            if (N() != null && N().isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public ForumData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            if (r() == 1 || i0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumRuleStatus n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.g0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            if (N() != null && N().isLongNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<n45> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.J;
        }
        return (List) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            if (N() != null && N().isNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.k0;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (this.p.getIsMarked() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.m0;
        }
        return invokeV.booleanValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.o0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public JumpLinkInfo t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.O;
        }
        return (JumpLinkInfo) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getMarkID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            ArrayList<n4a> arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            if (N() != null && N().isVideoThreadType() && N().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            if (N() != null && N().worksInfoData != null && N().worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public o35 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.t;
        }
        return (o35) invokeV.objValue;
    }

    public m4a z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.H;
        }
        return (m4a) invokeV.objValue;
    }

    public final void A0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.b0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    m4a m4aVar = new m4a();
                    m4aVar.n1 = w0();
                    m4aVar.E1(app);
                    if (!this.b0.contains(m4aVar)) {
                        this.b0.add(m4aVar);
                    }
                }
            }
        }
    }

    public void B0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            pc5 pc5Var = this.n0;
            pc5Var.b = floatingIconItem.icon_url;
            pc5Var.c = floatingIconItem.fold_lottie;
            pc5Var.d = floatingIconItem.unfold_lottie;
            pc5Var.e = floatingIconItem.float_type;
            pc5Var.f = floatingIconItem.fold_name;
            pc5Var.g = floatingIconItem.unfold_name;
            pc5Var.a = floatingIconItem.url;
            pc5Var.j = floatingIconItem.scheme;
            pc5Var.k = floatingIconItem.package_name;
            pc5Var.l = floatingIconItem.deeplink;
            pc5Var.h = floatingIconItem.view_statistics_url;
            pc5Var.i = floatingIconItem.click_statistics_url;
            pc5Var.r = floatingIconItem.display_ad_icon;
        }
    }

    public final void c0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, dataRes) == null) {
            this.P = new k99(this.p, this.u);
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            this.F = alaLiveInfoCoreData;
            AlaLiveInfo alaLiveInfo = dataRes.ala_info;
            if (alaLiveInfo != null) {
                alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
            }
            this.Q = dataRes.fold_tip;
            this.d = dataRes.exp_news_today.intValue();
            this.e = dataRes.exp_guide_today.intValue();
            this.f = dataRes.pb_sort_info;
            this.g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.h = f99.i(managerElection);
            }
        }
    }

    public final void e0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048630, this, dataRes) == null) && (list = dataRes.feed_thread_list) != null && list.size() > 0) {
            List<ThreadInfo> list2 = dataRes.feed_thread_list;
            if (this.E == null) {
                this.E = new ArrayList();
            }
            this.E.clear();
            for (ThreadInfo threadInfo : list2) {
                if (threadInfo != null) {
                    ThreadData threadData = new ThreadData();
                    threadData.parserProtobuf(threadInfo);
                    this.E.add(threadData);
                }
            }
            List<ThreadData> list3 = this.E;
            if (list3 != null && list3.size() > 15) {
                this.E = ListUtils.subList(this.E, 0, 15);
            }
        }
    }

    public final boolean h0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048636, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (threadData = this.p) == null || threadData.getBaijiahaoData() == null || this.p.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.getBaijiahaoData().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public final boolean u0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048662, this, threadInfo)) == null) {
            if (threadInfo == null || P() == null || threadInfo.id.longValue() == 0 || threadInfo.tid.longValue() == 0) {
                return false;
            }
            if (!P().equals(threadInfo.id.toString()) && !P().equals(threadInfo.tid.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void C0(DataRes dataRes) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.jump_link_info != null) {
                this.O = dataRes.jump_link_info;
            }
            xt9.e().h(dataRes.asp_shown_info);
            List<User> list = dataRes.user_list;
            boolean z7 = false;
            if (list != null) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i2));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.s.put(metaData.getUserId(), metaData);
                    }
                    if (i2 == 0) {
                        this.h0 = metaData.getBusinessAccountData();
                    }
                }
            }
            I0(dataRes.is_new_url.intValue());
            y0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.l(dataRes.display_forum);
            this.p.setUserMap(this.s);
            this.p.parserProtobuf(dataRes.thread);
            if (this.p.getFid() == 0 && dataRes.forum != null) {
                this.p.setFid(dataRes.forum.id.longValue());
            }
            if (this.p.getAuthor() != null && this.p.getAuthor().getBusinessAccountData() == null) {
                this.p.getAuthor().setBusinessAccountData(this.h0);
            }
            this.A.a(dataRes.news_info);
            int i3 = this.A.c;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.B.h1 = this.A;
                    } else {
                        this.B.i1 = this.A;
                    }
                } else {
                    this.B.h1 = this.A;
                }
            } else {
                this.B.g1 = this.A;
            }
            this.D.A1(dataRes.recommend_book);
            d0(dataRes);
            f0(dataRes);
            n4a n4aVar = new n4a();
            this.V = n4aVar;
            n4aVar.S0(1);
            this.V.r1(this.s);
            this.V.V0(this.n.isBrandForum);
            this.V.o1(this.p.getCreateTime());
            if (dataRes.forum != null) {
                this.V.T0(dataRes.forum.id.longValue());
                this.V.U0(dataRes.forum.name);
            }
            if (dataRes.first_floor_post != null) {
                this.V.H0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.V.h1(this.p.originalThreadData);
            }
            if (this.X == null) {
                this.X = this.V;
                this.W = true;
            }
            this.t.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.r0 = true;
            }
            this.u.parserProtobuf(dataRes.anti);
            this.v.c(dataRes.location);
            if (dataRes.user != null) {
                this.w = dataRes.user.is_manager.intValue();
            }
            this.a.parserProtobuf(dataRes.user);
            if (dataRes.user != null && dataRes.user.mute_user != null) {
                for (SimpleUser simpleUser : dataRes.user.mute_user) {
                    if (simpleUser != null) {
                        MuteUser muteUser = new MuteUser();
                        muteUser.parserProtobuf(simpleUser);
                        this.C.add(muteUser);
                    }
                }
            }
            ThreadData threadData = this.p;
            if (this.p.getReply_num() > 0) {
                i = this.p.getReply_num() - 1;
            } else {
                i = 0;
            }
            threadData.setReply_num(i);
            List<AdvertAppInfo> f = ns9.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                z0(dataRes);
                for (App app : list2) {
                    m4a m4aVar = new m4a();
                    m4aVar.n1 = w0();
                    m4aVar.E1(app);
                    if (!this.G.contains(m4aVar)) {
                        this.G.add(m4aVar);
                        if (f != null) {
                            f.add(m4aVar.getAdvertAppInfo());
                        }
                    }
                }
                A0(dataRes);
            }
            ns9.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            if (dataRes.forum_headline_img_info != null) {
                b99 b99Var = new b99();
                this.M = b99Var;
                b99Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            e0(dataRes);
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.from_forum_list) {
                    if (simpleForum != null) {
                        n45 n45Var = new n45();
                        n45Var.l(simpleForum);
                        this.J.add(n45Var);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            c0(dataRes);
            if (this.f1162T == null) {
                this.f1162T = new ArrayList();
            }
            this.f1162T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !u0(threadInfo) && !h0(threadInfo)) {
                        c25 c25Var = new c25();
                        c25Var.h(i4);
                        c25Var.parserProtobuf(threadInfo);
                        this.f1162T.add(c25Var);
                        i4++;
                    }
                }
            }
            if (dataRes.business_promot_info != null) {
                if (dataRes.business_promot_info.is_promot.longValue() == 1) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                this.i = z4;
                if (dataRes.business_promot_info.is_headlinepost.intValue() == 1) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                this.j = z5;
                if (dataRes.business_promot_info.is_s_card.intValue() == 1) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                this.k = z6;
                if (dataRes.business_promot_info.send_card_info != null) {
                    s89 s89Var = new s89();
                    s89Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new r89();
                    }
                    this.l.a(s89Var);
                }
            }
            this.c0.b();
            this.c0.c(this.s);
            this.c0.a(dataRes.recom_ala_info);
            if (this.c0.o != null) {
                this.c0.o.o(P());
            }
            if (ListUtils.getCount(dataRes.recom_thread_info) > 0) {
                this.f0 = dataRes.recom_thread_info;
            }
            if (dataRes.jumptotab1 != null) {
                str = dataRes.jumptotab1.toString();
            }
            this.d0 = str;
            this.e0 = dataRes.jumptotab2;
            if (dataRes.forum_rule != null) {
                this.g0 = dataRes.forum_rule;
            }
            if (dataRes.is_black_white.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.i0 = z;
            if (dataRes.is_official_forum.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.k0 = z2;
            if (dataRes.show_adsense.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.l0 = z3;
            if (dataRes.is_purchase.intValue() == 1) {
                z7 = true;
            }
            this.m0 = z7;
            B0(dataRes.floating_icon);
            this.o0 = dataRes.has_fold_comment.intValue();
            this.q0 = dataRes.similar_content;
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void D0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.U = i;
        }
    }

    public void E0(n45 n45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, n45Var) == null) {
            this.o = n45Var;
        }
    }

    public void F0(n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, n4aVar) == null) {
            this.V = n4aVar;
            this.X = n4aVar;
            this.W = false;
        }
    }

    public void G0(n4a n4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, n4aVar) == null) {
            this.X = n4aVar;
        }
    }

    public void H0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048591, this, z) != null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public void I0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.x = i;
        }
    }

    public void J0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048595, this, str) == null) && (threadData = this.p) != null) {
            threadData.setMarkID(str);
        }
    }

    public void L0(m4a m4aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, m4aVar) == null) {
            this.H = m4aVar;
        }
    }

    public void M0(k99 k99Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, k99Var) == null) {
            this.P = k99Var;
        }
    }

    public void N0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            this.j0 = i;
        }
    }

    public void O0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048605, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void P0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void Q0(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            this.p0 = list;
        }
    }

    public n4a R0(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, n4aVar)) == null) {
            this.L = n4aVar;
            return n4aVar;
        }
        return (n4a) invokeL.objValue;
    }

    public void S0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.b = str;
        }
    }

    public boolean t0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048660, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void y0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048670, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    public final void z0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048672, this, dataRes) == null) {
            m4a m4aVar = new m4a();
            m4aVar.h1 = true;
            m4aVar.E1(dataRes.banner_list.pb_banner_ad);
            this.H = m4aVar;
        }
    }

    public final n4a E() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (N() != null && N().getAuthor() != null) {
                n4a n4aVar = new n4a();
                MetaData author = N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                n4aVar.S0(1);
                n4aVar.Y0(N().getFirstPostId());
                n4aVar.p1(N().getTitle());
                n4aVar.o1(N().getCreateTime());
                n4aVar.N0(author);
                return n4aVar;
            }
            return null;
        }
        return (n4a) invokeV.objValue;
    }

    public n4a W() {
        InterceptResult invokeV;
        n4a n4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (X() != null) {
                return X();
            }
            if (!ListUtils.isEmpty(F())) {
                Iterator<n4a> it = F().iterator();
                while (it.hasNext()) {
                    n4aVar = it.next();
                    if (n4aVar != null && n4aVar.I() == 1) {
                        break;
                    }
                }
            }
            n4aVar = null;
            if (n4aVar == null) {
                n4aVar = i();
            }
            if (!k0(n4aVar)) {
                n4aVar = E();
            }
            if (n4aVar != null && n4aVar.q() != null && n4aVar.q().getUserTbVipInfoData() != null && n4aVar.q().getUserTbVipInfoData().getvipIntro() != null) {
                n4aVar.q().getGodUserData().setIntro(n4aVar.q().getUserTbVipInfoData().getvipIntro());
            }
            return n4aVar;
        }
        return (n4a) invokeV.objValue;
    }

    public void K0(o35 o35Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, o35Var, i) == null) {
            this.t.k(o35Var.a());
            this.t.p(o35Var.g());
            this.t.q(o35Var.h());
            this.t.o(o35Var.e());
            this.t.n(o35Var.d());
            if (i == 0) {
                this.t = o35Var;
            } else if (i == 1) {
                this.t.l(o35Var.b());
            } else if (i == 2) {
                this.t.m(o35Var.c());
            }
        }
    }

    public String[] L(boolean z) {
        InterceptResult invokeZ;
        String str;
        String str2;
        String str3;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048598, this, z)) == null) {
            String str4 = "";
            if (!v0()) {
                str = "";
            } else {
                int min = Math.min(this.q.size(), 30);
                if (N() != null && N().getAuthor() != null && !wi.isEmpty(N().getAuthor().getUserId())) {
                    String userId = N().getAuthor().getUserId();
                    n4a h = h();
                    if (h == null || h.q() == null || wi.isEmpty(h.q().getUserId())) {
                        str2 = "";
                    } else {
                        if (!StringHelper.equals(userId, h.q().getUserId())) {
                            str2 = "";
                        } else {
                            str2 = h.H();
                        }
                        if (wi.isEmpty("")) {
                            str4 = h.m0();
                        }
                    }
                    if (wi.isEmpty(str4) && wi.isEmpty(str2)) {
                        for (int i = 0; i < min; i++) {
                            n4a n4aVar = (n4a) ListUtils.getItem(this.q, i);
                            if (n4aVar != null && n4aVar.q() != null && !wi.isEmpty(n4aVar.q().getUserId()) && StringHelper.equals(userId, n4aVar.q().getUserId())) {
                                if (wi.isEmpty(str2)) {
                                    str2 = n4aVar.H();
                                }
                                if (wi.isEmpty(str4)) {
                                    str4 = n4aVar.m0();
                                }
                                if (!wi.isEmpty(str2) && !wi.isEmpty(str4)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && wi.isEmpty(str2)) {
                        str2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str4 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str4;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !wi.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
                        str3 = this.p.getThreadVideoInfo().thumbnail_url;
                    } else {
                        str3 = str2;
                    }
                    ThreadData threadData3 = this.p;
                    if (threadData3 != null && !threadData3.isShareThread && str3 == null && (originalThreadInfo = threadData3.originalThreadData) != null && (arrayList = originalThreadInfo.h) != null) {
                        int size = arrayList.size();
                        int i2 = 0;
                        while (true) {
                            if (i2 >= size) {
                                break;
                            }
                            MediaData mediaData = arrayList.get(i2);
                            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                                    str3 = mediaData.getThumbnails_url();
                                    break;
                                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                                    str3 = mediaData.getPicUrl();
                                    break;
                                }
                            }
                            i2++;
                        }
                    }
                    String str5 = str4;
                    str4 = str3;
                    str = str5;
                } else {
                    return new String[]{"", ""};
                }
            }
            return new String[]{str4, str};
        }
        return (String[]) invokeZ.objValue;
    }

    public final void d0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048628, this, dataRes) == null) && dataRes != null && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.S.contains(String.valueOf(post.id))) {
                    n4a n4aVar = new n4a();
                    n4aVar.r1(this.s);
                    n4aVar.V0(this.n.isBrandForum);
                    n4aVar.I0(post, N());
                    n4aVar.j1(N().getPraise());
                    SimpleForum simpleForum = dataRes.forum;
                    if (simpleForum != null) {
                        n4aVar.T0(simpleForum.id.longValue());
                        n4aVar.U0(dataRes.forum.name);
                    }
                    if (n4aVar.o() != null && n4aVar.o().baijiahaoData == null && N() != null && N().getBaijiahaoData() != null) {
                        n4aVar.o().baijiahaoData = N().getBaijiahaoData();
                    }
                    this.S.add(n4aVar.S());
                    if (n4aVar.I() == 1 && this.p.isActInfo()) {
                        if (r0()) {
                            n4aVar.i1(0);
                        } else {
                            n4aVar.i1(this.p.getActInfoType());
                        }
                    } else if (n4aVar.I() == 1 && this.p.isInterviewLive()) {
                        n4aVar.i1(41);
                    } else if (n4aVar.I() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        n4aVar.i1(0);
                        n4aVar.t0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            n4aVar.k1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
                        } else {
                            JSONArray jSONArray = new JSONArray();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("type", 0);
                                jSONObject.put("text", "");
                                jSONArray.put(jSONObject);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            n4aVar.k1(TbRichTextView.Z(jSONArray, false));
                        }
                        this.L = n4aVar;
                    }
                    if (n4aVar.I() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        n4aVar.h1(threadData2.originalThreadData);
                    }
                    if (n4aVar.I() == 1) {
                        this.X = n4aVar;
                        this.W = false;
                        if (n4aVar.q() != null && this.h0 != null) {
                            n4aVar.q().setBusinessAccountData(this.h0);
                        }
                    }
                    n4aVar.s1(post);
                    n4aVar.e1(post.agree.lz_agree.intValue());
                    this.q.add(n4aVar);
                }
            }
        }
    }

    public final void f0(DataRes dataRes) {
        Post post;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, dataRes) == null) && (post = dataRes.top_answer) != null && !this.S.contains(String.valueOf(post.id))) {
            n4a n4aVar = new n4a();
            n4aVar.r1(this.s);
            n4aVar.V0(this.n.isBrandForum);
            n4aVar.I0(post, N());
            n4aVar.j1(N().getPraise());
            n4aVar.T0(dataRes.forum.id.longValue());
            n4aVar.U0(dataRes.forum.name);
            if (n4aVar.o() != null && n4aVar.o().baijiahaoData == null && N() != null && N().getBaijiahaoData() != null) {
                n4aVar.o().baijiahaoData = N().getBaijiahaoData();
            }
            this.S.add(n4aVar.S());
            if (n4aVar.I() == 1 && this.p.isActInfo()) {
                if (r0()) {
                    n4aVar.i1(0);
                } else {
                    n4aVar.i1(this.p.getActInfoType());
                }
            } else if (n4aVar.I() == 1 && this.p.isInterviewLive()) {
                n4aVar.i1(41);
            } else if (n4aVar.I() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                n4aVar.i1(0);
                n4aVar.t0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    n4aVar.k1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
                } else {
                    JSONArray jSONArray = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", 0);
                        jSONObject.put("text", "");
                        jSONArray.put(jSONObject);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    n4aVar.k1(TbRichTextView.Z(jSONArray, false));
                }
                this.L = n4aVar;
            }
            if (n4aVar.I() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                n4aVar.h1(threadData2.originalThreadData);
            }
            if (n4aVar.I() == 1) {
                this.X = n4aVar;
                this.W = false;
                if (n4aVar.q() != null && this.h0 != null) {
                    n4aVar.q().setBusinessAccountData(this.h0);
                }
            }
            n4aVar.s1(post);
            n4aVar.e1(post.agree.lz_agree.intValue());
            this.r = n4aVar;
        }
    }

    public final boolean k0(n4a n4aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, n4aVar)) == null) {
            if (n4aVar == null || n4aVar.q() == null) {
                return false;
            }
            MetaData q = n4aVar.q();
            if (TextUtils.isEmpty(q.getUserId()) && TextUtils.isEmpty(q.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
