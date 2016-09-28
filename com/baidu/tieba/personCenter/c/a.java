package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.person.g;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    public c eFA;
    private ArrayList<v> eFt = new ArrayList<>();
    private PersonUserGodInfo eFu;
    private g eFv;
    private com.baidu.tieba.person.data.b eFw;
    private com.baidu.tieba.person.data.c eFx;
    public c eFy;
    public c eFz;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.c cVar) {
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (this.eFu == null) {
                this.eFu = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && cVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.isGodUser = true;
                this.eFu.parserProtobuf(cVar.getUserGodInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.Ec().a(this.mUserData);
                }
            }
            this.eFv = cVar.getUcCardData();
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(cVar.getBookrackData());
                this.eFw = new com.baidu.tieba.person.data.b(true, aVar);
            }
        }
    }

    private void aSO() {
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eFy = M(r.f.icon_mine_gift, r.j.gift_received_by_me, 10);
        if (!y.t(this.mUserData.getGift())) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < 3 && i2 < this.mUserData.getGift().size()) {
                    arrayList.add(this.mUserData.getGift().get(i2).getGiftIcon());
                    i = i2 + 1;
                }
            }
            this.eFy.bJr = new Bundle();
            this.eFy.bJr.putSerializable("person_center_item_pic", arrayList);
            this.eFy.bJr.putBoolean("person_center_item_red_tip", true);
        }
        this.eFy.eFE.bJr = new Bundle();
        this.eFy.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(this.eFy);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        c M = M(r.f.icon_mine_store_bluedrill, r.j.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            M.bJr = new Bundle();
            M.bJr.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        M.eFE.bJr = new Bundle();
        M.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(M);
        if (this.eFx != null) {
            c oT = this.eFx.oT(r.j.person_center_buy_record);
            if (oT != null) {
                this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
                oT.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eFt.add(oT);
            }
            if (this.mUserData.isSeller()) {
                c oT2 = this.eFx.oT(r.j.ecomm_my_shop);
                if (oT2 != null) {
                    this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
                    oT2.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
                    this.eFt.add(oT2);
                }
            } else {
                c oT3 = this.eFx.oT(r.j.person_center_my_order);
                if (oT3 != null) {
                    this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
                    oT3.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
                    this.eFt.add(oT3);
                }
            }
        }
        this.eFz = M(r.f.icon_mine_collect, r.j.person_center_collect, 15);
        this.eFz.bJr = new Bundle();
        this.eFz.bJr.putBoolean("person_center_item_red_tip", true);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eFz.eFE.bJr = new Bundle();
        this.eFz.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(this.eFz);
        c M2 = M(r.f.icon_mine_history, r.j.person_center_history, 16);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        M2.eFE.bJr = new Bundle();
        M2.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(M2);
        c M3 = M(r.f.icon_mine_anchor, r.j.host_mission, 17);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        M3.eFE.bJr = new Bundle();
        M3.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(M3);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eFt.add(this.eFw);
        this.eFA = M(r.f.icon_mine_friend, r.j.person_center_friend, 19);
        this.eFA.bJr = new Bundle();
        this.eFA.bJr.putBoolean("person_center_item_red_tip", true);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eFA.eFE.bJr = new Bundle();
        this.eFA.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(this.eFA);
        c M4 = M(r.f.icon_mine_group, r.j.person_center_group, 20);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        M4.eFE.bJr = new Bundle();
        M4.eFE.bJr.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eFt.add(M4);
        this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds220), r.d.cp_bg_line_c));
    }

    public void aSP() {
        if (this.eFv != null && !y.t(this.eFv.eDE)) {
            this.eFt.add(bl(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
            this.eFx = new com.baidu.tieba.person.data.c();
            this.eFx.setName(this.eFv.name);
            this.eFx.pE(this.eFv.eDD);
            this.eFx.setIcon(this.eFv.icon);
            this.eFx.pD(this.eFv.eDC);
            this.eFx.cz(this.eFv.eDE);
            this.eFt.add(this.eFx);
        }
        aSO();
    }

    private c M(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.eFF = i2;
        cVar.eFE = new com.baidu.tieba.personCenter.d.a();
        cVar.eFE.bJq = i3;
        return cVar;
    }

    private b bl(int i, int i2) {
        b bVar = new b();
        bVar.eAj = i;
        bVar.eFC = i2;
        return bVar;
    }

    public ArrayList<v> aph() {
        return this.eFt;
    }

    public UserData aSQ() {
        return this.mUserData;
    }
}
