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
import com.baidu.tbadk.core.util.ap;
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
/* loaded from: classes6.dex */
public abstract class a {
    private AntiData bWP;
    private PersonUserGodInfo hLP;
    private com.baidu.tieba.person.data.d hLQ;
    private ArrayList<com.baidu.adp.widget.ListView.m> hRA;
    private c hRB;
    private com.baidu.tieba.person.a.f hRC;
    private m hRD;
    private AlaLiveInfoCoreData hRE;
    private List<AlaLiveInfoCoreData> hRF;
    protected g hRG;
    protected List<com.baidu.adp.widget.ListView.m> hRH;
    protected ArrayList<com.baidu.adp.widget.ListView.m> hRK;
    public n hRL;
    public n hRM;
    public n hRN;
    public n hRO;
    public n hRP;
    public n hRQ;
    private UserVideoChannelInfoData hRR;
    public UserAgreeInfo hRS;
    public NicknameInfo hRT;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean hRw = true;
    protected int sex = 1;
    private int hRx = 1;
    private int hRy = 1;
    private int hRz = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> hRI = new ArrayList<>();
    private ArrayList<n> hRJ = new ArrayList<>();

    public abstract void bSj();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bwD() {
        return this.hRw;
    }

    public void oM(boolean z) {
        this.hRw = z;
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
            if (this.bWP == null) {
                this.bWP = new AntiData();
            }
            this.bWP.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.hRx = cVar.GetUser().priv_sets.like.intValue();
                    this.hRy = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.hRw = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.hRR == null) {
                this.hRR = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.hRR.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.hLQ = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.T(cVar.getConcernedForumList()) && !this.isHost && !bSk()) {
                dL(cVar.getConcernedForumList());
            }
            if (this.hRG == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.T(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String aI = ap.aI(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.T(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String aI2 = ap.aI(longValue);
                        String aL = ap.aL(longValue);
                        String aK = ap.aK(longValue);
                        if (ap.equals(aI2, aI)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ap.equals(aK, str3) && ap.equals(aL, str2) && ap.equals(aI2, aI)) {
                            z2 = false;
                            aK = str3;
                            str = aI;
                        } else {
                            z2 = true;
                            str2 = aL;
                            str = aI2;
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
                        str3 = aK;
                        aI = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.T(this.hRH) && v.T(this.hRK)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bQB();
                this.maskType = cVar.getMaskType();
            }
            if (this.hLP == null) {
                this.hLP = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.hLP.parserProtobuf(cVar.getUserGodInfo());
            }
            this.hRS = cVar.getUserAgreeInfo();
            this.hRE = cVar.getLiveInfo();
            this.hRF = cVar.getLiveReplayInfo();
            this.hRT = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.T(user.gift_list)) {
            this.hRG = new g();
            this.hRG.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bSl() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.hRH == null) {
                this.hRH = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.hRz);
            this.hRz = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.emo = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.emm = z;
            cardPersonDynamicThreadData.eml = z2;
            cardPersonDynamicThreadData.emn = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.hRH.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bSl() || this.isHost) {
            if (this.hRK == null) {
                this.hRK = new ArrayList<>();
            }
            this.hRz = UtilHelper.getRandom(random, 3, this.hRz);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.emo = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.emm = false;
            cardPersonDynamicThreadData.eml = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.hRz);
            this.hRK.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.T(list)) {
                if (this.hRH == null) {
                    this.hRH = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eml = z;
                dVar.sex = this.sex;
                dVar.eme = ap.aL(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.emf = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.emf = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.hRH.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bSk() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.hRH == null) {
                this.hRH = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eml = z;
            bVar.eme = ap.aL(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.emf = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.hRV = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.hRW = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.hRH.add(bVar);
            this.hRH.add(bY(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0277d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> bSa() {
        if (this.hRC == null) {
            return null;
        }
        return this.hRC.getPhotoAlbum();
    }

    private void dL(List<ForumDynamic> list) {
        this.hRB = new c();
        this.hRB.hRY = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.hSc = forumDynamic.user_thread_count.intValue();
                this.hRB.hRY.add(fVar);
            }
        }
    }

    private boolean bSk() {
        if (this.isHost) {
            return false;
        }
        if (this.hRx == 3) {
            return true;
        }
        return this.hRx == 2 && !this.hRw;
    }

    public boolean bSl() {
        if (this.isHost) {
            return false;
        }
        if (this.hRy == 3) {
            return true;
        }
        return this.hRy == 2 && !this.hRw;
    }

    protected com.baidu.tieba.person.d bY(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.hGw = i;
        dVar.coe = i2;
        return dVar;
    }

    public void bSm() {
        this.hRw = true;
        this.sex = 1;
        this.hRx = 1;
        this.hRy = 1;
        this.hRz = -1;
        this.mUserData = null;
        if (this.hRA != null) {
            this.hRA.clear();
        }
        this.hRA = null;
        this.hRB = null;
        this.hRC = null;
        this.hRD = null;
        this.hRG = null;
        this.mCardNullPolymericData = null;
        if (this.hRH != null) {
            this.hRH.clear();
        }
        if (this.hRK != null) {
            this.hRK.clear();
        }
        this.hRH = null;
        this.hRK = null;
        this.hRI.clear();
        this.hRS = null;
        this.hRT = null;
        this.maskType = 0;
        this.hRE = null;
        if (this.hRF != null) {
            this.hRF.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData bbI() {
        return this.bWP;
    }

    public AlaLiveInfoCoreData bSn() {
        return this.hRE;
    }

    public List<AlaLiveInfoCoreData> bSo() {
        return this.hRF;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> boB() {
        return this.hRI;
    }

    public c bSp() {
        return this.hRB;
    }

    public g bSq() {
        return this.hRG;
    }

    public PersonUserGodInfo bSr() {
        return this.hLP;
    }

    private void bQB() {
        this.hRJ.clear();
        this.hRN = aa(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.hRN.eHz = new Bundle();
        this.hRN.eHz.putBoolean("person_center_item_red_tip", true);
        this.hRN.hSn.eHz = new Bundle();
        this.hRN.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(this.hRN);
        this.hRO = aa(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.hRO.eHz = new Bundle();
        this.hRO.eHz.putBoolean("person_center_item_red_tip", true);
        this.hRO.hSn.eHz = new Bundle();
        this.hRO.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(this.hRO);
        this.hRL = aa(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.hRL.eHz = new Bundle();
        this.hRL.eHz.putBoolean("person_center_item_red_tip", true);
        this.hRL.hSn.eHz = new Bundle();
        this.hRL.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(this.hRL);
        n aa = aa(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        aa.hSn.eHz = new Bundle();
        aa.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            aa2.eHz = new Bundle();
            aa2.hSn.eHz = new Bundle();
            aa2.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.hRJ.add(aa2);
        }
        if (this.hRR != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.hRR.getManChannel() == 1) {
                this.hRM = aa(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.hRM.eHz = new Bundle();
                this.hRM.eHz.putBoolean("person_center_item_red_tip", true);
                this.hRM.hSn.eHz = new Bundle();
                this.hRM.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.hRJ.add(this.hRM);
            }
        }
        this.hRP = aa(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.hRP.eHz = new Bundle();
        this.hRP.eHz.putBoolean("person_center_item_red_tip", true);
        this.hRP.hSn.eHz = new Bundle();
        this.hRP.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(this.hRP);
        n aa3 = aa(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        aa3.hSn.eHz = new Bundle();
        aa3.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.hLQ != null) {
            aa3.hSn.eHz.putString("book_jump_link", this.hLQ.hKI);
        }
        this.hRJ.add(aa3);
        n aa4 = aa(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        aa4.hSn.eHz = new Bundle();
        aa4.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(aa4);
        n aa5 = aa(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        aa5.hSn.eHz = new Bundle();
        aa5.hSn.eHz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRJ.add(aa5);
        n aa6 = aa(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        aa6.hSn.eHz = new Bundle();
        aa6.hSn.eHz.putString("key_service_centre", "");
        this.hRJ.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.hSn = new com.baidu.tieba.personCenter.c.a();
        nVar.hSn.eHy = i3;
        return nVar;
    }
}
