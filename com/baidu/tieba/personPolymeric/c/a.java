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
import com.baidu.tbadk.core.util.ao;
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
    private PersonUserGodInfo fQr;
    private com.baidu.tieba.person.data.d fQs;
    private ArrayList<com.baidu.adp.widget.ListView.h> fWg;
    private c fWh;
    private com.baidu.tieba.person.a.f fWi;
    private m fWj;
    private AlaLiveInfoCoreData fWk;
    private List<AlaLiveInfoCoreData> fWl;
    protected g fWm;
    protected List<com.baidu.adp.widget.ListView.h> fWn;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fWq;
    public n fWr;
    public n fWs;
    public n fWt;
    public n fWu;
    public n fWv;
    public n fWw;
    private UserVideoChannelInfoData fWx;
    public UserAgreeInfo fWy;
    public NicknameInfo fWz;
    private AntiData fpv;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fWc = true;
    protected int sex = 1;
    private int fWd = 1;
    private int fWe = 1;
    private int fWf = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> fWo = new ArrayList<>();
    private ArrayList<n> fWp = new ArrayList<>();

    public abstract void bkv();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aMq() {
        return this.fWc;
    }

    public void lp(boolean z) {
        this.fWc = z;
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
            if (this.fpv == null) {
                this.fpv = new AntiData();
            }
            this.fpv.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.fWd = cVar.GetUser().priv_sets.like.intValue();
                    this.fWe = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fWc = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fWx == null) {
                this.fWx = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fWx.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fQs = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!w.z(cVar.getConcernedForumList()) && !this.isHost && !bkw()) {
                de(cVar.getConcernedForumList());
            }
            if (this.fWm == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !w.z(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String N = ao.N(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!w.z(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String N2 = ao.N(longValue);
                        String Q = ao.Q(longValue);
                        String P = ao.P(longValue);
                        if (ao.equals(N2, N)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(P, str3) && ao.equals(Q, str2) && ao.equals(N2, N)) {
                            z2 = false;
                            P = str3;
                            str = N;
                        } else {
                            z2 = true;
                            str2 = Q;
                            str = N2;
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
                        str3 = P;
                        N = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && w.z(this.fWn) && w.z(this.fWq)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                biM();
                this.maskType = cVar.getMaskType();
            }
            if (this.fQr == null) {
                this.fQr = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fQr.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fWy = cVar.getUserAgreeInfo();
            this.fWk = cVar.getLiveInfo();
            this.fWl = cVar.getLiveReplayInfo();
            this.fWz = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !w.z(user.gift_list)) {
            this.fWm = new g();
            this.fWm.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bkx() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fWn == null) {
                this.fWn = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fWf);
            this.fWf = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cCt = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cCr = z;
            cardPersonDynamicThreadData.cCq = z2;
            cardPersonDynamicThreadData.cCs = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fWn.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bkx() || this.isHost) {
            if (this.fWq == null) {
                this.fWq = new ArrayList<>();
            }
            this.fWf = UtilHelper.getRandom(random, 3, this.fWf);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cCt = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cCr = false;
            cardPersonDynamicThreadData.cCq = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fWf);
            this.fWq.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!w.z(list)) {
                if (this.fWn == null) {
                    this.fWn = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cCq = z;
                dVar.sex = this.sex;
                dVar.cCj = ao.Q(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cCk = ao.P(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cCk = ao.P(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fWn.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bkw() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fWn == null) {
                this.fWn = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cCq = z;
            bVar.cCj = ao.Q(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cCk = ao.P(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fWB = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fWC = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fWn.add(bVar);
            this.fWn.add(bw(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0141d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bkm() {
        if (this.fWi == null) {
            return null;
        }
        return this.fWi.getPhotoAlbum();
    }

    private void de(List<ForumDynamic> list) {
        this.fWh = new c();
        this.fWh.fWE = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fWI = forumDynamic.user_thread_count.intValue();
                this.fWh.fWE.add(fVar);
            }
        }
    }

    private boolean bkw() {
        if (this.isHost) {
            return false;
        }
        if (this.fWd == 3) {
            return true;
        }
        return this.fWd == 2 && !this.fWc;
    }

    public boolean bkx() {
        if (this.isHost) {
            return false;
        }
        if (this.fWe == 3) {
            return true;
        }
        return this.fWe == 2 && !this.fWc;
    }

    protected com.baidu.tieba.person.d bw(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fLg = i;
        dVar.aQS = i2;
        return dVar;
    }

    public void bky() {
        this.fWc = true;
        this.sex = 1;
        this.fWd = 1;
        this.fWe = 1;
        this.fWf = -1;
        this.mUserData = null;
        if (this.fWg != null) {
            this.fWg.clear();
        }
        this.fWg = null;
        this.fWh = null;
        this.fWi = null;
        this.fWj = null;
        this.fWm = null;
        this.mCardNullPolymericData = null;
        if (this.fWn != null) {
            this.fWn.clear();
        }
        if (this.fWq != null) {
            this.fWq.clear();
        }
        this.fWn = null;
        this.fWq = null;
        this.fWo.clear();
        this.fWy = null;
        this.fWz = null;
        this.maskType = 0;
        this.fWk = null;
        if (this.fWl != null) {
            this.fWl.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData bbg() {
        return this.fpv;
    }

    public AlaLiveInfoCoreData bkz() {
        return this.fWk;
    }

    public List<AlaLiveInfoCoreData> bkA() {
        return this.fWl;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aEg() {
        return this.fWo;
    }

    public c bkB() {
        return this.fWh;
    }

    public g bkC() {
        return this.fWm;
    }

    public PersonUserGodInfo bkD() {
        return this.fQr;
    }

    private void biM() {
        this.fWp.clear();
        this.fWt = T(d.f.icon_starer_caise_heibai, d.k.mark, 20);
        this.fWt.cUs = new Bundle();
        this.fWt.cUs.putBoolean("person_center_item_red_tip", true);
        this.fWt.fWT.cUs = new Bundle();
        this.fWt.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(this.fWt);
        this.fWu = T(d.f.icon_lover_caise_heibai, d.k.contacts, 24);
        this.fWu.cUs = new Bundle();
        this.fWu.cUs.putBoolean("person_center_item_red_tip", true);
        this.fWu.fWT.cUs = new Bundle();
        this.fWu.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(this.fWu);
        this.fWr = T(d.f.icon_liwu_caise_heibai, d.k.gift, 34);
        this.fWr.cUs = new Bundle();
        this.fWr.cUs.putBoolean("person_center_item_red_tip", true);
        this.fWr.fWT.cUs = new Bundle();
        this.fWr.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(this.fWr);
        n T = T(d.f.icon_lishi_caise_heibai, d.k.history, 21);
        T.fWT.cUs = new Bundle();
        T.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n T2 = T(d.f.icon_zhibou_caise_heibai, d.k.ala_live, 29);
            T2.cUs = new Bundle();
            T2.fWT.cUs = new Bundle();
            T2.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fWp.add(T2);
        }
        if (this.fWx != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.fWx.getManChannel() == 1) {
                this.fWs = T(d.f.icon_weibar_caise_heibai, d.k.frs_channel_tip, 30);
                this.fWs.cUs = new Bundle();
                this.fWs.cUs.putBoolean("person_center_item_red_tip", true);
                this.fWs.fWT.cUs = new Bundle();
                this.fWs.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fWp.add(this.fWs);
            }
        }
        this.fWv = T(d.f.icon_vip_heibai, d.k.member_center_item, 16);
        this.fWv.cUs = new Bundle();
        this.fWv.cUs.putBoolean("person_center_item_red_tip", true);
        this.fWv.fWT.cUs = new Bundle();
        this.fWv.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(this.fWv);
        n T3 = T(d.f.icon_bookshoop_caise_heibai, d.k.book_shel, 33);
        T3.fWT.cUs = new Bundle();
        T3.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fQs != null) {
            T3.fWT.cUs.putString("book_jump_link", this.fQs.fPq);
        }
        this.fWp.add(T3);
        n T4 = T(d.f.icon_kabao_caise_heibai, d.k.card_box, 35);
        T4.fWT.cUs = new Bundle();
        T4.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(T4);
        n T5 = T(d.f.icon_xiaofeijilu_caise_heibai, d.k.consumption_records, 17);
        T5.fWT.cUs = new Bundle();
        T5.fWT.cUs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fWp.add(T5);
        n T6 = T(d.f.icon_fuwu_caise_heibai, d.k.person_service_centre, 41);
        T6.fWT.cUs = new Bundle();
        T6.fWT.cUs.putString("key_service_centre", "");
        this.fWp.add(T6);
    }

    private n T(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.fWT = new com.baidu.tieba.personCenter.c.a();
        nVar.fWT.cUr = i3;
        return nVar;
    }
}
