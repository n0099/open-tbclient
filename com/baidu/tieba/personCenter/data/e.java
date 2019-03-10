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
    public ArrayList<m> fsP = new ArrayList<>();
    private List<BannerImage> hLU;
    private PersonUserGodInfo hLV;
    public com.baidu.tieba.person.data.d hLW;
    public f hLX;
    public f hLY;
    public f hLZ;
    public PersonMoreData hLp;
    public f hMa;
    public g hMb;
    public i hMc;
    private c hMd;
    private UserData mUserData;

    private void bQw() {
        if (this.hMd != null) {
            this.fsP.add(this.hMd);
        } else if (this.mUserData != null) {
            this.hMd = new c();
            this.hMd.hLO = this.mUserData.getFansNum();
            this.hMd.hLP = this.mUserData.getConcern_num();
            this.hMd.hLQ = this.mUserData.getLike_bars();
            this.hMd.threadNum = this.mUserData.getThreadNum();
            this.hMd.userData = this.mUserData;
            this.fsP.add(this.hMd);
        }
    }

    private void bQx() {
        if (this.hMc != null) {
            this.fsP.add(this.hMc);
            return;
        }
        this.hMc = new i();
        if (!v.T(this.hLU)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hLU.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.hLU.get(i2));
                if (!ap.isEmpty(aVar.bQv())) {
                    this.hMc.hLU.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.hMc.hLU.size() > 0) {
                this.fsP.add(this.hMc);
            }
        }
    }

    private void bQy() {
        this.fsP.add(new d());
    }

    private void bQz() {
        if (this.hLX == null) {
            this.hLX = Z(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.hLX.hMf = new h();
        }
        this.fsP.add(this.hLX);
        this.fsP.add(Z(d.f.icon_mine_list_history, d.j.my_history, 17));
        f Z = Z(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        Z.hMe = true;
        this.fsP.add(Z);
        f Z2 = Z(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            Z2.hMf = new h();
            Z2.hMf.isShowRedTip = true;
        }
        this.fsP.add(Z2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 1) == 1) {
            f Z3 = Z(d.f.icon_mine_list_finance, d.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z3.hMf = new h();
                Z3.hMf.isShowRedTip = true;
            }
            this.fsP.add(Z3);
        }
        this.fsP.add(Z(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.hLY = Z(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.hLY.hMf = new h();
        this.hLY.hMf.hMj = true;
        this.hLY.hMf.hMk = this.mUserData.getTDouNum();
        this.fsP.add(this.hLY);
        this.fsP.add(Z(d.f.icon_mine_list_card, d.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f Z4 = Z(d.f.icon_mine_list_myredbag, d.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                Z4.hMf = new h();
                Z4.hMf.isShowRedTip = true;
            }
            this.fsP.add(Z4);
        }
        f Z5 = Z(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            Z5.bvG = this.mUserData.membershipInfo.mLink;
        }
        this.fsP.add(Z5);
        boolean afQ = TbadkCoreApplication.getInst().getActivityPrizeData().afQ();
        String afR = TbadkCoreApplication.getInst().getActivityPrizeData().afR();
        if (afQ && !StringUtils.isNull(afR)) {
            this.hLZ = g(d.f.icon_mine_list_logingift, afR, 38);
            this.hLZ.hMe = true;
            this.hLZ.hMf = new h();
            this.fsP.add(this.hLZ);
            TiebaStatic.log(new am("c12597"));
        } else {
            Z5.hMe = true;
        }
        this.fsP.add(Z(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f Z6 = Z(d.f.icon_mine_list_live, d.j.ala_live, 25);
            Z6.hMe = true;
            this.fsP.add(Z6);
        }
        this.hMa = Z(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.hMa.hMe = true;
        this.fsP.add(this.hMa);
        this.fsP.add(Z(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        f Z7 = Z(d.f.icon_mine_list_more, d.j.more, 33);
        Z7.hMf = new h();
        Z7.hMf.hMl = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.hLp == null) {
            this.hLp = new PersonMoreData();
        }
        Z7.hMg = OrmObject.bundleWithObject(this.hLp);
        Z7.hMe = true;
        this.fsP.add(Z7);
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
        if (this.hLX != null) {
            if (this.hLX.hMf == null) {
                this.hLX.hMf = new h();
            }
            this.hLX.hMf.isShowRedTip = z;
        }
    }

    public void oz(boolean z) {
        if (this.hMa != null) {
            if (this.hMa.hMf == null) {
                this.hMa.hMf = new h();
            }
            this.hMa.hMf.isShowRedTip = z;
        }
    }

    public void oA(boolean z) {
        if (this.hLZ != null) {
            if (this.hLZ.hMf == null) {
                this.hLZ.hMf = new h();
            }
            this.hLZ.hMf.isShowRedTip = z;
        }
    }

    public void oB(boolean z) {
        if (this.hMd != null) {
            this.hMd.hLR = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.hMb = new g();
            this.hLU = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dI(profileResIdl.data.url_map);
            this.fsP.add(this.hMb);
            bQw();
            bQy();
            bQx();
            bQz();
            com.baidu.tieba.o.a.bXU().pt(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.hMb = new g();
            this.hMb.userData = this.mUserData;
            this.fsP.add(this.hMb);
            bQw();
            bQz();
            com.baidu.tieba.o.a.bXU().pt(true);
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
        if (this.hLV == null && userGodInfo != null) {
            this.hLV = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.hLV.parserProtobuf(userGodInfo);
        }
        this.hMb.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.hLW = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dI(List<UserMap> list) {
        if (!v.T(list)) {
            this.hLp = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.hLp.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
