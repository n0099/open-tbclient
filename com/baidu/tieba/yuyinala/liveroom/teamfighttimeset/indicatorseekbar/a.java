package com.baidu.tieba.yuyinala.liveroom.teamfighttimeset.indicatorseekbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes10.dex */
public class a {
    final Context context;
    boolean oCC;
    int oCE;
    int oCL;
    int oCo;
    int oCr;
    int oCt;
    int oCy;
    float oCd = 100.0f;
    float oCe = 0.0f;
    float progress = 0.0f;
    boolean oCf = false;
    boolean oCg = false;
    boolean oCh = false;
    boolean oCi = true;
    boolean oCj = false;
    boolean oCk = false;
    int oCl = 2;
    int oCm = Color.parseColor("#FF4081");
    int oCn = Color.parseColor("#FFFFFF");
    View oCp = null;
    View oCq = null;
    int oCs = Color.parseColor("#D7D7D7");
    int oCu = Color.parseColor("#FF4081");
    boolean oCv = false;
    int oCw = Color.parseColor("#FF4081");
    boolean oCx = false;
    int oCz = Color.parseColor("#FF4081");
    ColorStateList oCA = null;
    Drawable oCB = null;
    int oCD = Color.parseColor("#FF4081");
    String[] oCF = null;
    Typeface oCG = Typeface.DEFAULT;
    ColorStateList oCH = null;
    int oCI = 0;
    int oCJ = 0;
    int oCK = Color.parseColor("#FF4081");
    Drawable oCM = null;
    boolean oCN = false;
    boolean oCO = false;
    ColorStateList oCP = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.oCo = 0;
        this.oCr = 0;
        this.oCt = 0;
        this.oCy = 0;
        this.oCE = 0;
        this.oCL = 0;
        this.context = context;
        this.oCo = f.h(context, 14.0f);
        this.oCr = f.dp2px(context, 2.0f);
        this.oCt = f.dp2px(context, 2.0f);
        this.oCL = f.dp2px(context, 10.0f);
        this.oCE = f.h(context, 13.0f);
        this.oCy = f.dp2px(context, 14.0f);
    }
}
