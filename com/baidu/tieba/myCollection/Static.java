package com.baidu.tieba.myCollection;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.history.PbHistoryActivity;
import com.baidu.tieba.myCollection.message.AlaMGetLiveStatusHttpResponseMessage;
/* loaded from: classes3.dex */
public class Static {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<IntentConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(CollectTabActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof HistoryMessage) {
                HistoryMessage historyMessage = (HistoryMessage) customResponsedMessage;
                PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(historyMessage.Activity);
                d.a.k0.w1.h.a aVar = new d.a.k0.w1.h.a();
                aVar.J(historyMessage.threadId);
                aVar.B(historyMessage.forumName);
                aVar.K(historyMessage.threadName);
                aVar.H(historyMessage.postID);
                aVar.C(historyMessage.isHostOnly);
                aVar.I(historyMessage.isSquence);
                aVar.L(historyMessage.threadType);
                aVar.y(historyMessage.cartoonId);
                aVar.z(historyMessage.chapterId);
                aVar.D(historyMessage.isShareThread);
                aVar.G(historyMessage.isManga);
                aVar.F(historyMessage.liveId);
                aVar.M(historyMessage.userName);
                aVar.A(historyMessage.description);
                pbHistoryCacheModel.w(aVar);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements CustomMessageTask.CustomRunnable<BaseActivity> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.j0.h.a> run(CustomMessage<BaseActivity> customMessage) {
            return new CustomResponsedMessage<>(2001279, (customMessage == null || customMessage.getData() == null) ? null : new d.a.k0.w1.g.b(customMessage.getData()));
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements CustomMessageTask.CustomRunnable<BaseFragmentActivity> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.j0.h.a> run(CustomMessage<BaseFragmentActivity> customMessage) {
            return new CustomResponsedMessage<>(2921318, (customMessage == null || customMessage.getData() == null) ? null : new d.a.k0.w1.g.b(customMessage.getData()));
        }
    }

    /* loaded from: classes3.dex */
    public static class e extends CustomMessageListener {
        public e(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                    d.a.k0.w1.j.a.d().c();
                } else if (TbadkCoreApplication.isLogin()) {
                    d.a.k0.w1.j.a.d().f();
                } else {
                    d.a.k0.w1.j.a.d().c();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class f extends CustomMessageListener {
        public f(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (TbadkCoreApplication.isLogin()) {
                d.a.k0.w1.j.a.d().e();
            } else {
                d.a.k0.w1.j.a.d().c();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class g extends CustomMessageListener {
        public g(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getCmd() != 2001120 || !(customResponsedMessage instanceof NewsNotifyMessage) || ((NewsNotifyMessage) customResponsedMessage).getMsgBookmark() <= 0) {
                return;
            }
            d.a.k0.w1.b.b().d();
            d.a.k0.w1.b.b().e(true);
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(PbHistoryActivityConfig.class, PbHistoryActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2015005, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new b(2001278));
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001279, new c());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2921318, new d());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        Context context = TbadkCoreApplication.getInst().getContext();
        if (context != null && TbadkCoreApplication.getInst().isMainProcess(false)) {
            context.registerReceiver(new CollectUpdateReceiver(), new IntentFilter(CollectUpdateReceiver.ACTION_NAME));
        }
        MessageManager.getInstance().registerListener(new e(2001011));
        MessageManager.getInstance().registerListener(new f(2005016));
        MessageManager.getInstance().registerListener(new g(2001120));
        d.a.k0.d3.d0.a.e(CmdConfigHttp.CMD_ALA_LIVE_ROOM_CLOSED, TbConfig.URL_ALA_LIVE_ROOM_CLOSED, AlaMGetLiveStatusHttpResponseMessage.class, false, true, true, true);
    }
}
