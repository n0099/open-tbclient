package com.baidu.tieba.onlineDebugger;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.t;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class a {
    private String code;
    private Stack<Object> egk = new Stack<>();

    public a(String str) {
        this.code = str.substring(str.indexOf(" ") + 1);
        this.egk.add("#");
    }

    public Object get() {
        prepare();
        if (this.egk.isEmpty()) {
            return null;
        }
        return this.egk.pop();
    }

    private void prepare() {
        int i;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            int i5 = i2;
            i2 = i4;
            if (i2 < this.code.length()) {
                switch (this.code.charAt(i2)) {
                    case '$':
                        int length = "$.getInstance().get( )".length() + i2;
                        try {
                            Object aKH = com.baidu.tieba.onlineDebugger.e.b.oA("get " + this.code.substring(i2, length)).aKH();
                            if (aKH != null) {
                                this.egk.add(aKH);
                            }
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        i2 = length - 1;
                        i = i2;
                        break;
                    case '%':
                    case t.l.PullToRefresh_adapterViewBackground /* 38 */:
                    case t.l.PullToRefresh_headerBackground /* 39 */:
                    case '*':
                    case '+':
                    default:
                        i2 = i5;
                        i = i2;
                        break;
                    case t.l.PullToRefresh_headerTextColor /* 40 */:
                        this.egk.add(this.code.substring(i5 + 1, i2).trim());
                        this.egk.add("(");
                        i = i2;
                        break;
                    case t.l.PullToRefresh_mode /* 41 */:
                        String trim = this.code.substring(i5 + 1, i2).trim();
                        if (!trim.isEmpty()) {
                            this.egk.add(trim);
                        }
                        this.egk.add(")");
                        Stack stack = new Stack();
                        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                        while (true) {
                            if (!this.egk.isEmpty()) {
                                if (this.egk.peek().equals("(")) {
                                    stack.add(this.egk.pop());
                                    stack.add(this.egk.pop());
                                    String str = (String) stack.pop();
                                    while (!stack.isEmpty()) {
                                        Object pop = stack.pop();
                                        if (!pop.equals("(") && !pop.equals(")") && !pop.equals(",")) {
                                            linkedBlockingQueue.add(pop);
                                        }
                                    }
                                    Object a = a(str, linkedBlockingQueue);
                                    if (a != null) {
                                        this.egk.add(a);
                                    }
                                } else {
                                    stack.add(this.egk.pop());
                                }
                            }
                        }
                        i = i2;
                        break;
                    case ',':
                        String substring = this.code.substring(i5 + 1, i2);
                        if (!substring.isEmpty()) {
                            this.egk.add(substring.trim());
                        }
                        this.egk.add(",");
                        i = i2;
                        break;
                }
                i3 = i + 1;
            } else {
                return;
            }
        }
    }

    private Object a(String str, Queue<Object> queue) {
        Constructor<?>[] constructors;
        try {
            Class<?> cls = Class.forName(oh(str));
            int size = queue.size();
            for (Constructor<?> constructor : cls.getConstructors()) {
                if (constructor.getParameterTypes().length == size) {
                    try {
                        Object a = a(constructor, queue);
                        if (a != null) {
                            return a;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        } catch (ClassNotFoundException e2) {
        }
        return null;
    }

    private String oh(String str) {
        if (str.startsWith("new")) {
            return str.substring(str.indexOf(" ") + 1);
        }
        return str;
    }

    private Object a(Constructor<?> constructor, Queue<Object> queue) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Object[] array = queue.toArray();
        switch (constructor.getParameterTypes().length) {
            case 0:
                return constructor.newInstance(new Object[0]);
            case 1:
                return constructor.newInstance(Q(array[0]));
            case 2:
                return constructor.newInstance(Q(array[0]), Q(array[1]));
            case 3:
                return constructor.newInstance(Q(array[0]), Q(array[1]), Q(array[2]));
            case 4:
                return constructor.newInstance(Q(array[0]), Q(array[1]), Q(array[2]), Q(array[3]));
            default:
                return null;
        }
    }

    private Object Q(Object obj) {
        if (obj instanceof String) {
            String obj2 = obj.toString();
            try {
                return Integer.valueOf(obj2);
            } catch (Exception e) {
                if (obj2.equalsIgnoreCase("true") || obj2.equalsIgnoreCase("false")) {
                    return Boolean.valueOf(obj2);
                }
                return obj2;
            }
        }
        return obj;
    }
}
