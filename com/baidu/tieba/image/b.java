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
/* loaded from: classes6.dex */
public class b {
    private DragImageView.d dpx;
    private TbImageView gbH;
    private RelativeLayout hPe;
    private TextView hPf;
    public LinearLayout hPg;
    public TextView hPh;
    public TextView hPi;
    public TextView hPj;
    public boolean hPk = false;
    private UrlDragImageView hPl;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hPe = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gbH = (TbImageView) this.hPe.findViewById(R.id.big_image_ad_image);
        this.hPf = (TextView) this.hPe.findViewById(R.id.big_image_ad_button);
        this.hPg = (LinearLayout) this.hPe.findViewById(R.id.big_image_ad_source_container);
        this.hPj = (TextView) this.hPe.findViewById(R.id.big_image_ad_source);
        this.hPh = (TextView) this.hPe.findViewById(R.id.big_image_ad_title);
        this.hPi = (TextView) this.hPe.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bYw();
    }

    public View getView() {
        return this.hPe;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dpx = dVar;
    }

    public void bYw() {
        this.gbH.setVisibility(4);
        this.hPl = new UrlDragImageView(this.mContext);
        this.hPl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hPl.setIsCanDrag(true);
        this.hPl.setCanScale(false);
        this.hPl.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dpx != null) {
                    b.this.dpx.onDragStart();
                }
                b.this.setVisibility(b.this.hPh, 8);
                b.this.setVisibility(b.this.hPi, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dpx != null) {
                    b.this.dpx.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aQm() {
                b.this.setVisibility(b.this.hPh, 0);
                b.this.setVisibility(b.this.hPi, 0);
            }
        });
        this.hPe.addView(this.hPl, 0);
    }

    public UrlDragImageView bYx() {
        return this.hPl;
    }

    public TbImageView bYy() {
        return this.gbH;
    }

    public TextView bYz() {
        return this.hPf;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bYA() {
        this.hPf.setText(R.string.pause_load);
        this.hPf.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.hPf, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void Du(String str) {
        this.hPf.setText(str);
        this.hPf.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hPf, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bYB() {
        this.hPf.setText(R.string.setup_text);
        this.hPf.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hPf, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bYC() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gbH.getLayoutParams();
            double loadedHeight = this.gbH.getLoadedHeight() / this.gbH.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gbH.setLayoutParams(layoutParams);
        }
    }

    public void B(final View.OnClickListener onClickListener) {
        this.hPf.setOnClickListener(onClickListener);
        this.gbH.setOnClickListener(onClickListener);
        this.hPh.setOnClickListener(onClickListener);
        this.hPi.setOnClickListener(onClickListener);
        this.hPl.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hPn = 0.0f;
            private float hPo = 0.0f;
            private float hPp = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hPk = false;
                        this.hPn = motionEvent.getX();
                        this.hPo = motionEvent.getY();
                        this.hPp = 0.0f;
                        break;
                    case 1:
                        b.this.hPk = 10.0f < this.hPp;
                        if (!b.this.hPk) {
                            if (b.this.d(b.this.gbH, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gbH);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hPn;
                        float y = motionEvent.getY() - this.hPo;
                        this.hPp = (float) (Math.sqrt((x * x) + (y * y)) + this.hPp);
                        this.hPn = motionEvent.getX();
                        this.hPo = motionEvent.getY();
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
