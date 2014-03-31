package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x implements com.baidu.adp.framework.task.a<AccountData> {
    @Override // com.baidu.adp.framework.task.a
    public final CustomResponsedMessage<?> a(com.baidu.adp.framework.message.a<AccountData> aVar) {
        if (com.baidu.adp.lib.util.i.c()) {
            TbadkApplication.j();
            r.a(aVar.a());
            return null;
        } else if (r.c() != null) {
            r.c().b.post(new y(this, aVar));
            return null;
        } else {
            return null;
        }
    }
}
