package com.baidu.tieba;

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
/* loaded from: classes4.dex */
public class jv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ct4 A;
    public xy7 B;
    public List<MuteUser> C;
    public dt4 D;
    public List<ThreadData> E;
    public AlaLiveInfoCoreData F;
    public ArrayList<jn8> G;
    public jn8 H;
    public TwzhiboAnti I;
    public List<xt4> J;
    public List<xt4> K;
    public cw7 L;
    public PostData M;
    public nv7 N;
    public long O;
    public xv7 P;
    public String Q;
    public String R;
    public List<RecommendTopicData.RecommendTopicListData> S;
    public HashSet<String> T;
    public List<pr4> U;
    public int V;
    public k38 W;
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
    public List<jn8> d0;
    public int e;
    public my7 e0;
    public List<PbSortType> f;
    public oy7 f0;
    public int g;
    public String g0;
    public sv7 h;
    public String h0;
    public boolean i;
    public List<ThreadInfo> i0;
    public boolean j;
    public ForumRuleStatus j0;
    public boolean k;
    public BusinessAccountData k0;
    public ev7 l;
    public boolean l0;
    public boolean m;
    public int m0;
    public ForumData n;
    public boolean n0;
    public xt4 o;
    public boolean o0;
    public ThreadData p;
    public boolean p0;
    public ArrayList<PostData> q;
    public o05 q0;
    public PostData r;
    public int r0;
    public HashMap<String, MetaData> s;
    public List<Cdo> s0;
    public zs4 t;
    public boolean t0;
    public AntiData u;
    public j45 v;
    public int w;
    public int x;
    public int y;
    public String z;

    public jv7() {
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
        this.V = 0;
        this.Y = true;
        this.a0 = 0;
        this.c0 = 0;
        this.d0 = new ArrayList();
        this.m0 = 0;
        this.r0 = 0;
        this.t0 = false;
        this.n = new ForumData();
        this.o = new xt4();
        this.p = new ThreadData();
        this.q = new ArrayList<>();
        this.s = new HashMap<>();
        this.t = new zs4();
        this.u = new AntiData();
        this.v = new j45();
        this.w = 0;
        this.x = 0;
        this.a = new UserData();
        this.C = new ArrayList();
        this.A = new ct4();
        this.D = new dt4();
        this.B = new xy7();
        this.I = new TwzhiboAnti();
        this.L = new cw7();
        this.e0 = new my7();
        this.S = new ArrayList();
        this.T = new HashSet<>();
        this.q0 = new o05();
    }

    public nv7 A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.N : (nv7) invokeV.objValue;
    }

    public void A0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataRes) == null) || dataRes == null) {
            return;
        }
        try {
            kf8.e().h(dataRes.asp_shown_info);
            List<User> list = dataRes.user_list;
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    MetaData metaData = new MetaData();
                    metaData.parserProtobuf(list.get(i));
                    String userId = metaData.getUserId();
                    if (userId != null && !userId.equals("0")) {
                        this.s.put(metaData.getUserId(), metaData);
                    }
                    if (i == 0) {
                        this.k0 = metaData.getBusinessAccountData();
                    }
                }
            }
            G0(dataRes.is_new_url.intValue());
            w0(dataRes);
            this.n.parserProtobuf(dataRes.forum);
            this.o.j(dataRes.display_forum);
            this.p.setUserMap(this.s);
            this.p.parserProtobuf(dataRes.thread);
            if (this.p.getFid() == 0) {
                this.p.setFid(dataRes.forum.id.longValue());
            }
            if (this.p.getAuthor() != null && this.p.getAuthor().getBusinessAccountData() == null) {
                this.p.getAuthor().setBusinessAccountData(this.k0);
            }
            this.A.a(dataRes.news_info);
            int i2 = this.A.c;
            if (i2 == 1) {
                this.B.U0 = this.A;
            } else if (i2 == 2) {
                this.B.V0 = this.A;
            } else if (i2 != 3) {
                this.B.V0 = this.A;
            } else {
                this.B.W0 = this.A;
            }
            this.D.k1(dataRes.recommend_book);
            d0(dataRes);
            f0(dataRes);
            PostData postData = new PostData();
            this.X = postData;
            postData.D0(1);
            this.X.c1(this.s);
            this.X.G0(this.n.isBrandForum);
            this.X.Z0(this.p.getCreateTime());
            this.X.E0(dataRes.forum.id.longValue());
            this.X.F0(dataRes.forum.name);
            if (dataRes.first_floor_post != null) {
                this.X.v0(dataRes.first_floor_post);
            }
            if (this.p != null && this.p.isShareThread) {
                this.X.S0(this.p.originalThreadData);
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
            this.p.setReply_num(this.p.getReply_num() > 0 ? this.p.getReply_num() - 1 : 0);
            List<AdvertAppInfo> f = be8.l().f();
            if (f != null) {
                f.clear();
            }
            String str = null;
            this.H = null;
            if (dataRes.banner_list != null) {
                List<App> list2 = dataRes.banner_list.app;
                x0(dataRes);
                for (App app : list2) {
                    jn8 jn8Var = new jn8();
                    jn8Var.b1 = u0();
                    jn8Var.o1(app);
                    if (!this.G.contains(jn8Var)) {
                        this.G.add(jn8Var);
                        if (f != null) {
                            f.add(jn8Var.getAdvertAppInfo());
                        }
                    }
                }
                y0(dataRes);
            }
            be8.l().e();
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            if (currentAccountObj != null) {
                currentAccountObj.setIsSelectTail(this.a.getIsSelectTail());
            }
            this.I.parserProtobuf(dataRes.twzhibo_anti);
            AppealInfo appealInfo = dataRes.appeal_info;
            if (dataRes.forum_headline_img_info != null) {
                nv7 nv7Var = new nv7();
                this.N = nv7Var;
                nv7Var.c(dataRes.forum_headline_img_info);
            }
            if (dataRes.guess_like != null) {
                CardHListViewData cardHListViewData = new CardHListViewData();
                this.c = cardHListViewData;
                cardHListViewData.parseProtobuf(dataRes.guess_like);
            }
            e0(dataRes);
            if (ListUtils.getCount(dataRes.repost_recommend_forum_list) > 0) {
                if (this.J == null) {
                    this.J = new ArrayList();
                }
                for (SimpleForum simpleForum : dataRes.repost_recommend_forum_list) {
                    xt4 xt4Var = new xt4();
                    xt4Var.j(simpleForum);
                    this.J.add(xt4Var);
                }
            }
            if (ListUtils.getCount(dataRes.from_forum_list) > 0) {
                if (this.K == null) {
                    this.K = new ArrayList();
                }
                for (SimpleForum simpleForum2 : dataRes.from_forum_list) {
                    if (simpleForum2 != null) {
                        xt4 xt4Var2 = new xt4();
                        xt4Var2.j(simpleForum2);
                        this.K.add(xt4Var2);
                    }
                }
            }
            this.R = dataRes.multi_forum_text;
            if (this.O >= 0) {
                this.O = dataRes.thread_freq_num.longValue();
            }
            c0(dataRes);
            if (this.U == null) {
                this.U = new ArrayList();
            }
            this.U.clear();
            if (dataRes.bjh_recommend != null) {
                int i3 = 1;
                for (ThreadInfo threadInfo : dataRes.bjh_recommend) {
                    if (threadInfo != null && !s0(threadInfo) && !h0(threadInfo)) {
                        pr4 pr4Var = new pr4();
                        pr4Var.l(i3);
                        pr4Var.parserProtobuf(threadInfo);
                        this.U.add(pr4Var);
                        i3++;
                    }
                }
            }
            if (this.W != null && this.W.n()) {
                this.W = null;
            }
            if (dataRes.recom_ala_info != null && dataRes.recom_ala_info.live_status.intValue() == 1 && dataRes.recom_ala_info.pb_display_type.intValue() == 2) {
                if (this.W == null) {
                    k38 k38Var = new k38();
                    this.W = k38Var;
                    k38Var.r(dataRes.recom_ala_info);
                }
            } else if (this.W == null && dataRes.promotion != null) {
                k38 k38Var2 = new k38();
                this.W = k38Var2;
                k38Var2.s(dataRes.promotion);
            }
            if (dataRes.business_promot_info != null) {
                this.i = dataRes.business_promot_info.is_promot.longValue() == 1;
                this.j = dataRes.business_promot_info.is_headlinepost.intValue() == 1;
                this.k = dataRes.business_promot_info.is_s_card.intValue() == 1;
                if (dataRes.business_promot_info.send_card_info != null) {
                    fv7 fv7Var = new fv7();
                    fv7Var.d(dataRes.business_promot_info.send_card_info);
                    if (this.l == null) {
                        this.l = new ev7();
                    }
                    this.l.a(fv7Var);
                }
            }
            this.e0.b();
            this.e0.c(this.s);
            this.e0.a(dataRes.recom_ala_info);
            if (this.e0.o != null) {
                this.e0.o.o(Q());
            }
            oy7 oy7Var = new oy7();
            this.f0 = oy7Var;
            oy7Var.b(this.s);
            this.f0.a(dataRes.recom_ala_info);
            if (this.f0.m != null) {
                this.f0.m.o(Q());
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
            this.l0 = dataRes.is_black_white.intValue() == 1;
            this.n0 = dataRes.is_official_forum.intValue() == 1;
            this.o0 = dataRes.show_adsense.intValue() == 1;
            this.p0 = dataRes.is_purchase.intValue() == 1;
            FloatingIcon floatingIcon = dataRes.floating_icon;
            z0(dataRes.floating_icon);
            this.r0 = dataRes.has_fold_comment.intValue();
            dataRes.fold_comment_num.longValue();
        } catch (Exception e) {
            BdLog.detailException(e);
        }
    }

    public my7 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            my7 my7Var = this.e0;
            if (my7Var == null || !my7Var.isValid()) {
                return null;
            }
            return this.e0;
        }
        return (my7) invokeV.objValue;
    }

    public void B0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.V = i;
        }
    }

    public oy7 C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            oy7 oy7Var = this.f0;
            if (oy7Var == null || !oy7Var.isValid()) {
                return null;
            }
            return this.f0;
        }
        return (oy7) invokeV.objValue;
    }

    public void C0(xt4 xt4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, xt4Var) == null) {
            this.o = xt4Var;
        }
    }

    public xy7 D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.B : (xy7) invokeV.objValue;
    }

    public void D0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, postData) == null) {
            this.X = postData;
            this.Z = postData;
            this.Y = false;
        }
    }

    public dt4 E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.D : (dt4) invokeV.objValue;
    }

    public void E0(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, postData) == null) {
            this.Z = postData;
        }
    }

    public ArrayList<PostData> F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.q : (ArrayList) invokeV.objValue;
    }

    public void F0(boolean z) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (threadData = this.p) == null) {
            return;
        }
        if (z) {
            threadData.setIsMarked(1);
        } else {
            threadData.setIsMarked(0);
        }
    }

    public k38 G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.W : (k38) invokeV.objValue;
    }

    public void G0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.x = i;
        }
    }

    public int H() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.m0 : invokeV.intValue;
    }

    public void H0(String str) {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048591, this, str) == null) || (threadData = this.p) == null) {
            return;
        }
        threadData.setMarkID(str);
    }

    public List<ThreadInfo> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.i0 : (List) invokeV.objValue;
    }

    public void I0(zs4 zs4Var, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, zs4Var, i) == null) {
            this.t.k(zs4Var.a());
            this.t.p(zs4Var.g());
            this.t.q(zs4Var.h());
            this.t.o(zs4Var.e());
            this.t.n(zs4Var.d());
            if (i == 0) {
                this.t = zs4Var;
            } else if (i == 1) {
                this.t.l(zs4Var.b());
            } else if (i == 2) {
                this.t.m(zs4Var.c());
            }
        }
    }

    public AlaLiveInfoCoreData J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.F : (AlaLiveInfoCoreData) invokeV.objValue;
    }

    public void J0(jn8 jn8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, jn8Var) == null) {
            this.H = jn8Var;
        }
    }

    public List<ThreadData> K() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.E : (List) invokeV.objValue;
    }

    public void K0(xv7 xv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, xv7Var) == null) {
            this.P = xv7Var;
        }
    }

    public int L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            AntiData antiData = this.u;
            if (antiData != null) {
                return antiData.replyPrivateFlag;
            }
            return 1;
        }
        return invokeV.intValue;
    }

    public void L0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i) == null) {
            this.m0 = i;
        }
    }

    public String[] M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? N(true) : (String[]) invokeV.objValue;
    }

    public void M0(int i) {
        AntiData antiData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048601, this, i) == null) || (antiData = this.u) == null) {
            return;
        }
        antiData.replyPrivateFlag = i;
    }

    public String[] N(boolean z) {
        InterceptResult invokeZ;
        OriginalThreadInfo originalThreadInfo;
        ArrayList<MediaData> arrayList;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048602, this, z)) == null) {
            String str = "";
            if (t0()) {
                int size = this.q.size() <= 30 ? this.q.size() : 30;
                if (O() != null && O().getAuthor() != null && !dj.isEmpty(O().getAuthor().getUserId())) {
                    String userId = O().getAuthor().getUserId();
                    PostData i = i();
                    if (i != null && i.s() != null && !dj.isEmpty(i.s().getUserId())) {
                        r2 = StringHelper.equals(userId, i.s().getUserId()) ? i.B() : null;
                        if (dj.isEmpty("")) {
                            str = i.d0();
                        }
                    }
                    if (dj.isEmpty(str) && dj.isEmpty(r2)) {
                        for (int i2 = 0; i2 < size; i2++) {
                            PostData postData = (PostData) ListUtils.getItem(this.q, i2);
                            if (postData != null && postData.s() != null && !dj.isEmpty(postData.s().getUserId()) && StringHelper.equals(userId, postData.s().getUserId())) {
                                if (dj.isEmpty(r2)) {
                                    r2 = postData.B();
                                }
                                if (dj.isEmpty(str)) {
                                    str = postData.d0();
                                }
                                if (!dj.isEmpty(r2) && !dj.isEmpty(str)) {
                                    break;
                                }
                            }
                        }
                    }
                    if (z && dj.isEmpty(r2)) {
                        r2 = "https://tb5.bdstatic.com/yunying/tieba_logo.jpg";
                    }
                    ThreadData threadData = this.p;
                    if (threadData != null && threadData.getAnchorInfoData() != null && this.p.getAnchorInfoData().getGroup_id() != 0) {
                        str = PreferencesUtil.LEFT_MOUNT + TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e96) + "] " + str;
                    }
                    ThreadData threadData2 = this.p;
                    if (threadData2 != null && threadData2.getThreadVideoInfo() != null && !dj.isEmpty(this.p.getThreadVideoInfo().thumbnail_url)) {
                        r2 = this.p.getThreadVideoInfo().thumbnail_url;
                    }
                    ThreadData threadData3 = this.p;
                    if (threadData3 != null && !threadData3.isShareThread && r2 == null && (originalThreadInfo = threadData3.originalThreadData) != null && (arrayList = originalThreadInfo.h) != null) {
                        int size2 = arrayList.size();
                        int i3 = 0;
                        while (true) {
                            if (i3 >= size2) {
                                break;
                            }
                            MediaData mediaData = arrayList.get(i3);
                            if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                                if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                                    r2 = mediaData.getThumbnails_url();
                                    break;
                                } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                                    r2 = mediaData.getPicUrl();
                                    break;
                                }
                            }
                            i3++;
                        }
                    }
                } else {
                    return new String[]{null, ""};
                }
            }
            return new String[]{r2, str};
        }
        return (String[]) invokeZ.objValue;
    }

    public void N0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, threadData) == null) {
            this.p = threadData;
        }
    }

    public ThreadData O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.p : (ThreadData) invokeV.objValue;
    }

    public void O0(List<Cdo> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, list) == null) {
            this.s0 = list;
        }
    }

    public long P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.O : invokeV.longValue;
    }

    public PostData P0(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, postData)) == null) {
            this.M = postData;
            return postData;
        }
        return (PostData) invokeL.objValue;
    }

    public String Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            ThreadData threadData = this.p;
            return threadData != null ? threadData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public void Q0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.b = str;
        }
    }

    public List<Cdo> R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.s0 : (List) invokeV.objValue;
    }

    public xv7 S() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.P : (xv7) invokeV.objValue;
    }

    public cw7 T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) ? this.L : (cw7) invokeV.objValue;
    }

    public PostData U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) ? this.r : (PostData) invokeV.objValue;
    }

    public UserData V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048614, this)) == null) ? this.a : (UserData) invokeV.objValue;
    }

    public int W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) ? this.w : invokeV.intValue;
    }

    public PostData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.M : (PostData) invokeV.objValue;
    }

    public String Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) ? this.b : (String) invokeV.objValue;
    }

    public List<jn8> Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) ? this.d0 : (List) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.e0 = null;
            this.f0 = null;
        }
    }

    public o05 a0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048620, this)) == null) ? this.q0 : (o05) invokeV.objValue;
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            if (this.H.getAdvertAppInfo() != null) {
                this.H.getAdvertAppInfo().h = null;
            }
            this.H = null;
        }
    }

    public boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            zs4 zs4Var = this.t;
            return zs4Var != null && zs4Var.b() == 1;
        }
        return invokeV.booleanValue;
    }

    public String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            List<PbSortType> list = this.f;
            if (list == null || list.size() <= this.g) {
                return "";
            }
            for (int i = 0; i < this.f.size(); i++) {
                if (this.f.get(i).sort_type.intValue() == this.g) {
                    return this.f.get(i).sort_name;
                }
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public final void c0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, dataRes) == null) {
            this.P = new xv7(this.p, this.u);
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
                this.h = sv7.i(managerElection);
            }
        }
    }

    public AntiData d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) ? this.u : (AntiData) invokeV.objValue;
    }

    public final void d0(DataRes dataRes) {
        List<Post> list;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, dataRes) == null) || (list = dataRes.post_list) == null || list.size() <= 0) {
            return;
        }
        for (Post post : dataRes.post_list) {
            if (!this.T.contains(String.valueOf(post.id))) {
                PostData postData = new PostData();
                postData.c1(this.s);
                postData.G0(this.n.isBrandForum);
                postData.w0(post, O());
                postData.U0(O().getPraise());
                postData.E0(dataRes.forum.id.longValue());
                postData.F0(dataRes.forum.name);
                if (postData.q() != null && postData.q().baijiahaoData == null && O() != null && O().getBaijiahaoData() != null) {
                    postData.q().baijiahaoData = O().getBaijiahaoData();
                }
                this.T.add(postData.L());
                if (postData.C() == 1 && this.p.isActInfo()) {
                    if (p0()) {
                        postData.T0(0);
                    } else {
                        postData.T0(this.p.getActInfoType());
                    }
                } else if (postData.C() == 1 && this.p.isInterviewLive()) {
                    postData.T0(41);
                } else if (postData.C() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
                    postData.T0(0);
                    postData.i0();
                    if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                        postData.V0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                        postData.V0(TbRichTextView.U(jSONArray, false));
                    }
                    this.M = postData;
                }
                if (postData.C() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
                    postData.S0(threadData2.originalThreadData);
                }
                if (postData.C() == 1) {
                    this.Z = postData;
                    this.Y = false;
                    if (postData.s() != null && this.k0 != null) {
                        postData.s().setBusinessAccountData(this.k0);
                    }
                }
                postData.d1(post);
                postData.P0(post.agree.lz_agree.intValue());
                this.q.add(postData);
            }
        }
    }

    public ArrayList<jn8> e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? this.G : (ArrayList) invokeV.objValue;
    }

    public final void e0(DataRes dataRes) {
        List<ThreadInfo> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048628, this, dataRes) == null) || (list = dataRes.feed_thread_list) == null || list.size() <= 0) {
            return;
        }
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
        if (list3 == null || list3.size() <= 15) {
            return;
        }
        this.E = ListUtils.subList(this.E, 0, 15);
    }

    public List<pr4> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048629, this)) == null) ? this.U : (List) invokeV.objValue;
    }

    public final void f0(DataRes dataRes) {
        Post post;
        ThreadData threadData;
        ThreadData threadData2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048630, this, dataRes) == null) || (post = dataRes.top_answer) == null || this.T.contains(String.valueOf(post.id))) {
            return;
        }
        PostData postData = new PostData();
        postData.c1(this.s);
        postData.G0(this.n.isBrandForum);
        postData.w0(post, O());
        postData.U0(O().getPraise());
        postData.E0(dataRes.forum.id.longValue());
        postData.F0(dataRes.forum.name);
        if (postData.q() != null && postData.q().baijiahaoData == null && O() != null && O().getBaijiahaoData() != null) {
            postData.q().baijiahaoData = O().getBaijiahaoData();
        }
        this.T.add(postData.L());
        if (postData.C() == 1 && this.p.isActInfo()) {
            if (p0()) {
                postData.T0(0);
            } else {
                postData.T0(this.p.getActInfoType());
            }
        } else if (postData.C() == 1 && this.p.isInterviewLive()) {
            postData.T0(41);
        } else if (postData.C() == 1 && (threadData = this.p) != null && threadData.isVideoThreadType()) {
            postData.T0(0);
            postData.i0();
            if (this.p.getRichTitle() != null && this.p.getRichTitle().size() != 0) {
                postData.V0(new TbRichText(this.p.getRichTitle(), this.p.getTid(), true));
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
                postData.V0(TbRichTextView.U(jSONArray, false));
            }
            this.M = postData;
        }
        if (postData.C() == 1 && (threadData2 = this.p) != null && threadData2.isShareThread) {
            postData.S0(threadData2.originalThreadData);
        }
        if (postData.C() == 1) {
            this.Z = postData;
            this.Y = false;
            if (postData.s() != null && this.k0 != null) {
                postData.s().setBusinessAccountData(this.k0);
            }
        }
        postData.d1(post);
        postData.P0(post.agree.lz_agree.intValue());
        this.r = postData;
    }

    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048631, this)) == null) ? this.V : invokeV.intValue;
    }

    public boolean g0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048632, this)) == null) ? this.t0 : invokeV.booleanValue;
    }

    public xt4 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048633, this)) == null) ? this.o : (xt4) invokeV.objValue;
    }

    public final boolean h0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Baijiahao baijiahao;
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048634, this, threadInfo)) == null) {
            if (threadInfo == null || (baijiahao = threadInfo.baijiahao) == null || baijiahao.ori_ugc_nid == null || (threadData = this.p) == null || threadData.getBaijiahaoData() == null || this.p.getBaijiahaoData().oriUgcNid == null || "0".equals(threadInfo.baijiahao.ori_ugc_nid)) {
                return false;
            }
            return threadInfo.baijiahao.ori_ugc_nid.equals(this.p.getBaijiahaoData().oriUgcNid);
        }
        return invokeL.booleanValue;
    }

    public PostData i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048635, this)) == null) ? this.Z : (PostData) invokeV.objValue;
    }

    public boolean i0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048636, this)) == null) ? O() != null && O().isUgcThreadType() : invokeV.booleanValue;
    }

    public PostData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048637, this)) == null) ? this.X : (PostData) invokeV.objValue;
    }

    public boolean j0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048638, this)) == null) ? this.l0 : invokeV.booleanValue;
    }

    public String k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048639, this)) == null) ? this.Q : (String) invokeV.objValue;
    }

    public boolean k0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048640, this)) == null) {
            ForumData forumData = this.n;
            if (forumData != null) {
                return forumData.isFrsMask();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048641, this)) == null) ? this.n : (ForumData) invokeV.objValue;
    }

    public boolean l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048642, this)) == null) ? O() != null && O().isLongNovelThread() : invokeV.booleanValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048643, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getId() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048644, this)) == null) ? O() != null && O().isNovelThread() : invokeV.booleanValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048645, this)) == null) {
            ForumData forumData = this.n;
            return forumData != null ? forumData.getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public boolean n0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048646, this)) == null) ? this.n0 : invokeV.booleanValue;
    }

    public ForumRuleStatus o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048647, this)) == null) ? this.j0 : (ForumRuleStatus) invokeV.objValue;
    }

    public boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048648, this)) == null) ? this.p0 : invokeV.booleanValue;
    }

    public List<xt4> p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) ? this.K : (List) invokeV.objValue;
    }

    public boolean p0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            ThreadData threadData = this.p;
            return (threadData == null || threadData.getActDatas() == null || this.p.getActDatas().size() <= 0 || this.p.getActDatas().get(0) == null || !this.p.getActDatas().get(0).d()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public CardHListViewData q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) ? this.c : (CardHListViewData) invokeV.objValue;
    }

    public boolean q0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) ? this.o0 : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048653, this)) == null) ? this.p.getIsMarked() != 0 : invokeV.booleanValue;
    }

    public boolean r0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(1048654, this, z)) == null) ? (this.y == 2 && z) || this.y == 1 : invokeZ.booleanValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048655, this)) == null) ? this.x : invokeV.intValue;
    }

    public final boolean s0(ThreadInfo threadInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048656, this, threadInfo)) == null) {
            if (threadInfo == null || Q() == null || "0".equals(threadInfo.id) || "0".equals(threadInfo.tid)) {
                return false;
            }
            return Q().equals(threadInfo.id) || Q().equals(threadInfo.tid);
        }
        return invokeL.booleanValue;
    }

    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048657, this)) == null) ? this.r0 == 1 : invokeV.booleanValue;
    }

    public boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048658, this)) == null) {
            ArrayList<PostData> arrayList = this.q;
            return arrayList != null && arrayList.size() > 0;
        }
        return invokeV.booleanValue;
    }

    public String u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048659, this)) == null) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048660, this)) == null) ? (O() == null || !O().isVideoThreadType() || O().getThreadVideoInfo() == null) ? false : true : invokeV.booleanValue;
    }

    public List<MuteUser> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048661, this)) == null) ? this.C : (List) invokeV.objValue;
    }

    public boolean v0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048662, this)) == null) ? (O() == null || O().worksInfoData == null || !O().worksInfoData.isWorks) ? false : true : invokeV.booleanValue;
    }

    public String w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048663, this)) == null) ? this.R : (String) invokeV.objValue;
    }

    public final void w0(@NonNull DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048664, this, dataRes) == null) {
            this.y = dataRes.pb_notice_type.intValue();
            this.z = dataRes.pb_notice;
        }
    }

    @NonNull
    public String x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048665, this)) == null) ? this.z : (String) invokeV.objValue;
    }

    public final void x0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048666, this, dataRes) == null) {
            jn8 jn8Var = new jn8();
            jn8Var.V0 = true;
            jn8Var.o1(dataRes.banner_list.pb_banner_ad);
            this.H = jn8Var;
        }
    }

    public zs4 y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048667, this)) == null) ? this.t : (zs4) invokeV.objValue;
    }

    public final void y0(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048668, this, dataRes) == null) {
            List<App> list = dataRes.banner_list.video_recommend_ad;
            this.d0.clear();
            if (list == null || list.isEmpty()) {
                return;
            }
            for (App app : list) {
                jn8 jn8Var = new jn8();
                jn8Var.b1 = u0();
                jn8Var.o1(app);
                if (!this.d0.contains(jn8Var)) {
                    this.d0.add(jn8Var);
                }
            }
        }
    }

    public jn8 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048669, this)) == null) ? this.H : (jn8) invokeV.objValue;
    }

    public void z0(FloatingIcon floatingIcon) {
        FloatingIconItem floatingIconItem;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048670, this, floatingIcon) == null) || floatingIcon == null || (floatingIconItem = floatingIcon.pbpage) == null) {
            return;
        }
        o05 o05Var = this.q0;
        o05Var.b = floatingIconItem.icon_url;
        o05Var.c = floatingIconItem.fold_lottie;
        o05Var.d = floatingIconItem.unfold_lottie;
        o05Var.e = floatingIconItem.float_type;
        o05Var.f = floatingIconItem.fold_name;
        o05Var.g = floatingIconItem.unfold_name;
        o05Var.a = floatingIconItem.url;
        o05Var.j = floatingIconItem.scheme;
        o05Var.k = floatingIconItem.package_name;
        o05Var.l = floatingIconItem.deeplink;
        o05Var.h = floatingIconItem.view_statistics_url;
        o05Var.i = floatingIconItem.click_statistics_url;
        o05Var.r = floatingIconItem.display_ad_icon;
    }
}
