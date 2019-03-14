package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.d;
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
/* loaded from: classes4.dex */
public class e implements com.baidu.tieba.person.b {
    public ArrayList<m> fsO = new ArrayList<>();
    private List<BannerImage> hLO;
    private PersonUserGodInfo hLP;
    public com.baidu.tieba.person.data.d hLQ;
    public f hLR;
    public f hLS;
    public f hLT;
    public f hLU;
    public g hLV;
    public i hLW;
    private c hLX;
    public PersonMoreData hLj;
    private UserData mUserData;

    private void bQy() {
        if (this.hLX != null) {
            this.fsO.add(this.hLX);
        } else if (this.mUserData != null) {
            this.hLX = new c();
            this.hLX.hLI = this.mUserData.getFansNum();
            this.hLX.hLJ = this.mUserData.getConcern_num();
            this.hLX.hLK = this.mUserData.getLike_bars();
            this.hLX.threadNum = this.mUserData.getThreadNum();
            this.hLX.userData = this.mUserData;
            this.fsO.add(this.hLX);
        }
    }

    private void bQz() {
        if (this.hLW != null) {
            this.fsO.add(this.hLW);
            return;
        }
        this.hLW = new i();
        if (!v.T(this.hLO)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hLO.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.hLO.get(i2));
                if (!ap.isEmpty(aVar.bQx())) {
                    this.hLW.hLO.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.hLW.hLO.size() > 0) {
                this.fsO.add(this.hLW);
            }
        }
    }

    private void bQA() {
        this.fsO.add(new d());
    }

    private void bQB() {
        if (this.hLR == null) {
            this.hLR = Z(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.hLR.hLZ = new h();
        }
        this.fsO.add(this.hLR);
        this.fsO.add(Z(d.f.icon_mine_list_history, d.j.my_history, 17));
        f Z = Z(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        Z.hLY = true;
        this.fsO.add(Z);
        f Z2 = Z(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            Z2.hLZ = new h();
            Z2.hLZ.isShowRedTip = true;
        }
        this.fsO.add(Z2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 1) == 1) {
            f Z3 = Z(d.f.icon_mine_list_finance, d.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z3.hLZ = new h();
                Z3.hLZ.isShowRedTip = true;
            }
            this.fsO.add(Z3);
        }
        this.fsO.add(Z(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.hLS = Z(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.hLS.hLZ = new h();
        this.hLS.hLZ.hMd = true;
        this.hLS.hLZ.hMe = this.mUserData.getTDouNum();
        this.fsO.add(this.hLS);
        this.fsO.add(Z(d.f.icon_mine_list_card, d.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f Z4 = Z(d.f.icon_mine_list_myredbag, d.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                Z4.hLZ = new h();
                Z4.hLZ.isShowRedTip = true;
            }
            this.fsO.add(Z4);
        }
        f Z5 = Z(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            Z5.bvI = this.mUserData.membershipInfo.mLink;
        }
        this.fsO.add(Z5);
        boolean afQ = TbadkCoreApplication.getInst().getActivityPrizeData().afQ();
        String afR = TbadkCoreApplication.getInst().getActivityPrizeData().afR();
        if (afQ && !StringUtils.isNull(afR)) {
            this.hLT = g(d.f.icon_mine_list_logingift, afR, 38);
            this.hLT.hLY = true;
            this.hLT.hLZ = new h();
            this.fsO.add(this.hLT);
            TiebaStatic.log(new am("c12597"));
        } else {
            Z5.hLY = true;
        }
        this.fsO.add(Z(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f Z6 = Z(d.f.icon_mine_list_live, d.j.ala_live, 25);
            Z6.hLY = true;
            this.fsO.add(Z6);
        }
        this.hLU = Z(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.hLU.hLY = true;
        this.fsO.add(this.hLU);
        this.fsO.add(Z(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        f Z7 = Z(d.f.icon_mine_list_more, d.j.more, 33);
        Z7.hLZ = new h();
        Z7.hLZ.hMf = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.hLj == null) {
            this.hLj = new PersonMoreData();
        }
        Z7.hMa = OrmObject.bundleWithObject(this.hLj);
        Z7.hLY = true;
        this.fsO.add(Z7);
    }

    private f Z(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.userData = this.mUserData;
        }
        return fVar;
    }

    private f g(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.userData = this.mUserData;
        }
        return fVar;
    }

    public void a(l lVar) {
        this.mUserData.setPendantData(lVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void oy(boolean z) {
        if (this.hLR != null) {
            if (this.hLR.hLZ == null) {
                this.hLR.hLZ = new h();
            }
            this.hLR.hLZ.isShowRedTip = z;
        }
    }

    public void oz(boolean z) {
        if (this.hLU != null) {
            if (this.hLU.hLZ == null) {
                this.hLU.hLZ = new h();
            }
            this.hLU.hLZ.isShowRedTip = z;
        }
    }

    public void oA(boolean z) {
        if (this.hLT != null) {
            if (this.hLT.hLZ == null) {
                this.hLT.hLZ = new h();
            }
            this.hLT.hLZ.isShowRedTip = z;
        }
    }

    public void oB(boolean z) {
        if (this.hLX != null) {
            this.hLX.hLL = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.hLV = new g();
            this.hLO = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dI(profileResIdl.data.url_map);
            this.fsO.add(this.hLV);
            bQy();
            bQA();
            bQz();
            bQB();
            com.baidu.tieba.o.a.bXW().pt(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.hLV = new g();
            this.hLV.userData = this.mUserData;
            this.fsO.add(this.hLV);
            bQy();
            bQB();
            com.baidu.tieba.o.a.bXW().pt(true);
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
        if (this.hLP == null && userGodInfo != null) {
            this.hLP = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.hLP.parserProtobuf(userGodInfo);
        }
        this.hLV.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.hLQ = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dI(List<UserMap> list) {
        if (!v.T(list)) {
            this.hLj = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.hLj.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
