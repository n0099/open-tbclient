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
    private PersonUserGodInfo gfN;
    public com.baidu.tieba.person.data.d gfO;
    public e gfP;
    public e gfQ;
    public e gfR;
    public e gfS;
    public f gfT;
    public ArrayList<i> gfU = new ArrayList<>();
    private b gfV;
    public PersonMoreData gfl;
    private UserData mUserData;

    private void bhy() {
        if (this.gfV != null) {
            this.gfU.add(this.gfV);
        } else if (this.mUserData != null) {
            this.gfV = new b();
            this.gfV.gfH = this.mUserData.getFansNum();
            this.gfV.gfI = this.mUserData.getConcern_num();
            this.gfV.gfJ = this.mUserData.getLike_bars();
            this.gfV.threadNum = this.mUserData.getThreadNum();
            this.gfV.fBT = this.mUserData;
            this.gfU.add(this.gfV);
        }
    }

    private void bhz() {
        this.gfU.add(new c());
        if (this.gfP == null) {
            this.gfP = ad(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.gfP.gfX = new g();
        }
        this.gfU.add(this.gfP);
        this.gfU.add(ad(d.f.icon_mine_list_history, d.j.my_history, 17));
        e ad = ad(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        ad.gfW = true;
        this.gfU.add(ad);
        this.gfU.add(ad(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.gfQ = ad(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.gfQ.gfX = new g();
        this.gfQ.gfX.ggc = true;
        this.gfQ.gfX.ggd = this.mUserData.getTDouNum();
        this.gfU.add(this.gfQ);
        this.gfU.add(ad(d.f.icon_mine_list_card, d.j.card_box, 18));
        e ad2 = ad(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ad2.dWx = this.mUserData.membershipInfo.mLink;
        }
        this.gfU.add(ad2);
        e ad3 = ad(d.f.borrow_cash, d.j.borrow_cash, 37);
        this.gfU.add(ad3);
        boolean EV = TbadkCoreApplication.getInst().getActivityPrizeData().EV();
        String EW = TbadkCoreApplication.getInst().getActivityPrizeData().EW();
        if (EV && !StringUtils.isNull(EW)) {
            this.gfR = c(d.f.icon_mine_list_logingift, EW, 38);
            this.gfR.gfW = true;
            this.gfR.gfX = new g();
            this.gfU.add(this.gfR);
            TiebaStatic.log(new ak("c12597"));
        } else {
            ad3.gfW = true;
        }
        this.gfU.add(ad(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e ad4 = ad(d.f.icon_mine_list_live, d.j.ala_live, 25);
            ad4.gfW = true;
            this.gfU.add(ad4);
        }
        this.gfS = ad(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.gfS.gfW = true;
        this.gfU.add(this.gfS);
        this.gfU.add(ad(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e ad5 = ad(d.f.icon_mine_list_more, d.j.more, 33);
        ad5.gfX = new g();
        ad5.gfX.gge = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.gfl == null) {
            this.gfl = new PersonMoreData();
        }
        ad5.gfY = OrmObject.bundleWithObject(this.gfl);
        ad5.gfW = true;
        this.gfU.add(ad5);
    }

    private e ad(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fBT = this.mUserData;
        }
        return eVar;
    }

    private e c(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fBT = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void le(boolean z) {
        if (this.gfP != null) {
            if (this.gfP.gfX == null) {
                this.gfP.gfX = new g();
            }
            this.gfP.gfX.ggb = z;
        }
    }

    public void lf(boolean z) {
        if (this.gfS != null) {
            if (this.gfS.gfX == null) {
                this.gfS.gfX = new g();
            }
            this.gfS.gfX.ggb = z;
        }
    }

    public void lg(boolean z) {
        if (this.gfR != null) {
            if (this.gfR.gfX == null) {
                this.gfR.gfX = new g();
            }
            this.gfR.gfX.ggb = z;
        }
    }

    public void lh(boolean z) {
        if (this.gfV != null) {
            this.gfV.gfK = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gfT = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.gfU.add(this.gfT);
            bhy();
            bhz();
            com.baidu.tieba.m.a.buv().mR(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gfT = new f();
            this.gfT.fBT = this.mUserData;
            this.gfU.add(this.gfT);
            bhy();
            bhz();
            com.baidu.tieba.m.a.buv().mR(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.gfN == null && userGodInfo != null) {
            this.gfN = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gfN.parserProtobuf(userGodInfo);
        }
        this.gfT.fBT = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gfO = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!v.G(list)) {
            this.gfl = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.gfl.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
