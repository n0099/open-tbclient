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
    private AntiData aET;
    private PersonUserGodInfo gbQ;
    private com.baidu.tieba.person.data.d gbR;
    private ArrayList<com.baidu.adp.widget.ListView.h> ghO;
    private c ghP;
    private com.baidu.tieba.person.a.f ghQ;
    private m ghR;
    private AlaLiveInfoCoreData ghS;
    private List<AlaLiveInfoCoreData> ghT;
    protected g ghU;
    protected List<com.baidu.adp.widget.ListView.h> ghV;
    protected ArrayList<com.baidu.adp.widget.ListView.h> ghY;
    public n ghZ;
    public n gia;
    public n gib;
    public n gic;
    public n gie;
    public n gif;
    private UserVideoChannelInfoData gig;
    public UserAgreeInfo gih;
    public NicknameInfo gii;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ghK = true;
    protected int sex = 1;
    private int ghL = 1;
    private int ghM = 1;
    private int ghN = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> ghW = new ArrayList<>();
    private ArrayList<n> ghX = new ArrayList<>();

    public abstract void blS();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aQi() {
        return this.ghK;
    }

    public void lH(boolean z) {
        this.ghK = z;
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
            if (this.aET == null) {
                this.aET = new AntiData();
            }
            this.aET.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.ghL = cVar.GetUser().priv_sets.like.intValue();
                    this.ghM = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ghK = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gig == null) {
                this.gig = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gig.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gbR = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.z(cVar.getConcernedForumList()) && !this.isHost && !blT()) {
                df(cVar.getConcernedForumList());
            }
            if (this.ghU == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.z(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String U = ao.U(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.z(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String U2 = ao.U(longValue);
                        String X = ao.X(longValue);
                        String W = ao.W(longValue);
                        if (ao.equals(U2, U)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(W, str3) && ao.equals(X, str2) && ao.equals(U2, U)) {
                            z2 = false;
                            W = str3;
                            str = U;
                        } else {
                            z2 = true;
                            str2 = X;
                            str = U2;
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
                        str3 = W;
                        U = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.z(this.ghV) && v.z(this.ghY)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bkj();
                this.maskType = cVar.getMaskType();
            }
            if (this.gbQ == null) {
                this.gbQ = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gbQ.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gih = cVar.getUserAgreeInfo();
            this.ghS = cVar.getLiveInfo();
            this.ghT = cVar.getLiveReplayInfo();
            this.gii = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.z(user.gift_list)) {
            this.ghU = new g();
            this.ghU.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!blU() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.ghV == null) {
                this.ghV = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.ghN);
            this.ghN = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cIG = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cIE = z;
            cardPersonDynamicThreadData.cID = z2;
            cardPersonDynamicThreadData.cIF = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.ghV.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!blU() || this.isHost) {
            if (this.ghY == null) {
                this.ghY = new ArrayList<>();
            }
            this.ghN = UtilHelper.getRandom(random, 3, this.ghN);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cIG = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cIE = false;
            cardPersonDynamicThreadData.cID = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.ghN);
            this.ghY.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.z(list)) {
                if (this.ghV == null) {
                    this.ghV = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cID = z;
                dVar.sex = this.sex;
                dVar.cIw = ao.X(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cIx = ao.W(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cIx = ao.W(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.ghV.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!blT() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.ghV == null) {
                this.ghV = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cID = z;
            bVar.cIw = ao.X(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cIx = ao.W(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gik = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gil = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.ghV.add(bVar);
            this.ghV.add(by(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0141e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> blJ() {
        if (this.ghQ == null) {
            return null;
        }
        return this.ghQ.getPhotoAlbum();
    }

    private void df(List<ForumDynamic> list) {
        this.ghP = new c();
        this.ghP.gin = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gir = forumDynamic.user_thread_count.intValue();
                this.ghP.gin.add(fVar);
            }
        }
    }

    private boolean blT() {
        if (this.isHost) {
            return false;
        }
        if (this.ghL == 3) {
            return true;
        }
        return this.ghL == 2 && !this.ghK;
    }

    public boolean blU() {
        if (this.isHost) {
            return false;
        }
        if (this.ghM == 3) {
            return true;
        }
        return this.ghM == 2 && !this.ghK;
    }

    protected com.baidu.tieba.person.d by(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fWA = i;
        dVar.aVb = i2;
        return dVar;
    }

    public void blV() {
        this.ghK = true;
        this.sex = 1;
        this.ghL = 1;
        this.ghM = 1;
        this.ghN = -1;
        this.mUserData = null;
        if (this.ghO != null) {
            this.ghO.clear();
        }
        this.ghO = null;
        this.ghP = null;
        this.ghQ = null;
        this.ghR = null;
        this.ghU = null;
        this.mCardNullPolymericData = null;
        if (this.ghV != null) {
            this.ghV.clear();
        }
        if (this.ghY != null) {
            this.ghY.clear();
        }
        this.ghV = null;
        this.ghY = null;
        this.ghW.clear();
        this.gih = null;
        this.gii = null;
        this.maskType = 0;
        this.ghS = null;
        if (this.ghT != null) {
            this.ghT.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData avt() {
        return this.aET;
    }

    public AlaLiveInfoCoreData blW() {
        return this.ghS;
    }

    public List<AlaLiveInfoCoreData> blX() {
        return this.ghT;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aIc() {
        return this.ghW;
    }

    public c blY() {
        return this.ghP;
    }

    public g blZ() {
        return this.ghU;
    }

    public PersonUserGodInfo bma() {
        return this.gbQ;
    }

    private void bkj() {
        this.ghX.clear();
        this.gib = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gib.daW = new Bundle();
        this.gib.daW.putBoolean("person_center_item_red_tip", true);
        this.gib.giC.daW = new Bundle();
        this.gib.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(this.gib);
        this.gic = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gic.daW = new Bundle();
        this.gic.daW.putBoolean("person_center_item_red_tip", true);
        this.gic.giC.daW = new Bundle();
        this.gic.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(this.gic);
        this.ghZ = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.ghZ.daW = new Bundle();
        this.ghZ.daW.putBoolean("person_center_item_red_tip", true);
        this.ghZ.giC.daW = new Bundle();
        this.ghZ.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(this.ghZ);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.giC.daW = new Bundle();
        X.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.daW = new Bundle();
            X2.giC.daW = new Bundle();
            X2.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ghX.add(X2);
        }
        if (this.gig != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gig.getManChannel() == 1) {
                this.gia = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gia.daW = new Bundle();
                this.gia.daW.putBoolean("person_center_item_red_tip", true);
                this.gia.giC.daW = new Bundle();
                this.gia.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.ghX.add(this.gia);
            }
        }
        this.gie = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gie.daW = new Bundle();
        this.gie.daW.putBoolean("person_center_item_red_tip", true);
        this.gie.giC.daW = new Bundle();
        this.gie.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(this.gie);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.giC.daW = new Bundle();
        X3.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gbR != null) {
            X3.giC.daW.putString("book_jump_link", this.gbR.gaN);
        }
        this.ghX.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.giC.daW = new Bundle();
        X4.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.giC.daW = new Bundle();
        X5.giC.daW.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ghX.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.giC.daW = new Bundle();
        X6.giC.daW.putString("key_service_centre", "");
        this.ghX.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.giC = new com.baidu.tieba.personCenter.c.a();
        nVar.giC.daV = i3;
        return nVar;
    }
}
