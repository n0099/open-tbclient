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
    public PersonMoreData jSG;
    public j jTA;
    private ArrayList<com.baidu.adp.widget.ListView.m> jTo = new ArrayList<>();
    private Duxiaoman jTp;
    private List<BannerImage> jTq;
    private PersonUserGodInfo jTr;
    private d jTs;
    public com.baidu.tieba.person.data.d jTt;
    public g jTu;
    public g jTv;
    public g jTw;
    public g jTx;
    public h jTy;
    public m jTz;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> cGj() {
        return this.jTo;
    }

    private void cGk() {
        if (this.jTs != null) {
            this.jTo.add(this.jTs);
        } else if (this.mUserData != null) {
            this.jTs = new d();
            this.jTs.jTi = this.mUserData.getFansNum();
            this.jTs.jTj = this.mUserData.getConcern_num();
            this.jTs.jTk = this.mUserData.getLike_bars();
            this.jTs.threadNum = this.mUserData.getThreadNum();
            this.jTs.userData = this.mUserData;
            this.jTo.add(this.jTs);
        }
    }

    private void cGl() {
        if (this.jTz != null) {
            this.jTo.add(this.jTz);
            return;
        }
        this.jTz = new m();
        if (!v.isEmpty(this.jTq)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jTq.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jTq.get(i2));
                if (!aq.isEmpty(aVar.cGi())) {
                    this.jTz.jTq.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jTz.jTq.size() > 0) {
                this.jTo.add(this.jTz);
            }
        }
    }

    private void dX(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jTA == null) {
                this.jTA = new j();
                this.jTo.add(this.jTA);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jTA.setData(arrayList);
        }
    }

    private void cGm() {
        if (this.jTu == null) {
            this.jTu = X(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jTu.jTC = true;
            this.jTu.jTF = new i();
        }
        this.jTo.add(this.jTu);
        g X = X(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        X.jTC = true;
        this.jTo.add(X);
        g X2 = X(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        X2.jTE = true;
        X2.jTC = true;
        this.jTo.add(X2);
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.bXr() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g X3 = X(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            X3.jTC = true;
            X3.arb = this.mLiveGoodsWindowData.goods_url;
            this.jTo.add(X3);
        }
        g X4 = X(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        X4.jTC = true;
        X4.jTF = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            X4.jTF.isShowRedTip = true;
        }
        X4.jTF.jTN = true;
        this.jTo.add(X4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g X5 = X(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            X5.jTC = true;
            X5.arb = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.jTo.add(X5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNT().getInt("baidu_financial_display", 1) == 1) {
            g X6 = X(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            X6.jTC = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aNT().getBoolean("key_baidu_financial_has_clicked", false)) {
                X6.jTF = new i();
                X6.jTF.isShowRedTip = true;
            }
            this.jTo.add(X6);
        }
        if (this.jTp != null && this.jTp.is_end.intValue() != 1) {
            g X7 = X(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            X7.jTC = true;
            X7.arb = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jTp.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                X7.jTF = iVar;
            }
            this.jTo.add(X7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g X8 = X(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            X8.jTC = true;
            this.jTo.add(X8);
        }
        g X9 = X(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        X9.jTC = true;
        this.jTo.add(X9);
        this.jTv = X(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jTv.jTF = new i();
        this.jTv.jTC = true;
        this.jTv.jTF.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jTv.jTF.jTK = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.jTo.add(this.jTv);
        g X10 = X(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        X10.jTC = true;
        this.jTo.add(X10);
        g X11 = X(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        X11.jTC = true;
        if (this.mUserData.membershipInfo != null) {
            X11.arb = this.mUserData.membershipInfo.mLink;
        }
        this.jTo.add(X11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jTw = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jTw.jTE = true;
            this.jTw.jTF = new i();
            this.jTo.add(this.jTw);
            TiebaStatic.log(new an("c12597"));
        } else {
            X11.jTE = true;
        }
        g X12 = X(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        X12.jTC = true;
        this.jTo.add(X12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g X13 = X(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            X13.jTC = true;
            X13.jTE = true;
            this.jTo.add(X13);
        }
        this.jTx = X(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jTx.jTE = true;
        this.jTx.jTC = true;
        this.jTo.add(this.jTx);
        g X14 = X(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        X14.jTC = true;
        this.jTo.add(X14);
        if (this.jSG == null) {
            this.jSG = new PersonMoreData();
        }
        g X15 = X(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        X15.jTC = true;
        X15.jTD = true;
        X15.jTG = OrmObject.bundleWithObject(this.jSG);
        X15.jTF = new i();
        List<PersonMoreItemData> list = this.jSG.mUrlMaps;
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
                X15.jTF.jTJ = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.jTo.add(X15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g X(int i, int i2, int i3) {
        g gVar = new g();
        gVar.jTB = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g k(int i, String str, int i2) {
        g gVar = new g();
        gVar.jTB = i;
        gVar.title = str;
        gVar.type = i2;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    public void a(com.baidu.tbadk.data.k kVar) {
        this.mUserData.setPendantData(kVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void ss(boolean z) {
        if (this.jTu != null) {
            if (this.jTu.jTF == null) {
                this.jTu.jTF = new i();
            }
            this.jTu.jTF.isShowRedTip = z;
        }
    }

    public void st(boolean z) {
        if (this.jTx != null) {
            if (this.jTx.jTF == null) {
                this.jTx.jTF = new i();
            }
            this.jTx.jTF.isShowRedTip = z;
        }
    }

    public void su(boolean z) {
        if (this.jTw != null) {
            if (this.jTw.jTF == null) {
                this.jTw.jTF = new i();
            }
            this.jTw.jTF.isShowRedTip = z;
        }
    }

    public void sv(boolean z) {
        if (this.jTs != null) {
            this.jTs.jTl = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jTy = new h();
            this.jTq = profileResIdl.data.banner;
            this.jTp = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dY(profileResIdl.data.url_map);
            this.jTo.add(this.jTy);
            cGk();
            dX(profileResIdl.data.recom_swan_list);
            cGl();
            cGm();
            com.baidu.tieba.p.a.cOI().tq(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jTy = new h();
            this.jTy.userData = this.mUserData;
            this.jTo.add(this.jTy);
            cGk();
            cGm();
            com.baidu.tieba.p.a.cOI().tq(true);
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
        if (this.jTr == null && userGodInfo != null) {
            this.jTr = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jTr.parserProtobuf(userGodInfo);
        }
        this.jTy.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jTt = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dY(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jSG = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jSG.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
