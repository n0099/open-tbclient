package com.baidu.tieba.personCenter.c;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.personCenter.c.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes2.dex */
public class f implements com.baidu.tieba.person.b {
    private com.baidu.tieba.j.b mLiveGoodsWindowData;
    private UserData mUserData;
    private Duxiaoman mtV;
    private List<BannerImage> mtW;
    private PersonUserGodInfo mtX;
    private d mtY;
    public com.baidu.tieba.person.data.d mtZ;
    public PersonMoreData mtn;
    public h mua;
    public h mub;
    public h muc;
    public h mud;
    public i mue;
    public n muf;
    public k mug;
    private int[] muh = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mui = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] muj = {1, 2, 3, 4};
    private ArrayList<com.baidu.adp.widget.ListView.n> hcQ = new ArrayList<>();

    public ArrayList<com.baidu.adp.widget.ListView.n> dwJ() {
        return this.hcQ;
    }

    private void dwK() {
        if (this.mtY != null) {
            this.hcQ.add(this.mtY);
        } else if (this.mUserData != null) {
            this.mtY = new d();
            this.mtY.mtP = this.mUserData.getFansNum();
            this.mtY.mtQ = this.mUserData.getConcern_num();
            this.mtY.mtR = this.mUserData.getLike_bars();
            this.mtY.threadNum = this.mUserData.getThreadNum();
            this.mtY.userData = this.mUserData;
            this.hcQ.add(this.mtY);
        }
    }

    private void dwL() {
        if (this.muf != null) {
            this.hcQ.add(this.muf);
            return;
        }
        this.muf = new n();
        if (!y.isEmpty(this.mtW)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mtW.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mtW.get(i2));
                if (!au.isEmpty(aVar.blK())) {
                    this.muf.mtW.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.muf.mtW.size() > 0) {
                this.hcQ.add(this.muf);
            }
        }
    }

    private void dwM() {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mul = this.mui[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.muh[i]);
                    aVar.type = this.muj[i];
                }
                arrayList.add(aVar);
            }
            gVar.fv(arrayList);
            gVar.mUserData = this.mUserData;
            this.hcQ.add(gVar);
        }
    }

    private void ft(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.mug == null) {
                this.mug = new k();
                this.hcQ.add(this.mug);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mug.setData(arrayList);
        }
    }

    private void dwN() {
        if (this.mua == null) {
            this.mua = Z(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mua.mum = true;
            this.mua.mup = new j();
        }
        this.hcQ.add(this.mua);
        h Z = Z(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Z.mum = true;
        Z.muo = true;
        this.hcQ.add(Z);
        h Z2 = Z(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Z2.muo = true;
        Z2.mum = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cOy() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Z3 = Z(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Z3.mum = true;
            Z3.aHq = this.mLiveGoodsWindowData.goods_url;
            this.hcQ.add(Z3);
        }
        h Z4 = Z(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Z4.mum = true;
        Z4.mup = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Z4.mup.isShowRedTip = true;
        }
        Z4.mup.mux = true;
        this.hcQ.add(Z4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Z5 = Z(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Z5.mum = true;
            Z5.aHq = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.hcQ.add(Z5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("baidu_financial_display", 1) == 1) {
            h Z6 = Z(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Z6.mum = true;
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z6.mup = new j();
                Z6.mup.isShowRedTip = true;
            }
            this.hcQ.add(Z6);
        }
        if (this.mtV != null && this.mtV.is_end.intValue() != 1) {
            h Z7 = Z(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Z7.mum = true;
            Z7.aHq = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mtV.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Z7.mup = jVar;
            }
            this.hcQ.add(Z7);
        }
        h Z8 = Z(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Z8.mum = true;
        this.hcQ.add(Z8);
        h Z9 = Z(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Z9.mum = true;
        this.hcQ.add(Z9);
        this.mub = Z(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mub.mup = new j();
        this.mub.mum = true;
        this.mub.mup.text = au.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mub.mup.muu = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.hcQ.add(this.mub);
        h Z10 = Z(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Z10.mum = true;
        this.hcQ.add(Z10);
        h Z11 = Z(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Z11.mum = true;
        if (this.mUserData.membershipInfo != null) {
            Z11.aHq = this.mUserData.membershipInfo.mLink;
        }
        this.hcQ.add(Z11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.muc = g(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.muc.muo = true;
            this.muc.mup = new j();
            this.hcQ.add(this.muc);
            TiebaStatic.log(new ar("c12597"));
        } else {
            Z11.muo = true;
        }
        h Z12 = Z(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Z12.mum = true;
        this.hcQ.add(Z12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Z13 = Z(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Z13.mum = true;
            Z13.muo = true;
            this.hcQ.add(Z13);
        }
        this.mud = Z(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mud.muo = true;
        this.mud.mum = true;
        this.hcQ.add(this.mud);
        h Z14 = Z(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Z14.mum = true;
        this.hcQ.add(Z14);
        if (this.mtn == null) {
            this.mtn = new PersonMoreData();
        }
        h Z15 = Z(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Z15.mum = true;
        Z15.mun = true;
        Z15.muq = OrmObject.bundleWithObject(this.mtn);
        Z15.mup = new j();
        List<PersonMoreItemData> list = this.mtn.mUrlMaps;
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (PersonMoreItemData personMoreItemData : list) {
                if (personMoreItemData != null && !TextUtils.isEmpty(personMoreItemData.mName)) {
                    sb.append(personMoreItemData.mName).append("、");
                }
            }
            if (sb.toString().endsWith("、")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                Z15.mup.mut = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.hcQ.add(Z15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Z(int i, int i2, int i3) {
        h hVar = new h();
        hVar.grS = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h g(int i, String str, int i2) {
        h hVar = new h();
        hVar.grS = i;
        hVar.title = str;
        hVar.type = i2;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    public void a(com.baidu.tbadk.data.n nVar) {
        this.mUserData.setPendantData(nVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void wG(boolean z) {
        if (this.mua != null) {
            if (this.mua.mup == null) {
                this.mua.mup = new j();
            }
            this.mua.mup.isShowRedTip = z;
        }
    }

    public void wH(boolean z) {
        if (this.mud != null) {
            if (this.mud.mup == null) {
                this.mud.mup = new j();
            }
            this.mud.mup.isShowRedTip = z;
        }
    }

    public void wI(boolean z) {
        if (this.muc != null) {
            if (this.muc.mup == null) {
                this.muc.mup = new j();
            }
            this.muc.mup.isShowRedTip = z;
        }
    }

    public void wJ(boolean z) {
        if (this.mtY != null) {
            this.mtY.mtS = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mue = new i();
            this.mtW = profileResIdl.data.banner;
            this.mtV = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fu(profileResIdl.data.url_map);
            this.hcQ.add(this.mue);
            dwK();
            dwM();
            ft(profileResIdl.data.recom_swan_list);
            dwL();
            dwN();
            com.baidu.tieba.p.a.dFe().xK(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mue = new i();
            this.mue.userData = this.mUserData;
            this.hcQ.add(this.mue);
            dwK();
            dwN();
            com.baidu.tieba.p.a.dFe().xK(true);
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                TbadkCoreApplication.getCurrentAccountObj().setSex(this.mUserData.getSex());
            }
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.mtX == null && userGodInfo != null) {
            this.mtX = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mtX.parserProtobuf(userGodInfo);
        }
        this.mue.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mtZ = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fu(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.mtn = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.mtn.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
