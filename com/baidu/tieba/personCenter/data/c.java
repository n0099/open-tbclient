package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
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
    public f fiA;
    public PersonMoreData fiB;
    public ArrayList<com.baidu.adp.widget.ListView.f> fiC = new ArrayList<>();
    private a fiD;
    private PersonUserGodInfo fiu;
    public com.baidu.tieba.person.data.d fiv;
    public com.baidu.tieba.person.data.e fiw;
    public e fiy;
    public e fiz;
    private UserData mUserData;

    private void aYo() {
        if (this.fiD != null) {
            this.fiC.add(this.fiD);
        } else if (this.mUserData != null) {
            this.fiD = new a();
            this.fiD.fio = this.mUserData.getFansNum();
            this.fiD.fip = this.mUserData.getConcern_num();
            this.fiD.fiq = this.mUserData.getLike_bars();
            this.fiD.threadNum = this.mUserData.getThreadNum();
            this.fiD.eGm = this.mUserData;
            this.fiC.add(this.fiD);
        }
    }

    private void aYp() {
        this.fiC.add(new b());
        if (this.fiy == null) {
            this.fiy = V(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.fiy.fiH = new g();
        }
        this.fiC.add(this.fiy);
        this.fiC.add(V(d.f.icon_mine_list_history, d.j.my_history, 17));
        e V = V(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        V.fiG = true;
        this.fiC.add(V);
        this.fiC.add(V(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.fiz = V(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.fiz.fiH = new g();
        this.fiz.fiH.fiM = true;
        this.fiz.fiH.fiN = this.mUserData.getTDouNum();
        this.fiC.add(this.fiz);
        this.fiC.add(V(d.f.icon_mine_list_card, d.j.card_box, 18));
        e V2 = V(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            V2.dac = this.mUserData.membershipInfo.mLink;
        }
        this.fiC.add(V2);
        e V3 = V(d.f.borrow_cash, d.j.borrow_cash, 38);
        V3.fiG = true;
        this.fiC.add(V3);
        this.fiC.add(V(d.f.icon_mine_list_hot, d.j.hot_topic, 31));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e V4 = V(d.f.icon_mine_list_live, d.j.ala_live, 26);
            V4.fiG = true;
            this.fiC.add(V4);
        }
        this.fiC.add(V(d.f.icon_mine_list_service, d.j.person_service_centre, 32));
        e V5 = V(d.f.icon_mine_list_feedback, d.j.feedback, 25);
        V5.fiG = true;
        this.fiC.add(V5);
        e V6 = V(d.f.icon_mine_list_more, d.j.more, 34);
        V6.fiH = new g();
        V6.fiH.fiO = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.fiB == null) {
            this.fiB = new PersonMoreData();
        }
        V6.fiI = OrmObject.bundleWithObject(this.fiB);
        V6.fiG = true;
        this.fiC.add(V6);
    }

    private e V(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.eGm = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(k kVar) {
        this.mUserData.setPendantData(kVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void jW(boolean z) {
        if (this.fiy != null) {
            if (this.fiy.fiH == null) {
                this.fiy.fiH = new g();
            }
            this.fiy.fiH.fiL = z;
        }
    }

    public void jX(boolean z) {
        if (this.fiD != null) {
            this.fiD.fir = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fiA = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cD(profileResIdl.data.url_map);
            this.fiC.add(this.fiA);
            aYo();
            aYp();
            com.baidu.tieba.j.a.bjW().lD(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fiA = new f();
            this.fiA.eGm = this.mUserData;
            this.fiC.add(this.fiA);
            aYo();
            aYp();
            com.baidu.tieba.j.a.bjW().lD(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fiu == null && userGodInfo != null) {
            this.fiu = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fiu.parserProtobuf(userGodInfo);
        }
        this.fiA.eGm = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fiv = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        com.baidu.tieba.person.g gVar = new com.baidu.tieba.person.g();
        gVar.a(ucCard);
        this.fiw = new com.baidu.tieba.person.data.e();
        this.fiw.cA(gVar.fhk);
    }

    private void cD(List<UserMap> list) {
        if (!v.v(list)) {
            this.fiB = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fiB.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
