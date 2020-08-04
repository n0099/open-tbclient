package com.baidu.tieba.personCenter.c;

import android.support.annotation.StringRes;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.person.PersonMoreData;
import com.baidu.tieba.person.PersonMoreItemData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import com.baidu.tieba.personCenter.c.g;
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
/* loaded from: classes16.dex */
public class f implements com.baidu.tieba.person.b {
    public PersonMoreData kOu;
    private Duxiaoman kPb;
    private List<BannerImage> kPc;
    private PersonUserGodInfo kPd;
    private d kPe;
    public com.baidu.tieba.person.data.d kPf;
    public h kPg;
    public h kPh;
    public h kPi;
    public h kPj;
    public i kPk;
    public n kPl;
    public k kPm;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] kPn = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] kPo = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] kPp = {1, 2, 3, 4};
    private ArrayList<q> fSx = new ArrayList<>();

    public ArrayList<q> cVG() {
        return this.fSx;
    }

    private void cVH() {
        if (this.kPe != null) {
            this.fSx.add(this.kPe);
        } else if (this.mUserData != null) {
            this.kPe = new d();
            this.kPe.kOV = this.mUserData.getFansNum();
            this.kPe.kOW = this.mUserData.getConcern_num();
            this.kPe.kOX = this.mUserData.getLike_bars();
            this.kPe.threadNum = this.mUserData.getThreadNum();
            this.kPe.userData = this.mUserData;
            this.fSx.add(this.kPe);
        }
    }

    private void cVI() {
        if (this.kPl != null) {
            this.fSx.add(this.kPl);
            return;
        }
        this.kPl = new n();
        if (!x.isEmpty(this.kPc)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kPc.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.kPc.get(i2));
                if (!as.isEmpty(aVar.aUi())) {
                    this.kPl.kPc.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.kPl.kPc.size() > 0) {
                this.fSx.add(this.kPl);
            }
        }
    }

    private void cVJ() {
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.kPr = this.kPo[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.kPn[i]);
                    aVar.type = this.kPp[i];
                }
                arrayList.add(aVar);
            }
            gVar.eB(arrayList);
            gVar.mUserData = this.mUserData;
            this.fSx.add(gVar);
        }
    }

    private void ez(List<SmartApp> list) {
        if (!x.isEmpty(list)) {
            if (this.kPm == null) {
                this.kPm = new k();
                this.fSx.add(this.kPm);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.kPm.setData(arrayList);
        }
    }

    private void cVK() {
        if (this.kPg == null) {
            this.kPg = W(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.kPg.kPt = true;
            this.kPg.kPw = new j();
        }
        this.fSx.add(this.kPg);
        h W = W(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        W.kPt = true;
        W.kPv = true;
        this.fSx.add(W);
        h W2 = W(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        W2.kPv = true;
        W2.kPt = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.ckV() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h W3 = W(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            W3.kPt = true;
            W3.aye = this.mLiveGoodsWindowData.goods_url;
            this.fSx.add(W3);
        }
        h W4 = W(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        W4.kPt = true;
        W4.kPw = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            W4.kPw.isShowRedTip = true;
        }
        W4.kPw.kPE = true;
        this.fSx.add(W4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h W5 = W(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            W5.kPt = true;
            W5.aye = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.fSx.add(W5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aZP().getInt("baidu_financial_display", 1) == 1) {
            h W6 = W(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            W6.kPt = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("key_baidu_financial_has_clicked", false)) {
                W6.kPw = new j();
                W6.kPw.isShowRedTip = true;
            }
            this.fSx.add(W6);
        }
        if (this.kPb != null && this.kPb.is_end.intValue() != 1) {
            h W7 = W(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            W7.kPt = true;
            W7.aye = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.kPb.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                W7.kPw = jVar;
            }
            this.fSx.add(W7);
        }
        h W8 = W(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        W8.kPt = true;
        this.fSx.add(W8);
        h W9 = W(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        W9.kPt = true;
        this.fSx.add(W9);
        this.kPh = W(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.kPh.kPw = new j();
        this.kPh.kPt = true;
        this.kPh.kPw.text = as.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.kPh.kPw.kPB = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.fSx.add(this.kPh);
        h W10 = W(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        W10.kPt = true;
        this.fSx.add(W10);
        h W11 = W(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        W11.kPt = true;
        if (this.mUserData.membershipInfo != null) {
            W11.aye = this.mUserData.membershipInfo.mLink;
        }
        this.fSx.add(W11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.kPi = i(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.kPi.kPv = true;
            this.kPi.kPw = new j();
            this.fSx.add(this.kPi);
            TiebaStatic.log(new ap("c12597"));
        } else {
            W11.kPv = true;
        }
        h W12 = W(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        W12.kPt = true;
        this.fSx.add(W12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h W13 = W(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            W13.kPt = true;
            W13.kPv = true;
            this.fSx.add(W13);
        }
        this.kPj = W(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.kPj.kPv = true;
        this.kPj.kPt = true;
        this.fSx.add(this.kPj);
        h W14 = W(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        W14.kPt = true;
        this.fSx.add(W14);
        if (this.kOu == null) {
            this.kOu = new PersonMoreData();
        }
        h W15 = W(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        W15.kPt = true;
        W15.kPu = true;
        W15.kPx = OrmObject.bundleWithObject(this.kOu);
        W15.kPw = new j();
        List<PersonMoreItemData> list = this.kOu.mUrlMaps;
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
                W15.kPw.kPA = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.fSx.add(W15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h W(int i, int i2, int i3) {
        h hVar = new h();
        hVar.kPs = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h i(int i, String str, int i2) {
        h hVar = new h();
        hVar.kPs = i;
        hVar.title = str;
        hVar.type = i2;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    public void a(com.baidu.tbadk.data.l lVar) {
        this.mUserData.setPendantData(lVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void tK(boolean z) {
        if (this.kPg != null) {
            if (this.kPg.kPw == null) {
                this.kPg.kPw = new j();
            }
            this.kPg.kPw.isShowRedTip = z;
        }
    }

    public void tL(boolean z) {
        if (this.kPj != null) {
            if (this.kPj.kPw == null) {
                this.kPj.kPw = new j();
            }
            this.kPj.kPw.isShowRedTip = z;
        }
    }

    public void tM(boolean z) {
        if (this.kPi != null) {
            if (this.kPi.kPw == null) {
                this.kPi.kPw = new j();
            }
            this.kPi.kPw.isShowRedTip = z;
        }
    }

    public void tN(boolean z) {
        if (this.kPe != null) {
            this.kPe.kOY = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.kPk = new i();
            this.kPc = profileResIdl.data.banner;
            this.kPb = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            eA(profileResIdl.data.url_map);
            this.fSx.add(this.kPk);
            cVH();
            cVJ();
            ez(profileResIdl.data.recom_swan_list);
            cVI();
            cVK();
            com.baidu.tieba.p.a.ddy().uH(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.kPk = new i();
            this.kPk.userData = this.mUserData;
            this.fSx.add(this.kPk);
            cVH();
            cVK();
            com.baidu.tieba.p.a.ddy().uH(true);
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
        if (this.kPd == null && userGodInfo != null) {
            this.kPd = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.kPd.parserProtobuf(userGodInfo);
        }
        this.kPk.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.kPf = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void eA(List<UserMap> list) {
        if (!x.isEmpty(list)) {
            this.kOu = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.kOu.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
