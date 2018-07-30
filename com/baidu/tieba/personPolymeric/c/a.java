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
    private AntiData aBQ;
    private PersonUserGodInfo fUG;
    private com.baidu.tieba.person.data.d fUH;
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

    public abstract void bju();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aNW() {
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
            if (this.aBQ == null) {
                this.aBQ = new AntiData();
            }
            this.aBQ.parserProtobuf(cVar.GetAntiStat());
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
                this.fUH = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!w.z(cVar.getConcernedForumList()) && !this.isHost && !bjv()) {
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
                bhL();
                this.maskType = cVar.getMaskType();
            }
            if (this.fUG == null) {
                this.fUG = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fUG.parserProtobuf(cVar.getUserGodInfo());
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
        if ((!bjw() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gaE == null) {
                this.gaE = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gaw);
            this.gaw = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cCS = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cCQ = z;
            cardPersonDynamicThreadData.cCP = z2;
            cardPersonDynamicThreadData.cCR = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gaE.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bjw() || this.isHost) {
            if (this.gaH == null) {
                this.gaH = new ArrayList<>();
            }
            this.gaw = UtilHelper.getRandom(random, 3, this.gaw);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cCS = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cCQ = false;
            cardPersonDynamicThreadData.cCP = false;
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
                dVar.cCP = z;
                dVar.sex = this.sex;
                dVar.cCI = ap.T(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cCJ = ap.S(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cCJ = ap.S(dynamicInfo.dynamic_timestamp.longValue() * 1000);
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
        if ((!bjv() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gaE == null) {
                this.gaE = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cCP = z;
            bVar.cCI = ap.T(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cCJ = ap.S(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gaS = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gaT = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gaE.add(bVar);
            this.gaE.add(bw(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0140d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bjl() {
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

    private boolean bjv() {
        if (this.isHost) {
            return false;
        }
        if (this.gau == 3) {
            return true;
        }
        return this.gau == 2 && !this.gat;
    }

    public boolean bjw() {
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
        dVar.fPs = i;
        dVar.aRO = i2;
        return dVar;
    }

    public void bjx() {
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

    public AntiData Ce() {
        return this.aBQ;
    }

    public AlaLiveInfoCoreData bjy() {
        return this.gaB;
    }

    public List<AlaLiveInfoCoreData> bjz() {
        return this.gaC;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aFQ() {
        return this.gaF;
    }

    public c bjA() {
        return this.gay;
    }

    public g bjB() {
        return this.gaD;
    }

    public PersonUserGodInfo bjC() {
        return this.fUG;
    }

    private void bhL() {
        this.gaG.clear();
        this.gaK = S(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.gaK.cVh = new Bundle();
        this.gaK.cVh.putBoolean("person_center_item_red_tip", true);
        this.gaK.gbk.cVh = new Bundle();
        this.gaK.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaK);
        this.gaL = S(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.gaL.cVh = new Bundle();
        this.gaL.cVh.putBoolean("person_center_item_red_tip", true);
        this.gaL.gbk.cVh = new Bundle();
        this.gaL.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaL);
        this.gaI = S(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.gaI.cVh = new Bundle();
        this.gaI.cVh.putBoolean("person_center_item_red_tip", true);
        this.gaI.gbk.cVh = new Bundle();
        this.gaI.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaI);
        n S = S(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        S.gbk.cVh = new Bundle();
        S.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(S);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n S2 = S(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            S2.cVh = new Bundle();
            S2.gbk.cVh = new Bundle();
            S2.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gaG.add(S2);
        }
        if (this.gaO != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.gaO.getManChannel() == 1) {
                this.gaJ = S(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.gaJ.cVh = new Bundle();
                this.gaJ.cVh.putBoolean("person_center_item_red_tip", true);
                this.gaJ.gbk.cVh = new Bundle();
                this.gaJ.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gaG.add(this.gaJ);
            }
        }
        this.gaM = S(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.gaM.cVh = new Bundle();
        this.gaM.cVh.putBoolean("person_center_item_red_tip", true);
        this.gaM.gbk.cVh = new Bundle();
        this.gaM.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(this.gaM);
        n S3 = S(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        S3.gbk.cVh = new Bundle();
        S3.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fUH != null) {
            S3.gbk.cVh.putString("book_jump_link", this.fUH.fTF);
        }
        this.gaG.add(S3);
        n S4 = S(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        S4.gbk.cVh = new Bundle();
        S4.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(S4);
        n S5 = S(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        S5.gbk.cVh = new Bundle();
        S5.gbk.cVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gaG.add(S5);
        n S6 = S(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        S6.gbk.cVh = new Bundle();
        S6.gbk.cVh.putString("key_service_centre", "");
        this.gaG.add(S6);
    }

    private n S(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gbk = new com.baidu.tieba.personCenter.c.a();
        nVar.gbk.cVg = i3;
        return nVar;
    }
}
