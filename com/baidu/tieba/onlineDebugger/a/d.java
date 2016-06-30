package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.h;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class d implements b {
    private String dHZ;
    private String fieldName;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object N(Object obj) {
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
                    if (this.dHZ.contains(".") || (this.dHZ.contains("(") && this.dHZ.contains(")"))) {
                        h nf = com.baidu.tieba.onlineDebugger.e.b.nf("get " + this.dHZ);
                        if (nf != null) {
                            Object aCF = nf.aCF();
                            if (aCF != null) {
                                str = aCF.toString();
                            }
                        } else {
                            str = this.dHZ;
                        }
                    } else {
                        str = this.dHZ;
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

    public void mO(String str) {
        this.fieldName = str;
    }

    public void mQ(String str) {
        this.dHZ = str;
    }
}
