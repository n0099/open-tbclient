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
    private AntiData aKm;
    private PersonUserGodInfo gkS;
    private com.baidu.tieba.person.data.d gkT;
    private ArrayList<com.baidu.adp.widget.ListView.h> gqP;
    private c gqQ;
    private com.baidu.tieba.person.a.f gqR;
    private m gqS;
    private AlaLiveInfoCoreData gqT;
    private List<AlaLiveInfoCoreData> gqU;
    protected g gqV;
    protected List<com.baidu.adp.widget.ListView.h> gqW;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gqZ;
    public n gra;
    public n grb;
    public n grc;
    public n grd;
    public n gre;
    public n grf;
    private UserVideoChannelInfoData grg;
    public UserAgreeInfo grh;
    public NicknameInfo gri;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gqL = true;
    protected int sex = 1;
    private int gqM = 1;
    private int gqN = 1;
    private int gqO = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gqX = new ArrayList<>();
    private ArrayList<n> gqY = new ArrayList<>();

    public abstract void boy();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aST() {
        return this.gqL;
    }

    public void mj(boolean z) {
        this.gqL = z;
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
            if (this.aKm == null) {
                this.aKm = new AntiData();
            }
            this.aKm.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gqM = cVar.GetUser().priv_sets.like.intValue();
                    this.gqN = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gqL = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.grg == null) {
                this.grg = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.grg.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gkT = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.I(cVar.getConcernedForumList()) && !this.isHost && !boz()) {
                dr(cVar.getConcernedForumList());
            }
            if (this.gqV == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.I(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String Y = ao.Y(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.I(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String Y2 = ao.Y(longValue);
                        String ab = ao.ab(longValue);
                        String aa = ao.aa(longValue);
                        if (ao.equals(Y2, Y)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(aa, str3) && ao.equals(ab, str2) && ao.equals(Y2, Y)) {
                            z2 = false;
                            aa = str3;
                            str = Y;
                        } else {
                            z2 = true;
                            str2 = ab;
                            str = Y2;
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
                        str3 = aa;
                        Y = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.I(this.gqW) && v.I(this.gqZ)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bmP();
                this.maskType = cVar.getMaskType();
            }
            if (this.gkS == null) {
                this.gkS = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gkS.parserProtobuf(cVar.getUserGodInfo());
            }
            this.grh = cVar.getUserAgreeInfo();
            this.gqT = cVar.getLiveInfo();
            this.gqU = cVar.getLiveReplayInfo();
            this.gri = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.I(user.gift_list)) {
            this.gqV = new g();
            this.gqV.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!boA() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gqW == null) {
                this.gqW = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gqO);
            this.gqO = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cSf = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cSd = z;
            cardPersonDynamicThreadData.cSc = z2;
            cardPersonDynamicThreadData.cSe = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gqW.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!boA() || this.isHost) {
            if (this.gqZ == null) {
                this.gqZ = new ArrayList<>();
            }
            this.gqO = UtilHelper.getRandom(random, 3, this.gqO);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.cSf = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.cSd = false;
            cardPersonDynamicThreadData.cSc = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gqO);
            this.gqZ.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.I(list)) {
                if (this.gqW == null) {
                    this.gqW = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.cSc = z;
                dVar.sex = this.sex;
                dVar.cRV = ao.ab(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cRW = ao.aa(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.cRW = ao.aa(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gqW.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!boz() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gqW == null) {
                this.gqW = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.cSc = z;
            bVar.cRV = ao.ab(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.cRW = ao.aa(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.grk = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.grl = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gqW.add(bVar);
            this.gqW.add(bD(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0200e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> bop() {
        if (this.gqR == null) {
            return null;
        }
        return this.gqR.getPhotoAlbum();
    }

    private void dr(List<ForumDynamic> list) {
        this.gqQ = new c();
        this.gqQ.grn = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.grr = forumDynamic.user_thread_count.intValue();
                this.gqQ.grn.add(fVar);
            }
        }
    }

    private boolean boz() {
        if (this.isHost) {
            return false;
        }
        if (this.gqM == 3) {
            return true;
        }
        return this.gqM == 2 && !this.gqL;
    }

    public boolean boA() {
        if (this.isHost) {
            return false;
        }
        if (this.gqN == 3) {
            return true;
        }
        return this.gqN == 2 && !this.gqL;
    }

    protected com.baidu.tieba.person.d bD(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gfy = i;
        dVar.ban = i2;
        return dVar;
    }

    public void boB() {
        this.gqL = true;
        this.sex = 1;
        this.gqM = 1;
        this.gqN = 1;
        this.gqO = -1;
        this.mUserData = null;
        if (this.gqP != null) {
            this.gqP.clear();
        }
        this.gqP = null;
        this.gqQ = null;
        this.gqR = null;
        this.gqS = null;
        this.gqV = null;
        this.mCardNullPolymericData = null;
        if (this.gqW != null) {
            this.gqW.clear();
        }
        if (this.gqZ != null) {
            this.gqZ.clear();
        }
        this.gqW = null;
        this.gqZ = null;
        this.gqX.clear();
        this.grh = null;
        this.gri = null;
        this.maskType = 0;
        this.gqT = null;
        if (this.gqU != null) {
            this.gqU.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData ayn() {
        return this.aKm;
    }

    public AlaLiveInfoCoreData boC() {
        return this.gqT;
    }

    public List<AlaLiveInfoCoreData> boD() {
        return this.gqU;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aKS() {
        return this.gqX;
    }

    public c boE() {
        return this.gqQ;
    }

    public g boF() {
        return this.gqV;
    }

    public PersonUserGodInfo boG() {
        return this.gkS;
    }

    private void bmP() {
        this.gqY.clear();
        this.grc = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.grc.dkm = new Bundle();
        this.grc.dkm.putBoolean("person_center_item_red_tip", true);
        this.grc.grC.dkm = new Bundle();
        this.grc.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(this.grc);
        this.grd = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.grd.dkm = new Bundle();
        this.grd.dkm.putBoolean("person_center_item_red_tip", true);
        this.grd.grC.dkm = new Bundle();
        this.grd.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(this.grd);
        this.gra = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gra.dkm = new Bundle();
        this.gra.dkm.putBoolean("person_center_item_red_tip", true);
        this.gra.grC.dkm = new Bundle();
        this.gra.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(this.gra);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.grC.dkm = new Bundle();
        X.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.dkm = new Bundle();
            X2.grC.dkm = new Bundle();
            X2.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gqY.add(X2);
        }
        if (this.grg != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.grg.getManChannel() == 1) {
                this.grb = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.grb.dkm = new Bundle();
                this.grb.dkm.putBoolean("person_center_item_red_tip", true);
                this.grb.grC.dkm = new Bundle();
                this.grb.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gqY.add(this.grb);
            }
        }
        this.gre = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gre.dkm = new Bundle();
        this.gre.dkm.putBoolean("person_center_item_red_tip", true);
        this.gre.grC.dkm = new Bundle();
        this.gre.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(this.gre);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.grC.dkm = new Bundle();
        X3.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gkT != null) {
            X3.grC.dkm.putString("book_jump_link", this.gkT.gjM);
        }
        this.gqY.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.grC.dkm = new Bundle();
        X4.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.grC.dkm = new Bundle();
        X5.grC.dkm.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gqY.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.grC.dkm = new Bundle();
        X6.grC.dkm.putString("key_service_centre", "");
        this.gqY.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.grC = new com.baidu.tieba.personCenter.c.a();
        nVar.grC.dkl = i3;
        return nVar;
    }
}
