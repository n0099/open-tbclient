package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes18.dex */
public abstract class a {
    private AntiData eAp;
    public MetaData ecf;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo lfa;
    private com.baidu.tieba.person.data.d lfc;
    public n lmA;
    public n lmB;
    public n lmC;
    public UserAgreeInfo lmD;
    public NicknameInfo lmE;
    public User lmF;
    private ArrayList<com.baidu.adp.widget.ListView.q> lmm;
    private c lmn;
    private com.baidu.tieba.person.a.f lmo;
    private m lmp;
    private AlaLiveInfoCoreData lmq;
    private com.baidu.tieba.i.b lmr;
    private List<AlaLiveInfoCoreData> lms;
    protected g lmt;
    protected List<com.baidu.adp.widget.ListView.q> lmu;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lmx;
    public n lmy;
    public n lmz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean lmi = true;
    protected int sex = 1;
    private int lmj = 1;
    private int lmk = 1;
    private int lml = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lmv = new ArrayList<>();
    private ArrayList<n> lmw = new ArrayList<>();
    private List<bw> lmG = new ArrayList();

    public abstract void diE();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cIL() {
        return this.lmi;
    }

    public void uH(boolean z) {
        this.lmi = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.lmF = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.lmF);
            if (this.ecf == null) {
                this.ecf = new MetaData();
            }
            this.ecf.parserProtobuf(this.lmF);
            if (this.lfa == null) {
                this.lfa = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.lfa.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eAp == null) {
                this.eAp = new AntiData();
            }
            this.eAp.parserProtobuf(cVar.GetAntiStat());
            if (this.lmF != null) {
                if (this.lmF.priv_sets != null) {
                    this.lmj = this.lmF.priv_sets.like.intValue();
                    this.lmk = this.lmF.priv_sets.post.intValue();
                }
                this.sex = this.lmF.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.lmi = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.lfc = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !diF()) {
                eM(cVar.getConcernedForumList());
            }
            if (this.lmt == null) {
                c(this.lmF);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.lmF, postInfoList, random);
                    }
                }
            }
            String yearBytime = at.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!y.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = at.getYearBytime(longValue);
                        String chineseMonthBytime = at.getChineseMonthBytime(longValue);
                        String dateBytime = at.getDateBytime(longValue);
                        if (at.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (at.equals(dateBytime, str3) && at.equals(chineseMonthBytime, str2) && at.equals(yearBytime2, yearBytime)) {
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
                                a(this.lmF, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.lmu) && y.isEmpty(this.lmx)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dgI();
                this.maskType = cVar.getMaskType();
            }
            this.lmD = cVar.getUserAgreeInfo();
            this.lmq = cVar.getLiveInfo();
            this.lmr = cVar.getGoodsWindowInfo();
            this.lms = cVar.getLiveReplayInfo();
            this.lmE = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bw bwVar = new bw();
                        bwVar.a(newestThreadList.get(i2));
                        bwVar.a(this.ecf);
                        bwVar.bfd();
                        this.lmG.add(bwVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !y.isEmpty(user.gift_list)) {
            this.lmt = new g();
            this.lmt.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!diG() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.lmu == null) {
                this.lmu = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.lml);
            this.lml = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hnV = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hnT = z;
            cardPersonDynamicThreadData.hnS = z2;
            cardPersonDynamicThreadData.hnU = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.lmu.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!diG() || this.isHost) {
            if (this.lmx == null) {
                this.lmx = new ArrayList<>();
            }
            this.lml = UtilHelper.getRandom(random, 3, this.lml);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hnV = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hnT = false;
            cardPersonDynamicThreadData.hnS = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.lml);
            this.lmx.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.lmu == null) {
                    this.lmu = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.hnS = z;
                dVar.sex = this.sex;
                dVar.hnL = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hnM = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hnM = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.lmu.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!diF() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.lmu == null) {
                this.lmu = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.hnS = z;
            bVar.hnL = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.hnM = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jib = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.lmI = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.lmu.add(bVar);
            this.lmu.add(cZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> diu() {
        if (this.lmo == null) {
            return null;
        }
        return this.lmo.getPhotoAlbum();
    }

    private void eM(List<ForumDynamic> list) {
        this.lmn = new c();
        this.lmn.lmK = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.lmO = forumDynamic.user_thread_count.intValue();
                this.lmn.lmK.add(fVar);
            }
        }
    }

    private boolean diF() {
        if (this.isHost) {
            return false;
        }
        if (this.lmj == 3) {
            return true;
        }
        return this.lmj == 2 && !this.lmi;
    }

    public boolean diG() {
        if (this.isHost) {
            return false;
        }
        if (this.lmk == 3) {
            return true;
        }
        return this.lmk == 2 && !this.lmi;
    }

    protected com.baidu.tieba.person.d cZ(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.las = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void diH() {
        this.lmi = true;
        this.sex = 1;
        this.lmj = 1;
        this.lmk = 1;
        this.lml = -1;
        this.mUserData = null;
        if (this.lmm != null) {
            this.lmm.clear();
        }
        this.lmm = null;
        this.lmn = null;
        this.lmo = null;
        this.lmp = null;
        this.lmt = null;
        this.mCardNullPolymericData = null;
        if (this.lmu != null) {
            this.lmu.clear();
        }
        if (this.lmx != null) {
            this.lmx.clear();
        }
        this.lmu = null;
        this.lmx = null;
        this.lmv.clear();
        this.lmD = null;
        this.lmE = null;
        this.maskType = 0;
        this.lmq = null;
        this.lmr = null;
        if (this.lms != null) {
            this.lms.clear();
        }
        if (this.lmG != null) {
            this.lmG.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.lmF;
    }

    public AntiData ckU() {
        return this.eAp;
    }

    public com.baidu.tieba.i.b diI() {
        return this.lmr;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cAg() {
        return this.lmv;
    }

    private void dgI() {
        this.lmw.clear();
        this.lmz = W(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.lmz.hEu = new Bundle();
        this.lmz.hEu.putBoolean("person_center_item_red_tip", true);
        this.lmz.lmZ.hEu = new Bundle();
        this.lmz.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(this.lmz);
        this.lmA = W(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.lmA.hEu = new Bundle();
        this.lmA.hEu.putBoolean("person_center_item_red_tip", true);
        this.lmA.lmZ.hEu = new Bundle();
        this.lmA.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(this.lmA);
        this.lmy = W(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.lmy.hEu = new Bundle();
        this.lmy.hEu.putBoolean("person_center_item_red_tip", true);
        this.lmy.lmZ.hEu = new Bundle();
        this.lmy.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(this.lmy);
        n W = W(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        W.lmZ.hEu = new Bundle();
        W.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(W);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n W2 = W(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            W2.hEu = new Bundle();
            W2.lmZ.hEu = new Bundle();
            W2.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.lmw.add(W2);
        }
        this.lmB = W(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.lmB.hEu = new Bundle();
        this.lmB.hEu.putBoolean("person_center_item_red_tip", true);
        this.lmB.lmZ.hEu = new Bundle();
        this.lmB.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(this.lmB);
        n W3 = W(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        W3.lmZ.hEu = new Bundle();
        W3.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.lfc != null) {
            W3.lmZ.hEu.putString("book_jump_link", this.lfc.ldQ);
        }
        this.lmw.add(W3);
        n W4 = W(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        W4.lmZ.hEu = new Bundle();
        W4.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(W4);
        n W5 = W(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        W5.lmZ.hEu = new Bundle();
        W5.lmZ.hEu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lmw.add(W5);
        n W6 = W(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        W6.lmZ.hEu = new Bundle();
        W6.lmZ.hEu.putString("key_service_centre", "");
        this.lmw.add(W6);
    }

    private n W(int i, int i2, int i3) {
        n nVar = new n();
        nVar.lfp = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.lmZ = new com.baidu.tieba.personCenter.d.a();
        nVar.lmZ.hEt = i3;
        return nVar;
    }

    public List<bw> getNewestThreadList() {
        return this.lmG;
    }
}
