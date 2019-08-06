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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.i;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes4.dex */
public class MainTabActivityStatic {
    private static int jmu = 0;
    private static boolean jmv = false;

    static {
        blv();
        crO();
        crN();
        crP();
        crQ();
        MessageManager.getInstance().registerListener(new CustomMessageListener(2002004) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Activity) {
                    com.baidu.tbadk.core.f.b.cs((Activity) data);
                }
            }
        });
        bb.ajE().a(new bb.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.2
            @Override // com.baidu.tbadk.core.util.bb.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
                    if (str.contains("jump_enter_forum=1")) {
                        com.baidu.tbadk.core.f.b.b(tbPageContext.getPageActivity(), 1, true);
                        return 1;
                    } else if (str.contains("jump_chosen_post=1")) {
                        com.baidu.tbadk.core.f.b.b(tbPageContext.getPageActivity(), 2, true);
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
                    MainTabActivityStatic.d(customResponsedMessage);
                }
            }
        });
        MessageManager.getInstance().registerStickyMode(2001626);
        bb.ajE().a(new bb.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.4
            @Override // com.baidu.tbadk.core.util.bb.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> oo;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    String op = bb.op(lowerCase);
                    if (!StringUtils.isNull(op) && (oo = bb.oo(op)) != null) {
                        String str4 = oo.get("title");
                        str = !StringUtils.isNull(str4) ? URLDecoder.decode(str4) : str4;
                        str2 = oo.get("fid");
                        str3 = oo.get(ImageViewerConfig.FORUM_NAME);
                        if (!StringUtils.isNull(str3)) {
                            str3 = URLDecoder.decode(str3);
                        }
                    }
                    if (bd.cF(tbPageContext.getPageActivity())) {
                        if (!StringUtils.isNull(str3) && !StringUtils.isNull(str2)) {
                            ForumWriteData forumWriteData = new ForumWriteData(str2, str3, null, null);
                            forumWriteData.writeCallFrom = "0";
                            i.b(tbPageContext, "", forumWriteData);
                        } else {
                            ForumWriteData forumWriteData2 = new ForumWriteData("", "", null, null);
                            forumWriteData2.writeCallFrom = "0";
                            i.b(tbPageContext, str, forumWriteData2);
                        }
                        TiebaStatic.log(new an("c12611").P("obj_locate", 4).P("obj_type", 2));
                        TiebaStatic.log(new an("c12292").bT("obj_locate", "3"));
                    }
                    return 0;
                }
                return 3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(ResponsedMessage<?> responsedMessage) {
        NewsRemindMessage newsRemindMessage;
        if (responsedMessage != null && (responsedMessage instanceof NewsRemindMessage) && (newsRemindMessage = (NewsRemindMessage) responsedMessage) != null) {
            int a = a(newsRemindMessage);
            boolean b = b(newsRemindMessage);
            if (a != jmu || b != jmv) {
                jmu = a;
                jmv = b;
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

    private static void blv() {
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

    private static void crN() {
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

    private static void crO() {
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

    private static void crP() {
        bb.ajE().a(new bb.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.8
            @Override // com.baidu.tbadk.core.util.bb.a
            public int a(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.startsWith("tiebavr:") || TbadkCoreApplication.getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
                    return 3;
                }
                tbPageContext.showToast((int) R.string.vr_plugin_not_available);
                return 1;
            }
        });
    }

    private static void crQ() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SCHEMA_UPLOAD, TbConfig.SERVER_ADDRESS + "c/s/schemastat");
        tbHttpMessageTask.setResponsedClass(HttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
