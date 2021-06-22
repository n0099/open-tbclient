package com.baidu.tieba.lego.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import d.a.n0.r.q.a2;
import d.a.o0.k1.l;
import d.a.o0.k1.m.c;
import d.a.o0.k1.m.e;
import d.a.o0.k1.o.d;
import d.a.o0.k1.r.b;
/* loaded from: classes4.dex */
public class LegoListActivityStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<LegoListActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<LegoListActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(LegoListActivity.class);
            }
            return null;
        }
    }

    static {
        b.f60602a.set(new l());
        TbConfig.setLegoLibVersion("3.0.0");
        d.a.o0.k1.o.b.h().g(d.f());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016447, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerStickyMode(2016470);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016470, Boolean.TRUE));
        d.a.o0.k1.m.b.a().b(new e());
        d.a.o0.k1.m.a.a().b(new c());
        d.a.o0.k1.m.a.a().b(new d.a.o0.k1.m.d());
        d.a.n0.c.c.f52993a.set(d.a.o0.k1.m.b.a());
        d.a.n0.c.b.f52991a.set(d.a.o0.k1.m.a.a());
        a2.A3.set(true);
    }
}
