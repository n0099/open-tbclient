package com.baidu.tieba.postsearch;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PostSearchActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes5.dex */
public class PostSearchActivityStatic {

    /* loaded from: classes5.dex */
    public static class a implements CustomMessageTask.CustomRunnable<String> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Void> run(CustomMessage<String> customMessage) {
            if (customMessage == null) {
                return null;
            }
            String data = customMessage.getData();
            if (StringUtils.isNull(data)) {
                return null;
            }
            d.a.o0.e3.n0.a.q(data);
            return new CustomResponsedMessage<>(2009003);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Void> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Void> run(CustomMessage<Void> customMessage) {
            if (customMessage == null) {
                return null;
            }
            d.a.o0.e3.n0.a.d();
            return new CustomResponsedMessage<>(2009004);
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PostSearchActivityConfig.class, PostSearchActivity.class);
        b();
        c();
        a();
    }

    public static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009004, new b());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void b() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_POST_SEARCH, TbConfig.SERVER_ADDRESS + TbConfig.POST_SEARCH_URL);
        tbHttpMessageTask.setResponsedClass(PostSearchHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009003, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
