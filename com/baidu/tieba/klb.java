package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.PrintStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import kotlin.jvm.internal.ByteCompanionObject;
import okhttp3.internal.ws.WebSocketProtocol;
import org.apache.http.protocol.HTTP;
import org.java_websocket.WebSocket;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.IncompleteException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidFrameException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExedeedException;
import org.java_websocket.exceptions.NotSendableException;
import org.java_websocket.framing.Framedata;
/* loaded from: classes6.dex */
public class klb extends Draft {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public mlb c;
    public List<mlb> d;
    public fmb e;
    public List<fmb> f;
    public Framedata g;
    public List<ByteBuffer> h;
    public ByteBuffer i;
    public final Random j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947918344, "Lcom/baidu/tieba/klb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947918344, "Lcom/baidu/tieba/klb;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public klb() {
        this(Collections.emptyList());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((List) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public mlb A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (mlb) invokeV.objValue;
    }

    public List<mlb> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<fmb> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public fmb E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (fmb) invokeV.objValue;
    }

    public final String F() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            return simpleDateFormat.format(calendar.getTime());
        }
        return (String) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            mlb mlbVar = this.c;
            int i2 = 0;
            if (mlbVar != null) {
                i = mlbVar.hashCode();
            } else {
                i = 0;
            }
            int i3 = i * 31;
            fmb fmbVar = this.e;
            if (fmbVar != null) {
                i2 = fmbVar.hashCode();
            }
            return i3 + i2;
        }
        return invokeV.intValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.CloseHandshakeType l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return Draft.CloseHandshakeType.TWOWAY;
        }
        return (Draft.CloseHandshakeType) invokeV.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            this.i = null;
            mlb mlbVar = this.c;
            if (mlbVar != null) {
                mlbVar.reset();
            }
            this.c = new llb();
            this.e = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public klb(List<mlb> list) {
        this(list, Collections.singletonList(new gmb("")));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((List) objArr2[0], (List) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final Framedata.Opcode I(byte b) throws InvalidFrameException {
        InterceptResult invokeB;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeB = interceptable.invokeB(1048583, this, b)) == null) {
            if (b != 0) {
                if (b != 1) {
                    if (b != 2) {
                        switch (b) {
                            case 8:
                                return Framedata.Opcode.CLOSING;
                            case 9:
                                return Framedata.Opcode.PING;
                            case 10:
                                return Framedata.Opcode.PONG;
                            default:
                                throw new InvalidFrameException("Unknown opcode " + ((int) b));
                        }
                    }
                    return Framedata.Opcode.BINARY;
                }
                return Framedata.Opcode.TEXT;
            }
            return Framedata.Opcode.CONTINUOUS;
        }
        return (Framedata.Opcode) invokeB.objValue;
    }

    public final byte y(Framedata.Opcode opcode) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, opcode)) == null) {
            if (opcode == Framedata.Opcode.CONTINUOUS) {
                return (byte) 0;
            }
            if (opcode == Framedata.Opcode.TEXT) {
                return (byte) 1;
            }
            if (opcode == Framedata.Opcode.BINARY) {
                return (byte) 2;
            }
            if (opcode == Framedata.Opcode.CLOSING) {
                return (byte) 8;
            }
            if (opcode == Framedata.Opcode.PING) {
                return (byte) 9;
            }
            if (opcode == Framedata.Opcode.PONG) {
                return (byte) 10;
            }
            throw new IllegalArgumentException("Don't know how to handle " + opcode.toString());
        }
        return invokeL.byteValue;
    }

    public klb(List<mlb> list, List<fmb> list2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {list, list2};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.c = new llb();
        this.j = new Random();
        if (list != null && list2 != null) {
            this.d = new ArrayList(list.size());
            this.f = new ArrayList(list2.size());
            boolean z = false;
            this.h = new ArrayList();
            for (mlb mlbVar : list) {
                if (mlbVar.getClass().equals(llb.class)) {
                    z = true;
                }
            }
            this.d.addAll(list);
            if (!z) {
                List<mlb> list3 = this.d;
                list3.add(list3.size(), this.c);
            }
            this.f.addAll(list2);
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void G(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj) == null) && hlb.u) {
            System.out.println(obj);
        }
    }

    public final ByteBuffer D() throws LimitExedeedException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            long j = 0;
            for (ByteBuffer byteBuffer : this.h) {
                j += byteBuffer.limit();
            }
            if (j <= 2147483647L) {
                ByteBuffer allocate = ByteBuffer.allocate((int) j);
                for (ByteBuffer byteBuffer2 : this.h) {
                    allocate.put(byteBuffer2);
                }
                allocate.flip();
                return allocate;
            }
            throw new LimitExedeedException("Payloadsize is to big...");
        }
        return (ByteBuffer) invokeV.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (mlb mlbVar : B()) {
                arrayList.add(mlbVar.a());
            }
            ArrayList arrayList2 = new ArrayList();
            for (fmb fmbVar : C()) {
                arrayList2.add(fmbVar.a());
            }
            return new klb(arrayList, arrayList2);
        }
        return (Draft) invokeV.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            String draft = super.toString();
            if (A() != null) {
                draft = draft + " extension: " + A().toString();
            }
            if (E() != null) {
                return draft + " protocol: " + E().toString();
            }
            return draft;
        }
        return (String) invokeV.objValue;
    }

    public final byte[] H(long j, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Long.valueOf(j), Integer.valueOf(i)})) == null) {
            byte[] bArr = new byte[i];
            int i2 = (i * 8) - 8;
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) (j >>> (i2 - (i3 * 8)));
            }
            return bArr;
        }
        return (byte[]) invokeCommon.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> h(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048590, this, str, z)) == null) {
            vlb vlbVar = new vlb();
            vlbVar.j(ByteBuffer.wrap(jmb.f(str)));
            vlbVar.n(z);
            try {
                vlbVar.h();
                return Collections.singletonList(vlbVar);
            } catch (InvalidDataException e) {
                throw new NotSendableException(e);
            }
        }
        return (List) invokeLZ.objValue;
    }

    public Framedata J(ByteBuffer byteBuffer) throws IncompleteException, InvalidDataException {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, byteBuffer)) == null) {
            int remaining = byteBuffer.remaining();
            int i3 = 2;
            if (remaining >= 2) {
                byte b = byteBuffer.get();
                if ((b >> 8) != 0) {
                    z = true;
                } else {
                    z = false;
                }
                if ((b & 64) != 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((b & 32) != 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if ((b & 16) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                byte b2 = byteBuffer.get();
                if ((b2 & Byte.MIN_VALUE) != 0) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                byte b3 = (byte) (b2 & ByteCompanionObject.MAX_VALUE);
                Framedata.Opcode I = I((byte) (b & 15));
                if (b3 >= 0 && b3 <= 125) {
                    z6 = z2;
                    i = b3;
                } else if (I != Framedata.Opcode.PING && I != Framedata.Opcode.PONG && I != Framedata.Opcode.CLOSING) {
                    if (b3 == 126) {
                        if (remaining >= 4) {
                            z6 = z2;
                            i = new BigInteger(new byte[]{0, byteBuffer.get(), byteBuffer.get()}).intValue();
                            i3 = 4;
                        } else {
                            throw new IncompleteException(4);
                        }
                    } else {
                        i3 = 10;
                        if (remaining >= 10) {
                            byte[] bArr = new byte[8];
                            for (int i4 = 0; i4 < 8; i4++) {
                                bArr[i4] = byteBuffer.get();
                            }
                            z6 = z2;
                            long longValue = new BigInteger(bArr).longValue();
                            if (longValue <= 2147483647L) {
                                i = (int) longValue;
                            } else {
                                throw new LimitExedeedException("Payloadsize is to big...");
                            }
                        } else {
                            throw new IncompleteException(10);
                        }
                    }
                } else {
                    throw new InvalidFrameException("more than 125 octets");
                }
                if (z5) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
                int i5 = i3 + i2 + i;
                if (remaining >= i5) {
                    d(i);
                    ByteBuffer allocate = ByteBuffer.allocate(i);
                    if (z5) {
                        byte[] bArr2 = new byte[4];
                        byteBuffer.get(bArr2);
                        for (int i6 = 0; i6 < i; i6++) {
                            allocate.put((byte) (byteBuffer.get() ^ bArr2[i6 % 4]));
                        }
                    } else {
                        allocate.put(byteBuffer.array(), byteBuffer.position(), allocate.limit());
                        byteBuffer.position(byteBuffer.position() + allocate.limit());
                    }
                    slb g = slb.g(I);
                    g.i(z);
                    g.k(z6);
                    g.l(z3);
                    g.m(z4);
                    allocate.flip();
                    g.j(allocate);
                    A().h(g);
                    A().f(g);
                    if (hlb.u) {
                        PrintStream printStream = System.out;
                        StringBuilder sb = new StringBuilder();
                        sb.append("afterDecoding(");
                        sb.append(g.a().remaining());
                        sb.append("): {");
                        if (g.a().remaining() > 1000) {
                            str = "too big to display";
                        } else {
                            str = new String(g.a().array());
                        }
                        sb.append(str);
                        sb.append('}');
                        printStream.println(sb.toString());
                    }
                    g.h();
                    return g;
                }
                throw new IncompleteException(i5);
            }
            throw new IncompleteException(2);
        }
        return (Framedata) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState a(wlb wlbVar, dmb dmbVar) throws InvalidHandshakeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, wlbVar, dmbVar)) == null) {
            if (!c(dmbVar)) {
                G("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
                return Draft.HandshakeState.NOT_MATCHED;
            } else if (wlbVar.e("Sec-WebSocket-Key") && dmbVar.e("Sec-WebSocket-Accept")) {
                if (!z(wlbVar.d("Sec-WebSocket-Key")).equals(dmbVar.d("Sec-WebSocket-Accept"))) {
                    G("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
                String d = dmbVar.d("Sec-WebSocket-Extensions");
                Iterator<mlb> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    mlb next = it.next();
                    if (next.b(d)) {
                        this.c = next;
                        handshakeState = Draft.HandshakeState.MATCHED;
                        G("acceptHandshakeAsClient - Matching extension found: " + this.c.toString());
                        break;
                    }
                }
                Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
                String d2 = dmbVar.d("Sec-WebSocket-Protocol");
                Iterator<fmb> it2 = this.f.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    fmb next2 = it2.next();
                    if (next2.b(d2)) {
                        this.e = next2;
                        handshakeState2 = Draft.HandshakeState.MATCHED;
                        G("acceptHandshakeAsClient - Matching protocol found: " + this.e.toString());
                        break;
                    }
                }
                Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
                if (handshakeState2 == handshakeState3 && handshakeState == handshakeState3) {
                    return handshakeState3;
                }
                G("acceptHandshakeAsClient - No matching extension or protocol found.");
                return Draft.HandshakeState.NOT_MATCHED;
            } else {
                G("acceptHandshakeAsClient - Missing Sec-WebSocket-Key or Sec-WebSocket-Accept");
                return Draft.HandshakeState.NOT_MATCHED;
            }
        }
        return (Draft.HandshakeState) invokeLL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public Draft.HandshakeState b(wlb wlbVar) throws InvalidHandshakeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, wlbVar)) == null) {
            if (r(wlbVar) != 13) {
                G("acceptHandshakeAsServer - Wrong websocket version.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
            String d = wlbVar.d("Sec-WebSocket-Extensions");
            Iterator<mlb> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                mlb next = it.next();
                if (next.e(d)) {
                    this.c = next;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsServer - Matching extension found: " + this.c.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String d2 = wlbVar.d("Sec-WebSocket-Protocol");
            Iterator<fmb> it2 = this.f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                fmb next2 = it2.next();
                if (next2.b(d2)) {
                    this.e = next2;
                    handshakeState2 = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsServer - Matching protocol found: " + this.e.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState3 = Draft.HandshakeState.MATCHED;
            if (handshakeState2 == handshakeState3 && handshakeState == handshakeState3) {
                return handshakeState3;
            }
            G("acceptHandshakeAsServer - No matching extension or protocol found.");
            return Draft.HandshakeState.NOT_MATCHED;
        }
        return (Draft.HandshakeState) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public xlb m(xlb xlbVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, xlbVar)) == null) {
            xlbVar.put("Upgrade", "websocket");
            xlbVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            byte[] bArr = new byte[16];
            this.j.nextBytes(bArr);
            xlbVar.put("Sec-WebSocket-Key", hmb.g(bArr));
            xlbVar.put("Sec-WebSocket-Version", "13");
            StringBuilder sb = new StringBuilder();
            for (mlb mlbVar : this.d) {
                if (mlbVar.g() != null && mlbVar.g().length() != 0) {
                    if (sb.length() > 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb.append(mlbVar.g());
                }
            }
            if (sb.length() != 0) {
                xlbVar.put("Sec-WebSocket-Extensions", sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            for (fmb fmbVar : this.f) {
                if (fmbVar.c().length() != 0) {
                    if (sb2.length() > 0) {
                        sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb2.append(fmbVar.c());
                }
            }
            if (sb2.length() != 0) {
                xlbVar.put("Sec-WebSocket-Protocol", sb2.toString());
            }
            return xlbVar;
        }
        return (xlb) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> u(ByteBuffer byteBuffer) throws InvalidDataException {
        LinkedList linkedList;
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, byteBuffer)) == null) {
            while (true) {
                linkedList = new LinkedList();
                if (this.i == null) {
                    break;
                }
                try {
                    byteBuffer.mark();
                    int remaining = byteBuffer.remaining();
                    int remaining2 = this.i.remaining();
                    if (remaining2 > remaining) {
                        this.i.put(byteBuffer.array(), byteBuffer.position(), remaining);
                        byteBuffer.position(byteBuffer.position() + remaining);
                        return Collections.emptyList();
                    }
                    this.i.put(byteBuffer.array(), byteBuffer.position(), remaining2);
                    byteBuffer.position(byteBuffer.position() + remaining2);
                    linkedList.add(J((ByteBuffer) this.i.duplicate().position(0)));
                    this.i = null;
                } catch (IncompleteException e) {
                    int preferredSize = e.getPreferredSize();
                    d(preferredSize);
                    ByteBuffer allocate = ByteBuffer.allocate(preferredSize);
                    this.i.rewind();
                    allocate.put(this.i);
                    this.i = allocate;
                }
            }
            while (byteBuffer.hasRemaining()) {
                byteBuffer.mark();
                try {
                    linkedList.add(J(byteBuffer));
                } catch (IncompleteException e2) {
                    byteBuffer.reset();
                    int preferredSize2 = e2.getPreferredSize();
                    d(preferredSize2);
                    ByteBuffer allocate2 = ByteBuffer.allocate(preferredSize2);
                    this.i = allocate2;
                    allocate2.put(byteBuffer);
                }
            }
            return linkedList;
        }
        return (List) invokeL.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || klb.class != obj.getClass()) {
                return false;
            }
            klb klbVar = (klb) obj;
            mlb mlbVar = this.c;
            if (mlbVar == null ? klbVar.c != null : !mlbVar.equals(klbVar.c)) {
                return false;
            }
            fmb fmbVar = this.e;
            fmb fmbVar2 = klbVar.e;
            if (fmbVar != null) {
                return fmbVar.equals(fmbVar2);
            }
            if (fmbVar2 == null) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final String z(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) {
            String trim = str.trim();
            try {
                return hmb.g(MessageDigest.getInstance("SHA1").digest((trim + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalStateException(e);
            }
        }
        return (String) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public ByteBuffer g(Framedata framedata) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, framedata)) == null) {
            A().c(framedata);
            if (hlb.u) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("afterEnconding(");
                sb.append(framedata.a().remaining());
                sb.append("): {");
                if (framedata.a().remaining() > 1000) {
                    str = "too big to display";
                } else {
                    str = new String(framedata.a().array());
                }
                sb.append(str);
                sb.append('}');
                printStream.println(sb.toString());
            }
            return x(framedata);
        }
        return (ByteBuffer) invokeL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public List<Framedata> i(ByteBuffer byteBuffer, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048592, this, byteBuffer, z)) == null) {
            nlb nlbVar = new nlb();
            nlbVar.j(byteBuffer);
            nlbVar.n(z);
            try {
                nlbVar.h();
                return Collections.singletonList(nlbVar);
            } catch (InvalidDataException e) {
                throw new NotSendableException(e);
            }
        }
        return (List) invokeLZ.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public ylb n(wlb wlbVar, emb embVar) throws InvalidHandshakeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, wlbVar, embVar)) == null) {
            embVar.put("Upgrade", "websocket");
            embVar.put(HTTP.CONN_DIRECTIVE, wlbVar.d(HTTP.CONN_DIRECTIVE));
            String d = wlbVar.d("Sec-WebSocket-Key");
            if (d != null) {
                embVar.put("Sec-WebSocket-Accept", z(d));
                if (A().d().length() != 0) {
                    embVar.put("Sec-WebSocket-Extensions", A().d());
                }
                if (E() != null && E().c().length() != 0) {
                    embVar.put("Sec-WebSocket-Protocol", E().c());
                }
                embVar.c("Web Socket Protocol Handshake");
                embVar.put("Server", "TooTallNate Java-WebSocket");
                embVar.put("Date", F());
                return embVar;
            }
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        return (ylb) invokeLL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public void o(hlb hlbVar, Framedata framedata) throws InvalidDataException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, hlbVar, framedata) == null) {
            Framedata.Opcode d = framedata.d();
            if (d == Framedata.Opcode.CLOSING) {
                int i = 1005;
                if (framedata instanceof olb) {
                    olb olbVar = (olb) framedata;
                    i = olbVar.o();
                    str = olbVar.p();
                } else {
                    str = "";
                }
                if (hlbVar.t() == WebSocket.READYSTATE.CLOSING) {
                    hlbVar.g(i, str, true);
                } else if (l() == Draft.CloseHandshakeType.TWOWAY) {
                    hlbVar.d(i, str, true);
                } else {
                    hlbVar.o(i, str, false);
                }
            } else if (d == Framedata.Opcode.PING) {
                hlbVar.v().onWebsocketPing(hlbVar, framedata);
            } else if (d == Framedata.Opcode.PONG) {
                hlbVar.N();
                hlbVar.v().onWebsocketPong(hlbVar, framedata);
            } else if (framedata.f() && d != Framedata.Opcode.CONTINUOUS) {
                if (this.g == null) {
                    if (d == Framedata.Opcode.TEXT) {
                        try {
                            hlbVar.v().onWebsocketMessage(hlbVar, jmb.e(framedata.a()));
                            return;
                        } catch (RuntimeException e) {
                            hlbVar.v().onWebsocketError(hlbVar, e);
                            return;
                        }
                    } else if (d == Framedata.Opcode.BINARY) {
                        try {
                            hlbVar.v().onWebsocketMessage(hlbVar, framedata.a());
                            return;
                        } catch (RuntimeException e2) {
                            hlbVar.v().onWebsocketError(hlbVar, e2);
                            return;
                        }
                    } else {
                        throw new InvalidDataException(1002, "non control or continious frame expected");
                    }
                }
                throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
            } else {
                if (d != Framedata.Opcode.CONTINUOUS) {
                    if (this.g == null) {
                        this.g = framedata;
                        this.h.add(framedata.a());
                    } else {
                        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                    }
                } else if (framedata.f()) {
                    if (this.g != null) {
                        this.h.add(framedata.a());
                        if (this.g.d() == Framedata.Opcode.TEXT) {
                            ((slb) this.g).j(D());
                            ((slb) this.g).h();
                            try {
                                hlbVar.v().onWebsocketMessage(hlbVar, jmb.e(this.g.a()));
                            } catch (RuntimeException e3) {
                                hlbVar.v().onWebsocketError(hlbVar, e3);
                            }
                        } else if (this.g.d() == Framedata.Opcode.BINARY) {
                            ((slb) this.g).j(D());
                            ((slb) this.g).h();
                            try {
                                hlbVar.v().onWebsocketMessage(hlbVar, this.g.a());
                            } catch (RuntimeException e4) {
                                hlbVar.v().onWebsocketError(hlbVar, e4);
                            }
                        }
                        this.g = null;
                        this.h.clear();
                    } else {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                } else if (this.g == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
                if (d == Framedata.Opcode.TEXT && !jmb.b(framedata.a())) {
                    throw new InvalidDataException(1007);
                }
                if (d == Framedata.Opcode.CONTINUOUS && this.g != null) {
                    this.h.add(framedata.a());
                }
            }
        }
    }

    public final ByteBuffer x(Framedata framedata) {
        InterceptResult invokeL;
        boolean z;
        int i;
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, framedata)) == null) {
            ByteBuffer a = framedata.a();
            int i5 = 0;
            if (this.a == WebSocket.Role.CLIENT) {
                z = true;
            } else {
                z = false;
            }
            if (a.remaining() <= 125) {
                i = 1;
            } else if (a.remaining() <= 65535) {
                i = 2;
            } else {
                i = 8;
            }
            if (i > 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            int i6 = i2 + 1;
            if (z) {
                i3 = 4;
            } else {
                i3 = 0;
            }
            ByteBuffer allocate = ByteBuffer.allocate(i6 + i3 + a.remaining());
            byte y = y(framedata.d());
            byte b = Byte.MIN_VALUE;
            if (framedata.f()) {
                i4 = -128;
            } else {
                i4 = 0;
            }
            allocate.put((byte) (((byte) i4) | y));
            byte[] H = H(a.remaining(), i);
            if (i == 1) {
                byte b2 = H[0];
                if (!z) {
                    b = 0;
                }
                allocate.put((byte) (b2 | b));
            } else if (i == 2) {
                if (!z) {
                    b = 0;
                }
                allocate.put((byte) (b | 126));
                allocate.put(H);
            } else if (i == 8) {
                if (!z) {
                    b = 0;
                }
                allocate.put((byte) (b | ByteCompanionObject.MAX_VALUE));
                allocate.put(H);
            } else {
                throw new RuntimeException("Size representation not supported/specified");
            }
            if (z) {
                ByteBuffer allocate2 = ByteBuffer.allocate(4);
                allocate2.putInt(this.j.nextInt());
                allocate.put(allocate2.array());
                while (a.hasRemaining()) {
                    allocate.put((byte) (a.get() ^ allocate2.get(i5 % 4)));
                    i5++;
                }
            } else {
                allocate.put(a);
                a.flip();
            }
            allocate.flip();
            return allocate;
        }
        return (ByteBuffer) invokeL.objValue;
    }
}
