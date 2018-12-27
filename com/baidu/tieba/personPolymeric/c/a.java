package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes3.dex */
public abstract class a {
    private AntiData aNN;
    private AlaLiveInfoCoreData gAA;
    private List<AlaLiveInfoCoreData> gAB;
    protected g gAC;
    protected List<com.baidu.adp.widget.ListView.h> gAD;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gAG;
    public n gAH;
    public n gAI;
    public n gAJ;
    public n gAK;
    public n gAL;
    public n gAM;
    private UserVideoChannelInfoData gAN;
    public UserAgreeInfo gAO;
    public NicknameInfo gAP;
    private ArrayList<com.baidu.adp.widget.ListView.h> gAw;
    private c gAx;
    private com.baidu.tieba.person.a.f gAy;
    private m gAz;
    private com.baidu.tieba.person.data.d guA;
    private PersonUserGodInfo guz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gAs = true;
    protected int sex = 1;
    private int gAt = 1;
    private int gAu = 1;
    private int gAv = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gAE = new ArrayList<>();
    private ArrayList<n> gAF = new ArrayList<>();

    public abstract void brc();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aVy() {
        return this.gAs;
    }

    public void mp(boolean z) {
        this.gAs = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (this.aNN == null) {
                this.aNN = new AntiData();
            }
            this.aNN.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gAt = cVar.GetUser().priv_sets.like.intValue();
                    this.gAu = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gAs = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gAN == null) {
                this.gAN = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gAN.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.guA = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.I(cVar.getConcernedForumList()) && !this.isHost && !brd()) {
                dw(cVar.getConcernedForumList());
            }
            if (this.gAC == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.I(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String ag = ao.ag(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.I(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String ag2 = ao.ag(longValue);
                        String aj = ao.aj(longValue);
                        String ai = ao.ai(longValue);
                        if (ao.equals(ag2, ag)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(ai, str3) && ao.equals(aj, str2) && ao.equals(ag2, ag)) {
                            z2 = false;
                            ai = str3;
                            str = ag;
                        } else {
                            z2 = true;
                            str2 = aj;
                            str = ag2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z, z2, z3);
                                break;
                            case 2:
                                a(dynamicInfo, z2);
                                break;
                            case 3:
                                b(dynamicInfo, z2);
                                break;
                        }
                        z3 = false;
                        str3 = ai;
                        ag = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.I(this.gAD) && v.I(this.gAG)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bpt();
                this.maskType = cVar.getMaskType();
            }
            if (this.guz == null) {
                this.guz = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.guz.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gAO = cVar.getUserAgreeInfo();
            this.gAA = cVar.getLiveInfo();
            this.gAB = cVar.getLiveReplayInfo();
            this.gAP = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.I(user.gift_list)) {
            this.gAC = new g();
            this.gAC.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bre() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gAD == null) {
                this.gAD = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gAv);
            this.gAv = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.dbE = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.dbC = z;
            cardPersonDynamicThreadData.dbB = z2;
            cardPersonDynamicThreadData.dbD = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gAD.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bre() || this.isHost) {
            if (this.gAG == null) {
                this.gAG = new ArrayList<>();
            }
            this.gAv = UtilHelper.getRandom(random, 3, this.gAv);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.dbE = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.dbC = false;
            cardPersonDynamicThreadData.dbB = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gAv);
            this.gAG.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.I(list)) {
                if (this.gAD == null) {
                    this.gAD = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.dbB = z;
                dVar.sex = this.sex;
                dVar.dbu = ao.aj(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.dbv = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.dbv = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gAD.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!brd() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gAD == null) {
                this.gAD = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.dbB = z;
            bVar.dbu = ao.aj(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.dbv = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gAR = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gAS = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gAD.add(bVar);
            this.gAD.add(bC(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0210e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bqT() {
        if (this.gAy == null) {
            return null;
        }
        return this.gAy.getPhotoAlbum();
    }

    private void dw(List<ForumDynamic> list) {
        this.gAx = new c();
        this.gAx.gAU = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gAY = forumDynamic.user_thread_count.intValue();
                this.gAx.gAU.add(fVar);
            }
        }
    }

    private boolean brd() {
        if (this.isHost) {
            return false;
        }
        if (this.gAt == 3) {
            return true;
        }
        return this.gAt == 2 && !this.gAs;
    }

    public boolean bre() {
        if (this.isHost) {
            return false;
        }
        if (this.gAu == 3) {
            return true;
        }
        return this.gAu == 2 && !this.gAs;
    }

    protected com.baidu.tieba.person.d bC(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gpg = i;
        dVar.bdO = i2;
        return dVar;
    }

    public void brf() {
        this.gAs = true;
        this.sex = 1;
        this.gAt = 1;
        this.gAu = 1;
        this.gAv = -1;
        this.mUserData = null;
        if (this.gAw != null) {
            this.gAw.clear();
        }
        this.gAw = null;
        this.gAx = null;
        this.gAy = null;
        this.gAz = null;
        this.gAC = null;
        this.mCardNullPolymericData = null;
        if (this.gAD != null) {
            this.gAD.clear();
        }
        if (this.gAG != null) {
            this.gAG.clear();
        }
        this.gAD = null;
        this.gAG = null;
        this.gAE.clear();
        this.gAO = null;
        this.gAP = null;
        this.maskType = 0;
        this.gAA = null;
        if (this.gAB != null) {
            this.gAB.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData aAM() {
        return this.aNN;
    }

    public AlaLiveInfoCoreData brg() {
        return this.gAA;
    }

    public List<AlaLiveInfoCoreData> brh() {
        return this.gAB;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aNx() {
        return this.gAE;
    }

    public c bri() {
        return this.gAx;
    }

    public g brj() {
        return this.gAC;
    }

    public PersonUserGodInfo brk() {
        return this.guz;
    }

    private void bpt() {
        this.gAF.clear();
        this.gAJ = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gAJ.dtC = new Bundle();
        this.gAJ.dtC.putBoolean("person_center_item_red_tip", true);
        this.gAJ.gBj.dtC = new Bundle();
        this.gAJ.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(this.gAJ);
        this.gAK = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gAK.dtC = new Bundle();
        this.gAK.dtC.putBoolean("person_center_item_red_tip", true);
        this.gAK.gBj.dtC = new Bundle();
        this.gAK.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(this.gAK);
        this.gAH = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gAH.dtC = new Bundle();
        this.gAH.dtC.putBoolean("person_center_item_red_tip", true);
        this.gAH.gBj.dtC = new Bundle();
        this.gAH.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(this.gAH);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.gBj.dtC = new Bundle();
        X.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.dtC = new Bundle();
            X2.gBj.dtC = new Bundle();
            X2.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gAF.add(X2);
        }
        if (this.gAN != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gAN.getManChannel() == 1) {
                this.gAI = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gAI.dtC = new Bundle();
                this.gAI.dtC.putBoolean("person_center_item_red_tip", true);
                this.gAI.gBj.dtC = new Bundle();
                this.gAI.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gAF.add(this.gAI);
            }
        }
        this.gAL = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gAL.dtC = new Bundle();
        this.gAL.dtC.putBoolean("person_center_item_red_tip", true);
        this.gAL.gBj.dtC = new Bundle();
        this.gAL.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(this.gAL);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.gBj.dtC = new Bundle();
        X3.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.guA != null) {
            X3.gBj.dtC.putString("book_jump_link", this.guA.gtt);
        }
        this.gAF.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.gBj.dtC = new Bundle();
        X4.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.gBj.dtC = new Bundle();
        X5.gBj.dtC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gAF.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.gBj.dtC = new Bundle();
        X6.gBj.dtC.putString("key_service_centre", "");
        this.gAF.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gBj = new com.baidu.tieba.personCenter.c.a();
        nVar.gBj.dtB = i3;
        return nVar;
    }
}
