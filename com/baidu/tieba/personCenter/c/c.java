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
    public Bundle eZI;
    private PersonUserGodInfo fae;
    public com.baidu.tieba.person.data.d faf;
    public com.baidu.tieba.person.data.e fag;
    public e fah;
    public e fai;
    public f faj;
    public ArrayList<com.baidu.adp.widget.ListView.f> fak = new ArrayList<>();
    private a fal;
    private UserData mUserData;

    private void aVl() {
        if (this.fal != null) {
            this.fak.add(this.fal);
        } else if (this.mUserData != null) {
            this.fal = new a();
            this.fal.eZY = this.mUserData.getFansNum();
            this.fal.eZZ = this.mUserData.getConcern_num();
            this.fal.faa = this.mUserData.getLike_bars();
            this.fal.threadNum = this.mUserData.getThreadNum();
            this.fal.eyj = this.mUserData;
            this.fak.add(this.fal);
        }
    }

    private void aVm() {
        this.fak.add(new b());
        if (this.fah == null) {
            this.fah = S(d.g.icon_mine_list_collect, d.l.my_mark, 16);
            this.fah.fap = new g();
        }
        this.fak.add(this.fah);
        this.fak.add(S(d.g.icon_mine_list_history, d.l.my_history, 17));
        e S = S(d.g.icon_mine_list_friend, d.l.my_groups, 22);
        S.fao = true;
        this.fak.add(S);
        this.fak.add(S(d.g.icon_mine_list_member, d.l.member_center, 12));
        this.fai = S(d.g.icon_mine_list_gift, d.l.my_gift, 10);
        this.fai.fap = new g();
        this.fai.fap.fav = true;
        this.fai.fap.faw = this.mUserData.getTDouNum();
        this.fak.add(this.fai);
        this.fak.add(S(d.g.icon_mine_list_card, d.l.card_box, 18));
        e S2 = S(d.g.icon_mine_list_grade, d.l.blue_diamond, 11);
        if (this.mUserData.membershipInfo != null) {
            S2.cRn = this.mUserData.membershipInfo.mLink;
        }
        this.fak.add(S2);
        e S3 = S(d.g.borrow_cash, d.l.borrow_cash, 37);
        S3.fao = true;
        this.fak.add(S3);
        this.fak.add(S(d.g.icon_mine_list_hot, d.l.hot_topic, 31));
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            e S4 = S(d.g.icon_mine_list_live, d.l.ala_live, 26);
            S4.fao = true;
            this.fak.add(S4);
        }
        this.fak.add(S(d.g.icon_mine_list_service, d.l.person_service_centre, 32));
        e S5 = S(d.g.icon_mine_list_feedback, d.l.feedback, 25);
        S5.fao = true;
        this.fak.add(S5);
        e S6 = S(d.g.icon_mine_list_more, d.l.more, 34);
        S6.fap = new g();
        S6.fap.fax = TbadkCoreApplication.getInst().getString(d.l.person_center_more_desc);
        if (this.eZI == null) {
            this.eZI = new Bundle();
        }
        this.eZI.putString(PersonMoreActivityConfig.CONSUME_RECORD, this.fag.eZp);
        if (this.faf != null) {
            this.eZI.putString(PersonMoreActivityConfig.BOOK_SHELF, this.faf.eZj);
        }
        S6.faq = this.eZI;
        S6.fao = true;
        this.fak.add(S6);
    }

    private e S(int i, int i2, int i3) {
        e eVar = new e();
        eVar.iconId = i;
        eVar.title = TbadkCoreApplication.getInst().getString(i2);
        eVar.type = i3;
        if (this.mUserData != null) {
            eVar.eyj = this.mUserData;
        }
        return eVar;
    }

    public void setUserPendantData(i iVar) {
        this.mUserData.setPendantData(iVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void kc(boolean z) {
        if (this.fah != null) {
            if (this.fah.fap == null) {
                this.fah.fap = new g();
            }
            this.fah.fap.fau = z;
        }
    }

    public void kd(boolean z) {
        if (this.fal != null) {
            this.fal.fab = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.faj = new f();
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            cC(profileResIdl.data.url_map);
            this.fak.add(this.faj);
            aVl();
            aVm();
            com.baidu.tieba.j.a.bgJ().lI(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.faj = new f();
            this.faj.eyj = this.mUserData;
            this.fak.add(this.faj);
            aVl();
            aVm();
            com.baidu.tieba.j.a.bgJ().lI(true);
        }
    }

    private void a(User user, UserGodInfo userGodInfo) {
        if (this.mUserData == null) {
            this.mUserData = new UserData();
        }
        this.mUserData.parserProtobuf(user);
        if (this.fae == null && userGodInfo != null) {
            this.fae = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.fae.parserProtobuf(userGodInfo);
        }
        this.faj.eyj = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.faf = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        com.baidu.tieba.person.g gVar = new com.baidu.tieba.person.g();
        gVar.a(ucCard);
        this.fag = new com.baidu.tieba.person.data.e();
        this.fag.cz(gVar.eYT);
    }

    private void cC(List<UserMap> list) {
        if (!v.u(list)) {
            this.eZI = new Bundle();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    this.eZI.putString(userMap.name, userMap.url.replaceAll("amp;", ""));
                }
            }
        }
    }
}
