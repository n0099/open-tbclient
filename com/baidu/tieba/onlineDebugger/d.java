package com.baidu.tieba.onlineDebugger;

import android.content.Context;
import android.util.SparseArray;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.onlineDebugger.command.h;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class d {
    public static final Class<?> nB(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static final Object a(Method method, Object obj, String[] strArr) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Object[] objArr;
        Class<?>[] parameterTypes = method.getParameterTypes();
        if (strArr == null) {
            objArr = null;
        } else {
            objArr = new Object[strArr.length];
        }
        if (objArr != null && objArr.length > 0) {
            for (int i = 0; i < objArr.length; i++) {
                objArr[i] = c(strArr[i], parameterTypes[i]);
            }
        }
        return method.invoke(obj, objArr);
    }

    public static final void a(Field field, Object obj, String str) throws IllegalArgumentException, IllegalAccessException {
        field.set(obj, c(str, field.getType()));
    }

    public static final Object c(String str, Class<?> cls) {
        h nT;
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.startsWith("$") && (nT = com.baidu.tieba.onlineDebugger.e.b.nT("get " + trim)) != null) {
            try {
                return nT.aIQ();
            } catch (Exception e) {
                return null;
            }
        } else if (cls == Boolean.TYPE || cls == Boolean.class) {
            if ("true".equals(trim)) {
                return true;
            }
            if ("false".equals(trim)) {
                return false;
            }
            byte parseByte = Byte.parseByte(trim);
            if (parseByte == 0) {
                return true;
            }
            return parseByte == 1 ? false : null;
        } else if (cls == Byte.TYPE || cls == Byte.class) {
            return Byte.valueOf(Byte.parseByte(trim));
        } else {
            if (cls == Short.TYPE || cls == Short.class) {
                return Short.valueOf(Short.parseShort(trim));
            }
            if (cls == Character.TYPE || cls == Character.class) {
                if (trim.length() == 1) {
                    return Character.valueOf(trim.charAt(0));
                }
                return null;
            } else if (cls == Integer.TYPE || cls == Integer.class) {
                return Integer.valueOf(Integer.parseInt(trim));
            } else {
                if (cls == Long.TYPE || cls == Long.class) {
                    return Long.valueOf(Long.parseLong(trim));
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return Float.valueOf(Float.parseFloat(trim));
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return Double.valueOf(Double.parseDouble(trim));
                }
                if (cls == StringBuilder.class) {
                    return new StringBuilder(trim);
                }
                if (cls == StringBuffer.class) {
                    return new StringBuffer(trim);
                }
                if (cls == Date.class) {
                    return new Date(Long.parseLong(trim));
                }
                if (cls == Calendar.class) {
                    long parseLong = Long.parseLong(trim);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(parseLong);
                    return calendar;
                }
                if (cls != String.class && cls != CharSequence.class) {
                    if (cls == char[].class) {
                        return trim.toCharArray();
                    }
                    if (cls == byte[].class) {
                        try {
                            return trim.getBytes("UTF-8");
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                            return null;
                        }
                    } else if (cls == Object.class) {
                        return trim;
                    } else {
                        if (cls == Context.class) {
                            return TbadkCoreApplication.m9getInst().getApplicationContext();
                        }
                        return null;
                    }
                }
                return trim;
            }
        }
    }

    public static String X(Object obj) {
        StringBuilder sb = new StringBuilder();
        if (obj instanceof List) {
            sb.append('[');
            for (Object obj2 : (List) obj) {
                sb.append(X(obj2));
                sb.append('\n');
            }
            sb.append(']');
        }
        if (obj.getClass().isArray()) {
            sb.append('[');
            for (Object obj3 : (Object[]) obj) {
                sb.append(X(obj3));
                sb.append('\n');
            }
            sb.append(']');
        }
        if (obj instanceof Set) {
            sb.append('(');
            for (Object obj4 : (Set) obj) {
                sb.append(X(obj4));
                sb.append('\n');
            }
            sb.append(')');
        }
        if (obj instanceof Map) {
            sb.append('{');
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                sb.append(X(entry.getKey()));
                sb.append(':');
                sb.append(X(entry.getValue()));
                sb.append('\n');
            }
            sb.append('}');
        }
        if (obj instanceof SparseArray) {
            SparseArray sparseArray = (SparseArray) obj;
            sb.append("{[");
            for (int i = 0; i < sparseArray.size(); i++) {
                int keyAt = sparseArray.keyAt(i);
                Object obj5 = sparseArray.get(keyAt);
                sb.append(keyAt);
                sb.append(':');
                sb.append(X(obj5));
                sb.append('\n');
            }
            sb.append("]}");
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return obj.toString();
    }
}
