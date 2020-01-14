package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
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
/* loaded from: classes9.dex */
public abstract class a {
    public MetaData cOj;
    private AntiData dhW;
    protected boolean isHost;
    private PersonUserGodInfo jgv;
    private com.baidu.tieba.person.data.d jgx;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jnA;
    public n jnB;
    public n jnC;
    public n jnD;
    public n jnE;
    public n jnF;
    public UserAgreeInfo jnG;
    public NicknameInfo jnH;
    public User jnI;
    private ArrayList<com.baidu.adp.widget.ListView.m> jnq;
    private c jnr;
    private com.baidu.tieba.person.a.f jns;
    private m jnt;
    private AlaLiveInfoCoreData jnu;
    private List<AlaLiveInfoCoreData> jnv;
    protected g jnw;
    protected List<com.baidu.adp.widget.ListView.m> jnx;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean jnm = true;
    protected int sex = 1;
    private int jnn = 1;
    private int jno = 1;
    private int jnp = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jny = new ArrayList<>();
    private ArrayList<n> jnz = new ArrayList<>();
    private List<bj> jnJ = new ArrayList();

    public abstract void cvH();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bWZ() {
        return this.jnm;
    }

    public void rq(boolean z) {
        this.jnm = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.jnI = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.jnI);
            if (this.cOj == null) {
                this.cOj = new MetaData();
            }
            this.cOj.parserProtobuf(this.jnI);
            if (this.jgv == null) {
                this.jgv = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jgv.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dhW == null) {
                this.dhW = new AntiData();
            }
            this.dhW.parserProtobuf(cVar.GetAntiStat());
            if (this.jnI != null) {
                if (this.jnI.priv_sets != null) {
                    this.jnn = this.jnI.priv_sets.like.intValue();
                    this.jno = this.jnI.priv_sets.post.intValue();
                }
                this.sex = this.jnI.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.jnm = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jgx = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cvI()) {
                dV(cVar.getConcernedForumList());
            }
            if (this.jnw == null) {
                a(this.jnI);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.jnI, postInfoList, random);
                    }
                }
            }
            String yearBytime = aq.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = aq.getYearBytime(longValue);
                        String chineseMonthBytime = aq.getChineseMonthBytime(longValue);
                        String dateBytime = aq.getDateBytime(longValue);
                        if (aq.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (aq.equals(dateBytime, str3) && aq.equals(chineseMonthBytime, str2) && aq.equals(yearBytime2, yearBytime)) {
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
                                a(this.jnI, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.jnx) && v.isEmpty(this.jnA)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                ctQ();
                this.maskType = cVar.getMaskType();
            }
            this.jnG = cVar.getUserAgreeInfo();
            this.jnu = cVar.getLiveInfo();
            this.jnv = cVar.getLiveReplayInfo();
            this.jnH = cVar.getNicknameInfo();
            if (!v.isEmpty(cVar.getNewestThreadList())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < cVar.getNewestThreadList().size()) {
                        bj bjVar = new bj();
                        bjVar.a(cVar.getNewestThreadList().get(i2));
                        bjVar.a(this.cOj);
                        bjVar.aAv();
                        this.jnJ.add(bjVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void a(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.jnw = new g();
            this.jnw.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cvJ() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.jnx == null) {
                this.jnx = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.jnp);
            this.jnp = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fLu = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fLs = z;
            cardPersonDynamicThreadData.fLr = z2;
            cardPersonDynamicThreadData.fLt = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.jnx.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cvJ() || this.isHost) {
            if (this.jnA == null) {
                this.jnA = new ArrayList<>();
            }
            this.jnp = UtilHelper.getRandom(random, 3, this.jnp);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fLu = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fLs = false;
            cardPersonDynamicThreadData.fLr = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.jnp);
            this.jnA.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.jnx == null) {
                    this.jnx = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.fLr = z;
                dVar.sex = this.sex;
                dVar.fLk = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fLl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fLl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.jnx.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cvI() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.jnx == null) {
                this.jnx = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fLr = z;
            bVar.fLk = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fLl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jnL = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.jnM = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.jnx.add(bVar);
            this.jnx.add(cv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cvx() {
        if (this.jns == null) {
            return null;
        }
        return this.jns.getPhotoAlbum();
    }

    private void dV(List<ForumDynamic> list) {
        this.jnr = new c();
        this.jnr.jnO = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.jnS = forumDynamic.user_thread_count.intValue();
                this.jnr.jnO.add(fVar);
            }
        }
    }

    private boolean cvI() {
        if (this.isHost) {
            return false;
        }
        if (this.jnn == 3) {
            return true;
        }
        return this.jnn == 2 && !this.jnm;
    }

    public boolean cvJ() {
        if (this.isHost) {
            return false;
        }
        if (this.jno == 3) {
            return true;
        }
        return this.jno == 2 && !this.jnm;
    }

    protected com.baidu.tieba.person.d cv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jbg = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cvK() {
        this.jnm = true;
        this.sex = 1;
        this.jnn = 1;
        this.jno = 1;
        this.jnp = -1;
        this.mUserData = null;
        if (this.jnq != null) {
            this.jnq.clear();
        }
        this.jnq = null;
        this.jnr = null;
        this.jns = null;
        this.jnt = null;
        this.jnw = null;
        this.mCardNullPolymericData = null;
        if (this.jnx != null) {
            this.jnx.clear();
        }
        if (this.jnA != null) {
            this.jnA.clear();
        }
        this.jnx = null;
        this.jnA = null;
        this.jny.clear();
        this.jnG = null;
        this.jnH = null;
        this.maskType = 0;
        this.jnu = null;
        if (this.jnv != null) {
            this.jnv.clear();
        }
        if (this.jnJ != null) {
            this.jnJ.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.jnI;
    }

    public AntiData bBu() {
        return this.dhW;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bOU() {
        return this.jny;
    }

    private void ctQ() {
        this.jnz.clear();
        this.jnC = U(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.jnC.fYq = new Bundle();
        this.jnC.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnC.joe.fYq = new Bundle();
        this.jnC.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(this.jnC);
        this.jnD = U(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.jnD.fYq = new Bundle();
        this.jnD.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnD.joe.fYq = new Bundle();
        this.jnD.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(this.jnD);
        this.jnB = U(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.jnB.fYq = new Bundle();
        this.jnB.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnB.joe.fYq = new Bundle();
        this.jnB.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(this.jnB);
        n U = U(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        U.joe.fYq = new Bundle();
        U.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(U);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n U2 = U(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            U2.fYq = new Bundle();
            U2.joe.fYq = new Bundle();
            U2.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.jnz.add(U2);
        }
        this.jnE = U(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.jnE.fYq = new Bundle();
        this.jnE.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnE.joe.fYq = new Bundle();
        this.jnE.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(this.jnE);
        n U3 = U(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        U3.joe.fYq = new Bundle();
        U3.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jgx != null) {
            U3.joe.fYq.putString("book_jump_link", this.jgx.jfj);
        }
        this.jnz.add(U3);
        n U4 = U(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        U4.joe.fYq = new Bundle();
        U4.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(U4);
        n U5 = U(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        U5.joe.fYq = new Bundle();
        U5.joe.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnz.add(U5);
        n U6 = U(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        U6.joe.fYq = new Bundle();
        U6.joe.fYq.putString("key_service_centre", "");
        this.jnz.add(U6);
    }

    private n U(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.joe = new com.baidu.tieba.personCenter.c.a();
        nVar.joe.fYp = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.jnJ;
    }
}
