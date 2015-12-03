package com.baidu.tieba.passaccount.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.passaccount.a.f;
/* loaded from: classes.dex */
public class a extends com.baidu.tbadk.core.a.a {
    private static a cws = null;
    private InterfaceC0077a cwt = null;
    private final a.InterfaceC0041a cwu = new b(this);
    private final f.a cwv = new d(this);

    /* renamed from: com.baidu.tieba.passaccount.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0077a {
        void ci(String str);

        void onSuccess();
    }

    private a() {
    }

    public static a aiN() {
        if (cws == null) {
            cws = new a();
        }
        return cws;
    }

    @Override // com.baidu.tbadk.core.a.a
    public a.b ch(String str) {
        a.b bVar;
        Exception e;
        if (str != null) {
            try {
                String[] split = str.split("[|]");
                if (split != null && split.length >= 1) {
                    bVar = new a.b();
                    try {
                        bVar.wy = split[0];
                        if (split.length >= 2) {
                            bVar.TV = split[1];
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
    public void rq() {
        AccountData currentAccountObj;
        a.b ch;
        if (i.iP() && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null && (ch = ch(currentAccountObj.getBDUSS())) != null) {
            com.baidu.tieba.model.a.a(currentAccountObj.getAccount(), ch.wy, ch.TV, this.cwu);
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
