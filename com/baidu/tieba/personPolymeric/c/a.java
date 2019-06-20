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
    private AntiData ceO;
    private PersonUserGodInfo idJ;
    private com.baidu.tieba.person.data.d idK;
    private ArrayList<com.baidu.adp.widget.ListView.m> ikd;
    private c ike;
    private com.baidu.tieba.person.a.f ikf;
    private m ikg;
    private AlaLiveInfoCoreData ikh;
    private List<AlaLiveInfoCoreData> iki;
    protected g ikj;
    protected List<com.baidu.adp.widget.ListView.m> ikk;
    protected ArrayList<com.baidu.adp.widget.ListView.m> ikn;
    public n iko;
    public n ikp;
    public n ikq;
    public n ikr;
    public n iks;
    public n ikt;
    private UserVideoChannelInfoData iku;
    public UserAgreeInfo ikv;
    public NicknameInfo ikw;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ijZ = true;
    protected int sex = 1;
    private int ika = 1;
    private int ikb = 1;
    private int ikc = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> ikl = new ArrayList<>();
    private ArrayList<n> ikm = new ArrayList<>();

    public abstract void cak();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bEm() {
        return this.ijZ;
    }

    public void pC(boolean z) {
        this.ijZ = z;
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
            if (this.ceO == null) {
                this.ceO = new AntiData();
            }
            this.ceO.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.ika = cVar.GetUser().priv_sets.like.intValue();
                    this.ikb = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ijZ = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.iku == null) {
                this.iku = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.iku.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.idK = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.aa(cVar.getConcernedForumList()) && !this.isHost && !cal()) {
                dS(cVar.getConcernedForumList());
            }
            if (this.ikj == null) {
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
            if (this.mCardNullPolymericData == null && v.aa(this.ikk) && v.aa(this.ikn)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bYu();
                this.maskType = cVar.getMaskType();
            }
            if (this.idJ == null) {
                this.idJ = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.idJ.parserProtobuf(cVar.getUserGodInfo());
            }
            this.ikv = cVar.getUserAgreeInfo();
            this.ikh = cVar.getLiveInfo();
            this.iki = cVar.getLiveReplayInfo();
            this.ikw = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.ikj = new g();
            this.ikj.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!cam() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.ikk == null) {
                this.ikk = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.ikc);
            this.ikc = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eBP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eBN = z;
            cardPersonDynamicThreadData.eBM = z2;
            cardPersonDynamicThreadData.eBO = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.ikk.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!cam() || this.isHost) {
            if (this.ikn == null) {
                this.ikn = new ArrayList<>();
            }
            this.ikc = UtilHelper.getRandom(random, 3, this.ikc);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eBP = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eBN = false;
            cardPersonDynamicThreadData.eBM = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.ikc);
            this.ikn.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.aa(list)) {
                if (this.ikk == null) {
                    this.ikk = new ArrayList();
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
                this.ikk.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!cal() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.ikk == null) {
                this.ikk = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eBM = z;
            bVar.eBF = ap.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eBG = ap.aZ(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.iky = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.ikz = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.ikk.add(bVar);
            this.ikk.add(cf(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cab() {
        if (this.ikf == null) {
            return null;
        }
        return this.ikf.getPhotoAlbum();
    }

    private void dS(List<ForumDynamic> list) {
        this.ike = new c();
        this.ike.ikB = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.ikF = forumDynamic.user_thread_count.intValue();
                this.ike.ikB.add(fVar);
            }
        }
    }

    private boolean cal() {
        if (this.isHost) {
            return false;
        }
        if (this.ika == 3) {
            return true;
        }
        return this.ika == 2 && !this.ijZ;
    }

    public boolean cam() {
        if (this.isHost) {
            return false;
        }
        if (this.ikb == 3) {
            return true;
        }
        return this.ikb == 2 && !this.ijZ;
    }

    protected com.baidu.tieba.person.d cf(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.hYn = i;
        dVar.cwp = i2;
        return dVar;
    }

    public void can() {
        this.ijZ = true;
        this.sex = 1;
        this.ika = 1;
        this.ikb = 1;
        this.ikc = -1;
        this.mUserData = null;
        if (this.ikd != null) {
            this.ikd.clear();
        }
        this.ikd = null;
        this.ike = null;
        this.ikf = null;
        this.ikg = null;
        this.ikj = null;
        this.mCardNullPolymericData = null;
        if (this.ikk != null) {
            this.ikk.clear();
        }
        if (this.ikn != null) {
            this.ikn.clear();
        }
        this.ikk = null;
        this.ikn = null;
        this.ikl.clear();
        this.ikv = null;
        this.ikw = null;
        this.maskType = 0;
        this.ikh = null;
        if (this.iki != null) {
            this.iki.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData biZ() {
        return this.ceO;
    }

    public AlaLiveInfoCoreData cao() {
        return this.ikh;
    }

    public List<AlaLiveInfoCoreData> cap() {
        return this.iki;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bwf() {
        return this.ikl;
    }

    public c caq() {
        return this.ike;
    }

    public g car() {
        return this.ikj;
    }

    public PersonUserGodInfo cas() {
        return this.idJ;
    }

    private void bYu() {
        this.ikm.clear();
        this.ikq = ab(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.ikq.ayy = new Bundle();
        this.ikq.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikq.ikQ.ayy = new Bundle();
        this.ikq.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(this.ikq);
        this.ikr = ab(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.ikr.ayy = new Bundle();
        this.ikr.ayy.putBoolean("person_center_item_red_tip", true);
        this.ikr.ikQ.ayy = new Bundle();
        this.ikr.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(this.ikr);
        this.iko = ab(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.iko.ayy = new Bundle();
        this.iko.ayy.putBoolean("person_center_item_red_tip", true);
        this.iko.ikQ.ayy = new Bundle();
        this.iko.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(this.iko);
        n ab = ab(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ab.ikQ.ayy = new Bundle();
        ab.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(ab);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ab2 = ab(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ab2.ayy = new Bundle();
            ab2.ikQ.ayy = new Bundle();
            ab2.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.ikm.add(ab2);
        }
        if (this.iku != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.iku.getManChannel() == 1) {
                this.ikp = ab(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.ikp.ayy = new Bundle();
                this.ikp.ayy.putBoolean("person_center_item_red_tip", true);
                this.ikp.ikQ.ayy = new Bundle();
                this.ikp.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.ikm.add(this.ikp);
            }
        }
        this.iks = ab(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.iks.ayy = new Bundle();
        this.iks.ayy.putBoolean("person_center_item_red_tip", true);
        this.iks.ikQ.ayy = new Bundle();
        this.iks.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(this.iks);
        n ab3 = ab(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        ab3.ikQ.ayy = new Bundle();
        ab3.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.idK != null) {
            ab3.ikQ.ayy.putString("book_jump_link", this.idK.icy);
        }
        this.ikm.add(ab3);
        n ab4 = ab(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        ab4.ikQ.ayy = new Bundle();
        ab4.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(ab4);
        n ab5 = ab(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ab5.ikQ.ayy = new Bundle();
        ab5.ikQ.ayy.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.ikm.add(ab5);
        n ab6 = ab(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        ab6.ikQ.ayy = new Bundle();
        ab6.ikQ.ayy.putString("key_service_centre", "");
        this.ikm.add(ab6);
    }

    private n ab(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.ikQ = new com.baidu.tieba.personCenter.c.a();
        nVar.ikQ.eXw = i3;
        return nVar;
    }
}
