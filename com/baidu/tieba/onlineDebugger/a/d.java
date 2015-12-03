package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class d implements b {
    private String cvJ;
    private String fieldName;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object K(Object obj) {
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
                    if (this.cvJ.contains(".") || (this.cvJ.contains("(") && this.cvJ.contains(")"))) {
                        com.baidu.tieba.onlineDebugger.command.d km = com.baidu.tieba.onlineDebugger.e.b.km("get " + this.cvJ);
                        if (km != null) {
                            Object aiA = km.aiA();
                            if (aiA != null) {
                                str = aiA.toString();
                            }
                        } else {
                            str = this.cvJ;
                        }
                    } else {
                        str = this.cvJ;
                    }
                    BdLog.e(String.valueOf(obj.toString()) + " before setField " + this.fieldName + " value = " + (str == null ? "null" : str.toString()));
                    com.baidu.tieba.onlineDebugger.c.a(b, obj, str);
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

    public void jX(String str) {
        this.fieldName = str;
    }

    public void jZ(String str) {
        this.cvJ = str;
    }
}
