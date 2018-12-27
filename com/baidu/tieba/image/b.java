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
import com.baidu.searchbox.ng.ai.apps.runtime.config.WindowConfig;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class b {
    private TbImageView dwS;
    private TextView eSz;
    private RelativeLayout fjB;
    public TbImageView fjC;
    public LinearLayout fjD;
    public TextView fjE;
    public boolean fjF = false;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.fjB = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.h.big_image_ad, (ViewGroup) null);
        this.dwS = (TbImageView) this.fjB.findViewById(e.g.big_image_ad_image);
        this.eSz = (TextView) this.fjB.findViewById(e.g.big_image_ad_button);
        this.fjC = (TbImageView) this.fjB.findViewById(e.g.big_image_ad_label);
        this.fjD = (LinearLayout) this.fjB.findViewById(e.g.big_image_ad_source_container);
        this.fjE = (TextView) this.fjB.findViewById(e.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aWZ();
    }

    public View getView() {
        return this.fjB;
    }

    public void aWZ() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.fjB.addView(this.mProgressBar);
    }

    public TbImageView aXa() {
        return this.dwS;
    }

    public TextView aXb() {
        return this.eSz;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aXc() {
        this.eSz.setText(e.j.pause_load);
        this.eSz.setBackgroundResource(e.f.button_fenfa_xiazaizhong);
        al.b(this.eSz, e.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qO(String str) {
        this.eSz.setText(str);
        this.eSz.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eSz, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aXd() {
        this.eSz.setText(e.j.setup_text);
        this.eSz.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eSz, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aXe() {
        int width = ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.dwS.getLayoutParams();
        double loadedHeight = this.dwS.getLoadedHeight() / this.dwS.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.dwS.setLayoutParams(layoutParams);
    }

    public void v(View.OnClickListener onClickListener) {
        this.eSz.setOnClickListener(onClickListener);
        this.dwS.setOnClickListener(onClickListener);
    }

    public void aXf() {
        this.mProgressBar.setVisibility(8);
    }
}
