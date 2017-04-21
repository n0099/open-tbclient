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
    private boolean bjz;
    private ArrayList<v> eIi;
    private b eIj;
    private com.baidu.tieba.person.a.g eIk;
    private l eIl;
    private f eIm;
    private i eIn;
    private h eIo;
    private ArrayList<v> eIp;
    private UserData mUserData;
    private boolean eIb = true;
    private int sex = 1;
    private int eIc = 1;
    private int eId = 1;
    private int eIe = 1;
    private int eIf = 1;
    private int eIg = -1;
    private int eIh = -1;
    private boolean hasMore = true;
    private ArrayList<v> eCV = new ArrayList<>();

    public n(boolean z) {
        this.bjz = z;
    }

    public boolean avd() {
        return this.eIb;
    }

    public void jw(boolean z) {
        this.eIb = z;
    }

    public boolean NP() {
        return this.bjz;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eIc = dataRes.user.priv_sets.like.intValue();
                    this.eId = dataRes.user.priv_sets.post.intValue();
                    this.eIe = dataRes.user.priv_sets.group.intValue();
                    this.eIf = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eIb = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eIi = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eHG = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eIi.add(dVar);
                    this.eIi.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
                }
                if (!x.q(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eHG = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eIi.add(dVar2);
                        this.eIi.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
                    }
                }
            }
            if (!x.q(dataRes.concerned_forum_list) && !this.bjz && !aSB()) {
                cj(dataRes.concerned_forum_list);
            }
            if (this.eIk == null && this.bjz) {
                g(this.mUserData);
            }
            if (this.eIm == null && !this.bjz) {
                a(dataRes.user);
            }
            if (this.eIn == null && ((aSB() || aSC()) && !this.bjz)) {
                this.eIn = new i();
                this.eIn.sex = this.sex;
                this.eIn.eHU = aSB();
                this.eIn.eHV = aSC();
            }
            if (!x.q(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eIg != date.getDate();
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
                        this.eIg = date.getDate();
                    }
                }
            }
            if (this.eIo == null && x.q(this.eIp)) {
                this.eIo = new h();
                this.eIo.sex = this.sex;
                this.eIo.bjz = this.bjz;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !x.q(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eIm = new f();
            this.eIm.parserProtoBuf(user);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            this.eIk = new com.baidu.tieba.person.a.g();
            this.eIk.d(userData);
        }
    }

    public List<v> aSr() {
        if (this.eIk == null) {
            return null;
        }
        return this.eIk.getPhotoAlbum();
    }

    private void cj(List<ForumDynamic> list) {
        this.eIj = new b();
        this.eIj.eHJ = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eHN = forumDynamic.user_thread_count.intValue();
                this.eIj.eHJ.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aSC() || this.bjz) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eIp == null) {
                this.eIp = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eIh);
            this.eIh = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.byh = true;
            cardPersonDynamicThreadData.bjz = this.bjz;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.byg = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eIp.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!x.q(list)) {
                if (this.eIp == null) {
                    this.eIp = new ArrayList<>();
                }
                c cVar = new c();
                cVar.bjz = this.bjz;
                cVar.byg = z;
                cVar.sex = this.sex;
                cVar.bxZ = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eHF = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eHF = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eIp.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aSB() || this.bjz) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eIp == null) {
                this.eIp = new ArrayList<>();
            }
            a aVar = new a();
            aVar.bjz = this.bjz;
            aVar.sex = this.sex;
            aVar.byg = z;
            aVar.bxZ = au.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eHF = au.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eHG = forumDynamic.forum_name;
            aVar.isAttention = forumDynamic.is_like.intValue() == 1;
            aVar.eHH = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eIp.add(aVar);
            this.eIp.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
    }

    public void aSA() {
        this.eCV.clear();
        if (!x.q(this.eIi)) {
            this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            j jVar = new j();
            jVar.titleId = w.l.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
            this.eCV.add(jVar);
            this.eCV.addAll(this.eIi);
            this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds20), w.e.cp_bg_line_d));
        }
        if (this.eIj != null) {
            this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            this.eCV.add(this.eIj);
        }
        if (this.eIk != null) {
            this.eCV.add(this.eIk);
        }
        if (this.eIl != null) {
            this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
            this.eCV.add(this.eIl);
        }
        if (this.eIm != null) {
            this.eCV.add(this.eIm);
            this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
        this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.titleId = w.l.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds36);
        this.eCV.add(jVar2);
        if (this.eIn != null) {
            this.eCV.add(this.eIn);
            this.eCV.add(ba(com.baidu.adp.lib.util.k.g(TbadkCoreApplication.m9getInst().getApplicationContext(), w.f.ds1), w.e.cp_bg_line_c));
        }
        if (this.eIo != null) {
            this.eCV.add(this.eIo);
        }
        if (!x.q(this.eIp)) {
            this.eCV.addAll(this.eIp);
        }
    }

    private boolean aSB() {
        if (this.bjz) {
            return false;
        }
        if (this.eIc == 3) {
            return true;
        }
        return this.eIc == 2 && !this.eIb;
    }

    private boolean aSC() {
        if (this.bjz) {
            return false;
        }
        if (this.eId == 3) {
            return true;
        }
        return this.eId == 2 && !this.eIb;
    }

    private com.baidu.tieba.personCenter.c.b ba(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.eyx = i;
        bVar.eDi = i2;
        return bVar;
    }

    public void aSD() {
        this.eIb = true;
        this.sex = 1;
        this.eIc = 1;
        this.eId = 1;
        this.eIe = 1;
        this.eIf = 1;
        this.eIg = -1;
        this.eIh = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eIi != null) {
            this.eIi.clear();
        }
        this.eIi = null;
        this.eIj = null;
        this.eIk = null;
        this.eIl = null;
        this.eIm = null;
        this.eIn = null;
        this.eIo = null;
        if (this.eIp != null) {
            this.eIp.clear();
        }
        this.eIp = null;
        this.eCV.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aSE() {
        return this.eIp;
    }

    public ArrayList<v> amU() {
        return this.eCV;
    }
}
