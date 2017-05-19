package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes.dex */
public class n {
    private boolean bjW;
    private ArrayList<v> eDC;
    private b eDD;
    private com.baidu.tieba.person.a.e eDE;
    private l eDF;
    private f eDG;
    private i eDH;
    private List<v> eDI;
    private com.baidu.tieba.person.data.b eDL;
    public com.baidu.tieba.personCenter.b.a eDM;
    public com.baidu.tieba.personCenter.b.a eDN;
    public com.baidu.tieba.personCenter.b.a eDO;
    public com.baidu.tieba.personCenter.b.a eDP;
    public com.baidu.tieba.personCenter.b.a eDQ;
    public com.baidu.tieba.personCenter.b.a eDR;
    private UserVideoChannelInfoData eDS;
    private h mCardNullPolymericData;
    private UserData mUserData;
    private boolean eDv = true;
    private int sex = 1;
    private int eDw = 1;
    private int eDx = 1;
    private int eDy = 1;
    private int eDz = 1;
    private int eDA = -1;
    private int eDB = -1;
    private boolean hasMore = true;
    private ArrayList<v> eDJ = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> eDK = new ArrayList<>();

    public n(boolean z) {
        this.bjW = z;
    }

    public boolean arY() {
        return this.eDv;
    }

    public void jc(boolean z) {
        this.eDv = z;
    }

    public boolean Nd() {
        return this.bjW;
    }

    public void a(com.baidu.tieba.person.b bVar) {
        if (bVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(bVar.GetUser());
            if (bVar.GetUser() != null) {
                if (bVar.GetUser().priv_sets != null) {
                    this.eDw = bVar.GetUser().priv_sets.like.intValue();
                    this.eDx = bVar.GetUser().priv_sets.post.intValue();
                    this.eDy = bVar.GetUser().priv_sets.group.intValue();
                    this.eDz = bVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = bVar.GetUser().sex.intValue();
            }
            if (bVar.getTaInfo() != null) {
                this.eDv = bVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(bVar.getTaInfo().is_friend.intValue());
            if (this.eDS == null) {
                this.eDS = new UserVideoChannelInfoData();
            }
            if (bVar.getUserChannelInfo() != null) {
                this.eDS.parserProtobuf(bVar.getUserChannelInfo());
            }
            if (bVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(bVar.getBookrackData());
                this.eDL = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!x.r(bVar.getConcernedForumList()) && !this.bjW && !aPS()) {
                ca(bVar.getConcernedForumList());
            }
            if (this.eDH == null && aPT() && !this.bjW) {
                this.eDH = new i();
                this.eDH.sex = this.sex;
                this.eDH.eDp = aPT();
            }
            if (!x.r(bVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : bVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eDA != date.getDate();
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z);
                                break;
                            case 2:
                                a(dynamicInfo, z);
                                break;
                            case 3:
                                b(dynamicInfo, z);
                                break;
                        }
                        this.eDA = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && x.r(this.eDI)) {
                this.mCardNullPolymericData = new h();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.bjW = this.bjW;
                this.hasMore = false;
            }
            if (this.bjW) {
                aPX();
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aPT() || this.bjW) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eDI == null) {
                this.eDI = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eDB);
            this.eDB = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.byh = true;
            cardPersonDynamicThreadData.bjW = this.bjW;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.byg = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eDI.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.r(list)) {
                if (this.eDI == null) {
                    this.eDI = new ArrayList();
                }
                c cVar = new c();
                cVar.bjW = this.bjW;
                cVar.byg = z;
                cVar.sex = this.sex;
                cVar.bxY = au.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eDa = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eDa = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eDI.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aPS() || this.bjW) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eDI == null) {
                this.eDI = new ArrayList();
            }
            a aVar = new a();
            aVar.bjW = this.bjW;
            aVar.sex = this.sex;
            aVar.byg = z;
            aVar.bxY = au.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eDa = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.cxa = forumDynamic.forum_name;
            aVar.isAttention = forumDynamic.is_like.intValue() == 1;
            aVar.eDb = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eDI.add(aVar);
            this.eDI.add(aX(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
    }

    public List<v> aPE() {
        if (this.eDE == null) {
            return null;
        }
        return this.eDE.getPhotoAlbum();
    }

    private void ca(List<ForumDynamic> list) {
        this.eDD = new b();
        this.eDD.eDd = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eDh = forumDynamic.user_thread_count.intValue();
                this.eDD.eDd.add(eVar);
            }
        }
    }

    public void aPR() {
        this.eDJ.clear();
        if (this.eDH != null) {
            this.eDJ.add(this.eDH);
        }
        if (this.mCardNullPolymericData != null && this.eDH == null) {
            this.eDJ.add(this.mCardNullPolymericData);
        }
        if (!x.r(this.eDI)) {
            this.eDJ.addAll(this.eDI);
        }
    }

    private boolean aPS() {
        if (this.bjW) {
            return false;
        }
        if (this.eDw == 3) {
            return true;
        }
        return this.eDw == 2 && !this.eDv;
    }

    public boolean aPT() {
        if (this.bjW) {
            return false;
        }
        if (this.eDx == 3) {
            return true;
        }
        return this.eDx == 2 && !this.eDv;
    }

    private com.baidu.tieba.personCenter.b.b aX(int i, int i2) {
        com.baidu.tieba.personCenter.b.b bVar = new com.baidu.tieba.personCenter.b.b();
        bVar.eug = i;
        bVar.eyG = i2;
        return bVar;
    }

    public void aPU() {
        this.eDv = true;
        this.sex = 1;
        this.eDw = 1;
        this.eDx = 1;
        this.eDy = 1;
        this.eDz = 1;
        this.eDA = -1;
        this.eDB = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eDC != null) {
            this.eDC.clear();
        }
        this.eDC = null;
        this.eDD = null;
        this.eDE = null;
        this.eDF = null;
        this.eDG = null;
        this.eDH = null;
        this.mCardNullPolymericData = null;
        if (this.eDI != null) {
            this.eDI.clear();
        }
        this.eDI = null;
        this.eDJ.clear();
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> ajJ() {
        return this.eDJ;
    }

    public b aPV() {
        return this.eDD;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aPW() {
        return this.eDK;
    }

    private void aPX() {
        this.eDK.clear();
        this.eDO = L(w.g.icon_starer_caise_heibai, w.l.mark, 20);
        this.eDO.bIv = new Bundle();
        this.eDO.bIv.putBoolean("person_center_item_red_tip", true);
        this.eDO.eyE.bIv = new Bundle();
        this.eDO.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(this.eDO);
        this.eDP = L(w.g.icon_lover_caise_heibai, w.l.contacts, 24);
        this.eDP.bIv = new Bundle();
        this.eDP.bIv.putBoolean("person_center_item_red_tip", true);
        this.eDP.eyE.bIv = new Bundle();
        this.eDP.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(this.eDP);
        this.eDM = L(w.g.icon_liwu_caise_heibai, w.l.gift, 34);
        this.eDM.bIv = new Bundle();
        this.eDM.bIv.putBoolean("person_center_item_red_tip", true);
        this.eDM.eyE.bIv = new Bundle();
        this.eDM.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(this.eDM);
        com.baidu.tieba.personCenter.b.a L = L(w.g.icon_lishi_caise_heibai, w.l.history, 21);
        L.eyE.bIv = new Bundle();
        L.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(L);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a L2 = L(w.g.icon_zhibou_caise_heibai, w.l.person_center_ala_live, 29);
            L2.bIv = new Bundle();
            L2.eyE.bIv = new Bundle();
            L2.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eDK.add(L2);
        }
        if (this.eDS != null) {
            TiebaStatic.log(new as("c11956"));
            if (this.eDS.getManChannel() == 1) {
                this.eDN = L(w.g.icon_weibar_caise_heibai, w.l.weiba, 30);
                this.eDN.bIv = new Bundle();
                this.eDN.bIv.putBoolean("person_center_item_red_tip", true);
                this.eDN.eyE.bIv = new Bundle();
                this.eDN.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eDK.add(this.eDN);
            }
        }
        com.baidu.tieba.personCenter.b.a L3 = L(w.g.icon_zhuanshi_caise_heibai, w.l.blue_drill, 15);
        L3.eyE.bIv = new Bundle();
        L3.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(L3);
        com.baidu.tieba.personCenter.b.a L4 = L(w.g.icon_bookshoop_caise_heibai, w.l.book_shel, 33);
        L4.eyE.bIv = new Bundle();
        L4.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.eDL != null) {
            L4.eyE.bIv.putString("book_jump_link", this.eDL.exZ);
        }
        this.eDK.add(L4);
        com.baidu.tieba.personCenter.b.a L5 = L(w.g.icon_kabao_caise_heibai, w.l.card_box, 35);
        L5.eyE.bIv = new Bundle();
        L5.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(L5);
        com.baidu.tieba.personCenter.b.a L6 = L(w.g.icon_xiaofeijilu_caise_heibai, w.l.consumption_records, 17);
        L6.eyE.bIv = new Bundle();
        L6.eyE.bIv.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eDK.add(L6);
    }

    private com.baidu.tieba.personCenter.b.a L(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        aVar.eyE = new com.baidu.tieba.personCenter.c.a();
        aVar.eyE.bIu = i3;
        return aVar;
    }
}
