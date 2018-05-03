package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.person.b {
    private PersonUserGodInfo fDS;
    public com.baidu.tieba.person.data.d fDT;
    public e fDU;
    public e fDV;
    public e fDW;
    public e fDX;
    public f fDY;
    public ArrayList<h> fDZ = new ArrayList<>();
    public PersonMoreData fDq;
    private b fEa;
    private UserData mUserData;

    private void bdL() {
        if (this.fEa != null) {
            this.fDZ.add(this.fEa);
        } else if (this.mUserData != null) {
            this.fEa = new b();
            this.fEa.fDM = this.mUserData.getFansNum();
            this.fEa.fDN = this.mUserData.getConcern_num();
            this.fEa.fDO = this.mUserData.getLike_bars();
            this.fEa.threadNum = this.mUserData.getThreadNum();
            this.fEa.fbS = this.mUserData;
            this.fDZ.add(this.fEa);
        }
    }

    private void bdM() {
        this.fDZ.add(new c());
        if (this.fDU == null) {
            this.fDU = S(d.f.icon_mine_list_collect, d.k.my_mark, 16);
            this.fDU.fEc = new g();
        }
        this.fDZ.add(this.fDU);
        this.fDZ.add(S(d.f.icon_mine_list_history, d.k.my_history, 17));
        e S = S(d.f.icon_mine_list_friend, d.k.my_groups, 22);
        S.fEb = true;
        this.fDZ.add(S);
        if (com.baidu.adp.lib.b.d.eE().ak("android_show_answer") == 1) {
            e S2 = S(d.f.icon_mine_list_rich, d.k.slumdog_millionaire_entrance, 40);
            S2.fEb = true;
            this.fDZ.add(S2);
        }
        e S3 = S(d.f.borrow_cash, d.k.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            S3.fEc = new g();
            S3.fEc.fEg = true;
        }
        this.fDZ.add(S3);
        this.fDZ.add(S(d.f.icon_mine_list_member, d.k.member_center, 12));
        this.fDV = S(d.f.icon_mine_list_gift, d.k.my_gift, 10);
        this.fDV.fEc = new g();
        this.fDV.fEc.fEh = true;
        this.fDV.fEc.fEi = this.mUserData.getTDouNum();
        this.fDZ.add(this.fDV);
        this.fDZ.add(S(d.f.icon_mine_list_card, d.k.card_box, 18));
        e S4 = S(d.f.icon_mine_list_grade, d.k.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S4.dwV = this.mUserData.membershipInfo.mLink;
        }
        this.fDZ.add(S4);
        boolean xW = TbadkCoreApplication.getInst().getActivityPrizeData().xW();
        String xX = TbadkCoreApplication.getInst().getActivityPrizeData().xX();
        if (xW && !StringUtils.isNull(xX)) {
            this.fDW = f(d.f.icon_mine_list_logingift, xX, 38);
            this.fDW.fEb = true;
            this.fDW.fEc = new g();
            this.fDZ.add(this.fDW);
            TiebaStatic.log(new al("c12597"));
        } else {
            S4.fEb = true;
        }
        this.fDZ.add(S(d.f.icon_mine_list_hot, d.k.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S5 = S(d.f.icon_mine_list_live, d.k.ala_live, 25);
            S5.fEb = true;
            this.fDZ.add(S5);
        }
        this.fDX = S(d.f.icon_mine_list_service, d.k.person_service_centre, 31);
        this.fDX.fEb = true;
        this.fDZ.add(this.fDX);
        this.fDZ.add(S(d.f.icon_mine_bdcard_72, d.k.baidu_singkil, 39));
        e S6 = S(d.f.icon_mine_list_more, d.k.more, 33);
        S6.fEc = new g();
        S6.fEc.fEj = TbadkCoreApplication.getInst().getString(d.k.person_center_more_desc);
        if (this.fDq == null) {
            this.fDq = new PersonMoreData();
        }
        S6.fEd = OrmObject.bundleWithObject(this.fDq);
        S6.fEb = true;
        this.fDZ.add(S6);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fbS = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fbS = this.mUserData;
        }
        return eVar;
    }

    public void b(com.baidu.tbadk.data.h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kU(boolean z) {
        if (this.fDU != null) {
            if (this.fDU.fEc == null) {
                this.fDU.fEc = new g();
            }
            this.fDU.fEc.fEg = z;
        }
    }

    public void kV(boolean z) {
        if (this.fDX != null) {
            if (this.fDX.fEc == null) {
                this.fDX.fEc = new g();
            }
            this.fDX.fEc.fEg = z;
        }
    }

    public void kW(boolean z) {
        if (this.fDW != null) {
            if (this.fDW.fEc == null) {
                this.fDW.fEc = new g();
            }
            this.fDW.fEc.fEg = z;
        }
    }

    public void kX(boolean z) {
        if (this.fEa != null) {
            this.fEa.fDP = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fDY = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cT(profileResIdl.data.url_map);
            this.fDZ.add(this.fDY);
            bdL();
            bdM();
            com.baidu.tieba.n.a.bkt().lJ(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fDY = new f();
            this.fDY.fbS = this.mUserData;
            this.fDZ.add(this.fDY);
            bdL();
            bdM();
            com.baidu.tieba.n.a.bkt().lJ(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fDS == null && userGodInfo != null) {
            this.fDS = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fDS.parserProtobuf(userGodInfo);
        }
        this.fDY.fbS = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fDT = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void cT(List<UserMap> list) {
        if (!v.w(list)) {
            this.fDq = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fDq.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
