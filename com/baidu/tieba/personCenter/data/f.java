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
    public ArrayList<com.baidu.adp.widget.ListView.m> fPU = new ArrayList<>();
    private List<BannerImage> ilI;
    private PersonUserGodInfo ilJ;
    public com.baidu.tieba.person.data.d ilK;
    public g ilL;
    public g ilM;
    public g ilN;
    public g ilO;
    public h ilP;
    public m ilQ;
    public j ilR;
    private d ilS;
    public PersonMoreData ilc;
    private UserData mUserData;

    private void bZo() {
        if (this.ilS != null) {
            this.fPU.add(this.ilS);
        } else if (this.mUserData != null) {
            this.ilS = new d();
            this.ilS.ilC = this.mUserData.getFansNum();
            this.ilS.ilD = this.mUserData.getConcern_num();
            this.ilS.ilE = this.mUserData.getLike_bars();
            this.ilS.threadNum = this.mUserData.getThreadNum();
            this.ilS.userData = this.mUserData;
            this.fPU.add(this.ilS);
        }
    }

    private void bZp() {
        if (this.ilQ != null) {
            this.fPU.add(this.ilQ);
            return;
        }
        this.ilQ = new m();
        if (!v.isEmpty(this.ilI)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.ilI.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.ilI.get(i2));
                if (!aq.isEmpty(aVar.bZn())) {
                    this.ilQ.ilI.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.ilQ.ilI.size() > 0) {
                this.fPU.add(this.ilQ);
            }
        }
    }

    private void bZq() {
        this.fPU.add(new e());
    }

    private void eb(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.ilR == null) {
                this.ilR = new j();
                this.fPU.add(this.ilR);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.ilR.setData(arrayList);
        }
    }

    private void bZr() {
        if (this.ilL == null) {
            this.ilL = T(R.drawable.icon_pure_wo_list_collect_n_svg, R.string.my_mark, 16);
            this.ilL.ilU = true;
            this.ilL.ilW = new i();
        }
        this.fPU.add(this.ilL);
        g T = T(R.drawable.icon_pure_wo_list_history_n_svg, R.string.my_history, 17);
        T.ilU = true;
        this.fPU.add(T);
        g T2 = T(R.drawable.icon_pure_wo_list_group_n_svg, R.string.my_groups, 22);
        T2.ilV = true;
        T2.ilU = true;
        this.fPU.add(T2);
        g T3 = T(R.drawable.icon_pure_wo_list_youqianhua_n_svg, R.string.borrow_cash, 37);
        T3.ilU = true;
        T3.ilW = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            T3.ilW.isShowRedTip = true;
        }
        T3.ilW.imd = true;
        this.fPU.add(T3);
        if (com.baidu.tbadk.core.sharedPref.b.alR().getInt("baidu_financial_display", 1) == 1) {
            g T4 = T(R.drawable.icon_pure_wo_list_duxiaoman_n_svg, R.string.baidu_financial, 41);
            T4.ilU = true;
            if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_baidu_financial_has_clicked", false)) {
                T4.ilW = new i();
                T4.ilW.isShowRedTip = true;
            }
            this.fPU.add(T4);
        }
        if (ao.isOn()) {
            g T5 = T(R.drawable.icon_pure_wo_list_task_n_svg, R.string.person_task_center_entrance, 43);
            T5.ilU = true;
            this.fPU.add(T5);
        }
        g T6 = T(R.drawable.icon_pure_wo_list_member_n_svg, R.string.member_center, 12);
        T6.ilU = true;
        this.fPU.add(T6);
        this.ilM = T(R.drawable.icon_pure_wo_list_gift_n_svg, R.string.my_gift, 10);
        this.ilM.ilW = new i();
        this.ilM.ilU = true;
        this.ilM.ilW.ima = true;
        this.ilM.ilW.imb = this.mUserData.getTDouNum();
        this.fPU.add(this.ilM);
        g T7 = T(R.drawable.icon_pure_wo_list_cardbag_n_svg, R.string.card_box, 18);
        T7.ilU = true;
        this.fPU.add(T7);
        if (this.mUserData != null && this.mUserData.isShowRedPacket) {
            g T8 = T(R.drawable.icon_mine_list_myredbag, R.string.red_packet, 42);
            if (!com.baidu.tbadk.core.sharedPref.b.alR().getBoolean("key_has_my_redpacket_clicked", false)) {
                T8.ilW = new i();
                T8.ilW.isShowRedTip = true;
            }
            this.fPU.add(T8);
        }
        g T9 = T(R.drawable.icon_pure_wo_list_diamond_n_svg, R.string.blue_diamond, 11);
        T9.ilU = true;
        if (this.mUserData.membershipInfo != null) {
            T9.bWc = this.mUserData.membershipInfo.mLink;
        }
        this.fPU.add(T9);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.ilN = g(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.ilN.ilV = true;
            this.ilN.ilW = new i();
            this.fPU.add(this.ilN);
            TiebaStatic.log(new an("c12597"));
        } else {
            T9.ilV = true;
        }
        g T10 = T(R.drawable.icon_pure_wo_list_topic_n_svg, R.string.hot_topic, 30);
        T10.ilU = true;
        this.fPU.add(T10);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g T11 = T(R.drawable.icon_pure_wo_list_game_n_svg, R.string.lite_game, 44);
            T11.ilU = true;
            this.fPU.add(T11);
        }
        if (MessageManager.getInstance().findTask(2921421) != null) {
            g T12 = T(R.drawable.icon_mine_list_live, R.string.ala_live, 25);
            T12.ilV = true;
            this.fPU.add(T12);
        }
        this.ilO = T(R.drawable.icon_pure_wo_list_serve_n_svg, R.string.person_service_centre, 31);
        this.ilO.ilV = true;
        this.ilO.ilU = true;
        this.fPU.add(this.ilO);
        g T13 = T(R.drawable.icon_pure_wo_list_exempt_n_svg, R.string.baidu_singkil, 39);
        T13.ilU = true;
        this.fPU.add(T13);
        g T14 = T(R.drawable.icon_pure_wo_list_more_n_svg, R.string.more, 33);
        T14.ilU = true;
        T14.ilW = new i();
        T14.ilW.imc = TbadkCoreApplication.getInst().getString(R.string.person_center_more_desc);
        if (this.ilc == null) {
            this.ilc = new PersonMoreData();
        }
        T14.ilX = OrmObject.bundleWithObject(this.ilc);
        this.fPU.add(T14);
    }

    private g T(int i, int i2, int i3) {
        g gVar = new g();
        gVar.ilT = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g g(int i, String str, int i2) {
        g gVar = new g();
        gVar.ilT = i;
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
        if (this.ilL != null) {
            if (this.ilL.ilW == null) {
                this.ilL.ilW = new i();
            }
            this.ilL.ilW.isShowRedTip = z;
        }
    }

    public void pq(boolean z) {
        if (this.ilO != null) {
            if (this.ilO.ilW == null) {
                this.ilO.ilW = new i();
            }
            this.ilO.ilW.isShowRedTip = z;
        }
    }

    public void pr(boolean z) {
        if (this.ilN != null) {
            if (this.ilN.ilW == null) {
                this.ilN.ilW = new i();
            }
            this.ilN.ilW.isShowRedTip = z;
        }
    }

    public void ps(boolean z) {
        if (this.ilS != null) {
            this.ilS.ilF = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.ilP = new h();
            this.ilI = profileResIdl.data.banner;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            ec(profileResIdl.data.url_map);
            this.fPU.add(this.ilP);
            bZo();
            bZq();
            eb(profileResIdl.data.recom_swan_list);
            bZp();
            bZr();
            com.baidu.tieba.o.a.chd().ql(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.ilP = new h();
            this.ilP.userData = this.mUserData;
            this.fPU.add(this.ilP);
            bZo();
            bZr();
            com.baidu.tieba.o.a.chd().ql(true);
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
        if (this.ilJ == null && userGodInfo != null) {
            this.ilJ = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.ilJ.parserProtobuf(userGodInfo);
        }
        this.ilP.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.ilK = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void ec(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.ilc = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ilc.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
