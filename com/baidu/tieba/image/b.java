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
    private DragImageView.d cpD;
    private TbImageView fic;
    private RelativeLayout hao;
    private TextView hap;
    public LinearLayout haq;
    public TextView har;
    public TextView has;
    public TextView hat;
    public boolean hau = false;
    private UrlDragImageView hav;
    private Context mContext;

    public b(ViewGroup viewGroup) {
        this.hao = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.big_image_ad, (ViewGroup) null);
        this.fic = (TbImageView) this.hao.findViewById(R.id.big_image_ad_image);
        this.hap = (TextView) this.hao.findViewById(R.id.big_image_ad_button);
        this.haq = (LinearLayout) this.hao.findViewById(R.id.big_image_ad_source_container);
        this.hat = (TextView) this.hao.findViewById(R.id.big_image_ad_source);
        this.har = (TextView) this.hao.findViewById(R.id.big_image_ad_title);
        this.has = (TextView) this.hao.findViewById(R.id.big_image_ad_brand);
        this.mContext = viewGroup.getContext();
        bJs();
    }

    public View getView() {
        return this.hao;
    }

    public void setDragToExitListener(DragImageView.d dVar) {
        this.cpD = dVar;
    }

    public void bJs() {
        this.fic.setVisibility(4);
        this.hav = new UrlDragImageView(this.mContext);
        this.hav.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.hav.setIsCanDrag(true);
        this.hav.setCanScale(false);
        this.hav.setDragToExitListener(new DragImageView.d() { // from class: com.baidu.tieba.image.b.1
            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axv() {
                if (b.this.cpD != null) {
                    b.this.cpD.axv();
                }
                b.this.A(b.this.har, 8);
                b.this.A(b.this.has, 8);
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axw() {
                if (b.this.cpD != null) {
                    b.this.cpD.axw();
                }
            }

            @Override // com.baidu.tbadk.widget.DragImageView.d
            public void axx() {
                b.this.A(b.this.har, 0);
                b.this.A(b.this.has, 0);
            }
        });
        this.hao.addView(this.hav, 0);
    }

    public UrlDragImageView bJt() {
        return this.hav;
    }

    public TbImageView bJu() {
        return this.fic;
    }

    public TextView bJv() {
        return this.hap;
    }

    @SuppressLint({"ResourceAsColor"})
    public void bJw() {
        this.hap.setText(R.string.pause_load);
        this.hap.setBackgroundResource(R.drawable.button_fenfa_xiazaizhong);
        am.d(this.hap, R.color.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void Aj(String str) {
        this.hap.setText(str);
        this.hap.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.d(this.hap, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void bJx() {
        this.hap.setText(R.string.setup_text);
        this.hap.setBackgroundResource(R.drawable.button_fenfa_download_selector);
        am.d(this.hap, R.drawable.button_fenfa_download_text_selector, 1, 0);
    }

    public void bJy() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.fic.getLayoutParams();
        double loadedHeight = this.fic.getLoadedHeight() / this.fic.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.fic.setLayoutParams(layoutParams);
    }

    public void A(final View.OnClickListener onClickListener) {
        this.hap.setOnClickListener(onClickListener);
        this.fic.setOnClickListener(onClickListener);
        this.har.setOnClickListener(onClickListener);
        this.has.setOnClickListener(onClickListener);
        this.hav.setOuterOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.image.b.2
            private float hax = 0.0f;
            private float hay = 0.0f;
            private float haz = 0.0f;

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        b.this.hau = false;
                        this.hax = motionEvent.getX();
                        this.hay = motionEvent.getY();
                        this.haz = 0.0f;
                        break;
                    case 1:
                        b.this.hau = 10.0f < this.haz;
                        if (!b.this.hau) {
                            if (b.this.j(b.this.fic, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                                onClickListener.onClick(b.this.fic);
                                break;
                            } else if (b.this.mContext instanceof Activity) {
                                ((Activity) b.this.mContext).finish();
                                break;
                            }
                        }
                        break;
                    case 2:
                        float x = motionEvent.getX() - this.hax;
                        float y = motionEvent.getY() - this.hay;
                        this.haz = (float) (Math.sqrt((x * x) + (y * y)) + this.haz);
                        this.hax = motionEvent.getX();
                        this.hay = motionEvent.getY();
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
