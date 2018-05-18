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
    private TbImageView cOD;
    private RelativeLayout eqH;
    public TbImageView eqI;
    public LinearLayout eqJ;
    public TextView eqK;
    public boolean eqL = false;
    private TextView mButton;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eqH = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.i.big_image_ad, (ViewGroup) null);
        this.cOD = (TbImageView) this.eqH.findViewById(d.g.big_image_ad_image);
        this.mButton = (TextView) this.eqH.findViewById(d.g.big_image_ad_button);
        this.eqI = (TbImageView) this.eqH.findViewById(d.g.big_image_ad_label);
        this.eqJ = (LinearLayout) this.eqH.findViewById(d.g.big_image_ad_source_container);
        this.eqK = (TextView) this.eqH.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aIY();
    }

    public View getView() {
        return this.eqH;
    }

    public void aIY() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eqH.addView(this.mProgressBar);
    }

    public TbImageView aIZ() {
        return this.cOD;
    }

    public TextView aJa() {
        return this.mButton;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aJb() {
        this.mButton.setText(d.k.pause_load);
        this.mButton.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        ak.b(this.mButton, d.C0126d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oj(String str) {
        this.mButton.setText(str);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        ak.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aJc() {
        this.mButton.setText(d.k.setup_text);
        this.mButton.setBackgroundResource(d.f.button_fenfa_download_selector);
        ak.b(this.mButton, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aJd() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.cOD.getLayoutParams();
        double loadedHeight = this.cOD.getLoadedHeight() / this.cOD.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cOD.setLayoutParams(layoutParams);
    }

    public void p(View.OnClickListener onClickListener) {
        this.mButton.setOnClickListener(onClickListener);
        this.cOD.setOnClickListener(onClickListener);
    }

    public void aJe() {
        this.mProgressBar.setVisibility(8);
    }
}
