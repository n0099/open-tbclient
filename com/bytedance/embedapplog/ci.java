package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.uodis.opendevice.aidl.OpenDeviceIdentifierService;
/* loaded from: classes5.dex */
public interface ci extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a extends Binder implements ci {

        /* renamed from: com.bytedance.embedapplog.ci$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0275a implements ci {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f26908a;

            public C0275a(IBinder iBinder) {
                this.f26908a = iBinder;
            }

            @Override // com.bytedance.embedapplog.ci
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f26908a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26908a;
            }

            @Override // com.bytedance.embedapplog.ci
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                    this.f26908a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static ci a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof ci)) {
                return (ci) queryLocalInterface;
            }
            return new C0275a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i2 != 2) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(OpenDeviceIdentifierService.Stub.DESCRIPTOR);
                boolean b2 = b();
                parcel2.writeNoException();
                parcel2.writeInt(b2 ? 1 : 0);
                return true;
            }
        }
    }

    String a();

    boolean b();
}
