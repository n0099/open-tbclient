package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.x;
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
    private boolean bfT;
    private ArrayList<v> eRb;
    private b eRc;
    private com.baidu.tieba.person.a.g eRd;
    private com.baidu.tieba.person.data.e eRe;
    private l eRf;
    private f eRg;
    private i eRh;
    private h eRi;
    private ArrayList<v> eRj;
    private UserData mUserData;
    private boolean eQU = true;
    private int sex = 1;
    private int eQV = 1;
    private int eQW = 1;
    private int eQX = 1;
    private int eQY = 1;
    private int eQZ = -1;
    private int eRa = -1;
    private boolean hasMore = true;
    private ArrayList<v> eLS = new ArrayList<>();

    public n(boolean z) {
        this.bfT = z;
    }

    public boolean azj() {
        return this.eQU;
    }

    public void jt(boolean z) {
        this.eQU = z;
    }

    public boolean aSh() {
        return this.bfT;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eQV = dataRes.user.priv_sets.like.intValue();
                    this.eQW = dataRes.user.priv_sets.post.intValue();
                    this.eQX = dataRes.user.priv_sets.group.intValue();
                    this.eQY = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eQU = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eRb = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eQz = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eRb.add(dVar);
                    this.eRb.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
                }
                if (!x.t(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eQz = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eRb.add(dVar2);
                        this.eRb.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
                    }
                }
            }
            if (!x.t(dataRes.concerned_forum_list) && !this.bfT && !aWg()) {
                cH(dataRes.concerned_forum_list);
            }
            if (this.eRd == null && this.bfT) {
                i(this.mUserData);
            }
            a(dataRes.window, this.bfT);
            if (!x.t(dataRes.video_page) && !aWh()) {
                a(dataRes.video_page, j);
            }
            if (this.eRg == null && !this.bfT) {
                a(dataRes.user);
            }
            if (this.eRh == null && ((aWg() || aWh()) && !this.bfT)) {
                this.eRh = new i();
                this.eRh.sex = this.sex;
                this.eRh.eQN = aWg();
                this.eRh.eQO = aWh();
            }
            if (!x.t(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eQZ != date.getDate();
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
                        this.eQZ = date.getDate();
                    }
                }
            }
            if (this.eRi == null && x.t(this.eRj)) {
                this.eRi = new h();
                this.eRi.sex = this.sex;
                this.eRi.bfT = this.bfT;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !x.t(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eRg = new f();
            this.eRg.parserProtoBuf(user);
        }
    }

    private void i(UserData userData) {
        if (userData != null) {
            this.eRd = new com.baidu.tieba.person.a.g();
            this.eRd.f(userData);
        }
    }

    public List<v> aVV() {
        if (this.eRd == null) {
            return null;
        }
        return this.eRd.getPhotoAlbum();
    }

    private void a(List<ThreadInfo> list, long j) {
        this.eRf = new l();
        this.eRf.uid = j;
        this.eRf.eQR = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && threadInfo.video_info != null) {
                k kVar = new k();
                kVar.Rw = threadInfo.video_info.thumbnail_url;
                kVar.title = threadInfo.title;
                kVar.fid = String.valueOf(threadInfo.fid);
                kVar.TY = String.valueOf(threadInfo.tid);
                kVar.postId = String.valueOf(threadInfo.post_id);
                this.eRf.eQR.add(kVar);
            }
        }
    }

    private void cH(List<ForumDynamic> list) {
        this.eRc = new b();
        this.eRc.eQC = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eQG = forumDynamic.user_thread_count.intValue();
                this.eRc.eQC.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aWh() || this.bfT) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eRj == null) {
                this.eRj = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eRa);
            this.eRa = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bfS = true;
            cardPersonDynamicThreadData.bfT = this.bfT;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bfR = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eRj.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.t(list)) {
                if (this.eRj == null) {
                    this.eRj = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bfT = this.bfT;
                cVar.bfR = z;
                cVar.sex = this.sex;
                cVar.bfK = ax.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eQy = ax.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eQy = ax.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eRj.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aWg() || this.bfT) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eRj == null) {
                this.eRj = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bfT = this.bfT;
            aVar.sex = this.sex;
            aVar.bfR = z;
            aVar.bfK = ax.L(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eQy = ax.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eQz = forumDynamic.forum_name;
            aVar.alx = forumDynamic.is_like.intValue() == 1;
            aVar.eQA = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eRj.add(aVar);
            this.eRj.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
    }

    private void a(DealWindow dealWindow, boolean z) {
        if (dealWindow != null && !x.t(dealWindow.list)) {
            this.eRe = new com.baidu.tieba.person.data.e(2);
            this.eRe.cAf = z;
            this.eRe.mUserData = this.mUserData;
            this.eRe.window = dealWindow;
        }
    }

    public void aWf() {
        this.eLS.clear();
        if (!x.t(this.eRb)) {
            this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            j jVar = new j();
            jVar.eMe = r.j.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
            this.eLS.add(jVar);
            this.eLS.addAll(this.eRb);
            this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
        }
        if (this.eRc != null) {
            this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            this.eLS.add(this.eRc);
        }
        if (this.eRd != null) {
            this.eLS.add(this.eRd);
        }
        if (this.eRe != null && this.eRe.aUP()) {
            this.eRe.Xk = this.eLS;
            this.eRe.aNX();
        }
        if (this.eRf != null) {
            this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            this.eLS.add(this.eRf);
        }
        if (this.eRg != null) {
            this.eLS.add(this.eRg);
            this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
        this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.eMe = r.j.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
        this.eLS.add(jVar2);
        if (this.eRh != null) {
            this.eLS.add(this.eRh);
            this.eLS.add(bm(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
        if (this.eRi != null) {
            this.eLS.add(this.eRi);
        }
        if (!x.t(this.eRj)) {
            this.eLS.addAll(this.eRj);
        }
    }

    private boolean aWg() {
        if (this.bfT) {
            return false;
        }
        if (this.eQV == 3) {
            return true;
        }
        return this.eQV == 2 && !this.eQU;
    }

    private boolean aWh() {
        if (this.bfT) {
            return false;
        }
        if (this.eQW == 3) {
            return true;
        }
        return this.eQW == 2 && !this.eQU;
    }

    private com.baidu.tieba.personCenter.c.b bm(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.eGS = i;
        bVar.eMb = i2;
        return bVar;
    }

    public void aWi() {
        this.eQU = true;
        this.sex = 1;
        this.eQV = 1;
        this.eQW = 1;
        this.eQX = 1;
        this.eQY = 1;
        this.eQZ = -1;
        this.eRa = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eRb != null) {
            this.eRb.clear();
        }
        this.eRb = null;
        this.eRc = null;
        this.eRd = null;
        this.eRe = null;
        this.eRf = null;
        this.eRg = null;
        this.eRh = null;
        this.eRi = null;
        if (this.eRj != null) {
            this.eRj.clear();
        }
        this.eRj = null;
        this.eLS.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aWj() {
        return this.eRj;
    }

    public ArrayList<v> ard() {
        return this.eLS;
    }
}
