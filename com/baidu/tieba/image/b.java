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
    private DragImageView.d cCs;
    private TbImageView fkQ;
    private RelativeLayout gYr;
    private TextView gYs;
    public LinearLayout gYt;
    public TextView gYu;
    public TextView gYv;
    public TextView gYw;
    public boolean gYx = false;
    private UrlDragImageView gYy;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.gYr = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.fkQ = (TbImageView) this.gYr.findViewById(R.id.big_image_ad_image);
        this.gYs = (TextView) this.gYr.findViewById(R.id.big_image_ad_button);
        this.gYt = (LinearLayout) this.gYr.findViewById(R.id.big_image_ad_source_container);
        this.gYw = (TextView) this.gYr.findViewById(R.id.big_image_ad_source);
        this.gYu = (TextView) this.gYr.findViewById(R.id.big_image_ad_title);
        this.gYv = (TextView) this.gYr.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bGc();
    }

    public View getView() {
        return this.gYr;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cCs = dVar;
    }

    public void bGc() {
        this.fkQ.setVisibility(4);
        this.gYy = new UrlDragImageView(this.mContext);
        this.gYy.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.gYy.setIsCanDrag(true);
        this.gYy.setCanScale(false);
        this.gYy.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragStart() {
                if (b.this.cCs != null) {
                    b.this.cCs.onDragStart();
                }
                b.this.p(b.this.gYu, 8);
                b.this.p(b.this.gYv, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void onDragEnd() {
                if (b.this.cCs != null) {
                    b.this.cCs.onDragEnd();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void ayc() {
                b.this.p(b.this.gYu, 0);
                b.this.p(b.this.gYv, 0);
            }
        });
        this.gYr.addView(this.gYy, 0);
    }

    public UrlDragImageView bGd() {
        return this.gYy;
    }

    public TbImageView bGe() {
        return this.fkQ;
    }

    public TextView bGf() {
        return this.gYs;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bGg() {
        this.gYs.setText(R.string.pause_load);
        this.gYs.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.setViewTextColor(this.gYs, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void yB(String str) {
        this.gYs.setText(str);
        this.gYs.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.gYs, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bGh() {
        this.gYs.setText(R.string.setup_text);
        this.gYs.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.setViewTextColor(this.gYs, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bGi() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.fkQ.getLayoutParams();
        double loadedHeight = this.fkQ.getLoadedHeight() / this.fkQ.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.fkQ.setLayoutParams(layoutParams);
    }

    public void B(final View.OnClickListener onClickListener) {
        this.gYs.setOnClickListener(onClickListener);
        this.fkQ.setOnClickListener(onClickListener);
        this.gYu.setOnClickListener(onClickListener);
        this.gYv.setOnClickListener(onClickListener);
        this.gYy.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float gYA = 0.0f;
            private float gYB = 0.0f;
            private float gYC = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.gYx = false;
                        this.gYA = motionEvent.getX();
                        this.gYB = motionEvent.getY();
                        this.gYC = 0.0f;
                        break;
                    case 1:
                        b.this.gYx = 10.0f < this.gYC;
                        if (!b.this.gYx) {
                            if (b.this.e(b.this.fkQ, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.fkQ);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.gYA;
                        float y = motionEvent.getY() - this.gYB;
                        this.gYC = (float) (Math.sqrt((x * x) + (y * y)) + this.gYC);
                        this.gYA = motionEvent.getX();
                        this.gYB = motionEvent.getY();
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
