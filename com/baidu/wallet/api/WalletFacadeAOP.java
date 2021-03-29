package com.baidu.wallet.api;

import com.baidu.wallet.core.NoProguard;
import com.baidu.wallet.core.utils.LogUtil;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.ShortCompanionObject;
/* loaded from: classes5.dex */
public class WalletFacadeAOP implements NoProguard, InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public final IWalletFacade f23480a;

    public WalletFacadeAOP(IWalletFacade iWalletFacade) {
        this.f23480a = iWalletFacade;
    }

    private boolean a() {
        return BaiduWalletDelegate.getInstance().getAppContext() == null;
    }

    private void b() {
        CrabHelper.initCrab(BaiduWalletDelegate.getInstance().getAppContext());
        WalletLoginHelper.getInstance().clearOpenBduss();
    }

    private void c() {
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        if (method != null && a(method.getName())) {
            LogUtil.d(CrabHelper.CRAB_TAG, "crab aop init before method: " + method.getName());
            try {
                if (a()) {
                    return a(method.getReturnType());
                }
                b();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        Object invoke = method.invoke(this.f23480a, objArr);
        if (method != null && a(method.getName())) {
            try {
                c();
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return invoke;
    }

    private Object a(Class<?> cls) {
        try {
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InstantiationException e3) {
            e3.printStackTrace();
        }
        if (cls.isPrimitive()) {
            if (cls == Boolean.TYPE) {
                return Boolean.FALSE;
            }
            if (cls == Character.TYPE) {
                return (char) 0;
            }
            if (cls == Byte.TYPE) {
                return Byte.valueOf((byte) ByteCompanionObject.MIN_VALUE);
            }
            if (cls == Short.TYPE) {
                return Short.valueOf((short) ShortCompanionObject.MIN_VALUE);
            }
            if (cls == Integer.TYPE) {
                return Integer.MIN_VALUE;
            }
            if (cls == Long.TYPE) {
                return Long.MIN_VALUE;
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(Float.MIN_VALUE);
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(Double.MIN_VALUE);
            }
            if (cls == Void.TYPE) {
                return null;
            }
            return new Object();
        }
        return cls.newInstance();
    }

    private boolean a(String str) {
        if ("initWallet".equals(str) || "setDebugOn".equals(str) || "getBindUrl".equals(str)) {
            LogUtil.d(CrabHelper.CRAB_TAG, "crab aop init skip method: " + str);
            return false;
        }
        return true;
    }
}
