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
import com.baidu.tieba.f;
/* loaded from: classes3.dex */
public class b {
    private TbImageView cYw;
    private RelativeLayout eJD;
    public TbImageView eJE;
    public LinearLayout eJF;
    public TextView eJG;
    public boolean eJH = false;
    private TextView esw;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eJD = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(f.h.big_image_ad, (ViewGroup) null);
        this.cYw = (TbImageView) this.eJD.findViewById(f.g.big_image_ad_image);
        this.esw = (TextView) this.eJD.findViewById(f.g.big_image_ad_button);
        this.eJE = (TbImageView) this.eJD.findViewById(f.g.big_image_ad_label);
        this.eJF = (LinearLayout) this.eJD.findViewById(f.g.big_image_ad_source_container);
        this.eJG = (TextView) this.eJD.findViewById(f.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aPw();
    }

    public View getView() {
        return this.eJD;
    }

    public void aPw() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(f.C0146f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eJD.addView(this.mProgressBar);
    }

    public TbImageView aPx() {
        return this.cYw;
    }

    public TextView aPy() {
        return this.esw;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aPz() {
        this.esw.setText(f.j.pause_load);
        this.esw.setBackgroundResource(f.C0146f.button_fenfa_xiazaizhong);
        am.b(this.esw, f.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void pb(String str) {
        this.esw.setText(str);
        this.esw.setBackgroundResource(f.C0146f.button_fenfa_download_selector);
        am.b(this.esw, f.C0146f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aPA() {
        this.esw.setText(f.j.setup_text);
        this.esw.setBackgroundResource(f.C0146f.button_fenfa_download_selector);
        am.b(this.esw, f.C0146f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aPB() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.cYw.getLayoutParams();
        double loadedHeight = this.cYw.getLoadedHeight() / this.cYw.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cYw.setLayoutParams(layoutParams);
    }

    public void t(View.OnClickListener onClickListener) {
        this.esw.setOnClickListener(onClickListener);
        this.cYw.setOnClickListener(onClickListener);
    }

    public void aPC() {
        this.mProgressBar.setVisibility(8);
    }
}
