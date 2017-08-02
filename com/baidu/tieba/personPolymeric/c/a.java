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
    protected boolean bsZ;
    private ArrayList<com.baidu.adp.widget.ListView.f> fiB;
    private c fiC;
    private com.baidu.tieba.person.a.e fiD;
    private m fiE;
    private AlaLiveInfoCoreData fiF;
    private g fiG;
    protected j fiH;
    protected List<com.baidu.adp.widget.ListView.f> fiI;
    private com.baidu.tieba.person.data.b fiL;
    public com.baidu.tieba.personCenter.b.a fiM;
    public com.baidu.tieba.personCenter.b.a fiN;
    public com.baidu.tieba.personCenter.b.a fiO;
    public com.baidu.tieba.personCenter.b.a fiP;
    public com.baidu.tieba.personCenter.b.a fiQ;
    public com.baidu.tieba.personCenter.b.a fiR;
    private UserVideoChannelInfoData fiS;
    private PersonUserGodInfo fiT;
    public UserAgreeInfo fiU;
    public NicknameInfo fiV;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fit = true;
    protected int sex = 1;
    private int fiu = 1;
    private int fiv = 1;
    private int fiw = 1;
    private int fiy = 1;
    private int fiz = -1;
    private int fiA = -1;
    private boolean hasMore = true;
    protected ArrayList<com.baidu.adp.widget.ListView.f> fiJ = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> fiK = new ArrayList<>();

    public abstract void VB();

    public a(boolean z) {
        this.bsZ = z;
    }

    public boolean ayj() {
        return this.fit;
    }

    public void kr(boolean z) {
        this.fit = z;
    }

    public boolean OL() {
        return this.bsZ;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.fiu = fVar.GetUser().priv_sets.like.intValue();
                    this.fiv = fVar.GetUser().priv_sets.post.intValue();
                    this.fiw = fVar.GetUser().priv_sets.group.intValue();
                    this.fiy = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.fit = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.fiS == null) {
                this.fiS = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.fiS.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.fiL = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!u.v(fVar.getConcernedForumList()) && !this.bsZ && !aYp()) {
                cJ(fVar.getConcernedForumList());
            }
            if (this.fiH == null && aYq() && !this.bsZ) {
                this.fiH = new j();
                this.fiH.sex = this.sex;
                this.fiH.fjn = aYq();
            }
            if (!u.v(fVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.fiz != date.getDate();
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
                        this.fiz = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && u.v(this.fiI)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.bsZ = this.bsZ;
                this.hasMore = false;
            }
            if (this.bsZ) {
                aYv();
            }
            if (this.fiT == null) {
                this.fiT = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fiT.parserProtobuf(fVar.getUserGodInfo());
            }
            this.fiU = fVar.getUserAgreeInfo();
            this.fiF = fVar.getLiveInfo();
            this.fiV = fVar.getNicknameInfo();
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aYq() || this.bsZ) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.fiI == null) {
                this.fiI = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.fiA);
            this.fiA = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bJg = true;
            cardPersonDynamicThreadData.bsZ = this.bsZ;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bJf = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.fiI.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!u.v(list)) {
                if (this.fiI == null) {
                    this.fiI = new ArrayList();
                }
                d dVar = new d();
                dVar.bsZ = this.bsZ;
                dVar.bJf = z;
                dVar.sex = this.sex;
                dVar.bIY = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fiX = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fiX = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.fiI.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aYp() || this.bsZ) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.fiI == null) {
                this.fiI = new ArrayList();
            }
            b bVar = new b();
            bVar.bsZ = this.bsZ;
            bVar.sex = this.sex;
            bVar.bJf = z;
            bVar.bIY = al.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fiX = al.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.cTS = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fiY = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.fiI.add(bVar);
            this.fiI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.getInst().getApplicationContext(), d.f.ds1), d.e.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aYg() {
        if (this.fiD == null) {
            return null;
        }
        return this.fiD.getPhotoAlbum();
    }

    private void cJ(List<ForumDynamic> list) {
        this.fiC = new c();
        this.fiC.fja = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fje = forumDynamic.user_thread_count.intValue();
                this.fiC.fja.add(fVar);
            }
        }
    }

    private boolean aYp() {
        if (this.bsZ) {
            return false;
        }
        if (this.fiu == 3) {
            return true;
        }
        return this.fiu == 2 && !this.fit;
    }

    public boolean aYq() {
        if (this.bsZ) {
            return false;
        }
        if (this.fiv == 3) {
            return true;
        }
        return this.fiv == 2 && !this.fit;
    }

    private com.baidu.tieba.person.h bg(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.eZs = i;
        hVar.fcI = i2;
        return hVar;
    }

    public void aYr() {
        this.fit = true;
        this.sex = 1;
        this.fiu = 1;
        this.fiv = 1;
        this.fiw = 1;
        this.fiy = 1;
        this.fiz = -1;
        this.fiA = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.fiB != null) {
            this.fiB.clear();
        }
        this.fiB = null;
        this.fiC = null;
        this.fiD = null;
        this.fiE = null;
        this.fiG = null;
        this.fiH = null;
        this.mCardNullPolymericData = null;
        if (this.fiI != null) {
            this.fiI.clear();
        }
        this.fiI = null;
        this.fiJ.clear();
        this.fiU = null;
        this.fiV = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aYs() {
        return this.fiF;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> aqa() {
        return this.fiJ;
    }

    public c aYt() {
        return this.fiC;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aYu() {
        return this.fiK;
    }

    private void aYv() {
        this.fiK.clear();
        this.fiO = N(d.g.icon_starer_caise_heibai, d.l.mark, 20);
        this.fiO.bZs = new Bundle();
        this.fiO.bZs.putBoolean("person_center_item_red_tip", true);
        this.fiO.fdF.bZs = new Bundle();
        this.fiO.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(this.fiO);
        this.fiP = N(d.g.icon_lover_caise_heibai, d.l.contacts, 24);
        this.fiP.bZs = new Bundle();
        this.fiP.bZs.putBoolean("person_center_item_red_tip", true);
        this.fiP.fdF.bZs = new Bundle();
        this.fiP.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(this.fiP);
        this.fiM = N(d.g.icon_liwu_caise_heibai, d.l.gift, 34);
        this.fiM.bZs = new Bundle();
        this.fiM.bZs.putBoolean("person_center_item_red_tip", true);
        this.fiM.fdF.bZs = new Bundle();
        this.fiM.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(this.fiM);
        com.baidu.tieba.personCenter.b.a N = N(d.g.icon_lishi_caise_heibai, d.l.history, 21);
        N.fdF.bZs = new Bundle();
        N.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(N);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a N2 = N(d.g.icon_zhibou_caise_heibai, d.l.person_center_ala_live, 29);
            N2.bZs = new Bundle();
            N2.fdF.bZs = new Bundle();
            N2.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.fiK.add(N2);
        }
        if (this.fiS != null) {
            TiebaStatic.log(new aj("c11956"));
            if (this.fiS.getManChannel() == 1) {
                this.fiN = N(d.g.icon_weibar_caise_heibai, d.l.weiba, 30);
                this.fiN.bZs = new Bundle();
                this.fiN.bZs.putBoolean("person_center_item_red_tip", true);
                this.fiN.fdF.bZs = new Bundle();
                this.fiN.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.fiK.add(this.fiN);
            }
        }
        com.baidu.tieba.personCenter.b.a N3 = N(d.g.icon_zhuanshi_caise_heibai, d.l.blue_drill, 15);
        N3.fdF.bZs = new Bundle();
        N3.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(N3);
        com.baidu.tieba.personCenter.b.a N4 = N(d.g.icon_bookshoop_caise_heibai, d.l.book_shel, 33);
        N4.fdF.bZs = new Bundle();
        N4.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fiL != null) {
            N4.fdF.bZs.putString("book_jump_link", this.fiL.fdg);
        }
        this.fiK.add(N4);
        com.baidu.tieba.personCenter.b.a N5 = N(d.g.icon_kabao_caise_heibai, d.l.card_box, 35);
        N5.fdF.bZs = new Bundle();
        N5.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(N5);
        com.baidu.tieba.personCenter.b.a N6 = N(d.g.icon_xiaofeijilu_caise_heibai, d.l.consumption_records, 17);
        N6.fdF.bZs = new Bundle();
        N6.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(N6);
        com.baidu.tieba.personCenter.b.a N7 = N(d.g.icon_huishouzhan_caise_heibai, d.l.deleteThread_records, 37);
        N6.fdF.bZs = new Bundle();
        N6.fdF.bZs.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.fiK.add(N7);
    }

    private com.baidu.tieba.personCenter.b.a N(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.getInst().getString(i2);
        aVar.fdF = new com.baidu.tieba.personCenter.c.a();
        aVar.fdF.bZr = i3;
        return aVar;
    }
}
