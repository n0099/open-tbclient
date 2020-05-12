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
    private AntiData dMD;
    public MetaData drO;
    protected boolean isHost;
    private PersonUserGodInfo jTr;
    private com.baidu.tieba.person.data.d jTt;
    protected ArrayList<com.baidu.adp.widget.ListView.m> kaA;
    public n kaB;
    public n kaC;
    public n kaD;
    public n kaE;
    public n kaF;
    public UserAgreeInfo kaG;
    public NicknameInfo kaH;
    public User kaI;
    private ArrayList<com.baidu.adp.widget.ListView.m> kao;
    private c kap;
    private com.baidu.tieba.person.a.f kaq;
    private m kar;
    private AlaLiveInfoCoreData kas;
    private com.baidu.tieba.i.a kat;
    private List<AlaLiveInfoCoreData> kau;
    protected g kaw;
    protected List<com.baidu.adp.widget.ListView.m> kax;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean kak = true;
    protected int sex = 1;
    private int kal = 1;
    private int kam = 1;
    private int kan = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> kay = new ArrayList<>();
    private ArrayList<n> kaz = new ArrayList<>();
    private List<bj> kaJ = new ArrayList();

    public abstract void cIf();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cjv() {
        return this.kak;
    }

    public void sD(boolean z) {
        this.kak = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.kaI = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.kaI);
            if (this.drO == null) {
                this.drO = new MetaData();
            }
            this.drO.parserProtobuf(this.kaI);
            if (this.jTr == null) {
                this.jTr = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.jTr.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.dMD == null) {
                this.dMD = new AntiData();
            }
            this.dMD.parserProtobuf(cVar.GetAntiStat());
            if (this.kaI != null) {
                if (this.kaI.priv_sets != null) {
                    this.kal = this.kaI.priv_sets.like.intValue();
                    this.kam = this.kaI.priv_sets.post.intValue();
                }
                this.sex = this.kaI.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.kak = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.jTt = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !cIg()) {
                ec(cVar.getConcernedForumList());
            }
            if (this.kaw == null) {
                c(this.kaI);
            }
            Random random = new Random();
            if (this.isHost && !v.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.kaI, postInfoList, random);
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
                                a(this.kaI, dynamicInfo, random, z, z2, z3);
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
            if (this.mCardNullPolymericData == null && v.isEmpty(this.kax) && v.isEmpty(this.kaA)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                cGn();
                this.maskType = cVar.getMaskType();
            }
            this.kaG = cVar.getUserAgreeInfo();
            this.kas = cVar.getLiveInfo();
            this.kat = cVar.getGoodsWindowInfo();
            this.kau = cVar.getLiveReplayInfo();
            this.kaH = cVar.getNicknameInfo();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!v.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bj bjVar = new bj();
                        bjVar.a(newestThreadList.get(i2));
                        bjVar.a(this.drO);
                        bjVar.aLa();
                        this.kaJ.add(bjVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !v.isEmpty(user.gift_list)) {
            this.kaw = new g();
            this.kaw.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cIh() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.kax == null) {
                this.kax = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.kan);
            this.kan = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gtA = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gty = z;
            cardPersonDynamicThreadData.gtx = z2;
            cardPersonDynamicThreadData.gtz = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.kax.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!cIh() || this.isHost) {
            if (this.kaA == null) {
                this.kaA = new ArrayList<>();
            }
            this.kan = UtilHelper.getRandom(random, 3, this.kan);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.gtA = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.gty = false;
            cardPersonDynamicThreadData.gtx = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.kan);
            this.kaA.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.isEmpty(list)) {
                if (this.kax == null) {
                    this.kax = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.gtx = z;
                dVar.sex = this.sex;
                dVar.gtq = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gtr = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.gtr = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.kax.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cIg() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.kax == null) {
                this.kax = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.gtx = z;
            bVar.gtq = aq.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.gtr = aq.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.kaL = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.kaM = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.kax.add(bVar);
            this.kax.add(cD(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cHV() {
        if (this.kaq == null) {
            return null;
        }
        return this.kaq.getPhotoAlbum();
    }

    private void ec(List<ForumDynamic> list) {
        this.kap = new c();
        this.kap.kaO = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.kaS = forumDynamic.user_thread_count.intValue();
                this.kap.kaO.add(fVar);
            }
        }
    }

    private boolean cIg() {
        if (this.isHost) {
            return false;
        }
        if (this.kal == 3) {
            return true;
        }
        return this.kal == 2 && !this.kak;
    }

    public boolean cIh() {
        if (this.isHost) {
            return false;
        }
        if (this.kam == 3) {
            return true;
        }
        return this.kam == 2 && !this.kak;
    }

    protected com.baidu.tieba.person.d cD(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.jOI = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void cIi() {
        this.kak = true;
        this.sex = 1;
        this.kal = 1;
        this.kam = 1;
        this.kan = -1;
        this.mUserData = null;
        if (this.kao != null) {
            this.kao.clear();
        }
        this.kao = null;
        this.kap = null;
        this.kaq = null;
        this.kar = null;
        this.kaw = null;
        this.mCardNullPolymericData = null;
        if (this.kax != null) {
            this.kax.clear();
        }
        if (this.kaA != null) {
            this.kaA.clear();
        }
        this.kax = null;
        this.kaA = null;
        this.kay.clear();
        this.kaG = null;
        this.kaH = null;
        this.maskType = 0;
        this.kas = null;
        this.kat = null;
        if (this.kau != null) {
            this.kau.clear();
        }
        if (this.kaJ != null) {
            this.kaJ.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.kaI;
    }

    public AntiData bNF() {
        return this.dMD;
    }

    public com.baidu.tieba.i.a cIj() {
        return this.kat;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> cbp() {
        return this.kay;
    }

    private void cGn() {
        this.kaz.clear();
        this.kaC = Y(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.kaC.gKC = new Bundle();
        this.kaC.gKC.putBoolean("person_center_item_red_tip", true);
        this.kaC.kbd.gKC = new Bundle();
        this.kaC.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(this.kaC);
        this.kaD = Y(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.kaD.gKC = new Bundle();
        this.kaD.gKC.putBoolean("person_center_item_red_tip", true);
        this.kaD.kbd.gKC = new Bundle();
        this.kaD.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(this.kaD);
        this.kaB = Y(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.kaB.gKC = new Bundle();
        this.kaB.gKC.putBoolean("person_center_item_red_tip", true);
        this.kaB.kbd.gKC = new Bundle();
        this.kaB.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(this.kaB);
        n Y = Y(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        Y.kbd.gKC = new Bundle();
        Y.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(Y);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n Y2 = Y(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            Y2.gKC = new Bundle();
            Y2.kbd.gKC = new Bundle();
            Y2.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.kaz.add(Y2);
        }
        this.kaE = Y(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.kaE.gKC = new Bundle();
        this.kaE.gKC.putBoolean("person_center_item_red_tip", true);
        this.kaE.kbd.gKC = new Bundle();
        this.kaE.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(this.kaE);
        n Y3 = Y(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        Y3.kbd.gKC = new Bundle();
        Y3.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.jTt != null) {
            Y3.kbd.gKC.putString("book_jump_link", this.jTt.jSe);
        }
        this.kaz.add(Y3);
        n Y4 = Y(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        Y4.kbd.gKC = new Bundle();
        Y4.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(Y4);
        n Y5 = Y(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        Y5.kbd.gKC = new Bundle();
        Y5.kbd.gKC.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.kaz.add(Y5);
        n Y6 = Y(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        Y6.kbd.gKC = new Bundle();
        Y6.kbd.gKC.putString("key_service_centre", "");
        this.kaz.add(Y6);
    }

    private n Y(int i, int i2, int i3) {
        n nVar = new n();
        nVar.jTB = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.kbd = new com.baidu.tieba.personCenter.d.a();
        nVar.kbd.gKB = i3;
        return nVar;
    }

    public List<bj> getNewestThreadList() {
        return this.kaJ;
    }
}
