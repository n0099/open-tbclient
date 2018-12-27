package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.e;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes5.dex */
public class e implements com.baidu.tieba.person.b {
    public ArrayList<com.baidu.adp.widget.ListView.h> edS = new ArrayList<>();
    public PersonMoreData gtT;
    public com.baidu.tieba.person.data.d guA;
    public f guB;
    public f guC;
    public f guD;
    public f guE;
    public g guF;
    public i guG;
    private c guH;
    private List<BannerImage> guy;
    private PersonUserGodInfo guz;
    private UserData mUserData;

    private void bpq() {
        if (this.guH != null) {
            this.edS.add(this.guH);
        } else if (this.mUserData != null) {
            this.guH = new c();
            this.guH.gus = this.mUserData.getFansNum();
            this.guH.gut = this.mUserData.getConcern_num();
            this.guH.guu = this.mUserData.getLike_bars();
            this.guH.threadNum = this.mUserData.getThreadNum();
            this.guH.fSM = this.mUserData;
            this.edS.add(this.guH);
        }
    }

    private void bpr() {
        if (this.guG != null) {
            this.edS.add(this.guG);
            return;
        }
        this.guG = new i();
        if (!v.I(this.guy)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.guy.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.guy.get(i2));
                if (!ao.isEmpty(aVar.aJh())) {
                    this.guG.guy.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.guG.guy.size() > 0) {
                this.edS.add(this.guG);
            }
        }
    }

    private void bps() {
        this.edS.add(new d());
    }

    private void bpt() {
        if (this.guB == null) {
            this.guB = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.guB.guJ = new h();
        }
        this.edS.add(this.guB);
        this.edS.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.guI = true;
        this.edS.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.guJ = new h();
            W2.guJ.guN = true;
        }
        this.edS.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.guJ = new h();
                W3.guJ.guN = true;
            }
            this.edS.add(W3);
        }
        this.edS.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.guC = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.guC.guJ = new h();
        this.guC.guJ.guO = true;
        this.guC.guJ.guP = this.mUserData.getTDouNum();
        this.edS.add(this.guC);
        this.edS.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f W4 = W(e.f.icon_mine_list_myredbag, e.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                W4.guJ = new h();
                W4.guJ.guN = true;
            }
            this.edS.add(W4);
        }
        f W5 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W5.aou = this.mUserData.membershipInfo.mLink;
        }
        this.edS.add(W5);
        boolean Gj = TbadkCoreApplication.getInst().getActivityPrizeData().Gj();
        String Gk = TbadkCoreApplication.getInst().getActivityPrizeData().Gk();
        if (Gj && !StringUtils.isNull(Gk)) {
            this.guD = f(e.f.icon_mine_list_logingift, Gk, 38);
            this.guD.guI = true;
            this.guD.guJ = new h();
            this.edS.add(this.guD);
            TiebaStatic.log(new am("c12597"));
        } else {
            W5.guI = true;
        }
        this.edS.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W6 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W6.guI = true;
            this.edS.add(W6);
        }
        this.guE = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.guE.guI = true;
        this.edS.add(this.guE);
        this.edS.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W7 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W7.guJ = new h();
        W7.guJ.guQ = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.gtT == null) {
            this.gtT = new PersonMoreData();
        }
        W7.guK = OrmObject.bundleWithObject(this.gtT);
        W7.guI = true;
        this.edS.add(W7);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fSM = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fSM = this.mUserData;
        }
        return fVar;
    }

    public void b(j jVar) {
        this.mUserData.setPendantData(jVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void mb(boolean z) {
        if (this.guB != null) {
            if (this.guB.guJ == null) {
                this.guB.guJ = new h();
            }
            this.guB.guJ.guN = z;
        }
    }

    public void mc(boolean z) {
        if (this.guE != null) {
            if (this.guE.guJ == null) {
                this.guE.guJ = new h();
            }
            this.guE.guJ.guN = z;
        }
    }

    public void md(boolean z) {
        if (this.guD != null) {
            if (this.guD.guJ == null) {
                this.guD.guJ = new h();
            }
            this.guD.guJ.guN = z;
        }
    }

    public void me(boolean z) {
        if (this.guH != null) {
            this.guH.guv = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.guF = new g();
            this.guy = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dt(profileResIdl.data.url_map);
            this.edS.add(this.guF);
            bpq();
            bps();
            bpr();
            bpt();
            com.baidu.tieba.o.a.bww().mT(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.guF = new g();
            this.guF.fSM = this.mUserData;
            this.edS.add(this.guF);
            bpq();
            bpt();
            com.baidu.tieba.o.a.bww().mT(true);
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
        if (this.guz == null && userGodInfo != null) {
            this.guz = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.guz.parserProtobuf(userGodInfo);
        }
        this.guF.fSM = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.guA = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dt(List<UserMap> list) {
        if (!v.I(list)) {
            this.gtT = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.gtT.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
