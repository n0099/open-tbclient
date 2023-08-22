package com.baidu.titan.sdk.pm;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.titan.sdk.pm.IPatchInstallObserver;
/* loaded from: classes9.dex */
public interface IPatchManager extends IInterface {

    /* loaded from: classes9.dex */
    public static class Default implements IPatchManager {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.baidu.titan.sdk.pm.IPatchManager
        public void install(Uri uri, int i, Bundle bundle, IPatchInstallObserver iPatchInstallObserver) throws RemoteException {
        }

        @Override // com.baidu.titan.sdk.pm.IPatchManager
        public void requestCleanPatches() throws RemoteException {
        }
    }

    void install(Uri uri, int i, Bundle bundle, IPatchInstallObserver iPatchInstallObserver) throws RemoteException;

    void requestCleanPatches() throws RemoteException;

    /* loaded from: classes9.dex */
    public static abstract class Stub extends Binder implements IPatchManager {
        public static final String DESCRIPTOR = "com.baidu.titan.sdk.pm.IPatchManager";
        public static final int TRANSACTION_install = 1;
        public static final int TRANSACTION_requestCleanPatches = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* loaded from: classes9.dex */
        public static class Proxy implements IPatchManager {
            public static IPatchManager sDefaultImpl;
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

            @Override // com.baidu.titan.sdk.pm.IPatchManager
            public void install(Uri uri, int i, Bundle bundle, IPatchInstallObserver iPatchInstallObserver) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (uri != null) {
                        obtain.writeInt(1);
                        uri.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (iPatchInstallObserver != null) {
                        iBinder = iPatchInstallObserver.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().install(uri, i, bundle, iPatchInstallObserver);
                    } else {
                        obtain2.readException();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.titan.sdk.pm.IPatchManager
            public void requestCleanPatches() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        Stub.getDefaultImpl().requestCleanPatches();
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
            attachInterface(this, DESCRIPTOR);
        }

        public static IPatchManager getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static IPatchManager asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPatchManager)) {
                return (IPatchManager) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        public static boolean setDefaultImpl(IPatchManager iPatchManager) {
            if (Proxy.sDefaultImpl == null) {
                if (iPatchManager != null) {
                    Proxy.sDefaultImpl = iPatchManager;
                    return true;
                }
                return false;
            }
            throw new IllegalStateException("setDefaultImpl() called twice");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            Uri uri;
            if (i != 1) {
                if (i != 2) {
                    if (i != 1598968902) {
                        return super.onTransact(i, parcel, parcel2, i2);
                    }
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                parcel.enforceInterface(DESCRIPTOR);
                requestCleanPatches();
                parcel2.writeNoException();
                return true;
            }
            parcel.enforceInterface(DESCRIPTOR);
            Bundle bundle = null;
            if (parcel.readInt() != 0) {
                uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            } else {
                uri = null;
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() != 0) {
                bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
            }
            install(uri, readInt, bundle, IPatchInstallObserver.Stub.asInterface(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }
}
