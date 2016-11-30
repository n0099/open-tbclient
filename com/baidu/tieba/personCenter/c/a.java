package com.baidu.tieba.personCenter.c;

import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.person.g;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a {
    private ArrayList<v> eLS = new ArrayList<>();
    private PersonUserGodInfo eLT;
    private g eLU;
    private com.baidu.tieba.person.data.b eLV;
    private com.baidu.tieba.person.data.c eLW;
    public c eLX;
    public c eLY;
    public c eLZ;
    private UserData mUserData;

    public void a(com.baidu.tieba.person.c cVar) {
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (this.eLT == null) {
                this.eLT = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && cVar.getUserGodInfo().god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eLT.parserProtobuf(cVar.getUserGodInfo());
            }
            String userId = this.mUserData.getUserId();
            if (!StringUtils.isNull(userId)) {
                TbadkCoreApplication.m9getInst();
                if (!userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    com.baidu.tbadk.getUserInfo.b.Eh().a(this.mUserData);
                }
            }
            this.eLU = cVar.getUcCardData();
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(cVar.getBookrackData());
                this.eLV = new com.baidu.tieba.person.data.b(true, aVar);
            }
        }
    }

    private void aUV() {
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eLX = M(r.f.icon_mine_gift, r.j.gift_received_by_me, 10);
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
            this.eLX.bMk = new Bundle();
            this.eLX.bMk.putSerializable("person_center_item_pic", arrayList);
            this.eLX.bMk.putBoolean("person_center_item_red_tip", true);
        }
        this.eLX.eMd.bMk = new Bundle();
        this.eLX.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(this.eLX);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        c M = M(r.f.icon_mine_store_bluedrill, r.j.blue_drill_store, 11);
        if (this.mUserData != null && this.mUserData.membershipInfo != null && !StringUtils.isNull(this.mUserData.membershipInfo.mContent)) {
            M.bMk = new Bundle();
            M.bMk.putString("person_center_item_txt", this.mUserData.membershipInfo.mContent);
        }
        M.eMd.bMk = new Bundle();
        M.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(M);
        if (this.eLW != null) {
            c pg = this.eLW.pg(r.j.person_center_buy_record);
            if (pg != null) {
                this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
                pg.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eLS.add(pg);
            }
            if (this.mUserData.isSeller()) {
                c pg2 = this.eLW.pg(r.j.ecomm_my_shop);
                if (pg2 != null) {
                    this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
                    pg2.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
                    this.eLS.add(pg2);
                }
            } else {
                c pg3 = this.eLW.pg(r.j.person_center_my_order);
                if (pg3 != null) {
                    this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
                    pg3.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
                    this.eLS.add(pg3);
                }
            }
        }
        this.eLY = M(r.f.icon_mine_collect, r.j.person_center_collect, 15);
        this.eLY.bMk = new Bundle();
        this.eLY.bMk.putBoolean("person_center_item_red_tip", true);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eLY.eMd.bMk = new Bundle();
        this.eLY.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(this.eLY);
        c M2 = M(r.f.icon_mine_history, r.j.person_center_history, 16);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        M2.eMd.bMk = new Bundle();
        M2.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(M2);
        c M3 = M(r.f.icon_mine_anchor, r.j.host_mission, 17);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        M3.eMd.bMk = new Bundle();
        M3.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(M3);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eLS.add(this.eLV);
        this.eLZ = M(r.f.icon_mine_friend, r.j.person_center_friend, 19);
        this.eLZ.bMk = new Bundle();
        this.eLZ.bMk.putBoolean("person_center_item_red_tip", true);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
        this.eLZ.eMd.bMk = new Bundle();
        this.eLZ.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(this.eLZ);
        c M4 = M(r.f.icon_mine_group, r.j.person_center_group, 20);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        M4.eMd.bMk = new Bundle();
        M4.eMd.bMk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eLS.add(M4);
        this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds220), r.d.cp_bg_line_c));
    }

    public void aUW() {
        if (this.eLU != null && !x.t(this.eLU.eKd)) {
            this.eLS.add(bm(k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_c));
            this.eLW = new com.baidu.tieba.person.data.c();
            this.eLW.setName(this.eLU.name);
            this.eLW.pR(this.eLU.eKc);
            this.eLW.setIcon(this.eLU.icon);
            this.eLW.pQ(this.eLU.eKb);
            this.eLW.cB(this.eLU.eKd);
            this.eLS.add(this.eLW);
        }
        aUV();
    }

    private c M(int i, int i2, int i3) {
        c cVar = new c();
        cVar.iconId = i;
        cVar.eMe = i2;
        cVar.eMd = new com.baidu.tieba.personCenter.d.a();
        cVar.eMd.bMj = i3;
        return cVar;
    }

    private b bm(int i, int i2) {
        b bVar = new b();
        bVar.eGS = i;
        bVar.eMb = i2;
        return bVar;
    }

    public ArrayList<v> ard() {
        return this.eLS;
    }

    public UserData aUX() {
        return this.mUserData;
    }
}
