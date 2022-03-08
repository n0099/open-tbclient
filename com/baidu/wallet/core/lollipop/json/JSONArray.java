package com.baidu.wallet.core.lollipop.json;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.core.lollipop.json.JSONStringer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes6.dex */
public class JSONArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Object> values;

    public JSONArray() {
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
        this.values = new ArrayList();
    }

    public void checkedPut(Object obj) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
            if (obj instanceof Number) {
                JSON.checkDouble(((Number) obj).doubleValue());
            }
            put(obj);
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? (obj instanceof JSONArray) && ((JSONArray) obj).values.equals(this.values) : invokeL.booleanValue;
    }

    public Object get(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            try {
                Object obj = this.values.get(i2);
                if (obj != null) {
                    return obj;
                }
                throw new JSONException("Value at " + i2 + " is null.");
            } catch (IndexOutOfBoundsException unused) {
                throw new JSONException("Index " + i2 + " out of range [0.." + this.values.size() + SmallTailInfo.EMOTION_SUFFIX);
            }
        }
        return invokeI.objValue;
    }

    public boolean getBoolean(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            Object obj = get(i2);
            Boolean bool = JSON.toBoolean(obj);
            if (bool != null) {
                return bool.booleanValue();
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "boolean");
        }
        return invokeI.booleanValue;
    }

    public double getDouble(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            Object obj = get(i2);
            Double d2 = JSON.toDouble(obj);
            if (d2 != null) {
                return d2.doubleValue();
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "double");
        }
        return invokeI.doubleValue;
    }

    public int getInt(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
            Object obj = get(i2);
            Integer integer = JSON.toInteger(obj);
            if (integer != null) {
                return integer.intValue();
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "int");
        }
        return invokeI.intValue;
    }

    public JSONArray getJSONArray(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            Object obj = get(i2);
            if (obj instanceof JSONArray) {
                return (JSONArray) obj;
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "JSONArray");
        }
        return (JSONArray) invokeI.objValue;
    }

    public JSONObject getJSONObject(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            Object obj = get(i2);
            if (obj instanceof JSONObject) {
                return (JSONObject) obj;
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "JSONObject");
        }
        return (JSONObject) invokeI.objValue;
    }

    public long getLong(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            Object obj = get(i2);
            Long l = JSON.toLong(obj);
            if (l != null) {
                return l.longValue();
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "long");
        }
        return invokeI.longValue;
    }

    public String getString(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i2)) == null) {
            Object obj = get(i2);
            String json = JSON.toString(obj);
            if (json != null) {
                return json;
            }
            throw JSON.typeMismatch(Integer.valueOf(i2), obj, "String");
        }
        return (String) invokeI.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.values.hashCode() : invokeV.intValue;
    }

    public boolean isNull(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            Object opt = opt(i2);
            return opt == null || opt == JSONObject.NULL;
        }
        return invokeI.booleanValue;
    }

    public String join(String str) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) {
            JSONStringer jSONStringer = new JSONStringer();
            jSONStringer.open(JSONStringer.Scope.NULL, "");
            int size = this.values.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 > 0) {
                    jSONStringer.out.append(str);
                }
                jSONStringer.value(this.values.get(i2));
            }
            JSONStringer.Scope scope = JSONStringer.Scope.NULL;
            jSONStringer.close(scope, scope, "");
            return jSONStringer.out.toString();
        }
        return (String) invokeL.objValue;
    }

    public int length() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.values.size() : invokeV.intValue;
    }

    public Object opt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.values.size()) {
                return null;
            }
            return this.values.get(i2);
        }
        return invokeI.objValue;
    }

    public boolean optBoolean(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) ? optBoolean(i2, false) : invokeI.booleanValue;
    }

    public double optDouble(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) ? optDouble(i2, Double.NaN) : invokeI.doubleValue;
    }

    public int optInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) ? optInt(i2, 0) : invokeI.intValue;
    }

    public JSONArray optJSONArray(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) {
            Object opt = opt(i2);
            if (opt instanceof JSONArray) {
                return (JSONArray) opt;
            }
            return null;
        }
        return (JSONArray) invokeI.objValue;
    }

    public JSONObject optJSONObject(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i2)) == null) {
            Object opt = opt(i2);
            if (opt instanceof JSONObject) {
                return (JSONObject) opt;
            }
            return null;
        }
        return (JSONObject) invokeI.objValue;
    }

    public long optLong(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) ? optLong(i2, 0L) : invokeI.longValue;
    }

    public String optString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? optString(i2, "") : (String) invokeI.objValue;
    }

    public JSONArray put(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048612, this, z)) == null) {
            this.values.add(Boolean.valueOf(z));
            return this;
        }
        return (JSONArray) invokeZ.objValue;
    }

    public Object remove(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048613, this, i2)) == null) {
            if (i2 < 0 || i2 >= this.values.size()) {
                return null;
            }
            return this.values.remove(i2);
        }
        return invokeI.objValue;
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, jSONArray)) == null) {
            JSONObject jSONObject = new JSONObject();
            int min = Math.min(jSONArray.length(), this.values.size());
            if (min == 0) {
                return null;
            }
            for (int i2 = 0; i2 < min; i2++) {
                jSONObject.put(JSON.toString(jSONArray.opt(i2)), opt(i2));
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            try {
                JSONStringer jSONStringer = new JSONStringer();
                writeTo(jSONStringer);
                return jSONStringer.toString();
            } catch (JSONException unused) {
                return null;
            }
        }
        return (String) invokeV.objValue;
    }

    public void writeTo(JSONStringer jSONStringer) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, jSONStringer) == null) {
            jSONStringer.array();
            for (Object obj : this.values) {
                jSONStringer.value(obj);
            }
            jSONStringer.endArray();
        }
    }

    public boolean optBoolean(int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            Boolean bool = JSON.toBoolean(opt(i2));
            return bool != null ? bool.booleanValue() : z;
        }
        return invokeCommon.booleanValue;
    }

    public double optDouble(int i2, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) {
            Double d3 = JSON.toDouble(opt(i2));
            return d3 != null ? d3.doubleValue() : d2;
        }
        return invokeCommon.doubleValue;
    }

    public int optInt(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            Integer integer = JSON.toInteger(opt(i2));
            return integer != null ? integer.intValue() : i3;
        }
        return invokeII.intValue;
    }

    public long optLong(int i2, long j2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) {
            Long l = JSON.toLong(opt(i2));
            return l != null ? l.longValue() : j2;
        }
        return invokeCommon.longValue;
    }

    public String optString(int i2, String str) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i2, str)) == null) {
            String json = JSON.toString(opt(i2));
            return json != null ? json : str;
        }
        return (String) invokeIL.objValue;
    }

    public JSONArray put(double d2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Double.valueOf(d2)})) == null) {
            this.values.add(Double.valueOf(JSON.checkDouble(d2)));
            return this;
        }
        return (JSONArray) invokeCommon.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONArray(Collection collection) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (collection != null) {
            for (Object obj : collection) {
                put(JSONObject.wrap(obj));
            }
        }
    }

    public JSONArray put(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048604, this, i2)) == null) {
            this.values.add(Integer.valueOf(i2));
            return this;
        }
        return (JSONArray) invokeI.objValue;
    }

    public JSONArray put(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048610, this, j2)) == null) {
            this.values.add(Long.valueOf(j2));
            return this;
        }
        return (JSONArray) invokeJ.objValue;
    }

    public String toString(int i2) throws JSONException {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048616, this, i2)) == null) {
            JSONStringer jSONStringer = new JSONStringer(i2);
            writeTo(jSONStringer);
            return jSONStringer.toString();
        }
        return (String) invokeI.objValue;
    }

    public JSONArray put(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, obj)) == null) {
            this.values.add(obj);
            return this;
        }
        return (JSONArray) invokeL.objValue;
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {jSONTokener};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONArray) {
            this.values = ((JSONArray) nextValue).values;
            return;
        }
        throw JSON.typeMismatch(nextValue, "JSONArray");
    }

    public JSONArray put(int i2, boolean z) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)})) == null) ? put(i2, Boolean.valueOf(z)) : (JSONArray) invokeCommon.objValue;
    }

    public JSONArray put(int i2, double d2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), Double.valueOf(d2)})) == null) ? put(i2, Double.valueOf(d2)) : (JSONArray) invokeCommon.objValue;
    }

    public JSONArray put(int i2, int i3) throws JSONException {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048606, this, i2, i3)) == null) ? put(i2, Integer.valueOf(i3)) : (JSONArray) invokeII.objValue;
    }

    public JSONArray put(int i2, long j2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048607, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j2)})) == null) ? put(i2, Long.valueOf(j2)) : (JSONArray) invokeCommon.objValue;
    }

    public JSONArray put(int i2, Object obj) throws JSONException {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048608, this, i2, obj)) == null) {
            if (obj instanceof Number) {
                JSON.checkDouble(((Number) obj).doubleValue());
            }
            while (this.values.size() <= i2) {
                this.values.add(null);
            }
            this.values.set(i2, obj);
            return this;
        }
        return (JSONArray) invokeIL.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this((JSONTokener) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
    }

    public JSONArray(Object obj) throws JSONException {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {obj};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.values = new ArrayList(length);
            for (int i4 = 0; i4 < length; i4++) {
                put(JSONObject.wrap(Array.get(obj, i4)));
            }
            return;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }
}
