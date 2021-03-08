package com.baidu.tieba.tbadvert.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
/* loaded from: classes7.dex */
public class a {
    private FrameLayout akl;
    private Context mContext;
    private ImageView nEc;
    private InterfaceC0884a nEd;

    /* renamed from: com.baidu.tieba.tbadvert.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0884a {
        void dPL();

        void dPM();
    }

    public a(Context context, InterfaceC0884a interfaceC0884a) {
        this.nEd = interfaceC0884a;
        this.mContext = context;
        this.akl = new FrameLayout(context);
    }

    public View getView() {
        return this.akl;
    }

    public void d(Object obj, int i) {
        if (obj instanceof com.baidu.adp.widget.ImageView.a) {
            i((com.baidu.adp.widget.ImageView.a) obj);
        }
        dPS();
        Kb(i);
    }

    private void i(com.baidu.adp.widget.ImageView.a aVar) {
        this.nEc = new ImageView(this.mContext);
        this.nEc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (aVar != null) {
            this.nEc.setImageBitmap(aVar.getRawBitmap());
        }
        this.nEc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nEd != null) {
                    a.this.nEd.dPL();
                }
            }
        });
        this.akl.addView(this.nEc);
    }

    private void dPS() {
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
        this.akl.addView(textView, layoutParams);
    }

    private void Kb(int i) {
        CountDownTextView countDownTextView = new CountDownTextView(this.mContext);
        int dimension = (int) this.mContext.getResources().getDimension(R.dimen.ds22);
        int dimension2 = (int) this.mContext.getResources().getDimension(R.dimen.ds36);
        int statusBarHeight = ((this.mContext instanceof Activity) && (UtilHelper.isNotchScreen((Activity) this.mContext) || UtilHelper.isCutoutScreen((Activity) this.mContext))) ? l.getStatusBarHeight((Activity) this.mContext) + dimension2 : dimension2;
        String string = this.mContext.getResources().getString(R.string.skip);
        countDownTextView.setTextSize(0, dimension);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(R.dimen.ds106), (int) this.mContext.getResources().getDimension(R.dimen.ds52));
        countDownTextView.setTextColor(-1);
        countDownTextView.setGravity(17);
        countDownTextView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(R.dimen.ds4));
        gradientDrawable.setStroke(1, ViewCompat.MEASURED_STATE_MASK);
        countDownTextView.setBackgroundDrawable(gradientDrawable);
        countDownTextView.aF(string, i);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, statusBarHeight, (int) this.mContext.getResources().getDimension(R.dimen.ds32), 0);
        this.akl.addView(countDownTextView, layoutParams);
        countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.nEd != null) {
                    a.this.nEd.dPM();
                }
            }
        });
        countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.tbadvert.view.a.3
            @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.b
            public void cf(View view) {
                if (a.this.nEd != null) {
                    a.this.nEd.dPM();
                }
            }
        });
    }
}
