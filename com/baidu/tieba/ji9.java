package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class ji9 {
    public static /* synthetic */ Interceptable $ic;
    public static ji9 b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> a;

    /* loaded from: classes6.dex */
    public interface c {
        void a(HashMap<String, String> hashMap);
    }

    /* loaded from: classes6.dex */
    public class a extends et5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ji9 a;

        public a(ji9 ji9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ji9Var;
        }

        @Override // com.baidu.tieba.et5
        public Object doInBackground() {
            InterceptResult invokeV;
            Reader reader;
            Throwable th;
            InputStream inputStream;
            BufferedReader bufferedReader;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                try {
                    try {
                        inputStream = TbadkCoreApplication.getInst().getAssets().open("schema_map1.txt");
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                String[] split = readLine.split(",");
                                if (split.length == 2 && split[0] != null && split[1] != null) {
                                    this.a.a.put(split[0], split[1]);
                                }
                            } catch (Exception e) {
                                e = e;
                                e.printStackTrace();
                                og.c(inputStream);
                                og.e(bufferedReader);
                                return null;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        reader = null;
                        th = th3;
                        og.c(inputStream);
                        og.e(reader);
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream = null;
                    bufferedReader = null;
                } catch (Throwable th4) {
                    reader = null;
                    th = th4;
                    inputStream = null;
                }
                og.c(inputStream);
                og.e(bufferedReader);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements is5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ ji9 b;

        public b(ji9 ji9Var, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ji9Var, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ji9Var;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.is5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.a(this.b.a);
            }
        }
    }

    public ji9() {
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
        this.a = new HashMap<>();
        new HashMap();
    }

    public static ji9 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (ji9.class) {
                    if (b == null) {
                        b = new ji9();
                    }
                }
            }
            return b;
        }
        return (ji9) invokeV.objValue;
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!this.a.isEmpty()) {
                cVar.a(this.a);
            } else {
                it5.b(new a(this), new b(this, cVar));
            }
        }
    }
}
