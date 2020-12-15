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
/* loaded from: classes22.dex */
public class f implements com.baidu.tieba.person.b {
    private com.baidu.tieba.j.b mLiveGoodsWindowData;
    private UserData mUserData;
    public PersonMoreData mjt;
    private Duxiaoman mkb;
    private List<BannerImage> mkc;
    private PersonUserGodInfo mkd;
    private d mke;
    public com.baidu.tieba.person.data.d mkf;
    public h mkg;
    public h mkh;
    public h mki;
    public h mkj;
    public i mkk;
    public n mkl;
    public k mkm;
    private int[] mkn = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mko = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mkp = {1, 2, 3, 4};
    private ArrayList<q> gSL = new ArrayList<>();

    public ArrayList<q> dyv() {
        return this.gSL;
    }

    private void dyw() {
        if (this.mke != null) {
            this.gSL.add(this.mke);
        } else if (this.mUserData != null) {
            this.mke = new d();
            this.mke.mjV = this.mUserData.getFansNum();
            this.mke.mjW = this.mUserData.getConcern_num();
            this.mke.mjX = this.mUserData.getLike_bars();
            this.mke.threadNum = this.mUserData.getThreadNum();
            this.mke.userData = this.mUserData;
            this.gSL.add(this.mke);
        }
    }

    private void dyx() {
        if (this.mkl != null) {
            this.gSL.add(this.mkl);
            return;
        }
        this.mkl = new n();
        if (!y.isEmpty(this.mkc)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mkc.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mkc.get(i2));
                if (!au.isEmpty(aVar.bmM())) {
                    this.mkl.mkc.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mkl.mkc.size() > 0) {
                this.gSL.add(this.mkl);
            }
        }
    }

    private void dyy() {
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mkr = this.mko[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mkn[i]);
                    aVar.type = this.mkp[i];
                }
                arrayList.add(aVar);
            }
            gVar.fx(arrayList);
            gVar.mUserData = this.mUserData;
            this.gSL.add(gVar);
        }
    }

    private void fv(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.mkm == null) {
                this.mkm = new k();
                this.gSL.add(this.mkm);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mkm.setData(arrayList);
        }
    }

    private void dyz() {
        if (this.mkg == null) {
            this.mkg = Z(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mkg.mks = true;
            this.mkg.mkv = new j();
        }
        this.gSL.add(this.mkg);
        h Z = Z(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Z.mks = true;
        Z.mku = true;
        this.gSL.add(Z);
        h Z2 = Z(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Z2.mku = true;
        Z2.mks = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cMY() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Z3 = Z(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Z3.mks = true;
            Z3.aJj = this.mLiveGoodsWindowData.goods_url;
            this.gSL.add(Z3);
        }
        h Z4 = Z(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Z4.mks = true;
        Z4.mkv = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Z4.mkv.isShowRedTip = true;
        }
        Z4.mkv.mkD = true;
        this.gSL.add(Z4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Z5 = Z(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Z5.mks = true;
            Z5.aJj = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gSL.add(Z5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("baidu_financial_display", 1) == 1) {
            h Z6 = Z(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Z6.mks = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z6.mkv = new j();
                Z6.mkv.isShowRedTip = true;
            }
            this.gSL.add(Z6);
        }
        if (this.mkb != null && this.mkb.is_end.intValue() != 1) {
            h Z7 = Z(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Z7.mks = true;
            Z7.aJj = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mkb.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Z7.mkv = jVar;
            }
            this.gSL.add(Z7);
        }
        h Z8 = Z(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Z8.mks = true;
        this.gSL.add(Z8);
        h Z9 = Z(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Z9.mks = true;
        this.gSL.add(Z9);
        this.mkh = Z(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mkh.mkv = new j();
        this.mkh.mks = true;
        this.mkh.mkv.text = au.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mkh.mkv.mkA = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gSL.add(this.mkh);
        h Z10 = Z(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Z10.mks = true;
        this.gSL.add(Z10);
        h Z11 = Z(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Z11.mks = true;
        if (this.mUserData.membershipInfo != null) {
            Z11.aJj = this.mUserData.membershipInfo.mLink;
        }
        this.gSL.add(Z11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mki = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mki.mku = true;
            this.mki.mkv = new j();
            this.gSL.add(this.mki);
            TiebaStatic.log(new ar("c12597"));
        } else {
            Z11.mku = true;
        }
        h Z12 = Z(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Z12.mks = true;
        this.gSL.add(Z12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Z13 = Z(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Z13.mks = true;
            Z13.mku = true;
            this.gSL.add(Z13);
        }
        this.mkj = Z(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mkj.mku = true;
        this.mkj.mks = true;
        this.gSL.add(this.mkj);
        h Z14 = Z(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Z14.mks = true;
        this.gSL.add(Z14);
        if (this.mjt == null) {
            this.mjt = new PersonMoreData();
        }
        h Z15 = Z(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Z15.mks = true;
        Z15.mkt = true;
        Z15.mkw = OrmObject.bundleWithObject(this.mjt);
        Z15.mkv = new j();
        List<PersonMoreItemData> list = this.mjt.mUrlMaps;
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
                Z15.mkv.mkz = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gSL.add(Z15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Z(int i, int i2, int i3) {
        h hVar = new h();
        hVar.gjd = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.gjd = i;
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

    public void ws(boolean z) {
        if (this.mkg != null) {
            if (this.mkg.mkv == null) {
                this.mkg.mkv = new j();
            }
            this.mkg.mkv.isShowRedTip = z;
        }
    }

    public void wt(boolean z) {
        if (this.mkj != null) {
            if (this.mkj.mkv == null) {
                this.mkj.mkv = new j();
            }
            this.mkj.mkv.isShowRedTip = z;
        }
    }

    public void wu(boolean z) {
        if (this.mki != null) {
            if (this.mki.mkv == null) {
                this.mki.mkv = new j();
            }
            this.mki.mkv.isShowRedTip = z;
        }
    }

    public void wv(boolean z) {
        if (this.mke != null) {
            this.mke.mjY = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mkk = new i();
            this.mkc = profileResIdl.data.banner;
            this.mkb = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fw(profileResIdl.data.url_map);
            this.gSL.add(this.mkk);
            dyw();
            dyy();
            fv(profileResIdl.data.recom_swan_list);
            dyx();
            dyz();
            com.baidu.tieba.q.a.dGO().xu(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mkk = new i();
            this.mkk.userData = this.mUserData;
            this.gSL.add(this.mkk);
            dyw();
            dyz();
            com.baidu.tieba.q.a.dGO().xu(true);
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
        if (this.mkd == null && userGodInfo != null) {
            this.mkd = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mkd.parserProtobuf(userGodInfo);
        }
        this.mkk.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mkf = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fw(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.mjt = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.mjt.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
