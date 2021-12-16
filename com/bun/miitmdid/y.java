package com.bun.miitmdid;

import android.os.AsyncTask;
import android.os.RemoteException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.lib.MsaIdInterface;
/* loaded from: classes2.dex */
public class y extends AsyncTask<Void, Void, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public a0 a;

    /* renamed from: b  reason: collision with root package name */
    public MsaIdInterface f55027b;

    public y(MsaIdInterface msaIdInterface, a0 a0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msaIdInterface, a0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55027b = msaIdInterface;
        this.a = a0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(Void... voidArr) {
        InterceptResult invokeL;
        boolean isDataArrived;
        a0 a0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
            if (this.f55027b == null) {
                return Boolean.FALSE;
            }
            int i2 = 0;
            while (true) {
                try {
                    isDataArrived = this.f55027b.isDataArrived();
                } catch (RemoteException | InterruptedException unused) {
                }
                if (isDataArrived) {
                    break;
                }
                Thread.sleep(10L);
                i2++;
                if (i2 >= 30) {
                    break;
                }
            }
            if (isDataArrived && (a0Var = this.a) != null) {
                a0Var.a(this.f55027b);
            }
            return Boolean.valueOf(isDataArrived);
        }
        return (Boolean) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bool) == null) {
            super.onPostExecute(bool);
        }
    }
}
