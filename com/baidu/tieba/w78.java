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
public class w78 implements i68 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public v78 e;
    public x78 f;
    public y78 g;
    public a88 h;
    public a88 i;
    public a88 j;
    public a88 k;
    public b88 l;
    public PersonMoreData m;
    public h88 n;
    public i88 o;
    public e88 p;
    public z78 q;
    public s78 r;
    public PersonVipCardData s;
    public d88 t;
    public gj5 u;

    public w78() {
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

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            v78 v78Var = this.e;
            if (v78Var != null) {
                this.a.add(v78Var);
            } else if (this.b == null) {
            } else {
                this.e = new v78();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                v78 v78Var2 = this.e;
                v78Var2.e = this.b;
                this.a.add(v78Var2);
            }
        }
    }

    public final void A(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tbBookrack) == null) && tbBookrack != null) {
            u68 u68Var = new u68();
            u68Var.a(tbBookrack);
            new x68(true, u68Var);
        }
    }

    public final void B(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ucCard) == null) {
            new n68().a(ucCard);
        }
    }

    public void E(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        a88 a88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (a88Var = this.j) != null) {
            if (a88Var.i == null) {
                a88Var.i = new c88();
            }
            this.j.i.a = z;
        }
    }

    public void e(boolean z) {
        v78 v78Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (v78Var = this.e) != null) {
            v78Var.d = z;
        }
    }

    public void f(boolean z) {
        a88 a88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (a88Var = this.k) != null) {
            if (a88Var.i == null) {
                a88Var.i = new c88();
            }
            this.k.i.a = z;
        }
    }

    public void g(boolean z) {
        a88 a88Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (a88Var = this.h) != null) {
            if (a88Var.i == null) {
                a88Var.i = new c88();
            }
            this.h.i.a = z;
        }
    }

    public final void k(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, namoaixudEntry) == null) {
            x78 x78Var = this.f;
            if (x78Var != null) {
                this.a.add(x78Var);
                return;
            }
            x78 x78Var2 = new x78();
            this.f = x78Var2;
            x78Var2.f(namoaixudEntry);
            this.a.add(this.f);
        }
    }

    public final void C(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) != null) || ListUtils.isEmpty(list)) {
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

    public final void D(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, user, userGodInfo) == null) {
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

    @Override // com.baidu.tieba.i68
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            b88 b88Var = new b88();
            this.l = b88Var;
            b88Var.a = this.b;
            this.a.add(b88Var);
            h();
            n();
            PersonRedTipManager.getInstance().syncRedTipState(true);
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
            }
        }
    }

    public final void p(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048596, this, list) != null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.p == null) {
            e88 e88Var = new e88();
            this.p = e88Var;
            this.a.add(e88Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new g88(smartApp));
                }
            }
        }
        this.p.f(arrayList);
    }

    @Override // com.baidu.tieba.i68
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new b88();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            D(dataRes.user, dataRes.user_god_info);
            A(profileResIdl.data.tbbookrack);
            B(profileResIdl.data.uc_card);
            C(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                s78 s78Var = new s78();
                this.r = s78Var;
                s78Var.d(profileResIdl.data.bubble_info);
            }
            this.a.clear();
            this.a.add(this.l);
            h();
            x(profileResIdl.data.vip_banner);
            r();
            DataRes dataRes2 = profileResIdl.data;
            if (dataRes2.finance_tab != null && (namoaixudEntry = dataRes2.namoaixud_entry) != null) {
                k(namoaixudEntry);
            }
            User user = profileResIdl.data.user;
            if (user != null && (userGrowth = user.user_growth) != null) {
                q(userGrowth);
            }
            j(profileResIdl.data.user);
            o();
            i();
            p(profileResIdl.data.recom_naws_list);
            n();
            PersonRedTipManager.getInstance().syncRedTipState(true);
        }
    }

    public final void c(List<ApkDownloadInfoData> list) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, list) == null) && TbadkCoreApplication.getCurrentAccount() != null && list != null && list.size() > 0) {
            HashMap<String, String> e = this.u.e();
            if (e == null) {
                e = new HashMap<>();
            }
            for (int i = 0; i < list.size(); i++) {
                if (!e.containsKey(list.get(i).getApkPackageName())) {
                    if (list.get(i).getStatus() == null) {
                        e.put(list.get(i).getApkPackageName(), gj5.k);
                    } else if (list.get(i).getStatus().status == gj5.g) {
                        e.put(list.get(i).getApkPackageName(), gj5.j);
                        if (this.u.d()) {
                            e.put(gj5.i, gj5.k);
                        } else {
                            e.put(gj5.i, gj5.j);
                        }
                    } else if (list.get(i).getStatus().status == gj5.h) {
                        e.put(list.get(i).getApkPackageName(), gj5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), gj5.k);
                    }
                }
            }
            this.u.m(e);
        }
    }

    public final void i() {
        List<ApkDownloadInfoData> list;
        mk0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        i88 i88Var = this.o;
        if (i88Var != null) {
            this.a.add(i88Var);
            return;
        }
        i88 i88Var2 = new i88();
        this.o = i88Var2;
        if (i88Var2 != null && (list = i88Var2.a) != null && i88Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.u = gj5.c();
            HashMap<String, mk0> a = dk0.b().a();
            if (a != null) {
                for (Map.Entry<String, mk0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == gj5.g) {
                        if (this.u.i(value.h.getAbsolutePath()) && !this.u.j(value.d)) {
                            qk0 qk0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(qk0Var.g, value.h, qk0Var.h, value.c, value.d, value.m, value);
                            if (!this.o.a.contains(apkDownloadInfoData)) {
                                this.o.a.add(apkDownloadInfoData);
                            }
                        } else {
                            this.u.l(value.d);
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
                    i88 i88Var3 = this.o;
                    i88Var3.b.addAll(i88Var3.a);
                } else {
                    i88 i88Var4 = this.o;
                    i88Var4.b.addAll(i88Var4.a.subList(0, 5));
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
                if (!this.u.d() && this.u.f()) {
                    this.u.o();
                }
                this.u.q();
                this.a.add(this.o);
            }
        }
    }

    public final void j(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, user) == null) {
            z78 z78Var = this.q;
            if (z78Var != null) {
                this.a.add(z78Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            z78 z78Var2 = new z78();
            this.q = z78Var2;
            z78Var2.h(creationData);
            this.q.j(creationData2);
            this.a.add(this.q);
        }
    }

    public final void q(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, userGrowth) == null) {
            y78 y78Var = this.g;
            if (y78Var != null) {
                this.a.add(y78Var);
                return;
            }
            this.g = new y78();
            x55 x55Var = new x55();
            x55Var.g(userGrowth);
            this.g.f(x55Var);
            this.a.add(this.g);
        }
    }

    public final void x(VipBanner vipBanner) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, vipBanner) == null) {
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

    public final a88 l(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048592, this, i, i2, i3)) == null) {
            a88 a88Var = new a88();
            a88Var.b = i;
            a88Var.e = TbadkCoreApplication.getInst().getString(i2);
            a88Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                a88Var.h = userData;
            }
            return a88Var;
        }
        return (a88) invokeIII.objValue;
    }

    public final a88 m(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            a88 a88Var = new a88();
            a88Var.b = i;
            a88Var.e = str;
            a88Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                a88Var.h = userData;
            }
            return a88Var;
        }
        return (a88) invokeCommon.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            a88 l = l(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0eb2, 31);
            this.k = l;
            boolean z = true;
            l.c = true;
            this.a.add(l);
            a88 l2 = l(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02db, 39);
            l2.c = true;
            this.a.add(l2);
            a88 m = m(R.drawable.obfuscated_res_0x7f080882, "订单中心", 47);
            m.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(m);
            a88 m2 = m(R.drawable.obfuscated_res_0x7f08086f, "开店", 48);
            m2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(m2);
            a88 m3 = m(R.drawable.obfuscated_res_0x7f08097e, "隐私设置", 61);
            c88 c88Var = new c88();
            m3.i = c88Var;
            if (qy4.k().l("setting_private_red_dot", 1) != 1) {
                z = false;
            }
            c88Var.a = z;
            this.a.add(m3);
            a88 m4 = m(R.drawable.obfuscated_res_0x7f080862, "广告推广", 49);
            m4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(m4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            a88 l3 = l(R.drawable.obfuscated_res_0x7f080881, R.string.obfuscated_res_0x7f0f0e70, 33);
            l3.j = OrmObject.bundleWithObject(this.m);
            l3.i = new c88();
            this.a.add(l3);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            d88 d88Var = new d88();
            ArrayList arrayList = new ArrayList();
            a88 l = l(R.drawable.obfuscated_res_0x7f08086d, R.string.obfuscated_res_0x7f0f0ae7, 12);
            l.c = true;
            arrayList.add(l);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080866, R.string.obfuscated_res_0x7f0f0536, 62));
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(l(R.drawable.obfuscated_res_0x7f0807e1, R.string.obfuscated_res_0x7f0f0392, 53));
            a88 l2 = l(R.drawable.obfuscated_res_0x7f080865, R.string.obfuscated_res_0x7f0f0477, 56);
            l2.g = TbConfig.CREATE_BA;
            arrayList.add(l2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                a88 l3 = l(R.drawable.obfuscated_res_0x7f08086c, R.string.obfuscated_res_0x7f0f0226, 25);
                l3.c = true;
                l3.f = true;
                arrayList.add(l3);
            }
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080873, R.string.obfuscated_res_0x7f0f07c0, 58));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080863, R.string.obfuscated_res_0x7f0f032d, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                a88 l4 = l(R.drawable.obfuscated_res_0x7f080864, R.string.obfuscated_res_0x7f0f0d12, 15);
                l4.c = true;
                arrayList.add(l4);
            }
            a88 l5 = l(R.drawable.obfuscated_res_0x7f08086b, R.string.obfuscated_res_0x7f0f006b, 50);
            l5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(l5);
            a88 l6 = l(R.drawable.obfuscated_res_0x7f080868, R.string.obfuscated_res_0x7f0f0b7d, 10);
            this.i = l6;
            l6.i = new c88();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            c88 c88Var = this.i.i;
            c88Var.c = formatNumForTdouDisPlay;
            c88Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f0807fe, R.string.obfuscated_res_0x7f0f1604, 63));
            a88 l7 = l(R.drawable.obfuscated_res_0x7f080872, R.string.obfuscated_res_0x7f0f0ac7, 51);
            l7.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(l7);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080870, R.string.obfuscated_res_0x7f0f1274, 52));
            a88 l8 = l(R.drawable.obfuscated_res_0x7f080869, R.string.obfuscated_res_0x7f0f0d06, 54);
            l8.g = td5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(l8);
            a88 l9 = l(R.drawable.obfuscated_res_0x7f08087c, R.string.obfuscated_res_0x7f0f042b, 55);
            l9.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(l9);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f08086a, R.string.obfuscated_res_0x7f0f053b, 57));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080a6f, R.string.obfuscated_res_0x7f0f05db, 60));
            d88Var.f(arrayList);
            this.a.add(d88Var);
            this.t = d88Var;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            h88 h88Var = this.n;
            if (h88Var != null && h88Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new h88();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                r78 r78Var = new r78();
                r78Var.b(this.c.get(i));
                if (!xi.isEmpty(r78Var.a())) {
                    this.n.a.add(r78Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            v78 v78Var = this.e;
            if (v78Var != null && this.a.contains(v78Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public s78 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.r;
        }
        return (s78) invokeV.objValue;
    }

    public ArrayList<xn> v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return this.a;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            d88 d88Var = this.t;
            if (d88Var != null && this.a.contains(d88Var)) {
                return this.a.indexOf(this.t);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public UserData y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return this.b;
        }
        return (UserData) invokeV.objValue;
    }

    public b88 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.l;
        }
        return (b88) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            z78 z78Var = this.q;
            if (z78Var != null && this.a.contains(z78Var)) {
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
