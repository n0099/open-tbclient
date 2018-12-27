package com.baidu.tieba.write.write;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.passhost.pluginsdk.service.IEventCenterService;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ExceptionData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity;
import com.baidu.tieba.write.transmit.SelectForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
import com.baidu.tieba.write.video.WriteVideoActivity;
import java.util.Map;
/* loaded from: classes3.dex */
public class WriteActivityStatic {
    private static int ica = 11;
    private static int icb = 18;

    static {
        TbadkCoreApplication.getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TransmitPostEditActivityConfig.class, TransmitPostEditActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteVideoActivityConfig.class, WriteVideoActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(TransmitForumActivityConfig.class, TransmitForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(SelectForumActivityConfig.class, SelectForumActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(HotTopicChangeActivityConfig.class, HotTopicChangeFourmActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(WriteUrlActivityConfig.class, WriteUrlActivity.class);
        LocationModel.bET();
        ay.Ef().a("feedback:", new ay.b() { // from class: com.baidu.tieba.write.write.WriteActivityStatic.1
            @Override // com.baidu.tbadk.core.util.ay.b
            public void a(TbPageContext<?> tbPageContext, Map<String, String> map) {
                if (tbPageContext != null) {
                    WriteActivityStatic.C(tbPageContext);
                }
            }
        });
        registerListener();
        com.baidu.tieba.tbadkCore.a.a.a(309450, GetRepostForumSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309450, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, TbConfig.CMD_GET_REPOST_FORUM_LIST, GetRepostForumHttpResMessage.class, false, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(TbPageContext<?> tbPageContext) {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        if (Build.VERSION.SDK_INT <= icb && Build.VERSION.SDK_INT >= ica) {
            G(tbPageContext);
        } else {
            H(tbPageContext);
        }
    }

    private static void G(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.browser.a.a(tbPageContext.getPageActivity(), TbadkCoreApplication.getInst().getString(e.j.feedback), TbConfig.FEED_BACK_WEB_VIEW_URL, true, true, false, false, true);
    }

    private static void H(TbPageContext<?> tbPageContext) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), true, (int) IEventCenterService.EventId.EventMode.SAPIACCOUNT_CAPTCHA)));
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            l.showToast(tbPageContext.getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteActivityConfig(tbPageContext.getPageActivity(), 9, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016301) { // from class: com.baidu.tieba.write.write.WriteActivityStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ExceptionData) && aw.Ed() != null && aw.Ed().indexOf("NewVcode") != -1) {
                    TbadkCoreApplication.getInst().setNewVcodeWebviewCrashCount(TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() + 1);
                }
            }
        });
    }
}
