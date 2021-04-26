package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes5.dex */
public interface f extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a extends Binder implements f {

        /* renamed from: com.bytedance.embedapplog.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0289a implements f {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f27664a;

            public C0289a(IBinder iBinder) {
                this.f27664a = iBinder;
            }

            @Override // com.bytedance.embedapplog.f
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f27664a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27664a;
            }

            @Override // com.bytedance.embedapplog.f
            public boolean b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f27664a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.f
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f27664a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.f
            public String d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f27664a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.f
            public boolean e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f27664a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.embedapplog.f
            public void f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f27664a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof f)) {
                return (f) queryLocalInterface;
            }
            return new C0289a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            if (i2 != 1598968902) {
                switch (i2) {
                    case 1:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String a2 = a();
                        parcel2.writeNoException();
                        parcel2.writeString(a2);
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean b2 = b();
                        parcel2.writeNoException();
                        parcel2.writeInt(b2 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String c2 = c();
                        parcel2.writeNoException();
                        parcel2.writeString(c2);
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        String d2 = d();
                        parcel2.writeNoException();
                        parcel2.writeString(d2);
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        boolean e2 = e();
                        parcel2.writeNoException();
                        parcel2.writeInt(e2 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bun.lib.MsaIdInterface");
                        f();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            parcel2.writeString("com.bun.lib.MsaIdInterface");
            return true;
        }
    }

    String a();

    boolean b();

    String c();

    String d();

    boolean e();

    void f();
}
