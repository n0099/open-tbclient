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
import tbclient.Agree;
import tbclient.AichatBotCard;
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
import tbclient.RobotEntrance;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class zv9 implements vv9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public my4 A;
    public y0a B;
    public List<MuteUser> C;
    public ny4 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<lwa> G;
    public lwa H;
    public TwzhiboAnti I;
    public List<iz4> J;
    public sw9 K;
    public mwa L;
    public gw9 M;
    public long N;
    public JumpLinkInfo O;
    public ow9 P;
    public String Q;
    public String R;
    public HashSet<String> S;

    /* renamed from: T  reason: collision with root package name */
    public List<xw4> f1180T;
    public int U;
    public mwa V;
    public boolean W;
    public mwa X;
    public int Y;
    public boolean Z;
    public final UserData a;
    public int a0;
    public String b;
    public List<lwa> b0;
    public CardHListViewData c;
    public p0a c0;
    public int d;
    public String d0;
    public int e;
    public String e0;
    public List<PbSortType> f;
    public List<ThreadInfo> f0;
    public int g;
    public ForumRuleStatus g0;
    public kw9 h;
    public BusinessAccountData h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public boolean k0;
    public wv9 l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public d85 n0;
    public iz4 o;
    public int o0;
    public ThreadData p;
    public List<pi> p0;
    public ArrayList<mwa> q;
    public SimilarContent q0;
    public mwa r;
    public RobotEntrance r0;
    public HashMap<String, MetaData> s;
    public AichatBotCard s0;
    public jy4 t;
    public boolean t0;
    public AntiData u;
    public cd5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public zv9() {
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
        this.t0 = false;
        this.n = new ForumData();
        this.o = new iz4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new jy4();
        this.u = new AntiData();
        this.v = new cd5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new my4();
        this.D = new ny4();
        this.B = new y0a();
        this.I = new TwzhiboAnti();
        this.K = new sw9();
        this.c0 = new p0a();
        this.S = new HashSet<>();
        this.n0 = new d85();
    }

    @NonNull
    public String A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public jy4 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.t;
        }
        return (jy4) invokeV.objValue;
    }

    public lwa C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.H;
        }
        return (lwa) invokeV.objValue;
    }

    public gw9 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.M;
        }
        return (gw9) invokeV.objValue;
    }

    public p0a E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            p0a p0aVar = this.c0;
            if (p0aVar != null && p0aVar.isValid()) {
                return this.c0;
            }
            return null;
        }
        return (p0a) invokeV.objValue;
    }

    public y0a F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.B;
        }
        return (y0a) invokeV.objValue;
    }

    public ny4 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.D;
        }
        return (ny4) invokeV.objValue;
    }

    public ArrayList<mwa> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.j0;
        }
        return invokeV.intValue;
    }

    public List<ThreadInfo> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.f0;
        }
        return (List) invokeV.objValue;
    }

    public AlaLiveInfoCoreData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.F;
        }
        return (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public int M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            AntiData antiData = this.u;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public RobotEntrance N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.r0;
        }
        return (RobotEntrance) invokeV.objValue;
    }

    public String[] O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return P(true);
        }
        return (String[]) invokeV.objValue;
    }

    public SimilarContent Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.q0;
        }
        return (SimilarContent) invokeV.objValue;
    }

    public ThreadData R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    public long S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.N;
        }
        return invokeV.longValue;
    }

    public String T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<pi> U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.p0;
        }
        return (List) invokeV.objValue;
    }

    public ow9 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.P;
        }
        return (ow9) invokeV.objValue;
    }

    public sw9 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.K;
        }
        return (sw9) invokeV.objValue;
    }

    public mwa X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.r;
        }
        return (mwa) invokeV.objValue;
    }

    public UserData Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public int Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.tieba.vv9
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            if (R() != null && R().isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vv9
    public boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public mwa b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.L;
        }
        return (mwa) invokeV.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            this.c0 = null;
        }
    }

    public String c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048631, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public List<lwa> d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.b0;
        }
        return (List) invokeV.objValue;
    }

    public AichatBotCard e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.s0;
        }
        return (AichatBotCard) invokeV.objValue;
    }

    public d85 e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.n0;
        }
        return (d85) invokeV.objValue;
    }

    public AntiData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            jy4 jy4Var = this.t;
            if (jy4Var != null && jy4Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<lwa> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<xw4> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.f1180T;
        }
        return (List) invokeV.objValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.U;
        }
        return invokeV.intValue;
    }

    public iz4 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.o;
        }
        return (iz4) invokeV.objValue;
    }

    public mwa k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.X;
        }
        return (mwa) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.t0;
        }
        return invokeV.booleanValue;
    }

    public mwa l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            return this.V;
        }
        return (mwa) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public ForumData n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (u() == 1 || a()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (R() != null && R().isLongNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumRuleStatus q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.g0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            if (R() != null && R().isNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<iz4> r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.J;
        }
        return (List) invokeV.objValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.k0;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.m0;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (this.p.getIsMarked() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            if (this.o0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public JumpLinkInfo w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.O;
        }
        return (JumpLinkInfo) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getMarkID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            ArrayList<mwa> arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<MuteUser> y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (R() != null && R().isVideoThreadType() && R().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048675, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048676, this)) == null) {
            if (R() != null && R().worksInfoData != null && R().worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void A0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    public final void B0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) {
            lwa lwaVar = new lwa();
            lwaVar.j1 = true;
            lwaVar.M1(dataRes.banner_list.pb_banner_ad);
            this.H = lwaVar;
        }
    }

    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.U = i;
        }
    }

    public void H0(iz4 iz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, iz4Var) == null) {
            this.o = iz4Var;
        }
    }

    public void I0(mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, mwaVar) == null) {
            this.V = mwaVar;
            this.X = mwaVar;
            this.W = false;
        }
    }

    public void J0(mwa mwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, mwaVar) == null) {
            this.X = mwaVar;
        }
    }

    public void K0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048597, this, z) != null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public void L0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.x = i;
        }
    }

    public void M0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048601, this, str) == null) && (threadData = this.p) != null) {
            threadData.setMarkID(str);
        }
    }

    public void O0(lwa lwaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, lwaVar) == null) {
            this.H = lwaVar;
        }
    }

    public void P0(ow9 ow9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, ow9Var) == null) {
            this.P = ow9Var;
        }
    }

    public void Q0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048609, this, i) == null) {
            this.j0 = i;
        }
    }

    public void R0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048611, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void S0(RobotEntrance robotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, robotEntrance) == null) {
            this.r0 = robotEntrance;
        }
    }

    public void T0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void U0(List<pi> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, list) == null) {
            this.p0 = list;
        }
    }

    public mwa V0(mwa mwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, mwaVar)) == null) {
            this.L = mwaVar;
            return mwaVar;
        }
        return (mwa) invokeL.objValue;
    }

    public void W0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, str) == null) {
            this.b = str;
        }
    }

    public final void j0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048644, this, dataRes) == null) {
            Post post = dataRes.top_answer;
            if (post == null) {
                this.r = null;
            } else if (this.S.contains(String.valueOf(post.id))) {
            } else {
                this.r = C0(post, dataRes.forum);
            }
        }
    }

    public boolean v0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048668, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final mwa C0(Post post, SimpleForum simpleForum) {
        InterceptResult invokeLL;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, post, simpleForum)) == null) {
            mwa mwaVar = new mwa();
            mwaVar.z1(this.s);
            mwaVar.c1(this.n.isBrandForum);
            mwaVar.O0(post, R());
            mwaVar.q1(R().getPraise());
            if (simpleForum != null) {
                mwaVar.a1(simpleForum.id.longValue());
                mwaVar.b1(simpleForum.name);
            }
            if (mwaVar.p() != null && mwaVar.p().baijiahaoData == null && R() != null && R().getBaijiahaoData() != null) {
                mwaVar.p().baijiahaoData = R().getBaijiahaoData();
            }
            this.S.add(mwaVar.U());
            if (mwaVar.L() == 1 && this.p.isActInfo()) {
                if (t0()) {
                    mwaVar.p1(0);
                } else {
                    mwaVar.p1(this.p.getActInfoType());
                }
            } else if (mwaVar.L() == 1 && this.p.isInterviewLive()) {
                mwaVar.p1(41);
            } else if (mwaVar.L() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                mwaVar.p1(0);
                mwaVar.v0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    mwaVar.r1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    mwaVar.r1(TbRichTextView.Z(jSONArray, false));
                }
                this.L = mwaVar;
            }
            if (mwaVar.L() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                mwaVar.o1(threadData2.originalThreadData);
            }
            if (mwaVar.L() == 1) {
                this.X = mwaVar;
                this.W = false;
                if (mwaVar.u() != null && this.h0 != null) {
                    mwaVar.u().setBusinessAccountData(this.h0);
                }
            }
            mwaVar.A1(post);
            Agree agree = post.agree;
            if (agree != null) {
                mwaVar.l1(agree.lz_agree.intValue());
            }
            mwaVar.t1(post.sprite_meme_info);
            return mwaVar;
        }
        return (mwa) invokeLL.objValue;
    }

    public final void D0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.b0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    lwa lwaVar = new lwa();
                    lwaVar.p1 = y0();
                    lwaVar.M1(app);
                    if (!this.b0.contains(lwaVar)) {
                        this.b0.add(lwaVar);
                    }
                }
            }
        }
    }

    public void E0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            d85 d85Var = this.n0;
            d85Var.b = floatingIconItem.icon_url;
            d85Var.c = floatingIconItem.fold_lottie;
            d85Var.d = floatingIconItem.unfold_lottie;
            d85Var.e = floatingIconItem.float_type;
            d85Var.f = floatingIconItem.fold_name;
            d85Var.g = floatingIconItem.unfold_name;
            d85Var.a = floatingIconItem.url;
            d85Var.j = floatingIconItem.scheme;
            d85Var.k = floatingIconItem.package_name;
            d85Var.l = floatingIconItem.deeplink;
            d85Var.h = floatingIconItem.view_statistics_url;
            d85Var.i = floatingIconItem.click_statistics_url;
            d85Var.r = floatingIconItem.display_ad_icon;
            d85Var.s = floatingIconItem.hide_close_icon;
            d85Var.t = floatingIconItem.activity_id;
            d85Var.q = 2;
        }
    }

    public final void g0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048638, this, dataRes) == null) {
            this.P = new ow9(this.p, this.u);
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
                this.h = kw9.i(managerElection);
            }
        }
    }

    public final void h0(DataRes dataRes) {
        List<Post> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048640, this, dataRes) == null) && dataRes != null && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.S.contains(String.valueOf(post.id))) {
                    this.q.add(C0(post, dataRes.forum));
                }
            }
        }
    }

    public final void i0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048642, this, dataRes) == null) && (list = dataRes.feed_thread_list) != null && list.size() > 0) {
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

    public final boolean l0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (threadData = this.p) == null || threadData.getBaijiahaoData() == null || this.p.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.getBaijiahaoData().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public final boolean w0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048670, this, threadInfo)) == null) {
            if (threadInfo == null || T() == null || threadInfo.id.longValue() == 0 || threadInfo.tid.longValue() == 0) {
                return false;
            }
            if (!T().equals(threadInfo.id.toString()) && !T().equals(threadInfo.tid.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void F0(DataRes dataRes) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048587, this, dataRes) != null) || dataRes == null) {
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
            L0(dataRes.is_new_url.intValue());
            A0(dataRes);
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
                        this.B.j1 = this.A;
                    } else {
                        this.B.k1 = this.A;
                    }
                } else {
                    this.B.j1 = this.A;
                }
            } else {
                this.B.i1 = this.A;
            }
            this.D.I1(dataRes.recommend_book);
            h0(dataRes);
            j0(dataRes);
            mwa mwaVar = new mwa();
            this.V = mwaVar;
            mwaVar.Z0(1);
            this.V.z1(this.s);
            this.V.c1(this.n.isBrandForum);
            this.V.w1(this.p.getCreateTime());
            if (dataRes.forum != null) {
                this.V.a1(dataRes.forum.id.longValue());
                this.V.b1(dataRes.forum.name);
            }
            if (dataRes.first_floor_post != null) {
                this.V.N0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.V.o1(this.p.originalThreadData);
            }
            if (this.X == null) {
                this.X = this.V;
                this.W = true;
            }
            this.t.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.t0 = true;
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
            List<AdvertAppInfo> g = vha.m().g();
            if (g != null) {
                g.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                B0(dataRes);
                for (App app : list2) {
                    lwa lwaVar = new lwa();
                    lwaVar.p1 = y0();
                    lwaVar.M1(app);
                    if (!this.G.contains(lwaVar)) {
                        this.G.add(lwaVar);
                        if (g != null) {
                            g.add(lwaVar.getAdvertAppInfo());
                        }
                    }
                }
                D0(dataRes);
            }
            vha.m().f();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            if (dataRes.forum_headline_img_info != null) {
                gw9 gw9Var = new gw9();
                this.M = gw9Var;
                gw9Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            i0(dataRes);
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.from_forum_list) {
                    if (simpleForum != null) {
                        iz4 iz4Var = new iz4();
                        iz4Var.m(simpleForum);
                        this.J.add(iz4Var);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            g0(dataRes);
            if (this.f1180T == null) {
                this.f1180T = new ArrayList();
            }
            this.f1180T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !w0(threadInfo) && !l0(threadInfo)) {
                        xw4 xw4Var = new xw4();
                        xw4Var.g(i4);
                        xw4Var.parserProtobuf(threadInfo);
                        this.f1180T.add(xw4Var);
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
                    xv9 xv9Var = new xv9();
                    xv9Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new wv9();
                    }
                    this.l.a(xv9Var);
                }
            }
            this.c0.b();
            this.c0.c(this.s);
            this.c0.a(dataRes.recom_ala_info);
            if (this.c0.o != null) {
                this.c0.o.setTid(T());
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
            E0(dataRes.floating_icon);
            this.o0 = dataRes.has_fold_comment.intValue();
            this.q0 = dataRes.similar_content;
            this.r0 = dataRes.robot_entrance;
            this.s0 = dataRes.aichat_bot_card;
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public final mwa H() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (R() != null && R().getAuthor() != null) {
                mwa mwaVar = new mwa();
                MetaData author = R().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = R().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                mwaVar.Z0(1);
                mwaVar.f1(R().getFirstPostId());
                mwaVar.x1(R().getTitle());
                mwaVar.w1(R().getCreateTime());
                mwaVar.T0(author);
                return mwaVar;
            }
            return null;
        }
        return (mwa) invokeV.objValue;
    }

    public mwa a0() {
        InterceptResult invokeV;
        mwa mwaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (b0() != null) {
                return b0();
            }
            if (!ListUtils.isEmpty(I())) {
                Iterator<mwa> it = I().iterator();
                while (it.hasNext()) {
                    mwaVar = it.next();
                    if (mwaVar != null && mwaVar.L() == 1) {
                        break;
                    }
                }
            }
            mwaVar = null;
            if (mwaVar == null) {
                mwaVar = l();
            }
            if (!m0(mwaVar)) {
                mwaVar = H();
            }
            if (mwaVar != null && mwaVar.u() != null && mwaVar.u().getUserTbVipInfoData() != null && mwaVar.u().getUserTbVipInfoData().getvipIntro() != null) {
                mwaVar.u().getGodUserData().setIntro(mwaVar.u().getUserTbVipInfoData().getvipIntro());
            }
            return mwaVar;
        }
        return (mwa) invokeV.objValue;
    }

    public void N0(jy4 jy4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048603, this, jy4Var, i) == null) {
            this.t.k(jy4Var.a());
            this.t.p(jy4Var.g());
            this.t.q(jy4Var.h());
            this.t.o(jy4Var.e());
            this.t.n(jy4Var.d());
            if (i == 0) {
                this.t = jy4Var;
            } else if (i == 1) {
                this.t.l(jy4Var.b());
            } else if (i == 2) {
                this.t.m(jy4Var.c());
            }
        }
    }

    public String[] P(boolean z) {
        InterceptResult invokeZ;
        String str;
        String str2;
        String str3;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            String str4 = "";
            if (!x0()) {
                str = "";
            } else {
                int min = Math.min(this.q.size(), 30);
                if (R() != null && R().getAuthor() != null && !rd.isEmpty(R().getAuthor().getUserId())) {
                    String userId = R().getAuthor().getUserId();
                    mwa k = k();
                    if (k == null || k.u() == null || rd.isEmpty(k.u().getUserId())) {
                        str2 = "";
                    } else {
                        if (!StringHelper.equals(userId, k.u().getUserId())) {
                            str2 = "";
                        } else {
                            str2 = k.J();
                        }
                        if (rd.isEmpty("")) {
                            str4 = k.o0();
                        }
                    }
                    if (rd.isEmpty(str4) && rd.isEmpty(str2)) {
                        for (int i = 0; i < min; i++) {
                            mwa mwaVar = (mwa) ListUtils.getItem(this.q, i);
                            if (mwaVar != null && mwaVar.u() != null && !rd.isEmpty(mwaVar.u().getUserId()) && StringHelper.equals(userId, mwaVar.u().getUserId())) {
                                if (rd.isEmpty(str2)) {
                                    str2 = mwaVar.J();
                                }
                                if (rd.isEmpty(str4)) {
                                    str4 = mwaVar.o0();
                                }
                                if (!rd.isEmpty(str2) && !rd.isEmpty(str4)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && rd.isEmpty(str2)) {
                        str2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str4 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str4;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !rd.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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

    public final boolean m0(mwa mwaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, mwaVar)) == null) {
            if (mwaVar == null || mwaVar.u() == null) {
                return false;
            }
            MetaData u = mwaVar.u();
            if (TextUtils.isEmpty(u.getUserId()) && TextUtils.isEmpty(u.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
