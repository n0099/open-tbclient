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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private DragImageView.d cBB;
    private TbImageView fjZ;
    private RelativeLayout gXA;
    private TextView gXB;
    public LinearLayout gXC;
    public TextView gXD;
    public TextView gXE;
    public TextView gXF;
    public boolean gXG = false;
    private UrlDragImageView gXH;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gXA = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.fjZ = (TbImageView) this.gXA.findViewById(R.id.big_image_ad_image);
        this.gXB = (TextView) this.gXA.findViewById(R.id.big_image_ad_button);
        this.gXC = (LinearLayout) this.gXA.findViewById(R.id.big_image_ad_source_container);
        this.gXF = (TextView) this.gXA.findViewById(R.id.big_image_ad_source);
        this.gXD = (TextView) this.gXA.findViewById(R.id.big_image_ad_title);
        this.gXE = (TextView) this.gXA.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bGa();
    }

    public View getView() {
        return this.gXA;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cBB = dVar;
    }

    public void bGa() {
        this.fjZ.setVisibility(4);
        this.gXH = new UrlDragImageView(this.mContext);
        this.gXH.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gXH.setIsCanDrag(true);
        this.gXH.setCanScale(false);
        this.gXH.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.cBB != null) {
                    b.this.cBB.onDragStart();
                }
                b.this.p(b.this.gXD, 8);
                b.this.p(b.this.gXE, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.cBB != null) {
                    b.this.cBB.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void aya() {
                b.this.p(b.this.gXD, 0);
                b.this.p(b.this.gXE, 0);
            }
        });
        this.gXA.addView(this.gXH, 0);
    }

    public UrlDragImageView bGb() {
        return this.gXH;
    }

    public TbImageView bGc() {
        return this.fjZ;
    }

    public TextView bGd() {
        return this.gXB;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bGe() {
        this.gXB.setText(R.string.pause_load);
        this.gXB.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.gXB, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void yB(String str) {
        this.gXB.setText(str);
        this.gXB.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.gXB, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bGf() {
        this.gXB.setText(R.string.setup_text);
        this.gXB.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.gXB, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bGg() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.fjZ.getLayoutParams();
        double loadedHeight = this.fjZ.getLoadedHeight() / this.fjZ.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.fjZ.setLayoutParams(layoutParams);
    }

    public void B(final View.OnClickListener onClickListener) {
        this.gXB.setOnClickListener(onClickListener);
        this.fjZ.setOnClickListener(onClickListener);
        this.gXD.setOnClickListener(onClickListener);
        this.gXE.setOnClickListener(onClickListener);
        this.gXH.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gXJ = 0.0f;
            private float gXK = 0.0f;
            private float gXL = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gXG = false;
                        this.gXJ = motionEvent.getX();
                        this.gXK = motionEvent.getY();
                        this.gXL = 0.0f;
                        break;
                    case 1:
                        b.this.gXG = 10.0f < this.gXL;
                        if (!b.this.gXG) {
                            if (b.this.e(b.this.fjZ, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.fjZ);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gXJ;
                        float y = motionEvent.getY() - this.gXK;
                        this.gXL = (float) (Math.sqrt((x * x) + (y * y)) + this.gXL);
                        this.gXJ = motionEvent.getX();
                        this.gXK = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(View view, int i, int i2) {
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
    public void p(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
