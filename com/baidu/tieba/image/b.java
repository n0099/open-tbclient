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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private TbImageView cNz;
    private RelativeLayout epC;
    public TbImageView epD;
    public LinearLayout epE;
    public TextView epF;
    public boolean epG = false;
    private TextView mButton;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.epC = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.i.big_image_ad, (ViewGroup) null);
        this.cNz = (TbImageView) this.epC.findViewById(d.g.big_image_ad_image);
        this.mButton = (TextView) this.epC.findViewById(d.g.big_image_ad_button);
        this.epD = (TbImageView) this.epC.findViewById(d.g.big_image_ad_label);
        this.epE = (LinearLayout) this.epC.findViewById(d.g.big_image_ad_source_container);
        this.epF = (TextView) this.epC.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aIZ();
    }

    public View getView() {
        return this.epC;
    }

    public void aIZ() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.epC.addView(this.mProgressBar);
    }

    public TbImageView aJa() {
        return this.cNz;
    }

    public TextView aJb() {
        return this.mButton;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aJc() {
        this.mButton.setText(d.k.pause_load);
        this.mButton.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        ak.b(this.mButton, d.C0126d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void og(String str) {
        this.mButton.setText(str);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        ak.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aJd() {
        this.mButton.setText(d.k.setup_text);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        ak.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aJe() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.cNz.getLayoutParams();
        double loadedHeight = this.cNz.getLoadedHeight() / this.cNz.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cNz.setLayoutParams(layoutParams);
    }

    public void p(View.OnClickListener onClickListener) {
        this.mButton.setOnClickListener(onClickListener);
        this.cNz.setOnClickListener(onClickListener);
    }

    public void aJf() {
        this.mProgressBar.setVisibility(8);
    }
}
