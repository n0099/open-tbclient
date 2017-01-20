package com.baidu.tieba.onlineDebugger;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class a {
    private String code;
    private Stack<Object> ebC = new Stack<>();

    public a(String str) {
        this.code = str.substring(str.indexOf(" ") + 1);
        this.ebC.add("#");
    }

    public Object get() {
        prepare();
        if (this.ebC.isEmpty()) {
            return null;
        }
        return this.ebC.pop();
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
                            Object aIQ = com.baidu.tieba.onlineDebugger.e.b.nT("get " + this.code.substring(i2, length)).aIQ();
                            if (aIQ != null) {
                                this.ebC.add(aIQ);
                            }
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        i2 = length - 1;
                        i = i2;
                        break;
                    case '%':
                    case r.n.PullToRefresh_adapterViewBackground /* 38 */:
                    case r.n.PullToRefresh_headerBackground /* 39 */:
                    case '*':
                    case '+':
                    default:
                        i2 = i5;
                        i = i2;
                        break;
                    case r.n.PullToRefresh_headerTextColor /* 40 */:
                        this.ebC.add(this.code.substring(i5 + 1, i2).trim());
                        this.ebC.add("(");
                        i = i2;
                        break;
                    case r.n.PullToRefresh_mode /* 41 */:
                        String trim = this.code.substring(i5 + 1, i2).trim();
                        if (!trim.isEmpty()) {
                            this.ebC.add(trim);
                        }
                        this.ebC.add(")");
                        Stack stack = new Stack();
                        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                        while (true) {
                            if (!this.ebC.isEmpty()) {
                                if (this.ebC.peek().equals("(")) {
                                    stack.add(this.ebC.pop());
                                    stack.add(this.ebC.pop());
                                    String str = (String) stack.pop();
                                    while (!stack.isEmpty()) {
                                        Object pop = stack.pop();
                                        if (!pop.equals("(") && !pop.equals(")") && !pop.equals(",")) {
                                            linkedBlockingQueue.add(pop);
                                        }
                                    }
                                    Object a = a(str, linkedBlockingQueue);
                                    if (a != null) {
                                        this.ebC.add(a);
                                    }
                                } else {
                                    stack.add(this.ebC.pop());
                                }
                            }
                        }
                        i = i2;
                        break;
                    case ',':
                        String substring = this.code.substring(i5 + 1, i2);
                        if (!substring.isEmpty()) {
                            this.ebC.add(substring.trim());
                        }
                        this.ebC.add(",");
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
            Class<?> cls = Class.forName(nA(str));
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

    private String nA(String str) {
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
                return constructor.newInstance(W(array[0]));
            case 2:
                return constructor.newInstance(W(array[0]), W(array[1]));
            case 3:
                return constructor.newInstance(W(array[0]), W(array[1]), W(array[2]));
            case 4:
                return constructor.newInstance(W(array[0]), W(array[1]), W(array[2]), W(array[3]));
            default:
                return null;
        }
    }

    private Object W(Object obj) {
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
