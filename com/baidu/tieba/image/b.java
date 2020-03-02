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
    private DragImageView.d dtG;
    private TbImageView gdK;
    private RelativeLayout hRe;
    private TextView hRf;
    public LinearLayout hRg;
    public TextView hRh;
    public TextView hRi;
    public TextView hRj;
    public boolean hRk = false;
    private UrlDragImageView hRl;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hRe = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gdK = (TbImageView) this.hRe.findViewById(R.id.big_image_ad_image);
        this.hRf = (TextView) this.hRe.findViewById(R.id.big_image_ad_button);
        this.hRg = (LinearLayout) this.hRe.findViewById(R.id.big_image_ad_source_container);
        this.hRj = (TextView) this.hRe.findViewById(R.id.big_image_ad_source);
        this.hRh = (TextView) this.hRe.findViewById(R.id.big_image_ad_title);
        this.hRi = (TextView) this.hRe.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bZZ();
    }

    public View getView() {
        return this.hRe;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.dtG = dVar;
    }

    public void bZZ() {
        this.gdK.setVisibility(4);
        this.hRl = new UrlDragImageView(this.mContext);
        this.hRl.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hRl.setIsCanDrag(true);
        this.hRl.setCanScale(false);
        this.hRl.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.dtG != null) {
                    b.this.dtG.onDragStart();
                }
                b.this.setVisibility(b.this.hRh, 8);
                b.this.setVisibility(b.this.hRi, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.dtG != null) {
                    b.this.dtG.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aSF() {
                b.this.setVisibility(b.this.hRh, 0);
                b.this.setVisibility(b.this.hRi, 0);
            }
        });
        this.hRe.addView(this.hRl, 0);
    }

    public UrlDragImageView caa() {
        return this.hRl;
    }

    public TbImageView cab() {
        return this.gdK;
    }

    public TextView cac() {
        return this.hRf;
    }

    @SuppressLint({"ResourceAsColor"})
    public void cad() {
        this.hRf.setText(R.string.pause_load);
        this.hRf.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.hRf, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void DK(String str) {
        this.hRf.setText(str);
        this.hRf.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hRf, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cae() {
        this.hRf.setText(R.string.setup_text);
        this.hRf.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.hRf, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void caf() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gdK.getLayoutParams();
            double loadedHeight = this.gdK.getLoadedHeight() / this.gdK.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gdK.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.hRf.setOnClickListener(onClickListener);
        this.gdK.setOnClickListener(onClickListener);
        this.hRh.setOnClickListener(onClickListener);
        this.hRi.setOnClickListener(onClickListener);
        this.hRl.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hRn = 0.0f;
            private float hRo = 0.0f;
            private float hRp = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hRk = false;
                        this.hRn = motionEvent.getX();
                        this.hRo = motionEvent.getY();
                        this.hRp = 0.0f;
                        break;
                    case 1:
                        b.this.hRk = 10.0f < this.hRp;
                        if (!b.this.hRk) {
                            if (b.this.d(b.this.gdK, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gdK);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hRn;
                        float y = motionEvent.getY() - this.hRo;
                        this.hRp = (float) (Math.sqrt((x * x) + (y * y)) + this.hRp);
                        this.hRn = motionEvent.getX();
                        this.hRo = motionEvent.getY();
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
