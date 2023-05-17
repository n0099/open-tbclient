package com.baidu.titan.sdk.pm;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes8.dex */
public interface IPatchInstallObserver extends IInterface {

    /* loaded from: classes8.dex */
    public static class Default implements IPatchInstallObserver {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.titan.sdk.pm.IPatchInstallObserver
        public void onPatchInstalled(int i, Bundle bundle) throws RemoteException {
        }
    }

    void onPatchInstalled(int i, Bundle bundle) throws RemoteException;

    /* loaded from: classes8.dex */
    public static abstract class Stub extends Binder implements IPatchInstallObserver {
        public static final String DESCRIPTOR = "com.baidu.titan.sdk.pm.IPatchInstallObserver";
        public static final int TRANSACTION_onPatchInstalled = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes8.dex */
        public static class Proxy implements IPatchInstallObserver {
            public static IPatchInstallObserver sDefaultImpl;
            public IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.baidu.titan.sdk.pm.IPatchInstallObserver
            public void onPatchInstalled(int i, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, obtain, null, 1) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().onPatchInstalled(i, bundle);
                    }
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IPatchInstallObserver getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPatchInstallObserver asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPatchInstallObserver)) {
                return (IPatchInstallObserver) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IPatchInstallObserver iPatchInstallObserver) {
            if (Proxy.sDefaultImpl == null) {
                if (iPatchInstallObserver != null) {
                    Proxy.sDefaultImpl = iPatchInstallObserver;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Bundle bundle;
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            } else {
                bundle = null;
            }
            onPatchInstalled(readInt, bundle);
            return true;
        }
    }
}
