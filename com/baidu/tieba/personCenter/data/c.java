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
    private PersonUserGodInfo fsS;
    public com.baidu.tieba.person.data.d fsT;
    public d fsU;
    public d fsV;
    public d fsW;
    public e fsX;
    public ArrayList<com.baidu.adp.widget.ListView.f> fsY = new ArrayList<>();
    private a fsZ;
    public PersonMoreData fst;
    private UserData mUserData;

    private void bah() {
        if (this.fsZ != null) {
            this.fsY.add(this.fsZ);
        } else if (this.mUserData != null) {
            this.fsZ = new a();
            this.fsZ.fsM = this.mUserData.getFansNum();
            this.fsZ.fsN = this.mUserData.getConcern_num();
            this.fsZ.fsO = this.mUserData.getLike_bars();
            this.fsZ.threadNum = this.mUserData.getThreadNum();
            this.fsZ.ePx = this.mUserData;
            this.fsY.add(this.fsZ);
        }
    }

    private void bai() {
        this.fsY.add(new b());
        if (this.fsU == null) {
            this.fsU = U(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.fsU.ftb = new f();
        }
        this.fsY.add(this.fsU);
        this.fsY.add(U(d.f.icon_mine_list_history, d.j.my_history, 17));
        d U = U(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        U.fta = true;
        this.fsY.add(U);
        this.fsY.add(U(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.fsV = U(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.fsV.ftb = new f();
        this.fsV.ftb.ftg = true;
        this.fsV.ftb.fth = this.mUserData.getTDouNum();
        this.fsY.add(this.fsV);
        this.fsY.add(U(d.f.icon_mine_list_card, d.j.card_box, 18));
        d U2 = U(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            U2.dko = this.mUserData.membershipInfo.mLink;
        }
        this.fsY.add(U2);
        d U3 = U(d.f.borrow_cash, d.j.borrow_cash, 37);
        this.fsY.add(U3);
        boolean xw = TbadkCoreApplication.getInst().getActivityPrizeData().xw();
        String xx = TbadkCoreApplication.getInst().getActivityPrizeData().xx();
        if (xw && !StringUtils.isNull(xx)) {
            this.fsW = c(d.f.icon_mine_list_logingift, xx, 38);
            this.fsW.fta = true;
            this.fsW.ftb = new f();
            this.fsY.add(this.fsW);
            TiebaStatic.log(new ak("c12597"));
        } else {
            U3.fta = true;
        }
        this.fsY.add(U(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            d U4 = U(d.f.icon_mine_list_live, d.j.ala_live, 25);
            U4.fta = true;
            this.fsY.add(U4);
        }
        d U5 = U(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        U5.fta = true;
        this.fsY.add(U5);
        this.fsY.add(U(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        d U6 = U(d.f.icon_mine_list_more, d.j.more, 33);
        U6.ftb = new f();
        U6.ftb.fti = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.fst == null) {
            this.fst = new PersonMoreData();
        }
        U6.ftc = OrmObject.bundleWithObject(this.fst);
        U6.fta = true;
        this.fsY.add(U6);
    }

    private d U(int i, int i2, int i3) {
        d dVar = new d();
        dVar.iconId = i;
        dVar.title = TbadkCoreApplication.getInst().getString(i2);
        dVar.type = i3;
        if (this.mUserData != null) {
            dVar.ePx = this.mUserData;
        }
        return dVar;
    }

    private d c(int i, String str, int i2) {
        d dVar = new d();
        dVar.iconId = i;
        dVar.title = str;
        dVar.type = i2;
        if (this.mUserData != null) {
            dVar.ePx = this.mUserData;
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
        if (this.fsU != null) {
            if (this.fsU.ftb == null) {
                this.fsU.ftb = new f();
            }
            this.fsU.ftb.ftf = z;
        }
    }

    public void kC(boolean z) {
        if (this.fsW != null) {
            if (this.fsW.ftb == null) {
                this.fsW.ftb = new f();
            }
            this.fsW.ftb.ftf = z;
        }
    }

    public void kD(boolean z) {
        if (this.fsZ != null) {
            this.fsZ.fsP = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fsX = new e();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cQ(profileResIdl.data.url_map);
            this.fsY.add(this.fsX);
            bah();
            bai();
            com.baidu.tieba.m.a.bmN().mm(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fsX = new e();
            this.fsX.ePx = this.mUserData;
            this.fsY.add(this.fsX);
            bah();
            bai();
            com.baidu.tieba.m.a.bmN().mm(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fsS == null && userGodInfo != null) {
            this.fsS = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fsS.parserProtobuf(userGodInfo);
        }
        this.fsX.ePx = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fsT = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new g().a(ucCard);
    }

    private void cQ(List<UserMap> list) {
        if (!v.w(list)) {
            this.fst = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fst.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
