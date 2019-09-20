package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
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
/* loaded from: classes6.dex */
public abstract class a {
    private AntiData cgT;
    private PersonUserGodInfo ina;
    private com.baidu.tieba.person.data.d inb;
    protected boolean isHost;
    private com.baidu.tieba.person.a.f itA;
    private m itB;
    private AlaLiveInfoCoreData itC;
    private List<AlaLiveInfoCoreData> itD;
    protected g itE;
    protected List<com.baidu.adp.widget.ListView.m> itF;
    protected ArrayList<com.baidu.adp.widget.ListView.m> itI;
    public n itJ;
    public n itK;
    public n itL;
    public n itM;
    public n itN;
    public n itO;
    private UserVideoChannelInfoData itP;
    public UserAgreeInfo itQ;
    public NicknameInfo itR;
    private ArrayList<com.baidu.adp.widget.ListView.m> ity;
    private c itz;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean itu = true;
    protected int sex = 1;
    private int itv = 1;
    private int itw = 1;
    private int itx = -1;
    public int maskType = 0;
    protected ArrayList<com.baidu.adp.widget.ListView.m> itG = new ArrayList<>();
    private ArrayList<n> itH = new ArrayList<>();

    public abstract void cef();

    public a(boolean z) {
        this.isHost = z;
    }

    public boolean bHV() {
        return this.itu;
    }

    public void pU(boolean z) {
        this.itu = z;
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
            if (this.cgT == null) {
                this.cgT = new AntiData();
            }
            this.cgT.parserProtobuf(cVar.GetAntiStat());
            if (cVar.GetUser() != null) {
                if (cVar.GetUser().priv_sets != null) {
                    this.itv = cVar.GetUser().priv_sets.like.intValue();
                    this.itw = cVar.GetUser().priv_sets.post.intValue();
                }
                this.sex = cVar.GetUser().sex.intValue();
            }
            if (cVar.getTaInfo() != null) {
                this.itu = cVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(cVar.getTaInfo().is_friend.intValue());
            if (this.itP == null) {
                this.itP = new UserVideoChannelInfoData();
            }
            if (cVar.getUserChannelInfo() != null) {
                this.itP.parserProtobuf(cVar.getUserChannelInfo());
            }
            if (cVar.getBookrackData() != null) {
                com.baidu.tieba.person.data.a aVar = new com.baidu.tieba.person.data.a();
                aVar.a(cVar.getBookrackData());
                this.inb = new com.baidu.tieba.person.data.d(true, aVar);
            }
            if (!v.aa(cVar.getConcernedForumList()) && !this.isHost && !ceg()) {
                dT(cVar.getConcernedForumList());
            }
            if (this.itE == null) {
                a(cVar.GetUser());
            }
            Random random = new Random();
            if (this.isHost && !v.aa(cVar.GetPostList())) {
                for (PostInfoList postInfoList : cVar.GetPostList()) {
                    if ((postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.thread_type.longValue() == 40) || (postInfoList != null && postInfoList.is_post_deleted.intValue() == 2 && postInfoList.is_share_thread.intValue() == 1)) {
                        a(postInfoList, random);
                    }
                }
            }
            String aY = aq.aY(System.currentTimeMillis());
            String str2 = "";
            String str3 = "";
            if (!v.aa(cVar.getDynamicInfoList())) {
                Date date = new Date();
                boolean z3 = true;
                for (DynamicInfo dynamicInfo : cVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        long longValue = dynamicInfo.dynamic_timestamp.longValue() * 1000;
                        date.setTime(longValue);
                        String aY2 = aq.aY(longValue);
                        String bb = aq.bb(longValue);
                        String ba = aq.ba(longValue);
                        if (aq.bV(aY2, aY)) {
                            z = false;
                        } else {
                            z = true;
                        }
                        if (aq.bV(ba, str3) && aq.bV(bb, str2) && aq.bV(aY2, aY)) {
                            z2 = false;
                            ba = str3;
                            str = aY;
                        } else {
                            z2 = true;
                            str2 = bb;
                            str = aY2;
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
                        str3 = ba;
                        aY = str;
                    }
                }
            }
            if (this.mCardNullPolymericData == null && v.aa(this.itF) && v.aa(this.itI)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.isHost = this.isHost;
            }
            if (this.isHost) {
                ccp();
                this.maskType = cVar.getMaskType();
            }
            if (this.ina == null) {
                this.ina = new PersonUserGodInfo();
            }
            if (cVar.getUserGodInfo() != null && (cVar.getUserGodInfo().god_type.intValue() == 2 || cVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.ina.parserProtobuf(cVar.getUserGodInfo());
            }
            this.itQ = cVar.getUserAgreeInfo();
            this.itC = cVar.getLiveInfo();
            this.itD = cVar.getLiveReplayInfo();
            this.itR = cVar.getNicknameInfo();
        }
    }

    private void a(User user) {
        if (user != null && !v.aa(user.gift_list)) {
            this.itE = new g();
            this.itE.parserProtoBuf(user);
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z, boolean z2, boolean z3) {
        ThreadInfo threadInfo;
        if ((!ceh() || this.isHost) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.itF == null) {
                this.itF = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.itx);
            this.itx = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eIB = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eIz = z;
            cardPersonDynamicThreadData.eIy = z2;
            cardPersonDynamicThreadData.eIA = z3;
            cardPersonDynamicThreadData.from = 3;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.itF.add(cardPersonDynamicThreadData);
        }
    }

    private void a(PostInfoList postInfoList, Random random) {
        if (!ceh() || this.isHost) {
            if (this.itI == null) {
                this.itI = new ArrayList<>();
            }
            this.itx = UtilHelper.getRandom(random, 3, this.itx);
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.eIB = true;
            cardPersonDynamicThreadData.isHost = this.isHost;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.eIz = false;
            cardPersonDynamicThreadData.eIy = false;
            cardPersonDynamicThreadData.parseProtobuf(postInfoList, this.itx);
            this.itI.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!v.aa(list)) {
                if (this.itF == null) {
                    this.itF = new ArrayList();
                }
                d dVar = new d();
                dVar.isHost = this.isHost;
                dVar.eIy = z;
                dVar.sex = this.sex;
                dVar.eIr = aq.bb(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eIs = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eIs = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.itF.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!ceg() || this.isHost) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.itF == null) {
                this.itF = new ArrayList();
            }
            b bVar = new b();
            bVar.isHost = this.isHost;
            bVar.sex = this.sex;
            bVar.eIy = z;
            bVar.eIr = aq.bb(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eIs = aq.ba(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.itT = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.itU = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.itF.add(bVar);
            this.itF.add(cl(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getApplicationContext(), R.dimen.ds1), R.color.cp_bg_line_c));
        }
    }

    public List<com.baidu.adp.widget.ListView.m> cdW() {
        if (this.itA == null) {
            return null;
        }
        return this.itA.getPhotoAlbum();
    }

    private void dT(List<ForumDynamic> list) {
        this.itz = new c();
        this.itz.itW = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.iua = forumDynamic.user_thread_count.intValue();
                this.itz.itW.add(fVar);
            }
        }
    }

    private boolean ceg() {
        if (this.isHost) {
            return false;
        }
        if (this.itv == 3) {
            return true;
        }
        return this.itv == 2 && !this.itu;
    }

    public boolean ceh() {
        if (this.isHost) {
            return false;
        }
        if (this.itw == 3) {
            return true;
        }
        return this.itw == 2 && !this.itu;
    }

    protected com.baidu.tieba.person.d cl(int i, int i2) {
        com.baidu.tieba.person.d dVar = new com.baidu.tieba.person.d();
        dVar.ihE = i;
        dVar.cyH = i2;
        return dVar;
    }

    public void cei() {
        this.itu = true;
        this.sex = 1;
        this.itv = 1;
        this.itw = 1;
        this.itx = -1;
        this.mUserData = null;
        if (this.ity != null) {
            this.ity.clear();
        }
        this.ity = null;
        this.itz = null;
        this.itA = null;
        this.itB = null;
        this.itE = null;
        this.mCardNullPolymericData = null;
        if (this.itF != null) {
            this.itF.clear();
        }
        if (this.itI != null) {
            this.itI.clear();
        }
        this.itF = null;
        this.itI = null;
        this.itG.clear();
        this.itQ = null;
        this.itR = null;
        this.maskType = 0;
        this.itC = null;
        if (this.itD != null) {
            this.itD.clear();
        }
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AntiData blT() {
        return this.cgT;
    }

    public AlaLiveInfoCoreData cej() {
        return this.itC;
    }

    public List<AlaLiveInfoCoreData> cek() {
        return this.itD;
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> bzL() {
        return this.itG;
    }

    public c cel() {
        return this.itz;
    }

    public g cem() {
        return this.itE;
    }

    public PersonUserGodInfo cen() {
        return this.ina;
    }

    private void ccp() {
        this.itH.clear();
        this.itL = ad(R.drawable.icon_starer_caise_heibai, R.string.mark, 20);
        this.itL.azD = new Bundle();
        this.itL.azD.putBoolean("person_center_item_red_tip", true);
        this.itL.iul.azD = new Bundle();
        this.itL.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(this.itL);
        this.itM = ad(R.drawable.icon_lover_caise_heibai, R.string.contacts, 24);
        this.itM.azD = new Bundle();
        this.itM.azD.putBoolean("person_center_item_red_tip", true);
        this.itM.iul.azD = new Bundle();
        this.itM.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(this.itM);
        this.itJ = ad(R.drawable.icon_liwu_caise_heibai, R.string.gift, 34);
        this.itJ.azD = new Bundle();
        this.itJ.azD.putBoolean("person_center_item_red_tip", true);
        this.itJ.iul.azD = new Bundle();
        this.itJ.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(this.itJ);
        n ad = ad(R.drawable.icon_lishi_caise_heibai, R.string.history, 21);
        ad.iul.azD = new Bundle();
        ad.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(ad);
        if (TbadkCoreApplication.getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            n ad2 = ad(R.drawable.icon_zhibou_caise_heibai, R.string.ala_live, 29);
            ad2.azD = new Bundle();
            ad2.iul.azD = new Bundle();
            ad2.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.itH.add(ad2);
        }
        if (this.itP != null) {
            TiebaStatic.log(new an("c11956"));
            if (this.itP.getManChannel() == 1) {
                this.itK = ad(R.drawable.icon_weibar_caise_heibai, R.string.frs_channel_tip, 30);
                this.itK.azD = new Bundle();
                this.itK.azD.putBoolean("person_center_item_red_tip", true);
                this.itK.iul.azD = new Bundle();
                this.itK.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.itH.add(this.itK);
            }
        }
        this.itN = ad(R.drawable.icon_vip_heibai, R.string.member_center_item, 16);
        this.itN.azD = new Bundle();
        this.itN.azD.putBoolean("person_center_item_red_tip", true);
        this.itN.iul.azD = new Bundle();
        this.itN.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(this.itN);
        n ad3 = ad(R.drawable.icon_bookshoop_caise_heibai, R.string.book_shel, 33);
        ad3.iul.azD = new Bundle();
        ad3.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.inb != null) {
            ad3.iul.azD.putString("book_jump_link", this.inb.ilR);
        }
        this.itH.add(ad3);
        n ad4 = ad(R.drawable.icon_kabao_caise_heibai, R.string.card_box, 35);
        ad4.iul.azD = new Bundle();
        ad4.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(ad4);
        n ad5 = ad(R.drawable.icon_xiaofeijilu_caise_heibai, R.string.consumption_records, 17);
        ad5.iul.azD = new Bundle();
        ad5.iul.azD.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.itH.add(ad5);
        n ad6 = ad(R.drawable.icon_fuwu_caise_heibai, R.string.person_service_centre, 41);
        ad6.iul.azD = new Bundle();
        ad6.iul.azD.putString("key_service_centre", "");
        this.itH.add(ad6);
    }

    private n ad(int i, int i2, int i3) {
        n nVar = new n();
        nVar.ink = i;
        nVar.title = TbadkCoreApplication.getInst().getString(i2);
        nVar.iul = new com.baidu.tieba.personCenter.c.a();
        nVar.iul.feK = i3;
        return nVar;
    }
}
