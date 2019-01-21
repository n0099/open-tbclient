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
    private AntiData aOq;
    private ArrayList<com.baidu.adp.widget.ListView.h> gBB;
    private c gBC;
    private com.baidu.tieba.person.a.f gBD;
    private m gBE;
    private AlaLiveInfoCoreData gBF;
    private List<AlaLiveInfoCoreData> gBG;
    protected g gBH;
    protected List<com.baidu.adp.widget.ListView.h> gBI;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gBL;
    public n gBM;
    public n gBN;
    public n gBO;
    public n gBP;
    public n gBQ;
    public n gBR;
    private UserVideoChannelInfoData gBS;
    public UserAgreeInfo gBT;
    public NicknameInfo gBU;
    private PersonUserGodInfo gvE;
    private com.baidu.tieba.person.data.d gvF;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gBx = true;
    protected int sex = 1;
    private int gBy = 1;
    private int gBz = 1;
    private int gBA = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gBJ = new ArrayList<>();
    private ArrayList<n> gBK = new ArrayList<>();

    public abstract void brL();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aVY() {
        return this.gBx;
    }

    public void mp(boolean z) {
        this.gBx = z;
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
            if (this.aOq == null) {
                this.aOq = new AntiData();
            }
            this.aOq.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gBy = cVar.GetUser().priv_sets.like.intValue();
                    this.gBz = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gBx = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gBS == null) {
                this.gBS = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gBS.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gvF = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.I(cVar.getConcernedForumList()) && !this.isHost && !brM()) {
                dx(cVar.getConcernedForumList());
            }
            if (this.gBH == null) {
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
            String ag = ao.ag(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.I(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String ag2 = ao.ag(longValue);
                        String aj = ao.aj(longValue);
                        String ai = ao.ai(longValue);
                        if (ao.equals(ag2, ag)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (ao.equals(ai, str3) && ao.equals(aj, str2) && ao.equals(ag2, ag)) {
                            z2 = false;
                            ai = str3;
                            str = ag;
                        } else {
                            z2 = true;
                            str2 = aj;
                            str = ag2;
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
                        str3 = ai;
                        ag = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.I(this.gBI) && v.I(this.gBL)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bqc();
                this.maskType = cVar.getMaskType();
            }
            if (this.gvE == null) {
                this.gvE = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gvE.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gBT = cVar.getUserAgreeInfo();
            this.gBF = cVar.getLiveInfo();
            this.gBG = cVar.getLiveReplayInfo();
            this.gBU = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.I(user.gift_list)) {
            this.gBH = new g();
            this.gBH.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!brN() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gBI == null) {
                this.gBI = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gBA);
            this.gBA = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.dcr = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.dcp = z;
            cardPersonDynamicThreadData.dco = z2;
            cardPersonDynamicThreadData.dcq = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gBI.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!brN() || this.isHost) {
            if (this.gBL == null) {
                this.gBL = new ArrayList<>();
            }
            this.gBA = UtilHelper.getRandom(random, 3, this.gBA);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.dcr = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.dcp = false;
            cardPersonDynamicThreadData.dco = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gBA);
            this.gBL.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.I(list)) {
                if (this.gBI == null) {
                    this.gBI = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.dco = z;
                dVar.sex = this.sex;
                dVar.dch = ao.aj(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.dci = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.dci = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gBI.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!brM() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gBI == null) {
                this.gBI = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.dco = z;
            bVar.dch = ao.aj(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.dci = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gBW = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gBX = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gBI.add(bVar);
            this.gBI.add(bC(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0210e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> brC() {
        if (this.gBD == null) {
            return null;
        }
        return this.gBD.getPhotoAlbum();
    }

    private void dx(List<ForumDynamic> list) {
        this.gBC = new c();
        this.gBC.gBZ = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gCd = forumDynamic.user_thread_count.intValue();
                this.gBC.gBZ.add(fVar);
            }
        }
    }

    private boolean brM() {
        if (this.isHost) {
            return false;
        }
        if (this.gBy == 3) {
            return true;
        }
        return this.gBy == 2 && !this.gBx;
    }

    public boolean brN() {
        if (this.isHost) {
            return false;
        }
        if (this.gBz == 3) {
            return true;
        }
        return this.gBz == 2 && !this.gBx;
    }

    protected com.baidu.tieba.person.d bC(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gql = i;
        dVar.beB = i2;
        return dVar;
    }

    public void brO() {
        this.gBx = true;
        this.sex = 1;
        this.gBy = 1;
        this.gBz = 1;
        this.gBA = -1;
        this.mUserData = null;
        if (this.gBB != null) {
            this.gBB.clear();
        }
        this.gBB = null;
        this.gBC = null;
        this.gBD = null;
        this.gBE = null;
        this.gBH = null;
        this.mCardNullPolymericData = null;
        if (this.gBI != null) {
            this.gBI.clear();
        }
        if (this.gBL != null) {
            this.gBL.clear();
        }
        this.gBI = null;
        this.gBL = null;
        this.gBJ.clear();
        this.gBT = null;
        this.gBU = null;
        this.maskType = 0;
        this.gBF = null;
        if (this.gBG != null) {
            this.gBG.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData aBj() {
        return this.aOq;
    }

    public AlaLiveInfoCoreData brP() {
        return this.gBF;
    }

    public List<AlaLiveInfoCoreData> brQ() {
        return this.gBG;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aNX() {
        return this.gBJ;
    }

    public c brR() {
        return this.gBC;
    }

    public g brS() {
        return this.gBH;
    }

    public PersonUserGodInfo brT() {
        return this.gvE;
    }

    private void bqc() {
        this.gBK.clear();
        this.gBO = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gBO.dum = new Bundle();
        this.gBO.dum.putBoolean("person_center_item_red_tip", true);
        this.gBO.gCo.dum = new Bundle();
        this.gBO.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(this.gBO);
        this.gBP = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gBP.dum = new Bundle();
        this.gBP.dum.putBoolean("person_center_item_red_tip", true);
        this.gBP.gCo.dum = new Bundle();
        this.gBP.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(this.gBP);
        this.gBM = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gBM.dum = new Bundle();
        this.gBM.dum.putBoolean("person_center_item_red_tip", true);
        this.gBM.gCo.dum = new Bundle();
        this.gBM.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(this.gBM);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.gCo.dum = new Bundle();
        X.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.dum = new Bundle();
            X2.gCo.dum = new Bundle();
            X2.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gBK.add(X2);
        }
        if (this.gBS != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gBS.getManChannel() == 1) {
                this.gBN = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gBN.dum = new Bundle();
                this.gBN.dum.putBoolean("person_center_item_red_tip", true);
                this.gBN.gCo.dum = new Bundle();
                this.gBN.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gBK.add(this.gBN);
            }
        }
        this.gBQ = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gBQ.dum = new Bundle();
        this.gBQ.dum.putBoolean("person_center_item_red_tip", true);
        this.gBQ.gCo.dum = new Bundle();
        this.gBQ.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(this.gBQ);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.gCo.dum = new Bundle();
        X3.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gvF != null) {
            X3.gCo.dum.putString("book_jump_link", this.gvF.guy);
        }
        this.gBK.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.gCo.dum = new Bundle();
        X4.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.gCo.dum = new Bundle();
        X5.gCo.dum.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBK.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.gCo.dum = new Bundle();
        X6.gCo.dum.putString("key_service_centre", "");
        this.gBK.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gCo = new com.baidu.tieba.personCenter.c.a();
        nVar.gCo.dul = i3;
        return nVar;
    }
}
