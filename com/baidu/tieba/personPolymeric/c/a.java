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
    private PersonUserGodInfo mkb;
    private com.baidu.tieba.person.data.d mkd;
    public n mrA;
    public n mrB;
    public n mrC;
    public n mrD;
    public n mrE;
    public UserAgreeInfo mrF;
    public NicknameInfo mrG;
    public User mrH;
    private ArrayList<com.baidu.adp.widget.ListView.q> mro;
    private c mrp;
    private com.baidu.tieba.person.a.f mrq;
    private m mrr;
    private AlaLiveInfoCoreData mrs;
    private com.baidu.tieba.j.b mrt;
    private List<AlaLiveInfoCoreData> mru;
    protected g mrv;
    protected List<com.baidu.adp.widget.ListView.q> mrw;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mrz;
    private boolean mrk = true;
    protected int sex = 1;
    private int mrl = 1;
    private int mrm = 1;
    private int mrn = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mrx = new ArrayList<>();
    private ArrayList<n> mry = new ArrayList<>();
    private List<by> mrI = new ArrayList();

    public abstract void dAu();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean daz() {
        return this.mrk;
    }

    public void wD(boolean z) {
        this.mrk = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mrH = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mrH);
            if (this.eKe == null) {
                this.eKe = new MetaData();
            }
            this.eKe.parserProtobuf(this.mrH);
            if (this.mkb == null) {
                this.mkb = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mkb.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fju == null) {
                this.fju = new AntiData();
            }
            this.fju.parserProtobuf(cVar.GetAntiStat());
            if (this.mrH != null) {
                if (this.mrH.priv_sets != null) {
                    this.mrl = this.mrH.priv_sets.like.intValue();
                    this.mrm = this.mrH.priv_sets.post.intValue();
                }
                this.sex = this.mrH.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mrk = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mkd = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dAv()) {
                fA(cVar.getConcernedForumList());
            }
            if (this.mrv == null) {
                c(this.mrH);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mrH, postInfoList, random);
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
                                a(this.mrH, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mrw) && y.isEmpty(this.mrz)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dyy();
                this.maskType = cVar.getMaskType();
            }
            this.mrF = cVar.getUserAgreeInfo();
            this.mrs = cVar.getLiveInfo();
            this.mrt = cVar.getGoodsWindowInfo();
            this.mru = cVar.getLiveReplayInfo();
            this.mrG = cVar.getNicknameInfo();
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
                        this.mrI.add(byVar);
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
            this.mrv = new g();
            this.mrv.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dAw() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mrw == null) {
                this.mrw = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mrn);
            this.mrn = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iob = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.inZ = z;
            cardPersonDynamicThreadData.inY = z2;
            cardPersonDynamicThreadData.ioa = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mrw.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dAw() || this.isHost) {
            if (this.mrz == null) {
                this.mrz = new ArrayList<>();
            }
            this.mrn = UtilHelper.getRandom(random, 3, this.mrn);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iob = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.inZ = false;
            cardPersonDynamicThreadData.inY = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mrn);
            this.mrz.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mrw == null) {
                    this.mrw = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.inY = z;
                dVar.sex = this.sex;
                dVar.inR = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.inS = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.inS = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mrw.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dAv() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mrw == null) {
                this.mrw = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.inY = z;
            bVar.inR = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.inS = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jLw = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mrK = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mrw.add(bVar);
            this.mrw.add(dl(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dAk() {
        if (this.mrq == null) {
            return null;
        }
        return this.mrq.getPhotoAlbum();
    }

    private void fA(List<ForumDynamic> list) {
        this.mrp = new c();
        this.mrp.mrM = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mrQ = forumDynamic.user_thread_count.intValue();
                this.mrp.mrM.add(fVar);
            }
        }
    }

    private boolean dAv() {
        if (this.isHost) {
            return false;
        }
        if (this.mrl == 3) {
            return true;
        }
        return this.mrl == 2 && !this.mrk;
    }

    public boolean dAw() {
        if (this.isHost) {
            return false;
        }
        if (this.mrm == 3) {
            return true;
        }
        return this.mrm == 2 && !this.mrk;
    }

    protected com.baidu.tieba.person.d dl(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mfq = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dAx() {
        this.mrk = true;
        this.sex = 1;
        this.mrl = 1;
        this.mrm = 1;
        this.mrn = -1;
        this.mUserData = null;
        if (this.mro != null) {
            this.mro.clear();
        }
        this.mro = null;
        this.mrp = null;
        this.mrq = null;
        this.mrr = null;
        this.mrv = null;
        this.mCardNullPolymericData = null;
        if (this.mrw != null) {
            this.mrw.clear();
        }
        if (this.mrz != null) {
            this.mrz.clear();
        }
        this.mrw = null;
        this.mrz = null;
        this.mrx.clear();
        this.mrF = null;
        this.mrG = null;
        this.maskType = 0;
        this.mrs = null;
        this.mrt = null;
        if (this.mru != null) {
            this.mru.clear();
        }
        if (this.mrI != null) {
            this.mrI.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mrH;
    }

    public AntiData cBe() {
        return this.fju;
    }

    public com.baidu.tieba.j.b dAy() {
        return this.mrt;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cRZ() {
        return this.mrx;
    }

    private void dyy() {
        this.mry.clear();
        this.mrB = aa(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mrB.iEw = new Bundle();
        this.mrB.iEw.putBoolean("person_center_item_red_tip", true);
        this.mrB.msb.iEw = new Bundle();
        this.mrB.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(this.mrB);
        this.mrC = aa(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mrC.iEw = new Bundle();
        this.mrC.iEw.putBoolean("person_center_item_red_tip", true);
        this.mrC.msb.iEw = new Bundle();
        this.mrC.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(this.mrC);
        this.mrA = aa(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mrA.iEw = new Bundle();
        this.mrA.iEw.putBoolean("person_center_item_red_tip", true);
        this.mrA.msb.iEw = new Bundle();
        this.mrA.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(this.mrA);
        n aa = aa(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        aa.msb.iEw = new Bundle();
        aa.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            aa2.iEw = new Bundle();
            aa2.msb.iEw = new Bundle();
            aa2.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mry.add(aa2);
        }
        this.mrD = aa(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mrD.iEw = new Bundle();
        this.mrD.iEw.putBoolean("person_center_item_red_tip", true);
        this.mrD.msb.iEw = new Bundle();
        this.mrD.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(this.mrD);
        n aa3 = aa(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        aa3.msb.iEw = new Bundle();
        aa3.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mkd != null) {
            aa3.msb.iEw.putString("book_jump_link", this.mkd.miR);
        }
        this.mry.add(aa3);
        n aa4 = aa(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        aa4.msb.iEw = new Bundle();
        aa4.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(aa4);
        n aa5 = aa(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        aa5.msb.iEw = new Bundle();
        aa5.msb.iEw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mry.add(aa5);
        n aa6 = aa(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        aa6.msb.iEw = new Bundle();
        aa6.msb.iEw.putString("key_service_centre", "");
        this.mry.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gjb = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.msb = new com.baidu.tieba.personCenter.d.a();
        nVar.msb.iEv = i3;
        return nVar;
    }

    public List<by> getNewestThreadList() {
        return this.mrI;
    }
}
