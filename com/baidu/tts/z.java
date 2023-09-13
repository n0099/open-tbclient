package com.baidu.tts;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class z extends u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String b;
    public String c;
    public SimpleDateFormat d;
    public SimpleDateFormat e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(a0 a0Var) {
        super(a0Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a0Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((a0) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = "/sdcard/bds-tts/log/";
        this.c = "bdtts";
        this.d = new SimpleDateFormat("yyyy_MM_dd");
        this.e = new SimpleDateFormat("MM-dd_HH-mm-ss_SSS");
    }

    @Override // com.baidu.tts.u
    public int a(w wVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) {
            if (wVar == null) {
                Log.e("StorageLoggerCloseState", "invalid params!");
                return -1;
            }
            String str = this.c;
            File file = new File(this.b + this.d.format(new Date()));
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, String.format("%s_%s.log", str, this.e.format(new Date())));
            Log.w("StorageLoggerCloseState", "new log file=" + file2.getName());
            a0 a0Var = this.a;
            a0Var.a = file2;
            b0 b0Var = a0Var.d;
            a0Var.b = b0Var;
            return b0Var.a(wVar);
        }
        return invokeL.intValue;
    }
}
