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
    private ArrayList<o> fBK = new ArrayList<>();
    public PersonMoreData kky;
    private Duxiaoman klg;
    private List<BannerImage> klh;
    private PersonUserGodInfo kli;
    private d klj;
    public com.baidu.tieba.person.data.d klk;
    public g kll;
    public g klm;
    public g kln;
    public g klo;
    public h klp;
    public m klq;
    public j klr;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<o> cNj() {
        return this.fBK;
    }

    private void cNk() {
        if (this.klj != null) {
            this.fBK.add(this.klj);
        } else if (this.mUserData != null) {
            this.klj = new d();
            this.klj.kla = this.mUserData.getFansNum();
            this.klj.klb = this.mUserData.getConcern_num();
            this.klj.klc = this.mUserData.getLike_bars();
            this.klj.threadNum = this.mUserData.getThreadNum();
            this.klj.userData = this.mUserData;
            this.fBK.add(this.klj);
        }
    }

    private void cNl() {
        if (this.klq != null) {
            this.fBK.add(this.klq);
            return;
        }
        this.klq = new m();
        if (!v.isEmpty(this.klh)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.klh.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.klh.get(i2));
                if (!aq.isEmpty(aVar.cNi())) {
                    this.klq.klh.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.klq.klh.size() > 0) {
                this.fBK.add(this.klq);
            }
        }
    }

    private void ed(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.klr == null) {
                this.klr = new j();
                this.fBK.add(this.klr);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.klr.setData(arrayList);
        }
    }

    private void cNm() {
        if (this.kll == null) {
            this.kll = X(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.kll.klt = true;
            this.kll.klw = new i();
        }
        this.fBK.add(this.kll);
        g X = X(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        X.klt = true;
        X.klv = true;
        this.fBK.add(X);
        g X2 = X(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        X2.klv = true;
        X2.klt = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cdQ() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g X3 = X(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            X3.klt = true;
            X3.auL = this.mLiveGoodsWindowData.goods_url;
            this.fBK.add(X3);
        }
        g X4 = X(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        X4.klt = true;
        X4.klw = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            X4.klw.isShowRedTip = true;
        }
        X4.klw.klE = true;
        this.fBK.add(X4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g X5 = X(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            X5.klt = true;
            X5.auL = "tiebaclient://swan/f3TuxsL47kihWbLdWMiymiYwChMr52Rd/pages/index/index_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.fBK.add(X5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aTX().getInt("baidu_financial_display", 1) == 1) {
            g X6 = X(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            X6.klt = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aTX().getBoolean("key_baidu_financial_has_clicked", false)) {
                X6.klw = new i();
                X6.klw.isShowRedTip = true;
            }
            this.fBK.add(X6);
        }
        if (this.klg != null && this.klg.is_end.intValue() != 1) {
            g X7 = X(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            X7.klt = true;
            X7.auL = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.klg.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                X7.klw = iVar;
            }
            this.fBK.add(X7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g X8 = X(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            X8.klt = true;
            this.fBK.add(X8);
        }
        g X9 = X(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        X9.klt = true;
        this.fBK.add(X9);
        this.klm = X(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.klm.klw = new i();
        this.klm.klt = true;
        this.klm.klw.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.klm.klw.klB = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.fBK.add(this.klm);
        g X10 = X(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        X10.klt = true;
        this.fBK.add(X10);
        g X11 = X(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        X11.klt = true;
        if (this.mUserData.membershipInfo != null) {
            X11.auL = this.mUserData.membershipInfo.mLink;
        }
        this.fBK.add(X11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.kln = i(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.kln.klv = true;
            this.kln.klw = new i();
            this.fBK.add(this.kln);
            TiebaStatic.log(new an("c12597"));
        } else {
            X11.klv = true;
        }
        g X12 = X(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        X12.klt = true;
        this.fBK.add(X12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g X13 = X(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            X13.klt = true;
            X13.klv = true;
            this.fBK.add(X13);
        }
        this.klo = X(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.klo.klv = true;
        this.klo.klt = true;
        this.fBK.add(this.klo);
        g X14 = X(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        X14.klt = true;
        this.fBK.add(X14);
        if (this.kky == null) {
            this.kky = new PersonMoreData();
        }
        g X15 = X(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        X15.klt = true;
        X15.klu = true;
        X15.klx = OrmObject.bundleWithObject(this.kky);
        X15.klw = new i();
        List<PersonMoreItemData> list = this.kky.mUrlMaps;
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
                X15.klw.klA = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.fBK.add(X15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g X(int i, int i2, int i3) {
        g gVar = new g();
        gVar.kls = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g i(int i, String str, int i2) {
        g gVar = new g();
        gVar.kls = i;
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
        if (this.kll != null) {
            if (this.kll.klw == null) {
                this.kll.klw = new i();
            }
            this.kll.klw.isShowRedTip = z;
        }
    }

    public void sR(boolean z) {
        if (this.klo != null) {
            if (this.klo.klw == null) {
                this.klo.klw = new i();
            }
            this.klo.klw.isShowRedTip = z;
        }
    }

    public void sS(boolean z) {
        if (this.kln != null) {
            if (this.kln.klw == null) {
                this.kln.klw = new i();
            }
            this.kln.klw.isShowRedTip = z;
        }
    }

    public void sT(boolean z) {
        if (this.klj != null) {
            this.klj.kld = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.klp = new h();
            this.klh = profileResIdl.data.banner;
            this.klg = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            ee(profileResIdl.data.url_map);
            this.fBK.add(this.klp);
            cNk();
            ed(profileResIdl.data.recom_swan_list);
            cNl();
            cNm();
            com.baidu.tieba.p.a.cVL().tO(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.klp = new h();
            this.klp.userData = this.mUserData;
            this.fBK.add(this.klp);
            cNk();
            cNm();
            com.baidu.tieba.p.a.cVL().tO(true);
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
        if (this.kli == null && userGodInfo != null) {
            this.kli = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.kli.parserProtobuf(userGodInfo);
        }
        this.klp.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.klk = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void ee(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.kky = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.kky.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
