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
    public PersonMoreData giW;
    public com.baidu.tieba.person.data.d gjA;
    public e gjB;
    public e gjC;
    public e gjD;
    public e gjE;
    public f gjF;
    public ArrayList<i> gjG = new ArrayList<>();
    private b gjH;
    private PersonUserGodInfo gjz;
    private UserData mUserData;

    private void biK() {
        if (this.gjH != null) {
            this.gjG.add(this.gjH);
        } else if (this.mUserData != null) {
            this.gjH = new b();
            this.gjH.gjt = this.mUserData.getFansNum();
            this.gjH.gju = this.mUserData.getConcern_num();
            this.gjH.gjv = this.mUserData.getLike_bars();
            this.gjH.threadNum = this.mUserData.getThreadNum();
            this.gjH.fHq = this.mUserData;
            this.gjG.add(this.gjH);
        }
    }

    private void biL() {
        this.gjG.add(new c());
        if (this.gjB == null) {
            this.gjB = ae(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.gjB.gjJ = new g();
        }
        this.gjG.add(this.gjB);
        this.gjG.add(ae(d.f.icon_mine_list_history, d.j.my_history, 17));
        e ae = ae(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        ae.gjI = true;
        this.gjG.add(ae);
        if (com.baidu.adp.lib.b.d.mA().an("android_show_answer") == 1) {
            e ae2 = ae(d.f.icon_mine_list_rich, d.j.slumdog_millionaire_entrance, 40);
            ae2.gjI = true;
            this.gjG.add(ae2);
        }
        this.gjG.add(ae(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.gjC = ae(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.gjC.gjJ = new g();
        this.gjC.gjJ.gjO = true;
        this.gjC.gjJ.gjP = this.mUserData.getTDouNum();
        this.gjG.add(this.gjC);
        this.gjG.add(ae(d.f.icon_mine_list_card, d.j.card_box, 18));
        e ae3 = ae(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ae3.ecs = this.mUserData.membershipInfo.mLink;
        }
        this.gjG.add(ae3);
        e ae4 = ae(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            ae4.gjJ = new g();
            ae4.gjJ.gjN = true;
        }
        this.gjG.add(ae4);
        boolean Fj = TbadkCoreApplication.getInst().getActivityPrizeData().Fj();
        String Fk = TbadkCoreApplication.getInst().getActivityPrizeData().Fk();
        if (Fj && !StringUtils.isNull(Fk)) {
            this.gjD = f(d.f.icon_mine_list_logingift, Fk, 38);
            this.gjD.gjI = true;
            this.gjD.gjJ = new g();
            this.gjG.add(this.gjD);
            TiebaStatic.log(new ak("c12597"));
        } else {
            ae4.gjI = true;
        }
        this.gjG.add(ae(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e ae5 = ae(d.f.icon_mine_list_live, d.j.ala_live, 25);
            ae5.gjI = true;
            this.gjG.add(ae5);
        }
        this.gjE = ae(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.gjE.gjI = true;
        this.gjG.add(this.gjE);
        this.gjG.add(ae(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e ae6 = ae(d.f.icon_mine_list_more, d.j.more, 33);
        ae6.gjJ = new g();
        ae6.gjJ.gjQ = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.giW == null) {
            this.giW = new PersonMoreData();
        }
        ae6.gjK = OrmObject.bundleWithObject(this.giW);
        ae6.gjI = true;
        this.gjG.add(ae6);
    }

    private e ae(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fHq = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fHq = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lv(boolean z) {
        if (this.gjB != null) {
            if (this.gjB.gjJ == null) {
                this.gjB.gjJ = new g();
            }
            this.gjB.gjJ.gjN = z;
        }
    }

    public void lw(boolean z) {
        if (this.gjE != null) {
            if (this.gjE.gjJ == null) {
                this.gjE.gjJ = new g();
            }
            this.gjE.gjJ.gjN = z;
        }
    }

    public void lx(boolean z) {
        if (this.gjD != null) {
            if (this.gjD.gjJ == null) {
                this.gjD.gjJ = new g();
            }
            this.gjD.gjJ.gjN = z;
        }
    }

    public void ly(boolean z) {
        if (this.gjH != null) {
            this.gjH.gjw = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gjF = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.gjG.add(this.gjF);
            biK();
            biL();
            com.baidu.tieba.m.a.bpm().mi(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gjF = new f();
            this.gjF.fHq = this.mUserData;
            this.gjG.add(this.gjF);
            biK();
            biL();
            com.baidu.tieba.m.a.bpm().mi(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.gjz == null && userGodInfo != null) {
            this.gjz = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gjz.parserProtobuf(userGodInfo);
        }
        this.gjF.fHq = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gjA = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!v.E(list)) {
            this.giW = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.giW.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
