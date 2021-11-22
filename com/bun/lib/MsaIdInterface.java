package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public interface MsaIdInterface extends IInterface {

    /* loaded from: classes11.dex */
    public static class Default implements MsaIdInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Default() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (IBinder) invokeV.objValue;
        }

        @Override // com.bun.lib.MsaIdInterface
        public String getAAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.bun.lib.MsaIdInterface
        public String getOAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.bun.lib.MsaIdInterface
        public String getVAID() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return null;
            }
            return (String) invokeV.objValue;
        }

        @Override // com.bun.lib.MsaIdInterface
        public boolean isDataArrived() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.bun.lib.MsaIdInterface
        public boolean isSupported() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // com.bun.lib.MsaIdInterface
        public void shutDown() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            }
        }
    }

    /* loaded from: classes11.dex */
    public static abstract class Stub extends Binder implements MsaIdInterface {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        public static final int TRANSACTION_getAAID = 2;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getVAID = 3;
        public static final int TRANSACTION_isDataArrived = 4;
        public static final int TRANSACTION_isSupported = 5;
        public static final int TRANSACTION_shutDown = 6;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes11.dex */
        public static class Proxy implements MsaIdInterface {
            public static /* synthetic */ Interceptable $ic;
            public static MsaIdInterface sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            public IBinder mRemote;

            public Proxy(IBinder iBinder) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {iBinder};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mRemote : (IBinder) invokeV.objValue;
            }

            @Override // com.bun.lib.MsaIdInterface
            public String getAAID() {
                InterceptResult invokeV;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = Stub.getDefaultImpl().getAAID();
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            public String getInterfaceDescriptor() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? Stub.DESCRIPTOR : (String) invokeV.objValue;
            }

            @Override // com.bun.lib.MsaIdInterface
            public String getOAID() {
                InterceptResult invokeV;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = Stub.getDefaultImpl().getOAID();
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bun.lib.MsaIdInterface
            public String getVAID() {
                InterceptResult invokeV;
                String readString;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            readString = obtain2.readString();
                        } else {
                            readString = Stub.getDefaultImpl().getVAID();
                        }
                        return readString;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return (String) invokeV.objValue;
            }

            @Override // com.bun.lib.MsaIdInterface
            public boolean isDataArrived() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return Stub.getDefaultImpl().isDataArrived();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.bun.lib.MsaIdInterface
            public boolean isSupported() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                            return obtain2.readInt() != 0;
                        }
                        return Stub.getDefaultImpl().isSupported();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
                return invokeV.booleanValue;
            }

            @Override // com.bun.lib.MsaIdInterface
            public void shutDown() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                        if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                            obtain2.readException();
                        } else {
                            Stub.getDefaultImpl().shutDown();
                        }
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
        }

        public Stub() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, DESCRIPTOR);
        }

        public static MsaIdInterface asInterface(IBinder iBinder) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, iBinder)) == null) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
                return (queryLocalInterface == null || !(queryLocalInterface instanceof MsaIdInterface)) ? new Proxy(iBinder) : (MsaIdInterface) queryLocalInterface;
            }
            return (MsaIdInterface) invokeL.objValue;
        }

        public static MsaIdInterface getDefaultImpl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? Proxy.sDefaultImpl : (MsaIdInterface) invokeV.objValue;
        }

        public static boolean setDefaultImpl(MsaIdInterface msaIdInterface) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, msaIdInterface)) == null) {
                if (Proxy.sDefaultImpl == null) {
                    if (msaIdInterface != null) {
                        Proxy.sDefaultImpl = msaIdInterface;
                        return true;
                    }
                    return false;
                }
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            return invokeL.booleanValue;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this : (IBinder) invokeV.objValue;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i2, Parcel parcel, Parcel parcel2, int i3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), parcel, parcel2, Integer.valueOf(i3)})) == null) {
                if (i2 == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                switch (i2) {
                    case 1:
                        parcel.enforceInterface(DESCRIPTOR);
                        String oaid = getOAID();
                        parcel2.writeNoException();
                        parcel2.writeString(oaid);
                        return true;
                    case 2:
                        parcel.enforceInterface(DESCRIPTOR);
                        String aaid = getAAID();
                        parcel2.writeNoException();
                        parcel2.writeString(aaid);
                        return true;
                    case 3:
                        parcel.enforceInterface(DESCRIPTOR);
                        String vaid = getVAID();
                        parcel2.writeNoException();
                        parcel2.writeString(vaid);
                        return true;
                    case 4:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isDataArrived = isDataArrived();
                        parcel2.writeNoException();
                        parcel2.writeInt(isDataArrived ? 1 : 0);
                        return true;
                    case 5:
                        parcel.enforceInterface(DESCRIPTOR);
                        boolean isSupported = isSupported();
                        parcel2.writeNoException();
                        parcel2.writeInt(isSupported ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface(DESCRIPTOR);
                        shutDown();
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i2, parcel, parcel2, i3);
                }
            }
            return invokeCommon.booleanValue;
        }
    }

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isDataArrived();

    boolean isSupported();

    void shutDown();
}
