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
    public PersonMoreData mjW;
    private Duxiaoman mkE;
    private List<BannerImage> mkF;
    private PersonUserGodInfo mkG;
    private d mkH;
    public com.baidu.tieba.person.data.d mkI;
    public h mkJ;
    public h mkK;
    public h mkL;
    public h mkM;
    public i mkN;
    public n mkO;
    public k mkP;
    private int[] mkQ = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] mkR = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] mkS = {1, 2, 3, 4};
    private ArrayList<com.baidu.adp.widget.ListView.n> gZS = new ArrayList<>();

    public ArrayList<com.baidu.adp.widget.ListView.n> dut() {
        return this.gZS;
    }

    private void duu() {
        if (this.mkH != null) {
            this.gZS.add(this.mkH);
        } else if (this.mUserData != null) {
            this.mkH = new d();
            this.mkH.mky = this.mUserData.getFansNum();
            this.mkH.mkz = this.mUserData.getConcern_num();
            this.mkH.mkA = this.mUserData.getLike_bars();
            this.mkH.threadNum = this.mUserData.getThreadNum();
            this.mkH.userData = this.mUserData;
            this.gZS.add(this.mkH);
        }
    }

    private void duv() {
        if (this.mkO != null) {
            this.gZS.add(this.mkO);
            return;
        }
        this.mkO = new n();
        if (!x.isEmpty(this.mkF)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.mkF.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.mkF.get(i2));
                if (!at.isEmpty(aVar.bls())) {
                    this.mkO.mkF.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.mkO.mkF.size() > 0) {
                this.gZS.add(this.mkO);
            }
        }
    }

    private void duw() {
        if (com.baidu.tbadk.core.sharedPref.b.brx().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.mkU = this.mkR[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.mkQ[i]);
                    aVar.type = this.mkS[i];
                }
                arrayList.add(aVar);
            }
            gVar.fx(arrayList);
            gVar.mUserData = this.mUserData;
            this.gZS.add(gVar);
        }
    }

    private void fv(List<SmartApp> list) {
        if (!x.isEmpty(list)) {
            if (this.mkP == null) {
                this.mkP = new k();
                this.gZS.add(this.mkP);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.mkP.setData(arrayList);
        }
    }

    private void dux() {
        if (this.mkJ == null) {
            this.mkJ = ab(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.mkJ.mkV = true;
            this.mkJ.mkY = new j();
        }
        this.gZS.add(this.mkJ);
        h ab = ab(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        ab.mkV = true;
        ab.mkX = true;
        this.gZS.add(ab);
        h ab2 = ab(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        ab2.mkX = true;
        ab2.mkV = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cMu() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h ab3 = ab(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            ab3.mkV = true;
            ab3.aEU = this.mLiveGoodsWindowData.goods_url;
            this.gZS.add(ab3);
        }
        h ab4 = ab(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        ab4.mkV = true;
        ab4.mkY = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            ab4.mkY.isShowRedTip = true;
        }
        ab4.mkY.mlg = true;
        this.gZS.add(ab4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h ab5 = ab(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            ab5.mkV = true;
            ab5.aEU = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gZS.add(ab5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.brx().getInt("baidu_financial_display", 1) == 1) {
            h ab6 = ab(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            ab6.mkV = true;
            if (!com.baidu.tbadk.core.sharedPref.b.brx().getBoolean("key_baidu_financial_has_clicked", false)) {
                ab6.mkY = new j();
                ab6.mkY.isShowRedTip = true;
            }
            this.gZS.add(ab6);
        }
        if (this.mkE != null && this.mkE.is_end.intValue() != 1) {
            h ab7 = ab(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            ab7.mkV = true;
            ab7.aEU = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.mkE.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                ab7.mkY = jVar;
            }
            this.gZS.add(ab7);
        }
        h ab8 = ab(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        ab8.mkV = true;
        this.gZS.add(ab8);
        h ab9 = ab(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        ab9.mkV = true;
        this.gZS.add(ab9);
        this.mkK = ab(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.mkK.mkY = new j();
        this.mkK.mkV = true;
        this.mkK.mkY.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.mkK.mkY.mld = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gZS.add(this.mkK);
        h ab10 = ab(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        ab10.mkV = true;
        this.gZS.add(ab10);
        h ab11 = ab(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        ab11.mkV = true;
        if (this.mUserData.membershipInfo != null) {
            ab11.aEU = this.mUserData.membershipInfo.mLink;
        }
        this.gZS.add(ab11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.mkL = g(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.mkL.mkX = true;
            this.mkL.mkY = new j();
            this.gZS.add(this.mkL);
            TiebaStatic.log(new aq("c12597"));
        } else {
            ab11.mkX = true;
        }
        h ab12 = ab(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        ab12.mkV = true;
        this.gZS.add(ab12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h ab13 = ab(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            ab13.mkV = true;
            ab13.mkX = true;
            this.gZS.add(ab13);
        }
        this.mkM = ab(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.mkM.mkX = true;
        this.mkM.mkV = true;
        this.gZS.add(this.mkM);
        h ab14 = ab(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        ab14.mkV = true;
        this.gZS.add(ab14);
        if (this.mjW == null) {
            this.mjW = new PersonMoreData();
        }
        h ab15 = ab(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        ab15.mkV = true;
        ab15.mkW = true;
        ab15.mkZ = OrmObject.bundleWithObject(this.mjW);
        ab15.mkY = new j();
        List<PersonMoreItemData> list = this.mjW.mUrlMaps;
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
                ab15.mkY.mlc = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gZS.add(ab15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h ab(int i, int i2, int i3) {
        h hVar = new h();
        hVar.goV = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h g(int i, String str, int i2) {
        h hVar = new h();
        hVar.goV = i;
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

    public void wp(boolean z) {
        if (this.mkJ != null) {
            if (this.mkJ.mkY == null) {
                this.mkJ.mkY = new j();
            }
            this.mkJ.mkY.isShowRedTip = z;
        }
    }

    public void wq(boolean z) {
        if (this.mkM != null) {
            if (this.mkM.mkY == null) {
                this.mkM.mkY = new j();
            }
            this.mkM.mkY.isShowRedTip = z;
        }
    }

    public void wr(boolean z) {
        if (this.mkL != null) {
            if (this.mkL.mkY == null) {
                this.mkL.mkY = new j();
            }
            this.mkL.mkY.isShowRedTip = z;
        }
    }

    public void ws(boolean z) {
        if (this.mkH != null) {
            this.mkH.mkB = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.mkN = new i();
            this.mkF = profileResIdl.data.banner;
            this.mkE = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fw(profileResIdl.data.url_map);
            this.gZS.add(this.mkN);
            duu();
            duw();
            fv(profileResIdl.data.recom_swan_list);
            duv();
            dux();
            com.baidu.tieba.p.a.dCM().xr(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.mkN = new i();
            this.mkN.userData = this.mUserData;
            this.gZS.add(this.mkN);
            duu();
            dux();
            com.baidu.tieba.p.a.dCM().xr(true);
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
        if (this.mkG == null && userGodInfo != null) {
            this.mkG = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.mkG.parserProtobuf(userGodInfo);
        }
        this.mkN.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.mkI = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fw(List<UserMap> list) {
        if (!x.isEmpty(list)) {
            this.mjW = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.mjW.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
