package com.bytedance.embedapplog;

import android.content.Context;
import android.util.DisplayMetrics;
import com.baidu.ala.recorder.video.drawer.EncoderTextureDrawer;
import com.baidu.mobstat.Config;
import com.yy.videoplayer.decoder.VideoConstant;
import org.apache.http.HttpStatus;
import org.json.JSONObject;
/* loaded from: classes6.dex */
class n extends ch {
    private final Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context) {
        super(true, false);
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        String str;
        DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
        int i = displayMetrics.densityDpi;
        switch (i) {
            case 120:
                str = "ldpi";
                break;
            case 240:
                str = "hdpi";
                break;
            case 260:
            case 280:
            case 300:
            case VideoConstant.THUMBNAIL_WIDTH /* 320 */:
                str = "xhdpi";
                break;
            case 340:
            case EncoderTextureDrawer.X264_WIDTH /* 360 */:
            case 400:
            case HttpStatus.SC_METHOD_FAILURE /* 420 */:
            case 440:
            case 480:
                str = "xxhdpi";
                break;
            case 560:
            case 640:
                str = "xxxhdpi";
                break;
            default:
                str = "mdpi";
                break;
        }
        jSONObject.put("density_dpi", i);
        jSONObject.put("display_density", str);
        jSONObject.put("resolution", displayMetrics.heightPixels + Config.EVENT_HEAT_X + displayMetrics.widthPixels);
        return true;
    }
}
