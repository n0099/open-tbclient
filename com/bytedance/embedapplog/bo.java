package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes5.dex */
public interface bo extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class a extends Binder implements bo {

        /* renamed from: com.bytedance.embedapplog.bo$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static class C0290a implements bo {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f27155a;

            public C0290a(IBinder iBinder) {
                this.f27155a = iBinder;
            }

            @Override // com.bytedance.embedapplog.bo
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f27155a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27155a;
            }
        }

        public static bo a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof bo)) {
                return (bo) queryLocalInterface;
            }
            return new C0290a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.heytap.openid.IOpenID");
                return true;
            }
            parcel.enforceInterface("com.heytap.openid.IOpenID");
            String a2 = a(parcel.readString(), parcel.readString(), parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a(String str, String str2, String str3);
}
