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
    private TbImageView cNw;
    public TbImageView epA;
    public LinearLayout epB;
    public TextView epC;
    public boolean epD = false;
    private RelativeLayout epz;
    private TextView mButton;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.epz = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.i.big_image_ad, (ViewGroup) null);
        this.cNw = (TbImageView) this.epz.findViewById(d.g.big_image_ad_image);
        this.mButton = (TextView) this.epz.findViewById(d.g.big_image_ad_button);
        this.epA = (TbImageView) this.epz.findViewById(d.g.big_image_ad_label);
        this.epB = (LinearLayout) this.epz.findViewById(d.g.big_image_ad_source_container);
        this.epC = (TextView) this.epz.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aIZ();
    }

    public View getView() {
        return this.epz;
    }

    public void aIZ() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.epz.addView(this.mProgressBar);
    }

    public TbImageView aJa() {
        return this.cNw;
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
        ViewGroup.LayoutParams layoutParams = this.cNw.getLayoutParams();
        double loadedHeight = this.cNw.getLoadedHeight() / this.cNw.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cNw.setLayoutParams(layoutParams);
    }

    public void p(View.OnClickListener onClickListener) {
        this.mButton.setOnClickListener(onClickListener);
        this.cNw.setOnClickListener(onClickListener);
    }

    public void aJf() {
        this.mProgressBar.setVisibility(8);
    }
}
