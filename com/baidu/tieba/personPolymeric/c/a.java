package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.as;
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
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes18.dex */
public abstract class a {
    public MetaData dSF;
    private AntiData epR;
    protected boolean isHost;
    private PersonUserGodInfo kPd;
    private com.baidu.tieba.person.data.d kPf;
    public n kWA;
    public UserAgreeInfo kWB;
    public NicknameInfo kWC;
    public User kWD;
    private ArrayList<q> kWk;
    private c kWl;
    private com.baidu.tieba.person.a.f kWm;
    private m kWn;
    private AlaLiveInfoCoreData kWo;
    private com.baidu.tieba.i.a kWp;
    private List<AlaLiveInfoCoreData> kWq;
    protected g kWr;
    protected List<q> kWs;
    protected ArrayList<q> kWv;
    public n kWw;
    public n kWx;
    public n kWy;
    public n kWz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean kWg = true;
    protected int sex = 1;
    private int kWh = 1;
    private int kWi = 1;
    private int kWj = -1;
    public int maskType = 0;
    protected ArrayList<q> kWt = new ArrayList<>();
    private ArrayList<n> kWu = new ArrayList<>();
    private List<bv> kWE = new ArrayList();

    public abstract void cXC();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cxT() {
        return this.kWg;
    }

    public void tV(boolean z) {
        this.kWg = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.kWD = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.kWD);
            if (this.dSF == null) {
                this.dSF = new MetaData();
            }
            this.dSF.parserProtobuf(this.kWD);
            if (this.kPd == null) {
                this.kPd = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.kPd.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.epR == null) {
                this.epR = new AntiData();
            }
            this.epR.parserProtobuf(cVar.GetAntiStat());
            if (this.kWD != null) {
                if (this.kWD.priv_sets != null) {
                    this.kWh = this.kWD.priv_sets.like.intValue();
                    this.kWi = this.kWD.priv_sets.post.intValue();
                }
                this.sex = this.kWD.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.kWg = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.kPf = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!x.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cXD()) {
                eE(cVar.getConcernedForumList());
            }
            if (this.kWr == null) {
                c(this.kWD);
            }
            Random random = new Random();
            if (this.isHost && !x.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.kWD, postInfoList, random);
                    }
                }
            }
            String yearBytime = as.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!x.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = as.getYearBytime(longValue);
                        String chineseMonthBytime = as.getChineseMonthBytime(longValue);
                        String dateBytime = as.getDateBytime(longValue);
                        if (as.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (as.equals(dateBytime, str3) && as.equals(chineseMonthBytime, str2) && as.equals(yearBytime2, yearBytime)) {
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
                                a(this.kWD, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && x.isEmpty(this.kWs) && x.isEmpty(this.kWv)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cVK();
                this.maskType = cVar.getMaskType();
            }
            this.kWB = cVar.getUserAgreeInfo();
            this.kWo = cVar.getLiveInfo();
            this.kWp = cVar.getGoodsWindowInfo();
            this.kWq = cVar.getLiveReplayInfo();
            this.kWC = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!x.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bv bvVar = new bv();
                        bvVar.a(newestThreadList.get(i2));
                        bvVar.a(this.dSF);
                        bvVar.aWK();
                        this.kWE.add(bvVar);
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
            this.kWr = new g();
            this.kWr.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cXE() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.kWs == null) {
                this.kWs = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.kWj);
            this.kWj = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hba = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.haY = z;
            cardPersonDynamicThreadData.haX = z2;
            cardPersonDynamicThreadData.haZ = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.kWs.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cXE() || this.isHost) {
            if (this.kWv == null) {
                this.kWv = new ArrayList<>();
            }
            this.kWj = UtilHelper.getRandom(random, 3, this.kWj);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hba = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.haY = false;
            cardPersonDynamicThreadData.haX = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.kWj);
            this.kWv.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.isEmpty(list)) {
                if (this.kWs == null) {
                    this.kWs = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.haX = z;
                dVar.sex = this.sex;
                dVar.haQ = as.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.haR = as.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.haR = as.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.kWs.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cXD() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.kWs == null) {
                this.kWs = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.haX = z;
            bVar.haQ = as.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.haR = as.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.iSY = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.kWG = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.kWs.add(bVar);
            this.kWs.add(cR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<q> cXs() {
        if (this.kWm == null) {
            return null;
        }
        return this.kWm.getPhotoAlbum();
    }

    private void eE(List<ForumDynamic> list) {
        this.kWl = new c();
        this.kWl.kWI = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.kWM = forumDynamic.user_thread_count.intValue();
                this.kWl.kWI.add(fVar);
            }
        }
    }

    private boolean cXD() {
        if (this.isHost) {
            return false;
        }
        if (this.kWh == 3) {
            return true;
        }
        return this.kWh == 2 && !this.kWg;
    }

    public boolean cXE() {
        if (this.isHost) {
            return false;
        }
        if (this.kWi == 3) {
            return true;
        }
        return this.kWi == 2 && !this.kWg;
    }

    protected com.baidu.tieba.person.d cR(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.kKx = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cXF() {
        this.kWg = true;
        this.sex = 1;
        this.kWh = 1;
        this.kWi = 1;
        this.kWj = -1;
        this.mUserData = null;
        if (this.kWk != null) {
            this.kWk.clear();
        }
        this.kWk = null;
        this.kWl = null;
        this.kWm = null;
        this.kWn = null;
        this.kWr = null;
        this.mCardNullPolymericData = null;
        if (this.kWs != null) {
            this.kWs.clear();
        }
        if (this.kWv != null) {
            this.kWv.clear();
        }
        this.kWs = null;
        this.kWv = null;
        this.kWt.clear();
        this.kWB = null;
        this.kWC = null;
        this.maskType = 0;
        this.kWo = null;
        this.kWp = null;
        if (this.kWq != null) {
            this.kWq.clear();
        }
        if (this.kWE != null) {
            this.kWE.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.kWD;
    }

    public AntiData cax() {
        return this.epR;
    }

    public com.baidu.tieba.i.a cXG() {
        return this.kWp;
    }

    public ArrayList<q> cpm() {
        return this.kWt;
    }

    private void cVK() {
        this.kWu.clear();
        this.kWx = X(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.kWx.hrx = new Bundle();
        this.kWx.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWx.kWX.hrx = new Bundle();
        this.kWx.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(this.kWx);
        this.kWy = X(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.kWy.hrx = new Bundle();
        this.kWy.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWy.kWX.hrx = new Bundle();
        this.kWy.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(this.kWy);
        this.kWw = X(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.kWw.hrx = new Bundle();
        this.kWw.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWw.kWX.hrx = new Bundle();
        this.kWw.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(this.kWw);
        n X = X(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        X.kWX.hrx = new Bundle();
        X.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            X2.hrx = new Bundle();
            X2.kWX.hrx = new Bundle();
            X2.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.kWu.add(X2);
        }
        this.kWz = X(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.kWz.hrx = new Bundle();
        this.kWz.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWz.kWX.hrx = new Bundle();
        this.kWz.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(this.kWz);
        n X3 = X(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        X3.kWX.hrx = new Bundle();
        X3.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.kPf != null) {
            X3.kWX.hrx.putString("book_jump_link", this.kPf.kNT);
        }
        this.kWu.add(X3);
        n X4 = X(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        X4.kWX.hrx = new Bundle();
        X4.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(X4);
        n X5 = X(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        X5.kWX.hrx = new Bundle();
        X5.kWX.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWu.add(X5);
        n X6 = X(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        X6.kWX.hrx = new Bundle();
        X6.kWX.hrx.putString("key_service_centre", "");
        this.kWu.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.kPs = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.kWX = new com.baidu.tieba.personCenter.d.a();
        nVar.kWX.hrw = i3;
        return nVar;
    }

    public List<bv> getNewestThreadList() {
        return this.kWE;
    }
}
