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
    public ArrayList<com.baidu.adp.widget.ListView.h> ebb = new ArrayList<>();
    private List<BannerImage> grH;
    private PersonUserGodInfo grI;
    public com.baidu.tieba.person.data.d grJ;
    public f grK;
    public f grL;
    public f grM;
    public f grN;
    public g grO;
    public i grP;
    private c grQ;
    public PersonMoreData grc;
    private UserData mUserData;

    private void boE() {
        if (this.grQ != null) {
            this.ebb.add(this.grQ);
        } else if (this.mUserData != null) {
            this.grQ = new c();
            this.grQ.grB = this.mUserData.getFansNum();
            this.grQ.grC = this.mUserData.getConcern_num();
            this.grQ.grD = this.mUserData.getLike_bars();
            this.grQ.threadNum = this.mUserData.getThreadNum();
            this.grQ.fPU = this.mUserData;
            this.ebb.add(this.grQ);
        }
    }

    private void boF() {
        if (this.grP != null) {
            this.ebb.add(this.grP);
            return;
        }
        this.grP = new i();
        if (!v.I(this.grH)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.grH.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.grH.get(i2));
                if (!ao.isEmpty(aVar.aIs())) {
                    this.grP.grH.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.grP.grH.size() > 0) {
                this.ebb.add(this.grP);
            }
        }
    }

    private void boG() {
        this.ebb.add(new d());
    }

    private void boH() {
        if (this.grK == null) {
            this.grK = W(e.f.icon_mine_list_collect, e.j.my_mark, 16);
            this.grK.grS = new h();
        }
        this.ebb.add(this.grK);
        this.ebb.add(W(e.f.icon_mine_list_history, e.j.my_history, 17));
        f W = W(e.f.icon_mine_list_friend, e.j.my_groups, 22);
        W.grR = true;
        this.ebb.add(W);
        f W2 = W(e.f.borrow_cash, e.j.borrow_cash, 37);
        if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_has_borrow_cash_clicked", false)) {
            W2.grS = new h();
            W2.grS.grW = true;
        }
        this.ebb.add(W2);
        if (com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("baidu_financial_display", 0) == 1) {
            f W3 = W(e.f.icon_mine_list_finance, e.j.baidu_financial, 41);
            if (!com.baidu.tbadk.core.sharedPref.b.getInstance().getBoolean("key_baidu_financial_has_clicked", false)) {
                W3.grS = new h();
                W3.grS.grW = true;
            }
            this.ebb.add(W3);
        }
        this.ebb.add(W(e.f.icon_mine_list_member, e.j.member_center, 12));
        this.grL = W(e.f.icon_mine_list_gift, e.j.my_gift, 10);
        this.grL.grS = new h();
        this.grL.grS.grX = true;
        this.grL.grS.grY = this.mUserData.getTDouNum();
        this.ebb.add(this.grL);
        this.ebb.add(W(e.f.icon_mine_list_card, e.j.card_box, 18));
        f W4 = W(e.f.icon_mine_list_grade, e.j.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            W4.aou = this.mUserData.membershipInfo.mLink;
        }
        this.ebb.add(W4);
        boolean Gi = TbadkCoreApplication.getInst().getActivityPrizeData().Gi();
        String Gj = TbadkCoreApplication.getInst().getActivityPrizeData().Gj();
        if (Gi && !StringUtils.isNull(Gj)) {
            this.grM = f(e.f.icon_mine_list_logingift, Gj, 38);
            this.grM.grR = true;
            this.grM.grS = new h();
            this.ebb.add(this.grM);
            TiebaStatic.log(new am("c12597"));
        } else {
            W4.grR = true;
        }
        this.ebb.add(W(e.f.icon_mine_list_hot, e.j.hot_topic, 30));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            f W5 = W(e.f.icon_mine_list_live, e.j.ala_live, 25);
            W5.grR = true;
            this.ebb.add(W5);
        }
        this.grN = W(e.f.icon_mine_list_service, e.j.person_service_centre, 31);
        this.grN.grR = true;
        this.ebb.add(this.grN);
        this.ebb.add(W(e.f.icon_mine_bdcard_72, e.j.baidu_singkil, 39));
        f W6 = W(e.f.icon_mine_list_more, e.j.more, 33);
        W6.grS = new h();
        W6.grS.grZ = TbadkCoreApplication.getInst().getString(e.j.person_center_more_desc);
        if (this.grc == null) {
            this.grc = new PersonMoreData();
        }
        W6.grT = OrmObject.bundleWithObject(this.grc);
        W6.grR = true;
        this.ebb.add(W6);
    }

    private f W(int i, int i2, int i3) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = TbadkCoreApplication.getInst().getString(i2);
        fVar.type = i3;
        if (this.mUserData != null) {
            fVar.fPU = this.mUserData;
        }
        return fVar;
    }

    private f f(int i, String str, int i2) {
        f fVar = new f();
        fVar.iconId = i;
        fVar.title = str;
        fVar.type = i2;
        if (this.mUserData != null) {
            fVar.fPU = this.mUserData;
        }
        return fVar;
    }

    public void b(j jVar) {
        this.mUserData.setPendantData(jVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void lY(boolean z) {
        if (this.grK != null) {
            if (this.grK.grS == null) {
                this.grK.grS = new h();
            }
            this.grK.grS.grW = z;
        }
    }

    public void lZ(boolean z) {
        if (this.grN != null) {
            if (this.grN.grS == null) {
                this.grN.grS = new h();
            }
            this.grN.grS.grW = z;
        }
    }

    public void ma(boolean z) {
        if (this.grM != null) {
            if (this.grM.grS == null) {
                this.grM.grS = new h();
            }
            this.grM.grS.grW = z;
        }
    }

    public void mb(boolean z) {
        if (this.grQ != null) {
            this.grQ.grE = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.grO = new g();
            this.grH = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            ds(profileResIdl.data.url_map);
            this.ebb.add(this.grO);
            boE();
            boG();
            boF();
            boH();
            com.baidu.tieba.o.a.bvI().mQ(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.grO = new g();
            this.grO.fPU = this.mUserData;
            this.ebb.add(this.grO);
            boE();
            boH();
            com.baidu.tieba.o.a.bvI().mQ(true);
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
        if (this.grI == null && userGodInfo != null) {
            this.grI = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.grI.parserProtobuf(userGodInfo);
        }
        this.grO.fPU = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.grJ = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void ds(List<UserMap> list) {
        if (!v.I(list)) {
            this.grc = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.grc.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
