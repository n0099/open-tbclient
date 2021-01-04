package com.baidu.tieba.personCenter.c;

import android.text.TextUtils;
import androidx.annotation.StringRes;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
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
/* loaded from: classes2.dex */
public class f implements com.baidu.tieba.person.b {
    private com.baidu.tieba.j.b mLiveGoodsWindowData;
    private UserData mUserData;
    public PersonMoreData moC;
    private Duxiaoman mpk;
    private List<BannerImage> mpl;
    private PersonUserGodInfo mpm;
    private d mpn;
    public com.baidu.tieba.person.data.d mpo;
    public h mpp;
    public h mpq;
    public h mpr;
    public h mps;
    public i mpt;
    public n mpu;
    public k mpv;
    private int[] mpw = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mpx = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mpy = {1, 2, 3, 4};
    private ArrayList<com.baidu.adp.widget.ListView.n> hey = new ArrayList<>();

    public ArrayList<com.baidu.adp.widget.ListView.n> dyk() {
        return this.hey;
    }

    private void dyl() {
        if (this.mpn != null) {
            this.hey.add(this.mpn);
        } else if (this.mUserData != null) {
            this.mpn = new d();
            this.mpn.mpe = this.mUserData.getFansNum();
            this.mpn.mpf = this.mUserData.getConcern_num();
            this.mpn.mpg = this.mUserData.getLike_bars();
            this.mpn.threadNum = this.mUserData.getThreadNum();
            this.mpn.userData = this.mUserData;
            this.hey.add(this.mpn);
        }
    }

    private void dym() {
        if (this.mpu != null) {
            this.hey.add(this.mpu);
            return;
        }
        this.mpu = new n();
        if (!x.isEmpty(this.mpl)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mpl.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mpl.get(i2));
                if (!at.isEmpty(aVar.bpl())) {
                    this.mpu.mpl.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mpu.mpl.size() > 0) {
                this.hey.add(this.mpu);
            }
        }
    }

    private void dyn() {
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mpA = this.mpx[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mpw[i]);
                    aVar.type = this.mpy[i];
                }
                arrayList.add(aVar);
            }
            gVar.fx(arrayList);
            gVar.mUserData = this.mUserData;
            this.hey.add(gVar);
        }
    }

    private void fv(List<SmartApp> list) {
        if (!x.isEmpty(list)) {
            if (this.mpv == null) {
                this.mpv = new k();
                this.hey.add(this.mpv);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mpv.setData(arrayList);
        }
    }

    private void dyo() {
        if (this.mpp == null) {
            this.mpp = ab(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mpp.mpB = true;
            this.mpp.mpE = new j();
        }
        this.hey.add(this.mpp);
        h ab = ab(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        ab.mpB = true;
        ab.mpD = true;
        this.hey.add(ab);
        h ab2 = ab(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        ab2.mpD = true;
        ab2.mpB = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cQl() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h ab3 = ab(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            ab3.mpB = true;
            ab3.aJH = this.mLiveGoodsWindowData.goods_url;
            this.hey.add(ab3);
        }
        h ab4 = ab(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        ab4.mpB = true;
        ab4.mpE = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            ab4.mpE.isShowRedTip = true;
        }
        ab4.mpE.mpM = true;
        this.hey.add(ab4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h ab5 = ab(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            ab5.mpB = true;
            ab5.aJH = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.hey.add(ab5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvq().getInt("baidu_financial_display", 1) == 1) {
            h ab6 = ab(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            ab6.mpB = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("key_baidu_financial_has_clicked", false)) {
                ab6.mpE = new j();
                ab6.mpE.isShowRedTip = true;
            }
            this.hey.add(ab6);
        }
        if (this.mpk != null && this.mpk.is_end.intValue() != 1) {
            h ab7 = ab(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            ab7.mpB = true;
            ab7.aJH = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mpk.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                ab7.mpE = jVar;
            }
            this.hey.add(ab7);
        }
        h ab8 = ab(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        ab8.mpB = true;
        this.hey.add(ab8);
        h ab9 = ab(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        ab9.mpB = true;
        this.hey.add(ab9);
        this.mpq = ab(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mpq.mpE = new j();
        this.mpq.mpB = true;
        this.mpq.mpE.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mpq.mpE.mpJ = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.hey.add(this.mpq);
        h ab10 = ab(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        ab10.mpB = true;
        this.hey.add(ab10);
        h ab11 = ab(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        ab11.mpB = true;
        if (this.mUserData.membershipInfo != null) {
            ab11.aJH = this.mUserData.membershipInfo.mLink;
        }
        this.hey.add(ab11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mpr = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mpr.mpD = true;
            this.mpr.mpE = new j();
            this.hey.add(this.mpr);
            TiebaStatic.log(new aq("c12597"));
        } else {
            ab11.mpD = true;
        }
        h ab12 = ab(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        ab12.mpB = true;
        this.hey.add(ab12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h ab13 = ab(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            ab13.mpB = true;
            ab13.mpD = true;
            this.hey.add(ab13);
        }
        this.mps = ab(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mps.mpD = true;
        this.mps.mpB = true;
        this.hey.add(this.mps);
        h ab14 = ab(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        ab14.mpB = true;
        this.hey.add(ab14);
        if (this.moC == null) {
            this.moC = new PersonMoreData();
        }
        h ab15 = ab(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        ab15.mpB = true;
        ab15.mpC = true;
        ab15.mpF = OrmObject.bundleWithObject(this.moC);
        ab15.mpE = new j();
        List<PersonMoreItemData> list = this.moC.mUrlMaps;
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
                ab15.mpE.mpI = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.hey.add(ab15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h ab(int i, int i2, int i3) {
        h hVar = new h();
        hVar.gtC = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.gtC = i;
        hVar.title = str;
        hVar.type = i2;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    public void a(com.baidu.tbadk.data.n nVar) {
        this.mUserData.setPendantData(nVar);
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public void wt(boolean z) {
        if (this.mpp != null) {
            if (this.mpp.mpE == null) {
                this.mpp.mpE = new j();
            }
            this.mpp.mpE.isShowRedTip = z;
        }
    }

    public void wu(boolean z) {
        if (this.mps != null) {
            if (this.mps.mpE == null) {
                this.mps.mpE = new j();
            }
            this.mps.mpE.isShowRedTip = z;
        }
    }

    public void wv(boolean z) {
        if (this.mpr != null) {
            if (this.mpr.mpE == null) {
                this.mpr.mpE = new j();
            }
            this.mpr.mpE.isShowRedTip = z;
        }
    }

    public void ww(boolean z) {
        if (this.mpn != null) {
            this.mpn.mph = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mpt = new i();
            this.mpl = profileResIdl.data.banner;
            this.mpk = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fw(profileResIdl.data.url_map);
            this.hey.add(this.mpt);
            dyl();
            dyn();
            fv(profileResIdl.data.recom_swan_list);
            dym();
            dyo();
            com.baidu.tieba.p.a.dGD().xv(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mpt = new i();
            this.mpt.userData = this.mUserData;
            this.hey.add(this.mpt);
            dyl();
            dyo();
            com.baidu.tieba.p.a.dGD().xv(true);
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
        if (this.mpm == null && userGodInfo != null) {
            this.mpm = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mpm.parserProtobuf(userGodInfo);
        }
        this.mpt.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mpo = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fw(List<UserMap> list) {
        if (!x.isEmpty(list)) {
            this.moC = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.moC.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
