package com.baidu.tieba.write.write;

import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.live.tbadk.core.util.UrlSchemaHelper;
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
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
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
import java.util.Map;
/* loaded from: classes8.dex */
public class WriteActivityStatic {
    private static int olQ = 11;
    private static int olR = 18;

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
        LocationModel.dOq();
        cOu();
        bf.bsV().a(UrlSchemaHelper.SCHEMA_TYPE_FEED_BACK, new bf.b() { // from class: com.baidu.tieba.write.write.WriteActivityStatic.1
            @Override // com.baidu.tbadk.core.util.bf.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null) {
                    WriteActivityStatic.N(tbPageContext);
                }
            }
        });
        dZs();
        registerListener();
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_REPOST_RECOMMEND_FORUM, GetRepostForumSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_REPOST_RECOMMEND_FORUM, 1003323, TbConfig.CMD_GET_REPOST_FORUM_LIST, GetRepostForumHttpResMessage.class, false, false, true, false);
    }

    private static void dZs() {
        MessageManager.getInstance().addMessageRule(new com.baidu.adp.framework.b.b(CmdConfigCustom.START_GO_ACTION) { // from class: com.baidu.tieba.write.write.WriteActivityStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.b.f
            public CustomMessage<?> process(CustomMessage<?> customMessage, CustomMessageTask customMessageTask) {
                Class<?> cls;
                if (customMessage != null) {
                    Object data = customMessage.getData();
                    if ((data instanceof IntentConfig) && ((IntentConfig) data).getContext() != null && (WriteActivityConfig.class == (cls = data.getClass()) || RecordVideoActivityConfig.class == cls || WriteVoteActivityConfig.class == cls)) {
                        String simpleName = ((IntentConfig) data).getContext().getClass().getSimpleName();
                        if ("FrsActivity".equals(simpleName) || "MainTabActivity".equals(simpleName)) {
                            com.baidu.tieba.tbadkCore.writeModel.a.dOU().E(com.baidu.adp.base.j.K(((IntentConfig) data).getContext()).getUniqueId());
                        }
                    }
                }
                return customMessage;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(TbPageContext<?> tbPageContext) {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        if (Build.VERSION.SDK_INT <= olR && Build.VERSION.SDK_INT >= olQ) {
            R(tbPageContext);
        } else {
            S(tbPageContext);
        }
    }

    private static void R(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.browser.a.startWebActivity(tbPageContext.getPageActivity(), TbadkCoreApplication.getInst().getString(R.string.feedback), TbConfig.FEED_BACK_WEB_VIEW_URL, true, true, false, false, true);
    }

    private static void S(TbPageContext<?> tbPageContext) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(tbPageContext.getPageActivity(), true, RequestResponseCode.REQUEST_FEEDBACK)));
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData.getIfpost() == 0) {
            l.showToast(tbPageContext.getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        WriteActivityConfig.newInstance(tbPageContext.getPageActivity()).setType(9).setForumId(TbConfig.getPositionPagerId()).setForumName(TbConfig.getPositionPagerName()).setAntiData(antiData).send();
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.UEXCEPTION_MESSAGE) { // from class: com.baidu.tieba.write.write.WriteActivityStatic.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && bd.getCurrentActivity() != null && bd.getCurrentActivity().indexOf("NewVcode") != -1) {
                    TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                }
            }
        });
    }

    public static void cOu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.write.write.WriteActivityStatic.4
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.tieba.c.c> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, new com.baidu.tieba.write.b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        com.baidu.tieba.tbadkCore.a.a.c(309686, UrlParserSocketResponseMessage.class, false);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_URL_PARSER_MESSAGE, com.baidu.tieba.tbadkCore.a.a.bV(TbConfig.URL_URL_PARSER, 309686));
        tbHttpMessageTask.setResponsedClass(UrlParserHttpResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
