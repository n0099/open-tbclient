package com.baidu.tieba.recommendfrs;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import tbclient.GodInfo;
import tbclient.Personalized.DataRes;
import tbclient.ThreadInfo;
import tbclient.User;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends CustomMessageListener {
    final /* synthetic */ q dVL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(q qVar, int i) {
        super(i);
        this.dVL = qVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Incorrect condition in loop: B:13:0x0038 */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        DataRes.Builder builder;
        DataRes.Builder builder2;
        DataRes.Builder builder3;
        int intValue;
        DataRes.Builder builder4;
        if (customResponsedMessage instanceof UpdateAttentionMessage) {
            builder = this.dVL.dVs;
            if (!com.baidu.tbadk.core.util.y.q(builder.thread_list)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() == null || StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    return;
                }
                for (int i = 0; i < builder2.thread_list.size(); i++) {
                    builder3 = this.dVL.dVs;
                    ThreadInfo threadInfo = builder3.thread_list.get(i);
                    if (threadInfo != null && threadInfo.author != null && threadInfo.author.id.longValue() == com.baidu.adp.lib.h.b.c(updateAttentionMessage.getData().toUid, -1L)) {
                        ThreadInfo.Builder builder5 = new ThreadInfo.Builder(threadInfo);
                        User.Builder builder6 = new User.Builder(builder5.author);
                        GodInfo.Builder builder7 = new GodInfo.Builder(builder6.god_data);
                        if (updateAttentionMessage.getData().akM) {
                            intValue = builder6.fans_num.intValue() + 1;
                            builder7.followed = 1;
                        } else {
                            intValue = builder6.fans_num.intValue() - 1;
                            builder7.followed = 0;
                        }
                        builder6.fans_num = Integer.valueOf(intValue);
                        builder6.god_data = builder7.build(true);
                        builder5.author = builder6.build(true);
                        builder4 = this.dVL.dVs;
                        builder4.thread_list.set(i, builder5.build(true));
                        return;
                    }
                }
            }
        }
    }
}
