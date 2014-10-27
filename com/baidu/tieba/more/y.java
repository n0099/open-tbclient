package com.baidu.tieba.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.TbadkSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements r {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.tieba.more.r
    public void gF(int i) {
        ag agVar;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i == 5) {
                                            SystemHelpSettingActivity.ae(this.this$0);
                                            return;
                                        } else if (i != 9) {
                                            if (i == 10) {
                                                agVar = this.this$0.bqT;
                                                agVar.UZ();
                                                return;
                                            } else if (i == 12) {
                                                String currentAccount = TbadkApplication.getCurrentAccount();
                                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
                                                com.baidu.tieba.util.j.hB(currentAccount);
                                                TbadkApplication.setCurrentAccount(null, this.this$0);
                                                TbadkApplication.m251getInst().onUserChanged();
                                                com.baidu.tbadk.core.b.b.a(this.this$0, 11, false);
                                                return;
                                            } else if (i == 11) {
                                                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                                                BdSocketLinkService.close("exit app");
                                                com.baidu.tbadk.core.b.b.a(this.this$0, 12, false);
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            this.this$0.UV();
                                            return;
                                        }
                                    }
                                    this.this$0.UO();
                                    return;
                                }
                                this.this$0.UN();
                                return;
                            }
                            this.this$0.UP();
                            return;
                        }
                        this.this$0.UU();
                        return;
                    }
                    this.this$0.UQ();
                    return;
                }
                this.this$0.UR();
                return;
            }
            this.this$0.US();
            return;
        }
        this.this$0.UT();
    }
}
