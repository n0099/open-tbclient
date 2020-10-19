package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes17.dex */
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final List<Object> nyX;
    private static final AtomicReference<CommandLine> nyY;

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeReset();

    public abstract boolean Uq(String str);

    static {
        $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        nyX = new ArrayList();
        nyY = new AtomicReference<>();
    }

    public static boolean isInitialized() {
        return nyY.get() != null;
    }

    public static CommandLine dRF() {
        CommandLine commandLine = nyY.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    private CommandLine() {
    }
}
