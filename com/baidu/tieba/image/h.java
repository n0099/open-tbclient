package com.baidu.tieba.image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class h {
    private TbImageView aUZ;
    private TextView btu;
    private RelativeLayout cfx;
    private Context mContext;
    private ProgressBar mProgressBar;

    public h(ViewGroup viewGroup) {
        this.cfx = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(n.g.big_image_ad, (ViewGroup) null);
        this.aUZ = (TbImageView) this.cfx.findViewById(n.f.big_image_ad_image);
        this.btu = (TextView) this.cfx.findViewById(n.f.big_image_ad_button);
        this.mContext = viewGroup.getContext();
        adO();
    }

    public View getView() {
        return this.cfx;
    }

    public void adO() {
        new RelativeLayout.LayoutParams(-1, -1);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(n.e.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.cfx.addView(this.mProgressBar);
    }

    public TbImageView adP() {
        return this.aUZ;
    }

    public TextView adQ() {
        return this.btu;
    }

    public void adR() {
        this.btu.setEnabled(false);
        this.btu.setText(n.i.downloading2);
        this.btu.setBackgroundResource(n.e.button_fenfa_xiazaizhong);
        as.a(this.btu, n.c.fenfa_downloading_button, 1, 0);
    }

    public void jj(String str) {
        this.btu.setText(str);
        this.btu.setEnabled(true);
        this.btu.setBackgroundResource(n.e.button_fenfa_download_selector);
        as.a(this.btu, n.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void adS() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.aUZ.getLayoutParams();
        double loadedHeight = this.aUZ.getLoadedHeight() / this.aUZ.getLoadedWidth();
        if (loadedHeight > 0.5d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.aUZ.setLayoutParams(layoutParams);
    }

    public void adT() {
        this.btu.setEnabled(true);
        this.btu.setText(n.i.setup_text);
        this.btu.setBackgroundResource(n.e.button_fenfa_download_selector);
        as.a(this.btu, n.e.button_fenfa_download_text_selector, 1, 0);
    }

    public void q(View.OnClickListener onClickListener) {
        this.btu.setOnClickListener(onClickListener);
        this.aUZ.setOnClickListener(onClickListener);
    }

    public void adU() {
        this.mProgressBar.setVisibility(8);
    }
}
