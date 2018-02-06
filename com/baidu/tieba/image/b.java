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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private TbImageView duU;
    private RelativeLayout eUU;
    public TbImageView eUV;
    public LinearLayout eUW;
    public TextView eUX;
    public boolean eUY = false;
    private TextView mButton;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eUU = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.h.big_image_ad, (ViewGroup) null);
        this.duU = (TbImageView) this.eUU.findViewById(d.g.big_image_ad_image);
        this.mButton = (TextView) this.eUU.findViewById(d.g.big_image_ad_button);
        this.eUV = (TbImageView) this.eUU.findViewById(d.g.big_image_ad_label);
        this.eUW = (LinearLayout) this.eUU.findViewById(d.g.big_image_ad_source_container);
        this.eUX = (TextView) this.eUU.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aNX();
    }

    public View getView() {
        return this.eUU;
    }

    public void aNX() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eUU.addView(this.mProgressBar);
    }

    public TbImageView aNY() {
        return this.duU;
    }

    public TextView aNZ() {
        return this.mButton;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aOa() {
        this.mButton.setText(d.j.pause_load);
        this.mButton.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        aj.b(this.mButton, d.C0140d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void ob(String str) {
        this.mButton.setText(str);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        aj.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aOb() {
        this.mButton.setText(d.j.setup_text);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        aj.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aOc() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.duU.getLayoutParams();
        double loadedHeight = this.duU.getLoadedHeight() / this.duU.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.duU.setLayoutParams(layoutParams);
    }

    public void n(View.OnClickListener onClickListener) {
        this.mButton.setOnClickListener(onClickListener);
        this.duU.setOnClickListener(onClickListener);
    }

    public void aOd() {
        this.mProgressBar.setVisibility(8);
    }
}
