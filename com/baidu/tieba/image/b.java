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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class b {
    private TbImageView cYA;
    private RelativeLayout eJI;
    public TbImageView eJJ;
    public LinearLayout eJK;
    public TextView eJL;
    public boolean eJM = false;
    private TextView esA;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eJI = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.h.big_image_ad, (ViewGroup) null);
        this.cYA = (TbImageView) this.eJI.findViewById(d.g.big_image_ad_image);
        this.esA = (TextView) this.eJI.findViewById(d.g.big_image_ad_button);
        this.eJJ = (TbImageView) this.eJI.findViewById(d.g.big_image_ad_label);
        this.eJK = (LinearLayout) this.eJI.findViewById(d.g.big_image_ad_source_container);
        this.eJL = (TextView) this.eJI.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aPz();
    }

    public View getView() {
        return this.eJI;
    }

    public void aPz() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eJI.addView(this.mProgressBar);
    }

    public TbImageView aPA() {
        return this.cYA;
    }

    public TextView aPB() {
        return this.esA;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aPC() {
        this.esA.setText(d.j.pause_load);
        this.esA.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        am.b(this.esA, d.C0140d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oZ(String str) {
        this.esA.setText(str);
        this.esA.setBackgroundResource(d.f.button_fenfa_download_selector);
        am.b(this.esA, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aPD() {
        this.esA.setText(d.j.setup_text);
        this.esA.setBackgroundResource(d.f.button_fenfa_download_selector);
        am.b(this.esA, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aPE() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.cYA.getLayoutParams();
        double loadedHeight = this.cYA.getLoadedHeight() / this.cYA.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cYA.setLayoutParams(layoutParams);
    }

    public void t(View.OnClickListener onClickListener) {
        this.esA.setOnClickListener(onClickListener);
        this.cYA.setOnClickListener(onClickListener);
    }

    public void aPF() {
        this.mProgressBar.setVisibility(8);
    }
}
