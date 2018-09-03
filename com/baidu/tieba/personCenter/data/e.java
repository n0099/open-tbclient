package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes2.dex */
public class e implements com.baidu.tieba.person.b {
    public PersonMoreData fTX;
    private PersonUserGodInfo fUA;
    public com.baidu.tieba.person.data.d fUB;
    public f fUC;
    public f fUD;
    public f fUE;
    public f fUF;
    public g fUG;
    public i fUH;
    public ArrayList<com.baidu.adp.widget.ListView.h> fUI = new ArrayList<>();
    private c fUJ;
    private List<BannerImage> fUz;
    private UserData mUserData;

    private void bhF() {
        if (this.fUJ != null) {
            this.fUI.add(this.fUJ);
        } else if (this.mUserData != null) {
            this.fUJ = new c();
            this.fUJ.fUt = this.mUserData.getFansNum();
            this.fUJ.fUu = this.mUserData.getConcern_num();
            this.fUJ.fUv = this.mUserData.getLike_bars();
            this.fUJ.threadNum = this.mUserData.getThreadNum();
            this.fUJ.fst = this.mUserData;
            this.fUI.add(this.fUJ);
        }
    }

    private void bhG() {
        if (this.fUH != null) {
            this.fUI.add(this.fUH);
            return;
        }
        this.fUH = new i();
        if (!w.z(this.fUz)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.fUz.size()) {
                    a aVar = new a();
                    aVar.a(this.fUz.get(i2));
                    if (!ap.isEmpty(aVar.aBD())) {
                        this.fUH.fUz.add(aVar);
                    }
                    i = i2 + 1;
                } else {
                    this.fUI.add(this.fUH);
                    return;
                }
            }
        }
    }

    private void bhH() {
        this.fUI.add(new d());
    }

    private void bhI() {
        if (this.fUC == null) {
            this.fUC = R(f.C0146f.icon_mine_list_collect, f.j.my_mark, 16);
            this.fUC.fUL = new h();
        }
        this.fUI.add(this.fUC);
        this.fUI.add(R(f.C0146f.icon_mine_list_history, f.j.my_history, 17));
        f R = R(f.C0146f.icon_mine_list_friend, f.j.my_groups, 22);
        R.fUK = true;
        this.fUI.add(R);
        f R2 = R(f.C0146f.borrow_cash, f.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            R2.fUL = new h();
            R2.fUL.fUP = true;
        }
        this.fUI.add(R2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f R3 = R(f.C0146f.icon_mine_list_finance, f.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                R3.fUL = new h();
                R3.fUL.fUP = true;
            }
            this.fUI.add(R3);
        }
        this.fUI.add(R(f.C0146f.icon_mine_list_member, f.j.member_center, 12));
        this.fUD = R(f.C0146f.icon_mine_list_gift, f.j.my_gift, 10);
        this.fUD.fUL = new h();
        this.fUD.fUL.fUQ = true;
        this.fUD.fUL.fUR = this.mUserData.getTDouNum();
        this.fUI.add(this.fUD);
        this.fUI.add(R(f.C0146f.icon_mine_list_card, f.j.card_box, 18));
        f R4 = R(f.C0146f.icon_mine_list_grade, f.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            R4.acH = this.mUserData.membershipInfo.mLink;
        }
        this.fUI.add(R4);
        boolean BB = TbadkCoreApplication.getInst().getActivityPrizeData().BB();
        String BC = TbadkCoreApplication.getInst().getActivityPrizeData().BC();
        if (BB && !StringUtils.isNull(BC)) {
            this.fUE = f(f.C0146f.icon_mine_list_logingift, BC, 38);
            this.fUE.fUK = true;
            this.fUE.fUL = new h();
            this.fUI.add(this.fUE);
            TiebaStatic.log(new an("c12597"));
        } else {
            R4.fUK = true;
        }
        this.fUI.add(R(f.C0146f.icon_mine_list_hot, f.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f R5 = R(f.C0146f.icon_mine_list_live, f.j.ala_live, 25);
            R5.fUK = true;
            this.fUI.add(R5);
        }
        this.fUF = R(f.C0146f.icon_mine_list_service, f.j.person_service_centre, 31);
        this.fUF.fUK = true;
        this.fUI.add(this.fUF);
        this.fUI.add(R(f.C0146f.icon_mine_bdcard_72, f.j.baidu_singkil, 39));
        f R6 = R(f.C0146f.icon_mine_list_more, f.j.more, 33);
        R6.fUL = new h();
        R6.fUL.fUS = TbadkCoreApplication.getInst().getString(f.j.person_center_more_desc);
        if (this.fTX == null) {
            this.fTX = new PersonMoreData();
        }
        R6.fUM = OrmObject.bundleWithObject(this.fTX);
        R6.fUK = true;
        this.fUI.add(R6);
    }

    private f R(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fst = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fst = this.mUserData;
        }
        return fVar;
    }

    public void b(com.baidu.tbadk.data.i iVar) {
        this.mUserData.setPendantData(iVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kX(boolean z) {
        if (this.fUC != null) {
            if (this.fUC.fUL == null) {
                this.fUC.fUL = new h();
            }
            this.fUC.fUL.fUP = z;
        }
    }

    public void kY(boolean z) {
        if (this.fUF != null) {
            if (this.fUF.fUL == null) {
                this.fUF.fUL = new h();
            }
            this.fUF.fUL.fUP = z;
        }
    }

    public void kZ(boolean z) {
        if (this.fUE != null) {
            if (this.fUE.fUL == null) {
                this.fUE.fUL = new h();
            }
            this.fUE.fUL.fUP = z;
        }
    }

    public void la(boolean z) {
        if (this.fUJ != null) {
            this.fUJ.fUw = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fUG = new g();
            this.fUz = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            db(profileResIdl.data.url_map);
            this.fUI.add(this.fUG);
            bhF();
            bhH();
            bhG();
            bhI();
            com.baidu.tieba.o.a.boy().lL(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fUG = new g();
            this.fUG.fst = this.mUserData;
            this.fUI.add(this.fUG);
            bhF();
            bhI();
            com.baidu.tieba.o.a.boy().lL(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fUA == null && userGodInfo != null) {
            this.fUA = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fUA.parserProtobuf(userGodInfo);
        }
        this.fUG.fst = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fUB = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void db(List<UserMap> list) {
        if (!w.z(list)) {
            this.fTX = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.fTX.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
