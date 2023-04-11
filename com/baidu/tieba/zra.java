package com.baidu.tieba;

import android.os.Process;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes7.dex */
public class zra extends sra {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public StringBuffer d;
    public int e;
    public long f;
    public long g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zra(long j) {
        super(j);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Long.valueOf(j)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Long) newInitContext.callArgs[0]).longValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new StringBuffer();
        this.e = 0;
        this.f = 0L;
        this.g = 0L;
    }

    @Override // com.baidu.tieba.sra
    public void b() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        String readLine;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d.setLength(0);
            BufferedReader bufferedReader3 = null;
            try {
                try {
                    bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/stat")), 1000);
                    try {
                        readLine = bufferedReader2.readLine();
                        str = "";
                        if (readLine == null) {
                            readLine = "";
                        }
                        if (this.e == 0) {
                            this.e = Process.myPid();
                        }
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + this.e + "/stat")), 1000);
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
                try {
                    String readLine2 = bufferedReader.readLine();
                    if (readLine2 != null) {
                        str = readLine2;
                    }
                    f(readLine, str);
                    bufferedReader2.close();
                    bufferedReader.close();
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader3 = bufferedReader2;
                    try {
                        Log.e("SampleCpuSampler", "doSample: ", th);
                        if (bufferedReader3 != null) {
                            bufferedReader3.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (Throwable th4) {
                        if (bufferedReader3 != null) {
                            try {
                                bufferedReader3.close();
                            } catch (IOException e) {
                                Log.e("SampleCpuSampler", "doSample: ", e);
                                throw th4;
                            }
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th4;
                    }
                }
            } catch (IOException e2) {
                Log.e("SampleCpuSampler", "doSample: ", e2);
            }
        }
    }

    @Override // com.baidu.tieba.sra
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.c();
            g();
        }
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.d.toString();
        }
        return (String) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.f = 0L;
            this.g = 0L;
        }
    }

    public final void f(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String[] split = str.split(" ");
            if (split.length < 9) {
                return;
            }
            long parseLong = Long.parseLong(split[2]);
            long parseLong2 = Long.parseLong(split[3]);
            long parseLong3 = Long.parseLong(split[4]);
            long parseLong4 = Long.parseLong(split[5]);
            long parseLong5 = parseLong + parseLong2 + parseLong3 + parseLong4 + Long.parseLong(split[6]) + Long.parseLong(split[7]) + Long.parseLong(split[8]);
            if (str2.split(" ").length < 17) {
                return;
            }
            if (parseLong5 != 0) {
                long j = parseLong5 - this.g;
                this.d.append(((j - (parseLong4 - this.f)) * 100) / j);
            }
            this.f = parseLong4;
            this.g = parseLong5;
        }
    }
}
