package com.baidu.tieba.personCenter.c;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.o;
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
    private ArrayList<o> fBV = new ArrayList<>();
    public PersonMoreData klE;
    private Duxiaoman kmm;
    private List<BannerImage> kmn;
    private PersonUserGodInfo kmo;
    private d kmp;
    public com.baidu.tieba.person.data.d kmq;
    public g kmr;
    public g kms;
    public g kmt;
    public g kmu;
    public h kmv;
    public m kmw;
    public j kmx;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<o> cNz() {
        return this.fBV;
    }

    private void cNA() {
        if (this.kmp != null) {
            this.fBV.add(this.kmp);
        } else if (this.mUserData != null) {
            this.kmp = new d();
            this.kmp.kmg = this.mUserData.getFansNum();
            this.kmp.kmh = this.mUserData.getConcern_num();
            this.kmp.kmi = this.mUserData.getLike_bars();
            this.kmp.threadNum = this.mUserData.getThreadNum();
            this.kmp.userData = this.mUserData;
            this.fBV.add(this.kmp);
        }
    }

    private void cNB() {
        if (this.kmw != null) {
            this.fBV.add(this.kmw);
            return;
        }
        this.kmw = new m();
        if (!v.isEmpty(this.kmn)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kmn.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.kmn.get(i2));
                if (!aq.isEmpty(aVar.cNy())) {
                    this.kmw.kmn.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.kmw.kmn.size() > 0) {
                this.fBV.add(this.kmw);
            }
        }
    }

    private void ef(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.kmx == null) {
                this.kmx = new j();
                this.fBV.add(this.kmx);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.kmx.setData(arrayList);
        }
    }

    private void cNC() {
        if (this.kmr == null) {
            this.kmr = X(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.kmr.kmz = true;
            this.kmr.kmC = new i();
        }
        this.fBV.add(this.kmr);
        g X = X(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        X.kmz = true;
        X.kmB = true;
        this.fBV.add(X);
        g X2 = X(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        X2.kmB = true;
        X2.kmz = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cdY() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g X3 = X(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            X3.kmz = true;
            X3.auL = this.mLiveGoodsWindowData.goods_url;
            this.fBV.add(X3);
        }
        g X4 = X(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        X4.kmz = true;
        X4.kmC = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            X4.kmC.isShowRedTip = true;
        }
        X4.kmC.kmK = true;
        this.fBV.add(X4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g X5 = X(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            X5.kmz = true;
            X5.auL = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.fBV.add(X5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("baidu_financial_display", 1) == 1) {
            g X6 = X(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            X6.kmz = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_baidu_financial_has_clicked", false)) {
                X6.kmC = new i();
                X6.kmC.isShowRedTip = true;
            }
            this.fBV.add(X6);
        }
        if (this.kmm != null && this.kmm.is_end.intValue() != 1) {
            g X7 = X(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            X7.kmz = true;
            X7.auL = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.kmm.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                X7.kmC = iVar;
            }
            this.fBV.add(X7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g X8 = X(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            X8.kmz = true;
            this.fBV.add(X8);
        }
        g X9 = X(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        X9.kmz = true;
        this.fBV.add(X9);
        this.kms = X(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.kms.kmC = new i();
        this.kms.kmz = true;
        this.kms.kmC.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.kms.kmC.kmH = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.fBV.add(this.kms);
        g X10 = X(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        X10.kmz = true;
        this.fBV.add(X10);
        g X11 = X(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        X11.kmz = true;
        if (this.mUserData.membershipInfo != null) {
            X11.auL = this.mUserData.membershipInfo.mLink;
        }
        this.fBV.add(X11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.kmt = i(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.kmt.kmB = true;
            this.kmt.kmC = new i();
            this.fBV.add(this.kmt);
            TiebaStatic.log(new an("c12597"));
        } else {
            X11.kmB = true;
        }
        g X12 = X(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        X12.kmz = true;
        this.fBV.add(X12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g X13 = X(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            X13.kmz = true;
            X13.kmB = true;
            this.fBV.add(X13);
        }
        this.kmu = X(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.kmu.kmB = true;
        this.kmu.kmz = true;
        this.fBV.add(this.kmu);
        g X14 = X(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        X14.kmz = true;
        this.fBV.add(X14);
        if (this.klE == null) {
            this.klE = new PersonMoreData();
        }
        g X15 = X(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        X15.kmz = true;
        X15.kmA = true;
        X15.kmD = OrmObject.bundleWithObject(this.klE);
        X15.kmC = new i();
        List<PersonMoreItemData> list = this.klE.mUrlMaps;
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
                X15.kmC.kmG = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.fBV.add(X15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g X(int i, int i2, int i3) {
        g gVar = new g();
        gVar.kmy = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g i(int i, String str, int i2) {
        g gVar = new g();
        gVar.kmy = i;
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

    public void sQ(boolean z) {
        if (this.kmr != null) {
            if (this.kmr.kmC == null) {
                this.kmr.kmC = new i();
            }
            this.kmr.kmC.isShowRedTip = z;
        }
    }

    public void sR(boolean z) {
        if (this.kmu != null) {
            if (this.kmu.kmC == null) {
                this.kmu.kmC = new i();
            }
            this.kmu.kmC.isShowRedTip = z;
        }
    }

    public void sS(boolean z) {
        if (this.kmt != null) {
            if (this.kmt.kmC == null) {
                this.kmt.kmC = new i();
            }
            this.kmt.kmC.isShowRedTip = z;
        }
    }

    public void sT(boolean z) {
        if (this.kmp != null) {
            this.kmp.kmj = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.kmv = new h();
            this.kmn = profileResIdl.data.banner;
            this.kmm = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            eg(profileResIdl.data.url_map);
            this.fBV.add(this.kmv);
            cNA();
            ef(profileResIdl.data.recom_swan_list);
            cNB();
            cNC();
            com.baidu.tieba.p.a.cWb().tO(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.kmv = new h();
            this.kmv.userData = this.mUserData;
            this.fBV.add(this.kmv);
            cNA();
            cNC();
            com.baidu.tieba.p.a.cWb().tO(true);
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
        if (this.kmo == null && userGodInfo != null) {
            this.kmo = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.kmo.parserProtobuf(userGodInfo);
        }
        this.kmv.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.kmq = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void eg(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.klE = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.klE.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
