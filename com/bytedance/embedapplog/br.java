package com.bytedance.embedapplog;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* loaded from: classes4.dex */
public interface br extends IInterface {
    String a(String str, String str2, String str3);

    /* loaded from: classes4.dex */
    public static abstract class a extends Binder implements br {
        public static br a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            if (queryLocalInterface != null && (queryLocalInterface instanceof br)) {
                return (br) queryLocalInterface;
            }
            return new C0962a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.heytap.openid.IOpenID");
                    String a2 = a(parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.heytap.openid.IOpenID");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* renamed from: com.bytedance.embedapplog.br$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        static class C0962a implements br {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6109a;

            C0962a(IBinder iBinder) {
                this.f6109a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6109a;
            }

            @Override // com.bytedance.embedapplog.br
            public String a(String str, String str2, String str3) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.f6109a.transact(1, obtain, obtain2, 0);
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
