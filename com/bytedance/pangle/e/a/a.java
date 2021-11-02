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
/* loaded from: classes11.dex */
public final class a implements XmlResourceParser {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f61363a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f61364b;

    /* renamed from: c  reason: collision with root package name */
    public f f61365c;

    /* renamed from: d  reason: collision with root package name */
    public int[] f61366d;

    /* renamed from: e  reason: collision with root package name */
    public C1843a f61367e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61368f;

    /* renamed from: g  reason: collision with root package name */
    public int f61369g;

    /* renamed from: h  reason: collision with root package name */
    public int f61370h;

    /* renamed from: i  reason: collision with root package name */
    public int f61371i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61364b = false;
        this.f61367e = new C1843a();
        a();
    }

    private final int c(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, this, i2)) == null) {
            if (this.f61369g == 2) {
                int i3 = i2 * 5;
                if (i3 < this.k.length) {
                    return i3;
                }
                throw new IndexOutOfBoundsException("Invalid attribute index (" + i2 + ").");
            }
            throw new IndexOutOfBoundsException("Current event is not START_TAG.");
        }
        return invokeI.intValue;
    }

    public final int a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) ? this.k[c(i2) + 3] : invokeI.intValue;
    }

    public final int b(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.k[c(i2) + 4] : invokeI.intValue;
    }

    @Override // android.content.res.XmlResourceParser, java.lang.AutoCloseable
    public final void close() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f61364b) {
            this.f61364b = false;
            c cVar = this.f61363a;
            InputStream inputStream = cVar.f61377a;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
                cVar.a((InputStream) null);
            }
            this.f61363a = null;
            this.f61365c = null;
            this.f61366d = null;
            C1843a c1843a = this.f61367e;
            c1843a.f61375b = 0;
            c1843a.f61376c = 0;
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
    public final boolean getAttributeBooleanValue(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? getAttributeIntValue(i2, z ? 1 : 0) != 0 : invokeCommon.booleanValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final int getAttributeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.f61369g != 2) {
                return -1;
            }
            return this.k.length / 5;
        }
        return invokeV.intValue;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            int c2 = c(i2);
            int[] iArr = this.k;
            return iArr[c2 + 3] == 4 ? Float.intBitsToFloat(iArr[c2 + 4]) : f2;
        }
        return invokeCommon.floatValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            int c2 = c(i2);
            int[] iArr = this.k;
            int i4 = iArr[c2 + 3];
            return (i4 < 16 || i4 > 31) ? i3 : iArr[c2 + 4];
        }
        return invokeII.intValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(int i2, String[] strArr, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Integer.valueOf(i2), strArr, Integer.valueOf(i3)})) == null) {
            return 0;
        }
        return invokeCommon.intValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeListValue(String str, String str2, String[] strArr, int i2) {
        InterceptResult invokeLLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048588, this, str, str2, strArr, i2)) == null) {
            return 0;
        }
        return invokeLLLI.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            int i3 = this.k[c(i2) + 1];
            return i3 == -1 ? "" : this.f61365c.a(i3);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeNameResource(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            int i3 = this.k[c(i2) + 1];
            int[] iArr = this.f61366d;
            if (iArr == null || i3 < 0 || i3 >= iArr.length) {
                return 0;
            }
            return iArr[i3];
        }
        return invokeI.intValue;
    }

    @Override // android.content.res.XmlResourceParser, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeNamespace(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            int i3 = this.k[c(i2) + 0];
            return i3 == -1 ? "" : this.f61365c.a(i3);
        }
        return (String) invokeI.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributePrefix(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048592, this, i2)) == null) {
            int a2 = this.f61367e.a(this.k[c(i2) + 0]);
            return a2 == -1 ? "" : this.f61365c.a(a2);
        }
        return (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048593, this, i2, i3)) == null) {
            int c2 = c(i2);
            int[] iArr = this.k;
            return iArr[c2 + 3] == 1 ? iArr[c2 + 4] : i3;
        }
        return invokeII.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getAttributeType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? "CDATA" : (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) ? getAttributeIntValue(i2, i3) : invokeII.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            int c2 = c(i2);
            int[] iArr = this.k;
            return iArr[c2 + 3] == 3 ? this.f61365c.a(iArr[c2 + 2]) : "";
        }
        return (String) invokeI.objValue;
    }

    @Override // android.util.AttributeSet
    public final String getClassAttribute() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            int i2 = this.m;
            if (i2 == -1) {
                return null;
            }
            return this.f61365c.a(this.k[c(i2) + 2]);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f61367e.f61376c - 1 : invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getEventType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.f61369g : invokeV.intValue;
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
            int i2 = this.l;
            if (i2 == -1) {
                return null;
            }
            return this.f61365c.a(this.k[c(i2) + 2]);
        }
        return (String) invokeV.objValue;
    }

    @Override // android.util.AttributeSet
    public final int getIdAttributeResourceValue(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
            int i3 = this.l;
            if (i3 == -1) {
                return i2;
            }
            int c2 = c(i3);
            int[] iArr = this.k;
            return iArr[c2 + 3] != 1 ? i2 : iArr[c2 + 4];
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.f61370h : invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            if (this.f61371i != -1) {
                int i2 = this.f61369g;
                if (i2 == 2 || i2 == 3) {
                    return this.f61365c.a(this.f61371i);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f61365c.a(this.j) : (String) invokeV.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final int getNamespaceCount(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048612, this, i2)) == null) {
            C1843a c1843a = this.f61367e;
            int i3 = 0;
            if (c1843a.f61375b != 0 && i2 >= 0) {
                int i4 = c1843a.f61376c;
                if (i2 > i4) {
                    i2 = i4;
                }
                int i5 = 0;
                while (i2 != 0) {
                    int i6 = c1843a.f61374a[i5];
                    i3 += i6;
                    i5 += (i6 * 2) + 2;
                    i2--;
                }
            }
            return i3;
        }
        return invokeI.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespacePrefix(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) ? this.f61365c.a(this.f61367e.a(i2, true)) : (String) invokeI.objValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getNamespaceUri(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048614, this, i2)) == null) ? this.f61365c.a(this.f61367e.a(i2, false)) : (String) invokeI.objValue;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) ? this.f61365c.a(this.f61367e.a(this.j)) : (String) invokeV.objValue;
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
            int i2 = this.n;
            if (i2 == -1) {
                return 0;
            }
            return this.k[c(i2) + 4];
        }
        return invokeV.intValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser
    public final String getText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048619, this)) == null) {
            int i2 = this.f61371i;
            if (i2 == -1 || this.f61369g != 4) {
                return null;
            }
            return this.f61365c.a(i2);
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
    public final boolean isAttributeDefault(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048621, this, i2)) == null) {
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
            if (this.f61363a != null) {
                try {
                    b();
                    return this.f61369g;
                } catch (IOException e2) {
                    close();
                    throw e2;
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
    public final void require(int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048628, this, i2, str, str2) == null) {
            if (i2 == getEventType() && ((str == null || str.equals(getNamespace())) && (str2 == null || str2.equals(getName())))) {
                return;
            }
            throw new XmlPullParserException(XmlResourceParser.TYPES[i2] + " is expected.", this, null);
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
            int a2 = a(str, str2);
            return a2 == -1 ? z : getAttributeBooleanValue(a2, z);
        }
        return invokeLLZ.booleanValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeUnsignedIntValue(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048597, this, str, str2, i2)) == null) {
            int a2 = a(str, str2);
            return a2 == -1 ? i2 : getAttributeUnsignedIntValue(a2, i2);
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
        int a2;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, str, str2)) == null) {
            f fVar = this.f61365c;
            if (fVar == null || str2 == null || (a2 = fVar.a(str2)) == -1) {
                return -1;
            }
            int a3 = str != null ? this.f61365c.a(str) : -1;
            while (true) {
                int[] iArr = this.k;
                if (i2 == iArr.length) {
                    break;
                }
                int i3 = i2 + 1;
                i2 = (a2 == iArr[i3] && (a3 == -1 || a3 == iArr[i2 + 0])) ? 0 : i3;
            }
            return i2 / 5;
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
        int a2;
        int i2;
        int[] iArr;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (this.f61365c == null) {
                b.a(this.f61363a, 524291);
                this.f61363a.c();
                c cVar = this.f61363a;
                b.a(cVar, 1835009);
                int b2 = cVar.b();
                int b3 = cVar.b();
                int b4 = cVar.b();
                cVar.b();
                int b5 = cVar.b();
                int b6 = cVar.b();
                f fVar = new f();
                fVar.f61382a = cVar.a(b3);
                if (b4 != 0) {
                    cVar.a(b4);
                }
                int i4 = (b6 == 0 ? b2 : b6) - b5;
                if (i4 % 4 == 0) {
                    fVar.f61383b = cVar.a(i4 / 4);
                    if (b6 != 0) {
                        int i5 = b2 - b6;
                        if (i5 % 4 == 0) {
                            cVar.a(i5 / 4);
                        } else {
                            throw new IOException("Style data size is not multiple of 4 (" + i5 + ").");
                        }
                    }
                    this.f61365c = fVar;
                    this.f61367e.a();
                    this.f61364b = true;
                } else {
                    throw new IOException("String data size is not multiple of 4 (" + i4 + ").");
                }
            }
            int i6 = this.f61369g;
            if (i6 != 1) {
                a();
                while (true) {
                    if (this.f61368f) {
                        this.f61368f = false;
                        C1843a c1843a = this.f61367e;
                        int i7 = c1843a.f61375b;
                        if (i7 != 0) {
                            int i8 = i7 - 1;
                            int i9 = c1843a.f61374a[i8] * 2;
                            if ((i8 - 1) - i9 != 0) {
                                c1843a.f61375b = i7 - (i9 + 2);
                                c1843a.f61376c--;
                            }
                        }
                    }
                    int i10 = 3;
                    if (i6 == 3) {
                        C1843a c1843a2 = this.f61367e;
                        if (c1843a2.f61376c == 1) {
                            int i11 = c1843a2.f61375b;
                            if ((i11 == 0 ? 0 : c1843a2.f61374a[i11 - 1]) == 0) {
                                this.f61369g = 1;
                                return;
                            }
                        }
                    }
                    int a3 = i6 == 0 ? 1048834 : this.f61363a.a();
                    if (a3 == 524672) {
                        a2 = this.f61363a.a();
                        if (a2 < 8 || a2 % 4 != 0) {
                            break;
                        }
                        this.f61366d = this.f61363a.a((a2 / 4) - 2);
                    } else if (a3 < 1048832 || a3 > 1048836) {
                        break;
                    } else if (a3 == 1048834 && i6 == -1) {
                        this.f61369g = 0;
                        return;
                    } else {
                        this.f61363a.c();
                        int a4 = this.f61363a.a();
                        this.f61363a.c();
                        if (a3 != 1048832 && a3 != 1048833) {
                            this.f61370h = a4;
                            if (a3 == 1048834) {
                                this.j = this.f61363a.a();
                                this.f61371i = this.f61363a.a();
                                this.f61363a.c();
                                int a5 = this.f61363a.a();
                                this.l = (a5 >>> 16) - 1;
                                int a6 = this.f61363a.a();
                                this.m = a6;
                                this.n = (a6 >>> 16) - 1;
                                this.m = (65535 & a6) - 1;
                                this.k = this.f61363a.a((a5 & 65535) * 5);
                                while (true) {
                                    int[] iArr2 = this.k;
                                    if (i10 < iArr2.length) {
                                        iArr2[i10] = iArr2[i10] >>> 24;
                                        i10 += 5;
                                    } else {
                                        this.f61367e.a();
                                        this.f61369g = 2;
                                        return;
                                    }
                                }
                            } else if (a3 == 1048835) {
                                this.j = this.f61363a.a();
                                this.f61371i = this.f61363a.a();
                                this.f61369g = 3;
                                this.f61368f = true;
                                return;
                            } else if (a3 == 1048836) {
                                this.f61371i = this.f61363a.a();
                                this.f61363a.c();
                                this.f61363a.c();
                                this.f61369g = 4;
                                return;
                            }
                        } else if (a3 == 1048832) {
                            int a7 = this.f61363a.a();
                            int a8 = this.f61363a.a();
                            C1843a c1843a3 = this.f61367e;
                            if (c1843a3.f61376c == 0) {
                                c1843a3.a();
                            }
                            c1843a3.b();
                            int i12 = c1843a3.f61375b;
                            int i13 = i12 - 1;
                            int[] iArr3 = c1843a3.f61374a;
                            int i14 = iArr3[i13];
                            int i15 = i14 + 1;
                            iArr3[(i13 - 1) - (i14 * 2)] = i15;
                            iArr3[i13] = a7;
                            iArr3[i13 + 1] = a8;
                            iArr3[i13 + 2] = i15;
                            c1843a3.f61375b = i12 + 2;
                        } else {
                            this.f61363a.c();
                            this.f61363a.c();
                            C1843a c1843a4 = this.f61367e;
                            int i16 = c1843a4.f61375b;
                            if (i16 != 0 && (i3 = (iArr = c1843a4.f61374a)[i16 - 1]) != 0) {
                                int i17 = i3 - 1;
                                int i18 = i2 - 2;
                                iArr[i18] = i17;
                                iArr[i18 - ((i17 * 2) + 1)] = i17;
                                c1843a4.f61375b = i16 - 2;
                            }
                        }
                    }
                }
                throw new IOException("Invalid resource ids size (" + a2 + ").");
            }
        }
    }

    @Override // android.util.AttributeSet
    public final int getAttributeIntValue(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048586, this, str, str2, i2)) == null) {
            int a2 = a(str, str2);
            return a2 == -1 ? i2 : getAttributeIntValue(a2, i2);
        }
        return invokeLLI.intValue;
    }

    @Override // android.util.AttributeSet
    public final int getAttributeResourceValue(String str, String str2, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048594, this, str, str2, i2)) == null) {
            int a2 = a(str, str2);
            return a2 == -1 ? i2 : getAttributeResourceValue(a2, i2);
        }
        return invokeLLI.intValue;
    }

    @Override // android.util.AttributeSet
    public final float getAttributeFloatValue(String str, String str2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Float.valueOf(f2)})) == null) {
            int a2 = a(str, str2);
            return a2 == -1 ? f2 : getAttributeFloatValue(a2, f2);
        }
        return invokeCommon.floatValue;
    }

    @Override // org.xmlpull.v1.XmlPullParser, android.util.AttributeSet
    public final String getAttributeValue(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, str, str2)) == null) {
            int a2 = a(str, str2);
            if (a2 == -1) {
                return null;
            }
            return getAttributeValue(a2);
        }
        return (String) invokeLL.objValue;
    }

    /* renamed from: com.bytedance.pangle.e.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public static final class C1843a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int[] f61374a;

        /* renamed from: b  reason: collision with root package name */
        public int f61375b;

        /* renamed from: c  reason: collision with root package name */
        public int f61376c;

        public C1843a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61374a = new int[32];
        }

        public final void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                b();
                int i2 = this.f61375b;
                int[] iArr = this.f61374a;
                iArr[i2] = 0;
                iArr[i2 + 1] = 0;
                this.f61375b = i2 + 2;
                this.f61376c++;
            }
        }

        public final void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                int[] iArr = this.f61374a;
                int length = iArr.length;
                int i2 = this.f61375b;
                int i3 = length - i2;
                if (i3 <= 2) {
                    int[] iArr2 = new int[(iArr.length + i3) * 2];
                    System.arraycopy(iArr, 0, iArr2, 0, i2);
                    this.f61374a = iArr2;
                }
            }
        }

        public final int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                int i3 = this.f61375b;
                if (i3 == 0) {
                    return -1;
                }
                int i4 = i3 - 1;
                for (int i5 = this.f61376c; i5 != 0; i5--) {
                    i4 -= 2;
                    for (int i6 = this.f61374a[i4]; i6 != 0; i6--) {
                        int[] iArr = this.f61374a;
                        if (iArr[i4 + 1] == i2) {
                            return iArr[i4];
                        }
                        i4 -= 2;
                    }
                }
                return -1;
            }
            return invokeI.intValue;
        }

        public final int a(int i2, boolean z) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
                if (this.f61375b != 0 && i2 >= 0) {
                    int i3 = 0;
                    for (int i4 = this.f61376c; i4 != 0; i4--) {
                        int i5 = this.f61374a[i3];
                        if (i2 < i5) {
                            int i6 = i3 + (i2 * 2) + 1;
                            if (!z) {
                                i6++;
                            }
                            return this.f61374a[i6];
                        }
                        i2 -= i5;
                        i3 += (i5 * 2) + 2;
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
            this.f61369g = -1;
            this.f61370h = -1;
            this.f61371i = -1;
            this.j = -1;
            this.k = null;
            this.l = -1;
            this.m = -1;
            this.n = -1;
        }
    }
}
