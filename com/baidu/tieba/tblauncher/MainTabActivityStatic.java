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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.VrPlayerActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveRequestMessage;
import com.baidu.tbadk.coreExtra.message.NewMsgArriveResponsedMessage;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import d.b.i0.u3.j;
import java.net.URLDecoder;
import java.util.Map;
/* loaded from: classes5.dex */
public class MainTabActivityStatic {

    /* renamed from: a  reason: collision with root package name */
    public static int f21535a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f21536b = false;

    /* loaded from: classes5.dex */
    public static class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Object data = customResponsedMessage.getData();
            if (data instanceof Activity) {
                d.b.h0.r.a0.b.d((Activity) data);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements UrlManager.UrlDealListener {
        /* JADX WARN: Removed duplicated region for block: B:40:0x0085  */
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            int i;
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE)) {
                    if (str.contains(UrlSchemaHelper.GOTO_ENTERFORUM_TAB)) {
                        d.b.h0.r.a0.b.f(tbPageContext.getPageActivity(), 1, true);
                        return 1;
                    } else if (str.contains(UrlSchemaHelper.GOTO_RECOMMNEDS_FRS_TAB)) {
                        d.b.h0.r.a0.b.f(tbPageContext.getPageActivity(), 2, true);
                        return 1;
                    }
                }
                if (str.startsWith(UrlSchemaHelper.SCHEMA_TYPE_HOMEPAGE_LIVETAB)) {
                    try {
                        Uri parse = Uri.parse(str);
                        if (parse == null || StringUtils.isNull(parse.getQueryParameter("subTabIndex"))) {
                            i = -1;
                        } else {
                            int d2 = d.b.b.e.m.b.d(parse.getQueryParameter("subTabIndex"), 0);
                            i = d2 == 2 ? 19 : d2 == 1 ? 18 : 17;
                            try {
                                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921446, Integer.valueOf(d2)));
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                if (i != -1) {
                                }
                                return 3;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        i = -1;
                    }
                    if (i != -1) {
                        d.b.h0.r.a0.b.f(tbPageContext.getPageActivity(), i, true);
                        return 1;
                    }
                }
            }
            return 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends CustomMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001626) {
                MainTabActivityStatic.d(customResponsedMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            String str;
            String str2;
            String str3;
            Map<String, String> paramPair;
            if (strArr != null && strArr[0] != null) {
                String lowerCase = strArr[0].toLowerCase();
                if (lowerCase.contains("n/video/opersquare?jump_to_publish_video_thread=1")) {
                    String paramStr = UrlManager.getParamStr(lowerCase);
                    if (StringUtils.isNull(paramStr) || (paramPair = UrlManager.getParamPair(paramStr)) == null) {
                        str = "";
                        str2 = str;
                        str3 = str2;
                    } else {
                        str2 = paramPair.get("title");
                        if (!StringUtils.isNull(str2)) {
                            str2 = URLDecoder.decode(str2);
                        }
                        str3 = paramPair.get("fid");
                        str = paramPair.get("fname");
                        if (!StringUtils.isNull(str)) {
                            str = URLDecoder.decode(str);
                        }
                    }
                    if (ViewHelper.checkUpIsLogin(tbPageContext.getPageActivity())) {
                        if (!StringUtils.isNull(str) && !StringUtils.isNull(str3)) {
                            ForumWriteData forumWriteData = new ForumWriteData(str3, str, null, null);
                            forumWriteData.writeCallFrom = "0";
                            j.d(tbPageContext, "", forumWriteData);
                        } else {
                            ForumWriteData forumWriteData2 = new ForumWriteData("", "", null, null);
                            forumWriteData2.writeCallFrom = "0";
                            j.d(tbPageContext, str2, forumWriteData2);
                        }
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_ENTRANCE_CLICKED).param("obj_locate", 4).param("obj_type", 2));
                        TiebaStatic.log(new StatisticItem("c12292").param("obj_locate", "3"));
                    }
                    return 0;
                }
            }
            return 3;
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements CustomMessageTask.CustomRunnable<MainTabActivityConfig> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<MainTabActivityConfig> customMessage) {
            if (customMessage != null && customMessage.getData() != null) {
                customMessage.getData().startActivity(MainTabActivity.class);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class f implements CustomMessageTask.CustomRunnable<Void> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            if (customMessage == null) {
                return null;
            }
            TbadkCoreApplication.getInst().setFriendFeedNew(true);
            return new CustomResponsedMessage<>(2012118);
        }
    }

    /* loaded from: classes5.dex */
    public static class g implements CustomMessageTask.CustomRunnable<Integer> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Integer> customMessage) {
            if (customMessage != null && (customMessage instanceof NewMsgArriveRequestMessage)) {
                return new NewMsgArriveResponsedMessage(((NewMsgArriveRequestMessage) customMessage).getData().intValue());
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class h implements UrlManager.UrlDealListener {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            if (tbPageContext != null && strArr != null && strArr.length != 0) {
                String str = strArr[0];
                if (!StringUtils.isNull(str) && str.startsWith("tiebavr:") && !TbadkCoreApplication.getInst().appResponseToIntentClass(VrPlayerActivityConfig.class)) {
                    tbPageContext.showToast(R.string.vr_plugin_not_available);
                    return 1;
                }
            }
            return 3;
        }
    }

    static {
        g();
        f();
        e();
        i();
        h();
        MessageManager.getInstance().registerListener(new a(2002004));
        UrlManager.getInstance().addListener(new b());
        MessageManager.getInstance().registerListener(new c(2001626));
        MessageManager.getInstance().registerStickyMode(2001626);
        UrlManager.getInstance().addListener(new d());
    }

    public static int b(NewsRemindMessage newsRemindMessage) {
        if (newsRemindMessage == null) {
            return 0;
        }
        return newsRemindMessage.getMsgCount() + newsRemindMessage.getChatCount() + newsRemindMessage.getNotificationCount();
    }

    public static boolean c(NewsRemindMessage newsRemindMessage) {
        if (newsRemindMessage == null) {
            return false;
        }
        return newsRemindMessage.hasMsgRemind() || newsRemindMessage.hasChatRemind() || newsRemindMessage.hasNotificationRemind();
    }

    public static void d(ResponsedMessage<?> responsedMessage) {
        NewsRemindMessage newsRemindMessage;
        if (responsedMessage == null || !(responsedMessage instanceof NewsRemindMessage) || (newsRemindMessage = (NewsRemindMessage) responsedMessage) == null) {
            return;
        }
        int b2 = b(newsRemindMessage);
        boolean c2 = c(newsRemindMessage);
        if (b2 == f21535a && c2 == f21536b) {
            return;
        }
        f21535a = b2;
        f21536b = c2;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921002, new Pair(Integer.valueOf(b2), Boolean.valueOf(c2))));
    }

    public static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012118, new f());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012111, new g());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015002, new e());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    public static void h() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_SCHEMA_UPLOAD, TbConfig.SERVER_ADDRESS + "c/s/schemastat");
        tbHttpMessageTask.setResponsedClass(HttpResponsedMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void i() {
        UrlManager.getInstance().addListener(new h());
    }
}
