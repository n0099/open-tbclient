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
    private AntiData eWX;
    public MetaData eyV;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo lPG;
    private com.baidu.tieba.person.data.d lPI;
    private ArrayList<com.baidu.adp.widget.ListView.q> lWR;
    private c lWS;
    private com.baidu.tieba.person.a.f lWT;
    private m lWU;
    private AlaLiveInfoCoreData lWV;
    private com.baidu.tieba.i.b lWW;
    private List<AlaLiveInfoCoreData> lWX;
    protected g lWY;
    protected List<com.baidu.adp.widget.ListView.q> lWZ;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lXc;
    public n lXd;
    public n lXe;
    public n lXf;
    public n lXg;
    public n lXh;
    public UserAgreeInfo lXi;
    public NicknameInfo lXj;
    public User lXk;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean lWN = true;
    protected int sex = 1;
    private int lWO = 1;
    private int lWP = 1;
    private int lWQ = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> lXa = new ArrayList<>();
    private ArrayList<n> lXb = new ArrayList<>();
    private List<bw> lXl = new ArrayList();

    public abstract void dta();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cTg() {
        return this.lWN;
    }

    public void vN(boolean z) {
        this.lWN = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.lXk = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.lXk);
            if (this.eyV == null) {
                this.eyV = new MetaData();
            }
            this.eyV.parserProtobuf(this.lXk);
            if (this.lPG == null) {
                this.lPG = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.lPG.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.eWX == null) {
                this.eWX = new AntiData();
            }
            this.eWX.parserProtobuf(cVar.GetAntiStat());
            if (this.lXk != null) {
                if (this.lXk.priv_sets != null) {
                    this.lWO = this.lXk.priv_sets.like.intValue();
                    this.lWP = this.lXk.priv_sets.post.intValue();
                }
                this.sex = this.lXk.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.lWN = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.lPI = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dtb()) {
                fg(cVar.getConcernedForumList());
            }
            if (this.lWY == null) {
                c(this.lXk);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.lXk, postInfoList, random);
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
                                a(this.lXk, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.lWZ) && y.isEmpty(this.lXc)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dre();
                this.maskType = cVar.getMaskType();
            }
            this.lXi = cVar.getUserAgreeInfo();
            this.lWV = cVar.getLiveInfo();
            this.lWW = cVar.getGoodsWindowInfo();
            this.lWX = cVar.getLiveReplayInfo();
            this.lXj = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bw bwVar = new bw();
                        bwVar.a(newestThreadList.get(i2));
                        bwVar.a(this.eyV);
                        bwVar.bkz();
                        this.lXl.add(bwVar);
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
            this.lWY = new g();
            this.lWY.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dtc() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.lWZ == null) {
                this.lWZ = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.lWQ);
            this.lWQ = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hWr = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hWp = z;
            cardPersonDynamicThreadData.hWo = z2;
            cardPersonDynamicThreadData.hWq = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.lWZ.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dtc() || this.isHost) {
            if (this.lXc == null) {
                this.lXc = new ArrayList<>();
            }
            this.lWQ = UtilHelper.getRandom(random, 3, this.lWQ);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.hWr = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.hWp = false;
            cardPersonDynamicThreadData.hWo = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.lWQ);
            this.lXc.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.lWZ == null) {
                    this.lWZ = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.hWo = z;
                dVar.sex = this.sex;
                dVar.hWh = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hWi = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.hWi = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.lWZ.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dtb() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.lWZ == null) {
                this.lWZ = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.hWo = z;
            bVar.hWh = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.hWi = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jrg = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.lXn = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.lWZ.add(bVar);
            this.lWZ.add(de(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> dsQ() {
        if (this.lWT == null) {
            return null;
        }
        return this.lWT.getPhotoAlbum();
    }

    private void fg(List<ForumDynamic> list) {
        this.lWS = new c();
        this.lWS.lXp = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.lXt = forumDynamic.user_thread_count.intValue();
                this.lWS.lXp.add(fVar);
            }
        }
    }

    private boolean dtb() {
        if (this.isHost) {
            return false;
        }
        if (this.lWO == 3) {
            return true;
        }
        return this.lWO == 2 && !this.lWN;
    }

    public boolean dtc() {
        if (this.isHost) {
            return false;
        }
        if (this.lWP == 3) {
            return true;
        }
        return this.lWP == 2 && !this.lWN;
    }

    protected com.baidu.tieba.person.d de(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.lKZ = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dtd() {
        this.lWN = true;
        this.sex = 1;
        this.lWO = 1;
        this.lWP = 1;
        this.lWQ = -1;
        this.mUserData = null;
        if (this.lWR != null) {
            this.lWR.clear();
        }
        this.lWR = null;
        this.lWS = null;
        this.lWT = null;
        this.lWU = null;
        this.lWY = null;
        this.mCardNullPolymericData = null;
        if (this.lWZ != null) {
            this.lWZ.clear();
        }
        if (this.lXc != null) {
            this.lXc.clear();
        }
        this.lWZ = null;
        this.lXc = null;
        this.lXa.clear();
        this.lXi = null;
        this.lXj = null;
        this.maskType = 0;
        this.lWV = null;
        this.lWW = null;
        if (this.lWX != null) {
            this.lWX.clear();
        }
        if (this.lXl != null) {
            this.lXl.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.lXk;
    }

    public AntiData cuM() {
        return this.eWX;
    }

    public com.baidu.tieba.i.b dte() {
        return this.lWW;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cKD() {
        return this.lXa;
    }

    private void dre() {
        this.lXb.clear();
        this.lXe = Z(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.lXe.imS = new Bundle();
        this.lXe.imS.putBoolean("person_center_item_red_tip", true);
        this.lXe.lXE.imS = new Bundle();
        this.lXe.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(this.lXe);
        this.lXf = Z(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.lXf.imS = new Bundle();
        this.lXf.imS.putBoolean("person_center_item_red_tip", true);
        this.lXf.lXE.imS = new Bundle();
        this.lXf.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(this.lXf);
        this.lXd = Z(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.lXd.imS = new Bundle();
        this.lXd.imS.putBoolean("person_center_item_red_tip", true);
        this.lXd.lXE.imS = new Bundle();
        this.lXd.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(this.lXd);
        n Z = Z(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Z.lXE.imS = new Bundle();
        Z.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(Z);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Z2 = Z(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Z2.imS = new Bundle();
            Z2.lXE.imS = new Bundle();
            Z2.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.lXb.add(Z2);
        }
        this.lXg = Z(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.lXg.imS = new Bundle();
        this.lXg.imS.putBoolean("person_center_item_red_tip", true);
        this.lXg.lXE.imS = new Bundle();
        this.lXg.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(this.lXg);
        n Z3 = Z(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Z3.lXE.imS = new Bundle();
        Z3.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.lPI != null) {
            Z3.lXE.imS.putString("book_jump_link", this.lPI.lOw);
        }
        this.lXb.add(Z3);
        n Z4 = Z(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Z4.lXE.imS = new Bundle();
        Z4.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(Z4);
        n Z5 = Z(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Z5.lXE.imS = new Bundle();
        Z5.lXE.imS.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.lXb.add(Z5);
        n Z6 = Z(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Z6.lXE.imS = new Bundle();
        Z6.lXE.imS.putString("key_service_centre", "");
        this.lXb.add(Z6);
    }

    private n Z(int i, int i2, int i3) {
        n nVar = new n();
        nVar.fVr = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.lXE = new com.baidu.tieba.personCenter.d.a();
        nVar.lXE.imR = i3;
        return nVar;
    }

    public List<bw> getNewestThreadList() {
        return this.lXl;
    }
}
