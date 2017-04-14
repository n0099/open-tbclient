package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.w;
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
    private boolean bho;
    private ArrayList<v> eFS;
    private b eFT;
    private com.baidu.tieba.person.a.g eFU;
    private l eFV;
    private f eFW;
    private i eFX;
    private h eFY;
    private ArrayList<v> eFZ;
    private UserData mUserData;
    private boolean eFL = true;
    private int sex = 1;
    private int eFM = 1;
    private int eFN = 1;
    private int eFO = 1;
    private int eFP = 1;
    private int eFQ = -1;
    private int eFR = -1;
    private boolean hasMore = true;
    private ArrayList<v> eAF = new ArrayList<>();

    public n(boolean z) {
        this.bho = z;
    }

    public boolean auc() {
        return this.eFL;
    }

    public void jm(boolean z) {
        this.eFL = z;
    }

    public boolean NH() {
        return this.bho;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eFM = dataRes.user.priv_sets.like.intValue();
                    this.eFN = dataRes.user.priv_sets.post.intValue();
                    this.eFO = dataRes.user.priv_sets.group.intValue();
                    this.eFP = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eFL = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eFS = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eFq = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eFS.add(dVar);
                    this.eFS.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
                }
                if (!x.q(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eFq = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eFS.add(dVar2);
                        this.eFS.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
                    }
                }
            }
            if (!x.q(dataRes.concerned_forum_list) && !this.bho && !aRA()) {
                ci(dataRes.concerned_forum_list);
            }
            if (this.eFU == null && this.bho) {
                g(this.mUserData);
            }
            if (this.eFW == null && !this.bho) {
                a(dataRes.user);
            }
            if (this.eFX == null && ((aRA() || aRB()) && !this.bho)) {
                this.eFX = new i();
                this.eFX.sex = this.sex;
                this.eFX.eFE = aRA();
                this.eFX.eFF = aRB();
            }
            if (!x.q(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eFQ != date.getDate();
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
                        this.eFQ = date.getDate();
                    }
                }
            }
            if (this.eFY == null && x.q(this.eFZ)) {
                this.eFY = new h();
                this.eFY.sex = this.sex;
                this.eFY.bho = this.bho;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !x.q(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eFW = new f();
            this.eFW.parserProtoBuf(user);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            this.eFU = new com.baidu.tieba.person.a.g();
            this.eFU.d(userData);
        }
    }

    public List<v> aRq() {
        if (this.eFU == null) {
            return null;
        }
        return this.eFU.getPhotoAlbum();
    }

    private void ci(List<ForumDynamic> list) {
        this.eFT = new b();
        this.eFT.eFt = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eFx = forumDynamic.user_thread_count.intValue();
                this.eFT.eFt.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aRB() || this.bho) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eFZ == null) {
                this.eFZ = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eFR);
            this.eFR = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bvQ = true;
            cardPersonDynamicThreadData.bho = this.bho;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bvP = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eFZ.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.q(list)) {
                if (this.eFZ == null) {
                    this.eFZ = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bho = this.bho;
                cVar.bvP = z;
                cVar.sex = this.sex;
                cVar.bvI = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eFp = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eFp = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eFZ.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aRA() || this.bho) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eFZ == null) {
                this.eFZ = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bho = this.bho;
            aVar.sex = this.sex;
            aVar.bvP = z;
            aVar.bvI = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eFp = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eFq = forumDynamic.forum_name;
            aVar.isAttention = forumDynamic.is_like.intValue() == 1;
            aVar.eFr = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eFZ.add(aVar);
            this.eFZ.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
    }

    public void aRz() {
        this.eAF.clear();
        if (!x.q(this.eFS)) {
            this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            j jVar = new j();
            jVar.titleId = w.l.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
            this.eAF.add(jVar);
            this.eAF.addAll(this.eFS);
            this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
        }
        if (this.eFT != null) {
            this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            this.eAF.add(this.eFT);
        }
        if (this.eFU != null) {
            this.eAF.add(this.eFU);
        }
        if (this.eFV != null) {
            this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            this.eAF.add(this.eFV);
        }
        if (this.eFW != null) {
            this.eAF.add(this.eFW);
            this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
        this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.titleId = w.l.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
        this.eAF.add(jVar2);
        if (this.eFX != null) {
            this.eAF.add(this.eFX);
            this.eAF.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
        if (this.eFY != null) {
            this.eAF.add(this.eFY);
        }
        if (!x.q(this.eFZ)) {
            this.eAF.addAll(this.eFZ);
        }
    }

    private boolean aRA() {
        if (this.bho) {
            return false;
        }
        if (this.eFM == 3) {
            return true;
        }
        return this.eFM == 2 && !this.eFL;
    }

    private boolean aRB() {
        if (this.bho) {
            return false;
        }
        if (this.eFN == 3) {
            return true;
        }
        return this.eFN == 2 && !this.eFL;
    }

    private com.baidu.tieba.personCenter.c.b ba(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.ewf = i;
        bVar.eAS = i2;
        return bVar;
    }

    public void aRC() {
        this.eFL = true;
        this.sex = 1;
        this.eFM = 1;
        this.eFN = 1;
        this.eFO = 1;
        this.eFP = 1;
        this.eFQ = -1;
        this.eFR = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eFS != null) {
            this.eFS.clear();
        }
        this.eFS = null;
        this.eFT = null;
        this.eFU = null;
        this.eFV = null;
        this.eFW = null;
        this.eFX = null;
        this.eFY = null;
        if (this.eFZ != null) {
            this.eFZ.clear();
        }
        this.eFZ = null;
        this.eAF.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aRD() {
        return this.eFZ;
    }

    public ArrayList<v> alT() {
        return this.eAF;
    }
}
