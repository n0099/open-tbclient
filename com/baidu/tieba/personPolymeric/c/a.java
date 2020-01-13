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
    private PersonUserGodInfo jgq;
    private com.baidu.tieba.person.data.d jgs;
    public n jnA;
    public UserAgreeInfo jnB;
    public NicknameInfo jnC;
    public User jnD;
    private ArrayList<com.baidu.adp.widget.ListView.m> jnl;
    private c jnm;
    private com.baidu.tieba.person.a.f jnn;
    private m jno;
    private AlaLiveInfoCoreData jnp;
    private List<AlaLiveInfoCoreData> jnq;
    protected g jnr;
    protected List<com.baidu.adp.widget.ListView.m> jns;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jnv;
    public n jnw;
    public n jnx;
    public n jny;
    public n jnz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean jnh = true;
    protected int sex = 1;
    private int jni = 1;
    private int jnj = 1;
    private int jnk = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jnt = new ArrayList<>();
    private ArrayList<n> jnu = new ArrayList<>();
    private List<bj> jnE = new ArrayList();

    public abstract void cvF();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bWZ() {
        return this.jnh;
    }

    public void rq(boolean z) {
        this.jnh = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.jnD = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.jnD);
            if (this.cOj == null) {
                this.cOj = new MetaData();
            }
            this.cOj.parserProtobuf(this.jnD);
            if (this.jgq == null) {
                this.jgq = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jgq.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dhW == null) {
                this.dhW = new AntiData();
            }
            this.dhW.parserProtobuf(cVar.GetAntiStat());
            if (this.jnD != null) {
                if (this.jnD.priv_sets != null) {
                    this.jni = this.jnD.priv_sets.like.intValue();
                    this.jnj = this.jnD.priv_sets.post.intValue();
                }
                this.sex = this.jnD.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.jnh = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jgs = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cvG()) {
                dV(cVar.getConcernedForumList());
            }
            if (this.jnr == null) {
                a(this.jnD);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.jnD, postInfoList, random);
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
                                a(this.jnD, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.jns) && v.isEmpty(this.jnv)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                ctO();
                this.maskType = cVar.getMaskType();
            }
            this.jnB = cVar.getUserAgreeInfo();
            this.jnp = cVar.getLiveInfo();
            this.jnq = cVar.getLiveReplayInfo();
            this.jnC = cVar.getNicknameInfo();
            if (!v.isEmpty(cVar.getNewestThreadList())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < cVar.getNewestThreadList().size()) {
                        bj bjVar = new bj();
                        bjVar.a(cVar.getNewestThreadList().get(i2));
                        bjVar.a(this.cOj);
                        bjVar.aAv();
                        this.jnE.add(bjVar);
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
            this.jnr = new g();
            this.jnr.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cvH() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.jns == null) {
                this.jns = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.jnk);
            this.jnk = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fLu = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fLs = z;
            cardPersonDynamicThreadData.fLr = z2;
            cardPersonDynamicThreadData.fLt = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.jns.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cvH() || this.isHost) {
            if (this.jnv == null) {
                this.jnv = new ArrayList<>();
            }
            this.jnk = UtilHelper.getRandom(random, 3, this.jnk);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fLu = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fLs = false;
            cardPersonDynamicThreadData.fLr = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.jnk);
            this.jnv.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.jns == null) {
                    this.jns = new ArrayList();
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
                this.jns.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cvG() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.jns == null) {
                this.jns = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fLr = z;
            bVar.fLk = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fLl = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jnG = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.jnH = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.jns.add(bVar);
            this.jns.add(cv(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cvv() {
        if (this.jnn == null) {
            return null;
        }
        return this.jnn.getPhotoAlbum();
    }

    private void dV(List<ForumDynamic> list) {
        this.jnm = new c();
        this.jnm.jnJ = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.jnN = forumDynamic.user_thread_count.intValue();
                this.jnm.jnJ.add(fVar);
            }
        }
    }

    private boolean cvG() {
        if (this.isHost) {
            return false;
        }
        if (this.jni == 3) {
            return true;
        }
        return this.jni == 2 && !this.jnh;
    }

    public boolean cvH() {
        if (this.isHost) {
            return false;
        }
        if (this.jnj == 3) {
            return true;
        }
        return this.jnj == 2 && !this.jnh;
    }

    protected com.baidu.tieba.person.d cv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jbb = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cvI() {
        this.jnh = true;
        this.sex = 1;
        this.jni = 1;
        this.jnj = 1;
        this.jnk = -1;
        this.mUserData = null;
        if (this.jnl != null) {
            this.jnl.clear();
        }
        this.jnl = null;
        this.jnm = null;
        this.jnn = null;
        this.jno = null;
        this.jnr = null;
        this.mCardNullPolymericData = null;
        if (this.jns != null) {
            this.jns.clear();
        }
        if (this.jnv != null) {
            this.jnv.clear();
        }
        this.jns = null;
        this.jnv = null;
        this.jnt.clear();
        this.jnB = null;
        this.jnC = null;
        this.maskType = 0;
        this.jnp = null;
        if (this.jnq != null) {
            this.jnq.clear();
        }
        if (this.jnE != null) {
            this.jnE.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.jnD;
    }

    public AntiData bBu() {
        return this.dhW;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bOU() {
        return this.jnt;
    }

    private void ctO() {
        this.jnu.clear();
        this.jnx = U(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.jnx.fYq = new Bundle();
        this.jnx.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnx.jnZ.fYq = new Bundle();
        this.jnx.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(this.jnx);
        this.jny = U(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.jny.fYq = new Bundle();
        this.jny.fYq.putBoolean("person_center_item_red_tip", true);
        this.jny.jnZ.fYq = new Bundle();
        this.jny.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(this.jny);
        this.jnw = U(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.jnw.fYq = new Bundle();
        this.jnw.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnw.jnZ.fYq = new Bundle();
        this.jnw.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(this.jnw);
        n U = U(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        U.jnZ.fYq = new Bundle();
        U.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(U);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n U2 = U(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            U2.fYq = new Bundle();
            U2.jnZ.fYq = new Bundle();
            U2.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.jnu.add(U2);
        }
        this.jnz = U(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.jnz.fYq = new Bundle();
        this.jnz.fYq.putBoolean("person_center_item_red_tip", true);
        this.jnz.jnZ.fYq = new Bundle();
        this.jnz.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(this.jnz);
        n U3 = U(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        U3.jnZ.fYq = new Bundle();
        U3.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jgs != null) {
            U3.jnZ.fYq.putString("book_jump_link", this.jgs.jfe);
        }
        this.jnu.add(U3);
        n U4 = U(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        U4.jnZ.fYq = new Bundle();
        U4.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(U4);
        n U5 = U(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        U5.jnZ.fYq = new Bundle();
        U5.jnZ.fYq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jnu.add(U5);
        n U6 = U(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        U6.jnZ.fYq = new Bundle();
        U6.jnZ.fYq.putString("key_service_centre", "");
        this.jnu.add(U6);
    }

    private n U(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.jnZ = new com.baidu.tieba.personCenter.c.a();
        nVar.jnZ.fYp = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.jnE;
    }
}
