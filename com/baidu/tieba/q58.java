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
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
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
import tbclient.BannerImage;
import tbclient.CreationData;
import tbclient.DuxiaomanEntry;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.Profile.VipBanner;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserGrowth;
import tbclient.UserMap;
/* loaded from: classes5.dex */
public class q58 implements b48 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<Cdo> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public p58 e;
    public r58 f;
    public s58 g;
    public u58 h;
    public u58 i;
    public u58 j;
    public u58 k;
    public v58 l;
    public PersonMoreData m;
    public b68 n;
    public c68 o;
    public y58 p;
    public t58 q;
    public m58 r;
    public PersonVipCardData s;
    public wh5 t;
    public x58 u;

    public q58() {
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
        this.t = null;
        this.u = null;
        this.a = new ArrayList<>();
    }

    public final void A(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, user, userGodInfo) == null) {
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

    public void B(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    @Override // com.baidu.tieba.b48
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        v58 v58Var = new v58();
        this.l = v58Var;
        v58Var.a = this.b;
        this.a.add(v58Var);
        h();
        n();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.baidu.tieba.b48
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new v58();
        DataRes dataRes = profileResIdl.data;
        this.c = dataRes.banner;
        Duxiaoman duxiaoman = dataRes.duxiaoman;
        A(dataRes.user, dataRes.user_god_info);
        x(profileResIdl.data.tbbookrack);
        y(profileResIdl.data.uc_card);
        z(profileResIdl.data.url_map);
        if (profileResIdl.data.bubble_info != null) {
            m58 m58Var = new m58();
            this.r = m58Var;
            m58Var.c(profileResIdl.data.bubble_info);
        }
        this.a.clear();
        this.a.add(this.l);
        v(profileResIdl.data.vip_banner);
        h();
        r();
        DataRes dataRes2 = profileResIdl.data;
        if (dataRes2.finance_tab != null && (duxiaomanEntry = dataRes2.duxiaoman_entry) != null) {
            k(duxiaomanEntry);
        }
        User user = profileResIdl.data.user;
        if (user != null && (userGrowth = user.user_growth) != null) {
            q(userGrowth);
        }
        j(profileResIdl.data.user);
        o();
        i();
        p(profileResIdl.data.recom_swan_list);
        n();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public final void c(List<ApkDownloadInfoData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || TbadkCoreApplication.getCurrentAccount() == null || list == null || list.size() <= 0) {
            return;
        }
        HashMap<String, String> e = this.t.e();
        if (e == null) {
            e = new HashMap<>();
        }
        for (int i = 0; i < list.size(); i++) {
            if (!e.containsKey(list.get(i).getApkPackageName())) {
                if (list.get(i).getStatus() == null) {
                    e.put(list.get(i).getApkPackageName(), wh5.k);
                } else if (list.get(i).getStatus().status == wh5.g) {
                    e.put(list.get(i).getApkPackageName(), wh5.j);
                    if (this.t.d()) {
                        e.put(wh5.i, wh5.k);
                    } else {
                        e.put(wh5.i, wh5.j);
                    }
                } else if (list.get(i).getStatus().status == wh5.h) {
                    e.put(list.get(i).getApkPackageName(), wh5.k);
                } else {
                    e.put(list.get(i).getApkPackageName(), wh5.k);
                }
            }
        }
        this.t.m(e);
    }

    public void d(boolean z) {
        u58 u58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (u58Var = this.j) == null) {
            return;
        }
        if (u58Var.i == null) {
            u58Var.i = new w58();
        }
        this.j.i.a = z;
    }

    public void e(boolean z) {
        p58 p58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (p58Var = this.e) == null) {
            return;
        }
        p58Var.d = z;
    }

    public void f(boolean z) {
        u58 u58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (u58Var = this.k) == null) {
            return;
        }
        if (u58Var.i == null) {
            u58Var.i = new w58();
        }
        this.k.i.a = z;
    }

    public void g(boolean z) {
        u58 u58Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (u58Var = this.h) == null) {
            return;
        }
        if (u58Var.i == null) {
            u58Var.i = new w58();
        }
        this.h.i.a = z;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p58 p58Var = this.e;
            if (p58Var != null) {
                this.a.add(p58Var);
            } else if (this.b == null) {
            } else {
                this.e = new p58();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                p58 p58Var2 = this.e;
                p58Var2.e = this.b;
                this.a.add(p58Var2);
            }
        }
    }

    public final void i() {
        List<ApkDownloadInfoData> list;
        lk0 value;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048586, this) == null) && UbsABTestHelper.isShowMyPageDownloadCard()) {
            c68 c68Var = this.o;
            if (c68Var != null) {
                this.a.add(c68Var);
                return;
            }
            c68 c68Var2 = new c68();
            this.o = c68Var2;
            if (c68Var2 == null || (list = c68Var2.a) == null || c68Var2.b == null) {
                return;
            }
            list.clear();
            this.o.b.clear();
            this.t = wh5.c();
            HashMap<String, lk0> a = ck0.b().a();
            if (a != null) {
                for (Map.Entry<String, lk0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == wh5.g) {
                        if (this.t.i(value.h.getAbsolutePath()) && !this.t.j(value.d)) {
                            pk0 pk0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(pk0Var.g, value.h, pk0Var.h, value.c, value.d, value.m, value);
                            if (!this.o.a.contains(apkDownloadInfoData)) {
                                this.o.a.add(apkDownloadInfoData);
                            }
                        } else {
                            this.t.l(value.d);
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
                    c68 c68Var3 = this.o;
                    c68Var3.b.addAll(c68Var3.a);
                } else {
                    c68 c68Var4 = this.o;
                    c68Var4.b.addAll(c68Var4.a.subList(0, 5));
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
                if (!this.t.d() && this.t.f()) {
                    this.t.o();
                }
                this.t.q();
                this.a.add(this.o);
            }
        }
    }

    public final void j(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, user) == null) {
            t58 t58Var = this.q;
            if (t58Var != null) {
                this.a.add(t58Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            t58 t58Var2 = new t58();
            this.q = t58Var2;
            t58Var2.h(creationData);
            this.q.j(creationData2);
            this.a.add(this.q);
        }
    }

    public final void k(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, duxiaomanEntry) == null) {
            r58 r58Var = this.f;
            if (r58Var != null) {
                this.a.add(r58Var);
                return;
            }
            r58 r58Var2 = new r58();
            this.f = r58Var2;
            r58Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final u58 l(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048589, this, i, i2, i3)) == null) {
            u58 u58Var = new u58();
            u58Var.b = i;
            u58Var.e = TbadkCoreApplication.getInst().getString(i2);
            u58Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                u58Var.h = userData;
            }
            return u58Var;
        }
        return (u58) invokeIII.objValue;
    }

    public final u58 m(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            u58 u58Var = new u58();
            u58Var.b = i;
            u58Var.e = str;
            u58Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                u58Var.h = userData;
            }
            return u58Var;
        }
        return (u58) invokeCommon.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            u58 l = l(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e84, 31);
            this.k = l;
            l.c = true;
            this.a.add(l);
            u58 l2 = l(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02da, 39);
            l2.c = true;
            this.a.add(l2);
            u58 m = m(R.drawable.obfuscated_res_0x7f080877, "订单中心", 47);
            m.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(m);
            u58 m2 = m(R.drawable.obfuscated_res_0x7f080864, "开店", 48);
            m2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(m2);
            u58 m3 = m(R.drawable.obfuscated_res_0x7f080961, "隐私设置", 61);
            w58 w58Var = new w58();
            m3.i = w58Var;
            w58Var.a = ox4.k().l("setting_private_red_dot", 1) == 1;
            this.a.add(m3);
            u58 m4 = m(R.drawable.obfuscated_res_0x7f080858, "广告推广", 49);
            m4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(m4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            u58 l3 = l(R.drawable.obfuscated_res_0x7f080876, R.string.obfuscated_res_0x7f0f0e42, 33);
            l3.j = OrmObject.bundleWithObject(this.m);
            l3.i = new w58();
            this.a.add(l3);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            x58 x58Var = new x58();
            ArrayList arrayList = new ArrayList();
            u58 l = l(R.drawable.obfuscated_res_0x7f080862, R.string.obfuscated_res_0x7f0f0acb, 12);
            l.c = true;
            arrayList.add(l);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(l(R.drawable.obfuscated_res_0x7f0807d5, R.string.obfuscated_res_0x7f0f0390, 53));
            u58 l2 = l(R.drawable.obfuscated_res_0x7f08085b, R.string.obfuscated_res_0x7f0f046d, 56);
            l2.g = TbConfig.CREATE_BA;
            arrayList.add(l2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                u58 l3 = l(R.drawable.obfuscated_res_0x7f080861, R.string.obfuscated_res_0x7f0f0226, 25);
                l3.c = true;
                l3.f = true;
                arrayList.add(l3);
            }
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080867, R.string.obfuscated_res_0x7f0f07b0, 58));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080859, R.string.obfuscated_res_0x7f0f032c, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                u58 l4 = l(R.drawable.obfuscated_res_0x7f08085a, R.string.obfuscated_res_0x7f0f0ce8, 15);
                l4.c = true;
                arrayList.add(l4);
            }
            u58 l5 = l(R.drawable.obfuscated_res_0x7f080860, R.string.obfuscated_res_0x7f0f006b, 50);
            l5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(l5);
            u58 l6 = l(R.drawable.obfuscated_res_0x7f08085d, R.string.obfuscated_res_0x7f0f0b60, 10);
            this.i = l6;
            l6.i = new w58();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            w58 w58Var = this.i.i;
            w58Var.c = formatNumForTdouDisPlay;
            w58Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            u58 l7 = l(R.drawable.obfuscated_res_0x7f080863, R.string.obfuscated_res_0x7f0f0387, 18);
            l7.c = true;
            arrayList.add(l7);
            u58 l8 = l(R.drawable.obfuscated_res_0x7f080866, R.string.obfuscated_res_0x7f0f0aab, 51);
            l8.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(l8);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080865, R.string.obfuscated_res_0x7f0f123c, 52));
            u58 l9 = l(R.drawable.obfuscated_res_0x7f08085e, R.string.obfuscated_res_0x7f0f0cdc, 54);
            l9.g = kc5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(l9);
            u58 l10 = l(R.drawable.obfuscated_res_0x7f080870, R.string.obfuscated_res_0x7f0f0421, 55);
            l10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(l10);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f08085f, R.string.obfuscated_res_0x7f0f052f, 57));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080a4f, R.string.obfuscated_res_0x7f0f05cf, 60));
            x58Var.f(arrayList);
            this.a.add(x58Var);
            this.u = x58Var;
        }
    }

    public final void p(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            y58 y58Var = new y58();
            this.p = y58Var;
            this.a.add(y58Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new a68(smartApp));
                }
            }
        }
        this.p.f(arrayList);
    }

    public final void q(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, userGrowth) == null) {
            s58 s58Var = this.g;
            if (s58Var != null) {
                this.a.add(s58Var);
                return;
            }
            this.g = new s58();
            t45 t45Var = new t45();
            t45Var.g(userGrowth);
            this.g.f(t45Var);
            this.a.add(this.g);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            b68 b68Var = this.n;
            if (b68Var != null && b68Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new b68();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                l58 l58Var = new l58();
                l58Var.b(this.c.get(i));
                if (!dj.isEmpty(l58Var.a())) {
                    this.n.a.add(l58Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public m58 s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.r : (m58) invokeV.objValue;
    }

    public ArrayList<Cdo> t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            x58 x58Var = this.u;
            if (x58Var != null && this.a.contains(x58Var)) {
                for (int i = 0; i < this.a.size(); i++) {
                    if (this.a.get(i) == this.u) {
                        return i;
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void v(VipBanner vipBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, vipBanner) == null) {
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

    public UserData w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.b : (UserData) invokeV.objValue;
    }

    public final void x(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        o48 o48Var = new o48();
        o48Var.a(tbBookrack);
        new r48(true, o48Var);
    }

    public final void y(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, ucCard) == null) {
            new h48().a(ucCard);
        }
    }

    public final void z(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048603, this, list) == null) || ListUtils.isEmpty(list)) {
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
}
