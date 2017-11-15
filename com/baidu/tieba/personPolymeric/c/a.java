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
/* loaded from: classes.dex */
public abstract class a {
    private PersonUserGodInfo fiR;
    private com.baidu.tieba.person.data.d fiS;
    private ArrayList<com.baidu.adp.widget.ListView.f> fpa;
    private c fpb;
    private com.baidu.tieba.person.a.f fpc;
    private n fpd;
    private AlaLiveInfoCoreData fpe;
    private List<AlaLiveInfoCoreData> fpf;
    protected g fpg;
    protected j fph;
    protected k fpi;
    protected List<com.baidu.adp.widget.ListView.f> fpj;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fpm;
    public o fpn;
    public o fpo;
    public o fpp;
    public o fpq;
    public o fpr;
    public o fpt;
    private UserVideoChannelInfoData fpu;
    public UserAgreeInfo fpv;
    public NicknameInfo fpw;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean foT = true;
    protected int sex = 1;
    private int foU = 1;
    private int foV = 1;
    private int foW = 1;
    private int foX = 1;
    private int foY = -1;
    private int foZ = -1;
    private boolean hasMore = true;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fpk = new ArrayList<>();
    private ArrayList<o> fpl = new ArrayList<>();

    public abstract void bae();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aCb() {
        return this.foT;
    }

    public void kn(boolean z) {
        this.foT = z;
    }

    public boolean isHost() {
        return this.isHost;
    }

    public void a(com.baidu.tieba.person.c cVar) {
        if (cVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(cVar.GetUser());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.foU = cVar.GetUser().priv_sets.like.intValue();
                    this.foV = cVar.GetUser().priv_sets.post.intValue();
                    this.foW = cVar.GetUser().priv_sets.group.intValue();
                    this.foX = cVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.foT = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fpu == null) {
                this.fpu = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fpu.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fiS = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.v(cVar.getConcernedForumList()) && !this.isHost && !baf()) {
                cI(cVar.getConcernedForumList());
            }
            if (this.isHost && this.foV != 1) {
                this.fpi = new k();
            } else {
                this.fpi = null;
            }
            if (this.fph == null && bag() && !this.isHost) {
                this.fph = new j();
                this.fph.sex = this.sex;
                this.fph.fpP = bag();
            }
            if (this.fpg == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.v(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) {
                        a(postInfoList, random);
                    }
                }
            }
            if (!v.v(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z2 = this.foY != date.getDate();
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z2, z);
                                break;
                            case 2:
                                a(dynamicInfo, z2);
                                break;
                            case 3:
                                b(dynamicInfo, z2);
                                break;
                        }
                        this.foY = date.getDate();
                        z = false;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.v(this.fpj) && v.v(this.fpm)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
                this.hasMore = false;
            }
            if (this.isHost) {
                aYx();
                this.maskType = cVar.getMaskType();
            }
            if (this.fiR == null) {
                this.fiR = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fiR.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fpv = cVar.getUserAgreeInfo();
            this.fpe = cVar.getLiveInfo();
            this.fpf = cVar.getLiveReplayInfo();
            this.fpw = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.v(user.gift_list)) {
            this.fpg = new g();
            this.fpg.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2) {
        ThreadInfo threadInfo;
        if ((!bag() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fpj == null) {
                this.fpj = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.foZ);
            this.foZ = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bVW = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bVU = z;
            cardPersonDynamicThreadData.bVV = z2;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fpj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!bag() || this.isHost) {
            if (this.fpm == null) {
                this.fpm = new ArrayList<>();
            }
            this.foZ = UtilHelper.getRandom(random, 3, this.foZ);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bVW = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bVU = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.foZ);
            this.fpm.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.v(list)) {
                if (this.fpj == null) {
                    this.fpj = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.bVU = z;
                dVar.sex = this.sex;
                dVar.bVN = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fpy = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fpy = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fpj.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!baf() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fpj == null) {
                this.fpj = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.bVU = z;
            bVar.bVN = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fpy = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fpz = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fpA = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fpj.add(bVar);
            this.fpj.add(bA(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0080d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aZS() {
        if (this.fpc == null) {
            return null;
        }
        return this.fpc.getPhotoAlbum();
    }

    private void cI(List<ForumDynamic> list) {
        this.fpb = new c();
        this.fpb.fpC = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fpG = forumDynamic.user_thread_count.intValue();
                this.fpb.fpC.add(fVar);
            }
        }
    }

    private boolean baf() {
        if (this.isHost) {
            return false;
        }
        if (this.foU == 3) {
            return true;
        }
        return this.foU == 2 && !this.foT;
    }

    public boolean bag() {
        if (this.isHost) {
            return false;
        }
        if (this.foV == 3) {
            return true;
        }
        return this.foV == 2 && !this.foT;
    }

    protected com.baidu.tieba.person.d bA(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.feq = i;
        dVar.aHd = i2;
        return dVar;
    }

    public void bah() {
        this.foT = true;
        this.sex = 1;
        this.foU = 1;
        this.foV = 1;
        this.foW = 1;
        this.foX = 1;
        this.foY = -1;
        this.foZ = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fpa != null) {
            this.fpa.clear();
        }
        this.fpa = null;
        this.fpb = null;
        this.fpc = null;
        this.fpd = null;
        this.fpg = null;
        this.fph = null;
        this.mCardNullPolymericData = null;
        if (this.fpj != null) {
            this.fpj.clear();
        }
        if (this.fpm != null) {
            this.fpm.clear();
        }
        this.fpj = null;
        this.fpm = null;
        this.fpk.clear();
        this.fpv = null;
        this.fpw = null;
        this.maskType = 0;
        this.fpe = null;
        if (this.fpf != null) {
            this.fpf.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData bai() {
        return this.fpe;
    }

    public List<AlaLiveInfoCoreData> baj() {
        return this.fpf;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> atZ() {
        return this.fpk;
    }

    public c bak() {
        return this.fpb;
    }

    public g bal() {
        return this.fpg;
    }

    public PersonUserGodInfo bam() {
        return this.fiR;
    }

    private void aYx() {
        this.fpl.clear();
        this.fpp = W(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.fpp.cmw = new Bundle();
        this.fpp.cmw.putBoolean("person_center_item_red_tip", true);
        this.fpp.fjc.cmw = new Bundle();
        this.fpp.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(this.fpp);
        this.fpq = W(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.fpq.cmw = new Bundle();
        this.fpq.cmw.putBoolean("person_center_item_red_tip", true);
        this.fpq.fjc.cmw = new Bundle();
        this.fpq.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(this.fpq);
        this.fpn = W(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.fpn.cmw = new Bundle();
        this.fpn.cmw.putBoolean("person_center_item_red_tip", true);
        this.fpn.fjc.cmw = new Bundle();
        this.fpn.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(this.fpn);
        o W = W(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        W.fjc.cmw = new Bundle();
        W.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(W);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            o W2 = W(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            W2.cmw = new Bundle();
            W2.fjc.cmw = new Bundle();
            W2.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fpl.add(W2);
        }
        if (this.fpu != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.fpu.getManChannel() == 1) {
                this.fpo = W(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.fpo.cmw = new Bundle();
                this.fpo.cmw.putBoolean("person_center_item_red_tip", true);
                this.fpo.fjc.cmw = new Bundle();
                this.fpo.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fpl.add(this.fpo);
            }
        }
        this.fpr = W(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.fpr.cmw = new Bundle();
        this.fpr.cmw.putBoolean("person_center_item_red_tip", true);
        this.fpr.fjc.cmw = new Bundle();
        this.fpr.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(this.fpr);
        o W3 = W(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        W3.fjc.cmw = new Bundle();
        W3.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fiS != null) {
            W3.fjc.cmw.putString("book_jump_link", this.fiS.fhW);
        }
        this.fpl.add(W3);
        o W4 = W(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        W4.fjc.cmw = new Bundle();
        W4.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(W4);
        o W5 = W(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        W5.fjc.cmw = new Bundle();
        W5.fjc.cmw.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fpl.add(W5);
        o W6 = W(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        W6.fjc.cmw = new Bundle();
        W6.fjc.cmw.putString("key_service_centre", "");
        this.fpl.add(W6);
    }

    private o W(int i, int i2, int i3) {
        o oVar = new o();
        oVar.iconId = i;
        oVar.title = TbadkCoreApplication.getInst().getString(i2);
        oVar.fjc = new com.baidu.tieba.personCenter.c.a();
        oVar.fjc.cmv = i3;
        return oVar;
    }
}
