package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes4.dex */
public interface cl extends IInterface {
    String a();

    boolean b();

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements cl {
        public static cl a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof cl)) {
                return (cl) queryLocalInterface;
            }
            return new C0964a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    String a2 = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean b2 = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(b2 ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.bytedance.embedapplog.cl$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        static class C0964a implements cl {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6124a;

            C0964a(IBinder iBinder) {
                this.f6124a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6124a;
            }

            @Override // com.bytedance.embedapplog.cl
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f6124a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.cl
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f6124a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
