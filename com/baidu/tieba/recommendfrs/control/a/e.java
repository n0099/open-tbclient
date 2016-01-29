package com.baidu.tieba.recommendfrs.control.a;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.card.a.w;
import com.baidu.tieba.tbadkCore.ag;
import java.util.LinkedList;
import java.util.List;
import tbclient.App;
import tbclient.BannerList;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e {
    public static void a(DataRes.Builder builder) {
        if (builder != null) {
            x.n(builder.resource_list);
            x.n(builder.card_forum);
            x.n(builder.card_topic);
            if (builder.banner_list != null) {
                BannerList.Builder builder2 = new BannerList.Builder(builder.banner_list);
                x.n(builder2.app);
                builder.banner_list = builder2.build(false);
            }
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
        }
    }

    public static List<w> b(DataRes.Builder builder) {
        com.baidu.tbadk.core.data.c Kp;
        com.baidu.tieba.recommendfrs.data.c bVar;
        if (builder == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (builder.card_topic != null) {
            for (CardTopic cardTopic : builder.card_topic) {
                com.baidu.tieba.recommendfrs.data.d dVar = new com.baidu.tieba.recommendfrs.data.d();
                dVar.a(cardTopic);
                if (x.o(dVar.aSJ) > 3) {
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
                    if (com.baidu.tieba.recommendfrs.data.c.nx(cardForum.card_type.intValue())) {
                        bVar = new com.baidu.tieba.recommendfrs.data.f();
                    } else {
                        bVar = com.baidu.tieba.recommendfrs.data.c.ny(cardForum.card_type.intValue()) ? new com.baidu.tieba.recommendfrs.data.b() : null;
                    }
                    if (bVar != null) {
                        bVar.a(cardForum);
                        if (bVar.rM()) {
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
                if (aVar.getPosition() > 0 && (Kp = aVar.Kp()) != null) {
                    if (Kp.rN()) {
                        try {
                            if (!TextUtils.isEmpty(Kp.Uy) && !ag.isInstalledPackage(TbadkCoreApplication.m411getInst().getContext(), Kp.Uy)) {
                            }
                        } catch (Exception e) {
                        }
                    }
                    if (Kp.rM()) {
                        linkedList.add(aVar);
                    }
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
        }
    }

    public static com.baidu.tieba.card.a.c i(ah ahVar) {
        if (com.baidu.tieba.card.a.r.b(ahVar)) {
            return new com.baidu.tieba.card.a.r(ahVar);
        }
        if (com.baidu.tieba.card.a.s.b(ahVar)) {
            return new com.baidu.tieba.card.a.s(ahVar);
        }
        if (com.baidu.tieba.card.a.q.b(ahVar)) {
            com.baidu.tieba.card.a.q qVar = new com.baidu.tieba.card.a.q();
            qVar.aSc = ahVar;
            return qVar;
        }
        return null;
    }

    public static void d(DataRes.Builder builder) {
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && x.o(builder.thread_list) != 0) {
            int o = x.o(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > o) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > o) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > o) {
                    builder.resource_list.remove(size3);
                }
            }
        }
    }
}
