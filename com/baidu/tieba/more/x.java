package com.baidu.tieba.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkSettings;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SystemHelpSettingActivityConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements q {
    final /* synthetic */ MoreActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MoreActivity moreActivity) {
        this.this$0 = moreActivity;
    }

    @Override // com.baidu.tieba.more.q
    public void gJ(int i) {
        af afVar;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i == 5) {
                                            this.this$0.sendMessage(new CustomMessage(2002001, new SystemHelpSettingActivityConfig(this.this$0.getPageContext().getPageActivity())));
                                            return;
                                        } else if (i != 9) {
                                            if (i == 10) {
                                                afVar = this.this$0.buv;
                                                afVar.Vp();
                                                return;
                                            } else if (i == 12) {
                                                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
                                                TbadkCoreApplication.m255getInst().deleteAccountAllInfo(currentAccount);
                                                TbadkCoreApplication.setCurrentAccount(null, this.this$0.getPageContext().getPageActivity());
                                                TbadkCoreApplication.m255getInst().onUserChanged();
                                                com.baidu.tbadk.core.b.b.a(this.this$0.getPageContext().getPageActivity(), 11, false);
                                                return;
                                            } else if (i == 11) {
                                                TbadkSettings.getInst().saveBoolean("is_exit_app_not_start_websocket", true);
                                                BdSocketLinkService.close("exit app");
                                                com.baidu.tbadk.core.b.b.a(this.this$0.getPageContext().getPageActivity(), 12, false);
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            this.this$0.Vk();
                                            return;
                                        }
                                    }
                                    this.this$0.Vd();
                                    return;
                                }
                                this.this$0.Vc();
                                return;
                            }
                            this.this$0.Ve();
                            return;
                        }
                        this.this$0.Vj();
                        return;
                    }
                    this.this$0.Vf();
                    return;
                }
                this.this$0.Vg();
                return;
            }
            this.this$0.Vh();
            return;
        }
        this.this$0.Vi();
    }
}
