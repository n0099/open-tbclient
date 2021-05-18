package com.baidu.tieba.lego.activity;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import d.a.j0.r.q.a2;
import d.a.k0.j1.l;
import d.a.k0.j1.m.c;
import d.a.k0.j1.m.e;
import d.a.k0.j1.o.d;
import d.a.k0.j1.r.b;
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
        b.f56608a.set(new l());
        TbConfig.setLegoLibVersion("3.0.0");
        d.a.k0.j1.o.b.h().g(d.f());
        CustomMessageTask customMessageTask = new CustomMessageTask(2016447, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerStickyMode(2016470);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016470, Boolean.TRUE));
        d.a.k0.j1.m.b.a().b(new e());
        d.a.k0.j1.m.a.a().b(new c());
        d.a.k0.j1.m.a.a().b(new d.a.k0.j1.m.d());
        d.a.j0.c.c.f49187a.set(d.a.k0.j1.m.b.a());
        d.a.j0.c.b.f49185a.set(d.a.k0.j1.m.a.a());
        a2.w3.set(true);
    }
}
