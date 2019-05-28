package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
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
    public ArrayList<com.baidu.adp.widget.ListView.m> fIX = new ArrayList<>();
    public PersonMoreData icY;
    private List<BannerImage> idH;
    private PersonUserGodInfo idI;
    public com.baidu.tieba.person.data.d idJ;
    public g idK;
    public g idL;
    public g idM;
    public g idN;
    public h idO;
    public m idP;
    public j idQ;
    private d idR;
    private UserData mUserData;

    private void bYq() {
        if (this.idR != null) {
            this.fIX.add(this.idR);
        } else if (this.mUserData != null) {
            this.idR = new d();
            this.idR.idB = this.mUserData.getFansNum();
            this.idR.idC = this.mUserData.getConcern_num();
            this.idR.idD = this.mUserData.getLike_bars();
            this.idR.threadNum = this.mUserData.getThreadNum();
            this.idR.userData = this.mUserData;
            this.fIX.add(this.idR);
        }
    }

    private void bYr() {
        if (this.idP != null) {
            this.fIX.add(this.idP);
            return;
        }
        this.idP = new m();
        if (!v.aa(this.idH)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.idH.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.idH.get(i2));
                if (!ap.isEmpty(aVar.bYp())) {
                    this.idP.idH.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.idP.idH.size() > 0) {
                this.fIX.add(this.idP);
            }
        }
    }

    private void bYs() {
        this.fIX.add(new e());
    }

    private void dN(List<SmartApp> list) {
        if (!v.aa(list)) {
            if (this.idQ == null) {
                this.idQ = new j();
                this.fIX.add(this.idQ);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.idQ.setData(arrayList);
        }
    }

    private void bYt() {
        if (this.idK == null) {
            this.idK = aa(R.drawable.icon_mine_list_collect, R.string.my_mark, 16);
            this.idK.idT = new i();
        }
        this.fIX.add(this.idK);
        this.fIX.add(aa(R.drawable.icon_mine_list_history, R.string.my_history, 17));
        g aa = aa(R.drawable.icon_mine_list_friend, R.string.my_groups, 22);
        aa.idS = true;
        this.fIX.add(aa);
        g aa2 = aa(R.drawable.borrow_cash, R.string.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_has_borrow_cash_clicked", false)) {
            aa2.idT = new i();
            aa2.idT.isShowRedTip = true;
        }
        this.fIX.add(aa2);
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("baidu_financial_display", 1) == 1) {
            g aa3 = aa(R.drawable.icon_mine_list_finance, R.string.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_baidu_financial_has_clicked", false)) {
                aa3.idT = new i();
                aa3.idT.isShowRedTip = true;
            }
            this.fIX.add(aa3);
        }
        if (ao.iE()) {
            this.fIX.add(aa(R.drawable.icon_mine_task_n, R.string.person_task_center_entrance, 43));
        }
        this.fIX.add(aa(R.drawable.icon_mine_list_member, R.string.member_center, 12));
        this.idL = aa(R.drawable.icon_mine_list_gift, R.string.my_gift, 10);
        this.idL.idT = new i();
        this.idL.idT.idX = true;
        this.idL.idT.idY = this.mUserData.getTDouNum();
        this.fIX.add(this.idL);
        this.fIX.add(aa(R.drawable.icon_mine_list_card, R.string.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g aa4 = aa(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_has_my_redpacket_clicked", false)) {
                aa4.idT = new i();
                aa4.idT.isShowRedTip = true;
            }
            this.fIX.add(aa4);
        }
        g aa5 = aa(R.drawable.icon_mine_list_grade, R.string.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            aa5.bCP = this.mUserData.membershipInfo.mLink;
        }
        this.fIX.add(aa5);
        boolean akM = TbadkCoreApplication.getInst().getActivityPrizeData().akM();
        String akN = TbadkCoreApplication.getInst().getActivityPrizeData().akN();
        if (akM && !StringUtils.isNull(akN)) {
            this.idM = g(R.drawable.icon_mine_list_logingift, akN, 38);
            this.idM.idS = true;
            this.idM.idT = new i();
            this.fIX.add(this.idM);
            TiebaStatic.log(new am("c12597"));
        } else {
            aa5.idS = true;
        }
        this.fIX.add(aa(R.drawable.icon_mine_list_hot, R.string.hot_topic, 30));
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            this.fIX.add(aa(R.drawable.icon_me_game_n, R.string.lite_game, 44));
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            g aa6 = aa(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            aa6.idS = true;
            this.fIX.add(aa6);
        }
        this.idN = aa(R.drawable.icon_mine_list_service, R.string.person_service_centre, 31);
        this.idN.idS = true;
        this.fIX.add(this.idN);
        this.fIX.add(aa(R.drawable.icon_mine_bdcard_72, R.string.baidu_singkil, 39));
        g aa7 = aa(R.drawable.icon_mine_list_more, R.string.more, 33);
        aa7.idT = new i();
        aa7.idT.idZ = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.icY == null) {
            this.icY = new PersonMoreData();
        }
        aa7.idU = OrmObject.bundleWithObject(this.icY);
        aa7.idS = true;
        this.fIX.add(aa7);
    }

    private g aa(int i, int i2, int i3) {
        g gVar = new g();
        gVar.iconId = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g g(int i, String str, int i2) {
        g gVar = new g();
        gVar.iconId = i;
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

    public void pn(boolean z) {
        if (this.idK != null) {
            if (this.idK.idT == null) {
                this.idK.idT = new i();
            }
            this.idK.idT.isShowRedTip = z;
        }
    }

    public void po(boolean z) {
        if (this.idN != null) {
            if (this.idN.idT == null) {
                this.idN.idT = new i();
            }
            this.idN.idT.isShowRedTip = z;
        }
    }

    public void pp(boolean z) {
        if (this.idM != null) {
            if (this.idM.idT == null) {
                this.idM.idT = new i();
            }
            this.idM.idT.isShowRedTip = z;
        }
    }

    public void pq(boolean z) {
        if (this.idR != null) {
            this.idR.idE = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.idO = new h();
            this.idH = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dO(profileResIdl.data.url_map);
            this.fIX.add(this.idO);
            bYq();
            bYs();
            dN(profileResIdl.data.recom_swan_list);
            bYr();
            bYt();
            com.baidu.tieba.o.a.cfZ().qi(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.idO = new h();
            this.idO.userData = this.mUserData;
            this.fIX.add(this.idO);
            bYq();
            bYt();
            com.baidu.tieba.o.a.cfZ().qi(true);
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
        if (this.idI == null && userGodInfo != null) {
            this.idI = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.idI.parserProtobuf(userGodInfo);
        }
        this.idO.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.idJ = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dO(List<UserMap> list) {
        if (!v.aa(list)) {
            this.icY = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.icY.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
