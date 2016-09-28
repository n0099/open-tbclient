package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
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
    private boolean bcU;
    private ArrayList<v> eKD;
    private b eKE;
    private com.baidu.tieba.person.a.g eKF;
    private com.baidu.tieba.person.data.e eKG;
    private l eKH;
    private f eKI;
    private i eKJ;
    private h eKK;
    private ArrayList<v> eKL;
    private UserData mUserData;
    private boolean eKw = true;
    private int sex = 1;
    private int eKx = 1;
    private int eKy = 1;
    private int eKz = 1;
    private int eKA = 1;
    private int eKB = -1;
    private int eKC = -1;
    private boolean hasMore = true;
    private ArrayList<v> eFt = new ArrayList<>();

    public n(boolean z) {
        this.bcU = z;
    }

    public boolean axm() {
        return this.eKw;
    }

    public void iT(boolean z) {
        this.eKw = z;
    }

    public boolean aQi() {
        return this.bcU;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eKx = dataRes.user.priv_sets.like.intValue();
                    this.eKy = dataRes.user.priv_sets.post.intValue();
                    this.eKz = dataRes.user.priv_sets.group.intValue();
                    this.eKA = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eKw = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.isGodUser = true;
                this.eKD = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eKb = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eKD.add(dVar);
                    this.eKD.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
                }
                if (!y.t(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eKb = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eKD.add(dVar2);
                        this.eKD.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
                    }
                }
            }
            if (!y.t(dataRes.concerned_forum_list) && !this.bcU && !aTZ()) {
                cF(dataRes.concerned_forum_list);
            }
            if (this.eKF == null && this.bcU) {
                i(this.mUserData);
            }
            a(dataRes.window, this.bcU);
            if (!y.t(dataRes.video_page) && !aUa()) {
                a(dataRes.video_page, j);
            }
            if (this.eKI == null && !this.bcU) {
                a(dataRes.user);
            }
            if (this.eKJ == null && ((aTZ() || aUa()) && !this.bcU)) {
                this.eKJ = new i();
                this.eKJ.sex = this.sex;
                this.eKJ.eKp = aTZ();
                this.eKJ.eKq = aUa();
            }
            if (!y.t(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eKB != date.getDate();
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
                        this.eKB = date.getDate();
                    }
                }
            }
            if (this.eKK == null && y.t(this.eKL)) {
                this.eKK = new h();
                this.eKK.sex = this.sex;
                this.eKK.bcU = this.bcU;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !y.t(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eKI = new f();
            this.eKI.parserProtoBuf(user);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            this.eKF = new com.baidu.tieba.person.a.g();
            this.eKF.f(userData);
        }
    }

    public List<v> aTO() {
        if (this.eKF == null) {
            return null;
        }
        return this.eKF.getPhotoAlbum();
    }

    private void a(List<ThreadInfo> list, long j) {
        this.eKH = new l();
        this.eKH.uid = j;
        this.eKH.eKt = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && threadInfo.video_info != null) {
                k kVar = new k();
                kVar.Rb = threadInfo.video_info.thumbnail_url;
                kVar.title = threadInfo.title;
                kVar.fid = String.valueOf(threadInfo.fid);
                kVar.TB = String.valueOf(threadInfo.tid);
                kVar.postId = String.valueOf(threadInfo.post_id);
                this.eKH.eKt.add(kVar);
            }
        }
    }

    private void cF(List<ForumDynamic> list) {
        this.eKE = new b();
        this.eKE.eKe = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eKi = forumDynamic.user_thread_count.intValue();
                this.eKE.eKe.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aUa() || this.bcU) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eKL == null) {
                this.eKL = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eKC);
            this.eKC = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bcT = true;
            cardPersonDynamicThreadData.bcU = this.bcU;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bcS = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eKL.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!y.t(list)) {
                if (this.eKL == null) {
                    this.eKL = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bcU = this.bcU;
                cVar.bcS = z;
                cVar.sex = this.sex;
                cVar.bcL = az.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eKa = az.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eKa = az.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eKL.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aTZ() || this.bcU) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eKL == null) {
                this.eKL = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bcU = this.bcU;
            aVar.sex = this.sex;
            aVar.bcS = z;
            aVar.bcL = az.M(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eKa = az.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eKb = forumDynamic.forum_name;
            aVar.akC = forumDynamic.is_like.intValue() == 1;
            aVar.eKc = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eKL.add(aVar);
            this.eKL.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
    }

    private void a(DealWindow dealWindow, boolean z) {
        if (dealWindow != null && !y.t(dealWindow.list)) {
            this.eKG = new com.baidu.tieba.person.data.e(2);
            this.eKG.cuW = z;
            this.eKG.mUserData = this.mUserData;
            this.eKG.window = dealWindow;
        }
    }

    public void aTY() {
        this.eFt.clear();
        if (!y.t(this.eKD)) {
            this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            j jVar = new j();
            jVar.eFF = r.j.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
            this.eFt.add(jVar);
            this.eFt.addAll(this.eKD);
            this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
        }
        if (this.eKE != null) {
            this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            this.eFt.add(this.eKE);
        }
        if (this.eKF != null) {
            this.eFt.add(this.eKF);
        }
        if (this.eKG != null && this.eKG.aSI()) {
            this.eKG.WM = this.eFt;
            this.eKG.aMe();
        }
        if (this.eKH != null) {
            this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            this.eFt.add(this.eKH);
        }
        if (this.eKI != null) {
            this.eFt.add(this.eKI);
            this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
        this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.eFF = r.j.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
        this.eFt.add(jVar2);
        if (this.eKJ != null) {
            this.eFt.add(this.eKJ);
            this.eFt.add(bl(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
        if (this.eKK != null) {
            this.eFt.add(this.eKK);
        }
        if (!y.t(this.eKL)) {
            this.eFt.addAll(this.eKL);
        }
    }

    private boolean aTZ() {
        if (this.bcU) {
            return false;
        }
        if (this.eKx == 3) {
            return true;
        }
        return this.eKx == 2 && !this.eKw;
    }

    private boolean aUa() {
        if (this.bcU) {
            return false;
        }
        if (this.eKy == 3) {
            return true;
        }
        return this.eKy == 2 && !this.eKw;
    }

    private com.baidu.tieba.personCenter.c.b bl(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.eAj = i;
        bVar.eFC = i2;
        return bVar;
    }

    public void aUb() {
        this.eKw = true;
        this.sex = 1;
        this.eKx = 1;
        this.eKy = 1;
        this.eKz = 1;
        this.eKA = 1;
        this.eKB = -1;
        this.eKC = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eKD != null) {
            this.eKD.clear();
        }
        this.eKD = null;
        this.eKE = null;
        this.eKF = null;
        this.eKG = null;
        this.eKH = null;
        this.eKI = null;
        this.eKJ = null;
        this.eKK = null;
        if (this.eKL != null) {
            this.eKL.clear();
        }
        this.eKL = null;
        this.eFt.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aUc() {
        return this.eKL;
    }

    public ArrayList<v> aph() {
        return this.eFt;
    }
}
