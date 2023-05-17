package com.bun.lib;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Keep
/* loaded from: classes8.dex */
public interface MsaIdInterface extends IInterface {

    @Keep
    /* loaded from: classes8.dex */
    public static class Default implements MsaIdInterface {
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
        @Keep
        public native IBinder asBinder();

        @Override // com.bun.lib.MsaIdInterface
        @Keep
        public native String getAAID();

        @Override // com.bun.lib.MsaIdInterface
        @Keep
        public native String getOAID();

        @Override // com.bun.lib.MsaIdInterface
        @Keep
        public native String getVAID();

        @Override // com.bun.lib.MsaIdInterface
        @Keep
        public native boolean isDataArrived();

        @Override // com.bun.lib.MsaIdInterface
        @Keep
        public native boolean isSupported();

        @Override // com.bun.lib.MsaIdInterface
        @Keep
        public native void shutDown();
    }

    @Keep
    /* loaded from: classes8.dex */
    public static abstract class Stub extends Binder implements MsaIdInterface {
        public static /* synthetic */ Interceptable $ic = null;
        @Keep
        public static final String DESCRIPTOR = "com.bun.lib.MsaIdInterface";
        @Keep
        public static final int TRANSACTION_getAAID = 2;
        @Keep
        public static final int TRANSACTION_getOAID = 1;
        @Keep
        public static final int TRANSACTION_getVAID = 3;
        @Keep
        public static final int TRANSACTION_isDataArrived = 4;
        @Keep
        public static final int TRANSACTION_isSupported = 5;
        @Keep
        public static final int TRANSACTION_shutDown = 6;
        public transient /* synthetic */ FieldHolder $fh;

        @Keep
        /* loaded from: classes8.dex */
        public static class Proxy implements MsaIdInterface {
            public static /* synthetic */ Interceptable $ic;
            @Keep
            public static MsaIdInterface sDefaultImpl;
            public transient /* synthetic */ FieldHolder $fh;
            @Keep
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
            @Keep
            public native IBinder asBinder();

            @Override // com.bun.lib.MsaIdInterface
            @Keep
            public native String getAAID();

            @Keep
            public native String getInterfaceDescriptor();

            @Override // com.bun.lib.MsaIdInterface
            @Keep
            public native String getOAID();

            @Override // com.bun.lib.MsaIdInterface
            @Keep
            public native String getVAID();

            @Override // com.bun.lib.MsaIdInterface
            @Keep
            public native boolean isDataArrived();

            @Override // com.bun.lib.MsaIdInterface
            @Keep
            public native boolean isSupported();

            @Override // com.bun.lib.MsaIdInterface
            @Keep
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

        @Keep
        public static native MsaIdInterface asInterface(IBinder iBinder);

        @Keep
        public static native MsaIdInterface getDefaultImpl();

        @Keep
        public static native boolean setDefaultImpl(MsaIdInterface msaIdInterface);

        @Override // android.os.IInterface
        @Keep
        public native IBinder asBinder();

        @Override // android.os.Binder
        @Keep
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    @Keep
    String getAAID();

    @Keep
    String getOAID();

    @Keep
    String getVAID();

    @Keep
    boolean isDataArrived();

    @Keep
    boolean isSupported();

    @Keep
    void shutDown();
}
