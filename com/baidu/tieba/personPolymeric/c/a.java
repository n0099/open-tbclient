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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.e;
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
    private AntiData aJw;
    private PersonUserGodInfo gjt;
    private com.baidu.tieba.person.data.d gju;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gpA;
    public n gpB;
    public n gpC;
    public n gpD;
    public n gpE;
    public n gpF;
    public n gpG;
    private UserVideoChannelInfoData gpH;
    public UserAgreeInfo gpI;
    public NicknameInfo gpJ;
    private ArrayList<com.baidu.adp.widget.ListView.h> gpq;
    private c gpr;
    private com.baidu.tieba.person.a.f gps;
    private m gpt;
    private AlaLiveInfoCoreData gpu;
    private List<AlaLiveInfoCoreData> gpv;
    protected g gpw;
    protected List<com.baidu.adp.widget.ListView.h> gpx;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gpm = true;
    protected int sex = 1;
    private int gpn = 1;
    private int gpo = 1;
    private int gpp = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gpy = new ArrayList<>();
    private ArrayList<n> gpz = new ArrayList<>();

    public abstract void bpd();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aTw() {
        return this.gpm;
    }

    public void lY(boolean z) {
        this.gpm = z;
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
            if (this.aJw == null) {
                this.aJw = new AntiData();
            }
            this.aJw.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gpn = cVar.GetUser().priv_sets.like.intValue();
                    this.gpo = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gpm = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gpH == null) {
                this.gpH = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gpH.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gju = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.J(cVar.getConcernedForumList()) && !this.isHost && !bpe()) {
                dt(cVar.getConcernedForumList());
            }
            if (this.gpw == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.J(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String W = ao.W(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.J(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String W2 = ao.W(longValue);
                        String Z = ao.Z(longValue);
                        String Y = ao.Y(longValue);
                        if (ao.equals(W2, W)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(Y, str3) && ao.equals(Z, str2) && ao.equals(W2, W)) {
                            z2 = false;
                            Y = str3;
                            str = W;
                        } else {
                            z2 = true;
                            str2 = Z;
                            str = W2;
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
                        str3 = Y;
                        W = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.J(this.gpx) && v.J(this.gpA)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bnu();
                this.maskType = cVar.getMaskType();
            }
            if (this.gjt == null) {
                this.gjt = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gjt.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gpI = cVar.getUserAgreeInfo();
            this.gpu = cVar.getLiveInfo();
            this.gpv = cVar.getLiveReplayInfo();
            this.gpJ = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.J(user.gift_list)) {
            this.gpw = new g();
            this.gpw.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bpf() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gpx == null) {
                this.gpx = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gpp);
            this.gpp = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cQZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cQX = z;
            cardPersonDynamicThreadData.cQW = z2;
            cardPersonDynamicThreadData.cQY = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gpx.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bpf() || this.isHost) {
            if (this.gpA == null) {
                this.gpA = new ArrayList<>();
            }
            this.gpp = UtilHelper.getRandom(random, 3, this.gpp);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cQZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cQX = false;
            cardPersonDynamicThreadData.cQW = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gpp);
            this.gpA.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.J(list)) {
                if (this.gpx == null) {
                    this.gpx = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cQW = z;
                dVar.sex = this.sex;
                dVar.cQP = ao.Z(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cQQ = ao.Y(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cQQ = ao.Y(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gpx.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bpe() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gpx == null) {
                this.gpx = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cQW = z;
            bVar.cQP = ao.Z(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cQQ = ao.Y(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gpL = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gpM = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gpx.add(bVar);
            this.gpx.add(bB(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0175e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> boU() {
        if (this.gps == null) {
            return null;
        }
        return this.gps.getPhotoAlbum();
    }

    private void dt(List<ForumDynamic> list) {
        this.gpr = new c();
        this.gpr.gpO = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gpS = forumDynamic.user_thread_count.intValue();
                this.gpr.gpO.add(fVar);
            }
        }
    }

    private boolean bpe() {
        if (this.isHost) {
            return false;
        }
        if (this.gpn == 3) {
            return true;
        }
        return this.gpn == 2 && !this.gpm;
    }

    public boolean bpf() {
        if (this.isHost) {
            return false;
        }
        if (this.gpo == 3) {
            return true;
        }
        return this.gpo == 2 && !this.gpm;
    }

    protected com.baidu.tieba.person.d bB(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.geb = i;
        dVar.aZA = i2;
        return dVar;
    }

    public void bpg() {
        this.gpm = true;
        this.sex = 1;
        this.gpn = 1;
        this.gpo = 1;
        this.gpp = -1;
        this.mUserData = null;
        if (this.gpq != null) {
            this.gpq.clear();
        }
        this.gpq = null;
        this.gpr = null;
        this.gps = null;
        this.gpt = null;
        this.gpw = null;
        this.mCardNullPolymericData = null;
        if (this.gpx != null) {
            this.gpx.clear();
        }
        if (this.gpA != null) {
            this.gpA.clear();
        }
        this.gpx = null;
        this.gpA = null;
        this.gpy.clear();
        this.gpI = null;
        this.gpJ = null;
        this.maskType = 0;
        this.gpu = null;
        if (this.gpv != null) {
            this.gpv.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData ayQ() {
        return this.aJw;
    }

    public AlaLiveInfoCoreData bph() {
        return this.gpu;
    }

    public List<AlaLiveInfoCoreData> bpi() {
        return this.gpv;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aLu() {
        return this.gpy;
    }

    public c bpj() {
        return this.gpr;
    }

    public g bpk() {
        return this.gpw;
    }

    public PersonUserGodInfo bpl() {
        return this.gjt;
    }

    private void bnu() {
        this.gpz.clear();
        this.gpD = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gpD.djh = new Bundle();
        this.gpD.djh.putBoolean("person_center_item_red_tip", true);
        this.gpD.gqd.djh = new Bundle();
        this.gpD.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(this.gpD);
        this.gpE = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gpE.djh = new Bundle();
        this.gpE.djh.putBoolean("person_center_item_red_tip", true);
        this.gpE.gqd.djh = new Bundle();
        this.gpE.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(this.gpE);
        this.gpB = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gpB.djh = new Bundle();
        this.gpB.djh.putBoolean("person_center_item_red_tip", true);
        this.gpB.gqd.djh = new Bundle();
        this.gpB.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(this.gpB);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.gqd.djh = new Bundle();
        X.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.djh = new Bundle();
            X2.gqd.djh = new Bundle();
            X2.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gpz.add(X2);
        }
        if (this.gpH != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gpH.getManChannel() == 1) {
                this.gpC = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gpC.djh = new Bundle();
                this.gpC.djh.putBoolean("person_center_item_red_tip", true);
                this.gpC.gqd.djh = new Bundle();
                this.gpC.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gpz.add(this.gpC);
            }
        }
        this.gpF = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gpF.djh = new Bundle();
        this.gpF.djh.putBoolean("person_center_item_red_tip", true);
        this.gpF.gqd.djh = new Bundle();
        this.gpF.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(this.gpF);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.gqd.djh = new Bundle();
        X3.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gju != null) {
            X3.gqd.djh.putString("book_jump_link", this.gju.giq);
        }
        this.gpz.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.gqd.djh = new Bundle();
        X4.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.gqd.djh = new Bundle();
        X5.gqd.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpz.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.gqd.djh = new Bundle();
        X6.gqd.djh.putString("key_service_centre", "");
        this.gpz.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gqd = new com.baidu.tieba.personCenter.c.a();
        nVar.gqd.djg = i3;
        return nVar;
    }
}
