package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes11.dex */
public abstract class a {
    public MetaData dMu;
    private AntiData ejE;
    protected boolean isHost;
    private PersonUserGodInfo kGa;
    private com.baidu.tieba.person.data.d kGc;
    public n kNA;
    public UserAgreeInfo kNB;
    public NicknameInfo kNC;
    public User kND;
    private ArrayList<q> kNk;
    private c kNl;
    private com.baidu.tieba.person.a.f kNm;
    private m kNn;
    private AlaLiveInfoCoreData kNo;
    private com.baidu.tieba.i.a kNp;
    private List<AlaLiveInfoCoreData> kNq;
    protected g kNr;
    protected List<q> kNs;
    protected ArrayList<q> kNv;
    public n kNw;
    public n kNx;
    public n kNy;
    public n kNz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean kNg = true;
    protected int sex = 1;
    private int kNh = 1;
    private int kNi = 1;
    private int kNj = -1;
    public int maskType = 0;
    protected ArrayList<q> kNt = new ArrayList<>();
    private ArrayList<n> kNu = new ArrayList<>();
    private List<bu> kNE = new ArrayList();

    public abstract void cTM();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean ctR() {
        return this.kNg;
    }

    public void tp(boolean z) {
        this.kNg = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.kND = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.kND);
            if (this.dMu == null) {
                this.dMu = new MetaData();
            }
            this.dMu.parserProtobuf(this.kND);
            if (this.kGa == null) {
                this.kGa = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.kGa.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.ejE == null) {
                this.ejE = new AntiData();
            }
            this.ejE.parserProtobuf(cVar.GetAntiStat());
            if (this.kND != null) {
                if (this.kND.priv_sets != null) {
                    this.kNh = this.kND.priv_sets.like.intValue();
                    this.kNi = this.kND.priv_sets.post.intValue();
                }
                this.sex = this.kND.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.kNg = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.kGc = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!w.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cTN()) {
                ey(cVar.getConcernedForumList());
            }
            if (this.kNr == null) {
                c(this.kND);
            }
            Random random = new Random();
            if (this.isHost && !w.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.kND, postInfoList, random);
                    }
                }
            }
            String yearBytime = ar.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!w.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = ar.getYearBytime(longValue);
                        String chineseMonthBytime = ar.getChineseMonthBytime(longValue);
                        String dateBytime = ar.getDateBytime(longValue);
                        if (ar.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ar.equals(dateBytime, str3) && ar.equals(chineseMonthBytime, str2) && ar.equals(yearBytime2, yearBytime)) {
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
                                a(this.kND, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && w.isEmpty(this.kNs) && w.isEmpty(this.kNv)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cRU();
                this.maskType = cVar.getMaskType();
            }
            this.kNB = cVar.getUserAgreeInfo();
            this.kNo = cVar.getLiveInfo();
            this.kNp = cVar.getGoodsWindowInfo();
            this.kNq = cVar.getLiveReplayInfo();
            this.kNC = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!w.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bu buVar = new bu();
                        buVar.a(newestThreadList.get(i2));
                        buVar.a(this.dMu);
                        buVar.aSO();
                        this.kNE.add(buVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !w.isEmpty(user.gift_list)) {
            this.kNr = new g();
            this.kNr.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cTO() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.kNs == null) {
                this.kNs = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.kNj);
            this.kNj = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gVw = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gVu = z;
            cardPersonDynamicThreadData.gVt = z2;
            cardPersonDynamicThreadData.gVv = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.kNs.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cTO() || this.isHost) {
            if (this.kNv == null) {
                this.kNv = new ArrayList<>();
            }
            this.kNj = UtilHelper.getRandom(random, 3, this.kNj);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gVw = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gVu = false;
            cardPersonDynamicThreadData.gVt = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.kNj);
            this.kNv.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!w.isEmpty(list)) {
                if (this.kNs == null) {
                    this.kNs = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.gVt = z;
                dVar.sex = this.sex;
                dVar.gVm = ar.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gVn = ar.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gVn = ar.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.kNs.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cTN() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.kNs == null) {
                this.kNs = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.gVt = z;
            bVar.gVm = ar.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.gVn = ar.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.kNG = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.kNH = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.kNs.add(bVar);
            this.kNs.add(cO(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<q> cTC() {
        if (this.kNm == null) {
            return null;
        }
        return this.kNm.getPhotoAlbum();
    }

    private void ey(List<ForumDynamic> list) {
        this.kNl = new c();
        this.kNl.kNJ = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.kNN = forumDynamic.user_thread_count.intValue();
                this.kNl.kNJ.add(fVar);
            }
        }
    }

    private boolean cTN() {
        if (this.isHost) {
            return false;
        }
        if (this.kNh == 3) {
            return true;
        }
        return this.kNh == 2 && !this.kNg;
    }

    public boolean cTO() {
        if (this.isHost) {
            return false;
        }
        if (this.kNi == 3) {
            return true;
        }
        return this.kNi == 2 && !this.kNg;
    }

    protected com.baidu.tieba.person.d cO(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.kBt = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cTP() {
        this.kNg = true;
        this.sex = 1;
        this.kNh = 1;
        this.kNi = 1;
        this.kNj = -1;
        this.mUserData = null;
        if (this.kNk != null) {
            this.kNk.clear();
        }
        this.kNk = null;
        this.kNl = null;
        this.kNm = null;
        this.kNn = null;
        this.kNr = null;
        this.mCardNullPolymericData = null;
        if (this.kNs != null) {
            this.kNs.clear();
        }
        if (this.kNv != null) {
            this.kNv.clear();
        }
        this.kNs = null;
        this.kNv = null;
        this.kNt.clear();
        this.kNB = null;
        this.kNC = null;
        this.maskType = 0;
        this.kNo = null;
        this.kNp = null;
        if (this.kNq != null) {
            this.kNq.clear();
        }
        if (this.kNE != null) {
            this.kNE.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.kND;
    }

    public AntiData bXe() {
        return this.ejE;
    }

    public com.baidu.tieba.i.a cTQ() {
        return this.kNp;
    }

    public ArrayList<q> clM() {
        return this.kNt;
    }

    private void cRU() {
        this.kNu.clear();
        this.kNx = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.kNx.hlL = new Bundle();
        this.kNx.hlL.putBoolean("person_center_item_red_tip", true);
        this.kNx.kNY.hlL = new Bundle();
        this.kNx.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(this.kNx);
        this.kNy = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.kNy.hlL = new Bundle();
        this.kNy.hlL.putBoolean("person_center_item_red_tip", true);
        this.kNy.kNY.hlL = new Bundle();
        this.kNy.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(this.kNy);
        this.kNw = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.kNw.hlL = new Bundle();
        this.kNw.hlL.putBoolean("person_center_item_red_tip", true);
        this.kNw.kNY.hlL = new Bundle();
        this.kNw.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(this.kNw);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.kNY.hlL = new Bundle();
        Y.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.hlL = new Bundle();
            Y2.kNY.hlL = new Bundle();
            Y2.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.kNu.add(Y2);
        }
        this.kNz = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.kNz.hlL = new Bundle();
        this.kNz.hlL.putBoolean("person_center_item_red_tip", true);
        this.kNz.kNY.hlL = new Bundle();
        this.kNz.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(this.kNz);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.kNY.hlL = new Bundle();
        Y3.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.kGc != null) {
            Y3.kNY.hlL.putString("book_jump_link", this.kGc.kEP);
        }
        this.kNu.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.kNY.hlL = new Bundle();
        Y4.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.kNY.hlL = new Bundle();
        Y5.kNY.hlL.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kNu.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.kNY.hlL = new Bundle();
        Y6.kNY.hlL.putString("key_service_centre", "");
        this.kNu.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.kGp = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.kNY = new com.baidu.tieba.personCenter.d.a();
        nVar.kNY.hlK = i3;
        return nVar;
    }

    public List<bu> getNewestThreadList() {
        return this.kNE;
    }
}
