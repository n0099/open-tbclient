package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.lib.b.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.person.f;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import tbclient.Feedback;
/* loaded from: classes.dex */
public class a {
    private ArrayList<v> ezj = new ArrayList<>();
    private PersonUserGodInfo ezk;
    private UserVideoChannelInfoData ezl;
    private f ezm;
    private com.baidu.tieba.person.data.b ezn;
    private com.baidu.tieba.person.data.c ezo;
    public c ezp;
    public c ezq;
    public c ezr;
    public c ezs;
    public c ezt;
    private Feedback ezu;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.b bVar) {
        if (bVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(bVar.GetUser());
            if (this.ezk == null) {
                this.ezk = new PersonUserGodInfo();
            }
            if (bVar.getUserGodInfo() != null && bVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.ezk.parserProtobuf(bVar.getUserGodInfo());
            }
            if (this.ezl == null) {
                this.ezl = new UserVideoChannelInfoData();
            }
            if (bVar.getUserChannelInfo() != null) {
                this.ezl.parserProtobuf(bVar.getUserChannelInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.DK().a(this.mUserData);
                }
            }
            this.ezm = bVar.getUcCardData();
            if (bVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(bVar.getBookrackData());
                this.ezn = new com.baidu.tieba.person.data.b(true, aVar);
            }
            this.ezu = bVar.getFeedBack();
        }
    }

    private void aQF() {
        c oL;
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
        this.ezp = M(r.g.icon_mine_gift, r.l.gift_received_by_me, 10);
        if (!w.s(this.mUserData.getGift())) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < 3 && i < this.mUserData.getGift().size(); i++) {
                arrayList.add(this.mUserData.getGift().get(i).getGiftIcon());
            }
            this.ezp.bzZ = new Bundle();
            this.ezp.bzZ.putSerializable("person_center_item_pic", arrayList);
            this.ezp.bzZ.putBoolean("person_center_item_red_tip", true);
        }
        this.ezp.ezy.bzZ = new Bundle();
        this.ezp.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(this.ezp);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
            c M = M(r.g.icon_mine_live, r.l.person_center_ala_live, 25);
            M.bzZ = new Bundle();
            M.ezy.bzZ = new Bundle();
            M.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ezj.add(M);
        }
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        c M2 = M(r.g.icon_mine_store_bluedrill, r.l.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            M2.bzZ = new Bundle();
            M2.bzZ.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        M2.ezy.bzZ = new Bundle();
        M2.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(M2);
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        this.ezt = M(r.g.icon_mine_associator, r.l.member_center, 12);
        this.ezt.bzZ = new Bundle();
        this.ezt.bzZ.putBoolean("person_center_item_red_tip", true);
        this.ezt.ezy.bzZ = new Bundle();
        this.ezt.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(this.ezt);
        if (this.ezo != null && (oL = this.ezo.oL(TbadkCoreApplication.m9getInst().getString(r.l.consumption_records))) != null) {
            this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
            oL.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ezj.add(oL);
        }
        this.ezr = M(r.g.icon_mine_collect, r.l.my_mark, 16);
        this.ezr.bzZ = new Bundle();
        this.ezr.bzZ.putBoolean("person_center_item_red_tip", true);
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
        this.ezr.ezy.bzZ = new Bundle();
        this.ezr.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(this.ezr);
        c M3 = M(r.g.icon_mine_history, r.l.my_history, 17);
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        M3.ezy.bzZ = new Bundle();
        M3.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(M3);
        if (this.mUserData != null && this.mUserData.isShowDriftingBottle() && e.dL().ac("android_bottle_enable") == 1) {
            TiebaStatic.log(new ar("c11947"));
            c M4 = M(r.g.icon_mine_bottle, r.l.person_center_drifting_bottle, 23);
            this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
            M4.ezy.bzZ = new Bundle();
            M4.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ezj.add(M4);
        }
        c M5 = M(r.g.icon_mine_anchor, r.l.misson_title, 18);
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        M5.ezy.bzZ = new Bundle();
        M5.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(M5);
        if (this.ezl != null) {
            TiebaStatic.log(new ar("c11956"));
            boolean z = this.ezl.getManChannel() == 1;
            if (z) {
                this.ezq = M(r.g.icon_mine_channel, r.l.person_center_my_channel, 26);
                this.ezq.bzZ = new Bundle();
                this.ezq.bzZ.putBoolean("person_center_item_red_tip", true);
                this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
                this.ezq.ezy.bzZ = new Bundle();
                this.ezq.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.ezj.add(this.ezq);
            }
            if (this.ezl.getFollowChannel() == 1) {
                TiebaStatic.log(new ar("c11957"));
                c M6 = M(r.g.icon_mine_concern, r.l.person_center_subscribe_channel, 27);
                if (z) {
                    this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
                } else {
                    this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
                }
                M6.ezy.bzZ = new Bundle();
                M6.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.ezj.add(M6);
            }
        }
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
        this.ezj.add(this.ezn);
        this.ezs = M(r.g.icon_mine_friend, r.l.my_good_friends, 20);
        this.ezs.bzZ = new Bundle();
        this.ezs.bzZ.putBoolean("person_center_item_red_tip", true);
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
        this.ezs.ezy.bzZ = new Bundle();
        this.ezs.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(this.ezs);
        c M7 = M(r.g.icon_mine_group, r.l.my_groups, 21);
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        M7.ezy.bzZ = new Bundle();
        M7.ezy.bzZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ezj.add(M7);
        if (this.ezu != null && !StringUtils.isNull(this.ezu.url) && !StringUtils.isNull(this.ezu.title)) {
            c M8 = M(r.g.icon_personalcenter_feedback, r.l.person_center_feedback, 24);
            M8.title = UtilHelper.getFixedBarText(this.ezu.title, 6, true);
            M8.ezy.bzZ = new Bundle();
            M8.ezy.bzZ.putString("person_center_item_click_url", this.ezu.url);
            this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
            this.ezj.add(M8);
        }
        this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds220), r.e.cp_bg_line_c));
    }

    public void aQG() {
        if (this.ezm != null && !w.s(this.ezm.exO)) {
            this.ezj.add(bc(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_c));
            this.ezo = new com.baidu.tieba.person.data.c();
            this.ezo.setName(this.ezm.name);
            this.ezo.oK(this.ezm.exN);
            this.ezo.setIcon(this.ezm.icon);
            this.ezo.oJ(this.ezm.exM);
            this.ezo.cy(this.ezm.exO);
            this.ezj.add(this.ezo);
        }
        aQF();
    }

    private c M(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        cVar.ezy = new com.baidu.tieba.personCenter.d.a();
        cVar.ezy.bzY = i3;
        return cVar;
    }

    private b bc(int i, int i2) {
        b bVar = new b();
        bVar.euD = i;
        bVar.ezw = i2;
        return bVar;
    }

    public ArrayList<v> amM() {
        return this.ezj;
    }

    public UserData aQH() {
        return this.mUserData;
    }
}
