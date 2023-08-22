package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.lcp.sdk.pb.LcmPb$LcmResponse;
import com.baidu.lcp.sdk.pb.LcmPb$RpcData;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcNotifyMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcRequestMeta;
import com.baidu.lcp.sdk.pb.RpcMetaPb$RpcResponseMeta;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
/* loaded from: classes7.dex */
public class p90 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public p90() {
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

    public final e90 a(e90 e90Var, byte[] bArr) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, e90Var, bArr)) == null) {
            LcmPb$RpcData parseFrom = LcmPb$RpcData.parseFrom(bArr);
            if (parseFrom.hasLcmResponse()) {
                LcmPb$LcmResponse lcmResponse = parseFrom.getLcmResponse();
                if (y90.a) {
                    z90.a("PbProcessor", "methodId ：" + e90Var.j + ", logId :" + lcmResponse.getLogId() + ", errMsg :" + lcmResponse.getErrorMsg() + ", errCode :" + lcmResponse.getErrorCode() + ", pingMS :" + lcmResponse.getNextIntervalMs());
                }
                if (lcmResponse.getErrorCode() == 0) {
                    long j = e90Var.j;
                    if (j == 1) {
                        e90Var.k = 0;
                        e90Var.h = lcmResponse.getNextIntervalMs();
                        e90Var.r = lcmResponse.getServerInfo();
                    } else if (j == 2) {
                        e90Var.k = -1;
                    } else if (j == 3) {
                        e90Var.h = lcmResponse.getNextIntervalMs();
                    } else if (j == 4 && y90.a) {
                        z90.a("PbProcessor", "parseLcmResponse notify");
                    }
                    e90Var.d = 0;
                } else {
                    e90Var.d = lcmResponse.getErrorCode();
                    e90Var.e = lcmResponse.getErrorMsg();
                    e90Var.k = -1;
                }
            } else if (parseFrom.hasLcmNotify()) {
                if (y90.a) {
                    z90.a("PbProcessor", "lcmpb hasLcmNotify");
                }
            } else if (parseFrom.hasLcmRequest()) {
                e90Var.o = parseFrom.getLcmRequest().getLogId();
                e90Var.d = 0;
            }
            return e90Var;
        }
        return (e90) invokeLL.objValue;
    }

    public e90 b(DataInputStream dataInputStream) throws Exception {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dataInputStream)) == null) {
            z90.a("PbProcessor", "parseResponse");
            e90 e90Var = new e90();
            byte readByte = dataInputStream.readByte();
            byte readByte2 = dataInputStream.readByte();
            byte readByte3 = dataInputStream.readByte();
            byte readByte4 = dataInputStream.readByte();
            int readInt = dataInputStream.readInt();
            int readInt2 = dataInputStream.readInt();
            if (readInt <= 1048576 && readInt2 <= 1048576) {
                byte[] bArr = new byte[readInt2];
                dataInputStream.readFully(bArr);
                int i = readInt - readInt2;
                byte[] bArr2 = new byte[i];
                dataInputStream.readFully(bArr2);
                z90.e("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2 + ", payload :" + i);
                c(e90Var, bArr, bArr2);
                e90Var.t = (long) i;
                if (e90Var.d == -1) {
                    e90Var.d = JosStatusCodes.RNT_CODE_NO_JOS_INFO;
                }
                return e90Var;
            }
            z90.b("PbProcessor", "l :" + ((int) readByte) + ", c :" + ((int) readByte2) + ", p :" + ((int) readByte3) + ", v :" + ((int) readByte4) + ",data : " + readInt + ", rpc :" + readInt2);
            throw new Exception(" Failed to allocate a larger byte allocation, data length = " + readInt);
        }
        return (e90) invokeL.objValue;
    }

    public final e90 c(e90 e90Var, byte[] bArr, byte[] bArr2) throws Exception {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, e90Var, bArr, bArr2)) == null) {
            RpcMetaPb$RpcMeta parseFrom = RpcMetaPb$RpcMeta.parseFrom(bArr);
            if (parseFrom.getCompressType() == 1) {
                bArr2 = d(bArr2);
                if (y90.a) {
                    z90.a("PbProcessor", "payload is gzip compressed，length : " + bArr2.length);
                }
            }
            e90Var.g = bArr2;
            int i = 0;
            if (parseFrom.hasNotify()) {
                RpcMetaPb$RpcNotifyMeta notify = parseFrom.getNotify();
                e90Var.d = 0;
                e90Var.e = "notify";
                e90Var.i = notify.getServiceId();
                e90Var.j = notify.getMethodId();
                e90Var.o = notify.getLogId();
                e90Var.f = true;
                e90Var.q.clear();
                while (i < notify.getEventListCount()) {
                    e90Var.q.add(new y80(notify.getEventList(i).getEvent(), notify.getEventList(i).getTimestampMs()));
                    i++;
                }
                e90Var.q.add(new y80("CLCPNotify", System.currentTimeMillis()));
            } else if (parseFrom.hasResponse()) {
                RpcMetaPb$RpcResponseMeta response = parseFrom.getResponse();
                e90Var.d = response.getErrorCode();
                e90Var.e = response.getErrorText();
                e90Var.i = response.getServiceId();
                e90Var.j = response.getMethodId();
                e90Var.o = response.getLogId();
                e90Var.f = false;
                e90Var.q.clear();
                while (i < response.getEventListCount()) {
                    e90Var.q.add(new y80(response.getEventList(i).getEvent(), response.getEventList(i).getTimestampMs()));
                    i++;
                }
                e90Var.q.add(new y80("CLCPResEnd", System.currentTimeMillis()));
                if (e90Var.d == 0 && e90Var.i == 1) {
                    a(e90Var, bArr2);
                    return e90Var;
                }
            } else if (parseFrom.hasRequest()) {
                RpcMetaPb$RpcRequestMeta request = parseFrom.getRequest();
                e90Var.i = request.getServiceId();
                e90Var.j = request.getMethodId();
                if (y90.a) {
                    z90.a("PbProcessor", "parseRpcMeta requestMeta");
                }
                a(e90Var, bArr2);
            }
            return e90Var;
        }
        return (e90) invokeLLL.objValue;
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0065: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:38:0x0065 */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] d(byte[] bArr) {
        InterceptResult invokeL;
        GZIPInputStream gZIPInputStream;
        IOException e;
        GZIPInputStream gZIPInputStream2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bArr)) == null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream3 = null;
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = gZIPInputStream.read(bArr2);
                            if (read < 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        try {
                            gZIPInputStream.close();
                            byteArrayInputStream.close();
                            byteArrayOutputStream.close();
                        } catch (Exception e2) {
                            if (y90.a) {
                                z90.c("SocketTransceiver", "Exception ", e2);
                            }
                        }
                        return byteArray;
                    } catch (IOException e3) {
                        e = e3;
                        if (y90.a) {
                            z90.c("SocketTransceiver", "unzip exception :", e);
                        }
                        if (gZIPInputStream != null) {
                            try {
                                gZIPInputStream.close();
                            } catch (Exception e4) {
                                if (y90.a) {
                                    z90.c("SocketTransceiver", "Exception ", e4);
                                }
                                return bArr;
                            }
                        }
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                        return bArr;
                    }
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream3 = gZIPInputStream2;
                    if (gZIPInputStream3 != null) {
                        try {
                            gZIPInputStream3.close();
                        } catch (Exception e5) {
                            if (y90.a) {
                                z90.c("SocketTransceiver", "Exception ", e5);
                            }
                            throw th;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (IOException e6) {
                gZIPInputStream = null;
                e = e6;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream3 != null) {
                }
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
                throw th;
            }
        } else {
            return (byte[]) invokeL.objValue;
        }
    }
}
