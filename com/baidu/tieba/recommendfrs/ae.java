package com.baidu.tieba.recommendfrs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.as;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.Zan;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends CustomMessageListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(q qVar, int i) {
        super(i);
        this.dVL = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        as asVar;
        DataRes.Builder builder3;
        DataRes.Builder builder4;
        DataRes.Builder builder5;
        DataRes.Builder builder6;
        if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof as)) {
            builder = this.dVL.dVs;
            if (builder != null) {
                builder2 = this.dVL.dVs;
                if (com.baidu.tbadk.core.util.y.p(builder2.thread_list) != 0 && (asVar = (as) customResponsedMessage.getData()) != null && asVar.getPraise() != null && asVar.getId() != null) {
                    builder3 = this.dVL.dVs;
                    if (com.baidu.tbadk.core.util.y.p(builder3.thread_list) != 0) {
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            builder4 = this.dVL.dVs;
                            if (i2 < builder4.thread_list.size()) {
                                builder5 = this.dVL.dVs;
                                ThreadInfo threadInfo = builder5.thread_list.get(i2);
                                if (threadInfo == null || threadInfo.id.longValue() != com.baidu.adp.lib.h.b.c(asVar.getId(), -1L)) {
                                    i = i2 + 1;
                                } else {
                                    ThreadInfo.Builder builder7 = new ThreadInfo.Builder(threadInfo);
                                    Zan.Builder builder8 = new Zan.Builder(builder7.zan);
                                    builder8.num = Integer.valueOf((int) asVar.getPraise().getNum());
                                    builder7.zan = builder8.build(true);
                                    builder6 = this.dVL.dVs;
                                    builder6.thread_list.set(i2, builder7.build(true));
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}
