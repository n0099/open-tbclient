package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes8.dex */
public abstract class a {
    public MetaData eRz;
    private AntiData fqK;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    public n mBA;
    public n mBB;
    public n mBC;
    public n mBD;
    public n mBE;
    public UserAgreeInfo mBF;
    public NicknameInfo mBG;
    public User mBH;
    private ArrayList<com.baidu.adp.widget.ListView.n> mBo;
    private c mBp;
    private com.baidu.tieba.person.a.f mBq;
    private m mBr;
    private AlaLiveInfoCoreData mBs;
    private com.baidu.tieba.j.b mBt;
    private List<AlaLiveInfoCoreData> mBu;
    protected g mBv;
    protected List<com.baidu.adp.widget.ListView.n> mBw;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mBz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private PersonUserGodInfo mtX;
    private com.baidu.tieba.person.data.d mtZ;
    private boolean mBk = true;
    protected int sex = 1;
    private int mBl = 1;
    private int mBm = 1;
    private int mBn = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mBx = new ArrayList<>();
    private ArrayList<n> mBy = new ArrayList<>();
    private List<cb> mBI = new ArrayList();

    public abstract void dyJ();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cYr() {
        return this.mBk;
    }

    public void wR(boolean z) {
        this.mBk = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mBH = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mBH);
            if (this.eRz == null) {
                this.eRz = new MetaData();
            }
            this.eRz.parserProtobuf(this.mBH);
            if (this.mtX == null) {
                this.mtX = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mtX.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fqK == null) {
                this.fqK = new AntiData();
            }
            this.fqK.parserProtobuf(cVar.GetAntiStat());
            if (this.mBH != null) {
                if (this.mBH.priv_sets != null) {
                    this.mBl = this.mBH.priv_sets.like.intValue();
                    this.mBm = this.mBH.priv_sets.post.intValue();
                }
                this.sex = this.mBH.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mBk = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mtZ = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dyK()) {
                fy(cVar.getConcernedForumList());
            }
            if (this.mBv == null) {
                c(this.mBH);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mBH, postInfoList, random);
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
                            str = str3;
                        } else {
                            z2 = true;
                            str = dateBytime;
                            str2 = chineseMonthBytime;
                            yearBytime = yearBytime2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(this.mBH, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mBw) && y.isEmpty(this.mBz)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dwN();
                this.maskType = cVar.getMaskType();
            }
            this.mBF = cVar.getUserAgreeInfo();
            this.mBs = cVar.getLiveInfo();
            this.mBt = cVar.getGoodsWindowInfo();
            this.mBu = cVar.getLiveReplayInfo();
            this.mBG = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        cb cbVar = new cb();
                        cbVar.a(newestThreadList.get(i2));
                        cbVar.a(this.eRz);
                        cbVar.boo();
                        this.mBI.add(cbVar);
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
            this.mBv = new g();
            this.mBv.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dyL() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mBw == null) {
                this.mBw = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mBn);
            this.mBn = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iBO = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iBM = z;
            cardPersonDynamicThreadData.iBL = z2;
            cardPersonDynamicThreadData.iBN = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mBw.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dyL() || this.isHost) {
            if (this.mBz == null) {
                this.mBz = new ArrayList<>();
            }
            this.mBn = UtilHelper.getRandom(random, 3, this.mBn);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iBO = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iBM = false;
            cardPersonDynamicThreadData.iBL = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mBn);
            this.mBz.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mBw == null) {
                    this.mBw = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.iBL = z;
                dVar.sex = this.sex;
                dVar.iBE = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iBF = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iBF = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mBw.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dyK() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mBw == null) {
                this.mBw = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.iBL = z;
            bVar.iBE = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.iBF = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.kbW = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mBK = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mBw.add(bVar);
            this.mBw.add(df(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.n> dyz() {
        if (this.mBq == null) {
            return null;
        }
        return this.mBq.getPhotoAlbum();
    }

    private void fy(List<ForumDynamic> list) {
        this.mBp = new c();
        this.mBp.mBM = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mBQ = forumDynamic.user_thread_count.intValue();
                this.mBp.mBM.add(fVar);
            }
        }
    }

    private boolean dyK() {
        if (this.isHost) {
            return false;
        }
        if (this.mBl == 3) {
            return true;
        }
        return this.mBl == 2 && !this.mBk;
    }

    public boolean dyL() {
        if (this.isHost) {
            return false;
        }
        if (this.mBm == 3) {
            return true;
        }
        return this.mBm == 2 && !this.mBk;
    }

    protected com.baidu.tieba.person.d df(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mpq = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dyM() {
        this.mBk = true;
        this.sex = 1;
        this.mBl = 1;
        this.mBm = 1;
        this.mBn = -1;
        this.mUserData = null;
        if (this.mBo != null) {
            this.mBo.clear();
        }
        this.mBo = null;
        this.mBp = null;
        this.mBq = null;
        this.mBr = null;
        this.mBv = null;
        this.mCardNullPolymericData = null;
        if (this.mBw != null) {
            this.mBw.clear();
        }
        if (this.mBz != null) {
            this.mBz.clear();
        }
        this.mBw = null;
        this.mBz = null;
        this.mBx.clear();
        this.mBF = null;
        this.mBG = null;
        this.maskType = 0;
        this.mBs = null;
        this.mBt = null;
        if (this.mBu != null) {
            this.mBu.clear();
        }
        if (this.mBI != null) {
            this.mBI.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mBH;
    }

    public AntiData cBz() {
        return this.fqK;
    }

    public com.baidu.tieba.j.b dyN() {
        return this.mBt;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTv() {
        return this.mBx;
    }

    private void dwN() {
        this.mBy.clear();
        this.mBB = aa(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mBB.iRZ = new Bundle();
        this.mBB.iRZ.putBoolean("person_center_item_red_tip", true);
        this.mBB.mCb.iRZ = new Bundle();
        this.mBB.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(this.mBB);
        this.mBC = aa(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mBC.iRZ = new Bundle();
        this.mBC.iRZ.putBoolean("person_center_item_red_tip", true);
        this.mBC.mCb.iRZ = new Bundle();
        this.mBC.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(this.mBC);
        this.mBA = aa(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mBA.iRZ = new Bundle();
        this.mBA.iRZ.putBoolean("person_center_item_red_tip", true);
        this.mBA.mCb.iRZ = new Bundle();
        this.mBA.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(this.mBA);
        n aa = aa(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        aa.mCb.iRZ = new Bundle();
        aa.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            aa2.iRZ = new Bundle();
            aa2.mCb.iRZ = new Bundle();
            aa2.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mBy.add(aa2);
        }
        this.mBD = aa(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mBD.iRZ = new Bundle();
        this.mBD.iRZ.putBoolean("person_center_item_red_tip", true);
        this.mBD.mCb.iRZ = new Bundle();
        this.mBD.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(this.mBD);
        n aa3 = aa(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        aa3.mCb.iRZ = new Bundle();
        aa3.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mtZ != null) {
            aa3.mCb.iRZ.putString("book_jump_link", this.mtZ.msN);
        }
        this.mBy.add(aa3);
        n aa4 = aa(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        aa4.mCb.iRZ = new Bundle();
        aa4.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(aa4);
        n aa5 = aa(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        aa5.mCb.iRZ = new Bundle();
        aa5.mCb.iRZ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBy.add(aa5);
        n aa6 = aa(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        aa6.mCb.iRZ = new Bundle();
        aa6.mCb.iRZ.putString("key_service_centre", "");
        this.mBy.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.grS = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mCb = new com.baidu.tieba.personCenter.d.a();
        nVar.mCb.iRY = i3;
        return nVar;
    }

    public List<cb> getNewestThreadList() {
        return this.mBI;
    }
}
