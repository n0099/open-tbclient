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
/* loaded from: classes16.dex */
public class f implements com.baidu.tieba.person.b {
    private Duxiaoman leR;
    private List<BannerImage> leS;
    private PersonUserGodInfo leT;
    private d leU;
    public com.baidu.tieba.person.data.d leV;
    public h leW;
    public h leX;
    public h leY;
    public h leZ;
    public PersonMoreData lej;
    public i lfa;
    public n lfb;
    public k lfc;
    private com.baidu.tieba.i.b mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] lfd = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] lfe = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] lff = {1, 2, 3, 4};
    private ArrayList<q> gew = new ArrayList<>();

    public ArrayList<q> dgD() {
        return this.gew;
    }

    private void dgE() {
        if (this.leU != null) {
            this.gew.add(this.leU);
        } else if (this.mUserData != null) {
            this.leU = new d();
            this.leU.leL = this.mUserData.getFansNum();
            this.leU.leM = this.mUserData.getConcern_num();
            this.leU.leN = this.mUserData.getLike_bars();
            this.leU.threadNum = this.mUserData.getThreadNum();
            this.leU.userData = this.mUserData;
            this.gew.add(this.leU);
        }
    }

    private void dgF() {
        if (this.lfb != null) {
            this.gew.add(this.lfb);
            return;
        }
        this.lfb = new n();
        if (!y.isEmpty(this.leS)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.leS.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.leS.get(i2));
                if (!at.isEmpty(aVar.bcB())) {
                    this.lfb.leS.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.lfb.leS.size() > 0) {
                this.gew.add(this.lfb);
            }
        }
    }

    private void dgG() {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.lfh = this.lfe[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.lfd[i]);
                    aVar.type = this.lff[i];
                }
                arrayList.add(aVar);
            }
            gVar.eJ(arrayList);
            gVar.mUserData = this.mUserData;
            this.gew.add(gVar);
        }
    }

    private void eH(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.lfc == null) {
                this.lfc = new k();
                this.gew.add(this.lfc);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.lfc.setData(arrayList);
        }
    }

    private void dgH() {
        if (this.leW == null) {
            this.leW = V(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.leW.lfj = true;
            this.leW.lfm = new j();
        }
        this.gew.add(this.leW);
        h V = V(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        V.lfj = true;
        V.lfl = true;
        this.gew.add(V);
        h V2 = V(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        V2.lfl = true;
        V2.lfj = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cvE() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h V3 = V(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            V3.lfj = true;
            V3.aDg = this.mLiveGoodsWindowData.goods_url;
            this.gew.add(V3);
        }
        h V4 = V(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        V4.lfj = true;
        V4.lfm = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            V4.lfm.isShowRedTip = true;
        }
        V4.lfm.lfu = true;
        this.gew.add(V4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h V5 = V(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            V5.lfj = true;
            V5.aDg = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.gew.add(V5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("baidu_financial_display", 1) == 1) {
            h V6 = V(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            V6.lfj = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_baidu_financial_has_clicked", false)) {
                V6.lfm = new j();
                V6.lfm.isShowRedTip = true;
            }
            this.gew.add(V6);
        }
        if (this.leR != null && this.leR.is_end.intValue() != 1) {
            h V7 = V(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            V7.lfj = true;
            V7.aDg = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.leR.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                V7.lfm = jVar;
            }
            this.gew.add(V7);
        }
        h V8 = V(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        V8.lfj = true;
        this.gew.add(V8);
        h V9 = V(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        V9.lfj = true;
        this.gew.add(V9);
        this.leX = V(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.leX.lfm = new j();
        this.leX.lfj = true;
        this.leX.lfm.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.leX.lfm.lfr = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.gew.add(this.leX);
        h V10 = V(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        V10.lfj = true;
        this.gew.add(V10);
        h V11 = V(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        V11.lfj = true;
        if (this.mUserData.membershipInfo != null) {
            V11.aDg = this.mUserData.membershipInfo.mLink;
        }
        this.gew.add(V11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.leY = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.leY.lfl = true;
            this.leY.lfm = new j();
            this.gew.add(this.leY);
            TiebaStatic.log(new aq("c12597"));
        } else {
            V11.lfl = true;
        }
        h V12 = V(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        V12.lfj = true;
        this.gew.add(V12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h V13 = V(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            V13.lfj = true;
            V13.lfl = true;
            this.gew.add(V13);
        }
        this.leZ = V(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.leZ.lfl = true;
        this.leZ.lfj = true;
        this.gew.add(this.leZ);
        h V14 = V(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        V14.lfj = true;
        this.gew.add(V14);
        if (this.lej == null) {
            this.lej = new PersonMoreData();
        }
        h V15 = V(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        V15.lfj = true;
        V15.lfk = true;
        V15.lfn = OrmObject.bundleWithObject(this.lej);
        V15.lfm = new j();
        List<PersonMoreItemData> list = this.lej.mUrlMaps;
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
                V15.lfm.lfq = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.gew.add(V15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h V(int i, int i2, int i3) {
        h hVar = new h();
        hVar.lfi = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.lfi = i;
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

    public void uu(boolean z) {
        if (this.leW != null) {
            if (this.leW.lfm == null) {
                this.leW.lfm = new j();
            }
            this.leW.lfm.isShowRedTip = z;
        }
    }

    public void uv(boolean z) {
        if (this.leZ != null) {
            if (this.leZ.lfm == null) {
                this.leZ.lfm = new j();
            }
            this.leZ.lfm.isShowRedTip = z;
        }
    }

    public void uw(boolean z) {
        if (this.leY != null) {
            if (this.leY.lfm == null) {
                this.leY.lfm = new j();
            }
            this.leY.lfm.isShowRedTip = z;
        }
    }

    public void ux(boolean z) {
        if (this.leU != null) {
            this.leU.leO = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.lfa = new i();
            this.leS = profileResIdl.data.banner;
            this.leR = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            eI(profileResIdl.data.url_map);
            this.gew.add(this.lfa);
            dgE();
            dgG();
            eH(profileResIdl.data.recom_swan_list);
            dgF();
            dgH();
            com.baidu.tieba.p.a.doQ().vw(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.lfa = new i();
            this.lfa.userData = this.mUserData;
            this.gew.add(this.lfa);
            dgE();
            dgH();
            com.baidu.tieba.p.a.doQ().vw(true);
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
        if (this.leT == null && userGodInfo != null) {
            this.leT = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.leT.parserProtobuf(userGodInfo);
        }
        this.lfa.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.leV = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void eI(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.lej = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.lej.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
