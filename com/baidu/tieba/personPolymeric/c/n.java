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
    private boolean bhu;
    private ArrayList<v> eHX;
    private b eHY;
    private com.baidu.tieba.person.a.g eHZ;
    private l eIa;
    private f eIb;
    private i eIc;
    private h eId;
    private ArrayList<v> eIe;
    private UserData mUserData;
    private boolean eHQ = true;
    private int sex = 1;
    private int eHR = 1;
    private int eHS = 1;
    private int eHT = 1;
    private int eHU = 1;
    private int eHV = -1;
    private int eHW = -1;
    private boolean hasMore = true;
    private ArrayList<v> eCI = new ArrayList<>();

    public n(boolean z) {
        this.bhu = z;
    }

    public boolean auj() {
        return this.eHQ;
    }

    public void jn(boolean z) {
        this.eHQ = z;
    }

    public boolean Nj() {
        return this.bhu;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eHR = dataRes.user.priv_sets.like.intValue();
                    this.eHS = dataRes.user.priv_sets.post.intValue();
                    this.eHT = dataRes.user.priv_sets.group.intValue();
                    this.eHU = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eHQ = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eHX = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eHu = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eHX.add(dVar);
                    this.eHX.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
                }
                if (!x.q(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eHu = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eHX.add(dVar2);
                        this.eHX.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
                    }
                }
            }
            if (!x.q(dataRes.concerned_forum_list) && !this.bhu && !aRr()) {
                cj(dataRes.concerned_forum_list);
            }
            if (this.eHZ == null && this.bhu) {
                g(this.mUserData);
            }
            if (this.eIb == null && !this.bhu) {
                a(dataRes.user);
            }
            if (this.eIc == null && ((aRr() || aRs()) && !this.bhu)) {
                this.eIc = new i();
                this.eIc.sex = this.sex;
                this.eIc.eHI = aRr();
                this.eIc.eHJ = aRs();
            }
            if (!x.q(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eHV != date.getDate();
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
                        this.eHV = date.getDate();
                    }
                }
            }
            if (this.eId == null && x.q(this.eIe)) {
                this.eId = new h();
                this.eId.sex = this.sex;
                this.eId.bhu = this.bhu;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !x.q(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eIb = new f();
            this.eIb.parserProtoBuf(user);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            this.eHZ = new com.baidu.tieba.person.a.g();
            this.eHZ.d(userData);
        }
    }

    public List<v> aRh() {
        if (this.eHZ == null) {
            return null;
        }
        return this.eHZ.getPhotoAlbum();
    }

    private void cj(List<ForumDynamic> list) {
        this.eHY = new b();
        this.eHY.eHx = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eHB = forumDynamic.user_thread_count.intValue();
                this.eHY.eHx.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aRs() || this.bhu) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eIe == null) {
                this.eIe = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eHW);
            this.eHW = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bvX = true;
            cardPersonDynamicThreadData.bhu = this.bhu;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bvW = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eIe.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.q(list)) {
                if (this.eIe == null) {
                    this.eIe = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bhu = this.bhu;
                cVar.bvW = z;
                cVar.sex = this.sex;
                cVar.bvP = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eHt = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eHt = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eIe.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aRr() || this.bhu) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eIe == null) {
                this.eIe = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bhu = this.bhu;
            aVar.sex = this.sex;
            aVar.bvW = z;
            aVar.bvP = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eHt = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eHu = forumDynamic.forum_name;
            aVar.isAttention = forumDynamic.is_like.intValue() == 1;
            aVar.eHv = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eIe.add(aVar);
            this.eIe.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
    }

    public void aRq() {
        this.eCI.clear();
        if (!x.q(this.eHX)) {
            this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            j jVar = new j();
            jVar.eHL = w.l.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
            this.eCI.add(jVar);
            this.eCI.addAll(this.eHX);
            this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
        }
        if (this.eHY != null) {
            this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            this.eCI.add(this.eHY);
        }
        if (this.eHZ != null) {
            this.eCI.add(this.eHZ);
        }
        if (this.eIa != null) {
            this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            this.eCI.add(this.eIa);
        }
        if (this.eIb != null) {
            this.eCI.add(this.eIb);
            this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
        this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.eHL = w.l.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
        this.eCI.add(jVar2);
        if (this.eIc != null) {
            this.eCI.add(this.eIc);
            this.eCI.add(bg(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
        if (this.eId != null) {
            this.eCI.add(this.eId);
        }
        if (!x.q(this.eIe)) {
            this.eCI.addAll(this.eIe);
        }
    }

    private boolean aRr() {
        if (this.bhu) {
            return false;
        }
        if (this.eHR == 3) {
            return true;
        }
        return this.eHR == 2 && !this.eHQ;
    }

    private boolean aRs() {
        if (this.bhu) {
            return false;
        }
        if (this.eHS == 3) {
            return true;
        }
        return this.eHS == 2 && !this.eHQ;
    }

    private com.baidu.tieba.personCenter.c.b bg(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.eya = i;
        bVar.eCV = i2;
        return bVar;
    }

    public void aRt() {
        this.eHQ = true;
        this.sex = 1;
        this.eHR = 1;
        this.eHS = 1;
        this.eHT = 1;
        this.eHU = 1;
        this.eHV = -1;
        this.eHW = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eHX != null) {
            this.eHX.clear();
        }
        this.eHX = null;
        this.eHY = null;
        this.eHZ = null;
        this.eIa = null;
        this.eIb = null;
        this.eIc = null;
        this.eId = null;
        if (this.eIe != null) {
            this.eIe.clear();
        }
        this.eIe = null;
        this.eCI.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aRu() {
        return this.eIe;
    }

    public ArrayList<v> alZ() {
        return this.eCI;
    }
}
