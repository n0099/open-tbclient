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
    private TbImageView due;
    private TextView ePI;
    private RelativeLayout fgI;
    public TbImageView fgJ;
    public LinearLayout fgK;
    public TextView fgL;
    public boolean fgM = false;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.fgI = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(e.h.big_image_ad, (ViewGroup) null);
        this.due = (TbImageView) this.fgI.findViewById(e.g.big_image_ad_image);
        this.ePI = (TextView) this.fgI.findViewById(e.g.big_image_ad_button);
        this.fgJ = (TbImageView) this.fgI.findViewById(e.g.big_image_ad_label);
        this.fgK = (LinearLayout) this.fgI.findViewById(e.g.big_image_ad_source_container);
        this.fgL = (TextView) this.fgI.findViewById(e.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aWl();
    }

    public View getView() {
        return this.fgI;
    }

    public void aWl() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(e.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.fgI.addView(this.mProgressBar);
    }

    public TbImageView aWm() {
        return this.due;
    }

    public TextView aWn() {
        return this.ePI;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aWo() {
        this.ePI.setText(e.j.pause_load);
        this.ePI.setBackgroundResource(e.f.button_fenfa_xiazaizhong);
        al.b(this.ePI, e.d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void qL(String str) {
        this.ePI.setText(str);
        this.ePI.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.ePI, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aWp() {
        this.ePI.setText(e.j.setup_text);
        this.ePI.setBackgroundResource(e.f.button_fenfa_download_selector);
        al.b(this.ePI, e.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aWq() {
        int width = ((WindowManager) this.mContext.getSystemService(WindowConfig.JSON_WINDOW_KEY)).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.due.getLayoutParams();
        double loadedHeight = this.due.getLoadedHeight() / this.due.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.due.setLayoutParams(layoutParams);
    }

    public void v(View.OnClickListener onClickListener) {
        this.ePI.setOnClickListener(onClickListener);
        this.due.setOnClickListener(onClickListener);
    }

    public void aWr() {
        this.mProgressBar.setVisibility(8);
    }
}
