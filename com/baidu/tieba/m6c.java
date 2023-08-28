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
/* loaded from: classes7.dex */
public class m6c extends Draft {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public o6c c;
    public List<o6c> d;
    public h7c e;
    public List<h7c> f;
    public Framedata g;
    public List<ByteBuffer> h;
    public ByteBuffer i;
    public final Random j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947926063, "Lcom/baidu/tieba/m6c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947926063, "Lcom/baidu/tieba/m6c;");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m6c() {
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

    public o6c A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.c;
        }
        return (o6c) invokeV.objValue;
    }

    public List<o6c> B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.d;
        }
        return (List) invokeV.objValue;
    }

    public List<h7c> C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public h7c E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.e;
        }
        return (h7c) invokeV.objValue;
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
            o6c o6cVar = this.c;
            int i2 = 0;
            if (o6cVar != null) {
                i = o6cVar.hashCode();
            } else {
                i = 0;
            }
            int i3 = i * 31;
            h7c h7cVar = this.e;
            if (h7cVar != null) {
                i2 = h7cVar.hashCode();
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
            o6c o6cVar = this.c;
            if (o6cVar != null) {
                o6cVar.reset();
            }
            this.c = new n6c();
            this.e = null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public m6c(List<o6c> list) {
        this(list, Collections.singletonList(new i7c("")));
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

    public m6c(List<o6c> list, List<h7c> list2) {
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
        this.c = new n6c();
        this.j = new Random();
        if (list != null && list2 != null) {
            this.d = new ArrayList(list.size());
            this.f = new ArrayList(list2.size());
            boolean z = false;
            this.h = new ArrayList();
            for (o6c o6cVar : list) {
                if (o6cVar.getClass().equals(n6c.class)) {
                    z = true;
                }
            }
            this.d.addAll(list);
            if (!z) {
                List<o6c> list3 = this.d;
                list3.add(list3.size(), this.c);
            }
            this.f.addAll(list2);
            return;
        }
        throw new IllegalArgumentException();
    }

    public static void G(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj) == null) && j6c.u) {
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
            for (o6c o6cVar : B()) {
                arrayList.add(o6cVar.a());
            }
            ArrayList arrayList2 = new ArrayList();
            for (h7c h7cVar : C()) {
                arrayList2.add(h7cVar.a());
            }
            return new m6c(arrayList, arrayList2);
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
            x6c x6cVar = new x6c();
            x6cVar.j(ByteBuffer.wrap(l7c.f(str)));
            x6cVar.n(z);
            try {
                x6cVar.h();
                return Collections.singletonList(x6cVar);
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
                    u6c g = u6c.g(I);
                    g.i(z);
                    g.k(z6);
                    g.l(z3);
                    g.m(z4);
                    allocate.flip();
                    g.j(allocate);
                    A().h(g);
                    A().f(g);
                    if (j6c.u) {
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
    public Draft.HandshakeState a(y6c y6cVar, f7c f7cVar) throws InvalidHandshakeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, y6cVar, f7cVar)) == null) {
            if (!c(f7cVar)) {
                G("acceptHandshakeAsClient - Missing/wrong upgrade or connection in handshake.");
                return Draft.HandshakeState.NOT_MATCHED;
            } else if (y6cVar.e("Sec-WebSocket-Key") && f7cVar.e("Sec-WebSocket-Accept")) {
                if (!z(y6cVar.d("Sec-WebSocket-Key")).equals(f7cVar.d("Sec-WebSocket-Accept"))) {
                    G("acceptHandshakeAsClient - Wrong key for Sec-WebSocket-Key.");
                    return Draft.HandshakeState.NOT_MATCHED;
                }
                Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
                String d = f7cVar.d("Sec-WebSocket-Extensions");
                Iterator<o6c> it = this.d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    o6c next = it.next();
                    if (next.b(d)) {
                        this.c = next;
                        handshakeState = Draft.HandshakeState.MATCHED;
                        G("acceptHandshakeAsClient - Matching extension found: " + this.c.toString());
                        break;
                    }
                }
                Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
                String d2 = f7cVar.d("Sec-WebSocket-Protocol");
                Iterator<h7c> it2 = this.f.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    h7c next2 = it2.next();
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
    public Draft.HandshakeState b(y6c y6cVar) throws InvalidHandshakeException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, y6cVar)) == null) {
            if (r(y6cVar) != 13) {
                G("acceptHandshakeAsServer - Wrong websocket version.");
                return Draft.HandshakeState.NOT_MATCHED;
            }
            Draft.HandshakeState handshakeState = Draft.HandshakeState.NOT_MATCHED;
            String d = y6cVar.d("Sec-WebSocket-Extensions");
            Iterator<o6c> it = this.d.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                o6c next = it.next();
                if (next.e(d)) {
                    this.c = next;
                    handshakeState = Draft.HandshakeState.MATCHED;
                    G("acceptHandshakeAsServer - Matching extension found: " + this.c.toString());
                    break;
                }
            }
            Draft.HandshakeState handshakeState2 = Draft.HandshakeState.NOT_MATCHED;
            String d2 = y6cVar.d("Sec-WebSocket-Protocol");
            Iterator<h7c> it2 = this.f.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                h7c next2 = it2.next();
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
    public z6c m(z6c z6cVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, z6cVar)) == null) {
            z6cVar.put("Upgrade", "websocket");
            z6cVar.put(HTTP.CONN_DIRECTIVE, "Upgrade");
            byte[] bArr = new byte[16];
            this.j.nextBytes(bArr);
            z6cVar.put("Sec-WebSocket-Key", j7c.g(bArr));
            z6cVar.put("Sec-WebSocket-Version", "13");
            StringBuilder sb = new StringBuilder();
            for (o6c o6cVar : this.d) {
                if (o6cVar.g() != null && o6cVar.g().length() != 0) {
                    if (sb.length() > 0) {
                        sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb.append(o6cVar.g());
                }
            }
            if (sb.length() != 0) {
                z6cVar.put("Sec-WebSocket-Extensions", sb.toString());
            }
            StringBuilder sb2 = new StringBuilder();
            for (h7c h7cVar : this.f) {
                if (h7cVar.c().length() != 0) {
                    if (sb2.length() > 0) {
                        sb2.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                    }
                    sb2.append(h7cVar.c());
                }
            }
            if (sb2.length() != 0) {
                z6cVar.put("Sec-WebSocket-Protocol", sb2.toString());
            }
            return z6cVar;
        }
        return (z6c) invokeL.objValue;
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
            if (obj == null || m6c.class != obj.getClass()) {
                return false;
            }
            m6c m6cVar = (m6c) obj;
            o6c o6cVar = this.c;
            if (o6cVar == null ? m6cVar.c != null : !o6cVar.equals(m6cVar.c)) {
                return false;
            }
            h7c h7cVar = this.e;
            h7c h7cVar2 = m6cVar.e;
            if (h7cVar != null) {
                return h7cVar.equals(h7cVar2);
            }
            if (h7cVar2 == null) {
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
                return j7c.g(MessageDigest.getInstance("SHA1").digest((trim + WebSocketProtocol.ACCEPT_MAGIC).getBytes()));
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
            if (j6c.u) {
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
            p6c p6cVar = new p6c();
            p6cVar.j(byteBuffer);
            p6cVar.n(z);
            try {
                p6cVar.h();
                return Collections.singletonList(p6cVar);
            } catch (InvalidDataException e) {
                throw new NotSendableException(e);
            }
        }
        return (List) invokeLZ.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public a7c n(y6c y6cVar, g7c g7cVar) throws InvalidHandshakeException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, y6cVar, g7cVar)) == null) {
            g7cVar.put("Upgrade", "websocket");
            g7cVar.put(HTTP.CONN_DIRECTIVE, y6cVar.d(HTTP.CONN_DIRECTIVE));
            String d = y6cVar.d("Sec-WebSocket-Key");
            if (d != null) {
                g7cVar.put("Sec-WebSocket-Accept", z(d));
                if (A().d().length() != 0) {
                    g7cVar.put("Sec-WebSocket-Extensions", A().d());
                }
                if (E() != null && E().c().length() != 0) {
                    g7cVar.put("Sec-WebSocket-Protocol", E().c());
                }
                g7cVar.c("Web Socket Protocol Handshake");
                g7cVar.put("Server", "TooTallNate Java-WebSocket");
                g7cVar.put("Date", F());
                return g7cVar;
            }
            throw new InvalidHandshakeException("missing Sec-WebSocket-Key");
        }
        return (a7c) invokeLL.objValue;
    }

    @Override // org.java_websocket.drafts.Draft
    public void o(j6c j6cVar, Framedata framedata) throws InvalidDataException {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, j6cVar, framedata) == null) {
            Framedata.Opcode d = framedata.d();
            if (d == Framedata.Opcode.CLOSING) {
                int i = 1005;
                if (framedata instanceof q6c) {
                    q6c q6cVar = (q6c) framedata;
                    i = q6cVar.o();
                    str = q6cVar.p();
                } else {
                    str = "";
                }
                if (j6cVar.t() == WebSocket.READYSTATE.CLOSING) {
                    j6cVar.g(i, str, true);
                } else if (l() == Draft.CloseHandshakeType.TWOWAY) {
                    j6cVar.d(i, str, true);
                } else {
                    j6cVar.o(i, str, false);
                }
            } else if (d == Framedata.Opcode.PING) {
                j6cVar.v().onWebsocketPing(j6cVar, framedata);
            } else if (d == Framedata.Opcode.PONG) {
                j6cVar.N();
                j6cVar.v().onWebsocketPong(j6cVar, framedata);
            } else if (framedata.f() && d != Framedata.Opcode.CONTINUOUS) {
                if (this.g == null) {
                    if (d == Framedata.Opcode.TEXT) {
                        try {
                            j6cVar.v().onWebsocketMessage(j6cVar, l7c.e(framedata.a()));
                            return;
                        } catch (RuntimeException e) {
                            j6cVar.v().onWebsocketError(j6cVar, e);
                            return;
                        }
                    } else if (d == Framedata.Opcode.BINARY) {
                        try {
                            j6cVar.v().onWebsocketMessage(j6cVar, framedata.a());
                            return;
                        } catch (RuntimeException e2) {
                            j6cVar.v().onWebsocketError(j6cVar, e2);
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
                            ((u6c) this.g).j(D());
                            ((u6c) this.g).h();
                            try {
                                j6cVar.v().onWebsocketMessage(j6cVar, l7c.e(this.g.a()));
                            } catch (RuntimeException e3) {
                                j6cVar.v().onWebsocketError(j6cVar, e3);
                            }
                        } else if (this.g.d() == Framedata.Opcode.BINARY) {
                            ((u6c) this.g).j(D());
                            ((u6c) this.g).h();
                            try {
                                j6cVar.v().onWebsocketMessage(j6cVar, this.g.a());
                            } catch (RuntimeException e4) {
                                j6cVar.v().onWebsocketError(j6cVar, e4);
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
                if (d == Framedata.Opcode.TEXT && !l7c.b(framedata.a())) {
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
