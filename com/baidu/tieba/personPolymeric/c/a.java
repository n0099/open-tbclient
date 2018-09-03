package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.f;
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
    private AntiData aBN;
    private PersonUserGodInfo fUA;
    private com.baidu.tieba.person.data.d fUB;
    private m gaA;
    private AlaLiveInfoCoreData gaB;
    private List<AlaLiveInfoCoreData> gaC;
    protected g gaD;
    protected List<com.baidu.adp.widget.ListView.h> gaE;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gaH;
    public n gaI;
    public n gaJ;
    public n gaK;
    public n gaL;
    public n gaM;
    public n gaN;
    private UserVideoChannelInfoData gaO;
    public UserAgreeInfo gaP;
    public NicknameInfo gaQ;
    private ArrayList<com.baidu.adp.widget.ListView.h> gax;
    private c gay;
    private com.baidu.tieba.person.a.f gaz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gat = true;
    protected int sex = 1;
    private int gau = 1;
    private int gav = 1;
    private int gaw = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gaF = new ArrayList<>();
    private ArrayList<n> gaG = new ArrayList<>();

    public abstract void bjr();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aNT() {
        return this.gat;
    }

    public void ll(boolean z) {
        this.gat = z;
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
            if (this.aBN == null) {
                this.aBN = new AntiData();
            }
            this.aBN.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gau = cVar.GetUser().priv_sets.like.intValue();
                    this.gav = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gat = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gaO == null) {
                this.gaO = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gaO.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fUB = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!w.z(cVar.getConcernedForumList()) && !this.isHost && !bjs()) {
                de(cVar.getConcernedForumList());
            }
            if (this.gaD == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !w.z(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String Q = ap.Q(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!w.z(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String Q2 = ap.Q(longValue);
                        String T = ap.T(longValue);
                        String S = ap.S(longValue);
                        if (ap.equals(Q2, Q)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ap.equals(S, str3) && ap.equals(T, str2) && ap.equals(Q2, Q)) {
                            z2 = false;
                            S = str3;
                            str = Q;
                        } else {
                            z2 = true;
                            str2 = T;
                            str = Q2;
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
                        str3 = S;
                        Q = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && w.z(this.gaE) && w.z(this.gaH)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bhI();
                this.maskType = cVar.getMaskType();
            }
            if (this.fUA == null) {
                this.fUA = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fUA.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gaP = cVar.getUserAgreeInfo();
            this.gaB = cVar.getLiveInfo();
            this.gaC = cVar.getLiveReplayInfo();
            this.gaQ = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !w.z(user.gift_list)) {
            this.gaD = new g();
            this.gaD.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bjt() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gaE == null) {
                this.gaE = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gaw);
            this.gaw = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cCP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cCN = z;
            cardPersonDynamicThreadData.cCM = z2;
            cardPersonDynamicThreadData.cCO = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gaE.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bjt() || this.isHost) {
            if (this.gaH == null) {
                this.gaH = new ArrayList<>();
            }
            this.gaw = UtilHelper.getRandom(random, 3, this.gaw);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cCP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cCN = false;
            cardPersonDynamicThreadData.cCM = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gaw);
            this.gaH.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!w.z(list)) {
                if (this.gaE == null) {
                    this.gaE = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cCM = z;
                dVar.sex = this.sex;
                dVar.cCF = ap.T(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cCG = ap.S(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cCG = ap.S(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gaE.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bjs() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gaE == null) {
                this.gaE = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cCM = z;
            bVar.cCF = ap.T(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cCG = ap.S(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gaS = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gaT = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gaE.add(bVar);
            this.gaE.add(bw(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), f.e.ds1), f.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bji() {
        if (this.gaz == null) {
            return null;
        }
        return this.gaz.getPhotoAlbum();
    }

    private void de(List<ForumDynamic> list) {
        this.gay = new c();
        this.gay.gaV = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gaZ = forumDynamic.user_thread_count.intValue();
                this.gay.gaV.add(fVar);
            }
        }
    }

    private boolean bjs() {
        if (this.isHost) {
            return false;
        }
        if (this.gau == 3) {
            return true;
        }
        return this.gau == 2 && !this.gat;
    }

    public boolean bjt() {
        if (this.isHost) {
            return false;
        }
        if (this.gav == 3) {
            return true;
        }
        return this.gav == 2 && !this.gat;
    }

    protected com.baidu.tieba.person.d bw(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fPk = i;
        dVar.aRL = i2;
        return dVar;
    }

    public void bju() {
        this.gat = true;
        this.sex = 1;
        this.gau = 1;
        this.gav = 1;
        this.gaw = -1;
        this.mUserData = null;
        if (this.gax != null) {
            this.gax.clear();
        }
        this.gax = null;
        this.gay = null;
        this.gaz = null;
        this.gaA = null;
        this.gaD = null;
        this.mCardNullPolymericData = null;
        if (this.gaE != null) {
            this.gaE.clear();
        }
        if (this.gaH != null) {
            this.gaH.clear();
        }
        this.gaE = null;
        this.gaH = null;
        this.gaF.clear();
        this.gaP = null;
        this.gaQ = null;
        this.maskType = 0;
        this.gaB = null;
        if (this.gaC != null) {
            this.gaC.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData Cb() {
        return this.aBN;
    }

    public AlaLiveInfoCoreData bjv() {
        return this.gaB;
    }

    public List<AlaLiveInfoCoreData> bjw() {
        return this.gaC;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aFN() {
        return this.gaF;
    }

    public c bjx() {
        return this.gay;
    }

    public g bjy() {
        return this.gaD;
    }

    public PersonUserGodInfo bjz() {
        return this.fUA;
    }

    private void bhI() {
        this.gaG.clear();
        this.gaK = S(f.C0146f.icon_starer_caise_heibai, f.j.mark, 20);
        this.gaK.cVd = new Bundle();
        this.gaK.cVd.putBoolean("person_center_item_red_tip", true);
        this.gaK.gbk.cVd = new Bundle();
        this.gaK.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaK);
        this.gaL = S(f.C0146f.icon_lover_caise_heibai, f.j.contacts, 24);
        this.gaL.cVd = new Bundle();
        this.gaL.cVd.putBoolean("person_center_item_red_tip", true);
        this.gaL.gbk.cVd = new Bundle();
        this.gaL.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaL);
        this.gaI = S(f.C0146f.icon_liwu_caise_heibai, f.j.gift, 34);
        this.gaI.cVd = new Bundle();
        this.gaI.cVd.putBoolean("person_center_item_red_tip", true);
        this.gaI.gbk.cVd = new Bundle();
        this.gaI.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaI);
        n S = S(f.C0146f.icon_lishi_caise_heibai, f.j.history, 21);
        S.gbk.cVd = new Bundle();
        S.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(S);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n S2 = S(f.C0146f.icon_zhibou_caise_heibai, f.j.ala_live, 29);
            S2.cVd = new Bundle();
            S2.gbk.cVd = new Bundle();
            S2.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gaG.add(S2);
        }
        if (this.gaO != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.gaO.getManChannel() == 1) {
                this.gaJ = S(f.C0146f.icon_weibar_caise_heibai, f.j.frs_channel_tip, 30);
                this.gaJ.cVd = new Bundle();
                this.gaJ.cVd.putBoolean("person_center_item_red_tip", true);
                this.gaJ.gbk.cVd = new Bundle();
                this.gaJ.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gaG.add(this.gaJ);
            }
        }
        this.gaM = S(f.C0146f.icon_vip_heibai, f.j.member_center_item, 16);
        this.gaM.cVd = new Bundle();
        this.gaM.cVd.putBoolean("person_center_item_red_tip", true);
        this.gaM.gbk.cVd = new Bundle();
        this.gaM.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaM);
        n S3 = S(f.C0146f.icon_bookshoop_caise_heibai, f.j.book_shel, 33);
        S3.gbk.cVd = new Bundle();
        S3.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fUB != null) {
            S3.gbk.cVd.putString("book_jump_link", this.fUB.fTx);
        }
        this.gaG.add(S3);
        n S4 = S(f.C0146f.icon_kabao_caise_heibai, f.j.card_box, 35);
        S4.gbk.cVd = new Bundle();
        S4.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(S4);
        n S5 = S(f.C0146f.icon_xiaofeijilu_caise_heibai, f.j.consumption_records, 17);
        S5.gbk.cVd = new Bundle();
        S5.gbk.cVd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(S5);
        n S6 = S(f.C0146f.icon_fuwu_caise_heibai, f.j.person_service_centre, 41);
        S6.gbk.cVd = new Bundle();
        S6.gbk.cVd.putString("key_service_centre", "");
        this.gaG.add(S6);
    }

    private n S(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gbk = new com.baidu.tieba.personCenter.c.a();
        nVar.gbk.cVc = i3;
        return nVar;
    }
}
