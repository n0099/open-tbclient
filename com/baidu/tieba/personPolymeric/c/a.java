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
    private PersonUserGodInfo gju;
    private com.baidu.tieba.person.data.d gjv;
    public n gpA;
    private UserVideoChannelInfoData gpB;
    public UserAgreeInfo gpC;
    public NicknameInfo gpD;
    private ArrayList<com.baidu.adp.widget.ListView.i> gpk;
    private c gpl;
    private com.baidu.tieba.person.a.f gpm;
    private m gpn;
    private AlaLiveInfoCoreData gpo;
    private List<AlaLiveInfoCoreData> gpp;
    protected g gpq;
    protected List<com.baidu.adp.widget.ListView.i> gpr;
    protected ArrayList<com.baidu.adp.widget.ListView.i> gpu;
    public n gpv;
    public n gpw;
    public n gpx;
    public n gpy;
    public n gpz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gpg = true;
    protected int sex = 1;
    private int gph = 1;
    private int gpi = 1;
    private int gpj = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.i> gps = new ArrayList<>();
    private ArrayList<n> gpt = new ArrayList<>();

    public abstract void bks();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aMx() {
        return this.gpg;
    }

    public void lD(boolean z) {
        this.gpg = z;
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
                    this.gph = cVar.GetUser().priv_sets.like.intValue();
                    this.gpi = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gpg = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gpB == null) {
                this.gpB = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gpB.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gjv = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.E(cVar.getConcernedForumList()) && !this.isHost && !bkt()) {
                de(cVar.getConcernedForumList());
            }
            if (this.gpq == null) {
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
            if (this.mCardNullPolymericData == null && v.E(this.gpr) && v.E(this.gpu)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                biL();
                this.maskType = cVar.getMaskType();
            }
            if (this.gju == null) {
                this.gju = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gju.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gpC = cVar.getUserAgreeInfo();
            this.gpo = cVar.getLiveInfo();
            this.gpp = cVar.getLiveReplayInfo();
            this.gpD = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.E(user.gift_list)) {
            this.gpq = new g();
            this.gpq.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bku() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gpr == null) {
                this.gpr = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gpj);
            this.gpj = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.daZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.daX = z;
            cardPersonDynamicThreadData.daW = z2;
            cardPersonDynamicThreadData.daY = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gpr.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bku() || this.isHost) {
            if (this.gpu == null) {
                this.gpu = new ArrayList<>();
            }
            this.gpj = UtilHelper.getRandom(random, 3, this.gpj);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.daZ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.daX = false;
            cardPersonDynamicThreadData.daW = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gpj);
            this.gpu.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.E(list)) {
                if (this.gpr == null) {
                    this.gpr = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.daW = z;
                dVar.sex = this.sex;
                dVar.daO = am.V(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.daP = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.daP = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gpr.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bkt() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gpr == null) {
                this.gpr = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.daW = z;
            bVar.daO = am.V(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.daP = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gpF = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gpG = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gpr.add(bVar);
            this.gpr.add(cv(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0140d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bki() {
        if (this.gpm == null) {
            return null;
        }
        return this.gpm.getPhotoAlbum();
    }

    private void de(List<ForumDynamic> list) {
        this.gpl = new c();
        this.gpl.gpI = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gpM = forumDynamic.user_thread_count.intValue();
                this.gpl.gpI.add(fVar);
            }
        }
    }

    private boolean bkt() {
        if (this.isHost) {
            return false;
        }
        if (this.gph == 3) {
            return true;
        }
        return this.gph == 2 && !this.gpg;
    }

    public boolean bku() {
        if (this.isHost) {
            return false;
        }
        if (this.gpi == 3) {
            return true;
        }
        return this.gpi == 2 && !this.gpg;
    }

    protected com.baidu.tieba.person.d cv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gen = i;
        dVar.byc = i2;
        return dVar;
    }

    public void bkv() {
        this.gpg = true;
        this.sex = 1;
        this.gph = 1;
        this.gpi = 1;
        this.gpj = -1;
        this.mUserData = null;
        if (this.gpk != null) {
            this.gpk.clear();
        }
        this.gpk = null;
        this.gpl = null;
        this.gpm = null;
        this.gpn = null;
        this.gpq = null;
        this.mCardNullPolymericData = null;
        if (this.gpr != null) {
            this.gpr.clear();
        }
        if (this.gpu != null) {
            this.gpu.clear();
        }
        this.gpr = null;
        this.gpu = null;
        this.gps.clear();
        this.gpC = null;
        this.gpD = null;
        this.maskType = 0;
        this.gpo = null;
        if (this.gpp != null) {
            this.gpp.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData bkw() {
        return this.gpo;
    }

    public List<AlaLiveInfoCoreData> bkx() {
        return this.gpp;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> aEo() {
        return this.gps;
    }

    public c bky() {
        return this.gpl;
    }

    public g bkz() {
        return this.gpq;
    }

    public PersonUserGodInfo bkA() {
        return this.gju;
    }

    private void biL() {
        this.gpt.clear();
        this.gpx = af(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.gpx.dry = new Bundle();
        this.gpx.dry.putBoolean("person_center_item_red_tip", true);
        this.gpx.gpX.dry = new Bundle();
        this.gpx.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(this.gpx);
        this.gpy = af(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.gpy.dry = new Bundle();
        this.gpy.dry.putBoolean("person_center_item_red_tip", true);
        this.gpy.gpX.dry = new Bundle();
        this.gpy.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(this.gpy);
        this.gpv = af(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.gpv.dry = new Bundle();
        this.gpv.dry.putBoolean("person_center_item_red_tip", true);
        this.gpv.gpX.dry = new Bundle();
        this.gpv.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(this.gpv);
        n af = af(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        af.gpX.dry = new Bundle();
        af.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(af);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n af2 = af(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            af2.dry = new Bundle();
            af2.gpX.dry = new Bundle();
            af2.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gpt.add(af2);
        }
        if (this.gpB != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.gpB.getManChannel() == 1) {
                this.gpw = af(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.gpw.dry = new Bundle();
                this.gpw.dry.putBoolean("person_center_item_red_tip", true);
                this.gpw.gpX.dry = new Bundle();
                this.gpw.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gpt.add(this.gpw);
            }
        }
        this.gpz = af(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.gpz.dry = new Bundle();
        this.gpz.dry.putBoolean("person_center_item_red_tip", true);
        this.gpz.gpX.dry = new Bundle();
        this.gpz.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(this.gpz);
        n af3 = af(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        af3.gpX.dry = new Bundle();
        af3.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gjv != null) {
            af3.gpX.dry.putString("book_jump_link", this.gjv.gir);
        }
        this.gpt.add(af3);
        n af4 = af(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        af4.gpX.dry = new Bundle();
        af4.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(af4);
        n af5 = af(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        af5.gpX.dry = new Bundle();
        af5.gpX.dry.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpt.add(af5);
        n af6 = af(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        af6.gpX.dry = new Bundle();
        af6.gpX.dry.putString("key_service_centre", "");
        this.gpt.add(af6);
    }

    private n af(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gpX = new com.baidu.tieba.personCenter.c.a();
        nVar.gpX.drx = i3;
        return nVar;
    }
}
