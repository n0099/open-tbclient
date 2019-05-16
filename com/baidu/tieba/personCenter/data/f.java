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
    public ArrayList<com.baidu.adp.widget.ListView.m> fIW = new ArrayList<>();
    public PersonMoreData icV;
    private List<BannerImage> idE;
    private PersonUserGodInfo idF;
    public com.baidu.tieba.person.data.d idG;
    public g idH;
    public g idI;
    public g idJ;
    public g idK;
    public h idL;
    public m idM;
    public j idN;
    private d idO;
    private UserData mUserData;

    private void bYn() {
        if (this.idO != null) {
            this.fIW.add(this.idO);
        } else if (this.mUserData != null) {
            this.idO = new d();
            this.idO.idy = this.mUserData.getFansNum();
            this.idO.idz = this.mUserData.getConcern_num();
            this.idO.idA = this.mUserData.getLike_bars();
            this.idO.threadNum = this.mUserData.getThreadNum();
            this.idO.userData = this.mUserData;
            this.fIW.add(this.idO);
        }
    }

    private void bYo() {
        if (this.idM != null) {
            this.fIW.add(this.idM);
            return;
        }
        this.idM = new m();
        if (!v.aa(this.idE)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.idE.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.idE.get(i2));
                if (!ap.isEmpty(aVar.bYm())) {
                    this.idM.idE.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.idM.idE.size() > 0) {
                this.fIW.add(this.idM);
            }
        }
    }

    private void bYp() {
        this.fIW.add(new e());
    }

    private void dN(List<SmartApp> list) {
        if (!v.aa(list)) {
            if (this.idN == null) {
                this.idN = new j();
                this.fIW.add(this.idN);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.idN.setData(arrayList);
        }
    }

    private void bYq() {
        if (this.idH == null) {
            this.idH = aa(R.drawable.icon_mine_list_collect, R.string.my_mark, 16);
            this.idH.idQ = new i();
        }
        this.fIW.add(this.idH);
        this.fIW.add(aa(R.drawable.icon_mine_list_history, R.string.my_history, 17));
        g aa = aa(R.drawable.icon_mine_list_friend, R.string.my_groups, 22);
        aa.idP = true;
        this.fIW.add(aa);
        g aa2 = aa(R.drawable.borrow_cash, R.string.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_has_borrow_cash_clicked", false)) {
            aa2.idQ = new i();
            aa2.idQ.isShowRedTip = true;
        }
        this.fIW.add(aa2);
        if (com.baidu.tbadk.core.sharedPref.b.agM().getInt("baidu_financial_display", 1) == 1) {
            g aa3 = aa(R.drawable.icon_mine_list_finance, R.string.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_baidu_financial_has_clicked", false)) {
                aa3.idQ = new i();
                aa3.idQ.isShowRedTip = true;
            }
            this.fIW.add(aa3);
        }
        if (ao.iE()) {
            this.fIW.add(aa(R.drawable.icon_mine_task_n, R.string.person_task_center_entrance, 43));
        }
        this.fIW.add(aa(R.drawable.icon_mine_list_member, R.string.member_center, 12));
        this.idI = aa(R.drawable.icon_mine_list_gift, R.string.my_gift, 10);
        this.idI.idQ = new i();
        this.idI.idQ.idU = true;
        this.idI.idQ.idV = this.mUserData.getTDouNum();
        this.fIW.add(this.idI);
        this.fIW.add(aa(R.drawable.icon_mine_list_card, R.string.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g aa4 = aa(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.agM().getBoolean("key_has_my_redpacket_clicked", false)) {
                aa4.idQ = new i();
                aa4.idQ.isShowRedTip = true;
            }
            this.fIW.add(aa4);
        }
        g aa5 = aa(R.drawable.icon_mine_list_grade, R.string.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            aa5.bCP = this.mUserData.membershipInfo.mLink;
        }
        this.fIW.add(aa5);
        boolean akM = TbadkCoreApplication.getInst().getActivityPrizeData().akM();
        String akN = TbadkCoreApplication.getInst().getActivityPrizeData().akN();
        if (akM && !StringUtils.isNull(akN)) {
            this.idJ = g(R.drawable.icon_mine_list_logingift, akN, 38);
            this.idJ.idP = true;
            this.idJ.idQ = new i();
            this.fIW.add(this.idJ);
            TiebaStatic.log(new am("c12597"));
        } else {
            aa5.idP = true;
        }
        this.fIW.add(aa(R.drawable.icon_mine_list_hot, R.string.hot_topic, 30));
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            this.fIW.add(aa(R.drawable.icon_me_game_n, R.string.lite_game, 44));
        }
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            g aa6 = aa(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            aa6.idP = true;
            this.fIW.add(aa6);
        }
        this.idK = aa(R.drawable.icon_mine_list_service, R.string.person_service_centre, 31);
        this.idK.idP = true;
        this.fIW.add(this.idK);
        this.fIW.add(aa(R.drawable.icon_mine_bdcard_72, R.string.baidu_singkil, 39));
        g aa7 = aa(R.drawable.icon_mine_list_more, R.string.more, 33);
        aa7.idQ = new i();
        aa7.idQ.idW = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.icV == null) {
            this.icV = new PersonMoreData();
        }
        aa7.idR = OrmObject.bundleWithObject(this.icV);
        aa7.idP = true;
        this.fIW.add(aa7);
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
        if (this.idH != null) {
            if (this.idH.idQ == null) {
                this.idH.idQ = new i();
            }
            this.idH.idQ.isShowRedTip = z;
        }
    }

    public void po(boolean z) {
        if (this.idK != null) {
            if (this.idK.idQ == null) {
                this.idK.idQ = new i();
            }
            this.idK.idQ.isShowRedTip = z;
        }
    }

    public void pp(boolean z) {
        if (this.idJ != null) {
            if (this.idJ.idQ == null) {
                this.idJ.idQ = new i();
            }
            this.idJ.idQ.isShowRedTip = z;
        }
    }

    public void pq(boolean z) {
        if (this.idO != null) {
            this.idO.idB = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.idL = new h();
            this.idE = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dO(profileResIdl.data.url_map);
            this.fIW.add(this.idL);
            bYn();
            bYp();
            dN(profileResIdl.data.recom_swan_list);
            bYo();
            bYq();
            com.baidu.tieba.o.a.cfX().qi(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.idL = new h();
            this.idL.userData = this.mUserData;
            this.fIW.add(this.idL);
            bYn();
            bYq();
            com.baidu.tieba.o.a.cfX().qi(true);
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
        if (this.idF == null && userGodInfo != null) {
            this.idF = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.idF.parserProtobuf(userGodInfo);
        }
        this.idL.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.idG = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dO(List<UserMap> list) {
        if (!v.aa(list)) {
            this.icV = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.icV.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
