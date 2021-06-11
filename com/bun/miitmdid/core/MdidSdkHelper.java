package com.bun.miitmdid.core;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.bun.miitmdid.supplier.IdSupplier;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@Keep
/* loaded from: classes6.dex */
public class MdidSdkHelper {
    public static String TAG = "MdidSdkHelper";
    @Keep
    public static boolean _OuterIsOk = true;
    @Keep
    public String sdk_date = "2019120111";

    /* loaded from: classes6.dex */
    public static class a implements IdSupplier {
        @Override // com.bun.miitmdid.supplier.IdSupplier
        public String getAAID() {
            return "";
        }

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public String getOAID() {
            return "";
        }

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public String getVAID() {
            return "";
        }

        @Override // com.bun.miitmdid.supplier.IdSupplier
        public boolean isSupported() {
            return false;
        }
    }

    @Keep
    public static int InitSdk(Context context, boolean z, IIdentifierListener iIdentifierListener) {
        try {
            if (!_OuterIsOk) {
                if (iIdentifierListener != null) {
                    iIdentifierListener.OnSupport(false, new a());
                }
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Class<?> cls = Class.forName("com.bun.miitmdid.core.MdidSdk");
            if (cls == null) {
                logd(z, "not found class:com.bun.miitmdid.core.MdidSdk");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Constructor<?> constructor = cls.getConstructor(Boolean.TYPE);
            if (constructor == null) {
                logd(z, "not found MdidSdk Constructor");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Object newInstance = constructor.newInstance(Boolean.valueOf(z));
            if (newInstance == null) {
                logd(z, "Create MdidSdk Instance failed");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Method declaredMethod = cls.getDeclaredMethod("InitSdk", Context.class, IIdentifierListener.class);
            if (declaredMethod == null) {
                logd(z, "not found MdidSdk InitSdk function");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            int intValue = ((Integer) declaredMethod.invoke(newInstance, context, iIdentifierListener)).intValue();
            logd(z, "call and retvalue:" + intValue);
            return intValue;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            loge(z, e2);
            logd(z, "exception exit");
            return ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public static void logd(boolean z, String str) {
        if (z) {
            Log.d(TAG, str);
        }
    }

    public static void loge(boolean z, Exception exc) {
        if (z) {
            Log.e(TAG, exc.getClass().getSimpleName(), exc);
        }
    }
}
