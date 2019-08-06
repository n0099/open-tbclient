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
    private DragImageView.d coI;
    private TbImageView fgp;
    public boolean gYA = false;
    private UrlDragImageView gYB;
    private RelativeLayout gYu;
    private TextView gYv;
    public LinearLayout gYw;
    public TextView gYx;
    public TextView gYy;
    public TextView gYz;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gYu = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.fgp = (TbImageView) this.gYu.findViewById(R.id.big_image_ad_image);
        this.gYv = (TextView) this.gYu.findViewById(R.id.big_image_ad_button);
        this.gYw = (LinearLayout) this.gYu.findViewById(R.id.big_image_ad_source_container);
        this.gYz = (TextView) this.gYu.findViewById(R.id.big_image_ad_source);
        this.gYx = (TextView) this.gYu.findViewById(R.id.big_image_ad_title);
        this.gYy = (TextView) this.gYu.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bIF();
    }

    public View getView() {
        return this.gYu;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.coI = dVar;
    }

    public void bIF() {
        this.fgp.setVisibility(4);
        this.gYB = new UrlDragImageView(this.mContext);
        this.gYB.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gYB.setIsCanDrag(true);
        this.gYB.setCanScale(false);
        this.gYB.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axj() {
                if (b.this.coI != null) {
                    b.this.coI.axj();
                }
                b.this.A(b.this.gYx, 8);
                b.this.A(b.this.gYy, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axk() {
                if (b.this.coI != null) {
                    b.this.coI.axk();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axl() {
                b.this.A(b.this.gYx, 0);
                b.this.A(b.this.gYy, 0);
            }
        });
        this.gYu.addView(this.gYB, 0);
    }

    public UrlDragImageView bIG() {
        return this.gYB;
    }

    public TbImageView bIH() {
        return this.fgp;
    }

    public TextView bII() {
        return this.gYv;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bIJ() {
        this.gYv.setText(R.string.pause_load);
        this.gYv.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.d(this.gYv, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void zK(String str) {
        this.gYv.setText(str);
        this.gYv.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.d(this.gYv, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bIK() {
        this.gYv.setText(R.string.setup_text);
        this.gYv.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.d(this.gYv, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bIL() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.fgp.getLayoutParams();
        double loadedHeight = this.fgp.getLoadedHeight() / this.fgp.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.fgp.setLayoutParams(layoutParams);
    }

    public void A(final View.OnClickListener onClickListener) {
        this.gYv.setOnClickListener(onClickListener);
        this.fgp.setOnClickListener(onClickListener);
        this.gYx.setOnClickListener(onClickListener);
        this.gYy.setOnClickListener(onClickListener);
        this.gYB.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gYD = 0.0f;
            private float gYE = 0.0f;
            private float gYF = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gYA = false;
                        this.gYD = motionEvent.getX();
                        this.gYE = motionEvent.getY();
                        this.gYF = 0.0f;
                        break;
                    case 1:
                        b.this.gYA = 10.0f < this.gYF;
                        if (!b.this.gYA) {
                            if (b.this.j(b.this.fgp, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.fgp);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gYD;
                        float y = motionEvent.getY() - this.gYE;
                        this.gYF = (float) (Math.sqrt((x * x) + (y * y)) + this.gYF);
                        this.gYD = motionEvent.getX();
                        this.gYE = motionEvent.getY();
                        break;
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(View view, int i, int i2) {
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
