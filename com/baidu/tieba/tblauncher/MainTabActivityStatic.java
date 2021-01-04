package com.baidu.tieba.tblauncher;

import android.app.Activity;
import android.net.Uri;
import android.util.Pair;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.CommonStatisticKey;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
import com.baidu.live.tbadk.data.Config;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.j;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes.dex */
public class MainTabActivityStatic {
    private static int nyx = 0;
    private static boolean nyy = false;

    static {
        cEp();
        dRK();
        dRJ();
        dRL();
        dRM();
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.START_GO_HOME) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Activity) {
                    com.baidu.tbadk.core.e.b.eW((Activity) data);
                }
            }
        });
        be.bwu().a(new be.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.2
            /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
            @Override // com.baidu.tbadk.core.util.be.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Exception e;
                int i;
                int i2;
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (str.contains("jump_tieba_native=1")) {
                    if (str.contains(UrlSchemaHelper.GOTO_ENTERFORUM_TAB)) {
                        com.baidu.tbadk.core.e.b.c(tbPageContext.getPageActivity(), 1, true);
                        return 1;
                    } else if (str.contains(UrlSchemaHelper.GOTO_RECOMMNEDS_FRS_TAB)) {
                        com.baidu.tbadk.core.e.b.c(tbPageContext.getPageActivity(), 2, true);
                        return 1;
                    }
                }
                if (str.startsWith("tieba://homepage_livetab?")) {
                    try {
                        Uri parse = Uri.parse(str);
                        if (parse == null || StringUtils.isNull(parse.getQueryParameter("subTabIndex"))) {
                            i2 = -1;
                        } else {
                            int i3 = com.baidu.adp.lib.f.b.toInt(parse.getQueryParameter("subTabIndex"), 0);
                            if (i3 == 2) {
                                i2 = 19;
                            } else if (i3 == 1) {
                                i2 = 18;
                            } else {
                                i2 = 17;
                            }
                            try {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921446, Integer.valueOf(i3)));
                            } catch (Exception e2) {
                                e = e2;
                                i = i2;
                                e.printStackTrace();
                                i2 = i;
                                if (i2 != -1) {
                                }
                                return 3;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = -1;
                    }
                    if (i2 != -1) {
                        com.baidu.tbadk.core.e.b.c(tbPageContext.getPageActivity(), i2, true);
                        return 1;
                    }
                }
                return 3;
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_MESSAGE_REMIND) { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                    MainTabActivityStatic.d(customResponsedMessage);
                }
            }
        });
        MessageManager.getInstance().registerStickyMode(CmdConfigCustom.CMD_MESSAGE_REMIND);
        be.bwu().a(new be.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.4
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                Map<String, String> paramPair;
                if (strArr == null || strArr[0] == null) {
                    return 3;
                }
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String str = "";
                    String str2 = "";
                    String str3 = "";
                    String paramStr = be.getParamStr(lowerCase);
                    if (!StringUtils.isNull(paramStr) && (paramPair = be.getParamPair(paramStr)) != null) {
                        String str4 = paramPair.get("title");
                        str = !StringUtils.isNull(str4) ? URLDecoder.decode(str4) : str4;
                        str2 = paramPair.get("fid");
                        str3 = paramPair.get("fname");
                        if (!StringUtils.isNull(str3)) {
                            str3 = URLDecoder.decode(str3);
                        }
                    }
                    if (bg.checkUpIsLogin(tbPageContext.getPageActivity())) {
                        if (!StringUtils.isNull(str3) && !StringUtils.isNull(str2)) {
                            ForumWriteData forumWriteData = new ForumWriteData(str2, str3, null, null);
                            forumWriteData.writeCallFrom = "0";
                            j.b(tbPageContext, "", forumWriteData);
                        } else {
                            ForumWriteData forumWriteData2 = new ForumWriteData("", "", null, null);
                            forumWriteData2.writeCallFrom = "0";
                            j.b(tbPageContext, str, forumWriteData2);
                        }
                        TiebaStatic.log(new aq(CommonStatisticKey.KEY_ENTRANCE_CLICKED).an("obj_locate", 4).an("obj_type", 2));
                        TiebaStatic.log(new aq("c12292").dX("obj_locate", "3"));
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
            int a2 = a(newsRemindMessage);
            boolean b2 = b(newsRemindMessage);
            if (a2 != nyx || b2 != nyy) {
                nyx = a2;
                nyy = b2;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_HOME_NOTIFY_MSG, new Pair(Integer.valueOf(a2), Boolean.valueOf(b2))));
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

    private static void cEp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_MAINTAB, new CustomMessageTask.CustomRunnable<MainTabActivityConfig>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.5
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

    private static void dRJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.FRIEND_FEED_NEW, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.6
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

    private static void dRK() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.MSG_NEW, new CustomMessageTask.CustomRunnable<Integer>() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.7
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

    private static void dRL() {
        be.bwu().a(new be.a() { // from class: com.baidu.tieba.tblauncher.MainTabActivityStatic.8
            @Override // com.baidu.tbadk.core.util.be.a
            public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
                if (tbPageContext == null || strArr == null || strArr.length == 0) {
                    return 3;
                }
                String str = strArr[0];
                if (StringUtils.isNull(str) || !str.startsWith("tiebavr:") || TbadkCoreApplication.getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
                    return 3;
                }
                tbPageContext.showToast(R.string.vr_plugin_not_available);
                return 1;
            }
        });
    }

    private static void dRM() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1003393, TbConfig.SERVER_ADDRESS + Config.UPLOAD_SCHEMA);
        tbHttpMessageTask.setResponsedClass(HttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
