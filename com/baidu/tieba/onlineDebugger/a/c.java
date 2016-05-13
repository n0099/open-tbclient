package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class c implements b {
    private String dbr;
    private String[] dbs;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object L(Object obj) {
        Class<?> cls;
        boolean z;
        Class<?>[] parameterTypes;
        List<Method> d;
        if (obj != null) {
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            List<Method> d2 = com.baidu.adp.lib.a.a.a.d(cls);
            if (z && (d = com.baidu.adp.lib.a.a.a.d(Class.class)) != null) {
                d2.addAll(d);
            }
            if (d2 != null && d2.size() > 0) {
                ArrayList<Method> arrayList = new ArrayList();
                for (Method method : d2) {
                    if (method != null && method.getName().equals(this.dbr) && (parameterTypes = method.getParameterTypes()) != null) {
                        if (parameterTypes.length == 0) {
                            if (this.dbs == null || this.dbs.length == 0) {
                                arrayList.add(method);
                            }
                        } else if (this.dbs != null && this.dbs.length == parameterTypes.length) {
                            arrayList.add(method);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    throw new RuntimeException("method not find:" + this.dbr + " for class " + cls.getName());
                }
                if (arrayList.size() == 1) {
                    Method method2 = (Method) arrayList.get(0);
                    if (method2 != null) {
                        try {
                            return b(method2, obj);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        } catch (IllegalArgumentException e2) {
                            throw new RuntimeException(e2);
                        } catch (InvocationTargetException e3) {
                            throw new RuntimeException(e3);
                        } catch (Throwable th) {
                            throw new RuntimeException(th);
                        }
                    }
                    throw new RuntimeException("method not find:" + this.dbr + " for class " + cls.getName());
                }
                Exception exc = null;
                for (Method method3 : arrayList) {
                    if (method3 != null) {
                        try {
                            return b(method3, obj);
                        } catch (Exception e4) {
                            exc = e4;
                        }
                    }
                }
                throw new RuntimeException(exc);
            }
            throw new RuntimeException("method not find:" + this.dbr + " for class " + cls.getName());
        }
        return null;
    }

    private Object b(Method method, Object obj) {
        com.baidu.tieba.onlineDebugger.command.d dVar;
        Object obj2;
        String[] strArr = this.dbs;
        String[] strArr2 = (strArr == null || strArr.length != 0) ? strArr : null;
        if (strArr2 != null && strArr2.length > 0) {
            for (int i = 0; i < strArr2.length; i++) {
                String str = strArr2[i];
                if (str != null) {
                    if (str.startsWith("$")) {
                        strArr2[i] = str;
                    } else {
                        if (str.contains(".") || (str.contains("(") && str.contains(")"))) {
                            try {
                                dVar = com.baidu.tieba.onlineDebugger.e.b.lE("get " + str);
                            } catch (Exception e) {
                                dVar = null;
                            }
                            if (dVar != null) {
                                try {
                                    obj2 = dVar.auA();
                                } catch (Exception e2) {
                                    obj2 = null;
                                }
                                if (obj2 != null) {
                                    str = obj2.toString();
                                }
                            }
                        }
                        strArr2[i] = str;
                    }
                }
            }
        }
        if (!method.isAccessible()) {
            method.setAccessible(true);
        }
        BdLog.e(String.valueOf(obj.toString()) + " before invokeMethod " + this.dbr + " params " + (strArr2 != null ? Arrays.toString(strArr2) : "null"));
        Object a = com.baidu.tieba.onlineDebugger.c.a(method, obj, strArr2);
        BdLog.e(String.valueOf(obj.toString()) + " after invokeMethod " + this.dbr + " params " + (strArr2 != null ? Arrays.toString(strArr2) : "null") + " , result = " + (a != null ? a.toString() : "null"));
        return a;
    }

    public void lq(String str) {
        this.dbr = str;
    }

    public void B(String[] strArr) {
        this.dbs = strArr;
    }
}
