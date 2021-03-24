package com.baidu.wallet.core.lollipop.json;
/* loaded from: classes5.dex */
public class JSON {
    public static double checkDouble(double d2) throws JSONException {
        if (Double.isInfinite(d2) || Double.isNaN(d2)) {
            throw new JSONException("Forbidden numeric value: " + d2);
        }
        return d2;
    }

    public static Boolean toBoolean(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if ("true".equalsIgnoreCase(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str)) {
                return Boolean.FALSE;
            }
            return null;
        }
        return null;
    }

    public static Double toDouble(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static Integer toInteger(Object obj) {
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            try {
                return Integer.valueOf((int) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static Long toLong(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf((long) Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    public static String toString(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj != null) {
            return String.valueOf(obj);
        }
        return null;
    }

    public static JSONException typeMismatch(Object obj, Object obj2, String str) throws JSONException {
        if (obj2 == null) {
            throw new JSONException("Value at " + obj + " is null.");
        }
        throw new JSONException("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
    }

    public static JSONException typeMismatch(Object obj, String str) throws JSONException {
        if (obj == null) {
            throw new JSONException("Value is null.");
        }
        throw new JSONException("Value " + obj + " of type " + obj.getClass().getName() + " cannot be converted to " + str);
    }
}
