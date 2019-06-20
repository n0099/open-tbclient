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
    public ArrayList<com.baidu.adp.widget.ListView.m> fIZ = new ArrayList<>();
    public PersonMoreData icZ;
    private List<BannerImage> idI;
    private PersonUserGodInfo idJ;
    public com.baidu.tieba.person.data.d idK;
    public g idL;
    public g idM;
    public g idN;
    public g idO;
    public h idP;
    public m idQ;
    public j idR;
    private d idS;
    private UserData mUserData;

    private void bYr() {
        if (this.idS != null) {
            this.fIZ.add(this.idS);
        } else if (this.mUserData != null) {
            this.idS = new d();
            this.idS.idC = this.mUserData.getFansNum();
            this.idS.idD = this.mUserData.getConcern_num();
            this.idS.idE = this.mUserData.getLike_bars();
            this.idS.threadNum = this.mUserData.getThreadNum();
            this.idS.userData = this.mUserData;
            this.fIZ.add(this.idS);
        }
    }

    private void bYs() {
        if (this.idQ != null) {
            this.fIZ.add(this.idQ);
            return;
        }
        this.idQ = new m();
        if (!v.aa(this.idI)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.idI.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.idI.get(i2));
                if (!ap.isEmpty(aVar.bYq())) {
                    this.idQ.idI.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.idQ.idI.size() > 0) {
                this.fIZ.add(this.idQ);
            }
        }
    }

    private void bYt() {
        this.fIZ.add(new e());
    }

    private void dN(List<SmartApp> list) {
        if (!v.aa(list)) {
            if (this.idR == null) {
                this.idR = new j();
                this.fIZ.add(this.idR);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.idR.setData(arrayList);
        }
    }

    private void bYu() {
        if (this.idL == null) {
            this.idL = aa(R.drawable.icon_mine_list_collect, R.string.my_mark, 16);
            this.idL.idU = new i();
        }
        this.fIZ.add(this.idL);
        this.fIZ.add(aa(R.drawable.icon_mine_list_history, R.string.my_history, 17));
        g aa = aa(R.drawable.icon_mine_list_friend, R.string.my_groups, 22);
        aa.idT = true;
        this.fIZ.add(aa);
        g aa2 = aa(R.drawable.borrow_cash, R.string.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_has_borrow_cash_clicked", false)) {
            aa2.idU = new i();
            aa2.idU.isShowRedTip = true;
        }
        this.fIZ.add(aa2);
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("baidu_financial_display", 1) == 1) {
            g aa3 = aa(R.drawable.icon_mine_list_finance, R.string.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_baidu_financial_has_clicked", false)) {
                aa3.idU = new i();
                aa3.idU.isShowRedTip = true;
            }
            this.fIZ.add(aa3);
        }
        if (ao.iE()) {
            this.fIZ.add(aa(R.drawable.icon_mine_task_n, R.string.person_task_center_entrance, 43));
        }
        this.fIZ.add(aa(R.drawable.icon_mine_list_member, R.string.member_center, 12));
        this.idM = aa(R.drawable.icon_mine_list_gift, R.string.my_gift, 10);
        this.idM.idU = new i();
        this.idM.idU.idY = true;
        this.idM.idU.idZ = this.mUserData.getTDouNum();
        this.fIZ.add(this.idM);
        this.fIZ.add(aa(R.drawable.icon_mine_list_card, R.string.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g aa4 = aa(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_has_my_redpacket_clicked", false)) {
                aa4.idU = new i();
                aa4.idU.isShowRedTip = true;
            }
            this.fIZ.add(aa4);
        }
        g aa5 = aa(R.drawable.icon_mine_list_grade, R.string.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            aa5.bCQ = this.mUserData.membershipInfo.mLink;
        }
        this.fIZ.add(aa5);
        boolean akM = TbadkCoreApplication.getInst().getActivityPrizeData().akM();
        String akN = TbadkCoreApplication.getInst().getActivityPrizeData().akN();
        if (akM && !StringUtils.isNull(akN)) {
            this.idN = g(R.drawable.icon_mine_list_logingift, akN, 38);
            this.idN.idT = true;
            this.idN.idU = new i();
            this.fIZ.add(this.idN);
            TiebaStatic.log(new am("c12597"));
        } else {
            aa5.idT = true;
        }
        this.fIZ.add(aa(R.drawable.icon_mine_list_hot, R.string.hot_topic, 30));
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            this.fIZ.add(aa(R.drawable.icon_me_game_n, R.string.lite_game, 44));
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            g aa6 = aa(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            aa6.idT = true;
            this.fIZ.add(aa6);
        }
        this.idO = aa(R.drawable.icon_mine_list_service, R.string.person_service_centre, 31);
        this.idO.idT = true;
        this.fIZ.add(this.idO);
        this.fIZ.add(aa(R.drawable.icon_mine_bdcard_72, R.string.baidu_singkil, 39));
        g aa7 = aa(R.drawable.icon_mine_list_more, R.string.more, 33);
        aa7.idU = new i();
        aa7.idU.iea = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.icZ == null) {
            this.icZ = new PersonMoreData();
        }
        aa7.idV = OrmObject.bundleWithObject(this.icZ);
        aa7.idT = true;
        this.fIZ.add(aa7);
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

    public void po(boolean z) {
        if (this.idL != null) {
            if (this.idL.idU == null) {
                this.idL.idU = new i();
            }
            this.idL.idU.isShowRedTip = z;
        }
    }

    public void pp(boolean z) {
        if (this.idO != null) {
            if (this.idO.idU == null) {
                this.idO.idU = new i();
            }
            this.idO.idU.isShowRedTip = z;
        }
    }

    public void pq(boolean z) {
        if (this.idN != null) {
            if (this.idN.idU == null) {
                this.idN.idU = new i();
            }
            this.idN.idU.isShowRedTip = z;
        }
    }

    public void pr(boolean z) {
        if (this.idS != null) {
            this.idS.idF = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.idP = new h();
            this.idI = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dO(profileResIdl.data.url_map);
            this.fIZ.add(this.idP);
            bYr();
            bYt();
            dN(profileResIdl.data.recom_swan_list);
            bYs();
            bYu();
            com.baidu.tieba.o.a.cga().qj(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.idP = new h();
            this.idP.userData = this.mUserData;
            this.fIZ.add(this.idP);
            bYr();
            bYu();
            com.baidu.tieba.o.a.cga().qj(true);
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
        if (this.idJ == null && userGodInfo != null) {
            this.idJ = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.idJ.parserProtobuf(userGodInfo);
        }
        this.idP.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.idK = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dO(List<UserMap> list) {
        if (!v.aa(list)) {
            this.icZ = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.icZ.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
