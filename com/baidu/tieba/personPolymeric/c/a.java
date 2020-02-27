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
    public MetaData cSm;
    private AntiData dmd;
    protected boolean isHost;
    private PersonUserGodInfo jho;
    private com.baidu.tieba.person.data.d jhq;
    public UserAgreeInfo joA;
    public NicknameInfo joB;
    public User joC;
    private ArrayList<com.baidu.adp.widget.ListView.m> joj;
    private c jok;
    private com.baidu.tieba.person.a.f jol;
    private m jom;
    private AlaLiveInfoCoreData jon;
    private com.baidu.tieba.i.a joo;
    private List<AlaLiveInfoCoreData> jop;
    protected g joq;
    protected List<com.baidu.adp.widget.ListView.m> jor;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jou;
    public n jov;
    public n jow;
    public n jox;
    public n joy;
    public n joz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean jof = true;
    protected int sex = 1;
    private int jog = 1;
    private int joh = 1;
    private int joi = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jos = new ArrayList<>();
    private ArrayList<n> jot = new ArrayList<>();
    private List<bj> joD = new ArrayList();

    public abstract void cxa();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bYA() {
        return this.jof;
    }

    public void rt(boolean z) {
        this.jof = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.joC = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.joC);
            if (this.cSm == null) {
                this.cSm = new MetaData();
            }
            this.cSm.parserProtobuf(this.joC);
            if (this.jho == null) {
                this.jho = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jho.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dmd == null) {
                this.dmd = new AntiData();
            }
            this.dmd.parserProtobuf(cVar.GetAntiStat());
            if (this.joC != null) {
                if (this.joC.priv_sets != null) {
                    this.jog = this.joC.priv_sets.like.intValue();
                    this.joh = this.joC.priv_sets.post.intValue();
                }
                this.sex = this.joC.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.jof = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jhq = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cxb()) {
                dR(cVar.getConcernedForumList());
            }
            if (this.joq == null) {
                a(this.joC);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.joC, postInfoList, random);
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
                                a(this.joC, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.jor) && v.isEmpty(this.jou)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cvj();
                this.maskType = cVar.getMaskType();
            }
            this.joA = cVar.getUserAgreeInfo();
            this.jon = cVar.getLiveInfo();
            this.joo = cVar.getGoodsWindowInfo();
            this.jop = cVar.getLiveReplayInfo();
            this.joB = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bj bjVar = new bj();
                        bjVar.a(newestThreadList.get(i2));
                        bjVar.a(this.cSm);
                        bjVar.aCK();
                        this.joD.add(bjVar);
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
            this.joq = new g();
            this.joq.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cxc() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.jor == null) {
                this.jor = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.joi);
            this.joi = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fNQ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fNO = z;
            cardPersonDynamicThreadData.fNN = z2;
            cardPersonDynamicThreadData.fNP = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.jor.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cxc() || this.isHost) {
            if (this.jou == null) {
                this.jou = new ArrayList<>();
            }
            this.joi = UtilHelper.getRandom(random, 3, this.joi);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fNQ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fNO = false;
            cardPersonDynamicThreadData.fNN = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.joi);
            this.jou.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.jor == null) {
                    this.jor = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.fNN = z;
                dVar.sex = this.sex;
                dVar.fNG = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fNH = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fNH = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.jor.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cxb() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.jor == null) {
                this.jor = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fNN = z;
            bVar.fNG = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fNH = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.joF = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.joG = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.jor.add(bVar);
            this.jor.add(cw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cwQ() {
        if (this.jol == null) {
            return null;
        }
        return this.jol.getPhotoAlbum();
    }

    private void dR(List<ForumDynamic> list) {
        this.jok = new c();
        this.jok.joI = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.joM = forumDynamic.user_thread_count.intValue();
                this.jok.joI.add(fVar);
            }
        }
    }

    private boolean cxb() {
        if (this.isHost) {
            return false;
        }
        if (this.jog == 3) {
            return true;
        }
        return this.jog == 2 && !this.jof;
    }

    public boolean cxc() {
        if (this.isHost) {
            return false;
        }
        if (this.joh == 3) {
            return true;
        }
        return this.joh == 2 && !this.jof;
    }

    protected com.baidu.tieba.person.d cw(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jcM = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cxd() {
        this.jof = true;
        this.sex = 1;
        this.jog = 1;
        this.joh = 1;
        this.joi = -1;
        this.mUserData = null;
        if (this.joj != null) {
            this.joj.clear();
        }
        this.joj = null;
        this.jok = null;
        this.jol = null;
        this.jom = null;
        this.joq = null;
        this.mCardNullPolymericData = null;
        if (this.jor != null) {
            this.jor.clear();
        }
        if (this.jou != null) {
            this.jou.clear();
        }
        this.jor = null;
        this.jou = null;
        this.jos.clear();
        this.joA = null;
        this.joB = null;
        this.maskType = 0;
        this.jon = null;
        this.joo = null;
        if (this.jop != null) {
            this.jop.clear();
        }
        if (this.joD != null) {
            this.joD.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.joC;
    }

    public AntiData bCW() {
        return this.dmd;
    }

    public com.baidu.tieba.i.a cxe() {
        return this.joo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bQv() {
        return this.jos;
    }

    private void cvj() {
        this.jot.clear();
        this.jow = V(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.jow.gaq = new Bundle();
        this.jow.gaq.putBoolean("person_center_item_red_tip", true);
        this.jow.joX.gaq = new Bundle();
        this.jow.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(this.jow);
        this.jox = V(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.jox.gaq = new Bundle();
        this.jox.gaq.putBoolean("person_center_item_red_tip", true);
        this.jox.joX.gaq = new Bundle();
        this.jox.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(this.jox);
        this.jov = V(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.jov.gaq = new Bundle();
        this.jov.gaq.putBoolean("person_center_item_red_tip", true);
        this.jov.joX.gaq = new Bundle();
        this.jov.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(this.jov);
        n V = V(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        V.joX.gaq = new Bundle();
        V.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(V);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n V2 = V(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            V2.gaq = new Bundle();
            V2.joX.gaq = new Bundle();
            V2.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.jot.add(V2);
        }
        this.joy = V(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.joy.gaq = new Bundle();
        this.joy.gaq.putBoolean("person_center_item_red_tip", true);
        this.joy.joX.gaq = new Bundle();
        this.joy.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(this.joy);
        n V3 = V(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        V3.joX.gaq = new Bundle();
        V3.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jhq != null) {
            V3.joX.gaq.putString("book_jump_link", this.jhq.jgf);
        }
        this.jot.add(V3);
        n V4 = V(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        V4.joX.gaq = new Bundle();
        V4.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(V4);
        n V5 = V(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        V5.joX.gaq = new Bundle();
        V5.joX.gaq.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jot.add(V5);
        n V6 = V(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        V6.joX.gaq = new Bundle();
        V6.joX.gaq.putString("key_service_centre", "");
        this.jot.add(V6);
    }

    private n V(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.joX = new com.baidu.tieba.personCenter.d.a();
        nVar.joX.gap = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.joD;
    }
}
