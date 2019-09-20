package com.baidu.tieba.recapp.activity.newstyle;

import android.content.Context;
import android.content.Intent;
import com.baidu.tbadk.core.atomData.NewAdTbWebViewActivityConfig;
/* loaded from: classes3.dex */
public class NewWebVideoActivityConfig extends NewAdTbWebViewActivityConfig {
    public static final String KEY_CHARGE_STYLE = "charge_style";
    public static final String KEY_CHARGE_URL = "charge_url";
    public static final String KEY_TAIL_FRAME = "tail_frame";
    public static final String KEY_VIDEO_DURATION = "video_duration";
    public static final String KEY_VIDEO_RATIO = "video_ratio";
    public static final String KEY_VIDEO_THUMB_URL = "video_thumb_url";
    public static final String KEY_VIDEO_URL = "video_url";

    public NewWebVideoActivityConfig(Context context, String str, String str2, boolean z, String str3, String str4, float f, int i, String str5) {
        super(context, str, str2, z, str5);
        init(str3, str4, f, i);
    }

    public NewWebVideoActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, String str3, String str4, float f, int i, String str5) {
        super(context, str, str2, z, z2, z3, str5);
        init(str3, str4, f, i);
    }

    public NewWebVideoActivityConfig(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, String str4, float f, int i, String str5) {
        super(context, str, str2, z, z2, z3, z4, str5);
        init(str3, str4, f, i);
    }

    public void setChargeStyle(String str) {
        getIntent().putExtra("charge_style", str);
    }

    public void setChargeUrl(String str) {
        getIntent().putExtra("charge_url", str);
    }

    public void setTailFrame(String str) {
        getIntent().putExtra("tail_frame", str);
    }

    private void init(String str, String str2, float f, int i) {
        Intent intent = getIntent();
        intent.putExtra("video_url", str);
        intent.putExtra("video_thumb_url", str2);
        intent.putExtra("video_ratio", f);
        intent.putExtra("video_duration", i);
    }
}
