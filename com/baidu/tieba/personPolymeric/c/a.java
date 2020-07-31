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
    private PersonUserGodInfo kPb;
    private com.baidu.tieba.person.data.d kPd;
    public NicknameInfo kWA;
    public User kWB;
    private ArrayList<q> kWi;
    private c kWj;
    private com.baidu.tieba.person.a.f kWk;
    private m kWl;
    private AlaLiveInfoCoreData kWm;
    private com.baidu.tieba.i.a kWn;
    private List<AlaLiveInfoCoreData> kWo;
    protected g kWp;
    protected List<q> kWq;
    protected ArrayList<q> kWt;
    public n kWu;
    public n kWv;
    public n kWw;
    public n kWx;
    public n kWy;
    public UserAgreeInfo kWz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean kWe = true;
    protected int sex = 1;
    private int kWf = 1;
    private int kWg = 1;
    private int kWh = -1;
    public int maskType = 0;
    protected ArrayList<q> kWr = new ArrayList<>();
    private ArrayList<n> kWs = new ArrayList<>();
    private List<bv> kWC = new ArrayList();

    public abstract void cXC();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cxT() {
        return this.kWe;
    }

    public void tV(boolean z) {
        this.kWe = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.kWB = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.kWB);
            if (this.dSF == null) {
                this.dSF = new MetaData();
            }
            this.dSF.parserProtobuf(this.kWB);
            if (this.kPb == null) {
                this.kPb = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.kPb.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.epR == null) {
                this.epR = new AntiData();
            }
            this.epR.parserProtobuf(cVar.GetAntiStat());
            if (this.kWB != null) {
                if (this.kWB.priv_sets != null) {
                    this.kWf = this.kWB.priv_sets.like.intValue();
                    this.kWg = this.kWB.priv_sets.post.intValue();
                }
                this.sex = this.kWB.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.kWe = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.kPd = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!x.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cXD()) {
                eE(cVar.getConcernedForumList());
            }
            if (this.kWp == null) {
                c(this.kWB);
            }
            Random random = new Random();
            if (this.isHost && !x.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.kWB, postInfoList, random);
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
                                a(this.kWB, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && x.isEmpty(this.kWq) && x.isEmpty(this.kWt)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cVK();
                this.maskType = cVar.getMaskType();
            }
            this.kWz = cVar.getUserAgreeInfo();
            this.kWm = cVar.getLiveInfo();
            this.kWn = cVar.getGoodsWindowInfo();
            this.kWo = cVar.getLiveReplayInfo();
            this.kWA = cVar.getNicknameInfo();
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
                        this.kWC.add(bvVar);
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
            this.kWp = new g();
            this.kWp.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cXE() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.kWq == null) {
                this.kWq = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.kWh);
            this.kWh = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hba = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.haY = z;
            cardPersonDynamicThreadData.haX = z2;
            cardPersonDynamicThreadData.haZ = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.kWq.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cXE() || this.isHost) {
            if (this.kWt == null) {
                this.kWt = new ArrayList<>();
            }
            this.kWh = UtilHelper.getRandom(random, 3, this.kWh);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hba = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.haY = false;
            cardPersonDynamicThreadData.haX = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.kWh);
            this.kWt.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.isEmpty(list)) {
                if (this.kWq == null) {
                    this.kWq = new ArrayList();
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
                this.kWq.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cXD() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.kWq == null) {
                this.kWq = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.haX = z;
            bVar.haQ = as.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.haR = as.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.iSW = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.kWE = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.kWq.add(bVar);
            this.kWq.add(cR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<q> cXs() {
        if (this.kWk == null) {
            return null;
        }
        return this.kWk.getPhotoAlbum();
    }

    private void eE(List<ForumDynamic> list) {
        this.kWj = new c();
        this.kWj.kWG = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.kWK = forumDynamic.user_thread_count.intValue();
                this.kWj.kWG.add(fVar);
            }
        }
    }

    private boolean cXD() {
        if (this.isHost) {
            return false;
        }
        if (this.kWf == 3) {
            return true;
        }
        return this.kWf == 2 && !this.kWe;
    }

    public boolean cXE() {
        if (this.isHost) {
            return false;
        }
        if (this.kWg == 3) {
            return true;
        }
        return this.kWg == 2 && !this.kWe;
    }

    protected com.baidu.tieba.person.d cR(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.kKv = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cXF() {
        this.kWe = true;
        this.sex = 1;
        this.kWf = 1;
        this.kWg = 1;
        this.kWh = -1;
        this.mUserData = null;
        if (this.kWi != null) {
            this.kWi.clear();
        }
        this.kWi = null;
        this.kWj = null;
        this.kWk = null;
        this.kWl = null;
        this.kWp = null;
        this.mCardNullPolymericData = null;
        if (this.kWq != null) {
            this.kWq.clear();
        }
        if (this.kWt != null) {
            this.kWt.clear();
        }
        this.kWq = null;
        this.kWt = null;
        this.kWr.clear();
        this.kWz = null;
        this.kWA = null;
        this.maskType = 0;
        this.kWm = null;
        this.kWn = null;
        if (this.kWo != null) {
            this.kWo.clear();
        }
        if (this.kWC != null) {
            this.kWC.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.kWB;
    }

    public AntiData cax() {
        return this.epR;
    }

    public com.baidu.tieba.i.a cXG() {
        return this.kWn;
    }

    public ArrayList<q> cpm() {
        return this.kWr;
    }

    private void cVK() {
        this.kWs.clear();
        this.kWv = X(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.kWv.hrx = new Bundle();
        this.kWv.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWv.kWV.hrx = new Bundle();
        this.kWv.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(this.kWv);
        this.kWw = X(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.kWw.hrx = new Bundle();
        this.kWw.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWw.kWV.hrx = new Bundle();
        this.kWw.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(this.kWw);
        this.kWu = X(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.kWu.hrx = new Bundle();
        this.kWu.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWu.kWV.hrx = new Bundle();
        this.kWu.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(this.kWu);
        n X = X(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        X.kWV.hrx = new Bundle();
        X.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            X2.hrx = new Bundle();
            X2.kWV.hrx = new Bundle();
            X2.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.kWs.add(X2);
        }
        this.kWx = X(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.kWx.hrx = new Bundle();
        this.kWx.hrx.putBoolean("person_center_item_red_tip", true);
        this.kWx.kWV.hrx = new Bundle();
        this.kWx.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(this.kWx);
        n X3 = X(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        X3.kWV.hrx = new Bundle();
        X3.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.kPd != null) {
            X3.kWV.hrx.putString("book_jump_link", this.kPd.kNR);
        }
        this.kWs.add(X3);
        n X4 = X(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        X4.kWV.hrx = new Bundle();
        X4.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(X4);
        n X5 = X(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        X5.kWV.hrx = new Bundle();
        X5.kWV.hrx.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kWs.add(X5);
        n X6 = X(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        X6.kWV.hrx = new Bundle();
        X6.kWV.hrx.putString("key_service_centre", "");
        this.kWs.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.kPq = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.kWV = new com.baidu.tieba.personCenter.d.a();
        nVar.kWV.hrw = i3;
        return nVar;
    }

    public List<bv> getNewestThreadList() {
        return this.kWC;
    }
}
