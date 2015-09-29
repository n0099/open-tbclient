package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a cdi = null;
    private InterfaceC0069a cdj = null;
    private final a.InterfaceC0040a cdk = new b(this);
    private final f.a cdl = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0069a {
        void cc(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a aed() {
        if (cdi == null) {
            cdi = new a();
        }
        return cdi;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cb(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.ws = split[0];
                        if (split.length >= 2) {
                            bVar.TC = split[1];
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
    public void re() {
        AccountData currentAccountObj;
        a.b cb;
        if (i.iM() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cb = cb(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), cb.ws, cb.TC, this.cdk);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        com.baidu.tieba.model.a.a(str, str2, str3, interfaceC0040a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData k(String str, String str2, String str3) {
        return com.baidu.tieba.model.a.k(str, str2, str3);
    }
}
