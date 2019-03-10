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
    private ImageView cci;
    private DragImageView.d cfe;
    private TbImageView eKV;
    private RelativeLayout gAo;
    private TextView gAp;
    public LinearLayout gAq;
    public TextView gAr;
    public TextView gAs;
    public TextView gAt;
    public boolean gAu = false;
    private UrlDragImageView gAv;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gAo = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.h.big_image_ad, (ViewGroup) null);
        this.eKV = (TbImageView) this.gAo.findViewById(d.g.big_image_ad_image);
        this.gAp = (TextView) this.gAo.findViewById(d.g.big_image_ad_button);
        this.gAq = (LinearLayout) this.gAo.findViewById(d.g.big_image_ad_source_container);
        this.gAt = (TextView) this.gAo.findViewById(d.g.big_image_ad_source);
        this.cci = (ImageView) this.gAo.findViewById(d.g.big_image_close_btn);
        this.gAr = (TextView) this.gAo.findViewById(d.g.big_image_ad_title);
        this.gAs = (TextView) this.gAo.findViewById(d.g.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        this.cci.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mContext instanceof Activity) {
                    ((Activity) b.this.mContext).finish();
                }
            }
        });
        byc();
    }

    public View getView() {
        return this.gAo;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfe = dVar;
    }

    public void byc() {
        this.eKV.setVisibility(4);
        this.gAv = new UrlDragImageView(this.mContext);
        this.gAv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gAv.setIsCanDrag(true);
        this.gAv.setCanScale(false);
        this.gAv.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqT() {
                if (b.this.cfe != null) {
                    b.this.cfe.aqT();
                }
                b.this.y(b.this.cci, 8);
                b.this.y(b.this.gAr, 8);
                b.this.y(b.this.gAs, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqU() {
                b.this.cci.setVisibility(8);
                if (b.this.cfe != null) {
                    b.this.cfe.aqU();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqV() {
                b.this.y(b.this.cci, 0);
                b.this.y(b.this.gAr, 0);
                b.this.y(b.this.gAs, 0);
            }
        });
        this.gAo.addView(this.gAv, 0);
    }

    public UrlDragImageView byd() {
        return this.gAv;
    }

    public TbImageView bye() {
        return this.eKV;
    }

    public TextView byf() {
        return this.gAp;
    }

    @SuppressLint({"ResourceAsColor"})
    public void byg() {
        this.gAp.setText(d.j.pause_load);
        this.gAp.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        al.c(this.gAp, d.C0236d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void xK(String str) {
        this.gAp.setText(str);
        this.gAp.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAp, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void byh() {
        this.gAp.setText(d.j.setup_text);
        this.gAp.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAp, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void byi() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.eKV.getLayoutParams();
        double loadedHeight = this.eKV.getLoadedHeight() / this.eKV.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.eKV.setLayoutParams(layoutParams);
    }

    public void w(final View.OnClickListener onClickListener) {
        this.gAp.setOnClickListener(onClickListener);
        this.eKV.setOnClickListener(onClickListener);
        this.gAr.setOnClickListener(onClickListener);
        this.gAs.setOnClickListener(onClickListener);
        this.gAv.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.3
            private float gAx = 0.0f;
            private float gAy = 0.0f;
            private float gAz = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gAu = false;
                        this.gAx = motionEvent.getX();
                        this.gAy = motionEvent.getY();
                        this.gAz = 0.0f;
                        break;
                    case 1:
                        b.this.gAu = 10.0f < this.gAz;
                        if (!b.this.gAu && b.this.h(b.this.eKV, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            onClickListener.onClick(b.this.eKV);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gAx;
                        float y = motionEvent.getY() - this.gAy;
                        this.gAz = (float) (Math.sqrt((x * x) + (y * y)) + this.gAz);
                        this.gAx = motionEvent.getX();
                        this.gAy = motionEvent.getY();
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
