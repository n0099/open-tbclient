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
    private Duxiaoman leY;
    private List<BannerImage> leZ;
    public PersonMoreData ler;
    private PersonUserGodInfo lfa;
    private d lfb;
    public com.baidu.tieba.person.data.d lfc;
    public h lfd;
    public h lfe;
    public h lff;
    public h lfg;
    public i lfh;
    public n lfi;
    public k lfj;
    private com.baidu.tieba.i.b mLiveGoodsWindowData;
    private UserData mUserData;
    private int[] lfk = {R.string.my_threads, R.string.god_examination, R.string.create_college, R.string.hot_activities};
    private int[] lfl = {R.drawable.icon_mask_wo_tiezi48, R.drawable.icon_mask_wo_dashen48, R.drawable.icon_mask_wo_xueyuan48, R.drawable.icon_mask_wo_hot48};
    private int[] lfm = {1, 2, 3, 4};
    private ArrayList<q> geA = new ArrayList<>();

    public ArrayList<q> dgE() {
        return this.geA;
    }

    private void dgF() {
        if (this.lfb != null) {
            this.geA.add(this.lfb);
        } else if (this.mUserData != null) {
            this.lfb = new d();
            this.lfb.leS = this.mUserData.getFansNum();
            this.lfb.leT = this.mUserData.getConcern_num();
            this.lfb.leU = this.mUserData.getLike_bars();
            this.lfb.threadNum = this.mUserData.getThreadNum();
            this.lfb.userData = this.mUserData;
            this.geA.add(this.lfb);
        }
    }

    private void dgG() {
        if (this.lfi != null) {
            this.geA.add(this.lfi);
            return;
        }
        this.lfi = new n();
        if (!y.isEmpty(this.leZ)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.leZ.size()) {
                    break;
                }
                a aVar = new a();
                aVar.a(this.leZ.get(i2));
                if (!at.isEmpty(aVar.bcB())) {
                    this.lfi.leZ.add(aVar);
                }
                i = i2 + 1;
            }
            if (this.lfi.leZ.size() > 0) {
                this.geA.add(this.lfi);
            }
        }
    }

    private void dgH() {
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("key_create_center_entrance_switch", 0) != 0) {
            g gVar = new g();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 4; i++) {
                g.a aVar = new g.a();
                aVar.lfo = this.lfl[i];
                if (i == 1) {
                    if (this.mUserData != null && this.mUserData.isNewGod()) {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_examination);
                        aVar.type = 5;
                    } else {
                        aVar.text = TbadkCoreApplication.getInst().getString(R.string.god_authentication);
                        aVar.type = 2;
                    }
                } else {
                    aVar.text = TbadkCoreApplication.getInst().getString(this.lfk[i]);
                    aVar.type = this.lfm[i];
                }
                arrayList.add(aVar);
            }
            gVar.eJ(arrayList);
            gVar.mUserData = this.mUserData;
            this.geA.add(gVar);
        }
    }

    private void eH(List<SmartApp> list) {
        if (!y.isEmpty(list)) {
            if (this.lfj == null) {
                this.lfj = new k();
                this.geA.add(this.lfj);
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (SmartApp smartApp : list) {
                    if (smartApp != null) {
                        arrayList.add(new m(smartApp));
                    }
                }
            }
            this.lfj.setData(arrayList);
        }
    }

    private void dgI() {
        if (this.lfd == null) {
            this.lfd = V(R.drawable.icon_mask_wo_list_collect24_svg, R.string.my_mark, 16);
            this.lfd.lfq = true;
            this.lfd.lft = new j();
        }
        this.geA.add(this.lfd);
        h V = V(R.drawable.icon_mask_wo_list_history24_svg, R.string.my_history, 17);
        V.lfq = true;
        V.lfs = true;
        this.geA.add(V);
        h V2 = V(R.drawable.icon_mask_wo_list_group24_svg, R.string.my_groups, 22);
        V2.lfs = true;
        V2.lfq = true;
        if (this.mLiveGoodsWindowData != null && this.mLiveGoodsWindowData.cvF() && !TextUtils.isEmpty(this.mLiveGoodsWindowData.goods_url)) {
            h V3 = V(R.drawable.icon_mask_wo_list_shop24_svg, R.string.person_my_store_title, 46);
            V3.lfq = true;
            V3.aDi = this.mLiveGoodsWindowData.goods_url;
            this.geA.add(V3);
        }
        h V4 = V(R.drawable.icon_mask_wo_list_youqianhua24_svg, R.string.borrow_cash, 37);
        V4.lfq = true;
        V4.lft = new j();
        if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean(SharedPrefConfig.KEY_HAS_BORROW_CASH_CLICKED, false)) {
            V4.lft.isShowRedTip = true;
        }
        V4.lft.lfB = true;
        this.geA.add(V4);
        if (TbSingleton.getInstance().isShowPersonCenterLiteGame()) {
            h V5 = V(R.drawable.icon_mask_wo_list_game24_svg, R.string.lite_game_center, 44);
            V5.lfq = true;
            V5.aDi = "tiebaclient://swan/T43rINkXjgPfdKNXTuhQER2KdACVdB00/pages/index/index?_baiduboxapp=%7B%22from%22%3A%223000000000000000%22%2C%22ext%22%3A%7B%7D%7D";
            this.geA.add(V5);
        }
        if (com.baidu.tbadk.core.sharedPref.b.bik().getInt("baidu_financial_display", 1) == 1) {
            h V6 = V(R.drawable.icon_mask_wo_list_duxiaoman24_svg, R.string.baidu_financial, 41);
            V6.lfq = true;
            if (!com.baidu.tbadk.core.sharedPref.b.bik().getBoolean("key_baidu_financial_has_clicked", false)) {
                V6.lft = new j();
                V6.lft.isShowRedTip = true;
            }
            this.geA.add(V6);
        }
        if (this.leY != null && this.leY.is_end.intValue() != 1) {
            h V7 = V(R.drawable.icon_mask_wo_list_sign24_svg, R.string.person_center_sign_packet, 45);
            V7.lfq = true;
            V7.aDi = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
            int intValue = this.leY.total_cash.intValue();
            if (intValue > 0) {
                j jVar = new j();
                jVar.text = TbadkCoreApplication.getInst().getString(R.string.sign_cash_num, new Object[]{String.format("%.2f", Double.valueOf(intValue / 100.0d))});
                jVar.linkUrl = "https://tieba.baidu.com/mo/q/duxiaoman/index?noshare=1";
                V7.lft = jVar;
            }
            this.geA.add(V7);
        }
        h V8 = V(R.drawable.icon_mask_wo_list_task24_svg, R.string.person_task_center_entrance, 43);
        V8.lfq = true;
        this.geA.add(V8);
        h V9 = V(R.drawable.icon_mask_wo_list_member24_svg, R.string.member_center, 12);
        V9.lfq = true;
        this.geA.add(V9);
        this.lfe = V(R.drawable.icon_mask_wo_list_gift24_svg, R.string.my_gift, 10);
        this.lfe.lft = new j();
        this.lfe.lfq = true;
        this.lfe.lft.text = at.formatNumForTdouDisPlay(this.mUserData.getTDouNum());
        this.lfe.lft.lfy = TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon_huobi_tdou);
        this.geA.add(this.lfe);
        h V10 = V(R.drawable.icon_mask_wo_list_cardbag24_svg, R.string.card_box, 18);
        V10.lfq = true;
        this.geA.add(V10);
        h V11 = V(R.drawable.icon_mask_wo_list_diamond24_svg, R.string.blue_diamond, 11);
        V11.lfq = true;
        if (this.mUserData.membershipInfo != null) {
            V11.aDi = this.mUserData.membershipInfo.mLink;
        }
        this.geA.add(V11);
        boolean isPersonItemSwitch = TbadkCoreApplication.getInst().getActivityPrizeData().isPersonItemSwitch();
        String personItemText = TbadkCoreApplication.getInst().getActivityPrizeData().getPersonItemText();
        if (isPersonItemSwitch && !StringUtils.isNull(personItemText)) {
            this.lff = f(R.drawable.icon_mine_list_logingift, personItemText, 38);
            this.lff.lfs = true;
            this.lff.lft = new j();
            this.geA.add(this.lff);
            TiebaStatic.log(new aq("c12597"));
        } else {
            V11.lfs = true;
        }
        h V12 = V(R.drawable.icon_mask_wo_list_topic24_svg, R.string.hot_topic, 30);
        V12.lfq = true;
        this.geA.add(V12);
        if (MessageManager.getInstance().findTask(2921431) != null) {
            h V13 = V(R.drawable.icon_mask_wo_list_live24_svg, R.string.ala_live, 25);
            V13.lfq = true;
            V13.lfs = true;
            this.geA.add(V13);
        }
        this.lfg = V(R.drawable.icon_mask_wo_list_serve24_svg, R.string.person_service_centre, 31);
        this.lfg.lfs = true;
        this.lfg.lfq = true;
        this.geA.add(this.lfg);
        h V14 = V(R.drawable.icon_mask_wo_list_exempt24_svg, R.string.baidu_singkil, 39);
        V14.lfq = true;
        this.geA.add(V14);
        if (this.ler == null) {
            this.ler = new PersonMoreData();
        }
        h V15 = V(R.drawable.icon_pure_wo_list_more24_svg, R.string.person_center_more, 33);
        V15.lfq = true;
        V15.lfr = true;
        V15.lfu = OrmObject.bundleWithObject(this.ler);
        V15.lft = new j();
        List<PersonMoreItemData> list = this.ler.mUrlMaps;
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
                V15.lft.lfx = getString(R.string.person_center_more_desc, sb.toString());
            }
        }
        this.geA.add(V15);
    }

    private String getString(@StringRes int i, Object... objArr) {
        return TbadkCoreApplication.getInst().getString(i, objArr);
    }

    private h V(int i, int i2, int i3) {
        h hVar = new h();
        hVar.lfp = i;
        hVar.title = TbadkCoreApplication.getInst().getString(i2);
        hVar.type = i3;
        if (this.mUserData != null) {
            hVar.userData = this.mUserData;
        }
        return hVar;
    }

    private h f(int i, String str, int i2) {
        h hVar = new h();
        hVar.lfp = i;
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

    public void uw(boolean z) {
        if (this.lfd != null) {
            if (this.lfd.lft == null) {
                this.lfd.lft = new j();
            }
            this.lfd.lft.isShowRedTip = z;
        }
    }

    public void ux(boolean z) {
        if (this.lfg != null) {
            if (this.lfg.lft == null) {
                this.lfg.lft = new j();
            }
            this.lfg.lft.isShowRedTip = z;
        }
    }

    public void uy(boolean z) {
        if (this.lff != null) {
            if (this.lff.lft == null) {
                this.lff.lft = new j();
            }
            this.lff.lft.isShowRedTip = z;
        }
    }

    public void uz(boolean z) {
        if (this.lfb != null) {
            this.lfb.leV = z;
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(ProfileResIdl profileResIdl) {
        if (profileResIdl != null && profileResIdl.data != null) {
            this.lfh = new i();
            this.leZ = profileResIdl.data.banner;
            this.leY = profileResIdl.data.duxiaoman;
            a(profileResIdl.data.user, profileResIdl.data.user_god_info);
            b(profileResIdl.data.tbbookrack);
            b(profileResIdl.data.uc_card);
            eI(profileResIdl.data.url_map);
            this.geA.add(this.lfh);
            dgF();
            dgH();
            eH(profileResIdl.data.recom_swan_list);
            dgG();
            dgI();
            com.baidu.tieba.p.a.doT().vy(true);
        }
    }

    @Override // com.baidu.tieba.person.b
    public void a(PersonalResIdl personalResIdl) {
        if (personalResIdl != null && personalResIdl.data != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(personalResIdl.data.user);
            this.lfh = new i();
            this.lfh.userData = this.mUserData;
            this.geA.add(this.lfh);
            dgF();
            dgI();
            com.baidu.tieba.p.a.doT().vy(true);
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
        if (this.lfa == null && userGodInfo != null) {
            this.lfa = new PersonUserGodInfo();
        }
        if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
            this.mUserData.setIsBigV(true);
            this.lfa.parserProtobuf(userGodInfo);
        }
        this.lfh.userData = this.mUserData;
    }

    private void b(TbBookrack tbBookrack) {
        if (tbBookrack != null) {
            com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
            aVar.a(tbBookrack);
            this.lfc = new com.baidu.tieba.person.data.d(true, aVar);
        }
    }

    private void b(UcCard ucCard) {
        new com.baidu.tieba.person.g().a(ucCard);
    }

    private void eI(List<UserMap> list) {
        if (!y.isEmpty(list)) {
            this.ler = new PersonMoreData();
            for (UserMap userMap : list) {
                if (userMap != null && !StringUtils.isNull(userMap.name) && !StringUtils.isNull(userMap.url)) {
                    String replaceAll = userMap.url.replaceAll("amp;", "");
                    PersonMoreItemData personMoreItemData = new PersonMoreItemData();
                    personMoreItemData.mId = userMap.id.intValue();
                    personMoreItemData.mName = userMap.name;
                    personMoreItemData.mUrl = replaceAll;
                    this.ler.mUrlMaps.add(personMoreItemData);
                }
            }
        }
    }
}
