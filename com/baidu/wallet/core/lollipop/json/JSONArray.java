package com.baidu.wallet.core.lollipop.json;

import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.wallet.core.lollipop.json.JSONStringer;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes5.dex */
public class JSONArray {
    public final List<Object> values;

    public JSONArray() {
        this.values = new ArrayList();
    }

    public void checkedPut(Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        put(obj);
    }

    public boolean equals(Object obj) {
        return (obj instanceof JSONArray) && ((JSONArray) obj).values.equals(this.values);
    }

    public Object get(int i2) throws JSONException {
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

    public boolean getBoolean(int i2) throws JSONException {
        Object obj = get(i2);
        Boolean bool = JSON.toBoolean(obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "boolean");
    }

    public double getDouble(int i2) throws JSONException {
        Object obj = get(i2);
        Double d2 = JSON.toDouble(obj);
        if (d2 != null) {
            return d2.doubleValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "double");
    }

    public int getInt(int i2) throws JSONException {
        Object obj = get(i2);
        Integer integer = JSON.toInteger(obj);
        if (integer != null) {
            return integer.intValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "int");
    }

    public JSONArray getJSONArray(int i2) throws JSONException {
        Object obj = get(i2);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "JSONArray");
    }

    public JSONObject getJSONObject(int i2) throws JSONException {
        Object obj = get(i2);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "JSONObject");
    }

    public long getLong(int i2) throws JSONException {
        Object obj = get(i2);
        Long l = JSON.toLong(obj);
        if (l != null) {
            return l.longValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "long");
    }

    public String getString(int i2) throws JSONException {
        Object obj = get(i2);
        String json = JSON.toString(obj);
        if (json != null) {
            return json;
        }
        throw JSON.typeMismatch(Integer.valueOf(i2), obj, "String");
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public boolean isNull(int i2) {
        Object opt = opt(i2);
        return opt == null || opt == JSONObject.NULL;
    }

    public String join(String str) throws JSONException {
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

    public int length() {
        return this.values.size();
    }

    public Object opt(int i2) {
        if (i2 < 0 || i2 >= this.values.size()) {
            return null;
        }
        return this.values.get(i2);
    }

    public boolean optBoolean(int i2) {
        return optBoolean(i2, false);
    }

    public double optDouble(int i2) {
        return optDouble(i2, Double.NaN);
    }

    public int optInt(int i2) {
        return optInt(i2, 0);
    }

    public JSONArray optJSONArray(int i2) {
        Object opt = opt(i2);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(int i2) {
        Object opt = opt(i2);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(int i2) {
        return optLong(i2, 0L);
    }

    public String optString(int i2) {
        return optString(i2, "");
    }

    public JSONArray put(boolean z) {
        this.values.add(Boolean.valueOf(z));
        return this;
    }

    public Object remove(int i2) {
        if (i2 < 0 || i2 >= this.values.size()) {
            return null;
        }
        return this.values.remove(i2);
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
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

    public String toString() {
        try {
            JSONStringer jSONStringer = new JSONStringer();
            writeTo(jSONStringer);
            return jSONStringer.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public void writeTo(JSONStringer jSONStringer) throws JSONException {
        jSONStringer.array();
        for (Object obj : this.values) {
            jSONStringer.value(obj);
        }
        jSONStringer.endArray();
    }

    public boolean optBoolean(int i2, boolean z) {
        Boolean bool = JSON.toBoolean(opt(i2));
        return bool != null ? bool.booleanValue() : z;
    }

    public double optDouble(int i2, double d2) {
        Double d3 = JSON.toDouble(opt(i2));
        return d3 != null ? d3.doubleValue() : d2;
    }

    public int optInt(int i2, int i3) {
        Integer integer = JSON.toInteger(opt(i2));
        return integer != null ? integer.intValue() : i3;
    }

    public long optLong(int i2, long j) {
        Long l = JSON.toLong(opt(i2));
        return l != null ? l.longValue() : j;
    }

    public String optString(int i2, String str) {
        String json = JSON.toString(opt(i2));
        return json != null ? json : str;
    }

    public JSONArray put(double d2) throws JSONException {
        this.values.add(Double.valueOf(JSON.checkDouble(d2)));
        return this;
    }

    public JSONArray(Collection collection) {
        this();
        if (collection != null) {
            for (Object obj : collection) {
                put(JSONObject.wrap(obj));
            }
        }
    }

    public JSONArray put(int i2) {
        this.values.add(Integer.valueOf(i2));
        return this;
    }

    public JSONArray put(long j) {
        this.values.add(Long.valueOf(j));
        return this;
    }

    public String toString(int i2) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer(i2);
        writeTo(jSONStringer);
        return jSONStringer.toString();
    }

    public JSONArray put(Object obj) {
        this.values.add(obj);
        return this;
    }

    public JSONArray(JSONTokener jSONTokener) throws JSONException {
        Object nextValue = jSONTokener.nextValue();
        if (nextValue instanceof JSONArray) {
            this.values = ((JSONArray) nextValue).values;
            return;
        }
        throw JSON.typeMismatch(nextValue, "JSONArray");
    }

    public JSONArray put(int i2, boolean z) throws JSONException {
        return put(i2, Boolean.valueOf(z));
    }

    public JSONArray put(int i2, double d2) throws JSONException {
        return put(i2, Double.valueOf(d2));
    }

    public JSONArray put(int i2, int i3) throws JSONException {
        return put(i2, Integer.valueOf(i3));
    }

    public JSONArray put(int i2, long j) throws JSONException {
        return put(i2, Long.valueOf(j));
    }

    public JSONArray put(int i2, Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        while (this.values.size() <= i2) {
            this.values.add(null);
        }
        this.values.set(i2, obj);
        return this;
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Object obj) throws JSONException {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.values = new ArrayList(length);
            for (int i2 = 0; i2 < length; i2++) {
                put(JSONObject.wrap(Array.get(obj, i2)));
            }
            return;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }
}
