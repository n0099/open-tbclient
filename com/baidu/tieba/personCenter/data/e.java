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
import com.baidu.tbadk.data.l;
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
    public ArrayList<com.baidu.adp.widget.ListView.h> eey = new ArrayList<>();
    public PersonMoreData guX;
    private List<BannerImage> gvC;
    private PersonUserGodInfo gvD;
    public com.baidu.tieba.person.data.d gvE;
    public f gvF;
    public f gvG;
    public f gvH;
    public f gvI;
    public g gvJ;
    public i gvK;
    private c gvL;
    private UserData mUserData;

    private void bpZ() {
        if (this.gvL != null) {
            this.eey.add(this.gvL);
        } else if (this.mUserData != null) {
            this.gvL = new c();
            this.gvL.gvw = this.mUserData.getFansNum();
            this.gvL.gvx = this.mUserData.getConcern_num();
            this.gvL.gvy = this.mUserData.getLike_bars();
            this.gvL.threadNum = this.mUserData.getThreadNum();
            this.gvL.fTJ = this.mUserData;
            this.eey.add(this.gvL);
        }
    }

    private void bqa() {
        if (this.gvK != null) {
            this.eey.add(this.gvK);
            return;
        }
        this.gvK = new i();
        if (!v.I(this.gvC)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gvC.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.gvC.get(i2));
                if (!ao.isEmpty(aVar.aJF())) {
                    this.gvK.gvC.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.gvK.gvC.size() > 0) {
                this.eey.add(this.gvK);
            }
        }
    }

    private void bqb() {
        this.eey.add(new d());
    }

    private void bqc() {
        if (this.gvF == null) {
            this.gvF = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.gvF.gvN = new h();
        }
        this.eey.add(this.gvF);
        this.eey.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.gvM = true;
        this.eey.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.gvN = new h();
            W2.gvN.gvR = true;
        }
        this.eey.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 1) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.gvN = new h();
                W3.gvN.gvR = true;
            }
            this.eey.add(W3);
        }
        this.eey.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.gvG = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.gvG.gvN = new h();
        this.gvG.gvN.gvS = true;
        this.gvG.gvN.gvT = this.mUserData.getTDouNum();
        this.eey.add(this.gvG);
        this.eey.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f W4 = W(e.f.icon_mine_list_myredbag, e.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                W4.gvN = new h();
                W4.gvN.gvR = true;
            }
            this.eey.add(W4);
        }
        f W5 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W5.aoW = this.mUserData.membershipInfo.mLink;
        }
        this.eey.add(W5);
        boolean Gw = TbadkCoreApplication.getInst().getActivityPrizeData().Gw();
        String Gx = TbadkCoreApplication.getInst().getActivityPrizeData().Gx();
        if (Gw && !StringUtils.isNull(Gx)) {
            this.gvH = f(e.f.icon_mine_list_logingift, Gx, 38);
            this.gvH.gvM = true;
            this.gvH.gvN = new h();
            this.eey.add(this.gvH);
            TiebaStatic.log(new am("c12597"));
        } else {
            W5.gvM = true;
        }
        this.eey.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W6 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W6.gvM = true;
            this.eey.add(W6);
        }
        this.gvI = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.gvI.gvM = true;
        this.eey.add(this.gvI);
        this.eey.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W7 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W7.gvN = new h();
        W7.gvN.gvU = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.guX == null) {
            this.guX = new PersonMoreData();
        }
        W7.gvO = OrmObject.bundleWithObject(this.guX);
        W7.gvM = true;
        this.eey.add(W7);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fTJ = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fTJ = this.mUserData;
        }
        return fVar;
    }

    public void b(l lVar) {
        this.mUserData.setPendantData(lVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void mb(boolean z) {
        if (this.gvF != null) {
            if (this.gvF.gvN == null) {
                this.gvF.gvN = new h();
            }
            this.gvF.gvN.gvR = z;
        }
    }

    public void mc(boolean z) {
        if (this.gvI != null) {
            if (this.gvI.gvN == null) {
                this.gvI.gvN = new h();
            }
            this.gvI.gvN.gvR = z;
        }
    }

    public void md(boolean z) {
        if (this.gvH != null) {
            if (this.gvH.gvN == null) {
                this.gvH.gvN = new h();
            }
            this.gvH.gvN.gvR = z;
        }
    }

    public void me(boolean z) {
        if (this.gvL != null) {
            this.gvL.gvz = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gvJ = new g();
            this.gvC = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            du(profileResIdl.data.url_map);
            this.eey.add(this.gvJ);
            bpZ();
            bqb();
            bqa();
            bqc();
            com.baidu.tieba.o.a.bxf().mU(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gvJ = new g();
            this.gvJ.fTJ = this.mUserData;
            this.eey.add(this.gvJ);
            bpZ();
            bqc();
            com.baidu.tieba.o.a.bxf().mU(true);
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
        if (this.gvD == null && userGodInfo != null) {
            this.gvD = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gvD.parserProtobuf(userGodInfo);
        }
        this.gvJ.fTJ = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gvE = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void du(List<UserMap> list) {
        if (!v.I(list)) {
            this.guX = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.guX.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
