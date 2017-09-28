package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PersonMoreActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes.dex */
public class c implements com.baidu.tieba.person.b {
    public Bundle eZW;
    private a faA;
    private PersonUserGodInfo fat;
    public com.baidu.tieba.person.data.d fau;
    public com.baidu.tieba.person.data.e fav;
    public e faw;
    public e fax;
    public f fay;
    public ArrayList<com.baidu.adp.widget.ListView.f> faz = new ArrayList<>();
    private UserData mUserData;

    private void aVq() {
        if (this.faA != null) {
            this.faz.add(this.faA);
        } else if (this.mUserData != null) {
            this.faA = new a();
            this.faA.fan = this.mUserData.getFansNum();
            this.faA.fao = this.mUserData.getConcern_num();
            this.faA.fap = this.mUserData.getLike_bars();
            this.faA.threadNum = this.mUserData.getThreadNum();
            this.faA.eyy = this.mUserData;
            this.faz.add(this.faA);
        }
    }

    private void aVr() {
        this.faz.add(new b());
        if (this.faw == null) {
            this.faw = S(d.g.icon_mine_list_collect, d.l.my_mark, 16);
            this.faw.faE = new g();
        }
        this.faz.add(this.faw);
        this.faz.add(S(d.g.icon_mine_list_history, d.l.my_history, 17));
        e S = S(d.g.icon_mine_list_friend, d.l.my_groups, 22);
        S.faD = true;
        this.faz.add(S);
        this.faz.add(S(d.g.icon_mine_list_member, d.l.member_center, 12));
        this.fax = S(d.g.icon_mine_list_gift, d.l.my_gift, 10);
        this.fax.faE = new g();
        this.fax.faE.faK = true;
        this.fax.faE.faL = this.mUserData.getTDouNum();
        this.faz.add(this.fax);
        this.faz.add(S(d.g.icon_mine_list_card, d.l.card_box, 18));
        e S2 = S(d.g.icon_mine_list_grade, d.l.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S2.cRz = this.mUserData.membershipInfo.mLink;
        }
        S2.faD = true;
        this.faz.add(S2);
        this.faz.add(S(d.g.icon_mine_list_hot, d.l.hot_topic, 31));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S3 = S(d.g.icon_mine_list_live, d.l.ala_live, 26);
            S3.faD = true;
            this.faz.add(S3);
        }
        this.faz.add(S(d.g.icon_mine_list_service, d.l.person_service_centre, 32));
        e S4 = S(d.g.icon_mine_list_feedback, d.l.feedback, 25);
        S4.faD = true;
        this.faz.add(S4);
        e S5 = S(d.g.icon_mine_list_more, d.l.more, 34);
        S5.faE = new g();
        S5.faE.faM = TbadkCoreApplication.getInst().getString(d.l.person_center_more_desc);
        if (this.eZW == null) {
            this.eZW = new Bundle();
        }
        this.eZW.putString(PersonMoreActivityConfig.CONSUME_RECORD, this.fav.eZD);
        this.eZW.putString(PersonMoreActivityConfig.BOOK_SHELF, this.fau.eZx);
        S5.faF = this.eZW;
        S5.faD = true;
        this.faz.add(S5);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.eyy = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(i iVar) {
        this.mUserData.setPendantData(iVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kd(boolean z) {
        if (this.faw != null) {
            if (this.faw.faE == null) {
                this.faw.faE = new g();
            }
            this.faw.faE.faJ = z;
        }
    }

    public void ke(boolean z) {
        if (this.faA != null) {
            this.faA.faq = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.fay = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cC(profileResIdl.data.url_map);
            this.faz.add(this.fay);
            aVq();
            aVr();
            com.baidu.tieba.j.a.bgP().lJ(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.fay = new f();
            this.fay.eyy = this.mUserData;
            this.faz.add(this.fay);
            aVq();
            aVr();
            com.baidu.tieba.j.a.bgP().lJ(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fat == null && userGodInfo != null) {
            this.fat = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fat.parserProtobuf(userGodInfo);
        }
        this.fay.eyy = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.fau = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        com.baidu.tieba.person.g gVar = new com.baidu.tieba.person.g();
        gVar.a(ucCard);
        this.fav = new com.baidu.tieba.person.data.e();
        this.fav.cz(gVar.eZh);
    }

    private void cC(List<UserMap> list) {
        if (!v.u(list)) {
            this.eZW = new Bundle();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    this.eZW.putString(userMap.name, userMap.url.replaceAll("amp;", ""));
                }
            }
        }
    }
}
