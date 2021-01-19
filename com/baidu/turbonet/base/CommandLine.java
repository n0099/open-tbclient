package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final List<Object> oEr;
    private static final AtomicReference<CommandLine> sCommandLine;

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeReset();

    public abstract boolean hasSwitch(String str);

    static {
        $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        oEr = new ArrayList();
        sCommandLine = new AtomicReference<>();
    }

    public static boolean isInitialized() {
        return sCommandLine.get() != null;
    }

    public static CommandLine edy() {
        CommandLine commandLine = sCommandLine.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    private CommandLine() {
    }
}
