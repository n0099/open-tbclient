package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final List<Object> oBh;
    private static final AtomicReference<CommandLine> oBi;

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeReset();

    public abstract boolean Xh(String str);

    static {
        $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        oBh = new ArrayList();
        oBi = new AtomicReference<>();
    }

    public static boolean isInitialized() {
        return oBi.get() != null;
    }

    public static CommandLine egK() {
        CommandLine commandLine = oBi.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    private CommandLine() {
    }
}
