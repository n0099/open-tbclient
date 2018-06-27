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
    private TbImageView cVL;
    private RelativeLayout eFO;
    public TbImageView eFP;
    public LinearLayout eFQ;
    public TextView eFR;
    public boolean eFS = false;
    private TextView eoI;
    private Context mContext;
    private ProgressBar mProgressBar;

    public b(ViewGroup viewGroup) {
        this.eFO = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(d.i.big_image_ad, (ViewGroup) null);
        this.cVL = (TbImageView) this.eFO.findViewById(d.g.big_image_ad_image);
        this.eoI = (TextView) this.eFO.findViewById(d.g.big_image_ad_button);
        this.eFP = (TbImageView) this.eFO.findViewById(d.g.big_image_ad_label);
        this.eFQ = (LinearLayout) this.eFO.findViewById(d.g.big_image_ad_source_container);
        this.eFR = (TextView) this.eFO.findViewById(d.g.big_image_ad_source);
        this.mContext = viewGroup.getContext();
        aOz();
    }

    public View getView() {
        return this.eFO;
    }

    public void aOz() {
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(d.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.eFO.addView(this.mProgressBar);
    }

    public TbImageView aOA() {
        return this.cVL;
    }

    public TextView aOB() {
        return this.eoI;
    }

    @SuppressLint({"ResourceAsColor"})
    public void aOC() {
        this.eoI.setText(d.k.pause_load);
        this.eoI.setBackgroundResource(d.f.button_fenfa_xiazaizhong);
        am.b(this.eoI, d.C0142d.common_color_10049, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void oX(String str) {
        this.eoI.setText(str);
        this.eoI.setBackgroundResource(d.f.button_fenfa_download_selector);
        am.b(this.eoI, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    @SuppressLint({"ResourceAsColor"})
    public void aOD() {
        this.eoI.setText(d.k.setup_text);
        this.eoI.setBackgroundResource(d.f.button_fenfa_download_selector);
        am.b(this.eoI, d.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aOE() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.cVL.getLayoutParams();
        double loadedHeight = this.cVL.getLoadedHeight() / this.cVL.getLoadedWidth();
        if (loadedHeight > 1.0d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.cVL.setLayoutParams(layoutParams);
    }

    public void s(View.OnClickListener onClickListener) {
        this.eoI.setOnClickListener(onClickListener);
        this.cVL.setOnClickListener(onClickListener);
    }

    public void aOF() {
        this.mProgressBar.setVisibility(8);
    }
}
