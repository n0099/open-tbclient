package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.h;
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
public class d implements com.baidu.tieba.person.b {
    public PersonMoreData ggM;
    private PersonUserGodInfo ghp;
    public com.baidu.tieba.person.data.d ghq;
    public e ghr;
    public e ghs;
    public e ght;
    public e ghu;
    public f ghv;
    public ArrayList<i> ghw = new ArrayList<>();
    private b ghx;
    private UserData mUserData;

    private void bhz() {
        if (this.ghx != null) {
            this.ghw.add(this.ghx);
        } else if (this.mUserData != null) {
            this.ghx = new b();
            this.ghx.ghj = this.mUserData.getFansNum();
            this.ghx.ghk = this.mUserData.getConcern_num();
            this.ghx.ghl = this.mUserData.getLike_bars();
            this.ghx.threadNum = this.mUserData.getThreadNum();
            this.ghx.fDt = this.mUserData;
            this.ghw.add(this.ghx);
        }
    }

    private void bhA() {
        this.ghw.add(new c());
        if (this.ghr == null) {
            this.ghr = ad(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.ghr.ghz = new g();
        }
        this.ghw.add(this.ghr);
        this.ghw.add(ad(d.f.icon_mine_list_history, d.j.my_history, 17));
        e ad = ad(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        ad.ghy = true;
        this.ghw.add(ad);
        if (com.baidu.adp.lib.b.d.mz().an("android_show_answer") == 1) {
            e ad2 = ad(d.f.icon_mine_list_rich, d.j.slumdog_millionaire_entrance, 40);
            ad2.ghy = true;
            this.ghw.add(ad2);
        }
        this.ghw.add(ad(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.ghs = ad(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.ghs.ghz = new g();
        this.ghs.ghz.ghE = true;
        this.ghs.ghz.ghF = this.mUserData.getTDouNum();
        this.ghw.add(this.ghs);
        this.ghw.add(ad(d.f.icon_mine_list_card, d.j.card_box, 18));
        e ad3 = ad(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ad3.dXH = this.mUserData.membershipInfo.mLink;
        }
        this.ghw.add(ad3);
        e ad4 = ad(d.f.borrow_cash, d.j.borrow_cash, 37);
        this.ghw.add(ad4);
        boolean EM = TbadkCoreApplication.getInst().getActivityPrizeData().EM();
        String EN = TbadkCoreApplication.getInst().getActivityPrizeData().EN();
        if (EM && !StringUtils.isNull(EN)) {
            this.ght = c(d.f.icon_mine_list_logingift, EN, 38);
            this.ght.ghy = true;
            this.ght.ghz = new g();
            this.ghw.add(this.ght);
            TiebaStatic.log(new ak("c12597"));
        } else {
            ad4.ghy = true;
        }
        this.ghw.add(ad(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e ad5 = ad(d.f.icon_mine_list_live, d.j.ala_live, 25);
            ad5.ghy = true;
            this.ghw.add(ad5);
        }
        this.ghu = ad(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.ghu.ghy = true;
        this.ghw.add(this.ghu);
        this.ghw.add(ad(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e ad6 = ad(d.f.icon_mine_list_more, d.j.more, 33);
        ad6.ghz = new g();
        ad6.ghz.ghG = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.ggM == null) {
            this.ggM = new PersonMoreData();
        }
        ad6.ghA = OrmObject.bundleWithObject(this.ggM);
        ad6.ghy = true;
        this.ghw.add(ad6);
    }

    private e ad(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fDt = this.mUserData;
        }
        return eVar;
    }

    private e c(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fDt = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lg(boolean z) {
        if (this.ghr != null) {
            if (this.ghr.ghz == null) {
                this.ghr.ghz = new g();
            }
            this.ghr.ghz.ghD = z;
        }
    }

    public void lh(boolean z) {
        if (this.ghu != null) {
            if (this.ghu.ghz == null) {
                this.ghu.ghz = new g();
            }
            this.ghu.ghz.ghD = z;
        }
    }

    public void li(boolean z) {
        if (this.ght != null) {
            if (this.ght.ghz == null) {
                this.ght.ghz = new g();
            }
            this.ght.ghz.ghD = z;
        }
    }

    public void lj(boolean z) {
        if (this.ghx != null) {
            this.ghx.ghm = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ghv = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cV(profileResIdl.data.url_map);
            this.ghw.add(this.ghv);
            bhz();
            bhA();
            com.baidu.tieba.m.a.bnO().lT(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ghv = new f();
            this.ghv.fDt = this.mUserData;
            this.ghw.add(this.ghv);
            bhz();
            bhA();
            com.baidu.tieba.m.a.bnO().lT(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.ghp == null && userGodInfo != null) {
            this.ghp = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ghp.parserProtobuf(userGodInfo);
        }
        this.ghv.fDt = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.ghq = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void cV(List<UserMap> list) {
        if (!v.E(list)) {
            this.ggM = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ggM.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
