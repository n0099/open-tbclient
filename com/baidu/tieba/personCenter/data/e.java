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
    private List<BannerImage> hLT;
    private PersonUserGodInfo hLU;
    public com.baidu.tieba.person.data.d hLV;
    public f hLW;
    public f hLX;
    public f hLY;
    public f hLZ;
    public PersonMoreData hLo;
    public g hMa;
    public i hMb;
    private c hMc;
    private UserData mUserData;

    private void bQv() {
        if (this.hMc != null) {
            this.fsP.add(this.hMc);
        } else if (this.mUserData != null) {
            this.hMc = new c();
            this.hMc.hLN = this.mUserData.getFansNum();
            this.hMc.hLO = this.mUserData.getConcern_num();
            this.hMc.hLP = this.mUserData.getLike_bars();
            this.hMc.threadNum = this.mUserData.getThreadNum();
            this.hMc.userData = this.mUserData;
            this.fsP.add(this.hMc);
        }
    }

    private void bQw() {
        if (this.hMb != null) {
            this.fsP.add(this.hMb);
            return;
        }
        this.hMb = new i();
        if (!v.T(this.hLT)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hLT.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.hLT.get(i2));
                if (!ap.isEmpty(aVar.bQu())) {
                    this.hMb.hLT.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.hMb.hLT.size() > 0) {
                this.fsP.add(this.hMb);
            }
        }
    }

    private void bQx() {
        this.fsP.add(new d());
    }

    private void bQy() {
        if (this.hLW == null) {
            this.hLW = Z(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.hLW.hMe = new h();
        }
        this.fsP.add(this.hLW);
        this.fsP.add(Z(d.f.icon_mine_list_history, d.j.my_history, 17));
        f Z = Z(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        Z.hMd = true;
        this.fsP.add(Z);
        f Z2 = Z(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            Z2.hMe = new h();
            Z2.hMe.isShowRedTip = true;
        }
        this.fsP.add(Z2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 1) == 1) {
            f Z3 = Z(d.f.icon_mine_list_finance, d.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z3.hMe = new h();
                Z3.hMe.isShowRedTip = true;
            }
            this.fsP.add(Z3);
        }
        this.fsP.add(Z(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.hLX = Z(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.hLX.hMe = new h();
        this.hLX.hMe.hMi = true;
        this.hLX.hMe.hMj = this.mUserData.getTDouNum();
        this.fsP.add(this.hLX);
        this.fsP.add(Z(d.f.icon_mine_list_card, d.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f Z4 = Z(d.f.icon_mine_list_myredbag, d.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                Z4.hMe = new h();
                Z4.hMe.isShowRedTip = true;
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
            this.hLY = g(d.f.icon_mine_list_logingift, afR, 38);
            this.hLY.hMd = true;
            this.hLY.hMe = new h();
            this.fsP.add(this.hLY);
            TiebaStatic.log(new am("c12597"));
        } else {
            Z5.hMd = true;
        }
        this.fsP.add(Z(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f Z6 = Z(d.f.icon_mine_list_live, d.j.ala_live, 25);
            Z6.hMd = true;
            this.fsP.add(Z6);
        }
        this.hLZ = Z(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.hLZ.hMd = true;
        this.fsP.add(this.hLZ);
        this.fsP.add(Z(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        f Z7 = Z(d.f.icon_mine_list_more, d.j.more, 33);
        Z7.hMe = new h();
        Z7.hMe.hMk = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.hLo == null) {
            this.hLo = new PersonMoreData();
        }
        Z7.hMf = OrmObject.bundleWithObject(this.hLo);
        Z7.hMd = true;
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
        if (this.hLW != null) {
            if (this.hLW.hMe == null) {
                this.hLW.hMe = new h();
            }
            this.hLW.hMe.isShowRedTip = z;
        }
    }

    public void oz(boolean z) {
        if (this.hLZ != null) {
            if (this.hLZ.hMe == null) {
                this.hLZ.hMe = new h();
            }
            this.hLZ.hMe.isShowRedTip = z;
        }
    }

    public void oA(boolean z) {
        if (this.hLY != null) {
            if (this.hLY.hMe == null) {
                this.hLY.hMe = new h();
            }
            this.hLY.hMe.isShowRedTip = z;
        }
    }

    public void oB(boolean z) {
        if (this.hMc != null) {
            this.hMc.hLQ = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.hMa = new g();
            this.hLT = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dI(profileResIdl.data.url_map);
            this.fsP.add(this.hMa);
            bQv();
            bQx();
            bQw();
            bQy();
            com.baidu.tieba.o.a.bXT().pt(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.hMa = new g();
            this.hMa.userData = this.mUserData;
            this.fsP.add(this.hMa);
            bQv();
            bQy();
            com.baidu.tieba.o.a.bXT().pt(true);
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
        if (this.hLU == null && userGodInfo != null) {
            this.hLU = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.hLU.parserProtobuf(userGodInfo);
        }
        this.hMa.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.hLV = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dI(List<UserMap> list) {
        if (!v.T(list)) {
            this.hLo = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.hLo.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
