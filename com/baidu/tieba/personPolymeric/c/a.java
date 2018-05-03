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
    private PersonUserGodInfo fDS;
    private com.baidu.tieba.person.data.d fDT;
    private ArrayList<com.baidu.adp.widget.ListView.h> fJO;
    private c fJP;
    private com.baidu.tieba.person.a.f fJQ;
    private m fJR;
    private AlaLiveInfoCoreData fJS;
    private List<AlaLiveInfoCoreData> fJT;
    protected g fJU;
    protected List<com.baidu.adp.widget.ListView.h> fJV;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fJY;
    public n fJZ;
    public n fKa;
    public n fKb;
    public n fKc;
    public n fKd;
    public n fKe;
    private UserVideoChannelInfoData fKf;
    public UserAgreeInfo fKg;
    public NicknameInfo fKh;
    private AntiData fcR;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fJK = true;
    protected int sex = 1;
    private int fJL = 1;
    private int fJM = 1;
    private int fJN = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fJW = new ArrayList<>();
    private ArrayList<n> fJX = new ArrayList<>();

    public abstract void bfw();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aHx() {
        return this.fJK;
    }

    public void li(boolean z) {
        this.fJK = z;
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
            if (this.fcR == null) {
                this.fcR = new AntiData();
            }
            this.fcR.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.fJL = cVar.GetUser().priv_sets.like.intValue();
                    this.fJM = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fJK = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fKf == null) {
                this.fKf = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fKf.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fDT = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.w(cVar.getConcernedForumList()) && !this.isHost && !bfx()) {
                cW(cVar.getConcernedForumList());
            }
            if (this.fJU == null) {
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
            if (this.mCardNullPolymericData == null && v.w(this.fJV) && v.w(this.fJY)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bdM();
                this.maskType = cVar.getMaskType();
            }
            if (this.fDS == null) {
                this.fDS = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fDS.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fKg = cVar.getUserAgreeInfo();
            this.fJS = cVar.getLiveInfo();
            this.fJT = cVar.getLiveReplayInfo();
            this.fKh = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.w(user.gift_list)) {
            this.fJU = new g();
            this.fJU.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bfy() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fJV == null) {
                this.fJV = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fJN);
            this.fJN = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.csF = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.csD = z;
            cardPersonDynamicThreadData.csC = z2;
            cardPersonDynamicThreadData.csE = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fJV.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bfy() || this.isHost) {
            if (this.fJY == null) {
                this.fJY = new ArrayList<>();
            }
            this.fJN = UtilHelper.getRandom(random, 3, this.fJN);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.csF = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.csD = false;
            cardPersonDynamicThreadData.csC = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fJN);
            this.fJY.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.w(list)) {
                if (this.fJV == null) {
                    this.fJV = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.csC = z;
                dVar.sex = this.sex;
                dVar.csv = an.N(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.csw = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.csw = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fJV.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bfx() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fJV == null) {
                this.fJV = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.csC = z;
            bVar.csv = an.N(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.csw = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fKj = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fKk = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fJV.add(bVar);
            this.fJV.add(bu(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0126d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bfm() {
        if (this.fJQ == null) {
            return null;
        }
        return this.fJQ.getPhotoAlbum();
    }

    private void cW(List<ForumDynamic> list) {
        this.fJP = new c();
        this.fJP.fKm = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fKq = forumDynamic.user_thread_count.intValue();
                this.fJP.fKm.add(fVar);
            }
        }
    }

    private boolean bfx() {
        if (this.isHost) {
            return false;
        }
        if (this.fJL == 3) {
            return true;
        }
        return this.fJL == 2 && !this.fJK;
    }

    public boolean bfy() {
        if (this.isHost) {
            return false;
        }
        if (this.fJM == 3) {
            return true;
        }
        return this.fJM == 2 && !this.fJK;
    }

    protected com.baidu.tieba.person.d bu(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fyF = i;
        dVar.aIp = i2;
        return dVar;
    }

    public void bfz() {
        this.fJK = true;
        this.sex = 1;
        this.fJL = 1;
        this.fJM = 1;
        this.fJN = -1;
        this.mUserData = null;
        if (this.fJO != null) {
            this.fJO.clear();
        }
        this.fJO = null;
        this.fJP = null;
        this.fJQ = null;
        this.fJR = null;
        this.fJU = null;
        this.mCardNullPolymericData = null;
        if (this.fJV != null) {
            this.fJV.clear();
        }
        if (this.fJY != null) {
            this.fJY.clear();
        }
        this.fJV = null;
        this.fJY = null;
        this.fJW.clear();
        this.fKg = null;
        this.fKh = null;
        this.maskType = 0;
        this.fJS = null;
        if (this.fJT != null) {
            this.fJT.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData aWk() {
        return this.fcR;
    }

    public AlaLiveInfoCoreData bfA() {
        return this.fJS;
    }

    public List<AlaLiveInfoCoreData> bfB() {
        return this.fJT;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> azn() {
        return this.fJW;
    }

    public c bfC() {
        return this.fJP;
    }

    public g bfD() {
        return this.fJU;
    }

    public PersonUserGodInfo bfE() {
        return this.fDS;
    }

    private void bdM() {
        this.fJX.clear();
        this.fKb = T(d.f.icon_starer_caise_heibai, d.k.mark, 20);
        this.fKb.cKd = new Bundle();
        this.fKb.cKd.putBoolean("person_center_item_red_tip", true);
        this.fKb.fKB.cKd = new Bundle();
        this.fKb.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(this.fKb);
        this.fKc = T(d.f.icon_lover_caise_heibai, d.k.contacts, 24);
        this.fKc.cKd = new Bundle();
        this.fKc.cKd.putBoolean("person_center_item_red_tip", true);
        this.fKc.fKB.cKd = new Bundle();
        this.fKc.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(this.fKc);
        this.fJZ = T(d.f.icon_liwu_caise_heibai, d.k.gift, 34);
        this.fJZ.cKd = new Bundle();
        this.fJZ.cKd.putBoolean("person_center_item_red_tip", true);
        this.fJZ.fKB.cKd = new Bundle();
        this.fJZ.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(this.fJZ);
        n T = T(d.f.icon_lishi_caise_heibai, d.k.history, 21);
        T.fKB.cKd = new Bundle();
        T.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n T2 = T(d.f.icon_zhibou_caise_heibai, d.k.ala_live, 29);
            T2.cKd = new Bundle();
            T2.fKB.cKd = new Bundle();
            T2.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fJX.add(T2);
        }
        if (this.fKf != null) {
            TiebaStatic.log(new al("c11956"));
            if (this.fKf.getManChannel() == 1) {
                this.fKa = T(d.f.icon_weibar_caise_heibai, d.k.frs_channel_tip, 30);
                this.fKa.cKd = new Bundle();
                this.fKa.cKd.putBoolean("person_center_item_red_tip", true);
                this.fKa.fKB.cKd = new Bundle();
                this.fKa.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fJX.add(this.fKa);
            }
        }
        this.fKd = T(d.f.icon_vip_heibai, d.k.member_center_item, 16);
        this.fKd.cKd = new Bundle();
        this.fKd.cKd.putBoolean("person_center_item_red_tip", true);
        this.fKd.fKB.cKd = new Bundle();
        this.fKd.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(this.fKd);
        n T3 = T(d.f.icon_bookshoop_caise_heibai, d.k.book_shel, 33);
        T3.fKB.cKd = new Bundle();
        T3.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fDT != null) {
            T3.fKB.cKd.putString("book_jump_link", this.fDT.fCQ);
        }
        this.fJX.add(T3);
        n T4 = T(d.f.icon_kabao_caise_heibai, d.k.card_box, 35);
        T4.fKB.cKd = new Bundle();
        T4.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(T4);
        n T5 = T(d.f.icon_xiaofeijilu_caise_heibai, d.k.consumption_records, 17);
        T5.fKB.cKd = new Bundle();
        T5.fKB.cKd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fJX.add(T5);
        n T6 = T(d.f.icon_fuwu_caise_heibai, d.k.person_service_centre, 41);
        T6.fKB.cKd = new Bundle();
        T6.fKB.cKd.putString("key_service_centre", "");
        this.fJX.add(T6);
    }

    private n T(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.fKB = new com.baidu.tieba.personCenter.c.a();
        nVar.fKB.cKc = i3;
        return nVar;
    }
}
