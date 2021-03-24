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

    public Object get(int i) throws JSONException {
        try {
            Object obj = this.values.get(i);
            if (obj != null) {
                return obj;
            }
            throw new JSONException("Value at " + i + " is null.");
        } catch (IndexOutOfBoundsException unused) {
            throw new JSONException("Index " + i + " out of range [0.." + this.values.size() + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public boolean getBoolean(int i) throws JSONException {
        Object obj = get(i);
        Boolean bool = JSON.toBoolean(obj);
        if (bool != null) {
            return bool.booleanValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "boolean");
    }

    public double getDouble(int i) throws JSONException {
        Object obj = get(i);
        Double d2 = JSON.toDouble(obj);
        if (d2 != null) {
            return d2.doubleValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "double");
    }

    public int getInt(int i) throws JSONException {
        Object obj = get(i);
        Integer integer = JSON.toInteger(obj);
        if (integer != null) {
            return integer.intValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "int");
    }

    public JSONArray getJSONArray(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONArray) {
            return (JSONArray) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "JSONArray");
    }

    public JSONObject getJSONObject(int i) throws JSONException {
        Object obj = get(i);
        if (obj instanceof JSONObject) {
            return (JSONObject) obj;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "JSONObject");
    }

    public long getLong(int i) throws JSONException {
        Object obj = get(i);
        Long l = JSON.toLong(obj);
        if (l != null) {
            return l.longValue();
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "long");
    }

    public String getString(int i) throws JSONException {
        Object obj = get(i);
        String json = JSON.toString(obj);
        if (json != null) {
            return json;
        }
        throw JSON.typeMismatch(Integer.valueOf(i), obj, "String");
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public boolean isNull(int i) {
        Object opt = opt(i);
        return opt == null || opt == JSONObject.NULL;
    }

    public String join(String str) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer();
        jSONStringer.open(JSONStringer.Scope.NULL, "");
        int size = this.values.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                jSONStringer.out.append(str);
            }
            jSONStringer.value(this.values.get(i));
        }
        JSONStringer.Scope scope = JSONStringer.Scope.NULL;
        jSONStringer.close(scope, scope, "");
        return jSONStringer.out.toString();
    }

    public int length() {
        return this.values.size();
    }

    public Object opt(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.get(i);
    }

    public boolean optBoolean(int i) {
        return optBoolean(i, false);
    }

    public double optDouble(int i) {
        return optDouble(i, Double.NaN);
    }

    public int optInt(int i) {
        return optInt(i, 0);
    }

    public JSONArray optJSONArray(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONArray) {
            return (JSONArray) opt;
        }
        return null;
    }

    public JSONObject optJSONObject(int i) {
        Object opt = opt(i);
        if (opt instanceof JSONObject) {
            return (JSONObject) opt;
        }
        return null;
    }

    public long optLong(int i) {
        return optLong(i, 0L);
    }

    public String optString(int i) {
        return optString(i, "");
    }

    public JSONArray put(boolean z) {
        this.values.add(Boolean.valueOf(z));
        return this;
    }

    public Object remove(int i) {
        if (i < 0 || i >= this.values.size()) {
            return null;
        }
        return this.values.remove(i);
    }

    public JSONObject toJSONObject(JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        int min = Math.min(jSONArray.length(), this.values.size());
        if (min == 0) {
            return null;
        }
        for (int i = 0; i < min; i++) {
            jSONObject.put(JSON.toString(jSONArray.opt(i)), opt(i));
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

    public boolean optBoolean(int i, boolean z) {
        Boolean bool = JSON.toBoolean(opt(i));
        return bool != null ? bool.booleanValue() : z;
    }

    public double optDouble(int i, double d2) {
        Double d3 = JSON.toDouble(opt(i));
        return d3 != null ? d3.doubleValue() : d2;
    }

    public int optInt(int i, int i2) {
        Integer integer = JSON.toInteger(opt(i));
        return integer != null ? integer.intValue() : i2;
    }

    public long optLong(int i, long j) {
        Long l = JSON.toLong(opt(i));
        return l != null ? l.longValue() : j;
    }

    public String optString(int i, String str) {
        String json = JSON.toString(opt(i));
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

    public JSONArray put(int i) {
        this.values.add(Integer.valueOf(i));
        return this;
    }

    public JSONArray put(long j) {
        this.values.add(Long.valueOf(j));
        return this;
    }

    public String toString(int i) throws JSONException {
        JSONStringer jSONStringer = new JSONStringer(i);
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

    public JSONArray put(int i, boolean z) throws JSONException {
        return put(i, Boolean.valueOf(z));
    }

    public JSONArray put(int i, double d2) throws JSONException {
        return put(i, Double.valueOf(d2));
    }

    public JSONArray put(int i, int i2) throws JSONException {
        return put(i, Integer.valueOf(i2));
    }

    public JSONArray put(int i, long j) throws JSONException {
        return put(i, Long.valueOf(j));
    }

    public JSONArray put(int i, Object obj) throws JSONException {
        if (obj instanceof Number) {
            JSON.checkDouble(((Number) obj).doubleValue());
        }
        while (this.values.size() <= i) {
            this.values.add(null);
        }
        this.values.set(i, obj);
        return this;
    }

    public JSONArray(String str) throws JSONException {
        this(new JSONTokener(str));
    }

    public JSONArray(Object obj) throws JSONException {
        if (obj.getClass().isArray()) {
            int length = Array.getLength(obj);
            this.values = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                put(JSONObject.wrap(Array.get(obj, i)));
            }
            return;
        }
        throw new JSONException("Not a primitive array: " + obj.getClass());
    }
}
