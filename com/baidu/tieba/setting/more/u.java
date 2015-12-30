package com.baidu.tieba.setting.more;

import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.atomData.NotLoginGuideActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.setting.SystemHelpSettingActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements s {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.tieba.setting.more.s
    public void mw(int i) {
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
                                                this.this$0.duw.aAr();
                                                return;
                                            } else if (i == 12) {
                                                com.baidu.adp.lib.h.h.hj().postDelayed(new v(this), 1000L);
                                                this.this$0.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new NotLoginGuideActivityConfig(this.this$0.getPageContext().getPageActivity(), NotLoginGuideActivityConfig.FROM_ACCOUNT)));
                                                return;
                                            } else if (i == 11) {
                                                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                                                BdSocketLinkService.close("exit app");
                                                com.baidu.tbadk.core.c.b.b(this.this$0.getPageContext().getPageActivity(), 12, false);
                                                return;
                                            } else if (i != 13) {
                                                return;
                                            } else {
                                                this.this$0.aAh();
                                                TiebaStatic.log("c10017");
                                                return;
                                            }
                                        } else {
                                            this.this$0.aAo();
                                            return;
                                        }
                                    }
                                    this.this$0.aAg();
                                    return;
                                }
                                this.this$0.goToFeedBack();
                                return;
                            }
                            this.this$0.aAi();
                            return;
                        }
                        this.this$0.aAn();
                        return;
                    }
                    this.this$0.aAj();
                    return;
                }
                this.this$0.aAk();
                return;
            }
            this.this$0.aAl();
            return;
        }
        this.this$0.aAm();
    }
}
