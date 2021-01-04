package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes8.dex */
public abstract class a {
    public MetaData eTY;
    private AntiData ftd;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private PersonUserGodInfo mpm;
    private com.baidu.tieba.person.data.d mpo;
    private ArrayList<com.baidu.adp.widget.ListView.n> mwE;
    private c mwF;
    private com.baidu.tieba.person.a.f mwG;
    private m mwH;
    private AlaLiveInfoCoreData mwI;
    private com.baidu.tieba.j.b mwJ;
    private List<AlaLiveInfoCoreData> mwK;
    protected g mwL;
    protected List<com.baidu.adp.widget.ListView.n> mwM;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mwP;
    public n mwQ;
    public n mwR;
    public n mwS;
    public n mwT;
    public n mwU;
    public UserAgreeInfo mwV;
    public NicknameInfo mwW;
    public User mwX;
    private boolean mwA = true;
    protected int sex = 1;
    private int mwB = 1;
    private int mwC = 1;
    private int mwD = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mwN = new ArrayList<>();
    private ArrayList<n> mwO = new ArrayList<>();
    private List<bz> mwY = new ArrayList();

    public abstract void dAk();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean dad() {
        return this.mwA;
    }

    public void wE(boolean z) {
        this.mwA = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mwX = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mwX);
            if (this.eTY == null) {
                this.eTY = new MetaData();
            }
            this.eTY.parserProtobuf(this.mwX);
            if (this.mpm == null) {
                this.mpm = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mpm.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.ftd == null) {
                this.ftd = new AntiData();
            }
            this.ftd.parserProtobuf(cVar.GetAntiStat());
            if (this.mwX != null) {
                if (this.mwX.priv_sets != null) {
                    this.mwB = this.mwX.priv_sets.like.intValue();
                    this.mwC = this.mwX.priv_sets.post.intValue();
                }
                this.sex = this.mwX.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mwA = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mpo = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!x.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dAl()) {
                fA(cVar.getConcernedForumList());
            }
            if (this.mwL == null) {
                c(this.mwX);
            }
            Random random = new Random();
            if (this.isHost && !x.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mwX, postInfoList, random);
                    }
                }
            }
            String yearBytime = at.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!x.isEmpty(cVar.getDynamicInfoList())) {
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
                            str = str3;
                        } else {
                            z2 = true;
                            str = dateBytime;
                            str2 = chineseMonthBytime;
                            yearBytime = yearBytime2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(this.mwX, dynamicInfo, random, z, z2, z3);
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
                    }
                }
            }
            if (this.mCardNullPolymericData == null && x.isEmpty(this.mwM) && x.isEmpty(this.mwP)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dyo();
                this.maskType = cVar.getMaskType();
            }
            this.mwV = cVar.getUserAgreeInfo();
            this.mwI = cVar.getLiveInfo();
            this.mwJ = cVar.getGoodsWindowInfo();
            this.mwK = cVar.getLiveReplayInfo();
            this.mwW = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!x.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bz bzVar = new bz();
                        bzVar.a(newestThreadList.get(i2));
                        bzVar.a(this.eTY);
                        bzVar.brO();
                        this.mwY.add(bzVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !x.isEmpty(user.gift_list)) {
            this.mwL = new g();
            this.mwL.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dAm() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mwM == null) {
                this.mwM = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mwD);
            this.mwD = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iAx = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iAv = z;
            cardPersonDynamicThreadData.iAu = z2;
            cardPersonDynamicThreadData.iAw = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mwM.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dAm() || this.isHost) {
            if (this.mwP == null) {
                this.mwP = new ArrayList<>();
            }
            this.mwD = UtilHelper.getRandom(random, 3, this.mwD);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iAx = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iAv = false;
            cardPersonDynamicThreadData.iAu = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mwD);
            this.mwP.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.isEmpty(list)) {
                if (this.mwM == null) {
                    this.mwM = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.iAu = z;
                dVar.sex = this.sex;
                dVar.iAn = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iAo = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iAo = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mwM.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dAl() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mwM == null) {
                this.mwM = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.iAu = z;
            bVar.iAn = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.iAo = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jYM = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mxa = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mwM.add(bVar);
            this.mwM.add(dh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.n> dAa() {
        if (this.mwG == null) {
            return null;
        }
        return this.mwG.getPhotoAlbum();
    }

    private void fA(List<ForumDynamic> list) {
        this.mwF = new c();
        this.mwF.mxc = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mxg = forumDynamic.user_thread_count.intValue();
                this.mwF.mxc.add(fVar);
            }
        }
    }

    private boolean dAl() {
        if (this.isHost) {
            return false;
        }
        if (this.mwB == 3) {
            return true;
        }
        return this.mwB == 2 && !this.mwA;
    }

    public boolean dAm() {
        if (this.isHost) {
            return false;
        }
        if (this.mwC == 3) {
            return true;
        }
        return this.mwC == 2 && !this.mwA;
    }

    protected com.baidu.tieba.person.d dh(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mkF = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dAn() {
        this.mwA = true;
        this.sex = 1;
        this.mwB = 1;
        this.mwC = 1;
        this.mwD = -1;
        this.mUserData = null;
        if (this.mwE != null) {
            this.mwE.clear();
        }
        this.mwE = null;
        this.mwF = null;
        this.mwG = null;
        this.mwH = null;
        this.mwL = null;
        this.mCardNullPolymericData = null;
        if (this.mwM != null) {
            this.mwM.clear();
        }
        if (this.mwP != null) {
            this.mwP.clear();
        }
        this.mwM = null;
        this.mwP = null;
        this.mwN.clear();
        this.mwV = null;
        this.mwW = null;
        this.maskType = 0;
        this.mwI = null;
        this.mwJ = null;
        if (this.mwK != null) {
            this.mwK.clear();
        }
        if (this.mwY != null) {
            this.mwY.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mwX;
    }

    public AntiData cDY() {
        return this.ftd;
    }

    public com.baidu.tieba.j.b dAo() {
        return this.mwJ;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cVg() {
        return this.mwN;
    }

    private void dyo() {
        this.mwO.clear();
        this.mwR = ac(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mwR.iQK = new Bundle();
        this.mwR.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwR.mxr.iQK = new Bundle();
        this.mwR.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(this.mwR);
        this.mwS = ac(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mwS.iQK = new Bundle();
        this.mwS.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwS.mxr.iQK = new Bundle();
        this.mwS.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(this.mwS);
        this.mwQ = ac(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mwQ.iQK = new Bundle();
        this.mwQ.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwQ.mxr.iQK = new Bundle();
        this.mwQ.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(this.mwQ);
        n ac = ac(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ac.mxr.iQK = new Bundle();
        ac.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(ac);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ac2 = ac(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ac2.iQK = new Bundle();
            ac2.mxr.iQK = new Bundle();
            ac2.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mwO.add(ac2);
        }
        this.mwT = ac(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mwT.iQK = new Bundle();
        this.mwT.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwT.mxr.iQK = new Bundle();
        this.mwT.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(this.mwT);
        n ac3 = ac(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        ac3.mxr.iQK = new Bundle();
        ac3.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mpo != null) {
            ac3.mxr.iQK.putString("book_jump_link", this.mpo.mob);
        }
        this.mwO.add(ac3);
        n ac4 = ac(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        ac4.mxr.iQK = new Bundle();
        ac4.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(ac4);
        n ac5 = ac(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ac5.mxr.iQK = new Bundle();
        ac5.mxr.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwO.add(ac5);
        n ac6 = ac(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        ac6.mxr.iQK = new Bundle();
        ac6.mxr.iQK.putString("key_service_centre", "");
        this.mwO.add(ac6);
    }

    private n ac(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gtC = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mxr = new com.baidu.tieba.personCenter.d.a();
        nVar.mxr.iQJ = i3;
        return nVar;
    }

    public List<bz> getNewestThreadList() {
        return this.mwY;
    }
}
