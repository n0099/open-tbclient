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
import com.baidu.tbadk.core.data.RecommendTopicData;
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
import tbclient.PbPage.AppealInfo;
import tbclient.PbPage.DataRes;
import tbclient.PbPage.FloatingIcon;
import tbclient.PbPage.FloatingIconItem;
import tbclient.PbPage.PbFollowTip;
import tbclient.PbPage.PbSortType;
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes5.dex */
public class ki8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public my4 A;
    public yl8 B;
    public List<MuteUser> C;
    public ny4 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<ac9> G;
    public ac9 H;
    public TwzhiboAnti I;
    public List<iz4> J;
    public List<iz4> K;
    public dj8 L;
    public bc9 M;
    public oi8 N;
    public long O;
    public JumpLinkInfo P;
    public yi8 Q;
    public String R;
    public String S;
    public List<RecommendTopicData.RecommendTopicListData> T;
    public HashSet<String> U;
    public List<yw4> V;
    public int W;
    public nq8 X;
    public bc9 Y;
    public boolean Z;
    public final UserData a;
    public bc9 a0;
    public String b;
    public int b0;
    public CardHListViewData c;
    public boolean c0;
    public int d;
    public int d0;
    public int e;
    public List<ac9> e0;
    public List<PbSortType> f;
    public nl8 f0;
    public int g;
    public pl8 g0;
    public ti8 h;
    public String h0;
    public boolean i;
    public String i0;
    public boolean j;
    public List<ThreadInfo> j0;
    public boolean k;
    public ForumRuleStatus k0;
    public fi8 l;
    public BusinessAccountData l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public int n0;
    public iz4 o;
    public boolean o0;
    public ThreadData p;
    public boolean p0;
    public ArrayList<bc9> q;
    public boolean q0;
    public bc9 r;
    public k65 r0;
    public HashMap<String, MetaData> s;
    public int s0;
    public jy4 t;
    public List<gn> t0;
    public AntiData u;
    public boolean u0;
    public oa5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public ki8() {
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
        this.W = 0;
        this.Z = true;
        this.b0 = 0;
        this.d0 = 0;
        this.e0 = new ArrayList();
        this.n0 = 0;
        this.s0 = 0;
        this.u0 = false;
        this.n = new ForumData();
        this.o = new iz4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new jy4();
        this.u = new AntiData();
        this.v = new oa5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new my4();
        this.D = new ny4();
        this.B = new yl8();
        this.I = new TwzhiboAnti();
        this.L = new dj8();
        this.f0 = new nl8();
        this.T = new ArrayList();
        this.U = new HashSet<>();
        this.r0 = new k65();
    }

    public ac9 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.H;
        }
        return (ac9) invokeV.objValue;
    }

    public oi8 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.N;
        }
        return (oi8) invokeV.objValue;
    }

    public nl8 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            nl8 nl8Var = this.f0;
            if (nl8Var != null && nl8Var.isValid()) {
                return this.f0;
            }
            return null;
        }
        return (nl8) invokeV.objValue;
    }

    public pl8 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            pl8 pl8Var = this.g0;
            if (pl8Var != null && pl8Var.isValid()) {
                return this.g0;
            }
            return null;
        }
        return (pl8) invokeV.objValue;
    }

    public yl8 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.B;
        }
        return (yl8) invokeV.objValue;
    }

    public ny4 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.D;
        }
        return (ny4) invokeV.objValue;
    }

    public ArrayList<bc9> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public nq8 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.X;
        }
        return (nq8) invokeV.objValue;
    }

    public int J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.n0;
        }
        return invokeV.intValue;
    }

    public List<ThreadInfo> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.j0;
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

    public List<ThreadData> M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.E;
        }
        return (List) invokeV.objValue;
    }

    public int N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            AntiData antiData = this.u;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public String[] O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return P(true);
        }
        return (String[]) invokeV.objValue;
    }

    public ThreadData Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    public long R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public String S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<gn> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.t0;
        }
        return (List) invokeV.objValue;
    }

    public yi8 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.Q;
        }
        return (yi8) invokeV.objValue;
    }

    public dj8 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.L;
        }
        return (dj8) invokeV.objValue;
    }

    public bc9 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.r;
        }
        return (bc9) invokeV.objValue;
    }

    public UserData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public int Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.f0 = null;
            this.g0 = null;
        }
    }

    public bc9 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.M;
        }
        return (bc9) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public String b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public List<ac9> c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.e0;
        }
        return (List) invokeV.objValue;
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public k65 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.r0;
        }
        return (k65) invokeV.objValue;
    }

    public ArrayList<ac9> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public boolean e0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            jy4 jy4Var = this.t;
            if (jy4Var != null && jy4Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<yw4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.V;
        }
        return (List) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.W;
        }
        return invokeV.intValue;
    }

    public iz4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.o;
        }
        return (iz4) invokeV.objValue;
    }

    public bc9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.a0;
        }
        return (bc9) invokeV.objValue;
    }

    public bc9 j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.Y;
        }
        return (bc9) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.u0;
        }
        return invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            if (Q() != null && Q().isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.m0;
        }
        return invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.getName();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public ForumRuleStatus o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.k0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<iz4> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.K;
        }
        return (List) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            if (Q() != null && Q().isLongNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            if (Q() != null && Q().isNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            if (this.p.getIsMarked() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.o0;
        }
        return invokeV.booleanValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            return this.q0;
        }
        return invokeV.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            if (this.s0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public JumpLinkInfo u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            return this.P;
        }
        return (JumpLinkInfo) invokeV.objValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.p0;
        }
        return invokeV.booleanValue;
    }

    public String v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getMarkID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List<MuteUser> w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.S;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            ArrayList<bc9> arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @NonNull
    public String y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (Q() != null && Q().isVideoThreadType() && Q().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public jy4 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.t;
        }
        return (jy4) invokeV.objValue;
    }

    public boolean z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048674, this)) == null) {
            if (Q() != null && Q().worksInfoData != null && Q().worksInfoData.isWorks) {
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
            ac9 ac9Var = new ac9();
            ac9Var.a1 = true;
            ac9Var.u1(dataRes.banner_list.pb_banner_ad);
            this.H = ac9Var;
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.W = i;
        }
    }

    public void G0(iz4 iz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iz4Var) == null) {
            this.o = iz4Var;
        }
    }

    public void H0(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, bc9Var) == null) {
            this.Y = bc9Var;
            this.a0 = bc9Var;
            this.Z = false;
        }
    }

    public void I0(bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, bc9Var) == null) {
            this.a0 = bc9Var;
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

    public void N0(ac9 ac9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, ac9Var) == null) {
            this.H = ac9Var;
        }
    }

    public void O0(yi8 yi8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, yi8Var) == null) {
            this.Q = yi8Var;
        }
    }

    public void P0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.n0 = i;
        }
    }

    public void Q0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048609, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void R0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void S0(List<gn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, list) == null) {
            this.t0 = list;
        }
    }

    public bc9 T0(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, bc9Var)) == null) {
            this.M = bc9Var;
            return bc9Var;
        }
        return (bc9) invokeL.objValue;
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.b = str;
        }
    }

    public boolean v0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048666, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void C0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.e0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    ac9 ac9Var = new ac9();
                    ac9Var.g1 = y0();
                    ac9Var.u1(app);
                    if (!this.e0.contains(ac9Var)) {
                        this.e0.add(ac9Var);
                    }
                }
            }
        }
    }

    public void D0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            k65 k65Var = this.r0;
            k65Var.b = floatingIconItem.icon_url;
            k65Var.c = floatingIconItem.fold_lottie;
            k65Var.d = floatingIconItem.unfold_lottie;
            k65Var.e = floatingIconItem.float_type;
            k65Var.f = floatingIconItem.fold_name;
            k65Var.g = floatingIconItem.unfold_name;
            k65Var.a = floatingIconItem.url;
            k65Var.j = floatingIconItem.scheme;
            k65Var.k = floatingIconItem.package_name;
            k65Var.l = floatingIconItem.deeplink;
            k65Var.h = floatingIconItem.view_statistics_url;
            k65Var.i = floatingIconItem.click_statistics_url;
            k65Var.r = floatingIconItem.display_ad_icon;
        }
    }

    public final void h0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048638, this, dataRes) == null) && (list = dataRes.feed_thread_list) != null && list.size() > 0) {
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

    public final boolean k0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048644, this, threadInfo)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048668, this, threadInfo)) == null) {
            if (threadInfo == null || S() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            if (!S().equals(threadInfo.id) && !S().equals(threadInfo.tid)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
                this.P = dataRes.jump_link_info;
            }
            o29.e().h(dataRes.asp_shown_info);
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
                        this.l0 = metaData.getBusinessAccountData();
                    }
                }
            }
            K0(dataRes.is_new_url.intValue());
            A0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.i(dataRes.display_forum);
            this.p.setUserMap(this.s);
            this.p.parserProtobuf(dataRes.thread);
            if (this.p.getFid() == 0 && dataRes.forum != null) {
                this.p.setFid(dataRes.forum.id.longValue());
            }
            if (this.p.getAuthor() != null && this.p.getAuthor().getBusinessAccountData() == null) {
                this.p.getAuthor().setBusinessAccountData(this.l0);
            }
            this.A.a(dataRes.news_info);
            int i3 = this.A.c;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.B.a1 = this.A;
                    } else {
                        this.B.b1 = this.A;
                    }
                } else {
                    this.B.a1 = this.A;
                }
            } else {
                this.B.Z0 = this.A;
            }
            this.D.q1(dataRes.recommend_book);
            g0(dataRes);
            i0(dataRes);
            bc9 bc9Var = new bc9();
            this.Y = bc9Var;
            bc9Var.J0(1);
            this.Y.i1(this.s);
            this.Y.M0(this.n.isBrandForum);
            this.Y.f1(this.p.getCreateTime());
            if (dataRes.forum != null) {
                this.Y.K0(dataRes.forum.id.longValue());
                this.Y.L0(dataRes.forum.name);
            }
            if (dataRes.first_floor_post != null) {
                this.Y.A0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.Y.Y0(this.p.originalThreadData);
            }
            if (this.a0 == null) {
                this.a0 = this.Y;
                this.Z = true;
            }
            this.t.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.u0 = true;
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
            List<AdvertAppInfo> f = f19.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                B0(dataRes);
                for (App app : list2) {
                    ac9 ac9Var = new ac9();
                    ac9Var.g1 = y0();
                    ac9Var.u1(app);
                    if (!this.G.contains(ac9Var)) {
                        this.G.add(ac9Var);
                        if (f != null) {
                            f.add(ac9Var.getAdvertAppInfo());
                        }
                    }
                }
                C0(dataRes);
            }
            f19.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                oi8 oi8Var = new oi8();
                this.N = oi8Var;
                oi8Var.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            h0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    iz4 iz4Var = new iz4();
                    iz4Var.i(simpleForum);
                    this.J.add(iz4Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.K == null) {
                    this.K = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        iz4 iz4Var2 = new iz4();
                        iz4Var2.i(simpleForum2);
                        this.K.add(iz4Var2);
                    }
                }
            }
            this.S = dataRes.multi_forum_text;
            if (this.O >= 0) {
                this.O = dataRes.thread_freq_num.longValue();
            }
            f0(dataRes);
            if (this.V == null) {
                this.V = new ArrayList();
            }
            this.V.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !w0(threadInfo) && !k0(threadInfo)) {
                        yw4 yw4Var = new yw4();
                        yw4Var.i(i4);
                        yw4Var.parserProtobuf(threadInfo);
                        this.V.add(yw4Var);
                        i4++;
                    }
                }
            }
            if (this.X != null && this.X.k()) {
                this.X = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.X == null) {
                    nq8 nq8Var = new nq8();
                    this.X = nq8Var;
                    nq8Var.m(dataRes.recom_ala_info);
                }
            } else if (this.X == null && dataRes.promotion != null) {
                nq8 nq8Var2 = new nq8();
                this.X = nq8Var2;
                nq8Var2.o(dataRes.promotion);
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
                    gi8 gi8Var = new gi8();
                    gi8Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new fi8();
                    }
                    this.l.a(gi8Var);
                }
            }
            this.f0.b();
            this.f0.c(this.s);
            this.f0.a(dataRes.recom_ala_info);
            if (this.f0.o != null) {
                this.f0.o.o(S());
            }
            pl8 pl8Var = new pl8();
            this.g0 = pl8Var;
            pl8Var.b(this.s);
            this.g0.a(dataRes.recom_ala_info);
            if (this.g0.m != null) {
                this.g0.m.o(S());
            }
            if (ListUtils.getCount(dataRes.recom_thread_info) > 0) {
                this.j0 = dataRes.recom_thread_info;
            }
            if (dataRes.jumptotab1 != null) {
                str = dataRes.jumptotab1.toString();
            }
            this.h0 = str;
            this.i0 = dataRes.jumptotab2;
            if (dataRes.forum_rule != null) {
                this.k0 = dataRes.forum_rule;
            }
            if (dataRes.is_black_white.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.m0 = z;
            if (dataRes.is_official_forum.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.o0 = z2;
            if (dataRes.show_adsense.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.p0 = z3;
            if (dataRes.is_purchase.intValue() == 1) {
                z7 = true;
            }
            this.q0 = z7;
            FloatingIcon floatingIcon = dataRes.floating_icon;
            D0(dataRes.floating_icon);
            this.s0 = dataRes.has_fold_comment.intValue();
            dataRes.fold_comment_num.longValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public final bc9 G() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (Q() != null && Q().getAuthor() != null) {
                bc9 bc9Var = new bc9();
                MetaData author = Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                bc9Var.J0(1);
                bc9Var.P0(Q().getFirstPostId());
                bc9Var.g1(Q().getTitle());
                bc9Var.f1(Q().getCreateTime());
                bc9Var.G0(author);
                return bc9Var;
            }
            return null;
        }
        return (bc9) invokeV.objValue;
    }

    public bc9 Z() {
        InterceptResult invokeV;
        bc9 bc9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (a0() != null) {
                return a0();
            }
            if (!ListUtils.isEmpty(H())) {
                Iterator<bc9> it = H().iterator();
                while (it.hasNext()) {
                    bc9Var = it.next();
                    if (bc9Var != null && bc9Var.E() == 1) {
                        break;
                    }
                }
            }
            bc9Var = null;
            if (bc9Var == null) {
                bc9Var = j();
            }
            if (!n0(bc9Var)) {
                bc9Var = G();
            }
            if (bc9Var != null && bc9Var.r() != null && bc9Var.r().getUserTbVipInfoData() != null && bc9Var.r().getUserTbVipInfoData().getvipIntro() != null) {
                bc9Var.r().getGodUserData().setIntro(bc9Var.r().getUserTbVipInfoData().getvipIntro());
            }
            return bc9Var;
        }
        return (bc9) invokeV.objValue;
    }

    public void M0(jy4 jy4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, jy4Var, i) == null) {
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
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048606, this, z)) == null) {
            String str = null;
            String str2 = "";
            if (x0()) {
                int i = 30;
                if (this.q.size() <= 30) {
                    i = this.q.size();
                }
                if (Q() != null && Q().getAuthor() != null && !gi.isEmpty(Q().getAuthor().getUserId())) {
                    String userId = Q().getAuthor().getUserId();
                    bc9 i2 = i();
                    if (i2 != null && i2.r() != null && !gi.isEmpty(i2.r().getUserId())) {
                        if (StringHelper.equals(userId, i2.r().getUserId())) {
                            str = i2.D();
                        }
                        if (gi.isEmpty("")) {
                            str2 = i2.h0();
                        }
                    }
                    if (gi.isEmpty(str2) && gi.isEmpty(str)) {
                        for (int i3 = 0; i3 < i; i3++) {
                            bc9 bc9Var = (bc9) ListUtils.getItem(this.q, i3);
                            if (bc9Var != null && bc9Var.r() != null && !gi.isEmpty(bc9Var.r().getUserId()) && StringHelper.equals(userId, bc9Var.r().getUserId())) {
                                if (gi.isEmpty(str)) {
                                    str = bc9Var.D();
                                }
                                if (gi.isEmpty(str2)) {
                                    str2 = bc9Var.h0();
                                }
                                if (!gi.isEmpty(str) && !gi.isEmpty(str2)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && gi.isEmpty(str)) {
                        str = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str2 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str2;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !gi.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
                        str = this.p.getThreadVideoInfo().thumbnail_url;
                    }
                    ThreadData threadData3 = this.p;
                    if (threadData3 != null && !threadData3.isShareThread && str == null && (originalThreadInfo = threadData3.originalThreadData) != null && (arrayList = originalThreadInfo.h) != null) {
                        int size = arrayList.size();
                        int i4 = 0;
                        while (true) {
                            if (i4 >= size) {
                                break;
                            }
                            MediaData mediaData = arrayList.get(i4);
                            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                                    str = mediaData.getThumbnails_url();
                                    break;
                                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                                    str = mediaData.getPicUrl();
                                    break;
                                }
                            }
                            i4++;
                        }
                    }
                } else {
                    return new String[]{null, ""};
                }
            }
            return new String[]{str, str2};
        }
        return (String[]) invokeZ.objValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            List<PbSortType> list = this.f;
            if (list != null && list.size() > this.g) {
                for (int i = 0; i < this.f.size(); i++) {
                    if (this.f.get(i).sort_type.intValue() == this.g) {
                        return this.f.get(i).sort_name;
                    }
                }
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void f0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048634, this, dataRes) == null) {
            this.Q = new yi8(this.p, this.u);
            String str = dataRes.partial_visible_toast;
            PbFollowTip pbFollowTip = dataRes.follow_tip;
            if (pbFollowTip != null && pbFollowTip.is_toast_tip.intValue() == 1) {
                String str2 = dataRes.follow_tip.tip_text;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            this.F = alaLiveInfoCoreData;
            AlaLiveInfo alaLiveInfo = dataRes.ala_info;
            if (alaLiveInfo != null) {
                alaLiveInfoCoreData.parserProtoBuf(alaLiveInfo);
            }
            this.R = dataRes.fold_tip;
            this.d = dataRes.exp_news_today.intValue();
            this.e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i = 0; i < dataRes.thread_topic.size(); i++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i));
                    this.T.add(recommendTopicListData);
                }
            }
            this.f = dataRes.pb_sort_info;
            this.g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.h = ti8.i(managerElection);
            }
        }
    }

    public final void g0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, dataRes) == null) && dataRes != null && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.U.contains(String.valueOf(post.id))) {
                    bc9 bc9Var = new bc9();
                    bc9Var.i1(this.s);
                    bc9Var.M0(this.n.isBrandForum);
                    bc9Var.B0(post, Q());
                    bc9Var.a1(Q().getPraise());
                    SimpleForum simpleForum = dataRes.forum;
                    if (simpleForum != null) {
                        bc9Var.K0(simpleForum.id.longValue());
                        bc9Var.L0(dataRes.forum.name);
                    }
                    if (bc9Var.o() != null && bc9Var.o().baijiahaoData == null && Q() != null && Q().getBaijiahaoData() != null) {
                        bc9Var.o().baijiahaoData = Q().getBaijiahaoData();
                    }
                    this.U.add(bc9Var.O());
                    if (bc9Var.E() == 1 && this.p.isActInfo()) {
                        if (t0()) {
                            bc9Var.Z0(0);
                        } else {
                            bc9Var.Z0(this.p.getActInfoType());
                        }
                    } else if (bc9Var.E() == 1 && this.p.isInterviewLive()) {
                        bc9Var.Z0(41);
                    } else if (bc9Var.E() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        bc9Var.Z0(0);
                        bc9Var.n0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            bc9Var.b1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                            bc9Var.b1(TbRichTextView.Z(jSONArray, false));
                        }
                        this.M = bc9Var;
                    }
                    if (bc9Var.E() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        bc9Var.Y0(threadData2.originalThreadData);
                    }
                    if (bc9Var.E() == 1) {
                        this.a0 = bc9Var;
                        this.Z = false;
                        if (bc9Var.r() != null && this.l0 != null) {
                            bc9Var.r().setBusinessAccountData(this.l0);
                        }
                    }
                    bc9Var.j1(post);
                    bc9Var.V0(post.agree.lz_agree.intValue());
                    this.q.add(bc9Var);
                }
            }
        }
    }

    public final void i0(DataRes dataRes) {
        Post post;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048640, this, dataRes) == null) && (post = dataRes.top_answer) != null && !this.U.contains(String.valueOf(post.id))) {
            bc9 bc9Var = new bc9();
            bc9Var.i1(this.s);
            bc9Var.M0(this.n.isBrandForum);
            bc9Var.B0(post, Q());
            bc9Var.a1(Q().getPraise());
            bc9Var.K0(dataRes.forum.id.longValue());
            bc9Var.L0(dataRes.forum.name);
            if (bc9Var.o() != null && bc9Var.o().baijiahaoData == null && Q() != null && Q().getBaijiahaoData() != null) {
                bc9Var.o().baijiahaoData = Q().getBaijiahaoData();
            }
            this.U.add(bc9Var.O());
            if (bc9Var.E() == 1 && this.p.isActInfo()) {
                if (t0()) {
                    bc9Var.Z0(0);
                } else {
                    bc9Var.Z0(this.p.getActInfoType());
                }
            } else if (bc9Var.E() == 1 && this.p.isInterviewLive()) {
                bc9Var.Z0(41);
            } else if (bc9Var.E() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                bc9Var.Z0(0);
                bc9Var.n0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    bc9Var.b1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    bc9Var.b1(TbRichTextView.Z(jSONArray, false));
                }
                this.M = bc9Var;
            }
            if (bc9Var.E() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                bc9Var.Y0(threadData2.originalThreadData);
            }
            if (bc9Var.E() == 1) {
                this.a0 = bc9Var;
                this.Z = false;
                if (bc9Var.r() != null && this.l0 != null) {
                    bc9Var.r().setBusinessAccountData(this.l0);
                }
            }
            bc9Var.j1(post);
            bc9Var.V0(post.agree.lz_agree.intValue());
            this.r = bc9Var;
        }
    }

    public final boolean n0(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, bc9Var)) == null) {
            if (bc9Var == null || bc9Var.r() == null) {
                return false;
            }
            MetaData r = bc9Var.r();
            if (TextUtils.isEmpty(r.getUserId()) && TextUtils.isEmpty(r.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
