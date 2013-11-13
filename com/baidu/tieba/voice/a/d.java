package com.baidu.tieba.voice.a;

import com.baidu.tieba.voice.ak;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public String f2612a = null;
    public String b = null;
    public int c = 0;
    public String d = null;

    public static String a(int i) {
        switch (i) {
            case 0:
                return "";
            case 1:
                return ak.a(R.string.voice_cache_error_internal);
            case 2:
                return ak.a(R.string.voice_cache_error_no_space);
            case 3:
                return ak.a(R.string.sync_mark_fail_con);
            case 4:
                return ak.a(R.string.voice_cache_error_no_file);
            case 5:
                return ak.a(R.string.voice_cache_error_md5);
            case 6:
                return ak.a(R.string.voice_cache_error_no_input);
            case 7:
                return ak.a(R.string.voice_cache_error_no_dir);
            default:
                return "";
        }
    }
}
