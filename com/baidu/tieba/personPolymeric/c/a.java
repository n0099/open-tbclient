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
/* loaded from: classes8.dex */
public abstract class a {
    public MetaData cNZ;
    private AntiData dhK;
    protected boolean isHost;
    private PersonUserGodInfo jcN;
    private com.baidu.tieba.person.data.d jcP;
    private ArrayList<com.baidu.adp.widget.ListView.m> jjJ;
    private c jjK;
    private com.baidu.tieba.person.a.f jjL;
    private m jjM;
    private AlaLiveInfoCoreData jjN;
    private List<AlaLiveInfoCoreData> jjO;
    protected g jjP;
    protected List<com.baidu.adp.widget.ListView.m> jjQ;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jjT;
    public n jjU;
    public n jjV;
    public n jjW;
    public n jjX;
    public n jjY;
    public UserAgreeInfo jjZ;
    public NicknameInfo jka;
    public User jkb;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean jjF = true;
    protected int sex = 1;
    private int jjG = 1;
    private int jjH = 1;
    private int jjI = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> jjR = new ArrayList<>();
    private ArrayList<n> jjS = new ArrayList<>();
    private List<bj> jkc = new ArrayList();

    public abstract void cuy();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bVQ() {
        return this.jjF;
    }

    public void rd(boolean z) {
        this.jjF = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.jkb = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.jkb);
            if (this.cNZ == null) {
                this.cNZ = new MetaData();
            }
            this.cNZ.parserProtobuf(this.jkb);
            if (this.jcN == null) {
                this.jcN = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jcN.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dhK == null) {
                this.dhK = new AntiData();
            }
            this.dhK.parserProtobuf(cVar.GetAntiStat());
            if (this.jkb != null) {
                if (this.jkb.priv_sets != null) {
                    this.jjG = this.jkb.priv_sets.like.intValue();
                    this.jjH = this.jkb.priv_sets.post.intValue();
                }
                this.sex = this.jkb.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.jjF = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jcP = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cuz()) {
                dV(cVar.getConcernedForumList());
            }
            if (this.jjP == null) {
                a(this.jkb);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.jkb, postInfoList, random);
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
                                a(this.jkb, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.jjQ) && v.isEmpty(this.jjT)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                csH();
                this.maskType = cVar.getMaskType();
            }
            this.jjZ = cVar.getUserAgreeInfo();
            this.jjN = cVar.getLiveInfo();
            this.jjO = cVar.getLiveReplayInfo();
            this.jka = cVar.getNicknameInfo();
            if (!v.isEmpty(cVar.getNewestThreadList())) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < cVar.getNewestThreadList().size()) {
                        bj bjVar = new bj();
                        bjVar.a(cVar.getNewestThreadList().get(i2));
                        bjVar.a(this.cNZ);
                        bjVar.aAc();
                        this.jkc.add(bjVar);
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
            this.jjP = new g();
            this.jjP.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cuA() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.jjQ == null) {
                this.jjQ = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.jjI);
            this.jjI = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fIk = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fIi = z;
            cardPersonDynamicThreadData.fIh = z2;
            cardPersonDynamicThreadData.fIj = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.jjQ.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cuA() || this.isHost) {
            if (this.jjT == null) {
                this.jjT = new ArrayList<>();
            }
            this.jjI = UtilHelper.getRandom(random, 3, this.jjI);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.fIk = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.fIi = false;
            cardPersonDynamicThreadData.fIh = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.jjI);
            this.jjT.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.jjQ == null) {
                    this.jjQ = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.fIh = z;
                dVar.sex = this.sex;
                dVar.fIa = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fIb = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fIb = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.jjQ.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cuz() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.jjQ == null) {
                this.jjQ = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.fIh = z;
            bVar.fIa = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fIb = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jke = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.jkf = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.jjQ.add(bVar);
            this.jjQ.add(cw(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cuo() {
        if (this.jjL == null) {
            return null;
        }
        return this.jjL.getPhotoAlbum();
    }

    private void dV(List<ForumDynamic> list) {
        this.jjK = new c();
        this.jjK.jkh = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.jkl = forumDynamic.user_thread_count.intValue();
                this.jjK.jkh.add(fVar);
            }
        }
    }

    private boolean cuz() {
        if (this.isHost) {
            return false;
        }
        if (this.jjG == 3) {
            return true;
        }
        return this.jjG == 2 && !this.jjF;
    }

    public boolean cuA() {
        if (this.isHost) {
            return false;
        }
        if (this.jjH == 3) {
            return true;
        }
        return this.jjH == 2 && !this.jjF;
    }

    protected com.baidu.tieba.person.d cw(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.iXy = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cuB() {
        this.jjF = true;
        this.sex = 1;
        this.jjG = 1;
        this.jjH = 1;
        this.jjI = -1;
        this.mUserData = null;
        if (this.jjJ != null) {
            this.jjJ.clear();
        }
        this.jjJ = null;
        this.jjK = null;
        this.jjL = null;
        this.jjM = null;
        this.jjP = null;
        this.mCardNullPolymericData = null;
        if (this.jjQ != null) {
            this.jjQ.clear();
        }
        if (this.jjT != null) {
            this.jjT.clear();
        }
        this.jjQ = null;
        this.jjT = null;
        this.jjR.clear();
        this.jjZ = null;
        this.jka = null;
        this.maskType = 0;
        this.jjN = null;
        if (this.jjO != null) {
            this.jjO.clear();
        }
        if (this.jkc != null) {
            this.jkc.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.jkb;
    }

    public AntiData bAs() {
        return this.dhK;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bNL() {
        return this.jjR;
    }

    private void csH() {
        this.jjS.clear();
        this.jjV = U(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.jjV.fVh = new Bundle();
        this.jjV.fVh.putBoolean("person_center_item_red_tip", true);
        this.jjV.jkx.fVh = new Bundle();
        this.jjV.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(this.jjV);
        this.jjW = U(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.jjW.fVh = new Bundle();
        this.jjW.fVh.putBoolean("person_center_item_red_tip", true);
        this.jjW.jkx.fVh = new Bundle();
        this.jjW.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(this.jjW);
        this.jjU = U(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.jjU.fVh = new Bundle();
        this.jjU.fVh.putBoolean("person_center_item_red_tip", true);
        this.jjU.jkx.fVh = new Bundle();
        this.jjU.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(this.jjU);
        n U = U(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        U.jkx.fVh = new Bundle();
        U.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(U);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n U2 = U(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            U2.fVh = new Bundle();
            U2.jkx.fVh = new Bundle();
            U2.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.jjS.add(U2);
        }
        this.jjX = U(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.jjX.fVh = new Bundle();
        this.jjX.fVh.putBoolean("person_center_item_red_tip", true);
        this.jjX.jkx.fVh = new Bundle();
        this.jjX.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(this.jjX);
        n U3 = U(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        U3.jkx.fVh = new Bundle();
        U3.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jcP != null) {
            U3.jkx.fVh.putString("book_jump_link", this.jcP.jbB);
        }
        this.jjS.add(U3);
        n U4 = U(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        U4.jkx.fVh = new Bundle();
        U4.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(U4);
        n U5 = U(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        U5.jkx.fVh = new Bundle();
        U5.jkx.fVh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.jjS.add(U5);
        n U6 = U(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        U6.jkx.fVh = new Bundle();
        U6.jkx.fVh.putString("key_service_centre", "");
        this.jjS.add(U6);
    }

    private n U(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.jkx = new com.baidu.tieba.personCenter.c.a();
        nVar.jkx.fVg = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.jkc;
    }
}
