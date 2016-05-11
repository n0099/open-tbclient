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
    private static a dcf = null;
    private InterfaceC0066a dcg = null;
    private final a.InterfaceC0033a dch = new b(this);
    private final f.a dci = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066a {
        void ce(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a auK() {
        if (dcf == null) {
            dcf = new a();
        }
        return dcf;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cd(String str) {
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
    public void ok() {
        AccountData currentAccountObj;
        a.b cd;
        if (i.fq() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cd = cd(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), cd.mZ, cd.Mg, this.dch);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, a.InterfaceC0033a interfaceC0033a) {
        return com.baidu.tieba.model.a.a(str, str2, str3, interfaceC0033a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData l(String str, String str2, String str3) {
        return com.baidu.tieba.model.a.l(str, str2, str3);
    }
}
