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
    private TbImageView dmy;
    private TextView eHB;
    private RelativeLayout eYB;
    public TbImageView eYC;
    public LinearLayout eYD;
    public TextView eYE;
    public boolean eYF = false;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eYB = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.h.big_image_ad, (ViewGroup) null);
        this.dmy = (TbImageView) this.eYB.findViewById(e.g.big_image_ad_image);
        this.eHB = (TextView) this.eYB.findViewById(e.g.big_image_ad_button);
        this.eYC = (TbImageView) this.eYB.findViewById(e.g.big_image_ad_label);
        this.eYD = (LinearLayout) this.eYB.findViewById(e.g.big_image_ad_source_container);
        this.eYE = (TextView) this.eYB.findViewById(e.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aUX();
    }

    public View getView() {
        return this.eYB;
    }

    public void aUX() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eYB.addView(this.mProgressBar);
    }

    public TbImageView aUY() {
        return this.dmy;
    }

    public TextView aUZ() {
        return this.eHB;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aVa() {
        this.eHB.setText(e.j.pause_load);
        this.eHB.setBackgroundResource(e.f.button_fenfa_xiazaizhong);
        al.b(this.eHB, e.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qi(String str) {
        this.eHB.setText(str);
        this.eHB.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eHB, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aVb() {
        this.eHB.setText(e.j.setup_text);
        this.eHB.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eHB, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aVc() {
        int width = ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.dmy.getLayoutParams();
        double loadedHeight = this.dmy.getLoadedHeight() / this.dmy.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.dmy.setLayoutParams(layoutParams);
    }

    public void t(View.OnClickListener onClickListener) {
        this.eHB.setOnClickListener(onClickListener);
        this.dmy.setOnClickListener(onClickListener);
    }

    public void aVd() {
        this.mProgressBar.setVisibility(8);
    }
}
