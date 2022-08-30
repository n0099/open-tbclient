package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.data.UserPendantData;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.redtip.PersonRedTipManager;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.BannerImage;
import tbclient.CreationData;
import tbclient.DuxiaomanEntry;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.DataRes;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserGrowth;
import tbclient.UserMap;
/* loaded from: classes6.dex */
public class z38 implements n28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public y38 e;
    public a48 f;
    public b48 g;
    public d48 h;
    public d48 i;
    public d48 j;
    public d48 k;
    public e48 l;
    public PersonMoreData m;
    public k48 n;
    public h48 o;
    public c48 p;

    public z38() {
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
        this.a = new ArrayList<>();
    }

    @Override // com.baidu.tieba.n28
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        e48 e48Var = new e48();
        this.l = e48Var;
        e48Var.a = this.b;
        this.a.add(e48Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.baidu.tieba.n28
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new e48();
        DataRes dataRes = profileResIdl.data;
        this.c = dataRes.banner;
        Duxiaoman duxiaoman = dataRes.duxiaoman;
        v(dataRes.user, dataRes.user_god_info);
        s(profileResIdl.data.tbbookrack);
        t(profileResIdl.data.uc_card);
        u(profileResIdl.data.url_map);
        this.a.add(this.l);
        g();
        p();
        DataRes dataRes2 = profileResIdl.data;
        if (dataRes2.finance_tab != null && (duxiaomanEntry = dataRes2.duxiaoman_entry) != null) {
            i(duxiaomanEntry);
        }
        User user = profileResIdl.data.user;
        if (user != null && (userGrowth = user.user_growth) != null) {
            o(userGrowth);
        }
        h(profileResIdl.data.user);
        m();
        n(profileResIdl.data.recom_swan_list);
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
    }

    public void c(boolean z) {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (d48Var = this.j) == null) {
            return;
        }
        if (d48Var.i == null) {
            d48Var.i = new f48();
        }
        this.j.i.a = z;
    }

    public void d(boolean z) {
        y38 y38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (y38Var = this.e) == null) {
            return;
        }
        y38Var.d = z;
    }

    public void e(boolean z) {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (d48Var = this.k) == null) {
            return;
        }
        if (d48Var.i == null) {
            d48Var.i = new f48();
        }
        this.k.i.a = z;
    }

    public void f(boolean z) {
        d48 d48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (d48Var = this.h) == null) {
            return;
        }
        if (d48Var.i == null) {
            d48Var.i = new f48();
        }
        this.h.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            y38 y38Var = this.e;
            if (y38Var != null) {
                this.a.add(y38Var);
            } else if (this.b == null) {
            } else {
                this.e = new y38();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                y38 y38Var2 = this.e;
                y38Var2.e = this.b;
                this.a.add(y38Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            c48 c48Var = this.p;
            if (c48Var != null) {
                this.a.add(c48Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            c48 c48Var2 = new c48();
            this.p = c48Var2;
            c48Var2.h(creationData);
            this.p.j(creationData2);
            this.a.add(this.p);
        }
    }

    public final void i(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, duxiaomanEntry) == null) {
            a48 a48Var = this.f;
            if (a48Var != null) {
                this.a.add(a48Var);
                return;
            }
            a48 a48Var2 = new a48();
            this.f = a48Var2;
            a48Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final d48 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            d48 d48Var = new d48();
            d48Var.b = i;
            d48Var.e = TbadkCoreApplication.getInst().getString(i2);
            d48Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                d48Var.h = userData;
            }
            return d48Var;
        }
        return (d48) invokeIII.objValue;
    }

    public final d48 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            d48 d48Var = new d48();
            d48Var.b = i;
            d48Var.e = str;
            d48Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                d48Var.h = userData;
            }
            return d48Var;
        }
        return (d48) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            d48 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e68, 31);
            this.k = j;
            j.c = true;
            this.a.add(j);
            d48 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02d6, 39);
            j2.c = true;
            this.a.add(j2);
            d48 k = k(R.drawable.obfuscated_res_0x7f080859, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            d48 k2 = k(R.drawable.obfuscated_res_0x7f080847, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            d48 k3 = k(R.drawable.obfuscated_res_0x7f08083b, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            d48 j3 = j(R.drawable.obfuscated_res_0x7f080858, R.string.obfuscated_res_0x7f0f0e28, 33);
            j3.j = OrmObject.bundleWithObject(this.m);
            j3.i = new f48();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            g48 g48Var = new g48();
            ArrayList arrayList = new ArrayList();
            d48 j = j(R.drawable.obfuscated_res_0x7f080845, R.string.obfuscated_res_0x7f0f0ab5, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807bb, R.string.obfuscated_res_0x7f0f038c, 53));
            d48 j2 = j(R.drawable.obfuscated_res_0x7f08083e, R.string.obfuscated_res_0x7f0f0469, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                d48 j3 = j(R.drawable.obfuscated_res_0x7f080844, R.string.obfuscated_res_0x7f0f0224, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08084a, R.string.obfuscated_res_0x7f0f079d, 58));
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08083c, R.string.obfuscated_res_0x7f0f0328, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                d48 j4 = j(R.drawable.obfuscated_res_0x7f08083d, R.string.obfuscated_res_0x7f0f0cce, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            d48 j5 = j(R.drawable.obfuscated_res_0x7f080843, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            d48 j6 = j(R.drawable.obfuscated_res_0x7f080840, R.string.obfuscated_res_0x7f0f0b4a, 10);
            this.i = j6;
            j6.i = new f48();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            f48 f48Var = this.i.i;
            f48Var.c = formatNumForTdouDisPlay;
            f48Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            d48 j7 = j(R.drawable.obfuscated_res_0x7f080846, R.string.obfuscated_res_0x7f0f0383, 18);
            j7.c = true;
            arrayList.add(j7);
            d48 j8 = j(R.drawable.obfuscated_res_0x7f080849, R.string.obfuscated_res_0x7f0f0a95, 51);
            j8.g = "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080848, R.string.obfuscated_res_0x7f0f121d, 52));
            d48 j9 = j(R.drawable.obfuscated_res_0x7f080841, R.string.obfuscated_res_0x7f0f0cc2, 54);
            j9.g = r95.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            d48 j10 = j(R.drawable.obfuscated_res_0x7f080853, R.string.obfuscated_res_0x7f0f041d, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080842, R.string.obfuscated_res_0x7f0f0523, 57));
            g48Var.f(arrayList);
            this.a.add(g48Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            h48 h48Var = new h48();
            this.o = h48Var;
            this.a.add(h48Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new j48(smartApp));
                }
            }
        }
        this.o.f(arrayList);
    }

    public final void o(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, userGrowth) == null) {
            b48 b48Var = this.g;
            if (b48Var != null) {
                this.a.add(b48Var);
                return;
            }
            this.g = new b48();
            z15 z15Var = new z15();
            z15Var.g(userGrowth);
            this.g.f(z15Var);
            this.a.add(this.g);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            k48 k48Var = this.n;
            if (k48Var != null) {
                this.a.add(k48Var);
                return;
            }
            this.n = new k48();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                v38 v38Var = new v38();
                v38Var.d(this.c.get(i));
                if (!qi.isEmpty(v38Var.c())) {
                    this.n.a.add(v38Var);
                }
            }
            if (this.n.a.size() > 0) {
                this.a.add(this.n);
            }
        }
    }

    public ArrayList<pn> q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.a : (ArrayList) invokeV.objValue;
    }

    public UserData r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.b : (UserData) invokeV.objValue;
    }

    public final void s(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, tbBookrack) == null) || tbBookrack == null) {
            return;
        }
        a38 a38Var = new a38();
        a38Var.a(tbBookrack);
        new d38(true, a38Var);
    }

    public final void t(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ucCard) == null) {
            new t28().a(ucCard);
        }
    }

    public final void u(List<UserMap> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048596, this, list) == null) || ListUtils.isEmpty(list)) {
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

    public final void v(User user, UserGodInfo userGodInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, user, userGodInfo) == null) {
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

    public void w(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }
}
