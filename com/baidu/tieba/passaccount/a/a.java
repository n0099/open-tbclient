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
    private static a eeR = null;
    private InterfaceC0066a eeS = null;
    private final a.InterfaceC0031a eeT = new b(this);
    private final f.a eeU = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0066a {
        void bY(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a aIv() {
        if (eeR == null) {
            eeR = new a();
        }
        return eeR;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b bX(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.xo = split[0];
                        if (split.length >= 2) {
                            bVar.SH = split[1];
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
    public void oZ() {
        AccountData currentAccountObj;
        a.b bX;
        if (i.he() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (bX = bX(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.b.a(currentAccountObj.getAccount(), bX.xo, bX.SH, currentAccountObj.getStoken(), this.eeT);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public BdAsyncTask<?, ?, ?> a(String str, String str2, String str3, String str4, a.InterfaceC0031a interfaceC0031a) {
        return com.baidu.tieba.model.b.a(str, str2, str3, str4, interfaceC0031a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData h(String str, String str2, String str3, String str4) {
        return com.baidu.tieba.model.b.E(str, str2, str3);
    }
}
