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
    private TbImageView dnD;
    private TextView eIT;
    private RelativeLayout eZT;
    public TbImageView eZU;
    public LinearLayout eZV;
    public TextView eZW;
    public boolean eZX = false;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eZT = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.h.big_image_ad, (ViewGroup) null);
        this.dnD = (TbImageView) this.eZT.findViewById(e.g.big_image_ad_image);
        this.eIT = (TextView) this.eZT.findViewById(e.g.big_image_ad_button);
        this.eZU = (TbImageView) this.eZT.findViewById(e.g.big_image_ad_label);
        this.eZV = (LinearLayout) this.eZT.findViewById(e.g.big_image_ad_source_container);
        this.eZW = (TextView) this.eZT.findViewById(e.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aUu();
    }

    public View getView() {
        return this.eZT;
    }

    public void aUu() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eZT.addView(this.mProgressBar);
    }

    public TbImageView aUv() {
        return this.dnD;
    }

    public TextView aUw() {
        return this.eIT;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aUx() {
        this.eIT.setText(e.j.pause_load);
        this.eIT.setBackgroundResource(e.f.button_fenfa_xiazaizhong);
        al.b(this.eIT, e.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qj(String str) {
        this.eIT.setText(str);
        this.eIT.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eIT, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aUy() {
        this.eIT.setText(e.j.setup_text);
        this.eIT.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.eIT, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aUz() {
        int width = ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.dnD.getLayoutParams();
        double loadedHeight = this.dnD.getLoadedHeight() / this.dnD.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.dnD.setLayoutParams(layoutParams);
    }

    public void v(View.OnClickListener onClickListener) {
        this.eIT.setOnClickListener(onClickListener);
        this.dnD.setOnClickListener(onClickListener);
    }

    public void aUA() {
        this.mProgressBar.setVisibility(8);
    }
}
