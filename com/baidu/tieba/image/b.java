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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private ImageView ccl;
    private DragImageView.d cfh;
    private TbImageView eKE;
    private RelativeLayout gAb;
    private TextView gAc;
    public LinearLayout gAd;
    public TextView gAe;
    public TextView gAf;
    public TextView gAg;
    public boolean gAh = false;
    private UrlDragImageView gAi;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gAb = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.h.big_image_ad, (ViewGroup) null);
        this.eKE = (TbImageView) this.gAb.findViewById(d.g.big_image_ad_image);
        this.gAc = (TextView) this.gAb.findViewById(d.g.big_image_ad_button);
        this.gAd = (LinearLayout) this.gAb.findViewById(d.g.big_image_ad_source_container);
        this.gAg = (TextView) this.gAb.findViewById(d.g.big_image_ad_source);
        this.ccl = (ImageView) this.gAb.findViewById(d.g.big_image_close_btn);
        this.gAe = (TextView) this.gAb.findViewById(d.g.big_image_ad_title);
        this.gAf = (TextView) this.gAb.findViewById(d.g.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        this.ccl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mContext instanceof Activity) {
                    ((Activity) b.this.mContext).finish();
                }
            }
        });
        bxY();
    }

    public View getView() {
        return this.gAb;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfh = dVar;
    }

    public void bxY() {
        this.eKE.setVisibility(4);
        this.gAi = new UrlDragImageView(this.mContext);
        this.gAi.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gAi.setIsCanDrag(true);
        this.gAi.setCanScale(false);
        this.gAi.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqP() {
                if (b.this.cfh != null) {
                    b.this.cfh.aqP();
                }
                b.this.y(b.this.ccl, 8);
                b.this.y(b.this.gAe, 8);
                b.this.y(b.this.gAf, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqQ() {
                b.this.ccl.setVisibility(8);
                if (b.this.cfh != null) {
                    b.this.cfh.aqQ();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqR() {
                b.this.y(b.this.ccl, 0);
                b.this.y(b.this.gAe, 0);
                b.this.y(b.this.gAf, 0);
            }
        });
        this.gAb.addView(this.gAi, 0);
    }

    public UrlDragImageView bxZ() {
        return this.gAi;
    }

    public TbImageView bya() {
        return this.eKE;
    }

    public TextView byb() {
        return this.gAc;
    }

    @SuppressLint({"ResourceAsColor"})
    public void byc() {
        this.gAc.setText(d.j.pause_load);
        this.gAc.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        al.c(this.gAc, d.C0277d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void xH(String str) {
        this.gAc.setText(str);
        this.gAc.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAc, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void byd() {
        this.gAc.setText(d.j.setup_text);
        this.gAc.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAc, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void bye() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.eKE.getLayoutParams();
        double loadedHeight = this.eKE.getLoadedHeight() / this.eKE.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.eKE.setLayoutParams(layoutParams);
    }

    public void w(final View.OnClickListener onClickListener) {
        this.gAc.setOnClickListener(onClickListener);
        this.eKE.setOnClickListener(onClickListener);
        this.gAe.setOnClickListener(onClickListener);
        this.gAf.setOnClickListener(onClickListener);
        this.gAi.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.3
            private float gAk = 0.0f;
            private float gAl = 0.0f;
            private float gAm = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gAh = false;
                        this.gAk = motionEvent.getX();
                        this.gAl = motionEvent.getY();
                        this.gAm = 0.0f;
                        break;
                    case 1:
                        b.this.gAh = 10.0f < this.gAm;
                        if (!b.this.gAh && b.this.h(b.this.eKE, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            onClickListener.onClick(b.this.eKE);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gAk;
                        float y = motionEvent.getY() - this.gAl;
                        this.gAm = (float) (Math.sqrt((x * x) + (y * y)) + this.gAm);
                        this.gAk = motionEvent.getX();
                        this.gAl = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(View view, int i, int i2) {
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
    public void y(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
