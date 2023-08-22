package com.baidu.tieba;

import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.safe.BdCloseHelper;
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
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes7.dex */
public class la {
    public static /* synthetic */ Interceptable $ic;
    public static la a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448309976, "Lcom/baidu/tieba/la;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448309976, "Lcom/baidu/tieba/la;");
        }
    }

    public la() {
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

    public static la f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (la.class) {
                    if (a == null) {
                        a = new la();
                    }
                }
            }
            return a;
        }
        return (la) invokeV.objValue;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                ai.a(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                BdCloseHelper.close((InputStream) byteArrayInputStream);
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
                ai.c(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                BdCloseHelper.close((OutputStream) byteArrayOutputStream);
                BdCloseHelper.close((InputStream) byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public SocketResponsedMessage b(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        SocketResponsedMessage newInstance;
        InterceptResult invokeCommon;
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
                        newInstance.onDecodeFailedInBackGround(i, bArr, ia.c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    newInstance.decodeInBackGround(i, bArr);
                }
                return newInstance;
            } catch (Throwable th) {
                if (socketMessage != null) {
                    socketMessage.getClientLogID();
                }
                if (bArr != null) {
                    int length = bArr.length;
                }
                th.getMessage();
                throw new CoderException(ia.c);
            }
        }
        return (SocketResponsedMessage) invokeCommon.objValue;
    }

    public ma c(byte[] bArr) throws CoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int f = ka.f();
            if (bArr != null && bArr.length >= f) {
                ka a2 = ka.a(bArr);
                if (a2 != null) {
                    ma maVar = new ma();
                    maVar.a = a2;
                    maVar.b = bArr;
                    maVar.c = f;
                    maVar.d = bArr.length - f;
                    return maVar;
                }
                throw new CoderException(ia.b);
            }
            throw new CoderException(ia.b);
        }
        return (ma) invokeL.objValue;
    }

    public ma d(ma maVar) throws CoderException {
        InterceptResult invokeL;
        ka kaVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, maVar)) == null) {
            if (maVar != null && (kaVar = maVar.a) != null && maVar.b != null) {
                if (kaVar.d() && maVar.d > 0) {
                    if (na.a().b() != null) {
                        try {
                            byte[] a2 = ki.a(na.a().b(), maVar.b, maVar.c, maVar.d);
                            maVar.b = a2;
                            maVar.c = 0;
                            maVar.d = a2.length;
                        } catch (Exception unused) {
                            throw new CoderException(ia.h);
                        }
                    } else {
                        throw new CoderException(ia.g);
                    }
                }
                if (kaVar.c() && (i = maVar.d) > 0) {
                    try {
                        byte[] g = g(maVar.b, maVar.c, i);
                        maVar.b = g;
                        maVar.c = 0;
                        maVar.d = g.length;
                    } catch (Exception unused2) {
                        throw new CoderException(ia.f);
                    }
                }
                return maVar;
            }
            throw new CoderException(ia.b);
        }
        return (ma) invokeL.objValue;
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
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + ka.g);
                if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                    allocate.putInt(encodeExtraDataInBackGround.length);
                    allocate.put(encodeExtraDataInBackGround);
                    allocate.put(encodeInBackGround);
                    encodeInBackGround = allocate.array();
                    z3 = true;
                } else {
                    throw new CoderException(ia.e);
                }
            } else {
                z3 = false;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = ki.c(na.a().b(), encodeInBackGround);
            }
            return ka.i(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
