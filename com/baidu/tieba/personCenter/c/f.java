package com.baidu.tieba.personCenter.c;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
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
/* loaded from: classes9.dex */
public class f implements com.baidu.tieba.person.b {
    private ArrayList<com.baidu.adp.widget.ListView.m> gIS = new ArrayList<>();
    public PersonMoreData jgV;
    private Duxiaoman jhA;
    private List<BannerImage> jhB;
    private PersonUserGodInfo jhC;
    private d jhD;
    public com.baidu.tieba.person.data.d jhE;
    public g jhF;
    public g jhG;
    public g jhH;
    public g jhI;
    public h jhJ;
    public m jhK;
    public j jhL;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> cvj() {
        return this.gIS;
    }

    private void cvk() {
        if (this.jhD != null) {
            this.gIS.add(this.jhD);
        } else if (this.mUserData != null) {
            this.jhD = new d();
            this.jhD.jhu = this.mUserData.getFansNum();
            this.jhD.jhv = this.mUserData.getConcern_num();
            this.jhD.jhw = this.mUserData.getLike_bars();
            this.jhD.threadNum = this.mUserData.getThreadNum();
            this.jhD.userData = this.mUserData;
            this.gIS.add(this.jhD);
        }
    }

    private void cvl() {
        if (this.jhK != null) {
            this.gIS.add(this.jhK);
            return;
        }
        this.jhK = new m();
        if (!v.isEmpty(this.jhB)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jhB.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jhB.get(i2));
                if (!aq.isEmpty(aVar.cvi())) {
                    this.jhK.jhB.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jhK.jhB.size() > 0) {
                this.gIS.add(this.jhK);
            }
        }
    }

    private void dM(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jhL == null) {
                this.jhL = new j();
                this.gIS.add(this.jhL);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jhL.setData(arrayList);
        }
    }

    private void cvm() {
        if (this.jhF == null) {
            this.jhF = U(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jhF.jhM = true;
            this.jhF.jhP = new i();
        }
        this.gIS.add(this.jhF);
        g U = U(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        U.jhM = true;
        this.gIS.add(U);
        g U2 = U(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        U2.jhO = true;
        U2.jhM = true;
        this.gIS.add(U2);
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.bME() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g U3 = U(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            U3.jhM = true;
            U3.cLS = this.mLiveGoodsWindowData.goods_url;
            this.gIS.add(U3);
        }
        g U4 = U(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        U4.jhM = true;
        U4.jhP = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            U4.jhP.isShowRedTip = true;
        }
        U4.jhP.jhX = true;
        this.gIS.add(U4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g U5 = U(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            U5.jhM = true;
            U5.cLS = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gIS.add(U5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("baidu_financial_display", 1) == 1) {
            g U6 = U(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            U6.jhM = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_baidu_financial_has_clicked", false)) {
                U6.jhP = new i();
                U6.jhP.isShowRedTip = true;
            }
            this.gIS.add(U6);
        }
        if (this.jhA != null && this.jhA.is_end.intValue() != 1) {
            g U7 = U(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            U7.jhM = true;
            U7.cLS = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jhA.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                U7.jhP = iVar;
            }
            this.gIS.add(U7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g U8 = U(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            U8.jhM = true;
            this.gIS.add(U8);
        }
        g U9 = U(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        U9.jhM = true;
        this.gIS.add(U9);
        this.jhG = U(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jhG.jhP = new i();
        this.jhG.jhM = true;
        this.jhG.jhP.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jhG.jhP.jhU = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gIS.add(this.jhG);
        g U10 = U(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        U10.jhM = true;
        this.gIS.add(U10);
        g U11 = U(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        U11.jhM = true;
        if (this.mUserData.membershipInfo != null) {
            U11.cLS = this.mUserData.membershipInfo.mLink;
        }
        this.gIS.add(U11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jhH = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jhH.jhO = true;
            this.jhH.jhP = new i();
            this.gIS.add(this.jhH);
            TiebaStatic.log(new an("c12597"));
        } else {
            U11.jhO = true;
        }
        g U12 = U(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        U12.jhM = true;
        this.gIS.add(U12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g U13 = U(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            U13.jhM = true;
            U13.jhO = true;
            this.gIS.add(U13);
        }
        this.jhI = U(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jhI.jhO = true;
        this.jhI.jhM = true;
        this.gIS.add(this.jhI);
        g U14 = U(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        U14.jhM = true;
        this.gIS.add(U14);
        if (this.jgV == null) {
            this.jgV = new PersonMoreData();
        }
        g U15 = U(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        U15.jhM = true;
        U15.jhN = true;
        U15.jhQ = OrmObject.bundleWithObject(this.jgV);
        U15.jhP = new i();
        List<PersonMoreItemData> list = this.jgV.mUrlMaps;
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
                U15.jhP.jhT = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gIS.add(U15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g U(int i, int i2, int i3) {
        g gVar = new g();
        gVar.iconId = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g k(int i, String str, int i2) {
        g gVar = new g();
        gVar.iconId = i;
        gVar.title = str;
        gVar.type = i2;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    public void a(com.baidu.tbadk.data.m mVar) {
        this.mUserData.setPendantData(mVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void ri(boolean z) {
        if (this.jhF != null) {
            if (this.jhF.jhP == null) {
                this.jhF.jhP = new i();
            }
            this.jhF.jhP.isShowRedTip = z;
        }
    }

    public void rj(boolean z) {
        if (this.jhI != null) {
            if (this.jhI.jhP == null) {
                this.jhI.jhP = new i();
            }
            this.jhI.jhP.isShowRedTip = z;
        }
    }

    public void rk(boolean z) {
        if (this.jhH != null) {
            if (this.jhH.jhP == null) {
                this.jhH.jhP = new i();
            }
            this.jhH.jhP.isShowRedTip = z;
        }
    }

    public void rl(boolean z) {
        if (this.jhD != null) {
            this.jhD.jhx = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jhJ = new h();
            this.jhB = profileResIdl.data.banner;
            this.jhA = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dN(profileResIdl.data.url_map);
            this.gIS.add(this.jhJ);
            cvk();
            dM(profileResIdl.data.recom_swan_list);
            cvl();
            cvm();
            com.baidu.tieba.p.a.cDQ().sj(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jhJ = new h();
            this.jhJ.userData = this.mUserData;
            this.gIS.add(this.jhJ);
            cvk();
            cvm();
            com.baidu.tieba.p.a.cDQ().sj(true);
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
        if (this.jhC == null && userGodInfo != null) {
            this.jhC = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jhC.parserProtobuf(userGodInfo);
        }
        this.jhJ.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jhE = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dN(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jgV = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jgV.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
