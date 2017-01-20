package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.h;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public class c implements b {
    private String ebE;
    private String[] ebF;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object Y(Object obj) {
        Class<?> cls;
        boolean z;
        Class<?>[] parameterTypes;
        List<Method> l;
        if (obj != null) {
            if (obj instanceof Class) {
                cls = (Class) obj;
                z = true;
            } else {
                cls = obj.getClass();
                z = false;
            }
            List<Method> l2 = com.baidu.adp.lib.OrmObject.a.a.l(cls);
            if (z && (l = com.baidu.adp.lib.OrmObject.a.a.l(Class.class)) != null) {
                l2.addAll(l);
            }
            if (l2 != null && l2.size() > 0) {
                ArrayList<Method> arrayList = new ArrayList();
                for (Method method : l2) {
                    if (method != null && method.getName().equals(this.ebE) && (parameterTypes = method.getParameterTypes()) != null) {
                        if (parameterTypes.length == 0) {
                            if (this.ebF == null || this.ebF.length == 0) {
                                arrayList.add(method);
                            }
                        } else if (this.ebF != null && this.ebF.length == parameterTypes.length) {
                            arrayList.add(method);
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    throw new RuntimeException("method not find:" + this.ebE + " for class " + cls.getName());
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
                    throw new RuntimeException("method not find:" + this.ebE + " for class " + cls.getName());
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
            throw new RuntimeException("method not find:" + this.ebE + " for class " + cls.getName());
        }
        return null;
    }

    private Object b(Method method, Object obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        h hVar;
        Object obj2;
        String[] strArr = this.ebF;
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
                                hVar = com.baidu.tieba.onlineDebugger.e.b.nT("get " + str);
                            } catch (Exception e) {
                                hVar = null;
                            }
                            if (hVar != null) {
                                try {
                                    obj2 = hVar.aIQ();
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
        BdLog.e(String.valueOf(obj.toString()) + " before invokeMethod " + this.ebE + " params " + (strArr2 != null ? Arrays.toString(strArr2) : "null"));
        Object a = com.baidu.tieba.onlineDebugger.d.a(method, obj, strArr2);
        BdLog.e(String.valueOf(obj.toString()) + " after invokeMethod " + this.ebE + " params " + (strArr2 != null ? Arrays.toString(strArr2) : "null") + " , result = " + (a != null ? a.toString() : "null"));
        return a;
    }

    public void nD(String str) {
        this.ebE = str;
    }

    public void z(String[] strArr) {
        this.ebF = strArr;
    }
}
