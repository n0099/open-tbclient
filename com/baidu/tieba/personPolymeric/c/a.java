package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
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
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes6.dex */
public abstract class a {
    private AntiData ceN;
    private PersonUserGodInfo idI;
    private com.baidu.tieba.person.data.d idJ;
    private ArrayList<com.baidu.adp.widget.ListView.m> ikc;
    private c ikd;
    private com.baidu.tieba.person.a.f ike;
    private m ikf;
    private AlaLiveInfoCoreData ikg;
    private List<AlaLiveInfoCoreData> ikh;
    protected g iki;
    protected List<com.baidu.adp.widget.ListView.m> ikj;
    protected ArrayList<com.baidu.adp.widget.ListView.m> ikm;
    public n ikn;
    public n iko;
    public n ikp;
    public n ikq;
    public n ikr;
    public n iks;
    private UserVideoChannelInfoData ikt;
    public UserAgreeInfo iku;
    public NicknameInfo ikv;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ijY = true;
    protected int sex = 1;
    private int ijZ = 1;
    private int ika = 1;
    private int ikb = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> ikk = new ArrayList<>();
    private ArrayList<n> ikl = new ArrayList<>();

    public abstract void caj();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bEl() {
        return this.ijY;
    }

    public void pB(boolean z) {
        this.ijY = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        boolean z;
        boolean z2;
        String str;
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (this.ceN == null) {
                this.ceN = new AntiData();
            }
            this.ceN.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.ijZ = cVar.GetUser().priv_sets.like.intValue();
                    this.ika = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ijY = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.ikt == null) {
                this.ikt = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.ikt.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.idJ = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.aa(cVar.getConcernedForumList()) && !this.isHost && !cak()) {
                dS(cVar.getConcernedForumList());
            }
            if (this.iki == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.aa(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String aX = ap.aX(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.aa(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String aX2 = ap.aX(longValue);
                        String ba = ap.ba(longValue);
                        String aZ = ap.aZ(longValue);
                        if (ap.equals(aX2, aX)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ap.equals(aZ, str3) && ap.equals(ba, str2) && ap.equals(aX2, aX)) {
                            z2 = false;
                            aZ = str3;
                            str = aX;
                        } else {
                            z2 = true;
                            str2 = ba;
                            str = aX2;
                        }
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z, z2, z3);
                                break;
                            case 2:
                                a(dynamicInfo, z2);
                                break;
                            case 3:
                                b(dynamicInfo, z2);
                                break;
                        }
                        z3 = false;
                        str3 = aZ;
                        aX = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.aa(this.ikj) && v.aa(this.ikm)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bYt();
                this.maskType = cVar.getMaskType();
            }
            if (this.idI == null) {
                this.idI = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.idI.parserProtobuf(cVar.getUserGodInfo());
            }
            this.iku = cVar.getUserAgreeInfo();
            this.ikg = cVar.getLiveInfo();
            this.ikh = cVar.getLiveReplayInfo();
            this.ikv = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.iki = new g();
            this.iki.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cal() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.ikj == null) {
                this.ikj = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.ikb);
            this.ikb = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eBP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eBN = z;
            cardPersonDynamicThreadData.eBM = z2;
            cardPersonDynamicThreadData.eBO = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.ikj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cal() || this.isHost) {
            if (this.ikm == null) {
                this.ikm = new ArrayList<>();
            }
            this.ikb = UtilHelper.getRandom(random, 3, this.ikb);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eBP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eBN = false;
            cardPersonDynamicThreadData.eBM = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.ikb);
            this.ikm.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.aa(list)) {
                if (this.ikj == null) {
                    this.ikj = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eBM = z;
                dVar.sex = this.sex;
                dVar.eBF = ap.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eBG = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eBG = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.ikj.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cak() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.ikj == null) {
                this.ikj = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eBM = z;
            bVar.eBF = ap.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eBG = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.ikx = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.iky = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.ikj.add(bVar);
            this.ikj.add(cf(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> caa() {
        if (this.ike == null) {
            return null;
        }
        return this.ike.getPhotoAlbum();
    }

    private void dS(List<ForumDynamic> list) {
        this.ikd = new c();
        this.ikd.ikA = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.ikE = forumDynamic.user_thread_count.intValue();
                this.ikd.ikA.add(fVar);
            }
        }
    }

    private boolean cak() {
        if (this.isHost) {
            return false;
        }
        if (this.ijZ == 3) {
            return true;
        }
        return this.ijZ == 2 && !this.ijY;
    }

    public boolean cal() {
        if (this.isHost) {
            return false;
        }
        if (this.ika == 3) {
            return true;
        }
        return this.ika == 2 && !this.ijY;
    }

    protected com.baidu.tieba.person.d cf(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.hYm = i;
        dVar.cwo = i2;
        return dVar;
    }

    public void cam() {
        this.ijY = true;
        this.sex = 1;
        this.ijZ = 1;
        this.ika = 1;
        this.ikb = -1;
        this.mUserData = null;
        if (this.ikc != null) {
            this.ikc.clear();
        }
        this.ikc = null;
        this.ikd = null;
        this.ike = null;
        this.ikf = null;
        this.iki = null;
        this.mCardNullPolymericData = null;
        if (this.ikj != null) {
            this.ikj.clear();
        }
        if (this.ikm != null) {
            this.ikm.clear();
        }
        this.ikj = null;
        this.ikm = null;
        this.ikk.clear();
        this.iku = null;
        this.ikv = null;
        this.maskType = 0;
        this.ikg = null;
        if (this.ikh != null) {
            this.ikh.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData biZ() {
        return this.ceN;
    }

    public AlaLiveInfoCoreData can() {
        return this.ikg;
    }

    public List<AlaLiveInfoCoreData> cao() {
        return this.ikh;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bwe() {
        return this.ikk;
    }

    public c cap() {
        return this.ikd;
    }

    public g caq() {
        return this.iki;
    }

    public PersonUserGodInfo car() {
        return this.idI;
    }

    private void bYt() {
        this.ikl.clear();
        this.ikp = ab(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.ikp.ayy = new Bundle();
        this.ikp.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikp.ikP.ayy = new Bundle();
        this.ikp.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(this.ikp);
        this.ikq = ab(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.ikq.ayy = new Bundle();
        this.ikq.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikq.ikP.ayy = new Bundle();
        this.ikq.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(this.ikq);
        this.ikn = ab(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.ikn.ayy = new Bundle();
        this.ikn.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikn.ikP.ayy = new Bundle();
        this.ikn.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(this.ikn);
        n ab = ab(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ab.ikP.ayy = new Bundle();
        ab.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(ab);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ab2 = ab(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ab2.ayy = new Bundle();
            ab2.ikP.ayy = new Bundle();
            ab2.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ikl.add(ab2);
        }
        if (this.ikt != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.ikt.getManChannel() == 1) {
                this.iko = ab(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.iko.ayy = new Bundle();
                this.iko.ayy.putBoolean("person_center_item_red_tip", true);
                this.iko.ikP.ayy = new Bundle();
                this.iko.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.ikl.add(this.iko);
            }
        }
        this.ikr = ab(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.ikr.ayy = new Bundle();
        this.ikr.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikr.ikP.ayy = new Bundle();
        this.ikr.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(this.ikr);
        n ab3 = ab(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        ab3.ikP.ayy = new Bundle();
        ab3.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.idJ != null) {
            ab3.ikP.ayy.putString("book_jump_link", this.idJ.icx);
        }
        this.ikl.add(ab3);
        n ab4 = ab(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        ab4.ikP.ayy = new Bundle();
        ab4.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(ab4);
        n ab5 = ab(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ab5.ikP.ayy = new Bundle();
        ab5.ikP.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikl.add(ab5);
        n ab6 = ab(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        ab6.ikP.ayy = new Bundle();
        ab6.ikP.ayy.putString("key_service_centre", "");
        this.ikl.add(ab6);
    }

    private n ab(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.ikP = new com.baidu.tieba.personCenter.c.a();
        nVar.ikP.eXw = i3;
        return nVar;
    }
}
