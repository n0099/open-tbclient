package com.baidu.tieba.pb.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.f;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class v extends FrameLayout implements View.OnClickListener {
    private boolean aJs;
    private TextView aMI;
    private com.baidu.tieba.tbadkCore.data.a eAd;
    private TbImageView eAe;
    private LinearLayout eAf;
    private ImageView eAg;
    private TextView eAh;
    private Context mContext;
    private View mRootView;

    public v(Context context) {
        this(context, null, 0);
    }

    public v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aJs = false;
        this.mContext = context;
        init();
    }

    public com.baidu.tieba.tbadkCore.data.a getData() {
        return this.eAd;
    }

    public void IO() {
        this.aJs = true;
    }

    private void init() {
        this.mRootView = LayoutInflater.from(this.mContext).inflate(r.h.pic_show_cardview_layout, (ViewGroup) this, true);
        this.eAe = (TbImageView) findViewById(r.g.pic_img);
        this.eAf = (LinearLayout) findViewById(r.g.bottom_ll);
        this.aMI = (TextView) findViewById(r.g.title_ll);
        this.eAh = (TextView) findViewById(r.g.desc_ll);
        this.eAg = (ImageView) findViewById(r.g.show_pic_icon);
    }

    public void setIconResId(int i) {
        av.c(this.eAg, i);
    }

    public void setData(com.baidu.tieba.tbadkCore.data.a aVar) {
        int i;
        if (aVar != null && this.eAd != aVar) {
            this.eAd = aVar;
            if (!StringUtils.isNULL(aVar.getTitle())) {
                this.aMI.setVisibility(0);
                this.aMI.setText(aVar.getTitle());
            } else {
                this.aMI.setVisibility(8);
            }
            if (!StringUtils.isNULL(aVar.getDescription())) {
                this.eAh.setVisibility(0);
                this.eAh.setText(aVar.getDescription());
            } else {
                this.eAh.setVisibility(8);
            }
            if (this.aJs) {
                this.eAe.setSupportNoImage(true);
            }
            int imageWidth = aVar.getImageWidth();
            int imageHeight = aVar.getImageHeight();
            if (imageWidth > 0 && imageHeight > 0) {
                this.eAe.setScaleType(ImageView.ScaleType.CENTER_CROP);
                this.eAe.setOnClickListener(this);
                this.eAe.setInterceptOnClick(true);
                this.eAe.setDefaultResource(r.f.icon_click);
                this.eAe.c(aVar.bji(), 18, false);
                int K = k.K(this.mContext) - (k.e(this.mContext, r.e.ds30) * 2);
                float f = imageHeight / imageWidth;
                if (f > 1.7777778f) {
                    i = (int) (K * 1.7777778f);
                } else if (f < 0.75f) {
                    i = (int) (K * 0.75f);
                } else {
                    i = (int) (f * K);
                }
                this.eAe.setLayoutParams(new FrameLayout.LayoutParams(K, i));
                removeView(this.eAe);
                addView(this.eAe);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eAf.getLayoutParams();
                layoutParams.width = K;
                layoutParams.height = k.e(this.mContext, r.e.ds110);
                removeView(this.eAf);
                addView(this.eAf, layoutParams);
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        tbPageContext.getLayoutMode().ah(i == 1);
        tbPageContext.getLayoutMode().x(this.mRootView);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eAd != null) {
            f.u(this.mContext, this.eAd.bjj());
        }
    }

    public ImageView getIcon() {
        return this.eAg;
    }
}
