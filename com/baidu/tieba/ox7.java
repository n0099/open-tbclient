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
import com.baidu.tieba.tbadkCore.data.PostData;
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
public class ox7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public wt4 A;
    public c18 B;
    public List<MuteUser> C;
    public xt4 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<kp8> G;
    public kp8 H;
    public TwzhiboAnti I;
    public List<su4> J;
    public List<su4> K;
    public hy7 L;
    public PostData M;
    public sx7 N;
    public long O;
    public JumpLinkInfo P;
    public cy7 Q;
    public String R;
    public String S;
    public List<RecommendTopicData.RecommendTopicListData> T;
    public HashSet<String> U;
    public List<js4> V;
    public int W;
    public q58 X;
    public PostData Y;
    public boolean Z;
    public final UserData a;
    public PostData a0;
    public String b;
    public int b0;
    public CardHListViewData c;
    public boolean c0;
    public int d;
    public int d0;
    public int e;
    public List<kp8> e0;
    public List<PbSortType> f;
    public r08 f0;
    public int g;
    public t08 g0;
    public xx7 h;
    public String h0;
    public boolean i;
    public String i0;
    public boolean j;
    public List<ThreadInfo> j0;
    public boolean k;
    public ForumRuleStatus k0;
    public jx7 l;
    public BusinessAccountData l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public int n0;
    public su4 o;
    public boolean o0;
    public ThreadData p;
    public boolean p0;
    public ArrayList<PostData> q;
    public boolean q0;
    public PostData r;
    public o15 r0;
    public HashMap<String, MetaData> s;
    public int s0;
    public tt4 t;
    public List<xn> t0;
    public AntiData u;
    public boolean u0;
    public n55 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public ox7() {
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
        this.o = new su4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new tt4();
        this.u = new AntiData();
        this.v = new n55();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new wt4();
        this.D = new xt4();
        this.B = new c18();
        this.I = new TwzhiboAnti();
        this.L = new hy7();
        this.f0 = new r08();
        this.T = new ArrayList();
        this.U = new HashSet<>();
        this.r0 = new o15();
    }

    public kp8 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.H;
        }
        return (kp8) invokeV.objValue;
    }

    public sx7 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.N;
        }
        return (sx7) invokeV.objValue;
    }

    public r08 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            r08 r08Var = this.f0;
            if (r08Var != null && r08Var.isValid()) {
                return this.f0;
            }
            return null;
        }
        return (r08) invokeV.objValue;
    }

    public t08 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            t08 t08Var = this.g0;
            if (t08Var != null && t08Var.isValid()) {
                return this.g0;
            }
            return null;
        }
        return (t08) invokeV.objValue;
    }

    public c18 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.B;
        }
        return (c18) invokeV.objValue;
    }

    public xt4 F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.D;
        }
        return (xt4) invokeV.objValue;
    }

    public ArrayList<PostData> H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public q58 I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.X;
        }
        return (q58) invokeV.objValue;
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

    public List<xn> T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.t0;
        }
        return (List) invokeV.objValue;
    }

    public cy7 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.Q;
        }
        return (cy7) invokeV.objValue;
    }

    public hy7 V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.L;
        }
        return (hy7) invokeV.objValue;
    }

    public PostData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.r;
        }
        return (PostData) invokeV.objValue;
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

    public PostData a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.M;
        }
        return (PostData) invokeV.objValue;
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

    public List<kp8> c0() {
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

    public o15 d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.r0;
        }
        return (o15) invokeV.objValue;
    }

    public ArrayList<kp8> e() {
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
            tt4 tt4Var = this.t;
            if (tt4Var != null && tt4Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<js4> f() {
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

    public su4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.o;
        }
        return (su4) invokeV.objValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.a0;
        }
        return (PostData) invokeV.objValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.Y;
        }
        return (PostData) invokeV.objValue;
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

    public List<su4> p() {
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
            ArrayList<PostData> arrayList = this.q;
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

    public tt4 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.t;
        }
        return (tt4) invokeV.objValue;
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
            kp8 kp8Var = new kp8();
            kp8Var.X0 = true;
            kp8Var.r1(dataRes.banner_list.pb_banner_ad);
            this.H = kp8Var;
        }
    }

    public void F0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.W = i;
        }
    }

    public void G0(su4 su4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, su4Var) == null) {
            this.o = su4Var;
        }
    }

    public void H0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, postData) == null) {
            this.Y = postData;
            this.a0 = postData;
            this.Z = false;
        }
    }

    public void I0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, postData) == null) {
            this.a0 = postData;
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

    public void N0(kp8 kp8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, kp8Var) == null) {
            this.H = kp8Var;
        }
    }

    public void O0(cy7 cy7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, cy7Var) == null) {
            this.Q = cy7Var;
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

    public void S0(List<xn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, list) == null) {
            this.t0 = list;
        }
    }

    public PostData T0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, postData)) == null) {
            this.M = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
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
                    kp8 kp8Var = new kp8();
                    kp8Var.d1 = y0();
                    kp8Var.r1(app);
                    if (!this.e0.contains(kp8Var)) {
                        this.e0.add(kp8Var);
                    }
                }
            }
        }
    }

    public void D0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            o15 o15Var = this.r0;
            o15Var.b = floatingIconItem.icon_url;
            o15Var.c = floatingIconItem.fold_lottie;
            o15Var.d = floatingIconItem.unfold_lottie;
            o15Var.e = floatingIconItem.float_type;
            o15Var.f = floatingIconItem.fold_name;
            o15Var.g = floatingIconItem.unfold_name;
            o15Var.a = floatingIconItem.url;
            o15Var.j = floatingIconItem.scheme;
            o15Var.k = floatingIconItem.package_name;
            o15Var.l = floatingIconItem.deeplink;
            o15Var.h = floatingIconItem.view_statistics_url;
            o15Var.i = floatingIconItem.click_statistics_url;
            o15Var.r = floatingIconItem.display_ad_icon;
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
            ph8.e().h(dataRes.asp_shown_info);
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
            if (this.p.getFid() == 0) {
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
                        this.B.X0 = this.A;
                    } else {
                        this.B.Y0 = this.A;
                    }
                } else {
                    this.B.X0 = this.A;
                }
            } else {
                this.B.W0 = this.A;
            }
            this.D.n1(dataRes.recommend_book);
            g0(dataRes);
            i0(dataRes);
            PostData postData = new PostData();
            this.Y = postData;
            postData.G0(1);
            this.Y.f1(this.s);
            this.Y.J0(this.n.isBrandForum);
            this.Y.c1(this.p.getCreateTime());
            this.Y.H0(dataRes.forum.id.longValue());
            this.Y.I0(dataRes.forum.name);
            if (dataRes.first_floor_post != null) {
                this.Y.y0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.Y.V0(this.p.originalThreadData);
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
            List<AdvertAppInfo> f = gg8.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                B0(dataRes);
                for (App app : list2) {
                    kp8 kp8Var = new kp8();
                    kp8Var.d1 = y0();
                    kp8Var.r1(app);
                    if (!this.G.contains(kp8Var)) {
                        this.G.add(kp8Var);
                        if (f != null) {
                            f.add(kp8Var.getAdvertAppInfo());
                        }
                    }
                }
                C0(dataRes);
            }
            gg8.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                sx7 sx7Var = new sx7();
                this.N = sx7Var;
                sx7Var.c(dataRes.forum_headline_img_info);
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
                    su4 su4Var = new su4();
                    su4Var.i(simpleForum);
                    this.J.add(su4Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.K == null) {
                    this.K = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        su4 su4Var2 = new su4();
                        su4Var2.i(simpleForum2);
                        this.K.add(su4Var2);
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
                        js4 js4Var = new js4();
                        js4Var.l(i4);
                        js4Var.parserProtobuf(threadInfo);
                        this.V.add(js4Var);
                        i4++;
                    }
                }
            }
            if (this.X != null && this.X.n()) {
                this.X = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.X == null) {
                    q58 q58Var = new q58();
                    this.X = q58Var;
                    q58Var.r(dataRes.recom_ala_info);
                }
            } else if (this.X == null && dataRes.promotion != null) {
                q58 q58Var2 = new q58();
                this.X = q58Var2;
                q58Var2.s(dataRes.promotion);
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
                    kx7 kx7Var = new kx7();
                    kx7Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new jx7();
                    }
                    this.l.a(kx7Var);
                }
            }
            this.f0.b();
            this.f0.c(this.s);
            this.f0.a(dataRes.recom_ala_info);
            if (this.f0.o != null) {
                this.f0.o.o(S());
            }
            t08 t08Var = new t08();
            this.g0 = t08Var;
            t08Var.b(this.s);
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

    public final PostData G() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (Q() != null && Q().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = Q().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = Q().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.G0(1);
                postData.M0(Q().getFirstPostId());
                postData.d1(Q().getTitle());
                postData.c1(Q().getCreateTime());
                postData.E0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public PostData Z() {
        InterceptResult invokeV;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (a0() != null) {
                return a0();
            }
            if (!ListUtils.isEmpty(H())) {
                Iterator<PostData> it = H().iterator();
                while (it.hasNext()) {
                    postData = it.next();
                    if (postData != null && postData.D() == 1) {
                        break;
                    }
                }
            }
            postData = null;
            if (postData == null) {
                postData = j();
            }
            if (!n0(postData)) {
                postData = G();
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    public void M0(tt4 tt4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048601, this, tt4Var, i) == null) {
            this.t.k(tt4Var.a());
            this.t.p(tt4Var.g());
            this.t.q(tt4Var.h());
            this.t.o(tt4Var.e());
            this.t.n(tt4Var.d());
            if (i == 0) {
                this.t = tt4Var;
            } else if (i == 1) {
                this.t.l(tt4Var.b());
            } else if (i == 2) {
                this.t.m(tt4Var.c());
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
                if (Q() != null && Q().getAuthor() != null && !xi.isEmpty(Q().getAuthor().getUserId())) {
                    String userId = Q().getAuthor().getUserId();
                    PostData i2 = i();
                    if (i2 != null && i2.s() != null && !xi.isEmpty(i2.s().getUserId())) {
                        if (StringHelper.equals(userId, i2.s().getUserId())) {
                            str = i2.C();
                        }
                        if (xi.isEmpty("")) {
                            str2 = i2.f0();
                        }
                    }
                    if (xi.isEmpty(str2) && xi.isEmpty(str)) {
                        for (int i3 = 0; i3 < i; i3++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i3);
                            if (postData != null && postData.s() != null && !xi.isEmpty(postData.s().getUserId()) && StringHelper.equals(userId, postData.s().getUserId())) {
                                if (xi.isEmpty(str)) {
                                    str = postData.C();
                                }
                                if (xi.isEmpty(str2)) {
                                    str2 = postData.f0();
                                }
                                if (!xi.isEmpty(str) && !xi.isEmpty(str2)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && xi.isEmpty(str)) {
                        str = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str2 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ec5) + "] " + str2;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !xi.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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
            this.Q = new cy7(this.p, this.u);
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
                this.h = xx7.i(managerElection);
            }
        }
    }

    public final void g0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, dataRes) == null) && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.U.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.f1(this.s);
                    postData.J0(this.n.isBrandForum);
                    postData.z0(post, Q());
                    postData.X0(Q().getPraise());
                    postData.H0(dataRes.forum.id.longValue());
                    postData.I0(dataRes.forum.name);
                    if (postData.q() != null && postData.q().baijiahaoData == null && Q() != null && Q().getBaijiahaoData() != null) {
                        postData.q().baijiahaoData = Q().getBaijiahaoData();
                    }
                    this.U.add(postData.M());
                    if (postData.D() == 1 && this.p.isActInfo()) {
                        if (t0()) {
                            postData.W0(0);
                        } else {
                            postData.W0(this.p.getActInfoType());
                        }
                    } else if (postData.D() == 1 && this.p.isInterviewLive()) {
                        postData.W0(41);
                    } else if (postData.D() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        postData.W0(0);
                        postData.l0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            postData.Y0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                            postData.Y0(TbRichTextView.U(jSONArray, false));
                        }
                        this.M = postData;
                    }
                    if (postData.D() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        postData.V0(threadData2.originalThreadData);
                    }
                    if (postData.D() == 1) {
                        this.a0 = postData;
                        this.Z = false;
                        if (postData.s() != null && this.l0 != null) {
                            postData.s().setBusinessAccountData(this.l0);
                        }
                    }
                    postData.g1(post);
                    postData.S0(post.agree.lz_agree.intValue());
                    this.q.add(postData);
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
            PostData postData = new PostData();
            postData.f1(this.s);
            postData.J0(this.n.isBrandForum);
            postData.z0(post, Q());
            postData.X0(Q().getPraise());
            postData.H0(dataRes.forum.id.longValue());
            postData.I0(dataRes.forum.name);
            if (postData.q() != null && postData.q().baijiahaoData == null && Q() != null && Q().getBaijiahaoData() != null) {
                postData.q().baijiahaoData = Q().getBaijiahaoData();
            }
            this.U.add(postData.M());
            if (postData.D() == 1 && this.p.isActInfo()) {
                if (t0()) {
                    postData.W0(0);
                } else {
                    postData.W0(this.p.getActInfoType());
                }
            } else if (postData.D() == 1 && this.p.isInterviewLive()) {
                postData.W0(41);
            } else if (postData.D() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                postData.W0(0);
                postData.l0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    postData.Y0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    postData.Y0(TbRichTextView.U(jSONArray, false));
                }
                this.M = postData;
            }
            if (postData.D() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                postData.V0(threadData2.originalThreadData);
            }
            if (postData.D() == 1) {
                this.a0 = postData;
                this.Z = false;
                if (postData.s() != null && this.l0 != null) {
                    postData.s().setBusinessAccountData(this.l0);
                }
            }
            postData.g1(post);
            postData.S0(post.agree.lz_agree.intValue());
            this.r = postData;
        }
    }

    public final boolean n0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048650, this, postData)) == null) {
            if (postData == null || postData.s() == null) {
                return false;
            }
            MetaData s = postData.s();
            if (TextUtils.isEmpty(s.getUserId()) && TextUtils.isEmpty(s.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
