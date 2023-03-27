package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.SerializationException;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.io.IOException;
import java.io.Reader;
import kotlin.text.Typography;
/* loaded from: classes7.dex */
public class z6 implements m6 {
    public static /* synthetic */ Interceptable $ic;
    public static final byte[] e;
    public static final short[] f;
    public static final char[] g;
    public static final byte[] h;
    public static final byte[] i;
    public static final short[] j;
    public static final byte[] k;
    public static final byte[] l;
    public static final byte[] m;
    public static final byte[] n;
    public transient /* synthetic */ FieldHolder $fh;
    public final k6<JsonValue> a;
    public final k6<JsonValue> b;
    public JsonValue c;
    public JsonValue d;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1448322097, "Lcom/baidu/tieba/z6;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1448322097, "Lcom/baidu/tieba/z6;");
                return;
            }
        }
        e = d();
        f = h();
        g = l();
        h = j();
        i = i();
        j = f();
        k = g();
        l = m();
        m = k();
        n = e();
    }

    public static short[] f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new short[]{0, 0, 11, 14, 16, 19, 28, 34, 40, 43, 54, 62, 70, 79, 81, 90, 93, 96, 105, 108, 111, 113, 116, 119, 130, 138, 146, 157, 159, 170, 173, 176, 187, 190, 193, 196, 201, 206, 207};
        }
        return (short[]) invokeV.objValue;
    }

    public static short[] h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return new short[]{0, 0, 11, 13, 14, 16, 25, 31, 37, 39, 50, 57, 64, 73, 74, 83, 85, 87, 96, 98, 100, TbEnum.MsgContentType.MSG_CONTENT_TYPE_TEXT_GEN_IMAGE, 103, 105, 116, 123, 130, 141, 142, 153, 155, 157, 168, 170, 172, 174, 179, 184, 184};
        }
        return (short[]) invokeV.objValue;
    }

    public static byte[] k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            return new byte[]{13, 0, 15, 0, 0, 7, 3, Constants.GZIP_CAST_TYPE, 1, Constants.GZIP_CAST_TYPE, 17, 0, 20, 0, 0, 5, 1, 1, 1, 0, 0, 0, Constants.GZIP_CAST_TYPE, 13, 15, 0, 7, 3, 1, 1, 1, 1, 23, 0, 0, 0, 0, 0, 0, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, 0, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, 13, 0, 15, 0, 0, 7, 9, 3, 1, 1, 1, 1, 26, 0, 0, 0, 0, 0, 0, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, 0, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, 1, 0, 0};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, null)) == null) {
            return new byte[]{Base64.INTERNAL_PADDING, 1, 3, 0, 4, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 1, 6, 5, 13, 17, 22, 37, 7, 8, 9, 7, 8, 9, 7, 10, 20, 21, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, 12, 17, 19, 37, Constants.GZIP_CAST_TYPE, 12, 19, 14, 16, 15, 14, 12, 18, 17, Constants.GZIP_CAST_TYPE, 9, 5, 24, 23, 27, 31, 34, 25, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 25, 25, 26, 31, 33, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 25, 26, 33, 28, 30, 29, 28, 26, 32, 31, 25, 23, 2, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 2};
        }
        return (byte[]) invokeV.objValue;
    }

    public z6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = new k6<>(8);
        this.b = new k6<>(8);
    }

    public static byte[] e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            return new byte[]{0, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            return new byte[]{0, 9, 2, 1, 2, 7, 4, 4, 2, 9, 7, 7, 7, 1, 7, 2, 2, 7, 2, 2, 1, 2, 2, 9, 7, 7, 9, 1, 9, 2, 2, 9, 2, 2, 2, 3, 3, 0, 0};
        }
        return (byte[]) invokeV.objValue;
    }

    public void r() {
        JsonValue jsonValue;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c = this.a.pop();
            if (this.d.j > 0) {
                this.b.pop();
            }
            k6<JsonValue> k6Var = this.a;
            if (k6Var.b > 0) {
                jsonValue = k6Var.peek();
            } else {
                jsonValue = null;
            }
            this.d = jsonValue;
        }
    }

    public static byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return new byte[]{0, 1, 1, 1, 2, 1, 3, 1, 4, 1, 5, 1, 6, 1, 7, 1, 8, 2, 0, 7, 2, 0, 8, 2, 1, 3, 2, 1, 5};
        }
        return (byte[]) invokeV.objValue;
    }

    public static byte[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return new byte[]{1, 1, 2, 3, 4, 3, 5, 3, 6, 1, 0, 7, 7, 3, 8, 3, 9, 9, 3, Constants.GZIP_CAST_TYPE, Constants.GZIP_CAST_TYPE, 12, 13, 14, 3, 15, Constants.GZIP_CAST_TYPE, 10, 16, 16, 17, 18, 16, 3, 19, 19, 20, 21, 19, 3, 22, 22, 3, 21, 21, 24, 3, 25, 3, 26, 3, 27, 21, 23, 28, 29, 29, 28, 30, 31, 32, 3, 33, 34, 34, 33, 13, Base64.INTERNAL_PADDING, 15, 3, 34, 34, 12, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, 3, 15, 34, 10, 16, 3, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 12, 3, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 3, 3, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 10, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 3, 40, 40, 3, 13, 13, 12, 3, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 3, 15, 13, 10, ExifInterface.START_CODE, ExifInterface.START_CODE, 3, 43, 43, 3, 28, 3, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, Cea608Decoder.CTRL_ERASE_DISPLAYED_MEMORY, 3, 45, 45, 3, 47, 47, 48, 49, 50, 3, 51, 52, 53, 47, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 54, 55, 55, 54, 56, 57, 58, 3, 59, 60, 60, 59, 49, 61, 52, 3, 60, 60, 48, 62, 63, 3, 51, 52, 53, 60, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 54, 3, 62, 62, 48, 3, 64, 3, 51, 3, 53, 62, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 65, 65, 3, 66, 66, 3, 49, 49, 48, 3, 67, 3, 51, 52, 53, 49, Cea608Decoder.CTRL_ERASE_NON_DISPLAYED_MEMORY, 68, 68, 3, 69, 69, 3, 70, 70, 3, 8, 8, 71, 8, 3, 72, 72, 73, 72, 3, 3, 3, 0};
        }
        return (byte[]) invokeV.objValue;
    }

    public static char[] l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            return new char[]{'\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '[', ']', '{', '\t', '\n', '*', WebvttCueParser.CHAR_SLASH, Typography.quote, '*', WebvttCueParser.CHAR_SLASH, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '}', '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, WebvttCueParser.CHAR_SLASH, ':', '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, WebvttCueParser.CHAR_SLASH, ':', '\t', '\n', '*', WebvttCueParser.CHAR_SLASH, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, ',', WebvttCueParser.CHAR_SLASH, '}', '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, ',', WebvttCueParser.CHAR_SLASH, '}', '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '}', '\t', '\n', Typography.quote, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '}', '\t', '\n', '*', WebvttCueParser.CHAR_SLASH, '*', WebvttCueParser.CHAR_SLASH, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '}', '\t', '\n', '*', WebvttCueParser.CHAR_SLASH, '*', WebvttCueParser.CHAR_SLASH, Typography.quote, '*', WebvttCueParser.CHAR_SLASH, '*', WebvttCueParser.CHAR_SLASH, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '[', ']', '{', '\t', '\n', '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, ',', WebvttCueParser.CHAR_SLASH, ']', '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, ',', WebvttCueParser.CHAR_SLASH, ']', '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '[', ']', '{', '\t', '\n', Typography.quote, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '[', ']', '{', '\t', '\n', '*', WebvttCueParser.CHAR_SLASH, '*', WebvttCueParser.CHAR_SLASH, '\r', WebvttCueParser.CHAR_SPACE, Typography.quote, ',', WebvttCueParser.CHAR_SLASH, ':', '[', ']', '{', '\t', '\n', '*', WebvttCueParser.CHAR_SLASH, '*', WebvttCueParser.CHAR_SLASH, '*', WebvttCueParser.CHAR_SLASH, '\r', WebvttCueParser.CHAR_SPACE, WebvttCueParser.CHAR_SLASH, '\t', '\n', '\r', WebvttCueParser.CHAR_SPACE, WebvttCueParser.CHAR_SLASH, '\t', '\n', 0};
        }
        return (char[]) invokeV.objValue;
    }

    @Override // com.baidu.tieba.m6
    public JsonValue a(t2 t2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t2Var)) == null) {
            try {
                try {
                    return p(t2Var.r("UTF-8"));
                } catch (Exception e2) {
                    throw new SerializationException("Error parsing file: " + t2Var, e2);
                }
            } catch (Exception e3) {
                throw new SerializationException("Error reading file: " + t2Var, e3);
            }
        }
        return (JsonValue) invokeL.objValue;
    }

    public JsonValue p(Reader reader) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, reader)) == null) {
            char[] cArr = new char[1024];
            int i2 = 0;
            while (true) {
                try {
                    try {
                        int read = reader.read(cArr, i2, cArr.length - i2);
                        if (read == -1) {
                            s7.a(reader);
                            return q(cArr, 0, i2);
                        } else if (read == 0) {
                            char[] cArr2 = new char[cArr.length * 2];
                            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
                            cArr = cArr2;
                        } else {
                            i2 += read;
                        }
                    } catch (IOException e2) {
                        throw new SerializationException("Error reading input.", e2);
                    }
                } catch (Throwable th) {
                    s7.a(reader);
                    throw th;
                }
            }
        } else {
            return (JsonValue) invokeL.objValue;
        }
    }

    public final void b(String str, JsonValue jsonValue) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, jsonValue) == null) {
            jsonValue.P(str);
            JsonValue jsonValue2 = this.d;
            if (jsonValue2 == null) {
                this.d = jsonValue;
                this.c = jsonValue;
            } else if (!jsonValue2.u() && !this.d.C()) {
                this.c = this.d;
            } else {
                JsonValue jsonValue3 = this.d;
                jsonValue.g = jsonValue3;
                if (jsonValue3.j == 0) {
                    jsonValue3.f = jsonValue;
                } else {
                    JsonValue pop = this.b.pop();
                    pop.h = jsonValue;
                    jsonValue.i = pop;
                }
                this.b.a(jsonValue);
                this.d.j++;
            }
        }
    }

    public void c(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z) == null) {
            b(str, new JsonValue(z));
        }
    }

    public void u(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, str2) == null) {
            b(str, new JsonValue(str2));
        }
    }

    public void n(String str, double d, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, Double.valueOf(d), str2}) == null) {
            b(str, new JsonValue(d, str2));
        }
    }

    public void o(String str, long j2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{str, Long.valueOf(j2), str2}) == null) {
            b(str, new JsonValue(j2, str2));
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:401:0x005b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:454:0x009b */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:456:0x009b */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r11 != 4) goto L313;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x023c, code lost:
        r11 = 2;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01a0 A[LOOP:7: B:362:0x0167->B:125:0x01a0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:382:0x0357 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x034f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:387:0x0345 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:425:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1 A[Catch: RuntimeException -> 0x045a, TRY_LEAVE, TryCatch #6 {RuntimeException -> 0x045a, blocks: (B:262:0x0393, B:264:0x0399, B:268:0x03ab, B:275:0x03bc, B:281:0x03d1, B:286:0x03dc, B:21:0x0044, B:23:0x0052, B:25:0x005d, B:34:0x008f, B:36:0x0095, B:38:0x009d, B:39:0x00a0, B:41:0x00b6, B:42:0x00bb, B:44:0x00c5, B:45:0x00cc, B:46:0x00d3, B:48:0x00e1, B:139:0x01d0, B:161:0x0207, B:162:0x020f, B:164:0x0213, B:166:0x021b, B:168:0x0221, B:169:0x022d, B:170:0x0235, B:172:0x0240, B:174:0x0244, B:176:0x024c, B:178:0x0252, B:180:0x0260, B:185:0x0274, B:187:0x027a, B:191:0x028b, B:198:0x029c, B:204:0x02af, B:209:0x02bc, B:26:0x0062, B:28:0x0076, B:29:0x007b, B:31:0x0083, B:32:0x0088), top: B:368:0x0044 }] */
    /* JADX WARN: Type inference failed for: r0v40, types: [java.lang.Object, int[]] */
    /* JADX WARN: Type inference failed for: r0v50, types: [java.lang.Object, int[]] */
    /* JADX WARN: Type inference failed for: r13v16, types: [int] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v50, types: [int] */
    /* JADX WARN: Type inference failed for: r13v53 */
    /* JADX WARN: Type inference failed for: r18v13, types: [int] */
    /* JADX WARN: Type inference failed for: r18v16, types: [int] */
    /* JADX WARN: Type inference failed for: r18v17, types: [int] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int[]] */
    /* JADX WARN: Type inference failed for: r9v5, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JsonValue q(char[] cArr, int i2, int i3) {
        InterceptResult invokeLII;
        String str;
        int i4;
        byte[] bArr;
        RuntimeException runtimeException;
        String str2;
        String str3;
        int i5;
        k6 k6Var;
        boolean z;
        int i6;
        short s;
        short s2;
        byte b;
        String str4;
        String str5;
        int i7;
        byte[] bArr2;
        byte b2;
        String str6;
        int i8;
        boolean z2;
        int i9;
        boolean z3;
        int i10;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048582, this, cArr, i2, i3)) == null) {
            k6 k6Var2 = new k6(8);
            byte[] bArr3 = new int[4];
            int i11 = 0;
            char c = 0;
            byte b3 = 1;
            int i12 = 0;
            boolean z4 = false;
            boolean z5 = false;
            boolean z6 = false;
            int i13 = i2;
            while (true) {
                str = "false";
                try {
                    if (c != 0) {
                        if (c != 1) {
                            if (c == 2) {
                                i4 = i11;
                                bArr = bArr3;
                                if (b3 == 0) {
                                    i11 = i4;
                                    bArr3 = bArr;
                                    c = 5;
                                } else {
                                    i13++;
                                    if (i13 != i3) {
                                        i11 = i4;
                                        bArr3 = bArr;
                                        c = 1;
                                    }
                                }
                            }
                        }
                    } else if (i13 == i3) {
                        c = 4;
                    } else if (b3 == 0) {
                        c = 5;
                    }
                    short s3 = f[b3];
                    short s4 = j[b3];
                    byte b4 = h[b3];
                    if (b4 > 0) {
                        int i14 = s3 + b4;
                        int i15 = i14 - 1;
                        i6 = i12;
                        int i16 = s3;
                        while (i15 >= i16) {
                            int i17 = i16 + ((i15 - i16) >> 1);
                            int i18 = i15;
                            int i19 = i16;
                            if (cArr[i13] < g[i17]) {
                                i15 = i17 - 1;
                                i16 = i19;
                            } else if (cArr[i13] > g[i17]) {
                                i16 = i17 + 1;
                                i15 = i18;
                            } else {
                                s2 = s4 + (i17 - s3);
                                b = k[s2];
                                byte b5 = l[b];
                                if (m[b] == 0) {
                                    byte b6 = m[b];
                                    int i20 = b6 + 1;
                                    byte b7 = e[b6];
                                    int i21 = i20;
                                    i12 = i6;
                                    while (true) {
                                        ?? r18 = b7 - 1;
                                        if (b7 > 0) {
                                            try {
                                                int i22 = i21 + 1;
                                                switch (e[i21]) {
                                                    case 0:
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b2 = b5;
                                                        z5 = true;
                                                        b5 = b2;
                                                        b7 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                    case 1:
                                                        String str7 = new String(cArr, i12, i13 - i12);
                                                        if (z4) {
                                                            str7 = v(str7);
                                                        }
                                                        if (z5) {
                                                            k6Var2.a(str7);
                                                            i8 = i13;
                                                            i7 = i11;
                                                            bArr2 = bArr3;
                                                            b2 = b5;
                                                            z5 = false;
                                                        } else {
                                                            if (k6Var2.b > 0) {
                                                                str6 = (String) k6Var2.pop();
                                                            } else {
                                                                str6 = null;
                                                            }
                                                            if (z6) {
                                                                if (str7.equals("true")) {
                                                                    c(str6, true);
                                                                } else if (str7.equals("false")) {
                                                                    c(str6, false);
                                                                } else if (str7.equals(StringUtil.NULL_STRING)) {
                                                                    i7 = i11;
                                                                    u(str6, null);
                                                                    i8 = i13;
                                                                    bArr2 = bArr3;
                                                                    b2 = b5;
                                                                } else {
                                                                    i7 = i11;
                                                                    boolean z7 = false;
                                                                    boolean z8 = true;
                                                                    while (true) {
                                                                        if (i12 < i13) {
                                                                            i8 = i13;
                                                                            char c2 = cArr[i12];
                                                                            boolean z9 = z7;
                                                                            if (c2 != '+') {
                                                                                if (c2 != 'E' && c2 != 'e') {
                                                                                    if (c2 != '-') {
                                                                                        if (c2 != '.') {
                                                                                            switch (c2) {
                                                                                                case '0':
                                                                                                case '1':
                                                                                                case '2':
                                                                                                case '3':
                                                                                                case '4':
                                                                                                case '5':
                                                                                                case '6':
                                                                                                case '7':
                                                                                                case '8':
                                                                                                case '9':
                                                                                                    break;
                                                                                                default:
                                                                                                    z8 = false;
                                                                                                    z2 = false;
                                                                                                    break;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                                z7 = true;
                                                                                z8 = false;
                                                                                i12++;
                                                                                i13 = i8;
                                                                            }
                                                                            z7 = z9;
                                                                            i12++;
                                                                            i13 = i8;
                                                                        } else {
                                                                            i8 = i13;
                                                                            z2 = z7;
                                                                        }
                                                                    }
                                                                    if (z2) {
                                                                        bArr2 = bArr3;
                                                                        b2 = b5;
                                                                        try {
                                                                            n(str6, Double.parseDouble(str7), str7);
                                                                        } catch (NumberFormatException unused) {
                                                                        }
                                                                    } else {
                                                                        bArr2 = bArr3;
                                                                        b2 = b5;
                                                                        if (z8) {
                                                                            o(str6, Long.parseLong(str7), str7);
                                                                        }
                                                                    }
                                                                }
                                                                i8 = i13;
                                                                i7 = i11;
                                                                bArr2 = bArr3;
                                                                b2 = b5;
                                                            } else {
                                                                i8 = i13;
                                                                i7 = i11;
                                                                bArr2 = bArr3;
                                                                b2 = b5;
                                                            }
                                                            u(str6, str7);
                                                        }
                                                        i13 = i8;
                                                        i12 = i13;
                                                        z6 = false;
                                                        b5 = b2;
                                                        b7 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                        break;
                                                    case 2:
                                                        if (k6Var2.b > 0) {
                                                            str4 = (String) k6Var2.pop();
                                                        } else {
                                                            str4 = null;
                                                        }
                                                        t(str4);
                                                        if (i11 == bArr3.length) {
                                                            ?? r0 = new int[bArr3.length * 2];
                                                            System.arraycopy(bArr3, 0, r0, 0, bArr3.length);
                                                            bArr3 = r0;
                                                        }
                                                        int i23 = i11 + 1;
                                                        bArr3[i11] = b5;
                                                        i11 = i23;
                                                        c = 2;
                                                        b3 = 5;
                                                        break;
                                                    case 3:
                                                        r();
                                                        i11--;
                                                        b3 = bArr3[i11];
                                                        break;
                                                    case 4:
                                                        if (k6Var2.b > 0) {
                                                            str5 = (String) k6Var2.pop();
                                                        } else {
                                                            str5 = null;
                                                        }
                                                        s(str5);
                                                        if (i11 == bArr3.length) {
                                                            ?? r02 = new int[bArr3.length * 2];
                                                            System.arraycopy(bArr3, 0, r02, 0, bArr3.length);
                                                            bArr3 = r02;
                                                        }
                                                        bArr3[i11] = b5;
                                                        b3 = 23;
                                                        i11++;
                                                        break;
                                                    case 5:
                                                        r();
                                                        i11--;
                                                        b3 = bArr3[i11];
                                                        break;
                                                    case 6:
                                                        int i24 = i13 + 1;
                                                        if (cArr[i13] != '/') {
                                                            while (true) {
                                                                int i25 = i24;
                                                                i24 = i25 + 1;
                                                                try {
                                                                    if (i24 < i3) {
                                                                        i9 = i25;
                                                                        if (cArr[i25] != '*') {
                                                                        }
                                                                    } else {
                                                                        i9 = i25;
                                                                    }
                                                                    if (cArr[i24] == '/') {
                                                                        i13 = i24;
                                                                    }
                                                                } catch (RuntimeException e2) {
                                                                    runtimeException = e2;
                                                                    i13 = i9;
                                                                    break;
                                                                }
                                                            }
                                                        } else {
                                                            int i26 = i24;
                                                            while (i26 != i3 && cArr[i26] != '\n') {
                                                                i26++;
                                                            }
                                                            i13 = i26 - 1;
                                                        }
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b2 = b5;
                                                        b5 = b2;
                                                        b7 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                        break;
                                                    case 7:
                                                        char c3 = '\r';
                                                        if (z5) {
                                                            i10 = i13;
                                                            z4 = false;
                                                            do {
                                                                try {
                                                                    char c4 = cArr[i10];
                                                                    z3 = z4;
                                                                    if (c4 != '\n' && c4 != '\r') {
                                                                        if (c4 != '/') {
                                                                            if (c4 != ':') {
                                                                                if (c4 == '\\') {
                                                                                    z4 = true;
                                                                                    i10++;
                                                                                } else {
                                                                                    z4 = z3;
                                                                                    i10++;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            int i27 = i10 + 1;
                                                                            if (i27 != i3) {
                                                                                char c5 = cArr[i27];
                                                                                if (c5 != '/') {
                                                                                    if (c5 == '*') {
                                                                                    }
                                                                                }
                                                                            }
                                                                            z4 = z3;
                                                                            i10++;
                                                                        }
                                                                        b5 = b2;
                                                                        b7 = r18;
                                                                        i21 = i22;
                                                                        i11 = i7;
                                                                        bArr3 = bArr2;
                                                                    }
                                                                } catch (RuntimeException e3) {
                                                                    runtimeException = e3;
                                                                    i13 = i10;
                                                                    break;
                                                                }
                                                            } while (i10 != i3);
                                                            do {
                                                                i10--;
                                                            } while (Character.isSpace(cArr[i10]));
                                                            i7 = i11;
                                                            bArr2 = bArr3;
                                                            b2 = b5;
                                                            z6 = true;
                                                            i12 = i13;
                                                            i13 = i10;
                                                            b5 = b2;
                                                            b7 = r18;
                                                            i21 = i22;
                                                            i11 = i7;
                                                            bArr3 = bArr2;
                                                        } else {
                                                            int i28 = i13;
                                                            boolean z10 = false;
                                                            while (true) {
                                                                try {
                                                                    char c6 = cArr[i28];
                                                                    z3 = z10;
                                                                    if (c6 != '\n' && c6 != c3 && c6 != ',') {
                                                                        if (c6 != '/') {
                                                                            if (c6 != '}') {
                                                                                if (c6 != '\\') {
                                                                                    if (c6 != ']') {
                                                                                    }
                                                                                } else {
                                                                                    z3 = true;
                                                                                }
                                                                                i28++;
                                                                                if (i28 == i3) {
                                                                                    z10 = z3;
                                                                                    c3 = '\r';
                                                                                }
                                                                            }
                                                                        } else {
                                                                            int i29 = i28 + 1;
                                                                            if (i29 != i3) {
                                                                                char c7 = cArr[i29];
                                                                                if (c7 != '/') {
                                                                                    if (c7 == '*') {
                                                                                    }
                                                                                }
                                                                            }
                                                                            i28++;
                                                                            if (i28 == i3) {
                                                                            }
                                                                        }
                                                                    }
                                                                } catch (RuntimeException e4) {
                                                                    runtimeException = e4;
                                                                    i13 = i28;
                                                                    break;
                                                                }
                                                            }
                                                            i10 = i28;
                                                        }
                                                        z4 = z3;
                                                        do {
                                                            i10--;
                                                        } while (Character.isSpace(cArr[i10]));
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b2 = b5;
                                                        z6 = true;
                                                        i12 = i13;
                                                        i13 = i10;
                                                        b5 = b2;
                                                        b7 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                        break;
                                                    case 8:
                                                        int i30 = i13 + 1;
                                                        int i31 = i30;
                                                        boolean z11 = false;
                                                        do {
                                                            try {
                                                                char c8 = cArr[i31];
                                                                if (c8 != '\"') {
                                                                    if (c8 == '\\') {
                                                                        i31++;
                                                                        z11 = true;
                                                                    }
                                                                    i31++;
                                                                }
                                                                i12 = i30;
                                                                i7 = i11;
                                                                i13 = i31 - 1;
                                                                bArr2 = bArr3;
                                                                b2 = b5;
                                                                z4 = z11;
                                                                b5 = b2;
                                                                b7 = r18;
                                                                i21 = i22;
                                                                i11 = i7;
                                                                bArr3 = bArr2;
                                                            } catch (RuntimeException e5) {
                                                                runtimeException = e5;
                                                                i13 = i31;
                                                                break;
                                                            }
                                                        } while (i31 != i3);
                                                        i12 = i30;
                                                        i7 = i11;
                                                        i13 = i31 - 1;
                                                        bArr2 = bArr3;
                                                        b2 = b5;
                                                        z4 = z11;
                                                        b5 = b2;
                                                        b7 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                    default:
                                                        i7 = i11;
                                                        bArr2 = bArr3;
                                                        b2 = b5;
                                                        b5 = b2;
                                                        b7 = r18;
                                                        i21 = i22;
                                                        i11 = i7;
                                                        bArr3 = bArr2;
                                                }
                                            } catch (RuntimeException e6) {
                                                e = e6;
                                                runtimeException = e;
                                                JsonValue jsonValue = this.c;
                                                this.c = null;
                                                this.d = null;
                                                this.b.clear();
                                                if (i13 < i3) {
                                                }
                                            }
                                        } else {
                                            i4 = i11;
                                            bArr = bArr3;
                                            b3 = b5;
                                        }
                                    }
                                } else {
                                    i4 = i11;
                                    bArr = bArr3;
                                    b3 = b5;
                                    i12 = i6;
                                }
                                if (b3 == 0) {
                                }
                            }
                        }
                        s3 = i14;
                        s = s4 + b4;
                    } else {
                        i6 = i12;
                        s = s4;
                    }
                    byte b8 = i[b3];
                    s2 = s;
                    if (b8 > 0) {
                        int i32 = ((b8 << 1) + s3) - 2;
                        int i33 = s3;
                        while (true) {
                            if (i32 < i33) {
                                s2 = s + b8;
                            } else {
                                int i34 = i33 + (((i32 - i33) >> 1) & (-2));
                                byte b9 = b8;
                                int i35 = i32;
                                if (cArr[i13] < g[i34]) {
                                    i32 = i34 - 2;
                                    b8 = b9;
                                } else if (cArr[i13] > g[i34 + 1]) {
                                    i33 = i34 + 2;
                                    b8 = b9;
                                    i32 = i35;
                                } else {
                                    s2 = s + ((i34 - s3) >> 1);
                                }
                            }
                        }
                    }
                    b = k[s2];
                    byte b52 = l[b];
                    if (m[b] == 0) {
                    }
                    if (b3 == 0) {
                    }
                } catch (RuntimeException e7) {
                    e = e7;
                }
            }
            if (i13 == i3) {
                try {
                    byte b10 = n[b3];
                    int i36 = b10 + 1;
                    byte b11 = e[b10];
                    while (true) {
                        ?? r9 = b11 - 1;
                        if (b11 > 0) {
                            int i37 = i36 + 1;
                            if (e[i36] != 1) {
                                i5 = i13;
                                k6Var = k6Var2;
                                boolean z12 = z6;
                                str3 = str;
                                z = z12;
                            } else {
                                String str8 = new String(cArr, i12, i13 - i12);
                                if (z4) {
                                    str8 = v(str8);
                                }
                                if (z5) {
                                    k6Var2.a(str8);
                                    str3 = str;
                                    i5 = i13;
                                    k6Var = k6Var2;
                                    z5 = false;
                                } else {
                                    if (k6Var2.b > 0) {
                                        str2 = (String) k6Var2.pop();
                                    } else {
                                        str2 = null;
                                    }
                                    if (z6) {
                                        if (str8.equals("true")) {
                                            c(str2, true);
                                        } else if (str8.equals(str)) {
                                            c(str2, false);
                                        } else if (str8.equals(StringUtil.NULL_STRING)) {
                                            u(str2, null);
                                        } else {
                                            str3 = str;
                                            int i38 = i12;
                                            boolean z13 = false;
                                            boolean z14 = true;
                                            while (true) {
                                                if (i38 < i13) {
                                                    i5 = i13;
                                                    try {
                                                        char c9 = cArr[i38];
                                                        k6Var = k6Var2;
                                                        if (c9 != '+') {
                                                            if (c9 != 'E' && c9 != 'e') {
                                                                if (c9 != '-') {
                                                                    if (c9 != '.') {
                                                                        switch (c9) {
                                                                            case '0':
                                                                            case '1':
                                                                            case '2':
                                                                            case '3':
                                                                            case '4':
                                                                            case '5':
                                                                            case '6':
                                                                            case '7':
                                                                            case '8':
                                                                            case '9':
                                                                                i38++;
                                                                                i13 = i5;
                                                                                k6Var2 = k6Var;
                                                                            default:
                                                                                z13 = false;
                                                                                z14 = false;
                                                                                break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            z13 = true;
                                                            z14 = false;
                                                            i38++;
                                                            i13 = i5;
                                                            k6Var2 = k6Var;
                                                        }
                                                        i38++;
                                                        i13 = i5;
                                                        k6Var2 = k6Var;
                                                    } catch (RuntimeException e8) {
                                                        runtimeException = e8;
                                                        i13 = i5;
                                                    }
                                                } else {
                                                    i5 = i13;
                                                    k6Var = k6Var2;
                                                }
                                            }
                                            if (z13) {
                                                try {
                                                    n(str2, Double.parseDouble(str8), str8);
                                                } catch (NumberFormatException unused2) {
                                                }
                                            } else if (z14) {
                                                o(str2, Long.parseLong(str8), str8);
                                            }
                                        }
                                        str3 = str;
                                        i5 = i13;
                                        k6Var = k6Var2;
                                    } else {
                                        str3 = str;
                                        i5 = i13;
                                        k6Var = k6Var2;
                                    }
                                    u(str2, str8);
                                }
                                i12 = i5;
                                z = false;
                            }
                            b11 = r9;
                            i36 = i37;
                            i13 = i5;
                            k6Var2 = k6Var;
                            String str9 = str3;
                            z6 = z;
                            str = str9;
                        }
                    }
                } catch (RuntimeException e9) {
                    e = e9;
                    runtimeException = e;
                    JsonValue jsonValue2 = this.c;
                    this.c = null;
                    this.d = null;
                    this.b.clear();
                    if (i13 < i3) {
                    }
                }
            }
            i13 = i13;
            runtimeException = null;
            JsonValue jsonValue22 = this.c;
            this.c = null;
            this.d = null;
            this.b.clear();
            if (i13 < i3) {
                int i39 = 1;
                for (int i40 = 0; i40 < i13; i40++) {
                    if (cArr[i40] == '\n') {
                        i39++;
                    }
                }
                int max = Math.max(0, i13 - 32);
                throw new SerializationException("Error parsing JSON on line " + i39 + " near: " + new String(cArr, max, i13 - max) + "*ERROR*" + new String(cArr, i13, Math.min(64, i3 - i13)), runtimeException);
            }
            k6<JsonValue> k6Var3 = this.a;
            if (k6Var3.b != 0) {
                JsonValue peek = k6Var3.peek();
                this.a.clear();
                if (peek != null && peek.C()) {
                    throw new SerializationException("Error parsing JSON, unmatched brace.");
                }
                throw new SerializationException("Error parsing JSON, unmatched bracket.");
            } else if (runtimeException == null) {
                return jsonValue22;
            } else {
                throw new SerializationException("Error parsing JSON: " + new String(cArr), runtimeException);
            }
        }
        return (JsonValue) invokeLII.objValue;
    }

    public void s(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.array);
            if (this.d != null) {
                b(str, jsonValue);
            }
            this.a.a(jsonValue);
            this.d = jsonValue;
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            JsonValue jsonValue = new JsonValue(JsonValue.ValueType.object);
            if (this.d != null) {
                b(str, jsonValue);
            }
            this.a.a(jsonValue);
            this.d = jsonValue;
        }
    }

    public final String v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, str)) == null) {
            int length = str.length();
            t7 t7Var = new t7(length + 16);
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt != '\\') {
                    t7Var.a(charAt);
                } else if (i3 == length) {
                    break;
                } else {
                    i2 = i3 + 1;
                    char charAt2 = str.charAt(i3);
                    if (charAt2 == 'u') {
                        i3 = i2 + 4;
                        t7Var.p(Character.toChars(Integer.parseInt(str.substring(i2, i3), 16)));
                    } else {
                        if (charAt2 != '\"' && charAt2 != '/' && charAt2 != '\\') {
                            if (charAt2 != 'b') {
                                if (charAt2 != 'f') {
                                    if (charAt2 != 'n') {
                                        if (charAt2 != 'r') {
                                            if (charAt2 == 't') {
                                                charAt2 = '\t';
                                            } else {
                                                throw new SerializationException("Illegal escaped character: \\" + charAt2);
                                            }
                                        } else {
                                            charAt2 = '\r';
                                        }
                                    } else {
                                        charAt2 = '\n';
                                    }
                                } else {
                                    charAt2 = '\f';
                                }
                            } else {
                                charAt2 = '\b';
                            }
                        }
                        t7Var.a(charAt2);
                    }
                }
                i2 = i3;
            }
            return t7Var.toString();
        }
        return (String) invokeL.objValue;
    }
}
