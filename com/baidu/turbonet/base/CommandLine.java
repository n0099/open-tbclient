package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
public abstract class CommandLine {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference<CommandLine> f23027a;

    static {
        new ArrayList();
        f23027a = new AtomicReference<>();
    }

    public static CommandLine a() {
        return f23027a.get();
    }

    public static native void nativeAppendSwitch(String str);

    public static native void nativeAppendSwitchWithValue(String str, String str2);

    public static native void nativeAppendSwitchesAndArguments(String[] strArr);

    public static native String nativeGetSwitchValue(String str);

    public static native boolean nativeHasSwitch(String str);

    public static native void nativeReset();

    public abstract boolean b(String str);
}
