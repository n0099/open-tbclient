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
/* loaded from: classes11.dex */
public abstract class a {
    public MetaData cSB;
    private AntiData dmE;
    protected boolean isHost;
    private PersonUserGodInfo jjc;
    private com.baidu.tieba.person.data.d jje;
    private ArrayList<com.baidu.adp.widget.ListView.m> jpW;
    private c jpX;
    private com.baidu.tieba.person.a.f jpY;
    private m jpZ;
    private AlaLiveInfoCoreData jqa;
    private com.baidu.tieba.i.a jqb;
    private List<AlaLiveInfoCoreData> jqc;
    protected g jqd;
    protected List<com.baidu.adp.widget.ListView.m> jqe;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jqh;
    public n jqi;
    public n jqj;
    public n jqk;
    public n jql;
    public n jqm;
    public UserAgreeInfo jqn;
    public NicknameInfo jqo;
    public User jqp;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean jpS = true;
    protected int sex = 1;
    private int jpT = 1;
    private int jpU = 1;
    private int jpV = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jqf = new ArrayList<>();
    private ArrayList<n> jqg = new ArrayList<>();
    private List<bj> jqq = new ArrayList();

    public abstract void cxw();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bYV() {
        return this.jpS;
    }

    public void rz(boolean z) {
        this.jpS = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.jqp = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.jqp);
            if (this.cSB == null) {
                this.cSB = new MetaData();
            }
            this.cSB.parserProtobuf(this.jqp);
            if (this.jjc == null) {
                this.jjc = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jjc.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dmE == null) {
                this.dmE = new AntiData();
            }
            this.dmE.parserProtobuf(cVar.GetAntiStat());
            if (this.jqp != null) {
                if (this.jqp.priv_sets != null) {
                    this.jpT = this.jqp.priv_sets.like.intValue();
                    this.jpU = this.jqp.priv_sets.post.intValue();
                }
                this.sex = this.jqp.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.jpS = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jje = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cxx()) {
                dR(cVar.getConcernedForumList());
            }
            if (this.jqd == null) {
                a(this.jqp);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.jqp, postInfoList, random);
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
                                a(this.jqp, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.jqe) && v.isEmpty(this.jqh)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cvF();
                this.maskType = cVar.getMaskType();
            }
            this.jqn = cVar.getUserAgreeInfo();
            this.jqa = cVar.getLiveInfo();
            this.jqb = cVar.getGoodsWindowInfo();
            this.jqc = cVar.getLiveReplayInfo();
            this.jqo = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bj bjVar = new bj();
                        bjVar.a(newestThreadList.get(i2));
                        bjVar.a(this.cSB);
                        bjVar.aCP();
                        this.jqq.add(bjVar);
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
            this.jqd = new g();
            this.jqd.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cxy() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.jqe == null) {
                this.jqe = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.jpV);
            this.jpV = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fON = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fOL = z;
            cardPersonDynamicThreadData.fOK = z2;
            cardPersonDynamicThreadData.fOM = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.jqe.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cxy() || this.isHost) {
            if (this.jqh == null) {
                this.jqh = new ArrayList<>();
            }
            this.jpV = UtilHelper.getRandom(random, 3, this.jpV);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fON = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fOL = false;
            cardPersonDynamicThreadData.fOK = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.jpV);
            this.jqh.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.jqe == null) {
                    this.jqe = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.fOK = z;
                dVar.sex = this.sex;
                dVar.fOD = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fOE = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fOE = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.jqe.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cxx() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.jqe == null) {
                this.jqe = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fOK = z;
            bVar.fOD = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fOE = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jqs = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.jqt = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.jqe.add(bVar);
            this.jqe.add(cx(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cxm() {
        if (this.jpY == null) {
            return null;
        }
        return this.jpY.getPhotoAlbum();
    }

    private void dR(List<ForumDynamic> list) {
        this.jpX = new c();
        this.jpX.jqv = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.jqz = forumDynamic.user_thread_count.intValue();
                this.jpX.jqv.add(fVar);
            }
        }
    }

    private boolean cxx() {
        if (this.isHost) {
            return false;
        }
        if (this.jpT == 3) {
            return true;
        }
        return this.jpT == 2 && !this.jpS;
    }

    public boolean cxy() {
        if (this.isHost) {
            return false;
        }
        if (this.jpU == 3) {
            return true;
        }
        return this.jpU == 2 && !this.jpS;
    }

    protected com.baidu.tieba.person.d cx(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jez = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cxz() {
        this.jpS = true;
        this.sex = 1;
        this.jpT = 1;
        this.jpU = 1;
        this.jpV = -1;
        this.mUserData = null;
        if (this.jpW != null) {
            this.jpW.clear();
        }
        this.jpW = null;
        this.jpX = null;
        this.jpY = null;
        this.jpZ = null;
        this.jqd = null;
        this.mCardNullPolymericData = null;
        if (this.jqe != null) {
            this.jqe.clear();
        }
        if (this.jqh != null) {
            this.jqh.clear();
        }
        this.jqe = null;
        this.jqh = null;
        this.jqf.clear();
        this.jqn = null;
        this.jqo = null;
        this.maskType = 0;
        this.jqa = null;
        this.jqb = null;
        if (this.jqc != null) {
            this.jqc.clear();
        }
        if (this.jqq != null) {
            this.jqq.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.jqp;
    }

    public AntiData bDg() {
        return this.dmE;
    }

    public com.baidu.tieba.i.a cxA() {
        return this.jqb;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bQQ() {
        return this.jqf;
    }

    private void cvF() {
        this.jqg.clear();
        this.jqj = V(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.jqj.gbn = new Bundle();
        this.jqj.gbn.putBoolean("person_center_item_red_tip", true);
        this.jqj.jqK.gbn = new Bundle();
        this.jqj.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(this.jqj);
        this.jqk = V(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.jqk.gbn = new Bundle();
        this.jqk.gbn.putBoolean("person_center_item_red_tip", true);
        this.jqk.jqK.gbn = new Bundle();
        this.jqk.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(this.jqk);
        this.jqi = V(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.jqi.gbn = new Bundle();
        this.jqi.gbn.putBoolean("person_center_item_red_tip", true);
        this.jqi.jqK.gbn = new Bundle();
        this.jqi.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(this.jqi);
        n V = V(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        V.jqK.gbn = new Bundle();
        V.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(V);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n V2 = V(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            V2.gbn = new Bundle();
            V2.jqK.gbn = new Bundle();
            V2.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.jqg.add(V2);
        }
        this.jql = V(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.jql.gbn = new Bundle();
        this.jql.gbn.putBoolean("person_center_item_red_tip", true);
        this.jql.jqK.gbn = new Bundle();
        this.jql.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(this.jql);
        n V3 = V(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        V3.jqK.gbn = new Bundle();
        V3.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jje != null) {
            V3.jqK.gbn.putString("book_jump_link", this.jje.jhS);
        }
        this.jqg.add(V3);
        n V4 = V(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        V4.jqK.gbn = new Bundle();
        V4.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(V4);
        n V5 = V(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        V5.jqK.gbn = new Bundle();
        V5.jqK.gbn.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jqg.add(V5);
        n V6 = V(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        V6.jqK.gbn = new Bundle();
        V6.jqK.gbn.putString("key_service_centre", "");
        this.jqg.add(V6);
    }

    private n V(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.jqK = new com.baidu.tieba.personCenter.d.a();
        nVar.jqK.gbm = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.jqq;
    }
}
