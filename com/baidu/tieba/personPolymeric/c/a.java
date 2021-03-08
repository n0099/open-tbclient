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
/* loaded from: classes7.dex */
public abstract class a {
    public MetaData eTa;
    private AntiData fsl;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private List<AlaLiveInfoCoreData> mDA;
    protected g mDB;
    protected List<com.baidu.adp.widget.ListView.n> mDC;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mDF;
    public n mDG;
    public n mDH;
    public n mDI;
    public n mDJ;
    public n mDK;
    public UserAgreeInfo mDL;
    public NicknameInfo mDM;
    public User mDN;
    private ArrayList<com.baidu.adp.widget.ListView.n> mDs;
    private c mDt;
    private com.baidu.tieba.person.a.f mDu;
    private m mDv;
    private AlaLiveInfoCoreData mDw;
    private com.baidu.tieba.j.b mDz;
    private UserData mUserData;
    private PersonUserGodInfo mvZ;
    private com.baidu.tieba.person.data.d mwb;
    private boolean mDo = true;
    protected int sex = 1;
    private int mDp = 1;
    private int mDq = 1;
    private int mDr = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.n> mDD = new ArrayList<>();
    private ArrayList<n> mDE = new ArrayList<>();
    private List<cb> mDO = new ArrayList();

    public abstract void dyS();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cYy() {
        return this.mDo;
    }

    public void wR(boolean z) {
        this.mDo = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mDN = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mDN);
            if (this.eTa == null) {
                this.eTa = new MetaData();
            }
            this.eTa.parserProtobuf(this.mDN);
            if (this.mvZ == null) {
                this.mvZ = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mvZ.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fsl == null) {
                this.fsl = new AntiData();
            }
            this.fsl.parserProtobuf(cVar.GetAntiStat());
            if (this.mDN != null) {
                if (this.mDN.priv_sets != null) {
                    this.mDp = this.mDN.priv_sets.like.intValue();
                    this.mDq = this.mDN.priv_sets.post.intValue();
                }
                this.sex = this.mDN.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mDo = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mwb = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dyT()) {
                fy(cVar.getConcernedForumList());
            }
            if (this.mDB == null) {
                c(this.mDN);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mDN, postInfoList, random);
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
                                a(this.mDN, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mDC) && y.isEmpty(this.mDF)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dwW();
                this.maskType = cVar.getMaskType();
            }
            this.mDL = cVar.getUserAgreeInfo();
            this.mDw = cVar.getLiveInfo();
            this.mDz = cVar.getGoodsWindowInfo();
            this.mDA = cVar.getLiveReplayInfo();
            this.mDM = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        cb cbVar = new cb();
                        cbVar.a(newestThreadList.get(i2));
                        cbVar.a(this.eTa);
                        cbVar.boq();
                        this.mDO.add(cbVar);
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
            this.mDB = new g();
            this.mDB.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dyU() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mDC == null) {
                this.mDC = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mDr);
            this.mDr = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iDx = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iDv = z;
            cardPersonDynamicThreadData.iDu = z2;
            cardPersonDynamicThreadData.iDw = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mDC.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dyU() || this.isHost) {
            if (this.mDF == null) {
                this.mDF = new ArrayList<>();
            }
            this.mDr = UtilHelper.getRandom(random, 3, this.mDr);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.iDx = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.iDv = false;
            cardPersonDynamicThreadData.iDu = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mDr);
            this.mDF.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mDC == null) {
                    this.mDC = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.iDu = z;
                dVar.sex = this.sex;
                dVar.iDn = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iDo = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.iDo = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mDC.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dyT() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mDC == null) {
                this.mDC = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.iDu = z;
            bVar.iDn = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.iDo = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.kdY = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mDQ = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mDC.add(bVar);
            this.mDC.add(df(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.n> dyI() {
        if (this.mDu == null) {
            return null;
        }
        return this.mDu.getPhotoAlbum();
    }

    private void fy(List<ForumDynamic> list) {
        this.mDt = new c();
        this.mDt.mDS = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mDW = forumDynamic.user_thread_count.intValue();
                this.mDt.mDS.add(fVar);
            }
        }
    }

    private boolean dyT() {
        if (this.isHost) {
            return false;
        }
        if (this.mDp == 3) {
            return true;
        }
        return this.mDp == 2 && !this.mDo;
    }

    public boolean dyU() {
        if (this.isHost) {
            return false;
        }
        if (this.mDq == 3) {
            return true;
        }
        return this.mDq == 2 && !this.mDo;
    }

    protected com.baidu.tieba.person.d df(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mrs = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dyV() {
        this.mDo = true;
        this.sex = 1;
        this.mDp = 1;
        this.mDq = 1;
        this.mDr = -1;
        this.mUserData = null;
        if (this.mDs != null) {
            this.mDs.clear();
        }
        this.mDs = null;
        this.mDt = null;
        this.mDu = null;
        this.mDv = null;
        this.mDB = null;
        this.mCardNullPolymericData = null;
        if (this.mDC != null) {
            this.mDC.clear();
        }
        if (this.mDF != null) {
            this.mDF.clear();
        }
        this.mDC = null;
        this.mDF = null;
        this.mDD.clear();
        this.mDL = null;
        this.mDM = null;
        this.maskType = 0;
        this.mDw = null;
        this.mDz = null;
        if (this.mDA != null) {
            this.mDA.clear();
        }
        if (this.mDO != null) {
            this.mDO.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mDN;
    }

    public AntiData cBF() {
        return this.fsl;
    }

    public com.baidu.tieba.j.b dyW() {
        return this.mDz;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cTC() {
        return this.mDD;
    }

    private void dwW() {
        this.mDE.clear();
        this.mDH = aa(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mDH.iTI = new Bundle();
        this.mDH.iTI.putBoolean("person_center_item_red_tip", true);
        this.mDH.mEh.iTI = new Bundle();
        this.mDH.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(this.mDH);
        this.mDI = aa(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mDI.iTI = new Bundle();
        this.mDI.iTI.putBoolean("person_center_item_red_tip", true);
        this.mDI.mEh.iTI = new Bundle();
        this.mDI.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(this.mDI);
        this.mDG = aa(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mDG.iTI = new Bundle();
        this.mDG.iTI.putBoolean("person_center_item_red_tip", true);
        this.mDG.mEh.iTI = new Bundle();
        this.mDG.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(this.mDG);
        n aa = aa(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        aa.mEh.iTI = new Bundle();
        aa.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(aa);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n aa2 = aa(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            aa2.iTI = new Bundle();
            aa2.mEh.iTI = new Bundle();
            aa2.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mDE.add(aa2);
        }
        this.mDJ = aa(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mDJ.iTI = new Bundle();
        this.mDJ.iTI.putBoolean("person_center_item_red_tip", true);
        this.mDJ.mEh.iTI = new Bundle();
        this.mDJ.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(this.mDJ);
        n aa3 = aa(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        aa3.mEh.iTI = new Bundle();
        aa3.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mwb != null) {
            aa3.mEh.iTI.putString("book_jump_link", this.mwb.muP);
        }
        this.mDE.add(aa3);
        n aa4 = aa(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        aa4.mEh.iTI = new Bundle();
        aa4.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(aa4);
        n aa5 = aa(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        aa5.mEh.iTI = new Bundle();
        aa5.mEh.iTI.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mDE.add(aa5);
        n aa6 = aa(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        aa6.mEh.iTI = new Bundle();
        aa6.mEh.iTI.putString("key_service_centre", "");
        this.mDE.add(aa6);
    }

    private n aa(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gtB = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mEh = new com.baidu.tieba.personCenter.d.a();
        nVar.mEh.iTH = i3;
        return nVar;
    }

    public List<cb> getNewestThreadList() {
        return this.mDO;
    }
}
