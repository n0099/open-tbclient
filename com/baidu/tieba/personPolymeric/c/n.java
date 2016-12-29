package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import tbclient.DynamicInfo;
import tbclient.ForumDynamic;
import tbclient.Personal.DataRes;
import tbclient.Personal.ForumGodDetailInfo;
import tbclient.ThreadInfo;
import tbclient.User;
import tbclient.UserDynamic;
/* loaded from: classes.dex */
public class n {
    private boolean bfj;
    private ArrayList<v> euB;
    private b euC;
    private com.baidu.tieba.person.a.g euD;
    private l euE;
    private f euF;
    private i euG;
    private h euH;
    private ArrayList<v> euI;
    private UserData mUserData;
    private boolean euu = true;
    private int sex = 1;
    private int euv = 1;
    private int euw = 1;
    private int eux = 1;
    private int euy = 1;
    private int euz = -1;
    private int euA = -1;
    private boolean hasMore = true;
    private ArrayList<v> epo = new ArrayList<>();

    public n(boolean z) {
        this.bfj = z;
    }

    public boolean atI() {
        return this.euu;
    }

    public void je(boolean z) {
        this.euu = z;
    }

    public boolean aMb() {
        return this.bfj;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.euv = dataRes.user.priv_sets.like.intValue();
                    this.euw = dataRes.user.priv_sets.post.intValue();
                    this.eux = dataRes.user.priv_sets.group.intValue();
                    this.euy = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.euu = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.euB = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.etY = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.euB.add(dVar);
                    this.euB.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
                }
                if (!x.t(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.etY = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.euB.add(dVar2);
                        this.euB.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
                    }
                }
            }
            if (!x.t(dataRes.concerned_forum_list) && !this.bfj && !aPQ()) {
                cx(dataRes.concerned_forum_list);
            }
            if (this.euD == null && this.bfj) {
                g(this.mUserData);
            }
            if (!x.t(dataRes.video_page) && !aPR()) {
                a(dataRes.video_page, j);
            }
            if (this.euF == null && !this.bfj) {
                a(dataRes.user);
            }
            if (this.euG == null && ((aPQ() || aPR()) && !this.bfj)) {
                this.euG = new i();
                this.euG.sex = this.sex;
                this.euG.eum = aPQ();
                this.euG.eun = aPR();
            }
            if (!x.t(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.euz != date.getDate();
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
                        this.euz = date.getDate();
                    }
                }
            }
            if (this.euH == null && x.t(this.euI)) {
                this.euH = new h();
                this.euH.sex = this.sex;
                this.euH.bfj = this.bfj;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !x.t(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.euF = new f();
            this.euF.parserProtoBuf(user);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            this.euD = new com.baidu.tieba.person.a.g();
            this.euD.d(userData);
        }
    }

    public List<v> aPF() {
        if (this.euD == null) {
            return null;
        }
        return this.euD.getPhotoAlbum();
    }

    private void a(List<ThreadInfo> list, long j) {
        this.euE = new l();
        this.euE.uid = j;
        this.euE.eur = new ArrayList();
        for (ThreadInfo threadInfo : list) {
            if (threadInfo != null && threadInfo.video_info != null) {
                k kVar = new k();
                kVar.Rt = threadInfo.video_info.thumbnail_url;
                kVar.title = threadInfo.title;
                kVar.fid = String.valueOf(threadInfo.fid);
                kVar.Ty = String.valueOf(threadInfo.tid);
                kVar.postId = String.valueOf(threadInfo.post_id);
                this.euE.eur.add(kVar);
            }
        }
    }

    private void cx(List<ForumDynamic> list) {
        this.euC = new b();
        this.euC.eub = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.euf = forumDynamic.user_thread_count.intValue();
                this.euC.eub.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aPR() || this.bfj) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.euI == null) {
                this.euI = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.euA);
            this.euA = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bfi = true;
            cardPersonDynamicThreadData.bfj = this.bfj;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bfh = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.euI.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.t(list)) {
                if (this.euI == null) {
                    this.euI = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bfj = this.bfj;
                cVar.bfh = z;
                cVar.sex = this.sex;
                cVar.beZ = av.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.etX = av.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.etX = av.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.euI.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aPQ() || this.bfj) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.euI == null) {
                this.euI = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bfj = this.bfj;
            aVar.sex = this.sex;
            aVar.bfh = z;
            aVar.beZ = av.K(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.etX = av.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.etY = forumDynamic.forum_name;
            aVar.akY = forumDynamic.is_like.intValue() == 1;
            aVar.etZ = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.euI.add(aVar);
            this.euI.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
    }

    public void aPP() {
        this.epo.clear();
        if (!x.t(this.euB)) {
            this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            j jVar = new j();
            jVar.eup = r.j.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
            this.epo.add(jVar);
            this.epo.addAll(this.euB);
            this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds20), r.d.cp_bg_line_d));
        }
        if (this.euC != null) {
            this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            this.epo.add(this.euC);
        }
        if (this.euD != null) {
            this.epo.add(this.euD);
        }
        if (this.euE != null) {
            this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
            this.epo.add(this.euE);
        }
        if (this.euF != null) {
            this.epo.add(this.euF);
            this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
        this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.eup = r.j.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds36);
        this.epo.add(jVar2);
        if (this.euG != null) {
            this.epo.add(this.euG);
            this.epo.add(bb(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.e.ds1), r.d.cp_bg_line_c));
        }
        if (this.euH != null) {
            this.epo.add(this.euH);
        }
        if (!x.t(this.euI)) {
            this.epo.addAll(this.euI);
        }
    }

    private boolean aPQ() {
        if (this.bfj) {
            return false;
        }
        if (this.euv == 3) {
            return true;
        }
        return this.euv == 2 && !this.euu;
    }

    private boolean aPR() {
        if (this.bfj) {
            return false;
        }
        if (this.euw == 3) {
            return true;
        }
        return this.euw == 2 && !this.euu;
    }

    private com.baidu.tieba.personCenter.c.b bb(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.ekI = i;
        bVar.epz = i2;
        return bVar;
    }

    public void aPS() {
        this.euu = true;
        this.sex = 1;
        this.euv = 1;
        this.euw = 1;
        this.eux = 1;
        this.euy = 1;
        this.euz = -1;
        this.euA = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.euB != null) {
            this.euB.clear();
        }
        this.euB = null;
        this.euC = null;
        this.euD = null;
        this.euE = null;
        this.euF = null;
        this.euG = null;
        this.euH = null;
        if (this.euI != null) {
            this.euI.clear();
        }
        this.euI = null;
        this.epo.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aPT() {
        return this.euI;
    }

    public ArrayList<v> alF() {
        return this.epo;
    }
}
