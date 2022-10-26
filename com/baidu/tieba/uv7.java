package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
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
/* loaded from: classes6.dex */
public class uv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public et4 A;
    public iz7 B;
    public List C;
    public ft4 D;
    public List E;
    public AlaLiveInfoCoreData F;
    public ArrayList G;
    public qn8 H;
    public TwzhiboAnti I;
    public List J;
    public List K;
    public nw7 L;
    public PostData M;
    public yv7 N;
    public long O;
    public iw7 P;
    public String Q;
    public String R;
    public List S;
    public HashSet T;
    public List U;
    public int V;
    public v38 W;
    public PostData X;
    public boolean Y;
    public PostData Z;
    public final UserData a;
    public int a0;
    public String b;
    public boolean b0;
    public CardHListViewData c;
    public int c0;
    public int d;
    public List d0;
    public int e;
    public xy7 e0;
    public List f;
    public zy7 f0;
    public int g;
    public String g0;
    public dw7 h;
    public String h0;
    public boolean i;
    public List i0;
    public boolean j;
    public ForumRuleStatus j0;
    public boolean k;
    public BusinessAccountData k0;
    public pv7 l;
    public boolean l0;
    public boolean m;
    public int m0;
    public ForumData n;
    public boolean n0;
    public zt4 o;
    public boolean o0;
    public ThreadData p;
    public boolean p0;
    public ArrayList q;
    public t05 q0;
    public PostData r;
    public int r0;
    public HashMap s;
    public List s0;
    public bt4 t;
    public boolean t0;
    public AntiData u;
    public p45 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public uv7() {
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
        this.G = new ArrayList();
        this.H = null;
        this.I = null;
        this.V = 0;
        this.Y = true;
        this.a0 = 0;
        this.c0 = 0;
        this.d0 = new ArrayList();
        this.m0 = 0;
        this.r0 = 0;
        this.t0 = false;
        this.n = new ForumData();
        this.o = new zt4();
        this.p = new ThreadData();
        this.q = new ArrayList();
        this.s = new HashMap();
        this.t = new bt4();
        this.u = new AntiData();
        this.v = new p45();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new et4();
        this.D = new ft4();
        this.B = new iz7();
        this.I = new TwzhiboAnti();
        this.L = new nw7();
        this.e0 = new xy7();
        this.S = new ArrayList();
        this.T = new HashSet();
        this.q0 = new t05();
    }

    public yv7 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.N;
        }
        return (yv7) invokeV.objValue;
    }

    public xy7 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            xy7 xy7Var = this.e0;
            if (xy7Var != null && xy7Var.isValid()) {
                return this.e0;
            }
            return null;
        }
        return (xy7) invokeV.objValue;
    }

    public zy7 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            zy7 zy7Var = this.f0;
            if (zy7Var != null && zy7Var.isValid()) {
                return this.f0;
            }
            return null;
        }
        return (zy7) invokeV.objValue;
    }

    public iz7 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.B;
        }
        return (iz7) invokeV.objValue;
    }

    public ft4 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.D;
        }
        return (ft4) invokeV.objValue;
    }

    public ArrayList G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public v38 H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.W;
        }
        return (v38) invokeV.objValue;
    }

    public int I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.m0;
        }
        return invokeV.intValue;
    }

    public List J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.i0;
        }
        return (List) invokeV.objValue;
    }

    public AlaLiveInfoCoreData K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.F;
        }
        return (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public List L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return this.E;
        }
        return (List) invokeV.objValue;
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

    public String[] N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return O(true);
        }
        return (String[]) invokeV.objValue;
    }

    public ThreadData P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.p;
        }
        return (ThreadData) invokeV.objValue;
    }

    public long Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return this.O;
        }
        return invokeV.longValue;
    }

    public String R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getId();
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public List S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return this.s0;
        }
        return (List) invokeV.objValue;
    }

    public iw7 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) {
            return this.P;
        }
        return (iw7) invokeV.objValue;
    }

    public nw7 U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return this.L;
        }
        return (nw7) invokeV.objValue;
    }

    public PostData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return this.r;
        }
        return (PostData) invokeV.objValue;
    }

    public UserData W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.a;
        }
        return (UserData) invokeV.objValue;
    }

    public int X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            return this.w;
        }
        return invokeV.intValue;
    }

    public PostData Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.M;
        }
        return (PostData) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
            this.e0 = null;
            this.f0 = null;
        }
    }

    public String a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.b;
        }
        return (String) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public List b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return this.d0;
        }
        return (List) invokeV.objValue;
    }

    public t05 c0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) {
            return this.q0;
        }
        return (t05) invokeV.objValue;
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            return this.u;
        }
        return (AntiData) invokeV.objValue;
    }

    public boolean d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) {
            bt4 bt4Var = this.t;
            if (bt4Var != null && bt4Var.b() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ArrayList e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048630, this)) == null) {
            return this.G;
        }
        return (ArrayList) invokeV.objValue;
    }

    public List f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) {
            return this.U;
        }
        return (List) invokeV.objValue;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048634, this)) == null) {
            return this.V;
        }
        return invokeV.intValue;
    }

    public zt4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) {
            return this.o;
        }
        return (zt4) invokeV.objValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) {
            return this.Z;
        }
        return (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) {
            return this.t0;
        }
        return invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            return this.X;
        }
        return (PostData) invokeV.objValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) {
            return this.Q;
        }
        return (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            if (P() != null && P().isUgcThreadType()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) {
            return this.n;
        }
        return (ForumData) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            return this.l0;
        }
        return invokeV.booleanValue;
    }

    public String m() {
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

    public String n() {
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

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumRuleStatus o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return this.j0;
        }
        return (ForumRuleStatus) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (P() != null && P().isLongNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public List p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            return this.K;
        }
        return (List) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) {
            if (P() != null && P().isNovelThread()) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048654, this)) == null) {
            return this.c;
        }
        return (CardHListViewData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) {
            return this.n0;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
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

    public boolean r0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) {
            return this.p0;
        }
        return invokeV.booleanValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            return this.x;
        }
        return invokeV.intValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) {
            if (this.r0 == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) {
            return this.o0;
        }
        return invokeV.booleanValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData != null) {
                return threadData.getMarkID();
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public List v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048664, this)) == null) {
            return this.C;
        }
        return (List) invokeV.objValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048666, this)) == null) {
            return this.R;
        }
        return (String) invokeV.objValue;
    }

    public boolean w0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) {
            ArrayList arrayList = this.q;
            if (arrayList != null && arrayList.size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048668, this)) == null) {
            return this.z;
        }
        return (String) invokeV.objValue;
    }

    public boolean x0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) {
            if (P() != null && P().isVideoThreadType() && P().getThreadVideoInfo() != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public bt4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048670, this)) == null) {
            return this.t;
        }
        return (bt4) invokeV.objValue;
    }

    public boolean y0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048671, this)) == null) {
            if (P() != null && P().worksInfoData != null && P().worksInfoData.isWorks) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public qn8 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048672, this)) == null) {
            return this.H;
        }
        return (qn8) invokeV.objValue;
    }

    public final void A0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) {
            qn8 qn8Var = new qn8();
            qn8Var.V0 = true;
            qn8Var.p1(dataRes.banner_list.pb_banner_ad);
            this.H = qn8Var;
        }
    }

    public void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.V = i;
        }
    }

    public void F0(zt4 zt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, zt4Var) == null) {
            this.o = zt4Var;
        }
    }

    public void G0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, postData) == null) {
            this.X = postData;
            this.Z = postData;
            this.Y = false;
        }
    }

    public void H0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, postData) == null) {
            this.Z = postData;
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

    public void M0(qn8 qn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, qn8Var) == null) {
            this.H = qn8Var;
        }
    }

    public void N0(iw7 iw7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, iw7Var) == null) {
            this.P = iw7Var;
        }
    }

    public void O0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            this.m0 = i;
        }
    }

    public void P0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048607, this, i) == null) && (antiData = this.u) != null) {
            antiData.replyPrivateFlag = i;
        }
    }

    public void Q0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public void R0(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, list) == null) {
            this.s0 = list;
        }
    }

    public PostData S0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, postData)) == null) {
            this.M = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public void T0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.b = str;
        }
    }

    public boolean u0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048663, this, z)) == null) {
            if ((this.y == 2 && z) || this.y == 1) {
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void z0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048673, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    public final void B0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.d0.clear();
            if (list != null && !list.isEmpty()) {
                for (App app : list) {
                    qn8 qn8Var = new qn8();
                    qn8Var.b1 = x0();
                    qn8Var.p1(app);
                    if (!this.d0.contains(qn8Var)) {
                        this.d0.add(qn8Var);
                    }
                }
            }
        }
    }

    public void C0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, floatingIcon) == null) && floatingIcon != null && (floatingIconItem = floatingIcon.pbpage) != null) {
            t05 t05Var = this.q0;
            t05Var.b = floatingIconItem.icon_url;
            t05Var.c = floatingIconItem.fold_lottie;
            t05Var.d = floatingIconItem.unfold_lottie;
            t05Var.e = floatingIconItem.float_type;
            t05Var.f = floatingIconItem.fold_name;
            t05Var.g = floatingIconItem.unfold_name;
            t05Var.a = floatingIconItem.url;
            t05Var.j = floatingIconItem.scheme;
            t05Var.k = floatingIconItem.package_name;
            t05Var.l = floatingIconItem.deeplink;
            t05Var.h = floatingIconItem.view_statistics_url;
            t05Var.i = floatingIconItem.click_statistics_url;
            t05Var.r = floatingIconItem.display_ad_icon;
        }
    }

    public final void g0(DataRes dataRes) {
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
            List list3 = this.E;
            if (list3 != null && list3.size() > 15) {
                this.E = ListUtils.subList(this.E, 0, 15);
            }
        }
    }

    public final boolean j0(ThreadInfo threadInfo) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048665, this, threadInfo)) == null) {
            if (threadInfo == null || R() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            if (!R().equals(threadInfo.id) && !R().equals(threadInfo.tid)) {
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
            uf8.e().h(dataRes.asp_shown_info);
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
                        this.k0 = metaData.getBusinessAccountData();
                    }
                }
            }
            J0(dataRes.is_new_url.intValue());
            z0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.i(dataRes.display_forum);
            this.p.setUserMap(this.s);
            this.p.parserProtobuf(dataRes.thread);
            if (this.p.getFid() == 0) {
                this.p.setFid(dataRes.forum.id.longValue());
            }
            if (this.p.getAuthor() != null && this.p.getAuthor().getBusinessAccountData() == null) {
                this.p.getAuthor().setBusinessAccountData(this.k0);
            }
            this.A.a(dataRes.news_info);
            int i3 = this.A.c;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        this.B.V0 = this.A;
                    } else {
                        this.B.W0 = this.A;
                    }
                } else {
                    this.B.V0 = this.A;
                }
            } else {
                this.B.U0 = this.A;
            }
            this.D.l1(dataRes.recommend_book);
            f0(dataRes);
            h0(dataRes);
            PostData postData = new PostData();
            this.X = postData;
            postData.E0(1);
            this.X.d1(this.s);
            this.X.H0(this.n.isBrandForum);
            this.X.a1(this.p.getCreateTime());
            this.X.F0(dataRes.forum.id.longValue());
            this.X.G0(dataRes.forum.name);
            if (dataRes.first_floor_post != null) {
                this.X.w0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.X.T0(this.p.originalThreadData);
            }
            if (this.Z == null) {
                this.Z = this.X;
                this.Y = true;
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
            List f = le8.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                A0(dataRes);
                for (App app : list2) {
                    qn8 qn8Var = new qn8();
                    qn8Var.b1 = x0();
                    qn8Var.p1(app);
                    if (!this.G.contains(qn8Var)) {
                        this.G.add(qn8Var);
                        if (f != null) {
                            f.add(qn8Var.getAdvertAppInfo());
                        }
                    }
                }
                B0(dataRes);
            }
            le8.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                yv7 yv7Var = new yv7();
                this.N = yv7Var;
                yv7Var.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            g0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    zt4 zt4Var = new zt4();
                    zt4Var.i(simpleForum);
                    this.J.add(zt4Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.K == null) {
                    this.K = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        zt4 zt4Var2 = new zt4();
                        zt4Var2.i(simpleForum2);
                        this.K.add(zt4Var2);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.O >= 0) {
                this.O = dataRes.thread_freq_num.longValue();
            }
            e0(dataRes);
            if (this.U == null) {
                this.U = new ArrayList();
            }
            this.U.clear();
            if (dataRes.bjh_recommend != null) {
                int i4 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !v0(threadInfo) && !j0(threadInfo)) {
                        rr4 rr4Var = new rr4();
                        rr4Var.l(i4);
                        rr4Var.parserProtobuf(threadInfo);
                        this.U.add(rr4Var);
                        i4++;
                    }
                }
            }
            if (this.W != null && this.W.n()) {
                this.W = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.W == null) {
                    v38 v38Var = new v38();
                    this.W = v38Var;
                    v38Var.r(dataRes.recom_ala_info);
                }
            } else if (this.W == null && dataRes.promotion != null) {
                v38 v38Var2 = new v38();
                this.W = v38Var2;
                v38Var2.s(dataRes.promotion);
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
                    qv7 qv7Var = new qv7();
                    qv7Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new pv7();
                    }
                    this.l.a(qv7Var);
                }
            }
            this.e0.b();
            this.e0.c(this.s);
            this.e0.a(dataRes.recom_ala_info);
            if (this.e0.o != null) {
                this.e0.o.o(R());
            }
            zy7 zy7Var = new zy7();
            this.f0 = zy7Var;
            zy7Var.b(this.s);
            this.f0.a(dataRes.recom_ala_info);
            if (this.f0.m != null) {
                this.f0.m.o(R());
            }
            if (ListUtils.getCount(dataRes.recom_thread_info) > 0) {
                this.i0 = dataRes.recom_thread_info;
            }
            if (dataRes.jumptotab1 != null) {
                str = dataRes.jumptotab1.toString();
            }
            this.g0 = str;
            this.h0 = dataRes.jumptotab2;
            if (dataRes.forum_rule != null) {
                this.j0 = dataRes.forum_rule;
            }
            if (dataRes.is_black_white.intValue() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.l0 = z;
            if (dataRes.is_official_forum.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.n0 = z2;
            if (dataRes.show_adsense.intValue() == 1) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.o0 = z3;
            if (dataRes.is_purchase.intValue() == 1) {
                z7 = true;
            }
            this.p0 = z7;
            FloatingIcon floatingIcon = dataRes.floating_icon;
            C0(dataRes.floating_icon);
            this.r0 = dataRes.has_fold_comment.intValue();
            dataRes.fold_comment_num.longValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public final PostData F() {
        InterceptResult invokeV;
        MetaData metaData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (P() != null && P().getAuthor() != null) {
                PostData postData = new PostData();
                MetaData author = P().getAuthor();
                String userId = author.getUserId();
                HashMap<String, MetaData> userMap = P().getUserMap();
                if (userMap != null && (metaData = userMap.get(userId)) != null && metaData.getUserId() != null) {
                    author = metaData;
                }
                postData.E0(1);
                postData.K0(P().getFirstPostId());
                postData.b1(P().getTitle());
                postData.a1(P().getCreateTime());
                postData.C0(author);
                return postData;
            }
            return null;
        }
        return (PostData) invokeV.objValue;
    }

    public PostData Y() {
        InterceptResult invokeV;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) {
            if (Z() != null) {
                return Z();
            }
            if (!ListUtils.isEmpty(G())) {
                Iterator it = G().iterator();
                while (it.hasNext()) {
                    postData = (PostData) it.next();
                    if (postData != null && postData.D() == 1) {
                        break;
                    }
                }
            }
            postData = null;
            if (postData == null) {
                postData = j();
            }
            if (!m0(postData)) {
                postData = F();
            }
            if (postData != null && postData.s() != null && postData.s().getUserTbVipInfoData() != null && postData.s().getUserTbVipInfoData().getvipIntro() != null) {
                postData.s().getGodUserData().setIntro(postData.s().getUserTbVipInfoData().getvipIntro());
            }
            return postData;
        }
        return (PostData) invokeV.objValue;
    }

    public void L0(bt4 bt4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048599, this, bt4Var, i) == null) {
            this.t.k(bt4Var.a());
            this.t.p(bt4Var.g());
            this.t.q(bt4Var.h());
            this.t.o(bt4Var.e());
            this.t.n(bt4Var.d());
            if (i == 0) {
                this.t = bt4Var;
            } else if (i == 1) {
                this.t.l(bt4Var.b());
            } else if (i == 2) {
                this.t.m(bt4Var.c());
            }
        }
    }

    public String[] O(boolean z) {
        InterceptResult invokeZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048604, this, z)) == null) {
            String str = null;
            String str2 = "";
            if (w0()) {
                int i = 30;
                if (this.q.size() <= 30) {
                    i = this.q.size();
                }
                if (P() != null && P().getAuthor() != null && !ej.isEmpty(P().getAuthor().getUserId())) {
                    String userId = P().getAuthor().getUserId();
                    PostData i2 = i();
                    if (i2 != null && i2.s() != null && !ej.isEmpty(i2.s().getUserId())) {
                        if (StringHelper.equals(userId, i2.s().getUserId())) {
                            str = i2.C();
                        }
                        if (ej.isEmpty("")) {
                            str2 = i2.e0();
                        }
                    }
                    if (ej.isEmpty(str2) && ej.isEmpty(str)) {
                        for (int i3 = 0; i3 < i; i3++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i3);
                            if (postData != null && postData.s() != null && !ej.isEmpty(postData.s().getUserId()) && StringHelper.equals(userId, postData.s().getUserId())) {
                                if (ej.isEmpty(str)) {
                                    str = postData.C();
                                }
                                if (ej.isEmpty(str2)) {
                                    str2 = postData.e0();
                                }
                                if (!ej.isEmpty(str) && !ej.isEmpty(str2)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && ej.isEmpty(str)) {
                        str = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str2 = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0ea8) + "] " + str2;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !ej.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            List list = this.f;
            if (list != null && list.size() > this.g) {
                for (int i = 0; i < this.f.size(); i++) {
                    if (((PbSortType) this.f.get(i)).sort_type.intValue() == this.g) {
                        return ((PbSortType) this.f.get(i)).sort_name;
                    }
                }
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public boolean s0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
            ThreadData threadData = this.p;
            if (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void e0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, dataRes) == null) {
            this.P = new iw7(this.p, this.u);
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
            this.Q = dataRes.fold_tip;
            this.d = dataRes.exp_news_today.intValue();
            this.e = dataRes.exp_guide_today.intValue();
            if (!ListUtils.isEmpty(dataRes.thread_topic)) {
                for (int i = 0; i < dataRes.thread_topic.size(); i++) {
                    RecommendTopicData.RecommendTopicListData recommendTopicListData = new RecommendTopicData.RecommendTopicListData();
                    recommendTopicListData.parserProtoBuf(dataRes.thread_topic.get(i));
                    this.S.add(recommendTopicListData);
                }
            }
            this.f = dataRes.pb_sort_info;
            this.g = dataRes.sort_type.intValue();
            ManagerElection managerElection = dataRes.manager_election;
            if (managerElection != null) {
                this.h = dw7.i(managerElection);
            }
        }
    }

    public final void f0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048633, this, dataRes) == null) && (list = dataRes.post_list) != null && list.size() > 0) {
            for (Post post : dataRes.post_list) {
                if (!this.T.contains(String.valueOf(post.id))) {
                    PostData postData = new PostData();
                    postData.d1(this.s);
                    postData.H0(this.n.isBrandForum);
                    postData.x0(post, P());
                    postData.V0(P().getPraise());
                    postData.F0(dataRes.forum.id.longValue());
                    postData.G0(dataRes.forum.name);
                    if (postData.q() != null && postData.q().baijiahaoData == null && P() != null && P().getBaijiahaoData() != null) {
                        postData.q().baijiahaoData = P().getBaijiahaoData();
                    }
                    this.T.add(postData.M());
                    if (postData.D() == 1 && this.p.isActInfo()) {
                        if (s0()) {
                            postData.U0(0);
                        } else {
                            postData.U0(this.p.getActInfoType());
                        }
                    } else if (postData.D() == 1 && this.p.isInterviewLive()) {
                        postData.U0(41);
                    } else if (postData.D() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                        postData.U0(0);
                        postData.j0();
                        if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                            postData.W0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                            postData.W0(TbRichTextView.U(jSONArray, false));
                        }
                        this.M = postData;
                    }
                    if (postData.D() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                        postData.T0(threadData2.originalThreadData);
                    }
                    if (postData.D() == 1) {
                        this.Z = postData;
                        this.Y = false;
                        if (postData.s() != null && this.k0 != null) {
                            postData.s().setBusinessAccountData(this.k0);
                        }
                    }
                    postData.e1(post);
                    postData.Q0(post.agree.lz_agree.intValue());
                    this.q.add(postData);
                }
            }
        }
    }

    public final void h0(DataRes dataRes) {
        Post post;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048637, this, dataRes) == null) && (post = dataRes.top_answer) != null && !this.T.contains(String.valueOf(post.id))) {
            PostData postData = new PostData();
            postData.d1(this.s);
            postData.H0(this.n.isBrandForum);
            postData.x0(post, P());
            postData.V0(P().getPraise());
            postData.F0(dataRes.forum.id.longValue());
            postData.G0(dataRes.forum.name);
            if (postData.q() != null && postData.q().baijiahaoData == null && P() != null && P().getBaijiahaoData() != null) {
                postData.q().baijiahaoData = P().getBaijiahaoData();
            }
            this.T.add(postData.M());
            if (postData.D() == 1 && this.p.isActInfo()) {
                if (s0()) {
                    postData.U0(0);
                } else {
                    postData.U0(this.p.getActInfoType());
                }
            } else if (postData.D() == 1 && this.p.isInterviewLive()) {
                postData.U0(41);
            } else if (postData.D() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                postData.U0(0);
                postData.j0();
                if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                    postData.W0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                    postData.W0(TbRichTextView.U(jSONArray, false));
                }
                this.M = postData;
            }
            if (postData.D() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                postData.T0(threadData2.originalThreadData);
            }
            if (postData.D() == 1) {
                this.Z = postData;
                this.Y = false;
                if (postData.s() != null && this.k0 != null) {
                    postData.s().setBusinessAccountData(this.k0);
                }
            }
            postData.e1(post);
            postData.Q0(post.agree.lz_agree.intValue());
            this.r = postData;
        }
    }

    public final boolean m0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048647, this, postData)) == null) {
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
