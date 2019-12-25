package com.baidu.tieba.personCenter.data;

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
/* loaded from: classes6.dex */
public class f implements com.baidu.tieba.person.b {
    private ArrayList<com.baidu.adp.widget.ListView.m> gDq = new ArrayList<>();
    private Duxiaoman jcL;
    private List<BannerImage> jcM;
    private PersonUserGodInfo jcN;
    private d jcO;
    public com.baidu.tieba.person.data.d jcP;
    public g jcQ;
    public g jcR;
    public g jcS;
    public g jcT;
    public h jcU;
    public m jcV;
    public j jcW;
    public PersonMoreData jcd;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> csE() {
        return this.gDq;
    }

    private void csF() {
        if (this.jcO != null) {
            this.gDq.add(this.jcO);
        } else if (this.mUserData != null) {
            this.jcO = new d();
            this.jcO.jcF = this.mUserData.getFansNum();
            this.jcO.jcG = this.mUserData.getConcern_num();
            this.jcO.jcH = this.mUserData.getLike_bars();
            this.jcO.threadNum = this.mUserData.getThreadNum();
            this.jcO.userData = this.mUserData;
            this.gDq.add(this.jcO);
        }
    }

    private void csG() {
        if (this.jcV != null) {
            this.gDq.add(this.jcV);
            return;
        }
        this.jcV = new m();
        if (!v.isEmpty(this.jcM)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jcM.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jcM.get(i2));
                if (!aq.isEmpty(aVar.csD())) {
                    this.jcV.jcM.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jcV.jcM.size() > 0) {
                this.gDq.add(this.jcV);
            }
        }
    }

    private void dQ(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jcW == null) {
                this.jcW = new j();
                this.gDq.add(this.jcW);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jcW.setData(arrayList);
        }
    }

    private void csH() {
        if (this.jcQ == null) {
            this.jcQ = T(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jcQ.jcX = true;
            this.jcQ.jda = new i();
        }
        this.gDq.add(this.jcQ);
        g T = T(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        T.jcX = true;
        this.gDq.add(T);
        g T2 = T(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        T2.jcZ = true;
        T2.jcX = true;
        this.gDq.add(T2);
        g T3 = T(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        T3.jcX = true;
        T3.jda = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            T3.jda.isShowRedTip = true;
        }
        T3.jda.jdi = true;
        this.gDq.add(T3);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g T4 = T(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            T4.jcX = true;
            T4.cHB = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gDq.add(T4);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aCY().getInt("baidu_financial_display", 1) == 1) {
            g T5 = T(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            T5.jcX = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_baidu_financial_has_clicked", false)) {
                T5.jda = new i();
                T5.jda.isShowRedTip = true;
            }
            this.gDq.add(T5);
        }
        if (this.jcL != null && this.jcL.is_end.intValue() != 1) {
            g T6 = T(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            T6.jcX = true;
            T6.cHB = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jcL.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                T6.jda = iVar;
            }
            this.gDq.add(T6);
        }
        if (MissionEntranceSwitch.isOn()) {
            g T7 = T(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            T7.jcX = true;
            this.gDq.add(T7);
        }
        g T8 = T(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        T8.jcX = true;
        this.gDq.add(T8);
        this.jcR = T(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jcR.jda = new i();
        this.jcR.jcX = true;
        this.jcR.jda.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jcR.jda.jdf = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gDq.add(this.jcR);
        g T9 = T(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        T9.jcX = true;
        this.gDq.add(T9);
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g T10 = T(R.drawable.icon_mask_wo_list_redenvelopes24_svg, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.aCY().getBoolean("key_has_my_redpacket_clicked", false)) {
                T10.jda = new i();
                T10.jda.isShowRedTip = true;
            }
            this.gDq.add(T10);
        }
        g T11 = T(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        T11.jcX = true;
        if (this.mUserData.membershipInfo != null) {
            T11.cHB = this.mUserData.membershipInfo.mLink;
        }
        this.gDq.add(T11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jcS = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jcS.jcZ = true;
            this.jcS.jda = new i();
            this.gDq.add(this.jcS);
            TiebaStatic.log(new an("c12597"));
        } else {
            T11.jcZ = true;
        }
        g T12 = T(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        T12.jcX = true;
        this.gDq.add(T12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g T13 = T(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            T13.jcX = true;
            T13.jcZ = true;
            this.gDq.add(T13);
        }
        this.jcT = T(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jcT.jcZ = true;
        this.jcT.jcX = true;
        this.gDq.add(this.jcT);
        g T14 = T(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        T14.jcX = true;
        this.gDq.add(T14);
        if (this.jcd == null) {
            this.jcd = new PersonMoreData();
        }
        g T15 = T(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        T15.jcX = true;
        T15.jcY = true;
        T15.jdb = OrmObject.bundleWithObject(this.jcd);
        T15.jda = new i();
        List<PersonMoreItemData> list = this.jcd.mUrlMaps;
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
                T15.jda.jde = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gDq.add(T15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g T(int i, int i2, int i3) {
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

    public void qR(boolean z) {
        if (this.jcQ != null) {
            if (this.jcQ.jda == null) {
                this.jcQ.jda = new i();
            }
            this.jcQ.jda.isShowRedTip = z;
        }
    }

    public void qS(boolean z) {
        if (this.jcT != null) {
            if (this.jcT.jda == null) {
                this.jcT.jda = new i();
            }
            this.jcT.jda.isShowRedTip = z;
        }
    }

    public void qT(boolean z) {
        if (this.jcS != null) {
            if (this.jcS.jda == null) {
                this.jcS.jda = new i();
            }
            this.jcS.jda.isShowRedTip = z;
        }
    }

    public void qU(boolean z) {
        if (this.jcO != null) {
            this.jcO.jcI = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jcU = new h();
            this.jcM = profileResIdl.data.banner;
            this.jcL = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dR(profileResIdl.data.url_map);
            this.gDq.add(this.jcU);
            csF();
            dQ(profileResIdl.data.recom_swan_list);
            csG();
            csH();
            com.baidu.tieba.o.a.cBe().rU(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jcU = new h();
            this.jcU.userData = this.mUserData;
            this.gDq.add(this.jcU);
            csF();
            csH();
            com.baidu.tieba.o.a.cBe().rU(true);
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
        if (this.jcN == null && userGodInfo != null) {
            this.jcN = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jcN.parserProtobuf(userGodInfo);
        }
        this.jcU.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jcP = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dR(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jcd = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jcd.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
