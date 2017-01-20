package com.baidu.tieba.personPolymeric.c;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyGiftListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.w;
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
    private boolean baK;
    private i eEA;
    private h eEB;
    private ArrayList<v> eEC;
    private ArrayList<v> eEv;
    private b eEw;
    private com.baidu.tieba.person.a.g eEx;
    private l eEy;
    private f eEz;
    private UserData mUserData;
    private boolean eEo = true;
    private int sex = 1;
    private int eEp = 1;
    private int eEq = 1;
    private int eEr = 1;
    private int eEs = 1;
    private int eEt = -1;
    private int eEu = -1;
    private boolean hasMore = true;
    private ArrayList<v> ezj = new ArrayList<>();

    public n(boolean z) {
        this.baK = z;
    }

    public boolean auO() {
        return this.eEo;
    }

    public void jq(boolean z) {
        this.eEo = z;
    }

    public boolean Mw() {
        return this.baK;
    }

    public void a(DataRes dataRes, long j) {
        if (dataRes != null) {
            this.hasMore = dataRes.has_more.intValue() == 1;
            if (dataRes.user != null) {
                this.mUserData = new UserData();
                this.mUserData.parserProtobuf(dataRes.user);
                if (dataRes.user.priv_sets != null) {
                    this.eEp = dataRes.user.priv_sets.like.intValue();
                    this.eEq = dataRes.user.priv_sets.post.intValue();
                    this.eEr = dataRes.user.priv_sets.group.intValue();
                    this.eEs = dataRes.user.priv_sets.friend.intValue();
                }
                this.sex = dataRes.user.sex.intValue();
                this.eEo = dataRes.user.is_friend.intValue() == 1;
            }
            if (dataRes.user_god_info != null && dataRes.user_god_info.god_type.intValue() == 2) {
                this.mUserData.setIsGod(true);
                this.eEv = new ArrayList<>();
                if (dataRes.user != null && dataRes.user.tb_vip != null) {
                    d dVar = new d();
                    dVar.iconUrl = dataRes.user.tb_vip.v_url;
                    dVar.eDS = dataRes.user.tb_vip.intro;
                    dVar.des = "";
                    this.eEv.add(dVar);
                    this.eEv.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_d));
                }
                if (!w.s(dataRes.user_god_info.forum_god_list)) {
                    for (ForumGodDetailInfo forumGodDetailInfo : dataRes.user_god_info.forum_god_list) {
                        d dVar2 = new d();
                        dVar2.eDS = forumGodDetailInfo.forum_name;
                        dVar2.des = forumGodDetailInfo.intro;
                        this.eEv.add(dVar2);
                        this.eEv.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_d));
                    }
                }
            }
            if (!w.s(dataRes.concerned_forum_list) && !this.baK && !aRO()) {
                cC(dataRes.concerned_forum_list);
            }
            if (this.eEx == null && this.baK) {
                g(this.mUserData);
            }
            if (this.eEz == null && !this.baK) {
                a(dataRes.user);
            }
            if (this.eEA == null && ((aRO() || aRP()) && !this.baK)) {
                this.eEA = new i();
                this.eEA.sex = this.sex;
                this.eEA.eEg = aRO();
                this.eEA.eEh = aRP();
            }
            if (!w.s(dataRes.dynamic_list)) {
                Random random = new Random();
                Date date = new Date();
                for (DynamicInfo dynamicInfo : dataRes.dynamic_list) {
                    if (dynamicInfo != null && dynamicInfo.dynamic_timestamp.longValue() >= 0) {
                        date.setTime(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                        boolean z = this.eEt != date.getDate();
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
                        this.eEt = date.getDate();
                    }
                }
            }
            if (this.eEB == null && w.s(this.eEC)) {
                this.eEB = new h();
                this.eEB.sex = this.sex;
                this.eEB.baK = this.baK;
                this.hasMore = false;
            }
        }
    }

    private void a(User user) {
        if (user != null && !w.s(user.gift_list) && TbadkCoreApplication.m9getInst().appResponseToIntentClass(MyGiftListActivityConfig.class)) {
            this.eEz = new f();
            this.eEz.parserProtoBuf(user);
        }
    }

    private void g(UserData userData) {
        if (userData != null) {
            this.eEx = new com.baidu.tieba.person.a.g();
            this.eEx.d(userData);
        }
    }

    public List<v> aRE() {
        if (this.eEx == null) {
            return null;
        }
        return this.eEx.getPhotoAlbum();
    }

    private void cC(List<ForumDynamic> list) {
        this.eEw = new b();
        this.eEw.eDV = new ArrayList();
        for (ForumDynamic forumDynamic : list) {
            if (forumDynamic != null) {
                e eVar = new e();
                eVar.forumId = forumDynamic.forum_id.longValue();
                eVar.forumName = forumDynamic.forum_name;
                eVar.avatar = forumDynamic.avatar;
                eVar.sex = this.sex;
                eVar.eDZ = forumDynamic.user_thread_count.intValue();
                this.eEw.eDV.add(eVar);
            }
        }
    }

    private void a(DynamicInfo dynamicInfo, Random random, boolean z) {
        ThreadInfo threadInfo;
        if ((!aRP() || this.baK) && (threadInfo = dynamicInfo.thread_dynamic) != null) {
            if (this.eEC == null) {
                this.eEC = new ArrayList<>();
            }
            int random2 = UtilHelper.getRandom(random, 3, this.eEu);
            this.eEu = random2;
            CardPersonDynamicThreadData cardPersonDynamicThreadData = new CardPersonDynamicThreadData();
            cardPersonDynamicThreadData.bpc = true;
            cardPersonDynamicThreadData.baK = this.baK;
            cardPersonDynamicThreadData.sex = this.sex;
            cardPersonDynamicThreadData.bpb = z;
            cardPersonDynamicThreadData.a(threadInfo, random2, dynamicInfo.dynamic_timestamp.longValue());
            this.eEC.add(cardPersonDynamicThreadData);
        }
    }

    private void a(DynamicInfo dynamicInfo, boolean z) {
        UserDynamic userDynamic = dynamicInfo.user_dynamic;
        if (userDynamic != null) {
            List<User> list = userDynamic.concerned_user_list;
            if (!w.s(list)) {
                if (this.eEC == null) {
                    this.eEC = new ArrayList<>();
                }
                c cVar = new c();
                cVar.baK = this.baK;
                cVar.bpb = z;
                cVar.sex = this.sex;
                cVar.boU = at.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eDR = at.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.eDR = at.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
                cVar.users = new ArrayList();
                for (User user : list) {
                    if (user != null) {
                        UserData userData = new UserData();
                        userData.parserProtobuf(user);
                        cVar.users.add(userData);
                    }
                }
                this.eEC.add(cVar);
            }
        }
    }

    private void b(DynamicInfo dynamicInfo, boolean z) {
        ForumDynamic forumDynamic;
        if ((!aRO() || this.baK) && (forumDynamic = dynamicInfo.forum_dynamic) != null) {
            if (this.eEC == null) {
                this.eEC = new ArrayList<>();
            }
            a aVar = new a();
            aVar.baK = this.baK;
            aVar.sex = this.sex;
            aVar.bpb = z;
            aVar.boU = at.J(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.eDR = at.I(dynamicInfo.dynamic_timestamp.longValue() * 1000);
            aVar.forumId = forumDynamic.forum_id.longValue();
            aVar.avatar = forumDynamic.avatar;
            aVar.eDS = forumDynamic.forum_name;
            aVar.isAttention = forumDynamic.is_like.intValue() == 1;
            aVar.eDT = forumDynamic.member_count.intValue();
            aVar.postNum = forumDynamic.thread_count.intValue();
            this.eEC.add(aVar);
            this.eEC.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        }
    }

    public void aRN() {
        this.ezj.clear();
        if (!w.s(this.eEv)) {
            this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
            j jVar = new j();
            jVar.eEj = r.l.person_polymeric_auth_title;
            jVar.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds32);
            jVar.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds36);
            jVar.paddingBottom = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds36);
            this.ezj.add(jVar);
            this.ezj.addAll(this.eEv);
            this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds20), r.e.cp_bg_line_d));
        }
        if (this.eEw != null) {
            this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
            this.ezj.add(this.eEw);
        }
        if (this.eEx != null) {
            this.ezj.add(this.eEx);
        }
        if (this.eEy != null) {
            this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
            this.ezj.add(this.eEy);
        }
        if (this.eEz != null) {
            this.ezj.add(this.eEz);
            this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        }
        this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        j jVar2 = new j();
        jVar2.eEj = r.l.person_polymeric_dynamic_title;
        jVar2.paddingLeft = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds32);
        jVar2.paddingTop = com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds36);
        this.ezj.add(jVar2);
        if (this.eEA != null) {
            this.ezj.add(this.eEA);
            this.ezj.add(bc(com.baidu.adp.lib.util.k.e(TbadkCoreApplication.m9getInst().getApplicationContext(), r.f.ds1), r.e.cp_bg_line_c));
        }
        if (this.eEB != null) {
            this.ezj.add(this.eEB);
        }
        if (!w.s(this.eEC)) {
            this.ezj.addAll(this.eEC);
        }
    }

    private boolean aRO() {
        if (this.baK) {
            return false;
        }
        if (this.eEp == 3) {
            return true;
        }
        return this.eEp == 2 && !this.eEo;
    }

    private boolean aRP() {
        if (this.baK) {
            return false;
        }
        if (this.eEq == 3) {
            return true;
        }
        return this.eEq == 2 && !this.eEo;
    }

    private com.baidu.tieba.personCenter.c.b bc(int i, int i2) {
        com.baidu.tieba.personCenter.c.b bVar = new com.baidu.tieba.personCenter.c.b();
        bVar.euD = i;
        bVar.ezw = i2;
        return bVar;
    }

    public void aRQ() {
        this.eEo = true;
        this.sex = 1;
        this.eEp = 1;
        this.eEq = 1;
        this.eEr = 1;
        this.eEs = 1;
        this.eEt = -1;
        this.eEu = -1;
        this.hasMore = true;
        this.mUserData = null;
        if (this.eEv != null) {
            this.eEv.clear();
        }
        this.eEv = null;
        this.eEw = null;
        this.eEx = null;
        this.eEy = null;
        this.eEz = null;
        this.eEA = null;
        this.eEB = null;
        if (this.eEC != null) {
            this.eEC.clear();
        }
        this.eEC = null;
        this.ezj.clear();
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public UserData getUserData() {
        return this.mUserData;
    }

    public ArrayList<v> aRR() {
        return this.eEC;
    }

    public ArrayList<v> amM() {
        return this.ezj;
    }
}
