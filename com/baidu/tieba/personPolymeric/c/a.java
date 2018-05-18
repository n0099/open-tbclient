package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
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
    private PersonUserGodInfo fEY;
    private com.baidu.tieba.person.data.d fEZ;
    private ArrayList<com.baidu.adp.widget.ListView.h> fKU;
    private c fKV;
    private com.baidu.tieba.person.a.f fKW;
    private m fKX;
    private AlaLiveInfoCoreData fKY;
    private List<AlaLiveInfoCoreData> fKZ;
    protected g fLa;
    protected List<com.baidu.adp.widget.ListView.h> fLb;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fLe;
    public n fLf;
    public n fLg;
    public n fLh;
    public n fLi;
    public n fLj;
    public n fLk;
    private UserVideoChannelInfoData fLl;
    public UserAgreeInfo fLm;
    public NicknameInfo fLn;
    private AntiData fdY;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fKQ = true;
    protected int sex = 1;
    private int fKR = 1;
    private int fKS = 1;
    private int fKT = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fLc = new ArrayList<>();
    private ArrayList<n> fLd = new ArrayList<>();

    public abstract void bfw();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aHv() {
        return this.fKQ;
    }

    public void lj(boolean z) {
        this.fKQ = z;
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
            if (this.fdY == null) {
                this.fdY = new AntiData();
            }
            this.fdY.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.fKR = cVar.GetUser().priv_sets.like.intValue();
                    this.fKS = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fKQ = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fLl == null) {
                this.fLl = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fLl.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fEZ = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.w(cVar.getConcernedForumList()) && !this.isHost && !bfx()) {
                cZ(cVar.getConcernedForumList());
            }
            if (this.fLa == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.w(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String K = an.K(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.w(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String K2 = an.K(longValue);
                        String N = an.N(longValue);
                        String M = an.M(longValue);
                        if (an.equals(K2, K)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (an.equals(M, str3) && an.equals(N, str2) && an.equals(K2, K)) {
                            z2 = false;
                            M = str3;
                            str = K;
                        } else {
                            z2 = true;
                            str2 = N;
                            str = K2;
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
                        str3 = M;
                        K = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.w(this.fLb) && v.w(this.fLe)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bdM();
                this.maskType = cVar.getMaskType();
            }
            if (this.fEY == null) {
                this.fEY = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fEY.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fLm = cVar.getUserAgreeInfo();
            this.fKY = cVar.getLiveInfo();
            this.fKZ = cVar.getLiveReplayInfo();
            this.fLn = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.w(user.gift_list)) {
            this.fLa = new g();
            this.fLa.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bfy() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fLb == null) {
                this.fLb = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fKT);
            this.fKT = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ctP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.ctN = z;
            cardPersonDynamicThreadData.ctM = z2;
            cardPersonDynamicThreadData.ctO = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fLb.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bfy() || this.isHost) {
            if (this.fLe == null) {
                this.fLe = new ArrayList<>();
            }
            this.fKT = UtilHelper.getRandom(random, 3, this.fKT);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ctP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.ctN = false;
            cardPersonDynamicThreadData.ctM = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fKT);
            this.fLe.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.w(list)) {
                if (this.fLb == null) {
                    this.fLb = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.ctM = z;
                dVar.sex = this.sex;
                dVar.ctF = an.N(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.ctG = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.ctG = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fLb.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bfx() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fLb == null) {
                this.fLb = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.ctM = z;
            bVar.ctF = an.N(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.ctG = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fLp = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fLq = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fLb.add(bVar);
            this.fLb.add(bu(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0126d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bfm() {
        if (this.fKW == null) {
            return null;
        }
        return this.fKW.getPhotoAlbum();
    }

    private void cZ(List<ForumDynamic> list) {
        this.fKV = new c();
        this.fKV.fLs = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fLw = forumDynamic.user_thread_count.intValue();
                this.fKV.fLs.add(fVar);
            }
        }
    }

    private boolean bfx() {
        if (this.isHost) {
            return false;
        }
        if (this.fKR == 3) {
            return true;
        }
        return this.fKR == 2 && !this.fKQ;
    }

    public boolean bfy() {
        if (this.isHost) {
            return false;
        }
        if (this.fKS == 3) {
            return true;
        }
        return this.fKS == 2 && !this.fKQ;
    }

    protected com.baidu.tieba.person.d bu(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fzL = i;
        dVar.aIq = i2;
        return dVar;
    }

    public void bfz() {
        this.fKQ = true;
        this.sex = 1;
        this.fKR = 1;
        this.fKS = 1;
        this.fKT = -1;
        this.mUserData = null;
        if (this.fKU != null) {
            this.fKU.clear();
        }
        this.fKU = null;
        this.fKV = null;
        this.fKW = null;
        this.fKX = null;
        this.fLa = null;
        this.mCardNullPolymericData = null;
        if (this.fLb != null) {
            this.fLb.clear();
        }
        if (this.fLe != null) {
            this.fLe.clear();
        }
        this.fLb = null;
        this.fLe = null;
        this.fLc.clear();
        this.fLm = null;
        this.fLn = null;
        this.maskType = 0;
        this.fKY = null;
        if (this.fKZ != null) {
            this.fKZ.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData aWk() {
        return this.fdY;
    }

    public AlaLiveInfoCoreData bfA() {
        return this.fKY;
    }

    public List<AlaLiveInfoCoreData> bfB() {
        return this.fKZ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> azl() {
        return this.fLc;
    }

    public c bfC() {
        return this.fKV;
    }

    public g bfD() {
        return this.fLa;
    }

    public PersonUserGodInfo bfE() {
        return this.fEY;
    }

    private void bdM() {
        this.fLd.clear();
        this.fLh = T(d.f.icon_starer_caise_heibai, d.k.mark, 20);
        this.fLh.cLm = new Bundle();
        this.fLh.cLm.putBoolean("person_center_item_red_tip", true);
        this.fLh.fLH.cLm = new Bundle();
        this.fLh.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(this.fLh);
        this.fLi = T(d.f.icon_lover_caise_heibai, d.k.contacts, 24);
        this.fLi.cLm = new Bundle();
        this.fLi.cLm.putBoolean("person_center_item_red_tip", true);
        this.fLi.fLH.cLm = new Bundle();
        this.fLi.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(this.fLi);
        this.fLf = T(d.f.icon_liwu_caise_heibai, d.k.gift, 34);
        this.fLf.cLm = new Bundle();
        this.fLf.cLm.putBoolean("person_center_item_red_tip", true);
        this.fLf.fLH.cLm = new Bundle();
        this.fLf.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(this.fLf);
        n T = T(d.f.icon_lishi_caise_heibai, d.k.history, 21);
        T.fLH.cLm = new Bundle();
        T.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n T2 = T(d.f.icon_zhibou_caise_heibai, d.k.ala_live, 29);
            T2.cLm = new Bundle();
            T2.fLH.cLm = new Bundle();
            T2.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fLd.add(T2);
        }
        if (this.fLl != null) {
            TiebaStatic.log(new al("c11956"));
            if (this.fLl.getManChannel() == 1) {
                this.fLg = T(d.f.icon_weibar_caise_heibai, d.k.frs_channel_tip, 30);
                this.fLg.cLm = new Bundle();
                this.fLg.cLm.putBoolean("person_center_item_red_tip", true);
                this.fLg.fLH.cLm = new Bundle();
                this.fLg.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fLd.add(this.fLg);
            }
        }
        this.fLj = T(d.f.icon_vip_heibai, d.k.member_center_item, 16);
        this.fLj.cLm = new Bundle();
        this.fLj.cLm.putBoolean("person_center_item_red_tip", true);
        this.fLj.fLH.cLm = new Bundle();
        this.fLj.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(this.fLj);
        n T3 = T(d.f.icon_bookshoop_caise_heibai, d.k.book_shel, 33);
        T3.fLH.cLm = new Bundle();
        T3.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fEZ != null) {
            T3.fLH.cLm.putString("book_jump_link", this.fEZ.fDW);
        }
        this.fLd.add(T3);
        n T4 = T(d.f.icon_kabao_caise_heibai, d.k.card_box, 35);
        T4.fLH.cLm = new Bundle();
        T4.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(T4);
        n T5 = T(d.f.icon_xiaofeijilu_caise_heibai, d.k.consumption_records, 17);
        T5.fLH.cLm = new Bundle();
        T5.fLH.cLm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fLd.add(T5);
        n T6 = T(d.f.icon_fuwu_caise_heibai, d.k.person_service_centre, 41);
        T6.fLH.cLm = new Bundle();
        T6.fLH.cLm.putString("key_service_centre", "");
        this.fLd.add(T6);
    }

    private n T(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.fLH = new com.baidu.tieba.personCenter.c.a();
        nVar.fLH.cLl = i3;
        return nVar;
    }
}
