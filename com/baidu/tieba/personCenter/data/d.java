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
    private PersonUserGodInfo ghK;
    public com.baidu.tieba.person.data.d ghL;
    public e ghM;
    public e ghN;
    public e ghO;
    public e ghP;
    public f ghQ;
    public ArrayList<i> ghR = new ArrayList<>();
    private b ghS;
    public PersonMoreData ghh;
    private UserData mUserData;

    private void bhA() {
        if (this.ghS != null) {
            this.ghR.add(this.ghS);
        } else if (this.mUserData != null) {
            this.ghS = new b();
            this.ghS.ghE = this.mUserData.getFansNum();
            this.ghS.ghF = this.mUserData.getConcern_num();
            this.ghS.ghG = this.mUserData.getLike_bars();
            this.ghS.threadNum = this.mUserData.getThreadNum();
            this.ghS.fDO = this.mUserData;
            this.ghR.add(this.ghS);
        }
    }

    private void bhB() {
        this.ghR.add(new c());
        if (this.ghM == null) {
            this.ghM = ad(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.ghM.ghU = new g();
        }
        this.ghR.add(this.ghM);
        this.ghR.add(ad(d.f.icon_mine_list_history, d.j.my_history, 17));
        e ad = ad(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        ad.ghT = true;
        this.ghR.add(ad);
        if (com.baidu.adp.lib.b.d.mA().an("android_show_answer") == 1) {
            e ad2 = ad(d.f.icon_mine_list_rich, d.j.slumdog_millionaire_entrance, 40);
            ad2.ghT = true;
            this.ghR.add(ad2);
        }
        this.ghR.add(ad(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.ghN = ad(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.ghN.ghU = new g();
        this.ghN.ghU.ghZ = true;
        this.ghN.ghU.gia = this.mUserData.getTDouNum();
        this.ghR.add(this.ghN);
        this.ghR.add(ad(d.f.icon_mine_list_card, d.j.card_box, 18));
        e ad3 = ad(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ad3.dYc = this.mUserData.membershipInfo.mLink;
        }
        this.ghR.add(ad3);
        e ad4 = ad(d.f.borrow_cash, d.j.borrow_cash, 37);
        this.ghR.add(ad4);
        boolean EO = TbadkCoreApplication.getInst().getActivityPrizeData().EO();
        String EP = TbadkCoreApplication.getInst().getActivityPrizeData().EP();
        if (EO && !StringUtils.isNull(EP)) {
            this.ghO = c(d.f.icon_mine_list_logingift, EP, 38);
            this.ghO.ghT = true;
            this.ghO.ghU = new g();
            this.ghR.add(this.ghO);
            TiebaStatic.log(new ak("c12597"));
        } else {
            ad4.ghT = true;
        }
        this.ghR.add(ad(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e ad5 = ad(d.f.icon_mine_list_live, d.j.ala_live, 25);
            ad5.ghT = true;
            this.ghR.add(ad5);
        }
        this.ghP = ad(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.ghP.ghT = true;
        this.ghR.add(this.ghP);
        this.ghR.add(ad(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e ad6 = ad(d.f.icon_mine_list_more, d.j.more, 33);
        ad6.ghU = new g();
        ad6.ghU.gib = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.ghh == null) {
            this.ghh = new PersonMoreData();
        }
        ad6.ghV = OrmObject.bundleWithObject(this.ghh);
        ad6.ghT = true;
        this.ghR.add(ad6);
    }

    private e ad(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fDO = this.mUserData;
        }
        return eVar;
    }

    private e c(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fDO = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lj(boolean z) {
        if (this.ghM != null) {
            if (this.ghM.ghU == null) {
                this.ghM.ghU = new g();
            }
            this.ghM.ghU.ghY = z;
        }
    }

    public void lk(boolean z) {
        if (this.ghP != null) {
            if (this.ghP.ghU == null) {
                this.ghP.ghU = new g();
            }
            this.ghP.ghU.ghY = z;
        }
    }

    public void ll(boolean z) {
        if (this.ghO != null) {
            if (this.ghO.ghU == null) {
                this.ghO.ghU = new g();
            }
            this.ghO.ghU.ghY = z;
        }
    }

    public void lm(boolean z) {
        if (this.ghS != null) {
            this.ghS.ghH = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ghQ = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cV(profileResIdl.data.url_map);
            this.ghR.add(this.ghQ);
            bhA();
            bhB();
            com.baidu.tieba.m.a.bnP().lW(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ghQ = new f();
            this.ghQ.fDO = this.mUserData;
            this.ghR.add(this.ghQ);
            bhA();
            bhB();
            com.baidu.tieba.m.a.bnP().lW(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.ghK == null && userGodInfo != null) {
            this.ghK = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ghK.parserProtobuf(userGodInfo);
        }
        this.ghQ.fDO = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.ghL = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void cV(List<UserMap> list) {
        if (!v.E(list)) {
            this.ghh = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ghh.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
