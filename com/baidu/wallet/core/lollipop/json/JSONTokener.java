package com.baidu.wallet.core.lollipop.json;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.zxing.client.result.ResultParser;
import org.apache.commons.lang3.CharUtils;
/* loaded from: classes6.dex */
public class JSONTokener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String in;
    public int pos;

    public JSONTokener(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (str != null && str.startsWith(ResultParser.BYTE_ORDER_MARK)) {
            str = str.substring(1);
        }
        this.in = str;
    }

    public static int dehexchar(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Character.valueOf(c2)})) == null) {
            if (c2 < '0' || c2 > '9') {
                char c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    c3 = 'a';
                    if (c2 < 'a' || c2 > 'f') {
                        return -1;
                    }
                }
                return (c2 - c3) + 10;
            }
            return c2 - '0';
        }
        return invokeCommon.intValue;
    }

    private int nextCleanInternal() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            while (this.pos < this.in.length()) {
                String str = this.in;
                int i2 = this.pos;
                this.pos = i2 + 1;
                char charAt = str.charAt(i2);
                if (charAt != '\t' && charAt != '\n' && charAt != '\r' && charAt != ' ') {
                    if (charAt != '#') {
                        if (charAt != '/' || this.pos == this.in.length()) {
                            return charAt;
                        }
                        char charAt2 = this.in.charAt(this.pos);
                        if (charAt2 == '*') {
                            int i3 = this.pos + 1;
                            this.pos = i3;
                            int indexOf = this.in.indexOf("*/", i3);
                            if (indexOf != -1) {
                                this.pos = indexOf + 2;
                            } else {
                                throw syntaxError("Unterminated comment");
                            }
                        } else if (charAt2 != '/') {
                            return charAt;
                        } else {
                            this.pos++;
                            skipToEndOfLine();
                        }
                    } else {
                        skipToEndOfLine();
                    }
                }
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private String nextToInternal(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, str)) == null) {
            int i2 = this.pos;
            while (this.pos < this.in.length()) {
                char charAt = this.in.charAt(this.pos);
                if (charAt != '\r' && charAt != '\n' && str.indexOf(charAt) == -1) {
                    this.pos++;
                } else {
                    return this.in.substring(i2, this.pos);
                }
            }
            return this.in.substring(i2);
        }
        return (String) invokeL.objValue;
    }

    private JSONArray readArray() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) != null) {
            return (JSONArray) invokeV.objValue;
        }
        JSONArray jSONArray = new JSONArray();
        boolean z = false;
        while (true) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal == -1) {
                throw syntaxError("Unterminated array");
            }
            if (nextCleanInternal == 44 || nextCleanInternal == 59) {
                jSONArray.put((Object) null);
            } else if (nextCleanInternal == 93) {
                if (z) {
                    jSONArray.put((Object) null);
                }
                return jSONArray;
            } else {
                this.pos--;
                jSONArray.put(nextValue());
                int nextCleanInternal2 = nextCleanInternal();
                if (nextCleanInternal2 != 44 && nextCleanInternal2 != 59) {
                    if (nextCleanInternal2 == 93) {
                        return jSONArray;
                    }
                    throw syntaxError("Unterminated array");
                }
            }
            z = true;
        }
    }

    private char readEscapeCharacter() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            String str = this.in;
            int i2 = this.pos;
            this.pos = i2 + 1;
            char charAt = str.charAt(i2);
            if (charAt != 'b') {
                if (charAt != 'f') {
                    if (charAt != 'n') {
                        if (charAt != 'r') {
                            if (charAt != 't') {
                                if (charAt != 'u') {
                                    return charAt;
                                }
                                if (this.pos + 4 <= this.in.length()) {
                                    String str2 = this.in;
                                    int i3 = this.pos;
                                    String substring = str2.substring(i3, i3 + 4);
                                    this.pos += 4;
                                    return (char) Integer.parseInt(substring, 16);
                                }
                                throw syntaxError("Unterminated escape sequence");
                            }
                            return '\t';
                        }
                        return CharUtils.CR;
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return invokeV.charValue;
    }

    private Object readLiteral() throws JSONException {
        InterceptResult invokeV;
        String substring;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            String nextToInternal = nextToInternal("{}[]/\\:,=;# \t\f");
            if (nextToInternal.length() != 0) {
                if (StringUtil.NULL_STRING.equalsIgnoreCase(nextToInternal)) {
                    return JSONObject.NULL;
                }
                if ("true".equalsIgnoreCase(nextToInternal)) {
                    return Boolean.TRUE;
                }
                if ("false".equalsIgnoreCase(nextToInternal)) {
                    return Boolean.FALSE;
                }
                if (nextToInternal.indexOf(46) == -1) {
                    if (!nextToInternal.startsWith("0x") && !nextToInternal.startsWith("0X")) {
                        if (!nextToInternal.startsWith("0") || nextToInternal.length() <= 1) {
                            substring = nextToInternal;
                            i2 = 10;
                        } else {
                            substring = nextToInternal.substring(1);
                            i2 = 8;
                        }
                    } else {
                        substring = nextToInternal.substring(2);
                        i2 = 16;
                    }
                    try {
                        long parseLong = Long.parseLong(substring, i2);
                        if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                            return Integer.valueOf((int) parseLong);
                        }
                        return Long.valueOf(parseLong);
                    } catch (NumberFormatException unused) {
                    }
                }
                try {
                    return Double.valueOf(nextToInternal);
                } catch (NumberFormatException unused2) {
                    return nextToInternal;
                }
            }
            throw syntaxError("Expected literal value");
        }
        return invokeV.objValue;
    }

    private JSONObject readObject() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeV = interceptable.invokeV(65543, this)) != null) {
            return (JSONObject) invokeV.objValue;
        }
        JSONObject jSONObject = new JSONObject();
        int nextCleanInternal = nextCleanInternal();
        if (nextCleanInternal == 125) {
            return jSONObject;
        }
        if (nextCleanInternal != -1) {
            this.pos--;
        }
        while (true) {
            Object nextValue = nextValue();
            if (!(nextValue instanceof String)) {
                if (nextValue == null) {
                    throw syntaxError("Names cannot be null");
                }
                throw syntaxError("Names must be strings, but " + nextValue + " is of type " + nextValue.getClass().getName());
            }
            int nextCleanInternal2 = nextCleanInternal();
            if (nextCleanInternal2 != 58 && nextCleanInternal2 != 61) {
                throw syntaxError("Expected ':' after " + nextValue);
            }
            if (this.pos < this.in.length() && this.in.charAt(this.pos) == '>') {
                this.pos++;
            }
            jSONObject.put((String) nextValue, nextValue());
            int nextCleanInternal3 = nextCleanInternal();
            if (nextCleanInternal3 != 44 && nextCleanInternal3 != 59) {
                if (nextCleanInternal3 == 125) {
                    return jSONObject;
                }
                throw syntaxError("Unterminated object");
            }
        }
    }

    private void skipToEndOfLine() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            while (this.pos < this.in.length()) {
                char charAt = this.in.charAt(this.pos);
                if (charAt != '\r' && charAt != '\n') {
                    this.pos++;
                } else {
                    this.pos++;
                    return;
                }
            }
        }
    }

    public void back() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.pos - 1;
            this.pos = i2;
            if (i2 == -1) {
                this.pos = 0;
            }
        }
    }

    public boolean more() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.pos < this.in.length() : invokeV.booleanValue;
    }

    public char next() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.pos < this.in.length()) {
                String str = this.in;
                int i2 = this.pos;
                this.pos = i2 + 1;
                return str.charAt(i2);
            }
            return (char) 0;
        }
        return invokeV.charValue;
    }

    public char nextClean() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal == -1) {
                return (char) 0;
            }
            return (char) nextCleanInternal;
        }
        return invokeV.charValue;
    }

    public String nextString(char c2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{Character.valueOf(c2)})) == null) {
            int i2 = this.pos;
            StringBuilder sb = null;
            while (this.pos < this.in.length()) {
                String str = this.in;
                int i3 = this.pos;
                this.pos = i3 + 1;
                char charAt = str.charAt(i3);
                if (charAt == c2) {
                    if (sb == null) {
                        return this.in.substring(i2, this.pos - 1);
                    }
                    sb.append((CharSequence) this.in, i2, this.pos - 1);
                    return sb.toString();
                } else if (charAt == '\\') {
                    if (this.pos != this.in.length()) {
                        if (sb == null) {
                            sb = new StringBuilder();
                        }
                        sb.append((CharSequence) this.in, i2, this.pos - 1);
                        sb.append(readEscapeCharacter());
                        i2 = this.pos;
                    } else {
                        throw syntaxError("Unterminated escape sequence");
                    }
                }
            }
            throw syntaxError("Unterminated string");
        }
        return (String) invokeCommon.objValue;
    }

    public String nextTo(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null) {
                return nextToInternal(str).trim();
            }
            throw new NullPointerException("excluded == null");
        }
        return (String) invokeL.objValue;
    }

    public Object nextValue() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            int nextCleanInternal = nextCleanInternal();
            if (nextCleanInternal != -1) {
                if (nextCleanInternal == 34 || nextCleanInternal == 39) {
                    return nextString((char) nextCleanInternal);
                }
                if (nextCleanInternal != 91) {
                    if (nextCleanInternal != 123) {
                        this.pos--;
                        return readLiteral();
                    }
                    return readObject();
                }
                return readArray();
            }
            throw syntaxError("End of input");
        }
        return invokeV.objValue;
    }

    public void skipPast(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            int indexOf = this.in.indexOf(str, this.pos);
            this.pos = indexOf == -1 ? this.in.length() : str.length() + indexOf;
        }
    }

    public char skipTo(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Character.valueOf(c2)})) == null) {
            int indexOf = this.in.indexOf(c2, this.pos);
            if (indexOf != -1) {
                this.pos = indexOf;
                return c2;
            }
            return (char) 0;
        }
        return invokeCommon.charValue;
    }

    public JSONException syntaxError(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            return new JSONException(str + this);
        }
        return (JSONException) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return " at character " + this.pos + " of " + this.in;
        }
        return (String) invokeV.objValue;
    }

    public char next(char c2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Character.valueOf(c2)})) == null) {
            char next = next();
            if (next == c2) {
                return next;
            }
            throw syntaxError("Expected " + c2 + " but was " + next);
        }
        return invokeCommon.charValue;
    }

    public String nextTo(char c2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Character.valueOf(c2)})) == null) ? nextToInternal(String.valueOf(c2)).trim() : (String) invokeCommon.objValue;
    }

    public String next(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            if (this.pos + i2 <= this.in.length()) {
                String str = this.in;
                int i3 = this.pos;
                String substring = str.substring(i3, i3 + i2);
                this.pos += i2;
                return substring;
            }
            throw syntaxError(i2 + " is out of bounds");
        }
        return (String) invokeI.objValue;
    }
}
