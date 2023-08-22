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
/* loaded from: classes8.dex */
public class yh9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c35 A;
    public tl9 B;
    public List<MuteUser> C;
    public d35 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<yfa> G;
    public yfa H;
    public TwzhiboAnti I;
    public List<y35> J;
    public si9 K;
    public zfa L;
    public fi9 M;
    public long N;
    public JumpLinkInfo O;
    public oi9 P;
    public String Q;
    public String R;
    public HashSet<String> S;

    /* renamed from: T  reason: collision with root package name */
    public List<n15> f1190T;
    public int U;
    public zfa V;
    public boolean W;
    public zfa X;
    public int Y;
    public boolean Z;
    public final UserData a;
    public int a0;
    public String b;
    public List<yfa> b0;
    public CardHListViewData c;
    public kl9 c0;
    public int d;
    public String d0;
    public int e;
    public String e0;
    public List<PbSortType> f;
    public List<ThreadInfo> f0;
    public int g;
    public ForumRuleStatus g0;
    public ji9 h;
    public BusinessAccountData h0;
    public boolean i;
    public boolean i0;
    public boolean j;
    public int j0;
    public boolean k;
    public boolean k0;
    public vh9 l;
    public boolean l0;
    public boolean m;
    public boolean m0;
    public ForumData n;
    public cc5 n0;
    public y35 o;
    public int o0;
    public ThreadData p;
    public List<bn> p0;
    public ArrayList<zfa> q;
    public SimilarContent q0;
    public zfa r;
    public RobotEntrance r0;
    public HashMap<String, MetaData> s;
    public boolean s0;
    public z25 t;
    public AntiData u;
    public vg5 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public yh9() {
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
        this.o = new y35();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new z25();
        this.u = new AntiData();
        this.v = new vg5();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new c35();
        this.D = new d35();
        this.B = new tl9();
        this.I = new TwzhiboAnti();
        this.K = new si9();
        this.c0 = new kl9();
        this.S = new HashSet<>();
        this.n0 = new cc5();
    }

    public fi9 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.M;
        }
        return (fi9) invokeV.objValue;
    }

    public kl9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            kl9 kl9Var = this.c0;
            if (kl9Var != null && kl9Var.isValid()) {
                return this.c0;
            }
            return null;
        }
        return (kl9) invokeV.objValue;
    }

    public tl9 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.B;
        }
        return (tl9) invokeV.objValue;
    }

    public d35 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.D;
        }
        return (d35) invokeV.objValue;
    }

    public ArrayList<zfa> F() {
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

    public List<bn> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return this.p0;
        }
        return (List) invokeV.objValue;
    }

    public oi9 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.P;
        }
        return (oi9) invokeV.objValue;
    }

    public si9 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.K;
        }
        return (si9) invokeV.objValue;
    }

    public zfa U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.r;
        }
        return (zfa) invokeV.objValue;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public zfa Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.L;
        }
        return (zfa) invokeV.objValue;
    }

    public String Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048623, this) == null) {
            this.c0 = null;
        }
    }

    public List<yfa> a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            return this.b0;
        }
        return (List) invokeV.objValue;
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

    public cc5 b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            return this.n0;
        }
        return (cc5) invokeV.objValue;
    }

    public AntiData c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public boolean c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            z25 z25Var = this.t;
            if (z25Var != null && z25Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ArrayList<yfa> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List<n15> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) {
            return this.f1190T;
        }
        return (List) invokeV.objValue;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) {
            return this.U;
        }
        return invokeV.intValue;
    }

    public y35 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) {
            return this.o;
        }
        return (y35) invokeV.objValue;
    }

    public zfa h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) {
            return this.X;
        }
        return (zfa) invokeV.objValue;
    }

    public boolean h0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.s0;
        }
        return invokeV.booleanValue;
    }

    public zfa i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.V;
        }
        return (zfa) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.i0;
        }
        return invokeV.booleanValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            return this.g0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List<y35> o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            return this.J;
        }
        return (List) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048656, this)) == null) {
            return this.k0;
        }
        return invokeV.booleanValue;
    }

    public int r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.m0;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.O;
        }
        return (JumpLinkInfo) invokeV.objValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            ArrayList<zfa> arrayList = this.q;
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            if (O() != null && O().isVideoThreadType() && O().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public z25 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            return this.t;
        }
        return (z25) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            if (O() != null && O().worksInfoData != null && O().worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public yfa z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048673, this)) == null) {
            return this.H;
        }
        return (yfa) invokeV.objValue;
    }

    public final void A0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            yfa yfaVar = new yfa();
            yfaVar.g1 = true;
            yfaVar.E1(dataRes.banner_list.pb_banner_ad);
            this.H = yfaVar;
        }
    }

    public void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.U = i;
        }
    }

    public void F0(y35 y35Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, y35Var) == null) {
            this.o = y35Var;
        }
    }

    public void G0(zfa zfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, zfaVar) == null) {
            this.V = zfaVar;
            this.X = zfaVar;
            this.W = false;
        }
    }

    public void H0(zfa zfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, zfaVar) == null) {
            this.X = zfaVar;
        }
    }

    public void I0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048593, this, z) != null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public void J0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.x = i;
        }
    }

    public void K0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048597, this, str) == null) && (threadData = this.p) != null) {
            threadData.setMarkID(str);
        }
    }

    public void M0(yfa yfaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, yfaVar) == null) {
            this.H = yfaVar;
        }
    }

    public void N0(oi9 oi9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, oi9Var) == null) {
            this.P = oi9Var;
        }
    }

    public void O0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.j0 = i;
        }
    }

    public void P0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void Q0(RobotEntrance robotEntrance) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, robotEntrance) == null) {
            this.r0 = robotEntrance;
        }
    }

    public void R0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void S0(List<bn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, list) == null) {
            this.p0 = list;
        }
    }

    public zfa T0(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, zfaVar)) == null) {
            this.L = zfaVar;
            return zfaVar;
        }
        return (zfa) invokeL.objValue;
    }

    public void U0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.b = str;
        }
    }

    public boolean u0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048664, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void z0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048674, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    public final void B0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.b0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    yfa yfaVar = new yfa();
                    yfaVar.m1 = x0();
                    yfaVar.E1(app);
                    if (!this.b0.contains(yfaVar)) {
                        this.b0.add(yfaVar);
                    }
                }
            }
        }
    }

    public void C0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            cc5 cc5Var = this.n0;
            cc5Var.b = floatingIconItem.icon_url;
            cc5Var.c = floatingIconItem.fold_lottie;
            cc5Var.d = floatingIconItem.unfold_lottie;
            cc5Var.e = floatingIconItem.float_type;
            cc5Var.f = floatingIconItem.fold_name;
            cc5Var.g = floatingIconItem.unfold_name;
            cc5Var.a = floatingIconItem.url;
            cc5Var.j = floatingIconItem.scheme;
            cc5Var.k = floatingIconItem.package_name;
            cc5Var.l = floatingIconItem.deeplink;
            cc5Var.h = floatingIconItem.view_statistics_url;
            cc5Var.i = floatingIconItem.click_statistics_url;
            cc5Var.r = floatingIconItem.display_ad_icon;
        }
    }

    public final void d0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048630, this, dataRes) == null) {
            this.P = new oi9(this.p, this.u);
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
                this.h = ji9.i(managerElection);
            }
        }
    }

    public final void f0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048634, this, dataRes) == null) && (list = dataRes.feed_thread_list) != null && list.size() > 0) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048640, this, threadInfo)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048666, this, threadInfo)) == null) {
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

    public void D0(DataRes dataRes) {
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048583, this, dataRes) != null) || dataRes == null) {
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
            J0(dataRes.is_new_url.intValue());
            z0(dataRes);
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
                        this.B.g1 = this.A;
                    } else {
                        this.B.h1 = this.A;
                    }
                } else {
                    this.B.g1 = this.A;
                }
            } else {
                this.B.f1 = this.A;
            }
            this.D.A1(dataRes.recommend_book);
            e0(dataRes);
            g0(dataRes);
            zfa zfaVar = new zfa();
            this.V = zfaVar;
            zfaVar.S0(1);
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
            List<AdvertAppInfo> g = r1a.m().g();
            if (g != null) {
                g.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                A0(dataRes);
                for (App app : list2) {
                    yfa yfaVar = new yfa();
                    yfaVar.m1 = x0();
                    yfaVar.E1(app);
                    if (!this.G.contains(yfaVar)) {
                        this.G.add(yfaVar);
                        if (g != null) {
                            g.add(yfaVar.getAdvertAppInfo());
                        }
                    }
                }
                B0(dataRes);
            }
            r1a.m().f();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            if (dataRes.forum_headline_img_info != null) {
                fi9 fi9Var = new fi9();
                this.M = fi9Var;
                fi9Var.b(dataRes.forum_headline_img_info);
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
                        y35 y35Var = new y35();
                        y35Var.l(simpleForum);
                        this.J.add(y35Var);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.N >= 0) {
                this.N = dataRes.thread_freq_num.longValue();
            }
            d0(dataRes);
            if (this.f1190T == null) {
                this.f1190T = new ArrayList();
            }
            this.f1190T.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !v0(threadInfo) && !i0(threadInfo)) {
                        n15 n15Var = new n15();
                        n15Var.g(i4);
                        n15Var.parserProtobuf(threadInfo);
                        this.f1190T.add(n15Var);
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
                    wh9 wh9Var = new wh9();
                    wh9Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new vh9();
                    }
                    this.l.a(wh9Var);
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
            C0(dataRes.floating_icon);
            this.o0 = dataRes.has_fold_comment.intValue();
            this.q0 = dataRes.similar_content;
            this.r0 = dataRes.robot_entrance;
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public final zfa E() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            if (O() != null && O().getAuthor() != null) {
                zfa zfaVar = new zfa();
                MetaData author = O().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = O().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                zfaVar.S0(1);
                zfaVar.Y0(O().getFirstPostId());
                zfaVar.p1(O().getTitle());
                zfaVar.o1(O().getCreateTime());
                zfaVar.N0(author);
                return zfaVar;
            }
            return null;
        }
        return (zfa) invokeV.objValue;
    }

    public zfa X() {
        InterceptResult invokeV;
        zfa zfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (Y() != null) {
                return Y();
            }
            if (!ListUtils.isEmpty(F())) {
                Iterator<zfa> it = F().iterator();
                while (it.hasNext()) {
                    zfaVar = it.next();
                    if (zfaVar != null && zfaVar.I() == 1) {
                        break;
                    }
                }
            }
            zfaVar = null;
            if (zfaVar == null) {
                zfaVar = i();
            }
            if (!l0(zfaVar)) {
                zfaVar = E();
            }
            if (zfaVar != null && zfaVar.r() != null && zfaVar.r().getUserTbVipInfoData() != null && zfaVar.r().getUserTbVipInfoData().getvipIntro() != null) {
                zfaVar.r().getGodUserData().setIntro(zfaVar.r().getUserTbVipInfoData().getvipIntro());
            }
            return zfaVar;
        }
        return (zfa) invokeV.objValue;
    }

    public void L0(z25 z25Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, z25Var, i) == null) {
            this.t.k(z25Var.a());
            this.t.p(z25Var.g());
            this.t.q(z25Var.h());
            this.t.o(z25Var.e());
            this.t.n(z25Var.d());
            if (i == 0) {
                this.t = z25Var;
            } else if (i == 1) {
                this.t.l(z25Var.b());
            } else if (i == 2) {
                this.t.m(z25Var.c());
            }
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
                if (O() != null && O().getAuthor() != null && !di.isEmpty(O().getAuthor().getUserId())) {
                    String userId = O().getAuthor().getUserId();
                    zfa h = h();
                    if (h == null || h.r() == null || di.isEmpty(h.r().getUserId())) {
                        str2 = "";
                    } else {
                        if (!StringHelper.equals(userId, h.r().getUserId())) {
                            str2 = "";
                        } else {
                            str2 = h.H();
                        }
                        if (di.isEmpty("")) {
                            str4 = h.m0();
                        }
                    }
                    if (di.isEmpty(str4) && di.isEmpty(str2)) {
                        for (int i = 0; i < min; i++) {
                            zfa zfaVar = (zfa) ListUtils.getItem(this.q, i);
                            if (zfaVar != null && zfaVar.r() != null && !di.isEmpty(zfaVar.r().getUserId()) && StringHelper.equals(userId, zfaVar.r().getUserId())) {
                                if (di.isEmpty(str2)) {
                                    str2 = zfaVar.H();
                                }
                                if (di.isEmpty(str4)) {
                                    str4 = zfaVar.m0();
                                }
                                if (!di.isEmpty(str2) && !di.isEmpty(str4)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && di.isEmpty(str2)) {
                        str2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str4 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.photo_live_tips) + "] " + str4;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !di.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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

    public final void e0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048632, this, dataRes) == null) && dataRes != null && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.S.contains(String.valueOf(post.id))) {
                    zfa zfaVar = new zfa();
                    zfaVar.r1(this.s);
                    zfaVar.V0(this.n.isBrandForum);
                    zfaVar.I0(post, O());
                    zfaVar.j1(O().getPraise());
                    SimpleForum simpleForum = dataRes.forum;
                    if (simpleForum != null) {
                        zfaVar.T0(simpleForum.id.longValue());
                        zfaVar.U0(dataRes.forum.name);
                    }
                    if (zfaVar.o() != null && zfaVar.o().baijiahaoData == null && O() != null && O().getBaijiahaoData() != null) {
                        zfaVar.o().baijiahaoData = O().getBaijiahaoData();
                    }
                    this.S.add(zfaVar.S());
                    if (zfaVar.I() == 1 && this.p.isActInfo()) {
                        if (s0()) {
                            zfaVar.i1(0);
                        } else {
                            zfaVar.i1(this.p.getActInfoType());
                        }
                    } else if (zfaVar.I() == 1 && this.p.isInterviewLive()) {
                        zfaVar.i1(41);
                    } else if (zfaVar.I() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        zfaVar.i1(0);
                        zfaVar.t0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            zfaVar.k1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                            zfaVar.k1(TbRichTextView.Z(jSONArray, false));
                        }
                        this.L = zfaVar;
                    }
                    if (zfaVar.I() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        zfaVar.h1(threadData2.originalThreadData);
                    }
                    if (zfaVar.I() == 1) {
                        this.X = zfaVar;
                        this.W = false;
                        if (zfaVar.r() != null && this.h0 != null) {
                            zfaVar.r().setBusinessAccountData(this.h0);
                        }
                    }
                    zfaVar.s1(post);
                    zfaVar.e1(post.agree.lz_agree.intValue());
                    this.q.add(zfaVar);
                }
            }
        }
    }

    public final void g0(DataRes dataRes) {
        Post post;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048636, this, dataRes) == null) && (post = dataRes.top_answer) != null && !this.S.contains(String.valueOf(post.id))) {
            zfa zfaVar = new zfa();
            zfaVar.r1(this.s);
            zfaVar.V0(this.n.isBrandForum);
            zfaVar.I0(post, O());
            zfaVar.j1(O().getPraise());
            zfaVar.T0(dataRes.forum.id.longValue());
            zfaVar.U0(dataRes.forum.name);
            if (zfaVar.o() != null && zfaVar.o().baijiahaoData == null && O() != null && O().getBaijiahaoData() != null) {
                zfaVar.o().baijiahaoData = O().getBaijiahaoData();
            }
            this.S.add(zfaVar.S());
            if (zfaVar.I() == 1 && this.p.isActInfo()) {
                if (s0()) {
                    zfaVar.i1(0);
                } else {
                    zfaVar.i1(this.p.getActInfoType());
                }
            } else if (zfaVar.I() == 1 && this.p.isInterviewLive()) {
                zfaVar.i1(41);
            } else if (zfaVar.I() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                zfaVar.i1(0);
                zfaVar.t0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    zfaVar.k1(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    zfaVar.k1(TbRichTextView.Z(jSONArray, false));
                }
                this.L = zfaVar;
            }
            if (zfaVar.I() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                zfaVar.h1(threadData2.originalThreadData);
            }
            if (zfaVar.I() == 1) {
                this.X = zfaVar;
                this.W = false;
                if (zfaVar.r() != null && this.h0 != null) {
                    zfaVar.r().setBusinessAccountData(this.h0);
                }
            }
            zfaVar.s1(post);
            zfaVar.e1(post.agree.lz_agree.intValue());
            this.r = zfaVar;
        }
    }

    public final boolean l0(zfa zfaVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048646, this, zfaVar)) == null) {
            if (zfaVar == null || zfaVar.r() == null) {
                return false;
            }
            MetaData r = zfaVar.r();
            if (TextUtils.isEmpty(r.getUserId()) && TextUtils.isEmpty(r.getAvater())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
