package com.baidu.tieba.image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h {
    private TbImageView aPW;
    private RelativeLayout bPk;
    private TextView blP;
    private Context mContext;
    private ProgressBar mProgressBar;

    public h(ViewGroup viewGroup) {
        this.bPk = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(i.g.big_image_ad, (ViewGroup) null);
        this.aPW = (TbImageView) this.bPk.findViewById(i.f.big_image_ad_image);
        this.blP = (TextView) this.bPk.findViewById(i.f.big_image_ad_button);
        this.mContext = viewGroup.getContext();
        aai();
    }

    public View getView() {
        return this.bPk;
    }

    public void aai() {
        new RelativeLayout.LayoutParams(-1, -1);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.bPk.addView(this.mProgressBar);
    }

    public TbImageView aaj() {
        return this.aPW;
    }

    public TextView aak() {
        return this.blP;
    }

    public void aal() {
        this.blP.setEnabled(false);
        this.blP.setText(i.h.downloading2);
        this.blP.setBackgroundResource(i.e.button_fenfa_xiazaizhong);
        an.a(this.blP, i.c.fenfa_downloading_button, 1, 0);
    }

    public void iP(String str) {
        this.blP.setText(str);
        this.blP.setEnabled(true);
        this.blP.setBackgroundResource(i.e.button_fenfa_download_selector);
        an.a(this.blP, i.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void aam() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.aPW.getLayoutParams();
        double loadedHeight = this.aPW.getLoadedHeight() / this.aPW.getLoadedWidth();
        if (loadedHeight > 0.5d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.aPW.setLayoutParams(layoutParams);
    }

    public void aan() {
        this.blP.setEnabled(true);
        this.blP.setText(i.h.setup_text);
        this.blP.setBackgroundResource(i.e.button_fenfa_download_selector);
        an.a(this.blP, i.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void q(View.OnClickListener onClickListener) {
        this.blP.setOnClickListener(onClickListener);
        this.aPW.setOnClickListener(onClickListener);
    }

    public void aao() {
        this.mProgressBar.setVisibility(8);
    }
}
