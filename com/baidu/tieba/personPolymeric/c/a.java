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
    private PersonUserGodInfo kli;
    private com.baidu.tieba.person.data.d klk;
    public User ksA;
    private ArrayList<com.baidu.adp.widget.ListView.o> ksh;
    private c ksi;
    private com.baidu.tieba.person.a.f ksj;
    private m ksk;
    private AlaLiveInfoCoreData ksl;
    private com.baidu.tieba.i.a ksm;
    private List<AlaLiveInfoCoreData> ksn;
    protected g kso;
    protected List<com.baidu.adp.widget.ListView.o> ksp;
    protected ArrayList<com.baidu.adp.widget.ListView.o> kss;
    public n kst;
    public n ksu;
    public n ksv;
    public n ksw;
    public n ksx;
    public UserAgreeInfo ksy;
    public NicknameInfo ksz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ksd = true;
    protected int sex = 1;
    private int kse = 1;
    private int ksf = 1;
    private int ksg = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.o> ksq = new ArrayList<>();
    private ArrayList<n> ksr = new ArrayList<>();
    private List<bk> ksB = new ArrayList();

    public abstract void cPe();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cpS() {
        return this.ksd;
    }

    public void tb(boolean z) {
        this.ksd = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.ksA = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.ksA);
            if (this.dFJ == null) {
                this.dFJ = new MetaData();
            }
            this.dFJ.parserProtobuf(this.ksA);
            if (this.kli == null) {
                this.kli = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.kli.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eaU == null) {
                this.eaU = new AntiData();
            }
            this.eaU.parserProtobuf(cVar.GetAntiStat());
            if (this.ksA != null) {
                if (this.ksA.priv_sets != null) {
                    this.kse = this.ksA.priv_sets.like.intValue();
                    this.ksf = this.ksA.priv_sets.post.intValue();
                }
                this.sex = this.ksA.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ksd = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.klk = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cPf()) {
                ei(cVar.getConcernedForumList());
            }
            if (this.kso == null) {
                c(this.ksA);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.ksA, postInfoList, random);
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
                                a(this.ksA, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.ksp) && v.isEmpty(this.kss)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cNm();
                this.maskType = cVar.getMaskType();
            }
            this.ksy = cVar.getUserAgreeInfo();
            this.ksl = cVar.getLiveInfo();
            this.ksm = cVar.getGoodsWindowInfo();
            this.ksn = cVar.getLiveReplayInfo();
            this.ksz = cVar.getNicknameInfo();
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
                        this.ksB.add(bkVar);
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
            this.kso = new g();
            this.kso.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cPg() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.ksp == null) {
                this.ksp = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.ksg);
            this.ksg = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gIl = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gIj = z;
            cardPersonDynamicThreadData.gIi = z2;
            cardPersonDynamicThreadData.gIk = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.ksp.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cPg() || this.isHost) {
            if (this.kss == null) {
                this.kss = new ArrayList<>();
            }
            this.ksg = UtilHelper.getRandom(random, 3, this.ksg);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gIl = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gIj = false;
            cardPersonDynamicThreadData.gIi = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.ksg);
            this.kss.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.ksp == null) {
                    this.ksp = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.gIi = z;
                dVar.sex = this.sex;
                dVar.gIb = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gIc = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gIc = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.ksp.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cPf() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.ksp == null) {
                this.ksp = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.gIi = z;
            bVar.gIb = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.gIc = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.ksD = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.ksE = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.ksp.add(bVar);
            this.ksp.add(cI(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.o> cOU() {
        if (this.ksj == null) {
            return null;
        }
        return this.ksj.getPhotoAlbum();
    }

    private void ei(List<ForumDynamic> list) {
        this.ksi = new c();
        this.ksi.ksG = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.ksK = forumDynamic.user_thread_count.intValue();
                this.ksi.ksG.add(fVar);
            }
        }
    }

    private boolean cPf() {
        if (this.isHost) {
            return false;
        }
        if (this.kse == 3) {
            return true;
        }
        return this.kse == 2 && !this.ksd;
    }

    public boolean cPg() {
        if (this.isHost) {
            return false;
        }
        if (this.ksf == 3) {
            return true;
        }
        return this.ksf == 2 && !this.ksd;
    }

    protected com.baidu.tieba.person.d cI(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.kgA = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cPh() {
        this.ksd = true;
        this.sex = 1;
        this.kse = 1;
        this.ksf = 1;
        this.ksg = -1;
        this.mUserData = null;
        if (this.ksh != null) {
            this.ksh.clear();
        }
        this.ksh = null;
        this.ksi = null;
        this.ksj = null;
        this.ksk = null;
        this.kso = null;
        this.mCardNullPolymericData = null;
        if (this.ksp != null) {
            this.ksp.clear();
        }
        if (this.kss != null) {
            this.kss.clear();
        }
        this.ksp = null;
        this.kss = null;
        this.ksq.clear();
        this.ksy = null;
        this.ksz = null;
        this.maskType = 0;
        this.ksl = null;
        this.ksm = null;
        if (this.ksn != null) {
            this.ksn.clear();
        }
        if (this.ksB != null) {
            this.ksB.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.ksA;
    }

    public AntiData bUa() {
        return this.eaU;
    }

    public com.baidu.tieba.i.a cPi() {
        return this.ksm;
    }

    public ArrayList<com.baidu.adp.widget.ListView.o> chO() {
        return this.ksq;
    }

    private void cNm() {
        this.ksr.clear();
        this.ksu = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.ksu.gZo = new Bundle();
        this.ksu.gZo.putBoolean("person_center_item_red_tip", true);
        this.ksu.ksV.gZo = new Bundle();
        this.ksu.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(this.ksu);
        this.ksv = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.ksv.gZo = new Bundle();
        this.ksv.gZo.putBoolean("person_center_item_red_tip", true);
        this.ksv.ksV.gZo = new Bundle();
        this.ksv.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(this.ksv);
        this.kst = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.kst.gZo = new Bundle();
        this.kst.gZo.putBoolean("person_center_item_red_tip", true);
        this.kst.ksV.gZo = new Bundle();
        this.kst.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(this.kst);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.ksV.gZo = new Bundle();
        Y.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.gZo = new Bundle();
            Y2.ksV.gZo = new Bundle();
            Y2.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ksr.add(Y2);
        }
        this.ksw = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.ksw.gZo = new Bundle();
        this.ksw.gZo.putBoolean("person_center_item_red_tip", true);
        this.ksw.ksV.gZo = new Bundle();
        this.ksw.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(this.ksw);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.ksV.gZo = new Bundle();
        Y3.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.klk != null) {
            Y3.ksV.gZo.putString("book_jump_link", this.klk.kjX);
        }
        this.ksr.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.ksV.gZo = new Bundle();
        Y4.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.ksV.gZo = new Bundle();
        Y5.ksV.gZo.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ksr.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.ksV.gZo = new Bundle();
        Y6.ksV.gZo.putString("key_service_centre", "");
        this.ksr.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.kls = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.ksV = new com.baidu.tieba.personCenter.d.a();
        nVar.ksV.gZn = i3;
        return nVar;
    }

    public List<bk> getNewestThreadList() {
        return this.ksB;
    }
}
