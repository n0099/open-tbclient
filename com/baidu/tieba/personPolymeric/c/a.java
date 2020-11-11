package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.person.data.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.HotUserRankEntry;
import tbclient.PostInfoList;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.Profile.UserGodInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes24.dex */
public abstract class a {
    public MetaData eEK;
    private AntiData fcN;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo lVC;
    private com.baidu.tieba.person.data.d lVE;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private ArrayList<com.baidu.adp.widget.ListView.q> mcQ;
    private c mcR;
    private com.baidu.tieba.person.a.f mcS;
    private m mcT;
    private AlaLiveInfoCoreData mcU;
    private com.baidu.tieba.i.b mcV;
    private List<AlaLiveInfoCoreData> mcW;
    protected g mcX;
    protected List<com.baidu.adp.widget.ListView.q> mcY;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mdb;
    public n mdc;
    public n mdd;
    public n mde;
    public n mdf;
    public n mdg;
    public UserAgreeInfo mdh;
    public NicknameInfo mdi;
    public User mdj;
    private boolean mcM = true;
    protected int sex = 1;
    private int mcN = 1;
    private int mcO = 1;
    private int mcP = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mcZ = new ArrayList<>();
    private ArrayList<n> mda = new ArrayList<>();
    private List<bw> mdk = new ArrayList();

    public abstract void dvC();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cVH() {
        return this.mcM;
    }

    public void vW(boolean z) {
        this.mcM = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mdj = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mdj);
            if (this.eEK == null) {
                this.eEK = new MetaData();
            }
            this.eEK.parserProtobuf(this.mdj);
            if (this.lVC == null) {
                this.lVC = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.lVC.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fcN == null) {
                this.fcN = new AntiData();
            }
            this.fcN.parserProtobuf(cVar.GetAntiStat());
            if (this.mdj != null) {
                if (this.mdj.priv_sets != null) {
                    this.mcN = this.mdj.priv_sets.like.intValue();
                    this.mcO = this.mdj.priv_sets.post.intValue();
                }
                this.sex = this.mdj.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mcM = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.lVE = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dvD()) {
                fo(cVar.getConcernedForumList());
            }
            if (this.mcX == null) {
                c(this.mdj);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mdj, postInfoList, random);
                    }
                }
            }
            String yearBytime = at.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!y.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = at.getYearBytime(longValue);
                        String chineseMonthBytime = at.getChineseMonthBytime(longValue);
                        String dateBytime = at.getDateBytime(longValue);
                        if (at.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (at.equals(dateBytime, str3) && at.equals(chineseMonthBytime, str2) && at.equals(yearBytime2, yearBytime)) {
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
                                a(this.mdj, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mcY) && y.isEmpty(this.mdb)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dtG();
                this.maskType = cVar.getMaskType();
            }
            this.mdh = cVar.getUserAgreeInfo();
            this.mcU = cVar.getLiveInfo();
            this.mcV = cVar.getGoodsWindowInfo();
            this.mcW = cVar.getLiveReplayInfo();
            this.mdi = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bw bwVar = new bw();
                        bwVar.a(newestThreadList.get(i2));
                        bwVar.a(this.eEK);
                        bwVar.bmZ();
                        this.mdk.add(bwVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !y.isEmpty(user.gift_list)) {
            this.mcX = new g();
            this.mcX.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dvE() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mcY == null) {
                this.mcY = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mcP);
            this.mcP = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ico = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.icm = z;
            cardPersonDynamicThreadData.icl = z2;
            cardPersonDynamicThreadData.icn = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mcY.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dvE() || this.isHost) {
            if (this.mdb == null) {
                this.mdb = new ArrayList<>();
            }
            this.mcP = UtilHelper.getRandom(random, 3, this.mcP);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ico = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.icm = false;
            cardPersonDynamicThreadData.icl = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mcP);
            this.mdb.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mcY == null) {
                    this.mcY = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.icl = z;
                dVar.sex = this.sex;
                dVar.ice = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.icf = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.icf = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mcY.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dvD() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mcY == null) {
                this.mcY = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.icl = z;
            bVar.ice = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.icf = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jxd = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mdm = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mcY.add(bVar);
            this.mcY.add(dg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dvs() {
        if (this.mcS == null) {
            return null;
        }
        return this.mcS.getPhotoAlbum();
    }

    private void fo(List<ForumDynamic> list) {
        this.mcR = new c();
        this.mcR.mdo = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mds = forumDynamic.user_thread_count.intValue();
                this.mcR.mdo.add(fVar);
            }
        }
    }

    private boolean dvD() {
        if (this.isHost) {
            return false;
        }
        if (this.mcN == 3) {
            return true;
        }
        return this.mcN == 2 && !this.mcM;
    }

    public boolean dvE() {
        if (this.isHost) {
            return false;
        }
        if (this.mcO == 3) {
            return true;
        }
        return this.mcO == 2 && !this.mcM;
    }

    protected com.baidu.tieba.person.d dg(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.lQV = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dvF() {
        this.mcM = true;
        this.sex = 1;
        this.mcN = 1;
        this.mcO = 1;
        this.mcP = -1;
        this.mUserData = null;
        if (this.mcQ != null) {
            this.mcQ.clear();
        }
        this.mcQ = null;
        this.mcR = null;
        this.mcS = null;
        this.mcT = null;
        this.mcX = null;
        this.mCardNullPolymericData = null;
        if (this.mcY != null) {
            this.mcY.clear();
        }
        if (this.mdb != null) {
            this.mdb.clear();
        }
        this.mcY = null;
        this.mdb = null;
        this.mcZ.clear();
        this.mdh = null;
        this.mdi = null;
        this.maskType = 0;
        this.mcU = null;
        this.mcV = null;
        if (this.mcW != null) {
            this.mcW.clear();
        }
        if (this.mdk != null) {
            this.mdk.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mdj;
    }

    public AntiData cxn() {
        return this.fcN;
    }

    public com.baidu.tieba.i.b dvG() {
        return this.mcV;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cNe() {
        return this.mcZ;
    }

    private void dtG() {
        this.mda.clear();
        this.mdd = Z(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mdd.isQ = new Bundle();
        this.mdd.isQ.putBoolean("person_center_item_red_tip", true);
        this.mdd.mdD.isQ = new Bundle();
        this.mdd.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(this.mdd);
        this.mde = Z(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mde.isQ = new Bundle();
        this.mde.isQ.putBoolean("person_center_item_red_tip", true);
        this.mde.mdD.isQ = new Bundle();
        this.mde.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(this.mde);
        this.mdc = Z(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mdc.isQ = new Bundle();
        this.mdc.isQ.putBoolean("person_center_item_red_tip", true);
        this.mdc.mdD.isQ = new Bundle();
        this.mdc.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(this.mdc);
        n Z = Z(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Z.mdD.isQ = new Bundle();
        Z.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(Z);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Z2 = Z(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Z2.isQ = new Bundle();
            Z2.mdD.isQ = new Bundle();
            Z2.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mda.add(Z2);
        }
        this.mdf = Z(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mdf.isQ = new Bundle();
        this.mdf.isQ.putBoolean("person_center_item_red_tip", true);
        this.mdf.mdD.isQ = new Bundle();
        this.mdf.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(this.mdf);
        n Z3 = Z(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Z3.mdD.isQ = new Bundle();
        Z3.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.lVE != null) {
            Z3.mdD.isQ.putString("book_jump_link", this.lVE.lUs);
        }
        this.mda.add(Z3);
        n Z4 = Z(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Z4.mdD.isQ = new Bundle();
        Z4.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(Z4);
        n Z5 = Z(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Z5.mdD.isQ = new Bundle();
        Z5.mdD.isQ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mda.add(Z5);
        n Z6 = Z(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Z6.mdD.isQ = new Bundle();
        Z6.mdD.isQ.putString("key_service_centre", "");
        this.mda.add(Z6);
    }

    private n Z(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gbi = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mdD = new com.baidu.tieba.personCenter.d.a();
        nVar.mdD.isP = i3;
        return nVar;
    }

    public List<bw> getNewestThreadList() {
        return this.mdk;
    }
}
