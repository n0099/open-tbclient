package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.client.socket.coder.CoderException;
import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes8.dex */
public class u5 extends BdAsyncTask<String, SocketResponsedMessage, SocketResponsedMessage> {
    public static /* synthetic */ Interceptable $ic;
    public static final BdUniqueId f;
    public transient /* synthetic */ FieldHolder $fh;
    public a a;
    public c6 b;
    public v5 c;
    public int d;
    public SocketMessageTask e;

    /* loaded from: classes8.dex */
    public interface a {
        void a(b bVar);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public SocketResponsedMessage a;
        public v5 b;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448317261, "Lcom/baidu/tieba/u5;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448317261, "Lcom/baidu/tieba/u5;");
                return;
            }
        }
        f = BdUniqueId.gen();
    }

    public static BdUniqueId e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return f;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onCancelled() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onCancelled();
            b(null);
        }
    }

    public u5(c6 c6Var, v5 v5Var, a aVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {c6Var, v5Var, aVar, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.b = c6Var;
        this.c = v5Var;
        this.a = aVar;
        this.d = i;
        if (v5Var != null) {
            try {
                this.e = v5Var.t();
            } catch (Exception e) {
                BdLog.e(e.getMessage());
            }
        }
        if (this.e == null) {
            this.e = (SocketMessageTask) MessageManager.getInstance().findTask(this.b.a.b());
        }
        setTag(f);
        setPriority(4);
        SocketMessageTask socketMessageTask = this.e;
        if (socketMessageTask != null) {
            setKey(String.valueOf(socketMessageTask.getCmd()));
            setParallel(this.e.getParallel());
        }
    }

    public final void b(SocketResponsedMessage socketResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, socketResponsedMessage) == null) && this.a != null) {
            boolean c = c(socketResponsedMessage, this.c);
            b bVar = new b();
            bVar.a = socketResponsedMessage;
            if (!c) {
                bVar.b = this.c;
            }
            this.a.a(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: f */
    public void onProgressUpdate(SocketResponsedMessage... socketResponsedMessageArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, socketResponsedMessageArr) == null) {
            if (socketResponsedMessageArr != null && socketResponsedMessageArr.length > 0) {
                b(socketResponsedMessageArr[0]);
            } else {
                b(null);
            }
        }
    }

    public final boolean c(SocketResponsedMessage socketResponsedMessage, v5 v5Var) {
        InterceptResult invokeLL;
        long clientLogID;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage, v5Var)) == null) {
            if (this.d != 0 && v5Var != null && socketResponsedMessage == null) {
                int k = v5Var.k();
                if (v5Var.m() == null) {
                    clientLogID = -1;
                } else {
                    clientLogID = v5Var.m().getClientLogID();
                }
                z5.b("unpacker", k, clientLogID, this.d, "checkresponsedMessage", y5.l, "ack cont responsed");
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
        if (r14.d != r14.b.length) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ff A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0146 A[Catch: CoderException -> 0x01ad, TRY_LEAVE, TryCatch #3 {CoderException -> 0x01ad, blocks: (B:62:0x013e, B:64:0x0146, B:70:0x017f), top: B:119:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ed  */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SocketResponsedMessage doInBackground(String... strArr) {
        InterceptResult invokeL;
        c6 c6Var;
        int i;
        SocketResponsedMessage socketResponsedMessage;
        long j;
        v5 v5Var;
        long j2;
        long j3;
        long j4;
        boolean g;
        int i2;
        long currentTimeMillis;
        long j5;
        long j6;
        long j7;
        long j8;
        long j9;
        SocketMessage socketMessage;
        long j10;
        long j11;
        long j12;
        long j13;
        int i3;
        long j14;
        byte[] bArr;
        c6 c6Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, strArr)) == null) {
            SocketResponsedMessage socketResponsedMessage2 = null;
            if (this.b == null) {
                return null;
            }
            try {
                j2 = 0;
                if (this.c != null) {
                    try {
                        j3 = this.c.m;
                    } catch (CoderException unused) {
                        c6Var = null;
                        i = 0;
                        j = -100;
                        v5Var = this.c;
                        if (v5Var != null) {
                        }
                        z5.b("unpacker", i, j, this.d, "unpacktask", y5.k, "onBinaryMesssage decodebody error");
                        socketResponsedMessage = socketResponsedMessage2;
                        if (socketResponsedMessage != null) {
                        }
                        publishProgress(socketResponsedMessage);
                        if (socketResponsedMessage == null) {
                        }
                    }
                } else {
                    j3 = 0;
                }
                if (this.c != null) {
                    j4 = this.c.n;
                } else {
                    j4 = 0;
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                i = this.b.a.b();
                try {
                    g = this.b.a.g();
                    i2 = this.b.d;
                    b6 f2 = b6.f();
                    c6Var = this.b;
                    f2.d(c6Var);
                    try {
                        currentTimeMillis = System.currentTimeMillis();
                        if (this.c != null) {
                            try {
                                SocketMessage m = this.c.m();
                                long startTime = m.getStartTime();
                                long s = this.c.s();
                                long j15 = s - startTime;
                                long j16 = currentTimeMillis2 - s;
                                if (j3 > 0) {
                                    j7 = j3 - s;
                                    if (j4 >= j3) {
                                        j8 = j4 - s;
                                        j5 = j4 - j3;
                                        j6 = currentTimeMillis2 - j4;
                                        j9 = currentTimeMillis - currentTimeMillis2;
                                        socketMessage = m;
                                        j10 = j5;
                                        j11 = j6;
                                        j12 = j7;
                                        j13 = j8;
                                        j2 = j15;
                                    } else {
                                        j5 = 0;
                                        j6 = 0;
                                    }
                                } else {
                                    j5 = 0;
                                    j6 = 0;
                                    j7 = 0;
                                }
                                j8 = j16;
                                j9 = currentTimeMillis - currentTimeMillis2;
                                socketMessage = m;
                                j10 = j5;
                                j11 = j6;
                                j12 = j7;
                                j13 = j8;
                                j2 = j15;
                            } catch (CoderException unused2) {
                                j = -100;
                                v5Var = this.c;
                                if (v5Var != null) {
                                    j = this.c.m().getClientLogID();
                                }
                                z5.b("unpacker", i, j, this.d, "unpacktask", y5.k, "onBinaryMesssage decodebody error");
                                socketResponsedMessage = socketResponsedMessage2;
                                if (socketResponsedMessage != null) {
                                }
                                publishProgress(socketResponsedMessage);
                                if (socketResponsedMessage == null) {
                                }
                            }
                        } else {
                            socketMessage = null;
                            j13 = 0;
                            j12 = 0;
                            j10 = 0;
                            j11 = 0;
                            j9 = 0;
                        }
                        if (c6Var.c == 0) {
                            try {
                            } catch (CoderException unused3) {
                                socketResponsedMessage2 = null;
                                j = -100;
                                v5Var = this.c;
                                if (v5Var != null) {
                                }
                                z5.b("unpacker", i, j, this.d, "unpacktask", y5.k, "onBinaryMesssage decodebody error");
                                socketResponsedMessage = socketResponsedMessage2;
                                if (socketResponsedMessage != null) {
                                }
                                publishProgress(socketResponsedMessage);
                                if (socketResponsedMessage == null) {
                                }
                            }
                        }
                    } catch (CoderException unused4) {
                    }
                } catch (CoderException unused5) {
                    socketResponsedMessage2 = null;
                    c6Var = null;
                }
            } catch (CoderException unused6) {
                socketResponsedMessage2 = null;
                c6Var = null;
            }
            if (c6Var.d <= 0) {
                c6Var.b = null;
                i3 = i2;
                j14 = j11;
                bArr = null;
                long j17 = j14;
                long j18 = j10;
                try {
                    socketResponsedMessage = b6.f().b(i, c6Var.b, socketMessage, this.e, g);
                    if (socketResponsedMessage != null && bArr != null) {
                        try {
                            try {
                                socketResponsedMessage.decodeExtraDataInBackGround(i, bArr);
                            } catch (Exception unused7) {
                                throw new CoderException(y5.d);
                            }
                        } catch (CoderException unused8) {
                            socketResponsedMessage2 = socketResponsedMessage;
                            i = i;
                            c6Var = c6Var;
                            j = -100;
                            v5Var = this.c;
                            if (v5Var != null) {
                            }
                            z5.b("unpacker", i, j, this.d, "unpacktask", y5.k, "onBinaryMesssage decodebody error");
                            socketResponsedMessage = socketResponsedMessage2;
                            if (socketResponsedMessage != null) {
                            }
                            publishProgress(socketResponsedMessage);
                            if (socketResponsedMessage == null) {
                            }
                        }
                    }
                    try {
                        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
                        if (socketResponsedMessage == null) {
                            if (this.c != null && this.b != null) {
                                socketResponsedMessage.setCostTime(System.currentTimeMillis() - this.c.s());
                                socketResponsedMessage.setRetry(this.c.o());
                                socketResponsedMessage.performanceData.a = j2;
                                socketResponsedMessage.performanceData.c = j13;
                                socketResponsedMessage.performanceData.d = j12;
                                socketResponsedMessage.performanceData.e = j18;
                                socketResponsedMessage.performanceData.h = j17;
                            }
                            socketResponsedMessage.setDownSize(i3);
                            socketResponsedMessage.performanceData.g = currentTimeMillis3;
                            socketResponsedMessage.performanceData.f = j9;
                            socketResponsedMessage.sequenceID = this.b.a.h();
                            c6Var2 = c6Var;
                            try {
                                socketResponsedMessage.beforeDispatchInBackGround(i, c6Var2.b);
                            } catch (Exception e) {
                                try {
                                    BdLog.e(e.getMessage());
                                } catch (CoderException unused9) {
                                    c6Var = c6Var2;
                                    socketResponsedMessage2 = socketResponsedMessage;
                                    i = i;
                                    j = -100;
                                    v5Var = this.c;
                                    if (v5Var != null && v5Var.m() != null) {
                                        j = this.c.m().getClientLogID();
                                    }
                                    z5.b("unpacker", i, j, this.d, "unpacktask", y5.k, "onBinaryMesssage decodebody error");
                                    socketResponsedMessage = socketResponsedMessage2;
                                    if (socketResponsedMessage != null) {
                                    }
                                    publishProgress(socketResponsedMessage);
                                    if (socketResponsedMessage == null) {
                                    }
                                }
                            }
                        } else {
                            c6Var2 = c6Var;
                        }
                        c6Var = c6Var2;
                        i = i;
                    } catch (CoderException unused10) {
                        c6Var2 = c6Var;
                    }
                } catch (CoderException unused11) {
                    c6Var = c6Var;
                    i = i;
                    socketResponsedMessage2 = null;
                    j = -100;
                    v5Var = this.c;
                    if (v5Var != null) {
                    }
                    z5.b("unpacker", i, j, this.d, "unpacktask", y5.k, "onBinaryMesssage decodebody error");
                    socketResponsedMessage = socketResponsedMessage2;
                    if (socketResponsedMessage != null) {
                    }
                    publishProgress(socketResponsedMessage);
                    if (socketResponsedMessage == null) {
                    }
                }
                if (socketResponsedMessage != null) {
                    socketResponsedMessage.setStartTime(System.currentTimeMillis());
                }
                publishProgress(socketResponsedMessage);
                if (socketResponsedMessage == null) {
                    try {
                        h5 h5Var = h5.b;
                        if (h5Var != null) {
                            h5Var.a(socketResponsedMessage.getCmd(), StatConstants.VALUE_TYPE_RECEIVE, socketResponsedMessage.getDecodeData());
                        }
                        if (c6Var != null) {
                            socketResponsedMessage.afterDispatchInBackGround(i, c6Var.b);
                            return null;
                        }
                        return null;
                    } catch (Exception e2) {
                        BdLog.e(e2.getMessage());
                        return null;
                    }
                }
                return null;
            }
            if (this.b.a.e()) {
                try {
                    j14 = j11;
                    short s2 = ByteBuffer.wrap(c6Var.b, c6Var.c, a6.g).getShort();
                    int i4 = a6.g + s2;
                    i3 = i2;
                    byte[] array = ByteBuffer.allocateDirect(s2).put(c6Var.b, c6Var.c + a6.g, s2).array();
                    c6Var.c += i4;
                    c6Var.d -= i4;
                    bArr = array;
                } catch (Exception unused12) {
                    throw new CoderException(y5.d);
                }
            } else {
                i3 = i2;
                j14 = j11;
                bArr = null;
            }
            c6Var.b = ByteBuffer.allocateDirect(c6Var.d).put(c6Var.b, c6Var.c, c6Var.d).array();
            long j172 = j14;
            long j182 = j10;
            socketResponsedMessage = b6.f().b(i, c6Var.b, socketMessage, this.e, g);
            if (socketResponsedMessage != null) {
                socketResponsedMessage.decodeExtraDataInBackGround(i, bArr);
            }
            long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis;
            if (socketResponsedMessage == null) {
            }
            c6Var = c6Var2;
            i = i;
            if (socketResponsedMessage != null) {
            }
            publishProgress(socketResponsedMessage);
            if (socketResponsedMessage == null) {
            }
        } else {
            return (SocketResponsedMessage) invokeL.objValue;
        }
    }
}
