package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.l;
import com.baidu.tieba.d;
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
/* loaded from: classes4.dex */
public class e implements com.baidu.tieba.person.b {
    public ArrayList<m> fsA = new ArrayList<>();
    public PersonMoreData hKV;
    private List<BannerImage> hLA;
    private PersonUserGodInfo hLB;
    public com.baidu.tieba.person.data.d hLC;
    public f hLD;
    public f hLE;
    public f hLF;
    public f hLG;
    public g hLH;
    public i hLI;
    private c hLJ;
    private UserData mUserData;

    private void bQu() {
        if (this.hLJ != null) {
            this.fsA.add(this.hLJ);
        } else if (this.mUserData != null) {
            this.hLJ = new c();
            this.hLJ.hLu = this.mUserData.getFansNum();
            this.hLJ.hLv = this.mUserData.getConcern_num();
            this.hLJ.hLw = this.mUserData.getLike_bars();
            this.hLJ.threadNum = this.mUserData.getThreadNum();
            this.hLJ.userData = this.mUserData;
            this.fsA.add(this.hLJ);
        }
    }

    private void bQv() {
        if (this.hLI != null) {
            this.fsA.add(this.hLI);
            return;
        }
        this.hLI = new i();
        if (!v.T(this.hLA)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.hLA.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.hLA.get(i2));
                if (!ap.isEmpty(aVar.bQt())) {
                    this.hLI.hLA.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.hLI.hLA.size() > 0) {
                this.fsA.add(this.hLI);
            }
        }
    }

    private void bQw() {
        this.fsA.add(new d());
    }

    private void bQx() {
        if (this.hLD == null) {
            this.hLD = Z(d.f.icon_mine_list_collect, d.j.my_mark, 16);
            this.hLD.hLL = new h();
        }
        this.fsA.add(this.hLD);
        this.fsA.add(Z(d.f.icon_mine_list_history, d.j.my_history, 17));
        f Z = Z(d.f.icon_mine_list_friend, d.j.my_groups, 22);
        Z.hLK = true;
        this.fsA.add(Z);
        f Z2 = Z(d.f.borrow_cash, d.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            Z2.hLL = new h();
            Z2.hLL.isShowRedTip = true;
        }
        this.fsA.add(Z2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 1) == 1) {
            f Z3 = Z(d.f.icon_mine_list_finance, d.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z3.hLL = new h();
                Z3.hLL.isShowRedTip = true;
            }
            this.fsA.add(Z3);
        }
        this.fsA.add(Z(d.f.icon_mine_list_member, d.j.member_center, 12));
        this.hLE = Z(d.f.icon_mine_list_gift, d.j.my_gift, 10);
        this.hLE.hLL = new h();
        this.hLE.hLL.hLP = true;
        this.hLE.hLL.hLQ = this.mUserData.getTDouNum();
        this.fsA.add(this.hLE);
        this.fsA.add(Z(d.f.icon_mine_list_card, d.j.card_box, 18));
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            f Z4 = Z(d.f.icon_mine_list_myredbag, d.j.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_my_redpacket_clicked", false)) {
                Z4.hLL = new h();
                Z4.hLL.isShowRedTip = true;
            }
            this.fsA.add(Z4);
        }
        f Z5 = Z(d.f.icon_mine_list_grade, d.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            Z5.bvL = this.mUserData.membershipInfo.mLink;
        }
        this.fsA.add(Z5);
        boolean afN = TbadkCoreApplication.getInst().getActivityPrizeData().afN();
        String afO = TbadkCoreApplication.getInst().getActivityPrizeData().afO();
        if (afN && !StringUtils.isNull(afO)) {
            this.hLF = g(d.f.icon_mine_list_logingift, afO, 38);
            this.hLF.hLK = true;
            this.hLF.hLL = new h();
            this.fsA.add(this.hLF);
            TiebaStatic.log(new am("c12597"));
        } else {
            Z5.hLK = true;
        }
        this.fsA.add(Z(d.f.icon_mine_list_hot, d.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f Z6 = Z(d.f.icon_mine_list_live, d.j.ala_live, 25);
            Z6.hLK = true;
            this.fsA.add(Z6);
        }
        this.hLG = Z(d.f.icon_mine_list_service, d.j.person_service_centre, 31);
        this.hLG.hLK = true;
        this.fsA.add(this.hLG);
        this.fsA.add(Z(d.f.icon_mine_bdcard_72, d.j.baidu_singkil, 39));
        f Z7 = Z(d.f.icon_mine_list_more, d.j.more, 33);
        Z7.hLL = new h();
        Z7.hLL.hLR = TbadkCoreApplication.getInst().getString(d.j.person_center_more_desc);
        if (this.hKV == null) {
            this.hKV = new PersonMoreData();
        }
        Z7.hLM = OrmObject.bundleWithObject(this.hKV);
        Z7.hLK = true;
        this.fsA.add(Z7);
    }

    private f Z(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.userData = this.mUserData;
        }
        return fVar;
    }

    private f g(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.userData = this.mUserData;
        }
        return fVar;
    }

    public void a(l lVar) {
        this.mUserData.setPendantData(lVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void oy(boolean z) {
        if (this.hLD != null) {
            if (this.hLD.hLL == null) {
                this.hLD.hLL = new h();
            }
            this.hLD.hLL.isShowRedTip = z;
        }
    }

    public void oz(boolean z) {
        if (this.hLG != null) {
            if (this.hLG.hLL == null) {
                this.hLG.hLL = new h();
            }
            this.hLG.hLL.isShowRedTip = z;
        }
    }

    public void oA(boolean z) {
        if (this.hLF != null) {
            if (this.hLF.hLL == null) {
                this.hLF.hLL = new h();
            }
            this.hLF.hLL.isShowRedTip = z;
        }
    }

    public void oB(boolean z) {
        if (this.hLJ != null) {
            this.hLJ.hLx = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.hLH = new g();
            this.hLA = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dF(profileResIdl.data.url_map);
            this.fsA.add(this.hLH);
            bQu();
            bQw();
            bQv();
            bQx();
            com.baidu.tieba.o.a.bXS().pt(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.hLH = new g();
            this.hLH.userData = this.mUserData;
            this.fsA.add(this.hLH);
            bQu();
            bQx();
            com.baidu.tieba.o.a.bXS().pt(true);
            if (TbadkCoreApplication.getCurrentAccountObj() != null) {
                TbadkCoreApplication.getCurrentAccountObj().setSex(this.mUserData.getSex());
            }
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.hLB == null && userGodInfo != null) {
            this.hLB = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.hLB.parserProtobuf(userGodInfo);
        }
        this.hLH.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.hLC = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dF(List<UserMap> list) {
        if (!v.T(list)) {
            this.hKV = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.hKV.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
