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
    private AntiData aNL;
    private PersonUserGodInfo grI;
    private com.baidu.tieba.person.data.d grJ;
    private ArrayList<com.baidu.adp.widget.ListView.h> gxF;
    private c gxG;
    private com.baidu.tieba.person.a.f gxH;
    private m gxI;
    private AlaLiveInfoCoreData gxJ;
    private List<AlaLiveInfoCoreData> gxK;
    protected g gxL;
    protected List<com.baidu.adp.widget.ListView.h> gxM;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gxP;
    public n gxQ;
    public n gxR;
    public n gxS;
    public n gxT;
    public n gxU;
    public n gxV;
    private UserVideoChannelInfoData gxW;
    public UserAgreeInfo gxX;
    public NicknameInfo gxY;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gxB = true;
    protected int sex = 1;
    private int gxC = 1;
    private int gxD = 1;
    private int gxE = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gxN = new ArrayList<>();
    private ArrayList<n> gxO = new ArrayList<>();

    public abstract void bqr();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aUL() {
        return this.gxB;
    }

    public void mm(boolean z) {
        this.gxB = z;
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
            if (this.aNL == null) {
                this.aNL = new AntiData();
            }
            this.aNL.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gxC = cVar.GetUser().priv_sets.like.intValue();
                    this.gxD = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gxB = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gxW == null) {
                this.gxW = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gxW.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.grJ = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.I(cVar.getConcernedForumList()) && !this.isHost && !bqs()) {
                dv(cVar.getConcernedForumList());
            }
            if (this.gxL == null) {
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
            String af = ao.af(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.I(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String af2 = ao.af(longValue);
                        String ai = ao.ai(longValue);
                        String ah = ao.ah(longValue);
                        if (ao.equals(af2, af)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(ah, str3) && ao.equals(ai, str2) && ao.equals(af2, af)) {
                            z2 = false;
                            ah = str3;
                            str = af;
                        } else {
                            z2 = true;
                            str2 = ai;
                            str = af2;
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
                        str3 = ah;
                        af = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.I(this.gxM) && v.I(this.gxP)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                boI();
                this.maskType = cVar.getMaskType();
            }
            if (this.grI == null) {
                this.grI = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.grI.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gxX = cVar.getUserAgreeInfo();
            this.gxJ = cVar.getLiveInfo();
            this.gxK = cVar.getLiveReplayInfo();
            this.gxY = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.I(user.gift_list)) {
            this.gxL = new g();
            this.gxL.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bqt() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gxM == null) {
                this.gxM = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gxE);
            this.gxE = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cYM = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cYK = z;
            cardPersonDynamicThreadData.cYJ = z2;
            cardPersonDynamicThreadData.cYL = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gxM.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bqt() || this.isHost) {
            if (this.gxP == null) {
                this.gxP = new ArrayList<>();
            }
            this.gxE = UtilHelper.getRandom(random, 3, this.gxE);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cYM = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cYK = false;
            cardPersonDynamicThreadData.cYJ = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gxE);
            this.gxP.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.I(list)) {
                if (this.gxM == null) {
                    this.gxM = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cYJ = z;
                dVar.sex = this.sex;
                dVar.cYC = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cYD = ao.ah(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cYD = ao.ah(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gxM.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bqs() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gxM == null) {
                this.gxM = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cYJ = z;
            bVar.cYC = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cYD = ao.ah(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gya = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gyb = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gxM.add(bVar);
            this.gxM.add(bB(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0210e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bqi() {
        if (this.gxH == null) {
            return null;
        }
        return this.gxH.getPhotoAlbum();
    }

    private void dv(List<ForumDynamic> list) {
        this.gxG = new c();
        this.gxG.gyd = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gyh = forumDynamic.user_thread_count.intValue();
                this.gxG.gyd.add(fVar);
            }
        }
    }

    private boolean bqs() {
        if (this.isHost) {
            return false;
        }
        if (this.gxC == 3) {
            return true;
        }
        return this.gxC == 2 && !this.gxB;
    }

    public boolean bqt() {
        if (this.isHost) {
            return false;
        }
        if (this.gxD == 3) {
            return true;
        }
        return this.gxD == 2 && !this.gxB;
    }

    protected com.baidu.tieba.person.d bB(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gmp = i;
        dVar.bdL = i2;
        return dVar;
    }

    public void bqu() {
        this.gxB = true;
        this.sex = 1;
        this.gxC = 1;
        this.gxD = 1;
        this.gxE = -1;
        this.mUserData = null;
        if (this.gxF != null) {
            this.gxF.clear();
        }
        this.gxF = null;
        this.gxG = null;
        this.gxH = null;
        this.gxI = null;
        this.gxL = null;
        this.mCardNullPolymericData = null;
        if (this.gxM != null) {
            this.gxM.clear();
        }
        if (this.gxP != null) {
            this.gxP.clear();
        }
        this.gxM = null;
        this.gxP = null;
        this.gxN.clear();
        this.gxX = null;
        this.gxY = null;
        this.maskType = 0;
        this.gxJ = null;
        if (this.gxK != null) {
            this.gxK.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData azX() {
        return this.aNL;
    }

    public AlaLiveInfoCoreData bqv() {
        return this.gxJ;
    }

    public List<AlaLiveInfoCoreData> bqw() {
        return this.gxK;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aMK() {
        return this.gxN;
    }

    public c bqx() {
        return this.gxG;
    }

    public g bqy() {
        return this.gxL;
    }

    public PersonUserGodInfo bqz() {
        return this.grI;
    }

    private void boI() {
        this.gxO.clear();
        this.gxS = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gxS.dqO = new Bundle();
        this.gxS.dqO.putBoolean("person_center_item_red_tip", true);
        this.gxS.gys.dqO = new Bundle();
        this.gxS.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(this.gxS);
        this.gxT = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gxT.dqO = new Bundle();
        this.gxT.dqO.putBoolean("person_center_item_red_tip", true);
        this.gxT.gys.dqO = new Bundle();
        this.gxT.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(this.gxT);
        this.gxQ = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gxQ.dqO = new Bundle();
        this.gxQ.dqO.putBoolean("person_center_item_red_tip", true);
        this.gxQ.gys.dqO = new Bundle();
        this.gxQ.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(this.gxQ);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.gys.dqO = new Bundle();
        X.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.dqO = new Bundle();
            X2.gys.dqO = new Bundle();
            X2.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gxO.add(X2);
        }
        if (this.gxW != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gxW.getManChannel() == 1) {
                this.gxR = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gxR.dqO = new Bundle();
                this.gxR.dqO.putBoolean("person_center_item_red_tip", true);
                this.gxR.gys.dqO = new Bundle();
                this.gxR.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gxO.add(this.gxR);
            }
        }
        this.gxU = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gxU.dqO = new Bundle();
        this.gxU.dqO.putBoolean("person_center_item_red_tip", true);
        this.gxU.gys.dqO = new Bundle();
        this.gxU.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(this.gxU);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.gys.dqO = new Bundle();
        X3.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.grJ != null) {
            X3.gys.dqO.putString("book_jump_link", this.grJ.gqC);
        }
        this.gxO.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.gys.dqO = new Bundle();
        X4.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.gys.dqO = new Bundle();
        X5.gys.dqO.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gxO.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.gys.dqO = new Bundle();
        X6.gys.dqO.putString("key_service_centre", "");
        this.gxO.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gys = new com.baidu.tieba.personCenter.c.a();
        nVar.gys.dqN = i3;
        return nVar;
    }
}
