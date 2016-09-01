package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DealWindow;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.Personal.DataRes;
import tbclient.Personal.ForumGodDetailInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes.dex */
public class n {
    private boolean bcA;
    private b eIA;
    private com.baidu.tieba.person.a.g eIB;
    private com.baidu.tieba.person.data.e eIC;
    private l eID;
    private f eIE;
    private i eIF;
    private h eIG;
    private ArrayList<v> eIH;
    private ArrayList<v> eIz;
    private UserData mUserData;
    private boolean eIs = true;
    private int sex = 1;
    private int eIt = 1;
    private int eIu = 1;
    private int eIv = 1;
    private int eIw = 1;
    private int eIx = -1;
    private int eIy = -1;
    private boolean hasMore = true;
    private ArrayList<v> eDq = new ArrayList<>();

    public n(boolean z) {
        this.bcA = z;
    }

    public boolean awN() {
        return this.eIs;
    }

    public void iQ(boolean z) {
        this.eIs = z;
    }

    public boolean aPz() {
        return this.bcA;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eIt = dataRes.user.priv_sets.like.intValue();
                    this.eIu = dataRes.user.priv_sets.post.intValue();
                    this.eIv = dataRes.user.priv_sets.group.intValue();
                    this.eIw = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eIs = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.isGodUser = true;
                this.eIz = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eHX = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eIz.add(dVar);
                    this.eIz.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_d));
                }
                if (!y.t(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eHX = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eIz.add(dVar2);
                        this.eIz.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_d));
                    }
                }
            }
            if (!y.t(dataRes.concerned_forum_list) && !this.bcA && !aTC()) {
                cE(dataRes.concerned_forum_list);
            }
            if (this.eIB == null && this.bcA) {
                i(this.mUserData);
            }
            a(dataRes.window, this.bcA);
            if (!y.t(dataRes.video_page) && !aTD()) {
                a(dataRes.video_page, j);
            }
            if (this.eIE == null && !this.bcA) {
                a(dataRes.user);
            }
            if (this.eIF == null && ((aTC() || aTD()) && !this.bcA)) {
                this.eIF = new i();
                this.eIF.sex = this.sex;
                this.eIF.eIl = aTC();
                this.eIF.eIm = aTD();
            }
            if (!y.t(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eIx != date.getDate();
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
                        this.eIx = date.getDate();
                    }
                }
            }
            if (this.eIG == null && y.t(this.eIH)) {
                this.eIG = new h();
                this.eIG.sex = this.sex;
                this.eIG.bcA = this.bcA;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !y.t(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eIE = new f();
            this.eIE.parserProtoBuf(user);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            this.eIB = new com.baidu.tieba.person.a.g();
            this.eIB.f(userData);
        }
    }

    public List<v> aTr() {
        if (this.eIB == null) {
            return null;
        }
        return this.eIB.getPhotoAlbum();
    }

    private void a(List<ThreadInfo> list, long j) {
        this.eID = new l();
        this.eID.uid = j;
        this.eID.eIp = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && threadInfo.video_info != null) {
                k kVar = new k();
                kVar.QV = threadInfo.video_info.thumbnail_url;
                kVar.title = threadInfo.title;
                kVar.aRv = String.valueOf(threadInfo.fid);
                kVar.Tt = String.valueOf(threadInfo.tid);
                kVar.postId = String.valueOf(threadInfo.post_id);
                this.eID.eIp.add(kVar);
            }
        }
    }

    private void cE(List<ForumDynamic> list) {
        this.eIA = new b();
        this.eIA.eIa = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eIe = forumDynamic.user_thread_count.intValue();
                this.eIA.eIa.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aTD() || this.bcA) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eIH == null) {
                this.eIH = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eIy);
            this.eIy = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bcz = true;
            cardPersonDynamicThreadData.bcA = this.bcA;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bcy = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eIH.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.t(list)) {
                if (this.eIH == null) {
                    this.eIH = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bcA = this.bcA;
                cVar.bcy = z;
                cVar.sex = this.sex;
                cVar.bcr = ba.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eHW = ba.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eHW = ba.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eIH.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aTC() || this.bcA) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eIH == null) {
                this.eIH = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bcA = this.bcA;
            aVar.sex = this.sex;
            aVar.bcy = z;
            aVar.bcr = ba.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eHW = ba.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eHX = forumDynamic.forum_name;
            aVar.akW = forumDynamic.is_like.intValue() == 1;
            aVar.eHY = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eIH.add(aVar);
            this.eIH.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        }
    }

    private void a(DealWindow dealWindow, boolean z) {
        if (dealWindow != null && !y.t(dealWindow.list)) {
            this.eIC = new com.baidu.tieba.person.data.e(2);
            this.eIC.cuz = z;
            this.eIC.mUserData = this.mUserData;
            this.eIC.window = dealWindow;
        }
    }

    public void aTB() {
        this.eDq.clear();
        if (!y.t(this.eIz)) {
            this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
            j jVar = new j();
            jVar.ata = t.j.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds36);
            this.eDq.add(jVar);
            this.eDq.addAll(this.eIz);
            this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds20), t.d.cp_bg_line_d));
        }
        if (this.eIA != null) {
            this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
            this.eDq.add(this.eIA);
        }
        if (this.eIB != null) {
            this.eDq.add(this.eIB);
        }
        if (this.eIC != null && this.eIC.aSk()) {
            this.eIC.WC = this.eDq;
            this.eIC.aLC();
        }
        if (this.eID != null) {
            this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
            this.eDq.add(this.eID);
        }
        if (this.eIE != null) {
            this.eDq.add(this.eIE);
            this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        }
        this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.ata = t.j.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds36);
        this.eDq.add(jVar2);
        if (this.eIF != null) {
            this.eDq.add(this.eIF);
            this.eDq.add(bj(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), t.e.ds1), t.d.cp_bg_line_c));
        }
        if (this.eIG != null) {
            this.eDq.add(this.eIG);
        }
        if (!y.t(this.eIH)) {
            this.eDq.addAll(this.eIH);
        }
    }

    private boolean aTC() {
        if (this.bcA) {
            return false;
        }
        if (this.eIt == 3) {
            return true;
        }
        return this.eIt == 2 && !this.eIs;
    }

    private boolean aTD() {
        if (this.bcA) {
            return false;
        }
        if (this.eIu == 3) {
            return true;
        }
        return this.eIu == 2 && !this.eIs;
    }

    private com.baidu.tieba.personCenter.c.b bj(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.eyc = i;
        bVar.eDz = i2;
        return bVar;
    }

    public void aTE() {
        this.eIs = true;
        this.sex = 1;
        this.eIt = 1;
        this.eIu = 1;
        this.eIv = 1;
        this.eIw = 1;
        this.eIx = -1;
        this.eIy = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eIz != null) {
            this.eIz.clear();
        }
        this.eIz = null;
        this.eIA = null;
        this.eIB = null;
        this.eIC = null;
        this.eID = null;
        this.eIE = null;
        this.eIF = null;
        this.eIG = null;
        if (this.eIH != null) {
            this.eIH.clear();
        }
        this.eIH = null;
        this.eDq.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aTF() {
        return this.eIH;
    }

    public ArrayList<v> aoT() {
        return this.eDq;
    }
}
