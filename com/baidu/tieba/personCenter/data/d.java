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
    private PersonUserGodInfo fDV;
    public com.baidu.tieba.person.data.d fDW;
    public e fDX;
    public e fDY;
    public e fDZ;
    public PersonMoreData fDt;
    public e fEa;
    public f fEb;
    public ArrayList<h> fEc = new ArrayList<>();
    private b fEd;
    private UserData mUserData;

    private void bdL() {
        if (this.fEd != null) {
            this.fEc.add(this.fEd);
        } else if (this.mUserData != null) {
            this.fEd = new b();
            this.fEd.fDP = this.mUserData.getFansNum();
            this.fEd.fDQ = this.mUserData.getConcern_num();
            this.fEd.fDR = this.mUserData.getLike_bars();
            this.fEd.threadNum = this.mUserData.getThreadNum();
            this.fEd.fbV = this.mUserData;
            this.fEc.add(this.fEd);
        }
    }

    private void bdM() {
        this.fEc.add(new c());
        if (this.fDX == null) {
            this.fDX = S(d.f.icon_mine_list_collect, d.k.my_mark, 16);
            this.fDX.fEf = new g();
        }
        this.fEc.add(this.fDX);
        this.fEc.add(S(d.f.icon_mine_list_history, d.k.my_history, 17));
        e S = S(d.f.icon_mine_list_friend, d.k.my_groups, 22);
        S.fEe = true;
        this.fEc.add(S);
        if (com.baidu.adp.lib.b.d.eE().ak("android_show_answer") == 1) {
            e S2 = S(d.f.icon_mine_list_rich, d.k.slumdog_millionaire_entrance, 40);
            S2.fEe = true;
            this.fEc.add(S2);
        }
        e S3 = S(d.f.borrow_cash, d.k.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            S3.fEf = new g();
            S3.fEf.fEj = true;
        }
        this.fEc.add(S3);
        this.fEc.add(S(d.f.icon_mine_list_member, d.k.member_center, 12));
        this.fDY = S(d.f.icon_mine_list_gift, d.k.my_gift, 10);
        this.fDY.fEf = new g();
        this.fDY.fEf.fEk = true;
        this.fDY.fEf.fEl = this.mUserData.getTDouNum();
        this.fEc.add(this.fDY);
        this.fEc.add(S(d.f.icon_mine_list_card, d.k.card_box, 18));
        e S4 = S(d.f.icon_mine_list_grade, d.k.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S4.dwY = this.mUserData.membershipInfo.mLink;
        }
        this.fEc.add(S4);
        boolean xW = TbadkCoreApplication.getInst().getActivityPrizeData().xW();
        String xX = TbadkCoreApplication.getInst().getActivityPrizeData().xX();
        if (xW && !StringUtils.isNull(xX)) {
            this.fDZ = f(d.f.icon_mine_list_logingift, xX, 38);
            this.fDZ.fEe = true;
            this.fDZ.fEf = new g();
            this.fEc.add(this.fDZ);
            TiebaStatic.log(new al("c12597"));
        } else {
            S4.fEe = true;
        }
        this.fEc.add(S(d.f.icon_mine_list_hot, d.k.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S5 = S(d.f.icon_mine_list_live, d.k.ala_live, 25);
            S5.fEe = true;
            this.fEc.add(S5);
        }
        this.fEa = S(d.f.icon_mine_list_service, d.k.person_service_centre, 31);
        this.fEa.fEe = true;
        this.fEc.add(this.fEa);
        this.fEc.add(S(d.f.icon_mine_bdcard_72, d.k.baidu_singkil, 39));
        e S6 = S(d.f.icon_mine_list_more, d.k.more, 33);
        S6.fEf = new g();
        S6.fEf.fEm = TbadkCoreApplication.getInst().getString(d.k.person_center_more_desc);
        if (this.fDt == null) {
            this.fDt = new PersonMoreData();
        }
        S6.fEg = OrmObject.bundleWithObject(this.fDt);
        S6.fEe = true;
        this.fEc.add(S6);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fbV = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fbV = this.mUserData;
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
        if (this.fDX != null) {
            if (this.fDX.fEf == null) {
                this.fDX.fEf = new g();
            }
            this.fDX.fEf.fEj = z;
        }
    }

    public void kV(boolean z) {
        if (this.fEa != null) {
            if (this.fEa.fEf == null) {
                this.fEa.fEf = new g();
            }
            this.fEa.fEf.fEj = z;
        }
    }

    public void kW(boolean z) {
        if (this.fDZ != null) {
            if (this.fDZ.fEf == null) {
                this.fDZ.fEf = new g();
            }
            this.fDZ.fEf.fEj = z;
        }
    }

    public void kX(boolean z) {
        if (this.fEd != null) {
            this.fEd.fDS = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fEb = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cT(profileResIdl.data.url_map);
            this.fEc.add(this.fEb);
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
            this.fEb = new f();
            this.fEb.fbV = this.mUserData;
            this.fEc.add(this.fEb);
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
        if (this.fDV == null && userGodInfo != null) {
            this.fDV = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fDV.parserProtobuf(userGodInfo);
        }
        this.fEb.fbV = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fDW = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void cT(List<UserMap> list) {
        if (!v.w(list)) {
            this.fDt = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fDt.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
