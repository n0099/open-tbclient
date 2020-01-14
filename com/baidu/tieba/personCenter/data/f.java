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
/* loaded from: classes7.dex */
public class f implements com.baidu.tieba.person.b {
    private ArrayList<com.baidu.adp.widget.ListView.m> gGF = new ArrayList<>();
    public PersonMoreData jfL;
    public g jgA;
    public g jgB;
    public h jgC;
    public m jgD;
    public j jgE;
    private Duxiaoman jgt;
    private List<BannerImage> jgu;
    private PersonUserGodInfo jgv;
    private d jgw;
    public com.baidu.tieba.person.data.d jgx;
    public g jgy;
    public g jgz;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> ctN() {
        return this.gGF;
    }

    private void ctO() {
        if (this.jgw != null) {
            this.gGF.add(this.jgw);
        } else if (this.mUserData != null) {
            this.jgw = new d();
            this.jgw.jgn = this.mUserData.getFansNum();
            this.jgw.jgo = this.mUserData.getConcern_num();
            this.jgw.jgp = this.mUserData.getLike_bars();
            this.jgw.threadNum = this.mUserData.getThreadNum();
            this.jgw.userData = this.mUserData;
            this.gGF.add(this.jgw);
        }
    }

    private void ctP() {
        if (this.jgD != null) {
            this.gGF.add(this.jgD);
            return;
        }
        this.jgD = new m();
        if (!v.isEmpty(this.jgu)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jgu.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jgu.get(i2));
                if (!aq.isEmpty(aVar.ctM())) {
                    this.jgD.jgu.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jgD.jgu.size() > 0) {
                this.gGF.add(this.jgD);
            }
        }
    }

    private void dQ(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jgE == null) {
                this.jgE = new j();
                this.gGF.add(this.jgE);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jgE.setData(arrayList);
        }
    }

    private void ctQ() {
        if (this.jgy == null) {
            this.jgy = T(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jgy.jgF = true;
            this.jgy.jgI = new i();
        }
        this.gGF.add(this.jgy);
        g T = T(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        T.jgF = true;
        this.gGF.add(T);
        g T2 = T(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        T2.jgH = true;
        T2.jgF = true;
        this.gGF.add(T2);
        g T3 = T(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        T3.jgF = true;
        T3.jgI = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            T3.jgI.isShowRedTip = true;
        }
        T3.jgI.jgQ = true;
        this.gGF.add(T3);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g T4 = T(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            T4.jgF = true;
            T4.cHN = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gGF.add(T4);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getInt("baidu_financial_display", 1) == 1) {
            g T5 = T(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            T5.jgF = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_baidu_financial_has_clicked", false)) {
                T5.jgI = new i();
                T5.jgI.isShowRedTip = true;
            }
            this.gGF.add(T5);
        }
        if (this.jgt != null && this.jgt.is_end.intValue() != 1) {
            g T6 = T(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            T6.jgF = true;
            T6.cHN = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jgt.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                T6.jgI = iVar;
            }
            this.gGF.add(T6);
        }
        if (MissionEntranceSwitch.isOn()) {
            g T7 = T(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            T7.jgF = true;
            this.gGF.add(T7);
        }
        g T8 = T(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        T8.jgF = true;
        this.gGF.add(T8);
        this.jgz = T(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jgz.jgI = new i();
        this.jgz.jgF = true;
        this.jgz.jgI.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jgz.jgI.jgN = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gGF.add(this.jgz);
        g T9 = T(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        T9.jgF = true;
        this.gGF.add(T9);
        g T10 = T(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        T10.jgF = true;
        if (this.mUserData.membershipInfo != null) {
            T10.cHN = this.mUserData.membershipInfo.mLink;
        }
        this.gGF.add(T10);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jgA = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jgA.jgH = true;
            this.jgA.jgI = new i();
            this.gGF.add(this.jgA);
            TiebaStatic.log(new an("c12597"));
        } else {
            T10.jgH = true;
        }
        g T11 = T(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        T11.jgF = true;
        this.gGF.add(T11);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g T12 = T(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            T12.jgF = true;
            T12.jgH = true;
            this.gGF.add(T12);
        }
        this.jgB = T(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jgB.jgH = true;
        this.jgB.jgF = true;
        this.gGF.add(this.jgB);
        g T13 = T(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        T13.jgF = true;
        this.gGF.add(T13);
        if (this.jfL == null) {
            this.jfL = new PersonMoreData();
        }
        g T14 = T(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        T14.jgF = true;
        T14.jgG = true;
        T14.jgJ = OrmObject.bundleWithObject(this.jfL);
        T14.jgI = new i();
        List<PersonMoreItemData> list = this.jfL.mUrlMaps;
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
                T14.jgI.jgM = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gGF.add(T14);
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

    public void re(boolean z) {
        if (this.jgy != null) {
            if (this.jgy.jgI == null) {
                this.jgy.jgI = new i();
            }
            this.jgy.jgI.isShowRedTip = z;
        }
    }

    public void rf(boolean z) {
        if (this.jgB != null) {
            if (this.jgB.jgI == null) {
                this.jgB.jgI = new i();
            }
            this.jgB.jgI.isShowRedTip = z;
        }
    }

    public void rg(boolean z) {
        if (this.jgA != null) {
            if (this.jgA.jgI == null) {
                this.jgA.jgI = new i();
            }
            this.jgA.jgI.isShowRedTip = z;
        }
    }

    public void rh(boolean z) {
        if (this.jgw != null) {
            this.jgw.jgq = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jgC = new h();
            this.jgu = profileResIdl.data.banner;
            this.jgt = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dR(profileResIdl.data.url_map);
            this.gGF.add(this.jgC);
            ctO();
            dQ(profileResIdl.data.recom_swan_list);
            ctP();
            ctQ();
            com.baidu.tieba.o.a.cCm().sg(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jgC = new h();
            this.jgC.userData = this.mUserData;
            this.gGF.add(this.jgC);
            ctO();
            ctQ();
            com.baidu.tieba.o.a.cCm().sg(true);
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
        if (this.jgv == null && userGodInfo != null) {
            this.jgv = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jgv.parserProtobuf(userGodInfo);
        }
        this.jgC.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jgx = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dR(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jfL = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jfL.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
