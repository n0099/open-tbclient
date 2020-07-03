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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes9.dex */
public class f implements com.baidu.tieba.person.b {
    private Duxiaoman kFY;
    private List<BannerImage> kFZ;
    public PersonMoreData kFq;
    private PersonUserGodInfo kGa;
    private d kGb;
    public com.baidu.tieba.person.data.d kGc;
    public h kGd;
    public h kGe;
    public h kGf;
    public h kGg;
    public i kGh;
    public n kGi;
    public k kGj;
    private com.baidu.tieba.i.a mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] kGk = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] kGl = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] kGm = {1, 2, 3, 4};
    private ArrayList<q> fNe = new ArrayList<>();

    public ArrayList<q> cRP() {
        return this.fNe;
    }

    private void cRQ() {
        if (this.kGb != null) {
            this.fNe.add(this.kGb);
        } else if (this.mUserData != null) {
            this.kGb = new d();
            this.kGb.kFS = this.mUserData.getFansNum();
            this.kGb.kFT = this.mUserData.getConcern_num();
            this.kGb.kFU = this.mUserData.getLike_bars();
            this.kGb.threadNum = this.mUserData.getThreadNum();
            this.kGb.userData = this.mUserData;
            this.fNe.add(this.kGb);
        }
    }

    private void cRR() {
        if (this.kGi != null) {
            this.fNe.add(this.kGi);
            return;
        }
        this.kGi = new n();
        if (!w.isEmpty(this.kFZ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.kFZ.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.kFZ.get(i2));
                if (!ar.isEmpty(aVar.aQm())) {
                    this.kGi.kFZ.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.kGi.kFZ.size() > 0) {
                this.fNe.add(this.kGi);
            }
        }
    }

    private void cRS() {
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.kGo = this.kGl[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.kGk[i]);
                    aVar.type = this.kGm[i];
                }
                arrayList.add(aVar);
            }
            gVar.ev(arrayList);
            gVar.mUserData = this.mUserData;
            this.fNe.add(gVar);
        }
    }

    private void et(List<SmartApp> list) {
        if (!w.isEmpty(list)) {
            if (this.kGj == null) {
                this.kGj = new k();
                this.fNe.add(this.kGj);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.kGj.setData(arrayList);
        }
    }

    private void cRT() {
        if (this.kGd == null) {
            this.kGd = X(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.kGd.kGq = true;
            this.kGd.kGt = new j();
        }
        this.fNe.add(this.kGd);
        h X = X(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        X.kGq = true;
        X.kGs = true;
        this.fNe.add(X);
        h X2 = X(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        X2.kGs = true;
        X2.kGq = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.chv() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h X3 = X(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            X3.kGq = true;
            X3.awR = this.mLiveGoodsWindowData.goods_url;
            this.fNe.add(X3);
        }
        h X4 = X(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        X4.kGq = true;
        X4.kGt = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            X4.kGt.isShowRedTip = true;
        }
        X4.kGt.kGB = true;
        this.fNe.add(X4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h X5 = X(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            X5.kGq = true;
            X5.awR = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.fNe.add(X5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.aVP().getInt("baidu_financial_display", 1) == 1) {
            h X6 = X(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            X6.kGq = true;
            if (!com.baidu.tbadk.core.sharedPref.b.aVP().getBoolean("key_baidu_financial_has_clicked", false)) {
                X6.kGt = new j();
                X6.kGt.isShowRedTip = true;
            }
            this.fNe.add(X6);
        }
        if (this.kFY != null && this.kFY.is_end.intValue() != 1) {
            h X7 = X(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            X7.kGq = true;
            X7.awR = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.kFY.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                X7.kGt = jVar;
            }
            this.fNe.add(X7);
        }
        h X8 = X(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        X8.kGq = true;
        this.fNe.add(X8);
        h X9 = X(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        X9.kGq = true;
        this.fNe.add(X9);
        this.kGe = X(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.kGe.kGt = new j();
        this.kGe.kGq = true;
        this.kGe.kGt.text = ar.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.kGe.kGt.kGy = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.fNe.add(this.kGe);
        h X10 = X(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        X10.kGq = true;
        this.fNe.add(X10);
        h X11 = X(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        X11.kGq = true;
        if (this.mUserData.membershipInfo != null) {
            X11.awR = this.mUserData.membershipInfo.mLink;
        }
        this.fNe.add(X11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.kGf = i(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.kGf.kGs = true;
            this.kGf.kGt = new j();
            this.fNe.add(this.kGf);
            TiebaStatic.log(new ao("c12597"));
        } else {
            X11.kGs = true;
        }
        h X12 = X(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        X12.kGq = true;
        this.fNe.add(X12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h X13 = X(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            X13.kGq = true;
            X13.kGs = true;
            this.fNe.add(X13);
        }
        this.kGg = X(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.kGg.kGs = true;
        this.kGg.kGq = true;
        this.fNe.add(this.kGg);
        h X14 = X(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        X14.kGq = true;
        this.fNe.add(X14);
        if (this.kFq == null) {
            this.kFq = new PersonMoreData();
        }
        h X15 = X(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        X15.kGq = true;
        X15.kGr = true;
        X15.kGu = OrmObject.bundleWithObject(this.kFq);
        X15.kGt = new j();
        List<PersonMoreItemData> list = this.kFq.mUrlMaps;
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
                X15.kGt.kGx = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.fNe.add(X15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h X(int i, int i2, int i3) {
        h hVar = new h();
        hVar.kGp = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h i(int i, String str, int i2) {
        h hVar = new h();
        hVar.kGp = i;
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

    public void te(boolean z) {
        if (this.kGd != null) {
            if (this.kGd.kGt == null) {
                this.kGd.kGt = new j();
            }
            this.kGd.kGt.isShowRedTip = z;
        }
    }

    public void tf(boolean z) {
        if (this.kGg != null) {
            if (this.kGg.kGt == null) {
                this.kGg.kGt = new j();
            }
            this.kGg.kGt.isShowRedTip = z;
        }
    }

    public void tg(boolean z) {
        if (this.kGf != null) {
            if (this.kGf.kGt == null) {
                this.kGf.kGt = new j();
            }
            this.kGf.kGt.isShowRedTip = z;
        }
    }

    public void th(boolean z) {
        if (this.kGb != null) {
            this.kGb.kFV = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.kGh = new i();
            this.kFZ = profileResIdl.data.banner;
            this.kFY = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            eu(profileResIdl.data.url_map);
            this.fNe.add(this.kGh);
            cRQ();
            cRS();
            et(profileResIdl.data.recom_swan_list);
            cRR();
            cRT();
            com.baidu.tieba.p.a.daq().ud(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.kGh = new i();
            this.kGh.userData = this.mUserData;
            this.fNe.add(this.kGh);
            cRQ();
            cRT();
            com.baidu.tieba.p.a.daq().ud(true);
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
        if (this.kGa == null && userGodInfo != null) {
            this.kGa = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.kGa.parserProtobuf(userGodInfo);
        }
        this.kGh.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.kGc = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void eu(List<UserMap> list) {
        if (!w.isEmpty(list)) {
            this.kFq = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.kFq.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
