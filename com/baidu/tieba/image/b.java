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
    private TbImageView gVF;
    private TBSpecificationBtn iAv;
    private RelativeLayout iRB;
    public LinearLayout iRC;
    public TextView iRD;
    public TextView iRE;
    public TextView iRF;
    public TextView iRG;
    public boolean iRH = false;
    private UrlDragImageView iRI;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.iRB = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.gVF = (TbImageView) this.iRB.findViewById(R.id.big_image_ad_image);
        this.iAv = (TBSpecificationBtn) this.iRB.findViewById(R.id.big_image_ad_button);
        com.baidu.tbadk.core.view.commonBtn.c cVar = new com.baidu.tbadk.core.view.commonBtn.c();
        cVar.aO(R.color.cp_link_tip_a, R.color.cp_cont_a);
        this.iAv.setConfig(cVar);
        this.iRC = (LinearLayout) this.iRB.findViewById(R.id.big_image_ad_source_container);
        this.iRG = (TextView) this.iRB.findViewById(R.id.big_image_ad_source);
        this.iRD = (TextView) this.iRB.findViewById(R.id.big_image_ad_title);
        this.iRE = (TextView) this.iRB.findViewById(R.id.big_image_ad_brand);
        this.iRF = (TextView) this.iRB.findViewById(R.id.big_image_ad_tag);
        this.mContext = viewGroup.getContext();
        crs();
    }

    public View getView() {
        return this.iRB;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.eip = dVar;
    }

    public void crs() {
        this.gVF.setVisibility(4);
        this.iRI = new UrlDragImageView(this.mContext);
        this.iRI.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.iRI.setIsCanDrag(true);
        this.iRI.setCanScale(false);
        this.iRI.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.eip != null) {
                    b.this.eip.onDragStart();
                }
                b.this.n(b.this.iRD, 8);
                b.this.n(b.this.iRE, 8);
                b.this.n(b.this.iRF, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.eip != null) {
                    b.this.eip.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void bhc() {
                b.this.n(b.this.iRD, 0);
                b.this.n(b.this.iRE, 0);
                b.this.n(b.this.iRF, 0);
            }
        });
        this.iRB.addView(this.iRI, 0);
    }

    public UrlDragImageView crt() {
        return this.iRI;
    }

    public TbImageView cru() {
        return this.gVF;
    }

    public TBSpecificationBtn crv() {
        return this.iAv;
    }

    @SuppressLint({"ResourceAsColor"})
    public void crw() {
        this.iAv.setText(this.mContext.getResources().getString(R.string.pause_load));
    }

    @SuppressLint({"ResourceAsColor"})
    public void Hf(String str) {
        this.iAv.setText(str);
    }

    @SuppressLint({"ResourceAsColor"})
    public void crx() {
        this.iAv.setText(this.mContext.getResources().getString(R.string.setup_text));
    }

    public void cry() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            ViewGroup.LayoutParams layoutParams = this.gVF.getLayoutParams();
            double loadedHeight = this.gVF.getLoadedHeight() / this.gVF.getLoadedWidth();
            if (loadedHeight > 1.0d) {
                layoutParams.height = width;
                layoutParams.width = (int) (width / loadedHeight);
            } else {
                layoutParams.height = (int) (loadedHeight * width);
                layoutParams.width = width;
            }
            this.gVF.setLayoutParams(layoutParams);
        }
    }

    public void C(final View.OnClickListener onClickListener) {
        this.iAv.setOnClickListener(onClickListener);
        this.gVF.setOnClickListener(onClickListener);
        this.iRD.setOnClickListener(onClickListener);
        this.iRE.setOnClickListener(onClickListener);
        this.iRI.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float iRK = 0.0f;
            private float iRL = 0.0f;
            private float iRM = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.iRH = false;
                        this.iRK = motionEvent.getX();
                        this.iRL = motionEvent.getY();
                        this.iRM = 0.0f;
                        break;
                    case 1:
                        b.this.iRH = 10.0f < this.iRM;
                        if (!b.this.iRH) {
                            if (b.this.g(b.this.gVF, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.gVF);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.iRK;
                        float y = motionEvent.getY() - this.iRL;
                        this.iRM = (float) (Math.sqrt((x * x) + (y * y)) + this.iRM);
                        this.iRK = motionEvent.getX();
                        this.iRL = motionEvent.getY();
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
