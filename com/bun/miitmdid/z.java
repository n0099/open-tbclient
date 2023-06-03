package com.bun.miitmdid;

import android.os.AsyncTask;
import androidx.annotation.Keep;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bun.lib.MsaIdInterface;
@Keep
/* loaded from: classes9.dex */
public class z extends AsyncTask<Void, Void, Boolean> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Keep
    public b0 a;
    @Keep
    public MsaIdInterface b;

    public z(MsaIdInterface msaIdInterface, b0 b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {msaIdInterface, b0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = msaIdInterface;
        this.a = b0Var;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    @Keep
    /* renamed from: a */
    public native Boolean doInBackground(Void... voidArr);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.os.AsyncTask
    @Keep
    /* renamed from: a */
    public native void onPostExecute(Boolean bool);
}
