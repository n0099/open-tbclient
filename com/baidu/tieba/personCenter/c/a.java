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
    private ArrayList<v> eAF = new ArrayList<>();
    private PersonUserGodInfo eAG;
    private UserVideoChannelInfoData eAH;
    private f eAI;
    private com.baidu.tieba.person.data.b eAJ;
    private com.baidu.tieba.person.data.c eAK;
    public c eAL;
    public c eAM;
    public c eAN;
    public c eAO;
    public c eAP;
    private Feedback eAQ;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.b bVar) {
        if (bVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(bVar.GetUser());
            if (this.eAG == null) {
                this.eAG = new PersonUserGodInfo();
            }
            if (bVar.getUserGodInfo() != null && bVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eAG.parserProtobuf(bVar.getUserGodInfo());
            }
            if (this.eAH == null) {
                this.eAH = new UserVideoChannelInfoData();
            }
            if (bVar.getUserChannelInfo() != null) {
                this.eAH.parserProtobuf(bVar.getUserChannelInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.EB().a(this.mUserData);
                }
            }
            this.eAI = bVar.getUcCardData();
            if (bVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(bVar.getBookrackData());
                this.eAJ = new com.baidu.tieba.person.data.b(true, aVar);
            }
            this.eAQ = bVar.getFeedBack();
        }
    }

    private void aQr() {
        c nX;
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eAL = L(w.g.icon_mine_gift, w.l.gift_received_by_me, 10);
        if (!x.q(this.mUserData.getGift())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 3 && i < this.mUserData.getGift().size(); i++) {
                arrayList.add(this.mUserData.getGift().get(i).getGiftIcon());
            }
            this.eAL.bGY = new Bundle();
            this.eAL.bGY.putSerializable("person_center_item_pic", arrayList);
            this.eAL.bGY.putBoolean("person_center_item_red_tip", true);
        }
        this.eAL.eAU.bGY = new Bundle();
        this.eAL.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(this.eAL);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            c L = L(w.g.icon_mine_live, w.l.person_center_ala_live, 26);
            L.bGY = new Bundle();
            L.eAU.bGY = new Bundle();
            L.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eAF.add(L);
        }
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        c L2 = L(w.g.icon_mine_store_bluedrill, w.l.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            L2.bGY = new Bundle();
            L2.bGY.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        L2.eAU.bGY = new Bundle();
        L2.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(L2);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        this.eAP = L(w.g.icon_mine_associator, w.l.member_center, 12);
        this.eAP.bGY = new Bundle();
        this.eAP.bGY.putBoolean("person_center_item_red_tip", true);
        this.eAP.eAU.bGY = new Bundle();
        this.eAP.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(this.eAP);
        if (this.eAK != null && (nX = this.eAK.nX(TbadkCoreApplication.m9getInst().getString(w.l.consumption_records))) != null) {
            this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            nX.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eAF.add(nX);
        }
        this.eAN = L(w.g.icon_mine_collect, w.l.my_mark, 16);
        this.eAN.bGY = new Bundle();
        this.eAN.bGY.putBoolean("person_center_item_red_tip", true);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eAN.eAU.bGY = new Bundle();
        this.eAN.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(this.eAN);
        c L3 = L(w.g.icon_mine_history, w.l.my_history, 17);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L3.eAU.bGY = new Bundle();
        L3.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(L3);
        c L4 = L(w.g.icon_mine_card, w.l.my_card_box, 18);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L3.eAU.bGY = new Bundle();
        L3.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(L4);
        if (this.mUserData != null && this.mUserData.isShowDriftingBottle() && e.eY().Y("android_bottle_enable") == 1 && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BigImgPbActivityConfig.class)) {
            TiebaStatic.log(new as("c11947"));
            c L5 = L(w.g.icon_mine_bottle, w.l.person_center_drifting_bottle, 24);
            this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            L5.eAU.bGY = new Bundle();
            L5.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eAF.add(L5);
        }
        c L6 = L(w.g.icon_mine_anchor, w.l.misson_title, 19);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L6.eAU.bGY = new Bundle();
        L6.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(L6);
        if (this.eAH != null) {
            TiebaStatic.log(new as("c11956"));
            boolean z = this.eAH.getManChannel() == 1;
            if (z) {
                this.eAM = L(w.g.icon_mine_channel, w.l.person_center_my_channel, 27);
                this.eAM.bGY = new Bundle();
                this.eAM.bGY.putBoolean("person_center_item_red_tip", true);
                this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                this.eAM.eAU.bGY = new Bundle();
                this.eAM.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eAF.add(this.eAM);
            }
            if (this.eAH.getFollowChannel() == 1) {
                TiebaStatic.log(new as("c11957"));
                c L7 = L(w.g.icon_mine_concern, w.l.person_center_subscribe_channel, 28);
                if (z) {
                    this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
                } else {
                    this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                }
                L7.eAU.bGY = new Bundle();
                L7.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eAF.add(L7);
            }
        }
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eAF.add(this.eAJ);
        this.eAO = L(w.g.icon_mine_friend, w.l.my_good_friends, 21);
        this.eAO.bGY = new Bundle();
        this.eAO.bGY.putBoolean("person_center_item_red_tip", true);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eAO.eAU.bGY = new Bundle();
        this.eAO.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(this.eAO);
        c L8 = L(w.g.icon_mine_group, w.l.my_groups, 22);
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L8.eAU.bGY = new Bundle();
        L8.eAU.bGY.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eAF.add(L8);
        if (this.eAQ != null && !StringUtils.isNull(this.eAQ.url) && !StringUtils.isNull(this.eAQ.title)) {
            c L9 = L(w.g.icon_personalcenter_feedback, w.l.person_center_feedback, 25);
            L9.title = UtilHelper.getFixedBarText(this.eAQ.title, 6, true);
            L9.eAU.bGY = new Bundle();
            L9.eAU.bGY.putString("person_center_item_click_url", this.eAQ.url);
            this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
            this.eAF.add(L9);
        }
        this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds220), w.e.cp_bg_line_c));
    }

    public void aQs() {
        if (this.eAI != null && !x.q(this.eAI.ezu)) {
            this.eAF.add(ba(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
            this.eAK = new com.baidu.tieba.person.data.c();
            this.eAK.setName(this.eAI.name);
            this.eAK.nW(this.eAI.ezt);
            this.eAK.setIcon(this.eAI.icon);
            this.eAK.nV(this.eAI.ezs);
            this.eAK.ce(this.eAI.ezu);
            this.eAF.add(this.eAK);
        }
        aQr();
    }

    private c L(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        cVar.eAU = new com.baidu.tieba.personCenter.d.a();
        cVar.eAU.bGX = i3;
        return cVar;
    }

    private b ba(int i, int i2) {
        b bVar = new b();
        bVar.ewf = i;
        bVar.eAS = i2;
        return bVar;
    }

    public ArrayList<v> alT() {
        return this.eAF;
    }

    public UserData aQt() {
        return this.mUserData;
    }
}
