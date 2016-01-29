package com.baidu.tieba.image;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h {
    private TextView bAw;
    private TbImageView bbo;
    private RelativeLayout cob;
    private Context mContext;
    private ProgressBar mProgressBar;

    public h(ViewGroup viewGroup) {
        this.cob = (RelativeLayout) LayoutInflater.from(viewGroup.getContext()).inflate(t.h.big_image_ad, (ViewGroup) null);
        this.bbo = (TbImageView) this.cob.findViewById(t.g.big_image_ad_image);
        this.bAw = (TextView) this.cob.findViewById(t.g.big_image_ad_button);
        this.mContext = viewGroup.getContext();
        aig();
    }

    public View getView() {
        return this.cob;
    }

    public void aig() {
        new RelativeLayout.LayoutParams(-1, -1);
        this.mProgressBar = new ProgressBar(this.mContext, null, 16843399);
        this.mProgressBar.setIndeterminateDrawable(this.mContext.getResources().getDrawable(t.f.progressbar));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        this.mProgressBar.setLayoutParams(layoutParams);
        this.mProgressBar.setIndeterminate(true);
        this.cob.addView(this.mProgressBar);
    }

    public TbImageView aih() {
        return this.bbo;
    }

    public TextView aii() {
        return this.bAw;
    }

    public void aij() {
        this.bAw.setText(t.j.downloading2);
        this.bAw.setBackgroundResource(t.f.button_fenfa_xiazaizhong);
        ar.a(this.bAw, t.d.fenfa_downloading_button, 1, 0);
    }

    public void jB(String str) {
        this.bAw.setText(str);
        this.bAw.setBackgroundResource(t.f.button_fenfa_download_selector);
        ar.a(this.bAw, t.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void aik() {
        this.bAw.setText(t.j.setup_text);
        this.bAw.setBackgroundResource(t.f.button_fenfa_download_selector);
        ar.a(this.bAw, t.f.button_fenfa_download_text_selector, 1, 0);
    }

    public void ail() {
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = this.bbo.getLayoutParams();
        double loadedHeight = this.bbo.getLoadedHeight() / this.bbo.getLoadedWidth();
        if (loadedHeight > 0.5d) {
            layoutParams.height = width;
            layoutParams.width = (int) (width / loadedHeight);
        } else {
            layoutParams.height = (int) (loadedHeight * width);
            layoutParams.width = width;
        }
        this.bbo.setLayoutParams(layoutParams);
    }

    public void v(View.OnClickListener onClickListener) {
        this.bAw.setOnClickListener(onClickListener);
        this.bbo.setOnClickListener(onClickListener);
    }

    public void aim() {
        this.mProgressBar.setVisibility(8);
    }
}
