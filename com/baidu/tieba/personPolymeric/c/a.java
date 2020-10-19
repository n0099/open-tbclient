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
/* loaded from: classes24.dex */
public abstract class a {
    private AntiData eOB;
    public MetaData equ;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo lDj;
    private com.baidu.tieba.person.data.d lDl;
    private com.baidu.tieba.i.b lKA;
    private List<AlaLiveInfoCoreData> lKB;
    protected g lKC;
    protected List<com.baidu.adp.widget.ListView.q> lKD;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lKG;
    public n lKH;
    public n lKI;
    public n lKJ;
    public n lKK;
    public n lKL;
    public UserAgreeInfo lKM;
    public NicknameInfo lKN;
    public User lKO;
    private ArrayList<com.baidu.adp.widget.ListView.q> lKv;
    private c lKw;
    private com.baidu.tieba.person.a.f lKx;
    private m lKy;
    private AlaLiveInfoCoreData lKz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean lKr = true;
    protected int sex = 1;
    private int lKs = 1;
    private int lKt = 1;
    private int lKu = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lKE = new ArrayList<>();
    private ArrayList<n> lKF = new ArrayList<>();
    private List<bw> lKP = new ArrayList();

    public abstract void dpT();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cPZ() {
        return this.lKr;
    }

    public void vw(boolean z) {
        this.lKr = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.lKO = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.lKO);
            if (this.equ == null) {
                this.equ = new MetaData();
            }
            this.equ.parserProtobuf(this.lKO);
            if (this.lDj == null) {
                this.lDj = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.lDj.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eOB == null) {
                this.eOB = new AntiData();
            }
            this.eOB.parserProtobuf(cVar.GetAntiStat());
            if (this.lKO != null) {
                if (this.lKO.priv_sets != null) {
                    this.lKs = this.lKO.priv_sets.like.intValue();
                    this.lKt = this.lKO.priv_sets.post.intValue();
                }
                this.sex = this.lKO.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.lKr = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.lDl = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dpU()) {
                eX(cVar.getConcernedForumList());
            }
            if (this.lKC == null) {
                c(this.lKO);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.lKO, postInfoList, random);
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
                                a(this.lKO, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.lKD) && y.isEmpty(this.lKG)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dnX();
                this.maskType = cVar.getMaskType();
            }
            this.lKM = cVar.getUserAgreeInfo();
            this.lKz = cVar.getLiveInfo();
            this.lKA = cVar.getGoodsWindowInfo();
            this.lKB = cVar.getLiveReplayInfo();
            this.lKN = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bw bwVar = new bw();
                        bwVar.a(newestThreadList.get(i2));
                        bwVar.a(this.equ);
                        bwVar.biG();
                        this.lKP.add(bwVar);
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
            this.lKC = new g();
            this.lKC.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dpV() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.lKD == null) {
                this.lKD = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.lKu);
            this.lKu = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hJU = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hJS = z;
            cardPersonDynamicThreadData.hJR = z2;
            cardPersonDynamicThreadData.hJT = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.lKD.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dpV() || this.isHost) {
            if (this.lKG == null) {
                this.lKG = new ArrayList<>();
            }
            this.lKu = UtilHelper.getRandom(random, 3, this.lKu);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hJU = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hJS = false;
            cardPersonDynamicThreadData.hJR = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.lKu);
            this.lKG.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.lKD == null) {
                    this.lKD = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.hJR = z;
                dVar.sex = this.sex;
                dVar.hJK = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hJL = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hJL = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.lKD.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dpU() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.lKD == null) {
                this.lKD = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.hJR = z;
            bVar.hJK = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.hJL = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jeI = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.lKR = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.lKD.add(bVar);
            this.lKD.add(dc(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dpJ() {
        if (this.lKx == null) {
            return null;
        }
        return this.lKx.getPhotoAlbum();
    }

    private void eX(List<ForumDynamic> list) {
        this.lKw = new c();
        this.lKw.lKT = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.lKX = forumDynamic.user_thread_count.intValue();
                this.lKw.lKT.add(fVar);
            }
        }
    }

    private boolean dpU() {
        if (this.isHost) {
            return false;
        }
        if (this.lKs == 3) {
            return true;
        }
        return this.lKs == 2 && !this.lKr;
    }

    public boolean dpV() {
        if (this.isHost) {
            return false;
        }
        if (this.lKt == 3) {
            return true;
        }
        return this.lKt == 2 && !this.lKr;
    }

    protected com.baidu.tieba.person.d dc(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.lyC = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dpW() {
        this.lKr = true;
        this.sex = 1;
        this.lKs = 1;
        this.lKt = 1;
        this.lKu = -1;
        this.mUserData = null;
        if (this.lKv != null) {
            this.lKv.clear();
        }
        this.lKv = null;
        this.lKw = null;
        this.lKx = null;
        this.lKy = null;
        this.lKC = null;
        this.mCardNullPolymericData = null;
        if (this.lKD != null) {
            this.lKD.clear();
        }
        if (this.lKG != null) {
            this.lKG.clear();
        }
        this.lKD = null;
        this.lKG = null;
        this.lKE.clear();
        this.lKM = null;
        this.lKN = null;
        this.maskType = 0;
        this.lKz = null;
        this.lKA = null;
        if (this.lKB != null) {
            this.lKB.clear();
        }
        if (this.lKP != null) {
            this.lKP.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.lKO;
    }

    public AntiData crF() {
        return this.eOB;
    }

    public com.baidu.tieba.i.b dpX() {
        return this.lKA;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cHw() {
        return this.lKE;
    }

    private void dnX() {
        this.lKF.clear();
        this.lKI = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.lKI.iar = new Bundle();
        this.lKI.iar.putBoolean("person_center_item_red_tip", true);
        this.lKI.lLi.iar = new Bundle();
        this.lKI.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(this.lKI);
        this.lKJ = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.lKJ.iar = new Bundle();
        this.lKJ.iar.putBoolean("person_center_item_red_tip", true);
        this.lKJ.lLi.iar = new Bundle();
        this.lKJ.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(this.lKJ);
        this.lKH = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.lKH.iar = new Bundle();
        this.lKH.iar.putBoolean("person_center_item_red_tip", true);
        this.lKH.lLi.iar = new Bundle();
        this.lKH.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(this.lKH);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.lLi.iar = new Bundle();
        Y.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.iar = new Bundle();
            Y2.lLi.iar = new Bundle();
            Y2.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.lKF.add(Y2);
        }
        this.lKK = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.lKK.iar = new Bundle();
        this.lKK.iar.putBoolean("person_center_item_red_tip", true);
        this.lKK.lLi.iar = new Bundle();
        this.lKK.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(this.lKK);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.lLi.iar = new Bundle();
        Y3.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.lDl != null) {
            Y3.lLi.iar.putString("book_jump_link", this.lDl.lBZ);
        }
        this.lKF.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.lLi.iar = new Bundle();
        Y4.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.lLi.iar = new Bundle();
        Y5.lLi.iar.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lKF.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.lLi.iar = new Bundle();
        Y6.lLi.iar.putString("key_service_centre", "");
        this.lKF.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.lDy = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.lLi = new com.baidu.tieba.personCenter.d.a();
        nVar.lLi.iaq = i3;
        return nVar;
    }

    public List<bw> getNewestThreadList() {
        return this.lKP;
    }
}
