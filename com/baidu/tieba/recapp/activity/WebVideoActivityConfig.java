package com.baidu.tieba.recapp.activity;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.AdTbWebViewActivityConfig;
/* loaded from: classes3.dex */
public class WebVideoActivityConfig extends AdTbWebViewActivityConfig {
    public static final String KEY_CHARGE_STYLE = "charge_style";
    public static final String KEY_CHARGE_URL = "charge_url";
    public static final String KEY_TAIL_FRAME = "tail_frame";
    public static final String KEY_VIDEO_DURATION = "video_duration";
    public static final String KEY_VIDEO_RATIO = "video_ratio";
    public static final String KEY_VIDEO_THUMB_URL = "video_thumb_url";
    public static final String KEY_VIDEO_URL = "video_url";

    public WebVideoActivityConfig(Context context, String str, String str2, boolean z, String str3, String str4, float f, int i) {
        super(context, str, str2, z);
        init(str3, str4, f, i);
    }

    public WebVideoActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, String str3, String str4, float f, int i) {
        super(context, str, str2, z, z2, z3);
        init(str3, str4, f, i);
    }

    public WebVideoActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, String str4, float f, int i) {
        super(context, str, str2, z, z2, z3, z4);
        init(str3, str4, f, i);
    }

    public void setChargeStyle(String str) {
        getIntent().putExtra(KEY_CHARGE_STYLE, str);
    }

    public void setChargeUrl(String str) {
        getIntent().putExtra(KEY_CHARGE_URL, str);
    }

    public void setTailFrame(String str) {
        getIntent().putExtra(KEY_TAIL_FRAME, str);
    }

    private void init(String str, String str2, float f, int i) {
        Intent intent = getIntent();
        intent.putExtra(KEY_VIDEO_URL, str);
        intent.putExtra(KEY_VIDEO_THUMB_URL, str2);
        intent.putExtra(KEY_VIDEO_RATIO, f);
        intent.putExtra(KEY_VIDEO_DURATION, i);
    }
}
