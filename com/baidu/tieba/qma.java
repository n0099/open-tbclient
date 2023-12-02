package com.baidu.tieba;

import com.baidu.adp.lib.safe.BdCloseHelper;
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
/* loaded from: classes7.dex */
public class qma {
    public static /* synthetic */ Interceptable $ic;
    public static qma b;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<String, String> a;

    /* loaded from: classes7.dex */
    public interface c {
        void a(HashMap<String, String> hashMap);
    }

    /* loaded from: classes7.dex */
    public class a extends nu5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qma a;

        public a(qma qmaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qmaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qmaVar;
        }

        @Override // com.baidu.tieba.nu5
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
                                BdCloseHelper.close(inputStream);
                                BdCloseHelper.close((Reader) bufferedReader);
                                return null;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        bufferedReader = null;
                    } catch (Throwable th3) {
                        reader = null;
                        th = th3;
                        BdCloseHelper.close(inputStream);
                        BdCloseHelper.close(reader);
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
                BdCloseHelper.close(inputStream);
                BdCloseHelper.close((Reader) bufferedReader);
                return null;
            }
            return invokeV.objValue;
        }
    }

    /* loaded from: classes7.dex */
    public class b implements st5<Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c a;
        public final /* synthetic */ qma b;

        public b(qma qmaVar, c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qmaVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = qmaVar;
            this.a = cVar;
        }

        @Override // com.baidu.tieba.st5
        public void onReturnDataInUI(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                this.a.a(this.b.a);
            }
        }
    }

    public qma() {
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

    public static qma c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (b == null) {
                synchronized (qma.class) {
                    if (b == null) {
                        b = new qma();
                    }
                }
            }
            return b;
        }
        return (qma) invokeV.objValue;
    }

    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cVar) == null) {
            if (!this.a.isEmpty()) {
                cVar.a(this.a);
            } else {
                ru5.b(new a(this), new b(this, cVar));
            }
        }
    }
}
