package com.baidu.ubs.analytics.c;

import java.util.Map;
/* loaded from: classes6.dex */
public final class j {
    public static void b(String str, final String str2, final String str3, final Map<String, String> map) {
        final com.baidu.ubs.analytics.a.a aVar = new com.baidu.ubs.analytics.a.a();
        aVar.v(str);
        com.baidu.ubs.analytics.d.c.execute(new com.baidu.ubs.analytics.d.d() { // from class: com.baidu.ubs.analytics.c.j.1
            @Override // com.baidu.ubs.analytics.d.d
            protected final void a() {
                if (map != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("{");
                    for (Map.Entry entry : map.entrySet()) {
                        stringBuffer.append("\"").append(entry.getKey()).append("\":\"").append(entry.getValue().toString().replace("\"", "\\\"")).append("\",");
                    }
                    StringBuffer stringBuffer2 = new StringBuffer(stringBuffer.subSequence(0, stringBuffer.length() - 1));
                    stringBuffer2.append("}");
                    aVar.w(stringBuffer2.toString());
                }
                try {
                    aVar.x(m.ejK().I());
                    aVar.u(String.valueOf(System.currentTimeMillis()));
                    aVar.t(str2);
                    aVar.s(str3 == null ? "" : str3);
                    new com.baidu.ubs.analytics.a.b().a(aVar);
                } catch (Exception e) {
                    if (e.getMessage() != null) {
                        com.baidu.ubs.analytics.d.b.I(e.getMessage());
                    }
                }
            }
        });
    }
}
