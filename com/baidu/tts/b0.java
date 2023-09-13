package com.baidu.tts;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes9.dex */
public class b0 extends u {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Date b;
    public SimpleDateFormat c;
    public final String d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(a0 a0Var) {
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
        this.d = System.getProperty("line.separator");
        this.b = new Date();
        this.c = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");
    }

    @Override // com.baidu.tts.u
    public int a(w wVar) {
        InterceptResult invokeL;
        FileWriter fileWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, wVar)) == null) {
            if (wVar == null) {
                Log.e("StorageLoggerOpenState", "invalid params!");
                return -1;
            }
            File file = this.a.a;
            if (file == null) {
                Log.e("StorageLoggerOpenState", "logfile null!");
                return -2;
            } else if (file.length() >= 1048576) {
                Log.w("StorageLoggerOpenState", "write new log file");
                a0 a0Var = this.a;
                z zVar = a0Var.c;
                a0Var.b = zVar;
                return zVar.a(wVar);
            } else {
                StringBuilder sb = new StringBuilder();
                this.b.setTime(wVar.d);
                sb.append(this.c.format(this.b));
                sb.append("---");
                sb.append(wVar.b);
                sb.append("---");
                sb.append(wVar.c);
                sb.append(this.d);
                FileWriter fileWriter2 = null;
                try {
                    fileWriter = new FileWriter(this.a.a, true);
                } catch (IOException e) {
                    e = e;
                }
                try {
                    fileWriter.append((CharSequence) sb.toString());
                    fileWriter.flush();
                    fileWriter.close();
                    return 0;
                } catch (IOException e2) {
                    e = e2;
                    fileWriter2 = fileWriter;
                    Log.e("StorageLoggerOpenState", "log write exception! e=" + e.getMessage());
                    e.printStackTrace();
                    if (fileWriter2 != null) {
                        try {
                            fileWriter2.flush();
                            fileWriter2.close();
                            return -3;
                        } catch (IOException e3) {
                            Log.e("StorageLoggerOpenState", "log flush exception! e=" + e3.getMessage());
                            return -3;
                        }
                    }
                    return -3;
                }
            }
        }
        return invokeL.intValue;
    }
}
