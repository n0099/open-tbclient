package com.baidu.tieba.personPolymeric.c;

import android.os.Bundle;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.z;
import com.baidu.tbadk.data.UserVideoChannelInfoData;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.personInfo.PersonUserGodInfo;
import com.baidu.tieba.w;
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
    protected boolean boT;
    private ArrayList<v> eWa;
    private c eWb;
    private com.baidu.tieba.person.a.e eWc;
    private m eWd;
    private AlaLiveInfoCoreData eWe;
    private g eWf;
    protected j eWg;
    protected List<v> eWh;
    private com.baidu.tieba.person.data.b eWk;
    public com.baidu.tieba.personCenter.b.a eWl;
    public com.baidu.tieba.personCenter.b.a eWm;
    public com.baidu.tieba.personCenter.b.a eWn;
    public com.baidu.tieba.personCenter.b.a eWo;
    public com.baidu.tieba.personCenter.b.a eWp;
    public com.baidu.tieba.personCenter.b.a eWq;
    private UserVideoChannelInfoData eWr;
    private PersonUserGodInfo eWs;
    public UserAgreeInfo eWt;
    public NicknameInfo eWu;
    protected i mCardNullPolymericData;
    private UserData mUserData;
    private boolean eVT = true;
    protected int sex = 1;
    private int eVU = 1;
    private int eVV = 1;
    private int eVW = 1;
    private int eVX = 1;
    private int eVY = -1;
    private int eVZ = -1;
    private boolean hasMore = true;
    protected ArrayList<v> eWi = new ArrayList<>();
    private ArrayList<com.baidu.tieba.personCenter.b.a> eWj = new ArrayList<>();

    public abstract void UT();

    public a(boolean z) {
        this.boT = z;
    }

    public boolean awG() {
        return this.eVT;
    }

    public void jW(boolean z) {
        this.eVT = z;
    }

    public boolean Oy() {
        return this.boT;
    }

    public void a(com.baidu.tieba.person.f fVar) {
        if (fVar != null) {
            if (this.mUserData == null) {
                this.mUserData = new UserData();
            }
            this.mUserData.parserProtobuf(fVar.GetUser());
            if (fVar.GetUser() != null) {
                if (fVar.GetUser().priv_sets != null) {
                    this.eVU = fVar.GetUser().priv_sets.like.intValue();
                    this.eVV = fVar.GetUser().priv_sets.post.intValue();
                    this.eVW = fVar.GetUser().priv_sets.group.intValue();
                    this.eVX = fVar.GetUser().priv_sets.friend.intValue();
                }
                this.sex = fVar.GetUser().sex.intValue();
            }
            if (fVar.getTaInfo() != null) {
                this.eVT = fVar.getTaInfo().is_friend.intValue() == 1;
            }
            this.mUserData.setIsFriend(fVar.getTaInfo().is_friend.intValue());
            if (this.eWr == null) {
                this.eWr = new UserVideoChannelInfoData();
            }
            if (fVar.getUserChannelInfo() != null) {
                this.eWr.parserProtobuf(fVar.getUserChannelInfo());
            }
            if (fVar.getBookrackData() != null) {
                com.baidu.tieba.personInfo.a aVar = new com.baidu.tieba.personInfo.a();
                aVar.a(fVar.getBookrackData());
                this.eWk = new com.baidu.tieba.person.data.b(true, aVar);
            }
            if (!z.t(fVar.getConcernedForumList()) && !this.boT && !aVu()) {
                cs(fVar.getConcernedForumList());
            }
            if (this.eWg == null && aVv() && !this.boT) {
                this.eWg = new j();
                this.eWg.sex = this.sex;
                this.eWg.eWL = aVv();
            }
            if (!z.t(fVar.getDynamicInfoList())) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : fVar.getDynamicInfoList()) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eVY != date.getDate();
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
                        this.eVY = date.getDate();
                    }
                }
            }
            if (this.mCardNullPolymericData == null && z.t(this.eWh)) {
                this.mCardNullPolymericData = new i();
                this.mCardNullPolymericData.sex = this.sex;
                this.mCardNullPolymericData.boT = this.boT;
                this.hasMore = false;
            }
            if (this.boT) {
                aVA();
            }
            if (this.eWs == null) {
                this.eWs = new PersonUserGodInfo();
            }
            if (fVar.getUserGodInfo() != null && (fVar.getUserGodInfo().god_type.intValue() == 2 || fVar.getUserGodInfo().god_type.intValue() == 1)) {
                this.mUserData.setIsBigV(true);
                this.eWs.parserProtobuf(fVar.getUserGodInfo());
            }
            this.eWt = fVar.getUserAgreeInfo();
            this.eWe = fVar.getLiveInfo();
            this.eWu = fVar.getNicknameInfo();
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aVv() || this.boT) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eWh == null) {
                this.eWh = new ArrayList();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eVZ);
            this.eVZ = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bEU = true;
            cardPersonDynamicThreadData.boT = this.boT;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bET = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eWh.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!z.t(list)) {
                if (this.eWh == null) {
                    this.eWh = new ArrayList();
                }
                d dVar = new d();
                dVar.boT = this.boT;
                dVar.bET = z;
                dVar.sex = this.sex;
                dVar.bEM = aw.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eWw = aw.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.eWw = aw.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                dVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        dVar.users.add(userData);
                    }
                }
                this.eWh.add(dVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aVu() || this.boT) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eWh == null) {
                this.eWh = new ArrayList();
            }
            b bVar = new b();
            bVar.boT = this.boT;
            bVar.sex = this.sex;
            bVar.bET = z;
            bVar.bEM = aw.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.eWw = aw.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            bVar.forumId = forumDynamic.forum_id.longValue();
            bVar.avatar = forumDynamic.avatar;
            bVar.cLo = forumDynamic.forum_name;
            bVar.isAttention = forumDynamic.is_like.intValue() == 1;
            bVar.eWx = forumDynamic.member_count.intValue();
            bVar.postNum = forumDynamic.thread_count.intValue();
            this.eWh.add(bVar);
            this.eWh.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
    }

    public List<v> aVl() {
        if (this.eWc == null) {
            return null;
        }
        return this.eWc.getPhotoAlbum();
    }

    private void cs(List<ForumDynamic> list) {
        this.eWb = new c();
        this.eWb.eWz = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                f fVar = new f();
                fVar.forumId = forumDynamic.forum_id.longValue();
                fVar.forumName = forumDynamic.forum_name;
                fVar.avatar = forumDynamic.avatar;
                fVar.sex = this.sex;
                fVar.eWD = forumDynamic.user_thread_count.intValue();
                this.eWb.eWz.add(fVar);
            }
        }
    }

    private boolean aVu() {
        if (this.boT) {
            return false;
        }
        if (this.eVU == 3) {
            return true;
        }
        return this.eVU == 2 && !this.eVT;
    }

    public boolean aVv() {
        if (this.boT) {
            return false;
        }
        if (this.eVV == 3) {
            return true;
        }
        return this.eVV == 2 && !this.eVT;
    }

    private com.baidu.tieba.person.h bg(int i, int i2) {
        com.baidu.tieba.person.h hVar = new com.baidu.tieba.person.h();
        hVar.eMR = i;
        hVar.eQh = i2;
        return hVar;
    }

    public void aVw() {
        this.eVT = true;
        this.sex = 1;
        this.eVU = 1;
        this.eVV = 1;
        this.eVW = 1;
        this.eVX = 1;
        this.eVY = -1;
        this.eVZ = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eWa != null) {
            this.eWa.clear();
        }
        this.eWa = null;
        this.eWb = null;
        this.eWc = null;
        this.eWd = null;
        this.eWf = null;
        this.eWg = null;
        this.mCardNullPolymericData = null;
        if (this.eWh != null) {
            this.eWh.clear();
        }
        this.eWh = null;
        this.eWi.clear();
        this.eWt = null;
        this.eWu = null;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public AlaLiveInfoCoreData aVx() {
        return this.eWe;
    }

    public ArrayList<v> aou() {
        return this.eWi;
    }

    public c aVy() {
        return this.eWb;
    }

    public ArrayList<com.baidu.tieba.personCenter.b.a> aVz() {
        return this.eWj;
    }

    private void aVA() {
        this.eWj.clear();
        this.eWn = M(w.g.icon_starer_caise_heibai, w.l.mark, 20);
        this.eWn.bVe = new Bundle();
        this.eWn.bVe.putBoolean("person_center_item_red_tip", true);
        this.eWn.eRg.bVe = new Bundle();
        this.eWn.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(this.eWn);
        this.eWo = M(w.g.icon_lover_caise_heibai, w.l.contacts, 24);
        this.eWo.bVe = new Bundle();
        this.eWo.bVe.putBoolean("person_center_item_red_tip", true);
        this.eWo.eRg.bVe = new Bundle();
        this.eWo.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(this.eWo);
        this.eWl = M(w.g.icon_liwu_caise_heibai, w.l.gift, 34);
        this.eWl.bVe = new Bundle();
        this.eWl.bVe.putBoolean("person_center_item_red_tip", true);
        this.eWl.eRg.bVe = new Bundle();
        this.eWl.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(this.eWl);
        com.baidu.tieba.personCenter.b.a M = M(w.g.icon_lishi_caise_heibai, w.l.history, 21);
        M.eRg.bVe = new Bundle();
        M.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(M);
        if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(AlaLiveRoomActivityConfig.class)) {
            com.baidu.tieba.personCenter.b.a M2 = M(w.g.icon_zhibou_caise_heibai, w.l.person_center_ala_live, 29);
            M2.bVe = new Bundle();
            M2.eRg.bVe = new Bundle();
            M2.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
            this.eWj.add(M2);
        }
        if (this.eWr != null) {
            TiebaStatic.log(new au("c11956"));
            if (this.eWr.getManChannel() == 1) {
                this.eWm = M(w.g.icon_weibar_caise_heibai, w.l.weiba, 30);
                this.eWm.bVe = new Bundle();
                this.eWm.bVe.putBoolean("person_center_item_red_tip", true);
                this.eWm.eRg.bVe = new Bundle();
                this.eWm.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
                this.eWj.add(this.eWm);
            }
        }
        com.baidu.tieba.personCenter.b.a M3 = M(w.g.icon_zhuanshi_caise_heibai, w.l.blue_drill, 15);
        M3.eRg.bVe = new Bundle();
        M3.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(M3);
        com.baidu.tieba.personCenter.b.a M4 = M(w.g.icon_bookshoop_caise_heibai, w.l.book_shel, 33);
        M4.eRg.bVe = new Bundle();
        M4.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        if (this.eWk != null) {
            M4.eRg.bVe.putString("book_jump_link", this.eWk.eQG);
        }
        this.eWj.add(M4);
        com.baidu.tieba.personCenter.b.a M5 = M(w.g.icon_kabao_caise_heibai, w.l.card_box, 35);
        M5.eRg.bVe = new Bundle();
        M5.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(M5);
        com.baidu.tieba.personCenter.b.a M6 = M(w.g.icon_xiaofeijilu_caise_heibai, w.l.consumption_records, 17);
        M6.eRg.bVe = new Bundle();
        M6.eRg.bVe.putSerializable(UserData.TYPE_USER, this.mUserData);
        this.eWj.add(M6);
    }

    private com.baidu.tieba.personCenter.b.a M(int i, int i2, int i3) {
        com.baidu.tieba.personCenter.b.a aVar = new com.baidu.tieba.personCenter.b.a();
        aVar.iconId = i;
        aVar.title = TbadkCoreApplication.m9getInst().getString(i2);
        aVar.eRg = new com.baidu.tieba.personCenter.c.a();
        aVar.eRg.bVd = i3;
        return aVar;
    }
}
