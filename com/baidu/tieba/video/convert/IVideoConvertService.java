package com.baidu.tieba.video.convert;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.tieba.video.convert.IVideoConvertListener;
/* loaded from: classes2.dex */
public interface IVideoConvertService extends IInterface {
    void abortConvert() throws RemoteException;

    int doConvert(String str, String str2) throws RemoteException;

    boolean isConvertRunning() throws RemoteException;

    void setConvertType(int i) throws RemoteException;

    void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IVideoConvertService {
        private static final String DESCRIPTOR = "com.baidu.tieba.video.convert.IVideoConvertService";
        static final int TRANSACTION_abortConvert = 4;
        static final int TRANSACTION_doConvert = 1;
        static final int TRANSACTION_isConvertRunning = 5;
        static final int TRANSACTION_setConvertType = 2;
        static final int TRANSACTION_setIVideoConvertListener = 3;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IVideoConvertService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IVideoConvertService)) {
                return (IVideoConvertService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int doConvert = doConvert(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(doConvert);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    setConvertType(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    setIVideoConvertListener(IVideoConvertListener.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    abortConvert();
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    boolean isConvertRunning = isConvertRunning();
                    parcel2.writeNoException();
                    parcel2.writeInt(isConvertRunning ? 1 : 0);
                    return true;
                case 1598968902:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements IVideoConvertService {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public int doConvert(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public void setConvertType(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iVideoConvertListener != null ? iVideoConvertListener.asBinder() : null);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public void abortConvert() throws RemoteException {
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

            @Override // com.baidu.tieba.video.convert.IVideoConvertService
            public boolean isConvertRunning() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
