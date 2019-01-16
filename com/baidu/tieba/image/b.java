package com.baidu.tieba.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    private ImageView aTr;
    private DragImageView.d aVK;
    private TbImageView dxB;
    private TextView eTm;
    private RelativeLayout fkq;
    public TbImageView fkr;
    public LinearLayout fks;
    public TextView fkt;
    public boolean fku = false;
    private UrlDragImageView fkv;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.fkq = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.h.big_image_ad, (ViewGroup) null);
        this.dxB = (TbImageView) this.fkq.findViewById(e.g.big_image_ad_image);
        this.eTm = (TextView) this.fkq.findViewById(e.g.big_image_ad_button);
        this.fkr = (TbImageView) this.fkq.findViewById(e.g.big_image_ad_label);
        this.fks = (LinearLayout) this.fkq.findViewById(e.g.big_image_ad_source_container);
        this.fkt = (TextView) this.fkq.findViewById(e.g.big_image_ad_source);
        this.aTr = (ImageView) this.fkq.findViewById(e.g.big_image_close_btn);
        this.mContext = viewGroup.getContext();
        this.aTr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (b.this.mContext instanceof Activity) {
                    ((Activity) b.this.mContext).finish();
                }
            }
        });
        aXz();
    }

    public View getView() {
        return this.fkq;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVK = dVar;
    }

    public void aXz() {
        this.dxB.setVisibility(4);
        this.fkv = new UrlDragImageView(this.mContext);
        this.fkv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fkv.setIsCanDrag(true);
        this.fkv.setCanScale(false);
        this.fkv.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void Rd() {
                b.this.fkr.setVisibility(8);
                b.this.aTr.setVisibility(8);
                if (b.this.aVK != null) {
                    b.this.aVK.Rd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void Re() {
                b.this.fkr.setVisibility(8);
                b.this.aTr.setVisibility(8);
                if (b.this.aVK != null) {
                    b.this.aVK.Re();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void Rf() {
                b.this.fkr.setVisibility(0);
                b.this.aTr.setVisibility(0);
            }
        });
        this.fkq.addView(this.fkv, 0);
    }

    public UrlDragImageView aXA() {
        return this.fkv;
    }

    public TbImageView aXB() {
        return this.dxB;
    }

    public TextView aXC() {
        return this.eTm;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aXD() {
        this.eTm.setText(e.j.pause_load);
        this.eTm.setBackgroundResource(e.f.button_fenfa_xiazaizhong);
        al.b(this.eTm, e.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void re(String str) {
        this.eTm.setText(str);
        this.eTm.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eTm, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aXE() {
        this.eTm.setText(e.j.setup_text);
        this.eTm.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eTm, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aXF() {
        int width = ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.dxB.getLayoutParams();
        double loadedHeight = this.dxB.getLoadedHeight() / this.dxB.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.dxB.setLayoutParams(layoutParams);
    }

    public void v(final View.OnClickListener onClickListener) {
        this.eTm.setOnClickListener(onClickListener);
        this.dxB.setOnClickListener(onClickListener);
        this.fkv.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.3
            private float fkx = 0.0f;
            private float fky = 0.0f;
            private float fkz = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fku = false;
                        this.fkx = motionEvent.getX();
                        this.fky = motionEvent.getY();
                        this.fkz = 0.0f;
                        break;
                    case 1:
                        b.this.fku = 10.0f < this.fkz;
                        if (!b.this.fku && b.this.f(b.this.dxB, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            onClickListener.onClick(b.this.dxB);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.fkx;
                        float y = motionEvent.getY() - this.fky;
                        this.fkz = (float) (Math.sqrt((x * x) + (y * y)) + this.fkz);
                        this.fkx = motionEvent.getX();
                        this.fky = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        return i2 >= i4 && i2 <= view.getMeasuredHeight() + i4 && i >= i3 && i <= view.getMeasuredWidth() + i3;
    }
}
