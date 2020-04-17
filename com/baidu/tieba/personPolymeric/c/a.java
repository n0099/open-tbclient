package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
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
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes11.dex */
public abstract class a {
    private AntiData dMz;
    public MetaData drK;
    protected boolean isHost;
    private PersonUserGodInfo jTn;
    private com.baidu.tieba.person.data.d jTp;
    public n kaA;
    public n kaB;
    public UserAgreeInfo kaC;
    public NicknameInfo kaD;
    public User kaE;
    private ArrayList<com.baidu.adp.widget.ListView.m> kak;
    private c kal;
    private com.baidu.tieba.person.a.f kam;
    private m kan;
    private AlaLiveInfoCoreData kao;
    private com.baidu.tieba.i.a kap;
    private List<AlaLiveInfoCoreData> kaq;
    protected g kar;
    protected List<com.baidu.adp.widget.ListView.m> kas;
    protected ArrayList<com.baidu.adp.widget.ListView.m> kaw;
    public n kax;
    public n kay;
    public n kaz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean kag = true;
    protected int sex = 1;
    private int kah = 1;
    private int kai = 1;
    private int kaj = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> kat = new ArrayList<>();
    private ArrayList<n> kau = new ArrayList<>();
    private List<bj> kaF = new ArrayList();

    public abstract void cIh();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cjw() {
        return this.kag;
    }

    public void sD(boolean z) {
        this.kag = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.kaE = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.kaE);
            if (this.drK == null) {
                this.drK = new MetaData();
            }
            this.drK.parserProtobuf(this.kaE);
            if (this.jTn == null) {
                this.jTn = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jTn.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dMz == null) {
                this.dMz = new AntiData();
            }
            this.dMz.parserProtobuf(cVar.GetAntiStat());
            if (this.kaE != null) {
                if (this.kaE.priv_sets != null) {
                    this.kah = this.kaE.priv_sets.like.intValue();
                    this.kai = this.kaE.priv_sets.post.intValue();
                }
                this.sex = this.kaE.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.kag = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jTp = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cIi()) {
                ec(cVar.getConcernedForumList());
            }
            if (this.kar == null) {
                c(this.kaE);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.kaE, postInfoList, random);
                    }
                }
            }
            String yearBytime = aq.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = aq.getYearBytime(longValue);
                        String chineseMonthBytime = aq.getChineseMonthBytime(longValue);
                        String dateBytime = aq.getDateBytime(longValue);
                        if (aq.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (aq.equals(dateBytime, str3) && aq.equals(chineseMonthBytime, str2) && aq.equals(yearBytime2, yearBytime)) {
                            z2 = false;
                            chineseMonthBytime = str2;
                            str = str3;
                        } else {
                            z2 = true;
                            str = dateBytime;
                            yearBytime = yearBytime2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(this.kaE, dynamicInfo, random, z, z2, z3);
                                break;
                            case 2:
                                a(dynamicInfo, z2);
                                break;
                            case 3:
                                b(dynamicInfo, z2);
                                break;
                        }
                        z3 = false;
                        str3 = str;
                        str2 = chineseMonthBytime;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.isEmpty(this.kas) && v.isEmpty(this.kaw)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cGp();
                this.maskType = cVar.getMaskType();
            }
            this.kaC = cVar.getUserAgreeInfo();
            this.kao = cVar.getLiveInfo();
            this.kap = cVar.getGoodsWindowInfo();
            this.kaq = cVar.getLiveReplayInfo();
            this.kaD = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bj bjVar = new bj();
                        bjVar.a(newestThreadList.get(i2));
                        bjVar.a(this.drK);
                        bjVar.aLc();
                        this.kaF.add(bjVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.kar = new g();
            this.kar.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cIj() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.kas == null) {
                this.kas = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.kaj);
            this.kaj = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gtu = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gts = z;
            cardPersonDynamicThreadData.gtr = z2;
            cardPersonDynamicThreadData.gtt = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.kas.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cIj() || this.isHost) {
            if (this.kaw == null) {
                this.kaw = new ArrayList<>();
            }
            this.kaj = UtilHelper.getRandom(random, 3, this.kaj);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gtu = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gts = false;
            cardPersonDynamicThreadData.gtr = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.kaj);
            this.kaw.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.kas == null) {
                    this.kas = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.gtr = z;
                dVar.sex = this.sex;
                dVar.gtk = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gtl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gtl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.kas.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cIi() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.kas == null) {
                this.kas = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.gtr = z;
            bVar.gtk = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.gtl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.kaH = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.kaI = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.kas.add(bVar);
            this.kas.add(cD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cHX() {
        if (this.kam == null) {
            return null;
        }
        return this.kam.getPhotoAlbum();
    }

    private void ec(List<ForumDynamic> list) {
        this.kal = new c();
        this.kal.kaK = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.kaO = forumDynamic.user_thread_count.intValue();
                this.kal.kaK.add(fVar);
            }
        }
    }

    private boolean cIi() {
        if (this.isHost) {
            return false;
        }
        if (this.kah == 3) {
            return true;
        }
        return this.kah == 2 && !this.kag;
    }

    public boolean cIj() {
        if (this.isHost) {
            return false;
        }
        if (this.kai == 3) {
            return true;
        }
        return this.kai == 2 && !this.kag;
    }

    protected com.baidu.tieba.person.d cD(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jOE = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cIk() {
        this.kag = true;
        this.sex = 1;
        this.kah = 1;
        this.kai = 1;
        this.kaj = -1;
        this.mUserData = null;
        if (this.kak != null) {
            this.kak.clear();
        }
        this.kak = null;
        this.kal = null;
        this.kam = null;
        this.kan = null;
        this.kar = null;
        this.mCardNullPolymericData = null;
        if (this.kas != null) {
            this.kas.clear();
        }
        if (this.kaw != null) {
            this.kaw.clear();
        }
        this.kas = null;
        this.kaw = null;
        this.kat.clear();
        this.kaC = null;
        this.kaD = null;
        this.maskType = 0;
        this.kao = null;
        this.kap = null;
        if (this.kaq != null) {
            this.kaq.clear();
        }
        if (this.kaF != null) {
            this.kaF.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.kaE;
    }

    public AntiData bNG() {
        return this.dMz;
    }

    public com.baidu.tieba.i.a cIl() {
        return this.kap;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> cbq() {
        return this.kat;
    }

    private void cGp() {
        this.kau.clear();
        this.kay = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.kay.gKw = new Bundle();
        this.kay.gKw.putBoolean("person_center_item_red_tip", true);
        this.kay.kaZ.gKw = new Bundle();
        this.kay.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(this.kay);
        this.kaz = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.kaz.gKw = new Bundle();
        this.kaz.gKw.putBoolean("person_center_item_red_tip", true);
        this.kaz.kaZ.gKw = new Bundle();
        this.kaz.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(this.kaz);
        this.kax = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.kax.gKw = new Bundle();
        this.kax.gKw.putBoolean("person_center_item_red_tip", true);
        this.kax.kaZ.gKw = new Bundle();
        this.kax.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(this.kax);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.kaZ.gKw = new Bundle();
        Y.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.gKw = new Bundle();
            Y2.kaZ.gKw = new Bundle();
            Y2.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.kau.add(Y2);
        }
        this.kaA = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.kaA.gKw = new Bundle();
        this.kaA.gKw.putBoolean("person_center_item_red_tip", true);
        this.kaA.kaZ.gKw = new Bundle();
        this.kaA.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(this.kaA);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.kaZ.gKw = new Bundle();
        Y3.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jTp != null) {
            Y3.kaZ.gKw.putString("book_jump_link", this.jTp.jSa);
        }
        this.kau.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.kaZ.gKw = new Bundle();
        Y4.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.kaZ.gKw = new Bundle();
        Y5.kaZ.gKw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kau.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.kaZ.gKw = new Bundle();
        Y6.kaZ.gKw.putString("key_service_centre", "");
        this.kau.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.jTx = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.kaZ = new com.baidu.tieba.personCenter.d.a();
        nVar.kaZ.gKv = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.kaF;
    }
}
