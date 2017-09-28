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
    private PersonUserGodInfo fat;
    private com.baidu.tieba.person.data.d fau;
    protected g fgA;
    protected j fgB;
    protected k fgC;
    protected List<com.baidu.adp.widget.ListView.f> fgD;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fgG;
    public o fgH;
    public o fgI;
    public o fgJ;
    public o fgK;
    public o fgL;
    public o fgM;
    private UserVideoChannelInfoData fgN;
    public UserAgreeInfo fgO;
    public NicknameInfo fgP;
    private ArrayList<com.baidu.adp.widget.ListView.f> fgv;
    private c fgw;
    private com.baidu.tieba.person.a.f fgx;
    private n fgy;
    private AlaLiveInfoCoreData fgz;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fgo = true;
    protected int sex = 1;
    private int fgp = 1;
    private int fgq = 1;
    private int fgr = 1;
    private int fgs = 1;
    private int fgt = -1;
    private int fgu = -1;
    private boolean hasMore = true;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fgE = new ArrayList<>();
    private ArrayList<o> fgF = new ArrayList<>();

    public abstract void aWX();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean azH() {
        return this.fgo;
    }

    public void ko(boolean z) {
        this.fgo = z;
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
                    this.fgp = cVar.GetUser().priv_sets.like.intValue();
                    this.fgq = cVar.GetUser().priv_sets.post.intValue();
                    this.fgr = cVar.GetUser().priv_sets.group.intValue();
                    this.fgs = cVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fgo = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.fgN == null) {
                this.fgN = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.fgN.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fau = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.u(cVar.getConcernedForumList()) && !this.isHost && !aWY()) {
                cG(cVar.getConcernedForumList());
            }
            if (this.isHost && this.fgq != 1) {
                this.fgC = new k();
            } else {
                this.fgC = null;
            }
            if (this.fgB == null && aWZ() && !this.isHost) {
                this.fgB = new j();
                this.fgB.sex = this.sex;
                this.fgB.fhi = aWZ();
            }
            if (this.fgA == null) {
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
                        boolean z2 = this.fgt != date.getDate();
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
                        this.fgt = date.getDate();
                        z = false;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.u(this.fgD) && v.u(this.fgG)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
                this.hasMore = false;
            }
            if (this.isHost) {
                aVr();
                this.maskType = cVar.getMaskType();
            }
            if (this.fat == null) {
                this.fat = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fat.parserProtobuf(cVar.getUserGodInfo());
            }
            this.fgO = cVar.getUserAgreeInfo();
            this.fgz = cVar.getLiveInfo();
            this.fgP = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.u(user.gift_list)) {
            this.fgA = new g();
            this.fgA.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2) {
        ThreadInfo threadInfo;
        if ((!aWZ() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fgD == null) {
                this.fgD = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fgu);
            this.fgu = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOq = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOo = z;
            cardPersonDynamicThreadData.bOp = z2;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fgD.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!aWZ() || this.isHost) {
            if (this.fgG == null) {
                this.fgG = new ArrayList<>();
            }
            this.fgu = UtilHelper.getRandom(random, 3, this.fgu);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bOq = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bOo = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.fgu);
            this.fgG.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.u(list)) {
                if (this.fgD == null) {
                    this.fgD = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.bOo = z;
                dVar.sex = this.sex;
                dVar.bOh = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fgR = am.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fgR = am.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fgD.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aWY() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fgD == null) {
                this.fgD = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.bOo = z;
            bVar.bOh = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fgR = am.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fgS = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fgT = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fgD.add(bVar);
            this.fgD.add(bz(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aWN() {
        if (this.fgx == null) {
            return null;
        }
        return this.fgx.getPhotoAlbum();
    }

    private void cG(List<ForumDynamic> list) {
        this.fgw = new c();
        this.fgw.fgV = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fgZ = forumDynamic.user_thread_count.intValue();
                this.fgw.fgV.add(fVar);
            }
        }
    }

    private boolean aWY() {
        if (this.isHost) {
            return false;
        }
        if (this.fgp == 3) {
            return true;
        }
        return this.fgp == 2 && !this.fgo;
    }

    public boolean aWZ() {
        if (this.isHost) {
            return false;
        }
        if (this.fgq == 3) {
            return true;
        }
        return this.fgq == 2 && !this.fgo;
    }

    protected com.baidu.tieba.person.d bz(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.eVU = i;
        dVar.aGy = i2;
        return dVar;
    }

    public void aXa() {
        this.fgo = true;
        this.sex = 1;
        this.fgp = 1;
        this.fgq = 1;
        this.fgr = 1;
        this.fgs = 1;
        this.fgt = -1;
        this.fgu = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fgv != null) {
            this.fgv.clear();
        }
        this.fgv = null;
        this.fgw = null;
        this.fgx = null;
        this.fgy = null;
        this.fgA = null;
        this.fgB = null;
        this.mCardNullPolymericData = null;
        if (this.fgD != null) {
            this.fgD.clear();
        }
        if (this.fgG != null) {
            this.fgG.clear();
        }
        this.fgD = null;
        this.fgG = null;
        this.fgE.clear();
        this.fgO = null;
        this.fgP = null;
        this.maskType = 0;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> arr() {
        return this.fgE;
    }

    public c aXb() {
        return this.fgw;
    }

    public g aXc() {
        return this.fgA;
    }

    public PersonUserGodInfo aXd() {
        return this.fat;
    }

    private void aVr() {
        this.fgF.clear();
        this.fgJ = T(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.fgJ.ceV = new Bundle();
        this.fgJ.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgJ.faC.ceV = new Bundle();
        this.fgJ.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(this.fgJ);
        this.fgK = T(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.fgK.ceV = new Bundle();
        this.fgK.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgK.faC.ceV = new Bundle();
        this.fgK.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(this.fgK);
        this.fgH = T(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.fgH.ceV = new Bundle();
        this.fgH.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgH.faC.ceV = new Bundle();
        this.fgH.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(this.fgH);
        o T = T(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        T.faC.ceV = new Bundle();
        T.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(T);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            o T2 = T(d.g.icon_zhibou_caise_heibai, d.l.ala_live, 29);
            T2.ceV = new Bundle();
            T2.faC.ceV = new Bundle();
            T2.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fgF.add(T2);
        }
        if (this.fgN != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.fgN.getManChannel() == 1) {
                this.fgI = T(d.g.icon_weibar_caise_heibai, d.l.frs_channel_tip, 30);
                this.fgI.ceV = new Bundle();
                this.fgI.ceV.putBoolean("person_center_item_red_tip", true);
                this.fgI.faC.ceV = new Bundle();
                this.fgI.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fgF.add(this.fgI);
            }
        }
        this.fgL = T(d.g.icon_vip_heibai, d.l.member_center_item, 16);
        this.fgL.ceV = new Bundle();
        this.fgL.ceV.putBoolean("person_center_item_red_tip", true);
        this.fgL.faC.ceV = new Bundle();
        this.fgL.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(this.fgL);
        o T3 = T(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        T3.faC.ceV = new Bundle();
        T3.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fau != null) {
            T3.faC.ceV.putString("book_jump_link", this.fau.eZx);
        }
        this.fgF.add(T3);
        o T4 = T(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        T4.faC.ceV = new Bundle();
        T4.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(T4);
        o T5 = T(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        T5.faC.ceV = new Bundle();
        T5.faC.ceV.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fgF.add(T5);
        o T6 = T(d.g.icon_fuwu_caise_heibai, d.l.person_service_centre, 41);
        T6.faC.ceV = new Bundle();
        T6.faC.ceV.putString("key_service_centre", "");
        this.fgF.add(T6);
    }

    private o T(int i, int i2, int i3) {
        o oVar = new o();
        oVar.iconId = i;
        oVar.title = TbadkCoreApplication.getInst().getString(i2);
        oVar.faC = new com.baidu.tieba.personCenter.d.a();
        oVar.faC.ceU = i3;
        return oVar;
    }
}
