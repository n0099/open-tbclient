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
/* loaded from: classes22.dex */
public class f implements com.baidu.tieba.person.b {
    public PersonMoreData lUS;
    private Duxiaoman lVA;
    private List<BannerImage> lVB;
    private PersonUserGodInfo lVC;
    private d lVD;
    public com.baidu.tieba.person.data.d lVE;
    public h lVF;
    public h lVG;
    public h lVH;
    public h lVI;
    public i lVJ;
    public n lVK;
    public k lVL;
    private com.baidu.tieba.i.b mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] lVM = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] lVN = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] lVO = {1, 2, 3, 4};
    private ArrayList<q> gJR = new ArrayList<>();

    public ArrayList<q> dtC() {
        return this.gJR;
    }

    private void dtD() {
        if (this.lVD != null) {
            this.gJR.add(this.lVD);
        } else if (this.mUserData != null) {
            this.lVD = new d();
            this.lVD.lVu = this.mUserData.getFansNum();
            this.lVD.lVv = this.mUserData.getConcern_num();
            this.lVD.lVw = this.mUserData.getLike_bars();
            this.lVD.threadNum = this.mUserData.getThreadNum();
            this.lVD.userData = this.mUserData;
            this.gJR.add(this.lVD);
        }
    }

    private void dtE() {
        if (this.lVK != null) {
            this.gJR.add(this.lVK);
            return;
        }
        this.lVK = new n();
        if (!y.isEmpty(this.lVB)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lVB.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.lVB.get(i2));
                if (!at.isEmpty(aVar.bkx())) {
                    this.lVK.lVB.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.lVK.lVB.size() > 0) {
                this.gJR.add(this.lVK);
            }
        }
    }

    private void dtF() {
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.lVQ = this.lVN[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.lVM[i]);
                    aVar.type = this.lVO[i];
                }
                arrayList.add(aVar);
            }
            gVar.fl(arrayList);
            gVar.mUserData = this.mUserData;
            this.gJR.add(gVar);
        }
    }

    private void fj(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.lVL == null) {
                this.lVL = new k();
                this.gJR.add(this.lVL);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.lVL.setData(arrayList);
        }
    }

    private void dtG() {
        if (this.lVF == null) {
            this.lVF = Y(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.lVF.lVR = true;
            this.lVF.lVU = new j();
        }
        this.gJR.add(this.lVF);
        h Y = Y(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Y.lVR = true;
        Y.lVT = true;
        this.gJR.add(Y);
        h Y2 = Y(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Y2.lVT = true;
        Y2.lVR = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cIe() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Y3 = Y(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Y3.lVR = true;
            Y3.aIk = this.mLiveGoodsWindowData.goods_url;
            this.gJR.add(Y3);
        }
        h Y4 = Y(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Y4.lVR = true;
        Y4.lVU = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Y4.lVU.isShowRedTip = true;
        }
        Y4.lVU.lWc = true;
        this.gJR.add(Y4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Y5 = Y(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Y5.lVR = true;
            Y5.aIk = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gJR.add(Y5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bqh().getInt("baidu_financial_display", 1) == 1) {
            h Y6 = Y(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Y6.lVR = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("key_baidu_financial_has_clicked", false)) {
                Y6.lVU = new j();
                Y6.lVU.isShowRedTip = true;
            }
            this.gJR.add(Y6);
        }
        if (this.lVA != null && this.lVA.is_end.intValue() != 1) {
            h Y7 = Y(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Y7.lVR = true;
            Y7.aIk = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.lVA.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Y7.lVU = jVar;
            }
            this.gJR.add(Y7);
        }
        h Y8 = Y(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Y8.lVR = true;
        this.gJR.add(Y8);
        h Y9 = Y(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Y9.lVR = true;
        this.gJR.add(Y9);
        this.lVG = Y(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.lVG.lVU = new j();
        this.lVG.lVR = true;
        this.lVG.lVU.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.lVG.lVU.lVZ = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gJR.add(this.lVG);
        h Y10 = Y(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Y10.lVR = true;
        this.gJR.add(Y10);
        h Y11 = Y(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Y11.lVR = true;
        if (this.mUserData.membershipInfo != null) {
            Y11.aIk = this.mUserData.membershipInfo.mLink;
        }
        this.gJR.add(Y11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.lVH = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.lVH.lVT = true;
            this.lVH.lVU = new j();
            this.gJR.add(this.lVH);
            TiebaStatic.log(new aq("c12597"));
        } else {
            Y11.lVT = true;
        }
        h Y12 = Y(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Y12.lVR = true;
        this.gJR.add(Y12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Y13 = Y(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Y13.lVR = true;
            Y13.lVT = true;
            this.gJR.add(Y13);
        }
        this.lVI = Y(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.lVI.lVT = true;
        this.lVI.lVR = true;
        this.gJR.add(this.lVI);
        h Y14 = Y(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Y14.lVR = true;
        this.gJR.add(Y14);
        if (this.lUS == null) {
            this.lUS = new PersonMoreData();
        }
        h Y15 = Y(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Y15.lVR = true;
        Y15.lVS = true;
        Y15.lVV = OrmObject.bundleWithObject(this.lUS);
        Y15.lVU = new j();
        List<PersonMoreItemData> list = this.lUS.mUrlMaps;
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
                Y15.lVU.lVY = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gJR.add(Y15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Y(int i, int i2, int i3) {
        h hVar = new h();
        hVar.gbi = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.gbi = i;
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

    public void vL(boolean z) {
        if (this.lVF != null) {
            if (this.lVF.lVU == null) {
                this.lVF.lVU = new j();
            }
            this.lVF.lVU.isShowRedTip = z;
        }
    }

    public void vM(boolean z) {
        if (this.lVI != null) {
            if (this.lVI.lVU == null) {
                this.lVI.lVU = new j();
            }
            this.lVI.lVU.isShowRedTip = z;
        }
    }

    public void vN(boolean z) {
        if (this.lVH != null) {
            if (this.lVH.lVU == null) {
                this.lVH.lVU = new j();
            }
            this.lVH.lVU.isShowRedTip = z;
        }
    }

    public void vO(boolean z) {
        if (this.lVD != null) {
            this.lVD.lVx = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.lVJ = new i();
            this.lVB = profileResIdl.data.banner;
            this.lVA = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fk(profileResIdl.data.url_map);
            this.gJR.add(this.lVJ);
            dtD();
            dtF();
            fj(profileResIdl.data.recom_swan_list);
            dtE();
            dtG();
            com.baidu.tieba.p.a.dBY().wN(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.lVJ = new i();
            this.lVJ.userData = this.mUserData;
            this.gJR.add(this.lVJ);
            dtD();
            dtG();
            com.baidu.tieba.p.a.dBY().wN(true);
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
        if (this.lVC == null && userGodInfo != null) {
            this.lVC = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.lVC.parserProtobuf(userGodInfo);
        }
        this.lVJ.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.lVE = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fk(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.lUS = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.lUS.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
