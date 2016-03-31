package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements s {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.tieba.setting.more.s
    public void oN(int i) {
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
                                                this.this$0.ecU.aOl();
                                                return;
                                            } else if (i == 12) {
                                                TbadkCoreApplication.m411getInst().deleteAccountAllInfo(TbadkCoreApplication.getCurrentAccount());
                                                TbadkCoreApplication.setCurrentAccount(null, this.this$0.getPageContext().getPageActivity());
                                                com.baidu.tbadk.coreExtra.a.a.yn().yp();
                                                TbadkCoreApplication.m411getInst().onUserChanged();
                                                this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(this.this$0.getPageContext().getPageActivity()).createRefreshCfg(2, false)));
                                                return;
                                            } else if (i == 11) {
                                                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                                                BdSocketLinkService.close("exit app");
                                                com.baidu.tbadk.core.d.b.b(this.this$0.getPageContext().getPageActivity(), 12, false);
                                                return;
                                            } else if (i != 13) {
                                                return;
                                            } else {
                                                this.this$0.aNW();
                                                TiebaStatic.log("c10017");
                                                return;
                                            }
                                        } else {
                                            this.this$0.aOd();
                                            return;
                                        }
                                    }
                                    this.this$0.aNV();
                                    return;
                                }
                                this.this$0.Vj();
                                return;
                            }
                            this.this$0.aNX();
                            return;
                        }
                        this.this$0.aOc();
                        return;
                    }
                    this.this$0.aNY();
                    return;
                }
                this.this$0.aNZ();
                return;
            }
            this.this$0.aOa();
            return;
        }
        this.this$0.aOb();
    }
}
