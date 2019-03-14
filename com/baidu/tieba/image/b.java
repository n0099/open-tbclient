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
    private TbImageView eKR;
    private RelativeLayout gAn;
    private TextView gAo;
    public LinearLayout gAp;
    public TextView gAq;
    public TextView gAr;
    public TextView gAs;
    public boolean gAt = false;
    private UrlDragImageView gAu;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gAn = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.h.big_image_ad, (ViewGroup) null);
        this.eKR = (TbImageView) this.gAn.findViewById(d.g.big_image_ad_image);
        this.gAo = (TextView) this.gAn.findViewById(d.g.big_image_ad_button);
        this.gAp = (LinearLayout) this.gAn.findViewById(d.g.big_image_ad_source_container);
        this.gAs = (TextView) this.gAn.findViewById(d.g.big_image_ad_source);
        this.cci = (ImageView) this.gAn.findViewById(d.g.big_image_close_btn);
        this.gAq = (TextView) this.gAn.findViewById(d.g.big_image_ad_title);
        this.gAr = (TextView) this.gAn.findViewById(d.g.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        this.cci.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mContext instanceof Activity) {
                    ((Activity) b.this.mContext).finish();
                }
            }
        });
        byb();
    }

    public View getView() {
        return this.gAn;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cfe = dVar;
    }

    public void byb() {
        this.eKR.setVisibility(4);
        this.gAu = new UrlDragImageView(this.mContext);
        this.gAu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gAu.setIsCanDrag(true);
        this.gAu.setCanScale(false);
        this.gAu.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqS() {
                if (b.this.cfe != null) {
                    b.this.cfe.aqS();
                }
                b.this.y(b.this.cci, 8);
                b.this.y(b.this.gAq, 8);
                b.this.y(b.this.gAr, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqT() {
                b.this.cci.setVisibility(8);
                if (b.this.cfe != null) {
                    b.this.cfe.aqT();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aqU() {
                b.this.y(b.this.cci, 0);
                b.this.y(b.this.gAq, 0);
                b.this.y(b.this.gAr, 0);
            }
        });
        this.gAn.addView(this.gAu, 0);
    }

    public UrlDragImageView byc() {
        return this.gAu;
    }

    public TbImageView byd() {
        return this.eKR;
    }

    public TextView bye() {
        return this.gAo;
    }

    @SuppressLint({"ResourceAsColor"})
    public void byf() {
        this.gAo.setText(d.j.pause_load);
        this.gAo.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        al.c(this.gAo, d.C0277d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void xI(String str) {
        this.gAo.setText(str);
        this.gAo.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAo, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void byg() {
        this.gAo.setText(d.j.setup_text);
        this.gAo.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.c(this.gAo, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void byh() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.eKR.getLayoutParams();
        double loadedHeight = this.eKR.getLoadedHeight() / this.eKR.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.eKR.setLayoutParams(layoutParams);
    }

    public void w(final View.OnClickListener onClickListener) {
        this.gAo.setOnClickListener(onClickListener);
        this.eKR.setOnClickListener(onClickListener);
        this.gAq.setOnClickListener(onClickListener);
        this.gAr.setOnClickListener(onClickListener);
        this.gAu.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.3
            private float gAw = 0.0f;
            private float gAx = 0.0f;
            private float gAy = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gAt = false;
                        this.gAw = motionEvent.getX();
                        this.gAx = motionEvent.getY();
                        this.gAy = 0.0f;
                        break;
                    case 1:
                        b.this.gAt = 10.0f < this.gAy;
                        if (!b.this.gAt && b.this.h(b.this.eKR, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            onClickListener.onClick(b.this.eKR);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gAw;
                        float y = motionEvent.getY() - this.gAx;
                        this.gAy = (float) (Math.sqrt((x * x) + (y * y)) + this.gAy);
                        this.gAw = motionEvent.getX();
                        this.gAx = motionEvent.getY();
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
