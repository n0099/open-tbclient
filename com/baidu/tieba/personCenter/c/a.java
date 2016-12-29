package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.lib.c.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.person.f;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
import tbclient.Feedback;
/* loaded from: classes.dex */
public class a {
    private ArrayList<v> epo = new ArrayList<>();
    private PersonUserGodInfo epp;
    private f epq;
    private com.baidu.tieba.person.data.b epr;
    private com.baidu.tieba.person.data.c eps;
    public c ept;
    public c epu;
    public c epv;
    public c epw;
    private Feedback epx;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.b bVar) {
        if (bVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(bVar.GetUser());
            if (this.epp == null) {
                this.epp = new PersonUserGodInfo();
            }
            if (bVar.getUserGodInfo() != null && bVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.epp.parserProtobuf(bVar.getUserGodInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.DP().a(this.mUserData);
                }
            }
            this.epq = bVar.getUcCardData();
            if (bVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(bVar.getBookrackData());
                this.epr = new com.baidu.tieba.person.data.b(true, aVar);
            }
            this.epx = bVar.getFeedBack();
        }
    }

    private void aOF() {
        c ot;
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.ept = L(r.f.icon_mine_gift, r.j.gift_received_by_me, 10);
        if (!x.t(this.mUserData.getGift())) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 3 && i2 < this.mUserData.getGift().size()) {
                    arrayList.add(this.mUserData.getGift().get(i2).getGiftIcon());
                    i = i2 + 1;
                }
            }
            this.ept.bso = new Bundle();
            this.ept.bso.putSerializable("person_center_item_pic", arrayList);
            this.ept.bso.putBoolean("person_center_item_red_tip", true);
        }
        this.ept.epB.bso = new Bundle();
        this.ept.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(this.ept);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        c L = L(r.f.icon_mine_store_bluedrill, r.j.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            L.bso = new Bundle();
            L.bso.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        L.epB.bso = new Bundle();
        L.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(L);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        this.epw = L(r.f.icon_mine_associator, r.j.member_center, 12);
        this.epw.bso = new Bundle();
        this.epw.bso.putBoolean("person_center_item_red_tip", true);
        this.epw.epB.bso = new Bundle();
        this.epw.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(this.epw);
        if (this.eps != null && (ot = this.eps.ot(TbadkCoreApplication.m9getInst().getString(r.j.person_center_buy_record))) != null) {
            this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            ot.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.epo.add(ot);
        }
        this.epu = L(r.f.icon_mine_collect, r.j.person_center_collect, 16);
        this.epu.bso = new Bundle();
        this.epu.bso.putBoolean("person_center_item_red_tip", true);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.epu.epB.bso = new Bundle();
        this.epu.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(this.epu);
        c L2 = L(r.f.icon_mine_history, r.j.person_center_history, 17);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        L2.epB.bso = new Bundle();
        L2.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(L2);
        if (this.mUserData != null && this.mUserData.isShowDriftingBottle() && e.dN().ac("android_bottle_enable") == 1) {
            TiebaStatic.log(new at("c11947"));
            c L3 = L(r.f.icon_mine_bottle, r.j.person_center_drifting_bottle, 23);
            this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            L3.epB.bso = new Bundle();
            L3.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.epo.add(L3);
        }
        c L4 = L(r.f.icon_mine_anchor, r.j.misson_title, 18);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        L4.epB.bso = new Bundle();
        L4.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(L4);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.epo.add(this.epr);
        this.epv = L(r.f.icon_mine_friend, r.j.person_center_friend, 20);
        this.epv.bso = new Bundle();
        this.epv.bso.putBoolean("person_center_item_red_tip", true);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.epv.epB.bso = new Bundle();
        this.epv.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(this.epv);
        c L5 = L(r.f.icon_mine_group, r.j.person_center_group, 21);
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        L5.epB.bso = new Bundle();
        L5.epB.bso.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.epo.add(L5);
        if (this.epx != null && !StringUtils.isNull(this.epx.url) && !StringUtils.isNull(this.epx.title)) {
            c L6 = L(r.f.icon_personalcenter_feedback, r.j.person_center_feedback, 24);
            L6.title = UtilHelper.getFixedBarText(this.epx.title, 6, true);
            L6.epB.bso = new Bundle();
            L6.epB.bso.putString("person_center_item_click_url", this.epx.url);
            this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
            this.epo.add(L6);
        }
        this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds220), r.d.cp_bg_line_c));
    }

    public void aOG() {
        if (this.epq != null && !x.t(this.epq.enU)) {
            this.epo.add(bb(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
            this.eps = new com.baidu.tieba.person.data.c();
            this.eps.setName(this.epq.name);
            this.eps.os(this.epq.enT);
            this.eps.setIcon(this.epq.icon);
            this.eps.or(this.epq.enS);
            this.eps.ct(this.epq.enU);
            this.epo.add(this.eps);
        }
        aOF();
    }

    private c L(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        cVar.epB = new com.baidu.tieba.personCenter.d.a();
        cVar.epB.bsn = i3;
        return cVar;
    }

    private b bb(int i, int i2) {
        b bVar = new b();
        bVar.ekI = i;
        bVar.epz = i2;
        return bVar;
    }

    public ArrayList<v> alF() {
        return this.epo;
    }

    public UserData aOH() {
        return this.mUserData;
    }
}
