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
/* loaded from: classes7.dex */
public class nq9 implements xo9 {
    public static /* synthetic */ Interceptable $ic;
    public static final String w;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<yh> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public mq9 e;
    public oq9 f;
    public pq9 g;
    public rq9 h;
    public rq9 i;
    public rq9 j;
    public rq9 k;
    public sq9 l;
    public PersonMoreData m;
    public yq9 n;
    public zq9 o;
    public vq9 p;
    public qq9 q;
    public jq9 r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public uq9 u;
    public yr5 v;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948011251, "Lcom/baidu/tieba/nq9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948011251, "Lcom/baidu/tieba/nq9;");
                return;
            }
        }
        w = TbConfig.TIEBA_ADDRESS + "mo/q/hybrid-usergrow-base/novelChannel?channel_id=personal_tieba_story&customfullscreen=1&nonavigationbar=1&user_skin_overlay=0";
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            qq9 qq9Var = this.q;
            if (qq9Var != null && this.a.contains(qq9Var)) {
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

    public nq9() {
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
        this.v = yr5.d();
        this.a = new ArrayList<>();
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            mq9 mq9Var = this.e;
            if (mq9Var != null) {
                this.a.add(mq9Var);
            } else if (this.b == null) {
            } else {
                this.e = new mq9();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                mq9 mq9Var2 = this.e;
                mq9Var2.e = this.b;
                this.a.add(mq9Var2);
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

    public sq9 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (sq9) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            mq9 mq9Var = this.e;
            if (mq9Var != null && this.a.contains(mq9Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public jq9 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (jq9) invokeV.objValue;
    }

    public ArrayList<yh> x() {
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
            uq9 uq9Var = this.u;
            if (uq9Var != null && this.a.contains(uq9Var)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            kp9 kp9Var = new kp9();
            kp9Var.a(tbBookrack);
            new np9(true, kp9Var);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new dp9().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        rq9 rq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (rq9Var = this.j) != null) {
            if (rq9Var.h == null) {
                rq9Var.h = new tq9();
            }
            this.j.h.b(z);
        }
    }

    public void e(boolean z) {
        mq9 mq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (mq9Var = this.e) != null) {
            mq9Var.d = z;
        }
    }

    public void f(boolean z) {
        rq9 rq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (rq9Var = this.k) != null) {
            if (rq9Var.h == null) {
                rq9Var.h = new tq9();
            }
            this.k.h.b(z);
        }
    }

    public void g(boolean z) {
        rq9 rq9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (rq9Var = this.h) != null) {
            if (rq9Var.h == null) {
                rq9Var.h = new tq9();
            }
            this.h.h.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            oq9 oq9Var = this.f;
            if (oq9Var != null) {
                this.a.add(oq9Var);
                return;
            }
            oq9 oq9Var2 = new oq9();
            this.f = oq9Var2;
            oq9Var2.d(namoaixudEntry);
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

    public List<rq9> q(List<CustomGrid> list) {
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
                    iq9 iq9Var = new iq9();
                    iq9Var.a(customGrid);
                    rq9 b = iq9Var.b();
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
                        b.h = new tq9();
                    }
                    b.h.b(i(iq9Var));
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

    @Override // com.baidu.tieba.xo9
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            sq9 sq9Var = new sq9();
            this.l = sq9Var;
            sq9Var.a = this.b;
            this.a.add(sq9Var);
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
            vq9 vq9Var = new vq9();
            this.p = vq9Var;
            this.a.add(vq9Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new xq9(smartApp));
                }
            }
        }
        this.p.d(arrayList);
    }

    @Override // com.baidu.tieba.xo9
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new sq9();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                jq9 jq9Var = new jq9();
                this.r = jq9Var;
                jq9Var.d(profileResIdl.data.bubble_info);
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
                List<rq9> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    uq9 uq9Var = new uq9();
                    uq9Var.d(q);
                    this.a.add(uq9Var);
                    this.u = uq9Var;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<rq9> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (rq9 rq9Var : q2) {
                        if (rq9Var != null) {
                            this.a.add(rq9Var);
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
                        f.put(list.get(i).getApkPackageName(), yr5.k);
                    } else if (list.get(i).getStatus().status == yr5.g) {
                        f.put(list.get(i).getApkPackageName(), yr5.j);
                        if (this.v.e()) {
                            f.put(yr5.i, yr5.k);
                        } else {
                            f.put(yr5.i, yr5.j);
                        }
                    } else if (list.get(i).getStatus().status == yr5.h) {
                        f.put(list.get(i).getApkPackageName(), yr5.k);
                    } else {
                        f.put(list.get(i).getApkPackageName(), yr5.k);
                    }
                }
            }
            this.v.m(f);
        }
    }

    public final boolean i(iq9 iq9Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, iq9Var)) == null) {
            if (iq9Var == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (iq9Var.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(iq9Var.f);
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
                if (this.t.get(String.valueOf(iq9Var.e)) == null) {
                    this.t.put(String.valueOf(iq9Var.e), personRedTipData);
                    SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (iq9Var.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(iq9Var.e)) != null) {
                    if (iq9Var.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(iq9Var.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(iq9Var.e), personRedTipData);
                        SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (iq9Var.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(iq9Var.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(iq9Var.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(iq9Var.e), personRedTipData);
            SharedPrefHelper.getInstance().putString(SharedPrefHelper.getSharedPrefKeyWithAccount("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (iq9Var.f == 0) {
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
        zq9 zq9Var = this.o;
        if (zq9Var != null) {
            this.a.add(zq9Var);
            return;
        }
        this.o = new zq9();
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
            qq9 qq9Var = this.q;
            if (qq9Var != null) {
                this.a.add(qq9Var);
                return;
            }
            CreationData creationData = user.creation_data;
            if (creationData == null) {
                return;
            }
            CreationData creationData2 = user.workcreation_data;
            qq9 qq9Var2 = new qq9();
            this.q = qq9Var2;
            qq9Var2.d(creationData);
            this.q.e(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            pq9 pq9Var = this.g;
            if (pq9Var != null) {
                this.a.add(pq9Var);
                return;
            }
            this.g = new pq9();
            hc5 hc5Var = new hc5();
            hc5Var.g(userGrowth);
            this.g.d(hc5Var);
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

    public final rq9 m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            rq9 rq9Var = new rq9();
            rq9Var.b = i;
            rq9Var.e = TbadkCoreApplication.getInst().getString(i2);
            rq9Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                rq9Var.g = userData;
            }
            return rq9Var;
        }
        return (rq9) invokeIII.objValue;
    }

    public final rq9 n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            rq9 rq9Var = new rq9();
            rq9Var.b = i;
            rq9Var.e = str;
            rq9Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                rq9Var.g = userData;
            }
            return rq9Var;
        }
        return (rq9) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            rq9 m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.n = true;
            this.a.add(m);
            rq9 m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f0318, 39);
            m2.c = true;
            this.a.add(m2);
            rq9 n = n(R.drawable.obfuscated_res_0x7f080a60, "订单中心", 47);
            n.f = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            rq9 n2 = n(R.drawable.obfuscated_res_0x7f080a4e, "开店", 48);
            tq9 tq9Var = new tq9();
            n2.h = tq9Var;
            tq9Var.i = "免佣金";
            n2.f = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            rq9 n3 = n(R.drawable.obfuscated_res_0x7f080b6d, "隐私设置", 61);
            tq9 tq9Var2 = new tq9();
            n3.h = tq9Var2;
            if (SharedPrefHelper.getInstance().getInt("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            tq9Var2.a = z;
            this.a.add(n3);
            rq9 n4 = n(R.drawable.obfuscated_res_0x7f080a41, "广告推广", 49);
            n4.f = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            rq9 m3 = m(R.drawable.obfuscated_res_0x7f080a5f, R.string.obfuscated_res_0x7f0f1080, 33);
            m3.i = OrmObject.bundleWithObject(this.m);
            m3.h = new tq9();
            m3.o = true;
            this.a.add(m3);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            uq9 uq9Var = new uq9();
            ArrayList arrayList = new ArrayList();
            rq9 m = m(R.drawable.obfuscated_res_0x7f080a4c, R.string.member_center, 12);
            m.c = true;
            m.g = this.b;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a45, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809bb, R.string.certification_center, 53));
            rq9 m2 = m(R.drawable.obfuscated_res_0x7f080a44, R.string.create_ba, 56);
            m2.f = TbConfig.CREATE_BA;
            arrayList.add(m2);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a51, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a42, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                rq9 m3 = m(R.drawable.obfuscated_res_0x7f080a43, R.string.official_account, 15);
                m3.c = true;
                arrayList.add(m3);
            }
            rq9 m4 = m(R.drawable.obfuscated_res_0x7f080a4a, R.string.account_check, 50);
            m4.f = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m4);
            rq9 m5 = m(R.drawable.obfuscated_res_0x7f080a47, R.string.obfuscated_res_0x7f0f0d3e, 10);
            this.i = m5;
            m5.h = new tq9();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            tq9 tq9Var = this.i.h;
            tq9Var.c = formatNumForTdouDisPlay;
            tq9Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0809dd, R.string.welfare_entrance, 63));
            rq9 m6 = m(R.drawable.obfuscated_res_0x7f080a50, R.string.mark_center, 51);
            m6.f = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m6);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a4f, R.string.subscribe_manager, 52));
            rq9 m7 = m(R.drawable.obfuscated_res_0x7f080a48, R.string.obfuscated_res_0x7f0f0ee3, 54);
            m7.f = w;
            arrayList.add(m7);
            rq9 m8 = m(R.drawable.obfuscated_res_0x7f080a5a, R.string.community_convention, 55);
            m8.f = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m8);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080a49, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080c64, R.string.exchange_mall, 60));
            uq9Var.d(arrayList);
            this.a.add(uq9Var);
            this.u = uq9Var;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            yq9 yq9Var = this.n;
            if (yq9Var != null && yq9Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new yq9();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                hq9 hq9Var = new hq9();
                hq9Var.b(this.c.get(i));
                if (!ad.isEmpty(hq9Var.a())) {
                    this.n.a.add(hq9Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }
}
