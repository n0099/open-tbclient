package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
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
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.Profile.UserAgreeInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes.dex */
public abstract class a {
    protected boolean bld;
    private ArrayList<v> eLS;
    private c eLT;
    private com.baidu.tieba.person.a.e eLU;
    private m eLV;
    private AlaLiveInfoCoreData eLW;
    private g eLX;
    protected j eLY;
    protected List<v> eLZ;
    private com.baidu.tieba.person.data.b eMc;
    public com.baidu.tieba.personCenter.b.a eMd;
    public com.baidu.tieba.personCenter.b.a eMe;
    public com.baidu.tieba.personCenter.b.a eMf;
    public com.baidu.tieba.personCenter.b.a eMg;
    public com.baidu.tieba.personCenter.b.a eMh;
    public com.baidu.tieba.personCenter.b.a eMi;
    private UserVideoChannelInfoData eMj;
    private PersonUserGodInfo eMk;
    public UserAgreeInfo eMl;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean eLL = true;
    protected int sex = 1;
    private int eLM = 1;
    private int eLN = 1;
    private int eLO = 1;
    private int eLP = 1;
    private int eLQ = -1;
    private int eLR = -1;
    private boolean hasMore = true;
    protected ArrayList<v> eMa = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> eMb = new ArrayList<>();

    public abstract void Tr();

    public a(boolean z) {
        this.bld = z;
    }

    public boolean asW() {
        return this.eLL;
    }

    public void jw(boolean z) {
        this.eLL = z;
    }

    public boolean Nm() {
        return this.bld;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.eLM = fVar.GetUser().priv_sets.like.intValue();
                    this.eLN = fVar.GetUser().priv_sets.post.intValue();
                    this.eLO = fVar.GetUser().priv_sets.group.intValue();
                    this.eLP = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.eLL = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.eMj == null) {
                this.eMj = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.eMj.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.eMc = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!x.r(fVar.getConcernedForumList()) && !this.bld && !aRl()) {
                cd(fVar.getConcernedForumList());
            }
            if (this.eLY == null && aRm() && !this.bld) {
                this.eLY = new j();
                this.eLY.sex = this.sex;
                this.eLY.eMC = aRm();
            }
            if (!x.r(fVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eLQ != date.getDate();
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
                        this.eLQ = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && x.r(this.eLZ)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.bld = this.bld;
                this.hasMore = false;
            }
            if (this.bld) {
                aRs();
            }
            if (this.eMk == null) {
                this.eMk = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.eMk.parserProtobuf(fVar.getUserGodInfo());
            }
            this.eMl = fVar.getUserAgreeInfo();
            this.eLW = fVar.getLiveInfo();
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aRm() || this.bld) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eLZ == null) {
                this.eLZ = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eLR);
            this.eLR = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bEc = true;
            cardPersonDynamicThreadData.bld = this.bld;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bEb = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eLZ.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.r(list)) {
                if (this.eLZ == null) {
                    this.eLZ = new ArrayList();
                }
                d dVar = new d();
                dVar.bld = this.bld;
                dVar.bEb = z;
                dVar.sex = this.sex;
                dVar.bDU = au.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eMn = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eMn = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.eLZ.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aRl() || this.bld) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eLZ == null) {
                this.eLZ = new ArrayList();
            }
            b bVar = new b();
            bVar.bld = this.bld;
            bVar.sex = this.sex;
            bVar.bEb = z;
            bVar.bDU = au.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eMn = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.cDr = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.eMo = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.eLZ.add(bVar);
            this.eLZ.add(aX(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
    }

    public List<v> aRe() {
        if (this.eLU == null) {
            return null;
        }
        return this.eLU.getPhotoAlbum();
    }

    private void cd(List<ForumDynamic> list) {
        this.eLT = new c();
        this.eLT.eMq = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.eMu = forumDynamic.user_thread_count.intValue();
                this.eLT.eMq.add(fVar);
            }
        }
    }

    private boolean aRl() {
        if (this.bld) {
            return false;
        }
        if (this.eLM == 3) {
            return true;
        }
        return this.eLM == 2 && !this.eLL;
    }

    public boolean aRm() {
        if (this.bld) {
            return false;
        }
        if (this.eLN == 3) {
            return true;
        }
        return this.eLN == 2 && !this.eLL;
    }

    private com.baidu.tieba.person.h aX(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.eDj = i;
        hVar.eGz = i2;
        return hVar;
    }

    public void aRn() {
        this.eLL = true;
        this.sex = 1;
        this.eLM = 1;
        this.eLN = 1;
        this.eLO = 1;
        this.eLP = 1;
        this.eLQ = -1;
        this.eLR = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eLS != null) {
            this.eLS.clear();
        }
        this.eLS = null;
        this.eLT = null;
        this.eLU = null;
        this.eLV = null;
        this.eLX = null;
        this.eLY = null;
        this.mCardNullPolymericData = null;
        if (this.eLZ != null) {
            this.eLZ.clear();
        }
        this.eLZ = null;
        this.eMa.clear();
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aRo() {
        return this.eLW;
    }

    public ArrayList<v> akJ() {
        return this.eMa;
    }

    public c aRp() {
        return this.eLT;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aRq() {
        return this.eMb;
    }

    public PersonUserGodInfo aRr() {
        return this.eMk;
    }

    private void aRs() {
        this.eMb.clear();
        this.eMf = L(w.g.icon_starer_caise_heibai, w.l.mark, 20);
        this.eMf.bOj = new Bundle();
        this.eMf.bOj.putBoolean("person_center_item_red_tip", true);
        this.eMf.eHs.bOj = new Bundle();
        this.eMf.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(this.eMf);
        this.eMg = L(w.g.icon_lover_caise_heibai, w.l.contacts, 24);
        this.eMg.bOj = new Bundle();
        this.eMg.bOj.putBoolean("person_center_item_red_tip", true);
        this.eMg.eHs.bOj = new Bundle();
        this.eMg.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(this.eMg);
        this.eMd = L(w.g.icon_liwu_caise_heibai, w.l.gift, 34);
        this.eMd.bOj = new Bundle();
        this.eMd.bOj.putBoolean("person_center_item_red_tip", true);
        this.eMd.eHs.bOj = new Bundle();
        this.eMd.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(this.eMd);
        com.baidu.tieba.personCenter.b.a L = L(w.g.icon_lishi_caise_heibai, w.l.history, 21);
        L.eHs.bOj = new Bundle();
        L.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(L);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a L2 = L(w.g.icon_zhibou_caise_heibai, w.l.person_center_ala_live, 29);
            L2.bOj = new Bundle();
            L2.eHs.bOj = new Bundle();
            L2.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eMb.add(L2);
        }
        if (this.eMj != null) {
            TiebaStatic.log(new as("c11956"));
            if (this.eMj.getManChannel() == 1) {
                this.eMe = L(w.g.icon_weibar_caise_heibai, w.l.weiba, 30);
                this.eMe.bOj = new Bundle();
                this.eMe.bOj.putBoolean("person_center_item_red_tip", true);
                this.eMe.eHs.bOj = new Bundle();
                this.eMe.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eMb.add(this.eMe);
            }
        }
        com.baidu.tieba.personCenter.b.a L3 = L(w.g.icon_zhuanshi_caise_heibai, w.l.blue_drill, 15);
        L3.eHs.bOj = new Bundle();
        L3.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(L3);
        com.baidu.tieba.personCenter.b.a L4 = L(w.g.icon_bookshoop_caise_heibai, w.l.book_shel, 33);
        L4.eHs.bOj = new Bundle();
        L4.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.eMc != null) {
            L4.eHs.bOj.putString("book_jump_link", this.eMc.eGR);
        }
        this.eMb.add(L4);
        com.baidu.tieba.personCenter.b.a L5 = L(w.g.icon_kabao_caise_heibai, w.l.card_box, 35);
        L5.eHs.bOj = new Bundle();
        L5.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(L5);
        com.baidu.tieba.personCenter.b.a L6 = L(w.g.icon_xiaofeijilu_caise_heibai, w.l.consumption_records, 17);
        L6.eHs.bOj = new Bundle();
        L6.eHs.bOj.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eMb.add(L6);
    }

    private com.baidu.tieba.personCenter.b.a L(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        aVar.eHs = new com.baidu.tieba.personCenter.c.a();
        aVar.eHs.bOi = i3;
        return aVar;
    }
}
