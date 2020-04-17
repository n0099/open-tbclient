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
    private DragImageView.d dUb;
    private TbImageView gGS;
    private RelativeLayout iCH;
    private TextView iCI;
    public LinearLayout iCJ;
    public TextView iCK;
    public TextView iCL;
    public TextView iCM;
    public boolean iCN = false;
    private UrlDragImageView iCO;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.iCH = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gGS = (TbImageView) this.iCH.findViewById(R.id.big_image_ad_image);
        this.iCI = (TextView) this.iCH.findViewById(R.id.big_image_ad_button);
        this.iCJ = (LinearLayout) this.iCH.findViewById(R.id.big_image_ad_source_container);
        this.iCM = (TextView) this.iCH.findViewById(R.id.big_image_ad_source);
        this.iCK = (TextView) this.iCH.findViewById(R.id.big_image_ad_title);
        this.iCL = (TextView) this.iCH.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        ckU();
    }

    public View getView() {
        return this.iCH;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dUb = dVar;
    }

    public void ckU() {
        this.gGS.setVisibility(4);
        this.iCO = new UrlDragImageView(this.mContext);
        this.iCO.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.iCO.setIsCanDrag(true);
        this.iCO.setCanScale(false);
        this.iCO.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dUb != null) {
                    b.this.dUb.onDragStart();
                }
                b.this.n(b.this.iCK, 8);
                b.this.n(b.this.iCL, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dUb != null) {
                    b.this.dUb.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void baT() {
                b.this.n(b.this.iCK, 0);
                b.this.n(b.this.iCL, 0);
            }
        });
        this.iCH.addView(this.iCO, 0);
    }

    public UrlDragImageView ckV() {
        return this.iCO;
    }

    public TbImageView ckW() {
        return this.gGS;
    }

    public TextView ckX() {
        return this.iCI;
    }

    @SuppressLint({"ResourceAsColor"})
    public void ckY() {
        this.iCI.setText(R.string.pause_load);
        this.iCI.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.iCI, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void Ft(String str) {
        this.iCI.setText(str);
        this.iCI.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.iCI, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void ckZ() {
        this.iCI.setText(R.string.setup_text);
        this.iCI.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.iCI, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void cla() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gGS.getLayoutParams();
            double loadedHeight = this.gGS.getLoadedHeight() / this.gGS.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gGS.setLayoutParams(layoutParams);
        }
    }

    public void D(final View.OnClickListener onClickListener) {
        this.iCI.setOnClickListener(onClickListener);
        this.gGS.setOnClickListener(onClickListener);
        this.iCK.setOnClickListener(onClickListener);
        this.iCL.setOnClickListener(onClickListener);
        this.iCO.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float iCQ = 0.0f;
            private float iCR = 0.0f;
            private float iCS = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iCN = false;
                        this.iCQ = motionEvent.getX();
                        this.iCR = motionEvent.getY();
                        this.iCS = 0.0f;
                        break;
                    case 1:
                        b.this.iCN = 10.0f < this.iCS;
                        if (!b.this.iCN) {
                            if (b.this.e(b.this.gGS, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gGS);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.iCQ;
                        float y = motionEvent.getY() - this.iCR;
                        this.iCS = (float) (Math.sqrt((x * x) + (y * y)) + this.iCS);
                        this.iCQ = motionEvent.getX();
                        this.iCR = motionEvent.getY();
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
