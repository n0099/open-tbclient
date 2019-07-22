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
    private AntiData cfT;
    private PersonUserGodInfo ijY;
    private com.baidu.tieba.person.data.d ijZ;
    private List<AlaLiveInfoCoreData> iqA;
    protected g iqB;
    protected List<com.baidu.adp.widget.ListView.m> iqC;
    protected ArrayList<com.baidu.adp.widget.ListView.m> iqF;
    public n iqG;
    public n iqH;
    public n iqI;
    public n iqJ;
    public n iqK;
    public n iqL;
    private UserVideoChannelInfoData iqM;
    public UserAgreeInfo iqN;
    public NicknameInfo iqO;
    private ArrayList<com.baidu.adp.widget.ListView.m> iqv;
    private c iqw;
    private com.baidu.tieba.person.a.f iqx;
    private m iqy;
    private AlaLiveInfoCoreData iqz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean iqr = true;
    protected int sex = 1;
    private int iqs = 1;
    private int iqt = 1;
    private int iqu = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> iqD = new ArrayList<>();
    private ArrayList<n> iqE = new ArrayList<>();

    public abstract void ccZ();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bGT() {
        return this.iqr;
    }

    public void pQ(boolean z) {
        this.iqr = z;
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
            if (this.cfT == null) {
                this.cfT = new AntiData();
            }
            this.cfT.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.iqs = cVar.GetUser().priv_sets.like.intValue();
                    this.iqt = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.iqr = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.iqM == null) {
                this.iqM = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.iqM.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.ijZ = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.aa(cVar.getConcernedForumList()) && !this.isHost && !cda()) {
                dU(cVar.getConcernedForumList());
            }
            if (this.iqB == null) {
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
            if (this.mCardNullPolymericData == null && v.aa(this.iqC) && v.aa(this.iqF)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cbj();
                this.maskType = cVar.getMaskType();
            }
            if (this.ijY == null) {
                this.ijY = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.ijY.parserProtobuf(cVar.getUserGodInfo());
            }
            this.iqN = cVar.getUserAgreeInfo();
            this.iqz = cVar.getLiveInfo();
            this.iqA = cVar.getLiveReplayInfo();
            this.iqO = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.iqB = new g();
            this.iqB.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cdb() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.iqC == null) {
                this.iqC = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.iqu);
            this.iqu = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eGL = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eGJ = z;
            cardPersonDynamicThreadData.eGI = z2;
            cardPersonDynamicThreadData.eGK = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.iqC.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cdb() || this.isHost) {
            if (this.iqF == null) {
                this.iqF = new ArrayList<>();
            }
            this.iqu = UtilHelper.getRandom(random, 3, this.iqu);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eGL = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eGJ = false;
            cardPersonDynamicThreadData.eGI = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.iqu);
            this.iqF.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.aa(list)) {
                if (this.iqC == null) {
                    this.iqC = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eGI = z;
                dVar.sex = this.sex;
                dVar.eGB = aq.bb(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eGC = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eGC = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.iqC.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cda() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.iqC == null) {
                this.iqC = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eGI = z;
            bVar.eGB = aq.bb(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eGC = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.iqQ = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.iqR = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.iqC.add(bVar);
            this.iqC.add(cl(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> ccQ() {
        if (this.iqx == null) {
            return null;
        }
        return this.iqx.getPhotoAlbum();
    }

    private void dU(List<ForumDynamic> list) {
        this.iqw = new c();
        this.iqw.iqT = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.iqX = forumDynamic.user_thread_count.intValue();
                this.iqw.iqT.add(fVar);
            }
        }
    }

    private boolean cda() {
        if (this.isHost) {
            return false;
        }
        if (this.iqs == 3) {
            return true;
        }
        return this.iqs == 2 && !this.iqr;
    }

    public boolean cdb() {
        if (this.isHost) {
            return false;
        }
        if (this.iqt == 3) {
            return true;
        }
        return this.iqt == 2 && !this.iqr;
    }

    protected com.baidu.tieba.person.d cl(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.ieD = i;
        dVar.cxE = i2;
        return dVar;
    }

    public void cdc() {
        this.iqr = true;
        this.sex = 1;
        this.iqs = 1;
        this.iqt = 1;
        this.iqu = -1;
        this.mUserData = null;
        if (this.iqv != null) {
            this.iqv.clear();
        }
        this.iqv = null;
        this.iqw = null;
        this.iqx = null;
        this.iqy = null;
        this.iqB = null;
        this.mCardNullPolymericData = null;
        if (this.iqC != null) {
            this.iqC.clear();
        }
        if (this.iqF != null) {
            this.iqF.clear();
        }
        this.iqC = null;
        this.iqF = null;
        this.iqD.clear();
        this.iqN = null;
        this.iqO = null;
        this.maskType = 0;
        this.iqz = null;
        if (this.iqA != null) {
            this.iqA.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData blb() {
        return this.cfT;
    }

    public AlaLiveInfoCoreData cdd() {
        return this.iqz;
    }

    public List<AlaLiveInfoCoreData> cde() {
        return this.iqA;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> byJ() {
        return this.iqD;
    }

    public c cdf() {
        return this.iqw;
    }

    public g cdg() {
        return this.iqB;
    }

    public PersonUserGodInfo cdh() {
        return this.ijY;
    }

    private void cbj() {
        this.iqE.clear();
        this.iqI = ac(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.iqI.azf = new Bundle();
        this.iqI.azf.putBoolean("person_center_item_red_tip", true);
        this.iqI.iri.azf = new Bundle();
        this.iqI.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(this.iqI);
        this.iqJ = ac(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.iqJ.azf = new Bundle();
        this.iqJ.azf.putBoolean("person_center_item_red_tip", true);
        this.iqJ.iri.azf = new Bundle();
        this.iqJ.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(this.iqJ);
        this.iqG = ac(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.iqG.azf = new Bundle();
        this.iqG.azf.putBoolean("person_center_item_red_tip", true);
        this.iqG.iri.azf = new Bundle();
        this.iqG.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(this.iqG);
        n ac = ac(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ac.iri.azf = new Bundle();
        ac.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(ac);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ac2 = ac(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ac2.azf = new Bundle();
            ac2.iri.azf = new Bundle();
            ac2.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.iqE.add(ac2);
        }
        if (this.iqM != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.iqM.getManChannel() == 1) {
                this.iqH = ac(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.iqH.azf = new Bundle();
                this.iqH.azf.putBoolean("person_center_item_red_tip", true);
                this.iqH.iri.azf = new Bundle();
                this.iqH.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.iqE.add(this.iqH);
            }
        }
        this.iqK = ac(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.iqK.azf = new Bundle();
        this.iqK.azf.putBoolean("person_center_item_red_tip", true);
        this.iqK.iri.azf = new Bundle();
        this.iqK.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(this.iqK);
        n ac3 = ac(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        ac3.iri.azf = new Bundle();
        ac3.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.ijZ != null) {
            ac3.iri.azf.putString("book_jump_link", this.ijZ.iiQ);
        }
        this.iqE.add(ac3);
        n ac4 = ac(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        ac4.iri.azf = new Bundle();
        ac4.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(ac4);
        n ac5 = ac(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ac5.iri.azf = new Bundle();
        ac5.iri.azf.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iqE.add(ac5);
        n ac6 = ac(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        ac6.iri.azf = new Bundle();
        ac6.iri.azf.putString("key_service_centre", "");
        this.iqE.add(ac6);
    }

    private n ac(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iki = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.iri = new com.baidu.tieba.personCenter.c.a();
        nVar.iri.fcx = i3;
        return nVar;
    }
}
