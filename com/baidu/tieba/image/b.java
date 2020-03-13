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
    private DragImageView.d dtT;
    private TbImageView gdX;
    private RelativeLayout hRq;
    private TextView hRr;
    public LinearLayout hRs;
    public TextView hRt;
    public TextView hRu;
    public TextView hRv;
    public boolean hRw = false;
    private UrlDragImageView hRx;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hRq = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gdX = (TbImageView) this.hRq.findViewById(R.id.big_image_ad_image);
        this.hRr = (TextView) this.hRq.findViewById(R.id.big_image_ad_button);
        this.hRs = (LinearLayout) this.hRq.findViewById(R.id.big_image_ad_source_container);
        this.hRv = (TextView) this.hRq.findViewById(R.id.big_image_ad_source);
        this.hRt = (TextView) this.hRq.findViewById(R.id.big_image_ad_title);
        this.hRu = (TextView) this.hRq.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        caa();
    }

    public View getView() {
        return this.hRq;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtT = dVar;
    }

    public void caa() {
        this.gdX.setVisibility(4);
        this.hRx = new UrlDragImageView(this.mContext);
        this.hRx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hRx.setIsCanDrag(true);
        this.hRx.setCanScale(false);
        this.hRx.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dtT != null) {
                    b.this.dtT.onDragStart();
                }
                b.this.setVisibility(b.this.hRt, 8);
                b.this.setVisibility(b.this.hRu, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dtT != null) {
                    b.this.dtT.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aSG() {
                b.this.setVisibility(b.this.hRt, 0);
                b.this.setVisibility(b.this.hRu, 0);
            }
        });
        this.hRq.addView(this.hRx, 0);
    }

    public UrlDragImageView cab() {
        return this.hRx;
    }

    public TbImageView cac() {
        return this.gdX;
    }

    public TextView cad() {
        return this.hRr;
    }

    @SuppressLint({"ResourceAsColor"})
    public void cae() {
        this.hRr.setText(R.string.pause_load);
        this.hRr.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.hRr, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void DL(String str) {
        this.hRr.setText(str);
        this.hRr.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hRr, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void caf() {
        this.hRr.setText(R.string.setup_text);
        this.hRr.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hRr, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void cag() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gdX.getLayoutParams();
            double loadedHeight = this.gdX.getLoadedHeight() / this.gdX.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gdX.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.hRr.setOnClickListener(onClickListener);
        this.gdX.setOnClickListener(onClickListener);
        this.hRt.setOnClickListener(onClickListener);
        this.hRu.setOnClickListener(onClickListener);
        this.hRx.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hRz = 0.0f;
            private float hRA = 0.0f;
            private float hRB = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hRw = false;
                        this.hRz = motionEvent.getX();
                        this.hRA = motionEvent.getY();
                        this.hRB = 0.0f;
                        break;
                    case 1:
                        b.this.hRw = 10.0f < this.hRB;
                        if (!b.this.hRw) {
                            if (b.this.e(b.this.gdX, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gdX);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hRz;
                        float y = motionEvent.getY() - this.hRA;
                        this.hRB = (float) (Math.sqrt((x * x) + (y * y)) + this.hRB);
                        this.hRz = motionEvent.getX();
                        this.hRA = motionEvent.getY();
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
