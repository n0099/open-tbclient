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
    private DragImageView.d dtF;
    private TbImageView gdI;
    private RelativeLayout hRc;
    private TextView hRd;
    public LinearLayout hRe;
    public TextView hRf;
    public TextView hRg;
    public TextView hRh;
    public boolean hRi = false;
    private UrlDragImageView hRj;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hRc = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gdI = (TbImageView) this.hRc.findViewById(R.id.big_image_ad_image);
        this.hRd = (TextView) this.hRc.findViewById(R.id.big_image_ad_button);
        this.hRe = (LinearLayout) this.hRc.findViewById(R.id.big_image_ad_source_container);
        this.hRh = (TextView) this.hRc.findViewById(R.id.big_image_ad_source);
        this.hRf = (TextView) this.hRc.findViewById(R.id.big_image_ad_title);
        this.hRg = (TextView) this.hRc.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bZX();
    }

    public View getView() {
        return this.hRc;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtF = dVar;
    }

    public void bZX() {
        this.gdI.setVisibility(4);
        this.hRj = new UrlDragImageView(this.mContext);
        this.hRj.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hRj.setIsCanDrag(true);
        this.hRj.setCanScale(false);
        this.hRj.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dtF != null) {
                    b.this.dtF.onDragStart();
                }
                b.this.setVisibility(b.this.hRf, 8);
                b.this.setVisibility(b.this.hRg, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dtF != null) {
                    b.this.dtF.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aSD() {
                b.this.setVisibility(b.this.hRf, 0);
                b.this.setVisibility(b.this.hRg, 0);
            }
        });
        this.hRc.addView(this.hRj, 0);
    }

    public UrlDragImageView bZY() {
        return this.hRj;
    }

    public TbImageView bZZ() {
        return this.gdI;
    }

    public TextView caa() {
        return this.hRd;
    }

    @SuppressLint({"ResourceAsColor"})
    public void cab() {
        this.hRd.setText(R.string.pause_load);
        this.hRd.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.hRd, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void DK(String str) {
        this.hRd.setText(str);
        this.hRd.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hRd, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cac() {
        this.hRd.setText(R.string.setup_text);
        this.hRd.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hRd, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void cad() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gdI.getLayoutParams();
            double loadedHeight = this.gdI.getLoadedHeight() / this.gdI.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gdI.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.hRd.setOnClickListener(onClickListener);
        this.gdI.setOnClickListener(onClickListener);
        this.hRf.setOnClickListener(onClickListener);
        this.hRg.setOnClickListener(onClickListener);
        this.hRj.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hRl = 0.0f;
            private float hRm = 0.0f;
            private float hRn = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hRi = false;
                        this.hRl = motionEvent.getX();
                        this.hRm = motionEvent.getY();
                        this.hRn = 0.0f;
                        break;
                    case 1:
                        b.this.hRi = 10.0f < this.hRn;
                        if (!b.this.hRi) {
                            if (b.this.d(b.this.gdI, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gdI);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hRl;
                        float y = motionEvent.getY() - this.hRm;
                        this.hRn = (float) (Math.sqrt((x * x) + (y * y)) + this.hRn);
                        this.hRl = motionEvent.getX();
                        this.hRm = motionEvent.getY();
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
