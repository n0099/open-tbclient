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
    protected boolean buB;
    private ArrayList<com.baidu.adp.widget.ListView.f> flI;
    private c flJ;
    private com.baidu.tieba.person.a.e flK;
    private m flL;
    private AlaLiveInfoCoreData flM;
    private g flN;
    protected j flO;
    protected List<com.baidu.adp.widget.ListView.f> flP;
    private com.baidu.tieba.person.data.b flS;
    public com.baidu.tieba.personCenter.b.a flT;
    public com.baidu.tieba.personCenter.b.a flU;
    public com.baidu.tieba.personCenter.b.a flV;
    public com.baidu.tieba.personCenter.b.a flW;
    public com.baidu.tieba.personCenter.b.a flX;
    public com.baidu.tieba.personCenter.b.a flY;
    private UserVideoChannelInfoData flZ;
    private PersonUserGodInfo fma;
    public UserAgreeInfo fmb;
    public NicknameInfo fmc;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean flB = true;
    protected int sex = 1;
    private int flC = 1;
    private int flD = 1;
    private int flE = 1;
    private int flF = 1;
    private int flG = -1;
    private int flH = -1;
    private boolean hasMore = true;
    protected ArrayList<com.baidu.adp.widget.ListView.f> flQ = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> flR = new ArrayList<>();

    public abstract void VZ();

    public a(boolean z) {
        this.buB = z;
    }

    public boolean ayW() {
        return this.flB;
    }

    public void ku(boolean z) {
        this.flB = z;
    }

    public boolean OR() {
        return this.buB;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.flC = fVar.GetUser().priv_sets.like.intValue();
                    this.flD = fVar.GetUser().priv_sets.post.intValue();
                    this.flE = fVar.GetUser().priv_sets.group.intValue();
                    this.flF = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.flB = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.flZ == null) {
                this.flZ = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.flZ.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.flS = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!u.v(fVar.getConcernedForumList()) && !this.buB && !aZc()) {
                cM(fVar.getConcernedForumList());
            }
            if (this.flO == null && aZd() && !this.buB) {
                this.flO = new j();
                this.flO.sex = this.sex;
                this.flO.fmu = aZd();
            }
            if (!u.v(fVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.flG != date.getDate();
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
                        this.flG = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && u.v(this.flP)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.buB = this.buB;
                this.hasMore = false;
            }
            if (this.buB) {
                aZi();
            }
            if (this.fma == null) {
                this.fma = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fma.parserProtobuf(fVar.getUserGodInfo());
            }
            this.fmb = fVar.getUserAgreeInfo();
            this.flM = fVar.getLiveInfo();
            this.fmc = fVar.getNicknameInfo();
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aZd() || this.buB) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.flP == null) {
                this.flP = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.flH);
            this.flH = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bLa = true;
            cardPersonDynamicThreadData.buB = this.buB;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bKZ = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.flP.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!u.v(list)) {
                if (this.flP == null) {
                    this.flP = new ArrayList();
                }
                d dVar = new d();
                dVar.buB = this.buB;
                dVar.bKZ = z;
                dVar.sex = this.sex;
                dVar.bKS = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fme = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fme = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.flP.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aZc() || this.buB) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.flP == null) {
                this.flP = new ArrayList();
            }
            b bVar = new b();
            bVar.buB = this.buB;
            bVar.sex = this.sex;
            bVar.bKZ = z;
            bVar.bKS = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fme = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.cXk = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fmf = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.flP.add(bVar);
            this.flP.add(bp(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aYT() {
        if (this.flK == null) {
            return null;
        }
        return this.flK.getPhotoAlbum();
    }

    private void cM(List<ForumDynamic> list) {
        this.flJ = new c();
        this.flJ.fmh = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fml = forumDynamic.user_thread_count.intValue();
                this.flJ.fmh.add(fVar);
            }
        }
    }

    private boolean aZc() {
        if (this.buB) {
            return false;
        }
        if (this.flC == 3) {
            return true;
        }
        return this.flC == 2 && !this.flB;
    }

    public boolean aZd() {
        if (this.buB) {
            return false;
        }
        if (this.flD == 3) {
            return true;
        }
        return this.flD == 2 && !this.flB;
    }

    private com.baidu.tieba.person.h bp(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.fcz = i;
        hVar.ffP = i2;
        return hVar;
    }

    public void aZe() {
        this.flB = true;
        this.sex = 1;
        this.flC = 1;
        this.flD = 1;
        this.flE = 1;
        this.flF = 1;
        this.flG = -1;
        this.flH = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.flI != null) {
            this.flI.clear();
        }
        this.flI = null;
        this.flJ = null;
        this.flK = null;
        this.flL = null;
        this.flN = null;
        this.flO = null;
        this.mCardNullPolymericData = null;
        if (this.flP != null) {
            this.flP.clear();
        }
        this.flP = null;
        this.flQ.clear();
        this.fmb = null;
        this.fmc = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aZf() {
        return this.flM;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aqN() {
        return this.flQ;
    }

    public c aZg() {
        return this.flJ;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aZh() {
        return this.flR;
    }

    private void aZi() {
        this.flR.clear();
        this.flV = N(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.flV.cbl = new Bundle();
        this.flV.cbl.putBoolean("person_center_item_red_tip", true);
        this.flV.fgM.cbl = new Bundle();
        this.flV.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(this.flV);
        this.flW = N(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.flW.cbl = new Bundle();
        this.flW.cbl.putBoolean("person_center_item_red_tip", true);
        this.flW.fgM.cbl = new Bundle();
        this.flW.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(this.flW);
        this.flT = N(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.flT.cbl = new Bundle();
        this.flT.cbl.putBoolean("person_center_item_red_tip", true);
        this.flT.fgM.cbl = new Bundle();
        this.flT.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(this.flT);
        com.baidu.tieba.personCenter.b.a N = N(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        N.fgM.cbl = new Bundle();
        N.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(N);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a N2 = N(d.g.icon_zhibou_caise_heibai, d.l.person_center_ala_live, 29);
            N2.cbl = new Bundle();
            N2.fgM.cbl = new Bundle();
            N2.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.flR.add(N2);
        }
        if (this.flZ != null) {
            TiebaStatic.log(new aj("c11956"));
            if (this.flZ.getManChannel() == 1) {
                this.flU = N(d.g.icon_weibar_caise_heibai, d.l.weiba, 30);
                this.flU.cbl = new Bundle();
                this.flU.cbl.putBoolean("person_center_item_red_tip", true);
                this.flU.fgM.cbl = new Bundle();
                this.flU.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.flR.add(this.flU);
            }
        }
        com.baidu.tieba.personCenter.b.a N3 = N(d.g.icon_zhuanshi_caise_heibai, d.l.blue_drill, 15);
        N3.fgM.cbl = new Bundle();
        N3.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(N3);
        com.baidu.tieba.personCenter.b.a N4 = N(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        N4.fgM.cbl = new Bundle();
        N4.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.flS != null) {
            N4.fgM.cbl.putString("book_jump_link", this.flS.fgn);
        }
        this.flR.add(N4);
        com.baidu.tieba.personCenter.b.a N5 = N(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        N5.fgM.cbl = new Bundle();
        N5.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(N5);
        com.baidu.tieba.personCenter.b.a N6 = N(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        N6.fgM.cbl = new Bundle();
        N6.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(N6);
        com.baidu.tieba.personCenter.b.a N7 = N(d.g.icon_huishouzhan_caise_heibai, d.l.deleteThread_records, 37);
        N6.fgM.cbl = new Bundle();
        N6.fgM.cbl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.flR.add(N7);
    }

    private com.baidu.tieba.personCenter.b.a N(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.getInst().getString(i2);
        aVar.fgM = new com.baidu.tieba.personCenter.c.a();
        aVar.fgM.cbk = i3;
        return aVar;
    }
}
