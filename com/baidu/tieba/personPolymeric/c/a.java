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
    private PersonUserGodInfo mpl;
    private com.baidu.tieba.person.data.d mpn;
    private ArrayList<com.baidu.adp.widget.ListView.n> mwD;
    private c mwE;
    private com.baidu.tieba.person.a.f mwF;
    private m mwG;
    private AlaLiveInfoCoreData mwH;
    private com.baidu.tieba.j.b mwI;
    private List<AlaLiveInfoCoreData> mwJ;
    protected g mwK;
    protected List<com.baidu.adp.widget.ListView.n> mwL;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mwO;
    public n mwP;
    public n mwQ;
    public n mwR;
    public n mwS;
    public n mwT;
    public UserAgreeInfo mwU;
    public NicknameInfo mwV;
    public User mwW;
    private boolean mwz = true;
    protected int sex = 1;
    private int mwA = 1;
    private int mwB = 1;
    private int mwC = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mwM = new ArrayList<>();
    private ArrayList<n> mwN = new ArrayList<>();
    private List<bz> mwX = new ArrayList();

    public abstract void dAl();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean dae() {
        return this.mwz;
    }

    public void wE(boolean z) {
        this.mwz = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mwW = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mwW);
            if (this.eTY == null) {
                this.eTY = new MetaData();
            }
            this.eTY.parserProtobuf(this.mwW);
            if (this.mpl == null) {
                this.mpl = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mpl.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.ftd == null) {
                this.ftd = new AntiData();
            }
            this.ftd.parserProtobuf(cVar.GetAntiStat());
            if (this.mwW != null) {
                if (this.mwW.priv_sets != null) {
                    this.mwA = this.mwW.priv_sets.like.intValue();
                    this.mwB = this.mwW.priv_sets.post.intValue();
                }
                this.sex = this.mwW.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mwz = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mpn = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!x.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dAm()) {
                fA(cVar.getConcernedForumList());
            }
            if (this.mwK == null) {
                c(this.mwW);
            }
            Random random = new Random();
            if (this.isHost && !x.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mwW, postInfoList, random);
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
                                a(this.mwW, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && x.isEmpty(this.mwL) && x.isEmpty(this.mwO)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dyp();
                this.maskType = cVar.getMaskType();
            }
            this.mwU = cVar.getUserAgreeInfo();
            this.mwH = cVar.getLiveInfo();
            this.mwI = cVar.getGoodsWindowInfo();
            this.mwJ = cVar.getLiveReplayInfo();
            this.mwV = cVar.getNicknameInfo();
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
                        bzVar.brP();
                        this.mwX.add(bzVar);
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
            this.mwK = new g();
            this.mwK.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dAn() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mwL == null) {
                this.mwL = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mwC);
            this.mwC = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iAx = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iAv = z;
            cardPersonDynamicThreadData.iAu = z2;
            cardPersonDynamicThreadData.iAw = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mwL.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dAn() || this.isHost) {
            if (this.mwO == null) {
                this.mwO = new ArrayList<>();
            }
            this.mwC = UtilHelper.getRandom(random, 3, this.mwC);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iAx = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iAv = false;
            cardPersonDynamicThreadData.iAu = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mwC);
            this.mwO.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.isEmpty(list)) {
                if (this.mwL == null) {
                    this.mwL = new ArrayList();
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
                this.mwL.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dAm() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mwL == null) {
                this.mwL = new ArrayList();
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
            bVar.mwZ = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mwL.add(bVar);
            this.mwL.add(dh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.n> dAb() {
        if (this.mwF == null) {
            return null;
        }
        return this.mwF.getPhotoAlbum();
    }

    private void fA(List<ForumDynamic> list) {
        this.mwE = new c();
        this.mwE.mxb = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mxf = forumDynamic.user_thread_count.intValue();
                this.mwE.mxb.add(fVar);
            }
        }
    }

    private boolean dAm() {
        if (this.isHost) {
            return false;
        }
        if (this.mwA == 3) {
            return true;
        }
        return this.mwA == 2 && !this.mwz;
    }

    public boolean dAn() {
        if (this.isHost) {
            return false;
        }
        if (this.mwB == 3) {
            return true;
        }
        return this.mwB == 2 && !this.mwz;
    }

    protected com.baidu.tieba.person.d dh(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mkE = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dAo() {
        this.mwz = true;
        this.sex = 1;
        this.mwA = 1;
        this.mwB = 1;
        this.mwC = -1;
        this.mUserData = null;
        if (this.mwD != null) {
            this.mwD.clear();
        }
        this.mwD = null;
        this.mwE = null;
        this.mwF = null;
        this.mwG = null;
        this.mwK = null;
        this.mCardNullPolymericData = null;
        if (this.mwL != null) {
            this.mwL.clear();
        }
        if (this.mwO != null) {
            this.mwO.clear();
        }
        this.mwL = null;
        this.mwO = null;
        this.mwM.clear();
        this.mwU = null;
        this.mwV = null;
        this.maskType = 0;
        this.mwH = null;
        this.mwI = null;
        if (this.mwJ != null) {
            this.mwJ.clear();
        }
        if (this.mwX != null) {
            this.mwX.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mwW;
    }

    public AntiData cDZ() {
        return this.ftd;
    }

    public com.baidu.tieba.j.b dAp() {
        return this.mwI;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cVh() {
        return this.mwM;
    }

    private void dyp() {
        this.mwN.clear();
        this.mwQ = ac(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mwQ.iQK = new Bundle();
        this.mwQ.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwQ.mxq.iQK = new Bundle();
        this.mwQ.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(this.mwQ);
        this.mwR = ac(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mwR.iQK = new Bundle();
        this.mwR.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwR.mxq.iQK = new Bundle();
        this.mwR.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(this.mwR);
        this.mwP = ac(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mwP.iQK = new Bundle();
        this.mwP.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwP.mxq.iQK = new Bundle();
        this.mwP.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(this.mwP);
        n ac = ac(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ac.mxq.iQK = new Bundle();
        ac.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(ac);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ac2 = ac(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ac2.iQK = new Bundle();
            ac2.mxq.iQK = new Bundle();
            ac2.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mwN.add(ac2);
        }
        this.mwS = ac(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mwS.iQK = new Bundle();
        this.mwS.iQK.putBoolean("person_center_item_red_tip", true);
        this.mwS.mxq.iQK = new Bundle();
        this.mwS.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(this.mwS);
        n ac3 = ac(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        ac3.mxq.iQK = new Bundle();
        ac3.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mpn != null) {
            ac3.mxq.iQK.putString("book_jump_link", this.mpn.moa);
        }
        this.mwN.add(ac3);
        n ac4 = ac(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        ac4.mxq.iQK = new Bundle();
        ac4.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(ac4);
        n ac5 = ac(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ac5.mxq.iQK = new Bundle();
        ac5.mxq.iQK.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mwN.add(ac5);
        n ac6 = ac(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        ac6.mxq.iQK = new Bundle();
        ac6.mxq.iQK.putString("key_service_centre", "");
        this.mwN.add(ac6);
    }

    private n ac(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gtC = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mxq = new com.baidu.tieba.personCenter.d.a();
        nVar.mxq.iQJ = i3;
        return nVar;
    }

    public List<bz> getNewestThreadList() {
        return this.mwX;
    }
}
