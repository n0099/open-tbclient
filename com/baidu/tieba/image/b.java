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
/* loaded from: classes8.dex */
public class b {
    private DragImageView.d dUg;
    private TbImageView gGY;
    private RelativeLayout iCN;
    private TextView iCO;
    public LinearLayout iCP;
    public TextView iCQ;
    public TextView iCR;
    public TextView iCS;
    public boolean iCT = false;
    private UrlDragImageView iCU;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.iCN = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gGY = (TbImageView) this.iCN.findViewById(R.id.big_image_ad_image);
        this.iCO = (TextView) this.iCN.findViewById(R.id.big_image_ad_button);
        this.iCP = (LinearLayout) this.iCN.findViewById(R.id.big_image_ad_source_container);
        this.iCS = (TextView) this.iCN.findViewById(R.id.big_image_ad_source);
        this.iCQ = (TextView) this.iCN.findViewById(R.id.big_image_ad_title);
        this.iCR = (TextView) this.iCN.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        ckT();
    }

    public View getView() {
        return this.iCN;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dUg = dVar;
    }

    public void ckT() {
        this.gGY.setVisibility(4);
        this.iCU = new UrlDragImageView(this.mContext);
        this.iCU.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.iCU.setIsCanDrag(true);
        this.iCU.setCanScale(false);
        this.iCU.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dUg != null) {
                    b.this.dUg.onDragStart();
                }
                b.this.n(b.this.iCQ, 8);
                b.this.n(b.this.iCR, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dUg != null) {
                    b.this.dUg.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void baR() {
                b.this.n(b.this.iCQ, 0);
                b.this.n(b.this.iCR, 0);
            }
        });
        this.iCN.addView(this.iCU, 0);
    }

    public UrlDragImageView ckU() {
        return this.iCU;
    }

    public TbImageView ckV() {
        return this.gGY;
    }

    public TextView ckW() {
        return this.iCO;
    }

    @SuppressLint({"ResourceAsColor"})
    public void ckX() {
        this.iCO.setText(R.string.pause_load);
        this.iCO.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.iCO, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void Fw(String str) {
        this.iCO.setText(str);
        this.iCO.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.iCO, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void ckY() {
        this.iCO.setText(R.string.setup_text);
        this.iCO.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.iCO, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void ckZ() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gGY.getLayoutParams();
            double loadedHeight = this.gGY.getLoadedHeight() / this.gGY.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gGY.setLayoutParams(layoutParams);
        }
    }

    public void D(final View.OnClickListener onClickListener) {
        this.iCO.setOnClickListener(onClickListener);
        this.gGY.setOnClickListener(onClickListener);
        this.iCQ.setOnClickListener(onClickListener);
        this.iCR.setOnClickListener(onClickListener);
        this.iCU.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float iCW = 0.0f;
            private float iCX = 0.0f;
            private float iCY = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iCT = false;
                        this.iCW = motionEvent.getX();
                        this.iCX = motionEvent.getY();
                        this.iCY = 0.0f;
                        break;
                    case 1:
                        b.this.iCT = 10.0f < this.iCY;
                        if (!b.this.iCT) {
                            if (b.this.e(b.this.gGY, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gGY);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.iCW;
                        float y = motionEvent.getY() - this.iCX;
                        this.iCY = (float) (Math.sqrt((x * x) + (y * y)) + this.iCY);
                        this.iCW = motionEvent.getX();
                        this.iCX = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(View view, int i, int i2) {
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
    public void n(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
