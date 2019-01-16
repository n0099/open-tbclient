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
    private AntiData aOp;
    private ArrayList<com.baidu.adp.widget.ListView.h> gBA;
    private c gBB;
    private com.baidu.tieba.person.a.f gBC;
    private m gBD;
    private AlaLiveInfoCoreData gBE;
    private List<AlaLiveInfoCoreData> gBF;
    protected g gBG;
    protected List<com.baidu.adp.widget.ListView.h> gBH;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gBK;
    public n gBL;
    public n gBM;
    public n gBN;
    public n gBO;
    public n gBP;
    public n gBQ;
    private UserVideoChannelInfoData gBR;
    public UserAgreeInfo gBS;
    public NicknameInfo gBT;
    private PersonUserGodInfo gvD;
    private com.baidu.tieba.person.data.d gvE;
    protected boolean isHost;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean gBw = true;
    protected int sex = 1;
    private int gBx = 1;
    private int gBy = 1;
    private int gBz = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.h> gBI = new ArrayList<>();
    private ArrayList<n> gBJ = new ArrayList<>();

    public abstract void brL();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean aVY() {
        return this.gBw;
    }

    public void mp(boolean z) {
        this.gBw = z;
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
            if (this.aOp == null) {
                this.aOp = new AntiData();
            }
            this.aOp.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.gBx = cVar.GetUser().priv_sets.like.intValue();
                    this.gBy = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.gBw = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.gBR == null) {
                this.gBR = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.gBR.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.gvE = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.I(cVar.getConcernedForumList()) && !this.isHost && !brM()) {
                dx(cVar.getConcernedForumList());
            }
            if (this.gBG == null) {
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
            if (this.mCardNullPolymericData == null && v.I(this.gBH) && v.I(this.gBK)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                bqc();
                this.maskType = cVar.getMaskType();
            }
            if (this.gvD == null) {
                this.gvD = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.gvD.parserProtobuf(cVar.getUserGodInfo());
            }
            this.gBS = cVar.getUserAgreeInfo();
            this.gBE = cVar.getLiveInfo();
            this.gBF = cVar.getLiveReplayInfo();
            this.gBT = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.I(user.gift_list)) {
            this.gBG = new g();
            this.gBG.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!brN() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.gBH == null) {
                this.gBH = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.gBz);
            this.gBz = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.dcq = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.dco = z;
            cardPersonDynamicThreadData.dcn = z2;
            cardPersonDynamicThreadData.dcp = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.gBH.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!brN() || this.isHost) {
            if (this.gBK == null) {
                this.gBK = new ArrayList<>();
            }
            this.gBz = UtilHelper.getRandom(random, 3, this.gBz);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.dcq = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.dco = false;
            cardPersonDynamicThreadData.dcn = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.gBz);
            this.gBK.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.I(list)) {
                if (this.gBH == null) {
                    this.gBH = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.dcn = z;
                dVar.sex = this.sex;
                dVar.dcg = ao.aj(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.dch = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.dch = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.gBH.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!brM() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.gBH == null) {
                this.gBH = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.dcn = z;
            bVar.dcg = ao.aj(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.dch = ao.ai(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.gBV = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.gBW = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.gBH.add(bVar);
            this.gBH.add(bC(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getApplicationContext(), e.C0210e.ds1), e.d.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.h> brC() {
        if (this.gBC == null) {
            return null;
        }
        return this.gBC.getPhotoAlbum();
    }

    private void dx(List<ForumDynamic> list) {
        this.gBB = new c();
        this.gBB.gBY = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.gCc = forumDynamic.user_thread_count.intValue();
                this.gBB.gBY.add(fVar);
            }
        }
    }

    private boolean brM() {
        if (this.isHost) {
            return false;
        }
        if (this.gBx == 3) {
            return true;
        }
        return this.gBx == 2 && !this.gBw;
    }

    public boolean brN() {
        if (this.isHost) {
            return false;
        }
        if (this.gBy == 3) {
            return true;
        }
        return this.gBy == 2 && !this.gBw;
    }

    protected com.baidu.tieba.person.d bC(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.gqk = i;
        dVar.beA = i2;
        return dVar;
    }

    public void brO() {
        this.gBw = true;
        this.sex = 1;
        this.gBx = 1;
        this.gBy = 1;
        this.gBz = -1;
        this.mUserData = null;
        if (this.gBA != null) {
            this.gBA.clear();
        }
        this.gBA = null;
        this.gBB = null;
        this.gBC = null;
        this.gBD = null;
        this.gBG = null;
        this.mCardNullPolymericData = null;
        if (this.gBH != null) {
            this.gBH.clear();
        }
        if (this.gBK != null) {
            this.gBK.clear();
        }
        this.gBH = null;
        this.gBK = null;
        this.gBI.clear();
        this.gBS = null;
        this.gBT = null;
        this.maskType = 0;
        this.gBE = null;
        if (this.gBF != null) {
            this.gBF.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData aBj() {
        return this.aOp;
    }

    public AlaLiveInfoCoreData brP() {
        return this.gBE;
    }

    public List<AlaLiveInfoCoreData> brQ() {
        return this.gBF;
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> aNX() {
        return this.gBI;
    }

    public c brR() {
        return this.gBB;
    }

    public g brS() {
        return this.gBG;
    }

    public PersonUserGodInfo brT() {
        return this.gvD;
    }

    private void bqc() {
        this.gBJ.clear();
        this.gBN = X(e.f.icon_starer_caise_heibai, e.j.mark, 20);
        this.gBN.dul = new Bundle();
        this.gBN.dul.putBoolean("person_center_item_red_tip", true);
        this.gBN.gCn.dul = new Bundle();
        this.gBN.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(this.gBN);
        this.gBO = X(e.f.icon_lover_caise_heibai, e.j.contacts, 24);
        this.gBO.dul = new Bundle();
        this.gBO.dul.putBoolean("person_center_item_red_tip", true);
        this.gBO.gCn.dul = new Bundle();
        this.gBO.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(this.gBO);
        this.gBL = X(e.f.icon_liwu_caise_heibai, e.j.gift, 34);
        this.gBL.dul = new Bundle();
        this.gBL.dul.putBoolean("person_center_item_red_tip", true);
        this.gBL.gCn.dul = new Bundle();
        this.gBL.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(this.gBL);
        n X = X(e.f.icon_lishi_caise_heibai, e.j.history, 21);
        X.gCn.dul = new Bundle();
        X.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(X);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n X2 = X(e.f.icon_zhibou_caise_heibai, e.j.ala_live, 29);
            X2.dul = new Bundle();
            X2.gCn.dul = new Bundle();
            X2.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.gBJ.add(X2);
        }
        if (this.gBR != null) {
            TiebaStatic.log(new am("c11956"));
            if (this.gBR.getManChannel() == 1) {
                this.gBM = X(e.f.icon_weibar_caise_heibai, e.j.frs_channel_tip, 30);
                this.gBM.dul = new Bundle();
                this.gBM.dul.putBoolean("person_center_item_red_tip", true);
                this.gBM.gCn.dul = new Bundle();
                this.gBM.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.gBJ.add(this.gBM);
            }
        }
        this.gBP = X(e.f.icon_vip_heibai, e.j.member_center_item, 16);
        this.gBP.dul = new Bundle();
        this.gBP.dul.putBoolean("person_center_item_red_tip", true);
        this.gBP.gCn.dul = new Bundle();
        this.gBP.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(this.gBP);
        n X3 = X(e.f.icon_bookshoop_caise_heibai, e.j.book_shel, 33);
        X3.gCn.dul = new Bundle();
        X3.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.gvE != null) {
            X3.gCn.dul.putString("book_jump_link", this.gvE.gux);
        }
        this.gBJ.add(X3);
        n X4 = X(e.f.icon_kabao_caise_heibai, e.j.card_box, 35);
        X4.gCn.dul = new Bundle();
        X4.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(X4);
        n X5 = X(e.f.icon_xiaofeijilu_caise_heibai, e.j.consumption_records, 17);
        X5.gCn.dul = new Bundle();
        X5.gCn.dul.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.gBJ.add(X5);
        n X6 = X(e.f.icon_fuwu_caise_heibai, e.j.person_service_centre, 41);
        X6.gCn.dul = new Bundle();
        X6.gCn.dul.putString("key_service_centre", "");
        this.gBJ.add(X6);
    }

    private n X(int i, int i2, int i3) {
        n nVar = new n();
        nVar.iconId = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.gCn = new com.baidu.tieba.personCenter.c.a();
        nVar.gCn.duk = i3;
        return nVar;
    }
}
