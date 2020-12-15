package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
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
/* loaded from: classes24.dex */
public abstract class a {
    public MetaData eKe;
    private AntiData fju;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private PersonUserGodInfo mkd;
    private com.baidu.tieba.person.data.d mkf;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mrB;
    public n mrC;
    public n mrD;
    public n mrE;
    public n mrF;
    public n mrG;
    public UserAgreeInfo mrH;
    public NicknameInfo mrI;
    public User mrJ;
    private ArrayList<com.baidu.adp.widget.ListView.q> mrq;
    private c mrr;
    private com.baidu.tieba.person.a.f mrs;
    private m mrt;
    private AlaLiveInfoCoreData mru;
    private com.baidu.tieba.j.b mrv;
    private List<AlaLiveInfoCoreData> mrw;
    protected g mrx;
    protected List<com.baidu.adp.widget.ListView.q> mry;
    private boolean mrm = true;
    protected int sex = 1;
    private int mrn = 1;
    private int mro = 1;
    private int mrp = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mrz = new ArrayList<>();
    private ArrayList<n> mrA = new ArrayList<>();
    private List<by> mrK = new ArrayList();

    public abstract void dAv();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean daA() {
        return this.mrm;
    }

    public void wD(boolean z) {
        this.mrm = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mrJ = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mrJ);
            if (this.eKe == null) {
                this.eKe = new MetaData();
            }
            this.eKe.parserProtobuf(this.mrJ);
            if (this.mkd == null) {
                this.mkd = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mkd.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fju == null) {
                this.fju = new AntiData();
            }
            this.fju.parserProtobuf(cVar.GetAntiStat());
            if (this.mrJ != null) {
                if (this.mrJ.priv_sets != null) {
                    this.mrn = this.mrJ.priv_sets.like.intValue();
                    this.mro = this.mrJ.priv_sets.post.intValue();
                }
                this.sex = this.mrJ.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mrm = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mkf = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dAw()) {
                fA(cVar.getConcernedForumList());
            }
            if (this.mrx == null) {
                c(this.mrJ);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mrJ, postInfoList, random);
                    }
                }
            }
            String yearBytime = au.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!y.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = au.getYearBytime(longValue);
                        String chineseMonthBytime = au.getChineseMonthBytime(longValue);
                        String dateBytime = au.getDateBytime(longValue);
                        if (au.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (au.equals(dateBytime, str3) && au.equals(chineseMonthBytime, str2) && au.equals(yearBytime2, yearBytime)) {
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
                                a(this.mrJ, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mry) && y.isEmpty(this.mrB)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dyz();
                this.maskType = cVar.getMaskType();
            }
            this.mrH = cVar.getUserAgreeInfo();
            this.mru = cVar.getLiveInfo();
            this.mrv = cVar.getGoodsWindowInfo();
            this.mrw = cVar.getLiveReplayInfo();
            this.mrI = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        by byVar = new by();
                        byVar.a(newestThreadList.get(i2));
                        byVar.a(this.eKe);
                        byVar.bpo();
                        this.mrK.add(byVar);
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
            this.mrx = new g();
            this.mrx.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dAx() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mry == null) {
                this.mry = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mrp);
            this.mrp = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iod = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iob = z;
            cardPersonDynamicThreadData.ioa = z2;
            cardPersonDynamicThreadData.ioc = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mry.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dAx() || this.isHost) {
            if (this.mrB == null) {
                this.mrB = new ArrayList<>();
            }
            this.mrp = UtilHelper.getRandom(random, 3, this.mrp);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iod = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iob = false;
            cardPersonDynamicThreadData.ioa = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mrp);
            this.mrB.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mry == null) {
                    this.mry = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.ioa = z;
                dVar.sex = this.sex;
                dVar.inT = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.inU = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.inU = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mry.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dAw() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mry == null) {
                this.mry = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.ioa = z;
            bVar.inT = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.inU = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jLy = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mrM = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mry.add(bVar);
            this.mry.add(dl(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dAl() {
        if (this.mrs == null) {
            return null;
        }
        return this.mrs.getPhotoAlbum();
    }

    private void fA(List<ForumDynamic> list) {
        this.mrr = new c();
        this.mrr.mrO = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mrS = forumDynamic.user_thread_count.intValue();
                this.mrr.mrO.add(fVar);
            }
        }
    }

    private boolean dAw() {
        if (this.isHost) {
            return false;
        }
        if (this.mrn == 3) {
            return true;
        }
        return this.mrn == 2 && !this.mrm;
    }

    public boolean dAx() {
        if (this.isHost) {
            return false;
        }
        if (this.mro == 3) {
            return true;
        }
        return this.mro == 2 && !this.mrm;
    }

    protected com.baidu.tieba.person.d dl(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mfs = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dAy() {
        this.mrm = true;
        this.sex = 1;
        this.mrn = 1;
        this.mro = 1;
        this.mrp = -1;
        this.mUserData = null;
        if (this.mrq != null) {
            this.mrq.clear();
        }
        this.mrq = null;
        this.mrr = null;
        this.mrs = null;
        this.mrt = null;
        this.mrx = null;
        this.mCardNullPolymericData = null;
        if (this.mry != null) {
            this.mry.clear();
        }
        if (this.mrB != null) {
            this.mrB.clear();
        }
        this.mry = null;
        this.mrB = null;
        this.mrz.clear();
        this.mrH = null;
        this.mrI = null;
        this.maskType = 0;
        this.mru = null;
        this.mrv = null;
        if (this.mrw != null) {
            this.mrw.clear();
        }
        if (this.mrK != null) {
            this.mrK.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mrJ;
    }

    public AntiData cBf() {
        return this.fju;
    }

    public com.baidu.tieba.j.b dAz() {
        return this.mrv;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cSa() {
        return this.mrz;
    }

    private void dyz() {
        this.mrA.clear();
        this.mrD = aa(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mrD.iEy = new Bundle();
        this.mrD.iEy.putBoolean("person_center_item_red_tip", true);
        this.mrD.msd.iEy = new Bundle();
        this.mrD.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(this.mrD);
        this.mrE = aa(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mrE.iEy = new Bundle();
        this.mrE.iEy.putBoolean("person_center_item_red_tip", true);
        this.mrE.msd.iEy = new Bundle();
        this.mrE.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(this.mrE);
        this.mrC = aa(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mrC.iEy = new Bundle();
        this.mrC.iEy.putBoolean("person_center_item_red_tip", true);
        this.mrC.msd.iEy = new Bundle();
        this.mrC.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(this.mrC);
        n aa = aa(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        aa.msd.iEy = new Bundle();
        aa.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            aa2.iEy = new Bundle();
            aa2.msd.iEy = new Bundle();
            aa2.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mrA.add(aa2);
        }
        this.mrF = aa(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mrF.iEy = new Bundle();
        this.mrF.iEy.putBoolean("person_center_item_red_tip", true);
        this.mrF.msd.iEy = new Bundle();
        this.mrF.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(this.mrF);
        n aa3 = aa(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        aa3.msd.iEy = new Bundle();
        aa3.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mkf != null) {
            aa3.msd.iEy.putString("book_jump_link", this.mkf.miT);
        }
        this.mrA.add(aa3);
        n aa4 = aa(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        aa4.msd.iEy = new Bundle();
        aa4.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(aa4);
        n aa5 = aa(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        aa5.msd.iEy = new Bundle();
        aa5.msd.iEy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mrA.add(aa5);
        n aa6 = aa(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        aa6.msd.iEy = new Bundle();
        aa6.msd.iEy.putString("key_service_centre", "");
        this.mrA.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gjd = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.msd = new com.baidu.tieba.personCenter.d.a();
        nVar.msd.iEx = i3;
        return nVar;
    }

    public List<by> getNewestThreadList() {
        return this.mrK;
    }
}
