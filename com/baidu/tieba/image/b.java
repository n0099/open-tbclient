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
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class b {
    private DragImageView.d eip;
    private TbImageView gVQ;
    private TBSpecificationBtn iBi;
    private RelativeLayout iSo;
    public LinearLayout iSp;
    public TextView iSq;
    public TextView iSr;
    public TextView iSs;
    public TextView iSt;
    public boolean iSu = false;
    private UrlDragImageView iSv;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.iSo = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gVQ = (TbImageView) this.iSo.findViewById(R.id.big_image_ad_image);
        this.iBi = (TBSpecificationBtn) this.iSo.findViewById(R.id.big_image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.aO(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.iBi.setConfig(cVar);
        this.iSp = (LinearLayout) this.iSo.findViewById(R.id.big_image_ad_source_container);
        this.iSt = (TextView) this.iSo.findViewById(R.id.big_image_ad_source);
        this.iSq = (TextView) this.iSo.findViewById(R.id.big_image_ad_title);
        this.iSr = (TextView) this.iSo.findViewById(R.id.big_image_ad_brand);
        this.iSs = (TextView) this.iSo.findViewById(R.id.big_image_ad_tag);
        this.mContext = viewGroup.getContext();
        crB();
    }

    public View getView() {
        return this.iSo;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eip = dVar;
    }

    public void crB() {
        this.gVQ.setVisibility(4);
        this.iSv = new UrlDragImageView(this.mContext);
        this.iSv.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.iSv.setIsCanDrag(true);
        this.iSv.setCanScale(false);
        this.iSv.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eip != null) {
                    b.this.eip.onDragStart();
                }
                b.this.n(b.this.iSq, 8);
                b.this.n(b.this.iSr, 8);
                b.this.n(b.this.iSs, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eip != null) {
                    b.this.eip.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bhd() {
                b.this.n(b.this.iSq, 0);
                b.this.n(b.this.iSr, 0);
                b.this.n(b.this.iSs, 0);
            }
        });
        this.iSo.addView(this.iSv, 0);
    }

    public UrlDragImageView crC() {
        return this.iSv;
    }

    public TbImageView crD() {
        return this.gVQ;
    }

    public TBSpecificationBtn crE() {
        return this.iBi;
    }

    @SuppressLint({"ResourceAsColor"})
    public void crF() {
        this.iBi.setText(this.mContext.getResources().getString(R.string.pause_load));
    }

    @SuppressLint({"ResourceAsColor"})
    public void Hf(String str) {
        this.iBi.setText(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public void crG() {
        this.iBi.setText(this.mContext.getResources().getString(R.string.setup_text));
    }

    public void crH() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gVQ.getLayoutParams();
            double loadedHeight = this.gVQ.getLoadedHeight() / this.gVQ.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gVQ.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.iBi.setOnClickListener(onClickListener);
        this.gVQ.setOnClickListener(onClickListener);
        this.iSq.setOnClickListener(onClickListener);
        this.iSr.setOnClickListener(onClickListener);
        this.iSv.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float iSx = 0.0f;
            private float iSy = 0.0f;
            private float iSz = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iSu = false;
                        this.iSx = motionEvent.getX();
                        this.iSy = motionEvent.getY();
                        this.iSz = 0.0f;
                        break;
                    case 1:
                        b.this.iSu = 10.0f < this.iSz;
                        if (!b.this.iSu) {
                            if (b.this.g(b.this.gVQ, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gVQ);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.iSx;
                        float y = motionEvent.getY() - this.iSy;
                        this.iSz = (float) (Math.sqrt((x * x) + (y * y)) + this.iSz);
                        this.iSx = motionEvent.getX();
                        this.iSy = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(View view, int i, int i2) {
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
    public void n(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
