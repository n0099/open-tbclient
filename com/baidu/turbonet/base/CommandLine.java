package com.baidu.turbonet.base;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes19.dex */
public abstract class CommandLine {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final List<Object> mGi;
    private static final AtomicReference<CommandLine> mGj;

    private static native void nativeAppendSwitch(String str);

    private static native void nativeAppendSwitchWithValue(String str, String str2);

    private static native void nativeAppendSwitchesAndArguments(String[] strArr);

    private static native String nativeGetSwitchValue(String str);

    private static native boolean nativeHasSwitch(String str);

    private static native void nativeReset();

    public abstract boolean Qe(String str);

    static {
        $assertionsDisabled = !CommandLine.class.desiredAssertionStatus();
        mGi = new ArrayList();
        mGj = new AtomicReference<>();
    }

    public static boolean isInitialized() {
        return mGj.get() != null;
    }

    public static CommandLine dxY() {
        CommandLine commandLine = mGj.get();
        if ($assertionsDisabled || commandLine != null) {
            return commandLine;
        }
        throw new AssertionError();
    }

    private CommandLine() {
    }
}
