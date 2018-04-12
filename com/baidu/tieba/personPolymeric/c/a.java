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
    private PersonUserGodInfo fDV;
    private com.baidu.tieba.person.data.d fDW;
    private ArrayList<com.baidu.adp.widget.ListView.h> fJR;
    private c fJS;
    private com.baidu.tieba.person.a.f fJT;
    private m fJU;
    private AlaLiveInfoCoreData fJV;
    private List<AlaLiveInfoCoreData> fJW;
    protected g fJX;
    protected List<com.baidu.adp.widget.ListView.h> fJY;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fKb;
    public n fKc;
    public n fKd;
    public n fKe;
    public n fKf;
    public n fKg;
    public n fKh;
    private UserVideoChannelInfoData fKi;
    public UserAgreeInfo fKj;
    public NicknameInfo fKk;
    private AntiData fcU;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fJN = true;
    protected int sex = 1;
    private int fJO = 1;
    private int fJP = 1;
    private int fJQ = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fJZ = new ArrayList<>();
    private ArrayList<n> fKa = new ArrayList<>();

    public abstract void bfw();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aHx() {
        return this.fJN;
    }

    public void li(boolean z) {
        this.fJN = z;
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
            if (this.fcU == null) {
                this.fcU = new AntiData();
            }
            this.fcU.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.fJO = cVar.GetUser().priv_sets.like.intValue();
                    this.fJP = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fJN = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fKi == null) {
                this.fKi = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fKi.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fDW = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.w(cVar.getConcernedForumList()) && !this.isHost && !bfx()) {
                cW(cVar.getConcernedForumList());
            }
            if (this.fJX == null) {
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
            if (this.mCardNullPolymericData == null && v.w(this.fJY) && v.w(this.fKb)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bdM();
                this.maskType = cVar.getMaskType();
            }
            if (this.fDV == null) {
                this.fDV = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fDV.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fKj = cVar.getUserAgreeInfo();
            this.fJV = cVar.getLiveInfo();
            this.fJW = cVar.getLiveReplayInfo();
            this.fKk = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.w(user.gift_list)) {
            this.fJX = new g();
            this.fJX.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bfy() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fJY == null) {
                this.fJY = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fJQ);
            this.fJQ = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.csI = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.csG = z;
            cardPersonDynamicThreadData.csF = z2;
            cardPersonDynamicThreadData.csH = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fJY.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bfy() || this.isHost) {
            if (this.fKb == null) {
                this.fKb = new ArrayList<>();
            }
            this.fJQ = UtilHelper.getRandom(random, 3, this.fJQ);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.csI = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.csG = false;
            cardPersonDynamicThreadData.csF = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fJQ);
            this.fKb.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.w(list)) {
                if (this.fJY == null) {
                    this.fJY = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.csF = z;
                dVar.sex = this.sex;
                dVar.csy = an.N(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.csz = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.csz = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fJY.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bfx() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fJY == null) {
                this.fJY = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.csF = z;
            bVar.csy = an.N(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.csz = an.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fKm = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fKn = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fJY.add(bVar);
            this.fJY.add(bv(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0126d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bfm() {
        if (this.fJT == null) {
            return null;
        }
        return this.fJT.getPhotoAlbum();
    }

    private void cW(List<ForumDynamic> list) {
        this.fJS = new c();
        this.fJS.fKp = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fKt = forumDynamic.user_thread_count.intValue();
                this.fJS.fKp.add(fVar);
            }
        }
    }

    private boolean bfx() {
        if (this.isHost) {
            return false;
        }
        if (this.fJO == 3) {
            return true;
        }
        return this.fJO == 2 && !this.fJN;
    }

    public boolean bfy() {
        if (this.isHost) {
            return false;
        }
        if (this.fJP == 3) {
            return true;
        }
        return this.fJP == 2 && !this.fJN;
    }

    protected com.baidu.tieba.person.d bv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fyI = i;
        dVar.aIp = i2;
        return dVar;
    }

    public void bfz() {
        this.fJN = true;
        this.sex = 1;
        this.fJO = 1;
        this.fJP = 1;
        this.fJQ = -1;
        this.mUserData = null;
        if (this.fJR != null) {
            this.fJR.clear();
        }
        this.fJR = null;
        this.fJS = null;
        this.fJT = null;
        this.fJU = null;
        this.fJX = null;
        this.mCardNullPolymericData = null;
        if (this.fJY != null) {
            this.fJY.clear();
        }
        if (this.fKb != null) {
            this.fKb.clear();
        }
        this.fJY = null;
        this.fKb = null;
        this.fJZ.clear();
        this.fKj = null;
        this.fKk = null;
        this.maskType = 0;
        this.fJV = null;
        if (this.fJW != null) {
            this.fJW.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData aWk() {
        return this.fcU;
    }

    public AlaLiveInfoCoreData bfA() {
        return this.fJV;
    }

    public List<AlaLiveInfoCoreData> bfB() {
        return this.fJW;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> azn() {
        return this.fJZ;
    }

    public c bfC() {
        return this.fJS;
    }

    public g bfD() {
        return this.fJX;
    }

    public PersonUserGodInfo bfE() {
        return this.fDV;
    }

    private void bdM() {
        this.fKa.clear();
        this.fKe = T(d.f.icon_starer_caise_heibai, d.k.mark, 20);
        this.fKe.cKg = new Bundle();
        this.fKe.cKg.putBoolean("person_center_item_red_tip", true);
        this.fKe.fKE.cKg = new Bundle();
        this.fKe.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(this.fKe);
        this.fKf = T(d.f.icon_lover_caise_heibai, d.k.contacts, 24);
        this.fKf.cKg = new Bundle();
        this.fKf.cKg.putBoolean("person_center_item_red_tip", true);
        this.fKf.fKE.cKg = new Bundle();
        this.fKf.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(this.fKf);
        this.fKc = T(d.f.icon_liwu_caise_heibai, d.k.gift, 34);
        this.fKc.cKg = new Bundle();
        this.fKc.cKg.putBoolean("person_center_item_red_tip", true);
        this.fKc.fKE.cKg = new Bundle();
        this.fKc.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(this.fKc);
        n T = T(d.f.icon_lishi_caise_heibai, d.k.history, 21);
        T.fKE.cKg = new Bundle();
        T.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n T2 = T(d.f.icon_zhibou_caise_heibai, d.k.ala_live, 29);
            T2.cKg = new Bundle();
            T2.fKE.cKg = new Bundle();
            T2.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fKa.add(T2);
        }
        if (this.fKi != null) {
            TiebaStatic.log(new al("c11956"));
            if (this.fKi.getManChannel() == 1) {
                this.fKd = T(d.f.icon_weibar_caise_heibai, d.k.frs_channel_tip, 30);
                this.fKd.cKg = new Bundle();
                this.fKd.cKg.putBoolean("person_center_item_red_tip", true);
                this.fKd.fKE.cKg = new Bundle();
                this.fKd.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fKa.add(this.fKd);
            }
        }
        this.fKg = T(d.f.icon_vip_heibai, d.k.member_center_item, 16);
        this.fKg.cKg = new Bundle();
        this.fKg.cKg.putBoolean("person_center_item_red_tip", true);
        this.fKg.fKE.cKg = new Bundle();
        this.fKg.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(this.fKg);
        n T3 = T(d.f.icon_bookshoop_caise_heibai, d.k.book_shel, 33);
        T3.fKE.cKg = new Bundle();
        T3.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fDW != null) {
            T3.fKE.cKg.putString("book_jump_link", this.fDW.fCT);
        }
        this.fKa.add(T3);
        n T4 = T(d.f.icon_kabao_caise_heibai, d.k.card_box, 35);
        T4.fKE.cKg = new Bundle();
        T4.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(T4);
        n T5 = T(d.f.icon_xiaofeijilu_caise_heibai, d.k.consumption_records, 17);
        T5.fKE.cKg = new Bundle();
        T5.fKE.cKg.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fKa.add(T5);
        n T6 = T(d.f.icon_fuwu_caise_heibai, d.k.person_service_centre, 41);
        T6.fKE.cKg = new Bundle();
        T6.fKE.cKg.putString("key_service_centre", "");
        this.fKa.add(T6);
    }

    private n T(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.fKE = new com.baidu.tieba.personCenter.c.a();
        nVar.fKE.cKf = i3;
        return nVar;
    }
}
