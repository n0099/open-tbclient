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
    private PersonUserGodInfo idF;
    private com.baidu.tieba.person.data.d idG;
    private ArrayList<com.baidu.adp.widget.ListView.m> ijZ;
    private c ika;
    private com.baidu.tieba.person.a.f ikb;
    private m ikc;
    private AlaLiveInfoCoreData ikd;
    private List<AlaLiveInfoCoreData> ike;
    protected g ikf;
    protected List<com.baidu.adp.widget.ListView.m> ikg;
    protected ArrayList<com.baidu.adp.widget.ListView.m> ikj;
    public n ikk;
    public n ikl;
    public n ikm;
    public n ikn;
    public n iko;
    public n ikp;
    private UserVideoChannelInfoData ikq;
    public UserAgreeInfo ikr;
    public NicknameInfo iks;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ijV = true;
    protected int sex = 1;
    private int ijW = 1;
    private int ijX = 1;
    private int ijY = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> ikh = new ArrayList<>();
    private ArrayList<n> iki = new ArrayList<>();

    public abstract void cag();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bEi() {
        return this.ijV;
    }

    public void pB(boolean z) {
        this.ijV = z;
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
                    this.ijW = cVar.GetUser().priv_sets.like.intValue();
                    this.ijX = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ijV = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.ikq == null) {
                this.ikq = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.ikq.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.idG = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.aa(cVar.getConcernedForumList()) && !this.isHost && !cah()) {
                dS(cVar.getConcernedForumList());
            }
            if (this.ikf == null) {
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
            if (this.mCardNullPolymericData == null && v.aa(this.ikg) && v.aa(this.ikj)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bYq();
                this.maskType = cVar.getMaskType();
            }
            if (this.idF == null) {
                this.idF = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.idF.parserProtobuf(cVar.getUserGodInfo());
            }
            this.ikr = cVar.getUserAgreeInfo();
            this.ikd = cVar.getLiveInfo();
            this.ike = cVar.getLiveReplayInfo();
            this.iks = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.ikf = new g();
            this.ikf.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cai() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.ikg == null) {
                this.ikg = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.ijY);
            this.ijY = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eBO = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eBM = z;
            cardPersonDynamicThreadData.eBL = z2;
            cardPersonDynamicThreadData.eBN = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.ikg.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cai() || this.isHost) {
            if (this.ikj == null) {
                this.ikj = new ArrayList<>();
            }
            this.ijY = UtilHelper.getRandom(random, 3, this.ijY);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eBO = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eBM = false;
            cardPersonDynamicThreadData.eBL = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.ijY);
            this.ikj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.aa(list)) {
                if (this.ikg == null) {
                    this.ikg = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eBL = z;
                dVar.sex = this.sex;
                dVar.eBE = ap.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eBF = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eBF = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.ikg.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cah() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.ikg == null) {
                this.ikg = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eBL = z;
            bVar.eBE = ap.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eBF = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.iku = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.ikv = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.ikg.add(bVar);
            this.ikg.add(cf(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> bZX() {
        if (this.ikb == null) {
            return null;
        }
        return this.ikb.getPhotoAlbum();
    }

    private void dS(List<ForumDynamic> list) {
        this.ika = new c();
        this.ika.ikx = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.ikB = forumDynamic.user_thread_count.intValue();
                this.ika.ikx.add(fVar);
            }
        }
    }

    private boolean cah() {
        if (this.isHost) {
            return false;
        }
        if (this.ijW == 3) {
            return true;
        }
        return this.ijW == 2 && !this.ijV;
    }

    public boolean cai() {
        if (this.isHost) {
            return false;
        }
        if (this.ijX == 3) {
            return true;
        }
        return this.ijX == 2 && !this.ijV;
    }

    protected com.baidu.tieba.person.d cf(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.hYj = i;
        dVar.cwo = i2;
        return dVar;
    }

    public void caj() {
        this.ijV = true;
        this.sex = 1;
        this.ijW = 1;
        this.ijX = 1;
        this.ijY = -1;
        this.mUserData = null;
        if (this.ijZ != null) {
            this.ijZ.clear();
        }
        this.ijZ = null;
        this.ika = null;
        this.ikb = null;
        this.ikc = null;
        this.ikf = null;
        this.mCardNullPolymericData = null;
        if (this.ikg != null) {
            this.ikg.clear();
        }
        if (this.ikj != null) {
            this.ikj.clear();
        }
        this.ikg = null;
        this.ikj = null;
        this.ikh.clear();
        this.ikr = null;
        this.iks = null;
        this.maskType = 0;
        this.ikd = null;
        if (this.ike != null) {
            this.ike.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData biW() {
        return this.ceN;
    }

    public AlaLiveInfoCoreData cak() {
        return this.ikd;
    }

    public List<AlaLiveInfoCoreData> cal() {
        return this.ike;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bwb() {
        return this.ikh;
    }

    public c cam() {
        return this.ika;
    }

    public g can() {
        return this.ikf;
    }

    public PersonUserGodInfo cao() {
        return this.idF;
    }

    private void bYq() {
        this.iki.clear();
        this.ikm = ab(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.ikm.ayy = new Bundle();
        this.ikm.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikm.ikM.ayy = new Bundle();
        this.ikm.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(this.ikm);
        this.ikn = ab(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.ikn.ayy = new Bundle();
        this.ikn.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikn.ikM.ayy = new Bundle();
        this.ikn.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(this.ikn);
        this.ikk = ab(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.ikk.ayy = new Bundle();
        this.ikk.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikk.ikM.ayy = new Bundle();
        this.ikk.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(this.ikk);
        n ab = ab(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ab.ikM.ayy = new Bundle();
        ab.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(ab);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ab2 = ab(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ab2.ayy = new Bundle();
            ab2.ikM.ayy = new Bundle();
            ab2.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.iki.add(ab2);
        }
        if (this.ikq != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.ikq.getManChannel() == 1) {
                this.ikl = ab(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.ikl.ayy = new Bundle();
                this.ikl.ayy.putBoolean("person_center_item_red_tip", true);
                this.ikl.ikM.ayy = new Bundle();
                this.ikl.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.iki.add(this.ikl);
            }
        }
        this.iko = ab(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.iko.ayy = new Bundle();
        this.iko.ayy.putBoolean("person_center_item_red_tip", true);
        this.iko.ikM.ayy = new Bundle();
        this.iko.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(this.iko);
        n ab3 = ab(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        ab3.ikM.ayy = new Bundle();
        ab3.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.idG != null) {
            ab3.ikM.ayy.putString("book_jump_link", this.idG.icu);
        }
        this.iki.add(ab3);
        n ab4 = ab(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        ab4.ikM.ayy = new Bundle();
        ab4.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(ab4);
        n ab5 = ab(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ab5.ikM.ayy = new Bundle();
        ab5.ikM.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.iki.add(ab5);
        n ab6 = ab(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        ab6.ikM.ayy = new Bundle();
        ab6.ikM.ayy.putString("key_service_centre", "");
        this.iki.add(ab6);
    }

    private n ab(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.ikM = new com.baidu.tieba.personCenter.c.a();
        nVar.ikM.eXv = i3;
        return nVar;
    }
}
