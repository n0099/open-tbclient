package com.baidu.tieba.more;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements p {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.tieba.more.p
    public void a(int i) {
        w wVar;
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
                                                wVar = this.a.a;
                                                wVar.e();
                                                return;
                                            } else if (i == 12) {
                                                String currentAccount = TbadkApplication.getCurrentAccount();
                                                MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(2010015, currentAccount));
                                                com.baidu.tieba.util.k.h(currentAccount);
                                                TbadkApplication.setCurrentAccount(null, this.a);
                                                TbadkApplication.m252getInst().onUserChanged();
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2008001, com.baidu.tbadk.core.frameworkData.a.STOP));
                                                com.baidu.tbadk.core.b.b.a(this.a, 11, false);
                                                return;
                                            } else if (i == 11) {
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
