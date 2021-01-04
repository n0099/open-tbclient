package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes4.dex */
public interface ICommonPermissionListener extends IInterface {
    void onDenied(String str) throws RemoteException;

    void onGranted() throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements ICommonPermissionListener {
        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.ICommonPermissionListener");
        }

        public static ICommonPermissionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ICommonPermissionListener)) {
                return (ICommonPermissionListener) queryLocalInterface;
            }
            return new a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    onGranted();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    onDenied(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes4.dex */
        private static class a implements ICommonPermissionListener {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6372a;

            a(IBinder iBinder) {
                this.f6372a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6372a;
            }

            @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
            public void onGranted() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    this.f6372a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ICommonPermissionListener
            public void onDenied(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ICommonPermissionListener");
                    obtain.writeString(str);
                    this.f6372a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
