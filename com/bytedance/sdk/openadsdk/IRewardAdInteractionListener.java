package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes5.dex */
public interface IRewardAdInteractionListener extends IInterface {

    /* loaded from: classes5.dex */
    public static class Default implements IRewardAdInteractionListener {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onAdClose() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onAdShow() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onAdVideoBarClick() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onDestroy() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onRewardVerify(boolean z, int i, String str, int i2, String str2) throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onSkippedVideo() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onVideoComplete() throws RemoteException {
        }

        @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
        public void onVideoError() throws RemoteException {
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IRewardAdInteractionListener {

        /* loaded from: classes5.dex */
        public static class a implements IRewardAdInteractionListener {

            /* renamed from: a  reason: collision with root package name */
            public static IRewardAdInteractionListener f27275a;

            /* renamed from: b  reason: collision with root package name */
            public IBinder f27276b;

            public a(IBinder iBinder) {
                this.f27276b = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f27276b;
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdClose() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdClose();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdShow() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdShow();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdVideoBarClick() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onAdVideoBarClick();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onDestroy();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onRewardVerify(boolean z, int i, String str, int i2, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    obtain.writeString(str2);
                    if (!this.f27276b.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onRewardVerify(z, i, str, i2, str2);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onSkippedVideo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onSkippedVideo();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onVideoComplete() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVideoComplete();
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onVideoError() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    if (!this.f27276b.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onVideoError();
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
            attachInterface(this, "com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
        }

        public static IRewardAdInteractionListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            if (queryLocalInterface != null && (queryLocalInterface instanceof IRewardAdInteractionListener)) {
                return (IRewardAdInteractionListener) queryLocalInterface;
            }
            return new a(iBinder);
        }

        public static IRewardAdInteractionListener getDefaultImpl() {
            return a.f27275a;
        }

        public static boolean setDefaultImpl(IRewardAdInteractionListener iRewardAdInteractionListener) {
            if (a.f27275a != null || iRewardAdInteractionListener == null) {
                return false;
            }
            a.f27275a = iRewardAdInteractionListener;
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
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onDestroy();
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onAdShow();
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onAdVideoBarClick();
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onAdClose();
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onVideoComplete();
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onVideoError();
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onRewardVerify(parcel.readInt() != 0, parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 8:
                        parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                        onSkippedVideo();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
            return true;
        }
    }

    void onAdClose() throws RemoteException;

    void onAdShow() throws RemoteException;

    void onAdVideoBarClick() throws RemoteException;

    void onDestroy() throws RemoteException;

    void onRewardVerify(boolean z, int i, String str, int i2, String str2) throws RemoteException;

    void onSkippedVideo() throws RemoteException;

    void onVideoComplete() throws RemoteException;

    void onVideoError() throws RemoteException;
}
