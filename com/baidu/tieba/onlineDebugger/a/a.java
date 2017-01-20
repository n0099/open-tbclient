package com.baidu.tieba.onlineDebugger.a;

import com.baidu.adp.lib.util.BdLog;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class a implements b {
    private String fieldName;

    @Override // com.baidu.tieba.onlineDebugger.a.b
    public Object Y(Object obj) {
        Field b;
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
                    Object obj2 = b.get(obj);
                    BdLog.e(String.valueOf(obj.toString()) + " getField " + this.fieldName + " = " + (obj2 != null ? obj2.toString() : "null"));
                    return obj2;
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
}
