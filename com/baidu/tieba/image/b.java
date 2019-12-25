package com.baidu.tieba.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class b {
    private DragImageView.d dpm;
    private TbImageView fYy;
    private RelativeLayout hLB;
    private TextView hLC;
    public LinearLayout hLD;
    public TextView hLE;
    public TextView hLF;
    public TextView hLG;
    public boolean hLH = false;
    private UrlDragImageView hLI;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hLB = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.fYy = (TbImageView) this.hLB.findViewById(R.id.big_image_ad_image);
        this.hLC = (TextView) this.hLB.findViewById(R.id.big_image_ad_button);
        this.hLD = (LinearLayout) this.hLB.findViewById(R.id.big_image_ad_source_container);
        this.hLG = (TextView) this.hLB.findViewById(R.id.big_image_ad_source);
        this.hLE = (TextView) this.hLB.findViewById(R.id.big_image_ad_title);
        this.hLF = (TextView) this.hLB.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bXn();
    }

    public View getView() {
        return this.hLB;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dpm = dVar;
    }

    public void bXn() {
        this.fYy.setVisibility(4);
        this.hLI = new UrlDragImageView(this.mContext);
        this.hLI.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hLI.setIsCanDrag(true);
        this.hLI.setCanScale(false);
        this.hLI.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dpm != null) {
                    b.this.dpm.onDragStart();
                }
                b.this.setVisibility(b.this.hLE, 8);
                b.this.setVisibility(b.this.hLF, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dpm != null) {
                    b.this.dpm.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aPT() {
                b.this.setVisibility(b.this.hLE, 0);
                b.this.setVisibility(b.this.hLF, 0);
            }
        });
        this.hLB.addView(this.hLI, 0);
    }

    public UrlDragImageView bXo() {
        return this.hLI;
    }

    public TbImageView bXp() {
        return this.fYy;
    }

    public TextView bXq() {
        return this.hLC;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bXr() {
        this.hLC.setText(R.string.pause_load);
        this.hLC.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.hLC, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void Dk(String str) {
        this.hLC.setText(str);
        this.hLC.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hLC, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bXs() {
        this.hLC.setText(R.string.setup_text);
        this.hLC.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hLC, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bXt() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.fYy.getLayoutParams();
            double loadedHeight = this.fYy.getLoadedHeight() / this.fYy.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.fYy.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.hLC.setOnClickListener(onClickListener);
        this.fYy.setOnClickListener(onClickListener);
        this.hLE.setOnClickListener(onClickListener);
        this.hLF.setOnClickListener(onClickListener);
        this.hLI.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hLK = 0.0f;
            private float hLL = 0.0f;
            private float hLM = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hLH = false;
                        this.hLK = motionEvent.getX();
                        this.hLL = motionEvent.getY();
                        this.hLM = 0.0f;
                        break;
                    case 1:
                        b.this.hLH = 10.0f < this.hLM;
                        if (!b.this.hLH) {
                            if (b.this.d(b.this.fYy, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.fYy);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hLK;
                        float y = motionEvent.getY() - this.hLL;
                        this.hLM = (float) (Math.sqrt((x * x) + (y * y)) + this.hLM);
                        this.hLK = motionEvent.getX();
                        this.hLL = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVisibility(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
