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
    public PersonMoreData jfG;
    private Duxiaoman jgo;
    private List<BannerImage> jgp;
    private PersonUserGodInfo jgq;
    private d jgr;
    public com.baidu.tieba.person.data.d jgs;
    public g jgt;
    public g jgu;
    public g jgv;
    public g jgw;
    public h jgx;
    public m jgy;
    public j jgz;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> ctL() {
        return this.gGF;
    }

    private void ctM() {
        if (this.jgr != null) {
            this.gGF.add(this.jgr);
        } else if (this.mUserData != null) {
            this.jgr = new d();
            this.jgr.jgi = this.mUserData.getFansNum();
            this.jgr.jgj = this.mUserData.getConcern_num();
            this.jgr.jgk = this.mUserData.getLike_bars();
            this.jgr.threadNum = this.mUserData.getThreadNum();
            this.jgr.userData = this.mUserData;
            this.gGF.add(this.jgr);
        }
    }

    private void ctN() {
        if (this.jgy != null) {
            this.gGF.add(this.jgy);
            return;
        }
        this.jgy = new m();
        if (!v.isEmpty(this.jgp)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jgp.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jgp.get(i2));
                if (!aq.isEmpty(aVar.ctK())) {
                    this.jgy.jgp.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jgy.jgp.size() > 0) {
                this.gGF.add(this.jgy);
            }
        }
    }

    private void dQ(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jgz == null) {
                this.jgz = new j();
                this.gGF.add(this.jgz);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jgz.setData(arrayList);
        }
    }

    private void ctO() {
        if (this.jgt == null) {
            this.jgt = T(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jgt.jgA = true;
            this.jgt.jgD = new i();
        }
        this.gGF.add(this.jgt);
        g T = T(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        T.jgA = true;
        this.gGF.add(T);
        g T2 = T(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        T2.jgC = true;
        T2.jgA = true;
        this.gGF.add(T2);
        g T3 = T(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        T3.jgA = true;
        T3.jgD = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            T3.jgD.isShowRedTip = true;
        }
        T3.jgD.jgL = true;
        this.gGF.add(T3);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g T4 = T(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            T4.jgA = true;
            T4.cHN = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gGF.add(T4);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aDr().getInt("baidu_financial_display", 1) == 1) {
            g T5 = T(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            T5.jgA = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aDr().getBoolean("key_baidu_financial_has_clicked", false)) {
                T5.jgD = new i();
                T5.jgD.isShowRedTip = true;
            }
            this.gGF.add(T5);
        }
        if (this.jgo != null && this.jgo.is_end.intValue() != 1) {
            g T6 = T(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            T6.jgA = true;
            T6.cHN = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jgo.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                T6.jgD = iVar;
            }
            this.gGF.add(T6);
        }
        if (MissionEntranceSwitch.isOn()) {
            g T7 = T(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            T7.jgA = true;
            this.gGF.add(T7);
        }
        g T8 = T(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        T8.jgA = true;
        this.gGF.add(T8);
        this.jgu = T(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jgu.jgD = new i();
        this.jgu.jgA = true;
        this.jgu.jgD.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jgu.jgD.jgI = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gGF.add(this.jgu);
        g T9 = T(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        T9.jgA = true;
        this.gGF.add(T9);
        g T10 = T(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        T10.jgA = true;
        if (this.mUserData.membershipInfo != null) {
            T10.cHN = this.mUserData.membershipInfo.mLink;
        }
        this.gGF.add(T10);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jgv = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jgv.jgC = true;
            this.jgv.jgD = new i();
            this.gGF.add(this.jgv);
            TiebaStatic.log(new an("c12597"));
        } else {
            T10.jgC = true;
        }
        g T11 = T(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        T11.jgA = true;
        this.gGF.add(T11);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g T12 = T(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            T12.jgA = true;
            T12.jgC = true;
            this.gGF.add(T12);
        }
        this.jgw = T(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jgw.jgC = true;
        this.jgw.jgA = true;
        this.gGF.add(this.jgw);
        g T13 = T(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        T13.jgA = true;
        this.gGF.add(T13);
        if (this.jfG == null) {
            this.jfG = new PersonMoreData();
        }
        g T14 = T(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        T14.jgA = true;
        T14.jgB = true;
        T14.jgE = OrmObject.bundleWithObject(this.jfG);
        T14.jgD = new i();
        List<PersonMoreItemData> list = this.jfG.mUrlMaps;
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
                T14.jgD.jgH = getString(R.string.person_center_more_desc, sb.toString());
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
        if (this.jgt != null) {
            if (this.jgt.jgD == null) {
                this.jgt.jgD = new i();
            }
            this.jgt.jgD.isShowRedTip = z;
        }
    }

    public void rf(boolean z) {
        if (this.jgw != null) {
            if (this.jgw.jgD == null) {
                this.jgw.jgD = new i();
            }
            this.jgw.jgD.isShowRedTip = z;
        }
    }

    public void rg(boolean z) {
        if (this.jgv != null) {
            if (this.jgv.jgD == null) {
                this.jgv.jgD = new i();
            }
            this.jgv.jgD.isShowRedTip = z;
        }
    }

    public void rh(boolean z) {
        if (this.jgr != null) {
            this.jgr.jgl = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jgx = new h();
            this.jgp = profileResIdl.data.banner;
            this.jgo = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dR(profileResIdl.data.url_map);
            this.gGF.add(this.jgx);
            ctM();
            dQ(profileResIdl.data.recom_swan_list);
            ctN();
            ctO();
            com.baidu.tieba.o.a.cCk().sg(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jgx = new h();
            this.jgx.userData = this.mUserData;
            this.gGF.add(this.jgx);
            ctM();
            ctO();
            com.baidu.tieba.o.a.cCk().sg(true);
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
        if (this.jgq == null && userGodInfo != null) {
            this.jgq = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jgq.parserProtobuf(userGodInfo);
        }
        this.jgx.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jgs = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dR(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jfG = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jfG.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
