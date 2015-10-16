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
    private TbImageView aPO;
    private RelativeLayout bOP;
    private TextView bll;
    private Context mContext;
    private ProgressBar mProgressBar;

    public h(ViewGroup viewGroup) {
        this.bOP = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(i.g.big_image_ad, (ViewGroup) null);
        this.aPO = (TbImageView) this.bOP.findViewById(i.f.big_image_ad_image);
        this.bll = (TextView) this.bOP.findViewById(i.f.big_image_ad_button);
        this.mContext = viewGroup.getContext();
        ZR();
    }

    public View getView() {
        return this.bOP;
    }

    public void ZR() {
        new RelativeLayout.LayoutParams(-1, -1);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(i.e.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.bOP.addView(this.mProgressBar);
    }

    public TbImageView ZS() {
        return this.aPO;
    }

    public TextView ZT() {
        return this.bll;
    }

    public void ZU() {
        this.bll.setEnabled(false);
        this.bll.setText(i.h.downloading2);
        this.bll.setBackgroundResource(i.e.button_fenfa_xiazaizhong);
        an.a(this.bll, i.c.fenfa_downloading_button, 1, 0);
    }

    public void iN(String str) {
        this.bll.setText(str);
        this.bll.setEnabled(true);
        this.bll.setBackgroundResource(i.e.button_fenfa_download_selector);
        an.a(this.bll, i.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void ZV() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.aPO.getLayoutParams();
        double loadedHeight = this.aPO.getLoadedHeight() / this.aPO.getLoadedWidth();
        if (loadedHeight > 0.5d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.aPO.setLayoutParams(layoutParams);
    }

    public void ZW() {
        this.bll.setEnabled(true);
        this.bll.setText(i.h.setup_text);
        this.bll.setBackgroundResource(i.e.button_fenfa_download_selector);
        an.a(this.bll, i.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void q(View.OnClickListener onClickListener) {
        this.bll.setOnClickListener(onClickListener);
        this.aPO.setOnClickListener(onClickListener);
    }

    public void ZX() {
        this.mProgressBar.setVisibility(8);
    }
}
