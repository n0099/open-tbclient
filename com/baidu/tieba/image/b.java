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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.view.UrlDragImageView;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private DragImageView.d cno;
    private TbImageView faO;
    private RelativeLayout gRs;
    private TextView gRt;
    public LinearLayout gRu;
    public TextView gRv;
    public TextView gRw;
    public TextView gRx;
    public boolean gRy = false;
    private UrlDragImageView gRz;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gRs = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.faO = (TbImageView) this.gRs.findViewById(R.id.big_image_ad_image);
        this.gRt = (TextView) this.gRs.findViewById(R.id.big_image_ad_button);
        this.gRu = (LinearLayout) this.gRs.findViewById(R.id.big_image_ad_source_container);
        this.gRx = (TextView) this.gRs.findViewById(R.id.big_image_ad_source);
        this.gRv = (TextView) this.gRs.findViewById(R.id.big_image_ad_title);
        this.gRw = (TextView) this.gRs.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bFK();
    }

    public View getView() {
        return this.gRs;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cno = dVar;
    }

    public void bFK() {
        this.faO.setVisibility(4);
        this.gRz = new UrlDragImageView(this.mContext);
        this.gRz.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gRz.setIsCanDrag(true);
        this.gRz.setCanScale(false);
        this.gRz.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avW() {
                if (b.this.cno != null) {
                    b.this.cno.avW();
                }
                b.this.A(b.this.gRv, 8);
                b.this.A(b.this.gRw, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avX() {
                if (b.this.cno != null) {
                    b.this.cno.avX();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avY() {
                b.this.A(b.this.gRv, 0);
                b.this.A(b.this.gRw, 0);
            }
        });
        this.gRs.addView(this.gRz, 0);
    }

    public UrlDragImageView bFL() {
        return this.gRz;
    }

    public TbImageView bFM() {
        return this.faO;
    }

    public TextView bFN() {
        return this.gRt;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bFO() {
        this.gRt.setText(R.string.pause_load);
        this.gRt.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        al.c(this.gRt, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void yY(String str) {
        this.gRt.setText(str);
        this.gRt.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        al.c(this.gRt, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bFP() {
        this.gRt.setText(R.string.setup_text);
        this.gRt.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        al.c(this.gRt, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bFQ() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.faO.getLayoutParams();
        double loadedHeight = this.faO.getLoadedHeight() / this.faO.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.faO.setLayoutParams(layoutParams);
    }

    public void y(final View.OnClickListener onClickListener) {
        this.gRt.setOnClickListener(onClickListener);
        this.faO.setOnClickListener(onClickListener);
        this.gRv.setOnClickListener(onClickListener);
        this.gRw.setOnClickListener(onClickListener);
        this.gRz.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gRB = 0.0f;
            private float gRC = 0.0f;
            private float gRD = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gRy = false;
                        this.gRB = motionEvent.getX();
                        this.gRC = motionEvent.getY();
                        this.gRD = 0.0f;
                        break;
                    case 1:
                        b.this.gRy = 10.0f < this.gRD;
                        if (!b.this.gRy) {
                            if (b.this.k(b.this.faO, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.faO);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gRB;
                        float y = motionEvent.getY() - this.gRC;
                        this.gRD = (float) (Math.sqrt((x * x) + (y * y)) + this.gRD);
                        this.gRB = motionEvent.getX();
                        this.gRC = motionEvent.getY();
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
