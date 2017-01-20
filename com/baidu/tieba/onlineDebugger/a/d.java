package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.onlineDebugger.command.h;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class d implements b {
    private String ebG;
    private String fieldName;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object Y(Object obj) {
        Field b;
        String str = null;
        if (obj != null) {
            if (obj instanceof Class) {
                b = com.baidu.adp.lib.OrmObject.a.a.b((Class) obj, this.fieldName);
            } else {
                b = com.baidu.adp.lib.OrmObject.a.a.b(obj.getClass(), this.fieldName);
            }
            if (b != null) {
                try {
                    if (!b.isAccessible()) {
                        b.setAccessible(true);
                    }
                    if (this.ebG.contains(".") || (this.ebG.contains("(") && this.ebG.contains(")"))) {
                        h nT = com.baidu.tieba.onlineDebugger.e.b.nT("get " + this.ebG);
                        if (nT != null) {
                            Object aIQ = nT.aIQ();
                            if (aIQ != null) {
                                str = aIQ.toString();
                            }
                        } else {
                            str = this.ebG;
                        }
                    } else {
                        str = this.ebG;
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

    public void nC(String str) {
        this.fieldName = str;
    }

    public void nE(String str) {
        this.ebG = str;
    }
}
