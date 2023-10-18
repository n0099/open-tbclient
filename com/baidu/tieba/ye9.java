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
import com.baidu.tieba.recapp.localads.LocationCacheData;
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
import tbclient.ChatContent;
import tbclient.ForumRuleStatus;
import tbclient.JumpLinkInfo;
import tbclient.ManagerElection;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.FloatingIcon;
import tbclient.PbPage.FloatingIconItem;
import tbclient.PbPage.PbSortType;
import tbclient.PbPage.SimilarContent;
import tbclient.Post;
import tbclient.RobotEntrance;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class ye9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public px4 A;
    public oj9 B;
    public List<MuteUser> C;
    public qx4 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<oea> G;
    public oea H;
    public TwzhiboAnti I;
    public List<ly4> J;
    public sf9 K;
    public pea L;
    public ff9 M;
    public long N;
    public JumpLinkInfo O;
    public of9 P;
    public String Q;
    public String R;
    public HashSet<String> S;

    /* renamed from: T  reason: collision with root package name */
    public List<aw4> f1184T;
    public int U;
    public pea V;
    public boolean W;
    public pea X;
    public int Y;
    public boolean Z;
    public final UserData a;
    public int a0;
    public String b;
    public List<oea> b0;
    public CardHListViewData c;
    public fj9 c0;
    public int d;
    public String d0;
    public int e;
    public String e0;
    public List<PbSortType> f;
    public List<ThreadInfo> f0;
    public int g;
    public ForumRuleStatus g0;
    public jf9 h;
    public BusinessAccountData h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public boolean k0;
    public ve9 l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public y65 n0;
    public ly4 o;
    public int o0;
    public ThreadData p;
    public List<yh> p0;
    public ArrayList<pea> q;
    public SimilarContent q0;
    public pea r;
    public RobotEntrance r0;
    public HashMap<String, MetaData> s;
    public boolean s0;
    public mx4 t;
    public AntiData u;
    public yb5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public ye9() {
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
        this.s0 = false;
        this.n = new ForumData();
        this.o = new ly4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new mx4();
        this.u = new AntiData();
        this.v = new yb5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new px4();
        this.D = new qx4();
        this.B = new oj9();
        this.I = new TwzhiboAnti();
        this.K = new sf9();
        this.c0 = new fj9();
        this.S = new HashSet<>();
        this.n0 = new y65();
    }

    public ff9 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.M;
        }
        return (ff9) invokeV.objValue;
    }

    public fj9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            fj9 fj9Var = this.c0;
            if (fj9Var != null && fj9Var.isValid()) {
                return this.c0;
            }
            return null;
        }
        return (fj9) invokeV.objValue;
    }

    public oj9 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.B;
        }
        return (oj9) invokeV.objValue;
    }

    public qx4 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.D;
        }
        return (qx4) invokeV.objValue;
    }

    public ArrayList<pea> F() {
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

    public RobotEntrance K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.r0;
        }
        return (RobotEntrance) invokeV.objValue;
    }

    public String[] L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return M(true);
        }
        return (String[]) invokeV.objValue;
    }

    public SimilarContent N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.q0;
        }
        return (SimilarContent) invokeV.objValue;
    }

    public ThreadData O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.N;
        }
        return invokeV.longValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<yh> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.p0;
        }
        return (List) invokeV.objValue;
    }

    public of9 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.P;
        }
        return (of9) invokeV.objValue;
    }

    public sf9 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.K;
        }
        return (sf9) invokeV.objValue;
    }

    public pea U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.r;
        }
        return (pea) invokeV.objValue;
    }

    public UserData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public pea Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.L;
        }
        return (pea) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.c0 = null;
        }
    }

    public List<oea> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.b0;
        }
        return (List) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048626, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public y65 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.n0;
        }
        return (y65) invokeV.objValue;
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            mx4 mx4Var = this.t;
            if (mx4Var != null && mx4Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<oea> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<aw4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.f1184T;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.U;
        }
        return invokeV.intValue;
    }

    public ly4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.o;
        }
        return (ly4) invokeV.objValue;
    }

    public pea h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.X;
        }
        return (pea) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    public pea i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.V;
        }
        return (pea) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (O() != null && O().isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            if (r() == 1 || j0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumRuleStatus n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.g0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<ly4> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.J;
        }
        return (List) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (O() != null && O().isLongNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            if (O() != null && O().isNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.k0;
        }
        return invokeV.booleanValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.m0;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.o0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public JumpLinkInfo t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.O;
        }
        return (JumpLinkInfo) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            ArrayList<pea> arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (O() != null && O().isVideoThreadType() && O().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public mx4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.t;
        }
        return (mx4) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            if (O() != null && O().worksInfoData != null && O().worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public oea z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            return this.H;
        }
        return (oea) invokeV.objValue;
    }

    public final void A0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            oea oeaVar = new oea();
            oeaVar.h1 = true;
            oeaVar.I1(dataRes.banner_list.pb_banner_ad);
            this.H = oeaVar;
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.U = i;
        }
    }

    public void G0(ly4 ly4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, ly4Var) == null) {
            this.o = ly4Var;
        }
    }

    public void H0(pea peaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, peaVar) == null) {
            this.V = peaVar;
            this.X = peaVar;
            this.W = false;
        }
    }

    public void I0(pea peaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, peaVar) == null) {
            this.X = peaVar;
        }
    }

    public void J0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048595, this, z) != null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public void K0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.x = i;
        }
    }

    public void L0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048599, this, str) == null) && (threadData = this.p) != null) {
            threadData.setMarkID(str);
        }
    }

    public void N0(oea oeaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, oeaVar) == null) {
            this.H = oeaVar;
        }
    }

    public void O0(of9 of9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, of9Var) == null) {
            this.P = of9Var;
        }
    }

    public void P0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.j0 = i;
        }
    }

    public void Q0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048609, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void R0(RobotEntrance robotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, robotEntrance) == null) {
            this.r0 = robotEntrance;
        }
    }

    public void S0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void T0(List<yh> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, list) == null) {
            this.p0 = list;
        }
    }

    public pea U0(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, peaVar)) == null) {
            this.L = peaVar;
            return peaVar;
        }
        return (pea) invokeL.objValue;
    }

    public void V0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048619, this, str) == null) {
            this.b = str;
        }
    }

    public final void g0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048637, this, dataRes) == null) {
            Post post = dataRes.top_answer;
            if (post == null) {
                this.r = null;
            } else if (this.S.contains(String.valueOf(post.id))) {
            } else {
                this.r = B0(post, dataRes.forum);
            }
        }
    }

    public boolean u0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048665, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void z0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048675, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    public final pea B0(Post post, SimpleForum simpleForum) {
        InterceptResult invokeLL;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, post, simpleForum)) == null) {
            pea peaVar = new pea();
            peaVar.v1(this.s);
            peaVar.Z0(this.n.isBrandForum);
            peaVar.K0(post, O());
            peaVar.n1(O().getPraise());
            if (simpleForum != null) {
                peaVar.X0(simpleForum.id.longValue());
                peaVar.Y0(simpleForum.name);
            }
            if (peaVar.p() != null && peaVar.p().baijiahaoData == null && O() != null && O().getBaijiahaoData() != null) {
                peaVar.p().baijiahaoData = O().getBaijiahaoData();
            }
            this.S.add(peaVar.U());
            if (peaVar.L() == 1 && this.p.isActInfo()) {
                if (s0()) {
                    peaVar.m1(0);
                } else {
                    peaVar.m1(this.p.getActInfoType());
                }
            } else if (peaVar.L() == 1 && this.p.isInterviewLive()) {
                peaVar.m1(41);
            } else if (peaVar.L() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                peaVar.m1(0);
                peaVar.u0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    peaVar.o1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    peaVar.o1(TbRichTextView.Z(jSONArray, false));
                }
                this.L = peaVar;
            }
            if (peaVar.L() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                peaVar.l1(threadData2.originalThreadData);
            }
            if (peaVar.L() == 1) {
                this.X = peaVar;
                this.W = false;
                if (peaVar.t() != null && this.h0 != null) {
                    peaVar.t().setBusinessAccountData(this.h0);
                }
            }
            peaVar.w1(post);
            peaVar.i1(post.agree.lz_agree.intValue());
            ChatContent chatContent = post.chat_content;
            if (chatContent != null && !StringUtils.isNull(chatContent.scheme)) {
                peaVar.R0(new gea(post.chat_content.scheme));
            }
            return peaVar;
        }
        return (pea) invokeLL.objValue;
    }

    public final void C0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.b0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    oea oeaVar = new oea();
                    oeaVar.n1 = x0();
                    oeaVar.I1(app);
                    if (!this.b0.contains(oeaVar)) {
                        this.b0.add(oeaVar);
                    }
                }
            }
        }
    }

    public void D0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            y65 y65Var = this.n0;
            y65Var.b = floatingIconItem.icon_url;
            y65Var.c = floatingIconItem.fold_lottie;
            y65Var.d = floatingIconItem.unfold_lottie;
            y65Var.e = floatingIconItem.float_type;
            y65Var.f = floatingIconItem.fold_name;
            y65Var.g = floatingIconItem.unfold_name;
            y65Var.a = floatingIconItem.url;
            y65Var.j = floatingIconItem.scheme;
            y65Var.k = floatingIconItem.package_name;
            y65Var.l = floatingIconItem.deeplink;
            y65Var.h = floatingIconItem.view_statistics_url;
            y65Var.i = floatingIconItem.click_statistics_url;
            y65Var.r = floatingIconItem.display_ad_icon;
            y65Var.s = floatingIconItem.hide_close_icon;
            y65Var.t = floatingIconItem.activity_id;
            y65Var.q = 2;
        }
    }

    public final void d0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, dataRes) == null) {
            this.P = new of9(this.p, this.u);
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
                this.h = jf9.i(managerElection);
            }
        }
    }

    public final void e0(DataRes dataRes) {
        List<Post> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, dataRes) == null) && dataRes != null && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.S.contains(String.valueOf(post.id))) {
                    this.q.add(B0(post, dataRes.forum));
                }
            }
        }
    }

    public final void f0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048635, this, dataRes) == null) && (list = dataRes.feed_thread_list) != null && list.size() > 0) {
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

    public final boolean i0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (threadData = this.p) == null || threadData.getBaijiahaoData() == null || this.p.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.getBaijiahaoData().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public final boolean v0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048667, this, threadInfo)) == null) {
            if (threadInfo == null || Q() == null || threadInfo.id.longValue() == 0 || threadInfo.tid.longValue() == 0) {
                return false;
            }
            if (!Q().equals(threadInfo.id.toString()) && !Q().equals(threadInfo.tid.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final pea E() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (O() != null && O().getAuthor() != null) {
                pea peaVar = new pea();
                MetaData author = O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                peaVar.W0(1);
                peaVar.c1(O().getFirstPostId());
                peaVar.t1(O().getTitle());
                peaVar.s1(O().getCreateTime());
                peaVar.P0(author);
                return peaVar;
            }
            return null;
        }
        return (pea) invokeV.objValue;
    }

    public pea X() {
        InterceptResult invokeV;
        pea peaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (Y() != null) {
                return Y();
            }
            if (!ListUtils.isEmpty(F())) {
                Iterator<pea> it = F().iterator();
                while (it.hasNext()) {
                    peaVar = it.next();
                    if (peaVar != null && peaVar.L() == 1) {
                        break;
                    }
                }
            }
            peaVar = null;
            if (peaVar == null) {
                peaVar = i();
            }
            if (!l0(peaVar)) {
                peaVar = E();
            }
            if (peaVar != null && peaVar.t() != null && peaVar.t().getUserTbVipInfoData() != null && peaVar.t().getUserTbVipInfoData().getvipIntro() != null) {
                peaVar.t().getGodUserData().setIntro(peaVar.t().getUserTbVipInfoData().getvipIntro());
            }
            return peaVar;
        }
        return (pea) invokeV.objValue;
    }

    public void E0(DataRes dataRes) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048585, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.jump_link_info != null) {
                this.O = dataRes.jump_link_info;
            }
            LocationCacheData.getInstance().setAspShowInfo(dataRes.asp_shown_info);
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
            K0(dataRes.is_new_url.intValue());
            z0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.m(dataRes.display_forum);
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
            this.D.E1(dataRes.recommend_book);
            e0(dataRes);
            g0(dataRes);
            pea peaVar = new pea();
            this.V = peaVar;
            peaVar.W0(1);
            this.V.v1(this.s);
            this.V.Z0(this.n.isBrandForum);
            this.V.s1(this.p.getCreateTime());
            if (dataRes.forum != null) {
                this.V.X0(dataRes.forum.id.longValue());
                this.V.Y0(dataRes.forum.name);
            }
            if (dataRes.first_floor_post != null) {
                this.V.J0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.V.l1(this.p.originalThreadData);
            }
            if (this.X == null) {
                this.X = this.V;
                this.W = true;
            }
            this.t.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.s0 = true;
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
            List<AdvertAppInfo> g = tz9.m().g();
            if (g != null) {
                g.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                A0(dataRes);
                for (App app : list2) {
                    oea oeaVar = new oea();
                    oeaVar.n1 = x0();
                    oeaVar.I1(app);
                    if (!this.G.contains(oeaVar)) {
                        this.G.add(oeaVar);
                        if (g != null) {
                            g.add(oeaVar.getAdvertAppInfo());
                        }
                    }
                }
                C0(dataRes);
            }
            tz9.m().f();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            if (dataRes.forum_headline_img_info != null) {
                ff9 ff9Var = new ff9();
                this.M = ff9Var;
                ff9Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            f0(dataRes);
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.from_forum_list) {
                    if (simpleForum != null) {
                        ly4 ly4Var = new ly4();
                        ly4Var.m(simpleForum);
                        this.J.add(ly4Var);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            d0(dataRes);
            if (this.f1184T == null) {
                this.f1184T = new ArrayList();
            }
            this.f1184T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !v0(threadInfo) && !i0(threadInfo)) {
                        aw4 aw4Var = new aw4();
                        aw4Var.g(i4);
                        aw4Var.parserProtobuf(threadInfo);
                        this.f1184T.add(aw4Var);
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
                    we9 we9Var = new we9();
                    we9Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new ve9();
                    }
                    this.l.a(we9Var);
                }
            }
            this.c0.b();
            this.c0.c(this.s);
            this.c0.a(dataRes.recom_ala_info);
            if (this.c0.o != null) {
                this.c0.o.setTid(Q());
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
            D0(dataRes.floating_icon);
            this.o0 = dataRes.has_fold_comment.intValue();
            this.q0 = dataRes.similar_content;
            this.r0 = dataRes.robot_entrance;
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public String[] M(boolean z) {
        InterceptResult invokeZ;
        String str;
        String str2;
        String str3;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            String str4 = "";
            if (!w0()) {
                str = "";
            } else {
                int min = Math.min(this.q.size(), 30);
                if (O() != null && O().getAuthor() != null && !ad.isEmpty(O().getAuthor().getUserId())) {
                    String userId = O().getAuthor().getUserId();
                    pea h = h();
                    if (h == null || h.t() == null || ad.isEmpty(h.t().getUserId())) {
                        str2 = "";
                    } else {
                        if (!StringHelper.equals(userId, h.t().getUserId())) {
                            str2 = "";
                        } else {
                            str2 = h.K();
                        }
                        if (ad.isEmpty("")) {
                            str4 = h.n0();
                        }
                    }
                    if (ad.isEmpty(str4) && ad.isEmpty(str2)) {
                        for (int i = 0; i < min; i++) {
                            pea peaVar = (pea) ListUtils.getItem(this.q, i);
                            if (peaVar != null && peaVar.t() != null && !ad.isEmpty(peaVar.t().getUserId()) && StringHelper.equals(userId, peaVar.t().getUserId())) {
                                if (ad.isEmpty(str2)) {
                                    str2 = peaVar.K();
                                }
                                if (ad.isEmpty(str4)) {
                                    str4 = peaVar.n0();
                                }
                                if (!ad.isEmpty(str2) && !ad.isEmpty(str4)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && ad.isEmpty(str2)) {
                        str2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str4 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str4;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !ad.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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

    public void M0(mx4 mx4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, mx4Var, i) == null) {
            this.t.k(mx4Var.a());
            this.t.p(mx4Var.g());
            this.t.q(mx4Var.h());
            this.t.o(mx4Var.e());
            this.t.n(mx4Var.d());
            if (i == 0) {
                this.t = mx4Var;
            } else if (i == 1) {
                this.t.l(mx4Var.b());
            } else if (i == 2) {
                this.t.m(mx4Var.c());
            }
        }
    }

    public final boolean l0(pea peaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, peaVar)) == null) {
            if (peaVar == null || peaVar.t() == null) {
                return false;
            }
            MetaData t = peaVar.t();
            if (TextUtils.isEmpty(t.getUserId()) && TextUtils.isEmpty(t.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
