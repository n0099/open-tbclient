package com.bytedance.pangle.e.a;

import android.content.res.XmlResourceParser;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParserException;
/* loaded from: classes4.dex */
public final class a implements XmlResourceParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c a;
    public boolean b;
    public f c;
    public int[] d;
    public C0258a e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int[] k;
    public int l;
    public int m;
    public int n;

    public a() {
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
        this.b = false;
        this.e = new C0258a();
        a();
    }

    private final int c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i)) == null) {
            if (this.g == 2) {
                int i2 = i * 5;
                if (i2 < this.k.length) {
                    return i2;
                }
                throw new IndexOutOfBoundsException("Invalid attribute index (" + i + ").");
            }
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        return invokeI.intValue;
    }

    public final int a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) ? this.k[c(i) + 3] : invokeI.intValue;
    }

    public final int b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? this.k[c(i) + 4] : invokeI.intValue;
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.b) {
            this.b = false;
            c cVar = this.a;
            InputStream inputStream = cVar.a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                cVar.a((InputStream) null);
            }
            this.a = null;
            this.c = null;
            this.d = null;
            C0258a c0258a = this.e;
            c0258a.b = 0;
            c0258a.c = 0;
            a();
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void defineEntityReplacementText(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            throw new XmlPullParserException("Method is not supported.");
        }
    }

    @Override // android.util.AttributeSet
    public final boolean getAttributeBooleanValue(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) ? getAttributeIntValue(i, z ? 1 : 0) != 0 : invokeCommon.booleanValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final int getAttributeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.g != 2) {
                return -1;
            }
            return this.k.length / 5;
        }
        return invokeV.intValue;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(int i, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
            int c = c(i);
            int[] iArr = this.k;
            return iArr[c + 3] == 4 ? Float.intBitsToFloat(iArr[c + 4]) : f;
        }
        return invokeCommon.floatValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            int c = c(i);
            int[] iArr = this.k;
            int i3 = iArr[c + 3];
            return (i3 < 16 || i3 > 31) ? i2 : iArr[c + 4];
        }
        return invokeII.intValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(int i, String[] strArr, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i), strArr, Integer.valueOf(i2)})) == null) {
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(String str, String str2, String[] strArr, int i) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048588, this, str, str2, strArr, i)) == null) {
            return 0;
        }
        return invokeLLLI.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeName(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            int i2 = this.k[c(i) + 1];
            return i2 == -1 ? "" : this.c.a(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeNameResource(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            int i2 = this.k[c(i) + 1];
            int[] iArr = this.d;
            if (iArr == null || i2 < 0 || i2 >= iArr.length) {
                return 0;
            }
            return iArr[i2];
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeNamespace(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            int i2 = this.k[c(i) + 0];
            return i2 == -1 ? "" : this.c.a(i2);
        }
        return (String) invokeI.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributePrefix(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i)) == null) {
            int a = this.e.a(this.k[c(i) + 0]);
            return a == -1 ? "" : this.c.a(a);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i, i2)) == null) {
            int c = c(i);
            int[] iArr = this.k;
            return iArr[c + 3] == 1 ? iArr[c + 4] : i2;
        }
        return invokeII.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributeType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) ? "CDATA" : (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) ? getAttributeIntValue(i, i2) : invokeII.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            int c = c(i);
            int[] iArr = this.k;
            return iArr[c + 3] == 3 ? this.c.a(iArr[c + 2]) : "";
        }
        return (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final String getClassAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i = this.m;
            if (i == -1) {
                return null;
            }
            return this.c.a(this.k[c(i) + 2]);
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getColumnNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return -1;
        }
        return invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.e.c - 1 : invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getEventType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.g : invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean getFeature(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.util.AttributeSet
    public final String getIdAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            int i = this.l;
            if (i == -1) {
                return null;
            }
            return this.c.a(this.k[c(i) + 2]);
        }
        return (String) invokeV.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getIdAttributeResourceValue(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i)) == null) {
            int i2 = this.l;
            if (i2 == -1) {
                return i;
            }
            int c = c(i2);
            int[] iArr = this.k;
            return iArr[c + 3] != 1 ? i : iArr[c + 4];
        }
        return invokeI.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getInputEncoding() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getLineNumber() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.h : invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.i != -1) {
                int i = this.g;
                if (i == 2 || i == 3) {
                    return this.c.a(this.i);
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.c.a(this.j) : (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getNamespaceCount(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i)) == null) {
            C0258a c0258a = this.e;
            int i2 = 0;
            if (c0258a.b != 0 && i >= 0) {
                int i3 = c0258a.c;
                if (i > i3) {
                    i = i3;
                }
                int i4 = 0;
                while (i != 0) {
                    int i5 = c0258a.a[i4];
                    i2 += i5;
                    i4 += (i5 * 2) + 2;
                    i--;
                }
            }
            return i2;
        }
        return invokeI.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespacePrefix(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i)) == null) ? this.c.a(this.e.a(i, true)) : (String) invokeI.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespaceUri(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i)) == null) ? this.c.a(this.e.a(i, false)) : (String) invokeI.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getPositionDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return "XML line #" + getLineNumber();
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getPrefix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.c.a(this.e.a(this.j)) : (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final Object getProperty(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, str)) == null) {
            return null;
        }
        return invokeL.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getStyleAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            int i = this.n;
            if (i == -1) {
                return 0;
            }
            return this.k[c(i) + 4];
        }
        return invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            int i = this.i;
            if (i == -1 || this.g != 4) {
                return null;
            }
            return this.c.a(i);
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final char[] getTextCharacters(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, iArr)) == null) {
            String text = getText();
            if (text == null) {
                return null;
            }
            iArr[0] = 0;
            iArr[1] = text.length();
            char[] cArr = new char[text.length()];
            text.getChars(0, text.length(), cArr, 0);
            return cArr;
        }
        return (char[]) invokeL.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isAttributeDefault(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isEmptyElementTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final boolean isWhitespace() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048624, this)) == null) {
            if (this.a != null) {
                try {
                    b();
                    return this.g;
                } catch (IOException e) {
                    close();
                    throw e;
                }
            }
            throw new XmlPullParserException("Parser is not opened.", this, null);
        }
        return invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextTag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            int next = next();
            if (next == 4 && isWhitespace()) {
                next = next();
            }
            if (next == 2 || next == 3) {
                return next;
            }
            throw new XmlPullParserException("Expected start or end tag.", this, null);
        }
        return invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String nextText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            if (getEventType() == 2) {
                int next = next();
                if (next != 4) {
                    if (next == 3) {
                        return "";
                    }
                    throw new XmlPullParserException("Parser must be on START_TAG or TEXT to read text.", this, null);
                }
                String text = getText();
                if (next() == 3) {
                    return text;
                }
                throw new XmlPullParserException("Event TEXT must be immediately followed by END_TAG.", this, null);
            }
            throw new XmlPullParserException("Parser must be on START_TAG to read next text.", this, null);
        }
        return (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int nextToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048627, this)) == null) ? next() : invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void require(int i, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048628, this, i, str, str2) == null) {
            if (i == getEventType() && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
                return;
            }
            throw new XmlPullParserException(XmlResourceParser.TYPES[i] + " is expected.", this, null);
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setFeature(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048629, this, str, z) == null) {
            throw new XmlPullParserException("Method is not supported.");
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(InputStream inputStream, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048630, this, inputStream, str) == null) {
            throw new XmlPullParserException("Method is not supported.");
        }
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setProperty(String str, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048632, this, str, obj) == null) {
            throw new XmlPullParserException("Method is not supported.");
        }
    }

    @Override // android.util.AttributeSet
    public final boolean getAttributeBooleanValue(String str, String str2, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(1048581, this, str, str2, z)) == null) {
            int a = a(str, str2);
            return a == -1 ? z : getAttributeBooleanValue(a, z);
        }
        return invokeLLZ.booleanValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, str, str2, i)) == null) {
            int a = a(str, str2);
            return a == -1 ? i : getAttributeUnsignedIntValue(a, i);
        }
        return invokeLLI.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespace(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            throw new RuntimeException("Method is not supported.");
        }
        return (String) invokeL.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final void setInput(Reader reader) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048631, this, reader) == null) {
            throw new XmlPullParserException("Method is not supported.");
        }
    }

    private final int a(String str, String str2) {
        InterceptResult invokeLL;
        int a;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            f fVar = this.c;
            if (fVar == null || str2 == null || (a = fVar.a(str2)) == -1) {
                return -1;
            }
            int a2 = str != null ? this.c.a(str) : -1;
            while (true) {
                int[] iArr = this.k;
                if (i == iArr.length) {
                    break;
                }
                int i2 = i + 1;
                i = (a == iArr[i2] && (a2 == -1 || a2 == iArr[i + 0])) ? 0 : i2;
            }
            return i / 5;
        }
        return invokeLL.intValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x0254, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r8 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void b() {
        int a;
        int i;
        int[] iArr;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.c == null) {
                b.a(this.a, 524291);
                this.a.c();
                c cVar = this.a;
                b.a(cVar, 1835009);
                int b = cVar.b();
                int b2 = cVar.b();
                int b3 = cVar.b();
                cVar.b();
                int b4 = cVar.b();
                int b5 = cVar.b();
                f fVar = new f();
                fVar.a = cVar.a(b2);
                if (b3 != 0) {
                    cVar.a(b3);
                }
                int i3 = (b5 == 0 ? b : b5) - b4;
                if (i3 % 4 == 0) {
                    fVar.b = cVar.a(i3 / 4);
                    if (b5 != 0) {
                        int i4 = b - b5;
                        if (i4 % 4 == 0) {
                            cVar.a(i4 / 4);
                        } else {
                            throw new IOException("Style data size is not multiple of 4 (" + i4 + ").");
                        }
                    }
                    this.c = fVar;
                    this.e.a();
                    this.b = true;
                } else {
                    throw new IOException("String data size is not multiple of 4 (" + i3 + ").");
                }
            }
            int i5 = this.g;
            if (i5 != 1) {
                a();
                while (true) {
                    if (this.f) {
                        this.f = false;
                        C0258a c0258a = this.e;
                        int i6 = c0258a.b;
                        if (i6 != 0) {
                            int i7 = i6 - 1;
                            int i8 = c0258a.a[i7] * 2;
                            if ((i7 - 1) - i8 != 0) {
                                c0258a.b = i6 - (i8 + 2);
                                c0258a.c--;
                            }
                        }
                    }
                    int i9 = 3;
                    if (i5 == 3) {
                        C0258a c0258a2 = this.e;
                        if (c0258a2.c == 1) {
                            int i10 = c0258a2.b;
                            if ((i10 == 0 ? 0 : c0258a2.a[i10 - 1]) == 0) {
                                this.g = 1;
                                return;
                            }
                        }
                    }
                    int a2 = i5 == 0 ? 1048834 : this.a.a();
                    if (a2 == 524672) {
                        a = this.a.a();
                        if (a < 8 || a % 4 != 0) {
                            break;
                        }
                        this.d = this.a.a((a / 4) - 2);
                    } else if (a2 < 1048832 || a2 > 1048836) {
                        break;
                    } else if (a2 == 1048834 && i5 == -1) {
                        this.g = 0;
                        return;
                    } else {
                        this.a.c();
                        int a3 = this.a.a();
                        this.a.c();
                        if (a2 != 1048832 && a2 != 1048833) {
                            this.h = a3;
                            if (a2 == 1048834) {
                                this.j = this.a.a();
                                this.i = this.a.a();
                                this.a.c();
                                int a4 = this.a.a();
                                this.l = (a4 >>> 16) - 1;
                                int a5 = this.a.a();
                                this.m = a5;
                                this.n = (a5 >>> 16) - 1;
                                this.m = (65535 & a5) - 1;
                                this.k = this.a.a((a4 & 65535) * 5);
                                while (true) {
                                    int[] iArr2 = this.k;
                                    if (i9 < iArr2.length) {
                                        iArr2[i9] = iArr2[i9] >>> 24;
                                        i9 += 5;
                                    } else {
                                        this.e.a();
                                        this.g = 2;
                                        return;
                                    }
                                }
                            } else if (a2 == 1048835) {
                                this.j = this.a.a();
                                this.i = this.a.a();
                                this.g = 3;
                                this.f = true;
                                return;
                            } else if (a2 == 1048836) {
                                this.i = this.a.a();
                                this.a.c();
                                this.a.c();
                                this.g = 4;
                                return;
                            }
                        } else if (a2 == 1048832) {
                            int a6 = this.a.a();
                            int a7 = this.a.a();
                            C0258a c0258a3 = this.e;
                            if (c0258a3.c == 0) {
                                c0258a3.a();
                            }
                            c0258a3.b();
                            int i11 = c0258a3.b;
                            int i12 = i11 - 1;
                            int[] iArr3 = c0258a3.a;
                            int i13 = iArr3[i12];
                            int i14 = i13 + 1;
                            iArr3[(i12 - 1) - (i13 * 2)] = i14;
                            iArr3[i12] = a6;
                            iArr3[i12 + 1] = a7;
                            iArr3[i12 + 2] = i14;
                            c0258a3.b = i11 + 2;
                        } else {
                            this.a.c();
                            this.a.c();
                            C0258a c0258a4 = this.e;
                            int i15 = c0258a4.b;
                            if (i15 != 0 && (i2 = (iArr = c0258a4.a)[i15 - 1]) != 0) {
                                int i16 = i2 - 1;
                                int i17 = i - 2;
                                iArr[i17] = i16;
                                iArr[i17 - ((i16 * 2) + 1)] = i16;
                                c0258a4.b = i15 - 2;
                            }
                        }
                    }
                }
                throw new IOException("Invalid resource ids size (" + a + ").");
            }
        }
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, str, str2, i)) == null) {
            int a = a(str, str2);
            return a == -1 ? i : getAttributeIntValue(a, i);
        }
        return invokeLLI.intValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(String str, String str2, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, str, str2, i)) == null) {
            int a = a(str, str2);
            return a == -1 ? i : getAttributeResourceValue(a, i);
        }
        return invokeLLI.intValue;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(String str, String str2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Float.valueOf(f)})) == null) {
            int a = a(str, str2);
            return a == -1 ? f : getAttributeFloatValue(a, f);
        }
        return invokeCommon.floatValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            int a = a(str, str2);
            if (a == -1) {
                return null;
            }
            return getAttributeValue(a);
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: com.bytedance.pangle.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C0258a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;
        public int b;
        public int c;

        public C0258a() {
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
            this.a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b();
                int i = this.b;
                int[] iArr = this.a;
                iArr[i] = 0;
                iArr[i + 1] = 0;
                this.b = i + 2;
                this.c++;
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int[] iArr = this.a;
                int length = iArr.length;
                int i = this.b;
                int i2 = length - i;
                if (i2 <= 2) {
                    int[] iArr2 = new int[(iArr.length + i2) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i);
                    this.a = iArr2;
                }
            }
        }

        public final int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                int i2 = this.b;
                if (i2 == 0) {
                    return -1;
                }
                int i3 = i2 - 1;
                for (int i4 = this.c; i4 != 0; i4--) {
                    i3 -= 2;
                    for (int i5 = this.a[i3]; i5 != 0; i5--) {
                        int[] iArr = this.a;
                        if (iArr[i3 + 1] == i) {
                            return iArr[i3];
                        }
                        i3 -= 2;
                    }
                }
                return -1;
            }
            return invokeI.intValue;
        }

        public final int a(int i, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
                if (this.b != 0 && i >= 0) {
                    int i2 = 0;
                    for (int i3 = this.c; i3 != 0; i3--) {
                        int i4 = this.a[i2];
                        if (i < i4) {
                            int i5 = i2 + (i * 2) + 1;
                            if (!z) {
                                i5++;
                            }
                            return this.a[i5];
                        }
                        i -= i4;
                        i2 += (i4 * 2) + 2;
                    }
                }
                return -1;
            }
            return invokeCommon.intValue;
        }
    }

    private final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.g = -1;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = null;
            this.l = -1;
            this.m = -1;
            this.n = -1;
        }
    }
}
