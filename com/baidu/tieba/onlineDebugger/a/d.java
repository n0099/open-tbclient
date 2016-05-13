package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class d implements b {
    private String dbt;
    private String fieldName;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object L(Object obj) {
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
                    if (this.dbt.contains(".") || (this.dbt.contains("(") && this.dbt.contains(")"))) {
                        com.baidu.tieba.onlineDebugger.command.d lE = com.baidu.tieba.onlineDebugger.e.b.lE("get " + this.dbt);
                        if (lE != null) {
                            Object auA = lE.auA();
                            if (auA != null) {
                                str = auA.toString();
                            }
                        } else {
                            str = this.dbt;
                        }
                    } else {
                        str = this.dbt;
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

    public void lp(String str) {
        this.fieldName = str;
    }

    public void lr(String str) {
        this.dbt = str;
    }
}
