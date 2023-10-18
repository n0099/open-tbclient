package com.baidu.tieba;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import java.io.File;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public interface ql4 extends SharedPreferences, SharedPreferences.Editor {
    Set<String> a();

    boolean b();

    @Override // android.content.SharedPreferences
    @Deprecated
    Map<String, ?> getAll();

    long getContentSize();

    @NonNull
    File getFile();

    @Override // android.content.SharedPreferences
    @Deprecated
    void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);

    @Override // android.content.SharedPreferences
    @Deprecated
    void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener);
}
