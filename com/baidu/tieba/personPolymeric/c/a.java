package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes.dex */
public abstract class a {
    protected boolean buA;
    private ArrayList<com.baidu.adp.widget.ListView.f> flG;
    private c flH;
    private com.baidu.tieba.person.a.e flI;
    private m flJ;
    private AlaLiveInfoCoreData flK;
    private g flL;
    protected j flM;
    protected List<com.baidu.adp.widget.ListView.f> flN;
    private com.baidu.tieba.person.data.b flQ;
    public com.baidu.tieba.personCenter.b.a flR;
    public com.baidu.tieba.personCenter.b.a flS;
    public com.baidu.tieba.personCenter.b.a flT;
    public com.baidu.tieba.personCenter.b.a flU;
    public com.baidu.tieba.personCenter.b.a flV;
    public com.baidu.tieba.personCenter.b.a flW;
    private UserVideoChannelInfoData flX;
    private PersonUserGodInfo flY;
    public UserAgreeInfo flZ;
    public NicknameInfo fma;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean flz = true;
    protected int sex = 1;
    private int flA = 1;
    private int flB = 1;
    private int flC = 1;
    private int flD = 1;
    private int flE = -1;
    private int flF = -1;
    private boolean hasMore = true;
    protected ArrayList<com.baidu.adp.widget.ListView.f> flO = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> flP = new ArrayList<>();

    public abstract void Wc();

    public a(boolean z) {
        this.buA = z;
    }

    public boolean azb() {
        return this.flz;
    }

    public void ku(boolean z) {
        this.flz = z;
    }

    public boolean OS() {
        return this.buA;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.flA = fVar.GetUser().priv_sets.like.intValue();
                    this.flB = fVar.GetUser().priv_sets.post.intValue();
                    this.flC = fVar.GetUser().priv_sets.group.intValue();
                    this.flD = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.flz = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.flX == null) {
                this.flX = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.flX.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.flQ = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!u.v(fVar.getConcernedForumList()) && !this.buA && !aZh()) {
                cM(fVar.getConcernedForumList());
            }
            if (this.flM == null && aZi() && !this.buA) {
                this.flM = new j();
                this.flM.sex = this.sex;
                this.flM.fms = aZi();
            }
            if (!u.v(fVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.flE != date.getDate();
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
                        this.flE = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && u.v(this.flN)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.buA = this.buA;
                this.hasMore = false;
            }
            if (this.buA) {
                aZn();
            }
            if (this.flY == null) {
                this.flY = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.flY.parserProtobuf(fVar.getUserGodInfo());
            }
            this.flZ = fVar.getUserAgreeInfo();
            this.flK = fVar.getLiveInfo();
            this.fma = fVar.getNicknameInfo();
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aZi() || this.buA) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.flN == null) {
                this.flN = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.flF);
            this.flF = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bKZ = true;
            cardPersonDynamicThreadData.buA = this.buA;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bKY = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.flN.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!u.v(list)) {
                if (this.flN == null) {
                    this.flN = new ArrayList();
                }
                d dVar = new d();
                dVar.buA = this.buA;
                dVar.bKY = z;
                dVar.sex = this.sex;
                dVar.bKR = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fmc = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fmc = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.flN.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aZh() || this.buA) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.flN == null) {
                this.flN = new ArrayList();
            }
            b bVar = new b();
            bVar.buA = this.buA;
            bVar.sex = this.sex;
            bVar.bKY = z;
            bVar.bKR = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fmc = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.cXk = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fmd = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.flN.add(bVar);
            this.flN.add(bp(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aYY() {
        if (this.flI == null) {
            return null;
        }
        return this.flI.getPhotoAlbum();
    }

    private void cM(List<ForumDynamic> list) {
        this.flH = new c();
        this.flH.fmf = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fmj = forumDynamic.user_thread_count.intValue();
                this.flH.fmf.add(fVar);
            }
        }
    }

    private boolean aZh() {
        if (this.buA) {
            return false;
        }
        if (this.flA == 3) {
            return true;
        }
        return this.flA == 2 && !this.flz;
    }

    public boolean aZi() {
        if (this.buA) {
            return false;
        }
        if (this.flB == 3) {
            return true;
        }
        return this.flB == 2 && !this.flz;
    }

    private com.baidu.tieba.person.h bp(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.fcx = i;
        hVar.ffN = i2;
        return hVar;
    }

    public void aZj() {
        this.flz = true;
        this.sex = 1;
        this.flA = 1;
        this.flB = 1;
        this.flC = 1;
        this.flD = 1;
        this.flE = -1;
        this.flF = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.flG != null) {
            this.flG.clear();
        }
        this.flG = null;
        this.flH = null;
        this.flI = null;
        this.flJ = null;
        this.flL = null;
        this.flM = null;
        this.mCardNullPolymericData = null;
        if (this.flN != null) {
            this.flN.clear();
        }
        this.flN = null;
        this.flO.clear();
        this.flZ = null;
        this.fma = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aZk() {
        return this.flK;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aqT() {
        return this.flO;
    }

    public c aZl() {
        return this.flH;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aZm() {
        return this.flP;
    }

    private void aZn() {
        this.flP.clear();
        this.flT = N(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.flT.cbk = new Bundle();
        this.flT.cbk.putBoolean("person_center_item_red_tip", true);
        this.flT.fgK.cbk = new Bundle();
        this.flT.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(this.flT);
        this.flU = N(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.flU.cbk = new Bundle();
        this.flU.cbk.putBoolean("person_center_item_red_tip", true);
        this.flU.fgK.cbk = new Bundle();
        this.flU.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(this.flU);
        this.flR = N(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.flR.cbk = new Bundle();
        this.flR.cbk.putBoolean("person_center_item_red_tip", true);
        this.flR.fgK.cbk = new Bundle();
        this.flR.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(this.flR);
        com.baidu.tieba.personCenter.b.a N = N(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        N.fgK.cbk = new Bundle();
        N.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(N);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a N2 = N(d.g.icon_zhibou_caise_heibai, d.l.person_center_ala_live, 29);
            N2.cbk = new Bundle();
            N2.fgK.cbk = new Bundle();
            N2.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.flP.add(N2);
        }
        if (this.flX != null) {
            TiebaStatic.log(new aj("c11956"));
            if (this.flX.getManChannel() == 1) {
                this.flS = N(d.g.icon_weibar_caise_heibai, d.l.weiba, 30);
                this.flS.cbk = new Bundle();
                this.flS.cbk.putBoolean("person_center_item_red_tip", true);
                this.flS.fgK.cbk = new Bundle();
                this.flS.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.flP.add(this.flS);
            }
        }
        com.baidu.tieba.personCenter.b.a N3 = N(d.g.icon_zhuanshi_caise_heibai, d.l.blue_drill, 15);
        N3.fgK.cbk = new Bundle();
        N3.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(N3);
        com.baidu.tieba.personCenter.b.a N4 = N(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        N4.fgK.cbk = new Bundle();
        N4.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.flQ != null) {
            N4.fgK.cbk.putString("book_jump_link", this.flQ.fgl);
        }
        this.flP.add(N4);
        com.baidu.tieba.personCenter.b.a N5 = N(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        N5.fgK.cbk = new Bundle();
        N5.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(N5);
        com.baidu.tieba.personCenter.b.a N6 = N(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        N6.fgK.cbk = new Bundle();
        N6.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(N6);
        com.baidu.tieba.personCenter.b.a N7 = N(d.g.icon_huishouzhan_caise_heibai, d.l.deleteThread_records, 37);
        N6.fgK.cbk = new Bundle();
        N6.fgK.cbk.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flP.add(N7);
    }

    private com.baidu.tieba.personCenter.b.a N(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.getInst().getString(i2);
        aVar.fgK = new com.baidu.tieba.personCenter.c.a();
        aVar.fgK.cbj = i3;
        return aVar;
    }
}
