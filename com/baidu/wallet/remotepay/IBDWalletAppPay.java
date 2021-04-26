package com.baidu.wallet.remotepay;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.wallet.remotepay.IRemoteServiceCallback;
import java.util.Map;
/* loaded from: classes5.dex */
public interface IBDWalletAppPay extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IBDWalletAppPay {
        public static final String DESCRIPTOR = "com.baidu.wallet.remotepay.IBDWalletAppPay";
        public static final int TRANSACTION_doPay = 1;
        public static final int TRANSACTION_getWalletSdkVersion = 2;
        public static final int TRANSACTION_registerCallback = 3;
        public static final int TRANSACTION_unregisterCallback = 4;

        /* loaded from: classes5.dex */
        public static class Proxy implements IBDWalletAppPay {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public String doPay(String str, Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeMap(map);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public String getWalletSdkVersion() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iRemoteServiceCallback != null ? iRemoteServiceCallback.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.wallet.remotepay.IBDWalletAppPay
            public void unregisterCallback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IBDWalletAppPay asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IBDWalletAppPay)) {
                return (IBDWalletAppPay) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            if (i2 == 1) {
                parcel.enforceInterface(DESCRIPTOR);
                String doPay = doPay(parcel.readString(), parcel.readHashMap(Stub.class.getClassLoader()));
                parcel2.writeNoException();
                parcel2.writeString(doPay);
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                String walletSdkVersion = getWalletSdkVersion();
                parcel2.writeNoException();
                parcel2.writeString(walletSdkVersion);
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                registerCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                unregisterCallback();
                parcel2.writeNoException();
                return true;
            }
        }
    }

    String doPay(String str, Map map) throws RemoteException;

    String getWalletSdkVersion() throws RemoteException;

    void registerCallback(IRemoteServiceCallback iRemoteServiceCallback) throws RemoteException;

    void unregisterCallback() throws RemoteException;
}
