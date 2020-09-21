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
/* loaded from: classes23.dex */
public abstract class a {
    private AntiData eCu;
    public MetaData eep;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo lnS;
    private com.baidu.tieba.person.data.d lnU;
    public UserAgreeInfo lvA;
    public NicknameInfo lvB;
    public User lvC;
    private ArrayList<com.baidu.adp.widget.ListView.q> lvj;
    private c lvk;
    private com.baidu.tieba.person.a.f lvl;
    private m lvm;
    private AlaLiveInfoCoreData lvn;
    private com.baidu.tieba.i.b lvo;
    private List<AlaLiveInfoCoreData> lvp;
    protected g lvq;
    protected List<com.baidu.adp.widget.ListView.q> lvr;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lvu;
    public n lvv;
    public n lvw;
    public n lvx;
    public n lvy;
    public n lvz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean lvf = true;
    protected int sex = 1;
    private int lvg = 1;
    private int lvh = 1;
    private int lvi = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lvs = new ArrayList<>();
    private ArrayList<n> lvt = new ArrayList<>();
    private List<bw> lvD = new ArrayList();

    public abstract void dmj();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cMr() {
        return this.lvf;
    }

    public void uP(boolean z) {
        this.lvf = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.lvC = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.lvC);
            if (this.eep == null) {
                this.eep = new MetaData();
            }
            this.eep.parserProtobuf(this.lvC);
            if (this.lnS == null) {
                this.lnS = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.lnS.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eCu == null) {
                this.eCu = new AntiData();
            }
            this.eCu.parserProtobuf(cVar.GetAntiStat());
            if (this.lvC != null) {
                if (this.lvC.priv_sets != null) {
                    this.lvg = this.lvC.priv_sets.like.intValue();
                    this.lvh = this.lvC.priv_sets.post.intValue();
                }
                this.sex = this.lvC.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.lvf = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.lnU = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dmk()) {
                eU(cVar.getConcernedForumList());
            }
            if (this.lvq == null) {
                c(this.lvC);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.lvC, postInfoList, random);
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
                                a(this.lvC, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.lvr) && y.isEmpty(this.lvu)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dkn();
                this.maskType = cVar.getMaskType();
            }
            this.lvA = cVar.getUserAgreeInfo();
            this.lvn = cVar.getLiveInfo();
            this.lvo = cVar.getGoodsWindowInfo();
            this.lvp = cVar.getLiveReplayInfo();
            this.lvB = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bw bwVar = new bw();
                        bwVar.a(newestThreadList.get(i2));
                        bwVar.a(this.eep);
                        bwVar.bfX();
                        this.lvD.add(bwVar);
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
            this.lvq = new g();
            this.lvq.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dml() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.lvr == null) {
                this.lvr = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.lvi);
            this.lvi = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.huZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.huX = z;
            cardPersonDynamicThreadData.huW = z2;
            cardPersonDynamicThreadData.huY = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.lvr.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dml() || this.isHost) {
            if (this.lvu == null) {
                this.lvu = new ArrayList<>();
            }
            this.lvi = UtilHelper.getRandom(random, 3, this.lvi);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.huZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.huX = false;
            cardPersonDynamicThreadData.huW = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.lvi);
            this.lvu.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.lvr == null) {
                    this.lvr = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.huW = z;
                dVar.sex = this.sex;
                dVar.huP = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.huQ = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.huQ = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.lvr.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dmk() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.lvr == null) {
                this.lvr = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.huW = z;
            bVar.huP = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.huQ = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.iPO = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.lvF = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.lvr.add(bVar);
            this.lvr.add(dc(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dlZ() {
        if (this.lvl == null) {
            return null;
        }
        return this.lvl.getPhotoAlbum();
    }

    private void eU(List<ForumDynamic> list) {
        this.lvk = new c();
        this.lvk.lvH = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.lvL = forumDynamic.user_thread_count.intValue();
                this.lvk.lvH.add(fVar);
            }
        }
    }

    private boolean dmk() {
        if (this.isHost) {
            return false;
        }
        if (this.lvg == 3) {
            return true;
        }
        return this.lvg == 2 && !this.lvf;
    }

    public boolean dml() {
        if (this.isHost) {
            return false;
        }
        if (this.lvh == 3) {
            return true;
        }
        return this.lvh == 2 && !this.lvf;
    }

    protected com.baidu.tieba.person.d dc(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.ljk = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dmm() {
        this.lvf = true;
        this.sex = 1;
        this.lvg = 1;
        this.lvh = 1;
        this.lvi = -1;
        this.mUserData = null;
        if (this.lvj != null) {
            this.lvj.clear();
        }
        this.lvj = null;
        this.lvk = null;
        this.lvl = null;
        this.lvm = null;
        this.lvq = null;
        this.mCardNullPolymericData = null;
        if (this.lvr != null) {
            this.lvr.clear();
        }
        if (this.lvu != null) {
            this.lvu.clear();
        }
        this.lvr = null;
        this.lvu = null;
        this.lvs.clear();
        this.lvA = null;
        this.lvB = null;
        this.maskType = 0;
        this.lvn = null;
        this.lvo = null;
        if (this.lvp != null) {
            this.lvp.clear();
        }
        if (this.lvD != null) {
            this.lvD.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.lvC;
    }

    public AntiData coh() {
        return this.eCu;
    }

    public com.baidu.tieba.i.b dmn() {
        return this.lvo;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cDN() {
        return this.lvs;
    }

    private void dkn() {
        this.lvt.clear();
        this.lvw = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.lvw.hLw = new Bundle();
        this.lvw.hLw.putBoolean("person_center_item_red_tip", true);
        this.lvw.lvW.hLw = new Bundle();
        this.lvw.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(this.lvw);
        this.lvx = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.lvx.hLw = new Bundle();
        this.lvx.hLw.putBoolean("person_center_item_red_tip", true);
        this.lvx.lvW.hLw = new Bundle();
        this.lvx.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(this.lvx);
        this.lvv = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.lvv.hLw = new Bundle();
        this.lvv.hLw.putBoolean("person_center_item_red_tip", true);
        this.lvv.lvW.hLw = new Bundle();
        this.lvv.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(this.lvv);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.lvW.hLw = new Bundle();
        Y.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.hLw = new Bundle();
            Y2.lvW.hLw = new Bundle();
            Y2.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.lvt.add(Y2);
        }
        this.lvy = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.lvy.hLw = new Bundle();
        this.lvy.hLw.putBoolean("person_center_item_red_tip", true);
        this.lvy.lvW.hLw = new Bundle();
        this.lvy.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(this.lvy);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.lvW.hLw = new Bundle();
        Y3.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.lnU != null) {
            Y3.lvW.hLw.putString("book_jump_link", this.lnU.lmH);
        }
        this.lvt.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.lvW.hLw = new Bundle();
        Y4.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.lvW.hLw = new Bundle();
        Y5.lvW.hLw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lvt.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.lvW.hLw = new Bundle();
        Y6.lvW.hLw.putString("key_service_centre", "");
        this.lvt.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.loj = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.lvW = new com.baidu.tieba.personCenter.d.a();
        nVar.lvW.hLv = i3;
        return nVar;
    }

    public List<bw> getNewestThreadList() {
        return this.lvD;
    }
}
