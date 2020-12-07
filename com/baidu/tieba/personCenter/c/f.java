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
    private Duxiaoman mjZ;
    public PersonMoreData mjr;
    private List<BannerImage> mka;
    private PersonUserGodInfo mkb;
    private d mkc;
    public com.baidu.tieba.person.data.d mkd;
    public h mke;
    public h mkf;
    public h mkg;
    public h mkh;
    public i mki;
    public n mkj;
    public k mkk;
    private int[] mkl = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mkm = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mkn = {1, 2, 3, 4};
    private ArrayList<q> gSJ = new ArrayList<>();

    public ArrayList<q> dyu() {
        return this.gSJ;
    }

    private void dyv() {
        if (this.mkc != null) {
            this.gSJ.add(this.mkc);
        } else if (this.mUserData != null) {
            this.mkc = new d();
            this.mkc.mjT = this.mUserData.getFansNum();
            this.mkc.mjU = this.mUserData.getConcern_num();
            this.mkc.mjV = this.mUserData.getLike_bars();
            this.mkc.threadNum = this.mUserData.getThreadNum();
            this.mkc.userData = this.mUserData;
            this.gSJ.add(this.mkc);
        }
    }

    private void dyw() {
        if (this.mkj != null) {
            this.gSJ.add(this.mkj);
            return;
        }
        this.mkj = new n();
        if (!y.isEmpty(this.mka)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mka.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mka.get(i2));
                if (!au.isEmpty(aVar.bmM())) {
                    this.mkj.mka.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mkj.mka.size() > 0) {
                this.gSJ.add(this.mkj);
            }
        }
    }

    private void dyx() {
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mkp = this.mkm[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mkl[i]);
                    aVar.type = this.mkn[i];
                }
                arrayList.add(aVar);
            }
            gVar.fx(arrayList);
            gVar.mUserData = this.mUserData;
            this.gSJ.add(gVar);
        }
    }

    private void fv(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.mkk == null) {
                this.mkk = new k();
                this.gSJ.add(this.mkk);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mkk.setData(arrayList);
        }
    }

    private void dyy() {
        if (this.mke == null) {
            this.mke = Z(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mke.mkq = true;
            this.mke.mkt = new j();
        }
        this.gSJ.add(this.mke);
        h Z = Z(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Z.mkq = true;
        Z.mks = true;
        this.gSJ.add(Z);
        h Z2 = Z(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Z2.mks = true;
        Z2.mkq = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cMX() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Z3 = Z(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Z3.mkq = true;
            Z3.aJj = this.mLiveGoodsWindowData.goods_url;
            this.gSJ.add(Z3);
        }
        h Z4 = Z(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Z4.mkq = true;
        Z4.mkt = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Z4.mkt.isShowRedTip = true;
        }
        Z4.mkt.mkB = true;
        this.gSJ.add(Z4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Z5 = Z(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Z5.mkq = true;
            Z5.aJj = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gSJ.add(Z5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bsO().getInt("baidu_financial_display", 1) == 1) {
            h Z6 = Z(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Z6.mkq = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("key_baidu_financial_has_clicked", false)) {
                Z6.mkt = new j();
                Z6.mkt.isShowRedTip = true;
            }
            this.gSJ.add(Z6);
        }
        if (this.mjZ != null && this.mjZ.is_end.intValue() != 1) {
            h Z7 = Z(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Z7.mkq = true;
            Z7.aJj = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mjZ.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Z7.mkt = jVar;
            }
            this.gSJ.add(Z7);
        }
        h Z8 = Z(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Z8.mkq = true;
        this.gSJ.add(Z8);
        h Z9 = Z(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Z9.mkq = true;
        this.gSJ.add(Z9);
        this.mkf = Z(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mkf.mkt = new j();
        this.mkf.mkq = true;
        this.mkf.mkt.text = au.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mkf.mkt.mky = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gSJ.add(this.mkf);
        h Z10 = Z(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Z10.mkq = true;
        this.gSJ.add(Z10);
        h Z11 = Z(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Z11.mkq = true;
        if (this.mUserData.membershipInfo != null) {
            Z11.aJj = this.mUserData.membershipInfo.mLink;
        }
        this.gSJ.add(Z11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mkg = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mkg.mks = true;
            this.mkg.mkt = new j();
            this.gSJ.add(this.mkg);
            TiebaStatic.log(new ar("c12597"));
        } else {
            Z11.mks = true;
        }
        h Z12 = Z(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Z12.mkq = true;
        this.gSJ.add(Z12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Z13 = Z(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Z13.mkq = true;
            Z13.mks = true;
            this.gSJ.add(Z13);
        }
        this.mkh = Z(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mkh.mks = true;
        this.mkh.mkq = true;
        this.gSJ.add(this.mkh);
        h Z14 = Z(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Z14.mkq = true;
        this.gSJ.add(Z14);
        if (this.mjr == null) {
            this.mjr = new PersonMoreData();
        }
        h Z15 = Z(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Z15.mkq = true;
        Z15.mkr = true;
        Z15.mku = OrmObject.bundleWithObject(this.mjr);
        Z15.mkt = new j();
        List<PersonMoreItemData> list = this.mjr.mUrlMaps;
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
                Z15.mkt.mkx = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gSJ.add(Z15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Z(int i, int i2, int i3) {
        h hVar = new h();
        hVar.gjb = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.gjb = i;
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
        if (this.mke != null) {
            if (this.mke.mkt == null) {
                this.mke.mkt = new j();
            }
            this.mke.mkt.isShowRedTip = z;
        }
    }

    public void wt(boolean z) {
        if (this.mkh != null) {
            if (this.mkh.mkt == null) {
                this.mkh.mkt = new j();
            }
            this.mkh.mkt.isShowRedTip = z;
        }
    }

    public void wu(boolean z) {
        if (this.mkg != null) {
            if (this.mkg.mkt == null) {
                this.mkg.mkt = new j();
            }
            this.mkg.mkt.isShowRedTip = z;
        }
    }

    public void wv(boolean z) {
        if (this.mkc != null) {
            this.mkc.mjW = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mki = new i();
            this.mka = profileResIdl.data.banner;
            this.mjZ = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fw(profileResIdl.data.url_map);
            this.gSJ.add(this.mki);
            dyv();
            dyx();
            fv(profileResIdl.data.recom_swan_list);
            dyw();
            dyy();
            com.baidu.tieba.q.a.dGN().xu(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mki = new i();
            this.mki.userData = this.mUserData;
            this.gSJ.add(this.mki);
            dyv();
            dyy();
            com.baidu.tieba.q.a.dGN().xu(true);
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
        if (this.mkb == null && userGodInfo != null) {
            this.mkb = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mkb.parserProtobuf(userGodInfo);
        }
        this.mki.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mkd = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fw(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.mjr = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.mjr.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
