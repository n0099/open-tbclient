package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes11.dex */
public class a {
    final Context context;
    int oAG;
    int oAj;
    int oAm;
    int oAo;
    int oAt;
    boolean oAx;
    int oAz;
    float ozY = 100.0f;
    float ozZ = 0.0f;
    float progress = 0.0f;
    boolean oAa = false;
    boolean oAb = false;
    boolean oAc = false;
    boolean oAd = true;
    boolean oAe = false;
    boolean oAf = false;
    int oAg = 2;
    int oAh = Color.parseColor("#FF4081");
    int oAi = Color.parseColor("#FFFFFF");
    View oAk = null;
    View oAl = null;
    int oAn = Color.parseColor("#D7D7D7");
    int oAp = Color.parseColor("#FF4081");
    boolean oAq = false;
    int oAr = Color.parseColor("#FF4081");
    boolean oAs = false;
    int oAu = Color.parseColor("#FF4081");
    ColorStateList oAv = null;
    Drawable oAw = null;
    int oAy = Color.parseColor("#FF4081");
    String[] oAA = null;
    Typeface oAB = Typeface.DEFAULT;
    ColorStateList oAC = null;
    int oAD = 0;
    int oAE = 0;
    int oAF = Color.parseColor("#FF4081");
    Drawable oAH = null;
    boolean oAI = false;
    boolean oAJ = false;
    ColorStateList oAK = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.oAj = 0;
        this.oAm = 0;
        this.oAo = 0;
        this.oAt = 0;
        this.oAz = 0;
        this.oAG = 0;
        this.context = context;
        this.oAj = f.h(context, 14.0f);
        this.oAm = f.dp2px(context, 2.0f);
        this.oAo = f.dp2px(context, 2.0f);
        this.oAG = f.dp2px(context, 10.0f);
        this.oAz = f.h(context, 13.0f);
        this.oAt = f.dp2px(context, 14.0f);
    }
}
