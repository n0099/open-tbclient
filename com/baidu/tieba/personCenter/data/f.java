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
    public ArrayList<com.baidu.adp.widget.ListView.m> fOL = new ArrayList<>();
    private List<BannerImage> ikZ;
    public PersonMoreData ikt;
    private PersonUserGodInfo ila;
    public com.baidu.tieba.person.data.d ilb;
    public g ilc;
    public g ild;
    public g ile;
    public g ilf;
    public h ilg;
    public m ilh;
    public j ili;
    private d ilj;
    private UserData mUserData;

    private void cby() {
        if (this.ilj != null) {
            this.fOL.add(this.ilj);
        } else if (this.mUserData != null) {
            this.ilj = new d();
            this.ilj.ikT = this.mUserData.getFansNum();
            this.ilj.ikU = this.mUserData.getConcern_num();
            this.ilj.ikV = this.mUserData.getLike_bars();
            this.ilj.threadNum = this.mUserData.getThreadNum();
            this.ilj.userData = this.mUserData;
            this.fOL.add(this.ilj);
        }
    }

    private void cbz() {
        if (this.ilh != null) {
            this.fOL.add(this.ilh);
            return;
        }
        this.ilh = new m();
        if (!v.aa(this.ikZ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ikZ.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.ikZ.get(i2));
                if (!aq.isEmpty(aVar.cbx())) {
                    this.ilh.ikZ.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.ilh.ikZ.size() > 0) {
                this.fOL.add(this.ilh);
            }
        }
    }

    private void cbA() {
        this.fOL.add(new e());
    }

    private void dO(List<SmartApp> list) {
        if (!v.aa(list)) {
            if (this.ili == null) {
                this.ili = new j();
                this.fOL.add(this.ili);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.ili.setData(arrayList);
        }
    }

    private void cbB() {
        if (this.ilc == null) {
            this.ilc = ab(R.drawable.icon_mine_list_collect, R.string.my_mark, 16);
            this.ilc.ilm = new i();
        }
        this.fOL.add(this.ilc);
        this.fOL.add(ab(R.drawable.icon_mine_list_history, R.string.my_history, 17));
        g ab = ab(R.drawable.icon_mine_list_friend, R.string.my_groups, 22);
        ab.ill = true;
        this.fOL.add(ab);
        g ab2 = ab(R.drawable.borrow_cash, R.string.borrow_cash, 37);
        ab2.ilm = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_has_borrow_cash_clicked", false)) {
            ab2.ilm.isShowRedTip = true;
        }
        ab2.ilm.ilt = true;
        this.fOL.add(ab2);
        if (com.baidu.tbadk.core.sharedPref.b.ahQ().getInt("baidu_financial_display", 1) == 1) {
            g ab3 = ab(R.drawable.icon_mine_list_finance, R.string.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_baidu_financial_has_clicked", false)) {
                ab3.ilm = new i();
                ab3.ilm.isShowRedTip = true;
            }
            this.fOL.add(ab3);
        }
        if (ao.iN()) {
            this.fOL.add(ab(R.drawable.icon_mine_task_n, R.string.person_task_center_entrance, 43));
        }
        this.fOL.add(ab(R.drawable.icon_mine_list_member, R.string.member_center, 12));
        this.ild = ab(R.drawable.icon_mine_list_gift, R.string.my_gift, 10);
        this.ild.ilm = new i();
        this.ild.ilm.ilq = true;
        this.ild.ilm.ilr = this.mUserData.getTDouNum();
        this.fOL.add(this.ild);
        this.fOL.add(ab(R.drawable.icon_mine_list_card, R.string.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g ab4 = ab(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.ahQ().getBoolean("key_has_my_redpacket_clicked", false)) {
                ab4.ilm = new i();
                ab4.ilm.isShowRedTip = true;
            }
            this.fOL.add(ab4);
        }
        g ab5 = ab(R.drawable.icon_mine_list_grade, R.string.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ab5.bDN = this.mUserData.membershipInfo.mLink;
        }
        this.fOL.add(ab5);
        boolean alT = TbadkCoreApplication.getInst().getActivityPrizeData().alT();
        String alU = TbadkCoreApplication.getInst().getActivityPrizeData().alU();
        if (alT && !StringUtils.isNull(alU)) {
            this.ile = g(R.drawable.icon_mine_list_logingift, alU, 38);
            this.ile.ill = true;
            this.ile.ilm = new i();
            this.fOL.add(this.ile);
            TiebaStatic.log(new an("c12597"));
        } else {
            ab5.ill = true;
        }
        this.fOL.add(ab(R.drawable.icon_mine_list_hot, R.string.hot_topic, 30));
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            this.fOL.add(ab(R.drawable.icon_me_game_n, R.string.lite_game, 44));
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            g ab6 = ab(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            ab6.ill = true;
            this.fOL.add(ab6);
        }
        this.ilf = ab(R.drawable.icon_mine_list_service, R.string.person_service_centre, 31);
        this.ilf.ill = true;
        this.fOL.add(this.ilf);
        this.fOL.add(ab(R.drawable.icon_mine_bdcard_72, R.string.baidu_singkil, 39));
        g ab7 = ab(R.drawable.icon_mine_list_more, R.string.more, 33);
        ab7.ilm = new i();
        ab7.ilm.ils = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.ikt == null) {
            this.ikt = new PersonMoreData();
        }
        ab7.iln = OrmObject.bundleWithObject(this.ikt);
        ab7.ill = true;
        this.fOL.add(ab7);
    }

    private g ab(int i, int i2, int i3) {
        g gVar = new g();
        gVar.ilk = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g g(int i, String str, int i2) {
        g gVar = new g();
        gVar.ilk = i;
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

    public void pD(boolean z) {
        if (this.ilc != null) {
            if (this.ilc.ilm == null) {
                this.ilc.ilm = new i();
            }
            this.ilc.ilm.isShowRedTip = z;
        }
    }

    public void pE(boolean z) {
        if (this.ilf != null) {
            if (this.ilf.ilm == null) {
                this.ilf.ilm = new i();
            }
            this.ilf.ilm.isShowRedTip = z;
        }
    }

    public void pF(boolean z) {
        if (this.ile != null) {
            if (this.ile.ilm == null) {
                this.ile.ilm = new i();
            }
            this.ile.ilm.isShowRedTip = z;
        }
    }

    public void pG(boolean z) {
        if (this.ilj != null) {
            this.ilj.ikW = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ilg = new h();
            this.ikZ = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dP(profileResIdl.data.url_map);
            this.fOL.add(this.ilg);
            cby();
            cbA();
            dO(profileResIdl.data.recom_swan_list);
            cbz();
            cbB();
            com.baidu.tieba.o.a.cjj().qz(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ilg = new h();
            this.ilg.userData = this.mUserData;
            this.fOL.add(this.ilg);
            cby();
            cbB();
            com.baidu.tieba.o.a.cjj().qz(true);
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
        if (this.ila == null && userGodInfo != null) {
            this.ila = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ila.parserProtobuf(userGodInfo);
        }
        this.ilg.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.ilb = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dP(List<UserMap> list) {
        if (!v.aa(list)) {
            this.ikt = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ikt.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
