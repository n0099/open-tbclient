package com.baidu.tieba.recommendfrs.control.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.z;
import com.baidu.tieba.tbadkCore.ag;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardGod;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e {
    public static void a(DataRes.Builder builder) {
        if (builder != null) {
            y.o(builder.resource_list);
            y.o(builder.card_forum);
            y.o(builder.card_topic);
            if (builder.banner_list != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                y.o(builder2.app);
                builder.banner_list = builder2.build(false);
            }
            y.o(builder.card_god);
        }
    }

    public static void a(DataRes.Builder builder, DataRes.Builder builder2) {
        if (builder2 != null && builder != null) {
            if (builder2.card_forum != null && builder.card_forum != null) {
                builder.card_forum.addAll(builder2.card_forum);
            }
            if (builder2.card_topic != null && builder.card_topic != null) {
                builder.card_topic.addAll(builder2.card_topic);
            }
            if (builder2.resource_list != null && builder.resource_list != null) {
                builder.resource_list.addAll(builder2.resource_list);
            }
            if (builder2.banner_list != null) {
                BannerList.Builder builder3 = new BannerList.Builder(builder.banner_list);
                if (builder3.app == null) {
                    builder3.app = new LinkedList();
                }
                if (builder2.banner_list.app != null) {
                    builder3.app.addAll(builder2.banner_list.app);
                }
                builder.banner_list = builder3.build(false);
            }
            if (builder.age_sex == null) {
                builder.age_sex = builder2.age_sex;
                if (builder2.age_sex != null) {
                    com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("has_requested_new_user_guide", true);
                }
            }
            if (builder2.interestion != null && builder != null && builder.interestion != null && builder.interestion.size() == 0) {
                builder.interestion.addAll(builder2.interestion);
            }
            if (builder2.card_god != null) {
                builder.card_god.addAll(builder2.card_god);
            }
        }
    }

    public static List<z> b(DataRes.Builder builder) {
        com.baidu.tbadk.core.data.c LJ;
        com.baidu.tieba.recommendfrs.data.c bVar;
        if (builder == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (builder.card_topic != null) {
            for (CardTopic cardTopic : builder.card_topic) {
                com.baidu.tieba.recommendfrs.data.d dVar = new com.baidu.tieba.recommendfrs.data.d();
                dVar.a(cardTopic);
                if (y.p(dVar.aWv) > 3) {
                    linkedList.add(dVar);
                }
            }
        }
        if (builder.resource_list != null) {
            for (Resource resource : builder.resource_list) {
                com.baidu.tieba.recommendfrs.data.e eVar = new com.baidu.tieba.recommendfrs.data.e();
                eVar.a(resource);
                linkedList.add(eVar);
            }
        }
        if (builder.card_forum != null) {
            for (CardForum cardForum : builder.card_forum) {
                if (cardForum != null) {
                    if (com.baidu.tieba.recommendfrs.data.c.oB(cardForum.card_type.intValue())) {
                        bVar = new com.baidu.tieba.recommendfrs.data.f();
                    } else {
                        bVar = com.baidu.tieba.recommendfrs.data.c.oC(cardForum.card_type.intValue()) ? new com.baidu.tieba.recommendfrs.data.b() : null;
                    }
                    if (bVar != null) {
                        bVar.a(cardForum);
                        if (bVar.rk()) {
                            linkedList.add(bVar);
                        }
                    }
                }
            }
        }
        if (builder.banner_list != null && builder.banner_list.app != null) {
            for (App app : builder.banner_list.app) {
                com.baidu.tieba.recommendfrs.data.a aVar = new com.baidu.tieba.recommendfrs.data.a();
                aVar.b(app);
                if (aVar.getPosition() > 0 && (LJ = aVar.LJ()) != null) {
                    if (LJ.rl()) {
                        try {
                            if (!TextUtils.isEmpty(LJ.Se) && !ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), LJ.Se)) {
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (LJ.rk()) {
                        linkedList.add(aVar);
                    }
                }
            }
        }
        if (y.p(builder.card_god) != 0) {
            for (CardGod cardGod : builder.card_god) {
                com.baidu.tieba.recommendfrs.data.h hVar = new com.baidu.tieba.recommendfrs.data.h();
                hVar.a(cardGod);
                if (hVar.rk()) {
                    linkedList.add(hVar);
                }
            }
        }
        return linkedList;
    }

    public static void c(DataRes.Builder builder) {
        if (builder != null) {
            if (builder.thread_list == null) {
                builder.thread_list = new LinkedList();
            }
            if (builder.card_forum == null) {
                builder.card_forum = new LinkedList();
            }
            if (builder.card_topic == null) {
                builder.card_topic = new LinkedList();
            }
            if (builder.resource_list == null) {
                builder.resource_list = new LinkedList();
            }
            if (builder.thread_personalized == null) {
                builder.thread_personalized = new LinkedList();
            }
            if (builder.interestion == null) {
                builder.interestion = new LinkedList();
            }
            if (builder.card_god == null) {
                builder.card_god = new LinkedList();
            }
        }
    }

    public static com.baidu.tieba.card.a.c i(as asVar) {
        if (com.baidu.tieba.card.a.u.b(asVar)) {
            return new com.baidu.tieba.card.a.u(asVar);
        }
        if (com.baidu.tieba.card.a.v.b(asVar)) {
            return new com.baidu.tieba.card.a.v(asVar);
        }
        if (com.baidu.tieba.card.a.t.b(asVar)) {
            com.baidu.tieba.card.a.t tVar = new com.baidu.tieba.card.a.t();
            if (asVar.tq()) {
                tVar.aWd = true;
            } else {
                tVar.aWd = false;
            }
            tVar.aVJ = asVar;
            return tVar;
        }
        return null;
    }

    public static void d(DataRes.Builder builder) {
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && y.p(builder.thread_list) != 0) {
            int p = y.p(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > p) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > p) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > p) {
                    builder.resource_list.remove(size3);
                }
            }
            for (int size4 = builder.card_god.size() - 1; size4 >= 0; size4--) {
                if (builder.card_god.get(size4).position.intValue() > p) {
                    builder.card_god.remove(size4);
                }
            }
            if (builder.banner_list != null && builder.banner_list.app != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                if (builder2.app != null) {
                    for (int size5 = builder2.app.size() - 1; size5 >= 0; size5--) {
                        App app = builder2.app.get(size5);
                        int g = app != null ? com.baidu.adp.lib.h.b.g(app.pos_name, -1) : -1;
                        if (g < 0 || g > p) {
                            builder2.app.remove(size5);
                        }
                    }
                    if (builder2.app.size() != builder.banner_list.app.size()) {
                        builder.banner_list = builder2.build(false);
                    }
                }
            }
        }
    }
}
