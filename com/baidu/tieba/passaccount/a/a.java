package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a eor = null;
    private final a.InterfaceC0037a eos = new b(this);

    private a() {
    }

    public static a aLA() {
        if (eor == null) {
            eor = new a();
        }
        return eor;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b ck(String str) {
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
                            bVar.Sc = split[1];
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
    public void oT() {
        AccountData currentAccountObj;
        a.b ck;
        if (i.hj() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (ck = ck(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.c.a(currentAccountObj.getAccount(), ck.mBduss, ck.Sc, currentAccountObj.getStoken(), this.eos);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0037a interfaceC0037a) {
        return com.baidu.tieba.model.c.a(str, str2, str3, str4, interfaceC0037a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData h(String str, String str2, String str3, String str4) {
        return com.baidu.tieba.model.c.F(str, str2, str3);
    }
}
