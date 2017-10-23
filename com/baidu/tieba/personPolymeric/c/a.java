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
    private PersonUserGodInfo fae;
    private com.baidu.tieba.person.data.d faf;
    public NicknameInfo fgA;
    private ArrayList<com.baidu.adp.widget.ListView.f> fgg;
    private c fgh;
    private com.baidu.tieba.person.a.f fgi;
    private n fgj;
    private AlaLiveInfoCoreData fgk;
    protected g fgl;
    protected j fgm;
    protected k fgn;
    protected List<com.baidu.adp.widget.ListView.f> fgo;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fgr;
    public o fgs;
    public o fgt;
    public o fgu;
    public o fgv;
    public o fgw;
    public o fgx;
    private UserVideoChannelInfoData fgy;
    public UserAgreeInfo fgz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean ffZ = true;
    protected int sex = 1;
    private int fga = 1;
    private int fgb = 1;
    private int fgc = 1;
    private int fgd = 1;
    private int fge = -1;
    private int fgf = -1;
    private boolean hasMore = true;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fgp = new ArrayList<>();
    private ArrayList<o> fgq = new ArrayList<>();

    public abstract void aWR();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean azC() {
        return this.ffZ;
    }

    public void kn(boolean z) {
        this.ffZ = z;
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
                    this.fga = cVar.GetUser().priv_sets.like.intValue();
                    this.fgb = cVar.GetUser().priv_sets.post.intValue();
                    this.fgc = cVar.GetUser().priv_sets.group.intValue();
                    this.fgd = cVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.ffZ = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fgy == null) {
                this.fgy = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fgy.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.faf = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.u(cVar.getConcernedForumList()) && !this.isHost && !aWS()) {
                cG(cVar.getConcernedForumList());
            }
            if (this.isHost && this.fgb != 1) {
                this.fgn = new k();
            } else {
                this.fgn = null;
            }
            if (this.fgm == null && aWT() && !this.isHost) {
                this.fgm = new j();
                this.fgm.sex = this.sex;
                this.fgm.fgT = aWT();
            }
            if (this.fgl == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.u(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) {
                        a(postInfoList, random);
                    }
                }
            }
            if (!v.u(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z2 = this.fge != date.getDate();
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
                        this.fge = date.getDate();
                        z = false;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.u(this.fgo) && v.u(this.fgr)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
                this.hasMore = false;
            }
            if (this.isHost) {
                aVm();
                this.maskType = cVar.getMaskType();
            }
            if (this.fae == null) {
                this.fae = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fae.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fgz = cVar.getUserAgreeInfo();
            this.fgk = cVar.getLiveInfo();
            this.fgA = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.u(user.gift_list)) {
            this.fgl = new g();
            this.fgl.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2) {
        ThreadInfo threadInfo;
        if ((!aWT() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fgo == null) {
                this.fgo = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fgf);
            this.fgf = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOe = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOc = z;
            cardPersonDynamicThreadData.bOd = z2;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fgo.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!aWT() || this.isHost) {
            if (this.fgr == null) {
                this.fgr = new ArrayList<>();
            }
            this.fgf = UtilHelper.getRandom(random, 3, this.fgf);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOe = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOc = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fgf);
            this.fgr.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.u(list)) {
                if (this.fgo == null) {
                    this.fgo = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.bOc = z;
                dVar.sex = this.sex;
                dVar.bNV = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fgC = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fgC = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fgo.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aWS() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fgo == null) {
                this.fgo = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.bOc = z;
            bVar.bNV = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fgC = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fgD = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fgE = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fgo.add(bVar);
            this.fgo.add(bz(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aWH() {
        if (this.fgi == null) {
            return null;
        }
        return this.fgi.getPhotoAlbum();
    }

    private void cG(List<ForumDynamic> list) {
        this.fgh = new c();
        this.fgh.fgG = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fgK = forumDynamic.user_thread_count.intValue();
                this.fgh.fgG.add(fVar);
            }
        }
    }

    private boolean aWS() {
        if (this.isHost) {
            return false;
        }
        if (this.fga == 3) {
            return true;
        }
        return this.fga == 2 && !this.ffZ;
    }

    public boolean aWT() {
        if (this.isHost) {
            return false;
        }
        if (this.fgb == 3) {
            return true;
        }
        return this.fgb == 2 && !this.ffZ;
    }

    protected com.baidu.tieba.person.d bz(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.eVG = i;
        dVar.aGl = i2;
        return dVar;
    }

    public void aWU() {
        this.ffZ = true;
        this.sex = 1;
        this.fga = 1;
        this.fgb = 1;
        this.fgc = 1;
        this.fgd = 1;
        this.fge = -1;
        this.fgf = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fgg != null) {
            this.fgg.clear();
        }
        this.fgg = null;
        this.fgh = null;
        this.fgi = null;
        this.fgj = null;
        this.fgl = null;
        this.fgm = null;
        this.mCardNullPolymericData = null;
        if (this.fgo != null) {
            this.fgo.clear();
        }
        if (this.fgr != null) {
            this.fgr.clear();
        }
        this.fgo = null;
        this.fgr = null;
        this.fgp.clear();
        this.fgz = null;
        this.fgA = null;
        this.maskType = 0;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> arm() {
        return this.fgp;
    }

    public c aWV() {
        return this.fgh;
    }

    public g aWW() {
        return this.fgl;
    }

    public PersonUserGodInfo aWX() {
        return this.fae;
    }

    private void aVm() {
        this.fgq.clear();
        this.fgu = T(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.fgu.ceJ = new Bundle();
        this.fgu.ceJ.putBoolean("person_center_item_red_tip", true);
        this.fgu.fan.ceJ = new Bundle();
        this.fgu.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(this.fgu);
        this.fgv = T(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.fgv.ceJ = new Bundle();
        this.fgv.ceJ.putBoolean("person_center_item_red_tip", true);
        this.fgv.fan.ceJ = new Bundle();
        this.fgv.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(this.fgv);
        this.fgs = T(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.fgs.ceJ = new Bundle();
        this.fgs.ceJ.putBoolean("person_center_item_red_tip", true);
        this.fgs.fan.ceJ = new Bundle();
        this.fgs.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(this.fgs);
        o T = T(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        T.fan.ceJ = new Bundle();
        T.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            o T2 = T(d.g.icon_zhibou_caise_heibai, d.l.ala_live, 29);
            T2.ceJ = new Bundle();
            T2.fan.ceJ = new Bundle();
            T2.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fgq.add(T2);
        }
        if (this.fgy != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.fgy.getManChannel() == 1) {
                this.fgt = T(d.g.icon_weibar_caise_heibai, d.l.frs_channel_tip, 30);
                this.fgt.ceJ = new Bundle();
                this.fgt.ceJ.putBoolean("person_center_item_red_tip", true);
                this.fgt.fan.ceJ = new Bundle();
                this.fgt.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fgq.add(this.fgt);
            }
        }
        this.fgw = T(d.g.icon_vip_heibai, d.l.member_center_item, 16);
        this.fgw.ceJ = new Bundle();
        this.fgw.ceJ.putBoolean("person_center_item_red_tip", true);
        this.fgw.fan.ceJ = new Bundle();
        this.fgw.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(this.fgw);
        o T3 = T(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        T3.fan.ceJ = new Bundle();
        T3.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.faf != null) {
            T3.fan.ceJ.putString("book_jump_link", this.faf.eZj);
        }
        this.fgq.add(T3);
        o T4 = T(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        T4.fan.ceJ = new Bundle();
        T4.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(T4);
        o T5 = T(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        T5.fan.ceJ = new Bundle();
        T5.fan.ceJ.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgq.add(T5);
        o T6 = T(d.g.icon_fuwu_caise_heibai, d.l.person_service_centre, 41);
        T6.fan.ceJ = new Bundle();
        T6.fan.ceJ.putString("key_service_centre", "");
        this.fgq.add(T6);
    }

    private o T(int i, int i2, int i3) {
        o oVar = new o();
        oVar.iconId = i;
        oVar.title = TbadkCoreApplication.getInst().getString(i2);
        oVar.fan = new com.baidu.tieba.personCenter.d.a();
        oVar.fan.ceI = i3;
        return oVar;
    }
}
