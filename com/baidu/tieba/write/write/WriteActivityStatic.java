package com.baidu.tieba.write.write;

import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVideoActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.t;
import com.baidu.tieba.write.video.WriteVideoActivity;
/* loaded from: classes.dex */
public class WriteActivityStatic {
    private static int feg = 11;
    private static int feh = 18;

    static {
        TbadkCoreApplication.m11getInst().RegisterIntent(WriteActivityConfig.class, WriteActivity.class);
        TbadkCoreApplication.m11getInst().RegisterIntent(WriteVideoActivityConfig.class, WriteVideoActivity.class);
        com.baidu.tieba.tbadkCore.location.d.aUE();
        com.baidu.tbadk.core.util.bg.us().a("feedback:", new bo());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(TbPageContext<?> tbPageContext) {
        com.baidu.adp.lib.stats.a.dN().dW();
        if (Build.VERSION.SDK_INT <= feh && Build.VERSION.SDK_INT >= feg) {
            r(tbPageContext);
        } else {
            s(tbPageContext);
        }
    }

    private static void r(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.browser.f.a(tbPageContext.getPageActivity(), TbadkCoreApplication.m11getInst().getString(t.j.feedback), TbConfig.FEED_BACK_WEB_VIEW_URL, true, true, false, false, true);
    }

    private static void s(TbPageContext<?> tbPageContext) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (currentAccount == null || currentAccount.length() <= 0) {
            TbadkCoreApplication.m11getInst().login(tbPageContext, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig((Context) tbPageContext.getPageActivity(), tbPageContext.getString(t.j.login_feedback), true, 12008)));
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
}
