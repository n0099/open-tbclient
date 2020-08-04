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
    private TBSpecificationBtn jaz;
    private RelativeLayout jsh;
    public LinearLayout jsi;
    public TextView jsj;
    public TextView jsk;
    public TextView jsl;
    public TextView jsm;
    public boolean jsn = false;
    private UrlDragImageView jso;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.jsh = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hoq = (TbImageView) this.jsh.findViewById(R.id.big_image_ad_image);
        this.jaz = (TBSpecificationBtn) this.jsh.findViewById(R.id.big_image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.aT(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.jaz.setConfig(cVar);
        this.jsi = (LinearLayout) this.jsh.findViewById(R.id.big_image_ad_source_container);
        this.jsm = (TextView) this.jsh.findViewById(R.id.big_image_ad_source);
        this.jsj = (TextView) this.jsh.findViewById(R.id.big_image_ad_title);
        this.jsk = (TextView) this.jsh.findViewById(R.id.big_image_ad_brand);
        this.jsl = (TextView) this.jsh.findViewById(R.id.big_image_ad_tag);
        this.mContext = viewGroup.getContext();
        czq();
    }

    public View getView() {
        return this.jsh;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.exr = dVar;
    }

    public void czq() {
        this.hoq.setVisibility(4);
        this.jso = new UrlDragImageView(this.mContext);
        this.jso.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jso.setIsCanDrag(true);
        this.jso.setCanScale(false);
        this.jso.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.exr != null) {
                    b.this.exr.onDragStart();
                }
                b.this.o(b.this.jsj, 8);
                b.this.o(b.this.jsk, 8);
                b.this.o(b.this.jsl, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.exr != null) {
                    b.this.exr.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bnk() {
                b.this.o(b.this.jsj, 0);
                b.this.o(b.this.jsk, 0);
                b.this.o(b.this.jsl, 0);
            }
        });
        this.jsh.addView(this.jso, 0);
    }

    public UrlDragImageView czr() {
        return this.jso;
    }

    public TbImageView czs() {
        return this.hoq;
    }

    public TBSpecificationBtn czt() {
        return this.jaz;
    }

    @SuppressLint({"ResourceAsColor"})
    public void czu() {
        this.jaz.setText(this.mContext.getResources().getString(R.string.pause_load));
    }

    @SuppressLint({"ResourceAsColor"})
    public void Iw(String str) {
        this.jaz.setText(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public void czv() {
        this.jaz.setText(this.mContext.getResources().getString(R.string.setup_text));
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
        if (this.jaz != null) {
            this.jaz.setOnClickListener(onClickListener);
        }
        if (this.hoq != null) {
            this.hoq.setOnClickListener(onClickListener);
        }
        if (this.jsj != null) {
            this.jsj.setOnClickListener(onClickListener);
        }
        if (this.jsk != null) {
            this.jsk.setOnClickListener(onClickListener);
        }
        this.jso.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float jsq = 0.0f;
            private float jsr = 0.0f;
            private float jss = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.jsn = false;
                        this.jsq = motionEvent.getX();
                        this.jsr = motionEvent.getY();
                        this.jss = 0.0f;
                        break;
                    case 1:
                        b.this.jsn = 10.0f < this.jss;
                        if (!b.this.jsn) {
                            onClickListener.onClick(b.this.hoq);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.jsq;
                        float y = motionEvent.getY() - this.jsr;
                        this.jss = (float) (Math.sqrt((x * x) + (y * y)) + this.jss);
                        this.jsq = motionEvent.getX();
                        this.jsr = motionEvent.getY();
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
