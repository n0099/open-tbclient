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
    private PersonUserGodInfo fUG;
    public com.baidu.tieba.person.data.d fUH;
    public e fUI;
    public e fUJ;
    public e fUK;
    public e fUL;
    public f fUM;
    public ArrayList<h> fUN = new ArrayList<>();
    private b fUO;
    public PersonMoreData fUf;
    private UserData mUserData;

    private void bhK() {
        if (this.fUO != null) {
            this.fUN.add(this.fUO);
        } else if (this.mUserData != null) {
            this.fUO = new b();
            this.fUO.fUA = this.mUserData.getFansNum();
            this.fUO.fUB = this.mUserData.getConcern_num();
            this.fUO.fUC = this.mUserData.getLike_bars();
            this.fUO.threadNum = this.mUserData.getThreadNum();
            this.fUO.fsA = this.mUserData;
            this.fUN.add(this.fUO);
        }
    }

    private void bhL() {
        this.fUN.add(new c());
        if (this.fUI == null) {
            this.fUI = R(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.fUI.fUQ = new g();
        }
        this.fUN.add(this.fUI);
        this.fUN.add(R(d.f.icon_mine_list_history, d.j.my_history, 17));
        e R = R(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        R.fUP = true;
        this.fUN.add(R);
        e R2 = R(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            R2.fUQ = new g();
            R2.fUQ.fUU = true;
        }
        this.fUN.add(R2);
        this.fUN.add(R(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.fUJ = R(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.fUJ.fUQ = new g();
        this.fUJ.fUQ.fUV = true;
        this.fUJ.fUQ.fUW = this.mUserData.getTDouNum();
        this.fUN.add(this.fUJ);
        this.fUN.add(R(d.f.icon_mine_list_card, d.j.card_box, 18));
        e R3 = R(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            R3.acG = this.mUserData.membershipInfo.mLink;
        }
        this.fUN.add(R3);
        boolean BE = TbadkCoreApplication.getInst().getActivityPrizeData().BE();
        String BF = TbadkCoreApplication.getInst().getActivityPrizeData().BF();
        if (BE && !StringUtils.isNull(BF)) {
            this.fUK = f(d.f.icon_mine_list_logingift, BF, 38);
            this.fUK.fUP = true;
            this.fUK.fUQ = new g();
            this.fUN.add(this.fUK);
            TiebaStatic.log(new an("c12597"));
        } else {
            R3.fUP = true;
        }
        this.fUN.add(R(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e R4 = R(d.f.icon_mine_list_live, d.j.ala_live, 25);
            R4.fUP = true;
            this.fUN.add(R4);
        }
        this.fUL = R(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.fUL.fUP = true;
        this.fUN.add(this.fUL);
        this.fUN.add(R(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        e R5 = R(d.f.icon_mine_list_more, d.j.more, 33);
        R5.fUQ = new g();
        R5.fUQ.fUX = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.fUf == null) {
            this.fUf = new PersonMoreData();
        }
        R5.fUR = OrmObject.bundleWithObject(this.fUf);
        R5.fUP = true;
        this.fUN.add(R5);
    }

    private e R(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.fsA = this.mUserData;
        }
        return eVar;
    }

    private e f(int i, String str, int i2) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = str;
        eVar.type = i2;
        if (this.mUserData != null) {
            eVar.fsA = this.mUserData;
        }
        return eVar;
    }

    public void b(i iVar) {
        this.mUserData.setPendantData(iVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kX(boolean z) {
        if (this.fUI != null) {
            if (this.fUI.fUQ == null) {
                this.fUI.fUQ = new g();
            }
            this.fUI.fUQ.fUU = z;
        }
    }

    public void kY(boolean z) {
        if (this.fUL != null) {
            if (this.fUL.fUQ == null) {
                this.fUL.fUQ = new g();
            }
            this.fUL.fUQ.fUU = z;
        }
    }

    public void kZ(boolean z) {
        if (this.fUK != null) {
            if (this.fUK.fUQ == null) {
                this.fUK.fUQ = new g();
            }
            this.fUK.fUQ.fUU = z;
        }
    }

    public void la(boolean z) {
        if (this.fUO != null) {
            this.fUO.fUD = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fUM = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.fUN.add(this.fUM);
            bhK();
            bhL();
            com.baidu.tieba.o.a.box().lL(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fUM = new f();
            this.fUM.fsA = this.mUserData;
            this.fUN.add(this.fUM);
            bhK();
            bhL();
            com.baidu.tieba.o.a.box().lL(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fUG == null && userGodInfo != null) {
            this.fUG = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fUG.parserProtobuf(userGodInfo);
        }
        this.fUM.fsA = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fUH = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!w.z(list)) {
            this.fUf = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fUf.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
