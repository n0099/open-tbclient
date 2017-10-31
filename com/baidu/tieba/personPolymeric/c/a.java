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
    private PersonUserGodInfo fiu;
    private com.baidu.tieba.person.data.d fiv;
    private ArrayList<com.baidu.adp.widget.ListView.f> foD;
    private c foE;
    private com.baidu.tieba.person.a.f foF;
    private n foG;
    private AlaLiveInfoCoreData foH;
    private List<AlaLiveInfoCoreData> foI;
    protected g foJ;
    protected j foK;
    protected k foL;
    protected List<com.baidu.adp.widget.ListView.f> foM;
    protected ArrayList<com.baidu.adp.widget.ListView.f> foP;
    public o foQ;
    public o foR;
    public o foS;
    public o foT;
    public o foU;
    public o foV;
    private UserVideoChannelInfoData foW;
    public UserAgreeInfo foX;
    public NicknameInfo foY;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean fow = true;
    protected int sex = 1;
    private int fox = 1;
    private int foy = 1;
    private int foz = 1;
    private int foA = 1;
    private int foB = -1;
    private int foC = -1;
    private boolean hasMore = true;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.f> foN = new ArrayList<>();
    private ArrayList<o> foO = new ArrayList<>();

    public abstract void aZW();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aBX() {
        return this.fow;
    }

    public void kh(boolean z) {
        this.fow = z;
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
                    this.fox = cVar.GetUser().priv_sets.like.intValue();
                    this.foy = cVar.GetUser().priv_sets.post.intValue();
                    this.foz = cVar.GetUser().priv_sets.group.intValue();
                    this.foA = cVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.fow = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.foW == null) {
                this.foW = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.foW.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.fiv = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.v(cVar.getConcernedForumList()) && !this.isHost && !aZX()) {
                cH(cVar.getConcernedForumList());
            }
            if (this.isHost && this.foy != 1) {
                this.foL = new k();
            } else {
                this.foL = null;
            }
            if (this.foK == null && aZY() && !this.isHost) {
                this.foK = new j();
                this.foK.sex = this.sex;
                this.foK.fpr = aZY();
            }
            if (this.foJ == null) {
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
                        boolean z2 = this.foB != date.getDate();
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
                        this.foB = date.getDate();
                        z = false;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.v(this.foM) && v.v(this.foP)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
                this.hasMore = false;
            }
            if (this.isHost) {
                aYp();
                this.maskType = cVar.getMaskType();
            }
            if (this.fiu == null) {
                this.fiu = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.fiu.parserProtobuf(cVar.getUserGodInfo());
            }
            this.foX = cVar.getUserAgreeInfo();
            this.foH = cVar.getLiveInfo();
            this.foI = cVar.getLiveReplayInfo();
            this.foY = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.v(user.gift_list)) {
            this.foJ = new g();
            this.foJ.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2) {
        ThreadInfo threadInfo;
        if ((!aZY() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.foM == null) {
                this.foM = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.foC);
            this.foC = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bVJ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bVH = z;
            cardPersonDynamicThreadData.bVI = z2;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.foM.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!aZY() || this.isHost) {
            if (this.foP == null) {
                this.foP = new ArrayList<>();
            }
            this.foC = UtilHelper.getRandom(random, 3, this.foC);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bVJ = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bVH = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.foC);
            this.foP.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.v(list)) {
                if (this.foM == null) {
                    this.foM = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.bVH = z;
                dVar.sex = this.sex;
                dVar.bVA = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fpa = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.fpa = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.foM.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aZX() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.foM == null) {
                this.foM = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.bVH = z;
            bVar.bVA = am.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.fpa = am.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.fpb = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.fpc = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.foM.add(bVar);
            this.foM.add(bB(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getApplicationContext(), d.e.ds1), d.C0080d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.f> aZK() {
        if (this.foF == null) {
            return null;
        }
        return this.foF.getPhotoAlbum();
    }

    private void cH(List<ForumDynamic> list) {
        this.foE = new c();
        this.foE.fpe = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.fpi = forumDynamic.user_thread_count.intValue();
                this.foE.fpe.add(fVar);
            }
        }
    }

    private boolean aZX() {
        if (this.isHost) {
            return false;
        }
        if (this.fox == 3) {
            return true;
        }
        return this.fox == 2 && !this.fow;
    }

    public boolean aZY() {
        if (this.isHost) {
            return false;
        }
        if (this.foy == 3) {
            return true;
        }
        return this.foy == 2 && !this.fow;
    }

    protected com.baidu.tieba.person.d bB(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.fdU = i;
        dVar.aGV = i2;
        return dVar;
    }

    public void aZZ() {
        this.fow = true;
        this.sex = 1;
        this.fox = 1;
        this.foy = 1;
        this.foz = 1;
        this.foA = 1;
        this.foB = -1;
        this.foC = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.foD != null) {
            this.foD.clear();
        }
        this.foD = null;
        this.foE = null;
        this.foF = null;
        this.foG = null;
        this.foJ = null;
        this.foK = null;
        this.mCardNullPolymericData = null;
        if (this.foM != null) {
            this.foM.clear();
        }
        if (this.foP != null) {
            this.foP.clear();
        }
        this.foM = null;
        this.foP = null;
        this.foN.clear();
        this.foX = null;
        this.foY = null;
        this.maskType = 0;
        this.foH = null;
        if (this.foI != null) {
            this.foI.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData baa() {
        return this.foH;
    }

    public List<AlaLiveInfoCoreData> bab() {
        return this.foI;
    }

    public ArrayList<com.baidu.adp.widget.ListView.f> atI() {
        return this.foN;
    }

    public c bac() {
        return this.foE;
    }

    public g bad() {
        return this.foJ;
    }

    public PersonUserGodInfo bae() {
        return this.fiu;
    }

    private void aYp() {
        this.foO.clear();
        this.foS = W(d.f.icon_starer_caise_heibai, d.j.mark, 20);
        this.foS.cmc = new Bundle();
        this.foS.cmc.putBoolean("person_center_item_red_tip", true);
        this.foS.fiF.cmc = new Bundle();
        this.foS.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(this.foS);
        this.foT = W(d.f.icon_lover_caise_heibai, d.j.contacts, 24);
        this.foT.cmc = new Bundle();
        this.foT.cmc.putBoolean("person_center_item_red_tip", true);
        this.foT.fiF.cmc = new Bundle();
        this.foT.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(this.foT);
        this.foQ = W(d.f.icon_liwu_caise_heibai, d.j.gift, 34);
        this.foQ.cmc = new Bundle();
        this.foQ.cmc.putBoolean("person_center_item_red_tip", true);
        this.foQ.fiF.cmc = new Bundle();
        this.foQ.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(this.foQ);
        o W = W(d.f.icon_lishi_caise_heibai, d.j.history, 21);
        W.fiF.cmc = new Bundle();
        W.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(W);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            o W2 = W(d.f.icon_zhibou_caise_heibai, d.j.ala_live, 29);
            W2.cmc = new Bundle();
            W2.fiF.cmc = new Bundle();
            W2.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.foO.add(W2);
        }
        if (this.foW != null) {
            TiebaStatic.log(new ak("c11956"));
            if (this.foW.getManChannel() == 1) {
                this.foR = W(d.f.icon_weibar_caise_heibai, d.j.frs_channel_tip, 30);
                this.foR.cmc = new Bundle();
                this.foR.cmc.putBoolean("person_center_item_red_tip", true);
                this.foR.fiF.cmc = new Bundle();
                this.foR.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.foO.add(this.foR);
            }
        }
        this.foU = W(d.f.icon_vip_heibai, d.j.member_center_item, 16);
        this.foU.cmc = new Bundle();
        this.foU.cmc.putBoolean("person_center_item_red_tip", true);
        this.foU.fiF.cmc = new Bundle();
        this.foU.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(this.foU);
        o W3 = W(d.f.icon_bookshoop_caise_heibai, d.j.book_shel, 33);
        W3.fiF.cmc = new Bundle();
        W3.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.fiv != null) {
            W3.fiF.cmc.putString("book_jump_link", this.fiv.fhA);
        }
        this.foO.add(W3);
        o W4 = W(d.f.icon_kabao_caise_heibai, d.j.card_box, 35);
        W4.fiF.cmc = new Bundle();
        W4.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(W4);
        o W5 = W(d.f.icon_xiaofeijilu_caise_heibai, d.j.consumption_records, 17);
        W5.fiF.cmc = new Bundle();
        W5.fiF.cmc.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.foO.add(W5);
        o W6 = W(d.f.icon_fuwu_caise_heibai, d.j.person_service_centre, 41);
        W6.fiF.cmc = new Bundle();
        W6.fiF.cmc.putString("key_service_centre", "");
        this.foO.add(W6);
    }

    private o W(int i, int i2, int i3) {
        o oVar = new o();
        oVar.iconId = i;
        oVar.title = TbadkCoreApplication.getInst().getString(i2);
        oVar.fiF = new com.baidu.tieba.personCenter.c.a();
        oVar.fiF.cmb = i3;
        return oVar;
    }
}
