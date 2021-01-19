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
    int opT;
    int opW;
    int opY;
    int oqd;
    boolean oqh;
    int oqj;
    int oqq;
    float opI = 100.0f;
    float opJ = 0.0f;
    float progress = 0.0f;
    boolean opK = false;
    boolean opL = false;
    boolean opM = false;
    boolean opN = true;
    boolean opO = false;
    boolean opP = false;
    int opQ = 2;
    int opR = Color.parseColor("#FF4081");
    int opS = Color.parseColor("#FFFFFF");
    View opU = null;
    View opV = null;
    int opX = Color.parseColor("#D7D7D7");
    int opZ = Color.parseColor("#FF4081");
    boolean oqa = false;
    int oqb = Color.parseColor("#FF4081");
    boolean oqc = false;
    int oqe = Color.parseColor("#FF4081");
    ColorStateList oqf = null;
    Drawable oqg = null;
    int oqi = Color.parseColor("#FF4081");
    String[] oqk = null;
    Typeface oql = Typeface.DEFAULT;
    ColorStateList oqm = null;
    int oqn = 0;
    int oqo = 0;
    int oqp = Color.parseColor("#FF4081");
    Drawable oqr = null;
    boolean oqs = false;
    boolean oqt = false;
    ColorStateList oqu = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.opT = 0;
        this.opW = 0;
        this.opY = 0;
        this.oqd = 0;
        this.oqj = 0;
        this.oqq = 0;
        this.context = context;
        this.opT = f.h(context, 14.0f);
        this.opW = f.dp2px(context, 2.0f);
        this.opY = f.dp2px(context, 2.0f);
        this.oqq = f.dp2px(context, 10.0f);
        this.oqj = f.h(context, 13.0f);
        this.oqd = f.dp2px(context, 14.0f);
    }
}
