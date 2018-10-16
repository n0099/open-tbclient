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
    private PersonUserGodInfo gjs;
    private com.baidu.tieba.person.data.d gjt;
    public n gpA;
    public n gpB;
    public n gpC;
    public n gpD;
    public n gpE;
    public n gpF;
    private UserVideoChannelInfoData gpG;
    public UserAgreeInfo gpH;
    public NicknameInfo gpI;
    private ArrayList<com.baidu.adp.widget.ListView.h> gpp;
    private c gpq;
    private com.baidu.tieba.person.a.f gpr;
    private m gps;
    private AlaLiveInfoCoreData gpt;
    private List<AlaLiveInfoCoreData> gpu;
    protected g gpv;
    protected List<com.baidu.adp.widget.ListView.h> gpw;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gpz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gpl = true;
    protected int sex = 1;
    private int gpm = 1;
    private int gpn = 1;
    private int gpo = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gpx = new ArrayList<>();
    private ArrayList<n> gpy = new ArrayList<>();

    public abstract void bpd();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aTw() {
        return this.gpl;
    }

    public void lY(boolean z) {
        this.gpl = z;
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
                    this.gpm = cVar.GetUser().priv_sets.like.intValue();
                    this.gpn = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gpl = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gpG == null) {
                this.gpG = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gpG.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gjt = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.J(cVar.getConcernedForumList()) && !this.isHost && !bpe()) {
                dt(cVar.getConcernedForumList());
            }
            if (this.gpv == null) {
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
            if (this.mCardNullPolymericData == null && v.J(this.gpw) && v.J(this.gpz)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bnu();
                this.maskType = cVar.getMaskType();
            }
            if (this.gjs == null) {
                this.gjs = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gjs.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gpH = cVar.getUserAgreeInfo();
            this.gpt = cVar.getLiveInfo();
            this.gpu = cVar.getLiveReplayInfo();
            this.gpI = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.J(user.gift_list)) {
            this.gpv = new g();
            this.gpv.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bpf() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gpw == null) {
                this.gpw = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gpo);
            this.gpo = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cQZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cQX = z;
            cardPersonDynamicThreadData.cQW = z2;
            cardPersonDynamicThreadData.cQY = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gpw.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bpf() || this.isHost) {
            if (this.gpz == null) {
                this.gpz = new ArrayList<>();
            }
            this.gpo = UtilHelper.getRandom(random, 3, this.gpo);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cQZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cQX = false;
            cardPersonDynamicThreadData.cQW = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gpo);
            this.gpz.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.J(list)) {
                if (this.gpw == null) {
                    this.gpw = new ArrayList();
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
                this.gpw.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bpe() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gpw == null) {
                this.gpw = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cQW = z;
            bVar.cQP = ao.Z(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cQQ = ao.Y(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gpK = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gpL = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gpw.add(bVar);
            this.gpw.add(bB(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0175e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> boU() {
        if (this.gpr == null) {
            return null;
        }
        return this.gpr.getPhotoAlbum();
    }

    private void dt(List<ForumDynamic> list) {
        this.gpq = new c();
        this.gpq.gpN = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gpR = forumDynamic.user_thread_count.intValue();
                this.gpq.gpN.add(fVar);
            }
        }
    }

    private boolean bpe() {
        if (this.isHost) {
            return false;
        }
        if (this.gpm == 3) {
            return true;
        }
        return this.gpm == 2 && !this.gpl;
    }

    public boolean bpf() {
        if (this.isHost) {
            return false;
        }
        if (this.gpn == 3) {
            return true;
        }
        return this.gpn == 2 && !this.gpl;
    }

    protected com.baidu.tieba.person.d bB(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gea = i;
        dVar.aZA = i2;
        return dVar;
    }

    public void bpg() {
        this.gpl = true;
        this.sex = 1;
        this.gpm = 1;
        this.gpn = 1;
        this.gpo = -1;
        this.mUserData = null;
        if (this.gpp != null) {
            this.gpp.clear();
        }
        this.gpp = null;
        this.gpq = null;
        this.gpr = null;
        this.gps = null;
        this.gpv = null;
        this.mCardNullPolymericData = null;
        if (this.gpw != null) {
            this.gpw.clear();
        }
        if (this.gpz != null) {
            this.gpz.clear();
        }
        this.gpw = null;
        this.gpz = null;
        this.gpx.clear();
        this.gpH = null;
        this.gpI = null;
        this.maskType = 0;
        this.gpt = null;
        if (this.gpu != null) {
            this.gpu.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData ayP() {
        return this.aJw;
    }

    public AlaLiveInfoCoreData bph() {
        return this.gpt;
    }

    public List<AlaLiveInfoCoreData> bpi() {
        return this.gpu;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aLu() {
        return this.gpx;
    }

    public c bpj() {
        return this.gpq;
    }

    public g bpk() {
        return this.gpv;
    }

    public PersonUserGodInfo bpl() {
        return this.gjs;
    }

    private void bnu() {
        this.gpy.clear();
        this.gpC = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gpC.djh = new Bundle();
        this.gpC.djh.putBoolean("person_center_item_red_tip", true);
        this.gpC.gqc.djh = new Bundle();
        this.gpC.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpC);
        this.gpD = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gpD.djh = new Bundle();
        this.gpD.djh.putBoolean("person_center_item_red_tip", true);
        this.gpD.gqc.djh = new Bundle();
        this.gpD.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpD);
        this.gpA = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gpA.djh = new Bundle();
        this.gpA.djh.putBoolean("person_center_item_red_tip", true);
        this.gpA.gqc.djh = new Bundle();
        this.gpA.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpA);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.gqc.djh = new Bundle();
        X.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.djh = new Bundle();
            X2.gqc.djh = new Bundle();
            X2.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gpy.add(X2);
        }
        if (this.gpG != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gpG.getManChannel() == 1) {
                this.gpB = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gpB.djh = new Bundle();
                this.gpB.djh.putBoolean("person_center_item_red_tip", true);
                this.gpB.gqc.djh = new Bundle();
                this.gpB.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gpy.add(this.gpB);
            }
        }
        this.gpE = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gpE.djh = new Bundle();
        this.gpE.djh.putBoolean("person_center_item_red_tip", true);
        this.gpE.gqc.djh = new Bundle();
        this.gpE.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpE);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.gqc.djh = new Bundle();
        X3.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gjt != null) {
            X3.gqc.djh.putString("book_jump_link", this.gjt.gip);
        }
        this.gpy.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.gqc.djh = new Bundle();
        X4.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.gqc.djh = new Bundle();
        X5.gqc.djh.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.gqc.djh = new Bundle();
        X6.gqc.djh.putString("key_service_centre", "");
        this.gpy.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gqc = new com.baidu.tieba.personCenter.c.a();
        nVar.gqc.djg = i3;
        return nVar;
    }
}
