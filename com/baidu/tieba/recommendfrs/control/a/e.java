package com.baidu.tieba.recommendfrs.control.a;

import com.baidu.tbadk.core.data.z;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.card.a.o;
import com.baidu.tieba.card.a.p;
import com.baidu.tieba.card.a.t;
import java.util.LinkedList;
import java.util.List;
import tbclient.Personalized.CardForum;
import tbclient.Personalized.CardTopic;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.Resource;
/* loaded from: classes.dex */
public class e {
    public static void a(DataRes.Builder builder) {
        if (builder != null) {
            y.k(builder.resource_list);
            y.k(builder.card_forum);
            y.k(builder.card_topic);
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
        }
    }

    public static List<t> b(DataRes.Builder builder) {
        com.baidu.tieba.recommendfrs.data.b aVar;
        if (builder == null) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        if (builder.card_topic != null) {
            for (CardTopic cardTopic : builder.card_topic) {
                com.baidu.tieba.recommendfrs.data.c cVar = new com.baidu.tieba.recommendfrs.data.c();
                cVar.a(cardTopic);
                if (y.l(cVar.aQG) > 3) {
                    linkedList.add(cVar);
                }
            }
        }
        if (builder.resource_list != null) {
            for (Resource resource : builder.resource_list) {
                com.baidu.tieba.recommendfrs.data.d dVar = new com.baidu.tieba.recommendfrs.data.d();
                dVar.a(resource);
                linkedList.add(dVar);
            }
        }
        if (builder.card_forum != null) {
            for (CardForum cardForum : builder.card_forum) {
                if (cardForum != null) {
                    if (com.baidu.tieba.recommendfrs.data.b.mm(cardForum.card_type.intValue())) {
                        aVar = new com.baidu.tieba.recommendfrs.data.e();
                    } else {
                        aVar = com.baidu.tieba.recommendfrs.data.b.mn(cardForum.card_type.intValue()) ? new com.baidu.tieba.recommendfrs.data.a() : null;
                    }
                    if (aVar != null) {
                        aVar.a(cardForum);
                        if (aVar.rk()) {
                            linkedList.add(aVar);
                        }
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

    public static com.baidu.tieba.card.a.c h(z zVar) {
        if (o.b(zVar)) {
            return new o(zVar);
        }
        if (p.b(zVar)) {
            return new p(zVar);
        }
        if (com.baidu.tieba.card.a.n.b(zVar)) {
            com.baidu.tieba.card.a.n nVar = new com.baidu.tieba.card.a.n();
            nVar.aQo = zVar;
            return nVar;
        }
        return null;
    }

    public static void d(DataRes.Builder builder) {
        if (builder != null && builder.card_forum != null && builder.card_topic != null && builder.resource_list != null && y.l(builder.thread_list) != 0) {
            int l = y.l(builder.thread_list);
            for (int size = builder.card_forum.size() - 1; size >= 0; size--) {
                if (builder.card_forum.get(size).position.longValue() > l) {
                    builder.card_forum.remove(size);
                }
            }
            for (int size2 = builder.card_topic.size() - 1; size2 >= 0; size2--) {
                if (builder.card_topic.get(size2).position.intValue() > l) {
                    builder.card_topic.remove(size2);
                }
            }
            for (int size3 = builder.resource_list.size() - 1; size3 >= 0; size3--) {
                if (builder.resource_list.get(size3).position.longValue() > l) {
                    builder.resource_list.remove(size3);
                }
            }
        }
    }
}
