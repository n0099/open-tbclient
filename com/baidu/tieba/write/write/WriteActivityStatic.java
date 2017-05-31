package com.baidu.tieba.write.write;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicChangeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.atomData.WriteUrlActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
import com.baidu.tieba.write.album.AlbumActivity;
import com.baidu.tieba.write.selectForum.HotTopicChangeFourmActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivity;
import com.baidu.tieba.write.transmit.TransmitForumActivityConfig;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import com.baidu.tieba.write.vcode.newVcode.NewVcodeActivity;
import com.baidu.tieba.write.vcode.oldVcode.VcodeActivity;
import com.baidu.tieba.write.video.WriteVideoActivity;
/* loaded from: classes.dex */
public class WriteActivityStatic {
    private static int gaU = 11;
    private static int gaV = 18;

    static {
        TbadkCoreApplication.m9getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(WriteVideoActivityConfig.class, WriteVideoActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(VcodeActivityConfig.class, VcodeActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(AlbumActivityConfig.class, AlbumActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(NewVcodeActivityConfig.class, NewVcodeActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(AtListActivityConfig.class, AtListActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(WriteImageActivityConfig.class, WriteImageActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(WriteMulitImageActivityConfig.class, WriteMultiImgsActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(TransmitForumActivityConfig.class, TransmitForumActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(HotTopicChangeActivityConfig.class, HotTopicChangeFourmActivity.class);
        TbadkCoreApplication.m9getInst().RegisterIntent(WriteUrlActivityConfig.class, WriteUrlActivity.class);
        LocationModel.biR();
        com.baidu.tbadk.core.util.bb.vy().a("feedback:", new bn());
        registerListener();
        com.baidu.tieba.tbadkCore.a.a.a(309450, GetRepostForumSocketResMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309450, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, TbConfig.CMD_GET_REPOST_FORUM_LIST, GetRepostForumHttpResMessage.class, false, false, true, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void A(TbPageContext<?> tbPageContext) {
        BdStatisticsManager.getInstance().forceUploadAllLogIgnoreSwitch();
        if (Build.VERSION.SDK_INT <= gaV && Build.VERSION.SDK_INT >= gaU) {
            B(tbPageContext);
        } else {
            C(tbPageContext);
        }
    }

    private static void B(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), TbadkCoreApplication.m9getInst().getString(w.l.feedback), TbConfig.FEED_BACK_WEB_VIEW_URL, true, true, false, false, true);
    }

    private static void C(TbPageContext<?> tbPageContext) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m9getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(w.l.login_feedback), true, 12008)));
            return;
        }
        AntiData antiData = new AntiData();
        antiData.setIfpost(1);
        if (antiData != null && antiData.getIfpost() == 0) {
            com.baidu.adp.lib.util.k.showToast(tbPageContext.getPageActivity(), antiData.getForbid_info());
            return;
        }
        antiData.setIfVoice(false);
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new WriteActivityConfig(tbPageContext.getPageActivity(), 0, TbConfig.getPositionPagerId(), TbConfig.getPositionPagerName(), null, null, 0, antiData, 13003, true, false, null, false, false, null, null, null, 0)));
    }

    private static void registerListener() {
        MessageManager.getInstance().registerListener(new bo(CmdConfigCustom.UEXCEPTION_MESSAGE));
    }
}
