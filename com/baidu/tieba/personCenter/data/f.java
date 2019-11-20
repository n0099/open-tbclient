package com.baidu.tieba.personCenter.data;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.t.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes4.dex */
public class f implements com.baidu.tieba.person.b {
    public ArrayList<com.baidu.adp.widget.ListView.m> fPd = new ArrayList<>();
    private List<BannerImage> ikR;
    private PersonUserGodInfo ikS;
    public com.baidu.tieba.person.data.d ikT;
    public g ikU;
    public g ikV;
    public g ikW;
    public g ikX;
    public h ikY;
    public m ikZ;
    public PersonMoreData ikl;
    public j ila;
    private d ilb;
    private UserData mUserData;

    private void bZm() {
        if (this.ilb != null) {
            this.fPd.add(this.ilb);
        } else if (this.mUserData != null) {
            this.ilb = new d();
            this.ilb.ikL = this.mUserData.getFansNum();
            this.ilb.ikM = this.mUserData.getConcern_num();
            this.ilb.ikN = this.mUserData.getLike_bars();
            this.ilb.threadNum = this.mUserData.getThreadNum();
            this.ilb.userData = this.mUserData;
            this.fPd.add(this.ilb);
        }
    }

    private void bZn() {
        if (this.ikZ != null) {
            this.fPd.add(this.ikZ);
            return;
        }
        this.ikZ = new m();
        if (!v.isEmpty(this.ikR)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ikR.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.ikR.get(i2));
                if (!aq.isEmpty(aVar.bZl())) {
                    this.ikZ.ikR.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.ikZ.ikR.size() > 0) {
                this.fPd.add(this.ikZ);
            }
        }
    }

    private void bZo() {
        this.fPd.add(new e());
    }

    private void eb(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.ila == null) {
                this.ila = new j();
                this.fPd.add(this.ila);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.ila.setData(arrayList);
        }
    }

    private void bZp() {
        if (this.ikU == null) {
            this.ikU = T(R.drawable.icon_pure_wo_list_collect_n_svg, R.string.my_mark, 16);
            this.ikU.ild = true;
            this.ikU.ilf = new i();
        }
        this.fPd.add(this.ikU);
        g T = T(R.drawable.icon_pure_wo_list_history_n_svg, R.string.my_history, 17);
        T.ild = true;
        this.fPd.add(T);
        g T2 = T(R.drawable.icon_pure_wo_list_group_n_svg, R.string.my_groups, 22);
        T2.ile = true;
        T2.ild = true;
        this.fPd.add(T2);
        g T3 = T(R.drawable.icon_pure_wo_list_youqianhua_n_svg, R.string.borrow_cash, 37);
        T3.ild = true;
        T3.ilf = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            T3.ilf.isShowRedTip = true;
        }
        T3.ilf.ilm = true;
        this.fPd.add(T3);
        if (com.baidu.tbadk.core.sharedPref.b.alP().getInt("baidu_financial_display", 1) == 1) {
            g T4 = T(R.drawable.icon_pure_wo_list_duxiaoman_n_svg, R.string.baidu_financial, 41);
            T4.ild = true;
            if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_baidu_financial_has_clicked", false)) {
                T4.ilf = new i();
                T4.ilf.isShowRedTip = true;
            }
            this.fPd.add(T4);
        }
        if (ao.isOn()) {
            g T5 = T(R.drawable.icon_pure_wo_list_task_n_svg, R.string.person_task_center_entrance, 43);
            T5.ild = true;
            this.fPd.add(T5);
        }
        g T6 = T(R.drawable.icon_pure_wo_list_member_n_svg, R.string.member_center, 12);
        T6.ild = true;
        this.fPd.add(T6);
        this.ikV = T(R.drawable.icon_pure_wo_list_gift_n_svg, R.string.my_gift, 10);
        this.ikV.ilf = new i();
        this.ikV.ild = true;
        this.ikV.ilf.ilj = true;
        this.ikV.ilf.ilk = this.mUserData.getTDouNum();
        this.fPd.add(this.ikV);
        g T7 = T(R.drawable.icon_pure_wo_list_cardbag_n_svg, R.string.card_box, 18);
        T7.ild = true;
        this.fPd.add(T7);
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g T8 = T(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.alP().getBoolean("key_has_my_redpacket_clicked", false)) {
                T8.ilf = new i();
                T8.ilf.isShowRedTip = true;
            }
            this.fPd.add(T8);
        }
        g T9 = T(R.drawable.icon_pure_wo_list_diamond_n_svg, R.string.blue_diamond, 11);
        T9.ild = true;
        if (this.mUserData.membershipInfo != null) {
            T9.bVl = this.mUserData.membershipInfo.mLink;
        }
        this.fPd.add(T9);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.ikW = g(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.ikW.ile = true;
            this.ikW.ilf = new i();
            this.fPd.add(this.ikW);
            TiebaStatic.log(new an("c12597"));
        } else {
            T9.ile = true;
        }
        g T10 = T(R.drawable.icon_pure_wo_list_topic_n_svg, R.string.hot_topic, 30);
        T10.ild = true;
        this.fPd.add(T10);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g T11 = T(R.drawable.icon_pure_wo_list_game_n_svg, R.string.lite_game, 44);
            T11.ild = true;
            this.fPd.add(T11);
        }
        if (MessageManager.getInstance().findTask(2921421) != null) {
            g T12 = T(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            T12.ile = true;
            this.fPd.add(T12);
        }
        this.ikX = T(R.drawable.icon_pure_wo_list_serve_n_svg, R.string.person_service_centre, 31);
        this.ikX.ile = true;
        this.ikX.ild = true;
        this.fPd.add(this.ikX);
        g T13 = T(R.drawable.icon_pure_wo_list_exempt_n_svg, R.string.baidu_singkil, 39);
        T13.ild = true;
        this.fPd.add(T13);
        g T14 = T(R.drawable.icon_pure_wo_list_more_n_svg, R.string.more, 33);
        T14.ild = true;
        T14.ilf = new i();
        T14.ilf.ill = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.ikl == null) {
            this.ikl = new PersonMoreData();
        }
        T14.ilg = OrmObject.bundleWithObject(this.ikl);
        this.fPd.add(T14);
    }

    private g T(int i, int i2, int i3) {
        g gVar = new g();
        gVar.ilc = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g g(int i, String str, int i2) {
        g gVar = new g();
        gVar.ilc = i;
        gVar.title = str;
        gVar.type = i2;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        this.mUserData.setPendantData(lVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void pp(boolean z) {
        if (this.ikU != null) {
            if (this.ikU.ilf == null) {
                this.ikU.ilf = new i();
            }
            this.ikU.ilf.isShowRedTip = z;
        }
    }

    public void pq(boolean z) {
        if (this.ikX != null) {
            if (this.ikX.ilf == null) {
                this.ikX.ilf = new i();
            }
            this.ikX.ilf.isShowRedTip = z;
        }
    }

    public void pr(boolean z) {
        if (this.ikW != null) {
            if (this.ikW.ilf == null) {
                this.ikW.ilf = new i();
            }
            this.ikW.ilf.isShowRedTip = z;
        }
    }

    public void ps(boolean z) {
        if (this.ilb != null) {
            this.ilb.ikO = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ikY = new h();
            this.ikR = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            ec(profileResIdl.data.url_map);
            this.fPd.add(this.ikY);
            bZm();
            bZo();
            eb(profileResIdl.data.recom_swan_list);
            bZn();
            bZp();
            com.baidu.tieba.o.a.chb().ql(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ikY = new h();
            this.ikY.userData = this.mUserData;
            this.fPd.add(this.ikY);
            bZm();
            bZp();
            com.baidu.tieba.o.a.chb().ql(true);
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
        if (this.ikS == null && userGodInfo != null) {
            this.ikS = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ikS.parserProtobuf(userGodInfo);
        }
        this.ikY.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.ikT = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void ec(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.ikl = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ikl.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
