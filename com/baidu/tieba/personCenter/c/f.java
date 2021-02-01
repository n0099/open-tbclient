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
    public PersonMoreData msY;
    private Duxiaoman mtG;
    private List<BannerImage> mtH;
    private PersonUserGodInfo mtI;
    private d mtJ;
    public com.baidu.tieba.person.data.d mtK;
    public h mtL;
    public h mtM;
    public h mtN;
    public h mtO;
    public i mtP;
    public n mtQ;
    public k mtR;
    private int[] mtS = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mtT = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mtU = {1, 2, 3, 4};
    private ArrayList<com.baidu.adp.widget.ListView.n> hcC = new ArrayList<>();

    public ArrayList<com.baidu.adp.widget.ListView.n> dwC() {
        return this.hcC;
    }

    private void dwD() {
        if (this.mtJ != null) {
            this.hcC.add(this.mtJ);
        } else if (this.mUserData != null) {
            this.mtJ = new d();
            this.mtJ.mtA = this.mUserData.getFansNum();
            this.mtJ.mtB = this.mUserData.getConcern_num();
            this.mtJ.mtC = this.mUserData.getLike_bars();
            this.mtJ.threadNum = this.mUserData.getThreadNum();
            this.mtJ.userData = this.mUserData;
            this.hcC.add(this.mtJ);
        }
    }

    private void dwE() {
        if (this.mtQ != null) {
            this.hcC.add(this.mtQ);
            return;
        }
        this.mtQ = new n();
        if (!y.isEmpty(this.mtH)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mtH.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mtH.get(i2));
                if (!au.isEmpty(aVar.blK())) {
                    this.mtQ.mtH.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mtQ.mtH.size() > 0) {
                this.hcC.add(this.mtQ);
            }
        }
    }

    private void dwF() {
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mtW = this.mtT[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mtS[i]);
                    aVar.type = this.mtU[i];
                }
                arrayList.add(aVar);
            }
            gVar.fv(arrayList);
            gVar.mUserData = this.mUserData;
            this.hcC.add(gVar);
        }
    }

    private void ft(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.mtR == null) {
                this.mtR = new k();
                this.hcC.add(this.mtR);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mtR.setData(arrayList);
        }
    }

    private void dwG() {
        if (this.mtL == null) {
            this.mtL = Z(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mtL.mtX = true;
            this.mtL.mua = new j();
        }
        this.hcC.add(this.mtL);
        h Z = Z(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Z.mtX = true;
        Z.mtZ = true;
        this.hcC.add(Z);
        h Z2 = Z(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Z2.mtZ = true;
        Z2.mtX = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cOr() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Z3 = Z(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Z3.mtX = true;
            Z3.aHq = this.mLiveGoodsWindowData.goods_url;
            this.hcC.add(Z3);
        }
        h Z4 = Z(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Z4.mtX = true;
        Z4.mua = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Z4.mua.isShowRedTip = true;
        }
        Z4.mua.mui = true;
        this.hcC.add(Z4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Z5 = Z(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Z5.mtX = true;
            Z5.aHq = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.hcC.add(Z5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brQ().getInt("baidu_financial_display", 1) == 1) {
            h Z6 = Z(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Z6.mtX = true;
            if (!com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z6.mua = new j();
                Z6.mua.isShowRedTip = true;
            }
            this.hcC.add(Z6);
        }
        if (this.mtG != null && this.mtG.is_end.intValue() != 1) {
            h Z7 = Z(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Z7.mtX = true;
            Z7.aHq = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mtG.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Z7.mua = jVar;
            }
            this.hcC.add(Z7);
        }
        h Z8 = Z(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Z8.mtX = true;
        this.hcC.add(Z8);
        h Z9 = Z(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Z9.mtX = true;
        this.hcC.add(Z9);
        this.mtM = Z(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mtM.mua = new j();
        this.mtM.mtX = true;
        this.mtM.mua.text = au.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mtM.mua.muf = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.hcC.add(this.mtM);
        h Z10 = Z(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Z10.mtX = true;
        this.hcC.add(Z10);
        h Z11 = Z(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Z11.mtX = true;
        if (this.mUserData.membershipInfo != null) {
            Z11.aHq = this.mUserData.membershipInfo.mLink;
        }
        this.hcC.add(Z11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mtN = g(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mtN.mtZ = true;
            this.mtN.mua = new j();
            this.hcC.add(this.mtN);
            TiebaStatic.log(new ar("c12597"));
        } else {
            Z11.mtZ = true;
        }
        h Z12 = Z(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Z12.mtX = true;
        this.hcC.add(Z12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Z13 = Z(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Z13.mtX = true;
            Z13.mtZ = true;
            this.hcC.add(Z13);
        }
        this.mtO = Z(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mtO.mtZ = true;
        this.mtO.mtX = true;
        this.hcC.add(this.mtO);
        h Z14 = Z(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Z14.mtX = true;
        this.hcC.add(Z14);
        if (this.msY == null) {
            this.msY = new PersonMoreData();
        }
        h Z15 = Z(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Z15.mtX = true;
        Z15.mtY = true;
        Z15.mub = OrmObject.bundleWithObject(this.msY);
        Z15.mua = new j();
        List<PersonMoreItemData> list = this.msY.mUrlMaps;
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
                Z15.mua.mue = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.hcC.add(Z15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Z(int i, int i2, int i3) {
        h hVar = new h();
        hVar.grE = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h g(int i, String str, int i2) {
        h hVar = new h();
        hVar.grE = i;
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
        if (this.mtL != null) {
            if (this.mtL.mua == null) {
                this.mtL.mua = new j();
            }
            this.mtL.mua.isShowRedTip = z;
        }
    }

    public void wH(boolean z) {
        if (this.mtO != null) {
            if (this.mtO.mua == null) {
                this.mtO.mua = new j();
            }
            this.mtO.mua.isShowRedTip = z;
        }
    }

    public void wI(boolean z) {
        if (this.mtN != null) {
            if (this.mtN.mua == null) {
                this.mtN.mua = new j();
            }
            this.mtN.mua.isShowRedTip = z;
        }
    }

    public void wJ(boolean z) {
        if (this.mtJ != null) {
            this.mtJ.mtD = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mtP = new i();
            this.mtH = profileResIdl.data.banner;
            this.mtG = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fu(profileResIdl.data.url_map);
            this.hcC.add(this.mtP);
            dwD();
            dwF();
            ft(profileResIdl.data.recom_swan_list);
            dwE();
            dwG();
            com.baidu.tieba.p.a.dEW().xK(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mtP = new i();
            this.mtP.userData = this.mUserData;
            this.hcC.add(this.mtP);
            dwD();
            dwG();
            com.baidu.tieba.p.a.dEW().xK(true);
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
        if (this.mtI == null && userGodInfo != null) {
            this.mtI = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mtI.parserProtobuf(userGodInfo);
        }
        this.mtP.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mtK = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fu(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.msY = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.msY.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
