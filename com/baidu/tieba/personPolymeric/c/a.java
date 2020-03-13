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
    public MetaData cSo;
    private AntiData dmr;
    protected boolean isHost;
    private PersonUserGodInfo jhC;
    private com.baidu.tieba.person.data.d jhE;
    private m joA;
    private AlaLiveInfoCoreData joB;
    private com.baidu.tieba.i.a joC;
    private List<AlaLiveInfoCoreData> joD;
    protected g joE;
    protected List<com.baidu.adp.widget.ListView.m> joF;
    protected ArrayList<com.baidu.adp.widget.ListView.m> joI;
    public n joJ;
    public n joK;
    public n joL;
    public n joM;
    public n joN;
    public UserAgreeInfo joO;
    public NicknameInfo joP;
    public User joQ;
    private ArrayList<com.baidu.adp.widget.ListView.m> jox;
    private c joy;
    private com.baidu.tieba.person.a.f joz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean jot = true;
    protected int sex = 1;
    private int jou = 1;
    private int jov = 1;
    private int jow = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> joG = new ArrayList<>();
    private ArrayList<n> joH = new ArrayList<>();
    private List<bj> joR = new ArrayList();

    public abstract void cxd();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bYD() {
        return this.jot;
    }

    public void rt(boolean z) {
        this.jot = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.joQ = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.joQ);
            if (this.cSo == null) {
                this.cSo = new MetaData();
            }
            this.cSo.parserProtobuf(this.joQ);
            if (this.jhC == null) {
                this.jhC = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jhC.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dmr == null) {
                this.dmr = new AntiData();
            }
            this.dmr.parserProtobuf(cVar.GetAntiStat());
            if (this.joQ != null) {
                if (this.joQ.priv_sets != null) {
                    this.jou = this.joQ.priv_sets.like.intValue();
                    this.jov = this.joQ.priv_sets.post.intValue();
                }
                this.sex = this.joQ.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.jot = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jhE = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cxe()) {
                dR(cVar.getConcernedForumList());
            }
            if (this.joE == null) {
                a(this.joQ);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.joQ, postInfoList, random);
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
                                a(this.joQ, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.joF) && v.isEmpty(this.joI)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cvm();
                this.maskType = cVar.getMaskType();
            }
            this.joO = cVar.getUserAgreeInfo();
            this.joB = cVar.getLiveInfo();
            this.joC = cVar.getGoodsWindowInfo();
            this.joD = cVar.getLiveReplayInfo();
            this.joP = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bj bjVar = new bj();
                        bjVar.a(newestThreadList.get(i2));
                        bjVar.a(this.cSo);
                        bjVar.aCM();
                        this.joR.add(bjVar);
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
            this.joE = new g();
            this.joE.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cxf() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.joF == null) {
                this.joF = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.jow);
            this.jow = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fOf = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fOd = z;
            cardPersonDynamicThreadData.fOc = z2;
            cardPersonDynamicThreadData.fOe = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.joF.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cxf() || this.isHost) {
            if (this.joI == null) {
                this.joI = new ArrayList<>();
            }
            this.jow = UtilHelper.getRandom(random, 3, this.jow);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fOf = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fOd = false;
            cardPersonDynamicThreadData.fOc = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.jow);
            this.joI.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.joF == null) {
                    this.joF = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.fOc = z;
                dVar.sex = this.sex;
                dVar.fNV = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fNW = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fNW = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.joF.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cxe() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.joF == null) {
                this.joF = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fOc = z;
            bVar.fNV = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fNW = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.joT = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.joU = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.joF.add(bVar);
            this.joF.add(cw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cwT() {
        if (this.joz == null) {
            return null;
        }
        return this.joz.getPhotoAlbum();
    }

    private void dR(List<ForumDynamic> list) {
        this.joy = new c();
        this.joy.joW = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.jpa = forumDynamic.user_thread_count.intValue();
                this.joy.joW.add(fVar);
            }
        }
    }

    private boolean cxe() {
        if (this.isHost) {
            return false;
        }
        if (this.jou == 3) {
            return true;
        }
        return this.jou == 2 && !this.jot;
    }

    public boolean cxf() {
        if (this.isHost) {
            return false;
        }
        if (this.jov == 3) {
            return true;
        }
        return this.jov == 2 && !this.jot;
    }

    protected com.baidu.tieba.person.d cw(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jda = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cxg() {
        this.jot = true;
        this.sex = 1;
        this.jou = 1;
        this.jov = 1;
        this.jow = -1;
        this.mUserData = null;
        if (this.jox != null) {
            this.jox.clear();
        }
        this.jox = null;
        this.joy = null;
        this.joz = null;
        this.joA = null;
        this.joE = null;
        this.mCardNullPolymericData = null;
        if (this.joF != null) {
            this.joF.clear();
        }
        if (this.joI != null) {
            this.joI.clear();
        }
        this.joF = null;
        this.joI = null;
        this.joG.clear();
        this.joO = null;
        this.joP = null;
        this.maskType = 0;
        this.joB = null;
        this.joC = null;
        if (this.joD != null) {
            this.joD.clear();
        }
        if (this.joR != null) {
            this.joR.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.joQ;
    }

    public AntiData bCZ() {
        return this.dmr;
    }

    public com.baidu.tieba.i.a cxh() {
        return this.joC;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bQy() {
        return this.joG;
    }

    private void cvm() {
        this.joH.clear();
        this.joK = V(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.joK.gaF = new Bundle();
        this.joK.gaF.putBoolean("person_center_item_red_tip", true);
        this.joK.jpl.gaF = new Bundle();
        this.joK.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(this.joK);
        this.joL = V(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.joL.gaF = new Bundle();
        this.joL.gaF.putBoolean("person_center_item_red_tip", true);
        this.joL.jpl.gaF = new Bundle();
        this.joL.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(this.joL);
        this.joJ = V(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.joJ.gaF = new Bundle();
        this.joJ.gaF.putBoolean("person_center_item_red_tip", true);
        this.joJ.jpl.gaF = new Bundle();
        this.joJ.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(this.joJ);
        n V = V(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        V.jpl.gaF = new Bundle();
        V.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(V);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n V2 = V(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            V2.gaF = new Bundle();
            V2.jpl.gaF = new Bundle();
            V2.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.joH.add(V2);
        }
        this.joM = V(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.joM.gaF = new Bundle();
        this.joM.gaF.putBoolean("person_center_item_red_tip", true);
        this.joM.jpl.gaF = new Bundle();
        this.joM.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(this.joM);
        n V3 = V(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        V3.jpl.gaF = new Bundle();
        V3.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jhE != null) {
            V3.jpl.gaF.putString("book_jump_link", this.jhE.jgt);
        }
        this.joH.add(V3);
        n V4 = V(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        V4.jpl.gaF = new Bundle();
        V4.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(V4);
        n V5 = V(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        V5.jpl.gaF = new Bundle();
        V5.jpl.gaF.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.joH.add(V5);
        n V6 = V(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        V6.jpl.gaF = new Bundle();
        V6.jpl.gaF.putString("key_service_centre", "");
        this.joH.add(V6);
    }

    private n V(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.jpl = new com.baidu.tieba.personCenter.d.a();
        nVar.jpl.gaE = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.joR;
    }
}
