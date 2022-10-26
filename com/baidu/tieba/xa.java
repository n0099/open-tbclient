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
/* loaded from: classes6.dex */
public class xa {
    public static /* synthetic */ Interceptable $ic;
    public static xa a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448321508, "Lcom/baidu/tieba/xa;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448321508, "Lcom/baidu/tieba/xa;");
        }
    }

    public xa() {
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

    public static xa f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (a == null) {
                synchronized (xa.class) {
                    if (a == null) {
                        a = new xa();
                    }
                }
            }
            return a;
        }
        return (xa) invokeV.objValue;
    }

    public byte[] a(byte[] bArr, int i, int i2) throws Exception {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, bArr, i, i2)) == null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bj.a(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                dh.d(byteArrayOutputStream);
                dh.c(byteArrayInputStream);
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
                bj.c(byteArrayInputStream, byteArrayOutputStream);
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            } finally {
                dh.d(byteArrayOutputStream);
                dh.c(byteArrayInputStream);
            }
        }
        return (byte[]) invokeLII.objValue;
    }

    public SocketResponsedMessage b(int i, byte[] bArr, SocketMessage socketMessage, SocketMessageTask socketMessageTask, boolean z) throws CoderException {
        InterceptResult invokeCommon;
        int i2;
        SocketResponsedMessage socketResponsedMessage;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), bArr, socketMessage, socketMessageTask, Boolean.valueOf(z)})) == null) {
            try {
                Class responsedClass = socketMessageTask.getResponsedClass();
                try {
                    socketResponsedMessage = (SocketResponsedMessage) responsedClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Exception unused) {
                    socketResponsedMessage = (SocketResponsedMessage) responsedClass.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(i));
                }
                socketResponsedMessage.setOrginalMessage(socketMessage);
                if (z) {
                    try {
                        socketResponsedMessage.onDecodeFailedInBackGround(i, bArr, ua.c);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    socketResponsedMessage.decodeInBackGround(i, bArr);
                }
                return socketResponsedMessage;
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
                throw new CoderException(ua.c);
            }
        }
        return (SocketResponsedMessage) invokeCommon.objValue;
    }

    public ya c(byte[] bArr) throws CoderException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bArr)) == null) {
            int f = wa.f();
            if (bArr != null && bArr.length >= f) {
                wa a2 = wa.a(bArr);
                if (a2 != null) {
                    ya yaVar = new ya();
                    yaVar.a = a2;
                    yaVar.b = bArr;
                    yaVar.c = f;
                    yaVar.d = bArr.length - f;
                    return yaVar;
                }
                throw new CoderException(ua.b);
            }
            throw new CoderException(ua.b);
        }
        return (ya) invokeL.objValue;
    }

    public ya d(ya yaVar) throws CoderException {
        InterceptResult invokeL;
        wa waVar;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, yaVar)) == null) {
            if (yaVar != null && (waVar = yaVar.a) != null && yaVar.b != null) {
                if (waVar.d() && yaVar.d > 0) {
                    if (za.a().b() != null) {
                        try {
                            byte[] a2 = nj.a(za.a().b(), yaVar.b, yaVar.c, yaVar.d);
                            yaVar.b = a2;
                            yaVar.c = 0;
                            yaVar.d = a2.length;
                        } catch (Exception unused) {
                            throw new CoderException(ua.h);
                        }
                    } else {
                        throw new CoderException(ua.g);
                    }
                }
                if (waVar.c() && (i = yaVar.d) > 0) {
                    try {
                        byte[] g = g(yaVar.b, yaVar.c, i);
                        yaVar.b = g;
                        yaVar.c = 0;
                        yaVar.d = g.length;
                    } catch (Exception unused2) {
                        throw new CoderException(ua.f);
                    }
                }
                return yaVar;
            }
            throw new CoderException(ua.b);
        }
        return (ya) invokeL.objValue;
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
                ByteBuffer allocate = ByteBuffer.allocate(encodeInBackGround.length + encodeExtraDataInBackGround.length + wa.g);
                if (encodeExtraDataInBackGround.length <= Integer.MAX_VALUE) {
                    allocate.putInt(encodeExtraDataInBackGround.length);
                    allocate.put(encodeExtraDataInBackGround);
                    allocate.put(encodeInBackGround);
                    encodeInBackGround = allocate.array();
                    z3 = true;
                } else {
                    throw new CoderException(ua.e);
                }
            } else {
                z3 = false;
            }
            if (encodeInBackGround != null && z) {
                encodeInBackGround = a(encodeInBackGround, 0, encodeInBackGround.length);
            }
            if (encodeInBackGround != null && z2) {
                encodeInBackGround = nj.c(za.a().b(), encodeInBackGround);
            }
            return wa.i(z2, z, socketMessage.getCmd(), i, encodeInBackGround, z3);
        }
        return (byte[]) invokeCommon.objValue;
    }
}
