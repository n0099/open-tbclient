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
    private ArrayList<com.baidu.adp.widget.ListView.m> gJX = new ArrayList<>();
    public PersonMoreData jiv;
    private Duxiaoman jja;
    private List<BannerImage> jjb;
    private PersonUserGodInfo jjc;
    private d jjd;
    public com.baidu.tieba.person.data.d jje;
    public g jjf;
    public g jjg;
    public g jjh;
    public g jji;
    public h jjj;
    public m jjk;
    public j jjl;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> cvC() {
        return this.gJX;
    }

    private void cvD() {
        if (this.jjd != null) {
            this.gJX.add(this.jjd);
        } else if (this.mUserData != null) {
            this.jjd = new d();
            this.jjd.jiU = this.mUserData.getFansNum();
            this.jjd.jiV = this.mUserData.getConcern_num();
            this.jjd.jiW = this.mUserData.getLike_bars();
            this.jjd.threadNum = this.mUserData.getThreadNum();
            this.jjd.userData = this.mUserData;
            this.gJX.add(this.jjd);
        }
    }

    private void cvE() {
        if (this.jjk != null) {
            this.gJX.add(this.jjk);
            return;
        }
        this.jjk = new m();
        if (!v.isEmpty(this.jjb)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jjb.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jjb.get(i2));
                if (!aq.isEmpty(aVar.cvB())) {
                    this.jjk.jjb.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jjk.jjb.size() > 0) {
                this.gJX.add(this.jjk);
            }
        }
    }

    private void dM(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jjl == null) {
                this.jjl = new j();
                this.gJX.add(this.jjl);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jjl.setData(arrayList);
        }
    }

    private void cvF() {
        if (this.jjf == null) {
            this.jjf = U(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jjf.jjm = true;
            this.jjf.jjp = new i();
        }
        this.gJX.add(this.jjf);
        g U = U(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        U.jjm = true;
        this.gJX.add(U);
        g U2 = U(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        U2.jjo = true;
        U2.jjm = true;
        this.gJX.add(U2);
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.bMS() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g U3 = U(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            U3.jjm = true;
            U3.cMd = this.mLiveGoodsWindowData.goods_url;
            this.gJX.add(U3);
        }
        g U4 = U(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        U4.jjm = true;
        U4.jjp = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            U4.jjp.isShowRedTip = true;
        }
        U4.jjp.jjx = true;
        this.gJX.add(U4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g U5 = U(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            U5.jjm = true;
            U5.cMd = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gJX.add(U5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFH().getInt("baidu_financial_display", 1) == 1) {
            g U6 = U(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            U6.jjm = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aFH().getBoolean("key_baidu_financial_has_clicked", false)) {
                U6.jjp = new i();
                U6.jjp.isShowRedTip = true;
            }
            this.gJX.add(U6);
        }
        if (this.jja != null && this.jja.is_end.intValue() != 1) {
            g U7 = U(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            U7.jjm = true;
            U7.cMd = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jja.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                U7.jjp = iVar;
            }
            this.gJX.add(U7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g U8 = U(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            U8.jjm = true;
            this.gJX.add(U8);
        }
        g U9 = U(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        U9.jjm = true;
        this.gJX.add(U9);
        this.jjg = U(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jjg.jjp = new i();
        this.jjg.jjm = true;
        this.jjg.jjp.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jjg.jjp.jju = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gJX.add(this.jjg);
        g U10 = U(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        U10.jjm = true;
        this.gJX.add(U10);
        g U11 = U(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        U11.jjm = true;
        if (this.mUserData.membershipInfo != null) {
            U11.cMd = this.mUserData.membershipInfo.mLink;
        }
        this.gJX.add(U11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jjh = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jjh.jjo = true;
            this.jjh.jjp = new i();
            this.gJX.add(this.jjh);
            TiebaStatic.log(new an("c12597"));
        } else {
            U11.jjo = true;
        }
        g U12 = U(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        U12.jjm = true;
        this.gJX.add(U12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g U13 = U(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            U13.jjm = true;
            U13.jjo = true;
            this.gJX.add(U13);
        }
        this.jji = U(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jji.jjo = true;
        this.jji.jjm = true;
        this.gJX.add(this.jji);
        g U14 = U(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        U14.jjm = true;
        this.gJX.add(U14);
        if (this.jiv == null) {
            this.jiv = new PersonMoreData();
        }
        g U15 = U(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        U15.jjm = true;
        U15.jjn = true;
        U15.jjq = OrmObject.bundleWithObject(this.jiv);
        U15.jjp = new i();
        List<PersonMoreItemData> list = this.jiv.mUrlMaps;
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
                U15.jjp.jjt = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gJX.add(U15);
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

    public void ro(boolean z) {
        if (this.jjf != null) {
            if (this.jjf.jjp == null) {
                this.jjf.jjp = new i();
            }
            this.jjf.jjp.isShowRedTip = z;
        }
    }

    public void rp(boolean z) {
        if (this.jji != null) {
            if (this.jji.jjp == null) {
                this.jji.jjp = new i();
            }
            this.jji.jjp.isShowRedTip = z;
        }
    }

    public void rq(boolean z) {
        if (this.jjh != null) {
            if (this.jjh.jjp == null) {
                this.jjh.jjp = new i();
            }
            this.jjh.jjp.isShowRedTip = z;
        }
    }

    public void rr(boolean z) {
        if (this.jjd != null) {
            this.jjd.jiX = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jjj = new h();
            this.jjb = profileResIdl.data.banner;
            this.jja = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dN(profileResIdl.data.url_map);
            this.gJX.add(this.jjj);
            cvD();
            dM(profileResIdl.data.recom_swan_list);
            cvE();
            cvF();
            com.baidu.tieba.p.a.cEk().sp(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jjj = new h();
            this.jjj.userData = this.mUserData;
            this.gJX.add(this.jjj);
            cvD();
            cvF();
            com.baidu.tieba.p.a.cEk().sp(true);
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
        if (this.jjc == null && userGodInfo != null) {
            this.jjc = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jjc.parserProtobuf(userGodInfo);
        }
        this.jjj.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jje = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dN(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jiv = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jiv.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
