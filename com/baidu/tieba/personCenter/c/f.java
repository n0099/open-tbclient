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
    public PersonMoreData jSC;
    private ArrayList<com.baidu.adp.widget.ListView.m> jTk = new ArrayList<>();
    private Duxiaoman jTl;
    private List<BannerImage> jTm;
    private PersonUserGodInfo jTn;
    private d jTo;
    public com.baidu.tieba.person.data.d jTp;
    public g jTq;
    public g jTr;
    public g jTs;
    public g jTt;
    public h jTu;
    public m jTv;
    public j jTw;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;

    public ArrayList<com.baidu.adp.widget.ListView.m> cGm() {
        return this.jTk;
    }

    private void cGn() {
        if (this.jTo != null) {
            this.jTk.add(this.jTo);
        } else if (this.mUserData != null) {
            this.jTo = new d();
            this.jTo.jTe = this.mUserData.getFansNum();
            this.jTo.jTf = this.mUserData.getConcern_num();
            this.jTo.jTg = this.mUserData.getLike_bars();
            this.jTo.threadNum = this.mUserData.getThreadNum();
            this.jTo.userData = this.mUserData;
            this.jTk.add(this.jTo);
        }
    }

    private void cGo() {
        if (this.jTv != null) {
            this.jTk.add(this.jTv);
            return;
        }
        this.jTv = new m();
        if (!v.isEmpty(this.jTm)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.jTm.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.jTm.get(i2));
                if (!aq.isEmpty(aVar.cGl())) {
                    this.jTv.jTm.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.jTv.jTm.size() > 0) {
                this.jTk.add(this.jTv);
            }
        }
    }

    private void dX(List<SmartApp> list) {
        if (!v.isEmpty(list)) {
            if (this.jTw == null) {
                this.jTw = new j();
                this.jTk.add(this.jTw);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new l(smartApp));
                    }
                }
            }
            this.jTw.setData(arrayList);
        }
    }

    private void cGp() {
        if (this.jTq == null) {
            this.jTq = X(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.jTq.jTy = true;
            this.jTq.jTB = new i();
        }
        this.jTk.add(this.jTq);
        g X = X(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        X.jTy = true;
        this.jTk.add(X);
        g X2 = X(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        X2.jTA = true;
        X2.jTy = true;
        this.jTk.add(X2);
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.bXt() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            g X3 = X(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            X3.jTy = true;
            X3.aqV = this.mLiveGoodsWindowData.goods_url;
            this.jTk.add(X3);
        }
        g X4 = X(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        X4.jTy = true;
        X4.jTB = new i();
        if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            X4.jTB.isShowRedTip = true;
        }
        X4.jTB.jTJ = true;
        this.jTk.add(X4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            g X5 = X(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            X5.jTy = true;
            X5.aqV = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%221191000700000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.jTk.add(X5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aNV().getInt("baidu_financial_display", 1) == 1) {
            g X6 = X(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            X6.jTy = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aNV().getBoolean("key_baidu_financial_has_clicked", false)) {
                X6.jTB = new i();
                X6.jTB.isShowRedTip = true;
            }
            this.jTk.add(X6);
        }
        if (this.jTl != null && this.jTl.is_end.intValue() != 1) {
            g X7 = X(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            X7.jTy = true;
            X7.aqV = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.jTl.total_cash.intValue();
            if (intValue > 0) {
                i iVar = new i();
                iVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                iVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                X7.jTB = iVar;
            }
            this.jTk.add(X7);
        }
        if (MissionEntranceSwitch.isOn()) {
            g X8 = X(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
            X8.jTy = true;
            this.jTk.add(X8);
        }
        g X9 = X(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        X9.jTy = true;
        this.jTk.add(X9);
        this.jTr = X(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.jTr.jTB = new i();
        this.jTr.jTy = true;
        this.jTr.jTB.text = aq.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.jTr.jTB.jTG = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.jTk.add(this.jTr);
        g X10 = X(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        X10.jTy = true;
        this.jTk.add(X10);
        g X11 = X(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        X11.jTy = true;
        if (this.mUserData.membershipInfo != null) {
            X11.aqV = this.mUserData.membershipInfo.mLink;
        }
        this.jTk.add(X11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.jTs = k(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.jTs.jTA = true;
            this.jTs.jTB = new i();
            this.jTk.add(this.jTs);
            TiebaStatic.log(new an("c12597"));
        } else {
            X11.jTA = true;
        }
        g X12 = X(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        X12.jTy = true;
        this.jTk.add(X12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            g X13 = X(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            X13.jTy = true;
            X13.jTA = true;
            this.jTk.add(X13);
        }
        this.jTt = X(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.jTt.jTA = true;
        this.jTt.jTy = true;
        this.jTk.add(this.jTt);
        g X14 = X(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        X14.jTy = true;
        this.jTk.add(X14);
        if (this.jSC == null) {
            this.jSC = new PersonMoreData();
        }
        g X15 = X(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        X15.jTy = true;
        X15.jTz = true;
        X15.jTC = OrmObject.bundleWithObject(this.jSC);
        X15.jTB = new i();
        List<PersonMoreItemData> list = this.jSC.mUrlMaps;
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
                X15.jTB.jTF = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.jTk.add(X15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private g X(int i, int i2, int i3) {
        g gVar = new g();
        gVar.jTx = i;
        gVar.title = TbadkCoreApplication.getInst().getString(i2);
        gVar.type = i3;
        if (this.mUserData != null) {
            gVar.userData = this.mUserData;
        }
        return gVar;
    }

    private g k(int i, String str, int i2) {
        g gVar = new g();
        gVar.jTx = i;
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
        if (this.jTq != null) {
            if (this.jTq.jTB == null) {
                this.jTq.jTB = new i();
            }
            this.jTq.jTB.isShowRedTip = z;
        }
    }

    public void st(boolean z) {
        if (this.jTt != null) {
            if (this.jTt.jTB == null) {
                this.jTt.jTB = new i();
            }
            this.jTt.jTB.isShowRedTip = z;
        }
    }

    public void su(boolean z) {
        if (this.jTs != null) {
            if (this.jTs.jTB == null) {
                this.jTs.jTB = new i();
            }
            this.jTs.jTB.isShowRedTip = z;
        }
    }

    public void sv(boolean z) {
        if (this.jTo != null) {
            this.jTo.jTh = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.jTu = new h();
            this.jTm = profileResIdl.data.banner;
            this.jTl = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            dY(profileResIdl.data.url_map);
            this.jTk.add(this.jTu);
            cGn();
            dX(profileResIdl.data.recom_swan_list);
            cGo();
            cGp();
            com.baidu.tieba.p.a.cOL().tq(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.jTu = new h();
            this.jTu.userData = this.mUserData;
            this.jTk.add(this.jTu);
            cGn();
            cGp();
            com.baidu.tieba.p.a.cOL().tq(true);
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
        if (this.jTn == null && userGodInfo != null) {
            this.jTn = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.jTn.parserProtobuf(userGodInfo);
        }
        this.jTu.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.jTp = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void dY(List<UserMap> list) {
        if (!v.isEmpty(list)) {
            this.jSC = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.jSC.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
