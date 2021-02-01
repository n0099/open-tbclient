package com.bytedance.embedapplog;

import android.content.Context;
import com.kwai.video.player.KsMediaMeta;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class p extends ch {
    private final Context e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(Context context) {
        super(true, true);
        this.e = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.embedapplog.ch
    public boolean a(JSONObject jSONObject) {
        m.a(jSONObject, KsMediaMeta.KSM_KEY_LANGUAGE, this.e.getResources().getConfiguration().locale.getLanguage());
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        int i = rawOffset >= -12 ? rawOffset : -12;
        jSONObject.put("timezone", i <= 12 ? i : 12);
        m.a(jSONObject, "region", Locale.getDefault().getCountry());
        TimeZone timeZone = Calendar.getInstance().getTimeZone();
        m.a(jSONObject, "tz_name", timeZone.getID());
        jSONObject.put("tz_offset", timeZone.getOffset(System.currentTimeMillis() / 1000));
        return true;
    }
}
