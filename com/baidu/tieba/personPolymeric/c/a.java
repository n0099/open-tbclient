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
    private PersonUserGodInfo fas;
    private com.baidu.tieba.person.data.d fat;
    protected j fgA;
    protected k fgB;
    protected List<com.baidu.adp.widget.ListView.f> fgC;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fgF;
    public o fgG;
    public o fgH;
    public o fgI;
    public o fgJ;
    public o fgK;
    public o fgL;
    private UserVideoChannelInfoData fgM;
    public UserAgreeInfo fgN;
    public NicknameInfo fgO;
    private ArrayList<com.baidu.adp.widget.ListView.f> fgu;
    private c fgv;
    private com.baidu.tieba.person.a.f fgw;
    private n fgx;
    private AlaLiveInfoCoreData fgy;
    protected g fgz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fgn = true;
    protected int sex = 1;
    private int fgo = 1;
    private int fgp = 1;
    private int fgq = 1;
    private int fgr = 1;
    private int fgs = -1;
    private int fgt = -1;
    private boolean hasMore = true;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fgD = new ArrayList<>();
    private ArrayList<o> fgE = new ArrayList<>();

    public abstract void aWW();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean azH() {
        return this.fgn;
    }

    public void ko(boolean z) {
        this.fgn = z;
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
                    this.fgo = cVar.GetUser().priv_sets.like.intValue();
                    this.fgp = cVar.GetUser().priv_sets.post.intValue();
                    this.fgq = cVar.GetUser().priv_sets.group.intValue();
                    this.fgr = cVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fgn = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fgM == null) {
                this.fgM = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fgM.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fat = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.u(cVar.getConcernedForumList()) && !this.isHost && !aWX()) {
                cG(cVar.getConcernedForumList());
            }
            if (this.isHost && this.fgp != 1) {
                this.fgB = new k();
            } else {
                this.fgB = null;
            }
            if (this.fgA == null && aWY() && !this.isHost) {
                this.fgA = new j();
                this.fgA.sex = this.sex;
                this.fgA.fhh = aWY();
            }
            if (this.fgz == null) {
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
                        boolean z2 = this.fgs != date.getDate();
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
                        this.fgs = date.getDate();
                        z = false;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.u(this.fgC) && v.u(this.fgF)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
                this.hasMore = false;
            }
            if (this.isHost) {
                aVr();
                this.maskType = cVar.getMaskType();
            }
            if (this.fas == null) {
                this.fas = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fas.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fgN = cVar.getUserAgreeInfo();
            this.fgy = cVar.getLiveInfo();
            this.fgO = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.u(user.gift_list)) {
            this.fgz = new g();
            this.fgz.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2) {
        ThreadInfo threadInfo;
        if ((!aWY() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fgC == null) {
                this.fgC = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fgt);
            this.fgt = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOq = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOo = z;
            cardPersonDynamicThreadData.bOp = z2;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fgC.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!aWY() || this.isHost) {
            if (this.fgF == null) {
                this.fgF = new ArrayList<>();
            }
            this.fgt = UtilHelper.getRandom(random, 3, this.fgt);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOq = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOo = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fgt);
            this.fgF.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.u(list)) {
                if (this.fgC == null) {
                    this.fgC = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.bOo = z;
                dVar.sex = this.sex;
                dVar.bOh = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fgQ = am.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fgQ = am.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fgC.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aWX() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fgC == null) {
                this.fgC = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.bOo = z;
            bVar.bOh = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fgQ = am.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fgR = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fgS = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fgC.add(bVar);
            this.fgC.add(bz(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aWM() {
        if (this.fgw == null) {
            return null;
        }
        return this.fgw.getPhotoAlbum();
    }

    private void cG(List<ForumDynamic> list) {
        this.fgv = new c();
        this.fgv.fgU = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fgY = forumDynamic.user_thread_count.intValue();
                this.fgv.fgU.add(fVar);
            }
        }
    }

    private boolean aWX() {
        if (this.isHost) {
            return false;
        }
        if (this.fgo == 3) {
            return true;
        }
        return this.fgo == 2 && !this.fgn;
    }

    public boolean aWY() {
        if (this.isHost) {
            return false;
        }
        if (this.fgp == 3) {
            return true;
        }
        return this.fgp == 2 && !this.fgn;
    }

    protected com.baidu.tieba.person.d bz(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.eVU = i;
        dVar.aGy = i2;
        return dVar;
    }

    public void aWZ() {
        this.fgn = true;
        this.sex = 1;
        this.fgo = 1;
        this.fgp = 1;
        this.fgq = 1;
        this.fgr = 1;
        this.fgs = -1;
        this.fgt = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fgu != null) {
            this.fgu.clear();
        }
        this.fgu = null;
        this.fgv = null;
        this.fgw = null;
        this.fgx = null;
        this.fgz = null;
        this.fgA = null;
        this.mCardNullPolymericData = null;
        if (this.fgC != null) {
            this.fgC.clear();
        }
        if (this.fgF != null) {
            this.fgF.clear();
        }
        this.fgC = null;
        this.fgF = null;
        this.fgD.clear();
        this.fgN = null;
        this.fgO = null;
        this.maskType = 0;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> arr() {
        return this.fgD;
    }

    public c aXa() {
        return this.fgv;
    }

    public g aXb() {
        return this.fgz;
    }

    public PersonUserGodInfo aXc() {
        return this.fas;
    }

    private void aVr() {
        this.fgE.clear();
        this.fgI = T(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.fgI.ceV = new Bundle();
        this.fgI.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgI.faB.ceV = new Bundle();
        this.fgI.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(this.fgI);
        this.fgJ = T(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.fgJ.ceV = new Bundle();
        this.fgJ.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgJ.faB.ceV = new Bundle();
        this.fgJ.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(this.fgJ);
        this.fgG = T(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.fgG.ceV = new Bundle();
        this.fgG.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgG.faB.ceV = new Bundle();
        this.fgG.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(this.fgG);
        o T = T(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        T.faB.ceV = new Bundle();
        T.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            o T2 = T(d.g.icon_zhibou_caise_heibai, d.l.ala_live, 29);
            T2.ceV = new Bundle();
            T2.faB.ceV = new Bundle();
            T2.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fgE.add(T2);
        }
        if (this.fgM != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.fgM.getManChannel() == 1) {
                this.fgH = T(d.g.icon_weibar_caise_heibai, d.l.frs_channel_tip, 30);
                this.fgH.ceV = new Bundle();
                this.fgH.ceV.putBoolean("person_center_item_red_tip", true);
                this.fgH.faB.ceV = new Bundle();
                this.fgH.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fgE.add(this.fgH);
            }
        }
        this.fgK = T(d.g.icon_vip_heibai, d.l.member_center_item, 16);
        this.fgK.ceV = new Bundle();
        this.fgK.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgK.faB.ceV = new Bundle();
        this.fgK.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(this.fgK);
        o T3 = T(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        T3.faB.ceV = new Bundle();
        T3.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fat != null) {
            T3.faB.ceV.putString("book_jump_link", this.fat.eZx);
        }
        this.fgE.add(T3);
        o T4 = T(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        T4.faB.ceV = new Bundle();
        T4.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(T4);
        o T5 = T(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        T5.faB.ceV = new Bundle();
        T5.faB.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgE.add(T5);
        o T6 = T(d.g.icon_fuwu_caise_heibai, d.l.person_service_centre, 41);
        T6.faB.ceV = new Bundle();
        T6.faB.ceV.putString("key_service_centre", "");
        this.fgE.add(T6);
    }

    private o T(int i, int i2, int i3) {
        o oVar = new o();
        oVar.iconId = i;
        oVar.title = TbadkCoreApplication.getInst().getString(i2);
        oVar.faB = new com.baidu.tieba.personCenter.d.a();
        oVar.faB.ceU = i3;
        return oVar;
    }
}
