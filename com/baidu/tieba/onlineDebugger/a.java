package com.baidu.tieba.onlineDebugger;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.u;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes.dex */
public class a {
    private String code;
    private Stack<Object> dUe = new Stack<>();

    public a(String str) {
        this.code = str.substring(str.indexOf(" ") + 1);
        this.dUe.add("#");
    }

    public Object get() {
        prepare();
        if (this.dUe.isEmpty()) {
            return null;
        }
        return this.dUe.pop();
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
                    case u.l.PullToRefresh_tb_ptrDrawableTop /* 36 */:
                        int length = "$.getInstance().get( )".length() + i2;
                        try {
                            Object aFP = com.baidu.tieba.onlineDebugger.e.b.nQ("get " + this.code.substring(i2, length)).aFP();
                            if (aFP != null) {
                                this.dUe.add(aFP);
                            }
                        } catch (Exception e) {
                            BdLog.e(e);
                        }
                        i2 = length - 1;
                        i = i2;
                        break;
                    case u.l.PullToRefresh_tb_ptrDrawableBottom /* 37 */:
                    case u.l.PullToRefresh_adapterViewBackground /* 38 */:
                    case u.l.PullToRefresh_headerBackground /* 39 */:
                    case '*':
                    case '+':
                    default:
                        i2 = i5;
                        i = i2;
                        break;
                    case u.l.PullToRefresh_headerTextColor /* 40 */:
                        this.dUe.add(this.code.substring(i5 + 1, i2).trim());
                        this.dUe.add("(");
                        i = i2;
                        break;
                    case u.l.PullToRefresh_mode /* 41 */:
                        String trim = this.code.substring(i5 + 1, i2).trim();
                        if (!trim.isEmpty()) {
                            this.dUe.add(trim);
                        }
                        this.dUe.add(")");
                        Stack stack = new Stack();
                        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
                        while (true) {
                            if (!this.dUe.isEmpty()) {
                                if (this.dUe.peek().equals("(")) {
                                    stack.add(this.dUe.pop());
                                    stack.add(this.dUe.pop());
                                    String str = (String) stack.pop();
                                    while (!stack.isEmpty()) {
                                        Object pop = stack.pop();
                                        if (!pop.equals("(") && !pop.equals(")") && !pop.equals(",")) {
                                            linkedBlockingQueue.add(pop);
                                        }
                                    }
                                    Object a = a(str, linkedBlockingQueue);
                                    if (a != null) {
                                        this.dUe.add(a);
                                    }
                                } else {
                                    stack.add(this.dUe.pop());
                                }
                            }
                        }
                        i = i2;
                        break;
                    case ',':
                        String substring = this.code.substring(i5 + 1, i2);
                        if (!substring.isEmpty()) {
                            this.dUe.add(substring.trim());
                        }
                        this.dUe.add(",");
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
            Class<?> cls = Class.forName(nx(str));
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

    private String nx(String str) {
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
                return constructor.newInstance(O(array[0]));
            case 2:
                return constructor.newInstance(O(array[0]), O(array[1]));
            case 3:
                return constructor.newInstance(O(array[0]), O(array[1]), O(array[2]));
            case 4:
                return constructor.newInstance(O(array[0]), O(array[1]), O(array[2]), O(array[3]));
            default:
                return null;
        }
    }

    private Object O(Object obj) {
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
