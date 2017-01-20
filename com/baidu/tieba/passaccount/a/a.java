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
    private static a ecw = null;
    private InterfaceC0067a ecx = null;
    private final a.InterfaceC0032a ecy = new b(this);
    private final f.a ecz = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0067a {
        void cf(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a aJe() {
        if (ecw == null) {
            ecw = new a();
        }
        return ecw;
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
                        bVar.pS = split[0];
                        if (split.length >= 2) {
                            bVar.ND = split[1];
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
    public void oL() {
        AccountData currentAccountObj;
        a.b ce;
        if (i.gk() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (ce = ce(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), ce.pS, ce.ND, currentAccountObj.getStoken(), this.ecy);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0032a interfaceC0032a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0032a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData h(String str, String str2, String str3, String str4) {
        return com.baidu.tieba.model.b.H(str, str2, str3);
    }
}
