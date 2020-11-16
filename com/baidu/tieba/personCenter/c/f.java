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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private Duxiaoman lVS;
    private List<BannerImage> lVT;
    private PersonUserGodInfo lVU;
    private d lVV;
    public com.baidu.tieba.person.data.d lVW;
    public h lVX;
    public h lVY;
    public h lVZ;
    public PersonMoreData lVk;
    public h lWa;
    public i lWb;
    public n lWc;
    public k lWd;
    private com.baidu.tieba.j.b mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] lWe = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] lWf = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] lWg = {1, 2, 3, 4};
    private ArrayList<q> gJy = new ArrayList<>();

    public ArrayList<q> dtc() {
        return this.gJy;
    }

    private void dtd() {
        if (this.lVV != null) {
            this.gJy.add(this.lVV);
        } else if (this.mUserData != null) {
            this.lVV = new d();
            this.lVV.lVM = this.mUserData.getFansNum();
            this.lVV.lVN = this.mUserData.getConcern_num();
            this.lVV.lVO = this.mUserData.getLike_bars();
            this.lVV.threadNum = this.mUserData.getThreadNum();
            this.lVV.userData = this.mUserData;
            this.gJy.add(this.lVV);
        }
    }

    private void dte() {
        if (this.lWc != null) {
            this.gJy.add(this.lWc);
            return;
        }
        this.lWc = new n();
        if (!y.isEmpty(this.lVT)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lVT.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.lVT.get(i2));
                if (!au.isEmpty(aVar.bjz())) {
                    this.lWc.lVT.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.lWc.lVT.size() > 0) {
                this.gJy.add(this.lWc);
            }
        }
    }

    private void dtf() {
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.lWi = this.lWf[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.lWe[i]);
                    aVar.type = this.lWg[i];
                }
                arrayList.add(aVar);
            }
            gVar.fl(arrayList);
            gVar.mUserData = this.mUserData;
            this.gJy.add(gVar);
        }
    }

    private void fj(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.lWd == null) {
                this.lWd = new k();
                this.gJy.add(this.lWd);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.lWd.setData(arrayList);
        }
    }

    private void dtg() {
        if (this.lVX == null) {
            this.lVX = aa(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.lVX.lWj = true;
            this.lVX.lWm = new j();
        }
        this.gJy.add(this.lVX);
        h aa = aa(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        aa.lWj = true;
        aa.lWl = true;
        this.gJy.add(aa);
        h aa2 = aa(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        aa2.lWl = true;
        aa2.lWj = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cHJ() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h aa3 = aa(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            aa3.lWj = true;
            aa3.aGz = this.mLiveGoodsWindowData.goods_url;
            this.gJy.add(aa3);
        }
        h aa4 = aa(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        aa4.lWj = true;
        aa4.lWm = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            aa4.lWm.isShowRedTip = true;
        }
        aa4.lWm.lWu = true;
        this.gJy.add(aa4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h aa5 = aa(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            aa5.lWj = true;
            aa5.aGz = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gJy.add(aa5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bpu().getInt("baidu_financial_display", 1) == 1) {
            h aa6 = aa(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            aa6.lWj = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("key_baidu_financial_has_clicked", false)) {
                aa6.lWm = new j();
                aa6.lWm.isShowRedTip = true;
            }
            this.gJy.add(aa6);
        }
        if (this.lVS != null && this.lVS.is_end.intValue() != 1) {
            h aa7 = aa(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            aa7.lWj = true;
            aa7.aGz = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.lVS.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                aa7.lWm = jVar;
            }
            this.gJy.add(aa7);
        }
        h aa8 = aa(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        aa8.lWj = true;
        this.gJy.add(aa8);
        h aa9 = aa(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        aa9.lWj = true;
        this.gJy.add(aa9);
        this.lVY = aa(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.lVY.lWm = new j();
        this.lVY.lWj = true;
        this.lVY.lWm.text = au.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.lVY.lWm.lWr = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gJy.add(this.lVY);
        h aa10 = aa(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        aa10.lWj = true;
        this.gJy.add(aa10);
        h aa11 = aa(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        aa11.lWj = true;
        if (this.mUserData.membershipInfo != null) {
            aa11.aGz = this.mUserData.membershipInfo.mLink;
        }
        this.gJy.add(aa11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.lVZ = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.lVZ.lWl = true;
            this.lVZ.lWm = new j();
            this.gJy.add(this.lVZ);
            TiebaStatic.log(new ar("c12597"));
        } else {
            aa11.lWl = true;
        }
        h aa12 = aa(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        aa12.lWj = true;
        this.gJy.add(aa12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h aa13 = aa(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            aa13.lWj = true;
            aa13.lWl = true;
            this.gJy.add(aa13);
        }
        this.lWa = aa(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.lWa.lWl = true;
        this.lWa.lWj = true;
        this.gJy.add(this.lWa);
        h aa14 = aa(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        aa14.lWj = true;
        this.gJy.add(aa14);
        if (this.lVk == null) {
            this.lVk = new PersonMoreData();
        }
        h aa15 = aa(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        aa15.lWj = true;
        aa15.lWk = true;
        aa15.lWn = OrmObject.bundleWithObject(this.lVk);
        aa15.lWm = new j();
        List<PersonMoreItemData> list = this.lVk.mUrlMaps;
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
                aa15.lWm.lWq = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gJy.add(aa15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h aa(int i, int i2, int i3) {
        h hVar = new h();
        hVar.gaP = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.gaP = i;
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

    public void vO(boolean z) {
        if (this.lVX != null) {
            if (this.lVX.lWm == null) {
                this.lVX.lWm = new j();
            }
            this.lVX.lWm.isShowRedTip = z;
        }
    }

    public void vP(boolean z) {
        if (this.lWa != null) {
            if (this.lWa.lWm == null) {
                this.lWa.lWm = new j();
            }
            this.lWa.lWm.isShowRedTip = z;
        }
    }

    public void vQ(boolean z) {
        if (this.lVZ != null) {
            if (this.lVZ.lWm == null) {
                this.lVZ.lWm = new j();
            }
            this.lVZ.lWm.isShowRedTip = z;
        }
    }

    public void vR(boolean z) {
        if (this.lVV != null) {
            this.lVV.lVP = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.lWb = new i();
            this.lVT = profileResIdl.data.banner;
            this.lVS = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fk(profileResIdl.data.url_map);
            this.gJy.add(this.lWb);
            dtd();
            dtf();
            fj(profileResIdl.data.recom_swan_list);
            dte();
            dtg();
            com.baidu.tieba.q.a.dBC().wQ(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.lWb = new i();
            this.lWb.userData = this.mUserData;
            this.gJy.add(this.lWb);
            dtd();
            dtg();
            com.baidu.tieba.q.a.dBC().wQ(true);
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
        if (this.lVU == null && userGodInfo != null) {
            this.lVU = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.lVU.parserProtobuf(userGodInfo);
        }
        this.lWb.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.lVW = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fk(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.lVk = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.lVk.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
