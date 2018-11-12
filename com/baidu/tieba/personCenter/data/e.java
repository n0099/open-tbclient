package com.baidu.tieba.personCenter.data;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.j;
import com.baidu.tieba.e;
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
/* loaded from: classes5.dex */
public class e implements com.baidu.tieba.person.b {
    public ArrayList<com.baidu.adp.widget.ListView.h> dUy = new ArrayList<>();
    private List<BannerImage> gkR;
    private PersonUserGodInfo gkS;
    public com.baidu.tieba.person.data.d gkT;
    public f gkU;
    public f gkV;
    public f gkW;
    public f gkX;
    public g gkY;
    public i gkZ;
    public PersonMoreData gkm;
    private c gla;
    private UserData mUserData;

    private void bmM() {
        if (this.gla != null) {
            this.dUy.add(this.gla);
        } else if (this.mUserData != null) {
            this.gla = new c();
            this.gla.gkL = this.mUserData.getFansNum();
            this.gla.gkM = this.mUserData.getConcern_num();
            this.gla.gkN = this.mUserData.getLike_bars();
            this.gla.threadNum = this.mUserData.getThreadNum();
            this.gla.fJe = this.mUserData;
            this.dUy.add(this.gla);
        }
    }

    private void bmN() {
        if (this.gkZ != null) {
            this.dUy.add(this.gkZ);
            return;
        }
        this.gkZ = new i();
        if (!v.I(this.gkR)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.gkR.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.gkR.get(i2));
                if (!ao.isEmpty(aVar.aGG())) {
                    this.gkZ.gkR.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.gkZ.gkR.size() > 0) {
                this.dUy.add(this.gkZ);
            }
        }
    }

    private void bmO() {
        this.dUy.add(new d());
    }

    private void bmP() {
        if (this.gkU == null) {
            this.gkU = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.gkU.glc = new h();
        }
        this.dUy.add(this.gkU);
        this.dUy.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.glb = true;
        this.dUy.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.glc = new h();
            W2.glc.glg = true;
        }
        this.dUy.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.glc = new h();
                W3.glc.glg = true;
            }
            this.dUy.add(W3);
        }
        this.dUy.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.gkV = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.gkV.glc = new h();
        this.gkV.glc.glh = true;
        this.gkV.glc.gli = this.mUserData.getTDouNum();
        this.dUy.add(this.gkV);
        this.dUy.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        f W4 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W4.akS = this.mUserData.membershipInfo.mLink;
        }
        this.dUy.add(W4);
        boolean Fe = TbadkCoreApplication.getInst().getActivityPrizeData().Fe();
        String Ff = TbadkCoreApplication.getInst().getActivityPrizeData().Ff();
        if (Fe && !StringUtils.isNull(Ff)) {
            this.gkW = f(e.f.icon_mine_list_logingift, Ff, 38);
            this.gkW.glb = true;
            this.gkW.glc = new h();
            this.dUy.add(this.gkW);
            TiebaStatic.log(new am("c12597"));
        } else {
            W4.glb = true;
        }
        this.dUy.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W5 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W5.glb = true;
            this.dUy.add(W5);
        }
        this.gkX = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.gkX.glb = true;
        this.dUy.add(this.gkX);
        this.dUy.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W6 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W6.glc = new h();
        W6.glc.glj = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.gkm == null) {
            this.gkm = new PersonMoreData();
        }
        W6.gld = OrmObject.bundleWithObject(this.gkm);
        W6.glb = true;
        this.dUy.add(W6);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fJe = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fJe = this.mUserData;
        }
        return fVar;
    }

    public void b(j jVar) {
        this.mUserData.setPendantData(jVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lV(boolean z) {
        if (this.gkU != null) {
            if (this.gkU.glc == null) {
                this.gkU.glc = new h();
            }
            this.gkU.glc.glg = z;
        }
    }

    public void lW(boolean z) {
        if (this.gkX != null) {
            if (this.gkX.glc == null) {
                this.gkX.glc = new h();
            }
            this.gkX.glc.glg = z;
        }
    }

    public void lX(boolean z) {
        if (this.gkW != null) {
            if (this.gkW.glc == null) {
                this.gkW.glc = new h();
            }
            this.gkW.glc.glg = z;
        }
    }

    public void lY(boolean z) {
        if (this.gla != null) {
            this.gla.gkO = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.gkY = new g();
            this.gkR = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            m20do(profileResIdl.data.url_map);
            this.dUy.add(this.gkY);
            bmM();
            bmO();
            bmN();
            bmP();
            com.baidu.tieba.o.a.btQ().mN(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.gkY = new g();
            this.gkY.fJe = this.mUserData;
            this.dUy.add(this.gkY);
            bmM();
            bmP();
            com.baidu.tieba.o.a.btQ().mN(true);
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
        if (this.gkS == null && userGodInfo != null) {
            this.gkS = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.gkS.parserProtobuf(userGodInfo);
        }
        this.gkY.fJe = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.gkT = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    /* renamed from: do  reason: not valid java name */
    private void m20do(List<UserMap> list) {
        if (!v.I(list)) {
            this.gkm = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.gkm.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
