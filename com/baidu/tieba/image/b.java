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
    private DragImageView.d dug;
    private TbImageView geG;
    private RelativeLayout hSQ;
    private TextView hSR;
    public LinearLayout hSS;
    public TextView hST;
    public TextView hSU;
    public TextView hSV;
    public boolean hSW = false;
    private UrlDragImageView hSX;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hSQ = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.geG = (TbImageView) this.hSQ.findViewById(R.id.big_image_ad_image);
        this.hSR = (TextView) this.hSQ.findViewById(R.id.big_image_ad_button);
        this.hSS = (LinearLayout) this.hSQ.findViewById(R.id.big_image_ad_source_container);
        this.hSV = (TextView) this.hSQ.findViewById(R.id.big_image_ad_source);
        this.hST = (TextView) this.hSQ.findViewById(R.id.big_image_ad_title);
        this.hSU = (TextView) this.hSQ.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        cat();
    }

    public View getView() {
        return this.hSQ;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dug = dVar;
    }

    public void cat() {
        this.geG.setVisibility(4);
        this.hSX = new UrlDragImageView(this.mContext);
        this.hSX.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hSX.setIsCanDrag(true);
        this.hSX.setCanScale(false);
        this.hSX.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dug != null) {
                    b.this.dug.onDragStart();
                }
                b.this.setVisibility(b.this.hST, 8);
                b.this.setVisibility(b.this.hSU, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dug != null) {
                    b.this.dug.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aSK() {
                b.this.setVisibility(b.this.hST, 0);
                b.this.setVisibility(b.this.hSU, 0);
            }
        });
        this.hSQ.addView(this.hSX, 0);
    }

    public UrlDragImageView cau() {
        return this.hSX;
    }

    public TbImageView cav() {
        return this.geG;
    }

    public TextView caw() {
        return this.hSR;
    }

    @SuppressLint({"ResourceAsColor"})
    public void cax() {
        this.hSR.setText(R.string.pause_load);
        this.hSR.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.hSR, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void DK(String str) {
        this.hSR.setText(str);
        this.hSR.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hSR, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cay() {
        this.hSR.setText(R.string.setup_text);
        this.hSR.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hSR, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void caz() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.geG.getLayoutParams();
            double loadedHeight = this.geG.getLoadedHeight() / this.geG.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.geG.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.hSR.setOnClickListener(onClickListener);
        this.geG.setOnClickListener(onClickListener);
        this.hST.setOnClickListener(onClickListener);
        this.hSU.setOnClickListener(onClickListener);
        this.hSX.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hSZ = 0.0f;
            private float hTa = 0.0f;
            private float hTb = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hSW = false;
                        this.hSZ = motionEvent.getX();
                        this.hTa = motionEvent.getY();
                        this.hTb = 0.0f;
                        break;
                    case 1:
                        b.this.hSW = 10.0f < this.hTb;
                        if (!b.this.hSW) {
                            if (b.this.e(b.this.geG, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.geG);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hSZ;
                        float y = motionEvent.getY() - this.hTa;
                        this.hTb = (float) (Math.sqrt((x * x) + (y * y)) + this.hTb);
                        this.hSZ = motionEvent.getX();
                        this.hTa = motionEvent.getY();
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
    public void setVisibility(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
