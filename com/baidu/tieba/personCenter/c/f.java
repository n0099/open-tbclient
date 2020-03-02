package com.baidu.tieba.personCenter.c;

import android.support.annotation.StringRes;
import android.text.TextUtils;
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
import com.baidu.tbadk.switchs.MissionEntranceSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.BannerImage;
import tbclient.Personal.PersonalResIdl;
import tbclient.Profile.Duxiaoman;
import tbclient.Profile.ProfileResIdl;
import tbclient.Profile.UserGodInfo;
import tbclient.SmartApp;
import tbclient.TbBookrack;
import tbclient.UcCard;
import tbclient.User;
import tbclient.UserMap;
/* loaded from: classes9.dex */
public class f implements com.baidu.tieba.person.b {
    private ArrayList<com.baidu.adp.widget.ListView.m> gIG = new ArrayList<>();
    public PersonMoreData jgJ;
    private Duxiaoman jho;
    private List<BannerImage> jhp;
    private PersonUserGodInfo jhq;
    private d jhr;
    public com.baidu.tieba.person.data.d jhs;
    public g jht;
    public g jhu;
    public g jhv;
    public g jhw;
    public h jhx;
    public m jhy;
    public j jhz;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> cvi() {
        return this.gIG;
    }

    private void cvj() {
        if (this.jhr != null) {
            this.gIG.add(this.jhr);
        } else if (this.mUserData != null) {
            this.jhr = new d();
            this.jhr.jhi = this.mUserData.getFansNum();
            this.jhr.jhj = this.mUserData.getConcern_num();
            this.jhr.jhk = this.mUserData.getLike_bars();
            this.jhr.threadNum = this.mUserData.getThreadNum();
            this.jhr.userData = this.mUserData;
            this.gIG.add(this.jhr);
        }
    }

    private void cvk() {
        if (this.jhy != null) {
            this.gIG.add(this.jhy);
            return;
        }
        this.jhy = new m();
        if (!v.isEmpty(this.jhp)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jhp.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jhp.get(i2));
                if (!aq.isEmpty(aVar.cvh())) {
                    this.jhy.jhp.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jhy.jhp.size() > 0) {
                this.gIG.add(this.jhy);
            }
        }
    }

    private void dM(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jhz == null) {
                this.jhz = new j();
                this.gIG.add(this.jhz);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jhz.setData(arrayList);
        }
    }

    private void cvl() {
        if (this.jht == null) {
            this.jht = U(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jht.jhA = true;
            this.jht.jhD = new i();
        }
        this.gIG.add(this.jht);
        g U = U(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        U.jhA = true;
        this.gIG.add(U);
        g U2 = U(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        U2.jhC = true;
        U2.jhA = true;
        this.gIG.add(U2);
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.bMD() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g U3 = U(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            U3.jhA = true;
            U3.cLR = this.mLiveGoodsWindowData.goods_url;
            this.gIG.add(U3);
        }
        g U4 = U(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        U4.jhA = true;
        U4.jhD = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            U4.jhD.isShowRedTip = true;
        }
        U4.jhD.jhL = true;
        this.gIG.add(U4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g U5 = U(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            U5.jhA = true;
            U5.cLR = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gIG.add(U5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFD().getInt("baidu_financial_display", 1) == 1) {
            g U6 = U(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            U6.jhA = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aFD().getBoolean("key_baidu_financial_has_clicked", false)) {
                U6.jhD = new i();
                U6.jhD.isShowRedTip = true;
            }
            this.gIG.add(U6);
        }
        if (this.jho != null && this.jho.is_end.intValue() != 1) {
            g U7 = U(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            U7.jhA = true;
            U7.cLR = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jho.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                U7.jhD = iVar;
            }
            this.gIG.add(U7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g U8 = U(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            U8.jhA = true;
            this.gIG.add(U8);
        }
        g U9 = U(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        U9.jhA = true;
        this.gIG.add(U9);
        this.jhu = U(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jhu.jhD = new i();
        this.jhu.jhA = true;
        this.jhu.jhD.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jhu.jhD.jhI = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gIG.add(this.jhu);
        g U10 = U(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        U10.jhA = true;
        this.gIG.add(U10);
        g U11 = U(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        U11.jhA = true;
        if (this.mUserData.membershipInfo != null) {
            U11.cLR = this.mUserData.membershipInfo.mLink;
        }
        this.gIG.add(U11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jhv = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jhv.jhC = true;
            this.jhv.jhD = new i();
            this.gIG.add(this.jhv);
            TiebaStatic.log(new an("c12597"));
        } else {
            U11.jhC = true;
        }
        g U12 = U(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        U12.jhA = true;
        this.gIG.add(U12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g U13 = U(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            U13.jhA = true;
            U13.jhC = true;
            this.gIG.add(U13);
        }
        this.jhw = U(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jhw.jhC = true;
        this.jhw.jhA = true;
        this.gIG.add(this.jhw);
        g U14 = U(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        U14.jhA = true;
        this.gIG.add(U14);
        if (this.jgJ == null) {
            this.jgJ = new PersonMoreData();
        }
        g U15 = U(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        U15.jhA = true;
        U15.jhB = true;
        U15.jhE = OrmObject.bundleWithObject(this.jgJ);
        U15.jhD = new i();
        List<PersonMoreItemData> list = this.jgJ.mUrlMaps;
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (PersonMoreItemData personMoreItemData : list) {
                if (personMoreItemData != null && !TextUtils.isEmpty(personMoreItemData.mName)) {
                    sb.append(personMoreItemData.mName).append("、");
                }
            }
            if (sb.toString().endsWith("、")) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (!TextUtils.isEmpty(sb.toString())) {
                U15.jhD.jhH = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gIG.add(U15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g U(int i, int i2, int i3) {
        g gVar = new g();
        gVar.iconId = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g k(int i, String str, int i2) {
        g gVar = new g();
        gVar.iconId = i;
        gVar.title = str;
        gVar.type = i2;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    public void a(com.baidu.tbadk.data.m mVar) {
        this.mUserData.setPendantData(mVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void ri(boolean z) {
        if (this.jht != null) {
            if (this.jht.jhD == null) {
                this.jht.jhD = new i();
            }
            this.jht.jhD.isShowRedTip = z;
        }
    }

    public void rj(boolean z) {
        if (this.jhw != null) {
            if (this.jhw.jhD == null) {
                this.jhw.jhD = new i();
            }
            this.jhw.jhD.isShowRedTip = z;
        }
    }

    public void rk(boolean z) {
        if (this.jhv != null) {
            if (this.jhv.jhD == null) {
                this.jhv.jhD = new i();
            }
            this.jhv.jhD.isShowRedTip = z;
        }
    }

    public void rl(boolean z) {
        if (this.jhr != null) {
            this.jhr.jhl = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jhx = new h();
            this.jhp = profileResIdl.data.banner;
            this.jho = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dN(profileResIdl.data.url_map);
            this.gIG.add(this.jhx);
            cvj();
            dM(profileResIdl.data.recom_swan_list);
            cvk();
            cvl();
            com.baidu.tieba.p.a.cDP().sj(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jhx = new h();
            this.jhx.userData = this.mUserData;
            this.gIG.add(this.jhx);
            cvj();
            cvl();
            com.baidu.tieba.p.a.cDP().sj(true);
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
        if (this.jhq == null && userGodInfo != null) {
            this.jhq = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jhq.parserProtobuf(userGodInfo);
        }
        this.jhx.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jhs = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dN(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jgJ = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jgJ.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
