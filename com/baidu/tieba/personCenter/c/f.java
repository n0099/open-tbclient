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
    private Duxiaoman mvX;
    private List<BannerImage> mvY;
    private PersonUserGodInfo mvZ;
    public PersonMoreData mvp;
    private d mwa;
    public com.baidu.tieba.person.data.d mwb;
    public h mwc;
    public h mwd;
    public h mwe;
    public h mwf;
    public i mwg;
    public n mwh;
    public k mwi;
    private int[] mwj = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mwk = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mwl = {1, 2, 3, 4};
    private ArrayList<com.baidu.adp.widget.ListView.n> hez = new ArrayList<>();

    public ArrayList<com.baidu.adp.widget.ListView.n> dwS() {
        return this.hez;
    }

    private void dwT() {
        if (this.mwa != null) {
            this.hez.add(this.mwa);
        } else if (this.mUserData != null) {
            this.mwa = new d();
            this.mwa.mvR = this.mUserData.getFansNum();
            this.mwa.mvS = this.mUserData.getConcern_num();
            this.mwa.mvT = this.mUserData.getLike_bars();
            this.mwa.threadNum = this.mUserData.getThreadNum();
            this.mwa.userData = this.mUserData;
            this.hez.add(this.mwa);
        }
    }

    private void dwU() {
        if (this.mwh != null) {
            this.hez.add(this.mwh);
            return;
        }
        this.mwh = new n();
        if (!y.isEmpty(this.mvY)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mvY.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mvY.get(i2));
                if (!au.isEmpty(aVar.blM())) {
                    this.mwh.mvY.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mwh.mvY.size() > 0) {
                this.hez.add(this.mwh);
            }
        }
    }

    private void dwV() {
        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mwn = this.mwk[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mwj[i]);
                    aVar.type = this.mwl[i];
                }
                arrayList.add(aVar);
            }
            gVar.fv(arrayList);
            gVar.mUserData = this.mUserData;
            this.hez.add(gVar);
        }
    }

    private void ft(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.mwi == null) {
                this.mwi = new k();
                this.hez.add(this.mwi);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mwi.setData(arrayList);
        }
    }

    private void dwW() {
        if (this.mwc == null) {
            this.mwc = Z(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mwc.mwo = true;
            this.mwc.mwr = new j();
        }
        this.hez.add(this.mwc);
        h Z = Z(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Z.mwo = true;
        Z.mwq = true;
        this.hez.add(Z);
        h Z2 = Z(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Z2.mwq = true;
        Z2.mwo = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cOF() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Z3 = Z(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Z3.mwo = true;
            Z3.aIQ = this.mLiveGoodsWindowData.goods_url;
            this.hez.add(Z3);
        }
        h Z4 = Z(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Z4.mwo = true;
        Z4.mwr = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Z4.mwr.isShowRedTip = true;
        }
        Z4.mwr.mwz = true;
        this.hez.add(Z4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Z5 = Z(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Z5.mwo = true;
            Z5.aIQ = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.hez.add(Z5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brR().getInt("baidu_financial_display", 1) == 1) {
            h Z6 = Z(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Z6.mwo = true;
            if (!com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z6.mwr = new j();
                Z6.mwr.isShowRedTip = true;
            }
            this.hez.add(Z6);
        }
        if (this.mvX != null && this.mvX.is_end.intValue() != 1) {
            h Z7 = Z(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Z7.mwo = true;
            Z7.aIQ = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mvX.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Z7.mwr = jVar;
            }
            this.hez.add(Z7);
        }
        h Z8 = Z(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Z8.mwo = true;
        this.hez.add(Z8);
        h Z9 = Z(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Z9.mwo = true;
        this.hez.add(Z9);
        this.mwd = Z(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mwd.mwr = new j();
        this.mwd.mwo = true;
        this.mwd.mwr.text = au.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mwd.mwr.mww = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.hez.add(this.mwd);
        h Z10 = Z(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Z10.mwo = true;
        this.hez.add(Z10);
        h Z11 = Z(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Z11.mwo = true;
        if (this.mUserData.membershipInfo != null) {
            Z11.aIQ = this.mUserData.membershipInfo.mLink;
        }
        this.hez.add(Z11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mwe = g(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mwe.mwq = true;
            this.mwe.mwr = new j();
            this.hez.add(this.mwe);
            TiebaStatic.log(new ar("c12597"));
        } else {
            Z11.mwq = true;
        }
        h Z12 = Z(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Z12.mwo = true;
        this.hez.add(Z12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Z13 = Z(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Z13.mwo = true;
            Z13.mwq = true;
            this.hez.add(Z13);
        }
        this.mwf = Z(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mwf.mwq = true;
        this.mwf.mwo = true;
        this.hez.add(this.mwf);
        h Z14 = Z(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Z14.mwo = true;
        this.hez.add(Z14);
        if (this.mvp == null) {
            this.mvp = new PersonMoreData();
        }
        h Z15 = Z(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Z15.mwo = true;
        Z15.mwp = true;
        Z15.mws = OrmObject.bundleWithObject(this.mvp);
        Z15.mwr = new j();
        List<PersonMoreItemData> list = this.mvp.mUrlMaps;
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
                Z15.mwr.mwv = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.hez.add(Z15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Z(int i, int i2, int i3) {
        h hVar = new h();
        hVar.gtB = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h g(int i, String str, int i2) {
        h hVar = new h();
        hVar.gtB = i;
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
        if (this.mwc != null) {
            if (this.mwc.mwr == null) {
                this.mwc.mwr = new j();
            }
            this.mwc.mwr.isShowRedTip = z;
        }
    }

    public void wH(boolean z) {
        if (this.mwf != null) {
            if (this.mwf.mwr == null) {
                this.mwf.mwr = new j();
            }
            this.mwf.mwr.isShowRedTip = z;
        }
    }

    public void wI(boolean z) {
        if (this.mwe != null) {
            if (this.mwe.mwr == null) {
                this.mwe.mwr = new j();
            }
            this.mwe.mwr.isShowRedTip = z;
        }
    }

    public void wJ(boolean z) {
        if (this.mwa != null) {
            this.mwa.mvU = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mwg = new i();
            this.mvY = profileResIdl.data.banner;
            this.mvX = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fu(profileResIdl.data.url_map);
            this.hez.add(this.mwg);
            dwT();
            dwV();
            ft(profileResIdl.data.recom_swan_list);
            dwU();
            dwW();
            com.baidu.tieba.p.a.dFm().xK(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mwg = new i();
            this.mwg.userData = this.mUserData;
            this.hez.add(this.mwg);
            dwT();
            dwW();
            com.baidu.tieba.p.a.dFm().xK(true);
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
        if (this.mvZ == null && userGodInfo != null) {
            this.mvZ = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mvZ.parserProtobuf(userGodInfo);
        }
        this.mwg.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mwb = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fu(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.mvp = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.mvp.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
