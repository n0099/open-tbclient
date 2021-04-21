package com.baidu.wallet.paysdk;

import android.content.Context;
import com.baidu.apollon.statistics.PayStatisticsUtil;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import com.baidu.wallet.api.ILightappInvokerCallback;
import com.baidu.wallet.core.DebugConfig;
import com.baidu.wallet.core.utils.LogUtil;
import com.baidu.wallet.lightapp.base.LightappConstants;
import com.baidu.wallet.router.LocalRouter;
import com.baidu.wallet.router.RouterCallback;
import com.baidu.wallet.router.RouterRequest;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f25114a;

    /* renamed from: b  reason: collision with root package name */
    public String f25115b = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    public boolean f25116c = false;

    /* renamed from: d  reason: collision with root package name */
    public Class<?> f25117d;

    /* renamed from: e  reason: collision with root package name */
    public Method f25118e;

    /* renamed from: f  reason: collision with root package name */
    public Class<?> f25119f;

    /* loaded from: classes5.dex */
    public static class a implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        public ILightappInvokerCallback f25125a;

        public a(ILightappInvokerCallback iLightappInvokerCallback) {
            this.f25125a = iLightappInvokerCallback;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (this.f25125a != null) {
                if ("onResult".equals(method.getName())) {
                    if (objArr != null && objArr.length >= 2) {
                        this.f25125a.onResult(((Integer) objArr[0]).intValue(), (String) objArr[1]);
                    }
                    return null;
                }
                return method.invoke(this.f25125a, objArr);
            }
            return null;
        }
    }

    public b(String str) {
        this.f25114a = "";
        this.f25114a = str;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[IPUT, MOVE_EXCEPTION, IGET, CONST_STR, INVOKE, IPUT, MOVE_EXCEPTION] complete} */
    public void a(final Context context, final String str, final ILightappInvokerCallback iLightappInvokerCallback) {
        LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_getMethodList"), new RouterCallback() { // from class: com.baidu.wallet.paysdk.b.1
            @Override // com.baidu.wallet.router.RouterCallback
            public void onResult(int i, HashMap hashMap) {
                Set set;
                if (i != 0 || hashMap == null || (set = (Set) hashMap.get("data")) == null || !set.contains("callNativeVoice")) {
                    return;
                }
                LocalRouter.getInstance(context).route(context, new RouterRequest().provider(BaiduWalletServiceProviderMap.PLUGIN_LANGBRIGE).action("langbrige_invoke").data("options", str).data("invoke_callback", iLightappInvokerCallback), new RouterCallback() { // from class: com.baidu.wallet.paysdk.b.1.1
                    @Override // com.baidu.wallet.router.RouterCallback
                    public void onResult(int i2, HashMap hashMap2) {
                    }
                });
                PayStatisticsUtil.onEvent("callNativeVoiceByHostApp");
            }
        });
        if (!this.f25116c) {
            try {
                this.f25117d = Class.forName("com.baidu.walletfacesdk.LightInvokerImpl");
                Class<?> cls = Class.forName("com.baidu.walletfacesdk.LightInvokerCallback");
                this.f25119f = cls;
                this.f25118e = this.f25117d.getDeclaredMethod(LightappConstants.METHOD_INVOKE_BD_WALLET_NATIVE, Context.class, String.class, Boolean.TYPE, cls);
            } finally {
                try {
                } finally {
                }
            }
        }
        if (this.f25117d != null && this.f25119f != null && this.f25118e != null) {
            try {
                this.f25118e.invoke(null, context, str, Boolean.valueOf("ONLINE".equals(DebugConfig.getInstance().getEnvironment())), Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{this.f25119f}, new a(iLightappInvokerCallback)));
                return;
            } catch (Throwable th) {
                LogUtil.e(this.f25115b, "reflect callNativeVoice fail!", th);
                String a2 = a(iLightappInvokerCallback, "reflect callNativeVoice fail!");
                iLightappInvokerCallback.onResult(1, a2);
                ArrayList arrayList = new ArrayList();
                arrayList.add(a2);
                PayStatisticsUtil.onEventWithValues(this.f25114a, arrayList);
                return;
            }
        }
        String a3 = a(iLightappInvokerCallback, "reflect callNativeVoice fail!");
        iLightappInvokerCallback.onResult(1, a3);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(a3);
        PayStatisticsUtil.onEventWithValues(this.f25114a, arrayList2);
    }

    private String a(ILightappInvokerCallback iLightappInvokerCallback, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(RouterCallback.KEY_ERROR_CODE, 10003);
            jSONObject2.put("des", str);
            jSONObject.put("result", 10003);
            jSONObject.put("cnt", jSONObject2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
