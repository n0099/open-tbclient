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
    private TbImageView faN;
    private RelativeLayout gRn;
    private TextView gRo;
    public LinearLayout gRp;
    public TextView gRq;
    public TextView gRr;
    public TextView gRs;
    public boolean gRt = false;
    private UrlDragImageView gRu;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gRn = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.faN = (TbImageView) this.gRn.findViewById(R.id.big_image_ad_image);
        this.gRo = (TextView) this.gRn.findViewById(R.id.big_image_ad_button);
        this.gRp = (LinearLayout) this.gRn.findViewById(R.id.big_image_ad_source_container);
        this.gRs = (TextView) this.gRn.findViewById(R.id.big_image_ad_source);
        this.gRq = (TextView) this.gRn.findViewById(R.id.big_image_ad_title);
        this.gRr = (TextView) this.gRn.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bFG();
    }

    public View getView() {
        return this.gRn;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cnn = dVar;
    }

    public void bFG() {
        this.faN.setVisibility(4);
        this.gRu = new UrlDragImageView(this.mContext);
        this.gRu.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gRu.setIsCanDrag(true);
        this.gRu.setCanScale(false);
        this.gRu.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avV() {
                if (b.this.cnn != null) {
                    b.this.cnn.avV();
                }
                b.this.A(b.this.gRq, 8);
                b.this.A(b.this.gRr, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avW() {
                if (b.this.cnn != null) {
                    b.this.cnn.avW();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void avX() {
                b.this.A(b.this.gRq, 0);
                b.this.A(b.this.gRr, 0);
            }
        });
        this.gRn.addView(this.gRu, 0);
    }

    public UrlDragImageView bFH() {
        return this.gRu;
    }

    public TbImageView bFI() {
        return this.faN;
    }

    public TextView bFJ() {
        return this.gRo;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bFK() {
        this.gRo.setText(R.string.pause_load);
        this.gRo.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        al.c(this.gRo, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void yW(String str) {
        this.gRo.setText(str);
        this.gRo.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        al.c(this.gRo, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bFL() {
        this.gRo.setText(R.string.setup_text);
        this.gRo.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        al.c(this.gRo, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bFM() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.faN.getLayoutParams();
        double loadedHeight = this.faN.getLoadedHeight() / this.faN.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.faN.setLayoutParams(layoutParams);
    }

    public void y(final View.OnClickListener onClickListener) {
        this.gRo.setOnClickListener(onClickListener);
        this.faN.setOnClickListener(onClickListener);
        this.gRq.setOnClickListener(onClickListener);
        this.gRr.setOnClickListener(onClickListener);
        this.gRu.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gRw = 0.0f;
            private float gRx = 0.0f;
            private float gRy = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gRt = false;
                        this.gRw = motionEvent.getX();
                        this.gRx = motionEvent.getY();
                        this.gRy = 0.0f;
                        break;
                    case 1:
                        b.this.gRt = 10.0f < this.gRy;
                        if (!b.this.gRt) {
                            if (b.this.k(b.this.faN, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.faN);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gRw;
                        float y = motionEvent.getY() - this.gRx;
                        this.gRy = (float) (Math.sqrt((x * x) + (y * y)) + this.gRy);
                        this.gRw = motionEvent.getX();
                        this.gRx = motionEvent.getY();
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
