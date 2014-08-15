package com.baidu.tieba.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.link.BdSocketLinkService;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements r {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.tieba.more.r
    public void a(int i) {
        ac acVar;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 8) {
                                        if (i == 5) {
                                            SystemHelpSettingActivity.a(this.a);
                                            return;
                                        } else if (i != 9) {
                                            if (i == 10) {
                                                acVar = this.a.a;
                                                acVar.d();
                                                return;
                                            } else if (i == 12) {
                                                String currentAccount = TbadkApplication.getCurrentAccount();
                                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2008015, currentAccount));
                                                com.baidu.tieba.util.k.g(currentAccount);
                                                TbadkApplication.setCurrentAccount(null, this.a);
                                                TbadkApplication.m252getInst().onUserChanged();
                                                com.baidu.tbadk.core.b.b.a(this.a, 11, false);
                                                return;
                                            } else if (i == 11) {
                                                com.baidu.tbadk.h.a().b("is_exit_app_not_start_websocket", true);
                                                BdSocketLinkService.close("exit app");
                                                com.baidu.tbadk.core.b.b.a(this.a, 12, false);
                                                return;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            this.a.m();
                                            return;
                                        }
                                    }
                                    this.a.f();
                                    return;
                                }
                                this.a.e();
                                return;
                            }
                            this.a.g();
                            return;
                        }
                        this.a.l();
                        return;
                    }
                    this.a.h();
                    return;
                }
                this.a.i();
                return;
            }
            this.a.j();
            return;
        }
        this.a.k();
    }
}
