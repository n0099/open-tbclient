package com.baidu.tieba.yuyinala.liveroom.activeview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.CountDownTimer;
import android.support.v4.graphics.ColorUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.data.bi;
import com.baidu.live.data.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.z.f;
import java.util.List;
/* loaded from: classes4.dex */
public class AlaActiveDynamicView extends RelativeLayout implements c {
    private TbImageView fZh;
    private TextView gOA;
    private TextView gOB;
    private TextView gOC;
    private TextView gOD;
    private ViewGroup gOE;
    private View gOF;
    private TextView gOG;
    private TextView gOH;
    private TextView gOI;
    private ProgressBar gOJ;
    private ForegroundColorSpan gOK;
    private ForegroundColorSpan gOL;
    private int gOM;
    private o gOx;
    private ViewGroup gOy;
    private View gOz;
    private long mEndTime;
    private int mTextColor;
    private CountDownTimer mTimer;
    private a nOi;

    /* loaded from: classes4.dex */
    public interface a {
        void b(o oVar);
    }

    public AlaActiveDynamicView(Context context) {
        super(context);
        init();
    }

    public AlaActiveDynamicView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setCallback(a aVar) {
        this.nOi = aVar;
    }

    public o getActivityInfo() {
        return this.gOx;
    }

    public void setActivityInfo(o oVar) {
        this.gOx = oVar;
    }

    public void setData(String str, bi biVar) {
        a(biVar);
        this.fZh.startLoad(str, 10, false);
        this.gOA.setText(biVar.text);
        this.gOA.setTextColor(this.mTextColor);
        this.gOB.setText(biVar.point);
        this.gOB.setTextColor(this.gOM);
        setLayoutBg(biVar);
        setValues(biVar);
        bUk();
    }

    public void setTimer(String str) {
        this.gOG.setText(str);
        if (this.gOy.getVisibility() != 8) {
            this.gOy.setVisibility(8);
        }
        if (this.gOE.getVisibility() != 0) {
            this.gOE.setVisibility(0);
        }
    }

    private void bOI() {
        this.mEndTime = 0L;
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        f.PF().PH();
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStart() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void onStop() {
    }

    @Override // com.baidu.tieba.yuyinala.liveroom.activeview.c
    public void release() {
        bOI();
        this.nOi = null;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.yuyinala_active_dynamic, (ViewGroup) this, true);
        this.fZh = (TbImageView) findViewById(a.g.iv_bg);
        this.gOy = (ViewGroup) findViewById(a.g.layout_data);
        this.gOz = findViewById(a.g.divider_data);
        this.gOA = (TextView) findViewById(a.g.tv_data_title);
        this.gOB = (TextView) findViewById(a.g.tv_data_point);
        this.gOC = (TextView) findViewById(a.g.tv_data_a);
        this.gOD = (TextView) findViewById(a.g.tv_data_b);
        this.gOE = (ViewGroup) findViewById(a.g.layout_timer);
        this.gOF = findViewById(a.g.divider_timer);
        this.gOG = (TextView) findViewById(a.g.tv_timer_title);
        this.gOH = (TextView) findViewById(a.g.tv_timer_tip);
        this.gOI = (TextView) findViewById(a.g.tv_timer_num);
        this.gOJ = (ProgressBar) findViewById(a.g.pb_timer);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.yuyinala.liveroom.activeview.AlaActiveDynamicView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaActiveDynamicView.this.nOi != null) {
                    AlaActiveDynamicView.this.nOi.b(AlaActiveDynamicView.this.gOx);
                }
            }
        });
    }

    private void a(bi biVar) {
        boolean z;
        boolean z2 = true;
        if (TextUtils.isEmpty(biVar.aOi)) {
            z = false;
        } else {
            try {
                this.mTextColor = Color.parseColor(biVar.aOi);
                z = true;
            } catch (Exception e) {
                z = false;
            }
        }
        if (!z) {
            this.mTextColor = getResources().getColor(a.d.sdk_active_normal);
        }
        if (TextUtils.isEmpty(biVar.aOj)) {
            z2 = false;
        } else {
            try {
                this.gOM = Color.parseColor(biVar.aOj);
            } catch (Exception e2) {
                z2 = false;
            }
        }
        if (!z2) {
            this.gOM = getResources().getColor(a.d.sdk_active_highlight);
        }
        this.gOK = new ForegroundColorSpan(this.mTextColor);
        this.gOL = new ForegroundColorSpan(this.gOM);
    }

    private void setLayoutBg(bi biVar) {
        int i;
        boolean z;
        int parseColor;
        int parseColor2;
        int i2 = 0;
        String str = biVar.aOk;
        if (TextUtils.isEmpty(str)) {
            i = 0;
            z = false;
        } else {
            try {
                i2 = Color.parseColor(str);
                z = true;
                i = i2;
            } catch (Exception e) {
                i = 0;
                z = false;
            }
        }
        if (z) {
            int i3 = -1;
            String str2 = biVar.aOl;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    i3 = Integer.parseInt(str2);
                } catch (Exception e2) {
                }
                if (i3 >= 0 && i3 <= 100) {
                    i = ColorUtils.setAlphaComponent(i, ((100 - i3) * 255) / 100);
                }
            }
            int i4 = i2;
            parseColor = i;
            parseColor2 = i4;
        } else {
            parseColor = Color.parseColor("#9A000000");
            parseColor2 = Color.parseColor("#26D8D8D8");
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(getResources().getDimensionPixelOffset(a.e.sdk_ds8));
        gradientDrawable.setColor(parseColor);
        this.gOy.setBackgroundDrawable(gradientDrawable);
        this.gOE.setBackgroundDrawable(gradientDrawable);
        this.gOz.setBackgroundColor(parseColor2);
        this.gOF.setBackgroundColor(parseColor2);
    }

    private void setValues(bi biVar) {
        List<bi.a> list = biVar.aOh;
        if (list != null) {
            bi.a aVar = list.get(0);
            if (aVar != null) {
                SpannableString spannableString = new SpannableString(aVar.text + "：" + aVar.value);
                spannableString.setSpan(this.gOK, 0, aVar.text.length() + 1, 18);
                spannableString.setSpan(this.gOL, aVar.text.length() + 1, spannableString.length(), 18);
                this.gOC.setText(spannableString);
            }
            bi.a aVar2 = list.get(1);
            if (aVar2 != null) {
                SpannableString spannableString2 = new SpannableString(aVar2.text + "：" + aVar2.value);
                spannableString2.setSpan(this.gOK, 0, aVar2.text.length() + 1, 18);
                spannableString2.setSpan(this.gOL, aVar2.text.length() + 1, spannableString2.length(), 18);
                this.gOD.setText(spannableString2);
            }
        }
    }

    private void bUk() {
        this.gOG.setTextColor(this.gOM);
        this.gOH.setTextColor(this.mTextColor);
        this.gOI.setTextColor(this.mTextColor);
    }
}
