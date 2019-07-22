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
    private DragImageView.d coB;
    private TbImageView ffP;
    private RelativeLayout gXC;
    private TextView gXD;
    public LinearLayout gXE;
    public TextView gXF;
    public TextView gXG;
    public TextView gXH;
    public boolean gXI = false;
    private UrlDragImageView gXJ;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gXC = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.ffP = (TbImageView) this.gXC.findViewById(R.id.big_image_ad_image);
        this.gXD = (TextView) this.gXC.findViewById(R.id.big_image_ad_button);
        this.gXE = (LinearLayout) this.gXC.findViewById(R.id.big_image_ad_source_container);
        this.gXH = (TextView) this.gXC.findViewById(R.id.big_image_ad_source);
        this.gXF = (TextView) this.gXC.findViewById(R.id.big_image_ad_title);
        this.gXG = (TextView) this.gXC.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bIr();
    }

    public View getView() {
        return this.gXC;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.coB = dVar;
    }

    public void bIr() {
        this.ffP.setVisibility(4);
        this.gXJ = new UrlDragImageView(this.mContext);
        this.gXJ.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gXJ.setIsCanDrag(true);
        this.gXJ.setCanScale(false);
        this.gXJ.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axh() {
                if (b.this.coB != null) {
                    b.this.coB.axh();
                }
                b.this.A(b.this.gXF, 8);
                b.this.A(b.this.gXG, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axi() {
                if (b.this.coB != null) {
                    b.this.coB.axi();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axj() {
                b.this.A(b.this.gXF, 0);
                b.this.A(b.this.gXG, 0);
            }
        });
        this.gXC.addView(this.gXJ, 0);
    }

    public UrlDragImageView bIs() {
        return this.gXJ;
    }

    public TbImageView bIt() {
        return this.ffP;
    }

    public TextView bIu() {
        return this.gXD;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bIv() {
        this.gXD.setText(R.string.pause_load);
        this.gXD.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.d(this.gXD, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void zJ(String str) {
        this.gXD.setText(str);
        this.gXD.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.d(this.gXD, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bIw() {
        this.gXD.setText(R.string.setup_text);
        this.gXD.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.d(this.gXD, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bIx() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.ffP.getLayoutParams();
        double loadedHeight = this.ffP.getLoadedHeight() / this.ffP.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.ffP.setLayoutParams(layoutParams);
    }

    public void A(final View.OnClickListener onClickListener) {
        this.gXD.setOnClickListener(onClickListener);
        this.ffP.setOnClickListener(onClickListener);
        this.gXF.setOnClickListener(onClickListener);
        this.gXG.setOnClickListener(onClickListener);
        this.gXJ.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gXL = 0.0f;
            private float gXM = 0.0f;
            private float gXN = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gXI = false;
                        this.gXL = motionEvent.getX();
                        this.gXM = motionEvent.getY();
                        this.gXN = 0.0f;
                        break;
                    case 1:
                        b.this.gXI = 10.0f < this.gXN;
                        if (!b.this.gXI) {
                            if (b.this.k(b.this.ffP, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.ffP);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gXL;
                        float y = motionEvent.getY() - this.gXM;
                        this.gXN = (float) (Math.sqrt((x * x) + (y * y)) + this.gXN);
                        this.gXL = motionEvent.getX();
                        this.gXM = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k(View view, int i, int i2) {
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
    public void A(@NonNull View view, int i) {
        view.setVisibility(i);
    }
}
