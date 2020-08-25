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
    private AntiData eAl;
    public MetaData ecb;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo leT;
    private com.baidu.tieba.person.data.d leV;
    private ArrayList<com.baidu.adp.widget.ListView.q> lmb;
    private c lmc;
    private com.baidu.tieba.person.a.f lmd;
    private m lme;
    private AlaLiveInfoCoreData lmf;
    private com.baidu.tieba.i.b lmg;
    private List<AlaLiveInfoCoreData> lmh;
    protected g lmi;
    protected List<com.baidu.adp.widget.ListView.q> lmj;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lmm;
    public n lmn;
    public n lmo;
    public n lmp;
    public n lmq;
    public n lmr;
    public UserAgreeInfo lms;
    public NicknameInfo lmt;
    public User lmu;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean llX = true;
    protected int sex = 1;
    private int llY = 1;
    private int llZ = 1;
    private int lma = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lmk = new ArrayList<>();
    private ArrayList<n> lml = new ArrayList<>();
    private List<bw> lmv = new ArrayList();

    public abstract void diB();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cIK() {
        return this.llX;
    }

    public void uF(boolean z) {
        this.llX = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.lmu = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.lmu);
            if (this.ecb == null) {
                this.ecb = new MetaData();
            }
            this.ecb.parserProtobuf(this.lmu);
            if (this.leT == null) {
                this.leT = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.leT.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eAl == null) {
                this.eAl = new AntiData();
            }
            this.eAl.parserProtobuf(cVar.GetAntiStat());
            if (this.lmu != null) {
                if (this.lmu.priv_sets != null) {
                    this.llY = this.lmu.priv_sets.like.intValue();
                    this.llZ = this.lmu.priv_sets.post.intValue();
                }
                this.sex = this.lmu.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.llX = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.leV = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !diC()) {
                eM(cVar.getConcernedForumList());
            }
            if (this.lmi == null) {
                c(this.lmu);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.lmu, postInfoList, random);
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
                                a(this.lmu, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.lmj) && y.isEmpty(this.lmm)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dgH();
                this.maskType = cVar.getMaskType();
            }
            this.lms = cVar.getUserAgreeInfo();
            this.lmf = cVar.getLiveInfo();
            this.lmg = cVar.getGoodsWindowInfo();
            this.lmh = cVar.getLiveReplayInfo();
            this.lmt = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bw bwVar = new bw();
                        bwVar.a(newestThreadList.get(i2));
                        bwVar.a(this.ecb);
                        bwVar.bfd();
                        this.lmv.add(bwVar);
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
            this.lmi = new g();
            this.lmi.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!diD() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.lmj == null) {
                this.lmj = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.lma);
            this.lma = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hnR = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hnP = z;
            cardPersonDynamicThreadData.hnO = z2;
            cardPersonDynamicThreadData.hnQ = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.lmj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!diD() || this.isHost) {
            if (this.lmm == null) {
                this.lmm = new ArrayList<>();
            }
            this.lma = UtilHelper.getRandom(random, 3, this.lma);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hnR = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hnP = false;
            cardPersonDynamicThreadData.hnO = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.lma);
            this.lmm.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.lmj == null) {
                    this.lmj = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.hnO = z;
                dVar.sex = this.sex;
                dVar.hnH = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hnI = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hnI = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.lmj.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!diC() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.lmj == null) {
                this.lmj = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.hnO = z;
            bVar.hnH = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.hnI = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jhV = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.lmx = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.lmj.add(bVar);
            this.lmj.add(cZ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dir() {
        if (this.lmd == null) {
            return null;
        }
        return this.lmd.getPhotoAlbum();
    }

    private void eM(List<ForumDynamic> list) {
        this.lmc = new c();
        this.lmc.lmz = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.lmD = forumDynamic.user_thread_count.intValue();
                this.lmc.lmz.add(fVar);
            }
        }
    }

    private boolean diC() {
        if (this.isHost) {
            return false;
        }
        if (this.llY == 3) {
            return true;
        }
        return this.llY == 2 && !this.llX;
    }

    public boolean diD() {
        if (this.isHost) {
            return false;
        }
        if (this.llZ == 3) {
            return true;
        }
        return this.llZ == 2 && !this.llX;
    }

    protected com.baidu.tieba.person.d cZ(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.lal = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void diE() {
        this.llX = true;
        this.sex = 1;
        this.llY = 1;
        this.llZ = 1;
        this.lma = -1;
        this.mUserData = null;
        if (this.lmb != null) {
            this.lmb.clear();
        }
        this.lmb = null;
        this.lmc = null;
        this.lmd = null;
        this.lme = null;
        this.lmi = null;
        this.mCardNullPolymericData = null;
        if (this.lmj != null) {
            this.lmj.clear();
        }
        if (this.lmm != null) {
            this.lmm.clear();
        }
        this.lmj = null;
        this.lmm = null;
        this.lmk.clear();
        this.lms = null;
        this.lmt = null;
        this.maskType = 0;
        this.lmf = null;
        this.lmg = null;
        if (this.lmh != null) {
            this.lmh.clear();
        }
        if (this.lmv != null) {
            this.lmv.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.lmu;
    }

    public AntiData ckT() {
        return this.eAl;
    }

    public com.baidu.tieba.i.b diF() {
        return this.lmg;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cAf() {
        return this.lmk;
    }

    private void dgH() {
        this.lml.clear();
        this.lmo = W(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.lmo.hEo = new Bundle();
        this.lmo.hEo.putBoolean("person_center_item_red_tip", true);
        this.lmo.lmO.hEo = new Bundle();
        this.lmo.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(this.lmo);
        this.lmp = W(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.lmp.hEo = new Bundle();
        this.lmp.hEo.putBoolean("person_center_item_red_tip", true);
        this.lmp.lmO.hEo = new Bundle();
        this.lmp.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(this.lmp);
        this.lmn = W(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.lmn.hEo = new Bundle();
        this.lmn.hEo.putBoolean("person_center_item_red_tip", true);
        this.lmn.lmO.hEo = new Bundle();
        this.lmn.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(this.lmn);
        n W = W(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        W.lmO.hEo = new Bundle();
        W.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(W);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n W2 = W(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            W2.hEo = new Bundle();
            W2.lmO.hEo = new Bundle();
            W2.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.lml.add(W2);
        }
        this.lmq = W(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.lmq.hEo = new Bundle();
        this.lmq.hEo.putBoolean("person_center_item_red_tip", true);
        this.lmq.lmO.hEo = new Bundle();
        this.lmq.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(this.lmq);
        n W3 = W(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        W3.lmO.hEo = new Bundle();
        W3.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.leV != null) {
            W3.lmO.hEo.putString("book_jump_link", this.leV.ldJ);
        }
        this.lml.add(W3);
        n W4 = W(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        W4.lmO.hEo = new Bundle();
        W4.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(W4);
        n W5 = W(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        W5.lmO.hEo = new Bundle();
        W5.lmO.hEo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lml.add(W5);
        n W6 = W(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        W6.lmO.hEo = new Bundle();
        W6.lmO.hEo.putString("key_service_centre", "");
        this.lml.add(W6);
    }

    private n W(int i, int i2, int i3) {
        n nVar = new n();
        nVar.lfi = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.lmO = new com.baidu.tieba.personCenter.d.a();
        nVar.lmO.hEn = i3;
        return nVar;
    }

    public List<bw> getNewestThreadList() {
        return this.lmv;
    }
}
