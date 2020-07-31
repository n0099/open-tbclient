package com.baidu.tieba.image;

import android.annotation.SuppressLint;
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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes15.dex */
public class b {
    private DragImageView.d exr;
    private TbImageView hoq;
    private TBSpecificationBtn jax;
    private RelativeLayout jsf;
    public LinearLayout jsg;
    public TextView jsh;
    public TextView jsi;
    public TextView jsj;
    public TextView jsk;
    public boolean jsl = false;
    private UrlDragImageView jsm;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.jsf = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hoq = (TbImageView) this.jsf.findViewById(R.id.big_image_ad_image);
        this.jax = (TBSpecificationBtn) this.jsf.findViewById(R.id.big_image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.aT(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.jax.setConfig(cVar);
        this.jsg = (LinearLayout) this.jsf.findViewById(R.id.big_image_ad_source_container);
        this.jsk = (TextView) this.jsf.findViewById(R.id.big_image_ad_source);
        this.jsh = (TextView) this.jsf.findViewById(R.id.big_image_ad_title);
        this.jsi = (TextView) this.jsf.findViewById(R.id.big_image_ad_brand);
        this.jsj = (TextView) this.jsf.findViewById(R.id.big_image_ad_tag);
        this.mContext = viewGroup.getContext();
        czq();
    }

    public View getView() {
        return this.jsf;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.exr = dVar;
    }

    public void czq() {
        this.hoq.setVisibility(4);
        this.jsm = new UrlDragImageView(this.mContext);
        this.jsm.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jsm.setIsCanDrag(true);
        this.jsm.setCanScale(false);
        this.jsm.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.exr != null) {
                    b.this.exr.onDragStart();
                }
                b.this.o(b.this.jsh, 8);
                b.this.o(b.this.jsi, 8);
                b.this.o(b.this.jsj, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.exr != null) {
                    b.this.exr.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bnk() {
                b.this.o(b.this.jsh, 0);
                b.this.o(b.this.jsi, 0);
                b.this.o(b.this.jsj, 0);
            }
        });
        this.jsf.addView(this.jsm, 0);
    }

    public UrlDragImageView czr() {
        return this.jsm;
    }

    public TbImageView czs() {
        return this.hoq;
    }

    public TBSpecificationBtn czt() {
        return this.jax;
    }

    @SuppressLint({"ResourceAsColor"})
    public void czu() {
        this.jax.setText(this.mContext.getResources().getString(R.string.pause_load));
    }

    @SuppressLint({"ResourceAsColor"})
    public void Iw(String str) {
        this.jax.setText(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public void czv() {
        this.jax.setText(this.mContext.getResources().getString(R.string.setup_text));
    }

    public void czw() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.hoq.getLayoutParams();
            double loadedHeight = this.hoq.getLoadedHeight() / this.hoq.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.hoq.setLayoutParams(layoutParams);
        }
    }

    public void D(final View.OnClickListener onClickListener) {
        if (this.jax != null) {
            this.jax.setOnClickListener(onClickListener);
        }
        if (this.hoq != null) {
            this.hoq.setOnClickListener(onClickListener);
        }
        if (this.jsh != null) {
            this.jsh.setOnClickListener(onClickListener);
        }
        if (this.jsi != null) {
            this.jsi.setOnClickListener(onClickListener);
        }
        this.jsm.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float jso = 0.0f;
            private float jsp = 0.0f;
            private float jsq = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.jsl = false;
                        this.jso = motionEvent.getX();
                        this.jsp = motionEvent.getY();
                        this.jsq = 0.0f;
                        break;
                    case 1:
                        b.this.jsl = 10.0f < this.jsq;
                        if (!b.this.jsl) {
                            onClickListener.onClick(b.this.hoq);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.jso;
                        float y = motionEvent.getY() - this.jsp;
                        this.jsq = (float) (Math.sqrt((x * x) + (y * y)) + this.jsq);
                        this.jso = motionEvent.getX();
                        this.jsp = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
