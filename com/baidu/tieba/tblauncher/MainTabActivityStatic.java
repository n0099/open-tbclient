package com.baidu.tieba.tblauncher;

import android.app.Activity;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static int gtN = 0;

    static {
        aiC();
        bwe();
        bwd();
        bwf();
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.START_GO_HOME) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Activity) {
                    com.baidu.tbadk.core.e.b.aE((Activity) data);
                }
            }
        });
        av.vI().a(new av.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.2
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
                    if (str.contains("jump_enter_forum=1")) {
                        com.baidu.tbadk.core.e.b.c(tbPageContext.getPageActivity(), 1, true);
                        return 1;
                    } else if (str.contains("jump_chosen_post=1")) {
                        com.baidu.tbadk.core.e.b.c(tbPageContext.getPageActivity(), 2, true);
                        return 1;
                    }
                }
                return 3;
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_NOTIFY_LOCAL) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001120) {
                    MainTabActivityStatic.h(customResponsedMessage);
                }
            }
        });
    }

    private static int a(NewsNotifyMessage newsNotifyMessage) {
        if (newsNotifyMessage == null) {
            return 0;
        }
        int msgChat = newsNotifyMessage.getMsgChat();
        int msgReplyme = (((com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zg() ? newsNotifyMessage.getMsgReplyme() : 0) + msgChat) + (com.baidu.tbadk.coreExtra.messageCenter.b.yZ().ze() ? newsNotifyMessage.getMsgAtme() : 0)) - newsNotifyMessage.getMsgStrangerChat();
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.yZ().zt()) {
            msgReplyme -= newsNotifyMessage.getMsgOfficialMerge();
        }
        return msgReplyme;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage != null && (responsedMessage instanceof NewsNotifyMessage)) {
            int a = a((NewsNotifyMessage) responsedMessage);
            if (a > gtN) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_NOTIFY_MSG, true));
            }
            gtN = a;
        }
    }

    private static void aiC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new CustomMessageTask.CustomRunnable<MainTabActivityConfig>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<MainTabActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(MainTabActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bwd() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.5
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                TbadkCoreApplication.getInst().setFriendFeedNew(true);
                return new CustomResponsedMessage<>(CmdConfigCustom.FRIEND_FEED_NEW);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bwe() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
                if (customMessage != null && (customMessage instanceof NewMsgArriveRequestMessage)) {
                    return new NewMsgArriveResponsedMessage(((NewMsgArriveRequestMessage) customMessage).getData().intValue());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bwf() {
        av.vI().a(new av.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.7
            @Override // com.baidu.tbadk.core.util.av.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.startsWith("tiebavr:") || TbadkCoreApplication.getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
                    return 3;
                }
                tbPageContext.showToast(d.j.vr_plugin_not_available);
                return 1;
            }
        });
    }
}
