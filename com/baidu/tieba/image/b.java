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
/* loaded from: classes8.dex */
public class b {
    private DragImageView.d eqZ;
    private TbImageView hiH;
    private TBSpecificationBtn iSn;
    private RelativeLayout jjA;
    public LinearLayout jjB;
    public TextView jjC;
    public TextView jjD;
    public TextView jjE;
    public TextView jjF;
    public boolean jjG = false;
    private UrlDragImageView jjH;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.jjA = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.hiH = (TbImageView) this.jjA.findViewById(R.id.big_image_ad_image);
        this.iSn = (TBSpecificationBtn) this.jjA.findViewById(R.id.big_image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.aS(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.iSn.setConfig(cVar);
        this.jjB = (LinearLayout) this.jjA.findViewById(R.id.big_image_ad_source_container);
        this.jjF = (TextView) this.jjA.findViewById(R.id.big_image_ad_source);
        this.jjC = (TextView) this.jjA.findViewById(R.id.big_image_ad_title);
        this.jjD = (TextView) this.jjA.findViewById(R.id.big_image_ad_brand);
        this.jjE = (TextView) this.jjA.findViewById(R.id.big_image_ad_tag);
        this.mContext = viewGroup.getContext();
        cvs();
    }

    public View getView() {
        return this.jjA;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eqZ = dVar;
    }

    public void cvs() {
        this.hiH.setVisibility(4);
        this.jjH = new UrlDragImageView(this.mContext);
        this.jjH.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.jjH.setIsCanDrag(true);
        this.jjH.setCanScale(false);
        this.jjH.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eqZ != null) {
                    b.this.eqZ.onDragStart();
                }
                b.this.n(b.this.jjC, 8);
                b.this.n(b.this.jjD, 8);
                b.this.n(b.this.jjE, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eqZ != null) {
                    b.this.eqZ.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bjr() {
                b.this.n(b.this.jjC, 0);
                b.this.n(b.this.jjD, 0);
                b.this.n(b.this.jjE, 0);
            }
        });
        this.jjA.addView(this.jjH, 0);
    }

    public UrlDragImageView cvt() {
        return this.jjH;
    }

    public TbImageView cvu() {
        return this.hiH;
    }

    public TBSpecificationBtn cvv() {
        return this.iSn;
    }

    @SuppressLint({"ResourceAsColor"})
    public void cvw() {
        this.iSn.setText(this.mContext.getResources().getString(R.string.pause_load));
    }

    @SuppressLint({"ResourceAsColor"})
    public void HH(String str) {
        this.iSn.setText(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public void cvx() {
        this.iSn.setText(this.mContext.getResources().getString(R.string.setup_text));
    }

    public void cvy() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.hiH.getLayoutParams();
            double loadedHeight = this.hiH.getLoadedHeight() / this.hiH.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.hiH.setLayoutParams(layoutParams);
        }
    }

    public void D(final View.OnClickListener onClickListener) {
        this.iSn.setOnClickListener(onClickListener);
        this.hiH.setOnClickListener(onClickListener);
        this.jjC.setOnClickListener(onClickListener);
        this.jjD.setOnClickListener(onClickListener);
        this.jjH.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float jjJ = 0.0f;
            private float jjK = 0.0f;
            private float jjL = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.jjG = false;
                        this.jjJ = motionEvent.getX();
                        this.jjK = motionEvent.getY();
                        this.jjL = 0.0f;
                        break;
                    case 1:
                        b.this.jjG = 10.0f < this.jjL;
                        if (!b.this.jjG) {
                            onClickListener.onClick(b.this.hiH);
                            break;
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.jjJ;
                        float y = motionEvent.getY() - this.jjK;
                        this.jjL = (float) (Math.sqrt((x * x) + (y * y)) + this.jjL);
                        this.jjJ = motionEvent.getX();
                        this.jjK = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
