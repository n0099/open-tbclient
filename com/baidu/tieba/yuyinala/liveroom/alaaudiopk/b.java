package com.baidu.tieba.yuyinala.liveroom.alaaudiopk;

import android.widget.TextView;
/* loaded from: classes10.dex */
public class b {
    public static float b(d dVar) {
        if (dVar == null) {
            return 0.5f;
        }
        int parseInt = Integer.parseInt(dVar.oiV.f5349a);
        int parseInt2 = Integer.parseInt(dVar.oiV.f5350b);
        if (parseInt == 0 && parseInt2 == 0) {
            return 0.5f;
        }
        float f = parseInt / ((parseInt + parseInt2) + 0.0f);
        try {
            return Math.min(Math.max(f, 0.1f), 0.9f);
        } catch (Exception e) {
            return f;
        }
    }

    public static float b(TextView textView, TextView textView2) {
        try {
            int parseInt = Integer.parseInt(textView.getText().toString());
            int parseInt2 = Integer.parseInt(textView2.getText().toString());
            if (parseInt == 0 && parseInt2 == 0) {
                return 0.5f;
            }
            return Math.min(Math.max(parseInt / ((parseInt + parseInt2) + 0.0f), 0.1f), 0.9f);
        } catch (Exception e) {
            return 0.5f;
        }
    }
}
