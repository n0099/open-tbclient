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
    private ImageView aTs;
    private DragImageView.d aVL;
    private TbImageView dxC;
    private TextView eTn;
    private RelativeLayout fkr;
    public TbImageView fks;
    public LinearLayout fkt;
    public TextView fku;
    public boolean fkv = false;
    private UrlDragImageView fkw;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.fkr = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.h.big_image_ad, (ViewGroup) null);
        this.dxC = (TbImageView) this.fkr.findViewById(e.g.big_image_ad_image);
        this.eTn = (TextView) this.fkr.findViewById(e.g.big_image_ad_button);
        this.fks = (TbImageView) this.fkr.findViewById(e.g.big_image_ad_label);
        this.fkt = (LinearLayout) this.fkr.findViewById(e.g.big_image_ad_source_container);
        this.fku = (TextView) this.fkr.findViewById(e.g.big_image_ad_source);
        this.aTs = (ImageView) this.fkr.findViewById(e.g.big_image_close_btn);
        this.mContext = viewGroup.getContext();
        this.aTs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.image.b.1
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
        return this.fkr;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.aVL = dVar;
    }

    public void aXz() {
        this.dxC.setVisibility(4);
        this.fkw = new UrlDragImageView(this.mContext);
        this.fkw.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.fkw.setIsCanDrag(true);
        this.fkw.setCanScale(false);
        this.fkw.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.2
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void Rd() {
                b.this.fks.setVisibility(8);
                b.this.aTs.setVisibility(8);
                if (b.this.aVL != null) {
                    b.this.aVL.Rd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void Re() {
                b.this.fks.setVisibility(8);
                b.this.aTs.setVisibility(8);
                if (b.this.aVL != null) {
                    b.this.aVL.Re();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void Rf() {
                b.this.fks.setVisibility(0);
                b.this.aTs.setVisibility(0);
            }
        });
        this.fkr.addView(this.fkw, 0);
    }

    public UrlDragImageView aXA() {
        return this.fkw;
    }

    public TbImageView aXB() {
        return this.dxC;
    }

    public TextView aXC() {
        return this.eTn;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aXD() {
        this.eTn.setText(e.j.pause_load);
        this.eTn.setBackgroundResource(e.f.button_fenfa_xiazaizhong);
        al.b(this.eTn, e.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void re(String str) {
        this.eTn.setText(str);
        this.eTn.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eTn, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aXE() {
        this.eTn.setText(e.j.setup_text);
        this.eTn.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eTn, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aXF() {
        int width = ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.dxC.getLayoutParams();
        double loadedHeight = this.dxC.getLoadedHeight() / this.dxC.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.dxC.setLayoutParams(layoutParams);
    }

    public void v(final View.OnClickListener onClickListener) {
        this.eTn.setOnClickListener(onClickListener);
        this.dxC.setOnClickListener(onClickListener);
        this.fkw.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.3
            private float fky = 0.0f;
            private float fkz = 0.0f;
            private float fkA = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.fkv = false;
                        this.fky = motionEvent.getX();
                        this.fkz = motionEvent.getY();
                        this.fkA = 0.0f;
                        break;
                    case 1:
                        b.this.fkv = 10.0f < this.fkA;
                        if (!b.this.fkv && b.this.f(b.this.dxC, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                            onClickListener.onClick(b.this.dxC);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.fky;
                        float y = motionEvent.getY() - this.fkz;
                        this.fkA = (float) (Math.sqrt((x * x) + (y * y)) + this.fkA);
                        this.fky = motionEvent.getX();
                        this.fkz = motionEvent.getY();
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
