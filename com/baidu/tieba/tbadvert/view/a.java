package com.baidu.tieba.tbadvert.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadvert.view.CountDownTextView;
/* loaded from: classes3.dex */
public class a {
    private ImageView htH;
    private InterfaceC0320a htI;
    private Context mContext;
    private FrameLayout mRootView;

    /* renamed from: com.baidu.tieba.tbadvert.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0320a {
        void bGm();

        void bGn();
    }

    public a(Context context, InterfaceC0320a interfaceC0320a) {
        this.htI = interfaceC0320a;
        this.mContext = context;
        this.mRootView = new FrameLayout(context);
    }

    public View getView() {
        return this.mRootView;
    }

    public void f(Object obj, int i) {
        if (obj instanceof com.baidu.adp.widget.ImageView.a) {
            i((com.baidu.adp.widget.ImageView.a) obj);
        }
        bGt();
        vZ(i);
    }

    private void i(com.baidu.adp.widget.ImageView.a aVar) {
        this.htH = new ImageView(this.mContext);
        this.htH.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (aVar != null) {
            this.htH.setImageBitmap(aVar.ot());
        }
        this.htH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.htI != null) {
                    a.this.htI.bGm();
                }
            }
        });
        this.mRootView.addView(this.htH);
    }

    private void bGt() {
        TextView textView = new TextView(this.mContext);
        textView.setText(e.j.tb_ad_label);
        int dimension = (int) this.mContext.getResources().getDimension(e.C0210e.ds28);
        textView.setTextSize(0, (int) this.mContext.getResources().getDimension(e.C0210e.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(e.C0210e.ds68), (int) this.mContext.getResources().getDimension(e.C0210e.ds40));
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(e.C0210e.ds4));
        gradientDrawable.setStroke(1, -16777216);
        textView.setBackgroundDrawable(gradientDrawable);
        layoutParams.gravity = 83;
        layoutParams.setMargins(dimension, 0, 0, (int) this.mContext.getResources().getDimension(e.C0210e.ds28));
        this.mRootView.addView(textView, layoutParams);
    }

    private void vZ(int i) {
        CountDownTextView countDownTextView = new CountDownTextView(this.mContext);
        String string = this.mContext.getResources().getString(e.j.skip);
        countDownTextView.setTextSize(0, (int) this.mContext.getResources().getDimension(e.C0210e.ds22));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.mContext.getResources().getDimension(e.C0210e.ds106), (int) this.mContext.getResources().getDimension(e.C0210e.ds52));
        countDownTextView.setTextColor(-1);
        countDownTextView.setGravity(17);
        countDownTextView.setAlpha(0.5f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadius(this.mContext.getResources().getDimension(e.C0210e.ds4));
        gradientDrawable.setStroke(1, -16777216);
        countDownTextView.setBackgroundDrawable(gradientDrawable);
        countDownTextView.O(string, i);
        layoutParams.gravity = 53;
        layoutParams.setMargins(0, (int) this.mContext.getResources().getDimension(e.C0210e.ds36), (int) this.mContext.getResources().getDimension(e.C0210e.ds32), 0);
        this.mRootView.addView(countDownTextView, layoutParams);
        countDownTextView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.tbadvert.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.htI != null) {
                    a.this.htI.bGn();
                }
            }
        });
        countDownTextView.setTimeoutListener(new CountDownTextView.b() { // from class: com.baidu.tieba.tbadvert.view.a.3
            @Override // com.baidu.tieba.tbadvert.view.CountDownTextView.b
            public void ak(View view) {
                if (a.this.htI != null) {
                    a.this.htI.bGn();
                }
            }
        });
    }
}
