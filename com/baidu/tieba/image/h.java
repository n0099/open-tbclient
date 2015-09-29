package com.baidu.tieba.image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class h {
    private TbImageView aPD;
    private RelativeLayout bOE;
    private TextView bla;
    private Context mContext;
    private ProgressBar mProgressBar;

    public h(ViewGroup viewGroup) {
        this.bOE = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(i.g.big_image_ad, (ViewGroup) null);
        this.aPD = (TbImageView) this.bOE.findViewById(i.f.big_image_ad_image);
        this.bla = (TextView) this.bOE.findViewById(i.f.big_image_ad_button);
        this.mContext = viewGroup.getContext();
        ZR();
    }

    public View getView() {
        return this.bOE;
    }

    public void ZR() {
        new RelativeLayout.LayoutParams(-1, -1);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.bOE.addView(this.mProgressBar);
    }

    public TbImageView ZS() {
        return this.aPD;
    }

    public TextView ZT() {
        return this.bla;
    }

    public void ZU() {
        this.bla.setEnabled(false);
        this.bla.setText(i.h.downloading2);
        this.bla.setBackgroundResource(i.e.button_fenfa_xiazaizhong);
        am.a(this.bla, i.c.fenfa_downloading_button, 1, 0);
    }

    public void iN(String str) {
        this.bla.setText(str);
        this.bla.setEnabled(true);
        this.bla.setBackgroundResource(i.e.button_fenfa_download_selector);
        am.a(this.bla, i.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void ZV() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.aPD.getLayoutParams();
        double loadedHeight = this.aPD.getLoadedHeight() / this.aPD.getLoadedWidth();
        if (loadedHeight > 0.5d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.aPD.setLayoutParams(layoutParams);
    }

    public void ZW() {
        this.bla.setEnabled(true);
        this.bla.setText(i.h.setup_text);
        this.bla.setBackgroundResource(i.e.button_fenfa_download_selector);
        am.a(this.bla, i.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void q(View.OnClickListener onClickListener) {
        this.bla.setOnClickListener(onClickListener);
        this.aPD.setOnClickListener(onClickListener);
    }

    public void ZX() {
        this.mProgressBar.setVisibility(8);
    }
}
