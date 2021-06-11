package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes6.dex */
public interface i extends IInterface {
    String a();

    String a(String str);

    String b();

    String b(String str);

    boolean c();

    /* loaded from: classes6.dex */
    public static abstract class a extends Binder implements i {
        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0281a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 == 1) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b2 = b();
                parcel2.writeNoException();
                parcel2.writeString(b2);
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                boolean c2 = c();
                parcel2.writeNoException();
                parcel2.writeInt(c2 ? 1 : 0);
                return true;
            } else if (i2 == 4) {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            } else if (i2 != 5) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString("com.zui.deviceidservice.IDeviceidInterface");
                return true;
            } else {
                parcel.enforceInterface("com.zui.deviceidservice.IDeviceidInterface");
                String b3 = b(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(b3);
                return true;
            }
        }

        /* renamed from: com.bytedance.embedapplog.i$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static class C0281a implements i {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f26943a;

            public C0281a(IBinder iBinder) {
                this.f26943a = iBinder;
            }

            @Override // com.bytedance.embedapplog.i
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f26943a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f26943a;
            }

            @Override // com.bytedance.embedapplog.i
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f26943a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.i
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f26943a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.i
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f26943a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.i
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f26943a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
