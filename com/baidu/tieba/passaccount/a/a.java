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
    private static a cZK = null;
    private InterfaceC0073a cZL = null;
    private final a.InterfaceC0042a cZM = new b(this);
    private final f.a cZN = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0073a {
        void cg(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a auE() {
        if (cZK == null) {
            cZK = new a();
        }
        return cZK;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cf(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.xa = split[0];
                        if (split.length >= 2) {
                            bVar.Rq = split[1];
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
    public void qN() {
        AccountData currentAccountObj;
        a.b cf;
        if (i.jf() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cf = cf(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), cf.xa, cf.Rq, this.cZM);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, a.InterfaceC0042a interfaceC0042a) {
        return com.baidu.tieba.model.a.a(str, str2, str3, interfaceC0042a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData k(String str, String str2, String str3) {
        return com.baidu.tieba.model.a.k(str, str2, str3);
    }
}
