package com.bytedance.pangle.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.pangle.helper.e;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/* loaded from: classes11.dex */
public final class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(String[] strArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, strArr)) == null) {
            if (strArr.length <= 0) {
                return false;
            }
            try {
                Process exec = Runtime.getRuntime().exec(strArr);
                InputStream errorStream = exec.getErrorStream();
                InputStream inputStream = exec.getInputStream();
                a(errorStream);
                a(inputStream);
                if (exec.waitFor() != 0) {
                    ZeusLogger.e(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + strArr.toString());
                    return false;
                }
                return true;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            } catch (InterruptedException e3) {
                e3.printStackTrace();
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public static void a(InputStream inputStream) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, inputStream) == null) {
            e.f61434a.execute(new Runnable(inputStream) { // from class: com.bytedance.pangle.d.a.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ InputStream f61277a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {inputStream};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f61277a = inputStream;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && interceptable2.invokeV(1048576, this) != null) {
                        return;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f61277a));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                return;
                            }
                            ZeusLogger.d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(String.valueOf(readLine)));
                        } catch (IOException e2) {
                            ZeusLogger.e(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e2)));
                            return;
                        } finally {
                            g.a(bufferedReader);
                        }
                    }
                }
            });
        }
    }
}
