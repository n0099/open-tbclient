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
/* loaded from: classes5.dex */
public class oa8 implements a98 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<xn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public na8 e;
    public pa8 f;
    public qa8 g;
    public sa8 h;
    public sa8 i;
    public sa8 j;
    public sa8 k;
    public ta8 l;
    public PersonMoreData m;
    public za8 n;
    public ab8 o;
    public wa8 p;
    public ra8 q;
    public ka8 r;
    public PersonVipCardData s;
    public va8 t;
    public ak5 u;

    public oa8() {
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
            na8 na8Var = this.e;
            if (na8Var != null) {
                this.a.add(na8Var);
            } else if (this.b == null) {
            } else {
                this.e = new na8();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                na8 na8Var2 = this.e;
                na8Var2.e = this.b;
                this.a.add(na8Var2);
            }
        }
    }

    public final void A(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, tbBookrack) == null) && tbBookrack != null) {
            m98 m98Var = new m98();
            m98Var.a(tbBookrack);
            new p98(true, m98Var);
        }
    }

    public final void B(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ucCard) == null) {
            new f98().a(ucCard);
        }
    }

    public void E(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (sa8Var = this.j) != null) {
            if (sa8Var.i == null) {
                sa8Var.i = new ua8();
            }
            this.j.i.a = z;
        }
    }

    public void e(boolean z) {
        na8 na8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048585, this, z) == null) && (na8Var = this.e) != null) {
            na8Var.d = z;
        }
    }

    public void f(boolean z) {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (sa8Var = this.k) != null) {
            if (sa8Var.i == null) {
                sa8Var.i = new ua8();
            }
            this.k.i.a = z;
        }
    }

    public void g(boolean z) {
        sa8 sa8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (sa8Var = this.h) != null) {
            if (sa8Var.i == null) {
                sa8Var.i = new ua8();
            }
            this.h.i.a = z;
        }
    }

    public final void k(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, namoaixudEntry) == null) {
            pa8 pa8Var = this.f;
            if (pa8Var != null) {
                this.a.add(pa8Var);
                return;
            }
            pa8 pa8Var2 = new pa8();
            this.f = pa8Var2;
            pa8Var2.f(namoaixudEntry);
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

    @Override // com.baidu.tieba.a98
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            ta8 ta8Var = new ta8();
            this.l = ta8Var;
            ta8Var.a = this.b;
            this.a.add(ta8Var);
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
            wa8 wa8Var = new wa8();
            this.p = wa8Var;
            this.a.add(wa8Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new ya8(smartApp));
                }
            }
        }
        this.p.f(arrayList);
    }

    @Override // com.baidu.tieba.a98
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new ta8();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            D(dataRes.user, dataRes.user_god_info);
            A(profileResIdl.data.tbbookrack);
            B(profileResIdl.data.uc_card);
            C(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                ka8 ka8Var = new ka8();
                this.r = ka8Var;
                ka8Var.d(profileResIdl.data.bubble_info);
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
                        e.put(list.get(i).getApkPackageName(), ak5.k);
                    } else if (list.get(i).getStatus().status == ak5.g) {
                        e.put(list.get(i).getApkPackageName(), ak5.j);
                        if (this.u.d()) {
                            e.put(ak5.i, ak5.k);
                        } else {
                            e.put(ak5.i, ak5.j);
                        }
                    } else if (list.get(i).getStatus().status == ak5.h) {
                        e.put(list.get(i).getApkPackageName(), ak5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), ak5.k);
                    }
                }
            }
            this.u.m(e);
        }
    }

    public final void i() {
        List<ApkDownloadInfoData> list;
        lk0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        ab8 ab8Var = this.o;
        if (ab8Var != null) {
            this.a.add(ab8Var);
            return;
        }
        ab8 ab8Var2 = new ab8();
        this.o = ab8Var2;
        if (ab8Var2 != null && (list = ab8Var2.a) != null && ab8Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.u = ak5.c();
            HashMap<String, lk0> a = ck0.b().a();
            if (a != null) {
                for (Map.Entry<String, lk0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == ak5.g) {
                        if (this.u.i(value.h.getAbsolutePath()) && !this.u.j(value.d)) {
                            pk0 pk0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(pk0Var.g, value.h, pk0Var.h, value.c, value.d, value.m, value);
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
                    ab8 ab8Var3 = this.o;
                    ab8Var3.b.addAll(ab8Var3.a);
                } else {
                    ab8 ab8Var4 = this.o;
                    ab8Var4.b.addAll(ab8Var4.a.subList(0, 5));
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
            ra8 ra8Var = this.q;
            if (ra8Var != null) {
                this.a.add(ra8Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            ra8 ra8Var2 = new ra8();
            this.q = ra8Var2;
            ra8Var2.g(creationData);
            this.q.i(creationData2);
            this.a.add(this.q);
        }
    }

    public final void q(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, userGrowth) == null) {
            qa8 qa8Var = this.g;
            if (qa8Var != null) {
                this.a.add(qa8Var);
                return;
            }
            this.g = new qa8();
            y55 y55Var = new y55();
            y55Var.g(userGrowth);
            this.g.f(y55Var);
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

    public final sa8 l(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048592, this, i, i2, i3)) == null) {
            sa8 sa8Var = new sa8();
            sa8Var.b = i;
            sa8Var.e = TbadkCoreApplication.getInst().getString(i2);
            sa8Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                sa8Var.h = userData;
            }
            return sa8Var;
        }
        return (sa8) invokeIII.objValue;
    }

    public final sa8 m(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            sa8 sa8Var = new sa8();
            sa8Var.b = i;
            sa8Var.e = str;
            sa8Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                sa8Var.h = userData;
            }
            return sa8Var;
        }
        return (sa8) invokeCommon.objValue;
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            sa8 l = l(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = l;
            boolean z = true;
            l.c = true;
            this.a.add(l);
            sa8 l2 = l(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02e0, 39);
            l2.c = true;
            this.a.add(l2);
            sa8 m = m(R.drawable.obfuscated_res_0x7f0808a4, "订单中心", 47);
            m.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(m);
            sa8 m2 = m(R.drawable.obfuscated_res_0x7f080892, "开店", 48);
            m2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(m2);
            sa8 m3 = m(R.drawable.obfuscated_res_0x7f0809a4, "隐私设置", 61);
            ua8 ua8Var = new ua8();
            m3.i = ua8Var;
            if (ry4.l().m("setting_private_red_dot", 1) != 1) {
                z = false;
            }
            ua8Var.a = z;
            this.a.add(m3);
            sa8 m4 = m(R.drawable.obfuscated_res_0x7f080885, "广告推广", 49);
            m4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(m4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            sa8 l3 = l(R.drawable.obfuscated_res_0x7f0808a3, R.string.obfuscated_res_0x7f0f0ea7, 33);
            l3.j = OrmObject.bundleWithObject(this.m);
            l3.i = new ua8();
            this.a.add(l3);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            va8 va8Var = new va8();
            ArrayList arrayList = new ArrayList();
            sa8 l = l(R.drawable.obfuscated_res_0x7f080890, R.string.member_center, 12);
            l.c = true;
            arrayList.add(l);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080889, R.string.dressup_center_title, 62));
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080802, R.string.certification_center, 53));
            sa8 l2 = l(R.drawable.obfuscated_res_0x7f080888, R.string.create_ba, 56);
            l2.g = TbConfig.CREATE_BA;
            arrayList.add(l2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                sa8 l3 = l(R.drawable.obfuscated_res_0x7f08088f, R.string.ala_live, 25);
                l3.c = true;
                l3.f = true;
                arrayList.add(l3);
            }
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080895, R.string.game_hall, 58));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080886, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                sa8 l4 = l(R.drawable.obfuscated_res_0x7f080887, R.string.official_account, 15);
                l4.c = true;
                arrayList.add(l4);
            }
            sa8 l5 = l(R.drawable.obfuscated_res_0x7f08088e, R.string.account_check, 50);
            l5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(l5);
            sa8 l6 = l(R.drawable.obfuscated_res_0x7f08088b, R.string.obfuscated_res_0x7f0f0bb4, 10);
            this.i = l6;
            l6.i = new ua8();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            ua8 ua8Var = this.i.i;
            ua8Var.c = formatNumForTdouDisPlay;
            ua8Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f08081f, R.string.welfare_entrance, 63));
            sa8 l7 = l(R.drawable.obfuscated_res_0x7f080894, R.string.mark_center, 51);
            l7.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(l7);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080893, R.string.subscribe_manager, 52));
            sa8 l8 = l(R.drawable.obfuscated_res_0x7f08088c, R.string.novel_member_monthly, 54);
            l8.g = le5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(l8);
            sa8 l9 = l(R.drawable.obfuscated_res_0x7f08089e, R.string.community_convention, 55);
            l9.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(l9);
            arrayList.add(l(R.drawable.obfuscated_res_0x7f08088d, R.string.earn_money, 57));
            arrayList.add(l(R.drawable.obfuscated_res_0x7f080a95, R.string.exchange_mall, 60));
            va8Var.f(arrayList);
            this.a.add(va8Var);
            this.t = va8Var;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            za8 za8Var = this.n;
            if (za8Var != null && za8Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new za8();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                ja8 ja8Var = new ja8();
                ja8Var.b(this.c.get(i));
                if (!xi.isEmpty(ja8Var.a())) {
                    this.n.a.add(ja8Var);
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
            na8 na8Var = this.e;
            if (na8Var != null && this.a.contains(na8Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public ka8 t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.r;
        }
        return (ka8) invokeV.objValue;
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
            va8 va8Var = this.t;
            if (va8Var != null && this.a.contains(va8Var)) {
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

    public ta8 z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return this.l;
        }
        return (ta8) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            ra8 ra8Var = this.q;
            if (ra8Var != null && this.a.contains(ra8Var)) {
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
