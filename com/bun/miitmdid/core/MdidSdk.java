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
/* loaded from: classes5.dex */
public class MdidSdk implements SupplierListener {
    public IIdentifierListener _InnerListener;
    public b _setting;

    /* renamed from: com.bun.miitmdid.core.MdidSdk$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26764a;

        static {
            int[] iArr = new int[b.a.values().length];
            f26764a = iArr;
            try {
                iArr[b.a.XIAOMI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26764a[b.a.VIVO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26764a[b.a.HUA_WEI.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26764a[b.a.OPPO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26764a[b.a.MOTO.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26764a[b.a.LENOVO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26764a[b.a.ASUS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26764a[b.a.SAMSUNG.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26764a[b.a.MEIZU.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26764a[b.a.ALPS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f26764a[b.a.NUBIA.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    @Keep
    public MdidSdk() {
        try {
            a.a(true);
        } catch (Exception e2) {
            a.b("mdidsdk", "extractor exception!", e2);
        }
    }

    @Keep
    public MdidSdk(boolean z) {
        try {
            a.a(z);
        } catch (Exception e2) {
            a.b("mdidsdk", "extractor exception!", e2);
        }
    }

    private int _InnerFailed(int i, IdSupplier idSupplier) {
        OnSupport(idSupplier != null ? idSupplier.isSupported() : false, idSupplier);
        return i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.bun.miitmdid.supplier.h.a */
    /* JADX WARN: Multi-variable type inference failed */
    @Keep
    public int InitSdk(Context context, IIdentifierListener iIdentifierListener) {
        this._InnerListener = iIdentifierListener;
        com.bun.miitmdid.utils.b.a(context);
        b.a a2 = b.a.a(Build.MANUFACTURER);
        if (a2 == b.a.UNSUPPORT) {
            return _InnerFailed(ErrorCode.INIT_ERROR_MANUFACTURER_NOSUPPORT, new com.bun.miitmdid.supplier.a());
        }
        com.bun.miitmdid.a.a a3 = com.bun.miitmdid.a.a.a(context);
        if (a3 == null) {
            return _InnerFailed(ErrorCode.INIT_ERROR_LOAD_CONFIGFILE, new com.bun.miitmdid.supplier.a());
        }
        this._setting = a3;
        com.bun.miitmdid.supplier.f.b bVar = null;
        switch (AnonymousClass1.f26764a[a2.ordinal()]) {
            case 1:
                bVar = new com.bun.miitmdid.supplier.i.b(context);
                break;
            case 2:
                com.bun.miitmdid.supplier.h.a aVar = new com.bun.miitmdid.supplier.h.a(context);
                aVar.a(this._setting.a());
                bVar = aVar;
                break;
            case 3:
                bVar = new com.bun.miitmdid.supplier.b.a(context);
                break;
            case 4:
                bVar = new com.bun.miitmdid.supplier.g.a(context);
                break;
            case 5:
            case 6:
                bVar = new com.bun.miitmdid.supplier.e.b(context, this);
                break;
            case 7:
                bVar = new com.bun.miitmdid.supplier.a.a(context, this);
                break;
            case 8:
                bVar = new com.bun.miitmdid.supplier.sumsung.a(context, this);
                break;
            case 9:
            case 10:
                bVar = new com.bun.miitmdid.supplier.d.a(context);
                break;
            case 11:
                bVar = new com.bun.miitmdid.supplier.f.b(context);
                break;
        }
        if (bVar == null) {
            return _InnerFailed(ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, new com.bun.miitmdid.supplier.a());
        }
        if (!bVar.b()) {
            bVar.a(this);
            return ErrorCode.INIT_ERROR_RESULT_DELAY;
        } else if (bVar.isSupported()) {
            OnSupport(true, bVar);
            return 0;
        } else {
            return _InnerFailed(ErrorCode.INIT_ERROR_DEVICE_NOSUPPORT, bVar);
        }
    }

    @Override // com.bun.miitmdid.utils.SupplierListener
    public void OnSupport(boolean z, IdSupplier idSupplier) {
        String str;
        String str2;
        String str3;
        IIdentifierListener iIdentifierListener = this._InnerListener;
        if (iIdentifierListener != null) {
            iIdentifierListener.OnSupport(z, idSupplier);
        }
        c cVar = new c();
        if (idSupplier != null) {
            String oaid = idSupplier.getOAID();
            String vaid = idSupplier.getVAID();
            String aaid = idSupplier.getAAID();
            if (idSupplier instanceof InnerIdSupplier) {
                ((InnerIdSupplier) idSupplier).shutDown();
            }
            str = oaid;
            str2 = vaid;
            str3 = aaid;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
        }
        cVar.a(z, "", str, str2, str3);
    }

    public void UnInitSdk() {
    }
}
