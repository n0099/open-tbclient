package com.baidu.tieba;

import android.content.SharedPreferences;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes5.dex */
public interface oj4 extends SharedPreferences, SharedPreferences.Editor {
    Set a();

    boolean b();

    long c();

    @Override // android.content.SharedPreferences
    @Deprecated
    Map getAll();

    File getFile();

    @Override // android.content.SharedPreferences
    @Deprecated
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    @Override // android.content.SharedPreferences
    @Deprecated
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
