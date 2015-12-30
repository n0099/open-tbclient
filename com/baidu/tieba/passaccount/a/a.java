package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a czW = null;
    private InterfaceC0071a czX = null;
    private final a.InterfaceC0041a czY = new b(this);
    private final f.a czZ = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0071a {
        void ck(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a ajT() {
        if (czW == null) {
            czW = new a();
        }
        return czW;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b cj(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.wA = split[0];
                        if (split.length >= 2) {
                            bVar.Uv = split[1];
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
    public void qZ() {
        AccountData currentAccountObj;
        a.b cj;
        if (i.iQ() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (cj = cj(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), cj.wA, cj.Uv, this.czY);
        }
    }

    @Override // com.baidu.tbadk.core.a.a
    public void a(String str, String str2, String str3, a.InterfaceC0041a interfaceC0041a) {
        com.baidu.tieba.model.a.a(str, str2, str3, interfaceC0041a);
    }

    @Override // com.baidu.tbadk.core.a.a
    public AccountData k(String str, String str2, String str3) {
        return com.baidu.tieba.model.a.k(str, str2, str3);
    }
}
