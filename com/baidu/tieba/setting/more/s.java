package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SystemHelpSettingActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements r {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.tieba.setting.more.r
    public void jo(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i == 5) {
                                            this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SystemHelpSettingActivityConfig(this.this$0.getPageContext().getPageActivity())));
                                            return;
                                        } else if (i != 9) {
                                            if (i == 10) {
                                                this.this$0.cxw.alC();
                                                return;
                                            } else if (i == 12) {
                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.IM_DELETE_IM_DB, currentAccount));
                                                TbadkCoreApplication.m411getInst().deleteAccountAllInfo(currentAccount);
                                                TbadkCoreApplication.setCurrentAccount(null, this.this$0.getPageContext().getPageActivity());
                                                com.baidu.tbadk.coreExtra.act.a.vZ().we();
                                                TbadkCoreApplication.m411getInst().onUserChanged();
                                                com.baidu.tbadk.core.c.b.a(this.this$0.getPageContext().getPageActivity(), 11, false);
                                                return;
                                            } else if (i == 11) {
                                                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                                                BdSocketLinkService.close("exit app");
                                                com.baidu.tbadk.core.c.b.a(this.this$0.getPageContext().getPageActivity(), 12, false);
                                                return;
                                            } else if (i != 13) {
                                                return;
                                            } else {
                                                this.this$0.als();
                                                TiebaStatic.log("c10017");
                                                return;
                                            }
                                        } else {
                                            this.this$0.alz();
                                            return;
                                        }
                                    }
                                    this.this$0.alr();
                                    return;
                                }
                                this.this$0.goToFeedBack();
                                return;
                            }
                            this.this$0.alt();
                            return;
                        }
                        this.this$0.aly();
                        return;
                    }
                    this.this$0.alu();
                    return;
                }
                this.this$0.alv();
                return;
            }
            this.this$0.alw();
            return;
        }
        this.this$0.alx();
    }
}
