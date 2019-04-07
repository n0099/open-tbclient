package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
/* loaded from: classes3.dex */
public class a {
    private FrameLayout bfJ;
    private ImageView iJU;
    private InterfaceC0394a iJV;
    private Context mContext;

    /* renamed from: com.baidu.tieba.tbadvert.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0394a {
        void cfJ();

        void cfK();
    }

    public a(Context context, InterfaceC0394a interfaceC0394a) {
        this.iJV = interfaceC0394a;
        this.mContext = context;
        this.bfJ = new FrameLayout(context);
    }

    public View getView() {
        return this.bfJ;
    }

    public void f(Object obj, int i) {
        if (obj instanceof com.baidu.adp.widget.ImageView.a) {
            i((com.baidu.adp.widget.ImageView.a) obj);
        }
        cfQ();
        zE(i);
    }

    private void i(com.baidu.adp.widget.ImageView.a aVar) {
        this.iJU = new ImageView(this.mContext);
        this.iJU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (aVar != null) {
            this.iJU.setImageBitmap(aVar.oy());
        }
        this.iJU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iJV != null) {
                    a.this.iJV.cfJ();
                }
            }
        });
        this.bfJ.addView(this.iJU);
    }

    private void cfQ() {
        TextView textView = new TextView(this.mContext);
        textView.setText(d.j.tb_ad_label);
        int dimension = (int) this.mContext.getResources().getDimension(d.e.ds28);
        textView.setTextSize(0, (int) this.mContext.getResources().getDimension(d.e.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(d.e.ds68), (int) this.mContext.getResources().getDimension(d.e.ds40));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(d.e.ds4));
        gradientDrawable.setStroke(1, ViewCompat.MEASURED_STATE_MASK);
        textView.setBackgroundDrawable(gradientDrawable);
        layoutParams.gravity = 83;
        layoutParams.setMargins(dimension, 0, 0, (int) this.mContext.getResources().getDimension(d.e.ds28));
        this.bfJ.addView(textView, layoutParams);
    }

    private void zE(int i) {
        CountDownTextView countDownTextView = new CountDownTextView(this.mContext);
        String string = this.mContext.getResources().getString(d.j.skip);
        countDownTextView.setTextSize(0, (int) this.mContext.getResources().getDimension(d.e.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(d.e.ds106), (int) this.mContext.getResources().getDimension(d.e.ds52));
        countDownTextView.setTextColor(-1);
        countDownTextView.setGravity(17);
        countDownTextView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(d.e.ds4));
        gradientDrawable.setStroke(1, ViewCompat.MEASURED_STATE_MASK);
        countDownTextView.setBackgroundDrawable(gradientDrawable);
        countDownTextView.al(string, i);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, (int) this.mContext.getResources().getDimension(d.e.ds36), (int) this.mContext.getResources().getDimension(d.e.ds32), 0);
        this.bfJ.addView(countDownTextView, layoutParams);
        countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.iJV != null) {
                    a.this.iJV.cfK();
                }
            }
        });
        countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.tbadvert.view.a.3
            @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.b
            public void bh(View view) {
                if (a.this.iJV != null) {
                    a.this.iJV.cfK();
                }
            }
        });
    }
}
