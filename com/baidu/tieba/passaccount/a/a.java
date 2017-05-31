package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a efw = null;
    private final a.InterfaceC0035a efx = new b(this);

    private a() {
    }

    public static a aHH() {
        if (efw == null) {
            efw = new a();
        }
        return efw;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b ce(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.mBduss = split[0];
                        if (split.length >= 2) {
                            bVar.Sh = split[1];
                            return bVar;
                        }
                        return bVar;
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e.getMessage());
                        return bVar;
                    }
                }
            } catch (Exception e3) {
                bVar = null;
                e = e3;
            }
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.a.a
    public void oW() {
        AccountData currentAccountObj;
        a.b ce;
        if (i.hk() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (ce = ce(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.c.a(currentAccountObj.getAccount(), ce.mBduss, ce.Sh, currentAccountObj.getStoken(), this.efx);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0035a interfaceC0035a) {
        return com.baidu.tieba.model.c.a(str, str2, str3, str4, interfaceC0035a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData h(String str, String str2, String str3, String str4) {
        return com.baidu.tieba.model.c.B(str, str2, str3);
    }
}
