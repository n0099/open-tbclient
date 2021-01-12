package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
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
/* loaded from: classes7.dex */
public abstract class a {
    public MetaData ePn;
    private AntiData fos;
    public HotUserRankEntry hotUserRankEntry;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private PersonUserGodInfo mkG;
    private com.baidu.tieba.person.data.d mkI;
    private ArrayList<com.baidu.adp.widget.ListView.n> mrY;
    private c mrZ;
    private com.baidu.tieba.person.a.f msa;
    private m msb;
    private AlaLiveInfoCoreData msc;
    private com.baidu.tieba.j.b msd;
    private List<AlaLiveInfoCoreData> mse;
    protected g msf;
    protected List<com.baidu.adp.widget.ListView.n> msh;
    protected ArrayList<com.baidu.adp.widget.ListView.n> msk;
    public n msl;
    public n msm;
    public n msn;
    public n mso;
    public n msp;
    public UserAgreeInfo msq;
    public NicknameInfo msr;
    public User mss;
    private boolean mrU = true;
    protected int sex = 1;
    private int mrV = 1;
    private int mrW = 1;
    private int mrX = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.n> msi = new ArrayList<>();
    private ArrayList<n> msj = new ArrayList<>();
    private List<bz> mst = new ArrayList();

    public abstract void dwt();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean cWm() {
        return this.mrU;
    }

    public void wA(boolean z) {
        this.mrU = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            this.mss = cVar.GetUser();
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(this.mss);
            if (this.ePn == null) {
                this.ePn = new MetaData();
            }
            this.ePn.parserProtobuf(this.mss);
            if (this.mkG == null) {
                this.mkG = new PersonUserGodInfo();
            }
            UserGodInfo userGodInfo = cVar.getUserGodInfo();
            if (userGodInfo != null && (userGodInfo.god_type.intValue() == 2 || userGodInfo.god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.mkG.parserProtobuf(cVar.getUserGodInfo());
            }
            if (this.fos == null) {
                this.fos = new AntiData();
            }
            this.fos.parserProtobuf(cVar.GetAntiStat());
            if (this.mss != null) {
                if (this.mss.priv_sets != null) {
                    this.mrV = this.mss.priv_sets.like.intValue();
                    this.mrW = this.mss.priv_sets.post.intValue();
                }
                this.sex = this.mss.sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.mrU = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.mkI = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!x.isEmpty(cVar.getConcernedForumList()) && !this.isHost && !dwu()) {
                fA(cVar.getConcernedForumList());
            }
            if (this.msf == null) {
                c(this.mss);
            }
            Random random = new Random();
            if (this.isHost && !x.isEmpty(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(this.mss, postInfoList, random);
                    }
                }
            }
            String yearBytime = at.getYearBytime(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!x.isEmpty(cVar.getDynamicInfoList())) {
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
                            str = str3;
                        } else {
                            z2 = true;
                            str = dateBytime;
                            str2 = chineseMonthBytime;
                            yearBytime = yearBytime2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(this.mss, dynamicInfo, random, z, z2, z3);
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
                    }
                }
            }
            if (this.mCardNullPolymericData == null && x.isEmpty(this.msh) && x.isEmpty(this.msk)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                dux();
                this.maskType = cVar.getMaskType();
            }
            this.msq = cVar.getUserAgreeInfo();
            this.msc = cVar.getLiveInfo();
            this.msd = cVar.getGoodsWindowInfo();
            this.mse = cVar.getLiveReplayInfo();
            this.msr = cVar.getNicknameInfo();
            this.hotUserRankEntry = cVar.getHotRankEntry();
            List<ThreadInfo> newestThreadList = cVar.getNewestThreadList();
            if (!x.isEmpty(newestThreadList)) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < newestThreadList.size()) {
                        bz bzVar = new bz();
                        bzVar.a(newestThreadList.get(i2));
                        bzVar.a(this.ePn);
                        bzVar.bnV();
                        this.mst.add(bzVar);
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private void c(User user) {
        if (user != null && !x.isEmpty(user.gift_list)) {
            this.msf = new g();
            this.msf.parserProtoBuf(user);
        }
    }

    private void a(User user, DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!dwv() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.msh == null) {
                this.msh = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.mrX);
            this.mrX = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ivQ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.ivO = z;
            cardPersonDynamicThreadData.ivN = z2;
            cardPersonDynamicThreadData.ivP = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(user, threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.msh.add(cardPersonDynamicThreadData);
        }
    }

    private void a(User user, PostInfoList postInfoList, Random random) {
        if (!dwv() || this.isHost) {
            if (this.msk == null) {
                this.msk = new ArrayList<>();
            }
            this.mrX = UtilHelper.getRandom(random, 3, this.mrX);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.ivQ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.ivO = false;
            cardPersonDynamicThreadData.ivN = false;
            cardPersonDynamicThreadData.a(user, postInfoList, this.mrX);
            this.msk.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.isEmpty(list)) {
                if (this.msh == null) {
                    this.msh = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.ivN = z;
                dVar.sex = this.sex;
                dVar.ivG = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.ivH = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.ivH = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.msh.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!dwu() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.msh == null) {
                this.msh = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.ivN = z;
            bVar.ivG = at.getChineseMonthBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.ivH = at.getDateBytime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.jUh = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.msv = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.msh.add(bVar);
            this.msh.add(dh(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.CAM_X0204));
        }
    }

    public List<com.baidu.adp.widget.ListView.n> dwj() {
        if (this.msa == null) {
            return null;
        }
        return this.msa.getPhotoAlbum();
    }

    private void fA(List<ForumDynamic> list) {
        this.mrZ = new c();
        this.mrZ.msx = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.msB = forumDynamic.user_thread_count.intValue();
                this.mrZ.msx.add(fVar);
            }
        }
    }

    private boolean dwu() {
        if (this.isHost) {
            return false;
        }
        if (this.mrV == 3) {
            return true;
        }
        return this.mrV == 2 && !this.mrU;
    }

    public boolean dwv() {
        if (this.isHost) {
            return false;
        }
        if (this.mrW == 3) {
            return true;
        }
        return this.mrW == 2 && !this.mrU;
    }

    protected com.baidu.tieba.person.d dh(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.mfY = i;
        dVar.backgroundId = i2;
        return dVar;
    }

    public void dww() {
        this.mrU = true;
        this.sex = 1;
        this.mrV = 1;
        this.mrW = 1;
        this.mrX = -1;
        this.mUserData = null;
        if (this.mrY != null) {
            this.mrY.clear();
        }
        this.mrY = null;
        this.mrZ = null;
        this.msa = null;
        this.msb = null;
        this.msf = null;
        this.mCardNullPolymericData = null;
        if (this.msh != null) {
            this.msh.clear();
        }
        if (this.msk != null) {
            this.msk.clear();
        }
        this.msh = null;
        this.msk = null;
        this.msi.clear();
        this.msq = null;
        this.msr = null;
        this.maskType = 0;
        this.msc = null;
        this.msd = null;
        if (this.mse != null) {
            this.mse.clear();
        }
        if (this.mst != null) {
            this.mst.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public User getThreadUser() {
        return this.mss;
    }

    public AntiData cAh() {
        return this.fos;
    }

    public com.baidu.tieba.j.b dwx() {
        return this.msd;
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> cRp() {
        return this.msi;
    }

    private void dux() {
        this.msj.clear();
        this.msm = ac(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.msm.iMd = new Bundle();
        this.msm.iMd.putBoolean("person_center_item_red_tip", true);
        this.msm.msM.iMd = new Bundle();
        this.msm.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(this.msm);
        this.msn = ac(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.msn.iMd = new Bundle();
        this.msn.iMd.putBoolean("person_center_item_red_tip", true);
        this.msn.msM.iMd = new Bundle();
        this.msn.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(this.msn);
        this.msl = ac(R.drawable.icon_liwu_caise_heibai, R.string.gift, 32);
        this.msl.iMd = new Bundle();
        this.msl.iMd.putBoolean("person_center_item_red_tip", true);
        this.msl.msM.iMd = new Bundle();
        this.msl.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(this.msl);
        n ac = ac(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ac.msM.iMd = new Bundle();
        ac.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(ac);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ac2 = ac(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ac2.iMd = new Bundle();
            ac2.msM.iMd = new Bundle();
            ac2.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.msj.add(ac2);
        }
        this.mso = ac(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.mso.iMd = new Bundle();
        this.mso.iMd.putBoolean("person_center_item_red_tip", true);
        this.mso.msM.iMd = new Bundle();
        this.mso.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(this.mso);
        n ac3 = ac(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 31);
        ac3.msM.iMd = new Bundle();
        ac3.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.mkI != null) {
            ac3.msM.iMd.putString("book_jump_link", this.mkI.mjw);
        }
        this.msj.add(ac3);
        n ac4 = ac(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 33);
        ac4.msM.iMd = new Bundle();
        ac4.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(ac4);
        n ac5 = ac(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ac5.msM.iMd = new Bundle();
        ac5.msM.iMd.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.msj.add(ac5);
        n ac6 = ac(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 39);
        ac6.msM.iMd = new Bundle();
        ac6.msM.iMd.putString("key_service_centre", "");
        this.msj.add(ac6);
    }

    private n ac(int i, int i2, int i3) {
        n nVar = new n();
        nVar.goV = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.msM = new com.baidu.tieba.personCenter.d.a();
        nVar.msM.iMc = i3;
        return nVar;
    }

    public List<bz> getNewestThreadList() {
        return this.mst;
    }
}
