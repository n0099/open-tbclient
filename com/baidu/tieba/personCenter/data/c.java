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
    private PersonUserGodInfo fiR;
    public com.baidu.tieba.person.data.d fiS;
    public com.baidu.tieba.person.data.e fiT;
    public e fiU;
    public e fiV;
    public e fiW;
    public f fiX;
    public PersonMoreData fiY;
    public ArrayList<com.baidu.adp.widget.ListView.f> fiZ = new ArrayList<>();
    private a fja;
    private UserData mUserData;

    private void aYw() {
        if (this.fja != null) {
            this.fiZ.add(this.fja);
        } else if (this.mUserData != null) {
            this.fja = new a();
            this.fja.fiL = this.mUserData.getFansNum();
            this.fja.fiM = this.mUserData.getConcern_num();
            this.fja.fiN = this.mUserData.getLike_bars();
            this.fja.threadNum = this.mUserData.getThreadNum();
            this.fja.eGG = this.mUserData;
            this.fiZ.add(this.fja);
        }
    }

    private void aYx() {
        this.fiZ.add(new b());
        if (this.fiU == null) {
            this.fiU = V(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.fiU.fje = new g();
        }
        this.fiZ.add(this.fiU);
        this.fiZ.add(V(d.f.icon_mine_list_history, d.j.my_history, 17));
        e V = V(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        V.fjd = true;
        this.fiZ.add(V);
        this.fiZ.add(V(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.fiV = V(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.fiV.fje = new g();
        this.fiV.fje.fjj = true;
        this.fiV.fje.fjk = this.mUserData.getTDouNum();
        this.fiZ.add(this.fiV);
        this.fiZ.add(V(d.f.icon_mine_list_card, d.j.card_box, 18));
        e V2 = V(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            V2.dax = this.mUserData.membershipInfo.mLink;
        }
        this.fiZ.add(V2);
        e V3 = V(d.f.borrow_cash, d.j.borrow_cash, 38);
        this.fiZ.add(V3);
        if (TbadkCoreApplication.getInst().getActivityPrizeData().xw()) {
            this.fiW = V(d.f.icon_mine_list_logingift, d.j.activity_prize, 39);
            this.fiW.fjd = true;
            this.fiW.fje = new g();
            this.fiZ.add(this.fiW);
            TiebaStatic.log(new ak("c12597"));
        } else {
            V3.fjd = true;
        }
        this.fiZ.add(V(d.f.icon_mine_list_hot, d.j.hot_topic, 31));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e V4 = V(d.f.icon_mine_list_live, d.j.ala_live, 26);
            V4.fjd = true;
            this.fiZ.add(V4);
        }
        this.fiZ.add(V(d.f.icon_mine_list_service, d.j.person_service_centre, 32));
        e V5 = V(d.f.icon_mine_list_feedback, d.j.feedback, 25);
        V5.fjd = true;
        this.fiZ.add(V5);
        e V6 = V(d.f.icon_mine_list_more, d.j.more, 34);
        V6.fje = new g();
        V6.fje.fjl = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.fiY == null) {
            this.fiY = new PersonMoreData();
        }
        V6.fjf = OrmObject.bundleWithObject(this.fiY);
        V6.fjd = true;
        this.fiZ.add(V6);
    }

    private e V(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.eGG = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(k kVar) {
        this.mUserData.setPendantData(kVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kc(boolean z) {
        if (this.fiU != null) {
            if (this.fiU.fje == null) {
                this.fiU.fje = new g();
            }
            this.fiU.fje.fji = z;
        }
    }

    public void kd(boolean z) {
        if (this.fiW != null) {
            if (this.fiW.fje == null) {
                this.fiW.fje = new g();
            }
            this.fiW.fje.fji = z;
        }
    }

    public void ke(boolean z) {
        if (this.fja != null) {
            this.fja.fiO = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fiX = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cE(profileResIdl.data.url_map);
            this.fiZ.add(this.fiX);
            aYw();
            aYx();
            com.baidu.tieba.j.a.bkh().lL(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fiX = new f();
            this.fiX.eGG = this.mUserData;
            this.fiZ.add(this.fiX);
            aYw();
            aYx();
            com.baidu.tieba.j.a.bkh().lL(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fiR == null && userGodInfo != null) {
            this.fiR = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fiR.parserProtobuf(userGodInfo);
        }
        this.fiX.eGG = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fiS = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        com.baidu.tieba.person.g gVar = new com.baidu.tieba.person.g();
        gVar.a(ucCard);
        this.fiT = new com.baidu.tieba.person.data.e();
        this.fiT.cB(gVar.fhG);
    }

    private void cE(List<UserMap> list) {
        if (!v.v(list)) {
            this.fiY = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fiY.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
