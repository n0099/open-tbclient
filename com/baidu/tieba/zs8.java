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
import tbclient.Post;
import tbclient.SimpleForum;
import tbclient.SimpleUser;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes7.dex */
public class zs8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public oy4 A;
    public jw8 B;
    public List<MuteUser> C;
    public py4 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<rl9> G;
    public rl9 H;
    public TwzhiboAnti I;
    public List<kz4> J;
    public rt8 K;
    public sl9 L;
    public dt8 M;
    public long N;
    public JumpLinkInfo O;
    public nt8 P;
    public String Q;
    public String R;
    public HashSet<String> S;
    public List<ax4> T;
    public int U;
    public sl9 V;
    public boolean W;
    public sl9 X;
    public int Y;
    public boolean Z;
    public final UserData a;
    public int a0;
    public String b;
    public List<rl9> b0;
    public CardHListViewData c;
    public aw8 c0;
    public int d;
    public String d0;
    public int e;
    public String e0;
    public List<PbSortType> f;
    public List<ThreadInfo> f0;
    public int g;
    public ForumRuleStatus g0;
    public it8 h;
    public BusinessAccountData h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public boolean k0;
    public ws8 l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public n75 n0;
    public kz4 o;
    public int o0;
    public ThreadData p;
    public List<hn> p0;
    public ArrayList<sl9> q;
    public boolean q0;
    public sl9 r;
    public HashMap<String, MetaData> s;
    public ly4 t;
    public AntiData u;
    public sb5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public zs8() {
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
        this.q0 = false;
        this.n = new ForumData();
        this.o = new kz4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new ly4();
        this.u = new AntiData();
        this.v = new sb5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new oy4();
        this.D = new py4();
        this.B = new jw8();
        this.I = new TwzhiboAnti();
        this.K = new rt8();
        this.c0 = new aw8();
        this.S = new HashSet<>();
        this.n0 = new n75();
    }

    public dt8 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.M;
        }
        return (dt8) invokeV.objValue;
    }

    public aw8 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            aw8 aw8Var = this.c0;
            if (aw8Var != null && aw8Var.isValid()) {
                return this.c0;
            }
            return null;
        }
        return (aw8) invokeV.objValue;
    }

    public jw8 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.B;
        }
        return (jw8) invokeV.objValue;
    }

    public py4 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.D;
        }
        return (py4) invokeV.objValue;
    }

    public ArrayList<sl9> F() {
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

    public ThreadData M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    public long N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.N;
        }
        return invokeV.longValue;
    }

    public String O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List<hn> P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.p0;
        }
        return (List) invokeV.objValue;
    }

    public nt8 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.P;
        }
        return (nt8) invokeV.objValue;
    }

    public rt8 R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.K;
        }
        return (rt8) invokeV.objValue;
    }

    public sl9 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.r;
        }
        return (sl9) invokeV.objValue;
    }

    public UserData T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public int U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public sl9 W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.L;
        }
        return (sl9) invokeV.objValue;
    }

    public String X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public List<rl9> Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.b0;
        }
        return (List) invokeV.objValue;
    }

    public n75 Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.n0;
        }
        return (n75) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048620, this) == null) {
            this.c0 = null;
        }
    }

    public boolean a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            ly4 ly4Var = this.t;
            if (ly4Var != null && ly4Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public ArrayList<rl9> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<ax4> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.T;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.U;
        }
        return invokeV.intValue;
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.q0;
        }
        return invokeV.booleanValue;
    }

    public kz4 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.o;
        }
        return (kz4) invokeV.objValue;
    }

    public sl9 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.X;
        }
        return (sl9) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            if (M() != null && M().isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public sl9 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.V;
        }
        return (sl9) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public ForumData k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            if (r() == 1 || h0()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            if (M() != null && M().isLongNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumRuleStatus n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) {
            return this.g0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
            if (M() != null && M().isNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<kz4> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
            return this.J;
        }
        return (List) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.k0;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.m0;
        }
        return invokeV.booleanValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (this.p.getIsMarked() != 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.O;
        }
        return (JumpLinkInfo) invokeV.objValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getMarkID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public boolean u0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            ArrayList<sl9> arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
            if (M() != null && M().isVideoThreadType() && M().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            if (M() != null && M().worksInfoData != null && M().worksInfoData.isWorks) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public ly4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.t;
        }
        return (ly4) invokeV.objValue;
    }

    public rl9 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.H;
        }
        return (rl9) invokeV.objValue;
    }

    public void A0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            n75 n75Var = this.n0;
            n75Var.b = floatingIconItem.icon_url;
            n75Var.c = floatingIconItem.fold_lottie;
            n75Var.d = floatingIconItem.unfold_lottie;
            n75Var.e = floatingIconItem.float_type;
            n75Var.f = floatingIconItem.fold_name;
            n75Var.g = floatingIconItem.unfold_name;
            n75Var.a = floatingIconItem.url;
            n75Var.j = floatingIconItem.scheme;
            n75Var.k = floatingIconItem.package_name;
            n75Var.l = floatingIconItem.deeplink;
            n75Var.h = floatingIconItem.view_statistics_url;
            n75Var.i = floatingIconItem.click_statistics_url;
            n75Var.r = floatingIconItem.display_ad_icon;
        }
    }

    public final void b0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, dataRes) == null) {
            this.P = new nt8(this.p, this.u);
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
                this.h = it8.i(managerElection);
            }
        }
    }

    public final void d0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048627, this, dataRes) == null) && (list = dataRes.feed_thread_list) != null && list.size() > 0) {
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

    public final boolean g0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048633, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (threadData = this.p) == null || threadData.getBaijiahaoData() == null || this.p.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.getBaijiahaoData().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public final boolean t0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048659, this, threadInfo)) == null) {
            if (threadInfo == null || O() == null || threadInfo.id.longValue() == 0 || threadInfo.tid.longValue() == 0) {
                return false;
            }
            if (!O().equals(threadInfo.id.toString()) && !O().equals(threadInfo.tid.toString())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void z0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048671, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.b0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    rl9 rl9Var = new rl9();
                    rl9Var.h1 = v0();
                    rl9Var.v1(app);
                    if (!this.b0.contains(rl9Var)) {
                        this.b0.add(rl9Var);
                    }
                }
            }
        }
    }

    public void B0(DataRes dataRes) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, dataRes) != null) || dataRes == null) {
            return;
        }
        try {
            if (dataRes.jump_link_info != null) {
                this.O = dataRes.jump_link_info;
            }
            fc9.e().h(dataRes.asp_shown_info);
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
            H0(dataRes.is_new_url.intValue());
            x0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.i(dataRes.display_forum);
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
                        this.B.b1 = this.A;
                    } else {
                        this.B.c1 = this.A;
                    }
                } else {
                    this.B.b1 = this.A;
                }
            } else {
                this.B.a1 = this.A;
            }
            this.D.r1(dataRes.recommend_book);
            c0(dataRes);
            e0(dataRes);
            sl9 sl9Var = new sl9();
            this.V = sl9Var;
            sl9Var.K0(1);
            this.V.j1(this.s);
            this.V.N0(this.n.isBrandForum);
            this.V.g1(this.p.getCreateTime());
            if (dataRes.forum != null) {
                this.V.L0(dataRes.forum.id.longValue());
                this.V.M0(dataRes.forum.name);
            }
            if (dataRes.first_floor_post != null) {
                this.V.B0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.V.Z0(this.p.originalThreadData);
            }
            if (this.X == null) {
                this.X = this.V;
                this.W = true;
            }
            this.t.j(dataRes.page);
            if (dataRes.page != null && dataRes.page.has_more.intValue() == 0) {
                this.q0 = true;
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
            List<AdvertAppInfo> f = va9.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                y0(dataRes);
                for (App app : list2) {
                    rl9 rl9Var = new rl9();
                    rl9Var.h1 = v0();
                    rl9Var.v1(app);
                    if (!this.G.contains(rl9Var)) {
                        this.G.add(rl9Var);
                        if (f != null) {
                            f.add(rl9Var.getAdvertAppInfo());
                        }
                    }
                }
                z0(dataRes);
            }
            va9.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            if (dataRes.forum_headline_img_info != null) {
                dt8 dt8Var = new dt8();
                this.M = dt8Var;
                dt8Var.b(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            d0(dataRes);
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.from_forum_list) {
                    if (simpleForum != null) {
                        kz4 kz4Var = new kz4();
                        kz4Var.i(simpleForum);
                        this.J.add(kz4Var);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            b0(dataRes);
            if (this.T == null) {
                this.T = new ArrayList();
            }
            this.T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !t0(threadInfo) && !g0(threadInfo)) {
                        ax4 ax4Var = new ax4();
                        ax4Var.h(i4);
                        ax4Var.parserProtobuf(threadInfo);
                        this.T.add(ax4Var);
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
                    xs8 xs8Var = new xs8();
                    xs8Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new ws8();
                    }
                    this.l.a(xs8Var);
                }
            }
            this.c0.b();
            this.c0.c(this.s);
            this.c0.a(dataRes.recom_ala_info);
            if (this.c0.o != null) {
                this.c0.o.o(O());
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
            A0(dataRes.floating_icon);
            this.o0 = dataRes.has_fold_comment.intValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public void C0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.U = i;
        }
    }

    public void D0(kz4 kz4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, kz4Var) == null) {
            this.o = kz4Var;
        }
    }

    public void E0(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, sl9Var) == null) {
            this.V = sl9Var;
            this.X = sl9Var;
            this.W = false;
        }
    }

    public void F0(sl9 sl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, sl9Var) == null) {
            this.X = sl9Var;
        }
    }

    public void G0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048589, this, z) != null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public void H0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.x = i;
        }
    }

    public void I0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && (threadData = this.p) != null) {
            threadData.setMarkID(str);
        }
    }

    public void K0(rl9 rl9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, rl9Var) == null) {
            this.H = rl9Var;
        }
    }

    public void L0(nt8 nt8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, nt8Var) == null) {
            this.P = nt8Var;
        }
    }

    public void M0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
            this.j0 = i;
        }
    }

    public void N0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048603, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void O0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void P0(List<hn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, list) == null) {
            this.p0 = list;
        }
    }

    public sl9 Q0(sl9 sl9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, sl9Var)) == null) {
            this.L = sl9Var;
            return sl9Var;
        }
        return (sl9) invokeL.objValue;
    }

    public void R0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.b = str;
        }
    }

    public boolean s0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048657, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void x0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048667, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    public final void y0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048669, this, dataRes) == null) {
            rl9 rl9Var = new rl9();
            rl9Var.b1 = true;
            rl9Var.v1(dataRes.banner_list.pb_banner_ad);
            this.H = rl9Var;
        }
    }

    public final sl9 E() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (M() != null && M().getAuthor() != null) {
                sl9 sl9Var = new sl9();
                MetaData author = M().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = M().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                sl9Var.K0(1);
                sl9Var.Q0(M().getFirstPostId());
                sl9Var.h1(M().getTitle());
                sl9Var.g1(M().getCreateTime());
                sl9Var.H0(author);
                return sl9Var;
            }
            return null;
        }
        return (sl9) invokeV.objValue;
    }

    public sl9 V() {
        InterceptResult invokeV;
        sl9 sl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            if (W() != null) {
                return W();
            }
            if (!ListUtils.isEmpty(F())) {
                Iterator<sl9> it = F().iterator();
                while (it.hasNext()) {
                    sl9Var = it.next();
                    if (sl9Var != null && sl9Var.E() == 1) {
                        break;
                    }
                }
            }
            sl9Var = null;
            if (sl9Var == null) {
                sl9Var = i();
            }
            if (!j0(sl9Var)) {
                sl9Var = E();
            }
            if (sl9Var != null && sl9Var.q() != null && sl9Var.q().getUserTbVipInfoData() != null && sl9Var.q().getUserTbVipInfoData().getvipIntro() != null) {
                sl9Var.q().getGodUserData().setIntro(sl9Var.q().getUserTbVipInfoData().getvipIntro());
            }
            return sl9Var;
        }
        return (sl9) invokeV.objValue;
    }

    public void J0(ly4 ly4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, ly4Var, i) == null) {
            this.t.k(ly4Var.a());
            this.t.p(ly4Var.g());
            this.t.q(ly4Var.h());
            this.t.o(ly4Var.e());
            this.t.n(ly4Var.d());
            if (i == 0) {
                this.t = ly4Var;
            } else if (i == 1) {
                this.t.l(ly4Var.b());
            } else if (i == 2) {
                this.t.m(ly4Var.c());
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
            if (!u0()) {
                str = "";
            } else {
                int min = Math.min(this.q.size(), 30);
                if (M() != null && M().getAuthor() != null && !hi.isEmpty(M().getAuthor().getUserId())) {
                    String userId = M().getAuthor().getUserId();
                    sl9 h = h();
                    if (h == null || h.q() == null || hi.isEmpty(h.q().getUserId())) {
                        str2 = "";
                    } else {
                        if (!StringHelper.equals(userId, h.q().getUserId())) {
                            str2 = "";
                        } else {
                            str2 = h.D();
                        }
                        if (hi.isEmpty("")) {
                            str4 = h.i0();
                        }
                    }
                    if (hi.isEmpty(str4) && hi.isEmpty(str2)) {
                        for (int i = 0; i < min; i++) {
                            sl9 sl9Var = (sl9) ListUtils.getItem(this.q, i);
                            if (sl9Var != null && sl9Var.q() != null && !hi.isEmpty(sl9Var.q().getUserId()) && StringHelper.equals(userId, sl9Var.q().getUserId())) {
                                if (hi.isEmpty(str2)) {
                                    str2 = sl9Var.D();
                                }
                                if (hi.isEmpty(str4)) {
                                    str4 = sl9Var.i0();
                                }
                                if (!hi.isEmpty(str2) && !hi.isEmpty(str4)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && hi.isEmpty(str2)) {
                        str2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str4 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str4;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !hi.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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

    public final void c0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048625, this, dataRes) == null) && dataRes != null && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.S.contains(String.valueOf(post.id))) {
                    sl9 sl9Var = new sl9();
                    sl9Var.j1(this.s);
                    sl9Var.N0(this.n.isBrandForum);
                    sl9Var.C0(post, M());
                    sl9Var.b1(M().getPraise());
                    SimpleForum simpleForum = dataRes.forum;
                    if (simpleForum != null) {
                        sl9Var.L0(simpleForum.id.longValue());
                        sl9Var.M0(dataRes.forum.name);
                    }
                    if (sl9Var.n() != null && sl9Var.n().baijiahaoData == null && M() != null && M().getBaijiahaoData() != null) {
                        sl9Var.n().baijiahaoData = M().getBaijiahaoData();
                    }
                    this.S.add(sl9Var.O());
                    if (sl9Var.E() == 1 && this.p.isActInfo()) {
                        if (q0()) {
                            sl9Var.a1(0);
                        } else {
                            sl9Var.a1(this.p.getActInfoType());
                        }
                    } else if (sl9Var.E() == 1 && this.p.isInterviewLive()) {
                        sl9Var.a1(41);
                    } else if (sl9Var.E() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        sl9Var.a1(0);
                        sl9Var.o0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            sl9Var.c1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                            sl9Var.c1(TbRichTextView.Z(jSONArray, false));
                        }
                        this.L = sl9Var;
                    }
                    if (sl9Var.E() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        sl9Var.Z0(threadData2.originalThreadData);
                    }
                    if (sl9Var.E() == 1) {
                        this.X = sl9Var;
                        this.W = false;
                        if (sl9Var.q() != null && this.h0 != null) {
                            sl9Var.q().setBusinessAccountData(this.h0);
                        }
                    }
                    sl9Var.k1(post);
                    sl9Var.W0(post.agree.lz_agree.intValue());
                    this.q.add(sl9Var);
                }
            }
        }
    }

    public final void e0(DataRes dataRes) {
        Post post;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048629, this, dataRes) == null) && (post = dataRes.top_answer) != null && !this.S.contains(String.valueOf(post.id))) {
            sl9 sl9Var = new sl9();
            sl9Var.j1(this.s);
            sl9Var.N0(this.n.isBrandForum);
            sl9Var.C0(post, M());
            sl9Var.b1(M().getPraise());
            sl9Var.L0(dataRes.forum.id.longValue());
            sl9Var.M0(dataRes.forum.name);
            if (sl9Var.n() != null && sl9Var.n().baijiahaoData == null && M() != null && M().getBaijiahaoData() != null) {
                sl9Var.n().baijiahaoData = M().getBaijiahaoData();
            }
            this.S.add(sl9Var.O());
            if (sl9Var.E() == 1 && this.p.isActInfo()) {
                if (q0()) {
                    sl9Var.a1(0);
                } else {
                    sl9Var.a1(this.p.getActInfoType());
                }
            } else if (sl9Var.E() == 1 && this.p.isInterviewLive()) {
                sl9Var.a1(41);
            } else if (sl9Var.E() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                sl9Var.a1(0);
                sl9Var.o0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    sl9Var.c1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    sl9Var.c1(TbRichTextView.Z(jSONArray, false));
                }
                this.L = sl9Var;
            }
            if (sl9Var.E() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                sl9Var.Z0(threadData2.originalThreadData);
            }
            if (sl9Var.E() == 1) {
                this.X = sl9Var;
                this.W = false;
                if (sl9Var.q() != null && this.h0 != null) {
                    sl9Var.q().setBusinessAccountData(this.h0);
                }
            }
            sl9Var.k1(post);
            sl9Var.W0(post.agree.lz_agree.intValue());
            this.r = sl9Var;
        }
    }

    public final boolean j0(sl9 sl9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048639, this, sl9Var)) == null) {
            if (sl9Var == null || sl9Var.q() == null) {
                return false;
            }
            MetaData q = sl9Var.q();
            if (TextUtils.isEmpty(q.getUserId()) && TextUtils.isEmpty(q.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
