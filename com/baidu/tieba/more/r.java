package com.baidu.tieba.more;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class r implements p {
    final /* synthetic */ MoreActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MoreActivity moreActivity) {
        this.a = moreActivity;
    }

    @Override // com.baidu.tieba.more.p
    public final void a(int i) {
        w wVar;
        if (i == 0) {
            MoreActivity.b(this.a);
        } else if (i == 1) {
            MoreActivity.c(this.a);
        } else if (i == 2) {
            MoreActivity.d(this.a);
        } else if (i != 3) {
            if (i != 4) {
                if (i != 6) {
                    if (i != 7) {
                        if (i == 8) {
                            MoreActivity.i(this.a);
                            return;
                        } else if (i == 5) {
                            SystemHelpSettingActivity.a(this.a);
                            return;
                        } else if (i != 9) {
                            if (i == 10) {
                                wVar = this.a.a;
                                wVar.f();
                                return;
                            } else if (i == 12) {
                                AccountData N = TbadkApplication.N();
                                String E = TbadkApplication.E();
                                com.baidu.adp.framework.c.a().b(new CustomResponsedMessage(2008015, E));
                                com.baidu.tieba.util.k.h(E);
                                TbadkApplication.a((AccountData) null, this.a);
                                com.baidu.tbadk.core.a.l.a().b(E);
                                com.baidu.tbadk.core.a.l.a().a(N.getBDUSS());
                                TbadkApplication.j();
                                TbadkApplication.M();
                                com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
                                com.baidu.tbadk.core.d.b.a(this.a, 11, false);
                                return;
                            } else if (i == 11) {
                                com.baidu.tbadk.core.d.b.a(this.a, 12, false);
                                return;
                            } else {
                                return;
                            }
                        } else {
                            r0.sendMessage(new com.baidu.adp.framework.message.a(2001001, new com.baidu.tbadk.core.b.am(this.a)));
                            return;
                        }
                    }
                    this.a.b();
                    return;
                }
                AboutActivity.a(this.a);
                return;
            }
            MsgRemindActivity.a(this.a);
        } else {
            BrowseSettingActivity.a(this.a);
        }
    }
}
