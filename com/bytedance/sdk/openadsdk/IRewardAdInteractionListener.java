package com.bytedance.sdk.openadsdk;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes4.dex */
public interface IRewardAdInteractionListener extends IInterface {
    void onAdClose() throws RemoteException;

    void onAdShow() throws RemoteException;

    void onAdVideoBarClick() throws RemoteException;

    void onDestroy() throws RemoteException;

    void onRewardVerify(boolean z, int i, String str) throws RemoteException;

    void onSkippedVideo() throws RemoteException;

    void onVideoComplete() throws RemoteException;

    void onVideoError() throws RemoteException;

    /* loaded from: classes4.dex */
    public static abstract class Stub extends Binder implements IRewardAdInteractionListener {
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

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
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
                    onRewardVerify(parcel.readInt() != 0, parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    onSkippedVideo();
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes4.dex */
        private static class a implements IRewardAdInteractionListener {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f6375a;

            a(IBinder iBinder) {
                this.f6375a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f6375a;
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onDestroy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    this.f6375a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
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
                    this.f6375a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
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
                    this.f6375a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onAdClose() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    this.f6375a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
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
                    this.f6375a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
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
                    this.f6375a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.IRewardAdInteractionListener
            public void onRewardVerify(boolean z, int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.sdk.openadsdk.IRewardAdInteractionListener");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.f6375a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
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
                    this.f6375a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
