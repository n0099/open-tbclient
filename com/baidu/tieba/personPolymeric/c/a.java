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
    private AntiData bWR;
    private PersonUserGodInfo hLB;
    private com.baidu.tieba.person.data.d hLC;
    public n hRA;
    public n hRB;
    public n hRC;
    private UserVideoChannelInfoData hRD;
    public UserAgreeInfo hRE;
    public NicknameInfo hRF;
    private ArrayList<com.baidu.adp.widget.ListView.m> hRm;
    private c hRn;
    private com.baidu.tieba.person.a.f hRo;
    private m hRp;
    private AlaLiveInfoCoreData hRq;
    private List<AlaLiveInfoCoreData> hRr;
    protected g hRs;
    protected List<com.baidu.adp.widget.ListView.m> hRt;
    protected ArrayList<com.baidu.adp.widget.ListView.m> hRw;
    public n hRx;
    public n hRy;
    public n hRz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean hRi = true;
    protected int sex = 1;
    private int hRj = 1;
    private int hRk = 1;
    private int hRl = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> hRu = new ArrayList<>();
    private ArrayList<n> hRv = new ArrayList<>();

    public abstract void bSf();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bwA() {
        return this.hRi;
    }

    public void oM(boolean z) {
        this.hRi = z;
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
            if (this.bWR == null) {
                this.bWR = new AntiData();
            }
            this.bWR.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.hRj = cVar.GetUser().priv_sets.like.intValue();
                    this.hRk = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.hRi = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.hRD == null) {
                this.hRD = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.hRD.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.hLC = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.T(cVar.getConcernedForumList()) && !this.isHost && !bSg()) {
                dI(cVar.getConcernedForumList());
            }
            if (this.hRs == null) {
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
            if (this.mCardNullPolymericData == null && v.T(this.hRt) && v.T(this.hRw)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bQx();
                this.maskType = cVar.getMaskType();
            }
            if (this.hLB == null) {
                this.hLB = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.hLB.parserProtobuf(cVar.getUserGodInfo());
            }
            this.hRE = cVar.getUserAgreeInfo();
            this.hRq = cVar.getLiveInfo();
            this.hRr = cVar.getLiveReplayInfo();
            this.hRF = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.T(user.gift_list)) {
            this.hRs = new g();
            this.hRs.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bSh() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.hRt == null) {
                this.hRt = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.hRl);
            this.hRl = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ema = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.elY = z;
            cardPersonDynamicThreadData.elX = z2;
            cardPersonDynamicThreadData.elZ = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.hRt.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bSh() || this.isHost) {
            if (this.hRw == null) {
                this.hRw = new ArrayList<>();
            }
            this.hRl = UtilHelper.getRandom(random, 3, this.hRl);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ema = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.elY = false;
            cardPersonDynamicThreadData.elX = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.hRl);
            this.hRw.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.T(list)) {
                if (this.hRt == null) {
                    this.hRt = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.elX = z;
                dVar.sex = this.sex;
                dVar.elQ = ap.aL(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.elR = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.elR = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.hRt.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bSg() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.hRt == null) {
                this.hRt = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.elX = z;
            bVar.elQ = ap.aL(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.elR = ap.aK(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.hRH = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.hRI = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.hRt.add(bVar);
            this.hRt.add(bY(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0277d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> bRW() {
        if (this.hRo == null) {
            return null;
        }
        return this.hRo.getPhotoAlbum();
    }

    private void dI(List<ForumDynamic> list) {
        this.hRn = new c();
        this.hRn.hRK = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.hRO = forumDynamic.user_thread_count.intValue();
                this.hRn.hRK.add(fVar);
            }
        }
    }

    private boolean bSg() {
        if (this.isHost) {
            return false;
        }
        if (this.hRj == 3) {
            return true;
        }
        return this.hRj == 2 && !this.hRi;
    }

    public boolean bSh() {
        if (this.isHost) {
            return false;
        }
        if (this.hRk == 3) {
            return true;
        }
        return this.hRk == 2 && !this.hRi;
    }

    protected com.baidu.tieba.person.d bY(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.hGi = i;
        dVar.cog = i2;
        return dVar;
    }

    public void bSi() {
        this.hRi = true;
        this.sex = 1;
        this.hRj = 1;
        this.hRk = 1;
        this.hRl = -1;
        this.mUserData = null;
        if (this.hRm != null) {
            this.hRm.clear();
        }
        this.hRm = null;
        this.hRn = null;
        this.hRo = null;
        this.hRp = null;
        this.hRs = null;
        this.mCardNullPolymericData = null;
        if (this.hRt != null) {
            this.hRt.clear();
        }
        if (this.hRw != null) {
            this.hRw.clear();
        }
        this.hRt = null;
        this.hRw = null;
        this.hRu.clear();
        this.hRE = null;
        this.hRF = null;
        this.maskType = 0;
        this.hRq = null;
        if (this.hRr != null) {
            this.hRr.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData bbG() {
        return this.bWR;
    }

    public AlaLiveInfoCoreData bSj() {
        return this.hRq;
    }

    public List<AlaLiveInfoCoreData> bSk() {
        return this.hRr;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> boy() {
        return this.hRu;
    }

    public c bSl() {
        return this.hRn;
    }

    public g bSm() {
        return this.hRs;
    }

    public PersonUserGodInfo bSn() {
        return this.hLB;
    }

    private void bQx() {
        this.hRv.clear();
        this.hRz = aa(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.hRz.eHl = new Bundle();
        this.hRz.eHl.putBoolean("person_center_item_red_tip", true);
        this.hRz.hRZ.eHl = new Bundle();
        this.hRz.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(this.hRz);
        this.hRA = aa(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.hRA.eHl = new Bundle();
        this.hRA.eHl.putBoolean("person_center_item_red_tip", true);
        this.hRA.hRZ.eHl = new Bundle();
        this.hRA.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(this.hRA);
        this.hRx = aa(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.hRx.eHl = new Bundle();
        this.hRx.eHl.putBoolean("person_center_item_red_tip", true);
        this.hRx.hRZ.eHl = new Bundle();
        this.hRx.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(this.hRx);
        n aa = aa(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        aa.hRZ.eHl = new Bundle();
        aa.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            aa2.eHl = new Bundle();
            aa2.hRZ.eHl = new Bundle();
            aa2.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.hRv.add(aa2);
        }
        if (this.hRD != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.hRD.getManChannel() == 1) {
                this.hRy = aa(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.hRy.eHl = new Bundle();
                this.hRy.eHl.putBoolean("person_center_item_red_tip", true);
                this.hRy.hRZ.eHl = new Bundle();
                this.hRy.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.hRv.add(this.hRy);
            }
        }
        this.hRB = aa(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.hRB.eHl = new Bundle();
        this.hRB.eHl.putBoolean("person_center_item_red_tip", true);
        this.hRB.hRZ.eHl = new Bundle();
        this.hRB.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(this.hRB);
        n aa3 = aa(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        aa3.hRZ.eHl = new Bundle();
        aa3.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.hLC != null) {
            aa3.hRZ.eHl.putString("book_jump_link", this.hLC.hKu);
        }
        this.hRv.add(aa3);
        n aa4 = aa(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        aa4.hRZ.eHl = new Bundle();
        aa4.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(aa4);
        n aa5 = aa(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        aa5.hRZ.eHl = new Bundle();
        aa5.hRZ.eHl.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.hRv.add(aa5);
        n aa6 = aa(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        aa6.hRZ.eHl = new Bundle();
        aa6.hRZ.eHl.putString("key_service_centre", "");
        this.hRv.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.hRZ = new com.baidu.tieba.personCenter.c.a();
        nVar.hRZ.eHk = i3;
        return nVar;
    }
}
