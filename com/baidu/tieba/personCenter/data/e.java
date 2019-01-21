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
    public ArrayList<com.baidu.adp.widget.ListView.h> eez = new ArrayList<>();
    public PersonMoreData guY;
    private List<BannerImage> gvD;
    private PersonUserGodInfo gvE;
    public com.baidu.tieba.person.data.d gvF;
    public f gvG;
    public f gvH;
    public f gvI;
    public f gvJ;
    public g gvK;
    public i gvL;
    private c gvM;
    private UserData mUserData;

    private void bpZ() {
        if (this.gvM != null) {
            this.eez.add(this.gvM);
        } else if (this.mUserData != null) {
            this.gvM = new c();
            this.gvM.gvx = this.mUserData.getFansNum();
            this.gvM.gvy = this.mUserData.getConcern_num();
            this.gvM.gvz = this.mUserData.getLike_bars();
            this.gvM.threadNum = this.mUserData.getThreadNum();
            this.gvM.fTK = this.mUserData;
            this.eez.add(this.gvM);
        }
    }

    private void bqa() {
        if (this.gvL != null) {
            this.eez.add(this.gvL);
            return;
        }
        this.gvL = new i();
        if (!v.I(this.gvD)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gvD.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.gvD.get(i2));
                if (!ao.isEmpty(aVar.aJF())) {
                    this.gvL.gvD.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.gvL.gvD.size() > 0) {
                this.eez.add(this.gvL);
            }
        }
    }

    private void bqb() {
        this.eez.add(new d());
    }

    private void bqc() {
        if (this.gvG == null) {
            this.gvG = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.gvG.gvO = new h();
        }
        this.eez.add(this.gvG);
        this.eez.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.gvN = true;
        this.eez.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.gvO = new h();
            W2.gvO.gvS = true;
        }
        this.eez.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 1) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.gvO = new h();
                W3.gvO.gvS = true;
            }
            this.eez.add(W3);
        }
        this.eez.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.gvH = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.gvH.gvO = new h();
        this.gvH.gvO.gvT = true;
        this.gvH.gvO.gvU = this.mUserData.getTDouNum();
        this.eez.add(this.gvH);
        this.eez.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f W4 = W(e.f.icon_mine_list_myredbag, e.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                W4.gvO = new h();
                W4.gvO.gvS = true;
            }
            this.eez.add(W4);
        }
        f W5 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W5.aoX = this.mUserData.membershipInfo.mLink;
        }
        this.eez.add(W5);
        boolean Gw = TbadkCoreApplication.getInst().getActivityPrizeData().Gw();
        String Gx = TbadkCoreApplication.getInst().getActivityPrizeData().Gx();
        if (Gw && !StringUtils.isNull(Gx)) {
            this.gvI = f(e.f.icon_mine_list_logingift, Gx, 38);
            this.gvI.gvN = true;
            this.gvI.gvO = new h();
            this.eez.add(this.gvI);
            TiebaStatic.log(new am("c12597"));
        } else {
            W5.gvN = true;
        }
        this.eez.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W6 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W6.gvN = true;
            this.eez.add(W6);
        }
        this.gvJ = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.gvJ.gvN = true;
        this.eez.add(this.gvJ);
        this.eez.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W7 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W7.gvO = new h();
        W7.gvO.gvV = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.guY == null) {
            this.guY = new PersonMoreData();
        }
        W7.gvP = OrmObject.bundleWithObject(this.guY);
        W7.gvN = true;
        this.eez.add(W7);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fTK = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fTK = this.mUserData;
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
        if (this.gvG != null) {
            if (this.gvG.gvO == null) {
                this.gvG.gvO = new h();
            }
            this.gvG.gvO.gvS = z;
        }
    }

    public void mc(boolean z) {
        if (this.gvJ != null) {
            if (this.gvJ.gvO == null) {
                this.gvJ.gvO = new h();
            }
            this.gvJ.gvO.gvS = z;
        }
    }

    public void md(boolean z) {
        if (this.gvI != null) {
            if (this.gvI.gvO == null) {
                this.gvI.gvO = new h();
            }
            this.gvI.gvO.gvS = z;
        }
    }

    public void me(boolean z) {
        if (this.gvM != null) {
            this.gvM.gvA = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gvK = new g();
            this.gvD = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            du(profileResIdl.data.url_map);
            this.eez.add(this.gvK);
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
            this.gvK = new g();
            this.gvK.fTK = this.mUserData;
            this.eez.add(this.gvK);
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
        if (this.gvE == null && userGodInfo != null) {
            this.gvE = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gvE.parserProtobuf(userGodInfo);
        }
        this.gvK.fTK = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gvF = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void du(List<UserMap> list) {
        if (!v.I(list)) {
            this.guY = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.guY.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
