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
    public ArrayList<com.baidu.adp.widget.ListView.h> dTr = new ArrayList<>();
    public PersonMoreData giP;
    private c gjA;
    private List<BannerImage> gjr;
    private PersonUserGodInfo gjs;
    public com.baidu.tieba.person.data.d gjt;
    public f gju;
    public f gjv;
    public f gjw;
    public f gjx;
    public g gjy;
    public i gjz;
    private UserData mUserData;

    private void bnr() {
        if (this.gjA != null) {
            this.dTr.add(this.gjA);
        } else if (this.mUserData != null) {
            this.gjA = new c();
            this.gjA.gjl = this.mUserData.getFansNum();
            this.gjA.gjm = this.mUserData.getConcern_num();
            this.gjA.gjn = this.mUserData.getLike_bars();
            this.gjA.threadNum = this.mUserData.getThreadNum();
            this.gjA.fHF = this.mUserData;
            this.dTr.add(this.gjA);
        }
    }

    private void bns() {
        if (this.gjz != null) {
            this.dTr.add(this.gjz);
            return;
        }
        this.gjz = new i();
        if (!v.J(this.gjr)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gjr.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.gjr.get(i2));
                if (!ao.isEmpty(aVar.aHi())) {
                    this.gjz.gjr.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.gjz.gjr.size() > 0) {
                this.dTr.add(this.gjz);
            }
        }
    }

    private void bnt() {
        this.dTr.add(new d());
    }

    private void bnu() {
        if (this.gju == null) {
            this.gju = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.gju.gjC = new h();
        }
        this.dTr.add(this.gju);
        this.dTr.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.gjB = true;
        this.dTr.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.gjC = new h();
            W2.gjC.gjG = true;
        }
        this.dTr.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.gjC = new h();
                W3.gjC.gjG = true;
            }
            this.dTr.add(W3);
        }
        this.dTr.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.gjv = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.gjv.gjC = new h();
        this.gjv.gjC.gjH = true;
        this.gjv.gjC.gjI = this.mUserData.getTDouNum();
        this.dTr.add(this.gjv);
        this.dTr.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        f W4 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W4.akf = this.mUserData.membershipInfo.mLink;
        }
        this.dTr.add(W4);
        boolean ET = TbadkCoreApplication.getInst().getActivityPrizeData().ET();
        String EU = TbadkCoreApplication.getInst().getActivityPrizeData().EU();
        if (ET && !StringUtils.isNull(EU)) {
            this.gjw = f(e.f.icon_mine_list_logingift, EU, 38);
            this.gjw.gjB = true;
            this.gjw.gjC = new h();
            this.dTr.add(this.gjw);
            TiebaStatic.log(new am("c12597"));
        } else {
            W4.gjB = true;
        }
        this.dTr.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W5 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W5.gjB = true;
            this.dTr.add(W5);
        }
        this.gjx = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.gjx.gjB = true;
        this.dTr.add(this.gjx);
        this.dTr.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W6 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W6.gjC = new h();
        W6.gjC.gjJ = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.giP == null) {
            this.giP = new PersonMoreData();
        }
        W6.gjD = OrmObject.bundleWithObject(this.giP);
        W6.gjB = true;
        this.dTr.add(W6);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fHF = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fHF = this.mUserData;
        }
        return fVar;
    }

    public void b(j jVar) {
        this.mUserData.setPendantData(jVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lK(boolean z) {
        if (this.gju != null) {
            if (this.gju.gjC == null) {
                this.gju.gjC = new h();
            }
            this.gju.gjC.gjG = z;
        }
    }

    public void lL(boolean z) {
        if (this.gjx != null) {
            if (this.gjx.gjC == null) {
                this.gjx.gjC = new h();
            }
            this.gjx.gjC.gjG = z;
        }
    }

    public void lM(boolean z) {
        if (this.gjw != null) {
            if (this.gjw.gjC == null) {
                this.gjw.gjC = new h();
            }
            this.gjw.gjC.gjG = z;
        }
    }

    public void lN(boolean z) {
        if (this.gjA != null) {
            this.gjA.gjo = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gjy = new g();
            this.gjr = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dq(profileResIdl.data.url_map);
            this.dTr.add(this.gjy);
            bnr();
            bnt();
            bns();
            bnu();
            com.baidu.tieba.o.a.buu().mC(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gjy = new g();
            this.gjy.fHF = this.mUserData;
            this.dTr.add(this.gjy);
            bnr();
            bnu();
            com.baidu.tieba.o.a.buu().mC(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.gjs == null && userGodInfo != null) {
            this.gjs = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gjs.parserProtobuf(userGodInfo);
        }
        this.gjy.fHF = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gjt = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dq(List<UserMap> list) {
        if (!v.J(list)) {
            this.giP = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.giP.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
