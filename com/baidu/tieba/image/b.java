package com.baidu.tieba.image;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private TbImageView cXI;
    private RelativeLayout eBY;
    public TbImageView eBZ;
    public LinearLayout eCa;
    public TextView eCb;
    public boolean eCc = false;
    private TextView mButton;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eBY = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.i.big_image_ad, (ViewGroup) null);
        this.cXI = (TbImageView) this.eBY.findViewById(d.g.big_image_ad_image);
        this.mButton = (TextView) this.eBY.findViewById(d.g.big_image_ad_button);
        this.eBZ = (TbImageView) this.eBY.findViewById(d.g.big_image_ad_label);
        this.eCa = (LinearLayout) this.eBY.findViewById(d.g.big_image_ad_source_container);
        this.eCb = (TextView) this.eBY.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aNT();
    }

    public View getView() {
        return this.eBY;
    }

    public void aNT() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eBY.addView(this.mProgressBar);
    }

    public TbImageView aNU() {
        return this.cXI;
    }

    public TextView aNV() {
        return this.mButton;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aNW() {
        this.mButton.setText(d.k.pause_load);
        this.mButton.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        al.b(this.mButton, d.C0141d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oW(String str) {
        this.mButton.setText(str);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aNX() {
        this.mButton.setText(d.k.setup_text);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        al.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aNY() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.cXI.getLayoutParams();
        double loadedHeight = this.cXI.getLoadedHeight() / this.cXI.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cXI.setLayoutParams(layoutParams);
    }

    public void p(View.OnClickListener onClickListener) {
        this.mButton.setOnClickListener(onClickListener);
        this.cXI.setOnClickListener(onClickListener);
    }

    public void aNZ() {
        this.mProgressBar.setVisibility(8);
    }
}
