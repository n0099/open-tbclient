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
    private ImageView cck;
    private DragImageView.d cfg;
    private TbImageView eKD;
    private RelativeLayout gAa;
    private TextView gAb;
    public LinearLayout gAc;
    public TextView gAd;
    public TextView gAe;
    public TextView gAf;
    public boolean gAg = false;
    private UrlDragImageView gAh;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gAa = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.h.big_image_ad, (ViewGroup) null);
        this.eKD = (TbImageView) this.gAa.findViewById(d.g.big_image_ad_image);
        this.gAb = (TextView) this.gAa.findViewById(d.g.big_image_ad_button);
        this.gAc = (LinearLayout) this.gAa.findViewById(d.g.big_image_ad_source_container);
        this.gAf = (TextView) this.gAa.findViewById(d.g.big_image_ad_source);
        this.cck = (ImageView) this.gAa.findViewById(d.g.big_image_close_btn);
        this.gAd = (TextView) this.gAa.findViewById(d.g.big_image_ad_title);
        this.gAe = (TextView) this.gAa.findViewById(d.g.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        this.cck.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.b.1
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
        return this.gAa;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfg = dVar;
    }

    public void bxY() {
        this.eKD.setVisibility(4);
        this.gAh = new UrlDragImageView(this.mContext);
        this.gAh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gAh.setIsCanDrag(true);
        this.gAh.setCanScale(false);
        this.gAh.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqP() {
                if (b.this.cfg != null) {
                    b.this.cfg.aqP();
                }
                b.this.y(b.this.cck, 8);
                b.this.y(b.this.gAd, 8);
                b.this.y(b.this.gAe, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqQ() {
                b.this.cck.setVisibility(8);
                if (b.this.cfg != null) {
                    b.this.cfg.aqQ();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqR() {
                b.this.y(b.this.cck, 0);
                b.this.y(b.this.gAd, 0);
                b.this.y(b.this.gAe, 0);
            }
        });
        this.gAa.addView(this.gAh, 0);
    }

    public UrlDragImageView bxZ() {
        return this.gAh;
    }

    public TbImageView bya() {
        return this.eKD;
    }

    public TextView byb() {
        return this.gAb;
    }

    @SuppressLint({"ResourceAsColor"})
    public void byc() {
        this.gAb.setText(d.j.pause_load);
        this.gAb.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        al.c(this.gAb, d.C0277d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void xH(String str) {
        this.gAb.setText(str);
        this.gAb.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAb, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void byd() {
        this.gAb.setText(d.j.setup_text);
        this.gAb.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAb, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void bye() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.eKD.getLayoutParams();
        double loadedHeight = this.eKD.getLoadedHeight() / this.eKD.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.eKD.setLayoutParams(layoutParams);
    }

    public void w(final View.OnClickListener onClickListener) {
        this.gAb.setOnClickListener(onClickListener);
        this.eKD.setOnClickListener(onClickListener);
        this.gAd.setOnClickListener(onClickListener);
        this.gAe.setOnClickListener(onClickListener);
        this.gAh.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.3
            private float gAj = 0.0f;
            private float gAk = 0.0f;
            private float gAl = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gAg = false;
                        this.gAj = motionEvent.getX();
                        this.gAk = motionEvent.getY();
                        this.gAl = 0.0f;
                        break;
                    case 1:
                        b.this.gAg = 10.0f < this.gAl;
                        if (!b.this.gAg && b.this.h(b.this.eKD, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            onClickListener.onClick(b.this.eKD);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gAj;
                        float y = motionEvent.getY() - this.gAk;
                        this.gAl = (float) (Math.sqrt((x * x) + (y * y)) + this.gAl);
                        this.gAj = motionEvent.getX();
                        this.gAk = motionEvent.getY();
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
