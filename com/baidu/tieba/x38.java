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
public class x38 implements l28 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<pn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public w38 e;
    public y38 f;
    public z38 g;
    public b48 h;
    public b48 i;
    public b48 j;
    public b48 k;
    public c48 l;
    public PersonMoreData m;
    public i48 n;
    public f48 o;
    public a48 p;

    public x38() {
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

    @Override // com.baidu.tieba.l28
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, personalResIdl) == null) || personalResIdl == null || personalResIdl.data == null) {
            return;
        }
        if (this.b == null) {
            this.b = new UserData();
        }
        this.b.parserProtobuf(personalResIdl.data.user);
        c48 c48Var = new c48();
        this.l = c48Var;
        c48Var.a = this.b;
        this.a.add(c48Var);
        g();
        l();
        PersonRedTipManager.getInstance().syncRedTipState(true);
        if (TbadkCoreApplication.getCurrentAccountObj() != null) {
            TbadkCoreApplication.getCurrentAccountObj().setSex(this.b.getSex());
        }
    }

    @Override // com.baidu.tieba.l28
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        DuxiaomanEntry duxiaomanEntry;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, profileResIdl) == null) || profileResIdl == null || profileResIdl.data == null) {
            return;
        }
        this.l = new c48();
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
        b48 b48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (b48Var = this.j) == null) {
            return;
        }
        if (b48Var.i == null) {
            b48Var.i = new d48();
        }
        this.j.i.a = z;
    }

    public void d(boolean z) {
        w38 w38Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048579, this, z) == null) || (w38Var = this.e) == null) {
            return;
        }
        w38Var.d = z;
    }

    public void e(boolean z) {
        b48 b48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048580, this, z) == null) || (b48Var = this.k) == null) {
            return;
        }
        if (b48Var.i == null) {
            b48Var.i = new d48();
        }
        this.k.i.a = z;
    }

    public void f(boolean z) {
        b48 b48Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048581, this, z) == null) || (b48Var = this.h) == null) {
            return;
        }
        if (b48Var.i == null) {
            b48Var.i = new d48();
        }
        this.h.i.a = z;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            w38 w38Var = this.e;
            if (w38Var != null) {
                this.a.add(w38Var);
            } else if (this.b == null) {
            } else {
                this.e = new w38();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                w38 w38Var2 = this.e;
                w38Var2.e = this.b;
                this.a.add(w38Var2);
            }
        }
    }

    public final void h(User user) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, user) == null) {
            a48 a48Var = this.p;
            if (a48Var != null) {
                this.a.add(a48Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            a48 a48Var2 = new a48();
            this.p = a48Var2;
            a48Var2.h(creationData);
            this.p.j(creationData2);
            this.a.add(this.p);
        }
    }

    public final void i(DuxiaomanEntry duxiaomanEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, duxiaomanEntry) == null) {
            y38 y38Var = this.f;
            if (y38Var != null) {
                this.a.add(y38Var);
                return;
            }
            y38 y38Var2 = new y38();
            this.f = y38Var2;
            y38Var2.f(duxiaomanEntry);
            this.a.add(this.f);
        }
    }

    public final b48 j(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            b48 b48Var = new b48();
            b48Var.b = i;
            b48Var.e = TbadkCoreApplication.getInst().getString(i2);
            b48Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                b48Var.h = userData;
            }
            return b48Var;
        }
        return (b48) invokeIII.objValue;
    }

    public final b48 k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            b48 b48Var = new b48();
            b48Var.b = i;
            b48Var.e = str;
            b48Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                b48Var.h = userData;
            }
            return b48Var;
        }
        return (b48) invokeCommon.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            b48 j = j(R.drawable.icon_mask_wo_list_serve24_svg, R.string.obfuscated_res_0x7f0f0e68, 31);
            this.k = j;
            j.c = true;
            this.a.add(j);
            b48 j2 = j(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02d6, 39);
            j2.c = true;
            this.a.add(j2);
            b48 k = k(R.drawable.obfuscated_res_0x7f080859, "订单中心", 47);
            k.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(k);
            b48 k2 = k(R.drawable.obfuscated_res_0x7f080847, "开店", 48);
            k2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(k2);
            b48 k3 = k(R.drawable.obfuscated_res_0x7f08083b, "广告推广", 49);
            k3.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(k3);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            b48 j3 = j(R.drawable.obfuscated_res_0x7f080858, R.string.obfuscated_res_0x7f0f0e28, 33);
            j3.j = OrmObject.bundleWithObject(this.m);
            j3.i = new d48();
            this.a.add(j3);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            e48 e48Var = new e48();
            ArrayList arrayList = new ArrayList();
            b48 j = j(R.drawable.obfuscated_res_0x7f080845, R.string.obfuscated_res_0x7f0f0ab5, 12);
            j.c = true;
            arrayList.add(j);
            HashMap hashMap = new HashMap();
            hashMap.put("uid", this.b.getUserId());
            hashMap.put("entryType", "1");
            arrayList.add(j(R.drawable.obfuscated_res_0x7f0807bb, R.string.obfuscated_res_0x7f0f038c, 53));
            b48 j2 = j(R.drawable.obfuscated_res_0x7f08083e, R.string.obfuscated_res_0x7f0f0469, 56);
            j2.g = TbConfig.CREATE_BA;
            arrayList.add(j2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                b48 j3 = j(R.drawable.obfuscated_res_0x7f080844, R.string.obfuscated_res_0x7f0f0224, 25);
                j3.c = true;
                j3.f = true;
                arrayList.add(j3);
            }
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08084a, R.string.obfuscated_res_0x7f0f079d, 58));
            arrayList.add(j(R.drawable.obfuscated_res_0x7f08083c, R.string.obfuscated_res_0x7f0f0328, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                b48 j4 = j(R.drawable.obfuscated_res_0x7f08083d, R.string.obfuscated_res_0x7f0f0cce, 15);
                j4.c = true;
                arrayList.add(j4);
            }
            b48 j5 = j(R.drawable.obfuscated_res_0x7f080843, R.string.obfuscated_res_0x7f0f006b, 50);
            j5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(j5);
            b48 j6 = j(R.drawable.obfuscated_res_0x7f080840, R.string.obfuscated_res_0x7f0f0b4a, 10);
            this.i = j6;
            j6.i = new d48();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            d48 d48Var = this.i.i;
            d48Var.c = formatNumForTdouDisPlay;
            d48Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            b48 j7 = j(R.drawable.obfuscated_res_0x7f080846, R.string.obfuscated_res_0x7f0f0383, 18);
            j7.c = true;
            arrayList.add(j7);
            b48 j8 = j(R.drawable.obfuscated_res_0x7f080849, R.string.obfuscated_res_0x7f0f0a95, 51);
            j8.g = "https://tieba.baidu.com/mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(j8);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080848, R.string.obfuscated_res_0x7f0f121d, 52));
            b48 j9 = j(R.drawable.obfuscated_res_0x7f080841, R.string.obfuscated_res_0x7f0f0cc2, 54);
            j9.g = p95.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(j9);
            b48 j10 = j(R.drawable.obfuscated_res_0x7f080853, R.string.obfuscated_res_0x7f0f041d, 55);
            j10.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(j10);
            arrayList.add(j(R.drawable.obfuscated_res_0x7f080842, R.string.obfuscated_res_0x7f0f0523, 57));
            e48Var.f(arrayList);
            this.a.add(e48Var);
        }
    }

    public final void n(List<SmartApp> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.o == null) {
            f48 f48Var = new f48();
            this.o = f48Var;
            this.a.add(f48Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new h48(smartApp));
                }
            }
        }
        this.o.f(arrayList);
    }

    public final void o(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, userGrowth) == null) {
            z38 z38Var = this.g;
            if (z38Var != null) {
                this.a.add(z38Var);
                return;
            }
            this.g = new z38();
            x15 x15Var = new x15();
            x15Var.g(userGrowth);
            this.g.f(x15Var);
            this.a.add(this.g);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            i48 i48Var = this.n;
            if (i48Var != null) {
                this.a.add(i48Var);
                return;
            }
            this.n = new i48();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                t38 t38Var = new t38();
                t38Var.d(this.c.get(i));
                if (!qi.isEmpty(t38Var.c())) {
                    this.n.a.add(t38Var);
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
        y28 y28Var = new y28();
        y28Var.a(tbBookrack);
        new b38(true, y28Var);
    }

    public final void t(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, ucCard) == null) {
            new r28().a(ucCard);
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
