package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.h;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class d implements b {
    private String dSN;
    private String fieldName;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object V(Object obj) {
        Field b;
        String str = null;
        if (obj != null) {
            if (obj instanceof Class) {
                b = com.baidu.adp.lib.a.a.a.b((Class) obj, this.fieldName);
            } else {
                b = com.baidu.adp.lib.a.a.a.b(obj.getClass(), this.fieldName);
            }
            if (b != null) {
                try {
                    if (!b.isAccessible()) {
                        b.setAccessible(true);
                    }
                    if (this.dSN.contains(".") || (this.dSN.contains("(") && this.dSN.contains(")"))) {
                        h nC = com.baidu.tieba.onlineDebugger.e.b.nC("get " + this.dSN);
                        if (nC != null) {
                            Object aHc = nC.aHc();
                            if (aHc != null) {
                                str = aHc.toString();
                            }
                        } else {
                            str = this.dSN;
                        }
                    } else {
                        str = this.dSN;
                    }
                    BdLog.e(String.valueOf(obj.toString()) + " before setField " + this.fieldName + " value = " + (str == null ? "null" : str.toString()));
                    com.baidu.tieba.onlineDebugger.d.a(b, obj, str);
                    Object obj2 = b.get(obj);
                    BdLog.e(String.valueOf(obj.toString()) + " after setField " + this.fieldName + " success value = " + (obj2 == null ? "null" : obj2.toString()));
                    return true;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (IllegalArgumentException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    throw new RuntimeException(th);
                }
            }
            throw new RuntimeException("field not find:" + this.fieldName + " for class " + ((Class) obj).getName());
        }
        return null;
    }

    public void nl(String str) {
        this.fieldName = str;
    }

    public void nn(String str) {
        this.dSN = str;
    }
}
