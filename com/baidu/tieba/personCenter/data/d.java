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
    public PersonMoreData giR;
    public f gjA;
    public ArrayList<i> gjB = new ArrayList<>();
    private b gjC;
    private PersonUserGodInfo gju;
    public com.baidu.tieba.person.data.d gjv;
    public e gjw;
    public e gjx;
    public e gjy;
    public e gjz;
    private UserData mUserData;

    private void biK() {
        if (this.gjC != null) {
            this.gjB.add(this.gjC);
        } else if (this.mUserData != null) {
            this.gjC = new b();
            this.gjC.gjo = this.mUserData.getFansNum();
            this.gjC.gjp = this.mUserData.getConcern_num();
            this.gjC.gjq = this.mUserData.getLike_bars();
            this.gjC.threadNum = this.mUserData.getThreadNum();
            this.gjC.fHl = this.mUserData;
            this.gjB.add(this.gjC);
        }
    }

    private void biL() {
        this.gjB.add(new c());
        if (this.gjw == null) {
            this.gjw = ae(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.gjw.gjE = new g();
        }
        this.gjB.add(this.gjw);
        this.gjB.add(ae(d.f.icon_mine_list_history, d.j.my_history, 17));
        e ae = ae(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        ae.gjD = true;
        this.gjB.add(ae);
        if (com.baidu.adp.lib.b.d.mA().an("android_show_answer") == 1) {
            e ae2 = ae(d.f.icon_mine_list_rich, d.j.slumdog_millionaire_entrance, 40);
            ae2.gjD = true;
            this.gjB.add(ae2);
        }
        this.gjB.add(ae(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.gjx = ae(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.gjx.gjE = new g();
        this.gjx.gjE.gjJ = true;
        this.gjx.gjE.gjK = this.mUserData.getTDouNum();
        this.gjB.add(this.gjx);
        this.gjB.add(ae(d.f.icon_mine_list_card, d.j.card_box, 18));
        e ae3 = ae(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ae3.eco = this.mUserData.membershipInfo.mLink;
        }
        this.gjB.add(ae3);
        e ae4 = ae(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            ae4.gjE = new g();
            ae4.gjE.gjI = true;
        }
        this.gjB.add(ae4);
        boolean Fj = TbadkCoreApplication.getInst().getActivityPrizeData().Fj();
        String Fk = TbadkCoreApplication.getInst().getActivityPrizeData().Fk();
        if (Fj && !StringUtils.isNull(Fk)) {
            this.gjy = f(d.f.icon_mine_list_logingift, Fk, 38);
            this.gjy.gjD = true;
            this.gjy.gjE = new g();
            this.gjB.add(this.gjy);
            TiebaStatic.log(new ak("c12597"));
        } else {
            ae4.gjD = true;
        }
        this.gjB.add(ae(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e ae5 = ae(d.f.icon_mine_list_live, d.j.ala_live, 25);
            ae5.gjD = true;
            this.gjB.add(ae5);
        }
        this.gjz = ae(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.gjz.gjD = true;
        this.gjB.add(this.gjz);
        this.gjB.add(ae(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e ae6 = ae(d.f.icon_mine_list_more, d.j.more, 33);
        ae6.gjE = new g();
        ae6.gjE.gjL = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.giR == null) {
            this.giR = new PersonMoreData();
        }
        ae6.gjF = OrmObject.bundleWithObject(this.giR);
        ae6.gjD = true;
        this.gjB.add(ae6);
    }

    private e ae(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fHl = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fHl = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lq(boolean z) {
        if (this.gjw != null) {
            if (this.gjw.gjE == null) {
                this.gjw.gjE = new g();
            }
            this.gjw.gjE.gjI = z;
        }
    }

    public void lr(boolean z) {
        if (this.gjz != null) {
            if (this.gjz.gjE == null) {
                this.gjz.gjE = new g();
            }
            this.gjz.gjE.gjI = z;
        }
    }

    public void ls(boolean z) {
        if (this.gjy != null) {
            if (this.gjy.gjE == null) {
                this.gjy.gjE = new g();
            }
            this.gjy.gjE.gjI = z;
        }
    }

    public void lt(boolean z) {
        if (this.gjC != null) {
            this.gjC.gjr = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gjA = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.gjB.add(this.gjA);
            biK();
            biL();
            com.baidu.tieba.m.a.bpm().md(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gjA = new f();
            this.gjA.fHl = this.mUserData;
            this.gjB.add(this.gjA);
            biK();
            biL();
            com.baidu.tieba.m.a.bpm().md(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.gju == null && userGodInfo != null) {
            this.gju = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gju.parserProtobuf(userGodInfo);
        }
        this.gjA.fHl = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gjv = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!v.E(list)) {
            this.giR = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.giR.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
