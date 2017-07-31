package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.d;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.Profile.NicknameInfo;
import tbclient.Profile.UserAgreeInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes.dex */
public abstract class a {
    protected boolean buk;
    private ArrayList<com.baidu.adp.widget.ListView.f> fjN;
    private c fjO;
    private com.baidu.tieba.person.a.e fjP;
    private m fjQ;
    private AlaLiveInfoCoreData fjR;
    private g fjS;
    protected j fjT;
    protected List<com.baidu.adp.widget.ListView.f> fjU;
    private com.baidu.tieba.person.data.b fjX;
    public com.baidu.tieba.personCenter.b.a fjY;
    public com.baidu.tieba.personCenter.b.a fjZ;
    public com.baidu.tieba.personCenter.b.a fka;
    public com.baidu.tieba.personCenter.b.a fkb;
    public com.baidu.tieba.personCenter.b.a fkc;
    public com.baidu.tieba.personCenter.b.a fkd;
    private UserVideoChannelInfoData fke;
    private PersonUserGodInfo fkf;
    public UserAgreeInfo fkg;
    public NicknameInfo fkh;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fjG = true;
    protected int sex = 1;
    private int fjH = 1;
    private int fjI = 1;
    private int fjJ = 1;
    private int fjK = 1;
    private int fjL = -1;
    private int fjM = -1;
    private boolean hasMore = true;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fjV = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> fjW = new ArrayList<>();

    public abstract void VG();

    public a(boolean z) {
        this.buk = z;
    }

    public boolean ayu() {
        return this.fjG;
    }

    public void kr(boolean z) {
        this.fjG = z;
    }

    public boolean OQ() {
        return this.buk;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.fjH = fVar.GetUser().priv_sets.like.intValue();
                    this.fjI = fVar.GetUser().priv_sets.post.intValue();
                    this.fjJ = fVar.GetUser().priv_sets.group.intValue();
                    this.fjK = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.fjG = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.fke == null) {
                this.fke = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.fke.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.fjX = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!u.v(fVar.getConcernedForumList()) && !this.buk && !aYA()) {
                cJ(fVar.getConcernedForumList());
            }
            if (this.fjT == null && aYB() && !this.buk) {
                this.fjT = new j();
                this.fjT.sex = this.sex;
                this.fjT.fkz = aYB();
            }
            if (!u.v(fVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.fjL != date.getDate();
                        switch (dynamicInfo.type.intValue()) {
                            case 1:
                                a(dynamicInfo, random, z);
                                break;
                            case 2:
                                a(dynamicInfo, z);
                                break;
                            case 3:
                                b(dynamicInfo, z);
                                break;
                        }
                        this.fjL = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && u.v(this.fjU)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.buk = this.buk;
                this.hasMore = false;
            }
            if (this.buk) {
                aYG();
            }
            if (this.fkf == null) {
                this.fkf = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fkf.parserProtobuf(fVar.getUserGodInfo());
            }
            this.fkg = fVar.getUserAgreeInfo();
            this.fjR = fVar.getLiveInfo();
            this.fkh = fVar.getNicknameInfo();
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aYB() || this.buk) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fjU == null) {
                this.fjU = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fjM);
            this.fjM = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bKq = true;
            cardPersonDynamicThreadData.buk = this.buk;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bKp = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fjU.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!u.v(list)) {
                if (this.fjU == null) {
                    this.fjU = new ArrayList();
                }
                d dVar = new d();
                dVar.buk = this.buk;
                dVar.bKp = z;
                dVar.sex = this.sex;
                dVar.bKi = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fkj = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fkj = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fjU.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aYA() || this.buk) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fjU == null) {
                this.fjU = new ArrayList();
            }
            b bVar = new b();
            bVar.buk = this.buk;
            bVar.sex = this.sex;
            bVar.bKp = z;
            bVar.bKi = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fkj = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.cVl = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fkk = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fjU.add(bVar);
            this.fjU.add(bh(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aYr() {
        if (this.fjP == null) {
            return null;
        }
        return this.fjP.getPhotoAlbum();
    }

    private void cJ(List<ForumDynamic> list) {
        this.fjO = new c();
        this.fjO.fkm = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fkq = forumDynamic.user_thread_count.intValue();
                this.fjO.fkm.add(fVar);
            }
        }
    }

    private boolean aYA() {
        if (this.buk) {
            return false;
        }
        if (this.fjH == 3) {
            return true;
        }
        return this.fjH == 2 && !this.fjG;
    }

    public boolean aYB() {
        if (this.buk) {
            return false;
        }
        if (this.fjI == 3) {
            return true;
        }
        return this.fjI == 2 && !this.fjG;
    }

    private com.baidu.tieba.person.h bh(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.faE = i;
        hVar.fdU = i2;
        return hVar;
    }

    public void aYC() {
        this.fjG = true;
        this.sex = 1;
        this.fjH = 1;
        this.fjI = 1;
        this.fjJ = 1;
        this.fjK = 1;
        this.fjL = -1;
        this.fjM = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fjN != null) {
            this.fjN.clear();
        }
        this.fjN = null;
        this.fjO = null;
        this.fjP = null;
        this.fjQ = null;
        this.fjS = null;
        this.fjT = null;
        this.mCardNullPolymericData = null;
        if (this.fjU != null) {
            this.fjU.clear();
        }
        this.fjU = null;
        this.fjV.clear();
        this.fkg = null;
        this.fkh = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aYD() {
        return this.fjR;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aqm() {
        return this.fjV;
    }

    public c aYE() {
        return this.fjO;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aYF() {
        return this.fjW;
    }

    private void aYG() {
        this.fjW.clear();
        this.fka = N(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.fka.cay = new Bundle();
        this.fka.cay.putBoolean("person_center_item_red_tip", true);
        this.fka.feR.cay = new Bundle();
        this.fka.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(this.fka);
        this.fkb = N(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.fkb.cay = new Bundle();
        this.fkb.cay.putBoolean("person_center_item_red_tip", true);
        this.fkb.feR.cay = new Bundle();
        this.fkb.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(this.fkb);
        this.fjY = N(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.fjY.cay = new Bundle();
        this.fjY.cay.putBoolean("person_center_item_red_tip", true);
        this.fjY.feR.cay = new Bundle();
        this.fjY.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(this.fjY);
        com.baidu.tieba.personCenter.b.a N = N(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        N.feR.cay = new Bundle();
        N.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(N);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a N2 = N(d.g.icon_zhibou_caise_heibai, d.l.person_center_ala_live, 29);
            N2.cay = new Bundle();
            N2.feR.cay = new Bundle();
            N2.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fjW.add(N2);
        }
        if (this.fke != null) {
            TiebaStatic.log(new aj("c11956"));
            if (this.fke.getManChannel() == 1) {
                this.fjZ = N(d.g.icon_weibar_caise_heibai, d.l.weiba, 30);
                this.fjZ.cay = new Bundle();
                this.fjZ.cay.putBoolean("person_center_item_red_tip", true);
                this.fjZ.feR.cay = new Bundle();
                this.fjZ.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fjW.add(this.fjZ);
            }
        }
        com.baidu.tieba.personCenter.b.a N3 = N(d.g.icon_zhuanshi_caise_heibai, d.l.blue_drill, 15);
        N3.feR.cay = new Bundle();
        N3.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(N3);
        com.baidu.tieba.personCenter.b.a N4 = N(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        N4.feR.cay = new Bundle();
        N4.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fjX != null) {
            N4.feR.cay.putString("book_jump_link", this.fjX.fes);
        }
        this.fjW.add(N4);
        com.baidu.tieba.personCenter.b.a N5 = N(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        N5.feR.cay = new Bundle();
        N5.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(N5);
        com.baidu.tieba.personCenter.b.a N6 = N(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        N6.feR.cay = new Bundle();
        N6.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(N6);
        com.baidu.tieba.personCenter.b.a N7 = N(d.g.icon_huishouzhan_caise_heibai, d.l.deleteThread_records, 37);
        N6.feR.cay = new Bundle();
        N6.feR.cay.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fjW.add(N7);
    }

    private com.baidu.tieba.personCenter.b.a N(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.getInst().getString(i2);
        aVar.feR = new com.baidu.tieba.personCenter.c.a();
        aVar.feR.cax = i3;
        return aVar;
    }
}
