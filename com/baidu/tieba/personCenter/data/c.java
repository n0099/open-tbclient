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
    private PersonUserGodInfo frO;
    public com.baidu.tieba.person.data.d frP;
    public com.baidu.tieba.person.data.e frQ;
    public e frR;
    public e frS;
    public e frT;
    public f frU;
    public PersonMoreData frV;
    public ArrayList<com.baidu.adp.widget.ListView.f> frW = new ArrayList<>();
    private a frX;
    private UserData mUserData;

    private void aZY() {
        if (this.frX != null) {
            this.frW.add(this.frX);
        } else if (this.mUserData != null) {
            this.frX = new a();
            this.frX.frI = this.mUserData.getFansNum();
            this.frX.frJ = this.mUserData.getConcern_num();
            this.frX.frK = this.mUserData.getLike_bars();
            this.frX.threadNum = this.mUserData.getThreadNum();
            this.frX.eOp = this.mUserData;
            this.frW.add(this.frX);
        }
    }

    private void aZZ() {
        this.frW.add(new b());
        if (this.frR == null) {
            this.frR = U(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.frR.fsb = new g();
        }
        this.frW.add(this.frR);
        this.frW.add(U(d.f.icon_mine_list_history, d.j.my_history, 17));
        e U = U(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        U.fsa = true;
        this.frW.add(U);
        this.frW.add(U(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.frS = U(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.frS.fsb = new g();
        this.frS.fsb.fsg = true;
        this.frS.fsb.fsh = this.mUserData.getTDouNum();
        this.frW.add(this.frS);
        this.frW.add(U(d.f.icon_mine_list_card, d.j.card_box, 18));
        e U2 = U(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            U2.djf = this.mUserData.membershipInfo.mLink;
        }
        this.frW.add(U2);
        e U3 = U(d.f.borrow_cash, d.j.borrow_cash, 38);
        this.frW.add(U3);
        if (TbadkCoreApplication.getInst().getActivityPrizeData().xx()) {
            this.frT = U(d.f.icon_mine_list_logingift, d.j.activity_prize, 39);
            this.frT.fsa = true;
            this.frT.fsb = new g();
            this.frW.add(this.frT);
            TiebaStatic.log(new ak("c12597"));
        } else {
            U3.fsa = true;
        }
        this.frW.add(U(d.f.icon_mine_list_hot, d.j.hot_topic, 31));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e U4 = U(d.f.icon_mine_list_live, d.j.ala_live, 26);
            U4.fsa = true;
            this.frW.add(U4);
        }
        this.frW.add(U(d.f.icon_mine_list_service, d.j.person_service_centre, 32));
        e U5 = U(d.f.icon_mine_list_feedback, d.j.feedback, 25);
        U5.fsa = true;
        this.frW.add(U5);
        e U6 = U(d.f.icon_mine_list_more, d.j.more, 34);
        U6.fsb = new g();
        U6.fsb.fsi = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.frV == null) {
            this.frV = new PersonMoreData();
        }
        U6.fsc = OrmObject.bundleWithObject(this.frV);
        U6.fsa = true;
        this.frW.add(U6);
    }

    private e U(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.eOp = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(k kVar) {
        this.mUserData.setPendantData(kVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kA(boolean z) {
        if (this.frR != null) {
            if (this.frR.fsb == null) {
                this.frR.fsb = new g();
            }
            this.frR.fsb.fsf = z;
        }
    }

    public void kB(boolean z) {
        if (this.frT != null) {
            if (this.frT.fsb == null) {
                this.frT.fsb = new g();
            }
            this.frT.fsb.fsf = z;
        }
    }

    public void kC(boolean z) {
        if (this.frX != null) {
            this.frX.frL = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.frU = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cR(profileResIdl.data.url_map);
            this.frW.add(this.frU);
            aZY();
            aZZ();
            com.baidu.tieba.m.a.bmh().mk(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.frU = new f();
            this.frU.eOp = this.mUserData;
            this.frW.add(this.frU);
            aZY();
            aZZ();
            com.baidu.tieba.m.a.bmh().mk(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.frO == null && userGodInfo != null) {
            this.frO = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.frO.parserProtobuf(userGodInfo);
        }
        this.frU.eOp = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.frP = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        com.baidu.tieba.person.g gVar = new com.baidu.tieba.person.g();
        gVar.a(ucCard);
        this.frQ = new com.baidu.tieba.person.data.e();
        this.frQ.cO(gVar.fqE);
    }

    private void cR(List<UserMap> list) {
        if (!v.w(list)) {
            this.frV = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.frV.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
