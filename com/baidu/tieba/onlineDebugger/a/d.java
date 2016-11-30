package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.h;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class d implements b {
    private String eoh;
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
                    if (this.eoh.contains(".") || (this.eoh.contains("(") && this.eoh.contains(")"))) {
                        h pb = com.baidu.tieba.onlineDebugger.e.b.pb("get " + this.eoh);
                        if (pb != null) {
                            Object aNb = pb.aNb();
                            if (aNb != null) {
                                str = aNb.toString();
                            }
                        } else {
                            str = this.eoh;
                        }
                    } else {
                        str = this.eoh;
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

    public void oK(String str) {
        this.fieldName = str;
    }

    public void oM(String str) {
        this.eoh = str;
    }
}
