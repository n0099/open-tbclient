package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a dIL = null;
    private InterfaceC0070a dIM = null;
    private final a.InterfaceC0033a dIN = new b(this);
    private final f.a dIO = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0070a {
        void cd(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a aCS() {
        if (dIL == null) {
            dIL = new a();
        }
        return dIL;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cc(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.mZ = split[0];
                        if (split.length >= 2) {
                            bVar.Mg = split[1];
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
    public void of() {
        AccountData currentAccountObj;
        a.b cc;
        if (i.fr() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cc = cc(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), cc.mZ, cc.Mg, this.dIN);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a) {
        return com.baidu.tieba.model.a.a(str, str2, str3, interfaceC0033a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData p(String str, String str2, String str3) {
        return com.baidu.tieba.model.a.p(str, str2, str3);
    }
}
