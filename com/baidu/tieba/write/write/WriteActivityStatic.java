package com.baidu.tieba.write.write;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tbadk.core.atomData.RelevanceItemSearchActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.view.spanGroup.UrlParserHttpResponseMessage;
import com.baidu.tbadk.core.view.spanGroup.UrlParserSocketResponseMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.write.accountAccess.AccountAccessActivity;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.album.AlbumFloatActivity;
import com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity;
import com.baidu.tieba.write.transmit.SelectForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
import com.baidu.tieba.write.write.relevance.RelevanceItemSearchActivity;
import com.baidu.tieba.write.write.vote.WriteVoteActivity;
import d.a.c.a.j;
import d.a.c.e.p.l;
import java.util.Map;
/* loaded from: classes5.dex */
public class WriteActivityStatic {

    /* renamed from: a  reason: collision with root package name */
    public static int f22209a = 11;

    /* renamed from: b  reason: collision with root package name */
    public static int f22210b = 18;

    /* loaded from: classes5.dex */
    public static class a implements UrlManager.UrlSchemaHandler {
        @Override // com.baidu.tbadk.core.util.UrlManager.UrlSchemaHandler
        public void deal(TbPageContext<?> tbPageContext, Map<String, String> map) {
            if (tbPageContext != null) {
                WriteActivityStatic.b(tbPageContext);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends d.a.c.c.f.b {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.Message, com.baidu.adp.framework.task.MessageTask] */
        /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.Message' to match base method */
        @Override // d.a.c.c.f.f
        public /* bridge */ /* synthetic */ CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            CustomMessage<?> customMessage2 = customMessage;
            process2(customMessage2, customMessageTask);
            return customMessage2;
        }

        /* renamed from: process  reason: avoid collision after fix types in other method */
        public CustomMessage<?> process2(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
            Class<?> cls;
            if (customMessage != null) {
                Object data = customMessage.getData();
                if (data instanceof IntentConfig) {
                    IntentConfig intentConfig = (IntentConfig) data;
                    if (intentConfig.getContext() != null && (WriteActivityConfig.class == (cls = data.getClass()) || RecordVideoActivityConfig.class == cls || WriteVoteActivityConfig.class == cls)) {
                        String simpleName = intentConfig.getContext().getClass().getSimpleName();
                        if ("FrsActivity".equals(simpleName) || "MainTabActivity".equals(simpleName)) {
                            d.a.n0.e3.q0.a.f().o(j.a(intentConfig.getContext()).getUniqueId());
                        }
                    }
                }
            }
            return customMessage;
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof ExceptionData) || TiebaStaticHelper.getCurrentActivity() == null || TiebaStaticHelper.getCurrentActivity().indexOf("NewVcode") == -1) {
                return;
            }
            TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements CustomMessageTask.CustomRunnable<Object> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.a.n0.d0.c> run(CustomMessage<Object> customMessage) {
            return new CustomResponsedMessage<>(2001449, new d.a.n0.w3.b());
        }
    }

    static {
        TbadkCoreApplication.getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TransmitPostEditActivityConfig.class, TransmitPostEditActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlbumFloatActivityConfig.class, AlbumFloatActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TransmitForumActivityConfig.class, TransmitForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectForumActivityConfig.class, SelectForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(HotTopicChangeActivityConfig.class, HotTopicChangeFourmActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AccountAccessActivityConfig.class, AccountAccessActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteVoteActivityConfig.class, WriteVoteActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(RelevanceItemSearchActivityConfig.class, RelevanceItemSearchActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AddLinkActivityConfig.class, AddLinkActivity.class);
        LocationModel.G();
        e();
        UrlManager.getInstance().registerSchema(UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK, new a());
        f();
        g();
        d.a.n0.e3.d0.a.h(309450, GetRepostForumSocketResMessage.class, false, false);
        d.a.n0.e3.d0.a.c(309450, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, TbConfig.CMD_GET_REPOST_FORUM_LIST, GetRepostForumHttpResMessage.class, false, false, true, false);
    }

    public static void b(TbPageContext<?> tbPageContext) {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 <= f22210b && i2 >= f22209a) {
            d(tbPageContext);
        } else {
            c(tbPageContext);
        }
    }

    public static void c(TbPageContext<?> tbPageContext) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount != null && currentAccount.length() > 0) {
            AntiData antiData = new AntiData();
            antiData.setIfpost(1);
            if (antiData.getIfpost() == 0) {
                l.M(tbPageContext.getPageActivity(), antiData.getForbid_info());
                return;
            }
            antiData.setIfVoice(false);
            WriteActivityConfig.newInstance(tbPageContext.getPageActivity()).setType(9).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setAntiData(antiData).send();
            return;
        }
        TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, 12008)));
    }

    public static void d(TbPageContext<?> tbPageContext) {
        d.a.m0.l.a.p(tbPageContext.getPageActivity(), TbadkCoreApplication.getInst().getString(R.string.feedback), TbConfig.FEED_BACK_WEB_VIEW_URL, true, true, false, false, true);
    }

    public static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001449, new d());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        d.a.n0.e3.d0.a.f(309686, UrlParserSocketResponseMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, d.a.n0.e3.d0.a.a(TbConfig.URL_URL_PARSER, 309686));
        tbHttpMessageTask.setResponsedClass(UrlParserHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public static void f() {
        MessageManager.getInstance().addMessageRule(new b(2002001));
    }

    public static void g() {
        MessageManager.getInstance().registerListener(new c(2016301));
    }
}
