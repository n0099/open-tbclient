package com.bun.miitmdid;

import android.content.Context;
import android.os.IBinder;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;
import com.asus.msa.sdid.IDIDBinderStatusListener;
import com.asus.msa.sdid.SupplementaryDIDManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class i extends l implements IDIDBinderStatusListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final SupplementaryDIDManager j;

    public i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new SupplementaryDIDManager(context);
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

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void doStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            e0.c("AsusProvider", "doStart");
            a();
            try {
                c();
                this.j.init(this);
                b();
            } catch (Exception e) {
                e0.b("AsusProvider", "doStart: Exception: " + e.getMessage());
                a();
                a(this.c, this.d, this.e, this.f, this.g);
            }
        }
    }

    @Override // com.bun.miitmdid.l, com.bun.miitmdid.interfaces.IIdProvider
    public boolean isSync() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void onError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            e0.d("AsusProvider", "onError");
            a();
            a(this.c, this.d, this.e, this.f, this.g);
            shutDown();
        }
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    public void onSuccess(IDidAidlInterface iDidAidlInterface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, iDidAidlInterface) == null) {
            e0.c("AsusProvider", "onSuccess");
            if (d()) {
                return;
            }
            try {
                try {
                    this.f = iDidAidlInterface.isSupport();
                    String oaid = iDidAidlInterface.getOAID();
                    String vaid = iDidAidlInterface.getVAID();
                    String aaid = iDidAidlInterface.getAAID();
                    this.g = false;
                    if (oaid == null) {
                        oaid = "";
                    }
                    this.c = oaid;
                    if (vaid == null) {
                        vaid = "";
                    }
                    this.d = vaid;
                    if (aaid == null) {
                        aaid = "";
                    }
                    this.e = aaid;
                } catch (Exception e) {
                    e0.b("AsusProvider", "onSuccess: Exception: " + e.getMessage());
                    a();
                }
            } finally {
                a(this.c, this.d, this.e, this.f, this.g);
                shutDown();
            }
        }
    }

    @Override // com.bun.miitmdid.interfaces.IIdProvider
    public void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (supplementaryDIDManager = this.j) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }
}
