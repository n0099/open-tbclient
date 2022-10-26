package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public interface MsaIdInterface extends IInterface {

    /* loaded from: classes7.dex */
    public class Default implements MsaIdInterface {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Default() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // com.bun.lib.MsaIdInterface
        public native String getAAID();

        @Override // com.bun.lib.MsaIdInterface
        public native String getOAID();

        @Override // com.bun.lib.MsaIdInterface
        public native String getVAID();

        @Override // com.bun.lib.MsaIdInterface
        public native boolean isDataArrived();

        @Override // com.bun.lib.MsaIdInterface
        public native boolean isSupported();

        @Override // com.bun.lib.MsaIdInterface
        public native void shutDown();
    }

    /* loaded from: classes7.dex */
    public abstract class Stub extends Binder implements MsaIdInterface {
        public static /* synthetic */ Interceptable $ic = null;
        public static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        public static final int TRANSACTION_getAAID = 2;
        public static final int TRANSACTION_getOAID = 1;
        public static final int TRANSACTION_getVAID = 3;
        public static final int TRANSACTION_isDataArrived = 4;
        public static final int TRANSACTION_isSupported = 5;
        public static final int TRANSACTION_shutDown = 6;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes7.dex */
        public class Proxy implements MsaIdInterface {
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
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.bun.lib.MsaIdInterface
            public native String getAAID();

            public native String getInterfaceDescriptor();

            @Override // com.bun.lib.MsaIdInterface
            public native String getOAID();

            @Override // com.bun.lib.MsaIdInterface
            public native String getVAID();

            @Override // com.bun.lib.MsaIdInterface
            public native boolean isDataArrived();

            @Override // com.bun.lib.MsaIdInterface
            public native boolean isSupported();

            @Override // com.bun.lib.MsaIdInterface
            public native void shutDown();
        }

        public Stub() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            attachInterface(this, DESCRIPTOR);
        }

        public static native MsaIdInterface asInterface(IBinder iBinder);

        public static native MsaIdInterface getDefaultImpl();

        public static native boolean setDefaultImpl(MsaIdInterface msaIdInterface);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    String getAAID();

    String getOAID();

    String getVAID();

    boolean isDataArrived();

    boolean isSupported();

    void shutDown();
}
