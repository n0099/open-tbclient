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
    public ArrayList<com.baidu.adp.widget.ListView.m> fNX = new ArrayList<>();
    private List<BannerImage> ijX;
    private PersonUserGodInfo ijY;
    public com.baidu.tieba.person.data.d ijZ;
    public PersonMoreData ijr;
    public g ika;
    public g ikb;
    public g ikc;
    public g ikd;
    public h ike;
    public m ikf;
    public j ikg;
    private d ikh;
    private UserData mUserData;

    private void cbg() {
        if (this.ikh != null) {
            this.fNX.add(this.ikh);
        } else if (this.mUserData != null) {
            this.ikh = new d();
            this.ikh.ijR = this.mUserData.getFansNum();
            this.ikh.ijS = this.mUserData.getConcern_num();
            this.ikh.ijT = this.mUserData.getLike_bars();
            this.ikh.threadNum = this.mUserData.getThreadNum();
            this.ikh.userData = this.mUserData;
            this.fNX.add(this.ikh);
        }
    }

    private void cbh() {
        if (this.ikf != null) {
            this.fNX.add(this.ikf);
            return;
        }
        this.ikf = new m();
        if (!v.aa(this.ijX)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ijX.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.ijX.get(i2));
                if (!aq.isEmpty(aVar.cbf())) {
                    this.ikf.ijX.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.ikf.ijX.size() > 0) {
                this.fNX.add(this.ikf);
            }
        }
    }

    private void cbi() {
        this.fNX.add(new e());
    }

    private void dP(List<SmartApp> list) {
        if (!v.aa(list)) {
            if (this.ikg == null) {
                this.ikg = new j();
                this.fNX.add(this.ikg);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.ikg.setData(arrayList);
        }
    }

    private void cbj() {
        if (this.ika == null) {
            this.ika = ab(R.drawable.icon_mine_list_collect, R.string.my_mark, 16);
            this.ika.ikk = new i();
        }
        this.fNX.add(this.ika);
        this.fNX.add(ab(R.drawable.icon_mine_list_history, R.string.my_history, 17));
        g ab = ab(R.drawable.icon_mine_list_friend, R.string.my_groups, 22);
        ab.ikj = true;
        this.fNX.add(ab);
        g ab2 = ab(R.drawable.borrow_cash, R.string.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_has_borrow_cash_clicked", false)) {
            ab2.ikk = new i();
            ab2.ikk.isShowRedTip = true;
        }
        this.fNX.add(ab2);
        if (com.baidu.tbadk.core.sharedPref.b.ahO().getInt("baidu_financial_display", 1) == 1) {
            g ab3 = ab(R.drawable.icon_mine_list_finance, R.string.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_baidu_financial_has_clicked", false)) {
                ab3.ikk = new i();
                ab3.ikk.isShowRedTip = true;
            }
            this.fNX.add(ab3);
        }
        if (ao.iN()) {
            this.fNX.add(ab(R.drawable.icon_mine_task_n, R.string.person_task_center_entrance, 43));
        }
        this.fNX.add(ab(R.drawable.icon_mine_list_member, R.string.member_center, 12));
        this.ikb = ab(R.drawable.icon_mine_list_gift, R.string.my_gift, 10);
        this.ikb.ikk = new i();
        this.ikb.ikk.iko = true;
        this.ikb.ikk.ikp = this.mUserData.getTDouNum();
        this.fNX.add(this.ikb);
        this.fNX.add(ab(R.drawable.icon_mine_list_card, R.string.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g ab4 = ab(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("key_has_my_redpacket_clicked", false)) {
                ab4.ikk = new i();
                ab4.ikk.isShowRedTip = true;
            }
            this.fNX.add(ab4);
        }
        g ab5 = ab(R.drawable.icon_mine_list_grade, R.string.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ab5.bDN = this.mUserData.membershipInfo.mLink;
        }
        this.fNX.add(ab5);
        boolean alR = TbadkCoreApplication.getInst().getActivityPrizeData().alR();
        String alS = TbadkCoreApplication.getInst().getActivityPrizeData().alS();
        if (alR && !StringUtils.isNull(alS)) {
            this.ikc = g(R.drawable.icon_mine_list_logingift, alS, 38);
            this.ikc.ikj = true;
            this.ikc.ikk = new i();
            this.fNX.add(this.ikc);
            TiebaStatic.log(new an("c12597"));
        } else {
            ab5.ikj = true;
        }
        this.fNX.add(ab(R.drawable.icon_mine_list_hot, R.string.hot_topic, 30));
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            this.fNX.add(ab(R.drawable.icon_me_game_n, R.string.lite_game, 44));
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            g ab6 = ab(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            ab6.ikj = true;
            this.fNX.add(ab6);
        }
        this.ikd = ab(R.drawable.icon_mine_list_service, R.string.person_service_centre, 31);
        this.ikd.ikj = true;
        this.fNX.add(this.ikd);
        this.fNX.add(ab(R.drawable.icon_mine_bdcard_72, R.string.baidu_singkil, 39));
        g ab7 = ab(R.drawable.icon_mine_list_more, R.string.more, 33);
        ab7.ikk = new i();
        ab7.ikk.ikq = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.ijr == null) {
            this.ijr = new PersonMoreData();
        }
        ab7.ikl = OrmObject.bundleWithObject(this.ijr);
        ab7.ikj = true;
        this.fNX.add(ab7);
    }

    private g ab(int i, int i2, int i3) {
        g gVar = new g();
        gVar.iki = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g g(int i, String str, int i2) {
        g gVar = new g();
        gVar.iki = i;
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

    public void pC(boolean z) {
        if (this.ika != null) {
            if (this.ika.ikk == null) {
                this.ika.ikk = new i();
            }
            this.ika.ikk.isShowRedTip = z;
        }
    }

    public void pD(boolean z) {
        if (this.ikd != null) {
            if (this.ikd.ikk == null) {
                this.ikd.ikk = new i();
            }
            this.ikd.ikk.isShowRedTip = z;
        }
    }

    public void pE(boolean z) {
        if (this.ikc != null) {
            if (this.ikc.ikk == null) {
                this.ikc.ikk = new i();
            }
            this.ikc.ikk.isShowRedTip = z;
        }
    }

    public void pF(boolean z) {
        if (this.ikh != null) {
            this.ikh.ijU = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ike = new h();
            this.ijX = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dQ(profileResIdl.data.url_map);
            this.fNX.add(this.ike);
            cbg();
            cbi();
            dP(profileResIdl.data.recom_swan_list);
            cbh();
            cbj();
            com.baidu.tieba.o.a.ciR().qy(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ike = new h();
            this.ike.userData = this.mUserData;
            this.fNX.add(this.ike);
            cbg();
            cbj();
            com.baidu.tieba.o.a.ciR().qy(true);
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
        if (this.ijY == null && userGodInfo != null) {
            this.ijY = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ijY.parserProtobuf(userGodInfo);
        }
        this.ike.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.ijZ = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dQ(List<UserMap> list) {
        if (!v.aa(list)) {
            this.ijr = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ijr.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
