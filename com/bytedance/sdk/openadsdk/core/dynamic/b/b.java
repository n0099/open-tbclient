package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes6.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    private List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) ? Arrays.asList(DI.APP_INFO_NAME, "adInfo", "getTemplateInfo") : (List) invokeV.objValue;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:406)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:204)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:138)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    @androidx.annotation.Keep
    @com.bytedance.JProtect
    public org.json.JSONObject a() {
        /*
            r4 = this;
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.bytedance.sdk.openadsdk.core.dynamic.b.b.$ic
            if (r0 != 0) goto L89
        L4:
            r0 = 55
            r1 = 0
        L7:
            r2 = 72
        L9:
            switch(r2) {
                case 72: goto L84;
                case 73: goto L17;
                case 74: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L7
        Ld:
            switch(r1) {
                case 52: goto L7;
                case 53: goto L11;
                case 54: goto L84;
                default: goto L10;
            }
        L10:
            goto L19
        L11:
            switch(r0) {
                case 29: goto L19;
                case 30: goto L7;
                case 31: goto Ld;
                default: goto L14;
            }
        L14:
            r0 = 30
            goto L11
        L17:
            r0 = 57
        L19:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.util.List r2 = r4.b()
            java.util.Iterator r2 = r2.iterator()
        L2b:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L3b
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            r1.put(r3)
            goto L2b
        L3b:
            java.lang.String r2 = "appName"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.c.a.a()     // Catch: java.lang.Exception -> L83
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = "innerAppName"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.c.a.e()     // Catch: java.lang.Exception -> L83
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = "aid"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.c.a.b()     // Catch: java.lang.Exception -> L83
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = "sdkEdition"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.c.a.c()     // Catch: java.lang.Exception -> L83
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = "appVersion"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.c.a.d()     // Catch: java.lang.Exception -> L83
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = "netType"
            java.lang.String r3 = com.bytedance.sdk.openadsdk.c.a.f()     // Catch: java.lang.Exception -> L83
            r0.put(r2, r3)     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = "supportList"
            r0.put(r2, r1)     // Catch: java.lang.Exception -> L83
            java.lang.String r1 = "deviceId"
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.o.a()     // Catch: java.lang.Exception -> L83
            java.lang.String r2 = com.bytedance.sdk.openadsdk.c.a.a(r2)     // Catch: java.lang.Exception -> L83
            r0.put(r1, r2)     // Catch: java.lang.Exception -> L83
        L83:
            return r0
        L84:
            r2 = 73
            r1 = 16
            goto L9
        L89:
            r2 = r0
            r3 = 1048576(0x100000, float:1.469368E-39)
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeV(r3, r4)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            org.json.JSONObject r1 = (org.json.JSONObject) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.dynamic.b.b.a():org.json.JSONObject");
    }
}
