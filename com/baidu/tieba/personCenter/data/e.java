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
/* loaded from: classes2.dex */
public class e implements com.baidu.tieba.person.b {
    public ArrayList<com.baidu.adp.widget.ListView.h> dLv = new ArrayList<>();
    private List<BannerImage> gbP;
    private PersonUserGodInfo gbQ;
    public com.baidu.tieba.person.data.d gbR;
    public f gbS;
    public f gbT;
    public f gbU;
    public f gbV;
    public g gbW;
    public i gbX;
    private c gbY;
    public PersonMoreData gbn;
    private UserData mUserData;

    private void bkg() {
        if (this.gbY != null) {
            this.dLv.add(this.gbY);
        } else if (this.mUserData != null) {
            this.gbY = new c();
            this.gbY.gbJ = this.mUserData.getFansNum();
            this.gbY.gbK = this.mUserData.getConcern_num();
            this.gbY.gbL = this.mUserData.getLike_bars();
            this.gbY.threadNum = this.mUserData.getThreadNum();
            this.gbY.fAd = this.mUserData;
            this.dLv.add(this.gbY);
        }
    }

    private void bkh() {
        if (this.gbX != null) {
            this.dLv.add(this.gbX);
            return;
        }
        this.gbX = new i();
        if (!v.z(this.gbP)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gbP.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.gbP.get(i2));
                if (!ao.isEmpty(aVar.aDQ())) {
                    this.gbX.gbP.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.gbX.gbP.size() > 0) {
                this.dLv.add(this.gbX);
            }
        }
    }

    private void bki() {
        this.dLv.add(new d());
    }

    private void bkj() {
        if (this.gbS == null) {
            this.gbS = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.gbS.gca = new h();
        }
        this.dLv.add(this.gbS);
        this.dLv.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.gbZ = true;
        this.dLv.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.gca = new h();
            W2.gca.gce = true;
        }
        this.dLv.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.gca = new h();
                W3.gca.gce = true;
            }
            this.dLv.add(W3);
        }
        this.dLv.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.gbT = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.gbT.gca = new h();
        this.gbT.gca.gcf = true;
        this.gbT.gca.gcg = this.mUserData.getTDouNum();
        this.dLv.add(this.gbT);
        this.dLv.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        f W4 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W4.afi = this.mUserData.membershipInfo.mLink;
        }
        this.dLv.add(W4);
        boolean CP = TbadkCoreApplication.getInst().getActivityPrizeData().CP();
        String CQ = TbadkCoreApplication.getInst().getActivityPrizeData().CQ();
        if (CP && !StringUtils.isNull(CQ)) {
            this.gbU = f(e.f.icon_mine_list_logingift, CQ, 38);
            this.gbU.gbZ = true;
            this.gbU.gca = new h();
            this.dLv.add(this.gbU);
            TiebaStatic.log(new am("c12597"));
        } else {
            W4.gbZ = true;
        }
        this.dLv.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W5 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W5.gbZ = true;
            this.dLv.add(W5);
        }
        this.gbV = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.gbV.gbZ = true;
        this.dLv.add(this.gbV);
        this.dLv.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W6 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W6.gca = new h();
        W6.gca.gch = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.gbn == null) {
            this.gbn = new PersonMoreData();
        }
        W6.gcb = OrmObject.bundleWithObject(this.gbn);
        W6.gbZ = true;
        this.dLv.add(W6);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fAd = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fAd = this.mUserData;
        }
        return fVar;
    }

    public void b(j jVar) {
        this.mUserData.setPendantData(jVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lt(boolean z) {
        if (this.gbS != null) {
            if (this.gbS.gca == null) {
                this.gbS.gca = new h();
            }
            this.gbS.gca.gce = z;
        }
    }

    public void lu(boolean z) {
        if (this.gbV != null) {
            if (this.gbV.gca == null) {
                this.gbV.gca = new h();
            }
            this.gbV.gca.gce = z;
        }
    }

    public void lv(boolean z) {
        if (this.gbU != null) {
            if (this.gbU.gca == null) {
                this.gbU.gca = new h();
            }
            this.gbU.gca.gce = z;
        }
    }

    public void lw(boolean z) {
        if (this.gbY != null) {
            this.gbY.gbM = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gbW = new g();
            this.gbP = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dc(profileResIdl.data.url_map);
            this.dLv.add(this.gbW);
            bkg();
            bki();
            bkh();
            bkj();
            com.baidu.tieba.o.a.brf().mk(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gbW = new g();
            this.gbW.fAd = this.mUserData;
            this.dLv.add(this.gbW);
            bkg();
            bkj();
            com.baidu.tieba.o.a.brf().mk(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.gbQ == null && userGodInfo != null) {
            this.gbQ = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gbQ.parserProtobuf(userGodInfo);
        }
        this.gbW.fAd = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gbR = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dc(List<UserMap> list) {
        if (!v.z(list)) {
            this.gbn = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.gbn.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
