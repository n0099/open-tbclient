package com.baidu.tieba.video.convert;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.baidu.tieba.video.convert.IVideoConvertListener;
/* loaded from: classes5.dex */
public interface IVideoCompositeService extends IInterface {

    /* loaded from: classes5.dex */
    public static abstract class Stub extends Binder implements IVideoCompositeService {
        public static final String DESCRIPTOR = "com.baidu.tieba.video.convert.IVideoCompositeService";
        public static final int TRANSACTION_abortConvert = 2;
        public static final int TRANSACTION_addSticker = 4;
        public static final int TRANSACTION_isConvertRunning = 3;
        public static final int TRANSACTION_setIVideoConvertListener = 1;

        /* loaded from: classes5.dex */
        public static class Proxy implements IVideoCompositeService {
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public void abortConvert() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public int addSticker(String str, String str2, String str3, boolean z, int i2, int i3, int i4, int i5) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(i2);
                    obtain.writeInt(i3);
                    obtain.writeInt(i4);
                    obtain.writeInt(i5);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public boolean isConvertRunning() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.baidu.tieba.video.convert.IVideoCompositeService
            public void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeStrongBinder(iVideoConvertListener != null ? iVideoConvertListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, obtain2, 0);
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

        public static IVideoCompositeService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IVideoCompositeService)) {
                return (IVideoCompositeService) queryLocalInterface;
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
                setIVideoConvertListener(IVideoConvertListener.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            } else if (i2 == 2) {
                parcel.enforceInterface(DESCRIPTOR);
                abortConvert();
                parcel2.writeNoException();
                return true;
            } else if (i2 == 3) {
                parcel.enforceInterface(DESCRIPTOR);
                boolean isConvertRunning = isConvertRunning();
                parcel2.writeNoException();
                parcel2.writeInt(isConvertRunning ? 1 : 0);
                return true;
            } else if (i2 != 4) {
                if (i2 != 1598968902) {
                    return super.onTransact(i2, parcel, parcel2, i3);
                }
                parcel2.writeString(DESCRIPTOR);
                return true;
            } else {
                parcel.enforceInterface(DESCRIPTOR);
                int addSticker = addSticker(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                parcel2.writeInt(addSticker);
                return true;
            }
        }
    }

    void abortConvert() throws RemoteException;

    int addSticker(String str, String str2, String str3, boolean z, int i2, int i3, int i4, int i5) throws RemoteException;

    boolean isConvertRunning() throws RemoteException;

    void setIVideoConvertListener(IVideoConvertListener iVideoConvertListener) throws RemoteException;
}
