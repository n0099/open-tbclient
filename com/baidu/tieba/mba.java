package com.baidu.tieba;

import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.PrivSets;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes7.dex */
public abstract class mba {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NicknameInfo A;
    public User B;
    public MetaData C;
    public List<ThreadData> D;
    public HotUserRankEntry E;
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public int e;
    public int f;
    public UserData g;
    public AntiData h;
    public ArrayList<pi> i;
    public oba j;
    public l7a k;
    public z98 l;
    public List<AlaLiveInfoCoreData> m;
    public sba n;
    public uba o;
    public List<pi> p;
    public ArrayList<pi> q;
    public ArrayList<zba> r;
    public ArrayList<pi> s;
    public p7a t;
    public zba u;
    public zba v;
    public zba w;
    public zba x;
    public zba y;
    public PersonUserGodInfo z;

    public abstract void b();

    public mba(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = true;
        this.c = 1;
        this.d = 1;
        this.e = 1;
        this.f = -1;
        this.a = z;
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.D = new ArrayList();
    }

    public final void p(List<ForumDynamic> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            oba obaVar = new oba();
            this.j = obaVar;
            obaVar.a = new ArrayList();
            for (ForumDynamic forumDynamic : list) {
                if (forumDynamic != null) {
                    rba rbaVar = new rba();
                    rbaVar.a = forumDynamic.forum_id.longValue();
                    rbaVar.b = forumDynamic.forum_name;
                    rbaVar.c = forumDynamic.avatar;
                    rbaVar.e = this.c;
                    rbaVar.d = forumDynamic.user_thread_count.intValue();
                    this.j.a.add(rbaVar);
                }
            }
        }
    }

    public b7a a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            b7a b7aVar = new b7a();
            b7aVar.a = i;
            b7aVar.c = i2;
            return b7aVar;
        }
        return (b7a) invokeII.objValue;
    }

    public final zba c(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(Constants.METHOD_SEND_USER_MSG, this, i, i2, i3)) == null) {
            zba zbaVar = new zba();
            TbadkCoreApplication.getInst().getString(i2);
            c9a c9aVar = new c9a();
            zbaVar.a = c9aVar;
            c9aVar.a = i3;
            return zbaVar;
        }
        return (zba) invokeIII.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.r.clear();
            zba c = c(R.drawable.icon_starer_caise_heibai, R.string.obfuscated_res_0x7f0f0c89, 20);
            this.v = c;
            c.b = new Bundle();
            this.v.b.putBoolean("person_center_item_red_tip", true);
            this.v.a.b = new Bundle();
            this.v.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.v);
            zba c2 = c(R.drawable.icon_lover_caise_heibai, R.string.obfuscated_res_0x7f0f04e6, 24);
            this.w = c2;
            c2.b = new Bundle();
            this.w.b.putBoolean("person_center_item_red_tip", true);
            this.w.a.b = new Bundle();
            this.w.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.w);
            zba c3 = c(R.drawable.icon_liwu_caise_heibai, R.string.obfuscated_res_0x7f0f090a, 32);
            this.u = c3;
            c3.b = new Bundle();
            this.u.b.putBoolean("person_center_item_red_tip", true);
            this.u.a.b = new Bundle();
            this.u.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.u);
            zba c4 = c(R.drawable.icon_lishi_caise_heibai, R.string.obfuscated_res_0x7f0f09f7, 21);
            c4.a.b = new Bundle();
            c4.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c4);
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
                zba c5 = c(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
                c5.b = new Bundle();
                c5.a.b = new Bundle();
                c5.a.b.putSerializable(UserData.TYPE_USER, this.g);
                this.r.add(c5);
            }
            zba c6 = c(R.drawable.icon_vip_heibai, R.string.obfuscated_res_0x7f0f0cac, 16);
            this.x = c6;
            c6.b = new Bundle();
            this.x.b.putBoolean("person_center_item_red_tip", true);
            this.x.a.b = new Bundle();
            this.x.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(this.x);
            zba c7 = c(R.drawable.icon_bookshoop_caise_heibai, R.string.obfuscated_res_0x7f0f037b, 31);
            c7.a.b = new Bundle();
            c7.a.b.putSerializable(UserData.TYPE_USER, this.g);
            p7a p7aVar = this.t;
            if (p7aVar != null) {
                c7.a.b.putString("book_jump_link", p7aVar.a);
            }
            this.r.add(c7);
            zba c8 = c(R.drawable.icon_kabao_caise_heibai, R.string.obfuscated_res_0x7f0f03ed, 33);
            c8.a.b = new Bundle();
            c8.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c8);
            zba c9 = c(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
            c9.a.b = new Bundle();
            c9.a.b.putSerializable(UserData.TYPE_USER, this.g);
            this.r.add(c9);
            zba c10 = c(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
            c10.a.b = new Bundle();
            c10.a.b.putString("key_service_centre", "");
            this.r.add(c10);
        }
    }

    public AntiData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.h;
        }
        return (AntiData) invokeV.objValue;
    }

    public ArrayList<pi> f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.q;
        }
        return (ArrayList) invokeV.objValue;
    }

    public z98 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.l;
        }
        return (z98) invokeV.objValue;
    }

    public List<ThreadData> h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.D;
        }
        return (List) invokeV.objValue;
    }

    public User i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.B;
        }
        return (User) invokeV.objValue;
    }

    public UserData j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (UserData) invokeV.objValue;
    }

    public List<pi> k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            l7a l7aVar = this.k;
            if (l7aVar == null) {
                return null;
            }
            return l7aVar.a();
        }
        return (List) invokeV.objValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.a;
        }
        return invokeV.booleanValue;
    }

    public final boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.a) {
                return false;
            }
            int i = this.d;
            if (i == 3) {
                return true;
            }
            if (i != 2 || this.b) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            if (this.a) {
                return false;
            }
            int i = this.e;
            if (i == 3) {
                return true;
            }
            if (i != 2 || this.b) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void q(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048592, this, dynamicInfo, z) == null) {
            if ((n() && !this.a) || (forumDynamic = dynamicInfo.forum_dynamic) == null) {
                return;
            }
            if (this.p == null) {
                this.p = new ArrayList();
            }
            nba nbaVar = new nba();
            nbaVar.a = this.a;
            nbaVar.b = this.c;
            nbaVar.c = z;
            nbaVar.d = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            nbaVar.e = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            nbaVar.f = forumDynamic.forum_id.longValue();
            nbaVar.g = forumDynamic.avatar;
            nbaVar.h = forumDynamic.forum_name;
            boolean z2 = true;
            if (forumDynamic.is_like.intValue() != 1) {
                z2 = false;
            }
            nbaVar.i = z2;
            nbaVar.j = forumDynamic.member_count.intValue();
            nbaVar.k = forumDynamic.thread_count.intValue();
            this.p.add(nbaVar);
            this.p.add(a(BdUtilHelper.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.obfuscated_res_0x7f070198), R.color.CAM_X0204));
        }
    }

    public final void r(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(1048593, this, dynamicInfo, z) != null) || (userDynamic = dynamicInfo.user_dynamic) == null) {
            return;
        }
        List<User> list = userDynamic.concerned_user_list;
        if (ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            this.p = new ArrayList();
        }
        pba pbaVar = new pba();
        pbaVar.a = this.a;
        pbaVar.b = z;
        pbaVar.e = this.c;
        pbaVar.c = StringHelper.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        pbaVar.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        pbaVar.d = StringHelper.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
        pbaVar.f = new ArrayList();
        for (User user : list) {
            if (user != null) {
                UserData userData = new UserData();
                userData.parserProtobuf(user);
                pbaVar.f.add(userData);
            }
        }
        this.p.add(pbaVar);
    }

    public final void s(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048594, this, new Object[]{user, dynamicInfo, random, Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            if ((o() && !this.a) || (threadInfo = dynamicInfo.thread_dynamic) == null) {
                return;
            }
            if (this.p == null) {
                this.p = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.f);
            this.f = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.F = this.a;
            cardPersonDynamicThreadData.D = z;
            cardPersonDynamicThreadData.C = z2;
            cardPersonDynamicThreadData.E = z3;
            cardPersonDynamicThreadData.q = 3;
            cardPersonDynamicThreadData.f(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.p.add(cardPersonDynamicThreadData);
        }
    }

    public final void t(User user, PostInfoList postInfoList, Random random) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, user, postInfoList, random) == null) {
            if (o() && !this.a) {
                return;
            }
            if (this.s == null) {
                this.s = new ArrayList<>();
            }
            this.f = UtilHelper.getRandom(random, 3, this.f);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.F = this.a;
            cardPersonDynamicThreadData.D = false;
            cardPersonDynamicThreadData.C = false;
            cardPersonDynamicThreadData.e(user, null, postInfoList, this.f);
            this.s.add(cardPersonDynamicThreadData);
        }
    }

    public final void u(User user) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048596, this, user) == null) && user != null && !ListUtils.isEmpty(user.gift_list)) {
            sba sbaVar = new sba();
            this.n = sbaVar;
            sbaVar.c(user);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048599, this, z) == null) {
            this.b = z;
        }
    }

    public void v(a7a a7aVar) {
        String str;
        String str2;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, a7aVar) != null) || a7aVar == null) {
            return;
        }
        this.B = a7aVar.GetUser();
        if (this.g == null) {
            this.g = new UserData();
        }
        this.g.parserProtobuf(this.B);
        if (this.C == null) {
            this.C = new MetaData();
        }
        this.C.parserProtobuf(this.B);
        if (this.z == null) {
            this.z = new PersonUserGodInfo();
        }
        UserGodInfo userGodInfo = a7aVar.getUserGodInfo();
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.g.setIsBigV(true);
            this.z.parserProtobuf(a7aVar.getUserGodInfo());
        }
        if (this.h == null) {
            this.h = new AntiData();
        }
        this.h.parserProtobuf(a7aVar.GetAntiStat());
        User user = this.B;
        if (user != null) {
            PrivSets privSets = user.priv_sets;
            if (privSets != null) {
                this.d = privSets.like.intValue();
                this.e = this.B.priv_sets.post.intValue();
            }
            this.c = this.B.sex.intValue();
        }
        if (a7aVar.getTaInfo() != null) {
            if (a7aVar.getTaInfo().is_friend.intValue() == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            this.b = z2;
        }
        this.g.setIsFriend(a7aVar.getTaInfo().is_friend.intValue());
        if (a7aVar.getBookrackData() != null) {
            m7a m7aVar = new m7a();
            m7aVar.a(a7aVar.getBookrackData());
            this.t = new p7a(true, m7aVar);
        }
        if (!ListUtils.isEmpty(a7aVar.getConcernedForumList()) && !this.a && !n()) {
            p(a7aVar.getConcernedForumList());
        }
        if (this.n == null) {
            u(this.B);
        }
        Random random = new Random();
        if (this.a && !ListUtils.isEmpty(a7aVar.GetPostList())) {
            for (PostInfoList postInfoList : a7aVar.GetPostList()) {
                if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                    t(this.B, postInfoList, random);
                }
            }
        }
        String yearBytime = StringHelper.getYearBytime(System.currentTimeMillis());
        if (!ListUtils.isEmpty(a7aVar.getDynamicInfoList())) {
            Date date = new Date();
            String str3 = "";
            String str4 = "";
            boolean z3 = true;
            for (DynamicInfo dynamicInfo : a7aVar.getDynamicInfoList()) {
                if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                    long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                    date.setTime(longValue);
                    String yearBytime2 = StringHelper.getYearBytime(longValue);
                    String chineseMonthBytime = StringHelper.getChineseMonthBytime(longValue);
                    String dateBytime = StringHelper.getDateBytime(longValue);
                    boolean z4 = !StringHelper.equals(yearBytime2, yearBytime);
                    if (StringHelper.equals(dateBytime, str3) && StringHelper.equals(chineseMonthBytime, str4) && StringHelper.equals(yearBytime2, yearBytime)) {
                        yearBytime2 = yearBytime;
                        str2 = str3;
                        str = str4;
                        z = false;
                    } else {
                        str = chineseMonthBytime;
                        str2 = dateBytime;
                        z = true;
                    }
                    int intValue = dynamicInfo.type.intValue();
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue == 3) {
                                q(dynamicInfo, z);
                            }
                        } else {
                            r(dynamicInfo, z);
                        }
                    } else {
                        s(this.B, dynamicInfo, random, z4, z, z3);
                    }
                    yearBytime = yearBytime2;
                    str3 = str2;
                    str4 = str;
                    z3 = false;
                }
            }
        }
        if (this.o == null && ListUtils.isEmpty(this.p) && ListUtils.isEmpty(this.s)) {
            uba ubaVar = new uba();
            this.o = ubaVar;
            ubaVar.b = this.c;
            ubaVar.a = this.a;
        }
        if (this.a) {
            d();
            a7aVar.getMaskType();
        }
        a7aVar.getUserAgreeInfo();
        a7aVar.getLiveInfo();
        this.l = a7aVar.getGoodsWindowInfo();
        this.m = a7aVar.getLiveReplayInfo();
        this.A = a7aVar.getNicknameInfo();
        this.E = a7aVar.getHotRankEntry();
        List<ThreadInfo> newestThreadList = a7aVar.getNewestThreadList();
        if (!ListUtils.isEmpty(newestThreadList)) {
            for (int i = 0; i < newestThreadList.size(); i++) {
                ThreadData threadData = new ThreadData();
                threadData.parserProtobuf(newestThreadList.get(i));
                threadData.setAuthor(this.C);
                threadData.praserTimeConsumingInfo();
                this.D.add(threadData);
            }
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            this.b = true;
            this.c = 1;
            this.d = 1;
            this.e = 1;
            this.f = -1;
            this.g = null;
            ArrayList<pi> arrayList = this.i;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.i = null;
            this.j = null;
            this.k = null;
            this.n = null;
            this.o = null;
            List<pi> list = this.p;
            if (list != null) {
                list.clear();
            }
            ArrayList<pi> arrayList2 = this.s;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            this.p = null;
            this.s = null;
            this.q.clear();
            this.A = null;
            this.l = null;
            List<AlaLiveInfoCoreData> list2 = this.m;
            if (list2 != null) {
                list2.clear();
            }
            List<ThreadData> list3 = this.D;
            if (list3 != null) {
                list3.clear();
            }
        }
    }
}
