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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes21.dex */
public class f implements com.baidu.tieba.person.b {
    private Duxiaoman lnQ;
    private List<BannerImage> lnR;
    private PersonUserGodInfo lnS;
    private d lnT;
    public com.baidu.tieba.person.data.d lnU;
    public h lnV;
    public h lnW;
    public h lnX;
    public h lnY;
    public i lnZ;
    public PersonMoreData lni;
    public n loa;
    public k lob;
    private com.baidu.tieba.i.b mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] lod = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] loe = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] lof = {1, 2, 3, 4};
    private ArrayList<q> ghL = new ArrayList<>();

    public ArrayList<q> dkj() {
        return this.ghL;
    }

    private void dkk() {
        if (this.lnT != null) {
            this.ghL.add(this.lnT);
        } else if (this.mUserData != null) {
            this.lnT = new d();
            this.lnT.lnK = this.mUserData.getFansNum();
            this.lnT.lnL = this.mUserData.getConcern_num();
            this.lnT.lnM = this.mUserData.getLike_bars();
            this.lnT.threadNum = this.mUserData.getThreadNum();
            this.lnT.userData = this.mUserData;
            this.ghL.add(this.lnT);
        }
    }

    private void dkl() {
        if (this.loa != null) {
            this.ghL.add(this.loa);
            return;
        }
        this.loa = new n();
        if (!y.isEmpty(this.lnR)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lnR.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.lnR.get(i2));
                if (!at.isEmpty(aVar.bdv())) {
                    this.loa.lnR.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.loa.lnR.size() > 0) {
                this.ghL.add(this.loa);
            }
        }
    }

    private void dkm() {
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.loi = this.loe[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.lod[i]);
                    aVar.type = this.lof[i];
                }
                arrayList.add(aVar);
            }
            gVar.eR(arrayList);
            gVar.mUserData = this.mUserData;
            this.ghL.add(gVar);
        }
    }

    private void eP(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.lob == null) {
                this.lob = new k();
                this.ghL.add(this.lob);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.lob.setData(arrayList);
        }
    }

    private void dkn() {
        if (this.lnV == null) {
            this.lnV = X(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.lnV.lok = true;
            this.lnV.loo = new j();
        }
        this.ghL.add(this.lnV);
        h X = X(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        X.lok = true;
        X.lom = true;
        this.ghL.add(X);
        h X2 = X(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        X2.lom = true;
        X2.lok = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cyY() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h X3 = X(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            X3.lok = true;
            X3.aEb = this.mLiveGoodsWindowData.goods_url;
            this.ghL.add(X3);
        }
        h X4 = X(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        X4.lok = true;
        X4.loo = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            X4.loo.isShowRedTip = true;
        }
        X4.loo.lox = true;
        this.ghL.add(X4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h X5 = X(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            X5.lok = true;
            X5.aEb = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.ghL.add(X5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bjf().getInt("baidu_financial_display", 1) == 1) {
            h X6 = X(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            X6.lok = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("key_baidu_financial_has_clicked", false)) {
                X6.loo = new j();
                X6.loo.isShowRedTip = true;
            }
            this.ghL.add(X6);
        }
        if (this.lnQ != null && this.lnQ.is_end.intValue() != 1) {
            h X7 = X(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            X7.lok = true;
            X7.aEb = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.lnQ.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                X7.loo = jVar;
            }
            this.ghL.add(X7);
        }
        h X8 = X(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        X8.lok = true;
        this.ghL.add(X8);
        h X9 = X(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        X9.lok = true;
        this.ghL.add(X9);
        this.lnW = X(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.lnW.loo = new j();
        this.lnW.lok = true;
        this.lnW.loo.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.lnW.loo.lot = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.ghL.add(this.lnW);
        h X10 = X(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        X10.lok = true;
        this.ghL.add(X10);
        h X11 = X(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        X11.lok = true;
        if (this.mUserData.membershipInfo != null) {
            X11.aEb = this.mUserData.membershipInfo.mLink;
        }
        this.ghL.add(X11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.lnX = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.lnX.lom = true;
            this.lnX.loo = new j();
            this.ghL.add(this.lnX);
            TiebaStatic.log(new aq("c12597"));
        } else {
            X11.lom = true;
        }
        h X12 = X(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        X12.lok = true;
        this.ghL.add(X12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h X13 = X(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            X13.lok = true;
            X13.lom = true;
            this.ghL.add(X13);
        }
        this.lnY = X(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.lnY.lom = true;
        this.lnY.lok = true;
        this.ghL.add(this.lnY);
        h X14 = X(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        X14.lok = true;
        this.ghL.add(X14);
        if (this.lni == null) {
            this.lni = new PersonMoreData();
        }
        h X15 = X(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        X15.lok = true;
        X15.lol = true;
        X15.lop = OrmObject.bundleWithObject(this.lni);
        X15.loo = new j();
        List<PersonMoreItemData> list = this.lni.mUrlMaps;
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
                X15.loo.los = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.ghL.add(X15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h X(int i, int i2, int i3) {
        h hVar = new h();
        hVar.loj = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.loj = i;
        hVar.title = str;
        hVar.type = i2;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    public void a(com.baidu.tbadk.data.m mVar) {
        this.mUserData.setPendantData(mVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void uE(boolean z) {
        if (this.lnV != null) {
            if (this.lnV.loo == null) {
                this.lnV.loo = new j();
            }
            this.lnV.loo.isShowRedTip = z;
        }
    }

    public void uF(boolean z) {
        if (this.lnY != null) {
            if (this.lnY.loo == null) {
                this.lnY.loo = new j();
            }
            this.lnY.loo.isShowRedTip = z;
        }
    }

    public void uG(boolean z) {
        if (this.lnX != null) {
            if (this.lnX.loo == null) {
                this.lnX.loo = new j();
            }
            this.lnX.loo.isShowRedTip = z;
        }
    }

    public void uH(boolean z) {
        if (this.lnT != null) {
            this.lnT.lnN = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.lnZ = new i();
            this.lnR = profileResIdl.data.banner;
            this.lnQ = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            eQ(profileResIdl.data.url_map);
            this.ghL.add(this.lnZ);
            dkk();
            dkm();
            eP(profileResIdl.data.recom_swan_list);
            dkl();
            dkn();
            com.baidu.tieba.p.a.dsD().vG(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.lnZ = new i();
            this.lnZ.userData = this.mUserData;
            this.ghL.add(this.lnZ);
            dkk();
            dkn();
            com.baidu.tieba.p.a.dsD().vG(true);
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
        if (this.lnS == null && userGodInfo != null) {
            this.lnS = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.lnS.parserProtobuf(userGodInfo);
        }
        this.lnZ.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.lnU = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void eQ(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.lni = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.lni.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
