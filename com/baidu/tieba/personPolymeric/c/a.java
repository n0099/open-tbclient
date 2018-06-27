package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
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
/* loaded from: classes3.dex */
public abstract class a {
    private AntiData aBW;
    private PersonUserGodInfo fUt;
    private com.baidu.tieba.person.data.d fUu;
    private ArrayList<com.baidu.adp.widget.ListView.h> gag;
    private c gah;
    private com.baidu.tieba.person.a.f gai;
    private m gaj;
    private AlaLiveInfoCoreData gak;
    private List<AlaLiveInfoCoreData> gal;
    protected g gam;
    protected List<com.baidu.adp.widget.ListView.h> gan;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gaq;
    public n gar;
    public n gas;
    public n gat;
    public n gau;
    public n gav;
    public n gaw;
    private UserVideoChannelInfoData gax;
    public UserAgreeInfo gay;
    public NicknameInfo gaz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gac = true;
    protected int sex = 1;
    private int gad = 1;
    private int gae = 1;
    private int gaf = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gao = new ArrayList<>();
    private ArrayList<n> gap = new ArrayList<>();

    public abstract void bla();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aMW() {
        return this.gac;
    }

    public void lz(boolean z) {
        this.gac = z;
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
            if (this.aBW == null) {
                this.aBW = new AntiData();
            }
            this.aBW.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gad = cVar.GetUser().priv_sets.like.intValue();
                    this.gae = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gac = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gax == null) {
                this.gax = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gax.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fUu = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!w.A(cVar.getConcernedForumList()) && !this.isHost && !blb()) {
                di(cVar.getConcernedForumList());
            }
            if (this.gam == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !w.A(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String O = ap.O(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!w.A(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String O2 = ap.O(longValue);
                        String R = ap.R(longValue);
                        String Q = ap.Q(longValue);
                        if (ap.equals(O2, O)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ap.equals(Q, str3) && ap.equals(R, str2) && ap.equals(O2, O)) {
                            z2 = false;
                            Q = str3;
                            str = O;
                        } else {
                            z2 = true;
                            str2 = R;
                            str = O2;
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
                        str3 = Q;
                        O = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && w.A(this.gan) && w.A(this.gaq)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bjs();
                this.maskType = cVar.getMaskType();
            }
            if (this.fUt == null) {
                this.fUt = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fUt.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gay = cVar.getUserAgreeInfo();
            this.gak = cVar.getLiveInfo();
            this.gal = cVar.getLiveReplayInfo();
            this.gaz = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !w.A(user.gift_list)) {
            this.gam = new g();
            this.gam.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!blc() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gan == null) {
                this.gan = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gaf);
            this.gaf = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cAn = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cAl = z;
            cardPersonDynamicThreadData.cAk = z2;
            cardPersonDynamicThreadData.cAm = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gan.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!blc() || this.isHost) {
            if (this.gaq == null) {
                this.gaq = new ArrayList<>();
            }
            this.gaf = UtilHelper.getRandom(random, 3, this.gaf);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cAn = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cAl = false;
            cardPersonDynamicThreadData.cAk = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gaf);
            this.gaq.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!w.A(list)) {
                if (this.gan == null) {
                    this.gan = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cAk = z;
                dVar.sex = this.sex;
                dVar.cAd = ap.R(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cAe = ap.Q(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cAe = ap.Q(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gan.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!blb() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gan == null) {
                this.gan = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cAk = z;
            bVar.cAd = ap.R(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cAe = ap.Q(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gaB = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gaC = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gan.add(bVar);
            this.gan.add(bv(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0142d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bkR() {
        if (this.gai == null) {
            return null;
        }
        return this.gai.getPhotoAlbum();
    }

    private void di(List<ForumDynamic> list) {
        this.gah = new c();
        this.gah.gaE = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gaI = forumDynamic.user_thread_count.intValue();
                this.gah.gaE.add(fVar);
            }
        }
    }

    private boolean blb() {
        if (this.isHost) {
            return false;
        }
        if (this.gad == 3) {
            return true;
        }
        return this.gad == 2 && !this.gac;
    }

    public boolean blc() {
        if (this.isHost) {
            return false;
        }
        if (this.gae == 3) {
            return true;
        }
        return this.gae == 2 && !this.gac;
    }

    protected com.baidu.tieba.person.d bv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fPi = i;
        dVar.aRO = i2;
        return dVar;
    }

    public void bld() {
        this.gac = true;
        this.sex = 1;
        this.gad = 1;
        this.gae = 1;
        this.gaf = -1;
        this.mUserData = null;
        if (this.gag != null) {
            this.gag.clear();
        }
        this.gag = null;
        this.gah = null;
        this.gai = null;
        this.gaj = null;
        this.gam = null;
        this.mCardNullPolymericData = null;
        if (this.gan != null) {
            this.gan.clear();
        }
        if (this.gaq != null) {
            this.gaq.clear();
        }
        this.gan = null;
        this.gaq = null;
        this.gao.clear();
        this.gay = null;
        this.gaz = null;
        this.maskType = 0;
        this.gak = null;
        if (this.gal != null) {
            this.gal.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData Cm() {
        return this.aBW;
    }

    public AlaLiveInfoCoreData ble() {
        return this.gak;
    }

    public List<AlaLiveInfoCoreData> blf() {
        return this.gal;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aEQ() {
        return this.gao;
    }

    public c blg() {
        return this.gah;
    }

    public g blh() {
        return this.gam;
    }

    public PersonUserGodInfo bli() {
        return this.fUt;
    }

    private void bjs() {
        this.gap.clear();
        this.gat = T(d.f.icon_starer_caise_heibai, d.k.mark, 20);
        this.gat.cSu = new Bundle();
        this.gat.cSu.putBoolean("person_center_item_red_tip", true);
        this.gat.gaT.cSu = new Bundle();
        this.gat.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(this.gat);
        this.gau = T(d.f.icon_lover_caise_heibai, d.k.contacts, 24);
        this.gau.cSu = new Bundle();
        this.gau.cSu.putBoolean("person_center_item_red_tip", true);
        this.gau.gaT.cSu = new Bundle();
        this.gau.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(this.gau);
        this.gar = T(d.f.icon_liwu_caise_heibai, d.k.gift, 34);
        this.gar.cSu = new Bundle();
        this.gar.cSu.putBoolean("person_center_item_red_tip", true);
        this.gar.gaT.cSu = new Bundle();
        this.gar.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(this.gar);
        n T = T(d.f.icon_lishi_caise_heibai, d.k.history, 21);
        T.gaT.cSu = new Bundle();
        T.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n T2 = T(d.f.icon_zhibou_caise_heibai, d.k.ala_live, 29);
            T2.cSu = new Bundle();
            T2.gaT.cSu = new Bundle();
            T2.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gap.add(T2);
        }
        if (this.gax != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.gax.getManChannel() == 1) {
                this.gas = T(d.f.icon_weibar_caise_heibai, d.k.frs_channel_tip, 30);
                this.gas.cSu = new Bundle();
                this.gas.cSu.putBoolean("person_center_item_red_tip", true);
                this.gas.gaT.cSu = new Bundle();
                this.gas.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gap.add(this.gas);
            }
        }
        this.gav = T(d.f.icon_vip_heibai, d.k.member_center_item, 16);
        this.gav.cSu = new Bundle();
        this.gav.cSu.putBoolean("person_center_item_red_tip", true);
        this.gav.gaT.cSu = new Bundle();
        this.gav.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(this.gav);
        n T3 = T(d.f.icon_bookshoop_caise_heibai, d.k.book_shel, 33);
        T3.gaT.cSu = new Bundle();
        T3.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fUu != null) {
            T3.gaT.cSu.putString("book_jump_link", this.fUu.fTs);
        }
        this.gap.add(T3);
        n T4 = T(d.f.icon_kabao_caise_heibai, d.k.card_box, 35);
        T4.gaT.cSu = new Bundle();
        T4.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(T4);
        n T5 = T(d.f.icon_xiaofeijilu_caise_heibai, d.k.consumption_records, 17);
        T5.gaT.cSu = new Bundle();
        T5.gaT.cSu.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gap.add(T5);
        n T6 = T(d.f.icon_fuwu_caise_heibai, d.k.person_service_centre, 41);
        T6.gaT.cSu = new Bundle();
        T6.gaT.cSu.putString("key_service_centre", "");
        this.gap.add(T6);
    }

    private n T(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gaT = new com.baidu.tieba.personCenter.c.a();
        nVar.gaT.cSt = i3;
        return nVar;
    }
}
