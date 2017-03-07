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
    private ArrayList<v> eCI = new ArrayList<>();
    private PersonUserGodInfo eCJ;
    private UserVideoChannelInfoData eCK;
    private f eCL;
    private com.baidu.tieba.person.data.b eCM;
    private com.baidu.tieba.person.data.c eCN;
    public c eCO;
    public c eCP;
    public c eCQ;
    public c eCR;
    public c eCS;
    private Feedback eCT;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.b bVar) {
        if (bVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(bVar.GetUser());
            if (this.eCJ == null) {
                this.eCJ = new PersonUserGodInfo();
            }
            if (bVar.getUserGodInfo() != null && bVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eCJ.parserProtobuf(bVar.getUserGodInfo());
            }
            if (this.eCK == null) {
                this.eCK = new UserVideoChannelInfoData();
            }
            if (bVar.getUserChannelInfo() != null) {
                this.eCK.parserProtobuf(bVar.getUserChannelInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.Ed().a(this.mUserData);
                }
            }
            this.eCL = bVar.getUcCardData();
            if (bVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(bVar.getBookrackData());
                this.eCM = new com.baidu.tieba.person.data.b(true, aVar);
            }
            this.eCT = bVar.getFeedBack();
        }
    }

    private void aQi() {
        c nT;
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eCO = L(w.g.icon_mine_gift, w.l.gift_received_by_me, 10);
        if (!x.q(this.mUserData.getGift())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 3 && i < this.mUserData.getGift().size(); i++) {
                arrayList.add(this.mUserData.getGift().get(i).getGiftIcon());
            }
            this.eCO.bHf = new Bundle();
            this.eCO.bHf.putSerializable("person_center_item_pic", arrayList);
            this.eCO.bHf.putBoolean("person_center_item_red_tip", true);
        }
        this.eCO.eCX.bHf = new Bundle();
        this.eCO.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(this.eCO);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            c L = L(w.g.icon_mine_live, w.l.person_center_ala_live, 25);
            L.bHf = new Bundle();
            L.eCX.bHf = new Bundle();
            L.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eCI.add(L);
        }
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        c L2 = L(w.g.icon_mine_store_bluedrill, w.l.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            L2.bHf = new Bundle();
            L2.bHf.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        L2.eCX.bHf = new Bundle();
        L2.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(L2);
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        this.eCS = L(w.g.icon_mine_associator, w.l.member_center, 12);
        this.eCS.bHf = new Bundle();
        this.eCS.bHf.putBoolean("person_center_item_red_tip", true);
        this.eCS.eCX.bHf = new Bundle();
        this.eCS.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(this.eCS);
        if (this.eCN != null && (nT = this.eCN.nT(TbadkCoreApplication.m9getInst().getString(w.l.consumption_records))) != null) {
            this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            nT.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eCI.add(nT);
        }
        this.eCQ = L(w.g.icon_mine_collect, w.l.my_mark, 16);
        this.eCQ.bHf = new Bundle();
        this.eCQ.bHf.putBoolean("person_center_item_red_tip", true);
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eCQ.eCX.bHf = new Bundle();
        this.eCQ.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(this.eCQ);
        c L3 = L(w.g.icon_mine_history, w.l.my_history, 17);
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L3.eCX.bHf = new Bundle();
        L3.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(L3);
        if (this.mUserData != null && this.mUserData.isShowDriftingBottle() && e.eT().ab("android_bottle_enable") == 1 && TbadkCoreApplication.m9getInst().appResponseToIntentClass(BigImgPbActivityConfig.class)) {
            TiebaStatic.log(new as("c11947"));
            c L4 = L(w.g.icon_mine_bottle, w.l.person_center_drifting_bottle, 23);
            this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            L4.eCX.bHf = new Bundle();
            L4.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eCI.add(L4);
        }
        c L5 = L(w.g.icon_mine_anchor, w.l.misson_title, 18);
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L5.eCX.bHf = new Bundle();
        L5.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(L5);
        if (this.eCK != null) {
            TiebaStatic.log(new as("c11956"));
            boolean z = this.eCK.getManChannel() == 1;
            if (z) {
                this.eCP = L(w.g.icon_mine_channel, w.l.person_center_my_channel, 26);
                this.eCP.bHf = new Bundle();
                this.eCP.bHf.putBoolean("person_center_item_red_tip", true);
                this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                this.eCP.eCX.bHf = new Bundle();
                this.eCP.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eCI.add(this.eCP);
            }
            if (this.eCK.getFollowChannel() == 1) {
                TiebaStatic.log(new as("c11957"));
                c L6 = L(w.g.icon_mine_concern, w.l.person_center_subscribe_channel, 27);
                if (z) {
                    this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
                } else {
                    this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
                }
                L6.eCX.bHf = new Bundle();
                L6.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eCI.add(L6);
            }
        }
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eCI.add(this.eCM);
        this.eCR = L(w.g.icon_mine_friend, w.l.my_good_friends, 20);
        this.eCR.bHf = new Bundle();
        this.eCR.bHf.putBoolean("person_center_item_red_tip", true);
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
        this.eCR.eCX.bHf = new Bundle();
        this.eCR.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(this.eCR);
        c L7 = L(w.g.icon_mine_group, w.l.my_groups, 21);
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        L7.eCX.bHf = new Bundle();
        L7.eCX.bHf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eCI.add(L7);
        if (this.eCT != null && !StringUtils.isNull(this.eCT.url) && !StringUtils.isNull(this.eCT.title)) {
            c L8 = L(w.g.icon_personalcenter_feedback, w.l.person_center_feedback, 24);
            L8.title = UtilHelper.getFixedBarText(this.eCT.title, 6, true);
            L8.eCX.bHf = new Bundle();
            L8.eCX.bHf.putString("person_center_item_click_url", this.eCT.url);
            this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
            this.eCI.add(L8);
        }
        this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds220), w.e.cp_bg_line_c));
    }

    public void aQj() {
        if (this.eCL != null && !x.q(this.eCL.eBo)) {
            this.eCI.add(bg(k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_c));
            this.eCN = new com.baidu.tieba.person.data.c();
            this.eCN.setName(this.eCL.name);
            this.eCN.nS(this.eCL.eBn);
            this.eCN.setIcon(this.eCL.icon);
            this.eCN.nR(this.eCL.eBm);
            this.eCN.cf(this.eCL.eBo);
            this.eCI.add(this.eCN);
        }
        aQi();
    }

    private c L(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        cVar.eCX = new com.baidu.tieba.personCenter.d.a();
        cVar.eCX.bHe = i3;
        return cVar;
    }

    private b bg(int i, int i2) {
        b bVar = new b();
        bVar.eya = i;
        bVar.eCV = i2;
        return bVar;
    }

    public ArrayList<v> alZ() {
        return this.eCI;
    }

    public UserData aQk() {
        return this.mUserData;
    }
}
