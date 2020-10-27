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
    public PersonMoreData lOW;
    private Duxiaoman lPE;
    private List<BannerImage> lPF;
    private PersonUserGodInfo lPG;
    private d lPH;
    public com.baidu.tieba.person.data.d lPI;
    public h lPJ;
    public h lPK;
    public h lPL;
    public h lPM;
    public i lPN;
    public n lPO;
    public k lPP;
    private com.baidu.tieba.i.b mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] lPQ = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] lPR = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] lPS = {1, 2, 3, 4};
    private ArrayList<q> gEe = new ArrayList<>();

    public ArrayList<q> dra() {
        return this.gEe;
    }

    private void drb() {
        if (this.lPH != null) {
            this.gEe.add(this.lPH);
        } else if (this.mUserData != null) {
            this.lPH = new d();
            this.lPH.lPy = this.mUserData.getFansNum();
            this.lPH.lPz = this.mUserData.getConcern_num();
            this.lPH.lPA = this.mUserData.getLike_bars();
            this.lPH.threadNum = this.mUserData.getThreadNum();
            this.lPH.userData = this.mUserData;
            this.gEe.add(this.lPH);
        }
    }

    private void drc() {
        if (this.lPO != null) {
            this.gEe.add(this.lPO);
            return;
        }
        this.lPO = new n();
        if (!y.isEmpty(this.lPF)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.lPF.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.lPF.get(i2));
                if (!at.isEmpty(aVar.bhX())) {
                    this.lPO.lPF.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.lPO.lPF.size() > 0) {
                this.gEe.add(this.lPO);
            }
        }
    }

    private void drd() {
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.lPU = this.lPR[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.lPQ[i]);
                    aVar.type = this.lPS[i];
                }
                arrayList.add(aVar);
            }
            gVar.fd(arrayList);
            gVar.mUserData = this.mUserData;
            this.gEe.add(gVar);
        }
    }

    private void fb(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.lPP == null) {
                this.lPP = new k();
                this.gEe.add(this.lPP);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.lPP.setData(arrayList);
        }
    }

    private void dre() {
        if (this.lPJ == null) {
            this.lPJ = Y(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.lPJ.lPV = true;
            this.lPJ.lPY = new j();
        }
        this.gEe.add(this.lPJ);
        h Y = Y(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        Y.lPV = true;
        Y.lPX = true;
        this.gEe.add(Y);
        h Y2 = Y(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        Y2.lPX = true;
        Y2.lPV = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cFD() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h Y3 = Y(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            Y3.lPV = true;
            Y3.aHs = this.mLiveGoodsWindowData.goods_url;
            this.gEe.add(Y3);
        }
        h Y4 = Y(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        Y4.lPV = true;
        Y4.lPY = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            Y4.lPY.isShowRedTip = true;
        }
        Y4.lPY.lQg = true;
        this.gEe.add(Y4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h Y5 = Y(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            Y5.lPV = true;
            Y5.aHs = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gEe.add(Y5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bnH().getInt("baidu_financial_display", 1) == 1) {
            h Y6 = Y(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            Y6.lPV = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bnH().getBoolean("key_baidu_financial_has_clicked", false)) {
                Y6.lPY = new j();
                Y6.lPY.isShowRedTip = true;
            }
            this.gEe.add(Y6);
        }
        if (this.lPE != null && this.lPE.is_end.intValue() != 1) {
            h Y7 = Y(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            Y7.lPV = true;
            Y7.aHs = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.lPE.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                Y7.lPY = jVar;
            }
            this.gEe.add(Y7);
        }
        h Y8 = Y(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        Y8.lPV = true;
        this.gEe.add(Y8);
        h Y9 = Y(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        Y9.lPV = true;
        this.gEe.add(Y9);
        this.lPK = Y(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.lPK.lPY = new j();
        this.lPK.lPV = true;
        this.lPK.lPY.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.lPK.lPY.lQd = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gEe.add(this.lPK);
        h Y10 = Y(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        Y10.lPV = true;
        this.gEe.add(Y10);
        h Y11 = Y(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        Y11.lPV = true;
        if (this.mUserData.membershipInfo != null) {
            Y11.aHs = this.mUserData.membershipInfo.mLink;
        }
        this.gEe.add(Y11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.lPL = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.lPL.lPX = true;
            this.lPL.lPY = new j();
            this.gEe.add(this.lPL);
            TiebaStatic.log(new aq("c12597"));
        } else {
            Y11.lPX = true;
        }
        h Y12 = Y(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        Y12.lPV = true;
        this.gEe.add(Y12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h Y13 = Y(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            Y13.lPV = true;
            Y13.lPX = true;
            this.gEe.add(Y13);
        }
        this.lPM = Y(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.lPM.lPX = true;
        this.lPM.lPV = true;
        this.gEe.add(this.lPM);
        h Y14 = Y(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        Y14.lPV = true;
        this.gEe.add(Y14);
        if (this.lOW == null) {
            this.lOW = new PersonMoreData();
        }
        h Y15 = Y(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        Y15.lPV = true;
        Y15.lPW = true;
        Y15.lPZ = OrmObject.bundleWithObject(this.lOW);
        Y15.lPY = new j();
        List<PersonMoreItemData> list = this.lOW.mUrlMaps;
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
                Y15.lPY.lQc = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gEe.add(Y15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h Y(int i, int i2, int i3) {
        h hVar = new h();
        hVar.fVr = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.fVr = i;
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

    public void vC(boolean z) {
        if (this.lPJ != null) {
            if (this.lPJ.lPY == null) {
                this.lPJ.lPY = new j();
            }
            this.lPJ.lPY.isShowRedTip = z;
        }
    }

    public void vD(boolean z) {
        if (this.lPM != null) {
            if (this.lPM.lPY == null) {
                this.lPM.lPY = new j();
            }
            this.lPM.lPY.isShowRedTip = z;
        }
    }

    public void vE(boolean z) {
        if (this.lPL != null) {
            if (this.lPL.lPY == null) {
                this.lPL.lPY = new j();
            }
            this.lPL.lPY.isShowRedTip = z;
        }
    }

    public void vF(boolean z) {
        if (this.lPH != null) {
            this.lPH.lPB = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.lPN = new i();
            this.lPF = profileResIdl.data.banner;
            this.lPE = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            fc(profileResIdl.data.url_map);
            this.gEe.add(this.lPN);
            drb();
            drd();
            fb(profileResIdl.data.recom_swan_list);
            drc();
            dre();
            com.baidu.tieba.p.a.dzw().wE(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.lPN = new i();
            this.lPN.userData = this.mUserData;
            this.gEe.add(this.lPN);
            drb();
            dre();
            com.baidu.tieba.p.a.dzw().wE(true);
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
        if (this.lPG == null && userGodInfo != null) {
            this.lPG = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.lPG.parserProtobuf(userGodInfo);
        }
        this.lPN.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.lPI = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void fc(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.lOW = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.lOW.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
