package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
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
    public PersonMoreData fTS;
    public ArrayList<h> fUA = new ArrayList<>();
    private b fUB;
    private PersonUserGodInfo fUt;
    public com.baidu.tieba.person.data.d fUu;
    public e fUv;
    public e fUw;
    public e fUx;
    public e fUy;
    public f fUz;
    private UserData mUserData;

    private void bjr() {
        if (this.fUB != null) {
            this.fUA.add(this.fUB);
        } else if (this.mUserData != null) {
            this.fUB = new b();
            this.fUB.fUn = this.mUserData.getFansNum();
            this.fUB.fUo = this.mUserData.getConcern_num();
            this.fUB.fUp = this.mUserData.getLike_bars();
            this.fUB.threadNum = this.mUserData.getThreadNum();
            this.fUB.fso = this.mUserData;
            this.fUA.add(this.fUB);
        }
    }

    private void bjs() {
        this.fUA.add(new c());
        if (this.fUv == null) {
            this.fUv = S(d.f.icon_mine_list_collect, d.k.my_mark, 16);
            this.fUv.fUD = new g();
        }
        this.fUA.add(this.fUv);
        this.fUA.add(S(d.f.icon_mine_list_history, d.k.my_history, 17));
        e S = S(d.f.icon_mine_list_friend, d.k.my_groups, 22);
        S.fUC = true;
        this.fUA.add(S);
        if (com.baidu.adp.lib.b.d.hv().aw("android_show_answer") == 1) {
            e S2 = S(d.f.icon_mine_list_rich, d.k.slumdog_millionaire_entrance, 40);
            S2.fUC = true;
            this.fUA.add(S2);
        }
        e S3 = S(d.f.borrow_cash, d.k.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            S3.fUD = new g();
            S3.fUD.fUH = true;
        }
        this.fUA.add(S3);
        this.fUA.add(S(d.f.icon_mine_list_member, d.k.member_center, 12));
        this.fUw = S(d.f.icon_mine_list_gift, d.k.my_gift, 10);
        this.fUw.fUD = new g();
        this.fUw.fUD.fUI = true;
        this.fUw.fUD.fUJ = this.mUserData.getTDouNum();
        this.fUA.add(this.fUw);
        this.fUA.add(S(d.f.icon_mine_list_card, d.k.card_box, 18));
        e S4 = S(d.f.icon_mine_list_grade, d.k.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S4.adc = this.mUserData.membershipInfo.mLink;
        }
        this.fUA.add(S4);
        boolean BM = TbadkCoreApplication.getInst().getActivityPrizeData().BM();
        String BN = TbadkCoreApplication.getInst().getActivityPrizeData().BN();
        if (BM && !StringUtils.isNull(BN)) {
            this.fUx = f(d.f.icon_mine_list_logingift, BN, 38);
            this.fUx.fUC = true;
            this.fUx.fUD = new g();
            this.fUA.add(this.fUx);
            TiebaStatic.log(new an("c12597"));
        } else {
            S4.fUC = true;
        }
        this.fUA.add(S(d.f.icon_mine_list_hot, d.k.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S5 = S(d.f.icon_mine_list_live, d.k.ala_live, 25);
            S5.fUC = true;
            this.fUA.add(S5);
        }
        this.fUy = S(d.f.icon_mine_list_service, d.k.person_service_centre, 31);
        this.fUy.fUC = true;
        this.fUA.add(this.fUy);
        this.fUA.add(S(d.f.icon_mine_bdcard_72, d.k.baidu_singkil, 39));
        e S6 = S(d.f.icon_mine_list_more, d.k.more, 33);
        S6.fUD = new g();
        S6.fUD.fUK = TbadkCoreApplication.getInst().getString(d.k.person_center_more_desc);
        if (this.fTS == null) {
            this.fTS = new PersonMoreData();
        }
        S6.fUE = OrmObject.bundleWithObject(this.fTS);
        S6.fUC = true;
        this.fUA.add(S6);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fso = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fso = this.mUserData;
        }
        return eVar;
    }

    public void b(i iVar) {
        this.mUserData.setPendantData(iVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void ll(boolean z) {
        if (this.fUv != null) {
            if (this.fUv.fUD == null) {
                this.fUv.fUD = new g();
            }
            this.fUv.fUD.fUH = z;
        }
    }

    public void lm(boolean z) {
        if (this.fUy != null) {
            if (this.fUy.fUD == null) {
                this.fUy.fUD = new g();
            }
            this.fUy.fUD.fUH = z;
        }
    }

    public void ln(boolean z) {
        if (this.fUx != null) {
            if (this.fUx.fUD == null) {
                this.fUx.fUD = new g();
            }
            this.fUx.fUD.fUH = z;
        }
    }

    public void lo(boolean z) {
        if (this.fUB != null) {
            this.fUB.fUq = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fUz = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            df(profileResIdl.data.url_map);
            this.fUA.add(this.fUz);
            bjr();
            bjs();
            com.baidu.tieba.o.a.bpR().ma(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fUz = new f();
            this.fUz.fso = this.mUserData;
            this.fUA.add(this.fUz);
            bjr();
            bjs();
            com.baidu.tieba.o.a.bpR().ma(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fUt == null && userGodInfo != null) {
            this.fUt = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fUt.parserProtobuf(userGodInfo);
        }
        this.fUz.fso = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fUu = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void df(List<UserMap> list) {
        if (!w.A(list)) {
            this.fTS = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fTS.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
