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
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<v> eDq = new ArrayList<>();
    private PersonUserGodInfo eDr;
    private g eDs;
    private com.baidu.tieba.person.data.b eDt;
    private com.baidu.tieba.person.data.c eDu;
    public c eDv;
    public c eDw;
    public c eDx;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.c cVar) {
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (this.eDr == null) {
                this.eDr = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && cVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.isGodUser = true;
                this.eDr.parserProtobuf(cVar.getUserGodInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.Ec().a(this.mUserData);
                }
            }
            this.eDs = cVar.getUcCardData();
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(cVar.getBookrackData());
                this.eDt = new com.baidu.tieba.person.data.b(true, aVar);
            }
        }
    }

    private void aSq() {
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_c));
        this.eDv = K(t.f.icon_mine_gift, t.j.gift_received_by_me, 10);
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
            this.eDv.bJq = new Bundle();
            this.eDv.bJq.putSerializable("person_center_item_pic", arrayList);
            this.eDv.bJq.putBoolean("person_center_item_red_tip", true);
        }
        this.eDv.eDB.bJq = new Bundle();
        this.eDv.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(this.eDv);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        c K = K(t.f.icon_mine_store_bluedrill, t.j.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            K.bJq = new Bundle();
            K.bJq.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        K.eDB.bJq = new Bundle();
        K.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(K);
        if (this.eDu != null) {
            c oJ = this.eDu.oJ(t.j.person_center_buy_record);
            if (oJ != null) {
                this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
                oJ.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eDq.add(oJ);
            }
            if (this.mUserData.isSeller()) {
                c oJ2 = this.eDu.oJ(t.j.ecomm_my_shop);
                if (oJ2 != null) {
                    this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
                    oJ2.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
                    this.eDq.add(oJ2);
                }
            } else {
                c oJ3 = this.eDu.oJ(t.j.person_center_my_order);
                if (oJ3 != null) {
                    this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
                    oJ3.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
                    this.eDq.add(oJ3);
                }
            }
        }
        this.eDw = K(t.f.icon_mine_collect, t.j.person_center_collect, 15);
        this.eDw.bJq = new Bundle();
        this.eDw.bJq.putBoolean("person_center_item_red_tip", true);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_c));
        this.eDw.eDB.bJq = new Bundle();
        this.eDw.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(this.eDw);
        c K2 = K(t.f.icon_mine_history, t.j.person_center_history, 16);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        K2.eDB.bJq = new Bundle();
        K2.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(K2);
        c K3 = K(t.f.icon_mine_anchor, t.j.host_mission, 17);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        K3.eDB.bJq = new Bundle();
        K3.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(K3);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_c));
        this.eDq.add(this.eDt);
        this.eDx = K(t.f.icon_mine_friend, t.j.person_center_friend, 19);
        this.eDx.bJq = new Bundle();
        this.eDx.bJq.putBoolean("person_center_item_red_tip", true);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_c));
        this.eDx.eDB.bJq = new Bundle();
        this.eDx.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(this.eDx);
        c K4 = K(t.f.icon_mine_group, t.j.person_center_group, 20);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        K4.eDB.bJq = new Bundle();
        K4.eDB.bJq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDq.add(K4);
        this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds220), t.d.cp_bg_line_c));
    }

    public void aSr() {
        if (this.eDs != null && !y.t(this.eDs.eBB)) {
            this.eDq.add(bj(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_c));
            this.eDu = new com.baidu.tieba.person.data.c();
            this.eDu.setName(this.eDs.name);
            this.eDu.ps(this.eDs.eBA);
            this.eDu.setIcon(this.eDs.icon);
            this.eDu.pr(this.eDs.eBz);
            this.eDu.cy(this.eDs.eBB);
            this.eDq.add(this.eDu);
        }
        aSq();
    }

    private c K(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.ata = i2;
        cVar.eDB = new com.baidu.tieba.personCenter.d.a();
        cVar.eDB.bJp = i3;
        return cVar;
    }

    private b bj(int i, int i2) {
        b bVar = new b();
        bVar.eyc = i;
        bVar.eDz = i2;
        return bVar;
    }

    public ArrayList<v> aoT() {
        return this.eDq;
    }

    public UserData aSs() {
        return this.mUserData;
    }
}
