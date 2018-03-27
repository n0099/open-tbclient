package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
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
    private com.baidu.tieba.person.data.d gjA;
    private PersonUserGodInfo gjz;
    public n gpA;
    public n gpB;
    public n gpC;
    public n gpD;
    public n gpE;
    public n gpF;
    private UserVideoChannelInfoData gpG;
    public UserAgreeInfo gpH;
    public NicknameInfo gpI;
    private ArrayList<com.baidu.adp.widget.ListView.i> gpp;
    private c gpq;
    private com.baidu.tieba.person.a.f gpr;
    private m gps;
    private AlaLiveInfoCoreData gpt;
    private List<AlaLiveInfoCoreData> gpu;
    protected g gpv;
    protected List<com.baidu.adp.widget.ListView.i> gpw;
    protected ArrayList<com.baidu.adp.widget.ListView.i> gpz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gpl = true;
    protected int sex = 1;
    private int gpm = 1;
    private int gpn = 1;
    private int gpo = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.i> gpx = new ArrayList<>();
    private ArrayList<n> gpy = new ArrayList<>();

    public abstract void bks();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aMx() {
        return this.gpl;
    }

    public void lI(boolean z) {
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
                this.gjA = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.E(cVar.getConcernedForumList()) && !this.isHost && !bkt()) {
                de(cVar.getConcernedForumList());
            }
            if (this.gpv == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.E(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String S = am.S(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.E(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String S2 = am.S(longValue);
                        String V = am.V(longValue);
                        String U = am.U(longValue);
                        if (am.equals(S2, S)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (am.equals(U, str3) && am.equals(V, str2) && am.equals(S2, S)) {
                            z2 = false;
                            U = str3;
                            str = S;
                        } else {
                            z2 = true;
                            str2 = V;
                            str = S2;
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
                        str3 = U;
                        S = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.E(this.gpw) && v.E(this.gpz)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                biL();
                this.maskType = cVar.getMaskType();
            }
            if (this.gjz == null) {
                this.gjz = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gjz.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gpH = cVar.getUserAgreeInfo();
            this.gpt = cVar.getLiveInfo();
            this.gpu = cVar.getLiveReplayInfo();
            this.gpI = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.E(user.gift_list)) {
            this.gpv = new g();
            this.gpv.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bku() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gpw == null) {
                this.gpw = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gpo);
            this.gpo = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.daQ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.daO = z;
            cardPersonDynamicThreadData.daN = z2;
            cardPersonDynamicThreadData.daP = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gpw.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bku() || this.isHost) {
            if (this.gpz == null) {
                this.gpz = new ArrayList<>();
            }
            this.gpo = UtilHelper.getRandom(random, 3, this.gpo);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.daQ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.daO = false;
            cardPersonDynamicThreadData.daN = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gpo);
            this.gpz.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.E(list)) {
                if (this.gpw == null) {
                    this.gpw = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.daN = z;
                dVar.sex = this.sex;
                dVar.daF = am.V(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.daG = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.daG = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
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
        if ((!bkt() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gpw == null) {
                this.gpw = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.daN = z;
            bVar.daF = am.V(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.daG = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gpK = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gpL = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gpw.add(bVar);
            this.gpw.add(cv(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0141d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bki() {
        if (this.gpr == null) {
            return null;
        }
        return this.gpr.getPhotoAlbum();
    }

    private void de(List<ForumDynamic> list) {
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

    private boolean bkt() {
        if (this.isHost) {
            return false;
        }
        if (this.gpm == 3) {
            return true;
        }
        return this.gpm == 2 && !this.gpl;
    }

    public boolean bku() {
        if (this.isHost) {
            return false;
        }
        if (this.gpn == 3) {
            return true;
        }
        return this.gpn == 2 && !this.gpl;
    }

    protected com.baidu.tieba.person.d cv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.get = i;
        dVar.bxS = i2;
        return dVar;
    }

    public void bkv() {
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

    public AlaLiveInfoCoreData bkw() {
        return this.gpt;
    }

    public List<AlaLiveInfoCoreData> bkx() {
        return this.gpu;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> aEo() {
        return this.gpx;
    }

    public c bky() {
        return this.gpq;
    }

    public g bkz() {
        return this.gpv;
    }

    public PersonUserGodInfo bkA() {
        return this.gjz;
    }

    private void biL() {
        this.gpy.clear();
        this.gpC = af(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.gpC.drp = new Bundle();
        this.gpC.drp.putBoolean("person_center_item_red_tip", true);
        this.gpC.gqc.drp = new Bundle();
        this.gpC.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpC);
        this.gpD = af(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.gpD.drp = new Bundle();
        this.gpD.drp.putBoolean("person_center_item_red_tip", true);
        this.gpD.gqc.drp = new Bundle();
        this.gpD.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpD);
        this.gpA = af(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.gpA.drp = new Bundle();
        this.gpA.drp.putBoolean("person_center_item_red_tip", true);
        this.gpA.gqc.drp = new Bundle();
        this.gpA.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpA);
        n af = af(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        af.gqc.drp = new Bundle();
        af.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(af);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n af2 = af(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            af2.drp = new Bundle();
            af2.gqc.drp = new Bundle();
            af2.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gpy.add(af2);
        }
        if (this.gpG != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.gpG.getManChannel() == 1) {
                this.gpB = af(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.gpB.drp = new Bundle();
                this.gpB.drp.putBoolean("person_center_item_red_tip", true);
                this.gpB.gqc.drp = new Bundle();
                this.gpB.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gpy.add(this.gpB);
            }
        }
        this.gpE = af(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.gpE.drp = new Bundle();
        this.gpE.drp.putBoolean("person_center_item_red_tip", true);
        this.gpE.gqc.drp = new Bundle();
        this.gpE.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(this.gpE);
        n af3 = af(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        af3.gqc.drp = new Bundle();
        af3.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gjA != null) {
            af3.gqc.drp.putString("book_jump_link", this.gjA.giw);
        }
        this.gpy.add(af3);
        n af4 = af(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        af4.gqc.drp = new Bundle();
        af4.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(af4);
        n af5 = af(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        af5.gqc.drp = new Bundle();
        af5.gqc.drp.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpy.add(af5);
        n af6 = af(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        af6.gqc.drp = new Bundle();
        af6.gqc.drp.putString("key_service_centre", "");
        this.gpy.add(af6);
    }

    private n af(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gqc = new com.baidu.tieba.personCenter.c.a();
        nVar.gqc.dro = i3;
        return nVar;
    }
}
