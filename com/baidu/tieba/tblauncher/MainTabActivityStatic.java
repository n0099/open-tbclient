package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static int gSq = 0;
    private static boolean gSr = false;

    static {
        atj();
        bzA();
        bzz();
        bzB();
        bzC();
        MessageManager.getInstance().registerListener(new CustomMessageListener(2002004) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Activity) {
                    com.baidu.tbadk.core.e.b.aI((Activity) data);
                }
            }
        });
        az.zV().a(new az.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.2
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
                    if (str.contains("jump_enter_forum=1")) {
                        com.baidu.tbadk.core.e.b.b(tbPageContext.getPageActivity(), 1, true);
                        return 1;
                    } else if (str.contains("jump_chosen_post=1")) {
                        com.baidu.tbadk.core.e.b.b(tbPageContext.getPageActivity(), 2, true);
                        return 1;
                    }
                }
                return 3;
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001626) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                    MainTabActivityStatic.c(customResponsedMessage);
                }
            }
        });
        MessageManager.getInstance().registerStickyMode(2001626);
        az.zV().a(new az.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.4
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> eR;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    String eS = az.eS(lowerCase);
                    if (!StringUtils.isNull(eS) && (eR = az.eR(eS)) != null) {
                        String str4 = eR.get("title");
                        str = !StringUtils.isNull(str4) ? URLDecoder.decode(str4) : str4;
                        str2 = eR.get(ImageViewerConfig.FORUM_ID);
                        str3 = eR.get(ImageViewerConfig.FORUM_NAME);
                        if (!StringUtils.isNull(str3)) {
                            str3 = URLDecoder.decode(str3);
                        }
                    }
                    if (bb.aU(tbPageContext.getPageActivity())) {
                        if (!StringUtils.isNull(str3) && !StringUtils.isNull(str2)) {
                            ForumWriteData forumWriteData = new ForumWriteData(str2, str3, null, null);
                            forumWriteData.writeCallFrom = "0";
                            com.baidu.tieba.write.e.a(tbPageContext, "", forumWriteData);
                        } else {
                            ForumWriteData forumWriteData2 = new ForumWriteData("", "", null, null);
                            forumWriteData2.writeCallFrom = "0";
                            com.baidu.tieba.write.e.a(tbPageContext, str, forumWriteData2);
                        }
                        TiebaStatic.log(new an("c12611").r("obj_locate", 4).r("obj_type", 2));
                        TiebaStatic.log(new an("c12292").ah("obj_locate", "3"));
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(ResponsedMessage<?> responsedMessage) {
        NewsRemindMessage newsRemindMessage;
        if (responsedMessage != null && (responsedMessage instanceof NewsRemindMessage) && (newsRemindMessage = (NewsRemindMessage) responsedMessage) != null) {
            int a = a(newsRemindMessage);
            boolean b = b(newsRemindMessage);
            if (a != gSq || b != gSr) {
                gSq = a;
                gSr = b;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921002, new Pair(Integer.valueOf(a), Boolean.valueOf(b))));
            }
        }
    }

    private static int a(NewsRemindMessage newsRemindMessage) {
        if (newsRemindMessage == null) {
            return 0;
        }
        return newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
    }

    private static boolean b(NewsRemindMessage newsRemindMessage) {
        if (newsRemindMessage == null) {
            return false;
        }
        return newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
    }

    private static void atj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new CustomMessageTask.CustomRunnable<MainTabActivityConfig>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.5
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

    private static void bzz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.6
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                if (customMessage == null) {
                    return null;
                }
                TbadkCoreApplication.getInst().setFriendFeedNew(true);
                return new CustomResponsedMessage<>(2012118);
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bzA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.7
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

    private static void bzB() {
        az.zV().a(new az.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.8
            @Override // com.baidu.tbadk.core.util.az.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.startsWith("tiebavr:") || TbadkCoreApplication.getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
                    return 3;
                }
                tbPageContext.showToast(d.k.vr_plugin_not_available);
                return 1;
            }
        });
    }

    private static void bzC() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SCHEMA_UPLOAD, TbConfig.SERVER_ADDRESS + "c/s/schemastat");
        tbHttpMessageTask.setResponsedClass(HttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
