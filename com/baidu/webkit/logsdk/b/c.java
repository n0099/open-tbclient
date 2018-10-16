package com.baidu.webkit.logsdk.b;
/* loaded from: classes2.dex */
public final class c implements com.baidu.webkit.logsdk.d {
    final /* synthetic */ b a;

    public c(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.webkit.logsdk.d
    public final void a(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            b.a(this.a);
        } else {
            String str = new String(bArr);
            com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogConfigLoader jsonString", str);
            this.a.a(str);
        }
        com.baidu.webkit.logsdk.a.b a = com.baidu.webkit.logsdk.a.b.a();
        com.baidu.webkit.logsdk.d.c.a("BdLogSDK", "BdLogManager setReady = true", null);
        a.a = true;
        if (!a.a || a.c == null) {
            return;
        }
        a.c.sendMessage(a.c.obtainMessage(2));
    }
}
