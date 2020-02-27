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
    private ArrayList<com.baidu.adp.widget.ListView.m> gIE = new ArrayList<>();
    public PersonMoreData jgH;
    private Duxiaoman jhm;
    private List<BannerImage> jhn;
    private PersonUserGodInfo jho;
    private d jhp;
    public com.baidu.tieba.person.data.d jhq;
    public g jhr;
    public g jhs;
    public g jht;
    public g jhu;
    public h jhv;
    public m jhw;
    public j jhx;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> cvg() {
        return this.gIE;
    }

    private void cvh() {
        if (this.jhp != null) {
            this.gIE.add(this.jhp);
        } else if (this.mUserData != null) {
            this.jhp = new d();
            this.jhp.jhg = this.mUserData.getFansNum();
            this.jhp.jhh = this.mUserData.getConcern_num();
            this.jhp.jhi = this.mUserData.getLike_bars();
            this.jhp.threadNum = this.mUserData.getThreadNum();
            this.jhp.userData = this.mUserData;
            this.gIE.add(this.jhp);
        }
    }

    private void cvi() {
        if (this.jhw != null) {
            this.gIE.add(this.jhw);
            return;
        }
        this.jhw = new m();
        if (!v.isEmpty(this.jhn)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jhn.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jhn.get(i2));
                if (!aq.isEmpty(aVar.cvf())) {
                    this.jhw.jhn.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jhw.jhn.size() > 0) {
                this.gIE.add(this.jhw);
            }
        }
    }

    private void dM(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jhx == null) {
                this.jhx = new j();
                this.gIE.add(this.jhx);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jhx.setData(arrayList);
        }
    }

    private void cvj() {
        if (this.jhr == null) {
            this.jhr = U(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jhr.jhy = true;
            this.jhr.jhB = new i();
        }
        this.gIE.add(this.jhr);
        g U = U(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        U.jhy = true;
        this.gIE.add(U);
        g U2 = U(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        U2.jhA = true;
        U2.jhy = true;
        this.gIE.add(U2);
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.bMB() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g U3 = U(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            U3.jhy = true;
            U3.cLQ = this.mLiveGoodsWindowData.goods_url;
            this.gIE.add(U3);
        }
        g U4 = U(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        U4.jhy = true;
        U4.jhB = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            U4.jhB.isShowRedTip = true;
        }
        U4.jhB.jhJ = true;
        this.gIE.add(U4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g U5 = U(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            U5.jhy = true;
            U5.cLQ = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gIE.add(U5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aFB().getInt("baidu_financial_display", 1) == 1) {
            g U6 = U(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            U6.jhy = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aFB().getBoolean("key_baidu_financial_has_clicked", false)) {
                U6.jhB = new i();
                U6.jhB.isShowRedTip = true;
            }
            this.gIE.add(U6);
        }
        if (this.jhm != null && this.jhm.is_end.intValue() != 1) {
            g U7 = U(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            U7.jhy = true;
            U7.cLQ = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jhm.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                U7.jhB = iVar;
            }
            this.gIE.add(U7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g U8 = U(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            U8.jhy = true;
            this.gIE.add(U8);
        }
        g U9 = U(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        U9.jhy = true;
        this.gIE.add(U9);
        this.jhs = U(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jhs.jhB = new i();
        this.jhs.jhy = true;
        this.jhs.jhB.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jhs.jhB.jhG = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gIE.add(this.jhs);
        g U10 = U(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        U10.jhy = true;
        this.gIE.add(U10);
        g U11 = U(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        U11.jhy = true;
        if (this.mUserData.membershipInfo != null) {
            U11.cLQ = this.mUserData.membershipInfo.mLink;
        }
        this.gIE.add(U11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jht = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jht.jhA = true;
            this.jht.jhB = new i();
            this.gIE.add(this.jht);
            TiebaStatic.log(new an("c12597"));
        } else {
            U11.jhA = true;
        }
        g U12 = U(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        U12.jhy = true;
        this.gIE.add(U12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g U13 = U(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            U13.jhy = true;
            U13.jhA = true;
            this.gIE.add(U13);
        }
        this.jhu = U(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jhu.jhA = true;
        this.jhu.jhy = true;
        this.gIE.add(this.jhu);
        g U14 = U(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        U14.jhy = true;
        this.gIE.add(U14);
        if (this.jgH == null) {
            this.jgH = new PersonMoreData();
        }
        g U15 = U(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        U15.jhy = true;
        U15.jhz = true;
        U15.jhC = OrmObject.bundleWithObject(this.jgH);
        U15.jhB = new i();
        List<PersonMoreItemData> list = this.jgH.mUrlMaps;
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
                U15.jhB.jhF = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gIE.add(U15);
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
        if (this.jhr != null) {
            if (this.jhr.jhB == null) {
                this.jhr.jhB = new i();
            }
            this.jhr.jhB.isShowRedTip = z;
        }
    }

    public void rj(boolean z) {
        if (this.jhu != null) {
            if (this.jhu.jhB == null) {
                this.jhu.jhB = new i();
            }
            this.jhu.jhB.isShowRedTip = z;
        }
    }

    public void rk(boolean z) {
        if (this.jht != null) {
            if (this.jht.jhB == null) {
                this.jht.jhB = new i();
            }
            this.jht.jhB.isShowRedTip = z;
        }
    }

    public void rl(boolean z) {
        if (this.jhp != null) {
            this.jhp.jhj = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jhv = new h();
            this.jhn = profileResIdl.data.banner;
            this.jhm = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dN(profileResIdl.data.url_map);
            this.gIE.add(this.jhv);
            cvh();
            dM(profileResIdl.data.recom_swan_list);
            cvi();
            cvj();
            com.baidu.tieba.p.a.cDN().sj(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jhv = new h();
            this.jhv.userData = this.mUserData;
            this.gIE.add(this.jhv);
            cvh();
            cvj();
            com.baidu.tieba.p.a.cDN().sj(true);
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
        if (this.jho == null && userGodInfo != null) {
            this.jho = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jho.parserProtobuf(userGodInfo);
        }
        this.jhv.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jhq = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dN(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jgH = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jgH.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
