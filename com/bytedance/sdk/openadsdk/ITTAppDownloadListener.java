package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes4.dex */
public interface ITTAppDownloadListener extends IInterface {
    void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFinished(long j, String str, String str2) throws RemoteException;

    void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException;

    void onIdle() throws RemoteException;

    void onInstalled(String str, String str2) throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements ITTAppDownloadListener {
        public Stub() {
            attachInterface(this, "com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
        }

        public static ITTAppDownloadListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof ITTAppDownloadListener)) {
                return (ITTAppDownloadListener) queryLocalInterface;
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
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    onIdle();
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    onDownloadActive(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    onDownloadPaused(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    onDownloadFailed(parcel.readLong(), parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    onDownloadFinished(parcel.readLong(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    onInstalled(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes4.dex */
        private static class a implements ITTAppDownloadListener {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6077a;

            a(IBinder iBinder) {
                this.f6077a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6077a;
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onIdle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    this.f6077a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6077a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6077a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6077a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6077a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onInstalled(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.f6077a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
