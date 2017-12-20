package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.k;
import com.baidu.tieba.d;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.person.g;
import java.util.ArrayList;
import java.util.List;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.person.b {
    private PersonUserGodInfo fsN;
    public com.baidu.tieba.person.data.d fsO;
    public d fsP;
    public d fsQ;
    public d fsR;
    public e fsS;
    public ArrayList<com.baidu.adp.widget.ListView.f> fsT = new ArrayList<>();
    private a fsU;
    public PersonMoreData fso;
    private UserData mUserData;

    private void bag() {
        if (this.fsU != null) {
            this.fsT.add(this.fsU);
        } else if (this.mUserData != null) {
            this.fsU = new a();
            this.fsU.fsH = this.mUserData.getFansNum();
            this.fsU.fsI = this.mUserData.getConcern_num();
            this.fsU.fsJ = this.mUserData.getLike_bars();
            this.fsU.threadNum = this.mUserData.getThreadNum();
            this.fsU.ePs = this.mUserData;
            this.fsT.add(this.fsU);
        }
    }

    private void bah() {
        this.fsT.add(new b());
        if (this.fsP == null) {
            this.fsP = U(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.fsP.fsW = new f();
        }
        this.fsT.add(this.fsP);
        this.fsT.add(U(d.f.icon_mine_list_history, d.j.my_history, 17));
        d U = U(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        U.fsV = true;
        this.fsT.add(U);
        this.fsT.add(U(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.fsQ = U(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.fsQ.fsW = new f();
        this.fsQ.fsW.ftb = true;
        this.fsQ.fsW.ftc = this.mUserData.getTDouNum();
        this.fsT.add(this.fsQ);
        this.fsT.add(U(d.f.icon_mine_list_card, d.j.card_box, 18));
        d U2 = U(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            U2.dkk = this.mUserData.membershipInfo.mLink;
        }
        this.fsT.add(U2);
        d U3 = U(d.f.borrow_cash, d.j.borrow_cash, 37);
        this.fsT.add(U3);
        boolean xw = TbadkCoreApplication.getInst().getActivityPrizeData().xw();
        String xx = TbadkCoreApplication.getInst().getActivityPrizeData().xx();
        if (xw && !StringUtils.isNull(xx)) {
            this.fsR = c(d.f.icon_mine_list_logingift, xx, 38);
            this.fsR.fsV = true;
            this.fsR.fsW = new f();
            this.fsT.add(this.fsR);
            TiebaStatic.log(new ak("c12597"));
        } else {
            U3.fsV = true;
        }
        this.fsT.add(U(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            d U4 = U(d.f.icon_mine_list_live, d.j.ala_live, 25);
            U4.fsV = true;
            this.fsT.add(U4);
        }
        d U5 = U(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        U5.fsV = true;
        this.fsT.add(U5);
        this.fsT.add(U(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        d U6 = U(d.f.icon_mine_list_more, d.j.more, 33);
        U6.fsW = new f();
        U6.fsW.ftd = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.fso == null) {
            this.fso = new PersonMoreData();
        }
        U6.fsX = OrmObject.bundleWithObject(this.fso);
        U6.fsV = true;
        this.fsT.add(U6);
    }

    private d U(int i, int i2, int i3) {
        d dVar = new d();
        dVar.iconId = i;
        dVar.title = TbadkCoreApplication.getInst().getString(i2);
        dVar.type = i3;
        if (this.mUserData != null) {
            dVar.ePs = this.mUserData;
        }
        return dVar;
    }

    private d c(int i, String str, int i2) {
        d dVar = new d();
        dVar.iconId = i;
        dVar.title = str;
        dVar.type = i2;
        if (this.mUserData != null) {
            dVar.ePs = this.mUserData;
        }
        return dVar;
    }

    public void setUserPendantData(k kVar) {
        this.mUserData.setPendantData(kVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kB(boolean z) {
        if (this.fsP != null) {
            if (this.fsP.fsW == null) {
                this.fsP.fsW = new f();
            }
            this.fsP.fsW.fta = z;
        }
    }

    public void kC(boolean z) {
        if (this.fsR != null) {
            if (this.fsR.fsW == null) {
                this.fsR.fsW = new f();
            }
            this.fsR.fsW.fta = z;
        }
    }

    public void kD(boolean z) {
        if (this.fsU != null) {
            this.fsU.fsK = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fsS = new e();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cQ(profileResIdl.data.url_map);
            this.fsT.add(this.fsS);
            bag();
            bah();
            com.baidu.tieba.m.a.bmM().mm(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fsS = new e();
            this.fsS.ePs = this.mUserData;
            this.fsT.add(this.fsS);
            bag();
            bah();
            com.baidu.tieba.m.a.bmM().mm(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fsN == null && userGodInfo != null) {
            this.fsN = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fsN.parserProtobuf(userGodInfo);
        }
        this.fsS.ePs = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fsO = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new g().a(ucCard);
    }

    private void cQ(List<UserMap> list) {
        if (!v.w(list)) {
            this.fso = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fso.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
