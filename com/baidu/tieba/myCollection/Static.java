package com.baidu.tieba.myCollection;

import android.content.Context;
import android.content.IntentFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbHistoryActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.message.HistoryMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.myCollection.baseHistory.PbHistoryCacheModel;
import com.baidu.tieba.myCollection.history.PbHistoryActivity;
/* loaded from: classes11.dex */
public class Static {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(PbHistoryActivityConfig.class, PbHistoryActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_EDITMARK, new CustomMessageTask.CustomRunnable<IntentConfig>() { // from class: com.baidu.tieba.myCollection.Static.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<IntentConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(CollectTabActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_ADD_HISTORY) { // from class: com.baidu.tieba.myCollection.Static.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof HistoryMessage) {
                    HistoryMessage historyMessage = (HistoryMessage) customResponsedMessage;
                    if (historyMessage.Activity != null) {
                        PbHistoryCacheModel pbHistoryCacheModel = new PbHistoryCacheModel(historyMessage.Activity);
                        com.baidu.tieba.myCollection.baseHistory.a aVar = new com.baidu.tieba.myCollection.baseHistory.a();
                        aVar.setThreadId(historyMessage.threadId);
                        aVar.setForumName(historyMessage.forumName);
                        aVar.setThreadName(historyMessage.threadName);
                        aVar.Fo(historyMessage.postID);
                        aVar.pd(historyMessage.isHostOnly);
                        aVar.pe(historyMessage.isSquence);
                        aVar.setThreadType(historyMessage.threadType);
                        aVar.setCartoonId(historyMessage.cartoonId);
                        aVar.setChapterId(historyMessage.chapterId);
                        aVar.setIsShareThread(historyMessage.isShareThread);
                        aVar.setManga(historyMessage.isManga);
                        aVar.dO(historyMessage.liveId);
                        aVar.setUserName(historyMessage.userName);
                        aVar.setDescription(historyMessage.description);
                        pbHistoryCacheModel.a((PbHistoryCacheModel) aVar);
                    }
                }
            }
        });
        CustomMessageTask customMessageTask2 = new CustomMessageTask(CmdConfigCustom.CMD_MARK_MANAGER, new CustomMessageTask.CustomRunnable<BaseActivity>() { // from class: com.baidu.tieba.myCollection.Static.3
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.baseEditMark.a> run(CustomMessage<BaseActivity> customMessage) {
                com.baidu.tieba.myCollection.baseEditMark.b bVar = null;
                if (customMessage != null && customMessage.getData() != null) {
                    bVar = new com.baidu.tieba.myCollection.baseEditMark.b(customMessage.getData());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MARK_MANAGER, bVar);
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(CmdConfigCustom.CMD_MARK_MANAGER_1, new CustomMessageTask.CustomRunnable<BaseFragmentActivity>() { // from class: com.baidu.tieba.myCollection.Static.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tbadk.baseEditMark.a> run(CustomMessage<BaseFragmentActivity> customMessage) {
                com.baidu.tieba.myCollection.baseEditMark.b bVar = null;
                if (customMessage != null && customMessage.getData() != null) {
                    bVar = new com.baidu.tieba.myCollection.baseEditMark.b(customMessage.getData());
                }
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_MARK_MANAGER_1, bVar);
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        Context context = TbadkCoreApplication.getInst().getContext();
        if (context != null && TbadkCoreApplication.getInst().isMainProcess(false)) {
            context.registerReceiver(new CollectUpdateReceiver(), new IntentFilter(CollectUpdateReceiver.ACTION_NAME));
        }
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.tieba.myCollection.Static.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                    if (((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                        com.baidu.tieba.myCollection.a.a.chS().destroy();
                    } else if (TbadkCoreApplication.isLogin()) {
                        com.baidu.tieba.myCollection.a.a.chS().start();
                    } else {
                        com.baidu.tieba.myCollection.a.a.chS().destroy();
                    }
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.myCollection.Static.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (TbadkCoreApplication.isLogin()) {
                    com.baidu.tieba.myCollection.a.a.chS().restart();
                } else {
                    com.baidu.tieba.myCollection.a.a.chS().destroy();
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.myCollection.Static.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120 && (customResponsedMessage instanceof NewsNotifyMessage) && ((NewsNotifyMessage) customResponsedMessage).getMsgBookmark() > 0) {
                    b.cht().chw();
                    b.cht().oX(true);
                }
            }
        });
    }
}
