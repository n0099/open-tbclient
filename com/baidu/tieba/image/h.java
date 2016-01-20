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
    private TbImageView aYZ;
    private TextView bxl;
    private RelativeLayout cjB;
    private Context mContext;
    private ProgressBar mProgressBar;

    public h(ViewGroup viewGroup) {
        this.cjB = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(n.h.big_image_ad, (ViewGroup) null);
        this.aYZ = (TbImageView) this.cjB.findViewById(n.g.big_image_ad_image);
        this.bxl = (TextView) this.cjB.findViewById(n.g.big_image_ad_button);
        this.mContext = viewGroup.getContext();
        aeX();
    }

    public View getView() {
        return this.cjB;
    }

    public void aeX() {
        new RelativeLayout.LayoutParams(-1, -1);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(n.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.cjB.addView(this.mProgressBar);
    }

    public TbImageView aeY() {
        return this.aYZ;
    }

    public TextView aeZ() {
        return this.bxl;
    }

    public void afa() {
        this.bxl.setEnabled(false);
        this.bxl.setText(n.j.downloading2);
        this.bxl.setBackgroundResource(n.f.button_fenfa_xiazaizhong);
        as.a(this.bxl, n.d.fenfa_downloading_button, 1, 0);
    }

    public void jx(String str) {
        this.bxl.setText(str);
        this.bxl.setEnabled(true);
        this.bxl.setBackgroundResource(n.f.button_fenfa_download_selector);
        as.a(this.bxl, n.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void afb() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.aYZ.getLayoutParams();
        double loadedHeight = this.aYZ.getLoadedHeight() / this.aYZ.getLoadedWidth();
        if (loadedHeight > 0.5d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.aYZ.setLayoutParams(layoutParams);
    }

    public void afc() {
        this.bxl.setEnabled(true);
        this.bxl.setText(n.j.setup_text);
        this.bxl.setBackgroundResource(n.f.button_fenfa_download_selector);
        as.a(this.bxl, n.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void q(View.OnClickListener onClickListener) {
        this.bxl.setOnClickListener(onClickListener);
        this.aYZ.setOnClickListener(onClickListener);
    }

    public void afd() {
        this.mProgressBar.setVisibility(8);
    }
}
