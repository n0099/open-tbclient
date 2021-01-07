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
    public PersonMoreData moB;
    private Duxiaoman mpj;
    private List<BannerImage> mpk;
    private PersonUserGodInfo mpl;
    private d mpm;
    public com.baidu.tieba.person.data.d mpn;
    public h mpo;
    public h mpp;
    public h mpq;
    public h mpr;
    public i mps;
    public n mpt;
    public k mpu;
    private int[] mpv = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mpw = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mpx = {1, 2, 3, 4};
    private ArrayList<com.baidu.adp.widget.ListView.n> hey = new ArrayList<>();

    public ArrayList<com.baidu.adp.widget.ListView.n> dyl() {
        return this.hey;
    }

    private void dym() {
        if (this.mpm != null) {
            this.hey.add(this.mpm);
        } else if (this.mUserData != null) {
            this.mpm = new d();
            this.mpm.mpd = this.mUserData.getFansNum();
            this.mpm.mpe = this.mUserData.getConcern_num();
            this.mpm.mpf = this.mUserData.getLike_bars();
            this.mpm.threadNum = this.mUserData.getThreadNum();
            this.mpm.userData = this.mUserData;
            this.hey.add(this.mpm);
        }
    }

    private void dyn() {
        if (this.mpt != null) {
            this.hey.add(this.mpt);
            return;
        }
        this.mpt = new n();
        if (!x.isEmpty(this.mpk)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mpk.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mpk.get(i2));
                if (!at.isEmpty(aVar.bpm())) {
                    this.mpt.mpk.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mpt.mpk.size() > 0) {
                this.hey.add(this.mpt);
            }
        }
    }

    private void dyo() {
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mpz = this.mpw[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mpv[i]);
                    aVar.type = this.mpx[i];
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
            if (this.mpu == null) {
                this.mpu = new k();
                this.hey.add(this.mpu);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mpu.setData(arrayList);
        }
    }

    private void dyp() {
        if (this.mpo == null) {
            this.mpo = ab(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mpo.mpA = true;
            this.mpo.mpD = new j();
        }
        this.hey.add(this.mpo);
        h ab = ab(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        ab.mpA = true;
        ab.mpC = true;
        this.hey.add(ab);
        h ab2 = ab(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        ab2.mpC = true;
        ab2.mpA = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cQm() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h ab3 = ab(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            ab3.mpA = true;
            ab3.aJH = this.mLiveGoodsWindowData.goods_url;
            this.hey.add(ab3);
        }
        h ab4 = ab(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        ab4.mpA = true;
        ab4.mpD = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            ab4.mpD.isShowRedTip = true;
        }
        ab4.mpD.mpL = true;
        this.hey.add(ab4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h ab5 = ab(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            ab5.mpA = true;
            ab5.aJH = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.hey.add(ab5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bvr().getInt("baidu_financial_display", 1) == 1) {
            h ab6 = ab(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            ab6.mpA = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bvr().getBoolean("key_baidu_financial_has_clicked", false)) {
                ab6.mpD = new j();
                ab6.mpD.isShowRedTip = true;
            }
            this.hey.add(ab6);
        }
        if (this.mpj != null && this.mpj.is_end.intValue() != 1) {
            h ab7 = ab(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            ab7.mpA = true;
            ab7.aJH = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mpj.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                ab7.mpD = jVar;
            }
            this.hey.add(ab7);
        }
        h ab8 = ab(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        ab8.mpA = true;
        this.hey.add(ab8);
        h ab9 = ab(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        ab9.mpA = true;
        this.hey.add(ab9);
        this.mpp = ab(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mpp.mpD = new j();
        this.mpp.mpA = true;
        this.mpp.mpD.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mpp.mpD.mpI = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.hey.add(this.mpp);
        h ab10 = ab(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        ab10.mpA = true;
        this.hey.add(ab10);
        h ab11 = ab(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        ab11.mpA = true;
        if (this.mUserData.membershipInfo != null) {
            ab11.aJH = this.mUserData.membershipInfo.mLink;
        }
        this.hey.add(ab11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mpq = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mpq.mpC = true;
            this.mpq.mpD = new j();
            this.hey.add(this.mpq);
            TiebaStatic.log(new aq("c12597"));
        } else {
            ab11.mpC = true;
        }
        h ab12 = ab(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        ab12.mpA = true;
        this.hey.add(ab12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h ab13 = ab(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            ab13.mpA = true;
            ab13.mpC = true;
            this.hey.add(ab13);
        }
        this.mpr = ab(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mpr.mpC = true;
        this.mpr.mpA = true;
        this.hey.add(this.mpr);
        h ab14 = ab(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        ab14.mpA = true;
        this.hey.add(ab14);
        if (this.moB == null) {
            this.moB = new PersonMoreData();
        }
        h ab15 = ab(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        ab15.mpA = true;
        ab15.mpB = true;
        ab15.mpE = OrmObject.bundleWithObject(this.moB);
        ab15.mpD = new j();
        List<PersonMoreItemData> list = this.moB.mUrlMaps;
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
                ab15.mpD.mpH = getString(R.string.person_center_more_desc, sb.toString());
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
        if (this.mpo != null) {
            if (this.mpo.mpD == null) {
                this.mpo.mpD = new j();
            }
            this.mpo.mpD.isShowRedTip = z;
        }
    }

    public void wu(boolean z) {
        if (this.mpr != null) {
            if (this.mpr.mpD == null) {
                this.mpr.mpD = new j();
            }
            this.mpr.mpD.isShowRedTip = z;
        }
    }

    public void wv(boolean z) {
        if (this.mpq != null) {
            if (this.mpq.mpD == null) {
                this.mpq.mpD = new j();
            }
            this.mpq.mpD.isShowRedTip = z;
        }
    }

    public void ww(boolean z) {
        if (this.mpm != null) {
            this.mpm.mpg = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mps = new i();
            this.mpk = profileResIdl.data.banner;
            this.mpj = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fw(profileResIdl.data.url_map);
            this.hey.add(this.mps);
            dym();
            dyo();
            fv(profileResIdl.data.recom_swan_list);
            dyn();
            dyp();
            com.baidu.tieba.p.a.dGE().xv(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mps = new i();
            this.mps.userData = this.mUserData;
            this.hey.add(this.mps);
            dym();
            dyp();
            com.baidu.tieba.p.a.dGE().xv(true);
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
        if (this.mpl == null && userGodInfo != null) {
            this.mpl = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mpl.parserProtobuf(userGodInfo);
        }
        this.mps.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mpn = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fw(List<UserMap> list) {
        if (!x.isEmpty(list)) {
            this.moB = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.moB.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
