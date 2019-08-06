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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
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
    private AntiData cga;
    private PersonUserGodInfo ila;
    private com.baidu.tieba.person.data.d ilb;
    private c irA;
    private com.baidu.tieba.person.a.f irB;
    private m irC;
    private AlaLiveInfoCoreData irD;
    private List<AlaLiveInfoCoreData> irE;
    protected g irF;
    protected List<com.baidu.adp.widget.ListView.m> irG;
    protected ArrayList<com.baidu.adp.widget.ListView.m> irJ;
    public n irK;
    public n irL;
    public n irM;
    public n irN;
    public n irO;
    public n irP;
    private UserVideoChannelInfoData irQ;
    public UserAgreeInfo irR;
    public NicknameInfo irS;
    private ArrayList<com.baidu.adp.widget.ListView.m> irz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean irv = true;
    protected int sex = 1;
    private int irw = 1;
    private int irx = 1;
    private int iry = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> irH = new ArrayList<>();
    private ArrayList<n> irI = new ArrayList<>();

    public abstract void cdr();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bHh() {
        return this.irv;
    }

    public void pR(boolean z) {
        this.irv = z;
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
            if (this.cga == null) {
                this.cga = new AntiData();
            }
            this.cga.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.irw = cVar.GetUser().priv_sets.like.intValue();
                    this.irx = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.irv = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.irQ == null) {
                this.irQ = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.irQ.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.ilb = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.aa(cVar.getConcernedForumList()) && !this.isHost && !cds()) {
                dT(cVar.getConcernedForumList());
            }
            if (this.irF == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.aa(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String aY = aq.aY(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.aa(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String aY2 = aq.aY(longValue);
                        String bb = aq.bb(longValue);
                        String ba = aq.ba(longValue);
                        if (aq.bV(aY2, aY)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (aq.bV(ba, str3) && aq.bV(bb, str2) && aq.bV(aY2, aY)) {
                            z2 = false;
                            ba = str3;
                            str = aY;
                        } else {
                            z2 = true;
                            str2 = bb;
                            str = aY2;
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
                        str3 = ba;
                        aY = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.aa(this.irG) && v.aa(this.irJ)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cbB();
                this.maskType = cVar.getMaskType();
            }
            if (this.ila == null) {
                this.ila = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.ila.parserProtobuf(cVar.getUserGodInfo());
            }
            this.irR = cVar.getUserAgreeInfo();
            this.irD = cVar.getLiveInfo();
            this.irE = cVar.getLiveReplayInfo();
            this.irS = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.irF = new g();
            this.irF.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cdt() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.irG == null) {
                this.irG = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.iry);
            this.iry = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eGS = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eGQ = z;
            cardPersonDynamicThreadData.eGP = z2;
            cardPersonDynamicThreadData.eGR = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.irG.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cdt() || this.isHost) {
            if (this.irJ == null) {
                this.irJ = new ArrayList<>();
            }
            this.iry = UtilHelper.getRandom(random, 3, this.iry);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eGS = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eGQ = false;
            cardPersonDynamicThreadData.eGP = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.iry);
            this.irJ.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.aa(list)) {
                if (this.irG == null) {
                    this.irG = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eGP = z;
                dVar.sex = this.sex;
                dVar.eGI = aq.bb(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eGJ = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eGJ = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.irG.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cds() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.irG == null) {
                this.irG = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eGP = z;
            bVar.eGI = aq.bb(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eGJ = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.irU = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.irV = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.irG.add(bVar);
            this.irG.add(cl(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cdi() {
        if (this.irB == null) {
            return null;
        }
        return this.irB.getPhotoAlbum();
    }

    private void dT(List<ForumDynamic> list) {
        this.irA = new c();
        this.irA.irX = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.isb = forumDynamic.user_thread_count.intValue();
                this.irA.irX.add(fVar);
            }
        }
    }

    private boolean cds() {
        if (this.isHost) {
            return false;
        }
        if (this.irw == 3) {
            return true;
        }
        return this.irw == 2 && !this.irv;
    }

    public boolean cdt() {
        if (this.isHost) {
            return false;
        }
        if (this.irx == 3) {
            return true;
        }
        return this.irx == 2 && !this.irv;
    }

    protected com.baidu.tieba.person.d cl(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.ifF = i;
        dVar.cxL = i2;
        return dVar;
    }

    public void cdu() {
        this.irv = true;
        this.sex = 1;
        this.irw = 1;
        this.irx = 1;
        this.iry = -1;
        this.mUserData = null;
        if (this.irz != null) {
            this.irz.clear();
        }
        this.irz = null;
        this.irA = null;
        this.irB = null;
        this.irC = null;
        this.irF = null;
        this.mCardNullPolymericData = null;
        if (this.irG != null) {
            this.irG.clear();
        }
        if (this.irJ != null) {
            this.irJ.clear();
        }
        this.irG = null;
        this.irJ = null;
        this.irH.clear();
        this.irR = null;
        this.irS = null;
        this.maskType = 0;
        this.irD = null;
        if (this.irE != null) {
            this.irE.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData bli() {
        return this.cga;
    }

    public AlaLiveInfoCoreData cdv() {
        return this.irD;
    }

    public List<AlaLiveInfoCoreData> cdw() {
        return this.irE;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> byX() {
        return this.irH;
    }

    public c cdx() {
        return this.irA;
    }

    public g cdy() {
        return this.irF;
    }

    public PersonUserGodInfo cdz() {
        return this.ila;
    }

    private void cbB() {
        this.irI.clear();
        this.irM = ac(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.irM.azf = new Bundle();
        this.irM.azf.putBoolean("person_center_item_red_tip", true);
        this.irM.ism.azf = new Bundle();
        this.irM.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(this.irM);
        this.irN = ac(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.irN.azf = new Bundle();
        this.irN.azf.putBoolean("person_center_item_red_tip", true);
        this.irN.ism.azf = new Bundle();
        this.irN.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(this.irN);
        this.irK = ac(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.irK.azf = new Bundle();
        this.irK.azf.putBoolean("person_center_item_red_tip", true);
        this.irK.ism.azf = new Bundle();
        this.irK.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(this.irK);
        n ac = ac(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ac.ism.azf = new Bundle();
        ac.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(ac);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ac2 = ac(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ac2.azf = new Bundle();
            ac2.ism.azf = new Bundle();
            ac2.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.irI.add(ac2);
        }
        if (this.irQ != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.irQ.getManChannel() == 1) {
                this.irL = ac(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.irL.azf = new Bundle();
                this.irL.azf.putBoolean("person_center_item_red_tip", true);
                this.irL.ism.azf = new Bundle();
                this.irL.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.irI.add(this.irL);
            }
        }
        this.irO = ac(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.irO.azf = new Bundle();
        this.irO.azf.putBoolean("person_center_item_red_tip", true);
        this.irO.ism.azf = new Bundle();
        this.irO.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(this.irO);
        n ac3 = ac(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        ac3.ism.azf = new Bundle();
        ac3.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.ilb != null) {
            ac3.ism.azf.putString("book_jump_link", this.ilb.ijS);
        }
        this.irI.add(ac3);
        n ac4 = ac(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        ac4.ism.azf = new Bundle();
        ac4.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(ac4);
        n ac5 = ac(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ac5.ism.azf = new Bundle();
        ac5.ism.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.irI.add(ac5);
        n ac6 = ac(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        ac6.ism.azf = new Bundle();
        ac6.ism.azf.putString("key_service_centre", "");
        this.irI.add(ac6);
    }

    private n ac(int i, int i2, int i3) {
        n nVar = new n();
        nVar.ilk = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.ism = new com.baidu.tieba.personCenter.c.a();
        nVar.ism.fcX = i3;
        return nVar;
    }
}
