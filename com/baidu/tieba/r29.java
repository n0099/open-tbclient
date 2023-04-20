package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.nadcore.download.basic.AdAppStateManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.flow.data.ApkDownloadInfoData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tbadk.util.DataExt;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.personCenter.data.PersonRedTipData;
import com.baidu.tieba.personCenter.data.PersonVipCardData;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import tbclient.BannerImage;
import tbclient.CreationData;
import tbclient.CustomGrid;
import tbclient.NamoaixudEntry;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Namoaixud;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.Profile.VipBanner;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserGrowth;
import tbclient.UserMap;
/* loaded from: classes6.dex */
public class r29 implements c19 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<in> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public q29 e;
    public s29 f;
    public t29 g;
    public v29 h;
    public v29 i;
    public v29 j;
    public v29 k;
    public w29 l;
    public PersonMoreData m;
    public c39 n;
    public d39 o;
    public z29 p;
    public u29 q;
    public n29 r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public y29 u;
    public vq5 v;

    public r29() {
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
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.s = null;
        this.t = new HashMap<>();
        this.u = null;
        this.v = null;
        this.a = new ArrayList<>();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            q29 q29Var = this.e;
            if (q29Var != null) {
                this.a.add(q29Var);
            } else if (this.b == null) {
            } else {
                this.e = new q29();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                q29 q29Var2 = this.e;
                q29Var2.e = this.b;
                this.a.add(q29Var2);
            }
        }
    }

    public UserData A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (UserData) invokeV.objValue;
    }

    public w29 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (w29) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            q29 q29Var = this.e;
            if (q29Var != null && this.a.contains(q29Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public n29 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (n29) invokeV.objValue;
    }

    public ArrayList<in> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            y29 y29Var = this.u;
            if (y29Var != null && this.a.contains(y29Var)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            o19 o19Var = new o19();
            o19Var.a(tbBookrack);
            new r19(true, o19Var);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new h19().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        v29 v29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (v29Var = this.j) != null) {
            if (v29Var.i == null) {
                v29Var.i = new x29();
            }
            this.j.i.b(z);
        }
    }

    public void e(boolean z) {
        q29 q29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (q29Var = this.e) != null) {
            q29Var.d = z;
        }
    }

    public void f(boolean z) {
        v29 v29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (v29Var = this.k) != null) {
            if (v29Var.i == null) {
                v29Var.i = new x29();
            }
            this.k.i.b(z);
        }
    }

    public void g(boolean z) {
        v29 v29Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (v29Var = this.h) != null) {
            if (v29Var.i == null) {
                v29Var.i = new x29();
            }
            this.h.i.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            s29 s29Var = this.f;
            if (s29Var != null) {
                this.a.add(s29Var);
                return;
            }
            s29 s29Var2 = new s29();
            this.f = s29Var2;
            s29Var2.d(namoaixudEntry);
            this.a.add(this.f);
        }
    }

    public final void E(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.m = new PersonMoreData();
        for (UserMap userMap : list) {
            if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                String replaceAll = userMap.url.replaceAll("amp;", "");
                PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                personMoreItemData.mId = userMap.id.intValue();
                personMoreItemData.mName = userMap.name;
                personMoreItemData.mUrl = replaceAll;
                this.m.mUrlMaps.add(personMoreItemData);
            }
        }
    }

    public List<v29> q(List<CustomGrid> list) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                CustomGrid customGrid = list.get(i);
                if (customGrid != null) {
                    m29 m29Var = new m29();
                    m29Var.a(customGrid);
                    v29 b = m29Var.b();
                    boolean z2 = true;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b.o = z;
                    if (i != list.size() - 1) {
                        z2 = false;
                    }
                    b.p = z2;
                    if (b.a == 33 && b.m == 0) {
                        if (this.m == null) {
                            this.m = new PersonMoreData();
                        }
                        b.j = OrmObject.bundleWithObject(this.m);
                    }
                    if (b.i == null) {
                        b.i = new x29();
                    }
                    b.i.b(i(m29Var));
                    arrayList.add(b);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public final void F(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, user, userGodInfo) == null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(user);
            if (this.d == null && userGodInfo != null) {
                this.d = new PersonUserGodInfo();
            }
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.b.setIsBigV(true);
                PersonUserGodInfo personUserGodInfo = this.d;
                if (personUserGodInfo != null) {
                    personUserGodInfo.parserProtobuf(userGodInfo);
                }
            }
            this.l.a = this.b;
        }
    }

    @Override // com.baidu.tieba.c19
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            w29 w29Var = new w29();
            this.l = w29Var;
            w29Var.a = this.b;
            this.a.add(w29Var);
            h();
            o();
            PersonRedTipManager.getInstance().syncRedTipState(true);
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
            }
        }
    }

    public final void r(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048600, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            z29 z29Var = new z29();
            this.p = z29Var;
            this.a.add(z29Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new b39(smartApp));
                }
            }
        }
        this.p.d(arrayList);
    }

    @Override // com.baidu.tieba.c19
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new w29();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                n29 n29Var = new n29();
                this.r = n29Var;
                n29Var.d(profileResIdl.data.bubble_info);
            }
            this.a.clear();
            this.a.add(this.l);
            h();
            z(profileResIdl.data.vip_banner);
            t();
            DataRes dataRes2 = profileResIdl.data;
            if (dataRes2.finance_tab != null && (namoaixudEntry = dataRes2.namoaixud_entry) != null) {
                l(namoaixudEntry);
            }
            User user = profileResIdl.data.user;
            if (user != null && (userGrowth = user.user_growth) != null) {
                s(userGrowth);
            }
            k(profileResIdl.data.user);
            if (!ListUtils.isEmpty(profileResIdl.data.custom_grid)) {
                List<v29> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    y29 y29Var = new y29();
                    y29Var.d(q);
                    this.a.add(y29Var);
                    this.u = y29Var;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<v29> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (v29 v29Var : q2) {
                        if (v29Var != null) {
                            this.a.add(v29Var);
                        }
                    }
                } else {
                    o();
                }
            } else {
                o();
            }
            PersonRedTipManager.getInstance().syncRedTipState(true);
        }
    }

    public final void c(List<ApkDownloadInfoData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, list) == null) && TbadkCoreApplication.getCurrentAccount() != null && list != null && list.size() > 0) {
            HashMap<String, String> e = this.v.e();
            if (e == null) {
                e = new HashMap<>();
            }
            for (int i = 0; i < list.size(); i++) {
                if (!e.containsKey(list.get(i).getApkPackageName())) {
                    if (list.get(i).getStatus() == null) {
                        e.put(list.get(i).getApkPackageName(), vq5.k);
                    } else if (list.get(i).getStatus().status == vq5.g) {
                        e.put(list.get(i).getApkPackageName(), vq5.j);
                        if (this.v.d()) {
                            e.put(vq5.i, vq5.k);
                        } else {
                            e.put(vq5.i, vq5.j);
                        }
                    } else if (list.get(i).getStatus().status == vq5.h) {
                        e.put(list.get(i).getApkPackageName(), vq5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), vq5.k);
                    }
                }
            }
            this.v.m(e);
        }
    }

    public final boolean i(m29 m29Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, m29Var)) == null) {
            if (m29Var == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (m29Var.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(m29Var.f);
            if (this.t == null) {
                this.t = new HashMap<>();
            }
            String s = q45.m().s(q45.q("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(s)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(s).entrySet()) {
                    if (entry.getValue() instanceof Map) {
                        PersonRedTipData personRedTipData2 = new PersonRedTipData();
                        if (((Map) entry.getValue()).get("hadShow") instanceof Boolean) {
                            personRedTipData2.setShow(((Boolean) ((Map) entry.getValue()).get("hadShow")).booleanValue());
                        }
                        if (((Map) entry.getValue()).get("redPointVersion") instanceof Long) {
                            personRedTipData2.setRedPointVersion(((Long) ((Map) entry.getValue()).get("redPointVersion")).longValue());
                        }
                        this.t.put(entry.getKey(), personRedTipData2);
                    }
                }
                if (this.t.get(String.valueOf(m29Var.e)) == null) {
                    this.t.put(String.valueOf(m29Var.e), personRedTipData);
                    q45.m().B(q45.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (m29Var.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(m29Var.e)) != null) {
                    if (m29Var.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(m29Var.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(m29Var.e), personRedTipData);
                        q45.m().B(q45.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (m29Var.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(m29Var.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(m29Var.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(m29Var.e), personRedTipData);
            q45.m().B(q45.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (m29Var.f == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        List<ApkDownloadInfoData> list;
        yj0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        d39 d39Var = this.o;
        if (d39Var != null) {
            this.a.add(d39Var);
            return;
        }
        d39 d39Var2 = new d39();
        this.o = d39Var2;
        if (d39Var2 != null && (list = d39Var2.a) != null && d39Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.v = vq5.c();
            HashMap<String, yj0> a = pj0.b().a();
            if (a != null) {
                for (Map.Entry<String, yj0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == vq5.g) {
                        if (this.v.i(value.h.getAbsolutePath()) && !this.v.j(value.d)) {
                            ck0 ck0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(ck0Var.g, value.h, ck0Var.h, value.c, value.d, value.m, value);
                            if (!this.o.a.contains(apkDownloadInfoData)) {
                                this.o.a.add(apkDownloadInfoData);
                            }
                        } else {
                            this.v.l(value.d);
                        }
                    }
                }
                if (this.o.a.size() == 0) {
                    if (this.a.contains(this.o)) {
                        this.a.remove(this.o);
                        return;
                    }
                    return;
                }
                Collections.sort(this.o.a);
                if (this.o.a.size() <= 5) {
                    d39 d39Var3 = this.o;
                    d39Var3.b.addAll(d39Var3.a);
                } else {
                    d39 d39Var4 = this.o;
                    d39Var4.b.addAll(d39Var4.a.subList(0, 5));
                }
                if (this.o.b.size() == 0) {
                    return;
                }
                for (ApkDownloadInfoData apkDownloadInfoData2 : this.o.b) {
                    if (apkDownloadInfoData2.getAdDownloadBean() != null) {
                        AdAppStateManager.instance().register(apkDownloadInfoData2.getAdDownloadBean());
                    }
                }
                c(this.o.b);
                if (!this.v.d() && this.v.f()) {
                    this.v.o();
                }
                this.v.q();
                this.a.add(this.o);
            }
        }
    }

    public final void k(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, user) == null) {
            u29 u29Var = this.q;
            if (u29Var != null) {
                this.a.add(u29Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            u29 u29Var2 = new u29();
            this.q = u29Var2;
            u29Var2.e(creationData);
            this.q.f(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            t29 t29Var = this.g;
            if (t29Var != null) {
                this.a.add(t29Var);
                return;
            }
            this.g = new t29();
            cc5 cc5Var = new cc5();
            cc5Var.g(userGrowth);
            this.g.d(cc5Var);
            this.a.add(this.g);
        }
    }

    public final void z(VipBanner vipBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, vipBanner) == null) {
            PersonVipCardData personVipCardData = this.s;
            if (personVipCardData != null && personVipCardData.getTitle() != null) {
                this.a.add(this.s);
                return;
            }
            PersonVipCardData personVipCardData2 = new PersonVipCardData();
            this.s = personVipCardData2;
            personVipCardData2.parserProtobuf(vipBanner);
            if (this.s.getTitle() != null) {
                this.a.add(this.s);
            }
        }
    }

    public final v29 m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            v29 v29Var = new v29();
            v29Var.b = i;
            v29Var.e = TbadkCoreApplication.getInst().getString(i2);
            v29Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                v29Var.h = userData;
            }
            return v29Var;
        }
        return (v29) invokeIII.objValue;
    }

    public final v29 n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            v29 v29Var = new v29();
            v29Var.b = i;
            v29Var.e = str;
            v29Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                v29Var.h = userData;
            }
            return v29Var;
        }
        return (v29) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            v29 m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.o = true;
            this.a.add(m);
            v29 m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02e3, 39);
            m2.c = true;
            this.a.add(m2);
            v29 n = n(R.drawable.obfuscated_res_0x7f0808c1, "订单中心", 47);
            n.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            v29 n2 = n(R.drawable.obfuscated_res_0x7f0808af, "开店", 48);
            x29 x29Var = new x29();
            n2.i = x29Var;
            x29Var.i = "免佣金";
            n2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            v29 n3 = n(R.drawable.obfuscated_res_0x7f0809bc, "隐私设置", 61);
            x29 x29Var2 = new x29();
            n3.i = x29Var2;
            if (q45.m().n("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            x29Var2.a = z;
            this.a.add(n3);
            v29 n4 = n(R.drawable.obfuscated_res_0x7f0808a2, "广告推广", 49);
            n4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            v29 m3 = m(R.drawable.obfuscated_res_0x7f0808c0, R.string.obfuscated_res_0x7f0f0f0a, 33);
            m3.j = OrmObject.bundleWithObject(this.m);
            m3.i = new x29();
            m3.p = true;
            this.a.add(m3);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            y29 y29Var = new y29();
            ArrayList arrayList = new ArrayList();
            v29 m = m(R.drawable.obfuscated_res_0x7f0808ad, R.string.member_center, 12);
            m.c = true;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808a6, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f08081f, R.string.certification_center, 53));
            v29 m2 = m(R.drawable.obfuscated_res_0x7f0808a5, R.string.create_ba, 56);
            m2.g = TbConfig.CREATE_BA;
            arrayList.add(m2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                v29 m3 = m(R.drawable.obfuscated_res_0x7f0808ac, R.string.ala_live, 25);
                m3.c = true;
                m3.f = true;
                arrayList.add(m3);
            }
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808b2, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808a3, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                v29 m4 = m(R.drawable.obfuscated_res_0x7f0808a4, R.string.official_account, 15);
                m4.c = true;
                arrayList.add(m4);
            }
            v29 m5 = m(R.drawable.obfuscated_res_0x7f0808ab, R.string.account_check, 50);
            m5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m5);
            v29 m6 = m(R.drawable.obfuscated_res_0x7f0808a8, R.string.obfuscated_res_0x7f0f0c0f, 10);
            this.i = m6;
            m6.i = new x29();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            x29 x29Var = this.i.i;
            x29Var.c = formatNumForTdouDisPlay;
            x29Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f08083d, R.string.welfare_entrance, 63));
            v29 m7 = m(R.drawable.obfuscated_res_0x7f0808b1, R.string.mark_center, 51);
            m7.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m7);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808b0, R.string.subscribe_manager, 52));
            v29 m8 = m(R.drawable.obfuscated_res_0x7f0808a9, R.string.novel_member_monthly, 54);
            m8.g = cl5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(m8);
            v29 m9 = m(R.drawable.obfuscated_res_0x7f0808bb, R.string.community_convention, 55);
            m9.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m9);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808aa, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080ab0, R.string.exchange_mall, 60));
            y29Var.d(arrayList);
            this.a.add(y29Var);
            this.u = y29Var;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            c39 c39Var = this.n;
            if (c39Var != null && c39Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new c39();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                l29 l29Var = new l29();
                l29Var.b(this.c.get(i));
                if (!hi.isEmpty(l29Var.a())) {
                    this.n.a.add(l29Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            u29 u29Var = this.q;
            if (u29Var != null && this.a.contains(u29Var)) {
                for (int i = 0; i < this.a.size(); i++) {
                    if (this.a.get(i) == this.q) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }
}
