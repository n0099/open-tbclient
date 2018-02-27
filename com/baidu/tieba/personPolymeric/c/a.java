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
    private PersonUserGodInfo gjj;
    private com.baidu.tieba.person.data.d gjk;
    private ArrayList<com.baidu.adp.widget.ListView.i> goZ;
    private c gpa;
    private com.baidu.tieba.person.a.f gpb;
    private m gpc;
    private AlaLiveInfoCoreData gpd;
    private List<AlaLiveInfoCoreData> gpe;
    protected g gpf;
    protected List<com.baidu.adp.widget.ListView.i> gpg;
    protected ArrayList<com.baidu.adp.widget.ListView.i> gpj;
    public n gpk;
    public n gpl;
    public n gpm;
    public n gpn;
    public n gpo;
    public n gpp;
    private UserVideoChannelInfoData gpq;
    public UserAgreeInfo gpr;
    public NicknameInfo gps;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean goV = true;
    protected int sex = 1;
    private int goW = 1;
    private int goX = 1;
    private int goY = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.i> gph = new ArrayList<>();
    private ArrayList<n> gpi = new ArrayList<>();

    public abstract void bkr();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aMw() {
        return this.goV;
    }

    public void lD(boolean z) {
        this.goV = z;
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
                    this.goW = cVar.GetUser().priv_sets.like.intValue();
                    this.goX = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.goV = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gpq == null) {
                this.gpq = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gpq.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gjk = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.E(cVar.getConcernedForumList()) && !this.isHost && !bks()) {
                de(cVar.getConcernedForumList());
            }
            if (this.gpf == null) {
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
            if (this.mCardNullPolymericData == null && v.E(this.gpg) && v.E(this.gpj)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                biK();
                this.maskType = cVar.getMaskType();
            }
            if (this.gjj == null) {
                this.gjj = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gjj.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gpr = cVar.getUserAgreeInfo();
            this.gpd = cVar.getLiveInfo();
            this.gpe = cVar.getLiveReplayInfo();
            this.gps = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.E(user.gift_list)) {
            this.gpf = new g();
            this.gpf.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!bkt() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gpg == null) {
                this.gpg = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.goY);
            this.goY = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.daN = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.daL = z;
            cardPersonDynamicThreadData.daK = z2;
            cardPersonDynamicThreadData.daM = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gpg.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bkt() || this.isHost) {
            if (this.gpj == null) {
                this.gpj = new ArrayList<>();
            }
            this.goY = UtilHelper.getRandom(random, 3, this.goY);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.daN = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.daL = false;
            cardPersonDynamicThreadData.daK = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.goY);
            this.gpj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.E(list)) {
                if (this.gpg == null) {
                    this.gpg = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.daK = z;
                dVar.sex = this.sex;
                dVar.daC = am.V(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.daD = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.daD = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gpg.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!bks() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gpg == null) {
                this.gpg = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.daK = z;
            bVar.daC = am.V(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.daD = am.U(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gpu = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gpv = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gpg.add(bVar);
            this.gpg.add(cv(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0141d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.i> bkh() {
        if (this.gpb == null) {
            return null;
        }
        return this.gpb.getPhotoAlbum();
    }

    private void de(List<ForumDynamic> list) {
        this.gpa = new c();
        this.gpa.gpx = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gpB = forumDynamic.user_thread_count.intValue();
                this.gpa.gpx.add(fVar);
            }
        }
    }

    private boolean bks() {
        if (this.isHost) {
            return false;
        }
        if (this.goW == 3) {
            return true;
        }
        return this.goW == 2 && !this.goV;
    }

    public boolean bkt() {
        if (this.isHost) {
            return false;
        }
        if (this.goX == 3) {
            return true;
        }
        return this.goX == 2 && !this.goV;
    }

    protected com.baidu.tieba.person.d cv(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gec = i;
        dVar.bxP = i2;
        return dVar;
    }

    public void bku() {
        this.goV = true;
        this.sex = 1;
        this.goW = 1;
        this.goX = 1;
        this.goY = -1;
        this.mUserData = null;
        if (this.goZ != null) {
            this.goZ.clear();
        }
        this.goZ = null;
        this.gpa = null;
        this.gpb = null;
        this.gpc = null;
        this.gpf = null;
        this.mCardNullPolymericData = null;
        if (this.gpg != null) {
            this.gpg.clear();
        }
        if (this.gpj != null) {
            this.gpj.clear();
        }
        this.gpg = null;
        this.gpj = null;
        this.gph.clear();
        this.gpr = null;
        this.gps = null;
        this.maskType = 0;
        this.gpd = null;
        if (this.gpe != null) {
            this.gpe.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData bkv() {
        return this.gpd;
    }

    public List<AlaLiveInfoCoreData> bkw() {
        return this.gpe;
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> aEn() {
        return this.gph;
    }

    public c bkx() {
        return this.gpa;
    }

    public g bky() {
        return this.gpf;
    }

    public PersonUserGodInfo bkz() {
        return this.gjj;
    }

    private void biK() {
        this.gpi.clear();
        this.gpm = af(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.gpm.drm = new Bundle();
        this.gpm.drm.putBoolean("person_center_item_red_tip", true);
        this.gpm.gpM.drm = new Bundle();
        this.gpm.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(this.gpm);
        this.gpn = af(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.gpn.drm = new Bundle();
        this.gpn.drm.putBoolean("person_center_item_red_tip", true);
        this.gpn.gpM.drm = new Bundle();
        this.gpn.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(this.gpn);
        this.gpk = af(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.gpk.drm = new Bundle();
        this.gpk.drm.putBoolean("person_center_item_red_tip", true);
        this.gpk.gpM.drm = new Bundle();
        this.gpk.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(this.gpk);
        n af = af(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        af.gpM.drm = new Bundle();
        af.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(af);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n af2 = af(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            af2.drm = new Bundle();
            af2.gpM.drm = new Bundle();
            af2.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gpi.add(af2);
        }
        if (this.gpq != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.gpq.getManChannel() == 1) {
                this.gpl = af(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.gpl.drm = new Bundle();
                this.gpl.drm.putBoolean("person_center_item_red_tip", true);
                this.gpl.gpM.drm = new Bundle();
                this.gpl.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gpi.add(this.gpl);
            }
        }
        this.gpo = af(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.gpo.drm = new Bundle();
        this.gpo.drm.putBoolean("person_center_item_red_tip", true);
        this.gpo.gpM.drm = new Bundle();
        this.gpo.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(this.gpo);
        n af3 = af(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        af3.gpM.drm = new Bundle();
        af3.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gjk != null) {
            af3.gpM.drm.putString("book_jump_link", this.gjk.gig);
        }
        this.gpi.add(af3);
        n af4 = af(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        af4.gpM.drm = new Bundle();
        af4.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(af4);
        n af5 = af(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        af5.gpM.drm = new Bundle();
        af5.gpM.drm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gpi.add(af5);
        n af6 = af(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        af6.gpM.drm = new Bundle();
        af6.gpM.drm.putString("key_service_centre", "");
        this.gpi.add(af6);
    }

    private n af(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gpM = new com.baidu.tieba.personCenter.c.a();
        nVar.gpM.drl = i3;
        return nVar;
    }
}
