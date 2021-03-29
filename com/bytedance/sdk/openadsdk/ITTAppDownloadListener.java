package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes6.dex */
public interface ITTAppDownloadListener extends IInterface {

    /* loaded from: classes6.dex */
    public static class Default implements ITTAppDownloadListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadFinished(long j, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onIdle() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
        public void onInstalled(String str, String str2) throws RemoteException {
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class Stub extends Binder implements ITTAppDownloadListener {

        /* loaded from: classes6.dex */
        public static class a implements ITTAppDownloadListener {

            /* renamed from: a  reason: collision with root package name */
            public static ITTAppDownloadListener f27278a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f27279b;

            public a(IBinder iBinder) {
                this.f27279b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27279b;
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
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f27279b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadActive(j, j2, str, str2);
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
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
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f27279b.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadFailed(j, j2, str, str2);
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
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
                    if (!this.f27279b.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadFinished(j, str, str2);
                    } else {
                        obtain2.readException();
                    }
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
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (!this.f27279b.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDownloadPaused(j, j2, str, str2);
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th2) {
                    th = th2;
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.bytedance.sdk.openadsdk.ITTAppDownloadListener
            public void onIdle() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
                    if (!this.f27279b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onIdle();
                    } else {
                        obtain2.readException();
                    }
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
                    if (!this.f27279b.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onInstalled(str, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

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

        public static ITTAppDownloadListener getDefaultImpl() {
            return a.f27278a;
        }

        public static boolean setDefaultImpl(ITTAppDownloadListener iTTAppDownloadListener) {
            if (a.f27278a != null || iTTAppDownloadListener == null) {
                return false;
            }
            a.f27278a = iTTAppDownloadListener;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1598968902) {
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
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.ITTAppDownloadListener");
            return true;
        }
    }

    void onDownloadActive(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFailed(long j, long j2, String str, String str2) throws RemoteException;

    void onDownloadFinished(long j, String str, String str2) throws RemoteException;

    void onDownloadPaused(long j, long j2, String str, String str2) throws RemoteException;

    void onIdle() throws RemoteException;

    void onInstalled(String str, String str2) throws RemoteException;
}
