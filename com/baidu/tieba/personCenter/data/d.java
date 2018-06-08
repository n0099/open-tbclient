package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.i;
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
    public PersonMoreData fPQ;
    private PersonUserGodInfo fQr;
    public com.baidu.tieba.person.data.d fQs;
    public e fQt;
    public e fQu;
    public e fQv;
    public e fQw;
    public f fQx;
    public ArrayList<h> fQy = new ArrayList<>();
    private b fQz;
    private UserData mUserData;

    private void biL() {
        if (this.fQz != null) {
            this.fQy.add(this.fQz);
        } else if (this.mUserData != null) {
            this.fQz = new b();
            this.fQz.fQl = this.mUserData.getFansNum();
            this.fQz.fQm = this.mUserData.getConcern_num();
            this.fQz.fQn = this.mUserData.getLike_bars();
            this.fQz.threadNum = this.mUserData.getThreadNum();
            this.fQz.fov = this.mUserData;
            this.fQy.add(this.fQz);
        }
    }

    private void biM() {
        this.fQy.add(new c());
        if (this.fQt == null) {
            this.fQt = S(d.f.icon_mine_list_collect, d.k.my_mark, 16);
            this.fQt.fQB = new g();
        }
        this.fQy.add(this.fQt);
        this.fQy.add(S(d.f.icon_mine_list_history, d.k.my_history, 17));
        e S = S(d.f.icon_mine_list_friend, d.k.my_groups, 22);
        S.fQA = true;
        this.fQy.add(S);
        if (com.baidu.adp.lib.b.d.hv().aw("android_show_answer") == 1) {
            e S2 = S(d.f.icon_mine_list_rich, d.k.slumdog_millionaire_entrance, 40);
            S2.fQA = true;
            this.fQy.add(S2);
        }
        e S3 = S(d.f.borrow_cash, d.k.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            S3.fQB = new g();
            S3.fQB.fQF = true;
        }
        this.fQy.add(S3);
        this.fQy.add(S(d.f.icon_mine_list_member, d.k.member_center, 12));
        this.fQu = S(d.f.icon_mine_list_gift, d.k.my_gift, 10);
        this.fQu.fQB = new g();
        this.fQu.fQB.fQG = true;
        this.fQu.fQB.fQH = this.mUserData.getTDouNum();
        this.fQy.add(this.fQu);
        this.fQy.add(S(d.f.icon_mine_list_card, d.k.card_box, 18));
        e S4 = S(d.f.icon_mine_list_grade, d.k.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S4.dJm = this.mUserData.membershipInfo.mLink;
        }
        this.fQy.add(S4);
        boolean Bv = TbadkCoreApplication.getInst().getActivityPrizeData().Bv();
        String Bw = TbadkCoreApplication.getInst().getActivityPrizeData().Bw();
        if (Bv && !StringUtils.isNull(Bw)) {
            this.fQv = f(d.f.icon_mine_list_logingift, Bw, 38);
            this.fQv.fQA = true;
            this.fQv.fQB = new g();
            this.fQy.add(this.fQv);
            TiebaStatic.log(new am("c12597"));
        } else {
            S4.fQA = true;
        }
        this.fQy.add(S(d.f.icon_mine_list_hot, d.k.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S5 = S(d.f.icon_mine_list_live, d.k.ala_live, 25);
            S5.fQA = true;
            this.fQy.add(S5);
        }
        this.fQw = S(d.f.icon_mine_list_service, d.k.person_service_centre, 31);
        this.fQw.fQA = true;
        this.fQy.add(this.fQw);
        this.fQy.add(S(d.f.icon_mine_bdcard_72, d.k.baidu_singkil, 39));
        e S6 = S(d.f.icon_mine_list_more, d.k.more, 33);
        S6.fQB = new g();
        S6.fQB.fQI = TbadkCoreApplication.getInst().getString(d.k.person_center_more_desc);
        if (this.fPQ == null) {
            this.fPQ = new PersonMoreData();
        }
        S6.fQC = OrmObject.bundleWithObject(this.fPQ);
        S6.fQA = true;
        this.fQy.add(S6);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fov = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fov = this.mUserData;
        }
        return eVar;
    }

    public void b(i iVar) {
        this.mUserData.setPendantData(iVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lb(boolean z) {
        if (this.fQt != null) {
            if (this.fQt.fQB == null) {
                this.fQt.fQB = new g();
            }
            this.fQt.fQB.fQF = z;
        }
    }

    public void lc(boolean z) {
        if (this.fQw != null) {
            if (this.fQw.fQB == null) {
                this.fQw.fQB = new g();
            }
            this.fQw.fQB.fQF = z;
        }
    }

    public void ld(boolean z) {
        if (this.fQv != null) {
            if (this.fQv.fQB == null) {
                this.fQv.fQB = new g();
            }
            this.fQv.fQB.fQF = z;
        }
    }

    public void le(boolean z) {
        if (this.fQz != null) {
            this.fQz.fQo = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fQx = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.fQy.add(this.fQx);
            biL();
            biM();
            com.baidu.tieba.o.a.bpq().lQ(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fQx = new f();
            this.fQx.fov = this.mUserData;
            this.fQy.add(this.fQx);
            biL();
            biM();
            com.baidu.tieba.o.a.bpq().lQ(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fQr == null && userGodInfo != null) {
            this.fQr = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fQr.parserProtobuf(userGodInfo);
        }
        this.fQx.fov = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fQs = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!w.z(list)) {
            this.fPQ = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fPQ.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
