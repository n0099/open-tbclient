package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a cdU = null;
    private InterfaceC0069a cdV = null;
    private final a.InterfaceC0040a cdW = new b(this);
    private final f.a cdX = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0069a {
        void cb(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a aeu() {
        if (cdU == null) {
            cdU = new a();
        }
        return cdU;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b ca(String str) {
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
                            bVar.TE = split[1];
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
    public void rc() {
        AccountData currentAccountObj;
        a.b ca;
        if (i.iN() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (ca = ca(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), ca.ws, ca.TE, this.cdW);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public void a(String str, String str2, String str3, a.InterfaceC0040a interfaceC0040a) {
        com.baidu.tieba.model.a.a(str, str2, str3, interfaceC0040a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData j(String str, String str2, String str3) {
        return com.baidu.tieba.model.a.j(str, str2, str3);
    }
}
