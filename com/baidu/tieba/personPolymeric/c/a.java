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
    public MetaData cSn;
    private AntiData dme;
    protected boolean isHost;
    private PersonUserGodInfo jhq;
    private com.baidu.tieba.person.data.d jhs;
    public n joA;
    public n joB;
    public UserAgreeInfo joC;
    public NicknameInfo joD;
    public User joE;
    private ArrayList<com.baidu.adp.widget.ListView.m> jol;
    private c jom;
    private com.baidu.tieba.person.a.f jon;
    private m joo;
    private AlaLiveInfoCoreData jop;
    private com.baidu.tieba.i.a joq;
    private List<AlaLiveInfoCoreData> jor;
    protected g jos;
    protected List<com.baidu.adp.widget.ListView.m> jot;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jow;
    public n jox;
    public n joy;
    public n joz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean joh = true;
    protected int sex = 1;
    private int joi = 1;
    private int joj = 1;
    private int jok = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jou = new ArrayList<>();
    private ArrayList<n> jov = new ArrayList<>();
    private List<bj> joF = new ArrayList();

    public abstract void cxc();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bYC() {
        return this.joh;
    }

    public void rt(boolean z) {
        this.joh = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.joE = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.joE);
            if (this.cSn == null) {
                this.cSn = new MetaData();
            }
            this.cSn.parserProtobuf(this.joE);
            if (this.jhq == null) {
                this.jhq = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jhq.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dme == null) {
                this.dme = new AntiData();
            }
            this.dme.parserProtobuf(cVar.GetAntiStat());
            if (this.joE != null) {
                if (this.joE.priv_sets != null) {
                    this.joi = this.joE.priv_sets.like.intValue();
                    this.joj = this.joE.priv_sets.post.intValue();
                }
                this.sex = this.joE.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.joh = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jhs = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cxd()) {
                dR(cVar.getConcernedForumList());
            }
            if (this.jos == null) {
                a(this.joE);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.joE, postInfoList, random);
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
                                a(this.joE, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.jot) && v.isEmpty(this.jow)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cvl();
                this.maskType = cVar.getMaskType();
            }
            this.joC = cVar.getUserAgreeInfo();
            this.jop = cVar.getLiveInfo();
            this.joq = cVar.getGoodsWindowInfo();
            this.jor = cVar.getLiveReplayInfo();
            this.joD = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bj bjVar = new bj();
                        bjVar.a(newestThreadList.get(i2));
                        bjVar.a(this.cSn);
                        bjVar.aCM();
                        this.joF.add(bjVar);
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
            this.jos = new g();
            this.jos.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cxe() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.jot == null) {
                this.jot = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.jok);
            this.jok = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fNS = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fNQ = z;
            cardPersonDynamicThreadData.fNP = z2;
            cardPersonDynamicThreadData.fNR = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.jot.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cxe() || this.isHost) {
            if (this.jow == null) {
                this.jow = new ArrayList<>();
            }
            this.jok = UtilHelper.getRandom(random, 3, this.jok);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fNS = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fNQ = false;
            cardPersonDynamicThreadData.fNP = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.jok);
            this.jow.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.jot == null) {
                    this.jot = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.fNP = z;
                dVar.sex = this.sex;
                dVar.fNI = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fNJ = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fNJ = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.jot.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cxd() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.jot == null) {
                this.jot = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fNP = z;
            bVar.fNI = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fNJ = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.joH = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.joI = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.jot.add(bVar);
            this.jot.add(cw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cwS() {
        if (this.jon == null) {
            return null;
        }
        return this.jon.getPhotoAlbum();
    }

    private void dR(List<ForumDynamic> list) {
        this.jom = new c();
        this.jom.joK = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.joO = forumDynamic.user_thread_count.intValue();
                this.jom.joK.add(fVar);
            }
        }
    }

    private boolean cxd() {
        if (this.isHost) {
            return false;
        }
        if (this.joi == 3) {
            return true;
        }
        return this.joi == 2 && !this.joh;
    }

    public boolean cxe() {
        if (this.isHost) {
            return false;
        }
        if (this.joj == 3) {
            return true;
        }
        return this.joj == 2 && !this.joh;
    }

    protected com.baidu.tieba.person.d cw(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jcO = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cxf() {
        this.joh = true;
        this.sex = 1;
        this.joi = 1;
        this.joj = 1;
        this.jok = -1;
        this.mUserData = null;
        if (this.jol != null) {
            this.jol.clear();
        }
        this.jol = null;
        this.jom = null;
        this.jon = null;
        this.joo = null;
        this.jos = null;
        this.mCardNullPolymericData = null;
        if (this.jot != null) {
            this.jot.clear();
        }
        if (this.jow != null) {
            this.jow.clear();
        }
        this.jot = null;
        this.jow = null;
        this.jou.clear();
        this.joC = null;
        this.joD = null;
        this.maskType = 0;
        this.jop = null;
        this.joq = null;
        if (this.jor != null) {
            this.jor.clear();
        }
        if (this.joF != null) {
            this.joF.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.joE;
    }

    public AntiData bCY() {
        return this.dme;
    }

    public com.baidu.tieba.i.a cxg() {
        return this.joq;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bQx() {
        return this.jou;
    }

    private void cvl() {
        this.jov.clear();
        this.joy = V(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.joy.gas = new Bundle();
        this.joy.gas.putBoolean("person_center_item_red_tip", true);
        this.joy.joZ.gas = new Bundle();
        this.joy.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(this.joy);
        this.joz = V(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.joz.gas = new Bundle();
        this.joz.gas.putBoolean("person_center_item_red_tip", true);
        this.joz.joZ.gas = new Bundle();
        this.joz.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(this.joz);
        this.jox = V(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.jox.gas = new Bundle();
        this.jox.gas.putBoolean("person_center_item_red_tip", true);
        this.jox.joZ.gas = new Bundle();
        this.jox.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(this.jox);
        n V = V(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        V.joZ.gas = new Bundle();
        V.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(V);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n V2 = V(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            V2.gas = new Bundle();
            V2.joZ.gas = new Bundle();
            V2.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.jov.add(V2);
        }
        this.joA = V(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.joA.gas = new Bundle();
        this.joA.gas.putBoolean("person_center_item_red_tip", true);
        this.joA.joZ.gas = new Bundle();
        this.joA.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(this.joA);
        n V3 = V(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        V3.joZ.gas = new Bundle();
        V3.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jhs != null) {
            V3.joZ.gas.putString("book_jump_link", this.jhs.jgh);
        }
        this.jov.add(V3);
        n V4 = V(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        V4.joZ.gas = new Bundle();
        V4.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(V4);
        n V5 = V(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        V5.joZ.gas = new Bundle();
        V5.joZ.gas.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jov.add(V5);
        n V6 = V(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        V6.joZ.gas = new Bundle();
        V6.joZ.gas.putString("key_service_centre", "");
        this.jov.add(V6);
    }

    private n V(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.joZ = new com.baidu.tieba.personCenter.d.a();
        nVar.joZ.gar = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.joF;
    }
}
