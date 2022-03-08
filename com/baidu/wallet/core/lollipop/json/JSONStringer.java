package com.baidu.wallet.core.lollipop.json;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import com.tachikoma.core.utility.FileUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes6.dex */
public class JSONStringer {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String indent;
    public final StringBuilder out;
    public final List<Scope> stack;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes6.dex */
    public static final class Scope {
        public static final /* synthetic */ Scope[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Scope DANGLING_KEY;
        public static final Scope EMPTY_ARRAY;
        public static final Scope EMPTY_OBJECT;
        public static final Scope NONEMPTY_ARRAY;
        public static final Scope NONEMPTY_OBJECT;
        public static final Scope NULL;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(96279898, "Lcom/baidu/wallet/core/lollipop/json/JSONStringer$Scope;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(96279898, "Lcom/baidu/wallet/core/lollipop/json/JSONStringer$Scope;");
                    return;
                }
            }
            EMPTY_ARRAY = new Scope("EMPTY_ARRAY", 0);
            NONEMPTY_ARRAY = new Scope("NONEMPTY_ARRAY", 1);
            EMPTY_OBJECT = new Scope("EMPTY_OBJECT", 2);
            DANGLING_KEY = new Scope("DANGLING_KEY", 3);
            NONEMPTY_OBJECT = new Scope("NONEMPTY_OBJECT", 4);
            Scope scope = new Scope("NULL", 5);
            NULL = scope;
            $VALUES = new Scope[]{EMPTY_ARRAY, NONEMPTY_ARRAY, EMPTY_OBJECT, DANGLING_KEY, NONEMPTY_OBJECT, scope};
        }

        public Scope(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Scope valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Scope) Enum.valueOf(Scope.class, str) : (Scope) invokeL.objValue;
        }

        public static Scope[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Scope[]) $VALUES.clone() : (Scope[]) invokeV.objValue;
        }
    }

    public JSONStringer() {
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
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        this.indent = null;
    }

    private void beforeKey() throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            Scope peek = peek();
            if (peek == Scope.NONEMPTY_OBJECT) {
                this.out.append(',');
            } else if (peek != Scope.EMPTY_OBJECT) {
                throw new JSONException("Nesting problem");
            }
            newline();
            replaceTop(Scope.DANGLING_KEY);
        }
    }

    private void beforeValue() throws JSONException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.stack.isEmpty()) {
            return;
        }
        Scope peek = peek();
        if (peek == Scope.EMPTY_ARRAY) {
            replaceTop(Scope.NONEMPTY_ARRAY);
            newline();
        } else if (peek == Scope.NONEMPTY_ARRAY) {
            this.out.append(',');
            newline();
        } else if (peek == Scope.DANGLING_KEY) {
            this.out.append(this.indent == null ? ":" : ": ");
            replaceTop(Scope.NONEMPTY_OBJECT);
        } else if (peek != Scope.NULL) {
            throw new JSONException("Nesting problem");
        }
    }

    private void newline() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || this.indent == null) {
            return;
        }
        this.out.append(StringUtils.LF);
        for (int i2 = 0; i2 < this.stack.size(); i2++) {
            this.out.append(this.indent);
        }
    }

    private Scope peek() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            if (!this.stack.isEmpty()) {
                List<Scope> list = this.stack;
                return list.get(list.size() - 1);
            }
            throw new JSONException("Nesting problem");
        }
        return (Scope) invokeV.objValue;
    }

    private void replaceTop(Scope scope) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, this, scope) == null) {
            List<Scope> list = this.stack;
            list.set(list.size() - 1, scope);
        }
    }

    private void string(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, str) == null) {
            this.out.append("\"");
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\f') {
                    this.out.append("\\f");
                } else if (charAt == '\r') {
                    this.out.append("\\r");
                } else if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                    switch (charAt) {
                        case '\b':
                            this.out.append("\\b");
                            continue;
                        case '\t':
                            this.out.append("\\t");
                            continue;
                        case '\n':
                            this.out.append("\\n");
                            continue;
                        default:
                            if (charAt <= 31) {
                                this.out.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                                continue;
                            } else {
                                this.out.append(charAt);
                                break;
                            }
                    }
                } else {
                    StringBuilder sb = this.out;
                    sb.append(FileUtil.WINDOWS_SEPARATOR);
                    sb.append(charAt);
                }
            }
            this.out.append("\"");
        }
    }

    public JSONStringer array() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? open(Scope.EMPTY_ARRAY, PreferencesUtil.LEFT_MOUNT) : (JSONStringer) invokeV.objValue;
    }

    public JSONStringer close(Scope scope, Scope scope2, String str) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, scope, scope2, str)) == null) {
            Scope peek = peek();
            if (peek != scope2 && peek != scope) {
                throw new JSONException("Nesting problem");
            }
            List<Scope> list = this.stack;
            list.remove(list.size() - 1);
            if (peek == scope2) {
                newline();
            }
            this.out.append(str);
            return this;
        }
        return (JSONStringer) invokeLLL.objValue;
    }

    public JSONStringer endArray() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? close(Scope.EMPTY_ARRAY, Scope.NONEMPTY_ARRAY, PreferencesUtil.RIGHT_MOUNT) : (JSONStringer) invokeV.objValue;
    }

    public JSONStringer endObject() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? close(Scope.EMPTY_OBJECT, Scope.NONEMPTY_OBJECT, "}") : (JSONStringer) invokeV.objValue;
    }

    public JSONStringer key(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                beforeKey();
                string(str);
                return this;
            }
            throw new JSONException("Names must be non-null");
        }
        return (JSONStringer) invokeL.objValue;
    }

    public JSONStringer object() throws JSONException {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? open(Scope.EMPTY_OBJECT, "{") : (JSONStringer) invokeV.objValue;
    }

    public JSONStringer open(Scope scope, String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, scope, str)) == null) {
            if (this.stack.isEmpty() && this.out.length() > 0) {
                throw new JSONException("Nesting problem: multiple top-level roots");
            }
            beforeValue();
            this.stack.add(scope);
            this.out.append(str);
            return this;
        }
        return (JSONStringer) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (this.out.length() == 0) {
                return null;
            }
            return this.out.toString();
        }
        return (String) invokeV.objValue;
    }

    public JSONStringer value(Object obj) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
            if (!this.stack.isEmpty()) {
                if (obj instanceof JSONArray) {
                    ((JSONArray) obj).writeTo(this);
                    return this;
                } else if (obj instanceof JSONObject) {
                    ((JSONObject) obj).writeTo(this);
                    return this;
                } else {
                    beforeValue();
                    if (obj != null && !(obj instanceof Boolean) && obj != JSONObject.NULL) {
                        if (obj instanceof Number) {
                            this.out.append(JSONObject.numberToString((Number) obj));
                        } else {
                            string(obj.toString());
                        }
                    } else {
                        this.out.append(obj);
                    }
                    return this;
                }
            }
            throw new JSONException("Nesting problem");
        }
        return (JSONStringer) invokeL.objValue;
    }

    public JSONStringer(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.out = new StringBuilder();
        this.stack = new ArrayList();
        char[] cArr = new char[i2];
        Arrays.fill(cArr, (char) WebvttCueParser.CHAR_SPACE);
        this.indent = new String(cArr);
    }

    public JSONStringer value(boolean z) throws JSONException {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048587, this, z)) == null) {
            if (!this.stack.isEmpty()) {
                beforeValue();
                this.out.append(z);
                return this;
            }
            throw new JSONException("Nesting problem");
        }
        return (JSONStringer) invokeZ.objValue;
    }

    public JSONStringer value(double d2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Double.valueOf(d2)})) == null) {
            if (!this.stack.isEmpty()) {
                beforeValue();
                this.out.append(JSONObject.numberToString(Double.valueOf(d2)));
                return this;
            }
            throw new JSONException("Nesting problem");
        }
        return (JSONStringer) invokeCommon.objValue;
    }

    public JSONStringer value(long j2) throws JSONException {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            if (!this.stack.isEmpty()) {
                beforeValue();
                this.out.append(j2);
                return this;
            }
            throw new JSONException("Nesting problem");
        }
        return (JSONStringer) invokeJ.objValue;
    }
}
