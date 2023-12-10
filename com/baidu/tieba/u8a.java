package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
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
/* loaded from: classes8.dex */
public class u8a implements e7a {
    public static /* synthetic */ Interceptable $ic;
    public static final String w;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pi> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public t8a e;
    public v8a f;
    public w8a g;
    public y8a h;
    public y8a i;
    public y8a j;
    public y8a k;
    public z8a l;
    public PersonMoreData m;
    public f9a n;
    public g9a o;
    public c9a p;
    public x8a q;
    public q8a r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public b9a u;
    public fu5 v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948166251, "Lcom/baidu/tieba/u8a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948166251, "Lcom/baidu/tieba/u8a;");
                return;
            }
        }
        w = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-usergrow-base/novelChannel?channel_id=personal_tieba_story&customfullscreen=1&nonavigationbar=1&user_skin_overlay=0";
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            x8a x8aVar = this.q;
            if (x8aVar != null && this.a.contains(x8aVar)) {
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

    public u8a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
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
        this.v = fu5.d();
        this.a = new ArrayList<>();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            t8a t8aVar = this.e;
            if (t8aVar != null) {
                this.a.add(t8aVar);
            } else if (this.b == null) {
            } else {
                this.e = new t8a();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                t8a t8aVar2 = this.e;
                t8aVar2.e = this.b;
                this.a.add(t8aVar2);
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

    public z8a B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (z8a) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            t8a t8aVar = this.e;
            if (t8aVar != null && this.a.contains(t8aVar)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public q8a v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (q8a) invokeV.objValue;
    }

    public ArrayList<pi> x() {
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
            b9a b9aVar = this.u;
            if (b9aVar != null && this.a.contains(b9aVar)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            r7a r7aVar = new r7a();
            r7aVar.a(tbBookrack);
            new u7a(true, r7aVar);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new k7a().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        y8a y8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (y8aVar = this.j) != null) {
            if (y8aVar.h == null) {
                y8aVar.h = new a9a();
            }
            this.j.h.b(z);
        }
    }

    public void e(boolean z) {
        t8a t8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (t8aVar = this.e) != null) {
            t8aVar.d = z;
        }
    }

    public void f(boolean z) {
        y8a y8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (y8aVar = this.k) != null) {
            if (y8aVar.h == null) {
                y8aVar.h = new a9a();
            }
            this.k.h.b(z);
        }
    }

    public void g(boolean z) {
        y8a y8aVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (y8aVar = this.h) != null) {
            if (y8aVar.h == null) {
                y8aVar.h = new a9a();
            }
            this.h.h.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            v8a v8aVar = this.f;
            if (v8aVar != null) {
                this.a.add(v8aVar);
                return;
            }
            v8a v8aVar2 = new v8a();
            this.f = v8aVar2;
            v8aVar2.d(namoaixudEntry);
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

    public List<y8a> q(List<CustomGrid> list) {
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
                    p8a p8aVar = new p8a();
                    p8aVar.a(customGrid);
                    y8a b = p8aVar.b();
                    boolean z2 = true;
                    if (i == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    b.n = z;
                    if (i != list.size() - 1) {
                        z2 = false;
                    }
                    b.o = z2;
                    if (b.a == 33 && b.l == 0) {
                        if (this.m == null) {
                            this.m = new PersonMoreData();
                        }
                        b.i = OrmObject.bundleWithObject(this.m);
                    }
                    if (b.h == null) {
                        b.h = new a9a();
                    }
                    b.h.b(i(p8aVar));
                    b.g = this.b;
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

    @Override // com.baidu.tieba.e7a
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            z8a z8aVar = new z8a();
            this.l = z8aVar;
            z8aVar.a = this.b;
            this.a.add(z8aVar);
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
            c9a c9aVar = new c9a();
            this.p = c9aVar;
            this.a.add(c9aVar);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new e9a(smartApp));
                }
            }
        }
        this.p.d(arrayList);
    }

    @Override // com.baidu.tieba.e7a
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new z8a();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                q8a q8aVar = new q8a();
                this.r = q8aVar;
                q8aVar.d(profileResIdl.data.bubble_info);
            }
            this.a.clear();
            this.a.add(this.l);
            h();
            k(profileResIdl.data.user);
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
            if (!ListUtils.isEmpty(profileResIdl.data.custom_grid)) {
                List<y8a> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    b9a b9aVar = new b9a();
                    b9aVar.d(q);
                    this.a.add(b9aVar);
                    this.u = b9aVar;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<y8a> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (y8a y8aVar : q2) {
                        if (y8aVar != null) {
                            this.a.add(y8aVar);
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
            HashMap<String, String> f = this.v.f();
            if (f == null) {
                f = new HashMap<>();
            }
            for (int i = 0; i < list.size(); i++) {
                if (!f.containsKey(list.get(i).getApkPackageName())) {
                    if (list.get(i).getStatus() == null) {
                        f.put(list.get(i).getApkPackageName(), fu5.k);
                    } else if (list.get(i).getStatus().status == fu5.g) {
                        f.put(list.get(i).getApkPackageName(), fu5.j);
                        if (this.v.e()) {
                            f.put(fu5.i, fu5.k);
                        } else {
                            f.put(fu5.i, fu5.j);
                        }
                    } else if (list.get(i).getStatus().status == fu5.h) {
                        f.put(list.get(i).getApkPackageName(), fu5.k);
                    } else {
                        f.put(list.get(i).getApkPackageName(), fu5.k);
                    }
                }
            }
            this.v.m(f);
        }
    }

    public final boolean i(p8a p8aVar) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, p8aVar)) == null) {
            if (p8aVar == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (p8aVar.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(p8aVar.f);
            if (this.t == null) {
                this.t = new HashMap<>();
            }
            String string = SharedPrefHelper.getInstance().getString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), "");
            if (!StringUtils.isNull(string)) {
                new HashMap();
                for (Map.Entry<String, Object> entry : DataExt.toMap(string).entrySet()) {
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
                if (this.t.get(String.valueOf(p8aVar.e)) == null) {
                    this.t.put(String.valueOf(p8aVar.e), personRedTipData);
                    SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (p8aVar.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(p8aVar.e)) != null) {
                    if (p8aVar.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(p8aVar.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(p8aVar.e), personRedTipData);
                        SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (p8aVar.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(p8aVar.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(p8aVar.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(p8aVar.e), personRedTipData);
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (p8aVar.f == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        g9a g9aVar = this.o;
        if (g9aVar != null) {
            this.a.add(g9aVar);
            return;
        }
        this.o = new g9a();
        List<ApkDownloadInfoData> a = this.v.a(5);
        if (a != null) {
            this.o.a.addAll(a);
        }
        if (this.o.a.size() == 0) {
            if (this.a.contains(this.o)) {
                this.a.remove(this.o);
                return;
            }
            return;
        }
        for (ApkDownloadInfoData apkDownloadInfoData : this.o.a) {
            if (apkDownloadInfoData.getAdDownloadBean() != null) {
                AdAppStateManager.instance().register(apkDownloadInfoData.getAdDownloadBean());
            }
        }
        c(this.o.a);
        if (!this.v.e() && this.v.g()) {
            this.v.o();
        }
        this.v.q();
        this.a.add(this.o);
    }

    public final void k(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, user) == null) {
            x8a x8aVar = this.q;
            if (x8aVar != null) {
                this.a.add(x8aVar);
                return;
            }
            CreationData creationData = user.creation_data;
            if (creationData == null) {
                return;
            }
            CreationData creationData2 = user.workcreation_data;
            x8a x8aVar2 = new x8a();
            this.q = x8aVar2;
            x8aVar2.d(creationData);
            this.q.e(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            w8a w8aVar = this.g;
            if (w8aVar != null) {
                this.a.add(w8aVar);
                return;
            }
            this.g = new w8a();
            md5 md5Var = new md5();
            md5Var.g(userGrowth);
            this.g.d(md5Var);
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

    public final y8a m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            y8a y8aVar = new y8a();
            y8aVar.b = i;
            y8aVar.e = TbadkCoreApplication.getInst().getString(i2);
            y8aVar.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                y8aVar.g = userData;
            }
            return y8aVar;
        }
        return (y8a) invokeIII.objValue;
    }

    public final y8a n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            y8a y8aVar = new y8a();
            y8aVar.b = i;
            y8aVar.e = str;
            y8aVar.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                y8aVar.g = userData;
            }
            return y8aVar;
        }
        return (y8a) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            y8a m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.n = true;
            this.a.add(m);
            y8a m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f0320, 39);
            m2.c = true;
            this.a.add(m2);
            y8a n = n(R.drawable.obfuscated_res_0x7f080a74, "订单中心", 47);
            n.f = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            y8a n2 = n(R.drawable.obfuscated_res_0x7f080a62, "开店", 48);
            a9a a9aVar = new a9a();
            n2.h = a9aVar;
            a9aVar.i = "免佣金";
            n2.f = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            y8a n3 = n(R.drawable.obfuscated_res_0x7f080b86, "隐私设置", 61);
            a9a a9aVar2 = new a9a();
            n3.h = a9aVar2;
            if (SharedPrefHelper.getInstance().getInt("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            a9aVar2.a = z;
            this.a.add(n3);
            y8a n4 = n(R.drawable.obfuscated_res_0x7f080a55, "广告推广", 49);
            n4.f = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            y8a m3 = m(R.drawable.obfuscated_res_0x7f080a73, R.string.obfuscated_res_0x7f0f10a3, 33);
            m3.i = OrmObject.bundleWithObject(this.m);
            m3.h = new a9a();
            m3.o = true;
            this.a.add(m3);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            b9a b9aVar = new b9a();
            ArrayList arrayList = new ArrayList();
            y8a m = m(R.drawable.obfuscated_res_0x7f080a60, R.string.member_center, 12);
            m.c = true;
            m.g = this.b;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a59, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809cb, R.string.certification_center, 53));
            y8a m2 = m(R.drawable.obfuscated_res_0x7f080a58, R.string.create_ba, 56);
            m2.f = TbConfig.CREATE_BA;
            arrayList.add(m2);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a65, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a56, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                y8a m3 = m(R.drawable.obfuscated_res_0x7f080a57, R.string.official_account, 15);
                m3.c = true;
                arrayList.add(m3);
            }
            y8a m4 = m(R.drawable.obfuscated_res_0x7f080a5e, R.string.account_check, 50);
            m4.f = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m4);
            y8a m5 = m(R.drawable.obfuscated_res_0x7f080a5b, R.string.obfuscated_res_0x7f0f0d5e, 10);
            this.i = m5;
            m5.h = new a9a();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            a9a a9aVar = this.i.h;
            a9aVar.c = formatNumForTdouDisPlay;
            a9aVar.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809ef, R.string.welfare_entrance, 63));
            y8a m6 = m(R.drawable.obfuscated_res_0x7f080a64, R.string.mark_center, 51);
            m6.f = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m6);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a63, R.string.subscribe_manager, 52));
            y8a m7 = m(R.drawable.obfuscated_res_0x7f080a5c, R.string.obfuscated_res_0x7f0f0f04, 54);
            m7.f = w;
            arrayList.add(m7);
            y8a m8 = m(R.drawable.obfuscated_res_0x7f080a6e, R.string.community_convention, 55);
            m8.f = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m8);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a5d, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080c82, R.string.exchange_mall, 60));
            b9aVar.d(arrayList);
            this.a.add(b9aVar);
            this.u = b9aVar;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            f9a f9aVar = this.n;
            if (f9aVar != null && f9aVar.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new f9a();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                o8a o8aVar = new o8a();
                o8aVar.b(this.c.get(i));
                if (!rd.isEmpty(o8aVar.a())) {
                    this.n.a.add(o8aVar);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }
}
