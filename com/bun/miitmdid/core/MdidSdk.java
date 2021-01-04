package com.bun.miitmdid.core;

import android.content.Context;
import android.os.Build;
import androidx.annotation.Keep;
import com.bun.miitmdid.a.b;
import com.bun.miitmdid.b.c;
import com.bun.miitmdid.supplier.IdSupplier;
import com.bun.miitmdid.supplier.InnerIdSupplier;
import com.bun.miitmdid.supplier.b;
import com.bun.miitmdid.utils.SupplierListener;
import com.bun.miitmdid.utils.a;
@Keep
/* loaded from: classes6.dex */
public class MdidSdk implements SupplierListener {
    private IIdentifierListener _InnerListener;
    private b _setting;

    @Keep
    public MdidSdk() {
        try {
            a.a(true);
        } catch (Exception e) {
            a.b("mdidsdk", "extractor exception!", e);
        }
    }

    @Keep
    public MdidSdk(boolean z) {
        try {
            a.a(z);
        } catch (Exception e) {
            a.b("mdidsdk", "extractor exception!", e);
        }
    }

    private int _InnerFailed(int i, IdSupplier idSupplier) {
        OnSupport(idSupplier != null ? idSupplier.isSupported() : false, idSupplier);
        return i;
    }

    @Keep
    public int InitSdk(Context context, IIdentifierListener iIdentifierListener) {
        this._InnerListener = iIdentifierListener;
        com.bun.miitmdid.utils.b.a(context);
        b.a a2 = b.a.a(Build.MANUFACTURER);
        if (a2 == b.a.UNSUPPORT) {
            return _InnerFailed(ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT, new com.bun.miitmdid.supplier.a());
        }
        com.bun.miitmdid.a.a hK = com.bun.miitmdid.a.a.hK(context);
        if (hK == null) {
            return _InnerFailed(ErrorCode.INIT_ERROR_LOAD_CONFIGFILE, new com.bun.miitmdid.supplier.a());
        }
        this._setting = hK;
        InnerIdSupplier innerIdSupplier = null;
        switch (a2) {
            case XIAOMI:
                innerIdSupplier = new com.bun.miitmdid.supplier.i.b(context);
                break;
            case VIVO:
                innerIdSupplier = new com.bun.miitmdid.supplier.h.a(context);
                ((com.bun.miitmdid.supplier.h.a) innerIdSupplier).a(this._setting.a());
                break;
            case HUA_WEI:
                innerIdSupplier = new com.bun.miitmdid.supplier.b.a(context);
                break;
            case OPPO:
                innerIdSupplier = new com.bun.miitmdid.supplier.g.a(context);
                break;
            case MOTO:
            case LENOVO:
                innerIdSupplier = new com.bun.miitmdid.supplier.e.b(context, this);
                break;
            case ASUS:
                innerIdSupplier = new com.bun.miitmdid.supplier.a.a(context, this);
                break;
            case SAMSUNG:
                innerIdSupplier = new com.bun.miitmdid.supplier.sumsung.a(context, this);
                break;
            case MEIZU:
            case ALPS:
                innerIdSupplier = new com.bun.miitmdid.supplier.d.a(context);
                break;
            case NUBIA:
                innerIdSupplier = new com.bun.miitmdid.supplier.f.b(context);
                break;
        }
        if (innerIdSupplier == null) {
            return _InnerFailed(ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, new com.bun.miitmdid.supplier.a());
        }
        if (!innerIdSupplier.b()) {
            innerIdSupplier.a(this);
            return ErrorCode.INIT_ERROR_RESULT_DELAY;
        } else if (innerIdSupplier.isSupported()) {
            OnSupport(true, innerIdSupplier);
            return 0;
        } else {
            return _InnerFailed(ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, innerIdSupplier);
        }
    }

    @Override // com.bun.miitmdid.utils.SupplierListener
    public void OnSupport(boolean z, IdSupplier idSupplier) {
        if (this._InnerListener != null) {
            this._InnerListener.OnSupport(z, idSupplier);
        }
        c cVar = new c();
        String str = "";
        String str2 = "";
        String str3 = "";
        if (idSupplier != null) {
            str = idSupplier.getOAID();
            str2 = idSupplier.getVAID();
            str3 = idSupplier.getAAID();
            if (idSupplier instanceof InnerIdSupplier) {
                ((InnerIdSupplier) idSupplier).shutDown();
            }
        }
        cVar.b(z, "", str, str2, str3);
    }

    public void UnInitSdk() {
    }
}
