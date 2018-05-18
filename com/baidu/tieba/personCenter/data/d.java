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
    private PersonUserGodInfo fEY;
    public com.baidu.tieba.person.data.d fEZ;
    public PersonMoreData fEw;
    public e fFa;
    public e fFb;
    public e fFc;
    public e fFd;
    public f fFe;
    public ArrayList<h> fFf = new ArrayList<>();
    private b fFg;
    private UserData mUserData;

    private void bdL() {
        if (this.fFg != null) {
            this.fFf.add(this.fFg);
        } else if (this.mUserData != null) {
            this.fFg = new b();
            this.fFg.fES = this.mUserData.getFansNum();
            this.fFg.fET = this.mUserData.getConcern_num();
            this.fFg.fEU = this.mUserData.getLike_bars();
            this.fFg.threadNum = this.mUserData.getThreadNum();
            this.fFg.fcZ = this.mUserData;
            this.fFf.add(this.fFg);
        }
    }

    private void bdM() {
        this.fFf.add(new c());
        if (this.fFa == null) {
            this.fFa = S(d.f.icon_mine_list_collect, d.k.my_mark, 16);
            this.fFa.fFi = new g();
        }
        this.fFf.add(this.fFa);
        this.fFf.add(S(d.f.icon_mine_list_history, d.k.my_history, 17));
        e S = S(d.f.icon_mine_list_friend, d.k.my_groups, 22);
        S.fFh = true;
        this.fFf.add(S);
        if (com.baidu.adp.lib.b.d.eE().ak("android_show_answer") == 1) {
            e S2 = S(d.f.icon_mine_list_rich, d.k.slumdog_millionaire_entrance, 40);
            S2.fFh = true;
            this.fFf.add(S2);
        }
        e S3 = S(d.f.borrow_cash, d.k.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            S3.fFi = new g();
            S3.fFi.fFm = true;
        }
        this.fFf.add(S3);
        this.fFf.add(S(d.f.icon_mine_list_member, d.k.member_center, 12));
        this.fFb = S(d.f.icon_mine_list_gift, d.k.my_gift, 10);
        this.fFb.fFi = new g();
        this.fFb.fFi.fFn = true;
        this.fFb.fFi.fFo = this.mUserData.getTDouNum();
        this.fFf.add(this.fFb);
        this.fFf.add(S(d.f.icon_mine_list_card, d.k.card_box, 18));
        e S4 = S(d.f.icon_mine_list_grade, d.k.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S4.dyc = this.mUserData.membershipInfo.mLink;
        }
        this.fFf.add(S4);
        boolean xV = TbadkCoreApplication.getInst().getActivityPrizeData().xV();
        String xW = TbadkCoreApplication.getInst().getActivityPrizeData().xW();
        if (xV && !StringUtils.isNull(xW)) {
            this.fFc = f(d.f.icon_mine_list_logingift, xW, 38);
            this.fFc.fFh = true;
            this.fFc.fFi = new g();
            this.fFf.add(this.fFc);
            TiebaStatic.log(new al("c12597"));
        } else {
            S4.fFh = true;
        }
        this.fFf.add(S(d.f.icon_mine_list_hot, d.k.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S5 = S(d.f.icon_mine_list_live, d.k.ala_live, 25);
            S5.fFh = true;
            this.fFf.add(S5);
        }
        this.fFd = S(d.f.icon_mine_list_service, d.k.person_service_centre, 31);
        this.fFd.fFh = true;
        this.fFf.add(this.fFd);
        this.fFf.add(S(d.f.icon_mine_bdcard_72, d.k.baidu_singkil, 39));
        e S6 = S(d.f.icon_mine_list_more, d.k.more, 33);
        S6.fFi = new g();
        S6.fFi.fFp = TbadkCoreApplication.getInst().getString(d.k.person_center_more_desc);
        if (this.fEw == null) {
            this.fEw = new PersonMoreData();
        }
        S6.fFj = OrmObject.bundleWithObject(this.fEw);
        S6.fFh = true;
        this.fFf.add(S6);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fcZ = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fcZ = this.mUserData;
        }
        return eVar;
    }

    public void b(com.baidu.tbadk.data.h hVar) {
        this.mUserData.setPendantData(hVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kV(boolean z) {
        if (this.fFa != null) {
            if (this.fFa.fFi == null) {
                this.fFa.fFi = new g();
            }
            this.fFa.fFi.fFm = z;
        }
    }

    public void kW(boolean z) {
        if (this.fFd != null) {
            if (this.fFd.fFi == null) {
                this.fFd.fFi = new g();
            }
            this.fFd.fFi.fFm = z;
        }
    }

    public void kX(boolean z) {
        if (this.fFc != null) {
            if (this.fFc.fFi == null) {
                this.fFc.fFi = new g();
            }
            this.fFc.fFi.fFm = z;
        }
    }

    public void kY(boolean z) {
        if (this.fFg != null) {
            this.fFg.fEV = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fFe = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cW(profileResIdl.data.url_map);
            this.fFf.add(this.fFe);
            bdL();
            bdM();
            com.baidu.tieba.n.a.bks().lK(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fFe = new f();
            this.fFe.fcZ = this.mUserData;
            this.fFf.add(this.fFe);
            bdL();
            bdM();
            com.baidu.tieba.n.a.bks().lK(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fEY == null && userGodInfo != null) {
            this.fEY = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fEY.parserProtobuf(userGodInfo);
        }
        this.fFe.fcZ = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fEZ = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void cW(List<UserMap> list) {
        if (!v.w(list)) {
            this.fEw = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fEw.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
