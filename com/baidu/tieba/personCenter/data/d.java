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
    public PersonMoreData giG;
    private PersonUserGodInfo gjj;
    public com.baidu.tieba.person.data.d gjk;
    public e gjl;
    public e gjm;
    public e gjn;
    public e gjo;
    public f gjp;
    public ArrayList<i> gjq = new ArrayList<>();
    private b gjr;
    private UserData mUserData;

    private void biJ() {
        if (this.gjr != null) {
            this.gjq.add(this.gjr);
        } else if (this.mUserData != null) {
            this.gjr = new b();
            this.gjr.gjd = this.mUserData.getFansNum();
            this.gjr.gje = this.mUserData.getConcern_num();
            this.gjr.gjf = this.mUserData.getLike_bars();
            this.gjr.threadNum = this.mUserData.getThreadNum();
            this.gjr.fHa = this.mUserData;
            this.gjq.add(this.gjr);
        }
    }

    private void biK() {
        this.gjq.add(new c());
        if (this.gjl == null) {
            this.gjl = ae(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.gjl.gjt = new g();
        }
        this.gjq.add(this.gjl);
        this.gjq.add(ae(d.f.icon_mine_list_history, d.j.my_history, 17));
        e ae = ae(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        ae.gjs = true;
        this.gjq.add(ae);
        if (com.baidu.adp.lib.b.d.mA().an("android_show_answer") == 1) {
            e ae2 = ae(d.f.icon_mine_list_rich, d.j.slumdog_millionaire_entrance, 40);
            ae2.gjs = true;
            this.gjq.add(ae2);
        }
        this.gjq.add(ae(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.gjm = ae(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.gjm.gjt = new g();
        this.gjm.gjt.gjy = true;
        this.gjm.gjt.gjz = this.mUserData.getTDouNum();
        this.gjq.add(this.gjm);
        this.gjq.add(ae(d.f.icon_mine_list_card, d.j.card_box, 18));
        e ae3 = ae(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            ae3.ecc = this.mUserData.membershipInfo.mLink;
        }
        this.gjq.add(ae3);
        e ae4 = ae(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            ae4.gjt = new g();
            ae4.gjt.gjx = true;
        }
        this.gjq.add(ae4);
        boolean Fi = TbadkCoreApplication.getInst().getActivityPrizeData().Fi();
        String Fj = TbadkCoreApplication.getInst().getActivityPrizeData().Fj();
        if (Fi && !StringUtils.isNull(Fj)) {
            this.gjn = f(d.f.icon_mine_list_logingift, Fj, 38);
            this.gjn.gjs = true;
            this.gjn.gjt = new g();
            this.gjq.add(this.gjn);
            TiebaStatic.log(new ak("c12597"));
        } else {
            ae4.gjs = true;
        }
        this.gjq.add(ae(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e ae5 = ae(d.f.icon_mine_list_live, d.j.ala_live, 25);
            ae5.gjs = true;
            this.gjq.add(ae5);
        }
        this.gjo = ae(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.gjo.gjs = true;
        this.gjq.add(this.gjo);
        this.gjq.add(ae(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e ae6 = ae(d.f.icon_mine_list_more, d.j.more, 33);
        ae6.gjt = new g();
        ae6.gjt.gjA = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.giG == null) {
            this.giG = new PersonMoreData();
        }
        ae6.gju = OrmObject.bundleWithObject(this.giG);
        ae6.gjs = true;
        this.gjq.add(ae6);
    }

    private e ae(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fHa = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fHa = this.mUserData;
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
        if (this.gjl != null) {
            if (this.gjl.gjt == null) {
                this.gjl.gjt = new g();
            }
            this.gjl.gjt.gjx = z;
        }
    }

    public void lr(boolean z) {
        if (this.gjo != null) {
            if (this.gjo.gjt == null) {
                this.gjo.gjt = new g();
            }
            this.gjo.gjt.gjx = z;
        }
    }

    public void ls(boolean z) {
        if (this.gjn != null) {
            if (this.gjn.gjt == null) {
                this.gjn.gjt = new g();
            }
            this.gjn.gjt.gjx = z;
        }
    }

    public void lt(boolean z) {
        if (this.gjr != null) {
            this.gjr.gjg = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gjp = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.gjq.add(this.gjp);
            biJ();
            biK();
            com.baidu.tieba.m.a.bpl().md(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gjp = new f();
            this.gjp.fHa = this.mUserData;
            this.gjq.add(this.gjp);
            biJ();
            biK();
            com.baidu.tieba.m.a.bpl().md(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.gjj == null && userGodInfo != null) {
            this.gjj = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gjj.parserProtobuf(userGodInfo);
        }
        this.gjp.fHa = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gjk = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!v.E(list)) {
            this.giG = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.giG.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
