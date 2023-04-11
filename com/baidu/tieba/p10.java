package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.ABTestConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/* loaded from: classes5.dex */
public class p10 extends o10 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948009050, "Lcom/baidu/tieba/p10;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948009050, "Lcom/baidu/tieba/p10;");
                return;
            }
        }
        a = ABTestConfig.isDebug();
    }

    public p10() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:20:0x003a */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:51:0x0077 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:71:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0082 A[Catch: IOException -> 0x007e, TryCatch #10 {IOException -> 0x007e, blocks: (B:53:0x007a, B:57:0x0082, B:59:0x0087), top: B:76:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0087 A[Catch: IOException -> 0x007e, TRY_LEAVE, TryCatch #10 {IOException -> 0x007e, blocks: (B:53:0x007a, B:57:0x0082, B:59:0x0087), top: B:76:0x007a }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v9 */
    @Override // com.baidu.tieba.o10
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str) {
        InterceptResult invokeL;
        FileInputStream fileInputStream;
        ?? r2;
        InputStreamReader inputStreamReader;
        Throwable th;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                fileInputStream = new FileInputStream(str);
                try {
                    inputStreamReader = new InputStreamReader(fileInputStream);
                } catch (IOException e) {
                    e = e;
                    inputStreamReader = null;
                    r2 = 0;
                } catch (Throwable th2) {
                    th = th2;
                    r2 = 0;
                    th = th;
                    inputStreamReader = r2;
                    if (r2 != 0) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
                try {
                    r2 = new BufferedReader(inputStreamReader);
                    try {
                        try {
                            StringBuilder sb = new StringBuilder();
                            while (true) {
                                String readLine = r2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                sb.append(readLine);
                            }
                            String sb2 = sb.toString();
                            try {
                                r2.close();
                                inputStreamReader.close();
                                fileInputStream.close();
                            } catch (IOException e2) {
                                if (a) {
                                    e2.printStackTrace();
                                }
                            }
                            return sb2;
                        } catch (IOException e3) {
                            e = e3;
                            if (a) {
                                e.printStackTrace();
                            }
                            if (r2 != 0) {
                                try {
                                    r2.close();
                                } catch (IOException e4) {
                                    if (a) {
                                        e4.printStackTrace();
                                    }
                                    return null;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return null;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        if (r2 != 0) {
                            try {
                                r2.close();
                            } catch (IOException e5) {
                                if (a) {
                                    e5.printStackTrace();
                                }
                                throw th;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    r2 = 0;
                } catch (Throwable th4) {
                    r2 = 0;
                    th = th4;
                    if (r2 != 0) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                inputStreamReader = null;
                fileInputStream = null;
                r2 = 0;
            } catch (Throwable th5) {
                th = th5;
                fileInputStream = null;
                r2 = 0;
            }
        } else {
            return (String) invokeL.objValue;
        }
    }

    @Override // com.baidu.tieba.o10
    public void b(String str, String str2) {
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        BufferedWriter bufferedWriter;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) {
            BufferedWriter bufferedWriter2 = null;
            try {
                fileOutputStream = new FileOutputStream(new File(str));
                try {
                    outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                    try {
                        try {
                            bufferedWriter = new BufferedWriter(outputStreamWriter);
                        } catch (IOException e) {
                            e = e;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        bufferedWriter.write(str2);
                        bufferedWriter.close();
                        try {
                            bufferedWriter.close();
                            outputStreamWriter.close();
                            fileOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            if (!a) {
                                return;
                            }
                            e.printStackTrace();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedWriter2 = bufferedWriter;
                        if (a) {
                            e.printStackTrace();
                        }
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e4) {
                                e = e4;
                                if (!a) {
                                    return;
                                }
                                e.printStackTrace();
                            }
                        }
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedWriter2 = bufferedWriter;
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e5) {
                                if (a) {
                                    e5.printStackTrace();
                                }
                                throw th;
                            }
                        }
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw th;
                    }
                } catch (IOException e6) {
                    e = e6;
                    outputStreamWriter = null;
                } catch (Throwable th3) {
                    th = th3;
                    outputStreamWriter = null;
                }
            } catch (IOException e7) {
                e = e7;
                fileOutputStream = null;
                outputStreamWriter = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                outputStreamWriter = null;
            }
        }
    }
}
