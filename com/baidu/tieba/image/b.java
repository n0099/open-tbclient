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
    private DragImageView.d cnn;
    private TbImageView faO;
    private RelativeLayout gRq;
    private TextView gRr;
    public LinearLayout gRs;
    public TextView gRt;
    public TextView gRu;
    public TextView gRv;
    public boolean gRw = false;
    private UrlDragImageView gRx;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gRq = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.faO = (TbImageView) this.gRq.findViewById(R.id.big_image_ad_image);
        this.gRr = (TextView) this.gRq.findViewById(R.id.big_image_ad_button);
        this.gRs = (LinearLayout) this.gRq.findViewById(R.id.big_image_ad_source_container);
        this.gRv = (TextView) this.gRq.findViewById(R.id.big_image_ad_source);
        this.gRt = (TextView) this.gRq.findViewById(R.id.big_image_ad_title);
        this.gRu = (TextView) this.gRq.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bFJ();
    }

    public View getView() {
        return this.gRq;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cnn = dVar;
    }

    public void bFJ() {
        this.faO.setVisibility(4);
        this.gRx = new UrlDragImageView(this.mContext);
        this.gRx.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gRx.setIsCanDrag(true);
        this.gRx.setCanScale(false);
        this.gRx.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avW() {
                if (b.this.cnn != null) {
                    b.this.cnn.avW();
                }
                b.this.A(b.this.gRt, 8);
                b.this.A(b.this.gRu, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avX() {
                if (b.this.cnn != null) {
                    b.this.cnn.avX();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avY() {
                b.this.A(b.this.gRt, 0);
                b.this.A(b.this.gRu, 0);
            }
        });
        this.gRq.addView(this.gRx, 0);
    }

    public UrlDragImageView bFK() {
        return this.gRx;
    }

    public TbImageView bFL() {
        return this.faO;
    }

    public TextView bFM() {
        return this.gRr;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bFN() {
        this.gRr.setText(R.string.pause_load);
        this.gRr.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        al.c(this.gRr, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void yW(String str) {
        this.gRr.setText(str);
        this.gRr.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        al.c(this.gRr, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bFO() {
        this.gRr.setText(R.string.setup_text);
        this.gRr.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        al.c(this.gRr, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bFP() {
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
        this.gRr.setOnClickListener(onClickListener);
        this.faO.setOnClickListener(onClickListener);
        this.gRt.setOnClickListener(onClickListener);
        this.gRu.setOnClickListener(onClickListener);
        this.gRx.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gRz = 0.0f;
            private float gRA = 0.0f;
            private float gRB = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gRw = false;
                        this.gRz = motionEvent.getX();
                        this.gRA = motionEvent.getY();
                        this.gRB = 0.0f;
                        break;
                    case 1:
                        b.this.gRw = 10.0f < this.gRB;
                        if (!b.this.gRw) {
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
                        float x = motionEvent.getX() - this.gRz;
                        float y = motionEvent.getY() - this.gRA;
                        this.gRB = (float) (Math.sqrt((x * x) + (y * y)) + this.gRB);
                        this.gRz = motionEvent.getX();
                        this.gRA = motionEvent.getY();
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
