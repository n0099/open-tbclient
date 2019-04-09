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
    private AntiData bWS;
    private PersonUserGodInfo hLC;
    private com.baidu.tieba.person.data.d hLD;
    public n hRA;
    public n hRB;
    public n hRC;
    public n hRD;
    private UserVideoChannelInfoData hRE;
    public UserAgreeInfo hRF;
    public NicknameInfo hRG;
    private ArrayList<com.baidu.adp.widget.ListView.m> hRn;
    private c hRo;
    private com.baidu.tieba.person.a.f hRp;
    private m hRq;
    private AlaLiveInfoCoreData hRr;
    private List<AlaLiveInfoCoreData> hRs;
    protected g hRt;
    protected List<com.baidu.adp.widget.ListView.m> hRu;
    protected ArrayList<com.baidu.adp.widget.ListView.m> hRx;
    public n hRy;
    public n hRz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean hRj = true;
    protected int sex = 1;
    private int hRk = 1;
    private int hRl = 1;
    private int hRm = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> hRv = new ArrayList<>();
    private ArrayList<n> hRw = new ArrayList<>();

    public abstract void bSf();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bwA() {
        return this.hRj;
    }

    public void oM(boolean z) {
        this.hRj = z;
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
            if (this.bWS == null) {
                this.bWS = new AntiData();
            }
            this.bWS.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.hRk = cVar.GetUser().priv_sets.like.intValue();
                    this.hRl = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.hRj = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.hRE == null) {
                this.hRE = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.hRE.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.hLD = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.T(cVar.getConcernedForumList()) && !this.isHost && !bSg()) {
                dI(cVar.getConcernedForumList());
            }
            if (this.hRt == null) {
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
            if (this.mCardNullPolymericData == null && v.T(this.hRu) && v.T(this.hRx)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bQx();
                this.maskType = cVar.getMaskType();
            }
            if (this.hLC == null) {
                this.hLC = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.hLC.parserProtobuf(cVar.getUserGodInfo());
            }
            this.hRF = cVar.getUserAgreeInfo();
            this.hRr = cVar.getLiveInfo();
            this.hRs = cVar.getLiveReplayInfo();
            this.hRG = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.T(user.gift_list)) {
            this.hRt = new g();
            this.hRt.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bSh() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.hRu == null) {
                this.hRu = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.hRm);
            this.hRm = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.emb = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.elZ = z;
            cardPersonDynamicThreadData.elY = z2;
            cardPersonDynamicThreadData.ema = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.hRu.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bSh() || this.isHost) {
            if (this.hRx == null) {
                this.hRx = new ArrayList<>();
            }
            this.hRm = UtilHelper.getRandom(random, 3, this.hRm);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.emb = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.elZ = false;
            cardPersonDynamicThreadData.elY = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.hRm);
            this.hRx.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.T(list)) {
                if (this.hRu == null) {
                    this.hRu = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.elY = z;
                dVar.sex = this.sex;
                dVar.elR = ap.aL(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.elS = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.elS = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.hRu.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bSg() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.hRu == null) {
                this.hRu = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.elY = z;
            bVar.elR = ap.aL(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.elS = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.hRI = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.hRJ = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.hRu.add(bVar);
            this.hRu.add(bY(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0277d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> bRW() {
        if (this.hRp == null) {
            return null;
        }
        return this.hRp.getPhotoAlbum();
    }

    private void dI(List<ForumDynamic> list) {
        this.hRo = new c();
        this.hRo.hRL = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.hRP = forumDynamic.user_thread_count.intValue();
                this.hRo.hRL.add(fVar);
            }
        }
    }

    private boolean bSg() {
        if (this.isHost) {
            return false;
        }
        if (this.hRk == 3) {
            return true;
        }
        return this.hRk == 2 && !this.hRj;
    }

    public boolean bSh() {
        if (this.isHost) {
            return false;
        }
        if (this.hRl == 3) {
            return true;
        }
        return this.hRl == 2 && !this.hRj;
    }

    protected com.baidu.tieba.person.d bY(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.hGj = i;
        dVar.coh = i2;
        return dVar;
    }

    public void bSi() {
        this.hRj = true;
        this.sex = 1;
        this.hRk = 1;
        this.hRl = 1;
        this.hRm = -1;
        this.mUserData = null;
        if (this.hRn != null) {
            this.hRn.clear();
        }
        this.hRn = null;
        this.hRo = null;
        this.hRp = null;
        this.hRq = null;
        this.hRt = null;
        this.mCardNullPolymericData = null;
        if (this.hRu != null) {
            this.hRu.clear();
        }
        if (this.hRx != null) {
            this.hRx.clear();
        }
        this.hRu = null;
        this.hRx = null;
        this.hRv.clear();
        this.hRF = null;
        this.hRG = null;
        this.maskType = 0;
        this.hRr = null;
        if (this.hRs != null) {
            this.hRs.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData bbG() {
        return this.bWS;
    }

    public AlaLiveInfoCoreData bSj() {
        return this.hRr;
    }

    public List<AlaLiveInfoCoreData> bSk() {
        return this.hRs;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> boy() {
        return this.hRv;
    }

    public c bSl() {
        return this.hRo;
    }

    public g bSm() {
        return this.hRt;
    }

    public PersonUserGodInfo bSn() {
        return this.hLC;
    }

    private void bQx() {
        this.hRw.clear();
        this.hRA = aa(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.hRA.eHm = new Bundle();
        this.hRA.eHm.putBoolean("person_center_item_red_tip", true);
        this.hRA.hSa.eHm = new Bundle();
        this.hRA.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(this.hRA);
        this.hRB = aa(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.hRB.eHm = new Bundle();
        this.hRB.eHm.putBoolean("person_center_item_red_tip", true);
        this.hRB.hSa.eHm = new Bundle();
        this.hRB.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(this.hRB);
        this.hRy = aa(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.hRy.eHm = new Bundle();
        this.hRy.eHm.putBoolean("person_center_item_red_tip", true);
        this.hRy.hSa.eHm = new Bundle();
        this.hRy.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(this.hRy);
        n aa = aa(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        aa.hSa.eHm = new Bundle();
        aa.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            aa2.eHm = new Bundle();
            aa2.hSa.eHm = new Bundle();
            aa2.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.hRw.add(aa2);
        }
        if (this.hRE != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.hRE.getManChannel() == 1) {
                this.hRz = aa(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.hRz.eHm = new Bundle();
                this.hRz.eHm.putBoolean("person_center_item_red_tip", true);
                this.hRz.hSa.eHm = new Bundle();
                this.hRz.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.hRw.add(this.hRz);
            }
        }
        this.hRC = aa(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.hRC.eHm = new Bundle();
        this.hRC.eHm.putBoolean("person_center_item_red_tip", true);
        this.hRC.hSa.eHm = new Bundle();
        this.hRC.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(this.hRC);
        n aa3 = aa(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        aa3.hSa.eHm = new Bundle();
        aa3.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.hLD != null) {
            aa3.hSa.eHm.putString("book_jump_link", this.hLD.hKv);
        }
        this.hRw.add(aa3);
        n aa4 = aa(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        aa4.hSa.eHm = new Bundle();
        aa4.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(aa4);
        n aa5 = aa(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        aa5.hSa.eHm = new Bundle();
        aa5.hSa.eHm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRw.add(aa5);
        n aa6 = aa(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        aa6.hSa.eHm = new Bundle();
        aa6.hSa.eHm.putString("key_service_centre", "");
        this.hRw.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.hSa = new com.baidu.tieba.personCenter.c.a();
        nVar.hSa.eHl = i3;
        return nVar;
    }
}
