package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.lib.b.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.BigImgPbActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.person.f;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import tbclient.Feedback;
/* loaded from: classes.dex */
public class a {
    private ArrayList<v> eCV = new ArrayList<>();
    private PersonUserGodInfo eCW;
    private UserVideoChannelInfoData eCX;
    private f eCY;
    private com.baidu.tieba.person.data.b eCZ;
    private com.baidu.tieba.person.data.c eDa;
    public c eDb;
    public c eDc;
    public c eDd;
    public c eDe;
    public c eDf;
    private Feedback eDg;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.b bVar) {
        if (bVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(bVar.GetUser());
            if (this.eCW == null) {
                this.eCW = new PersonUserGodInfo();
            }
            if (bVar.getUserGodInfo() != null && bVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eCW.parserProtobuf(bVar.getUserGodInfo());
            }
            if (this.eCX == null) {
                this.eCX = new UserVideoChannelInfoData();
            }
            if (bVar.getUserChannelInfo() != null) {
                this.eCX.parserProtobuf(bVar.getUserChannelInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.EB().a(this.mUserData);
                }
            }
            this.eCY = bVar.getUcCardData();
            if (bVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(bVar.getBookrackData());
                this.eCZ = new com.baidu.tieba.person.data.b(true, aVar);
            }
            this.eDg = bVar.getFeedBack();
        }
    }

    private void aRs() {
        c nY;
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eDb = L(w.g.icon_mine_gift, w.l.gift_received_by_me, 10);
        if (!x.q(this.mUserData.getGift())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 3 && i < this.mUserData.getGift().size(); i++) {
                arrayList.add(this.mUserData.getGift().get(i).getGiftIcon());
            }
            this.eDb.bJp = new Bundle();
            this.eDb.bJp.putSerializable("person_center_item_pic", arrayList);
            this.eDb.bJp.putBoolean("person_center_item_red_tip", true);
        }
        this.eDb.eDk.bJp = new Bundle();
        this.eDb.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(this.eDb);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            c L = L(w.g.icon_mine_live, w.l.person_center_ala_live, 26);
            L.bJp = new Bundle();
            L.eDk.bJp = new Bundle();
            L.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eCV.add(L);
        }
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        c L2 = L(w.g.icon_mine_store_bluedrill, w.l.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            L2.bJp = new Bundle();
            L2.bJp.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        L2.eDk.bJp = new Bundle();
        L2.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(L2);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        this.eDf = L(w.g.icon_mine_associator, w.l.member_center, 12);
        this.eDf.bJp = new Bundle();
        this.eDf.bJp.putBoolean("person_center_item_red_tip", true);
        this.eDf.eDk.bJp = new Bundle();
        this.eDf.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(this.eDf);
        if (this.eDa != null && (nY = this.eDa.nY(TbadkCoreApplication.m9getInst().getString(w.l.consumption_records))) != null) {
            this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            nY.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eCV.add(nY);
        }
        this.eDd = L(w.g.icon_mine_collect, w.l.my_mark, 16);
        this.eDd.bJp = new Bundle();
        this.eDd.bJp.putBoolean("person_center_item_red_tip", true);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eDd.eDk.bJp = new Bundle();
        this.eDd.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(this.eDd);
        c L3 = L(w.g.icon_mine_history, w.l.my_history, 17);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L3.eDk.bJp = new Bundle();
        L3.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(L3);
        c L4 = L(w.g.icon_mine_card, w.l.my_card_box, 18);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L3.eDk.bJp = new Bundle();
        L3.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(L4);
        if (this.mUserData != null && this.mUserData.isShowDriftingBottle() && e.eZ().Y("android_bottle_enable") == 1 && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BigImgPbActivityConfig.class)) {
            TiebaStatic.log(new as("c11947"));
            c L5 = L(w.g.icon_mine_bottle, w.l.person_center_drifting_bottle, 24);
            this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            L5.eDk.bJp = new Bundle();
            L5.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eCV.add(L5);
        }
        c L6 = L(w.g.icon_mine_anchor, w.l.misson_title, 19);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L6.eDk.bJp = new Bundle();
        L6.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(L6);
        if (this.eCX != null) {
            TiebaStatic.log(new as("c11956"));
            boolean z = this.eCX.getManChannel() == 1;
            if (z) {
                this.eDc = L(w.g.icon_mine_channel, w.l.person_center_my_channel, 27);
                this.eDc.bJp = new Bundle();
                this.eDc.bJp.putBoolean("person_center_item_red_tip", true);
                this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                this.eDc.eDk.bJp = new Bundle();
                this.eDc.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eCV.add(this.eDc);
            }
            if (this.eCX.getFollowChannel() == 1) {
                TiebaStatic.log(new as("c11957"));
                c L7 = L(w.g.icon_mine_concern, w.l.person_center_subscribe_channel, 28);
                if (z) {
                    this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
                } else {
                    this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                }
                L7.eDk.bJp = new Bundle();
                L7.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eCV.add(L7);
            }
        }
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eCV.add(this.eCZ);
        this.eDe = L(w.g.icon_mine_friend, w.l.my_good_friends, 21);
        this.eDe.bJp = new Bundle();
        this.eDe.bJp.putBoolean("person_center_item_red_tip", true);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eDe.eDk.bJp = new Bundle();
        this.eDe.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(this.eDe);
        c L8 = L(w.g.icon_mine_group, w.l.my_groups, 22);
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L8.eDk.bJp = new Bundle();
        L8.eDk.bJp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCV.add(L8);
        if (this.eDg != null && !StringUtils.isNull(this.eDg.url) && !StringUtils.isNull(this.eDg.title)) {
            c L9 = L(w.g.icon_personalcenter_feedback, w.l.person_center_feedback, 25);
            L9.title = UtilHelper.getFixedBarText(this.eDg.title, 6, true);
            L9.eDk.bJp = new Bundle();
            L9.eDk.bJp.putString("person_center_item_click_url", this.eDg.url);
            this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
            this.eCV.add(L9);
        }
        this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds220), w.e.cp_bg_line_c));
    }

    public void aRt() {
        if (this.eCY != null && !x.q(this.eCY.eBK)) {
            this.eCV.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
            this.eDa = new com.baidu.tieba.person.data.c();
            this.eDa.setName(this.eCY.name);
            this.eDa.nX(this.eCY.eBJ);
            this.eDa.setIcon(this.eCY.icon);
            this.eDa.nW(this.eCY.eBI);
            this.eDa.cf(this.eCY.eBK);
            this.eCV.add(this.eDa);
        }
        aRs();
    }

    private c L(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        cVar.eDk = new com.baidu.tieba.personCenter.d.a();
        cVar.eDk.bJo = i3;
        return cVar;
    }

    private b ba(int i, int i2) {
        b bVar = new b();
        bVar.eyx = i;
        bVar.eDi = i2;
        return bVar;
    }

    public ArrayList<v> amU() {
        return this.eCV;
    }

    public UserData aRu() {
        return this.mUserData;
    }
}
