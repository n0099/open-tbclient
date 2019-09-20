package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.t.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes4.dex */
public class f implements com.baidu.tieba.person.b {
    public ArrayList<com.baidu.adp.widget.ListView.m> fQB = new ArrayList<>();
    private List<BannerImage> imZ;
    public PersonMoreData imt;
    private PersonUserGodInfo ina;
    public com.baidu.tieba.person.data.d inb;
    public g inc;
    public g ind;
    public g ine;
    public g inf;
    public h ing;
    public m inh;
    public j ini;
    private d inj;
    private UserData mUserData;

    private void ccm() {
        if (this.inj != null) {
            this.fQB.add(this.inj);
        } else if (this.mUserData != null) {
            this.inj = new d();
            this.inj.imT = this.mUserData.getFansNum();
            this.inj.imU = this.mUserData.getConcern_num();
            this.inj.imV = this.mUserData.getLike_bars();
            this.inj.threadNum = this.mUserData.getThreadNum();
            this.inj.userData = this.mUserData;
            this.fQB.add(this.inj);
        }
    }

    private void ccn() {
        if (this.inh != null) {
            this.fQB.add(this.inh);
            return;
        }
        this.inh = new m();
        if (!v.aa(this.imZ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.imZ.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.imZ.get(i2));
                if (!aq.isEmpty(aVar.ccl())) {
                    this.inh.imZ.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.inh.imZ.size() > 0) {
                this.fQB.add(this.inh);
            }
        }
    }

    private void cco() {
        this.fQB.add(new e());
    }

    private void dO(List<SmartApp> list) {
        if (!v.aa(list)) {
            if (this.ini == null) {
                this.ini = new j();
                this.fQB.add(this.ini);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.ini.setData(arrayList);
        }
    }

    private void ccp() {
        if (this.inc == null) {
            this.inc = ac(R.drawable.icon_pure_wo_list_collect_n_svg, R.string.my_mark, 16);
            this.inc.inl = true;
            this.inc.inn = new i();
        }
        this.fQB.add(this.inc);
        g ac = ac(R.drawable.icon_pure_wo_list_history_n_svg, R.string.my_history, 17);
        ac.inl = true;
        this.fQB.add(ac);
        g ac2 = ac(R.drawable.icon_pure_wo_list_group_n_svg, R.string.my_groups, 22);
        ac2.inm = true;
        ac2.inl = true;
        this.fQB.add(ac2);
        g ac3 = ac(R.drawable.icon_pure_wo_list_youqianhua_n_svg, R.string.borrow_cash, 37);
        ac3.inl = true;
        ac3.inn = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_has_borrow_cash_clicked", false)) {
            ac3.inn.isShowRedTip = true;
        }
        ac3.inn.inv = true;
        this.fQB.add(ac3);
        if (com.baidu.tbadk.core.sharedPref.b.ahU().getInt("baidu_financial_display", 1) == 1) {
            g ac4 = ac(R.drawable.icon_pure_wo_list_duxiaoman_n_svg, R.string.baidu_financial, 41);
            ac4.inl = true;
            if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_baidu_financial_has_clicked", false)) {
                ac4.inn = new i();
                ac4.inn.isShowRedTip = true;
            }
            this.fQB.add(ac4);
        }
        if (ao.iN()) {
            g ac5 = ac(R.drawable.icon_pure_wo_list_task_n_svg, R.string.person_task_center_entrance, 43);
            ac5.inl = true;
            this.fQB.add(ac5);
        }
        g ac6 = ac(R.drawable.icon_pure_wo_list_member_n_svg, R.string.member_center, 12);
        ac6.inl = true;
        this.fQB.add(ac6);
        this.ind = ac(R.drawable.icon_pure_wo_list_gift_n_svg, R.string.my_gift, 10);
        this.ind.inn = new i();
        this.ind.inl = true;
        this.ind.inn.inr = true;
        this.ind.inn.f0int = this.mUserData.getTDouNum();
        this.fQB.add(this.ind);
        g ac7 = ac(R.drawable.icon_pure_wo_list_cardbag_n_svg, R.string.card_box, 18);
        ac7.inl = true;
        this.fQB.add(ac7);
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g ac8 = ac(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.ahU().getBoolean("key_has_my_redpacket_clicked", false)) {
                ac8.inn = new i();
                ac8.inn.isShowRedTip = true;
            }
            this.fQB.add(ac8);
        }
        g ac9 = ac(R.drawable.icon_pure_wo_list_diamond_n_svg, R.string.blue_diamond, 11);
        ac9.inl = true;
        if (this.mUserData.membershipInfo != null) {
            ac9.bEl = this.mUserData.membershipInfo.mLink;
        }
        this.fQB.add(ac9);
        boolean amf = TbadkCoreApplication.getInst().getActivityPrizeData().amf();
        String amg = TbadkCoreApplication.getInst().getActivityPrizeData().amg();
        if (amf && !StringUtils.isNull(amg)) {
            this.ine = g(R.drawable.icon_mine_list_logingift, amg, 38);
            this.ine.inm = true;
            this.ine.inn = new i();
            this.fQB.add(this.ine);
            TiebaStatic.log(new an("c12597"));
        } else {
            ac9.inm = true;
        }
        g ac10 = ac(R.drawable.icon_pure_wo_list_topic_n_svg, R.string.hot_topic, 30);
        ac10.inl = true;
        this.fQB.add(ac10);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g ac11 = ac(R.drawable.icon_pure_wo_list_game_n_svg, R.string.lite_game, 44);
            ac11.inl = true;
            this.fQB.add(ac11);
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            g ac12 = ac(R.drawable.icon_pure_wo_list_live_n_svg, R.string.ala_live, 25);
            ac12.inl = true;
            ac12.inm = true;
            this.fQB.add(ac12);
        }
        this.inf = ac(R.drawable.icon_pure_wo_list_serve_n_svg, R.string.person_service_centre, 31);
        this.inf.inm = true;
        this.inf.inl = true;
        this.fQB.add(this.inf);
        g ac13 = ac(R.drawable.icon_pure_wo_list_exempt_n_svg, R.string.baidu_singkil, 39);
        ac13.inl = true;
        this.fQB.add(ac13);
        g ac14 = ac(R.drawable.icon_pure_wo_list_more_n_svg, R.string.more, 33);
        ac14.inl = true;
        ac14.inn = new i();
        ac14.inn.inu = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.imt == null) {
            this.imt = new PersonMoreData();
        }
        ac14.ino = OrmObject.bundleWithObject(this.imt);
        this.fQB.add(ac14);
    }

    private g ac(int i, int i2, int i3) {
        g gVar = new g();
        gVar.ink = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g g(int i, String str, int i2) {
        g gVar = new g();
        gVar.ink = i;
        gVar.title = str;
        gVar.type = i2;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        this.mUserData.setPendantData(lVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void pG(boolean z) {
        if (this.inc != null) {
            if (this.inc.inn == null) {
                this.inc.inn = new i();
            }
            this.inc.inn.isShowRedTip = z;
        }
    }

    public void pH(boolean z) {
        if (this.inf != null) {
            if (this.inf.inn == null) {
                this.inf.inn = new i();
            }
            this.inf.inn.isShowRedTip = z;
        }
    }

    public void pI(boolean z) {
        if (this.ine != null) {
            if (this.ine.inn == null) {
                this.ine.inn = new i();
            }
            this.ine.inn.isShowRedTip = z;
        }
    }

    public void pJ(boolean z) {
        if (this.inj != null) {
            this.inj.imW = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ing = new h();
            this.imZ = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dP(profileResIdl.data.url_map);
            this.fQB.add(this.ing);
            ccm();
            cco();
            dO(profileResIdl.data.recom_swan_list);
            ccn();
            ccp();
            com.baidu.tieba.o.a.cjV().qC(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ing = new h();
            this.ing.userData = this.mUserData;
            this.fQB.add(this.ing);
            ccm();
            ccp();
            com.baidu.tieba.o.a.cjV().qC(true);
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
        if (this.ina == null && userGodInfo != null) {
            this.ina = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ina.parserProtobuf(userGodInfo);
        }
        this.ing.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.inb = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dP(List<UserMap> list) {
        if (!v.aa(list)) {
            this.imt = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.imt.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
