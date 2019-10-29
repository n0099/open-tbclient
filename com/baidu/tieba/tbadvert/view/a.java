package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
/* loaded from: classes3.dex */
public class a {
    private FrameLayout bEW;
    private ImageView jmL;
    private InterfaceC0524a jmM;
    private Context mContext;

    /* renamed from: com.baidu.tieba.tbadvert.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0524a {
        void cpP();

        void cpQ();
    }

    public a(Context context, InterfaceC0524a interfaceC0524a) {
        this.jmM = interfaceC0524a;
        this.mContext = context;
        this.bEW = new FrameLayout(context);
    }

    public View getView() {
        return this.bEW;
    }

    public void e(Object obj, int i) {
        if (obj instanceof com.baidu.adp.widget.ImageView.a) {
            k((com.baidu.adp.widget.ImageView.a) obj);
        }
        cpW();
        Ag(i);
    }

    private void k(com.baidu.adp.widget.ImageView.a aVar) {
        this.jmL = new ImageView(this.mContext);
        this.jmL.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (aVar != null) {
            this.jmL.setImageBitmap(aVar.getRawBitmap());
        }
        this.jmL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jmM != null) {
                    a.this.jmM.cpP();
                }
            }
        });
        this.bEW.addView(this.jmL);
    }

    private void cpW() {
        TextView textView = new TextView(this.mContext);
        textView.setText(R.string.tb_ad_label);
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ds28);
        textView.setTextSize(0, (int) this.mContext.getResources().getDimension(R.dimen.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.ds68), (int) this.mContext.getResources().getDimension(R.dimen.ds40));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, ViewCompat.MEASURED_STATE_MASK);
        textView.setBackgroundDrawable(gradientDrawable);
        layoutParams.gravity = 83;
        layoutParams.setMargins(dimension, 0, 0, (int) this.mContext.getResources().getDimension(R.dimen.ds28));
        this.bEW.addView(textView, layoutParams);
    }

    private void Ag(int i) {
        CountDownTextView countDownTextView = new CountDownTextView(this.mContext);
        String string = this.mContext.getResources().getString(R.string.skip);
        countDownTextView.setTextSize(0, (int) this.mContext.getResources().getDimension(R.dimen.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.ds106), (int) this.mContext.getResources().getDimension(R.dimen.ds52));
        countDownTextView.setTextColor(-1);
        countDownTextView.setGravity(17);
        countDownTextView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, ViewCompat.MEASURED_STATE_MASK);
        countDownTextView.setBackgroundDrawable(gradientDrawable);
        countDownTextView.aa(string, i);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, (int) this.mContext.getResources().getDimension(R.dimen.ds36), (int) this.mContext.getResources().getDimension(R.dimen.ds32), 0);
        this.bEW.addView(countDownTextView, layoutParams);
        countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.jmM != null) {
                    a.this.jmM.cpQ();
                }
            }
        });
        countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.tbadvert.view.a.3
            @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.b
            public void bp(View view) {
                if (a.this.jmM != null) {
                    a.this.jmM.cpQ();
                }
            }
        });
    }
}
