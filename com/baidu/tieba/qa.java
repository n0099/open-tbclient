package com.baidu.tieba;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class qa {
    public static /* synthetic */ Interceptable $ic;
    public static qa a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448314781, "Lcom/baidu/tieba/qa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448314781, "Lcom/baidu/tieba/qa;");
        }
    }

    public qa() {
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

    public static qa f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (qa.class) {
                    if (a == null) {
                        a = new qa();
                    }
                }
            }
            return a;
        }
        return (qa) invokeV.objValue;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                si.a(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                tg.d(byteArrayOutputStream);
                tg.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public byte[] g(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048581, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                si.c(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                tg.d(byteArrayOutputStream);
                tg.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public SocketResponsedMessage b(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        InterceptResult invokeCommon;
        int i2;
        SocketResponsedMessage newInstance;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), bArr, socketMessage, socketMessageTask, Boolean.valueOf(z)})) == null) {
            try {
                Class<? extends SocketResponsedMessage> responsedClass = socketMessageTask.getResponsedClass();
                try {
                    newInstance = responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                    newInstance = responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
                }
                newInstance.setOrginalMessage(socketMessage);
                if (z) {
                    try {
                        newInstance.onDecodeFailedInBackGround(i, bArr, na.c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    newInstance.decodeInBackGround(i, bArr);
                }
                return newInstance;
            } catch (Throwable th) {
                long j = 0;
                if (socketMessage != null) {
                    j = socketMessage.getClientLogID();
                }
                long j2 = j;
                if (bArr != null) {
                    i2 = bArr.length;
                } else {
                    i2 = 0;
                }
                BdStatisticsManager.getInstance().error("im", j2, (String) null, "cmd", Integer.valueOf(i), "byteslength", Integer.valueOf(i2), "comment", th.getMessage());
                throw new CoderException(na.c);
            }
        }
        return (SocketResponsedMessage) invokeCommon.objValue;
    }

    public ra c(byte[] bArr) throws CoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int f = pa.f();
            if (bArr != null && bArr.length >= f) {
                pa a2 = pa.a(bArr);
                if (a2 != null) {
                    ra raVar = new ra();
                    raVar.a = a2;
                    raVar.b = bArr;
                    raVar.c = f;
                    raVar.d = bArr.length - f;
                    return raVar;
                }
                throw new CoderException(na.b);
            }
            throw new CoderException(na.b);
        }
        return (ra) invokeL.objValue;
    }

    public ra d(ra raVar) throws CoderException {
        InterceptResult invokeL;
        pa paVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, raVar)) == null) {
            if (raVar != null && (paVar = raVar.a) != null && raVar.b != null) {
                if (paVar.d() && raVar.d > 0) {
                    if (sa.a().b() != null) {
                        try {
                            byte[] a2 = ej.a(sa.a().b(), raVar.b, raVar.c, raVar.d);
                            raVar.b = a2;
                            raVar.c = 0;
                            raVar.d = a2.length;
                        } catch (Exception unused) {
                            throw new CoderException(na.h);
                        }
                    } else {
                        throw new CoderException(na.g);
                    }
                }
                if (paVar.c() && (i = raVar.d) > 0) {
                    try {
                        byte[] g = g(raVar.b, raVar.c, i);
                        raVar.b = g;
                        raVar.c = 0;
                        raVar.d = g.length;
                    } catch (Exception unused2) {
                        throw new CoderException(na.f);
                    }
                }
                return raVar;
            }
            throw new CoderException(na.b);
        }
        return (ra) invokeL.objValue;
    }

    public byte[] e(SocketMessage socketMessage, int i, boolean z, boolean z2) throws CoderException {
        InterceptResult invokeCommon;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{socketMessage, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (socketMessage == null) {
                return null;
            }
            byte[] encodeInBackGround = socketMessage.encodeInBackGround();
            byte[] encodeExtraDataInBackGround = socketMessage.encodeExtraDataInBackGround();
            if (encodeExtraDataInBackGround != null) {
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + pa.g);
                if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                    allocate.putInt(encodeExtraDataInBackGround.length);
                    allocate.put(encodeExtraDataInBackGround);
                    allocate.put(encodeInBackGround);
                    encodeInBackGround = allocate.array();
                    z3 = true;
                } else {
                    throw new CoderException(na.e);
                }
            } else {
                z3 = false;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = ej.c(sa.a().b(), encodeInBackGround);
            }
            return pa.i(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
