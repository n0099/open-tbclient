package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bk;
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
    public MetaData dFJ;
    private AntiData eaU;
    protected boolean isHost;
    private PersonUserGodInfo kmo;
    private com.baidu.tieba.person.data.d kmq;
    public n ktA;
    public n ktB;
    public n ktC;
    public n ktD;
    public UserAgreeInfo ktE;
    public NicknameInfo ktF;
    public User ktG;
    private ArrayList<com.baidu.adp.widget.ListView.o> ktn;
    private c kto;
    private com.baidu.tieba.person.a.f ktp;
    private m ktq;
    private AlaLiveInfoCoreData ktr;
    private com.baidu.tieba.i.a kts;
    private List<AlaLiveInfoCoreData> ktt;
    protected g ktu;
    protected List<com.baidu.adp.widget.ListView.o> ktv;
    protected ArrayList<com.baidu.adp.widget.ListView.o> kty;
    public n ktz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ktj = true;
    protected int sex = 1;
    private int ktk = 1;
    private int ktl = 1;
    private int ktm = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.o> ktw = new ArrayList<>();
    private ArrayList<n> ktx = new ArrayList<>();
    private List<bk> ktH = new ArrayList();

    public abstract void cPu();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cqb() {
        return this.ktj;
    }

    public void tb(boolean z) {
        this.ktj = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.ktG = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.ktG);
            if (this.dFJ == null) {
                this.dFJ = new MetaData();
            }
            this.dFJ.parserProtobuf(this.ktG);
            if (this.kmo == null) {
                this.kmo = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.kmo.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eaU == null) {
                this.eaU = new AntiData();
            }
            this.eaU.parserProtobuf(cVar.GetAntiStat());
            if (this.ktG != null) {
                if (this.ktG.priv_sets != null) {
                    this.ktk = this.ktG.priv_sets.like.intValue();
                    this.ktl = this.ktG.priv_sets.post.intValue();
                }
                this.sex = this.ktG.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ktj = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.kmq = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cPv()) {
                ek(cVar.getConcernedForumList());
            }
            if (this.ktu == null) {
                c(this.ktG);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.ktG, postInfoList, random);
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
                                a(this.ktG, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.ktv) && v.isEmpty(this.kty)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cNC();
                this.maskType = cVar.getMaskType();
            }
            this.ktE = cVar.getUserAgreeInfo();
            this.ktr = cVar.getLiveInfo();
            this.kts = cVar.getGoodsWindowInfo();
            this.ktt = cVar.getLiveReplayInfo();
            this.ktF = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bk bkVar = new bk();
                        bkVar.a(newestThreadList.get(i2));
                        bkVar.a(this.dFJ);
                        bkVar.aQX();
                        this.ktH.add(bkVar);
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
            this.ktu = new g();
            this.ktu.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cPw() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.ktv == null) {
                this.ktv = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.ktm);
            this.ktm = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gIw = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gIu = z;
            cardPersonDynamicThreadData.gIt = z2;
            cardPersonDynamicThreadData.gIv = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.ktv.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cPw() || this.isHost) {
            if (this.kty == null) {
                this.kty = new ArrayList<>();
            }
            this.ktm = UtilHelper.getRandom(random, 3, this.ktm);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gIw = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gIu = false;
            cardPersonDynamicThreadData.gIt = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.ktm);
            this.kty.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.ktv == null) {
                    this.ktv = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.gIt = z;
                dVar.sex = this.sex;
                dVar.gIm = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gIn = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gIn = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.ktv.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cPv() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.ktv == null) {
                this.ktv = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.gIt = z;
            bVar.gIm = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.gIn = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.ktJ = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.ktK = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.ktv.add(bVar);
            this.ktv.add(cI(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.o> cPk() {
        if (this.ktp == null) {
            return null;
        }
        return this.ktp.getPhotoAlbum();
    }

    private void ek(List<ForumDynamic> list) {
        this.kto = new c();
        this.kto.ktM = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.ktQ = forumDynamic.user_thread_count.intValue();
                this.kto.ktM.add(fVar);
            }
        }
    }

    private boolean cPv() {
        if (this.isHost) {
            return false;
        }
        if (this.ktk == 3) {
            return true;
        }
        return this.ktk == 2 && !this.ktj;
    }

    public boolean cPw() {
        if (this.isHost) {
            return false;
        }
        if (this.ktl == 3) {
            return true;
        }
        return this.ktl == 2 && !this.ktj;
    }

    protected com.baidu.tieba.person.d cI(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.khG = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cPx() {
        this.ktj = true;
        this.sex = 1;
        this.ktk = 1;
        this.ktl = 1;
        this.ktm = -1;
        this.mUserData = null;
        if (this.ktn != null) {
            this.ktn.clear();
        }
        this.ktn = null;
        this.kto = null;
        this.ktp = null;
        this.ktq = null;
        this.ktu = null;
        this.mCardNullPolymericData = null;
        if (this.ktv != null) {
            this.ktv.clear();
        }
        if (this.kty != null) {
            this.kty.clear();
        }
        this.ktv = null;
        this.kty = null;
        this.ktw.clear();
        this.ktE = null;
        this.ktF = null;
        this.maskType = 0;
        this.ktr = null;
        this.kts = null;
        if (this.ktt != null) {
            this.ktt.clear();
        }
        if (this.ktH != null) {
            this.ktH.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.ktG;
    }

    public AntiData bUc() {
        return this.eaU;
    }

    public com.baidu.tieba.i.a cPy() {
        return this.kts;
    }

    public ArrayList<com.baidu.adp.widget.ListView.o> chX() {
        return this.ktw;
    }

    private void cNC() {
        this.ktx.clear();
        this.ktA = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.ktA.gZz = new Bundle();
        this.ktA.gZz.putBoolean("person_center_item_red_tip", true);
        this.ktA.kub.gZz = new Bundle();
        this.ktA.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(this.ktA);
        this.ktB = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.ktB.gZz = new Bundle();
        this.ktB.gZz.putBoolean("person_center_item_red_tip", true);
        this.ktB.kub.gZz = new Bundle();
        this.ktB.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(this.ktB);
        this.ktz = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.ktz.gZz = new Bundle();
        this.ktz.gZz.putBoolean("person_center_item_red_tip", true);
        this.ktz.kub.gZz = new Bundle();
        this.ktz.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(this.ktz);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.kub.gZz = new Bundle();
        Y.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.gZz = new Bundle();
            Y2.kub.gZz = new Bundle();
            Y2.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ktx.add(Y2);
        }
        this.ktC = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.ktC.gZz = new Bundle();
        this.ktC.gZz.putBoolean("person_center_item_red_tip", true);
        this.ktC.kub.gZz = new Bundle();
        this.ktC.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(this.ktC);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.kub.gZz = new Bundle();
        Y3.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.kmq != null) {
            Y3.kub.gZz.putString("book_jump_link", this.kmq.kld);
        }
        this.ktx.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.kub.gZz = new Bundle();
        Y4.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.kub.gZz = new Bundle();
        Y5.kub.gZz.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ktx.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.kub.gZz = new Bundle();
        Y6.kub.gZz.putString("key_service_centre", "");
        this.ktx.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.kmy = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.kub = new com.baidu.tieba.personCenter.d.a();
        nVar.kub.gZy = i3;
        return nVar;
    }

    public List<bk> getNewestThreadList() {
        return this.ktH;
    }
}
