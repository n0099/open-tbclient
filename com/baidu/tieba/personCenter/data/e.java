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
    public ArrayList<com.baidu.adp.widget.ListView.h> dTs = new ArrayList<>();
    public PersonMoreData giQ;
    public i gjA;
    private c gjB;
    private List<BannerImage> gjs;
    private PersonUserGodInfo gjt;
    public com.baidu.tieba.person.data.d gju;
    public f gjv;
    public f gjw;
    public f gjx;
    public f gjy;
    public g gjz;
    private UserData mUserData;

    private void bnr() {
        if (this.gjB != null) {
            this.dTs.add(this.gjB);
        } else if (this.mUserData != null) {
            this.gjB = new c();
            this.gjB.gjm = this.mUserData.getFansNum();
            this.gjB.gjn = this.mUserData.getConcern_num();
            this.gjB.gjo = this.mUserData.getLike_bars();
            this.gjB.threadNum = this.mUserData.getThreadNum();
            this.gjB.fHG = this.mUserData;
            this.dTs.add(this.gjB);
        }
    }

    private void bns() {
        if (this.gjA != null) {
            this.dTs.add(this.gjA);
            return;
        }
        this.gjA = new i();
        if (!v.J(this.gjs)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gjs.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.gjs.get(i2));
                if (!ao.isEmpty(aVar.aHi())) {
                    this.gjA.gjs.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.gjA.gjs.size() > 0) {
                this.dTs.add(this.gjA);
            }
        }
    }

    private void bnt() {
        this.dTs.add(new d());
    }

    private void bnu() {
        if (this.gjv == null) {
            this.gjv = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.gjv.gjD = new h();
        }
        this.dTs.add(this.gjv);
        this.dTs.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.gjC = true;
        this.dTs.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.gjD = new h();
            W2.gjD.gjH = true;
        }
        this.dTs.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.gjD = new h();
                W3.gjD.gjH = true;
            }
            this.dTs.add(W3);
        }
        this.dTs.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.gjw = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.gjw.gjD = new h();
        this.gjw.gjD.gjI = true;
        this.gjw.gjD.gjJ = this.mUserData.getTDouNum();
        this.dTs.add(this.gjw);
        this.dTs.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        f W4 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W4.akf = this.mUserData.membershipInfo.mLink;
        }
        this.dTs.add(W4);
        boolean ET = TbadkCoreApplication.getInst().getActivityPrizeData().ET();
        String EU = TbadkCoreApplication.getInst().getActivityPrizeData().EU();
        if (ET && !StringUtils.isNull(EU)) {
            this.gjx = f(e.f.icon_mine_list_logingift, EU, 38);
            this.gjx.gjC = true;
            this.gjx.gjD = new h();
            this.dTs.add(this.gjx);
            TiebaStatic.log(new am("c12597"));
        } else {
            W4.gjC = true;
        }
        this.dTs.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W5 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W5.gjC = true;
            this.dTs.add(W5);
        }
        this.gjy = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.gjy.gjC = true;
        this.dTs.add(this.gjy);
        this.dTs.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W6 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W6.gjD = new h();
        W6.gjD.gjK = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.giQ == null) {
            this.giQ = new PersonMoreData();
        }
        W6.gjE = OrmObject.bundleWithObject(this.giQ);
        W6.gjC = true;
        this.dTs.add(W6);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fHG = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fHG = this.mUserData;
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
        if (this.gjv != null) {
            if (this.gjv.gjD == null) {
                this.gjv.gjD = new h();
            }
            this.gjv.gjD.gjH = z;
        }
    }

    public void lL(boolean z) {
        if (this.gjy != null) {
            if (this.gjy.gjD == null) {
                this.gjy.gjD = new h();
            }
            this.gjy.gjD.gjH = z;
        }
    }

    public void lM(boolean z) {
        if (this.gjx != null) {
            if (this.gjx.gjD == null) {
                this.gjx.gjD = new h();
            }
            this.gjx.gjD.gjH = z;
        }
    }

    public void lN(boolean z) {
        if (this.gjB != null) {
            this.gjB.gjp = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gjz = new g();
            this.gjs = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dq(profileResIdl.data.url_map);
            this.dTs.add(this.gjz);
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
            this.gjz = new g();
            this.gjz.fHG = this.mUserData;
            this.dTs.add(this.gjz);
            bnr();
            bnu();
            com.baidu.tieba.o.a.buu().mC(true);
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
        if (this.gjt == null && userGodInfo != null) {
            this.gjt = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gjt.parserProtobuf(userGodInfo);
        }
        this.gjz.fHG = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gju = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dq(List<UserMap> list) {
        if (!v.J(list)) {
            this.giQ = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.giQ.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
