package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final List<Object> obx;
    private static final AtomicReference<CommandLine> oby;

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeReset();

    public abstract boolean VE(String str);

    static {
        $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        obx = new ArrayList();
        oby = new AtomicReference<>();
    }

    public static boolean isInitialized() {
        return oby.get() != null;
    }

    public static CommandLine dXx() {
        CommandLine commandLine = oby.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    private CommandLine() {
    }
}
