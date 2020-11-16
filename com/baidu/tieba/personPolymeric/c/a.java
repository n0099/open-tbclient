package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
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
    public MetaData eDc;
    private AntiData fbU;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    private PersonUserGodInfo lVU;
    private com.baidu.tieba.person.data.d lVW;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    public NicknameInfo mdA;
    public User mdB;
    private ArrayList<com.baidu.adp.widget.ListView.q> mdi;
    private c mdj;
    private com.baidu.tieba.person.a.f mdk;
    private m mdl;
    private AlaLiveInfoCoreData mdm;
    private com.baidu.tieba.j.b mdn;
    private List<AlaLiveInfoCoreData> mdo;
    protected g mdp;
    protected List<com.baidu.adp.widget.ListView.q> mdq;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mdt;
    public n mdu;
    public n mdv;
    public n mdw;
    public n mdx;
    public n mdy;
    public UserAgreeInfo mdz;
    private boolean mde = true;
    protected int sex = 1;
    private int mdf = 1;
    private int mdg = 1;
    private int mdh = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.q> mdr = new ArrayList<>();
    private ArrayList<n> mds = new ArrayList<>();
    private List<bx> mdC = new ArrayList();

    public abstract void dvc();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cVn() {
        return this.mde;
    }

    public void vZ(boolean z) {
        this.mde = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mdB = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mdB);
            if (this.eDc == null) {
                this.eDc = new MetaData();
            }
            this.eDc.parserProtobuf(this.mdB);
            if (this.lVU == null) {
                this.lVU = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.lVU.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fbU == null) {
                this.fbU = new AntiData();
            }
            this.fbU.parserProtobuf(cVar.GetAntiStat());
            if (this.mdB != null) {
                if (this.mdB.priv_sets != null) {
                    this.mdf = this.mdB.priv_sets.like.intValue();
                    this.mdg = this.mdB.priv_sets.post.intValue();
                }
                this.sex = this.mdB.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mde = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.lVW = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!y.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dvd()) {
                fo(cVar.getConcernedForumList());
            }
            if (this.mdp == null) {
                c(this.mdB);
            }
            Random random = new Random();
            if (this.isHost && !y.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mdB, postInfoList, random);
                    }
                }
            }
            String yearBytime = au.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!y.isEmpty(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String yearBytime2 = au.getYearBytime(longValue);
                        String chineseMonthBytime = au.getChineseMonthBytime(longValue);
                        String dateBytime = au.getDateBytime(longValue);
                        if (au.equals(yearBytime2, yearBytime)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (au.equals(dateBytime, str3) && au.equals(chineseMonthBytime, str2) && au.equals(yearBytime2, yearBytime)) {
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
                                a(this.mdB, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && y.isEmpty(this.mdq) && y.isEmpty(this.mdt)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dtg();
                this.maskType = cVar.getMaskType();
            }
            this.mdz = cVar.getUserAgreeInfo();
            this.mdm = cVar.getLiveInfo();
            this.mdn = cVar.getGoodsWindowInfo();
            this.mdo = cVar.getLiveReplayInfo();
            this.mdA = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!y.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bx bxVar = new bx();
                        bxVar.a(newestThreadList.get(i2));
                        bxVar.a(this.eDc);
                        bxVar.bmb();
                        this.mdC.add(bxVar);
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
            this.mdp = new g();
            this.mdp.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dve() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.mdq == null) {
                this.mdq = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mdh);
            this.mdh = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.idd = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.idb = z;
            cardPersonDynamicThreadData.ida = z2;
            cardPersonDynamicThreadData.idc = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.mdq.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dve() || this.isHost) {
            if (this.mdt == null) {
                this.mdt = new ArrayList<>();
            }
            this.mdh = UtilHelper.getRandom(random, 3, this.mdh);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.idd = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.idb = false;
            cardPersonDynamicThreadData.ida = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mdh);
            this.mdt.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.isEmpty(list)) {
                if (this.mdq == null) {
                    this.mdq = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.ida = z;
                dVar.sex = this.sex;
                dVar.icT = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.icU = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.icU = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.mdq.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dvd() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.mdq == null) {
                this.mdq = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.ida = z;
            bVar.icT = au.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.icU = au.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jxU = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.mdE = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.mdq.add(bVar);
            this.mdq.add(dg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.q> duS() {
        if (this.mdk == null) {
            return null;
        }
        return this.mdk.getPhotoAlbum();
    }

    private void fo(List<ForumDynamic> list) {
        this.mdj = new c();
        this.mdj.mdG = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.mdK = forumDynamic.user_thread_count.intValue();
                this.mdj.mdG.add(fVar);
            }
        }
    }

    private boolean dvd() {
        if (this.isHost) {
            return false;
        }
        if (this.mdf == 3) {
            return true;
        }
        return this.mdf == 2 && !this.mde;
    }

    public boolean dve() {
        if (this.isHost) {
            return false;
        }
        if (this.mdg == 3) {
            return true;
        }
        return this.mdg == 2 && !this.mde;
    }

    protected com.baidu.tieba.person.d dg(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.lRl = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dvf() {
        this.mde = true;
        this.sex = 1;
        this.mdf = 1;
        this.mdg = 1;
        this.mdh = -1;
        this.mUserData = null;
        if (this.mdi != null) {
            this.mdi.clear();
        }
        this.mdi = null;
        this.mdj = null;
        this.mdk = null;
        this.mdl = null;
        this.mdp = null;
        this.mCardNullPolymericData = null;
        if (this.mdq != null) {
            this.mdq.clear();
        }
        if (this.mdt != null) {
            this.mdt.clear();
        }
        this.mdq = null;
        this.mdt = null;
        this.mdr.clear();
        this.mdz = null;
        this.mdA = null;
        this.maskType = 0;
        this.mdm = null;
        this.mdn = null;
        if (this.mdo != null) {
            this.mdo.clear();
        }
        if (this.mdC != null) {
            this.mdC.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mdB;
    }

    public AntiData cwP() {
        return this.fbU;
    }

    public com.baidu.tieba.j.b dvg() {
        return this.mdn;
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> cML() {
        return this.mdr;
    }

    private void dtg() {
        this.mds.clear();
        this.mdv = ab(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.mdv.itE = new Bundle();
        this.mdv.itE.putBoolean("person_center_item_red_tip", true);
        this.mdv.mdV.itE = new Bundle();
        this.mdv.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(this.mdv);
        this.mdw = ab(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.mdw.itE = new Bundle();
        this.mdw.itE.putBoolean("person_center_item_red_tip", true);
        this.mdw.mdV.itE = new Bundle();
        this.mdw.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(this.mdw);
        this.mdu = ab(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.mdu.itE = new Bundle();
        this.mdu.itE.putBoolean("person_center_item_red_tip", true);
        this.mdu.mdV.itE = new Bundle();
        this.mdu.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(this.mdu);
        n ab = ab(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ab.mdV.itE = new Bundle();
        ab.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(ab);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ab2 = ab(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ab2.itE = new Bundle();
            ab2.mdV.itE = new Bundle();
            ab2.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.mds.add(ab2);
        }
        this.mdx = ab(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mdx.itE = new Bundle();
        this.mdx.itE.putBoolean("person_center_item_red_tip", true);
        this.mdx.mdV.itE = new Bundle();
        this.mdx.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(this.mdx);
        n ab3 = ab(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        ab3.mdV.itE = new Bundle();
        ab3.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.lVW != null) {
            ab3.mdV.itE.putString("book_jump_link", this.lVW.lUK);
        }
        this.mds.add(ab3);
        n ab4 = ab(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        ab4.mdV.itE = new Bundle();
        ab4.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(ab4);
        n ab5 = ab(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ab5.mdV.itE = new Bundle();
        ab5.mdV.itE.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.mds.add(ab5);
        n ab6 = ab(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        ab6.mdV.itE = new Bundle();
        ab6.mdV.itE.putString("key_service_centre", "");
        this.mds.add(ab6);
    }

    private n ab(int i, int i2, int i3) {
        n nVar = new n();
        nVar.gaP = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.mdV = new com.baidu.tieba.personCenter.d.a();
        nVar.mdV.itD = i3;
        return nVar;
    }

    public List<bx> getNewestThreadList() {
        return this.mdC;
    }
}
