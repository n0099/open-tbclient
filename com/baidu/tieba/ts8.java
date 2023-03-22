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
public class ts8 implements er8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<gn> a;
    public UserData b;
    public List<BannerImage> c;
    public PersonUserGodInfo d;
    public ss8 e;
    public us8 f;
    public vs8 g;
    public xs8 h;
    public xs8 i;
    public xs8 j;
    public xs8 k;
    public ys8 l;
    public PersonMoreData m;
    public et8 n;
    public ft8 o;
    public bt8 p;
    public ws8 q;
    public ps8 r;
    public PersonVipCardData s;
    public HashMap<String, PersonRedTipData> t;
    public at8 u;
    public op5 v;

    public ts8() {
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
            ss8 ss8Var = this.e;
            if (ss8Var != null) {
                this.a.add(ss8Var);
            } else if (this.b == null) {
            } else {
                this.e = new ss8();
                this.b.getFansNum();
                this.e.a = this.b.getConcern_num();
                this.e.b = this.b.getLike_bars();
                this.e.c = this.b.getThreadNum();
                ss8 ss8Var2 = this.e;
                ss8Var2.e = this.b;
                this.a.add(ss8Var2);
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

    public ys8 B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.l;
        }
        return (ys8) invokeV.objValue;
    }

    public int u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            ss8 ss8Var = this.e;
            if (ss8Var != null && this.a.contains(ss8Var)) {
                return this.a.indexOf(this.e);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public ps8 v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return this.r;
        }
        return (ps8) invokeV.objValue;
    }

    public ArrayList<gn> x() {
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
            at8 at8Var = this.u;
            if (at8Var != null && this.a.contains(at8Var)) {
                return this.a.indexOf(this.u);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public final void C(TbBookrack tbBookrack) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbBookrack) == null) && tbBookrack != null) {
            qr8 qr8Var = new qr8();
            qr8Var.a(tbBookrack);
            new tr8(true, qr8Var);
        }
    }

    public final void D(UcCard ucCard) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, ucCard) == null) {
            new jr8().a(ucCard);
        }
    }

    public void G(UserPendantData userPendantData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, userPendantData) == null) {
            this.b.setPendantData(userPendantData);
        }
    }

    public void d(boolean z) {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048586, this, z) == null) && (xs8Var = this.j) != null) {
            if (xs8Var.i == null) {
                xs8Var.i = new zs8();
            }
            this.j.i.b(z);
        }
    }

    public void e(boolean z) {
        ss8 ss8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048587, this, z) == null) && (ss8Var = this.e) != null) {
            ss8Var.d = z;
        }
    }

    public void f(boolean z) {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (xs8Var = this.k) != null) {
            if (xs8Var.i == null) {
                xs8Var.i = new zs8();
            }
            this.k.i.b(z);
        }
    }

    public void g(boolean z) {
        xs8 xs8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (xs8Var = this.h) != null) {
            if (xs8Var.i == null) {
                xs8Var.i = new zs8();
            }
            this.h.i.b(z);
        }
    }

    public final void l(NamoaixudEntry namoaixudEntry) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, namoaixudEntry) == null) {
            us8 us8Var = this.f;
            if (us8Var != null) {
                this.a.add(us8Var);
                return;
            }
            us8 us8Var2 = new us8();
            this.f = us8Var2;
            us8Var2.f(namoaixudEntry);
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

    public List<xs8> q(List<CustomGrid> list) {
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
                    os8 os8Var = new os8();
                    os8Var.a(customGrid);
                    xs8 b = os8Var.b();
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
                        b.i = new zs8();
                    }
                    b.i.b(i(os8Var));
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

    @Override // com.baidu.tieba.er8
    public void a(PersonalResIdl personalResIdl) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, personalResIdl) == null) && personalResIdl != null && personalResIdl.data != null) {
            if (this.b == null) {
                this.b = new UserData();
            }
            this.b.parserProtobuf(personalResIdl.data.user);
            ys8 ys8Var = new ys8();
            this.l = ys8Var;
            ys8Var.a = this.b;
            this.a.add(ys8Var);
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
            bt8 bt8Var = new bt8();
            this.p = bt8Var;
            this.a.add(bt8Var);
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (SmartApp smartApp : list) {
                if (smartApp != null) {
                    arrayList.add(new dt8(smartApp));
                }
            }
        }
        this.p.f(arrayList);
    }

    @Override // com.baidu.tieba.er8
    public void b(ProfileResIdl profileResIdl) {
        UserGrowth userGrowth;
        NamoaixudEntry namoaixudEntry;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, profileResIdl) == null) && profileResIdl != null && profileResIdl.data != null) {
            this.l = new ys8();
            DataRes dataRes = profileResIdl.data;
            this.c = dataRes.banner;
            Namoaixud namoaixud = dataRes.namoaixud;
            F(dataRes.user, dataRes.user_god_info);
            C(profileResIdl.data.tbbookrack);
            D(profileResIdl.data.uc_card);
            E(profileResIdl.data.url_map);
            if (profileResIdl.data.bubble_info != null) {
                ps8 ps8Var = new ps8();
                this.r = ps8Var;
                ps8Var.d(profileResIdl.data.bubble_info);
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
                List<xs8> q = q(profileResIdl.data.custom_grid);
                if (!ListUtils.isEmpty(q)) {
                    at8 at8Var = new at8();
                    at8Var.f(q);
                    this.a.add(at8Var);
                    this.u = at8Var;
                } else {
                    p();
                }
            } else {
                p();
            }
            j();
            r(profileResIdl.data.recom_naws_list);
            if (!ListUtils.isEmpty(profileResIdl.data.more_grid)) {
                List<xs8> q2 = q(profileResIdl.data.more_grid);
                if (!ListUtils.isEmpty(q2)) {
                    for (xs8 xs8Var : q2) {
                        if (xs8Var != null) {
                            this.a.add(xs8Var);
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
                        e.put(list.get(i).getApkPackageName(), op5.k);
                    } else if (list.get(i).getStatus().status == op5.g) {
                        e.put(list.get(i).getApkPackageName(), op5.j);
                        if (this.v.d()) {
                            e.put(op5.i, op5.k);
                        } else {
                            e.put(op5.i, op5.j);
                        }
                    } else if (list.get(i).getStatus().status == op5.h) {
                        e.put(list.get(i).getApkPackageName(), op5.k);
                    } else {
                        e.put(list.get(i).getApkPackageName(), op5.k);
                    }
                }
            }
            this.v.m(e);
        }
    }

    public final boolean i(os8 os8Var) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, os8Var)) == null) {
            if (os8Var == null) {
                return false;
            }
            PersonRedTipData personRedTipData = new PersonRedTipData();
            if (os8Var.f != 0) {
                z = true;
            } else {
                z = false;
            }
            personRedTipData.setShow(z);
            personRedTipData.setRedPointVersion(os8Var.f);
            if (this.t == null) {
                this.t = new HashMap<>();
            }
            String s = m35.m().s(m35.q("key_my_tab_item_red_tip_data"), "");
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
                if (this.t.get(String.valueOf(os8Var.e)) == null) {
                    this.t.put(String.valueOf(os8Var.e), personRedTipData);
                    m35.m().B(m35.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                    if (os8Var.f == 0) {
                        return false;
                    }
                    return true;
                }
                if (this.t.get(String.valueOf(os8Var.e)) != null) {
                    if (os8Var.f > ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(os8Var.e)))).getRedPointVersion()) {
                        this.t.put(String.valueOf(os8Var.e), personRedTipData);
                        m35.m().B(m35.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
                        return true;
                    } else if (os8Var.f == ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(os8Var.e)))).getRedPointVersion()) {
                        return ((PersonRedTipData) Objects.requireNonNull(this.t.get(String.valueOf(os8Var.e)))).isShow();
                    }
                }
                return false;
            }
            this.t.put(String.valueOf(os8Var.e), personRedTipData);
            m35.m().B(m35.q("key_my_tab_item_red_tip_data"), DataExt.toJson(this.t));
            if (os8Var.f == 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void j() {
        List<ApkDownloadInfoData> list;
        wj0 value;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048592, this) != null) || !UbsABTestHelper.isShowMyPageDownloadCard()) {
            return;
        }
        ft8 ft8Var = this.o;
        if (ft8Var != null) {
            this.a.add(ft8Var);
            return;
        }
        ft8 ft8Var2 = new ft8();
        this.o = ft8Var2;
        if (ft8Var2 != null && (list = ft8Var2.a) != null && ft8Var2.b != null) {
            list.clear();
            this.o.b.clear();
            this.v = op5.c();
            HashMap<String, wj0> a = nj0.b().a();
            if (a != null) {
                for (Map.Entry<String, wj0> entry : a.entrySet()) {
                    if (entry != null && (value = entry.getValue()) != null && value.c.status == op5.g) {
                        if (this.v.i(value.h.getAbsolutePath()) && !this.v.j(value.d)) {
                            ak0 ak0Var = value.p;
                            ApkDownloadInfoData apkDownloadInfoData = new ApkDownloadInfoData(ak0Var.g, value.h, ak0Var.h, value.c, value.d, value.m, value);
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
                    ft8 ft8Var3 = this.o;
                    ft8Var3.b.addAll(ft8Var3.a);
                } else {
                    ft8 ft8Var4 = this.o;
                    ft8Var4.b.addAll(ft8Var4.a.subList(0, 5));
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
            ws8 ws8Var = this.q;
            if (ws8Var != null) {
                this.a.add(ws8Var);
                return;
            }
            CreationData creationData = user.creation_data;
            CreationData creationData2 = user.workcreation_data;
            ws8 ws8Var2 = new ws8();
            this.q = ws8Var2;
            ws8Var2.g(creationData);
            this.q.h(creationData2);
            this.a.add(this.q);
        }
    }

    public final void s(UserGrowth userGrowth) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, userGrowth) == null) {
            vs8 vs8Var = this.g;
            if (vs8Var != null) {
                this.a.add(vs8Var);
                return;
            }
            this.g = new vs8();
            xa5 xa5Var = new xa5();
            xa5Var.g(userGrowth);
            this.g.f(xa5Var);
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

    public final xs8 m(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i, i2, i3)) == null) {
            xs8 xs8Var = new xs8();
            xs8Var.b = i;
            xs8Var.e = TbadkCoreApplication.getInst().getString(i2);
            xs8Var.a = i3;
            UserData userData = this.b;
            if (userData != null) {
                xs8Var.h = userData;
            }
            return xs8Var;
        }
        return (xs8) invokeIII.objValue;
    }

    public final xs8 n(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            xs8 xs8Var = new xs8();
            xs8Var.b = i;
            xs8Var.e = str;
            xs8Var.a = i2;
            UserData userData = this.b;
            if (userData != null) {
                xs8Var.h = userData;
            }
            return xs8Var;
        }
        return (xs8) invokeCommon.objValue;
    }

    public final void o() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            xs8 m = m(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
            this.k = m;
            m.c = true;
            m.o = true;
            this.a.add(m);
            xs8 m2 = m(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.obfuscated_res_0x7f0f02e4, 39);
            m2.c = true;
            this.a.add(m2);
            xs8 n = n(R.drawable.obfuscated_res_0x7f0808cf, "订单中心", 47);
            n.g = "tiebaclient://swan/GidbxGjMhcXQsHbhL7KHyLm2qWim65ct/pages/home/index/?_baiduboxapp=%7B%22ext%22%3A%7B%7D%7D&callback=_bdbox_js_275&upgrade=0";
            this.a.add(n);
            xs8 n2 = n(R.drawable.obfuscated_res_0x7f0808bd, "开店", 48);
            n2.g = "https://activity.baidu.com/mbox/4a81af9f62/home";
            this.a.add(n2);
            xs8 n3 = n(R.drawable.obfuscated_res_0x7f0809cd, "隐私设置", 61);
            zs8 zs8Var = new zs8();
            n3.i = zs8Var;
            if (m35.m().n("setting_private_red_dot", 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            zs8Var.a = z;
            this.a.add(n3);
            xs8 n4 = n(R.drawable.obfuscated_res_0x7f0808b0, "广告推广", 49);
            n4.g = "https://yingxiao.baidu.com/new/home/topic/detail?name=index&no=644";
            this.a.add(n4);
            if (this.m == null) {
                this.m = new PersonMoreData();
            }
            xs8 m3 = m(R.drawable.obfuscated_res_0x7f0808ce, R.string.obfuscated_res_0x7f0f0f11, 33);
            m3.j = OrmObject.bundleWithObject(this.m);
            m3.i = new zs8();
            m3.p = true;
            this.a.add(m3);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            at8 at8Var = new at8();
            ArrayList arrayList = new ArrayList();
            xs8 m = m(R.drawable.obfuscated_res_0x7f0808bb, R.string.member_center, 12);
            m.c = true;
            arrayList.add(m);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808b4, R.string.dressup_center_title, 62));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f08082b, R.string.certification_center, 53));
            xs8 m2 = m(R.drawable.obfuscated_res_0x7f0808b3, R.string.create_ba, 56);
            m2.g = TbConfig.CREATE_BA;
            arrayList.add(m2);
            if (MessageManager.getInstance().findTask(2921431) != null) {
                xs8 m3 = m(R.drawable.obfuscated_res_0x7f0808ba, R.string.ala_live, 25);
                m3.c = true;
                m3.f = true;
                arrayList.add(m3);
            }
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808c0, R.string.game_hall, 58));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808b1, R.string.book_desk, 59));
            if (TbSingleton.getInstance().isBusinessAccount()) {
                xs8 m4 = m(R.drawable.obfuscated_res_0x7f0808b2, R.string.official_account, 15);
                m4.c = true;
                arrayList.add(m4);
            }
            xs8 m5 = m(R.drawable.obfuscated_res_0x7f0808b9, R.string.account_check, 50);
            m5.g = "https://wappass.baidu.com/v6/safetyInspection?adapter=3";
            arrayList.add(m5);
            xs8 m6 = m(R.drawable.obfuscated_res_0x7f0808b6, R.string.obfuscated_res_0x7f0f0c13, 10);
            this.i = m6;
            m6.i = new zs8();
            this.i.c = true;
            String formatNumForTdouDisPlay = StringHelper.formatNumForTdouDisPlay(this.b.getTDouNum());
            if (CurrencySwitchUtil.isYyIsConvert()) {
                formatNumForTdouDisPlay = CurrencyHelper.getFormatOverBaiwanNum(this.b.getTDouNum());
            }
            zs8 zs8Var = this.i.i;
            zs8Var.c = formatNumForTdouDisPlay;
            zs8Var.e = CurrencySwitchUtil.getMoneyIcon();
            arrayList.add(this.i);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080849, R.string.welfare_entrance, 63));
            xs8 m7 = m(R.drawable.obfuscated_res_0x7f0808bf, R.string.mark_center, 51);
            m7.g = TbConfig.TIEBA_ADDRESS + "mo/q/icon/panelIcon?opacity=0&opacitybtnhex=ffffff&user_id=" + this.b.getUserId();
            arrayList.add(m7);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808be, R.string.subscribe_manager, 52));
            xs8 m8 = m(R.drawable.obfuscated_res_0x7f0808b7, R.string.novel_member_monthly, 54);
            m8.g = vj5.g("https://boxnovel.baidu.com/boxnovel/tbvipright?data={\"fromaction\": \"tieba\"}");
            arrayList.add(m8);
            xs8 m9 = m(R.drawable.obfuscated_res_0x7f0808c9, R.string.community_convention, 55);
            m9.g = TbConfig.COMMUNITY_CONVENTION;
            arrayList.add(m9);
            arrayList.add(m(R.drawable.obfuscated_res_0x7f0808b8, R.string.earn_money, 57));
            arrayList.add(m(R.drawable.obfuscated_res_0x7f080ac0, R.string.exchange_mall, 60));
            at8Var.f(arrayList);
            this.a.add(at8Var);
            this.u = at8Var;
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            et8 et8Var = this.n;
            if (et8Var != null && et8Var.a.size() > 0) {
                this.a.add(this.n);
                return;
            }
            this.n = new et8();
            if (ListUtils.isEmpty(this.c)) {
                return;
            }
            for (int i = 0; i < this.c.size(); i++) {
                ns8 ns8Var = new ns8();
                ns8Var.b(this.c.get(i));
                if (!gi.isEmpty(ns8Var.a())) {
                    this.n.a.add(ns8Var);
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
            ws8 ws8Var = this.q;
            if (ws8Var != null && this.a.contains(ws8Var)) {
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
