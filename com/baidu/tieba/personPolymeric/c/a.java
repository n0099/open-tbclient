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
    private ArrayList<com.baidu.adp.widget.ListView.n> mAY;
    private c mAZ;
    private com.baidu.tieba.person.a.f mBa;
    private m mBb;
    private AlaLiveInfoCoreData mBc;
    private com.baidu.tieba.j.b mBd;
    private List<AlaLiveInfoCoreData> mBe;
    protected g mBf;
    protected List<com.baidu.adp.widget.ListView.n> mBh;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mBk;
    public n mBl;
    public n mBm;
    public n mBn;
    public n mBo;
    public n mBp;
    public UserAgreeInfo mBq;
    public NicknameInfo mBr;
    public User mBs;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private PersonUserGodInfo mtI;
    private com.baidu.tieba.person.data.d mtK;
    private boolean mAU = true;
    protected int sex = 1;
    private int mAV = 1;
    private int mAW = 1;
    private int mAX = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mBi = new ArrayList<>();
    private ArrayList<n> mBj = new ArrayList<>();
    private List<cb> mBt = new ArrayList();

    public abstract void dyC();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cYk() {
        return this.mAU;
    }

    public void wR(boolean z) {
        this.mAU = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mBs = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mBs);
            if (this.eRz == null) {
                this.eRz = new MetaData();
            }
            this.eRz.parserProtobuf(this.mBs);
            if (this.mtI == null) {
                this.mtI = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mtI.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fqK == null) {
                this.fqK = new AntiData();
            }
            this.fqK.parserProtobuf(cVar.GetAntiStat());
            if (this.mBs != null) {
                if (this.mBs.priv_sets != null) {
                    this.mAV = this.mBs.priv_sets.like.intValue();
                    this.mAW = this.mBs.priv_sets.post.intValue();
                }
                this.sex = this.mBs.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mAU = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mtK = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dyD()) {
                fy(cVar.getConcernedForumList());
            }
            if (this.mBf == null) {
                c(this.mBs);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mBs, postInfoList, random);
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
                                a(this.mBs, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mBh) && y.isEmpty(this.mBk)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dwG();
                this.maskType = cVar.getMaskType();
            }
            this.mBq = cVar.getUserAgreeInfo();
            this.mBc = cVar.getLiveInfo();
            this.mBd = cVar.getGoodsWindowInfo();
            this.mBe = cVar.getLiveReplayInfo();
            this.mBr = cVar.getNicknameInfo();
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
                        this.mBt.add(cbVar);
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
            this.mBf = new g();
            this.mBf.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dyE() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mBh == null) {
                this.mBh = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mAX);
            this.mAX = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iBA = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iBy = z;
            cardPersonDynamicThreadData.iBx = z2;
            cardPersonDynamicThreadData.iBz = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mBh.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dyE() || this.isHost) {
            if (this.mBk == null) {
                this.mBk = new ArrayList<>();
            }
            this.mAX = UtilHelper.getRandom(random, 3, this.mAX);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iBA = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iBy = false;
            cardPersonDynamicThreadData.iBx = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mAX);
            this.mBk.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mBh == null) {
                    this.mBh = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.iBx = z;
                dVar.sex = this.sex;
                dVar.iBq = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iBr = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iBr = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mBh.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dyD() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mBh == null) {
                this.mBh = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.iBx = z;
            bVar.iBq = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.iBr = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.kbI = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mBv = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mBh.add(bVar);
            this.mBh.add(de(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.n> dys() {
        if (this.mBa == null) {
            return null;
        }
        return this.mBa.getPhotoAlbum();
    }

    private void fy(List<ForumDynamic> list) {
        this.mAZ = new c();
        this.mAZ.mBx = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mBB = forumDynamic.user_thread_count.intValue();
                this.mAZ.mBx.add(fVar);
            }
        }
    }

    private boolean dyD() {
        if (this.isHost) {
            return false;
        }
        if (this.mAV == 3) {
            return true;
        }
        return this.mAV == 2 && !this.mAU;
    }

    public boolean dyE() {
        if (this.isHost) {
            return false;
        }
        if (this.mAW == 3) {
            return true;
        }
        return this.mAW == 2 && !this.mAU;
    }

    protected com.baidu.tieba.person.d de(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mpb = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dyF() {
        this.mAU = true;
        this.sex = 1;
        this.mAV = 1;
        this.mAW = 1;
        this.mAX = -1;
        this.mUserData = null;
        if (this.mAY != null) {
            this.mAY.clear();
        }
        this.mAY = null;
        this.mAZ = null;
        this.mBa = null;
        this.mBb = null;
        this.mBf = null;
        this.mCardNullPolymericData = null;
        if (this.mBh != null) {
            this.mBh.clear();
        }
        if (this.mBk != null) {
            this.mBk.clear();
        }
        this.mBh = null;
        this.mBk = null;
        this.mBi.clear();
        this.mBq = null;
        this.mBr = null;
        this.maskType = 0;
        this.mBc = null;
        this.mBd = null;
        if (this.mBe != null) {
            this.mBe.clear();
        }
        if (this.mBt != null) {
            this.mBt.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mBs;
    }

    public AntiData cBs() {
        return this.fqK;
    }

    public com.baidu.tieba.j.b dyG() {
        return this.mBd;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTo() {
        return this.mBi;
    }

    private void dwG() {
        this.mBj.clear();
        this.mBm = aa(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mBm.iRL = new Bundle();
        this.mBm.iRL.putBoolean("person_center_item_red_tip", true);
        this.mBm.mBM.iRL = new Bundle();
        this.mBm.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(this.mBm);
        this.mBn = aa(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mBn.iRL = new Bundle();
        this.mBn.iRL.putBoolean("person_center_item_red_tip", true);
        this.mBn.mBM.iRL = new Bundle();
        this.mBn.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(this.mBn);
        this.mBl = aa(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mBl.iRL = new Bundle();
        this.mBl.iRL.putBoolean("person_center_item_red_tip", true);
        this.mBl.mBM.iRL = new Bundle();
        this.mBl.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(this.mBl);
        n aa = aa(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        aa.mBM.iRL = new Bundle();
        aa.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            aa2.iRL = new Bundle();
            aa2.mBM.iRL = new Bundle();
            aa2.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mBj.add(aa2);
        }
        this.mBo = aa(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mBo.iRL = new Bundle();
        this.mBo.iRL.putBoolean("person_center_item_red_tip", true);
        this.mBo.mBM.iRL = new Bundle();
        this.mBo.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(this.mBo);
        n aa3 = aa(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        aa3.mBM.iRL = new Bundle();
        aa3.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mtK != null) {
            aa3.mBM.iRL.putString("book_jump_link", this.mtK.msy);
        }
        this.mBj.add(aa3);
        n aa4 = aa(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        aa4.mBM.iRL = new Bundle();
        aa4.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(aa4);
        n aa5 = aa(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        aa5.mBM.iRL = new Bundle();
        aa5.mBM.iRL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mBj.add(aa5);
        n aa6 = aa(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        aa6.mBM.iRL = new Bundle();
        aa6.mBM.iRL.putString("key_service_centre", "");
        this.mBj.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.grE = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mBM = new com.baidu.tieba.personCenter.d.a();
        nVar.mBM.iRK = i3;
        return nVar;
    }

    public List<cb> getNewestThreadList() {
        return this.mBt;
    }
}
