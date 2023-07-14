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
public class ze9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public z35 A;
    public ti9 B;
    public List<MuteUser> C;
    public a45 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<xca> G;
    public xca H;
    public TwzhiboAnti I;
    public List<v45> J;
    public tf9 K;
    public yca L;
    public gf9 M;
    public long N;
    public JumpLinkInfo O;
    public pf9 P;
    public String Q;
    public String R;
    public HashSet<String> S;

    /* renamed from: T  reason: collision with root package name */
    public List<k25> f1190T;
    public int U;
    public yca V;
    public boolean W;
    public yca X;
    public int Y;
    public boolean Z;
    public final UserData a;
    public int a0;
    public String b;
    public List<xca> b0;
    public CardHListViewData c;
    public ki9 c0;
    public int d;
    public String d0;
    public int e;
    public String e0;
    public List<PbSortType> f;
    public List<ThreadInfo> f0;
    public int g;
    public ForumRuleStatus g0;
    public kf9 h;
    public BusinessAccountData h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public boolean k0;
    public we9 l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public hd5 n0;
    public v45 o;
    public int o0;
    public ThreadData p;
    public List<yn> p0;
    public ArrayList<yca> q;
    public SimilarContent q0;
    public yca r;
    public boolean r0;
    public HashMap<String, MetaData> s;
    public w35 t;
    public AntiData u;
    public ci5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public ze9() {
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
        this.o = new v45();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new w35();
        this.u = new AntiData();
        this.v = new ci5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new z35();
        this.D = new a45();
        this.B = new ti9();
        this.I = new TwzhiboAnti();
        this.K = new tf9();
        this.c0 = new ki9();
        this.S = new HashSet<>();
        this.n0 = new hd5();
    }

    public gf9 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.M;
        }
        return (gf9) invokeV.objValue;
    }

    public ki9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            ki9 ki9Var = this.c0;
            if (ki9Var != null && ki9Var.isValid()) {
                return this.c0;
            }
            return null;
        }
        return (ki9) invokeV.objValue;
    }

    public ti9 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.B;
        }
        return (ti9) invokeV.objValue;
    }

    public a45 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.D;
        }
        return (a45) invokeV.objValue;
    }

    public ArrayList<yca> F() {
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

    public List<yn> Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.p0;
        }
        return (List) invokeV.objValue;
    }

    public pf9 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.P;
        }
        return (pf9) invokeV.objValue;
    }

    public tf9 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.K;
        }
        return (tf9) invokeV.objValue;
    }

    public yca T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.r;
        }
        return (yca) invokeV.objValue;
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

    public yca X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.L;
        }
        return (yca) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public List<xca> Z() {
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

    public hd5 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.n0;
        }
        return (hd5) invokeV.objValue;
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
            w35 w35Var = this.t;
            if (w35Var != null && w35Var.b() == 1) {
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

    public ArrayList<xca> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<k25> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.f1190T;
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

    public v45 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.o;
        }
        return (v45) invokeV.objValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.r0;
        }
        return invokeV.booleanValue;
    }

    public yca h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.X;
        }
        return (yca) invokeV.objValue;
    }

    public yca i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.V;
        }
        return (yca) invokeV.objValue;
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

    public List<v45> o() {
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
            ArrayList<yca> arrayList = this.q;
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

    public w35 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.t;
        }
        return (w35) invokeV.objValue;
    }

    public xca z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.H;
        }
        return (xca) invokeV.objValue;
    }

    public final void A0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.b0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    xca xcaVar = new xca();
                    xcaVar.n1 = w0();
                    xcaVar.E1(app);
                    if (!this.b0.contains(xcaVar)) {
                        this.b0.add(xcaVar);
                    }
                }
            }
        }
    }

    public void B0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            hd5 hd5Var = this.n0;
            hd5Var.b = floatingIconItem.icon_url;
            hd5Var.c = floatingIconItem.fold_lottie;
            hd5Var.d = floatingIconItem.unfold_lottie;
            hd5Var.e = floatingIconItem.float_type;
            hd5Var.f = floatingIconItem.fold_name;
            hd5Var.g = floatingIconItem.unfold_name;
            hd5Var.a = floatingIconItem.url;
            hd5Var.j = floatingIconItem.scheme;
            hd5Var.k = floatingIconItem.package_name;
            hd5Var.l = floatingIconItem.deeplink;
            hd5Var.h = floatingIconItem.view_statistics_url;
            hd5Var.i = floatingIconItem.click_statistics_url;
            hd5Var.r = floatingIconItem.display_ad_icon;
        }
    }

    public final void c0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048626, this, dataRes) == null) {
            this.P = new pf9(this.p, this.u);
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
                this.h = kf9.i(managerElection);
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
            f0a.e().h(dataRes.asp_shown_info);
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
            yca ycaVar = new yca();
            this.V = ycaVar;
            ycaVar.S0(1);
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
            List<AdvertAppInfo> g = uy9.m().g();
            if (g != null) {
                g.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                z0(dataRes);
                for (App app : list2) {
                    xca xcaVar = new xca();
                    xcaVar.n1 = w0();
                    xcaVar.E1(app);
                    if (!this.G.contains(xcaVar)) {
                        this.G.add(xcaVar);
                        if (g != null) {
                            g.add(xcaVar.getAdvertAppInfo());
                        }
                    }
                }
                A0(dataRes);
            }
            uy9.m().f();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            if (dataRes.forum_headline_img_info != null) {
                gf9 gf9Var = new gf9();
                this.M = gf9Var;
                gf9Var.b(dataRes.forum_headline_img_info);
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
                        v45 v45Var = new v45();
                        v45Var.l(simpleForum);
                        this.J.add(v45Var);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            c0(dataRes);
            if (this.f1190T == null) {
                this.f1190T = new ArrayList();
            }
            this.f1190T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !u0(threadInfo) && !h0(threadInfo)) {
                        k25 k25Var = new k25();
                        k25Var.g(i4);
                        k25Var.parserProtobuf(threadInfo);
                        this.f1190T.add(k25Var);
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
                    xe9 xe9Var = new xe9();
                    xe9Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new we9();
                    }
                    this.l.a(xe9Var);
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

    public void E0(v45 v45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, v45Var) == null) {
            this.o = v45Var;
        }
    }

    public void F0(yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, ycaVar) == null) {
            this.V = ycaVar;
            this.X = ycaVar;
            this.W = false;
        }
    }

    public void G0(yca ycaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ycaVar) == null) {
            this.X = ycaVar;
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

    public void L0(xca xcaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, xcaVar) == null) {
            this.H = xcaVar;
        }
    }

    public void M0(pf9 pf9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, pf9Var) == null) {
            this.P = pf9Var;
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

    public void Q0(List<yn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, list) == null) {
            this.p0 = list;
        }
    }

    public yca R0(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, ycaVar)) == null) {
            this.L = ycaVar;
            return ycaVar;
        }
        return (yca) invokeL.objValue;
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
            xca xcaVar = new xca();
            xcaVar.h1 = true;
            xcaVar.E1(dataRes.banner_list.pb_banner_ad);
            this.H = xcaVar;
        }
    }

    public final yca E() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (N() != null && N().getAuthor() != null) {
                yca ycaVar = new yca();
                MetaData author = N().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = N().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                ycaVar.S0(1);
                ycaVar.Y0(N().getFirstPostId());
                ycaVar.p1(N().getTitle());
                ycaVar.o1(N().getCreateTime());
                ycaVar.N0(author);
                return ycaVar;
            }
            return null;
        }
        return (yca) invokeV.objValue;
    }

    public yca W() {
        InterceptResult invokeV;
        yca ycaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (X() != null) {
                return X();
            }
            if (!ListUtils.isEmpty(F())) {
                Iterator<yca> it = F().iterator();
                while (it.hasNext()) {
                    ycaVar = it.next();
                    if (ycaVar != null && ycaVar.I() == 1) {
                        break;
                    }
                }
            }
            ycaVar = null;
            if (ycaVar == null) {
                ycaVar = i();
            }
            if (!k0(ycaVar)) {
                ycaVar = E();
            }
            if (ycaVar != null && ycaVar.q() != null && ycaVar.q().getUserTbVipInfoData() != null && ycaVar.q().getUserTbVipInfoData().getvipIntro() != null) {
                ycaVar.q().getGodUserData().setIntro(ycaVar.q().getUserTbVipInfoData().getvipIntro());
            }
            return ycaVar;
        }
        return (yca) invokeV.objValue;
    }

    public void K0(w35 w35Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048597, this, w35Var, i) == null) {
            this.t.k(w35Var.a());
            this.t.p(w35Var.g());
            this.t.q(w35Var.h());
            this.t.o(w35Var.e());
            this.t.n(w35Var.d());
            if (i == 0) {
                this.t = w35Var;
            } else if (i == 1) {
                this.t.l(w35Var.b());
            } else if (i == 2) {
                this.t.m(w35Var.c());
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
                if (N() != null && N().getAuthor() != null && !xi.isEmpty(N().getAuthor().getUserId())) {
                    String userId = N().getAuthor().getUserId();
                    yca h = h();
                    if (h == null || h.q() == null || xi.isEmpty(h.q().getUserId())) {
                        str2 = "";
                    } else {
                        if (!StringHelper.equals(userId, h.q().getUserId())) {
                            str2 = "";
                        } else {
                            str2 = h.H();
                        }
                        if (xi.isEmpty("")) {
                            str4 = h.m0();
                        }
                    }
                    if (xi.isEmpty(str4) && xi.isEmpty(str2)) {
                        for (int i = 0; i < min; i++) {
                            yca ycaVar = (yca) ListUtils.getItem(this.q, i);
                            if (ycaVar != null && ycaVar.q() != null && !xi.isEmpty(ycaVar.q().getUserId()) && StringHelper.equals(userId, ycaVar.q().getUserId())) {
                                if (xi.isEmpty(str2)) {
                                    str2 = ycaVar.H();
                                }
                                if (xi.isEmpty(str4)) {
                                    str4 = ycaVar.m0();
                                }
                                if (!xi.isEmpty(str2) && !xi.isEmpty(str4)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && xi.isEmpty(str2)) {
                        str2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str4 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str4;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !xi.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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
                    yca ycaVar = new yca();
                    ycaVar.r1(this.s);
                    ycaVar.V0(this.n.isBrandForum);
                    ycaVar.I0(post, N());
                    ycaVar.j1(N().getPraise());
                    SimpleForum simpleForum = dataRes.forum;
                    if (simpleForum != null) {
                        ycaVar.T0(simpleForum.id.longValue());
                        ycaVar.U0(dataRes.forum.name);
                    }
                    if (ycaVar.o() != null && ycaVar.o().baijiahaoData == null && N() != null && N().getBaijiahaoData() != null) {
                        ycaVar.o().baijiahaoData = N().getBaijiahaoData();
                    }
                    this.S.add(ycaVar.S());
                    if (ycaVar.I() == 1 && this.p.isActInfo()) {
                        if (r0()) {
                            ycaVar.i1(0);
                        } else {
                            ycaVar.i1(this.p.getActInfoType());
                        }
                    } else if (ycaVar.I() == 1 && this.p.isInterviewLive()) {
                        ycaVar.i1(41);
                    } else if (ycaVar.I() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        ycaVar.i1(0);
                        ycaVar.t0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            ycaVar.k1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                            ycaVar.k1(TbRichTextView.Z(jSONArray, false));
                        }
                        this.L = ycaVar;
                    }
                    if (ycaVar.I() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        ycaVar.h1(threadData2.originalThreadData);
                    }
                    if (ycaVar.I() == 1) {
                        this.X = ycaVar;
                        this.W = false;
                        if (ycaVar.q() != null && this.h0 != null) {
                            ycaVar.q().setBusinessAccountData(this.h0);
                        }
                    }
                    ycaVar.s1(post);
                    ycaVar.e1(post.agree.lz_agree.intValue());
                    this.q.add(ycaVar);
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
            yca ycaVar = new yca();
            ycaVar.r1(this.s);
            ycaVar.V0(this.n.isBrandForum);
            ycaVar.I0(post, N());
            ycaVar.j1(N().getPraise());
            ycaVar.T0(dataRes.forum.id.longValue());
            ycaVar.U0(dataRes.forum.name);
            if (ycaVar.o() != null && ycaVar.o().baijiahaoData == null && N() != null && N().getBaijiahaoData() != null) {
                ycaVar.o().baijiahaoData = N().getBaijiahaoData();
            }
            this.S.add(ycaVar.S());
            if (ycaVar.I() == 1 && this.p.isActInfo()) {
                if (r0()) {
                    ycaVar.i1(0);
                } else {
                    ycaVar.i1(this.p.getActInfoType());
                }
            } else if (ycaVar.I() == 1 && this.p.isInterviewLive()) {
                ycaVar.i1(41);
            } else if (ycaVar.I() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                ycaVar.i1(0);
                ycaVar.t0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    ycaVar.k1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    ycaVar.k1(TbRichTextView.Z(jSONArray, false));
                }
                this.L = ycaVar;
            }
            if (ycaVar.I() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                ycaVar.h1(threadData2.originalThreadData);
            }
            if (ycaVar.I() == 1) {
                this.X = ycaVar;
                this.W = false;
                if (ycaVar.q() != null && this.h0 != null) {
                    ycaVar.q().setBusinessAccountData(this.h0);
                }
            }
            ycaVar.s1(post);
            ycaVar.e1(post.agree.lz_agree.intValue());
            this.r = ycaVar;
        }
    }

    public final boolean k0(yca ycaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048642, this, ycaVar)) == null) {
            if (ycaVar == null || ycaVar.q() == null) {
                return false;
            }
            MetaData q = ycaVar.q();
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
